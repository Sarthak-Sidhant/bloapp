package in.gov.eci.bloapp.views.activity.newsir.model;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class MappingPayload {
    public String algoApplicantCategory;
    public AlgoMapping algoMapping;
    public boolean applicantEligibleInPrevSir;
    public BloMapping bloMapping;

    public boolean isApplicantEligibleInPrevSir() {
        return this.applicantEligibleInPrevSir;
    }

    public void setApplicantEligibleInPrevSir(boolean applicantEligibleInPrevSir) {
        this.applicantEligibleInPrevSir = applicantEligibleInPrevSir;
    }

    public String getAlgoApplicantCategory() {
        return this.algoApplicantCategory;
    }

    public void setAlgoApplicantCategory(String algoApplicantCategory) {
        this.algoApplicantCategory = algoApplicantCategory;
    }

    public BloMapping getBloMapping() {
        return this.bloMapping;
    }

    public void setBloMapping(BloMapping bloMapping) {
        this.bloMapping = bloMapping;
    }

    public AlgoMapping getAlgoMapping() {
        return this.algoMapping;
    }

    public void setAlgoMapping(AlgoMapping algoMapping) {
        this.algoMapping = algoMapping;
    }
}
