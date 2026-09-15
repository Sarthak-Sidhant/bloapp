package in.gov.eci.bloapp.model.check_list_form_6;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SectionNumberModel implements Serializable {

    public static class Root implements Serializable {
        int acNo;
        String blockNo;
        int capacity;
        String createdBy;
        Date createdDttm;
        String districtCd;
        int districtNo;
        String effectiveFrom;
        String effectiveTo;
        int id;
        String isActive;
        Object modifiedBy;
        Object modifiedDttm;
        String panchayatId;
        int partNo;
        Object pinCode;
        String poId;
        String psId;
        String sectionId;
        String sectionName;
        String sectionNameL1;
        Object sectionNameL2;
        int sectionNo;
        String sectionType;
        Object sectionTypeL1;
        Object sectionTypeL2;
        String stateCd;
        String tehsilNo;
        Object townId;
        String townNo;
        Object villageId;
        Object wardNo;

        public Root(int sectionNo, String sectionName) {
            this.sectionName = sectionName;
            this.sectionNo = sectionNo;
        }

        @SerializedName("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @SerializedName("stateCd")
        public String getStateCd() {
            return this.stateCd;
        }

        public void setStateCd(String stateCd) {
            this.stateCd = stateCd;
        }

        @SerializedName("districtCd")
        public String getDistrictCd() {
            return this.districtCd;
        }

        public void setDistrictCd(String districtCd) {
            this.districtCd = districtCd;
        }

        @SerializedName("acNo")
        public int getAcNo() {
            return this.acNo;
        }

        public void setAcNo(int acNo) {
            this.acNo = acNo;
        }

        @SerializedName("partNo")
        public int getPartNo() {
            return this.partNo;
        }

        public void setPartNo(int partNo) {
            this.partNo = partNo;
        }

        @SerializedName("sectionId")
        public String getSectionId() {
            return this.sectionId;
        }

        public void setSectionId(String sectionId) {
            this.sectionId = sectionId;
        }

        @SerializedName("sectionName")
        public String getSectionName() {
            return this.sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        @SerializedName("sectionNameL1")
        public String getSectionNameL1() {
            return this.sectionNameL1;
        }

        public void setSectionNameL1(String sectionNameL1) {
            this.sectionNameL1 = sectionNameL1;
        }

        @SerializedName("sectionNameL2")
        public Object getSectionNameL2() {
            return this.sectionNameL2;
        }

        public void setSectionNameL2(Object sectionNameL2) {
            this.sectionNameL2 = sectionNameL2;
        }

        @SerializedName("townId")
        public Object getTownId() {
            return this.townId;
        }

        public void setTownId(Object townId) {
            this.townId = townId;
        }

        @SerializedName("villageId")
        public Object getVillageId() {
            return this.villageId;
        }

        public void setVillageId(Object villageId) {
            this.villageId = villageId;
        }

        @SerializedName("panchayatId")
        public String getPanchayatId() {
            return this.panchayatId;
        }

        public void setPanchayatId(String panchayatId) {
            this.panchayatId = panchayatId;
        }

        @SerializedName("pinCode")
        public Object getPinCode() {
            return this.pinCode;
        }

        public void setPinCode(Object pinCode) {
            this.pinCode = pinCode;
        }

        @SerializedName("districtNo")
        public int getDistrictNo() {
            return this.districtNo;
        }

        public void setDistrictNo(int districtNo) {
            this.districtNo = districtNo;
        }

        @SerializedName("wardNo")
        public Object getWardNo() {
            return this.wardNo;
        }

        public void setWardNo(Object wardNo) {
            this.wardNo = wardNo;
        }

        @SerializedName("blockNo")
        public String getBlockNo() {
            return this.blockNo;
        }

        public void setBlockNo(String blockNo) {
            this.blockNo = blockNo;
        }

        @SerializedName("poId")
        public String getPoId() {
            return this.poId;
        }

        public void setPoId(String poId) {
            this.poId = poId;
        }

        @SerializedName("psId")
        public String getPsId() {
            return this.psId;
        }

        public void setPsId(String psId) {
            this.psId = psId;
        }

        @SerializedName("capacity")
        public int getCapacity() {
            return this.capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        @SerializedName("sectionType")
        public String getSectionType() {
            return this.sectionType;
        }

        public void setSectionType(String sectionType) {
            this.sectionType = sectionType;
        }

        @SerializedName("sectionTypeL1")
        public Object getSectionTypeL1() {
            return this.sectionTypeL1;
        }

        public void setSectionTypeL1(Object sectionTypeL1) {
            this.sectionTypeL1 = sectionTypeL1;
        }

        @SerializedName("sectionTypeL2")
        public Object getSectionTypeL2() {
            return this.sectionTypeL2;
        }

        public void setSectionTypeL2(Object sectionTypeL2) {
            this.sectionTypeL2 = sectionTypeL2;
        }

        @SerializedName("effectiveFrom")
        public String getEffectiveFrom() {
            return this.effectiveFrom;
        }

        public void setEffectiveFrom(String effectiveFrom) {
            this.effectiveFrom = effectiveFrom;
        }

        @SerializedName("effectiveTo")
        public String getEffectiveTo() {
            return this.effectiveTo;
        }

        public void setEffectiveTo(String effectiveTo) {
            this.effectiveTo = effectiveTo;
        }

        @SerializedName("isActive")
        public String getIsActive() {
            return this.isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        @SerializedName("createdBy")
        public String getCreatedBy() {
            return this.createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        @SerializedName("createdDttm")
        public Date getCreatedDttm() {
            return this.createdDttm;
        }

        public void setCreatedDttm(Date createdDttm) {
            this.createdDttm = createdDttm;
        }

        @SerializedName("modifiedBy")
        public Object getModifiedBy() {
            return this.modifiedBy;
        }

        public void setModifiedBy(Object modifiedBy) {
            this.modifiedBy = modifiedBy;
        }

        @SerializedName("modifiedDttm")
        public Object getModifiedDttm() {
            return this.modifiedDttm;
        }

        public void setModifiedDttm(Object modifiedDttm) {
            this.modifiedDttm = modifiedDttm;
        }

        @SerializedName("tehsilNo")
        public String getTehsilNo() {
            return this.tehsilNo;
        }

        public void setTehsilNo(String tehsilNo) {
            this.tehsilNo = tehsilNo;
        }

        @SerializedName("sectionNo")
        public int getSectionNo() {
            return this.sectionNo;
        }

        public void setSectionNo(int sectionNo) {
            this.sectionNo = sectionNo;
        }

        @SerializedName("townNo")
        public String getTownNo() {
            return this.townNo;
        }

        public void setTownNo(String townNo) {
            this.townNo = townNo;
        }
    }
}
