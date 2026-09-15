package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STBWMode;
import com.microsoft.schemas.office.office.STConnectorType;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.office.office.STTrueFalseBlank;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTRect;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTStroke;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.CTTextbox;
import com.microsoft.schemas.vml.STColorType;
import com.yalantis.ucrop.view.CropImageView;
import in.gov.eci.bloapp.utils.Constants;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CTRectImpl extends XmlComplexContentImpl implements CTRect {
    private static final long serialVersionUID = 1;
    private static final QName PATH$0 = new QName("urn:schemas-microsoft-com:vml", "path");
    private static final QName FORMULAS$2 = new QName("urn:schemas-microsoft-com:vml", "formulas");
    private static final QName HANDLES$4 = new QName("urn:schemas-microsoft-com:vml", "handles");
    private static final QName FILL$6 = new QName("urn:schemas-microsoft-com:vml", "fill");
    private static final QName STROKE$8 = new QName("urn:schemas-microsoft-com:vml", "stroke");
    private static final QName SHADOW$10 = new QName("urn:schemas-microsoft-com:vml", "shadow");
    private static final QName TEXTBOX$12 = new QName("urn:schemas-microsoft-com:vml", "textbox");
    private static final QName TEXTPATH$14 = new QName("urn:schemas-microsoft-com:vml", "textpath");
    private static final QName IMAGEDATA$16 = new QName("urn:schemas-microsoft-com:vml", "imagedata");
    private static final QName SKEW$18 = new QName("urn:schemas-microsoft-com:office:office", "skew");
    private static final QName EXTRUSION$20 = new QName("urn:schemas-microsoft-com:office:office", "extrusion");
    private static final QName CALLOUT$22 = new QName("urn:schemas-microsoft-com:office:office", "callout");
    private static final QName LOCK$24 = new QName("urn:schemas-microsoft-com:office:office", "lock");
    private static final QName CLIPPATH$26 = new QName("urn:schemas-microsoft-com:office:office", "clippath");
    private static final QName SIGNATURELINE$28 = new QName("urn:schemas-microsoft-com:office:office", "signatureline");
    private static final QName WRAP$30 = new QName("urn:schemas-microsoft-com:office:word", "wrap");
    private static final QName ANCHORLOCK$32 = new QName("urn:schemas-microsoft-com:office:word", "anchorlock");
    private static final QName BORDERTOP$34 = new QName("urn:schemas-microsoft-com:office:word", "bordertop");
    private static final QName BORDERBOTTOM$36 = new QName("urn:schemas-microsoft-com:office:word", "borderbottom");
    private static final QName BORDERLEFT$38 = new QName("urn:schemas-microsoft-com:office:word", "borderleft");
    private static final QName BORDERRIGHT$40 = new QName("urn:schemas-microsoft-com:office:word", "borderright");
    private static final QName CLIENTDATA$42 = new QName("urn:schemas-microsoft-com:office:excel", "ClientData");
    private static final QName TEXTDATA$44 = new QName("urn:schemas-microsoft-com:office:powerpoint", "textdata");
    private static final QName ID$46 = new QName("", "id");
    private static final QName STYLE$48 = new QName("", "style");
    private static final QName HREF$50 = new QName("", "href");
    private static final QName TARGET$52 = new QName("", "target");
    private static final QName CLASS1$54 = new QName("", "class");
    private static final QName TITLE$56 = new QName("", Constants.TITLE);
    private static final QName ALT$58 = new QName("", "alt");
    private static final QName COORDSIZE$60 = new QName("", "coordsize");
    private static final QName COORDORIGIN$62 = new QName("", "coordorigin");
    private static final QName WRAPCOORDS$64 = new QName("", "wrapcoords");
    private static final QName PRINT$66 = new QName("", "print");
    private static final QName SPID$68 = new QName("urn:schemas-microsoft-com:office:office", "spid");
    private static final QName ONED$70 = new QName("urn:schemas-microsoft-com:office:office", "oned");
    private static final QName REGROUPID$72 = new QName("urn:schemas-microsoft-com:office:office", "regroupid");
    private static final QName DOUBLECLICKNOTIFY$74 = new QName("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
    private static final QName BUTTON$76 = new QName("urn:schemas-microsoft-com:office:office", "button");
    private static final QName USERHIDDEN$78 = new QName("urn:schemas-microsoft-com:office:office", "userhidden");
    private static final QName BULLET$80 = new QName("urn:schemas-microsoft-com:office:office", "bullet");
    private static final QName HR$82 = new QName("urn:schemas-microsoft-com:office:office", "hr");
    private static final QName HRSTD$84 = new QName("urn:schemas-microsoft-com:office:office", "hrstd");
    private static final QName HRNOSHADE$86 = new QName("urn:schemas-microsoft-com:office:office", "hrnoshade");
    private static final QName HRPCT$88 = new QName("urn:schemas-microsoft-com:office:office", "hrpct");
    private static final QName HRALIGN$90 = new QName("urn:schemas-microsoft-com:office:office", "hralign");
    private static final QName ALLOWINCELL$92 = new QName("urn:schemas-microsoft-com:office:office", "allowincell");
    private static final QName ALLOWOVERLAP$94 = new QName("urn:schemas-microsoft-com:office:office", "allowoverlap");
    private static final QName USERDRAWN$96 = new QName("urn:schemas-microsoft-com:office:office", "userdrawn");
    private static final QName BORDERTOPCOLOR$98 = new QName("urn:schemas-microsoft-com:office:office", "bordertopcolor");
    private static final QName BORDERLEFTCOLOR$100 = new QName("urn:schemas-microsoft-com:office:office", "borderleftcolor");
    private static final QName BORDERBOTTOMCOLOR$102 = new QName("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
    private static final QName BORDERRIGHTCOLOR$104 = new QName("urn:schemas-microsoft-com:office:office", "borderrightcolor");
    private static final QName DGMLAYOUT$106 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayout");
    private static final QName DGMNODEKIND$108 = new QName("urn:schemas-microsoft-com:office:office", "dgmnodekind");
    private static final QName DGMLAYOUTMRU$110 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
    private static final QName INSETMODE$112 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");
    private static final QName CHROMAKEY$114 = new QName("", "chromakey");
    private static final QName FILLED$116 = new QName("", "filled");
    private static final QName FILLCOLOR$118 = new QName("", "fillcolor");
    private static final QName OPACITY$120 = new QName("", "opacity");
    private static final QName STROKED$122 = new QName("", "stroked");
    private static final QName STROKECOLOR$124 = new QName("", "strokecolor");
    private static final QName STROKEWEIGHT$126 = new QName("", "strokeweight");
    private static final QName INSETPEN$128 = new QName("", "insetpen");
    private static final QName SPT$130 = new QName("urn:schemas-microsoft-com:office:office", "spt");
    private static final QName CONNECTORTYPE$132 = new QName("urn:schemas-microsoft-com:office:office", "connectortype");
    private static final QName BWMODE$134 = new QName("urn:schemas-microsoft-com:office:office", "bwmode");
    private static final QName BWPURE$136 = new QName("urn:schemas-microsoft-com:office:office", "bwpure");
    private static final QName BWNORMAL$138 = new QName("urn:schemas-microsoft-com:office:office", "bwnormal");
    private static final QName FORCEDASH$140 = new QName("urn:schemas-microsoft-com:office:office", "forcedash");
    private static final QName OLEICON$142 = new QName("urn:schemas-microsoft-com:office:office", "oleicon");
    private static final QName OLE$144 = new QName("urn:schemas-microsoft-com:office:office", "ole");
    private static final QName PREFERRELATIVE$146 = new QName("urn:schemas-microsoft-com:office:office", "preferrelative");
    private static final QName CLIPTOWRAP$148 = new QName("urn:schemas-microsoft-com:office:office", "cliptowrap");
    private static final QName CLIP$150 = new QName("urn:schemas-microsoft-com:office:office", "clip");

    public CTRectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTAnchorLock addNewAnchorlock() {
        CTAnchorLock cTAnchorLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockAdd_element_user = get_store().add_element_user(ANCHORLOCK$32);
        }
        return cTAnchorLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder addNewBorderbottom() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERBOTTOM$36);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder addNewBorderleft() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERLEFT$38);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder addNewBorderright() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERRIGHT$40);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder addNewBordertop() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERTOP$34);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTCallout addNewCallout() {
        CTCallout cTCalloutAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutAdd_element_user = get_store().add_element_user(CALLOUT$22);
        }
        return cTCalloutAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTClientData addNewClientData() {
        CTClientData cTClientDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataAdd_element_user = get_store().add_element_user(CLIENTDATA$42);
        }
        return cTClientDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTClipPath addNewClippath() {
        CTClipPath cTClipPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathAdd_element_user = get_store().add_element_user(CLIPPATH$26);
        }
        return cTClipPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTExtrusion addNewExtrusion() {
        CTExtrusion cTExtrusionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionAdd_element_user = get_store().add_element_user(EXTRUSION$20);
        }
        return cTExtrusionAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTFill addNewFill() {
        CTFill cTFillAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillAdd_element_user = get_store().add_element_user(FILL$6);
        }
        return cTFillAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTFormulas addNewFormulas() {
        CTFormulas cTFormulasAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasAdd_element_user = get_store().add_element_user(FORMULAS$2);
        }
        return cTFormulasAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTHandles addNewHandles() {
        CTHandles cTHandlesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesAdd_element_user = get_store().add_element_user(HANDLES$4);
        }
        return cTHandlesAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTImageData addNewImagedata() {
        CTImageData cTImageDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataAdd_element_user = get_store().add_element_user(IMAGEDATA$16);
        }
        return cTImageDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTLock addNewLock() {
        CTLock cTLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockAdd_element_user = get_store().add_element_user(LOCK$24);
        }
        return cTLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTPath addNewPath() {
        CTPath cTPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathAdd_element_user = get_store().add_element_user(PATH$0);
        }
        return cTPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTShadow addNewShadow() {
        CTShadow cTShadowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowAdd_element_user = get_store().add_element_user(SHADOW$10);
        }
        return cTShadowAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTSignatureLine addNewSignatureline() {
        CTSignatureLine cTSignatureLineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineAdd_element_user = get_store().add_element_user(SIGNATURELINE$28);
        }
        return cTSignatureLineAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTSkew addNewSkew() {
        CTSkew cTSkewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewAdd_element_user = get_store().add_element_user(SKEW$18);
        }
        return cTSkewAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTStroke addNewStroke() {
        CTStroke cTStrokeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeAdd_element_user = get_store().add_element_user(STROKE$8);
        }
        return cTStrokeAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTTextbox addNewTextbox() {
        CTTextbox cTTextboxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxAdd_element_user = get_store().add_element_user(TEXTBOX$12);
        }
        return cTTextboxAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTRel addNewTextdata() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(TEXTDATA$44);
        }
        return cTRelAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTTextPath addNewTextpath() {
        CTTextPath cTTextPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathAdd_element_user = get_store().add_element_user(TEXTPATH$14);
        }
        return cTTextPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTWrap addNewWrap() {
        CTWrap cTWrapAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapAdd_element_user = get_store().add_element_user(WRAP$30);
        }
        return cTWrapAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$92);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$94);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getAlt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALT$58);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTAnchorLock getAnchorlockArray(int i) {
        CTAnchorLock cTAnchorLockFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockFind_element_user = get_store().find_element_user(ANCHORLOCK$32, i);
            if (cTAnchorLockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAnchorLockFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTAnchorLock[] getAnchorlockArray() {
        CTAnchorLock[] cTAnchorLockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANCHORLOCK$32, arrayList);
            cTAnchorLockArr = new CTAnchorLock[arrayList.size()];
            arrayList.toArray(cTAnchorLockArr);
        }
        return cTAnchorLockArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTAnchorLock> getAnchorlockList() {
        AbstractList<CTAnchorLock> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTAnchorLock>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1AnchorlockList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTAnchorLock cTAnchorLock) {
                    CTRectImpl.this.insertNewAnchorlock(i).set(cTAnchorLock);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAnchorLock get(int i) {
                    return CTRectImpl.this.getAnchorlockArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAnchorLock remove(int i) {
                    CTAnchorLock anchorlockArray = CTRectImpl.this.getAnchorlockArray(i);
                    CTRectImpl.this.removeAnchorlock(i);
                    return anchorlockArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAnchorLock set(int i, CTAnchorLock cTAnchorLock) {
                    CTAnchorLock anchorlockArray = CTRectImpl.this.getAnchorlockArray(i);
                    CTRectImpl.this.setAnchorlockArray(i, cTAnchorLock);
                    return anchorlockArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfAnchorlockArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder getBorderbottomArray(int i) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderFind_element_user = get_store().find_element_user(BORDERBOTTOM$36, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTBorder[] getBorderbottomArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERBOTTOM$36, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTBorder> getBorderbottomList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1BorderbottomList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTRectImpl.this.insertNewBorderbottom(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTRectImpl.this.getBorderbottomArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder borderbottomArray = CTRectImpl.this.getBorderbottomArray(i);
                    CTRectImpl.this.removeBorderbottom(i);
                    return borderbottomArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder borderbottomArray = CTRectImpl.this.getBorderbottomArray(i);
                    CTRectImpl.this.setBorderbottomArray(i, cTBorder);
                    return borderbottomArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfBorderbottomArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$102);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder getBorderleftArray(int i) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderFind_element_user = get_store().find_element_user(BORDERLEFT$38, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTBorder[] getBorderleftArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERLEFT$38, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTBorder> getBorderleftList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1BorderleftList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTRectImpl.this.insertNewBorderleft(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTRectImpl.this.getBorderleftArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder borderleftArray = CTRectImpl.this.getBorderleftArray(i);
                    CTRectImpl.this.removeBorderleft(i);
                    return borderleftArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder borderleftArray = CTRectImpl.this.getBorderleftArray(i);
                    CTRectImpl.this.setBorderleftArray(i, cTBorder);
                    return borderleftArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfBorderleftArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$100);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder getBorderrightArray(int i) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderFind_element_user = get_store().find_element_user(BORDERRIGHT$40, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTBorder[] getBorderrightArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERRIGHT$40, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTBorder> getBorderrightList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1BorderrightList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTRectImpl.this.insertNewBorderright(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTRectImpl.this.getBorderrightArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder borderrightArray = CTRectImpl.this.getBorderrightArray(i);
                    CTRectImpl.this.removeBorderright(i);
                    return borderrightArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder borderrightArray = CTRectImpl.this.getBorderrightArray(i);
                    CTRectImpl.this.setBorderrightArray(i, cTBorder);
                    return borderrightArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfBorderrightArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$104);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder getBordertopArray(int i) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderFind_element_user = get_store().find_element_user(BORDERTOP$34, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTBorder[] getBordertopArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERTOP$34, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTBorder> getBordertopList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1BordertopList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTRectImpl.this.insertNewBordertop(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTRectImpl.this.getBordertopArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder bordertopArray = CTRectImpl.this.getBordertopArray(i);
                    CTRectImpl.this.removeBordertop(i);
                    return bordertopArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder bordertopArray = CTRectImpl.this.getBordertopArray(i);
                    CTRectImpl.this.setBordertopArray(i, cTBorder);
                    return bordertopArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfBordertopArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$98);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getBullet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BULLET$80);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getButton() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BUTTON$76);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STBWMode.Enum getBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWMODE$134);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STBWMode.Enum getBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWNORMAL$138);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STBWMode.Enum getBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWPURE$136);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTCallout getCalloutArray(int i) {
        CTCallout cTCalloutFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutFind_element_user = get_store().find_element_user(CALLOUT$22, i);
            if (cTCalloutFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCalloutFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTCallout[] getCalloutArray() {
        CTCallout[] cTCalloutArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CALLOUT$22, arrayList);
            cTCalloutArr = new CTCallout[arrayList.size()];
            arrayList.toArray(cTCalloutArr);
        }
        return cTCalloutArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTCallout> getCalloutList() {
        AbstractList<CTCallout> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTCallout>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1CalloutList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTCallout cTCallout) {
                    CTRectImpl.this.insertNewCallout(i).set(cTCallout);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCallout get(int i) {
                    return CTRectImpl.this.getCalloutArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCallout remove(int i) {
                    CTCallout calloutArray = CTRectImpl.this.getCalloutArray(i);
                    CTRectImpl.this.removeCallout(i);
                    return calloutArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCallout set(int i, CTCallout cTCallout) {
                    CTCallout calloutArray = CTRectImpl.this.getCalloutArray(i);
                    CTRectImpl.this.setCalloutArray(i, cTCallout);
                    return calloutArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfCalloutArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CHROMAKEY$114);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getClass1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLASS1$54);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTClientData getClientDataArray(int i) {
        CTClientData cTClientDataFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataFind_element_user = get_store().find_element_user(CLIENTDATA$42, i);
            if (cTClientDataFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTClientDataFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTClientData[] getClientDataArray() {
        CTClientData[] cTClientDataArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLIENTDATA$42, arrayList);
            cTClientDataArr = new CTClientData[arrayList.size()];
            arrayList.toArray(cTClientDataArr);
        }
        return cTClientDataArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTClientData> getClientDataList() {
        AbstractList<CTClientData> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTClientData>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1ClientDataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTClientData cTClientData) {
                    CTRectImpl.this.insertNewClientData(i).set(cTClientData);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData get(int i) {
                    return CTRectImpl.this.getClientDataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData remove(int i) {
                    CTClientData clientDataArray = CTRectImpl.this.getClientDataArray(i);
                    CTRectImpl.this.removeClientData(i);
                    return clientDataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData set(int i, CTClientData cTClientData) {
                    CTClientData clientDataArray = CTRectImpl.this.getClientDataArray(i);
                    CTRectImpl.this.setClientDataArray(i, cTClientData);
                    return clientDataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfClientDataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getClip() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLIP$150);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTClipPath getClippathArray(int i) {
        CTClipPath cTClipPathFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathFind_element_user = get_store().find_element_user(CLIPPATH$26, i);
            if (cTClipPathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTClipPathFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTClipPath[] getClippathArray() {
        CTClipPath[] cTClipPathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLIPPATH$26, arrayList);
            cTClipPathArr = new CTClipPath[arrayList.size()];
            arrayList.toArray(cTClipPathArr);
        }
        return cTClipPathArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTClipPath> getClippathList() {
        AbstractList<CTClipPath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTClipPath>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1ClippathList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTClipPath cTClipPath) {
                    CTRectImpl.this.insertNewClippath(i).set(cTClipPath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClipPath get(int i) {
                    return CTRectImpl.this.getClippathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClipPath remove(int i) {
                    CTClipPath clippathArray = CTRectImpl.this.getClippathArray(i);
                    CTRectImpl.this.removeClippath(i);
                    return clippathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClipPath set(int i, CTClipPath cTClipPath) {
                    CTClipPath clippathArray = CTRectImpl.this.getClippathArray(i);
                    CTRectImpl.this.setClippathArray(i, cTClipPath);
                    return clippathArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfClippathArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$148);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STConnectorType.Enum getConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$132;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$62);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDSIZE$60);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public BigInteger getDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$106);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public BigInteger getDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$110);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public BigInteger getDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$108);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$74);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTExtrusion getExtrusionArray(int i) {
        CTExtrusion cTExtrusionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionFind_element_user = get_store().find_element_user(EXTRUSION$20, i);
            if (cTExtrusionFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExtrusionFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTExtrusion[] getExtrusionArray() {
        CTExtrusion[] cTExtrusionArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXTRUSION$20, arrayList);
            cTExtrusionArr = new CTExtrusion[arrayList.size()];
            arrayList.toArray(cTExtrusionArr);
        }
        return cTExtrusionArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTExtrusion> getExtrusionList() {
        AbstractList<CTExtrusion> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTExtrusion>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1ExtrusionList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTExtrusion cTExtrusion) {
                    CTRectImpl.this.insertNewExtrusion(i).set(cTExtrusion);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtrusion get(int i) {
                    return CTRectImpl.this.getExtrusionArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtrusion remove(int i) {
                    CTExtrusion extrusionArray = CTRectImpl.this.getExtrusionArray(i);
                    CTRectImpl.this.removeExtrusion(i);
                    return extrusionArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtrusion set(int i, CTExtrusion cTExtrusion) {
                    CTExtrusion extrusionArray = CTRectImpl.this.getExtrusionArray(i);
                    CTRectImpl.this.setExtrusionArray(i, cTExtrusion);
                    return extrusionArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfExtrusionArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTFill getFillArray(int i) {
        CTFill cTFillFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillFind_element_user = get_store().find_element_user(FILL$6, i);
            if (cTFillFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFillFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTFill[] getFillArray() {
        CTFill[] cTFillArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FILL$6, arrayList);
            cTFillArr = new CTFill[arrayList.size()];
            arrayList.toArray(cTFillArr);
        }
        return cTFillArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTFill> getFillList() {
        AbstractList<CTFill> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFill>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1FillList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFill cTFill) {
                    CTRectImpl.this.insertNewFill(i).set(cTFill);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFill get(int i) {
                    return CTRectImpl.this.getFillArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFill remove(int i) {
                    CTFill fillArray = CTRectImpl.this.getFillArray(i);
                    CTRectImpl.this.removeFill(i);
                    return fillArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFill set(int i, CTFill cTFill) {
                    CTFill fillArray = CTRectImpl.this.getFillArray(i);
                    CTRectImpl.this.setFillArray(i, cTFill);
                    return fillArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfFillArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$118);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public com.microsoft.schemas.vml.STTrueFalse.Enum getFilled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLED$116);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FORCEDASH$140);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTFormulas getFormulasArray(int i) {
        CTFormulas cTFormulasFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasFind_element_user = get_store().find_element_user(FORMULAS$2, i);
            if (cTFormulasFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFormulasFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTFormulas[] getFormulasArray() {
        CTFormulas[] cTFormulasArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FORMULAS$2, arrayList);
            cTFormulasArr = new CTFormulas[arrayList.size()];
            arrayList.toArray(cTFormulasArr);
        }
        return cTFormulasArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTFormulas> getFormulasList() {
        AbstractList<CTFormulas> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFormulas>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1FormulasList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFormulas cTFormulas) {
                    CTRectImpl.this.insertNewFormulas(i).set(cTFormulas);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFormulas get(int i) {
                    return CTRectImpl.this.getFormulasArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFormulas remove(int i) {
                    CTFormulas formulasArray = CTRectImpl.this.getFormulasArray(i);
                    CTRectImpl.this.removeFormulas(i);
                    return formulasArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFormulas set(int i, CTFormulas cTFormulas) {
                    CTFormulas formulasArray = CTRectImpl.this.getFormulasArray(i);
                    CTRectImpl.this.setFormulasArray(i, cTFormulas);
                    return formulasArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfFormulasArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTHandles getHandlesArray(int i) {
        CTHandles cTHandlesFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesFind_element_user = get_store().find_element_user(HANDLES$4, i);
            if (cTHandlesFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHandlesFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTHandles[] getHandlesArray() {
        CTHandles[] cTHandlesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HANDLES$4, arrayList);
            cTHandlesArr = new CTHandles[arrayList.size()];
            arrayList.toArray(cTHandlesArr);
        }
        return cTHandlesArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTHandles> getHandlesList() {
        AbstractList<CTHandles> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTHandles>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1HandlesList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTHandles cTHandles) {
                    CTRectImpl.this.insertNewHandles(i).set(cTHandles);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTHandles get(int i) {
                    return CTRectImpl.this.getHandlesArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTHandles remove(int i) {
                    CTHandles handlesArray = CTRectImpl.this.getHandlesArray(i);
                    CTRectImpl.this.removeHandles(i);
                    return handlesArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTHandles set(int i, CTHandles cTHandles) {
                    CTHandles handlesArray = CTRectImpl.this.getHandlesArray(i);
                    CTRectImpl.this.setHandlesArray(i, cTHandles);
                    return handlesArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfHandlesArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getHr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HR$82);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STHrAlign.Enum getHralign() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$90;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HREF$50);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$86);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public float getHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRPCT$88);
            if (simpleValueFind_attribute_user == null) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            return simpleValueFind_attribute_user.getFloatValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRSTD$84);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$46);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTImageData getImagedataArray(int i) {
        CTImageData cTImageDataFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataFind_element_user = get_store().find_element_user(IMAGEDATA$16, i);
            if (cTImageDataFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTImageDataFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTImageData[] getImagedataArray() {
        CTImageData[] cTImageDataArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(IMAGEDATA$16, arrayList);
            cTImageDataArr = new CTImageData[arrayList.size()];
            arrayList.toArray(cTImageDataArr);
        }
        return cTImageDataArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTImageData> getImagedataList() {
        AbstractList<CTImageData> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTImageData>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1ImagedataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTImageData cTImageData) {
                    CTRectImpl.this.insertNewImagedata(i).set(cTImageData);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTImageData get(int i) {
                    return CTRectImpl.this.getImagedataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTImageData remove(int i) {
                    CTImageData imagedataArray = CTRectImpl.this.getImagedataArray(i);
                    CTRectImpl.this.removeImagedata(i);
                    return imagedataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTImageData set(int i, CTImageData cTImageData) {
                    CTImageData imagedataArray = CTRectImpl.this.getImagedataArray(i);
                    CTRectImpl.this.setImagedataArray(i, cTImageData);
                    return imagedataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfImagedataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$112;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public com.microsoft.schemas.vml.STTrueFalse.Enum getInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(INSETPEN$128);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTLock getLockArray(int i) {
        CTLock cTLockFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockFind_element_user = get_store().find_element_user(LOCK$24, i);
            if (cTLockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLockFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTLock[] getLockArray() {
        CTLock[] cTLockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LOCK$24, arrayList);
            cTLockArr = new CTLock[arrayList.size()];
            arrayList.toArray(cTLockArr);
        }
        return cTLockArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTLock> getLockList() {
        AbstractList<CTLock> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTLock>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1LockList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTLock cTLock) {
                    CTRectImpl.this.insertNewLock(i).set(cTLock);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLock get(int i) {
                    return CTRectImpl.this.getLockArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLock remove(int i) {
                    CTLock lockArray = CTRectImpl.this.getLockArray(i);
                    CTRectImpl.this.removeLock(i);
                    return lockArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLock set(int i, CTLock cTLock) {
                    CTLock lockArray = CTRectImpl.this.getLockArray(i);
                    CTRectImpl.this.setLockArray(i, cTLock);
                    return lockArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfLockArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalseBlank.Enum getOle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OLE$144);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OLEICON$142);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getOned() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ONED$70);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OPACITY$120);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTPath getPathArray(int i) {
        CTPath cTPathFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathFind_element_user = get_store().find_element_user(PATH$0, i);
            if (cTPathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPathFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTPath[] getPathArray() {
        CTPath[] cTPathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PATH$0, arrayList);
            cTPathArr = new CTPath[arrayList.size()];
            arrayList.toArray(cTPathArr);
        }
        return cTPathArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTPath> getPathList() {
        AbstractList<CTPath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPath>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1PathList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPath cTPath) {
                    CTRectImpl.this.insertNewPath(i).set(cTPath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath get(int i) {
                    return CTRectImpl.this.getPathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath remove(int i) {
                    CTPath pathArray = CTRectImpl.this.getPathArray(i);
                    CTRectImpl.this.removePath(i);
                    return pathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath set(int i, CTPath cTPath) {
                    CTPath pathArray = CTRectImpl.this.getPathArray(i);
                    CTRectImpl.this.setPathArray(i, cTPath);
                    return pathArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfPathArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$146);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public com.microsoft.schemas.vml.STTrueFalse.Enum getPrint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PRINT$66);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public BigInteger getRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REGROUPID$72);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTShadow getShadowArray(int i) {
        CTShadow cTShadowFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowFind_element_user = get_store().find_element_user(SHADOW$10, i);
            if (cTShadowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShadowFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTShadow[] getShadowArray() {
        CTShadow[] cTShadowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHADOW$10, arrayList);
            cTShadowArr = new CTShadow[arrayList.size()];
            arrayList.toArray(cTShadowArr);
        }
        return cTShadowArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTShadow> getShadowList() {
        AbstractList<CTShadow> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTShadow>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1ShadowList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTShadow cTShadow) {
                    CTRectImpl.this.insertNewShadow(i).set(cTShadow);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTShadow get(int i) {
                    return CTRectImpl.this.getShadowArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTShadow remove(int i) {
                    CTShadow shadowArray = CTRectImpl.this.getShadowArray(i);
                    CTRectImpl.this.removeShadow(i);
                    return shadowArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTShadow set(int i, CTShadow cTShadow) {
                    CTShadow shadowArray = CTRectImpl.this.getShadowArray(i);
                    CTRectImpl.this.setShadowArray(i, cTShadow);
                    return shadowArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfShadowArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTSignatureLine getSignaturelineArray(int i) {
        CTSignatureLine cTSignatureLineFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineFind_element_user = get_store().find_element_user(SIGNATURELINE$28, i);
            if (cTSignatureLineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSignatureLineFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTSignatureLine[] getSignaturelineArray() {
        CTSignatureLine[] cTSignatureLineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SIGNATURELINE$28, arrayList);
            cTSignatureLineArr = new CTSignatureLine[arrayList.size()];
            arrayList.toArray(cTSignatureLineArr);
        }
        return cTSignatureLineArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTSignatureLine> getSignaturelineList() {
        AbstractList<CTSignatureLine> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSignatureLine>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1SignaturelineList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSignatureLine cTSignatureLine) {
                    CTRectImpl.this.insertNewSignatureline(i).set(cTSignatureLine);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSignatureLine get(int i) {
                    return CTRectImpl.this.getSignaturelineArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSignatureLine remove(int i) {
                    CTSignatureLine signaturelineArray = CTRectImpl.this.getSignaturelineArray(i);
                    CTRectImpl.this.removeSignatureline(i);
                    return signaturelineArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSignatureLine set(int i, CTSignatureLine cTSignatureLine) {
                    CTSignatureLine signaturelineArray = CTRectImpl.this.getSignaturelineArray(i);
                    CTRectImpl.this.setSignaturelineArray(i, cTSignatureLine);
                    return signaturelineArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfSignaturelineArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTSkew getSkewArray(int i) {
        CTSkew cTSkewFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewFind_element_user = get_store().find_element_user(SKEW$18, i);
            if (cTSkewFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSkewFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTSkew[] getSkewArray() {
        CTSkew[] cTSkewArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SKEW$18, arrayList);
            cTSkewArr = new CTSkew[arrayList.size()];
            arrayList.toArray(cTSkewArr);
        }
        return cTSkewArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTSkew> getSkewList() {
        AbstractList<CTSkew> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSkew>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1SkewList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSkew cTSkew) {
                    CTRectImpl.this.insertNewSkew(i).set(cTSkew);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSkew get(int i) {
                    return CTRectImpl.this.getSkewArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSkew remove(int i) {
                    CTSkew skewArray = CTRectImpl.this.getSkewArray(i);
                    CTRectImpl.this.removeSkew(i);
                    return skewArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSkew set(int i, CTSkew cTSkew) {
                    CTSkew skewArray = CTRectImpl.this.getSkewArray(i);
                    CTRectImpl.this.setSkewArray(i, cTSkew);
                    return skewArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfSkewArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getSpid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPID$68);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public float getSpt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPT$130);
            if (simpleValueFind_attribute_user == null) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            return simpleValueFind_attribute_user.getFloatValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTStroke getStrokeArray(int i) {
        CTStroke cTStrokeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeFind_element_user = get_store().find_element_user(STROKE$8, i);
            if (cTStrokeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStrokeFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTStroke[] getStrokeArray() {
        CTStroke[] cTStrokeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(STROKE$8, arrayList);
            cTStrokeArr = new CTStroke[arrayList.size()];
            arrayList.toArray(cTStrokeArr);
        }
        return cTStrokeArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTStroke> getStrokeList() {
        AbstractList<CTStroke> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTStroke>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1StrokeList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTStroke cTStroke) {
                    CTRectImpl.this.insertNewStroke(i).set(cTStroke);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTStroke get(int i) {
                    return CTRectImpl.this.getStrokeArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTStroke remove(int i) {
                    CTStroke strokeArray = CTRectImpl.this.getStrokeArray(i);
                    CTRectImpl.this.removeStroke(i);
                    return strokeArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTStroke set(int i, CTStroke cTStroke) {
                    CTStroke strokeArray = CTRectImpl.this.getStrokeArray(i);
                    CTRectImpl.this.setStrokeArray(i, cTStroke);
                    return strokeArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfStrokeArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKECOLOR$124);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public com.microsoft.schemas.vml.STTrueFalse.Enum getStroked() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKED$122);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKEWEIGHT$126);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STYLE$48);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TARGET$52);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTTextbox getTextboxArray(int i) {
        CTTextbox cTTextboxFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxFind_element_user = get_store().find_element_user(TEXTBOX$12, i);
            if (cTTextboxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextboxFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTTextbox[] getTextboxArray() {
        CTTextbox[] cTTextboxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTBOX$12, arrayList);
            cTTextboxArr = new CTTextbox[arrayList.size()];
            arrayList.toArray(cTTextboxArr);
        }
        return cTTextboxArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTTextbox> getTextboxList() {
        AbstractList<CTTextbox> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTextbox>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1TextboxList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTextbox cTTextbox) {
                    CTRectImpl.this.insertNewTextbox(i).set(cTTextbox);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextbox get(int i) {
                    return CTRectImpl.this.getTextboxArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextbox remove(int i) {
                    CTTextbox textboxArray = CTRectImpl.this.getTextboxArray(i);
                    CTRectImpl.this.removeTextbox(i);
                    return textboxArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextbox set(int i, CTTextbox cTTextbox) {
                    CTTextbox textboxArray = CTRectImpl.this.getTextboxArray(i);
                    CTRectImpl.this.setTextboxArray(i, cTTextbox);
                    return textboxArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfTextboxArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTRel getTextdataArray(int i) {
        CTRel cTRelFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelFind_element_user = get_store().find_element_user(TEXTDATA$44, i);
            if (cTRelFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRelFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTRel[] getTextdataArray() {
        CTRel[] cTRelArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTDATA$44, arrayList);
            cTRelArr = new CTRel[arrayList.size()];
            arrayList.toArray(cTRelArr);
        }
        return cTRelArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTRel> getTextdataList() {
        AbstractList<CTRel> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRel>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1TextdataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRel cTRel) {
                    CTRectImpl.this.insertNewTextdata(i).set(cTRel);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRel get(int i) {
                    return CTRectImpl.this.getTextdataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRel remove(int i) {
                    CTRel textdataArray = CTRectImpl.this.getTextdataArray(i);
                    CTRectImpl.this.removeTextdata(i);
                    return textdataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRel set(int i, CTRel cTRel) {
                    CTRel textdataArray = CTRectImpl.this.getTextdataArray(i);
                    CTRectImpl.this.setTextdataArray(i, cTRel);
                    return textdataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfTextdataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTTextPath getTextpathArray(int i) {
        CTTextPath cTTextPathFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathFind_element_user = get_store().find_element_user(TEXTPATH$14, i);
            if (cTTextPathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextPathFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTTextPath[] getTextpathArray() {
        CTTextPath[] cTTextPathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTPATH$14, arrayList);
            cTTextPathArr = new CTTextPath[arrayList.size()];
            arrayList.toArray(cTTextPathArr);
        }
        return cTTextPathArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTTextPath> getTextpathList() {
        AbstractList<CTTextPath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTextPath>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1TextpathList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTextPath cTTextPath) {
                    CTRectImpl.this.insertNewTextpath(i).set(cTTextPath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextPath get(int i) {
                    return CTRectImpl.this.getTextpathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextPath remove(int i) {
                    CTTextPath textpathArray = CTRectImpl.this.getTextpathArray(i);
                    CTRectImpl.this.removeTextpath(i);
                    return textpathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextPath set(int i, CTTextPath cTTextPath) {
                    CTTextPath textpathArray = CTRectImpl.this.getTextpathArray(i);
                    CTRectImpl.this.setTextpathArray(i, cTTextPath);
                    return textpathArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfTextpathArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TITLE$56);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERDRAWN$96);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse.Enum getUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$78);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTWrap getWrapArray(int i) {
        CTWrap cTWrapFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapFind_element_user = get_store().find_element_user(WRAP$30, i);
            if (cTWrapFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTWrapFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    @Deprecated
    public CTWrap[] getWrapArray() {
        CTWrap[] cTWrapArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(WRAP$30, arrayList);
            cTWrapArr = new CTWrap[arrayList.size()];
            arrayList.toArray(cTWrapArr);
        }
        return cTWrapArr;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public List<CTWrap> getWrapList() {
        AbstractList<CTWrap> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTWrap>() { // from class: com.microsoft.schemas.vml.impl.CTRectImpl.1WrapList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTWrap cTWrap) {
                    CTRectImpl.this.insertNewWrap(i).set(cTWrap);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTWrap get(int i) {
                    return CTRectImpl.this.getWrapArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTWrap remove(int i) {
                    CTWrap wrapArray = CTRectImpl.this.getWrapArray(i);
                    CTRectImpl.this.removeWrap(i);
                    return wrapArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTWrap set(int i, CTWrap cTWrap) {
                    CTWrap wrapArray = CTRectImpl.this.getWrapArray(i);
                    CTRectImpl.this.setWrapArray(i, cTWrap);
                    return wrapArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRectImpl.this.sizeOfWrapArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public String getWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$64);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTAnchorLock insertNewAnchorlock(int i) {
        CTAnchorLock cTAnchorLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockInsert_element_user = get_store().insert_element_user(ANCHORLOCK$32, i);
        }
        return cTAnchorLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder insertNewBorderbottom(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERBOTTOM$36, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder insertNewBorderleft(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERLEFT$38, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder insertNewBorderright(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERRIGHT$40, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTBorder insertNewBordertop(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERTOP$34, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTCallout insertNewCallout(int i) {
        CTCallout cTCalloutInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutInsert_element_user = get_store().insert_element_user(CALLOUT$22, i);
        }
        return cTCalloutInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTClientData insertNewClientData(int i) {
        CTClientData cTClientDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataInsert_element_user = get_store().insert_element_user(CLIENTDATA$42, i);
        }
        return cTClientDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTClipPath insertNewClippath(int i) {
        CTClipPath cTClipPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathInsert_element_user = get_store().insert_element_user(CLIPPATH$26, i);
        }
        return cTClipPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTExtrusion insertNewExtrusion(int i) {
        CTExtrusion cTExtrusionInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionInsert_element_user = get_store().insert_element_user(EXTRUSION$20, i);
        }
        return cTExtrusionInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTFill insertNewFill(int i) {
        CTFill cTFillInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillInsert_element_user = get_store().insert_element_user(FILL$6, i);
        }
        return cTFillInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTFormulas insertNewFormulas(int i) {
        CTFormulas cTFormulasInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasInsert_element_user = get_store().insert_element_user(FORMULAS$2, i);
        }
        return cTFormulasInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTHandles insertNewHandles(int i) {
        CTHandles cTHandlesInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesInsert_element_user = get_store().insert_element_user(HANDLES$4, i);
        }
        return cTHandlesInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTImageData insertNewImagedata(int i) {
        CTImageData cTImageDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataInsert_element_user = get_store().insert_element_user(IMAGEDATA$16, i);
        }
        return cTImageDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTLock insertNewLock(int i) {
        CTLock cTLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockInsert_element_user = get_store().insert_element_user(LOCK$24, i);
        }
        return cTLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTPath insertNewPath(int i) {
        CTPath cTPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathInsert_element_user = get_store().insert_element_user(PATH$0, i);
        }
        return cTPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTShadow insertNewShadow(int i) {
        CTShadow cTShadowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowInsert_element_user = get_store().insert_element_user(SHADOW$10, i);
        }
        return cTShadowInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTSignatureLine insertNewSignatureline(int i) {
        CTSignatureLine cTSignatureLineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineInsert_element_user = get_store().insert_element_user(SIGNATURELINE$28, i);
        }
        return cTSignatureLineInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTSkew insertNewSkew(int i) {
        CTSkew cTSkewInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewInsert_element_user = get_store().insert_element_user(SKEW$18, i);
        }
        return cTSkewInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTStroke insertNewStroke(int i) {
        CTStroke cTStrokeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeInsert_element_user = get_store().insert_element_user(STROKE$8, i);
        }
        return cTStrokeInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTTextbox insertNewTextbox(int i) {
        CTTextbox cTTextboxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxInsert_element_user = get_store().insert_element_user(TEXTBOX$12, i);
        }
        return cTTextboxInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTRel insertNewTextdata(int i) {
        CTRel cTRelInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelInsert_element_user = get_store().insert_element_user(TEXTDATA$44, i);
        }
        return cTRelInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTTextPath insertNewTextpath(int i) {
        CTTextPath cTTextPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathInsert_element_user = get_store().insert_element_user(TEXTPATH$14, i);
        }
        return cTTextPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public CTWrap insertNewWrap(int i) {
        CTWrap cTWrapInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapInsert_element_user = get_store().insert_element_user(WRAP$30, i);
        }
        return cTWrapInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetAllowincell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWINCELL$92) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetAllowoverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWOVERLAP$94) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetAlt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALT$58) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetBorderbottomcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERBOTTOMCOLOR$102) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetBorderleftcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERLEFTCOLOR$100) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetBorderrightcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERRIGHTCOLOR$104) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetBordertopcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERTOPCOLOR$98) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetBullet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BULLET$80) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetButton() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BUTTON$76) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetBwmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWMODE$134) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetBwnormal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWNORMAL$138) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetBwpure() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWPURE$136) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetChromakey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CHROMAKEY$114) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetClass1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLASS1$54) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetClip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIP$150) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetCliptowrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIPTOWRAP$148) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetConnectortype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTORTYPE$132) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetCoordorigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDORIGIN$62) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetCoordsize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDSIZE$60) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetDgmlayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUT$106) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetDgmlayoutmru() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUTMRU$110) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetDgmnodekind() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMNODEKIND$108) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetDoubleclicknotify() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DOUBLECLICKNOTIFY$74) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetFillcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLCOLOR$118) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetFilled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLED$116) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetForcedash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORCEDASH$140) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetHr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HR$82) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetHralign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRALIGN$90) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$50) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetHrnoshade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRNOSHADE$86) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetHrpct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRPCT$88) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetHrstd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRSTD$84) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$46) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$112) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetInsetpen() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETPEN$128) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetOle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLE$144) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetOleicon() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLEICON$142) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetOned() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ONED$70) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$120) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetPreferrelative() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PREFERRELATIVE$146) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetPrint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRINT$66) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetRegroupid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REGROUPID$72) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetSpid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPID$68) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetSpt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPT$130) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetStrokecolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKECOLOR$124) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetStroked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKED$122) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetStrokeweight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKEWEIGHT$126) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$48) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$52) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$56) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetUserdrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$96) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetUserhidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERHIDDEN$78) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public boolean isSetWrapcoords() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WRAPCOORDS$64) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeAnchorlock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHORLOCK$32, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeBorderbottom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOTTOM$36, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeBorderleft(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERLEFT$38, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeBorderright(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERRIGHT$40, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeBordertop(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERTOP$34, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeCallout(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALLOUT$22, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeClientData(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIENTDATA$42, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeClippath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIPPATH$26, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeExtrusion(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTRUSION$20, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$6, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeFormulas(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULAS$2, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeHandles(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HANDLES$4, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeImagedata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGEDATA$16, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$24, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removePath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$0, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$10, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeSignatureline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATURELINE$28, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeSkew(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SKEW$18, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeStroke(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STROKE$8, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeTextbox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOX$12, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeTextdata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDATA$44, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeTextpath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTPATH$14, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void removeWrap(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAP$30, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setAllowincell(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$92;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setAllowoverlap(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$94;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setAlt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$58;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setAnchorlockArray(int i, CTAnchorLock cTAnchorLock) {
        generatedSetterHelperImpl(cTAnchorLock, ANCHORLOCK$32, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr) {
        check_orphaned();
        arraySetterHelper(cTAnchorLockArr, ANCHORLOCK$32);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBorderbottomArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERBOTTOM$36, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBorderbottomArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERBOTTOM$36);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBorderbottomcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$102;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBorderleftArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERLEFT$38, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBorderleftArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERLEFT$38);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBorderleftcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$100;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBorderrightArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERRIGHT$40, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBorderrightArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERRIGHT$40);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBorderrightcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$104;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBordertopArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERTOP$34, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBordertopArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERTOP$34);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBordertopcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$98;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBullet(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$80;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setButton(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$76;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBwmode(STBWMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$134;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBwnormal(STBWMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$138;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setBwpure(STBWMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$136;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setCalloutArray(int i, CTCallout cTCallout) {
        generatedSetterHelperImpl(cTCallout, CALLOUT$22, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setCalloutArray(CTCallout[] cTCalloutArr) {
        check_orphaned();
        arraySetterHelper(cTCalloutArr, CALLOUT$22);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setChromakey(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$114;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setClass1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$54;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setClientDataArray(int i, CTClientData cTClientData) {
        generatedSetterHelperImpl(cTClientData, CLIENTDATA$42, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setClientDataArray(CTClientData[] cTClientDataArr) {
        check_orphaned();
        arraySetterHelper(cTClientDataArr, CLIENTDATA$42);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setClip(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$150;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setClippathArray(int i, CTClipPath cTClipPath) {
        generatedSetterHelperImpl(cTClipPath, CLIPPATH$26, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setClippathArray(CTClipPath[] cTClipPathArr) {
        check_orphaned();
        arraySetterHelper(cTClipPathArr, CLIPPATH$26);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setCliptowrap(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$148;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setConnectortype(STConnectorType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$132;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setCoordorigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$62;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setCoordsize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$60;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setDgmlayout(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$106;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setDgmlayoutmru(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$110;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setDgmnodekind(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$108;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setDoubleclicknotify(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$74;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setExtrusionArray(int i, CTExtrusion cTExtrusion) {
        generatedSetterHelperImpl(cTExtrusion, EXTRUSION$20, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setExtrusionArray(CTExtrusion[] cTExtrusionArr) {
        check_orphaned();
        arraySetterHelper(cTExtrusionArr, EXTRUSION$20);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setFillArray(int i, CTFill cTFill) {
        generatedSetterHelperImpl(cTFill, FILL$6, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setFillArray(CTFill[] cTFillArr) {
        check_orphaned();
        arraySetterHelper(cTFillArr, FILL$6);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setFillcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$118;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setFilled(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$116;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setForcedash(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$140;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setFormulasArray(int i, CTFormulas cTFormulas) {
        generatedSetterHelperImpl(cTFormulas, FORMULAS$2, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setFormulasArray(CTFormulas[] cTFormulasArr) {
        check_orphaned();
        arraySetterHelper(cTFormulasArr, FORMULAS$2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setHandlesArray(int i, CTHandles cTHandles) {
        generatedSetterHelperImpl(cTHandles, HANDLES$4, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setHandlesArray(CTHandles[] cTHandlesArr) {
        check_orphaned();
        arraySetterHelper(cTHandlesArr, HANDLES$4);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setHr(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$82;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setHralign(STHrAlign.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$90;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setHrnoshade(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$86;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setHrpct(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$88;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setFloatValue(f);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setHrstd(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$84;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setImagedataArray(int i, CTImageData cTImageData) {
        generatedSetterHelperImpl(cTImageData, IMAGEDATA$16, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setImagedataArray(CTImageData[] cTImageDataArr) {
        check_orphaned();
        arraySetterHelper(cTImageDataArr, IMAGEDATA$16);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$112;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setInsetpen(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$128;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setLockArray(int i, CTLock cTLock) {
        generatedSetterHelperImpl(cTLock, LOCK$24, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setLockArray(CTLock[] cTLockArr) {
        check_orphaned();
        arraySetterHelper(cTLockArr, LOCK$24);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setOle(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$144;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setOleicon(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$142;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setOned(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$70;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setOpacity(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$120;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setPathArray(int i, CTPath cTPath) {
        generatedSetterHelperImpl(cTPath, PATH$0, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setPathArray(CTPath[] cTPathArr) {
        check_orphaned();
        arraySetterHelper(cTPathArr, PATH$0);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setPreferrelative(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$146;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setPrint(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$66;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setRegroupid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$72;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setShadowArray(int i, CTShadow cTShadow) {
        generatedSetterHelperImpl(cTShadow, SHADOW$10, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setShadowArray(CTShadow[] cTShadowArr) {
        check_orphaned();
        arraySetterHelper(cTShadowArr, SHADOW$10);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setSignaturelineArray(int i, CTSignatureLine cTSignatureLine) {
        generatedSetterHelperImpl(cTSignatureLine, SIGNATURELINE$28, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr) {
        check_orphaned();
        arraySetterHelper(cTSignatureLineArr, SIGNATURELINE$28);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setSkewArray(int i, CTSkew cTSkew) {
        generatedSetterHelperImpl(cTSkew, SKEW$18, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setSkewArray(CTSkew[] cTSkewArr) {
        check_orphaned();
        arraySetterHelper(cTSkewArr, SKEW$18);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setSpid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$68;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setSpt(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$130;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setFloatValue(f);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setStrokeArray(int i, CTStroke cTStroke) {
        generatedSetterHelperImpl(cTStroke, STROKE$8, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setStrokeArray(CTStroke[] cTStrokeArr) {
        check_orphaned();
        arraySetterHelper(cTStrokeArr, STROKE$8);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setStrokecolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$124;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setStroked(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$122;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setStrokeweight(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$126;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$52;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setTextboxArray(int i, CTTextbox cTTextbox) {
        generatedSetterHelperImpl(cTTextbox, TEXTBOX$12, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setTextboxArray(CTTextbox[] cTTextboxArr) {
        check_orphaned();
        arraySetterHelper(cTTextboxArr, TEXTBOX$12);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setTextdataArray(int i, CTRel cTRel) {
        generatedSetterHelperImpl(cTRel, TEXTDATA$44, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setTextdataArray(CTRel[] cTRelArr) {
        check_orphaned();
        arraySetterHelper(cTRelArr, TEXTDATA$44);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setTextpathArray(int i, CTTextPath cTTextPath) {
        generatedSetterHelperImpl(cTTextPath, TEXTPATH$14, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setTextpathArray(CTTextPath[] cTTextPathArr) {
        check_orphaned();
        arraySetterHelper(cTTextPathArr, TEXTPATH$14);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$56;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setUserdrawn(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$96;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setUserhidden(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$78;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setWrapArray(int i, CTWrap cTWrap) {
        generatedSetterHelperImpl(cTWrap, WRAP$30, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setWrapArray(CTWrap[] cTWrapArr) {
        check_orphaned();
        arraySetterHelper(cTWrapArr, WRAP$30);
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void setWrapcoords(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$64;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfAnchorlockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANCHORLOCK$32);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfBorderbottomArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERBOTTOM$36);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfBorderleftArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERLEFT$38);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfBorderrightArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERRIGHT$40);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfBordertopArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERTOP$34);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfCalloutArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CALLOUT$22);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfClientDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIENTDATA$42);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfClippathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIPPATH$26);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfExtrusionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXTRUSION$20);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FILL$6);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfFormulasArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FORMULAS$2);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfHandlesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HANDLES$4);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfImagedataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(IMAGEDATA$16);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfLockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LOCK$24);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfPathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PATH$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfShadowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHADOW$10);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfSignaturelineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SIGNATURELINE$28);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfSkewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SKEW$18);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfStrokeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(STROKE$8);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfTextboxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTBOX$12);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfTextdataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTDATA$44);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfTextpathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTPATH$14);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public int sizeOfWrapArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(WRAP$30);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWINCELL$92);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWOVERLAP$94);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetAlt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALT$58);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERBOTTOMCOLOR$102);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERLEFTCOLOR$100);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERRIGHTCOLOR$104);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERTOPCOLOR$98);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetBullet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BULLET$80);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BUTTON$76);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWMODE$134);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWNORMAL$138);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWPURE$136);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CHROMAKEY$114);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetClass1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLASS1$54);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetClip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIP$150);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIPTOWRAP$148);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTORTYPE$132);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDORIGIN$62);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDSIZE$60);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUT$106);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUTMRU$110);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMNODEKIND$108);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DOUBLECLICKNOTIFY$74);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLCOLOR$118);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetFilled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLED$116);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORCEDASH$140);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetHr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HR$82);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetHralign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRALIGN$90);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$50);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRNOSHADE$86);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRPCT$88);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRSTD$84);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$46);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$112);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETPEN$128);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetOle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLE$144);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLEICON$142);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetOned() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ONED$70);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$120);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PREFERRELATIVE$146);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetPrint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRINT$66);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REGROUPID$72);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetSpid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPID$68);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetSpt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPT$130);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKECOLOR$124);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetStroked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKED$122);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKEWEIGHT$126);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$48);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$52);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$56);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$96);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERHIDDEN$78);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void unsetWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WRAPCOORDS$64);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetAllowincell() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$92);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetAllowoverlap() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$94);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetAlt() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ALT$58);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetBorderbottomcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$102);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetBorderleftcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$100);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetBorderrightcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$104);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetBordertopcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$98);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetBullet() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BULLET$80);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetButton() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BUTTON$76);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STBWMode xgetBwmode() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWMODE$134);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STBWMode xgetBwnormal() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWNORMAL$138);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STBWMode xgetBwpure() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWPURE$136);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STColorType xgetChromakey() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(CHROMAKEY$114);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetClass1() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(CLASS1$54);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetClip() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(CLIP$150);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetCliptowrap() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$148);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STConnectorType xgetConnectortype() {
        STConnectorType sTConnectorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$132;
            sTConnectorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTConnectorTypeFind_attribute_user == null) {
                sTConnectorTypeFind_attribute_user = (STConnectorType) get_default_attribute_value(qName);
            }
        }
        return sTConnectorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetCoordorigin() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$62);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetCoordsize() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDSIZE$60);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlInteger xgetDgmlayout() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$106);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlInteger xgetDgmlayoutmru() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$110);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlInteger xgetDgmnodekind() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$108);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetDoubleclicknotify() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$74);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STColorType xgetFillcolor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$118);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public com.microsoft.schemas.vml.STTrueFalse xgetFilled() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FILLED$116);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetForcedash() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FORCEDASH$140);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetHr() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HR$82);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STHrAlign xgetHralign() {
        STHrAlign sTHrAlignFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$90;
            sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_default_attribute_value(qName);
            }
        }
        return sTHrAlignFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetHref() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(HREF$50);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetHrnoshade() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$86);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlFloat xgetHrpct() {
        XmlFloat xmlFloatFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_attribute_user = get_store().find_attribute_user(HRPCT$88);
        }
        return xmlFloatFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetHrstd() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRSTD$84);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetId() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ID$46);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$112;
            sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_default_attribute_value(qName);
            }
        }
        return sTInsetModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public com.microsoft.schemas.vml.STTrueFalse xgetInsetpen() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(INSETPEN$128);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalseBlank xgetOle() {
        STTrueFalseBlank sTTrueFalseBlankFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlankFind_attribute_user = get_store().find_attribute_user(OLE$144);
        }
        return sTTrueFalseBlankFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetOleicon() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(OLEICON$142);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetOned() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ONED$70);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetOpacity() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(OPACITY$120);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetPreferrelative() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$146);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public com.microsoft.schemas.vml.STTrueFalse xgetPrint() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(PRINT$66);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlInteger xgetRegroupid() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(REGROUPID$72);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetSpid() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(SPID$68);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlFloat xgetSpt() {
        XmlFloat xmlFloatFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_attribute_user = get_store().find_attribute_user(SPT$130);
        }
        return xmlFloatFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STColorType xgetStrokecolor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(STROKECOLOR$124);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public com.microsoft.schemas.vml.STTrueFalse xgetStroked() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(STROKED$122);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetStrokeweight() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STROKEWEIGHT$126);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetStyle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STYLE$48);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetTarget() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TARGET$52);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetTitle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TITLE$56);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetUserdrawn() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERDRAWN$96);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public STTrueFalse xgetUserhidden() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$78);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public XmlString xgetWrapcoords() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$64);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetAllowincell(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$92;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetAllowoverlap(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$94;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetAlt(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$58;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetBorderbottomcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$102;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetBorderleftcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$100;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetBorderrightcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$104;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetBordertopcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$98;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetBullet(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$80;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetButton(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$76;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetBwmode(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$134;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetBwnormal(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$138;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetBwpure(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$136;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetChromakey(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$114;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetClass1(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$54;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetClip(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$150;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetCliptowrap(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$148;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetConnectortype(STConnectorType sTConnectorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$132;
            STConnectorType sTConnectorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTConnectorTypeFind_attribute_user == null) {
                sTConnectorTypeFind_attribute_user = (STConnectorType) get_store().add_attribute_user(qName);
            }
            sTConnectorTypeFind_attribute_user.set(sTConnectorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetCoordorigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$62;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetCoordsize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$60;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetDgmlayout(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$106;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetDgmlayoutmru(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$110;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetDgmnodekind(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$108;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetDoubleclicknotify(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$74;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetFillcolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$118;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetFilled(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$116;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetForcedash(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$140;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetHr(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$82;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetHralign(STHrAlign sTHrAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$90;
            STHrAlign sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_store().add_attribute_user(qName);
            }
            sTHrAlignFind_attribute_user.set(sTHrAlign);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$50;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetHrnoshade(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$86;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetHrpct(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$88;
            XmlFloat xmlFloatFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlFloatFind_attribute_user == null) {
                xmlFloatFind_attribute_user = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloatFind_attribute_user.set(xmlFloat);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetHrstd(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$84;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$46;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$112;
            STInsetMode sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_store().add_attribute_user(qName);
            }
            sTInsetModeFind_attribute_user.set(sTInsetMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetInsetpen(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$128;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetOle(STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$144;
            STTrueFalseBlank sTTrueFalseBlankFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseBlankFind_attribute_user == null) {
                sTTrueFalseBlankFind_attribute_user = (STTrueFalseBlank) get_store().add_attribute_user(qName);
            }
            sTTrueFalseBlankFind_attribute_user.set(sTTrueFalseBlank);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetOleicon(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$142;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetOned(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$70;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$120;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetPreferrelative(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$146;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetPrint(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$66;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetRegroupid(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$72;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetSpid(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$68;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetSpt(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$130;
            XmlFloat xmlFloatFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlFloatFind_attribute_user == null) {
                xmlFloatFind_attribute_user = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloatFind_attribute_user.set(xmlFloat);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetStrokecolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$124;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetStroked(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$122;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetStrokeweight(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$126;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$48;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$52;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$56;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetUserdrawn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$96;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetUserhidden(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$78;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTRect
    public void xsetWrapcoords(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$64;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
