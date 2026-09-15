"use strict";

const DATA = {
  versions: null,       // versions.json (array, chronological)
  versionsByName: null, // map version -> summary
  featureIndex: null,   // feature_index.json
  stringIndex: null,    // string_index.json
  flows: {},            // version -> flow json (lazy)
  stateCache: {},        // version -> full state json (lazy, for compare)
  screensIndex: null,    // screens_index.json (lazy)
  screenCache: {},        // screen id -> parsed screen json (lazy)
};

const $ = (sel, root = document) => root.querySelector(sel);
const $$ = (sel, root = document) => Array.from(root.querySelectorAll(sel));

function escapeHtml(s) {
  return String(s).replace(/[&<>"']/g, (c) => ({ "&": "&amp;", "<": "&lt;", ">": "&gt;", '"': "&quot;", "'": "&#39;" }[c]));
}

function highlight(text, query) {
  if (!query) return escapeHtml(text);
  const idx = text.toLowerCase().indexOf(query.toLowerCase());
  if (idx === -1) return escapeHtml(text);
  return (
    escapeHtml(text.slice(0, idx)) +
    "<mark>" + escapeHtml(text.slice(idx, idx + query.length)) + "</mark>" +
    escapeHtml(text.slice(idx + query.length))
  );
}

async function fetchJson(path) {
  const res = await fetch(path);
  if (!res.ok) throw new Error(`Failed to load ${path}: ${res.status}`);
  return res.json();
}

async function loadCore() {
  const [versions, featureIndex, stringIndex] = await Promise.all([
    fetchJson("data/versions.json"),
    fetchJson("data/feature_index.json"),
    fetchJson("data/string_index.json"),
  ]);
  DATA.versions = versions;
  DATA.versionsByName = Object.fromEntries(versions.map((v) => [v.version, v]));
  DATA.featureIndex = featureIndex;
  DATA.stringIndex = stringIndex;
}

async function getState(version) {
  if (!DATA.stateCache[version]) {
    DATA.stateCache[version] = await fetchJson(`data/state/${version}.json`);
  }
  return DATA.stateCache[version];
}

async function getFlow(version) {
  if (!DATA.flows[version]) {
    try {
      DATA.flows[version] = await fetchJson(`data/flows/${version}.json`);
    } catch (e) {
      DATA.flows[version] = { version, nodes: [], edges: [] };
    }
  }
  return DATA.flows[version];
}

/* ---------------------------- Tabs ---------------------------- */

function setupTabs() {
  $$(".tab-btn").forEach((btn) => {
    btn.addEventListener("click", () => {
      $$(".tab-btn").forEach((b) => b.classList.remove("active"));
      btn.classList.add("active");
      const tab = btn.dataset.tab;
      $$(".view").forEach((v) => (v.hidden = true));
      $(`#view-${tab}`).hidden = false;
      if (tab === "flows") ensureFlowRendered();
      if (tab === "preview") ensurePreviewLoaded();
      if (tab === "sdks") ensureSdkInventoryLoaded();
    });
  });
}

/* ---------------------------- Timeline ---------------------------- */

function renderTimelineList() {
  const list = $("#timeline-list");
  list.innerHTML = "";
  // newest first for browsing convenience
  const ordered = [...DATA.versions].reverse();
  ordered.forEach((v) => {
    const row = document.createElement("div");
    row.className = "tl-row";
    row.dataset.version = v.version;
    const dc = v.diffCounts;
    const badges = [];
    if (dc.addedActivities) badges.push(`<span class="badge add">+${dc.addedActivities} screens</span>`);
    if (dc.removedActivities) badges.push(`<span class="badge rem">-${dc.removedActivities} screens</span>`);
    if (dc.addedStrings) badges.push(`<span class="badge add">+${dc.addedStrings} strings</span>`);
    if (dc.modifiedStrings) badges.push(`<span class="badge mod">${dc.modifiedStrings} modified</span>`);
    if (!badges.length) badges.push(`<span class="badge neutral">maintenance</span>`);
    row.innerHTML = `
      <div class="tl-row-top">
        <span class="tl-ver">v${v.version}</span>
        <span class="tl-date">${v.date}</span>
      </div>
      <div class="tl-badges">${badges.join("")}</div>
    `;
    row.addEventListener("click", () => selectTimelineVersion(v.version));
    list.appendChild(row);
  });
}

function selectTimelineVersion(version) {
  $$(".tl-row").forEach((r) => r.classList.toggle("active", r.dataset.version === version));
  const v = DATA.versionsByName[version];
  const detail = $("#timeline-detail");
  const d = v.diff;

  const section = (title, items, cls) =>
    items.length
      ? `<div class="diff-section"><h3>${title} (${items.length})</h3><div class="chip-list">${items
          .map((i) => `<span class="chip ${cls}">${escapeHtml(i.split(".").pop())}</span>`)
          .join("")}</div></div>`
      : "";

  const stringAdds = Object.entries(d.addedStrings);
  const stringMods = Object.entries(d.modifiedStrings);

  detail.innerHTML = `
    <h2 class="detail-title">v${v.version} <span style="color:var(--text-dim); font-weight:400;">&middot; ${v.date}</span></h2>
    <div class="detail-sub">versionCode ${v.versionCode} &middot; targetSdk ${v.targetSdkVersion} &middot; minSdk ${v.minSdkVersion}</div>
    <div class="detail-grid">
      <div class="stat-box"><div class="num">${v.counts.activities}</div><div class="lbl">Screens</div></div>
      <div class="stat-box"><div class="num">${v.counts.strings}</div><div class="lbl">UI strings</div></div>
      <div class="stat-box"><div class="num">${v.counts.services}</div><div class="lbl">Services</div></div>
      <div class="stat-box"><div class="num">${v.counts.receivers}</div><div class="lbl">Receivers</div></div>
      <div class="stat-box"><div class="num">${v.counts.permissions}</div><div class="lbl">Permissions</div></div>
    </div>
    ${section("New screens", d.addedActivities, "add")}
    ${section("Removed screens", d.removedActivities, "rem")}
    ${section("New services", d.addedServices, "add")}
    ${section("New receivers", d.addedReceivers, "add")}
    ${section("New permissions", d.addedPermissions, "add")}
    ${section("Removed permissions", d.removedPermissions, "rem")}
    ${
      stringAdds.length
        ? `<div class="diff-section"><h3>New UI strings (${stringAdds.length})</h3>${stringAdds
            .map(([k, val]) => `<div class="string-diff-row"><span class="key">${escapeHtml(k)}</span><span class="new">${escapeHtml(val)}</span></div>`)
            .join("")}</div>`
        : ""
    }
    ${
      stringMods.length
        ? `<div class="diff-section"><h3>Modified UI strings (${stringMods.length})</h3>${stringMods
            .map(([k, ch]) => `<div class="string-diff-row"><span class="key">${escapeHtml(k)}</span><span class="old">${escapeHtml(ch.old)}</span><span class="new">${escapeHtml(ch.new)}</span></div>`)
            .join("")}</div>`
        : ""
    }
    ${!d.addedActivities.length && !d.removedActivities.length && !stringAdds.length && !stringMods.length && !d.addedServices.length && !d.addedPermissions.length
      ? '<div class="empty-state">No manifest/string-level changes detected &mdash; likely an internal/bugfix build.</div>'
      : ""}
  `;
}

/* ---------------------------- Features ---------------------------- */

function populateFeatureModuleFilter() {
  const sel = $("#feature-module");
  sel.innerHTML = `<option value="all">All modules</option>` + DATA.featureIndex.modules.map((m) => `<option value="${escapeHtml(m)}">${escapeHtml(m)}</option>`).join("");
}

function currentFeatureFilters() {
  return {
    q: $("#feature-search").value.trim().toLowerCase(),
    module: $("#feature-module").value,
    existence: $("#feature-existence").value,
  };
}

function filteredFeatures() {
  const { q, module, existence } = currentFeatureFilters();
  return DATA.featureIndex.features.filter((f) => {
    if (module !== "all" && f.module !== module) return false;
    if (q && !f.label.toLowerCase().includes(q) && !f.className.toLowerCase().includes(q)) return false;
    if (existence === "present" && !f.stillPresent) return false;
    if (existence === "removed" && f.stillPresent) return false;
    if (existence === "launcher" && !f.isLauncher) return false;
    return true;
  });
}

function renderFeatureList() {
  const list = $("#feature-list");
  const feats = filteredFeatures();
  $("#feature-count").textContent = `${feats.length} screens`;
  list.innerHTML = "";
  feats.forEach((f) => {
    const row = document.createElement("div");
    row.className = "feat-row";
    row.dataset.id = f.className;
    row.innerHTML = `
      <div class="feat-label">${escapeHtml(f.label)}</div>
      <div class="feat-meta">
        <span class="tag">${escapeHtml(f.module)}</span>
        <span>${f.stillPresent ? "in v9.68" : `removed after v${f.lastSeen}`}</span>
        ${f.isLauncher ? '<span class="tag">launcher</span>' : ""}
      </div>
    `;
    row.addEventListener("click", () => selectFeature(f.className));
    list.appendChild(row);
  });
}

async function selectFeature(className) {
  $$(".feat-row").forEach((r) => r.classList.toggle("active", r.dataset.id === className));
  const f = DATA.featureIndex.features.find((x) => x.className === className);
  const allVersions = DATA.featureIndex.versions;
  const presentSet = new Set(f.versions);
  const detail = $("#feature-detail");
  detail.innerHTML = `
    <h2 class="detail-title">${escapeHtml(f.label)}</h2>
    <div class="detail-sub"><code>${escapeHtml(f.className)}</code></div>
    <div class="detail-grid">
      <div class="stat-box"><div class="num">${f.firstSeen}</div><div class="lbl">First seen</div></div>
      <div class="stat-box"><div class="num">${f.stillPresent ? "9.68" : f.lastSeen}</div><div class="lbl">${f.stillPresent ? "Still present" : "Last seen"}</div></div>
      <div class="stat-box"><div class="num">${f.versionCount}/${allVersions.length}</div><div class="lbl">Versions present</div></div>
      <div class="stat-box"><div class="num">${escapeHtml(f.module)}</div><div class="lbl">Module</div></div>
    </div>
    <div class="diff-section">
      <h3>Presence across all 30 releases</h3>
      <div class="presence-track">
        ${allVersions
          .map((v) => `<div class="presence-dot ${presentSet.has(v) ? "on" : ""}" title="v${v}${presentSet.has(v) ? " — present" : " — absent"}">${v.split(".")[1]}</div>`)
          .join("")}
      </div>
    </div>
    <div class="diff-section" id="feature-linkage-section">
      <h3>Screen-to-screen linkage (v9.68 call graph)</h3>
      <div class="empty-state" style="padding:0;">Loading&hellip;</div>
    </div>
  `;

  const flow = await getFlow("9.68");
  const section = $("#feature-linkage-section");
  if (!section) return; // user picked another screen before this resolved
  const incoming = dedupeByField(flow.edges.filter((e) => e.target === className), "source");
  const outgoing = dedupeByField(flow.edges.filter((e) => e.source === className), "target");
  if (!incoming.length && !outgoing.length) {
    section.querySelector(".empty-state").textContent = "Not present in the extracted v9.68 navigation call graph (no startActivity/fragment-transaction reference found either way).";
    return;
  }
  section.innerHTML = `
    <h3>Screen-to-screen linkage (v9.68 call graph)</h3>
    ${
      incoming.length
        ? `<div class="net-section"><h4>Reached from (${incoming.length})</h4><div class="chip-list">${incoming
            .map((e) => `<span class="linkage-chip" data-jump="${escapeHtml(e.source)}">${escapeHtml(screenLabelFor(e.source))}</span>`)
            .join("")}</div></div>`
        : `<div class="net-section"><h4>Reached from</h4><div class="empty-state" style="padding:0;">No known screen links here directly &mdash; may be an entry point.</div></div>`
    }
    ${
      outgoing.length
        ? `<div class="net-section" style="margin-top:10px;"><h4>Navigates to (${outgoing.length})</h4><div class="chip-list">${outgoing
            .map((e) => `<span class="linkage-chip" data-jump="${escapeHtml(e.target)}">${escapeHtml(screenLabelFor(e.target))}</span>`)
            .join("")}</div></div>`
        : ""
    }
  `;
  $$('[data-jump]', section).forEach((chip) => chip.addEventListener("click", () => jumpToPreview(chip.dataset.jump)));
}

async function jumpToPreview(id) {
  $$(".tab-btn").forEach((b) => b.classList.toggle("active", b.dataset.tab === "preview"));
  $$(".view").forEach((v) => (v.hidden = true));
  $("#view-preview").hidden = false;
  await ensurePreviewLoaded();
  openPreviewScreen(id, true);
}

/* ---------------------------- Flow Explorer ---------------------------- */

const flowState = {
  version: null,
  nodes: [],
  edges: [],
  positions: new Map(),
  selected: null,
};

function forceLayout(nodes, edges, width, height) {
  const k = Math.sqrt((width * height) / Math.max(nodes.length, 1)) * 0.9;
  const pos = new Map();
  const idx = new Map(nodes.map((n, i) => [n.id, i]));
  nodes.forEach((n, i) => {
    const angle = (i / nodes.length) * Math.PI * 2;
    pos.set(n.id, {
      x: width / 2 + Math.cos(angle) * width * 0.3 + (Math.random() - 0.5) * 40,
      y: height / 2 + Math.sin(angle) * height * 0.3 + (Math.random() - 0.5) * 40,
    });
  });

  const iterations = 220;
  for (let it = 0; it < iterations; it++) {
    const temp = width * 0.06 * (1 - it / iterations);
    const disp = new Map(nodes.map((n) => [n.id, { x: 0, y: 0 }]));

    for (let i = 0; i < nodes.length; i++) {
      for (let j = i + 1; j < nodes.length; j++) {
        const a = nodes[i], b = nodes[j];
        const pa = pos.get(a.id), pb = pos.get(b.id);
        let dx = pa.x - pb.x, dy = pa.y - pb.y;
        let dist = Math.sqrt(dx * dx + dy * dy) || 0.01;
        const force = (k * k) / dist;
        dx = (dx / dist) * force;
        dy = (dy / dist) * force;
        disp.get(a.id).x += dx; disp.get(a.id).y += dy;
        disp.get(b.id).x -= dx; disp.get(b.id).y -= dy;
      }
    }

    edges.forEach((e) => {
      if (!idx.has(e.source) || !idx.has(e.target)) return;
      const pa = pos.get(e.source), pb = pos.get(e.target);
      let dx = pa.x - pb.x, dy = pa.y - pb.y;
      let dist = Math.sqrt(dx * dx + dy * dy) || 0.01;
      const force = (dist * dist) / k;
      dx = (dx / dist) * force; dy = (dy / dist) * force;
      disp.get(e.source).x -= dx; disp.get(e.source).y -= dy;
      disp.get(e.target).x += dx; disp.get(e.target).y += dy;
    });

    nodes.forEach((n) => {
      const d = disp.get(n.id);
      const dist = Math.sqrt(d.x * d.x + d.y * d.y) || 0.01;
      const lim = Math.min(dist, temp);
      const p = pos.get(n.id);
      p.x += (d.x / dist) * lim;
      p.y += (d.y / dist) * lim;
      p.x = Math.max(30, Math.min(width - 30, p.x));
      p.y = Math.max(30, Math.min(height - 30, p.y));
    });
  }
  return pos;
}

function populateFlowModuleFilter() {
  const sel = $("#flow-module");
  const modules = Array.from(new Set(flowState.nodes.map((n) => n.module))).sort();
  sel.innerHTML = `<option value="all">All modules</option>` + modules.map((m) => `<option value="${escapeHtml(m)}">${escapeHtml(m)}</option>`).join("");
}

let flowLoadedFor = null;

async function ensureFlowRendered() {
  const version = $("#flow-version").value;
  if (flowLoadedFor === version) return;
  flowLoadedFor = version;
  const flow = await getFlow(version);
  flowState.version = version;
  flowState.nodes = flow.nodes;
  flowState.edges = flow.edges;
  populateFlowModuleFilter();
  renderFlowGraph();
}

function renderFlowGraph() {
  const svg = $("#flow-svg");
  const wrap = $(".flow-canvas-wrap");
  const width = Math.max(wrap.clientWidth, 600);
  const height = Math.max(wrap.clientHeight, 500);
  svg.setAttribute("viewBox", `0 0 ${width} ${height}`);
  svg.innerHTML = "";

  if (!flowState.nodes.length) {
    $("#flow-count").textContent = "no flow data";
    return;
  }

  if (!flowState.positions.size || flowState.layoutVersion !== flowState.version) {
    flowState.positions = forceLayout(flowState.nodes, flowState.edges, width, height);
    flowState.layoutVersion = flowState.version;
  }
  const pos = flowState.positions;

  const svgns = "http://www.w3.org/2000/svg";
  const edgeGroup = document.createElementNS(svgns, "g");
  const nodeGroup = document.createElementNS(svgns, "g");

  const edgeEls = flowState.edges.map((e) => {
    const line = document.createElementNS(svgns, "line");
    line.setAttribute("class", "flow-edge");
    line.dataset.source = e.source;
    line.dataset.target = e.target;
    edgeGroup.appendChild(line);
    return line;
  });

  const nodeEls = new Map();
  flowState.nodes.forEach((n) => {
    const g = document.createElementNS(svgns, "g");
    g.setAttribute("class", `flow-node ${n.kind}`);
    g.dataset.id = n.id;
    const circle = document.createElementNS(svgns, "circle");
    circle.setAttribute("r", n.kind === "activity" ? 7 : 5);
    const text = document.createElementNS(svgns, "text");
    text.textContent = n.label;
    text.setAttribute("x", 9);
    text.setAttribute("y", 3);
    g.appendChild(circle);
    g.appendChild(text);
    nodeGroup.appendChild(g);
    nodeEls.set(n.id, g);

    let dragging = false, offset = { x: 0, y: 0 };
    g.addEventListener("pointerdown", (ev) => {
      dragging = true;
      g.setPointerCapture(ev.pointerId);
      const p = pos.get(n.id);
      const pt = clientToSvg(svg, ev.clientX, ev.clientY);
      offset = { x: pt.x - p.x, y: pt.y - p.y };
      ev.stopPropagation();
    });
    g.addEventListener("pointermove", (ev) => {
      if (!dragging) return;
      const pt = clientToSvg(svg, ev.clientX, ev.clientY);
      const p = pos.get(n.id);
      p.x = pt.x - offset.x;
      p.y = pt.y - offset.y;
      layoutFrame();
    });
    g.addEventListener("pointerup", () => (dragging = false));
    g.addEventListener("click", (ev) => {
      ev.stopPropagation();
      selectFlowNode(n.id);
    });
  });

  svg.appendChild(edgeGroup);
  svg.appendChild(nodeGroup);

  function layoutFrame() {
    flowState.nodes.forEach((n) => {
      const p = pos.get(n.id);
      nodeEls.get(n.id).setAttribute("transform", `translate(${p.x},${p.y})`);
    });
    edgeEls.forEach((line, i) => {
      const e = flowState.edges[i];
      const ps = pos.get(e.source), pt = pos.get(e.target);
      if (!ps || !pt) return;
      line.setAttribute("x1", ps.x); line.setAttribute("y1", ps.y);
      line.setAttribute("x2", pt.x); line.setAttribute("y2", pt.y);
    });
  }
  layoutFrame();
  applyFlowFilters();
  $("#flow-count").textContent = `${flowState.nodes.length} screens/fragments · ${flowState.edges.length} navigations`;
}

function clientToSvg(svg, cx, cy) {
  const rect = svg.getBoundingClientRect();
  const vb = svg.viewBox.baseVal;
  return {
    x: ((cx - rect.left) / rect.width) * vb.width,
    y: ((cy - rect.top) / rect.height) * vb.height,
  };
}

function applyFlowFilters() {
  const module = $("#flow-module").value;
  const q = $("#flow-search").value.trim().toLowerCase();
  const nodeMatches = new Map(
    flowState.nodes.map((n) => [
      n.id,
      (module === "all" || n.module === module) && (!q || n.label.toLowerCase().includes(q) || n.id.toLowerCase().includes(q)),
    ])
  );
  $$("#flow-svg .flow-node").forEach((el) => {
    el.classList.toggle("dim", !nodeMatches.get(el.dataset.id));
  });
  $$("#flow-svg .flow-edge").forEach((el) => {
    const ok = nodeMatches.get(el.dataset.source) && nodeMatches.get(el.dataset.target);
    el.classList.toggle("dim", !ok);
  });
}

function selectFlowNode(id) {
  flowState.selected = id;
  $$("#flow-svg .flow-node").forEach((el) => el.classList.toggle("selected", el.dataset.id === id));
  const node = flowState.nodes.find((n) => n.id === id);
  const incoming = flowState.edges.filter((e) => e.target === id);
  const outgoing = flowState.edges.filter((e) => e.source === id);
  const nameOf = (fullId) => flowState.nodes.find((n) => n.id === fullId)?.label || fullId.split(".").pop();

  const detail = $("#flow-detail");
  detail.innerHTML = `
    <h2 class="detail-title">${escapeHtml(node.label)}</h2>
    <div class="detail-sub"><code>${escapeHtml(node.id)}</code> &middot; ${node.kind} &middot; module: ${escapeHtml(node.module)}</div>
    <div class="diff-section">
      <h3>Navigates to (${outgoing.length})</h3>
      ${outgoing.length ? `<div class="chip-list">${outgoing.map((e) => `<span class="chip" data-nav="${escapeHtml(e.target)}">${escapeHtml(nameOf(e.target))} <span style="opacity:.5">(${e.kind})</span></span>`).join("")}</div>` : '<div class="empty-state" style="padding:4px 0;">No outgoing navigation detected.</div>'}
    </div>
    <div class="diff-section">
      <h3>Reached from (${incoming.length})</h3>
      ${incoming.length ? `<div class="chip-list">${incoming.map((e) => `<span class="chip" data-nav="${escapeHtml(e.source)}">${escapeHtml(nameOf(e.source))} <span style="opacity:.5">(${e.kind})</span></span>`).join("")}</div>` : '<div class="empty-state" style="padding:4px 0;">No known screens navigate here directly (may be an entry point).</div>'}
    </div>
  `;
  $$('[data-nav]', detail).forEach((chip) => chip.addEventListener("click", () => selectFlowNode(chip.dataset.nav)));
}

/* ---------------------------- App Preview (clickable UI mock) ---------------------------- */

const QUICKSTART_IDS = [
  "in.gov.eci.bloapp.views.activity.DashboardBLOActivity",
  "in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment",
  "in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity",
  "in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity",
  "in.gov.eci.bloapp.views.fragments.pse.PseMainFragment",
  "in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment",
  "in.gov.eci.bloapp.views.activity.LoginActivity",
];

const previewState = {
  loaded: false,
  screenIds: new Set(),
  edgesBySource: new Map(),
  edgesByTarget: new Map(),
  stack: [], // history of screen ids
};

const STOPWORDS = new Set(["the", "of", "for", "to", "a", "an", "in", "on", "and", "or", "new", "your", "please", "enter", "select"]);

function wordsOf(label) {
  return (label || "")
    .toLowerCase()
    .replace(/[^a-z0-9\s]/g, " ")
    .split(/\s+/)
    .filter((w) => w && !STOPWORDS.has(w));
}

async function getScreen(id) {
  if (!(id in DATA.screenCache)) {
    try {
      DATA.screenCache[id] = await fetchJson(`data/screens/${encodeURIComponent(id)}.json`);
    } catch (e) {
      DATA.screenCache[id] = null;
    }
  }
  return DATA.screenCache[id];
}

function screenLabelFor(id) {
  const feat = DATA.featureIndex.features.find((f) => f.className === id);
  if (feat) return feat.label;
  return id.split(".").pop().replace(/([a-z])([A-Z])/g, "$1 $2");
}

function screenModuleFor(id) {
  const feat = DATA.featureIndex.features.find((f) => f.className === id);
  return feat ? feat.module : "other";
}

async function ensurePreviewLoaded() {
  if (previewState.loaded) return;
  const [index, flow] = await Promise.all([fetchJson("data/screens_index.json"), getFlow("9.68")]);
  DATA.screensIndex = index;
  previewState.screenIds = new Set(index.screens);
  flow.edges.forEach((e) => {
    if (!previewState.edgesBySource.has(e.source)) previewState.edgesBySource.set(e.source, []);
    previewState.edgesBySource.get(e.source).push(e);
    if (!previewState.edgesByTarget.has(e.target)) previewState.edgesByTarget.set(e.target, []);
    previewState.edgesByTarget.get(e.target).push(e);
  });
  previewState.loaded = true;

  renderQuickstart();
  renderPreviewList();
  $("#preview-search").addEventListener("input", renderPreviewList);
}

function renderQuickstart() {
  const box = $("#preview-quickstart");
  box.innerHTML = "";
  QUICKSTART_IDS.filter((id) => previewState.screenIds.has(id)).forEach((id) => {
    const chip = document.createElement("button");
    chip.className = "qs-chip";
    chip.textContent = screenLabelFor(id);
    chip.addEventListener("click", () => openPreviewScreen(id, true));
    box.appendChild(chip);
  });
}

function renderPreviewList() {
  const q = $("#preview-search").value.trim().toLowerCase();
  const list = $("#preview-list");
  const ids = [...previewState.screenIds]
    .map((id) => ({ id, label: screenLabelFor(id), module: screenModuleFor(id) }))
    .filter((s) => !q || s.label.toLowerCase().includes(q) || s.id.toLowerCase().includes(q))
    .sort((a, b) => a.module.localeCompare(b.module) || a.label.localeCompare(b.label));

  list.innerHTML = "";
  ids.slice(0, 400).forEach((s) => {
    const row = document.createElement("div");
    row.className = "preview-row";
    row.innerHTML = `<div class="pr-title">${escapeHtml(s.label)}</div><div class="pr-meta">${escapeHtml(s.module)}</div>`;
    row.addEventListener("click", () => openPreviewScreen(s.id, true));
    list.appendChild(row);
  });
}

function openPreviewScreen(id, resetStack) {
  if (resetStack) previewState.stack = [];
  previewState.stack.push(id);
  renderCrumbs();
  renderPhoneScreenById(id);
}

function goBackPreview() {
  if (previewState.stack.length <= 1) return;
  previewState.stack.pop();
  renderCrumbs();
  renderPhoneScreenById(previewState.stack[previewState.stack.length - 1]);
}

function renderCrumbs() {
  const el = $("#preview-crumbs");
  if (!previewState.stack.length) {
    el.innerHTML = "";
    return;
  }
  const backBtn = previewState.stack.length > 1 ? `<button class="crumb-back" id="preview-back-btn">&larr; Back</button>` : "";
  const trail = previewState.stack.map((id) => screenLabelFor(id)).join("  /  ");
  el.innerHTML = `${backBtn}${escapeHtml(trail)}`;
  const back = $("#preview-back-btn");
  if (back) back.addEventListener("click", goBackPreview);
}

function widgetHtml(w) {
  switch (w.kind) {
    case "text": {
      const looksHeading = w.label.length < 40 && /[A-Za-z]/.test(w.label) && !w.label.endsWith(".");
      return `<div class="mock-text${looksHeading ? " heading" : ""}">${escapeHtml(w.label)}</div>`;
    }
    case "input":
      return `<div class="mock-field">
        <label>${escapeHtml(w.label)}</label>
        <input type="text" placeholder="${escapeHtml(w.label)}" />
      </div>`;
    case "select":
      return `<div class="mock-field">
        <label>${escapeHtml(w.label)}</label>
        <select><option>${escapeHtml(w.label)}</option></select>
        <div class="field-caption">Options are loaded from the server at runtime &mdash; not available offline.</div>
      </div>`;
    case "checkbox":
      return `<label class="mock-check-row"><input type="checkbox" /> ${escapeHtml(w.label)}</label>`;
    case "switch":
      return `<label class="mock-switch-row"><input type="checkbox" /> ${escapeHtml(w.label)}</label>`;
    case "radiogroup": {
      const name = "rg_" + Math.random().toString(36).slice(2);
      return `<div class="mock-radiogroup">${w.options
        .map((o, i) => `<label class="mock-radio-opt"><input type="radio" name="${name}" ${i === 0 ? "checked" : ""}/> <span>${escapeHtml(o)}</span></label>`)
        .join("")}</div>`;
    }
    case "list":
      return `<div class="mock-list-placeholder">${escapeHtml(w.label)} &mdash; list loads dynamically from the server</div>`;
    default:
      return "";
  }
}

function matchEdgeToButton(label, edges, claimed) {
  const bw = new Set(wordsOf(label));
  let best = null, bestScore = 0;
  edges.forEach((e) => {
    if (claimed.has(e)) return;
    const tw = wordsOf(screenLabelFor(e.target));
    const overlap = tw.filter((w) => bw.has(w)).length;
    if (overlap > bestScore) {
      bestScore = overlap;
      best = e;
    }
  });
  return bestScore > 0 ? best : null;
}

async function renderPhoneScreenById(id) {
  const screenEl = $("#phone-screen");
  screenEl.innerHTML = `<div class="empty-state" style="padding:30px 20px;">Loading&hellip;</div>`;
  const screen = await getScreen(id);
  const edges = previewState.edgesBySource.get(id) || [];
  const incoming = previewState.edgesByTarget.get(id) || [];
  const label = screenLabelFor(id);

  if (!screen) {
    screenEl.innerHTML = `
      <div class="screen-topbar"><span>${escapeHtml(label)}</span></div>
      <div class="screen-body">
        <div class="empty-state">No layout could be reconstructed for this screen (custom/dynamic view).</div>
        ${renderLinkageBlock(incoming, edges, new Set())}
      </div>`;
    $$(".linkage-chip[data-nav]", screenEl).forEach((chip) => chip.addEventListener("click", () => openPreviewScreen(chip.dataset.nav, false)));
    return;
  }

  const claimed = new Set();
  const bodyHtml = screen.widgets
    .map((w) => {
      if (w.kind === "button") {
        const match = matchEdgeToButton(w.label, edges, claimed);
        if (match) {
          claimed.add(match);
          return `<button class="mock-btn" data-nav="${escapeHtml(match.target)}">${escapeHtml(w.label)}<span class="btn-dest">&rarr; ${escapeHtml(screenLabelFor(match.target))}</span></button>`;
        }
        return `<button class="mock-btn unlinked" disabled>${escapeHtml(w.label)}<span class="btn-dest">no linked screen found in call graph</span></button>`;
      }
      return widgetHtml(w);
    })
    .join("");

  screenEl.innerHTML = `
    <div class="screen-topbar"><span>${escapeHtml(label)}</span><span class="screen-kind-tag">${screen.kind}</span></div>
    <div class="screen-body">
      ${bodyHtml || '<div class="empty-state">This screen has no static fields &mdash; content is likely a menu/list built at runtime.</div>'}
    </div>
    ${renderNetworkBlock(screen)}
    ${renderLinkageBlock(incoming, edges, claimed)}
  `;

  $$(".mock-btn[data-nav]", screenEl).forEach((btn) => btn.addEventListener("click", () => openPreviewScreen(btn.dataset.nav, false)));
  $$(".linkage-chip[data-nav]", screenEl).forEach((chip) => chip.addEventListener("click", () => openPreviewScreen(chip.dataset.nav, false)));
}

function renderNetworkBlock(screen) {
  const calls = screen.apiCalls || [];
  const extras = screen.returnsExtras;
  const onDeviceSdks = screen.onDeviceSdks || [];
  if (!calls.length && !extras && !onDeviceSdks.length) return "";

  const onDeviceHtml = onDeviceSdks.length
    ? `<div class="net-section">
        <span class="badge add">Runs entirely on-device &mdash; no network calls detected</span>
        <div class="field-caption" style="margin-top:4px;">via ${onDeviceSdks.map(escapeHtml).join(", ")}. See Embedded SDKs for how we verified this.</div>
      </div>`
    : "";

  const callsHtml = calls.length
    ? `<div class="net-section">
        <h4>Network calls made from this screen</h4>
        ${calls.map((c) => `<div class="net-call"><span class="net-verb verb-${c.verb.toLowerCase()}">${c.verb}</span><code>${escapeHtml(c.path)}</code></div>`).join("")}
      </div>`
    : "";

  const extrasHtml = extras
    ? `<div class="net-section">
        <h4>On completion, returns to caller</h4>
        <div class="chip-list">${extras.map((e) => `<span class="chip">${escapeHtml(e)}</span>`).join("")}</div>
      </div>`
    : "";

  return `<div class="reachable-block network-block">${onDeviceHtml}${callsHtml}${extrasHtml}</div>`;
}

function dedupeByField(edges, field) {
  const seen = new Set();
  const out = [];
  for (const e of edges) {
    if (seen.has(e[field])) continue;
    seen.add(e[field]);
    out.push(e);
  }
  return out;
}

function renderLinkageBlock(incoming, outgoing, claimed) {
  const dedupedIn = dedupeByField(incoming, "source");
  const remainingOut = dedupeByField(
    outgoing.filter((e) => !claimed.has(e)),
    "target"
  );
  if (!dedupedIn.length && !remainingOut.length) return "";

  const inHtml = dedupedIn.length
    ? `<div class="net-section">
        <h4>Reached from (${dedupedIn.length})</h4>
        ${dedupedIn.map((e) => `<span class="linkage-chip" data-nav="${escapeHtml(e.source)}">${escapeHtml(screenLabelFor(e.source))}</span>`).join("")}
      </div>`
    : `<div class="net-section"><h4>Reached from</h4><div class="empty-state" style="padding:2px 0;">No known screen links here directly &mdash; may be an entry point.</div></div>`;

  const outHtml = remainingOut.length
    ? `<div class="net-section">
        <h4>Navigates to (${remainingOut.length})</h4>
        ${remainingOut.map((e) => `<span class="linkage-chip" data-nav="${escapeHtml(e.target)}">${escapeHtml(screenLabelFor(e.target))}</span>`).join("")}
      </div>`
    : "";

  return `<div class="reachable-block linkage-block">${inHtml}${outHtml}</div>`;
}

/* ---------------------------- SDK Inventory ---------------------------- */

let sdkInventory = null;

function fmtBytes(n) {
  if (n < 1024) return `${n} B`;
  if (n < 1024 * 1024) return `${(n / 1024).toFixed(1)} KB`;
  return `${(n / (1024 * 1024)).toFixed(1)} MB`;
}

async function ensureSdkInventoryLoaded() {
  if (sdkInventory) return;
  sdkInventory = await fetchJson("data/sdk_inventory.json");
  renderSdkList();
}

function renderSdkList() {
  const list = $("#sdk-list");
  list.innerHTML = "";
  const groups = [
    ["feature", "Feature SDKs"],
    ["infrastructure", "Infrastructure"],
  ];
  groups.forEach(([cat, label]) => {
    const header = document.createElement("div");
    header.className = "sdk-group-header";
    header.textContent = label;
    list.appendChild(header);
    sdkInventory.sdks
      .filter((s) => s.category === cat)
      .forEach((s) => {
        const row = document.createElement("div");
        row.className = "feat-row";
        row.dataset.id = s.id;
        row.innerHTML = `
          <div class="feat-label">${escapeHtml(s.displayName)} ${s.verifiedOnDevice ? '<span class="tag verified">verified on-device</span>' : ""}</div>
          <div class="feat-meta">
            <span class="tag">${s.classCount} classes</span>
            ${s.nativeLibs.length ? `<span class="tag">${s.nativeLibs.length} native lib${s.nativeLibs.length > 1 ? "s" : ""}</span>` : ""}
            ${s.bundledModels.length ? `<span class="tag">${s.bundledModels.length} models</span>` : ""}
          </div>
        `;
        row.addEventListener("click", () => selectSdk(s.id));
        list.appendChild(row);
      });
  });
}

function selectSdk(id) {
  $$(".feat-row", $("#sdk-list")).forEach((r) => r.classList.toggle("active", r.dataset.id === id));
  const s = sdkInventory.sdks.find((x) => x.id === id);
  const detail = $("#sdk-detail");

  const netSig = s.networkSignal;
  const netVerdict = s.verifiedOnDevice
    ? `<span class="badge add">Verified: no network code, runs on-device</span>`
    : netSig.filesWithSignal === 0
    ? `<span class="badge add">No network signal found</span>`
    : `<span class="badge mod">${netSig.filesWithSignal} file(s) with network-shaped code (${netSig.httpLiteralOrApiHits} hits) &mdash; not verified, could include false positives (e.g. XML namespace URIs)</span>`;

  detail.innerHTML = `
    <h2 class="detail-title">${escapeHtml(s.displayName)}</h2>
    <div class="detail-sub">${s.packageRoots.map((r) => `<code>${escapeHtml(r.replace(/\//g, "."))}</code>`).join(" &middot; ")}</div>
    <div class="detail-grid">
      <div class="stat-box"><div class="num">${s.classCount}</div><div class="lbl">Classes</div></div>
      <div class="stat-box"><div class="num">${s.usedByAppFileCount}</div><div class="lbl">App files referencing it</div></div>
      <div class="stat-box"><div class="num">${s.nativeLibs.length}</div><div class="lbl">Native libs</div></div>
      <div class="stat-box"><div class="num">${s.bundledModels.length}</div><div class="lbl">Bundled models</div></div>
    </div>
    <div class="diff-section">
      <h3>What it is</h3>
      <div class="mock-text" style="font-size:13px; line-height:1.6;">${escapeHtml(s.description)}</div>
    </div>
    <div class="diff-section">
      <h3>Network signal</h3>
      <div class="chip-list">${netVerdict}</div>
    </div>
    ${
      s.nativeLibs.length
        ? `<div class="diff-section"><h3>Native libraries (arm64-v8a)</h3>${s.nativeLibs
            .map((n) => `<div class="string-diff-row"><span class="key">${escapeHtml(n.name)}</span> <span style="color:var(--text-dim);">${fmtBytes(n.sizeBytes)}</span></div>`)
            .join("")}</div>`
        : ""
    }
    ${
      s.bundledModels.length
        ? `<div class="diff-section"><h3>Bundled model assets</h3>${s.bundledModels
            .map((n) => `<div class="string-diff-row"><span class="key">${escapeHtml(n.name.replace("assets/models/", ""))}</span> <span style="color:var(--text-dim);">${fmtBytes(n.sizeBytes)}</span></div>`)
            .join("")}</div>`
        : ""
    }
  `;
}

/* ---------------------------- Compare ---------------------------- */

function populateCompareSelects() {
  const opts = DATA.versions.map((v) => `<option value="${v.version}">v${v.version} (${v.date})</option>`).join("");
  $("#compare-from").innerHTML = opts;
  $("#compare-to").innerHTML = opts;
  $("#compare-from").value = DATA.versions[0].version;
  $("#compare-to").value = DATA.versions[DATA.versions.length - 1].version;
}

function diffStates(a, b) {
  const setDiff = (arrA, arrB) => {
    const A = new Set(arrA), B = new Set(arrB);
    return { added: [...B].filter((x) => !A.has(x)).sort(), removed: [...A].filter((x) => !B.has(x)).sort() };
  };
  const activities = setDiff(a.activities, b.activities);
  const services = setDiff(a.services, b.services);
  const receivers = setDiff(a.receivers, b.receivers);
  const permissions = setDiff(a.permissions, b.permissions);

  const addedStrings = {}, removedStrings = [], modifiedStrings = {};
  for (const [k, v] of Object.entries(b.strings)) {
    if (!(k in a.strings)) addedStrings[k] = v;
    else if (a.strings[k] !== v) modifiedStrings[k] = { old: a.strings[k], new: v };
  }
  for (const k of Object.keys(a.strings)) if (!(k in b.strings)) removedStrings.push(k);

  return { activities, services, receivers, permissions, addedStrings, removedStrings: removedStrings.sort(), modifiedStrings };
}

async function runCompare() {
  const from = $("#compare-from").value;
  const to = $("#compare-to").value;
  const result = $("#compare-result");
  result.innerHTML = '<div class="empty-state">Loading&hellip;</div>';
  const [a, b] = await Promise.all([getState(from), getState(to)]);
  const d = diffStates(a, b);
  const stringAdds = Object.entries(d.addedStrings);
  const stringMods = Object.entries(d.modifiedStrings);

  const chipRow = (label, items, cls) =>
    items.length
      ? `<div class="diff-section"><h3>${label} (${items.length})</h3><div class="chip-list">${items.map((i) => `<span class="chip ${cls}">${escapeHtml(i.split(".").pop())}</span>`).join("")}</div></div>`
      : "";

  result.innerHTML = `
    <div class="compare-block">
      <h2 class="detail-title">v${from} &rarr; v${to}</h2>
      <div class="detail-sub">${a.date} &rarr; ${b.date}</div>
      <div class="detail-grid">
        <div class="stat-box"><div class="num">${a.activities.length} &rarr; ${b.activities.length}</div><div class="lbl">Screens</div></div>
        <div class="stat-box"><div class="num">${Object.keys(a.strings).length} &rarr; ${Object.keys(b.strings).length}</div><div class="lbl">Strings</div></div>
        <div class="stat-box"><div class="num">${a.permissions.length} &rarr; ${b.permissions.length}</div><div class="lbl">Permissions</div></div>
        <div class="stat-box"><div class="num">${a.targetSdkVersion} &rarr; ${b.targetSdkVersion}</div><div class="lbl">Target SDK</div></div>
      </div>
      ${chipRow("Screens added", d.activities.added, "add")}
      ${chipRow("Screens removed", d.activities.removed, "rem")}
      ${chipRow("Services added", d.services.added, "add")}
      ${chipRow("Receivers added", d.receivers.added, "add")}
      ${chipRow("Permissions added", d.permissions.added, "add")}
      ${chipRow("Permissions removed", d.permissions.removed, "rem")}
      ${
        stringAdds.length
          ? `<div class="diff-section"><h3>Strings added (${stringAdds.length})</h3>${stringAdds.map(([k, v]) => `<div class="string-diff-row"><span class="key">${escapeHtml(k)}</span><span class="new">${escapeHtml(v)}</span></div>`).join("")}</div>`
          : ""
      }
      ${
        stringMods.length
          ? `<div class="diff-section"><h3>Strings modified (${stringMods.length})</h3>${stringMods.map(([k, ch]) => `<div class="string-diff-row"><span class="key">${escapeHtml(k)}</span><span class="old">${escapeHtml(ch.old)}</span><span class="new">${escapeHtml(ch.new)}</span></div>`).join("")}</div>`
          : ""
      }
    </div>
  `;
}

/* ---------------------------- Search ---------------------------- */

function runSearch() {
  const q = $("#global-search").value.trim().toLowerCase();
  const result = $("#search-result");
  if (!q) {
    result.innerHTML = '<div class="empty-state">Type to search screen names and UI string text/keys across all 30 versions.</div>';
    $("#search-count").textContent = "";
    return;
  }
  const featureHits = DATA.featureIndex.features.filter((f) => f.label.toLowerCase().includes(q) || f.className.toLowerCase().includes(q)).slice(0, 60);
  const stringHits = DATA.stringIndex.strings.filter((s) => s.key.toLowerCase().includes(q) || s.text.toLowerCase().includes(q)).slice(0, 80);

  $("#search-count").textContent = `${featureHits.length} screens · ${stringHits.length} strings`;

  const featHtml = featureHits
    .map(
      (f) => `<div class="search-hit">
        <div class="kind">Screen</div>
        <div class="title">${highlight(f.label, q)}</div>
        <div class="sub">${escapeHtml(f.className)} &middot; v${f.firstSeen}&ndash;${f.stillPresent ? "9.68" : f.lastSeen}</div>
      </div>`
    )
    .join("");
  const strHtml = stringHits
    .map(
      (s) => `<div class="search-hit">
        <div class="kind">UI string</div>
        <div class="title">${highlight(s.text, q)}</div>
        <div class="sub">${highlight(s.key, q)} &middot; v${s.firstSeen}&ndash;${s.stillPresent ? "9.68" : s.lastSeen}</div>
      </div>`
    )
    .join("");

  result.innerHTML = featHtml + strHtml || '<div class="empty-state">No matches.</div>';
}

/* ---------------------------- Wire up ---------------------------- */

function setupEvents() {
  $("#feature-search").addEventListener("input", renderFeatureList);
  $("#feature-module").addEventListener("change", renderFeatureList);
  $("#feature-existence").addEventListener("change", renderFeatureList);

  $("#flow-version").addEventListener("change", () => {
    flowState.positions = new Map();
    ensureFlowRendered();
  });
  $("#flow-module").addEventListener("change", applyFlowFilters);
  $("#flow-search").addEventListener("input", applyFlowFilters);
  window.addEventListener("resize", () => {
    if (!$("#view-flows").hidden) renderFlowGraph();
  });

  $("#compare-run").addEventListener("click", runCompare);
  $("#global-search").addEventListener("input", runSearch);
}

async function main() {
  await loadCore();
  setupTabs();
  setupEvents();
  renderTimelineList();
  selectTimelineVersion(DATA.versions[DATA.versions.length - 1].version);
  populateFeatureModuleFilter();
  renderFeatureList();
  populateCompareSelects();
  runSearch();
}

main().catch((err) => {
  document.body.innerHTML = `<div style="padding:40px;font-family:monospace;color:#b3261e;">Failed to load explorer data: ${escapeHtml(err.message)}<br><br>Make sure you're serving this folder over HTTP (e.g. <code>python3 -m http.server</code>) rather than opening index.html directly as a file.</div>`;
});
