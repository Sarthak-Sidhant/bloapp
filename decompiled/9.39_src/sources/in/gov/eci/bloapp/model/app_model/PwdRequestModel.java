package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class PwdRequestModel {

    @SerializedName("APPLICANT_NAME")
    public String applicantName;

    @SerializedName("COMPLETED_STATUS")
    public String completedProcessedDate;

    @SerializedName("FORM_STATUS")
    public String formStatus;

    @SerializedName("GENERATED_REFERENCE_NUMBER")
    public String generatedReferenceNumber;

    @SerializedName("REFERENCE_NUMBER")
    public String referenceNumber;

    @SerializedName("REMARK")
    public String remark;

    @SerializedName("REQUEST_PROCESSED_DATE")
    public String requestProcessedDate;

    @SerializedName("SUBMISSION_DATE")
    public String submissionDate;

    @SerializedName("TYPE_OF_REQUEST")
    public String typeOfRequest;

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public String getSubmissionDate() {
        return this.submissionDate;
    }

    public String getApplicantName() {
        return this.applicantName;
    }

    public String getTypeOfRequest() {
        return this.typeOfRequest;
    }

    public String completedProcessedDate() {
        return this.completedProcessedDate;
    }

    public String getFormStatus() {
        return this.formStatus;
    }

    public String getRequestProcessedDate() {
        return this.requestProcessedDate;
    }

    public String getGeneratedReferenceNumber() {
        return this.generatedReferenceNumber;
    }

    public String getRemark() {
        return this.remark;
    }

    public PwdRequestModel(String referenceNumber, String submissionDate, String applicantName, String typeOfRequest, String formStatus, String requestProcessedDate, String completedProcessedDate, String generatedReferenceNumber, String remark) {
        this.referenceNumber = referenceNumber;
        this.submissionDate = submissionDate;
        this.applicantName = applicantName;
        this.typeOfRequest = typeOfRequest;
        this.formStatus = formStatus;
        this.requestProcessedDate = requestProcessedDate;
        this.completedProcessedDate = completedProcessedDate;
        this.generatedReferenceNumber = generatedReferenceNumber;
        this.remark = remark;
    }
}
