package in.gov.eci.bloapp.model.ElectroleDeatils;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class H2HSurveyStatusModel {

    public static class Payload {
        int acNo;
        String applicantFirstName;
        String applicantLastName;
        String bloId;
        String epicNo;
        String form7Status;
        String form8Status;
        String h2HMarking;
        String lastSyncStatus;
        String modifiedOn;
        String partName;
        int partNo;
        int serialNo;
        String submissionDate;

        @SerializedName("epicNo")
        public String getEpicNo() {
            return this.epicNo;
        }

        public void setEpicNo(String epicNo) {
            this.epicNo = epicNo;
        }

        @SerializedName("partName")
        public String getPartName() {
            return this.partName;
        }

        public Payload(String epicNo, String partName, int acNo, int partNo, int serialNo, String applicantFirstName, String applicantLastName, String submissionDate, String h2HMarking, String form7Status, String form8Status, String bloId, String modifiedOn, String lastSyncStatus) {
            this.epicNo = epicNo;
            this.partName = partName;
            this.acNo = acNo;
            this.partNo = partNo;
            this.serialNo = serialNo;
            this.applicantFirstName = applicantFirstName;
            this.applicantLastName = applicantLastName;
            this.submissionDate = submissionDate;
            this.h2HMarking = h2HMarking;
            this.form7Status = form7Status;
            this.form8Status = form8Status;
            this.bloId = bloId;
            this.modifiedOn = modifiedOn;
            this.lastSyncStatus = lastSyncStatus;
        }

        public Payload(String epicNo, int acNo, int serialNo, String applicantFirstName, String applicantLastName, String submissionDate, String h2HMarking, String formStatus) {
            this.epicNo = epicNo;
            this.acNo = acNo;
            this.serialNo = serialNo;
            this.applicantFirstName = applicantFirstName;
            this.applicantLastName = applicantLastName;
            this.submissionDate = submissionDate;
            this.h2HMarking = h2HMarking;
            this.form7Status = formStatus;
        }

        public void setPartName(String partName) {
            this.partName = partName;
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

        @SerializedName("serialNo")
        public int getSerialNo() {
            return this.serialNo;
        }

        public void setSerialNo(int serialNo) {
            this.serialNo = serialNo;
        }

        @SerializedName("applicantFirstName")
        public String getApplicantFirstName() {
            return this.applicantFirstName;
        }

        public void setApplicantFirstName(String applicantFirstName) {
            this.applicantFirstName = applicantFirstName;
        }

        @SerializedName("applicantLastName")
        public String getApplicantLastName() {
            return this.applicantLastName;
        }

        public void setApplicantLastName(String applicantLastName) {
            this.applicantLastName = applicantLastName;
        }

        @SerializedName("submissionDate")
        public String getSubmissionDate() {
            return this.submissionDate;
        }

        public void setSubmissionDate(String submissionDate) {
            this.submissionDate = submissionDate;
        }

        @SerializedName("h2HMarking")
        public String getH2HMarking() {
            return this.h2HMarking;
        }

        public void setH2HMarking(String h2HMarking) {
            this.h2HMarking = h2HMarking;
        }

        @SerializedName("form7Status")
        public String getForm7Status() {
            return this.form7Status;
        }

        public void setForm7Status(String form7Status) {
            this.form7Status = form7Status;
        }

        @SerializedName("form8Status")
        public String getForm8Status() {
            return this.form8Status;
        }

        public void setForm8Status(String form8Status) {
            this.form8Status = form8Status;
        }

        public String getBloId() {
            return this.bloId;
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

    public class Root {
        Object message;
        ArrayList<Payload> payload;
        Object refId;
        String status;
        int statusCode;

        public Root() {
        }

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
