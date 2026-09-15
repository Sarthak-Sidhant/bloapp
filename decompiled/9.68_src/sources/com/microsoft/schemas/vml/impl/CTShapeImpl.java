package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTInk;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STBWMode;
import com.microsoft.schemas.office.office.STConnectorType;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.office.office.STTrueFalseBlank;
import com.microsoft.schemas.office.powerpoint.CTEmpty;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShape;
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
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CTShapeImpl extends XmlComplexContentImpl implements CTShape {
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
    private static final QName INK$46 = new QName("urn:schemas-microsoft-com:office:office", "ink");
    private static final QName ISCOMMENT$48 = new QName("urn:schemas-microsoft-com:office:powerpoint", "iscomment");
    private static final QName ID$50 = new QName("", "id");
    private static final QName STYLE$52 = new QName("", "style");
    private static final QName HREF$54 = new QName("", "href");
    private static final QName TARGET$56 = new QName("", "target");
    private static final QName CLASS1$58 = new QName("", "class");
    private static final QName TITLE$60 = new QName("", Constants.TITLE);
    private static final QName ALT$62 = new QName("", "alt");
    private static final QName COORDSIZE$64 = new QName("", "coordsize");
    private static final QName COORDORIGIN$66 = new QName("", "coordorigin");
    private static final QName WRAPCOORDS$68 = new QName("", "wrapcoords");
    private static final QName PRINT$70 = new QName("", "print");
    private static final QName SPID$72 = new QName("urn:schemas-microsoft-com:office:office", "spid");
    private static final QName ONED$74 = new QName("urn:schemas-microsoft-com:office:office", "oned");
    private static final QName REGROUPID$76 = new QName("urn:schemas-microsoft-com:office:office", "regroupid");
    private static final QName DOUBLECLICKNOTIFY$78 = new QName("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
    private static final QName BUTTON$80 = new QName("urn:schemas-microsoft-com:office:office", "button");
    private static final QName USERHIDDEN$82 = new QName("urn:schemas-microsoft-com:office:office", "userhidden");
    private static final QName BULLET$84 = new QName("urn:schemas-microsoft-com:office:office", "bullet");
    private static final QName HR$86 = new QName("urn:schemas-microsoft-com:office:office", "hr");
    private static final QName HRSTD$88 = new QName("urn:schemas-microsoft-com:office:office", "hrstd");
    private static final QName HRNOSHADE$90 = new QName("urn:schemas-microsoft-com:office:office", "hrnoshade");
    private static final QName HRPCT$92 = new QName("urn:schemas-microsoft-com:office:office", "hrpct");
    private static final QName HRALIGN$94 = new QName("urn:schemas-microsoft-com:office:office", "hralign");
    private static final QName ALLOWINCELL$96 = new QName("urn:schemas-microsoft-com:office:office", "allowincell");
    private static final QName ALLOWOVERLAP$98 = new QName("urn:schemas-microsoft-com:office:office", "allowoverlap");
    private static final QName USERDRAWN$100 = new QName("urn:schemas-microsoft-com:office:office", "userdrawn");
    private static final QName BORDERTOPCOLOR$102 = new QName("urn:schemas-microsoft-com:office:office", "bordertopcolor");
    private static final QName BORDERLEFTCOLOR$104 = new QName("urn:schemas-microsoft-com:office:office", "borderleftcolor");
    private static final QName BORDERBOTTOMCOLOR$106 = new QName("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
    private static final QName BORDERRIGHTCOLOR$108 = new QName("urn:schemas-microsoft-com:office:office", "borderrightcolor");
    private static final QName DGMLAYOUT$110 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayout");
    private static final QName DGMNODEKIND$112 = new QName("urn:schemas-microsoft-com:office:office", "dgmnodekind");
    private static final QName DGMLAYOUTMRU$114 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
    private static final QName INSETMODE$116 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");
    private static final QName CHROMAKEY$118 = new QName("", "chromakey");
    private static final QName FILLED$120 = new QName("", "filled");
    private static final QName FILLCOLOR$122 = new QName("", "fillcolor");
    private static final QName OPACITY$124 = new QName("", "opacity");
    private static final QName STROKED$126 = new QName("", "stroked");
    private static final QName STROKECOLOR$128 = new QName("", "strokecolor");
    private static final QName STROKEWEIGHT$130 = new QName("", "strokeweight");
    private static final QName INSETPEN$132 = new QName("", "insetpen");
    private static final QName SPT$134 = new QName("urn:schemas-microsoft-com:office:office", "spt");
    private static final QName CONNECTORTYPE$136 = new QName("urn:schemas-microsoft-com:office:office", "connectortype");
    private static final QName BWMODE$138 = new QName("urn:schemas-microsoft-com:office:office", "bwmode");
    private static final QName BWPURE$140 = new QName("urn:schemas-microsoft-com:office:office", "bwpure");
    private static final QName BWNORMAL$142 = new QName("urn:schemas-microsoft-com:office:office", "bwnormal");
    private static final QName FORCEDASH$144 = new QName("urn:schemas-microsoft-com:office:office", "forcedash");
    private static final QName OLEICON$146 = new QName("urn:schemas-microsoft-com:office:office", "oleicon");
    private static final QName OLE$148 = new QName("urn:schemas-microsoft-com:office:office", "ole");
    private static final QName PREFERRELATIVE$150 = new QName("urn:schemas-microsoft-com:office:office", "preferrelative");
    private static final QName CLIPTOWRAP$152 = new QName("urn:schemas-microsoft-com:office:office", "cliptowrap");
    private static final QName CLIP$154 = new QName("urn:schemas-microsoft-com:office:office", "clip");
    private static final QName TYPE$156 = new QName("", "type");
    private static final QName ADJ$158 = new QName("", "adj");
    private static final QName PATH2$160 = new QName("", "path");
    private static final QName GFXDATA$162 = new QName("urn:schemas-microsoft-com:office:office", "gfxdata");
    private static final QName EQUATIONXML$164 = new QName("", "equationxml");

    public CTShapeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTAnchorLock addNewAnchorlock() {
        CTAnchorLock cTAnchorLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockAdd_element_user = get_store().add_element_user(ANCHORLOCK$32);
        }
        return cTAnchorLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTBorder addNewBorderbottom() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERBOTTOM$36);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTBorder addNewBorderleft() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERLEFT$38);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTBorder addNewBorderright() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERRIGHT$40);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTBorder addNewBordertop() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERTOP$34);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTCallout addNewCallout() {
        CTCallout cTCalloutAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutAdd_element_user = get_store().add_element_user(CALLOUT$22);
        }
        return cTCalloutAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTClientData addNewClientData() {
        CTClientData cTClientDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataAdd_element_user = get_store().add_element_user(CLIENTDATA$42);
        }
        return cTClientDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTClipPath addNewClippath() {
        CTClipPath cTClipPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathAdd_element_user = get_store().add_element_user(CLIPPATH$26);
        }
        return cTClipPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTExtrusion addNewExtrusion() {
        CTExtrusion cTExtrusionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionAdd_element_user = get_store().add_element_user(EXTRUSION$20);
        }
        return cTExtrusionAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTFill addNewFill() {
        CTFill cTFillAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillAdd_element_user = get_store().add_element_user(FILL$6);
        }
        return cTFillAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTFormulas addNewFormulas() {
        CTFormulas cTFormulasAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasAdd_element_user = get_store().add_element_user(FORMULAS$2);
        }
        return cTFormulasAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTHandles addNewHandles() {
        CTHandles cTHandlesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesAdd_element_user = get_store().add_element_user(HANDLES$4);
        }
        return cTHandlesAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTImageData addNewImagedata() {
        CTImageData cTImageDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataAdd_element_user = get_store().add_element_user(IMAGEDATA$16);
        }
        return cTImageDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTInk addNewInk() {
        CTInk cTInkAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInkAdd_element_user = get_store().add_element_user(INK$46);
        }
        return cTInkAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTEmpty addNewIscomment() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(ISCOMMENT$48);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTLock addNewLock() {
        CTLock cTLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockAdd_element_user = get_store().add_element_user(LOCK$24);
        }
        return cTLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTPath addNewPath() {
        CTPath cTPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathAdd_element_user = get_store().add_element_user(PATH$0);
        }
        return cTPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTShadow addNewShadow() {
        CTShadow cTShadowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowAdd_element_user = get_store().add_element_user(SHADOW$10);
        }
        return cTShadowAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTSignatureLine addNewSignatureline() {
        CTSignatureLine cTSignatureLineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineAdd_element_user = get_store().add_element_user(SIGNATURELINE$28);
        }
        return cTSignatureLineAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTSkew addNewSkew() {
        CTSkew cTSkewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewAdd_element_user = get_store().add_element_user(SKEW$18);
        }
        return cTSkewAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTStroke addNewStroke() {
        CTStroke cTStrokeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeAdd_element_user = get_store().add_element_user(STROKE$8);
        }
        return cTStrokeAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTTextbox addNewTextbox() {
        CTTextbox cTTextboxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxAdd_element_user = get_store().add_element_user(TEXTBOX$12);
        }
        return cTTextboxAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTRel addNewTextdata() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(TEXTDATA$44);
        }
        return cTRelAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTTextPath addNewTextpath() {
        CTTextPath cTTextPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathAdd_element_user = get_store().add_element_user(TEXTPATH$14);
        }
        return cTTextPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTWrap addNewWrap() {
        CTWrap cTWrapAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapAdd_element_user = get_store().add_element_user(WRAP$30);
        }
        return cTWrapAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getAdj() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ADJ$158);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$96);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$98);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getAlt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALT$62);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTAnchorLock> getAnchorlockList() {
        AbstractList<CTAnchorLock> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTAnchorLock>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1AnchorlockList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTAnchorLock cTAnchorLock) {
                    CTShapeImpl.this.insertNewAnchorlock(i).set(cTAnchorLock);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAnchorLock get(int i) {
                    return CTShapeImpl.this.getAnchorlockArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAnchorLock remove(int i) {
                    CTAnchorLock anchorlockArray = CTShapeImpl.this.getAnchorlockArray(i);
                    CTShapeImpl.this.removeAnchorlock(i);
                    return anchorlockArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAnchorLock set(int i, CTAnchorLock cTAnchorLock) {
                    CTAnchorLock anchorlockArray = CTShapeImpl.this.getAnchorlockArray(i);
                    CTShapeImpl.this.setAnchorlockArray(i, cTAnchorLock);
                    return anchorlockArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfAnchorlockArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTBorder> getBorderbottomList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1BorderbottomList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTShapeImpl.this.insertNewBorderbottom(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTShapeImpl.this.getBorderbottomArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder borderbottomArray = CTShapeImpl.this.getBorderbottomArray(i);
                    CTShapeImpl.this.removeBorderbottom(i);
                    return borderbottomArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder borderbottomArray = CTShapeImpl.this.getBorderbottomArray(i);
                    CTShapeImpl.this.setBorderbottomArray(i, cTBorder);
                    return borderbottomArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfBorderbottomArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$106);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTBorder> getBorderleftList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1BorderleftList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTShapeImpl.this.insertNewBorderleft(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTShapeImpl.this.getBorderleftArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder borderleftArray = CTShapeImpl.this.getBorderleftArray(i);
                    CTShapeImpl.this.removeBorderleft(i);
                    return borderleftArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder borderleftArray = CTShapeImpl.this.getBorderleftArray(i);
                    CTShapeImpl.this.setBorderleftArray(i, cTBorder);
                    return borderleftArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfBorderleftArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$104);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTBorder> getBorderrightList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1BorderrightList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTShapeImpl.this.insertNewBorderright(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTShapeImpl.this.getBorderrightArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder borderrightArray = CTShapeImpl.this.getBorderrightArray(i);
                    CTShapeImpl.this.removeBorderright(i);
                    return borderrightArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder borderrightArray = CTShapeImpl.this.getBorderrightArray(i);
                    CTShapeImpl.this.setBorderrightArray(i, cTBorder);
                    return borderrightArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfBorderrightArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$108);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTBorder> getBordertopList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1BordertopList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTShapeImpl.this.insertNewBordertop(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTShapeImpl.this.getBordertopArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder bordertopArray = CTShapeImpl.this.getBordertopArray(i);
                    CTShapeImpl.this.removeBordertop(i);
                    return bordertopArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder bordertopArray = CTShapeImpl.this.getBordertopArray(i);
                    CTShapeImpl.this.setBordertopArray(i, cTBorder);
                    return bordertopArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfBordertopArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$102);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getBullet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BULLET$84);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getButton() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BUTTON$80);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STBWMode.Enum getBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWMODE$138);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STBWMode.Enum getBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWNORMAL$142);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STBWMode.Enum getBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWPURE$140);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTCallout> getCalloutList() {
        AbstractList<CTCallout> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTCallout>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1CalloutList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTCallout cTCallout) {
                    CTShapeImpl.this.insertNewCallout(i).set(cTCallout);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCallout get(int i) {
                    return CTShapeImpl.this.getCalloutArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCallout remove(int i) {
                    CTCallout calloutArray = CTShapeImpl.this.getCalloutArray(i);
                    CTShapeImpl.this.removeCallout(i);
                    return calloutArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCallout set(int i, CTCallout cTCallout) {
                    CTCallout calloutArray = CTShapeImpl.this.getCalloutArray(i);
                    CTShapeImpl.this.setCalloutArray(i, cTCallout);
                    return calloutArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfCalloutArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CHROMAKEY$118);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getClass1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLASS1$58);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTClientData> getClientDataList() {
        AbstractList<CTClientData> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTClientData>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1ClientDataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTClientData cTClientData) {
                    CTShapeImpl.this.insertNewClientData(i).set(cTClientData);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData get(int i) {
                    return CTShapeImpl.this.getClientDataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData remove(int i) {
                    CTClientData clientDataArray = CTShapeImpl.this.getClientDataArray(i);
                    CTShapeImpl.this.removeClientData(i);
                    return clientDataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData set(int i, CTClientData cTClientData) {
                    CTClientData clientDataArray = CTShapeImpl.this.getClientDataArray(i);
                    CTShapeImpl.this.setClientDataArray(i, cTClientData);
                    return clientDataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfClientDataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getClip() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLIP$154);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTClipPath> getClippathList() {
        AbstractList<CTClipPath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTClipPath>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1ClippathList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTClipPath cTClipPath) {
                    CTShapeImpl.this.insertNewClippath(i).set(cTClipPath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClipPath get(int i) {
                    return CTShapeImpl.this.getClippathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClipPath remove(int i) {
                    CTClipPath clippathArray = CTShapeImpl.this.getClippathArray(i);
                    CTShapeImpl.this.removeClippath(i);
                    return clippathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClipPath set(int i, CTClipPath cTClipPath) {
                    CTClipPath clippathArray = CTShapeImpl.this.getClippathArray(i);
                    CTShapeImpl.this.setClippathArray(i, cTClipPath);
                    return clippathArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfClippathArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$152);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STConnectorType.Enum getConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$136;
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

    @Override // com.microsoft.schemas.vml.CTShape
    public String getCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$66);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDSIZE$64);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public BigInteger getDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$110);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public BigInteger getDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$114);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public BigInteger getDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$112);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$78);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getEquationxml() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EQUATIONXML$164);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTExtrusion> getExtrusionList() {
        AbstractList<CTExtrusion> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTExtrusion>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1ExtrusionList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTExtrusion cTExtrusion) {
                    CTShapeImpl.this.insertNewExtrusion(i).set(cTExtrusion);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtrusion get(int i) {
                    return CTShapeImpl.this.getExtrusionArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtrusion remove(int i) {
                    CTExtrusion extrusionArray = CTShapeImpl.this.getExtrusionArray(i);
                    CTShapeImpl.this.removeExtrusion(i);
                    return extrusionArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtrusion set(int i, CTExtrusion cTExtrusion) {
                    CTExtrusion extrusionArray = CTShapeImpl.this.getExtrusionArray(i);
                    CTShapeImpl.this.setExtrusionArray(i, cTExtrusion);
                    return extrusionArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfExtrusionArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTFill> getFillList() {
        AbstractList<CTFill> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFill>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1FillList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFill cTFill) {
                    CTShapeImpl.this.insertNewFill(i).set(cTFill);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFill get(int i) {
                    return CTShapeImpl.this.getFillArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFill remove(int i) {
                    CTFill fillArray = CTShapeImpl.this.getFillArray(i);
                    CTShapeImpl.this.removeFill(i);
                    return fillArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFill set(int i, CTFill cTFill) {
                    CTFill fillArray = CTShapeImpl.this.getFillArray(i);
                    CTShapeImpl.this.setFillArray(i, cTFill);
                    return fillArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfFillArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$122);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public com.microsoft.schemas.vml.STTrueFalse.Enum getFilled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLED$120);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FORCEDASH$144);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTFormulas> getFormulasList() {
        AbstractList<CTFormulas> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFormulas>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1FormulasList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFormulas cTFormulas) {
                    CTShapeImpl.this.insertNewFormulas(i).set(cTFormulas);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFormulas get(int i) {
                    return CTShapeImpl.this.getFormulasArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFormulas remove(int i) {
                    CTFormulas formulasArray = CTShapeImpl.this.getFormulasArray(i);
                    CTShapeImpl.this.removeFormulas(i);
                    return formulasArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFormulas set(int i, CTFormulas cTFormulas) {
                    CTFormulas formulasArray = CTShapeImpl.this.getFormulasArray(i);
                    CTShapeImpl.this.setFormulasArray(i, cTFormulas);
                    return formulasArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfFormulasArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public byte[] getGfxdata() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(GFXDATA$162);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTHandles> getHandlesList() {
        AbstractList<CTHandles> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTHandles>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1HandlesList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTHandles cTHandles) {
                    CTShapeImpl.this.insertNewHandles(i).set(cTHandles);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTHandles get(int i) {
                    return CTShapeImpl.this.getHandlesArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTHandles remove(int i) {
                    CTHandles handlesArray = CTShapeImpl.this.getHandlesArray(i);
                    CTShapeImpl.this.removeHandles(i);
                    return handlesArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTHandles set(int i, CTHandles cTHandles) {
                    CTHandles handlesArray = CTShapeImpl.this.getHandlesArray(i);
                    CTShapeImpl.this.setHandlesArray(i, cTHandles);
                    return handlesArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfHandlesArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getHr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HR$86);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STHrAlign.Enum getHralign() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$94;
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

    @Override // com.microsoft.schemas.vml.CTShape
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HREF$54);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$90);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public float getHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRPCT$92);
            if (simpleValueFind_attribute_user == null) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            return simpleValueFind_attribute_user.getFloatValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRSTD$88);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$50);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTImageData> getImagedataList() {
        AbstractList<CTImageData> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTImageData>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1ImagedataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTImageData cTImageData) {
                    CTShapeImpl.this.insertNewImagedata(i).set(cTImageData);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTImageData get(int i) {
                    return CTShapeImpl.this.getImagedataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTImageData remove(int i) {
                    CTImageData imagedataArray = CTShapeImpl.this.getImagedataArray(i);
                    CTShapeImpl.this.removeImagedata(i);
                    return imagedataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTImageData set(int i, CTImageData cTImageData) {
                    CTImageData imagedataArray = CTShapeImpl.this.getImagedataArray(i);
                    CTShapeImpl.this.setImagedataArray(i, cTImageData);
                    return imagedataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfImagedataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTInk getInkArray(int i) {
        CTInk cTInkFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInkFind_element_user = get_store().find_element_user(INK$46, i);
            if (cTInkFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTInkFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    @Deprecated
    public CTInk[] getInkArray() {
        CTInk[] cTInkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INK$46, arrayList);
            cTInkArr = new CTInk[arrayList.size()];
            arrayList.toArray(cTInkArr);
        }
        return cTInkArr;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTInk> getInkList() {
        AbstractList<CTInk> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTInk>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1InkList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTInk cTInk) {
                    CTShapeImpl.this.insertNewInk(i).set(cTInk);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTInk get(int i) {
                    return CTShapeImpl.this.getInkArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTInk remove(int i) {
                    CTInk inkArray = CTShapeImpl.this.getInkArray(i);
                    CTShapeImpl.this.removeInk(i);
                    return inkArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTInk set(int i, CTInk cTInk) {
                    CTInk inkArray = CTShapeImpl.this.getInkArray(i);
                    CTShapeImpl.this.setInkArray(i, cTInk);
                    return inkArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfInkArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$116;
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

    @Override // com.microsoft.schemas.vml.CTShape
    public com.microsoft.schemas.vml.STTrueFalse.Enum getInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(INSETPEN$132);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTEmpty getIscommentArray(int i) {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(ISCOMMENT$48, i);
            if (cTEmptyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    @Deprecated
    public CTEmpty[] getIscommentArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ISCOMMENT$48, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTEmpty> getIscommentList() {
        AbstractList<CTEmpty> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTEmpty>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1IscommentList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTEmpty cTEmpty) {
                    CTShapeImpl.this.insertNewIscomment(i).set(cTEmpty);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTEmpty get(int i) {
                    return CTShapeImpl.this.getIscommentArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTEmpty remove(int i) {
                    CTEmpty iscommentArray = CTShapeImpl.this.getIscommentArray(i);
                    CTShapeImpl.this.removeIscomment(i);
                    return iscommentArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTEmpty set(int i, CTEmpty cTEmpty) {
                    CTEmpty iscommentArray = CTShapeImpl.this.getIscommentArray(i);
                    CTShapeImpl.this.setIscommentArray(i, cTEmpty);
                    return iscommentArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfIscommentArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTLock> getLockList() {
        AbstractList<CTLock> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTLock>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1LockList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTLock cTLock) {
                    CTShapeImpl.this.insertNewLock(i).set(cTLock);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLock get(int i) {
                    return CTShapeImpl.this.getLockArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLock remove(int i) {
                    CTLock lockArray = CTShapeImpl.this.getLockArray(i);
                    CTShapeImpl.this.removeLock(i);
                    return lockArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLock set(int i, CTLock cTLock) {
                    CTLock lockArray = CTShapeImpl.this.getLockArray(i);
                    CTShapeImpl.this.setLockArray(i, cTLock);
                    return lockArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfLockArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalseBlank.Enum getOle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OLE$148);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OLEICON$146);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getOned() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ONED$74);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OPACITY$124);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getPath2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PATH2$160);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTPath> getPathList() {
        AbstractList<CTPath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPath>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1PathList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPath cTPath) {
                    CTShapeImpl.this.insertNewPath(i).set(cTPath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath get(int i) {
                    return CTShapeImpl.this.getPathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath remove(int i) {
                    CTPath pathArray = CTShapeImpl.this.getPathArray(i);
                    CTShapeImpl.this.removePath(i);
                    return pathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath set(int i, CTPath cTPath) {
                    CTPath pathArray = CTShapeImpl.this.getPathArray(i);
                    CTShapeImpl.this.setPathArray(i, cTPath);
                    return pathArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfPathArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$150);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public com.microsoft.schemas.vml.STTrueFalse.Enum getPrint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PRINT$70);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public BigInteger getRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REGROUPID$76);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTShadow> getShadowList() {
        AbstractList<CTShadow> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTShadow>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1ShadowList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTShadow cTShadow) {
                    CTShapeImpl.this.insertNewShadow(i).set(cTShadow);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTShadow get(int i) {
                    return CTShapeImpl.this.getShadowArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTShadow remove(int i) {
                    CTShadow shadowArray = CTShapeImpl.this.getShadowArray(i);
                    CTShapeImpl.this.removeShadow(i);
                    return shadowArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTShadow set(int i, CTShadow cTShadow) {
                    CTShadow shadowArray = CTShapeImpl.this.getShadowArray(i);
                    CTShapeImpl.this.setShadowArray(i, cTShadow);
                    return shadowArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfShadowArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTSignatureLine> getSignaturelineList() {
        AbstractList<CTSignatureLine> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSignatureLine>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1SignaturelineList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSignatureLine cTSignatureLine) {
                    CTShapeImpl.this.insertNewSignatureline(i).set(cTSignatureLine);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSignatureLine get(int i) {
                    return CTShapeImpl.this.getSignaturelineArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSignatureLine remove(int i) {
                    CTSignatureLine signaturelineArray = CTShapeImpl.this.getSignaturelineArray(i);
                    CTShapeImpl.this.removeSignatureline(i);
                    return signaturelineArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSignatureLine set(int i, CTSignatureLine cTSignatureLine) {
                    CTSignatureLine signaturelineArray = CTShapeImpl.this.getSignaturelineArray(i);
                    CTShapeImpl.this.setSignaturelineArray(i, cTSignatureLine);
                    return signaturelineArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfSignaturelineArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTSkew> getSkewList() {
        AbstractList<CTSkew> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSkew>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1SkewList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSkew cTSkew) {
                    CTShapeImpl.this.insertNewSkew(i).set(cTSkew);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSkew get(int i) {
                    return CTShapeImpl.this.getSkewArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSkew remove(int i) {
                    CTSkew skewArray = CTShapeImpl.this.getSkewArray(i);
                    CTShapeImpl.this.removeSkew(i);
                    return skewArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSkew set(int i, CTSkew cTSkew) {
                    CTSkew skewArray = CTShapeImpl.this.getSkewArray(i);
                    CTShapeImpl.this.setSkewArray(i, cTSkew);
                    return skewArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfSkewArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getSpid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPID$72);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public float getSpt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPT$134);
            if (simpleValueFind_attribute_user == null) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            return simpleValueFind_attribute_user.getFloatValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTStroke> getStrokeList() {
        AbstractList<CTStroke> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTStroke>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1StrokeList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTStroke cTStroke) {
                    CTShapeImpl.this.insertNewStroke(i).set(cTStroke);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTStroke get(int i) {
                    return CTShapeImpl.this.getStrokeArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTStroke remove(int i) {
                    CTStroke strokeArray = CTShapeImpl.this.getStrokeArray(i);
                    CTShapeImpl.this.removeStroke(i);
                    return strokeArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTStroke set(int i, CTStroke cTStroke) {
                    CTStroke strokeArray = CTShapeImpl.this.getStrokeArray(i);
                    CTShapeImpl.this.setStrokeArray(i, cTStroke);
                    return strokeArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfStrokeArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKECOLOR$128);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public com.microsoft.schemas.vml.STTrueFalse.Enum getStroked() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKED$126);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKEWEIGHT$130);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STYLE$52);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TARGET$56);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTTextbox> getTextboxList() {
        AbstractList<CTTextbox> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTextbox>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1TextboxList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTextbox cTTextbox) {
                    CTShapeImpl.this.insertNewTextbox(i).set(cTTextbox);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextbox get(int i) {
                    return CTShapeImpl.this.getTextboxArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextbox remove(int i) {
                    CTTextbox textboxArray = CTShapeImpl.this.getTextboxArray(i);
                    CTShapeImpl.this.removeTextbox(i);
                    return textboxArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextbox set(int i, CTTextbox cTTextbox) {
                    CTTextbox textboxArray = CTShapeImpl.this.getTextboxArray(i);
                    CTShapeImpl.this.setTextboxArray(i, cTTextbox);
                    return textboxArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfTextboxArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTRel> getTextdataList() {
        AbstractList<CTRel> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRel>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1TextdataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRel cTRel) {
                    CTShapeImpl.this.insertNewTextdata(i).set(cTRel);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRel get(int i) {
                    return CTShapeImpl.this.getTextdataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRel remove(int i) {
                    CTRel textdataArray = CTShapeImpl.this.getTextdataArray(i);
                    CTShapeImpl.this.removeTextdata(i);
                    return textdataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRel set(int i, CTRel cTRel) {
                    CTRel textdataArray = CTShapeImpl.this.getTextdataArray(i);
                    CTShapeImpl.this.setTextdataArray(i, cTRel);
                    return textdataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfTextdataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTTextPath> getTextpathList() {
        AbstractList<CTTextPath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTextPath>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1TextpathList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTextPath cTTextPath) {
                    CTShapeImpl.this.insertNewTextpath(i).set(cTTextPath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextPath get(int i) {
                    return CTShapeImpl.this.getTextpathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextPath remove(int i) {
                    CTTextPath textpathArray = CTShapeImpl.this.getTextpathArray(i);
                    CTShapeImpl.this.removeTextpath(i);
                    return textpathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextPath set(int i, CTTextPath cTTextPath) {
                    CTTextPath textpathArray = CTShapeImpl.this.getTextpathArray(i);
                    CTShapeImpl.this.setTextpathArray(i, cTTextPath);
                    return textpathArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfTextpathArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TITLE$60);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$156);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERDRAWN$100);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse.Enum getUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$82);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
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

    @Override // com.microsoft.schemas.vml.CTShape
    public List<CTWrap> getWrapList() {
        AbstractList<CTWrap> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTWrap>() { // from class: com.microsoft.schemas.vml.impl.CTShapeImpl.1WrapList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTWrap cTWrap) {
                    CTShapeImpl.this.insertNewWrap(i).set(cTWrap);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTWrap get(int i) {
                    return CTShapeImpl.this.getWrapArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTWrap remove(int i) {
                    CTWrap wrapArray = CTShapeImpl.this.getWrapArray(i);
                    CTShapeImpl.this.removeWrap(i);
                    return wrapArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTWrap set(int i, CTWrap cTWrap) {
                    CTWrap wrapArray = CTShapeImpl.this.getWrapArray(i);
                    CTShapeImpl.this.setWrapArray(i, cTWrap);
                    return wrapArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfWrapArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public String getWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$68);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTAnchorLock insertNewAnchorlock(int i) {
        CTAnchorLock cTAnchorLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockInsert_element_user = get_store().insert_element_user(ANCHORLOCK$32, i);
        }
        return cTAnchorLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTBorder insertNewBorderbottom(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERBOTTOM$36, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTBorder insertNewBorderleft(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERLEFT$38, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTBorder insertNewBorderright(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERRIGHT$40, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTBorder insertNewBordertop(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERTOP$34, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTCallout insertNewCallout(int i) {
        CTCallout cTCalloutInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutInsert_element_user = get_store().insert_element_user(CALLOUT$22, i);
        }
        return cTCalloutInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTClientData insertNewClientData(int i) {
        CTClientData cTClientDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataInsert_element_user = get_store().insert_element_user(CLIENTDATA$42, i);
        }
        return cTClientDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTClipPath insertNewClippath(int i) {
        CTClipPath cTClipPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathInsert_element_user = get_store().insert_element_user(CLIPPATH$26, i);
        }
        return cTClipPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTExtrusion insertNewExtrusion(int i) {
        CTExtrusion cTExtrusionInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionInsert_element_user = get_store().insert_element_user(EXTRUSION$20, i);
        }
        return cTExtrusionInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTFill insertNewFill(int i) {
        CTFill cTFillInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillInsert_element_user = get_store().insert_element_user(FILL$6, i);
        }
        return cTFillInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTFormulas insertNewFormulas(int i) {
        CTFormulas cTFormulasInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasInsert_element_user = get_store().insert_element_user(FORMULAS$2, i);
        }
        return cTFormulasInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTHandles insertNewHandles(int i) {
        CTHandles cTHandlesInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesInsert_element_user = get_store().insert_element_user(HANDLES$4, i);
        }
        return cTHandlesInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTImageData insertNewImagedata(int i) {
        CTImageData cTImageDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataInsert_element_user = get_store().insert_element_user(IMAGEDATA$16, i);
        }
        return cTImageDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTInk insertNewInk(int i) {
        CTInk cTInkInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInkInsert_element_user = get_store().insert_element_user(INK$46, i);
        }
        return cTInkInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTEmpty insertNewIscomment(int i) {
        CTEmpty cTEmptyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyInsert_element_user = get_store().insert_element_user(ISCOMMENT$48, i);
        }
        return cTEmptyInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTLock insertNewLock(int i) {
        CTLock cTLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockInsert_element_user = get_store().insert_element_user(LOCK$24, i);
        }
        return cTLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTPath insertNewPath(int i) {
        CTPath cTPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathInsert_element_user = get_store().insert_element_user(PATH$0, i);
        }
        return cTPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTShadow insertNewShadow(int i) {
        CTShadow cTShadowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowInsert_element_user = get_store().insert_element_user(SHADOW$10, i);
        }
        return cTShadowInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTSignatureLine insertNewSignatureline(int i) {
        CTSignatureLine cTSignatureLineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineInsert_element_user = get_store().insert_element_user(SIGNATURELINE$28, i);
        }
        return cTSignatureLineInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTSkew insertNewSkew(int i) {
        CTSkew cTSkewInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewInsert_element_user = get_store().insert_element_user(SKEW$18, i);
        }
        return cTSkewInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTStroke insertNewStroke(int i) {
        CTStroke cTStrokeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeInsert_element_user = get_store().insert_element_user(STROKE$8, i);
        }
        return cTStrokeInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTTextbox insertNewTextbox(int i) {
        CTTextbox cTTextboxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxInsert_element_user = get_store().insert_element_user(TEXTBOX$12, i);
        }
        return cTTextboxInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTRel insertNewTextdata(int i) {
        CTRel cTRelInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelInsert_element_user = get_store().insert_element_user(TEXTDATA$44, i);
        }
        return cTRelInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTTextPath insertNewTextpath(int i) {
        CTTextPath cTTextPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathInsert_element_user = get_store().insert_element_user(TEXTPATH$14, i);
        }
        return cTTextPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public CTWrap insertNewWrap(int i) {
        CTWrap cTWrapInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapInsert_element_user = get_store().insert_element_user(WRAP$30, i);
        }
        return cTWrapInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetAdj() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ADJ$158) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetAllowincell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWINCELL$96) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetAllowoverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWOVERLAP$98) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetAlt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALT$62) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetBorderbottomcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERBOTTOMCOLOR$106) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetBorderleftcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERLEFTCOLOR$104) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetBorderrightcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERRIGHTCOLOR$108) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetBordertopcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERTOPCOLOR$102) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetBullet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BULLET$84) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetButton() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BUTTON$80) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetBwmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWMODE$138) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetBwnormal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWNORMAL$142) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetBwpure() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWPURE$140) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetChromakey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CHROMAKEY$118) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetClass1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLASS1$58) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetClip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIP$154) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetCliptowrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIPTOWRAP$152) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetConnectortype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTORTYPE$136) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetCoordorigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDORIGIN$66) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetCoordsize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDSIZE$64) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetDgmlayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUT$110) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetDgmlayoutmru() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUTMRU$114) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetDgmnodekind() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMNODEKIND$112) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetDoubleclicknotify() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DOUBLECLICKNOTIFY$78) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetEquationxml() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EQUATIONXML$164) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetFillcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLCOLOR$122) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetFilled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLED$120) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetForcedash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORCEDASH$144) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetGfxdata() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(GFXDATA$162) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetHr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HR$86) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetHralign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRALIGN$94) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$54) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetHrnoshade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRNOSHADE$90) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetHrpct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRPCT$92) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetHrstd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRSTD$88) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$50) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$116) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetInsetpen() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETPEN$132) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetOle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLE$148) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetOleicon() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLEICON$146) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetOned() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ONED$74) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$124) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetPath2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PATH2$160) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetPreferrelative() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PREFERRELATIVE$150) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetPrint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRINT$70) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetRegroupid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REGROUPID$76) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetSpid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPID$72) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetSpt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPT$134) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetStrokecolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKECOLOR$128) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetStroked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKED$126) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetStrokeweight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKEWEIGHT$130) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$52) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$56) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$60) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$156) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetUserdrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$100) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetUserhidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERHIDDEN$82) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public boolean isSetWrapcoords() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WRAPCOORDS$68) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeAnchorlock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHORLOCK$32, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeBorderbottom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOTTOM$36, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeBorderleft(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERLEFT$38, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeBorderright(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERRIGHT$40, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeBordertop(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERTOP$34, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeCallout(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALLOUT$22, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeClientData(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIENTDATA$42, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeClippath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIPPATH$26, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeExtrusion(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTRUSION$20, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$6, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeFormulas(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULAS$2, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeHandles(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HANDLES$4, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeImagedata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGEDATA$16, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeInk(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INK$46, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeIscomment(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ISCOMMENT$48, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$24, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removePath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$0, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$10, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeSignatureline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATURELINE$28, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeSkew(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SKEW$18, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeStroke(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STROKE$8, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeTextbox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOX$12, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeTextdata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDATA$44, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeTextpath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTPATH$14, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void removeWrap(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAP$30, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setAdj(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$158;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setAllowincell(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$96;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setAllowoverlap(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$98;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setAlt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$62;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setAnchorlockArray(int i, CTAnchorLock cTAnchorLock) {
        generatedSetterHelperImpl(cTAnchorLock, ANCHORLOCK$32, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr) {
        check_orphaned();
        arraySetterHelper(cTAnchorLockArr, ANCHORLOCK$32);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBorderbottomArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERBOTTOM$36, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBorderbottomArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERBOTTOM$36);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBorderbottomcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$106;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBorderleftArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERLEFT$38, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBorderleftArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERLEFT$38);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBorderleftcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$104;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBorderrightArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERRIGHT$40, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBorderrightArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERRIGHT$40);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBorderrightcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$108;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBordertopArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERTOP$34, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBordertopArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERTOP$34);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBordertopcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$102;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBullet(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$84;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setButton(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$80;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBwmode(STBWMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$138;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBwnormal(STBWMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$142;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setBwpure(STBWMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$140;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setCalloutArray(int i, CTCallout cTCallout) {
        generatedSetterHelperImpl(cTCallout, CALLOUT$22, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setCalloutArray(CTCallout[] cTCalloutArr) {
        check_orphaned();
        arraySetterHelper(cTCalloutArr, CALLOUT$22);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setChromakey(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$118;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setClass1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$58;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setClientDataArray(int i, CTClientData cTClientData) {
        generatedSetterHelperImpl(cTClientData, CLIENTDATA$42, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setClientDataArray(CTClientData[] cTClientDataArr) {
        check_orphaned();
        arraySetterHelper(cTClientDataArr, CLIENTDATA$42);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setClip(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$154;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setClippathArray(int i, CTClipPath cTClipPath) {
        generatedSetterHelperImpl(cTClipPath, CLIPPATH$26, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setClippathArray(CTClipPath[] cTClipPathArr) {
        check_orphaned();
        arraySetterHelper(cTClipPathArr, CLIPPATH$26);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setCliptowrap(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$152;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setConnectortype(STConnectorType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$136;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setCoordorigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$66;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setCoordsize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$64;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setDgmlayout(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$110;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setDgmlayoutmru(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$114;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setDgmnodekind(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$112;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setDoubleclicknotify(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$78;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setEquationxml(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQUATIONXML$164;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setExtrusionArray(int i, CTExtrusion cTExtrusion) {
        generatedSetterHelperImpl(cTExtrusion, EXTRUSION$20, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setExtrusionArray(CTExtrusion[] cTExtrusionArr) {
        check_orphaned();
        arraySetterHelper(cTExtrusionArr, EXTRUSION$20);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setFillArray(int i, CTFill cTFill) {
        generatedSetterHelperImpl(cTFill, FILL$6, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setFillArray(CTFill[] cTFillArr) {
        check_orphaned();
        arraySetterHelper(cTFillArr, FILL$6);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setFillcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$122;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setFilled(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$120;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setForcedash(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$144;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setFormulasArray(int i, CTFormulas cTFormulas) {
        generatedSetterHelperImpl(cTFormulas, FORMULAS$2, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setFormulasArray(CTFormulas[] cTFormulasArr) {
        check_orphaned();
        arraySetterHelper(cTFormulasArr, FORMULAS$2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setGfxdata(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GFXDATA$162;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setHandlesArray(int i, CTHandles cTHandles) {
        generatedSetterHelperImpl(cTHandles, HANDLES$4, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setHandlesArray(CTHandles[] cTHandlesArr) {
        check_orphaned();
        arraySetterHelper(cTHandlesArr, HANDLES$4);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setHr(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$86;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setHralign(STHrAlign.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$94;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$54;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setHrnoshade(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$90;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setHrpct(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$92;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setFloatValue(f);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setHrstd(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$88;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setImagedataArray(int i, CTImageData cTImageData) {
        generatedSetterHelperImpl(cTImageData, IMAGEDATA$16, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setImagedataArray(CTImageData[] cTImageDataArr) {
        check_orphaned();
        arraySetterHelper(cTImageDataArr, IMAGEDATA$16);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setInkArray(int i, CTInk cTInk) {
        generatedSetterHelperImpl(cTInk, INK$46, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setInkArray(CTInk[] cTInkArr) {
        check_orphaned();
        arraySetterHelper(cTInkArr, INK$46);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$116;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setInsetpen(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$132;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setIscommentArray(int i, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, ISCOMMENT$48, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setIscommentArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, ISCOMMENT$48);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setLockArray(int i, CTLock cTLock) {
        generatedSetterHelperImpl(cTLock, LOCK$24, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setLockArray(CTLock[] cTLockArr) {
        check_orphaned();
        arraySetterHelper(cTLockArr, LOCK$24);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setOle(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$148;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setOleicon(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$146;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setOned(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$74;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setOpacity(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$124;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setPath2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$160;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setPathArray(int i, CTPath cTPath) {
        generatedSetterHelperImpl(cTPath, PATH$0, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setPathArray(CTPath[] cTPathArr) {
        check_orphaned();
        arraySetterHelper(cTPathArr, PATH$0);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setPreferrelative(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$150;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setPrint(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$70;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setRegroupid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$76;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setShadowArray(int i, CTShadow cTShadow) {
        generatedSetterHelperImpl(cTShadow, SHADOW$10, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setShadowArray(CTShadow[] cTShadowArr) {
        check_orphaned();
        arraySetterHelper(cTShadowArr, SHADOW$10);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setSignaturelineArray(int i, CTSignatureLine cTSignatureLine) {
        generatedSetterHelperImpl(cTSignatureLine, SIGNATURELINE$28, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr) {
        check_orphaned();
        arraySetterHelper(cTSignatureLineArr, SIGNATURELINE$28);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setSkewArray(int i, CTSkew cTSkew) {
        generatedSetterHelperImpl(cTSkew, SKEW$18, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setSkewArray(CTSkew[] cTSkewArr) {
        check_orphaned();
        arraySetterHelper(cTSkewArr, SKEW$18);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setSpid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$72;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setSpt(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$134;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setFloatValue(f);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setStrokeArray(int i, CTStroke cTStroke) {
        generatedSetterHelperImpl(cTStroke, STROKE$8, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setStrokeArray(CTStroke[] cTStrokeArr) {
        check_orphaned();
        arraySetterHelper(cTStrokeArr, STROKE$8);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setStrokecolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$128;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setStroked(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$126;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setStrokeweight(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$130;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$52;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$56;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setTextboxArray(int i, CTTextbox cTTextbox) {
        generatedSetterHelperImpl(cTTextbox, TEXTBOX$12, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setTextboxArray(CTTextbox[] cTTextboxArr) {
        check_orphaned();
        arraySetterHelper(cTTextboxArr, TEXTBOX$12);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setTextdataArray(int i, CTRel cTRel) {
        generatedSetterHelperImpl(cTRel, TEXTDATA$44, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setTextdataArray(CTRel[] cTRelArr) {
        check_orphaned();
        arraySetterHelper(cTRelArr, TEXTDATA$44);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setTextpathArray(int i, CTTextPath cTTextPath) {
        generatedSetterHelperImpl(cTTextPath, TEXTPATH$14, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setTextpathArray(CTTextPath[] cTTextPathArr) {
        check_orphaned();
        arraySetterHelper(cTTextPathArr, TEXTPATH$14);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$60;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setType(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$156;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setUserdrawn(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$100;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setUserhidden(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$82;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setWrapArray(int i, CTWrap cTWrap) {
        generatedSetterHelperImpl(cTWrap, WRAP$30, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setWrapArray(CTWrap[] cTWrapArr) {
        check_orphaned();
        arraySetterHelper(cTWrapArr, WRAP$30);
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void setWrapcoords(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$68;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfAnchorlockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANCHORLOCK$32);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfBorderbottomArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERBOTTOM$36);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfBorderleftArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERLEFT$38);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfBorderrightArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERRIGHT$40);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfBordertopArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERTOP$34);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfCalloutArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CALLOUT$22);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfClientDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIENTDATA$42);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfClippathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIPPATH$26);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfExtrusionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXTRUSION$20);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FILL$6);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfFormulasArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FORMULAS$2);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfHandlesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HANDLES$4);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfImagedataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(IMAGEDATA$16);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfInkArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INK$46);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfIscommentArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ISCOMMENT$48);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfLockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LOCK$24);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfPathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PATH$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfShadowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHADOW$10);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfSignaturelineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SIGNATURELINE$28);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfSkewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SKEW$18);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfStrokeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(STROKE$8);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfTextboxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTBOX$12);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfTextdataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTDATA$44);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfTextpathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTPATH$14);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public int sizeOfWrapArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(WRAP$30);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetAdj() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ADJ$158);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWINCELL$96);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWOVERLAP$98);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetAlt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALT$62);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERBOTTOMCOLOR$106);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERLEFTCOLOR$104);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERRIGHTCOLOR$108);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERTOPCOLOR$102);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetBullet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BULLET$84);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BUTTON$80);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWMODE$138);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWNORMAL$142);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWPURE$140);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CHROMAKEY$118);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetClass1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLASS1$58);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetClip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIP$154);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIPTOWRAP$152);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTORTYPE$136);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDORIGIN$66);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDSIZE$64);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUT$110);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUTMRU$114);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMNODEKIND$112);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DOUBLECLICKNOTIFY$78);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetEquationxml() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EQUATIONXML$164);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLCOLOR$122);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetFilled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLED$120);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORCEDASH$144);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetGfxdata() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(GFXDATA$162);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetHr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HR$86);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetHralign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRALIGN$94);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$54);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRNOSHADE$90);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRPCT$92);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRSTD$88);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$50);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$116);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETPEN$132);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetOle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLE$148);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLEICON$146);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetOned() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ONED$74);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$124);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetPath2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PATH2$160);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PREFERRELATIVE$150);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetPrint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRINT$70);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REGROUPID$76);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetSpid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPID$72);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetSpt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPT$134);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKECOLOR$128);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetStroked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKED$126);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKEWEIGHT$130);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$52);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$56);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$60);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$156);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$100);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERHIDDEN$82);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void unsetWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WRAPCOORDS$68);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetAdj() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ADJ$158);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetAllowincell() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$96);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetAllowoverlap() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$98);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetAlt() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ALT$62);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetBorderbottomcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$106);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetBorderleftcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$104);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetBorderrightcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$108);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetBordertopcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$102);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetBullet() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BULLET$84);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetButton() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BUTTON$80);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STBWMode xgetBwmode() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWMODE$138);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STBWMode xgetBwnormal() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWNORMAL$142);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STBWMode xgetBwpure() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWPURE$140);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STColorType xgetChromakey() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(CHROMAKEY$118);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetClass1() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(CLASS1$58);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetClip() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(CLIP$154);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetCliptowrap() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$152);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STConnectorType xgetConnectortype() {
        STConnectorType sTConnectorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$136;
            sTConnectorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTConnectorTypeFind_attribute_user == null) {
                sTConnectorTypeFind_attribute_user = (STConnectorType) get_default_attribute_value(qName);
            }
        }
        return sTConnectorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetCoordorigin() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$66);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetCoordsize() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDSIZE$64);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlInteger xgetDgmlayout() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$110);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlInteger xgetDgmlayoutmru() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$114);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlInteger xgetDgmnodekind() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$112);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetDoubleclicknotify() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$78);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetEquationxml() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(EQUATIONXML$164);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STColorType xgetFillcolor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$122);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public com.microsoft.schemas.vml.STTrueFalse xgetFilled() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FILLED$120);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetForcedash() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FORCEDASH$144);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlBase64Binary xgetGfxdata() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(GFXDATA$162);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetHr() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HR$86);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STHrAlign xgetHralign() {
        STHrAlign sTHrAlignFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$94;
            sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_default_attribute_value(qName);
            }
        }
        return sTHrAlignFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetHref() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(HREF$54);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetHrnoshade() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$90);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlFloat xgetHrpct() {
        XmlFloat xmlFloatFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_attribute_user = get_store().find_attribute_user(HRPCT$92);
        }
        return xmlFloatFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetHrstd() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRSTD$88);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetId() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ID$50);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$116;
            sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_default_attribute_value(qName);
            }
        }
        return sTInsetModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public com.microsoft.schemas.vml.STTrueFalse xgetInsetpen() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(INSETPEN$132);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalseBlank xgetOle() {
        STTrueFalseBlank sTTrueFalseBlankFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlankFind_attribute_user = get_store().find_attribute_user(OLE$148);
        }
        return sTTrueFalseBlankFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetOleicon() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(OLEICON$146);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetOned() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ONED$74);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetOpacity() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(OPACITY$124);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetPath2() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(PATH2$160);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetPreferrelative() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$150);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public com.microsoft.schemas.vml.STTrueFalse xgetPrint() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(PRINT$70);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlInteger xgetRegroupid() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(REGROUPID$76);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetSpid() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(SPID$72);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlFloat xgetSpt() {
        XmlFloat xmlFloatFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_attribute_user = get_store().find_attribute_user(SPT$134);
        }
        return xmlFloatFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STColorType xgetStrokecolor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(STROKECOLOR$128);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public com.microsoft.schemas.vml.STTrueFalse xgetStroked() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(STROKED$126);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetStrokeweight() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STROKEWEIGHT$130);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetStyle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STYLE$52);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetTarget() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TARGET$56);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetTitle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TITLE$60);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetType() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TYPE$156);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetUserdrawn() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERDRAWN$100);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public STTrueFalse xgetUserhidden() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$82);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public XmlString xgetWrapcoords() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$68);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetAdj(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$158;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetAllowincell(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$96;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetAllowoverlap(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$98;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetAlt(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$62;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetBorderbottomcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$106;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetBorderleftcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$104;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetBorderrightcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$108;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetBordertopcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$102;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetBullet(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$84;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetButton(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$80;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetBwmode(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$138;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetBwnormal(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$142;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetBwpure(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$140;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetChromakey(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$118;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetClass1(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$58;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetClip(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$154;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetCliptowrap(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$152;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetConnectortype(STConnectorType sTConnectorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$136;
            STConnectorType sTConnectorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTConnectorTypeFind_attribute_user == null) {
                sTConnectorTypeFind_attribute_user = (STConnectorType) get_store().add_attribute_user(qName);
            }
            sTConnectorTypeFind_attribute_user.set(sTConnectorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetCoordorigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$66;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetCoordsize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$64;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetDgmlayout(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$110;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetDgmlayoutmru(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$114;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetDgmnodekind(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$112;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetDoubleclicknotify(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$78;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetEquationxml(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQUATIONXML$164;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetFillcolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$122;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetFilled(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$120;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetForcedash(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$144;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetGfxdata(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GFXDATA$162;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetHr(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$86;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetHralign(STHrAlign sTHrAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$94;
            STHrAlign sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_store().add_attribute_user(qName);
            }
            sTHrAlignFind_attribute_user.set(sTHrAlign);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$54;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetHrnoshade(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$90;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetHrpct(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$92;
            XmlFloat xmlFloatFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlFloatFind_attribute_user == null) {
                xmlFloatFind_attribute_user = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloatFind_attribute_user.set(xmlFloat);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetHrstd(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$88;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$50;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$116;
            STInsetMode sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_store().add_attribute_user(qName);
            }
            sTInsetModeFind_attribute_user.set(sTInsetMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetInsetpen(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$132;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetOle(STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$148;
            STTrueFalseBlank sTTrueFalseBlankFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseBlankFind_attribute_user == null) {
                sTTrueFalseBlankFind_attribute_user = (STTrueFalseBlank) get_store().add_attribute_user(qName);
            }
            sTTrueFalseBlankFind_attribute_user.set(sTTrueFalseBlank);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetOleicon(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$146;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetOned(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$74;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$124;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetPath2(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$160;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetPreferrelative(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$150;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetPrint(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$70;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetRegroupid(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$76;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetSpid(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$72;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetSpt(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$134;
            XmlFloat xmlFloatFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlFloatFind_attribute_user == null) {
                xmlFloatFind_attribute_user = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloatFind_attribute_user.set(xmlFloat);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetStrokecolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$128;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetStroked(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$126;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetStrokeweight(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$130;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$52;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$56;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$60;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetType(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$156;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetUserdrawn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$100;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetUserhidden(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$82;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShape
    public void xsetWrapcoords(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$68;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
