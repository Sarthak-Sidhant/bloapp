package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.CTF;
import com.microsoft.schemas.vml.CTFormulas;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CTFormulasImpl extends XmlComplexContentImpl implements CTFormulas {
    private static final QName F$0 = new QName("urn:schemas-microsoft-com:vml", "f");
    private static final long serialVersionUID = 1;

    public CTFormulasImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public CTF addNewF() {
        CTF ctfAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfAdd_element_user = get_store().add_element_user(F$0);
        }
        return ctfAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public CTF getFArray(int i) {
        CTF ctfFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfFind_element_user = get_store().find_element_user(F$0, i);
            if (ctfFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctfFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    @Deprecated
    public CTF[] getFArray() {
        CTF[] ctfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(F$0, arrayList);
            ctfArr = new CTF[arrayList.size()];
            arrayList.toArray(ctfArr);
        }
        return ctfArr;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public List<CTF> getFList() {
        AbstractList<CTF> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTF>() { // from class: com.microsoft.schemas.vml.impl.CTFormulasImpl.1FList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTF ctf) {
                    CTFormulasImpl.this.insertNewF(i).set(ctf);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTF get(int i) {
                    return CTFormulasImpl.this.getFArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTF remove(int i) {
                    CTF fArray = CTFormulasImpl.this.getFArray(i);
                    CTFormulasImpl.this.removeF(i);
                    return fArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTF set(int i, CTF ctf) {
                    CTF fArray = CTFormulasImpl.this.getFArray(i);
                    CTFormulasImpl.this.setFArray(i, ctf);
                    return fArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTFormulasImpl.this.sizeOfFArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public CTF insertNewF(int i) {
        CTF ctfInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfInsert_element_user = get_store().insert_element_user(F$0, i);
        }
        return ctfInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public void removeF(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(F$0, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public void setFArray(int i, CTF ctf) {
        generatedSetterHelperImpl(ctf, F$0, i, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public void setFArray(CTF[] ctfArr) {
        check_orphaned();
        arraySetterHelper(ctfArr, F$0);
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public int sizeOfFArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(F$0);
        }
        return iCount_elements;
    }
}
