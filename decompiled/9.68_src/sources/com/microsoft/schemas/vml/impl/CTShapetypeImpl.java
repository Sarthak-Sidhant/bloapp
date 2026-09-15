package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTComplex;
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
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShapetype;
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
public class CTShapetypeImpl extends XmlComplexContentImpl implements CTShapetype {
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
    private static final QName COMPLEX$46 = new QName("urn:schemas-microsoft-com:office:office", "complex");
    private static final QName ID$48 = new QName("", "id");
    private static final QName STYLE$50 = new QName("", "style");
    private static final QName HREF$52 = new QName("", "href");
    private static final QName TARGET$54 = new QName("", "target");
    private static final QName CLASS1$56 = new QName("", "class");
    private static final QName TITLE$58 = new QName("", Constants.TITLE);
    private static final QName ALT$60 = new QName("", "alt");
    private static final QName COORDSIZE$62 = new QName("", "coordsize");
    private static final QName COORDORIGIN$64 = new QName("", "coordorigin");
    private static final QName WRAPCOORDS$66 = new QName("", "wrapcoords");
    private static final QName PRINT$68 = new QName("", "print");
    private static final QName SPID$70 = new QName("urn:schemas-microsoft-com:office:office", "spid");
    private static final QName ONED$72 = new QName("urn:schemas-microsoft-com:office:office", "oned");
    private static final QName REGROUPID$74 = new QName("urn:schemas-microsoft-com:office:office", "regroupid");
    private static final QName DOUBLECLICKNOTIFY$76 = new QName("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
    private static final QName BUTTON$78 = new QName("urn:schemas-microsoft-com:office:office", "button");
    private static final QName USERHIDDEN$80 = new QName("urn:schemas-microsoft-com:office:office", "userhidden");
    private static final QName BULLET$82 = new QName("urn:schemas-microsoft-com:office:office", "bullet");
    private static final QName HR$84 = new QName("urn:schemas-microsoft-com:office:office", "hr");
    private static final QName HRSTD$86 = new QName("urn:schemas-microsoft-com:office:office", "hrstd");
    private static final QName HRNOSHADE$88 = new QName("urn:schemas-microsoft-com:office:office", "hrnoshade");
    private static final QName HRPCT$90 = new QName("urn:schemas-microsoft-com:office:office", "hrpct");
    private static final QName HRALIGN$92 = new QName("urn:schemas-microsoft-com:office:office", "hralign");
    private static final QName ALLOWINCELL$94 = new QName("urn:schemas-microsoft-com:office:office", "allowincell");
    private static final QName ALLOWOVERLAP$96 = new QName("urn:schemas-microsoft-com:office:office", "allowoverlap");
    private static final QName USERDRAWN$98 = new QName("urn:schemas-microsoft-com:office:office", "userdrawn");
    private static final QName BORDERTOPCOLOR$100 = new QName("urn:schemas-microsoft-com:office:office", "bordertopcolor");
    private static final QName BORDERLEFTCOLOR$102 = new QName("urn:schemas-microsoft-com:office:office", "borderleftcolor");
    private static final QName BORDERBOTTOMCOLOR$104 = new QName("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
    private static final QName BORDERRIGHTCOLOR$106 = new QName("urn:schemas-microsoft-com:office:office", "borderrightcolor");
    private static final QName DGMLAYOUT$108 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayout");
    private static final QName DGMNODEKIND$110 = new QName("urn:schemas-microsoft-com:office:office", "dgmnodekind");
    private static final QName DGMLAYOUTMRU$112 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
    private static final QName INSETMODE$114 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");
    private static final QName CHROMAKEY$116 = new QName("", "chromakey");
    private static final QName FILLED$118 = new QName("", "filled");
    private static final QName FILLCOLOR$120 = new QName("", "fillcolor");
    private static final QName OPACITY$122 = new QName("", "opacity");
    private static final QName STROKED$124 = new QName("", "stroked");
    private static final QName STROKECOLOR$126 = new QName("", "strokecolor");
    private static final QName STROKEWEIGHT$128 = new QName("", "strokeweight");
    private static final QName INSETPEN$130 = new QName("", "insetpen");
    private static final QName SPT$132 = new QName("urn:schemas-microsoft-com:office:office", "spt");
    private static final QName CONNECTORTYPE$134 = new QName("urn:schemas-microsoft-com:office:office", "connectortype");
    private static final QName BWMODE$136 = new QName("urn:schemas-microsoft-com:office:office", "bwmode");
    private static final QName BWPURE$138 = new QName("urn:schemas-microsoft-com:office:office", "bwpure");
    private static final QName BWNORMAL$140 = new QName("urn:schemas-microsoft-com:office:office", "bwnormal");
    private static final QName FORCEDASH$142 = new QName("urn:schemas-microsoft-com:office:office", "forcedash");
    private static final QName OLEICON$144 = new QName("urn:schemas-microsoft-com:office:office", "oleicon");
    private static final QName OLE$146 = new QName("urn:schemas-microsoft-com:office:office", "ole");
    private static final QName PREFERRELATIVE$148 = new QName("urn:schemas-microsoft-com:office:office", "preferrelative");
    private static final QName CLIPTOWRAP$150 = new QName("urn:schemas-microsoft-com:office:office", "cliptowrap");
    private static final QName CLIP$152 = new QName("urn:schemas-microsoft-com:office:office", "clip");
    private static final QName ADJ$154 = new QName("", "adj");
    private static final QName PATH2$156 = new QName("", "path");
    private static final QName MASTER$158 = new QName("urn:schemas-microsoft-com:office:office", "master");

    public CTShapetypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTAnchorLock addNewAnchorlock() {
        CTAnchorLock cTAnchorLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockAdd_element_user = get_store().add_element_user(ANCHORLOCK$32);
        }
        return cTAnchorLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder addNewBorderbottom() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERBOTTOM$36);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder addNewBorderleft() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERLEFT$38);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder addNewBorderright() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERRIGHT$40);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder addNewBordertop() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERTOP$34);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTCallout addNewCallout() {
        CTCallout cTCalloutAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutAdd_element_user = get_store().add_element_user(CALLOUT$22);
        }
        return cTCalloutAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClientData addNewClientData() {
        CTClientData cTClientDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataAdd_element_user = get_store().add_element_user(CLIENTDATA$42);
        }
        return cTClientDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClipPath addNewClippath() {
        CTClipPath cTClipPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathAdd_element_user = get_store().add_element_user(CLIPPATH$26);
        }
        return cTClipPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTComplex addNewComplex() {
        CTComplex cTComplexAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTComplexAdd_element_user = get_store().add_element_user(COMPLEX$46);
        }
        return cTComplexAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTExtrusion addNewExtrusion() {
        CTExtrusion cTExtrusionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionAdd_element_user = get_store().add_element_user(EXTRUSION$20);
        }
        return cTExtrusionAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFill addNewFill() {
        CTFill cTFillAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillAdd_element_user = get_store().add_element_user(FILL$6);
        }
        return cTFillAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFormulas addNewFormulas() {
        CTFormulas cTFormulasAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasAdd_element_user = get_store().add_element_user(FORMULAS$2);
        }
        return cTFormulasAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTHandles addNewHandles() {
        CTHandles cTHandlesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesAdd_element_user = get_store().add_element_user(HANDLES$4);
        }
        return cTHandlesAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTImageData addNewImagedata() {
        CTImageData cTImageDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataAdd_element_user = get_store().add_element_user(IMAGEDATA$16);
        }
        return cTImageDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTLock addNewLock() {
        CTLock cTLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockAdd_element_user = get_store().add_element_user(LOCK$24);
        }
        return cTLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTPath addNewPath() {
        CTPath cTPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathAdd_element_user = get_store().add_element_user(PATH$0);
        }
        return cTPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTShadow addNewShadow() {
        CTShadow cTShadowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowAdd_element_user = get_store().add_element_user(SHADOW$10);
        }
        return cTShadowAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSignatureLine addNewSignatureline() {
        CTSignatureLine cTSignatureLineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineAdd_element_user = get_store().add_element_user(SIGNATURELINE$28);
        }
        return cTSignatureLineAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSkew addNewSkew() {
        CTSkew cTSkewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewAdd_element_user = get_store().add_element_user(SKEW$18);
        }
        return cTSkewAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTStroke addNewStroke() {
        CTStroke cTStrokeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeAdd_element_user = get_store().add_element_user(STROKE$8);
        }
        return cTStrokeAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextbox addNewTextbox() {
        CTTextbox cTTextboxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxAdd_element_user = get_store().add_element_user(TEXTBOX$12);
        }
        return cTTextboxAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTRel addNewTextdata() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(TEXTDATA$44);
        }
        return cTRelAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextPath addNewTextpath() {
        CTTextPath cTTextPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathAdd_element_user = get_store().add_element_user(TEXTPATH$14);
        }
        return cTTextPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTWrap addNewWrap() {
        CTWrap cTWrapAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapAdd_element_user = get_store().add_element_user(WRAP$30);
        }
        return cTWrapAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getAdj() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ADJ$154);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$94);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$96);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getAlt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALT$60);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTAnchorLock> getAnchorlockList() {
        AbstractList<CTAnchorLock> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTAnchorLock>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1AnchorlockList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTAnchorLock cTAnchorLock) {
                    CTShapetypeImpl.this.insertNewAnchorlock(i).set(cTAnchorLock);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAnchorLock get(int i) {
                    return CTShapetypeImpl.this.getAnchorlockArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAnchorLock remove(int i) {
                    CTAnchorLock anchorlockArray = CTShapetypeImpl.this.getAnchorlockArray(i);
                    CTShapetypeImpl.this.removeAnchorlock(i);
                    return anchorlockArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAnchorLock set(int i, CTAnchorLock cTAnchorLock) {
                    CTAnchorLock anchorlockArray = CTShapetypeImpl.this.getAnchorlockArray(i);
                    CTShapetypeImpl.this.setAnchorlockArray(i, cTAnchorLock);
                    return anchorlockArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfAnchorlockArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTBorder> getBorderbottomList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1BorderbottomList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTShapetypeImpl.this.insertNewBorderbottom(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTShapetypeImpl.this.getBorderbottomArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder borderbottomArray = CTShapetypeImpl.this.getBorderbottomArray(i);
                    CTShapetypeImpl.this.removeBorderbottom(i);
                    return borderbottomArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder borderbottomArray = CTShapetypeImpl.this.getBorderbottomArray(i);
                    CTShapetypeImpl.this.setBorderbottomArray(i, cTBorder);
                    return borderbottomArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfBorderbottomArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$104);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTBorder> getBorderleftList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1BorderleftList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTShapetypeImpl.this.insertNewBorderleft(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTShapetypeImpl.this.getBorderleftArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder borderleftArray = CTShapetypeImpl.this.getBorderleftArray(i);
                    CTShapetypeImpl.this.removeBorderleft(i);
                    return borderleftArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder borderleftArray = CTShapetypeImpl.this.getBorderleftArray(i);
                    CTShapetypeImpl.this.setBorderleftArray(i, cTBorder);
                    return borderleftArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfBorderleftArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$102);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTBorder> getBorderrightList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1BorderrightList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTShapetypeImpl.this.insertNewBorderright(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTShapetypeImpl.this.getBorderrightArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder borderrightArray = CTShapetypeImpl.this.getBorderrightArray(i);
                    CTShapetypeImpl.this.removeBorderright(i);
                    return borderrightArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder borderrightArray = CTShapetypeImpl.this.getBorderrightArray(i);
                    CTShapetypeImpl.this.setBorderrightArray(i, cTBorder);
                    return borderrightArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfBorderrightArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$106);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTBorder> getBordertopList() {
        AbstractList<CTBorder> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorder>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1BordertopList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorder cTBorder) {
                    CTShapetypeImpl.this.insertNewBordertop(i).set(cTBorder);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder get(int i) {
                    return CTShapetypeImpl.this.getBordertopArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder remove(int i) {
                    CTBorder bordertopArray = CTShapetypeImpl.this.getBordertopArray(i);
                    CTShapetypeImpl.this.removeBordertop(i);
                    return bordertopArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorder set(int i, CTBorder cTBorder) {
                    CTBorder bordertopArray = CTShapetypeImpl.this.getBordertopArray(i);
                    CTShapetypeImpl.this.setBordertopArray(i, cTBorder);
                    return bordertopArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfBordertopArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$100);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getBullet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BULLET$82);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getButton() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BUTTON$78);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode.Enum getBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWMODE$136);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode.Enum getBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWNORMAL$140);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode.Enum getBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWPURE$138);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTCallout> getCalloutList() {
        AbstractList<CTCallout> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTCallout>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1CalloutList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTCallout cTCallout) {
                    CTShapetypeImpl.this.insertNewCallout(i).set(cTCallout);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCallout get(int i) {
                    return CTShapetypeImpl.this.getCalloutArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCallout remove(int i) {
                    CTCallout calloutArray = CTShapetypeImpl.this.getCalloutArray(i);
                    CTShapetypeImpl.this.removeCallout(i);
                    return calloutArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCallout set(int i, CTCallout cTCallout) {
                    CTCallout calloutArray = CTShapetypeImpl.this.getCalloutArray(i);
                    CTShapetypeImpl.this.setCalloutArray(i, cTCallout);
                    return calloutArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfCalloutArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CHROMAKEY$116);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getClass1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLASS1$56);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTClientData> getClientDataList() {
        AbstractList<CTClientData> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTClientData>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1ClientDataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTClientData cTClientData) {
                    CTShapetypeImpl.this.insertNewClientData(i).set(cTClientData);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData get(int i) {
                    return CTShapetypeImpl.this.getClientDataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData remove(int i) {
                    CTClientData clientDataArray = CTShapetypeImpl.this.getClientDataArray(i);
                    CTShapetypeImpl.this.removeClientData(i);
                    return clientDataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData set(int i, CTClientData cTClientData) {
                    CTClientData clientDataArray = CTShapetypeImpl.this.getClientDataArray(i);
                    CTShapetypeImpl.this.setClientDataArray(i, cTClientData);
                    return clientDataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfClientDataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getClip() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLIP$152);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTClipPath> getClippathList() {
        AbstractList<CTClipPath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTClipPath>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1ClippathList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTClipPath cTClipPath) {
                    CTShapetypeImpl.this.insertNewClippath(i).set(cTClipPath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClipPath get(int i) {
                    return CTShapetypeImpl.this.getClippathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClipPath remove(int i) {
                    CTClipPath clippathArray = CTShapetypeImpl.this.getClippathArray(i);
                    CTShapetypeImpl.this.removeClippath(i);
                    return clippathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClipPath set(int i, CTClipPath cTClipPath) {
                    CTClipPath clippathArray = CTShapetypeImpl.this.getClippathArray(i);
                    CTShapetypeImpl.this.setClippathArray(i, cTClipPath);
                    return clippathArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfClippathArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$150);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTComplex getComplex() {
        synchronized (monitor()) {
            check_orphaned();
            CTComplex cTComplexFind_element_user = get_store().find_element_user(COMPLEX$46, 0);
            if (cTComplexFind_element_user == null) {
                return null;
            }
            return cTComplexFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STConnectorType.Enum getConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$64);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDSIZE$62);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public BigInteger getDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$108);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public BigInteger getDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$112);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public BigInteger getDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$110);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$76);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTExtrusion> getExtrusionList() {
        AbstractList<CTExtrusion> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTExtrusion>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1ExtrusionList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTExtrusion cTExtrusion) {
                    CTShapetypeImpl.this.insertNewExtrusion(i).set(cTExtrusion);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtrusion get(int i) {
                    return CTShapetypeImpl.this.getExtrusionArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtrusion remove(int i) {
                    CTExtrusion extrusionArray = CTShapetypeImpl.this.getExtrusionArray(i);
                    CTShapetypeImpl.this.removeExtrusion(i);
                    return extrusionArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtrusion set(int i, CTExtrusion cTExtrusion) {
                    CTExtrusion extrusionArray = CTShapetypeImpl.this.getExtrusionArray(i);
                    CTShapetypeImpl.this.setExtrusionArray(i, cTExtrusion);
                    return extrusionArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfExtrusionArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTFill> getFillList() {
        AbstractList<CTFill> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFill>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1FillList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFill cTFill) {
                    CTShapetypeImpl.this.insertNewFill(i).set(cTFill);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFill get(int i) {
                    return CTShapetypeImpl.this.getFillArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFill remove(int i) {
                    CTFill fillArray = CTShapetypeImpl.this.getFillArray(i);
                    CTShapetypeImpl.this.removeFill(i);
                    return fillArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFill set(int i, CTFill cTFill) {
                    CTFill fillArray = CTShapetypeImpl.this.getFillArray(i);
                    CTShapetypeImpl.this.setFillArray(i, cTFill);
                    return fillArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfFillArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$120);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.vml.STTrueFalse.Enum getFilled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLED$118);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FORCEDASH$142);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTFormulas> getFormulasList() {
        AbstractList<CTFormulas> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFormulas>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1FormulasList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFormulas cTFormulas) {
                    CTShapetypeImpl.this.insertNewFormulas(i).set(cTFormulas);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFormulas get(int i) {
                    return CTShapetypeImpl.this.getFormulasArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFormulas remove(int i) {
                    CTFormulas formulasArray = CTShapetypeImpl.this.getFormulasArray(i);
                    CTShapetypeImpl.this.removeFormulas(i);
                    return formulasArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFormulas set(int i, CTFormulas cTFormulas) {
                    CTFormulas formulasArray = CTShapetypeImpl.this.getFormulasArray(i);
                    CTShapetypeImpl.this.setFormulasArray(i, cTFormulas);
                    return formulasArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfFormulasArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTHandles> getHandlesList() {
        AbstractList<CTHandles> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTHandles>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1HandlesList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTHandles cTHandles) {
                    CTShapetypeImpl.this.insertNewHandles(i).set(cTHandles);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTHandles get(int i) {
                    return CTShapetypeImpl.this.getHandlesArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTHandles remove(int i) {
                    CTHandles handlesArray = CTShapetypeImpl.this.getHandlesArray(i);
                    CTShapetypeImpl.this.removeHandles(i);
                    return handlesArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTHandles set(int i, CTHandles cTHandles) {
                    CTHandles handlesArray = CTShapetypeImpl.this.getHandlesArray(i);
                    CTShapetypeImpl.this.setHandlesArray(i, cTHandles);
                    return handlesArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfHandlesArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getHr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HR$84);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STHrAlign.Enum getHralign() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HREF$52);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$88);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public float getHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRPCT$90);
            if (simpleValueFind_attribute_user == null) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            return simpleValueFind_attribute_user.getFloatValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRSTD$86);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$48);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTImageData> getImagedataList() {
        AbstractList<CTImageData> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTImageData>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1ImagedataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTImageData cTImageData) {
                    CTShapetypeImpl.this.insertNewImagedata(i).set(cTImageData);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTImageData get(int i) {
                    return CTShapetypeImpl.this.getImagedataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTImageData remove(int i) {
                    CTImageData imagedataArray = CTShapetypeImpl.this.getImagedataArray(i);
                    CTShapetypeImpl.this.removeImagedata(i);
                    return imagedataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTImageData set(int i, CTImageData cTImageData) {
                    CTImageData imagedataArray = CTShapetypeImpl.this.getImagedataArray(i);
                    CTShapetypeImpl.this.setImagedataArray(i, cTImageData);
                    return imagedataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfImagedataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.vml.STTrueFalse.Enum getInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(INSETPEN$130);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTLock> getLockList() {
        AbstractList<CTLock> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTLock>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1LockList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTLock cTLock) {
                    CTShapetypeImpl.this.insertNewLock(i).set(cTLock);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLock get(int i) {
                    return CTShapetypeImpl.this.getLockArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLock remove(int i) {
                    CTLock lockArray = CTShapetypeImpl.this.getLockArray(i);
                    CTShapetypeImpl.this.removeLock(i);
                    return lockArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLock set(int i, CTLock cTLock) {
                    CTLock lockArray = CTShapetypeImpl.this.getLockArray(i);
                    CTShapetypeImpl.this.setLockArray(i, cTLock);
                    return lockArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfLockArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getMaster() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MASTER$158);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalseBlank.Enum getOle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OLE$146);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OLEICON$144);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getOned() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ONED$72);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OPACITY$122);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getPath2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PATH2$156);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTPath> getPathList() {
        AbstractList<CTPath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPath>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1PathList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPath cTPath) {
                    CTShapetypeImpl.this.insertNewPath(i).set(cTPath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath get(int i) {
                    return CTShapetypeImpl.this.getPathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath remove(int i) {
                    CTPath pathArray = CTShapetypeImpl.this.getPathArray(i);
                    CTShapetypeImpl.this.removePath(i);
                    return pathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath set(int i, CTPath cTPath) {
                    CTPath pathArray = CTShapetypeImpl.this.getPathArray(i);
                    CTShapetypeImpl.this.setPathArray(i, cTPath);
                    return pathArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfPathArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$148);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.vml.STTrueFalse.Enum getPrint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PRINT$68);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public BigInteger getRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REGROUPID$74);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTShadow> getShadowList() {
        AbstractList<CTShadow> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTShadow>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1ShadowList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTShadow cTShadow) {
                    CTShapetypeImpl.this.insertNewShadow(i).set(cTShadow);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTShadow get(int i) {
                    return CTShapetypeImpl.this.getShadowArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTShadow remove(int i) {
                    CTShadow shadowArray = CTShapetypeImpl.this.getShadowArray(i);
                    CTShapetypeImpl.this.removeShadow(i);
                    return shadowArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTShadow set(int i, CTShadow cTShadow) {
                    CTShadow shadowArray = CTShapetypeImpl.this.getShadowArray(i);
                    CTShapetypeImpl.this.setShadowArray(i, cTShadow);
                    return shadowArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfShadowArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTSignatureLine> getSignaturelineList() {
        AbstractList<CTSignatureLine> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSignatureLine>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1SignaturelineList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSignatureLine cTSignatureLine) {
                    CTShapetypeImpl.this.insertNewSignatureline(i).set(cTSignatureLine);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSignatureLine get(int i) {
                    return CTShapetypeImpl.this.getSignaturelineArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSignatureLine remove(int i) {
                    CTSignatureLine signaturelineArray = CTShapetypeImpl.this.getSignaturelineArray(i);
                    CTShapetypeImpl.this.removeSignatureline(i);
                    return signaturelineArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSignatureLine set(int i, CTSignatureLine cTSignatureLine) {
                    CTSignatureLine signaturelineArray = CTShapetypeImpl.this.getSignaturelineArray(i);
                    CTShapetypeImpl.this.setSignaturelineArray(i, cTSignatureLine);
                    return signaturelineArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfSignaturelineArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTSkew> getSkewList() {
        AbstractList<CTSkew> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSkew>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1SkewList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSkew cTSkew) {
                    CTShapetypeImpl.this.insertNewSkew(i).set(cTSkew);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSkew get(int i) {
                    return CTShapetypeImpl.this.getSkewArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSkew remove(int i) {
                    CTSkew skewArray = CTShapetypeImpl.this.getSkewArray(i);
                    CTShapetypeImpl.this.removeSkew(i);
                    return skewArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSkew set(int i, CTSkew cTSkew) {
                    CTSkew skewArray = CTShapetypeImpl.this.getSkewArray(i);
                    CTShapetypeImpl.this.setSkewArray(i, cTSkew);
                    return skewArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfSkewArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getSpid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPID$70);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public float getSpt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPT$132);
            if (simpleValueFind_attribute_user == null) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            return simpleValueFind_attribute_user.getFloatValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTStroke> getStrokeList() {
        AbstractList<CTStroke> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTStroke>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1StrokeList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTStroke cTStroke) {
                    CTShapetypeImpl.this.insertNewStroke(i).set(cTStroke);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTStroke get(int i) {
                    return CTShapetypeImpl.this.getStrokeArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTStroke remove(int i) {
                    CTStroke strokeArray = CTShapetypeImpl.this.getStrokeArray(i);
                    CTShapetypeImpl.this.removeStroke(i);
                    return strokeArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTStroke set(int i, CTStroke cTStroke) {
                    CTStroke strokeArray = CTShapetypeImpl.this.getStrokeArray(i);
                    CTShapetypeImpl.this.setStrokeArray(i, cTStroke);
                    return strokeArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfStrokeArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKECOLOR$126);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.vml.STTrueFalse.Enum getStroked() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKED$124);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (com.microsoft.schemas.vml.STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKEWEIGHT$128);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STYLE$50);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TARGET$54);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTTextbox> getTextboxList() {
        AbstractList<CTTextbox> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTextbox>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1TextboxList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTextbox cTTextbox) {
                    CTShapetypeImpl.this.insertNewTextbox(i).set(cTTextbox);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextbox get(int i) {
                    return CTShapetypeImpl.this.getTextboxArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextbox remove(int i) {
                    CTTextbox textboxArray = CTShapetypeImpl.this.getTextboxArray(i);
                    CTShapetypeImpl.this.removeTextbox(i);
                    return textboxArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextbox set(int i, CTTextbox cTTextbox) {
                    CTTextbox textboxArray = CTShapetypeImpl.this.getTextboxArray(i);
                    CTShapetypeImpl.this.setTextboxArray(i, cTTextbox);
                    return textboxArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfTextboxArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTRel> getTextdataList() {
        AbstractList<CTRel> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRel>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1TextdataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRel cTRel) {
                    CTShapetypeImpl.this.insertNewTextdata(i).set(cTRel);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRel get(int i) {
                    return CTShapetypeImpl.this.getTextdataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRel remove(int i) {
                    CTRel textdataArray = CTShapetypeImpl.this.getTextdataArray(i);
                    CTShapetypeImpl.this.removeTextdata(i);
                    return textdataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRel set(int i, CTRel cTRel) {
                    CTRel textdataArray = CTShapetypeImpl.this.getTextdataArray(i);
                    CTShapetypeImpl.this.setTextdataArray(i, cTRel);
                    return textdataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfTextdataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTTextPath> getTextpathList() {
        AbstractList<CTTextPath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTextPath>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1TextpathList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTextPath cTTextPath) {
                    CTShapetypeImpl.this.insertNewTextpath(i).set(cTTextPath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextPath get(int i) {
                    return CTShapetypeImpl.this.getTextpathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextPath remove(int i) {
                    CTTextPath textpathArray = CTShapetypeImpl.this.getTextpathArray(i);
                    CTShapetypeImpl.this.removeTextpath(i);
                    return textpathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTextPath set(int i, CTTextPath cTTextPath) {
                    CTTextPath textpathArray = CTShapetypeImpl.this.getTextpathArray(i);
                    CTShapetypeImpl.this.setTextpathArray(i, cTTextPath);
                    return textpathArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfTextpathArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TITLE$58);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERDRAWN$98);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$80);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
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

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTWrap> getWrapList() {
        AbstractList<CTWrap> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTWrap>() { // from class: com.microsoft.schemas.vml.impl.CTShapetypeImpl.1WrapList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTWrap cTWrap) {
                    CTShapetypeImpl.this.insertNewWrap(i).set(cTWrap);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTWrap get(int i) {
                    return CTShapetypeImpl.this.getWrapArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTWrap remove(int i) {
                    CTWrap wrapArray = CTShapetypeImpl.this.getWrapArray(i);
                    CTShapetypeImpl.this.removeWrap(i);
                    return wrapArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTWrap set(int i, CTWrap cTWrap) {
                    CTWrap wrapArray = CTShapetypeImpl.this.getWrapArray(i);
                    CTShapetypeImpl.this.setWrapArray(i, cTWrap);
                    return wrapArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapetypeImpl.this.sizeOfWrapArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$66);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTAnchorLock insertNewAnchorlock(int i) {
        CTAnchorLock cTAnchorLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockInsert_element_user = get_store().insert_element_user(ANCHORLOCK$32, i);
        }
        return cTAnchorLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder insertNewBorderbottom(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERBOTTOM$36, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder insertNewBorderleft(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERLEFT$38, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder insertNewBorderright(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERRIGHT$40, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder insertNewBordertop(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERTOP$34, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTCallout insertNewCallout(int i) {
        CTCallout cTCalloutInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutInsert_element_user = get_store().insert_element_user(CALLOUT$22, i);
        }
        return cTCalloutInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClientData insertNewClientData(int i) {
        CTClientData cTClientDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataInsert_element_user = get_store().insert_element_user(CLIENTDATA$42, i);
        }
        return cTClientDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClipPath insertNewClippath(int i) {
        CTClipPath cTClipPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathInsert_element_user = get_store().insert_element_user(CLIPPATH$26, i);
        }
        return cTClipPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTExtrusion insertNewExtrusion(int i) {
        CTExtrusion cTExtrusionInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionInsert_element_user = get_store().insert_element_user(EXTRUSION$20, i);
        }
        return cTExtrusionInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFill insertNewFill(int i) {
        CTFill cTFillInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillInsert_element_user = get_store().insert_element_user(FILL$6, i);
        }
        return cTFillInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFormulas insertNewFormulas(int i) {
        CTFormulas cTFormulasInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasInsert_element_user = get_store().insert_element_user(FORMULAS$2, i);
        }
        return cTFormulasInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTHandles insertNewHandles(int i) {
        CTHandles cTHandlesInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesInsert_element_user = get_store().insert_element_user(HANDLES$4, i);
        }
        return cTHandlesInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTImageData insertNewImagedata(int i) {
        CTImageData cTImageDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataInsert_element_user = get_store().insert_element_user(IMAGEDATA$16, i);
        }
        return cTImageDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTLock insertNewLock(int i) {
        CTLock cTLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockInsert_element_user = get_store().insert_element_user(LOCK$24, i);
        }
        return cTLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTPath insertNewPath(int i) {
        CTPath cTPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathInsert_element_user = get_store().insert_element_user(PATH$0, i);
        }
        return cTPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTShadow insertNewShadow(int i) {
        CTShadow cTShadowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowInsert_element_user = get_store().insert_element_user(SHADOW$10, i);
        }
        return cTShadowInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSignatureLine insertNewSignatureline(int i) {
        CTSignatureLine cTSignatureLineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineInsert_element_user = get_store().insert_element_user(SIGNATURELINE$28, i);
        }
        return cTSignatureLineInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSkew insertNewSkew(int i) {
        CTSkew cTSkewInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewInsert_element_user = get_store().insert_element_user(SKEW$18, i);
        }
        return cTSkewInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTStroke insertNewStroke(int i) {
        CTStroke cTStrokeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeInsert_element_user = get_store().insert_element_user(STROKE$8, i);
        }
        return cTStrokeInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextbox insertNewTextbox(int i) {
        CTTextbox cTTextboxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxInsert_element_user = get_store().insert_element_user(TEXTBOX$12, i);
        }
        return cTTextboxInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTRel insertNewTextdata(int i) {
        CTRel cTRelInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelInsert_element_user = get_store().insert_element_user(TEXTDATA$44, i);
        }
        return cTRelInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextPath insertNewTextpath(int i) {
        CTTextPath cTTextPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathInsert_element_user = get_store().insert_element_user(TEXTPATH$14, i);
        }
        return cTTextPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTWrap insertNewWrap(int i) {
        CTWrap cTWrapInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapInsert_element_user = get_store().insert_element_user(WRAP$30, i);
        }
        return cTWrapInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetAdj() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ADJ$154) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetAllowincell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWINCELL$94) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetAllowoverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWOVERLAP$96) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetAlt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALT$60) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBorderbottomcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERBOTTOMCOLOR$104) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBorderleftcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERLEFTCOLOR$102) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBorderrightcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERRIGHTCOLOR$106) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBordertopcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERTOPCOLOR$100) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBullet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BULLET$82) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetButton() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BUTTON$78) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBwmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWMODE$136) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBwnormal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWNORMAL$140) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBwpure() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWPURE$138) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetChromakey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CHROMAKEY$116) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetClass1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLASS1$56) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetClip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIP$152) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetCliptowrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIPTOWRAP$150) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetComplex() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COMPLEX$46) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetConnectortype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTORTYPE$134) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetCoordorigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDORIGIN$64) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetCoordsize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDSIZE$62) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetDgmlayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUT$108) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetDgmlayoutmru() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUTMRU$112) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetDgmnodekind() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMNODEKIND$110) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetDoubleclicknotify() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DOUBLECLICKNOTIFY$76) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetFillcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLCOLOR$120) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetFilled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLED$118) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetForcedash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORCEDASH$142) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HR$84) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHralign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRALIGN$92) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$52) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHrnoshade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRNOSHADE$88) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHrpct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRPCT$90) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHrstd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRSTD$86) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$48) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$114) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetInsetpen() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETPEN$130) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetMaster() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MASTER$158) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetOle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLE$146) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetOleicon() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLEICON$144) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetOned() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ONED$72) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$122) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetPath2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PATH2$156) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetPreferrelative() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PREFERRELATIVE$148) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetPrint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRINT$68) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetRegroupid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REGROUPID$74) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetSpid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPID$70) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetSpt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPT$132) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetStrokecolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKECOLOR$126) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetStroked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKED$124) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetStrokeweight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKEWEIGHT$128) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$50) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$54) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$58) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetUserdrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$98) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetUserhidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERHIDDEN$80) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetWrapcoords() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WRAPCOORDS$66) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeAnchorlock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHORLOCK$32, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeBorderbottom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOTTOM$36, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeBorderleft(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERLEFT$38, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeBorderright(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERRIGHT$40, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeBordertop(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERTOP$34, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeCallout(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALLOUT$22, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeClientData(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIENTDATA$42, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeClippath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIPPATH$26, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeExtrusion(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTRUSION$20, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$6, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeFormulas(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULAS$2, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeHandles(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HANDLES$4, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeImagedata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGEDATA$16, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$24, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removePath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$0, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$10, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeSignatureline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATURELINE$28, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeSkew(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SKEW$18, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeStroke(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STROKE$8, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeTextbox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOX$12, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeTextdata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDATA$44, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeTextpath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTPATH$14, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeWrap(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAP$30, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAdj(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$154;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAllowincell(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$94;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAllowoverlap(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$96;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAlt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$60;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAnchorlockArray(int i, CTAnchorLock cTAnchorLock) {
        generatedSetterHelperImpl(cTAnchorLock, ANCHORLOCK$32, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr) {
        check_orphaned();
        arraySetterHelper(cTAnchorLockArr, ANCHORLOCK$32);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderbottomArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERBOTTOM$36, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderbottomArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERBOTTOM$36);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderbottomcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$104;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderleftArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERLEFT$38, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderleftArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERLEFT$38);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderleftcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$102;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderrightArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERRIGHT$40, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderrightArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERRIGHT$40);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderrightcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$106;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBordertopArray(int i, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, BORDERTOP$34, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBordertopArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, BORDERTOP$34);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBordertopcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$100;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBullet(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$82;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setButton(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$78;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBwmode(STBWMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$136;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBwnormal(STBWMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$140;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBwpure(STBWMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$138;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCalloutArray(int i, CTCallout cTCallout) {
        generatedSetterHelperImpl(cTCallout, CALLOUT$22, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCalloutArray(CTCallout[] cTCalloutArr) {
        check_orphaned();
        arraySetterHelper(cTCalloutArr, CALLOUT$22);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setChromakey(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$116;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClass1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$56;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClientDataArray(int i, CTClientData cTClientData) {
        generatedSetterHelperImpl(cTClientData, CLIENTDATA$42, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClientDataArray(CTClientData[] cTClientDataArr) {
        check_orphaned();
        arraySetterHelper(cTClientDataArr, CLIENTDATA$42);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClip(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$152;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClippathArray(int i, CTClipPath cTClipPath) {
        generatedSetterHelperImpl(cTClipPath, CLIPPATH$26, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClippathArray(CTClipPath[] cTClipPathArr) {
        check_orphaned();
        arraySetterHelper(cTClipPathArr, CLIPPATH$26);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCliptowrap(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$150;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setComplex(CTComplex cTComplex) {
        generatedSetterHelperImpl(cTComplex, COMPLEX$46, 0, (short) 1);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setConnectortype(STConnectorType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCoordorigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$64;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCoordsize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$62;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setDgmlayout(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$108;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setDgmlayoutmru(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$112;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setDgmnodekind(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$110;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setDoubleclicknotify(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$76;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setExtrusionArray(int i, CTExtrusion cTExtrusion) {
        generatedSetterHelperImpl(cTExtrusion, EXTRUSION$20, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setExtrusionArray(CTExtrusion[] cTExtrusionArr) {
        check_orphaned();
        arraySetterHelper(cTExtrusionArr, EXTRUSION$20);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFillArray(int i, CTFill cTFill) {
        generatedSetterHelperImpl(cTFill, FILL$6, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFillArray(CTFill[] cTFillArr) {
        check_orphaned();
        arraySetterHelper(cTFillArr, FILL$6);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFillcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$120;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFilled(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$118;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setForcedash(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$142;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFormulasArray(int i, CTFormulas cTFormulas) {
        generatedSetterHelperImpl(cTFormulas, FORMULAS$2, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFormulasArray(CTFormulas[] cTFormulasArr) {
        check_orphaned();
        arraySetterHelper(cTFormulasArr, FORMULAS$2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHandlesArray(int i, CTHandles cTHandles) {
        generatedSetterHelperImpl(cTHandles, HANDLES$4, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHandlesArray(CTHandles[] cTHandlesArr) {
        check_orphaned();
        arraySetterHelper(cTHandlesArr, HANDLES$4);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHr(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$84;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHralign(STHrAlign.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$52;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHrnoshade(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$88;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHrpct(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$90;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setFloatValue(f);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHrstd(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$86;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setImagedataArray(int i, CTImageData cTImageData) {
        generatedSetterHelperImpl(cTImageData, IMAGEDATA$16, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setImagedataArray(CTImageData[] cTImageDataArr) {
        check_orphaned();
        arraySetterHelper(cTImageDataArr, IMAGEDATA$16);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setInsetpen(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$130;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setLockArray(int i, CTLock cTLock) {
        generatedSetterHelperImpl(cTLock, LOCK$24, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setLockArray(CTLock[] cTLockArr) {
        check_orphaned();
        arraySetterHelper(cTLockArr, LOCK$24);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setMaster(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTER$158;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setOle(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$146;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setOleicon(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$144;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setOned(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$72;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setOpacity(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$122;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPath2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$156;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPathArray(int i, CTPath cTPath) {
        generatedSetterHelperImpl(cTPath, PATH$0, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPathArray(CTPath[] cTPathArr) {
        check_orphaned();
        arraySetterHelper(cTPathArr, PATH$0);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPreferrelative(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$148;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPrint(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$68;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setRegroupid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$74;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setShadowArray(int i, CTShadow cTShadow) {
        generatedSetterHelperImpl(cTShadow, SHADOW$10, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setShadowArray(CTShadow[] cTShadowArr) {
        check_orphaned();
        arraySetterHelper(cTShadowArr, SHADOW$10);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSignaturelineArray(int i, CTSignatureLine cTSignatureLine) {
        generatedSetterHelperImpl(cTSignatureLine, SIGNATURELINE$28, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr) {
        check_orphaned();
        arraySetterHelper(cTSignatureLineArr, SIGNATURELINE$28);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSkewArray(int i, CTSkew cTSkew) {
        generatedSetterHelperImpl(cTSkew, SKEW$18, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSkewArray(CTSkew[] cTSkewArr) {
        check_orphaned();
        arraySetterHelper(cTSkewArr, SKEW$18);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSpid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$70;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSpt(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$132;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setFloatValue(f);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStrokeArray(int i, CTStroke cTStroke) {
        generatedSetterHelperImpl(cTStroke, STROKE$8, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStrokeArray(CTStroke[] cTStrokeArr) {
        check_orphaned();
        arraySetterHelper(cTStrokeArr, STROKE$8);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStrokecolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$126;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStroked(com.microsoft.schemas.vml.STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$124;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStrokeweight(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$128;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$54;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextboxArray(int i, CTTextbox cTTextbox) {
        generatedSetterHelperImpl(cTTextbox, TEXTBOX$12, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextboxArray(CTTextbox[] cTTextboxArr) {
        check_orphaned();
        arraySetterHelper(cTTextboxArr, TEXTBOX$12);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextdataArray(int i, CTRel cTRel) {
        generatedSetterHelperImpl(cTRel, TEXTDATA$44, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextdataArray(CTRel[] cTRelArr) {
        check_orphaned();
        arraySetterHelper(cTRelArr, TEXTDATA$44);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextpathArray(int i, CTTextPath cTTextPath) {
        generatedSetterHelperImpl(cTTextPath, TEXTPATH$14, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextpathArray(CTTextPath[] cTTextPathArr) {
        check_orphaned();
        arraySetterHelper(cTTextPathArr, TEXTPATH$14);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$58;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setUserdrawn(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$98;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setUserhidden(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$80;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setWrapArray(int i, CTWrap cTWrap) {
        generatedSetterHelperImpl(cTWrap, WRAP$30, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setWrapArray(CTWrap[] cTWrapArr) {
        check_orphaned();
        arraySetterHelper(cTWrapArr, WRAP$30);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setWrapcoords(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$66;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfAnchorlockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANCHORLOCK$32);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfBorderbottomArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERBOTTOM$36);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfBorderleftArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERLEFT$38);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfBorderrightArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERRIGHT$40);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfBordertopArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERTOP$34);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfCalloutArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CALLOUT$22);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfClientDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIENTDATA$42);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfClippathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIPPATH$26);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfExtrusionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXTRUSION$20);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FILL$6);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfFormulasArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FORMULAS$2);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfHandlesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HANDLES$4);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfImagedataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(IMAGEDATA$16);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfLockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LOCK$24);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfPathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PATH$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfShadowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHADOW$10);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfSignaturelineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SIGNATURELINE$28);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfSkewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SKEW$18);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfStrokeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(STROKE$8);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfTextboxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTBOX$12);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfTextdataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTDATA$44);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfTextpathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTPATH$14);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfWrapArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(WRAP$30);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetAdj() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ADJ$154);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWINCELL$94);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWOVERLAP$96);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetAlt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALT$60);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERBOTTOMCOLOR$104);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERLEFTCOLOR$102);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERRIGHTCOLOR$106);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERTOPCOLOR$100);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBullet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BULLET$82);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BUTTON$78);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWMODE$136);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWNORMAL$140);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWPURE$138);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CHROMAKEY$116);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetClass1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLASS1$56);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetClip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIP$152);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIPTOWRAP$150);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetComplex() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPLEX$46, 0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTORTYPE$134);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDORIGIN$64);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDSIZE$62);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUT$108);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUTMRU$112);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMNODEKIND$110);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DOUBLECLICKNOTIFY$76);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLCOLOR$120);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetFilled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLED$118);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORCEDASH$142);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HR$84);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHralign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRALIGN$92);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$52);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRNOSHADE$88);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRPCT$90);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRSTD$86);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$48);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$114);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETPEN$130);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetMaster() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MASTER$158);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetOle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLE$146);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLEICON$144);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetOned() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ONED$72);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$122);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetPath2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PATH2$156);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PREFERRELATIVE$148);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetPrint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRINT$68);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REGROUPID$74);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetSpid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPID$70);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetSpt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPT$132);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKECOLOR$126);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetStroked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKED$124);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKEWEIGHT$128);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$50);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$54);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$58);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$98);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERHIDDEN$80);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WRAPCOORDS$66);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetAdj() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ADJ$154);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetAllowincell() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$94);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetAllowoverlap() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$96);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetAlt() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ALT$60);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetBorderbottomcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$104);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetBorderleftcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$102);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetBorderrightcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$106);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetBordertopcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$100);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetBullet() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BULLET$82);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetButton() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BUTTON$78);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode xgetBwmode() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWMODE$136);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode xgetBwnormal() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWNORMAL$140);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode xgetBwpure() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWPURE$138);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STColorType xgetChromakey() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(CHROMAKEY$116);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetClass1() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(CLASS1$56);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetClip() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(CLIP$152);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetCliptowrap() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$150);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STConnectorType xgetConnectortype() {
        STConnectorType sTConnectorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            sTConnectorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTConnectorTypeFind_attribute_user == null) {
                sTConnectorTypeFind_attribute_user = (STConnectorType) get_default_attribute_value(qName);
            }
        }
        return sTConnectorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetCoordorigin() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$64);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetCoordsize() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDSIZE$62);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlInteger xgetDgmlayout() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$108);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlInteger xgetDgmlayoutmru() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$112);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlInteger xgetDgmnodekind() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$110);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetDoubleclicknotify() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$76);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STColorType xgetFillcolor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$120);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.vml.STTrueFalse xgetFilled() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FILLED$118);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetForcedash() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FORCEDASH$142);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetHr() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HR$84);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STHrAlign xgetHralign() {
        STHrAlign sTHrAlignFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_default_attribute_value(qName);
            }
        }
        return sTHrAlignFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetHref() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(HREF$52);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetHrnoshade() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$88);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlFloat xgetHrpct() {
        XmlFloat xmlFloatFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_attribute_user = get_store().find_attribute_user(HRPCT$90);
        }
        return xmlFloatFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetHrstd() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRSTD$86);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetId() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ID$48);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_default_attribute_value(qName);
            }
        }
        return sTInsetModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.vml.STTrueFalse xgetInsetpen() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(INSETPEN$130);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetMaster() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(MASTER$158);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalseBlank xgetOle() {
        STTrueFalseBlank sTTrueFalseBlankFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlankFind_attribute_user = get_store().find_attribute_user(OLE$146);
        }
        return sTTrueFalseBlankFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetOleicon() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(OLEICON$144);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetOned() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ONED$72);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetOpacity() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(OPACITY$122);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetPath2() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(PATH2$156);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetPreferrelative() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$148);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.vml.STTrueFalse xgetPrint() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(PRINT$68);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlInteger xgetRegroupid() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(REGROUPID$74);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetSpid() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(SPID$70);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlFloat xgetSpt() {
        XmlFloat xmlFloatFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_attribute_user = get_store().find_attribute_user(SPT$132);
        }
        return xmlFloatFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STColorType xgetStrokecolor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(STROKECOLOR$126);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.vml.STTrueFalse xgetStroked() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(STROKED$124);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetStrokeweight() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STROKEWEIGHT$128);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetStyle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STYLE$50);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetTarget() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TARGET$54);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetTitle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TITLE$58);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetUserdrawn() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERDRAWN$98);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetUserhidden() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$80);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetWrapcoords() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$66);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetAdj(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$154;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetAllowincell(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$94;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetAllowoverlap(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$96;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetAlt(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$60;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBorderbottomcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$104;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBorderleftcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$102;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBorderrightcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$106;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBordertopcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$100;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBullet(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$82;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetButton(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$78;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBwmode(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$136;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBwnormal(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$140;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBwpure(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$138;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetChromakey(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$116;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetClass1(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$56;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetClip(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$152;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetCliptowrap(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$150;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetConnectortype(STConnectorType sTConnectorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            STConnectorType sTConnectorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTConnectorTypeFind_attribute_user == null) {
                sTConnectorTypeFind_attribute_user = (STConnectorType) get_store().add_attribute_user(qName);
            }
            sTConnectorTypeFind_attribute_user.set(sTConnectorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetCoordorigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$64;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetCoordsize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$62;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetDgmlayout(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$108;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetDgmlayoutmru(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$112;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetDgmnodekind(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$110;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetDoubleclicknotify(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$76;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetFillcolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$120;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetFilled(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$118;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetForcedash(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$142;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHr(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$84;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHralign(STHrAlign sTHrAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            STHrAlign sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_store().add_attribute_user(qName);
            }
            sTHrAlignFind_attribute_user.set(sTHrAlign);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$52;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHrnoshade(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$88;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHrpct(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$90;
            XmlFloat xmlFloatFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlFloatFind_attribute_user == null) {
                xmlFloatFind_attribute_user = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloatFind_attribute_user.set(xmlFloat);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHrstd(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$86;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$48;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            STInsetMode sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_store().add_attribute_user(qName);
            }
            sTInsetModeFind_attribute_user.set(sTInsetMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetInsetpen(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$130;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetMaster(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTER$158;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetOle(STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$146;
            STTrueFalseBlank sTTrueFalseBlankFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseBlankFind_attribute_user == null) {
                sTTrueFalseBlankFind_attribute_user = (STTrueFalseBlank) get_store().add_attribute_user(qName);
            }
            sTTrueFalseBlankFind_attribute_user.set(sTTrueFalseBlank);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetOleicon(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$144;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetOned(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$72;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$122;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetPath2(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$156;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetPreferrelative(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$148;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetPrint(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$68;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetRegroupid(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$74;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetSpid(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$70;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetSpt(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$132;
            XmlFloat xmlFloatFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlFloatFind_attribute_user == null) {
                xmlFloatFind_attribute_user = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloatFind_attribute_user.set(xmlFloat);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetStrokecolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$126;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetStroked(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$124;
            com.microsoft.schemas.vml.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetStrokeweight(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$128;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$50;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$54;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$58;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetUserdrawn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$98;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetUserhidden(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$80;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetWrapcoords(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$66;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
