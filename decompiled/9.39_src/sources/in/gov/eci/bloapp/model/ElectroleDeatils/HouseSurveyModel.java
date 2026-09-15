package in.gov.eci.bloapp.model.ElectroleDeatils;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class HouseSurveyModel {

    public static class Payload {
        String bloId;
        String epicNo;
        String houseNo;
        String lastSyncStatus;
        String modifiedOn;
        String partNo;
        String sectionNo;

        @SerializedName("epicNo")
        public String getEpicNo() {
            return this.epicNo;
        }

        public void setEpicNo(String epicNo) {
            this.epicNo = epicNo;
        }

        @SerializedName("houseNo")
        public String getHouseNo() {
            return this.houseNo;
        }

        public void setHouseNo(String houseNo) {
            this.houseNo = houseNo;
        }

        @SerializedName("sectionNo")
        public String getSectionNo() {
            return this.sectionNo;
        }

        public void setSectionNo(String sectionNo) {
            this.sectionNo = sectionNo;
        }

        public String getPartNo() {
            return this.partNo;
        }

        public void setPartNo(String partNo) {
            this.partNo = partNo;
        }

        public String getBloId() {
            return this.bloId;
        }

        public Payload(String epicNo, String houseNo, String sectionNo, String partNo, String bloId, String modifiedOn, String lastSyncStatus) {
            this.epicNo = epicNo;
            this.houseNo = houseNo;
            this.sectionNo = sectionNo;
            this.partNo = partNo;
            this.bloId = bloId;
            this.modifiedOn = modifiedOn;
            this.lastSyncStatus = lastSyncStatus;
        }

        public void setBloId(String bloId) {
            this.bloId = bloId;
        }

        public String getModifiedOn() {
            return this.modifiedOn;
        }

        public void setModifiedOn(String modifiedOn) {
            this.modifiedOn = modifiedOn;
        }

        public String getLastSyncStatus() {
            return this.lastSyncStatus;
        }

        public void setLastSyncStatus(String lastSyncStatus) {
            this.lastSyncStatus = lastSyncStatus;
        }
    }

    public static class Root {
        Object message;
        ArrayList<Payload> payload;
        Object refId;
        String status;
        int statusCode;

        @SerializedName("status")
        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @SerializedName("statusCode")
        public int getStatusCode() {
            return this.statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        @SerializedName("refId")
        public Object getRefId() {
            return this.refId;
        }

        public void setRefId(Object refId) {
            this.refId = refId;
        }

        @SerializedName("message")
        public Object getMessage() {
            return this.message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }

        @SerializedName("payload")
        public ArrayList<Payload> getPayload() {
            return this.payload;
        }

        public void setPayload(ArrayList<Payload> payload) {
            this.payload = payload;
        }
    }
}
