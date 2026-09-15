package in.gov.eci.bloapp.api.model;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SIRResponseData {
    private String message;
    private StatusPaylod payload;
    private String refId;
    private String status;
    private String statusCode;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StatusPaylod getPayload() {
        return this.payload;
    }

    public void setPayload(StatusPaylod payload) {
        this.payload = payload;
    }

    public class StatusPaylod {
        String additionalCommentTab;
        String alreadyFilledFormSentBack;
        String alreadyFilledFormSentBackMarkUnButton;
        String autoFaceDetection;
        String deceasedElectors;
        String draftList;
        String duplicateVerification;
        String efDashBoard;
        String efDistributionTracker;
        int efPhotoFlag;
        String electorsAnomaly;
        String epicMatchFillEF;
        String faceRecognition;
        String fillEnumerationForm;
        String flag;
        String formsCount;
        String isElectorUpload;
        String isOnlineSirFlag;
        String lastSIRYear;
        String logicalDiscrepancies;
        String markUncollectableSentBack;
        String migratedElectors;
        String noMapping;
        String offlineTab;
        String pendingElectors;
        String postDraft;
        String pseVerification;
        String reverifyMarkUncollectable;
        String reverifyUploadDocs;
        String scheduleHearingNotice;
        String selectPhoto;
        String sentBackByEro;
        String stateCd;
        String updateMobile;
        String uploadAttendance;
        String uploadBLOMOM;
        String uploadEfForUncollected;
        String verifyFormsFilled;
        String verifyMarkUncollectable;
        String viewDocCitizen;
        String viewModifiedByAEROERO;
        String viewPostAnomaly;

        public StatusPaylod() {
        }

        public String getStateCd() {
            return this.stateCd;
        }

        public void setStateCd(String stateCd) {
            this.stateCd = stateCd;
        }

        public String getFlag() {
            return this.flag;
        }

        public String getEfDistributionTracker() {
            return this.efDistributionTracker;
        }

        public void setEfDistributionTracker(String efDistributionTracker) {
            this.efDistributionTracker = efDistributionTracker;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getPendingElectors() {
            return this.pendingElectors;
        }

        public void setPendingElectors(String pendingElectors) {
            this.pendingElectors = pendingElectors;
        }

        public String getFillEnumerationForm() {
            return this.fillEnumerationForm;
        }

        public void setFillEnumerationForm(String fillEnumerationForm) {
            this.fillEnumerationForm = fillEnumerationForm;
        }

        public String getVerifyFormsFilled() {
            return this.verifyFormsFilled;
        }

        public void setVerifyFormsFilled(String verifyFormsFilled) {
            this.verifyFormsFilled = verifyFormsFilled;
        }

        public String getReverifyUploadDocs() {
            return this.reverifyUploadDocs;
        }

        public void setReverifyUploadDocs(String reverifyUploadDocs) {
            this.reverifyUploadDocs = reverifyUploadDocs;
        }

        public String getSentBackByEro() {
            return this.sentBackByEro;
        }

        public void setSentBackByEro(String sentBackByEro) {
            this.sentBackByEro = sentBackByEro;
        }

        public String getUploadEfForUncollected() {
            return this.uploadEfForUncollected;
        }

        public void setUploadEfForUncollected(String uploadEfForUncollected) {
            this.uploadEfForUncollected = uploadEfForUncollected;
        }

        public String getMarkUncollectableSentBack() {
            return this.markUncollectableSentBack;
        }

        public void setMarkUncollectableSentBack(String markUncollectableSentBack) {
            this.markUncollectableSentBack = markUncollectableSentBack;
        }

        public String getAlreadyFilledFormSentBack() {
            return this.alreadyFilledFormSentBack;
        }

        public void setAlreadyFilledFormSentBack(String alreadyFilledFormSentBack) {
            this.alreadyFilledFormSentBack = alreadyFilledFormSentBack;
        }

        public String getAlreadyFilledFormSentBackMarkUnButton() {
            return this.alreadyFilledFormSentBackMarkUnButton;
        }

        public void setAlreadyFilledFormSentBackMarkUnButton(String alreadyFilledFormSentBackMarkUnButton) {
            this.alreadyFilledFormSentBackMarkUnButton = alreadyFilledFormSentBackMarkUnButton;
        }

        public String getViewModifiedByAEROERO() {
            return this.viewModifiedByAEROERO;
        }

        public void setViewModifiedByAEROERO(String viewModifiedByAEROERO) {
            this.viewModifiedByAEROERO = viewModifiedByAEROERO;
        }

        public String getOfflineTab() {
            return this.offlineTab;
        }

        public void setOfflineTab(String offlineTab) {
            this.offlineTab = offlineTab;
        }

        public String getAdditionalCommentTab() {
            return this.additionalCommentTab;
        }

        public void setAdditionalCommentTab(String additionalCommentTab) {
            this.additionalCommentTab = additionalCommentTab;
        }

        public String getViewPostAnomaly() {
            return this.viewPostAnomaly;
        }

        public void setViewPostAnomaly(String viewPostAnomaly) {
            this.viewPostAnomaly = viewPostAnomaly;
        }

        public String getPostDraft() {
            return this.postDraft;
        }

        public void setPostDraft(String postDraft) {
            this.postDraft = postDraft;
        }

        public String getMigratedElectors() {
            return this.migratedElectors;
        }

        public void setMigratedElectors(String migratedElectors) {
            this.migratedElectors = migratedElectors;
        }

        public String getSelectPhoto() {
            return this.selectPhoto;
        }

        public void setSelectPhoto(String selectPhoto) {
            this.selectPhoto = selectPhoto;
        }

        public String getDraftList() {
            return this.draftList;
        }

        public void setDraftList(String draftList) {
            this.draftList = draftList;
        }

        public String getPseVerification() {
            return this.pseVerification;
        }

        public void setPseVerification(String pseVerification) {
            this.pseVerification = pseVerification;
        }

        public String getFormsCount() {
            return this.formsCount;
        }

        public void setFormsCount(String formsCount) {
            this.formsCount = formsCount;
        }

        public String getAnomaly() {
            return this.logicalDiscrepancies;
        }

        public void setAnomaly(String logicaldescrip) {
            this.logicalDiscrepancies = logicaldescrip;
        }

        public String getNoMapping() {
            return this.noMapping;
        }

        public void setNoMapping(String noMapping) {
            this.noMapping = noMapping;
        }

        public String getDuplicateVerification() {
            return this.duplicateVerification;
        }

        public void setDuplicateVerification(String duplicateVerification) {
            this.duplicateVerification = duplicateVerification;
        }

        public String getDeceasedElectors() {
            return this.deceasedElectors;
        }

        public void setDeceasedElectors(String deceasedElectors) {
            this.deceasedElectors = deceasedElectors;
        }

        public String getElectorsAnomaly() {
            return this.electorsAnomaly;
        }

        public void setElectorsAnomaly(String electorsAnomaly) {
            this.electorsAnomaly = electorsAnomaly;
        }

        public String getVerifyMarkUncollectable() {
            return this.verifyMarkUncollectable;
        }

        public void setVerifyMarkUncollectable(String verifyMarkUncollectable) {
            this.verifyMarkUncollectable = verifyMarkUncollectable;
        }

        public String getReverifyMarkUncollectable() {
            return this.reverifyMarkUncollectable;
        }

        public void setReverifyMarkUncollectable(String reverifyMarkUncollectable) {
            this.reverifyMarkUncollectable = reverifyMarkUncollectable;
        }

        public int getEfPhotoFlag() {
            return this.efPhotoFlag;
        }

        public void setEfPhotoFlag(int efPhotoFlag) {
            this.efPhotoFlag = efPhotoFlag;
        }

        public String getEfDashBoard() {
            return this.efDashBoard;
        }

        public void setEfDashBoard(String efDashBoard) {
            this.efDashBoard = efDashBoard;
        }

        public String getLastSIRYear() {
            return this.lastSIRYear;
        }

        public void setLastSIRYear(String lastSIRYear) {
            this.lastSIRYear = lastSIRYear;
        }

        public String getIsElectorUpload() {
            return this.isElectorUpload;
        }

        public void setIsElectorUpload(String isElectorUpload) {
            this.isElectorUpload = isElectorUpload;
        }

        public String getUploadAttendance() {
            return this.uploadAttendance;
        }

        public void setUploadAttendance(String uploadAttendance) {
            this.uploadAttendance = uploadAttendance;
        }

        public String getAutoFaceDetection() {
            return this.autoFaceDetection;
        }

        public void setAutoFaceDetection(String autoFaceDetection) {
            this.autoFaceDetection = autoFaceDetection;
        }

        public String getScheduleHearingNotice() {
            return this.scheduleHearingNotice;
        }

        public void setScheduleHearingNotice(String scheduleHearingNotice) {
            this.scheduleHearingNotice = scheduleHearingNotice;
        }

        public String getUploadBLOMOM() {
            return this.uploadBLOMOM;
        }

        public void setUploadBLOMOM(String uploadBLOMOM) {
            this.uploadBLOMOM = uploadBLOMOM;
        }

        public String getViewDocCitizen() {
            return this.viewDocCitizen;
        }

        public void setViewDocCitizen(String viewDocCitizen) {
            this.viewDocCitizen = viewDocCitizen;
        }

        public String getUpdateMobile() {
            return this.updateMobile;
        }

        public void setUpdateMobile(String updateMobile) {
            this.updateMobile = updateMobile;
        }

        public String getEpicMatchFillEF() {
            return this.epicMatchFillEF;
        }

        public void setEpicMatchFillEF(String epicMatchFillEF) {
            this.epicMatchFillEF = epicMatchFillEF;
        }

        public String getFaceRecognition() {
            return this.faceRecognition;
        }

        public void setFaceRecognition(String faceRecognition) {
            this.faceRecognition = faceRecognition;
        }

        public String getIsOnlineSirFlag() {
            return this.isOnlineSirFlag;
        }

        public void setIsOnlineSirFlag(String isOnlineSirFlag) {
            this.isOnlineSirFlag = isOnlineSirFlag;
        }
    }
}
