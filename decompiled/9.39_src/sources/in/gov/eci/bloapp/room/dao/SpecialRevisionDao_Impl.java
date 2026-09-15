package in.gov.eci.bloapp.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class SpecialRevisionDao_Impl implements SpecialRevisionDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<SpecialSurveyRevisionModel> __insertAdapterOfSpecialSurveyRevisionModel = new EntityInsertAdapter<SpecialSurveyRevisionModel>() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl.1
        protected String createQuery() {
            return "INSERT OR REPLACE INTO `special_revision_survey` (`EPIC_ID`,`STATE_CD`,`EPIC_NO`,`HOUSE_NO`,`DOB_VERIFIED`,`EROLL_DOB`,`DISTRICT_CD`,`AC_NO`,`PART_NO`,`PART_SERIAL_NO`,`CREATED_DTTM`,`CREATED_BY`,`MODIFIED_DTTM`,`MODIFIED_BY`,`PHOTO_URL`,`SR_FORM_PAGE_1_URL`,`CITIZENSHIP_TYPE`,`CITIZENSHIP_TYPE_CAT`,`LIST_1_DOC`,`LIST_2_DOC`,`LIST_3_DOC`,`LIST_4_DOC`,`LIST_5_DOC`,`LIST_6_DOC`,`LIST_7_DOC`,`LIST_1_DOC_URL`,`LIST_2_DOC_URL`,`LIST_3_DOC_URL`,`LIST_4_DOC_URL`,`LIST_5_DOC_URL`,`LIST_6_DOC_URL`,`LIST_7_DOC_URL`,`SURVEY_CHANNEL`,`AADHAR_NO`,`MOBILE_NO`,`FATHERS_OR_GUARDIAN_NAME`,`FATHERS_OR_GUARDIAN_EPIC_NO`,`MOTHERS_NAME`,`MOTHERS_EPIC_NO`,`SPOUSE_NAME`,`SPOUSE_EPIC_NO`,`ANNEXURE_C_URL`,`PRE_REVISION_VOTER_FLG`,`PRE_REVISION_VOTER_DOC_URL`,`SUBMITTED_FOR_RECOMMENDATION`,`FATHERS_NATIONALITY`,`MOTHERS_NATIONALITY`,`SR_FORM_PAGE_2_URL`,`OLD_AC_NO`,`OLD_PART_NO`,`OLD_PSL_NO`,`F_OLD_AC_NO`,`F_OLD_PART_NO`,`F_OLD_PSL_NO`,`M_OLD_AC_NO`,`M_OLD_PART_NO`,`M_OLD_PSL_NO`,`LIST_8_DOC`,`DOCUMENT_UPLOADED_FLG`,`citizen_signature_filepath`,`FORM_SUBMISSION_PLACE`,`LIST_1_DOC_URL_PG2`,`LIST_2_DOC_URL_PG2`,`LIST_3_DOC_URL_PG2`,`LIST_4_DOC_URL_PG2`,`LIST_5_DOC_URL_PG2`,`LIST_5_DOC_URL_PG3`,`LIST_6_DOC_URL_PG2`,`LIST_7_DOC_URL_PG2`,`PRE_REVISION_VOTER_DOC_URL_PG2`,`ANNEXURE_C_URL_PG2`,`IP_ADDRESS`,`USER_ID`,`IS_LEGACY_OPT`,`BLO_OVER_RIDDEN_FLG`,`EMAIL_ID`,`PASSPORT_NO`,`ELECTOR_TYPE`,`ELECTOR_NAME`,`PRV_PARTNO`,`PRV_PARTSLNO`,`PRV_CAT`,`RELATION_TYPE`,`RELATION_PROOF_DOC_URL_PG1`,`RELATION_PROOF_DOC_URL_PG2`,`RELATION_OLD_AC_NO`,`RELATION_OLD_PART_NO`,`RELATION_OLD_PSL_NO`,`RELATION_DOC_TYPE`,`RELATION_DOC_URL_PG1`,`RELATION_DOC_URL_PG2`,`IS_RELATIVE_PRE_VOTER_FLG`,`RELATION_EPIC_NO`,`IS_THIS_YOU_FLG`,`IS_THIS_YOU_REL_FLG`,`RELATION_OLD_STATE_CD`,`OLD_STATE_CD`,`tabName`,`COMMENTS`,`REQUEST_STATUS_CODE`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final SpecialSurveyRevisionModel entity) {
            if (entity.getEpic_id() == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.getEpic_id().longValue());
            }
            if (entity.getState_cd() == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.getState_cd());
            }
            if (entity.getEpic_no() == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.getEpic_no());
            }
            if (entity.getHouse_no() == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.getHouse_no());
            }
            if (entity.getDob_verified() == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.getDob_verified());
            }
            if (entity.getEroll_dob() == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.getEroll_dob());
            }
            if (entity.getDistrict_cd() == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.getDistrict_cd());
            }
            if (entity.getAc_no() == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.getAc_no());
            }
            if (entity.getPart_no() == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.getPart_no());
            }
            if (entity.getPart_serial_no() == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.getPart_serial_no());
            }
            if (entity.getCreated_dttm() == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.getCreated_dttm());
            }
            if (entity.getCreated_by() == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.getCreated_by());
            }
            if (entity.getModified_dttm() == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.getModified_dttm());
            }
            if (entity.getModified_by() == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.getModified_by());
            }
            if (entity.getPhoto_url() == null) {
                statement.bindNull(15);
            } else {
                statement.bindText(15, entity.getPhoto_url());
            }
            if (entity.getSr_form_page_1_url() == null) {
                statement.bindNull(16);
            } else {
                statement.bindText(16, entity.getSr_form_page_1_url());
            }
            if (entity.getCitizenship_type() == null) {
                statement.bindNull(17);
            } else {
                statement.bindText(17, entity.getCitizenship_type());
            }
            if (entity.getCitizenship_type_cat() == null) {
                statement.bindNull(18);
            } else {
                statement.bindText(18, entity.getCitizenship_type_cat());
            }
            if (entity.getList_1_doc() == null) {
                statement.bindNull(19);
            } else {
                statement.bindText(19, entity.getList_1_doc());
            }
            if (entity.getList_2_doc() == null) {
                statement.bindNull(20);
            } else {
                statement.bindText(20, entity.getList_2_doc());
            }
            if (entity.getList_3_doc() == null) {
                statement.bindNull(21);
            } else {
                statement.bindText(21, entity.getList_3_doc());
            }
            if (entity.getList_4_doc() == null) {
                statement.bindNull(22);
            } else {
                statement.bindText(22, entity.getList_4_doc());
            }
            if (entity.getList_5_doc() == null) {
                statement.bindNull(23);
            } else {
                statement.bindText(23, entity.getList_5_doc());
            }
            if (entity.getList_6_doc() == null) {
                statement.bindNull(24);
            } else {
                statement.bindText(24, entity.getList_6_doc());
            }
            if (entity.getList_7_doc() == null) {
                statement.bindNull(25);
            } else {
                statement.bindText(25, entity.getList_7_doc());
            }
            if (entity.getList_1_doc_url() == null) {
                statement.bindNull(26);
            } else {
                statement.bindText(26, entity.getList_1_doc_url());
            }
            if (entity.getList_2_doc_url() == null) {
                statement.bindNull(27);
            } else {
                statement.bindText(27, entity.getList_2_doc_url());
            }
            if (entity.getList_3_doc_url() == null) {
                statement.bindNull(28);
            } else {
                statement.bindText(28, entity.getList_3_doc_url());
            }
            if (entity.getList_4_doc_url() == null) {
                statement.bindNull(29);
            } else {
                statement.bindText(29, entity.getList_4_doc_url());
            }
            if (entity.getList_5_doc_url() == null) {
                statement.bindNull(30);
            } else {
                statement.bindText(30, entity.getList_5_doc_url());
            }
            if (entity.getList_6_doc_url() == null) {
                statement.bindNull(31);
            } else {
                statement.bindText(31, entity.getList_6_doc_url());
            }
            if (entity.getList_7_doc_url() == null) {
                statement.bindNull(32);
            } else {
                statement.bindText(32, entity.getList_7_doc_url());
            }
            if (entity.getSurvey_channel() == null) {
                statement.bindNull(33);
            } else {
                statement.bindText(33, entity.getSurvey_channel());
            }
            if (entity.getAadhaar_no() == null) {
                statement.bindNull(34);
            } else {
                statement.bindText(34, entity.getAadhaar_no());
            }
            if (entity.getMobile_no() == null) {
                statement.bindNull(35);
            } else {
                statement.bindText(35, entity.getMobile_no());
            }
            if (entity.getFather_or_guardian_name() == null) {
                statement.bindNull(36);
            } else {
                statement.bindText(36, entity.getFather_or_guardian_name());
            }
            if (entity.getFather_or_guardian_epic_no() == null) {
                statement.bindNull(37);
            } else {
                statement.bindText(37, entity.getFather_or_guardian_epic_no());
            }
            if (entity.getMothers_name() == null) {
                statement.bindNull(38);
            } else {
                statement.bindText(38, entity.getMothers_name());
            }
            if (entity.getMothers_epic_no() == null) {
                statement.bindNull(39);
            } else {
                statement.bindText(39, entity.getMothers_epic_no());
            }
            if (entity.getSpouse_name() == null) {
                statement.bindNull(40);
            } else {
                statement.bindText(40, entity.getSpouse_name());
            }
            if (entity.getSpouse_epic_no() == null) {
                statement.bindNull(41);
            } else {
                statement.bindText(41, entity.getSpouse_epic_no());
            }
            if (entity.getAnnexure_c_url() == null) {
                statement.bindNull(42);
            } else {
                statement.bindText(42, entity.getAnnexure_c_url());
            }
            if (entity.getPre_revision_voter_flag() == null) {
                statement.bindNull(43);
            } else {
                statement.bindText(43, entity.getPre_revision_voter_flag());
            }
            if (entity.getPre_revision_voter_doc_url() == null) {
                statement.bindNull(44);
            } else {
                statement.bindText(44, entity.getPre_revision_voter_doc_url());
            }
            if (entity.getSubmitted_for_recommendation() == null) {
                statement.bindNull(45);
            } else {
                statement.bindText(45, entity.getSubmitted_for_recommendation());
            }
            if (entity.getFather_nationality() == null) {
                statement.bindNull(46);
            } else {
                statement.bindText(46, entity.getFather_nationality());
            }
            if (entity.getMother_nationality() == null) {
                statement.bindNull(47);
            } else {
                statement.bindText(47, entity.getMother_nationality());
            }
            if (entity.getSr_form_page_2_url() == null) {
                statement.bindNull(48);
            } else {
                statement.bindText(48, entity.getSr_form_page_2_url());
            }
            if (entity.getOld_ac_no() == null) {
                statement.bindNull(49);
            } else {
                statement.bindText(49, entity.getOld_ac_no());
            }
            if (entity.getOld_part_no() == null) {
                statement.bindNull(50);
            } else {
                statement.bindText(50, entity.getOld_part_no());
            }
            if (entity.getOld_psl_no() == null) {
                statement.bindNull(51);
            } else {
                statement.bindText(51, entity.getOld_psl_no());
            }
            if (entity.getF_old_ac_no() == null) {
                statement.bindNull(52);
            } else {
                statement.bindText(52, entity.getF_old_ac_no());
            }
            if (entity.getF_old_part_no() == null) {
                statement.bindNull(53);
            } else {
                statement.bindText(53, entity.getF_old_part_no());
            }
            if (entity.getF_old_psl_no() == null) {
                statement.bindNull(54);
            } else {
                statement.bindText(54, entity.getF_old_psl_no());
            }
            if (entity.getM_old_ac_no() == null) {
                statement.bindNull(55);
            } else {
                statement.bindText(55, entity.getM_old_ac_no());
            }
            if (entity.getM_old_part_no() == null) {
                statement.bindNull(56);
            } else {
                statement.bindText(56, entity.getM_old_part_no());
            }
            if (entity.getM_old_psl_no() == null) {
                statement.bindNull(57);
            } else {
                statement.bindText(57, entity.getM_old_psl_no());
            }
            if (entity.getList_8_doc() == null) {
                statement.bindNull(58);
            } else {
                statement.bindText(58, entity.getList_8_doc());
            }
            if (entity.getDocument_uploaded_flag() == null) {
                statement.bindNull(59);
            } else {
                statement.bindText(59, entity.getDocument_uploaded_flag());
            }
            if (entity.getCitizen_signature_filepath() == null) {
                statement.bindNull(60);
            } else {
                statement.bindText(60, entity.getCitizen_signature_filepath());
            }
            if (entity.getForm_submission_place() == null) {
                statement.bindNull(61);
            } else {
                statement.bindText(61, entity.getForm_submission_place());
            }
            if (entity.getList_1_doc_url_pg2() == null) {
                statement.bindNull(62);
            } else {
                statement.bindText(62, entity.getList_1_doc_url_pg2());
            }
            if (entity.getList_2_doc_url_pg2() == null) {
                statement.bindNull(63);
            } else {
                statement.bindText(63, entity.getList_2_doc_url_pg2());
            }
            if (entity.getList_3_doc_url_pg2() == null) {
                statement.bindNull(64);
            } else {
                statement.bindText(64, entity.getList_3_doc_url_pg2());
            }
            if (entity.getList_4_doc_url_pg2() == null) {
                statement.bindNull(65);
            } else {
                statement.bindText(65, entity.getList_4_doc_url_pg2());
            }
            if (entity.getList_5_doc_url_pg2() == null) {
                statement.bindNull(66);
            } else {
                statement.bindText(66, entity.getList_5_doc_url_pg2());
            }
            if (entity.getList_5_doc_url_pg3() == null) {
                statement.bindNull(67);
            } else {
                statement.bindText(67, entity.getList_5_doc_url_pg3());
            }
            if (entity.getList_6_doc_url_pg2() == null) {
                statement.bindNull(68);
            } else {
                statement.bindText(68, entity.getList_6_doc_url_pg2());
            }
            if (entity.getList_7_doc_url_pg2() == null) {
                statement.bindNull(69);
            } else {
                statement.bindText(69, entity.getList_7_doc_url_pg2());
            }
            if (entity.getPre_revision_voter_doc_url_pg2() == null) {
                statement.bindNull(70);
            } else {
                statement.bindText(70, entity.getPre_revision_voter_doc_url_pg2());
            }
            if (entity.getAnnexure_c_url_pg2() == null) {
                statement.bindNull(71);
            } else {
                statement.bindText(71, entity.getAnnexure_c_url_pg2());
            }
            if (entity.getIP_ADDRESS() == null) {
                statement.bindNull(72);
            } else {
                statement.bindText(72, entity.getIP_ADDRESS());
            }
            if (entity.getUSER_ID() == null) {
                statement.bindNull(73);
            } else {
                statement.bindText(73, entity.getUSER_ID());
            }
            if (entity.getIS_LEGACY_OPT() == null) {
                statement.bindNull(74);
            } else {
                statement.bindText(74, entity.getIS_LEGACY_OPT());
            }
            if (entity.getBLO_OVER_RIDDEN_FLG() == null) {
                statement.bindNull(75);
            } else {
                statement.bindText(75, entity.getBLO_OVER_RIDDEN_FLG());
            }
            if (entity.getEMAIL_ID() == null) {
                statement.bindNull(76);
            } else {
                statement.bindText(76, entity.getEMAIL_ID());
            }
            if (entity.getPASSPORT_NO() == null) {
                statement.bindNull(77);
            } else {
                statement.bindText(77, entity.getPASSPORT_NO());
            }
            if (entity.getELECTOR_TYPE() == null) {
                statement.bindNull(78);
            } else {
                statement.bindText(78, entity.getELECTOR_TYPE());
            }
            if (entity.getElectorName() == null) {
                statement.bindNull(79);
            } else {
                statement.bindText(79, entity.getElectorName());
            }
            if (entity.getPrvPartNo() == null) {
                statement.bindNull(80);
            } else {
                statement.bindText(80, entity.getPrvPartNo());
            }
            if (entity.getPrvPartSlNo() == null) {
                statement.bindNull(81);
            } else {
                statement.bindText(81, entity.getPrvPartSlNo());
            }
            if (entity.getPrvCat() == null) {
                statement.bindNull(82);
            } else {
                statement.bindText(82, entity.getPrvCat());
            }
            if (entity.getRelationType() == null) {
                statement.bindNull(83);
            } else {
                statement.bindText(83, entity.getRelationType());
            }
            if (entity.getRelationProofDocUrlPg1() == null) {
                statement.bindNull(84);
            } else {
                statement.bindText(84, entity.getRelationProofDocUrlPg1());
            }
            if (entity.getRelationProofDocUrlPg2() == null) {
                statement.bindNull(85);
            } else {
                statement.bindText(85, entity.getRelationProofDocUrlPg2());
            }
            if (entity.getRelationOldAcNo() == null) {
                statement.bindNull(86);
            } else {
                statement.bindText(86, entity.getRelationOldAcNo());
            }
            if (entity.getRelationOldPartNo() == null) {
                statement.bindNull(87);
            } else {
                statement.bindText(87, entity.getRelationOldPartNo());
            }
            if (entity.getRelationOldPslNo() == null) {
                statement.bindNull(88);
            } else {
                statement.bindText(88, entity.getRelationOldPslNo());
            }
            if (entity.getRelationDocType() == null) {
                statement.bindNull(89);
            } else {
                statement.bindText(89, entity.getRelationDocType());
            }
            if (entity.getRelationDocUrlPg1() == null) {
                statement.bindNull(90);
            } else {
                statement.bindText(90, entity.getRelationDocUrlPg1());
            }
            if (entity.getRelationDocUrlPg2() == null) {
                statement.bindNull(91);
            } else {
                statement.bindText(91, entity.getRelationDocUrlPg2());
            }
            if (entity.getIsRelativePreVoterFlg() == null) {
                statement.bindNull(92);
            } else {
                statement.bindText(92, entity.getIsRelativePreVoterFlg());
            }
            if (entity.getRelationEpicNo() == null) {
                statement.bindNull(93);
            } else {
                statement.bindText(93, entity.getRelationEpicNo());
            }
            if (entity.getIsThisYou() == null) {
                statement.bindNull(94);
            } else {
                statement.bindText(94, entity.getIsThisYou());
            }
            if (entity.getIsThisYouRel() == null) {
                statement.bindNull(95);
            } else {
                statement.bindText(95, entity.getIsThisYouRel());
            }
            if (entity.getRelationOldStateCd() == null) {
                statement.bindNull(96);
            } else {
                statement.bindText(96, entity.getRelationOldStateCd());
            }
            if (entity.getOldStateCd() == null) {
                statement.bindNull(97);
            } else {
                statement.bindText(97, entity.getOldStateCd());
            }
            if (entity.getTabName() == null) {
                statement.bindNull(98);
            } else {
                statement.bindText(98, entity.getTabName());
            }
            if (entity.getComments() == null) {
                statement.bindNull(99);
            } else {
                statement.bindText(99, entity.getComments());
            }
            statement.bindLong(100, entity.getRequestStatusCode());
        }
    };
    private final EntityDeleteOrUpdateAdapter<SpecialSurveyRevisionModel> __deleteAdapterOfSpecialSurveyRevisionModel = new EntityDeleteOrUpdateAdapter<SpecialSurveyRevisionModel>() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl.2
        protected String createQuery() {
            return "DELETE FROM `special_revision_survey` WHERE `EPIC_ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final SpecialSurveyRevisionModel entity) {
            if (entity.getEpic_id() == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.getEpic_id().longValue());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<SpecialSurveyRevisionModel> __updateAdapterOfSpecialSurveyRevisionModel = new EntityDeleteOrUpdateAdapter<SpecialSurveyRevisionModel>() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl.3
        protected String createQuery() {
            return "UPDATE OR ABORT `special_revision_survey` SET `EPIC_ID` = ?,`STATE_CD` = ?,`EPIC_NO` = ?,`HOUSE_NO` = ?,`DOB_VERIFIED` = ?,`EROLL_DOB` = ?,`DISTRICT_CD` = ?,`AC_NO` = ?,`PART_NO` = ?,`PART_SERIAL_NO` = ?,`CREATED_DTTM` = ?,`CREATED_BY` = ?,`MODIFIED_DTTM` = ?,`MODIFIED_BY` = ?,`PHOTO_URL` = ?,`SR_FORM_PAGE_1_URL` = ?,`CITIZENSHIP_TYPE` = ?,`CITIZENSHIP_TYPE_CAT` = ?,`LIST_1_DOC` = ?,`LIST_2_DOC` = ?,`LIST_3_DOC` = ?,`LIST_4_DOC` = ?,`LIST_5_DOC` = ?,`LIST_6_DOC` = ?,`LIST_7_DOC` = ?,`LIST_1_DOC_URL` = ?,`LIST_2_DOC_URL` = ?,`LIST_3_DOC_URL` = ?,`LIST_4_DOC_URL` = ?,`LIST_5_DOC_URL` = ?,`LIST_6_DOC_URL` = ?,`LIST_7_DOC_URL` = ?,`SURVEY_CHANNEL` = ?,`AADHAR_NO` = ?,`MOBILE_NO` = ?,`FATHERS_OR_GUARDIAN_NAME` = ?,`FATHERS_OR_GUARDIAN_EPIC_NO` = ?,`MOTHERS_NAME` = ?,`MOTHERS_EPIC_NO` = ?,`SPOUSE_NAME` = ?,`SPOUSE_EPIC_NO` = ?,`ANNEXURE_C_URL` = ?,`PRE_REVISION_VOTER_FLG` = ?,`PRE_REVISION_VOTER_DOC_URL` = ?,`SUBMITTED_FOR_RECOMMENDATION` = ?,`FATHERS_NATIONALITY` = ?,`MOTHERS_NATIONALITY` = ?,`SR_FORM_PAGE_2_URL` = ?,`OLD_AC_NO` = ?,`OLD_PART_NO` = ?,`OLD_PSL_NO` = ?,`F_OLD_AC_NO` = ?,`F_OLD_PART_NO` = ?,`F_OLD_PSL_NO` = ?,`M_OLD_AC_NO` = ?,`M_OLD_PART_NO` = ?,`M_OLD_PSL_NO` = ?,`LIST_8_DOC` = ?,`DOCUMENT_UPLOADED_FLG` = ?,`citizen_signature_filepath` = ?,`FORM_SUBMISSION_PLACE` = ?,`LIST_1_DOC_URL_PG2` = ?,`LIST_2_DOC_URL_PG2` = ?,`LIST_3_DOC_URL_PG2` = ?,`LIST_4_DOC_URL_PG2` = ?,`LIST_5_DOC_URL_PG2` = ?,`LIST_5_DOC_URL_PG3` = ?,`LIST_6_DOC_URL_PG2` = ?,`LIST_7_DOC_URL_PG2` = ?,`PRE_REVISION_VOTER_DOC_URL_PG2` = ?,`ANNEXURE_C_URL_PG2` = ?,`IP_ADDRESS` = ?,`USER_ID` = ?,`IS_LEGACY_OPT` = ?,`BLO_OVER_RIDDEN_FLG` = ?,`EMAIL_ID` = ?,`PASSPORT_NO` = ?,`ELECTOR_TYPE` = ?,`ELECTOR_NAME` = ?,`PRV_PARTNO` = ?,`PRV_PARTSLNO` = ?,`PRV_CAT` = ?,`RELATION_TYPE` = ?,`RELATION_PROOF_DOC_URL_PG1` = ?,`RELATION_PROOF_DOC_URL_PG2` = ?,`RELATION_OLD_AC_NO` = ?,`RELATION_OLD_PART_NO` = ?,`RELATION_OLD_PSL_NO` = ?,`RELATION_DOC_TYPE` = ?,`RELATION_DOC_URL_PG1` = ?,`RELATION_DOC_URL_PG2` = ?,`IS_RELATIVE_PRE_VOTER_FLG` = ?,`RELATION_EPIC_NO` = ?,`IS_THIS_YOU_FLG` = ?,`IS_THIS_YOU_REL_FLG` = ?,`RELATION_OLD_STATE_CD` = ?,`OLD_STATE_CD` = ?,`tabName` = ?,`COMMENTS` = ?,`REQUEST_STATUS_CODE` = ? WHERE `EPIC_ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final SpecialSurveyRevisionModel entity) {
            if (entity.getEpic_id() == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.getEpic_id().longValue());
            }
            if (entity.getState_cd() == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.getState_cd());
            }
            if (entity.getEpic_no() == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.getEpic_no());
            }
            if (entity.getHouse_no() == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.getHouse_no());
            }
            if (entity.getDob_verified() == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.getDob_verified());
            }
            if (entity.getEroll_dob() == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.getEroll_dob());
            }
            if (entity.getDistrict_cd() == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.getDistrict_cd());
            }
            if (entity.getAc_no() == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.getAc_no());
            }
            if (entity.getPart_no() == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.getPart_no());
            }
            if (entity.getPart_serial_no() == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.getPart_serial_no());
            }
            if (entity.getCreated_dttm() == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.getCreated_dttm());
            }
            if (entity.getCreated_by() == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.getCreated_by());
            }
            if (entity.getModified_dttm() == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.getModified_dttm());
            }
            if (entity.getModified_by() == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.getModified_by());
            }
            if (entity.getPhoto_url() == null) {
                statement.bindNull(15);
            } else {
                statement.bindText(15, entity.getPhoto_url());
            }
            if (entity.getSr_form_page_1_url() == null) {
                statement.bindNull(16);
            } else {
                statement.bindText(16, entity.getSr_form_page_1_url());
            }
            if (entity.getCitizenship_type() == null) {
                statement.bindNull(17);
            } else {
                statement.bindText(17, entity.getCitizenship_type());
            }
            if (entity.getCitizenship_type_cat() == null) {
                statement.bindNull(18);
            } else {
                statement.bindText(18, entity.getCitizenship_type_cat());
            }
            if (entity.getList_1_doc() == null) {
                statement.bindNull(19);
            } else {
                statement.bindText(19, entity.getList_1_doc());
            }
            if (entity.getList_2_doc() == null) {
                statement.bindNull(20);
            } else {
                statement.bindText(20, entity.getList_2_doc());
            }
            if (entity.getList_3_doc() == null) {
                statement.bindNull(21);
            } else {
                statement.bindText(21, entity.getList_3_doc());
            }
            if (entity.getList_4_doc() == null) {
                statement.bindNull(22);
            } else {
                statement.bindText(22, entity.getList_4_doc());
            }
            if (entity.getList_5_doc() == null) {
                statement.bindNull(23);
            } else {
                statement.bindText(23, entity.getList_5_doc());
            }
            if (entity.getList_6_doc() == null) {
                statement.bindNull(24);
            } else {
                statement.bindText(24, entity.getList_6_doc());
            }
            if (entity.getList_7_doc() == null) {
                statement.bindNull(25);
            } else {
                statement.bindText(25, entity.getList_7_doc());
            }
            if (entity.getList_1_doc_url() == null) {
                statement.bindNull(26);
            } else {
                statement.bindText(26, entity.getList_1_doc_url());
            }
            if (entity.getList_2_doc_url() == null) {
                statement.bindNull(27);
            } else {
                statement.bindText(27, entity.getList_2_doc_url());
            }
            if (entity.getList_3_doc_url() == null) {
                statement.bindNull(28);
            } else {
                statement.bindText(28, entity.getList_3_doc_url());
            }
            if (entity.getList_4_doc_url() == null) {
                statement.bindNull(29);
            } else {
                statement.bindText(29, entity.getList_4_doc_url());
            }
            if (entity.getList_5_doc_url() == null) {
                statement.bindNull(30);
            } else {
                statement.bindText(30, entity.getList_5_doc_url());
            }
            if (entity.getList_6_doc_url() == null) {
                statement.bindNull(31);
            } else {
                statement.bindText(31, entity.getList_6_doc_url());
            }
            if (entity.getList_7_doc_url() == null) {
                statement.bindNull(32);
            } else {
                statement.bindText(32, entity.getList_7_doc_url());
            }
            if (entity.getSurvey_channel() == null) {
                statement.bindNull(33);
            } else {
                statement.bindText(33, entity.getSurvey_channel());
            }
            if (entity.getAadhaar_no() == null) {
                statement.bindNull(34);
            } else {
                statement.bindText(34, entity.getAadhaar_no());
            }
            if (entity.getMobile_no() == null) {
                statement.bindNull(35);
            } else {
                statement.bindText(35, entity.getMobile_no());
            }
            if (entity.getFather_or_guardian_name() == null) {
                statement.bindNull(36);
            } else {
                statement.bindText(36, entity.getFather_or_guardian_name());
            }
            if (entity.getFather_or_guardian_epic_no() == null) {
                statement.bindNull(37);
            } else {
                statement.bindText(37, entity.getFather_or_guardian_epic_no());
            }
            if (entity.getMothers_name() == null) {
                statement.bindNull(38);
            } else {
                statement.bindText(38, entity.getMothers_name());
            }
            if (entity.getMothers_epic_no() == null) {
                statement.bindNull(39);
            } else {
                statement.bindText(39, entity.getMothers_epic_no());
            }
            if (entity.getSpouse_name() == null) {
                statement.bindNull(40);
            } else {
                statement.bindText(40, entity.getSpouse_name());
            }
            if (entity.getSpouse_epic_no() == null) {
                statement.bindNull(41);
            } else {
                statement.bindText(41, entity.getSpouse_epic_no());
            }
            if (entity.getAnnexure_c_url() == null) {
                statement.bindNull(42);
            } else {
                statement.bindText(42, entity.getAnnexure_c_url());
            }
            if (entity.getPre_revision_voter_flag() == null) {
                statement.bindNull(43);
            } else {
                statement.bindText(43, entity.getPre_revision_voter_flag());
            }
            if (entity.getPre_revision_voter_doc_url() == null) {
                statement.bindNull(44);
            } else {
                statement.bindText(44, entity.getPre_revision_voter_doc_url());
            }
            if (entity.getSubmitted_for_recommendation() == null) {
                statement.bindNull(45);
            } else {
                statement.bindText(45, entity.getSubmitted_for_recommendation());
            }
            if (entity.getFather_nationality() == null) {
                statement.bindNull(46);
            } else {
                statement.bindText(46, entity.getFather_nationality());
            }
            if (entity.getMother_nationality() == null) {
                statement.bindNull(47);
            } else {
                statement.bindText(47, entity.getMother_nationality());
            }
            if (entity.getSr_form_page_2_url() == null) {
                statement.bindNull(48);
            } else {
                statement.bindText(48, entity.getSr_form_page_2_url());
            }
            if (entity.getOld_ac_no() == null) {
                statement.bindNull(49);
            } else {
                statement.bindText(49, entity.getOld_ac_no());
            }
            if (entity.getOld_part_no() == null) {
                statement.bindNull(50);
            } else {
                statement.bindText(50, entity.getOld_part_no());
            }
            if (entity.getOld_psl_no() == null) {
                statement.bindNull(51);
            } else {
                statement.bindText(51, entity.getOld_psl_no());
            }
            if (entity.getF_old_ac_no() == null) {
                statement.bindNull(52);
            } else {
                statement.bindText(52, entity.getF_old_ac_no());
            }
            if (entity.getF_old_part_no() == null) {
                statement.bindNull(53);
            } else {
                statement.bindText(53, entity.getF_old_part_no());
            }
            if (entity.getF_old_psl_no() == null) {
                statement.bindNull(54);
            } else {
                statement.bindText(54, entity.getF_old_psl_no());
            }
            if (entity.getM_old_ac_no() == null) {
                statement.bindNull(55);
            } else {
                statement.bindText(55, entity.getM_old_ac_no());
            }
            if (entity.getM_old_part_no() == null) {
                statement.bindNull(56);
            } else {
                statement.bindText(56, entity.getM_old_part_no());
            }
            if (entity.getM_old_psl_no() == null) {
                statement.bindNull(57);
            } else {
                statement.bindText(57, entity.getM_old_psl_no());
            }
            if (entity.getList_8_doc() == null) {
                statement.bindNull(58);
            } else {
                statement.bindText(58, entity.getList_8_doc());
            }
            if (entity.getDocument_uploaded_flag() == null) {
                statement.bindNull(59);
            } else {
                statement.bindText(59, entity.getDocument_uploaded_flag());
            }
            if (entity.getCitizen_signature_filepath() == null) {
                statement.bindNull(60);
            } else {
                statement.bindText(60, entity.getCitizen_signature_filepath());
            }
            if (entity.getForm_submission_place() == null) {
                statement.bindNull(61);
            } else {
                statement.bindText(61, entity.getForm_submission_place());
            }
            if (entity.getList_1_doc_url_pg2() == null) {
                statement.bindNull(62);
            } else {
                statement.bindText(62, entity.getList_1_doc_url_pg2());
            }
            if (entity.getList_2_doc_url_pg2() == null) {
                statement.bindNull(63);
            } else {
                statement.bindText(63, entity.getList_2_doc_url_pg2());
            }
            if (entity.getList_3_doc_url_pg2() == null) {
                statement.bindNull(64);
            } else {
                statement.bindText(64, entity.getList_3_doc_url_pg2());
            }
            if (entity.getList_4_doc_url_pg2() == null) {
                statement.bindNull(65);
            } else {
                statement.bindText(65, entity.getList_4_doc_url_pg2());
            }
            if (entity.getList_5_doc_url_pg2() == null) {
                statement.bindNull(66);
            } else {
                statement.bindText(66, entity.getList_5_doc_url_pg2());
            }
            if (entity.getList_5_doc_url_pg3() == null) {
                statement.bindNull(67);
            } else {
                statement.bindText(67, entity.getList_5_doc_url_pg3());
            }
            if (entity.getList_6_doc_url_pg2() == null) {
                statement.bindNull(68);
            } else {
                statement.bindText(68, entity.getList_6_doc_url_pg2());
            }
            if (entity.getList_7_doc_url_pg2() == null) {
                statement.bindNull(69);
            } else {
                statement.bindText(69, entity.getList_7_doc_url_pg2());
            }
            if (entity.getPre_revision_voter_doc_url_pg2() == null) {
                statement.bindNull(70);
            } else {
                statement.bindText(70, entity.getPre_revision_voter_doc_url_pg2());
            }
            if (entity.getAnnexure_c_url_pg2() == null) {
                statement.bindNull(71);
            } else {
                statement.bindText(71, entity.getAnnexure_c_url_pg2());
            }
            if (entity.getIP_ADDRESS() == null) {
                statement.bindNull(72);
            } else {
                statement.bindText(72, entity.getIP_ADDRESS());
            }
            if (entity.getUSER_ID() == null) {
                statement.bindNull(73);
            } else {
                statement.bindText(73, entity.getUSER_ID());
            }
            if (entity.getIS_LEGACY_OPT() == null) {
                statement.bindNull(74);
            } else {
                statement.bindText(74, entity.getIS_LEGACY_OPT());
            }
            if (entity.getBLO_OVER_RIDDEN_FLG() == null) {
                statement.bindNull(75);
            } else {
                statement.bindText(75, entity.getBLO_OVER_RIDDEN_FLG());
            }
            if (entity.getEMAIL_ID() == null) {
                statement.bindNull(76);
            } else {
                statement.bindText(76, entity.getEMAIL_ID());
            }
            if (entity.getPASSPORT_NO() == null) {
                statement.bindNull(77);
            } else {
                statement.bindText(77, entity.getPASSPORT_NO());
            }
            if (entity.getELECTOR_TYPE() == null) {
                statement.bindNull(78);
            } else {
                statement.bindText(78, entity.getELECTOR_TYPE());
            }
            if (entity.getElectorName() == null) {
                statement.bindNull(79);
            } else {
                statement.bindText(79, entity.getElectorName());
            }
            if (entity.getPrvPartNo() == null) {
                statement.bindNull(80);
            } else {
                statement.bindText(80, entity.getPrvPartNo());
            }
            if (entity.getPrvPartSlNo() == null) {
                statement.bindNull(81);
            } else {
                statement.bindText(81, entity.getPrvPartSlNo());
            }
            if (entity.getPrvCat() == null) {
                statement.bindNull(82);
            } else {
                statement.bindText(82, entity.getPrvCat());
            }
            if (entity.getRelationType() == null) {
                statement.bindNull(83);
            } else {
                statement.bindText(83, entity.getRelationType());
            }
            if (entity.getRelationProofDocUrlPg1() == null) {
                statement.bindNull(84);
            } else {
                statement.bindText(84, entity.getRelationProofDocUrlPg1());
            }
            if (entity.getRelationProofDocUrlPg2() == null) {
                statement.bindNull(85);
            } else {
                statement.bindText(85, entity.getRelationProofDocUrlPg2());
            }
            if (entity.getRelationOldAcNo() == null) {
                statement.bindNull(86);
            } else {
                statement.bindText(86, entity.getRelationOldAcNo());
            }
            if (entity.getRelationOldPartNo() == null) {
                statement.bindNull(87);
            } else {
                statement.bindText(87, entity.getRelationOldPartNo());
            }
            if (entity.getRelationOldPslNo() == null) {
                statement.bindNull(88);
            } else {
                statement.bindText(88, entity.getRelationOldPslNo());
            }
            if (entity.getRelationDocType() == null) {
                statement.bindNull(89);
            } else {
                statement.bindText(89, entity.getRelationDocType());
            }
            if (entity.getRelationDocUrlPg1() == null) {
                statement.bindNull(90);
            } else {
                statement.bindText(90, entity.getRelationDocUrlPg1());
            }
            if (entity.getRelationDocUrlPg2() == null) {
                statement.bindNull(91);
            } else {
                statement.bindText(91, entity.getRelationDocUrlPg2());
            }
            if (entity.getIsRelativePreVoterFlg() == null) {
                statement.bindNull(92);
            } else {
                statement.bindText(92, entity.getIsRelativePreVoterFlg());
            }
            if (entity.getRelationEpicNo() == null) {
                statement.bindNull(93);
            } else {
                statement.bindText(93, entity.getRelationEpicNo());
            }
            if (entity.getIsThisYou() == null) {
                statement.bindNull(94);
            } else {
                statement.bindText(94, entity.getIsThisYou());
            }
            if (entity.getIsThisYouRel() == null) {
                statement.bindNull(95);
            } else {
                statement.bindText(95, entity.getIsThisYouRel());
            }
            if (entity.getRelationOldStateCd() == null) {
                statement.bindNull(96);
            } else {
                statement.bindText(96, entity.getRelationOldStateCd());
            }
            if (entity.getOldStateCd() == null) {
                statement.bindNull(97);
            } else {
                statement.bindText(97, entity.getOldStateCd());
            }
            if (entity.getTabName() == null) {
                statement.bindNull(98);
            } else {
                statement.bindText(98, entity.getTabName());
            }
            if (entity.getComments() == null) {
                statement.bindNull(99);
            } else {
                statement.bindText(99, entity.getComments());
            }
            statement.bindLong(100, entity.getRequestStatusCode());
            if (entity.getEpic_id() == null) {
                statement.bindNull(101);
            } else {
                statement.bindLong(101, entity.getEpic_id().longValue());
            }
        }
    };

    public SpecialRevisionDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public void addSpecialSurveyRevisionDetails(final SpecialSurveyRevisionModel specialSurveyRevisionModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return this.f$0.lambda$addSpecialSurveyRevisionDetails$0(specialSurveyRevisionModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$addSpecialSurveyRevisionDetails$0(SpecialSurveyRevisionModel specialSurveyRevisionModel, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfSpecialSurveyRevisionModel.insert(sQLiteConnection, specialSurveyRevisionModel);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public void deleteSpecialSurveyRevisionDetails(final SpecialSurveyRevisionModel specialSurveyRevisionModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return this.f$0.lambda$deleteSpecialSurveyRevisionDetails$1(specialSurveyRevisionModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deleteSpecialSurveyRevisionDetails$1(SpecialSurveyRevisionModel specialSurveyRevisionModel, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfSpecialSurveyRevisionModel.handle(sQLiteConnection, specialSurveyRevisionModel);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public void updateSpecialSurveyRevisionDetails(final SpecialSurveyRevisionModel specialSurveyRevisionModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return this.f$0.lambda$updateSpecialSurveyRevisionDetails$2(specialSurveyRevisionModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$updateSpecialSurveyRevisionDetails$2(SpecialSurveyRevisionModel specialSurveyRevisionModel, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfSpecialSurveyRevisionModel.handle(sQLiteConnection, specialSurveyRevisionModel);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public List<SpecialSurveyRevisionModel> getSpecialSurveyRevisionDetails(final String partNumber) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return SpecialRevisionDao_Impl.lambda$getSpecialSurveyRevisionDetails$3(partNumber, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getSpecialSurveyRevisionDetails$3(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from special_revision_survey where PART_NO = ? order by rowid asc");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EPIC_ID");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "STATE_CD");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EPIC_NO");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "HOUSE_NO");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "DOB_VERIFIED");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EROLL_DOB");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "DISTRICT_CD");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "AC_NO");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PART_NO");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PART_SERIAL_NO");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CREATED_DTTM");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CREATED_BY");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_DTTM");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_BY");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PHOTO_URL");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SR_FORM_PAGE_1_URL");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CITIZENSHIP_TYPE");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CITIZENSHIP_TYPE_CAT");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_1_DOC");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_2_DOC");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_3_DOC");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_4_DOC");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_5_DOC");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_6_DOC");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_7_DOC");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_1_DOC_URL");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_2_DOC_URL");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_3_DOC_URL");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_4_DOC_URL");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_5_DOC_URL");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_6_DOC_URL");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_7_DOC_URL");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SURVEY_CHANNEL");
            int columnIndexOrThrow34 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "AADHAR_NO");
            int columnIndexOrThrow35 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOBILE_NO");
            int columnIndexOrThrow36 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FATHERS_OR_GUARDIAN_NAME");
            int columnIndexOrThrow37 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FATHERS_OR_GUARDIAN_EPIC_NO");
            int columnIndexOrThrow38 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOTHERS_NAME");
            int columnIndexOrThrow39 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOTHERS_EPIC_NO");
            int columnIndexOrThrow40 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SPOUSE_NAME");
            int columnIndexOrThrow41 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SPOUSE_EPIC_NO");
            int columnIndexOrThrow42 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ANNEXURE_C_URL");
            int columnIndexOrThrow43 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRE_REVISION_VOTER_FLG");
            int columnIndexOrThrow44 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRE_REVISION_VOTER_DOC_URL");
            int columnIndexOrThrow45 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SUBMITTED_FOR_RECOMMENDATION");
            int columnIndexOrThrow46 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FATHERS_NATIONALITY");
            int columnIndexOrThrow47 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOTHERS_NATIONALITY");
            int columnIndexOrThrow48 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SR_FORM_PAGE_2_URL");
            int columnIndexOrThrow49 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "OLD_AC_NO");
            int columnIndexOrThrow50 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "OLD_PART_NO");
            int columnIndexOrThrow51 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "OLD_PSL_NO");
            int columnIndexOrThrow52 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "F_OLD_AC_NO");
            int columnIndexOrThrow53 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "F_OLD_PART_NO");
            int columnIndexOrThrow54 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "F_OLD_PSL_NO");
            int columnIndexOrThrow55 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "M_OLD_AC_NO");
            int columnIndexOrThrow56 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "M_OLD_PART_NO");
            int columnIndexOrThrow57 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "M_OLD_PSL_NO");
            int columnIndexOrThrow58 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_8_DOC");
            int columnIndexOrThrow59 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "DOCUMENT_UPLOADED_FLG");
            int columnIndexOrThrow60 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "citizen_signature_filepath");
            int columnIndexOrThrow61 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FORM_SUBMISSION_PLACE");
            int columnIndexOrThrow62 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_1_DOC_URL_PG2");
            int columnIndexOrThrow63 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_2_DOC_URL_PG2");
            int columnIndexOrThrow64 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_3_DOC_URL_PG2");
            int columnIndexOrThrow65 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_4_DOC_URL_PG2");
            int columnIndexOrThrow66 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_5_DOC_URL_PG2");
            int columnIndexOrThrow67 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_5_DOC_URL_PG3");
            int columnIndexOrThrow68 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_6_DOC_URL_PG2");
            int columnIndexOrThrow69 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_7_DOC_URL_PG2");
            int columnIndexOrThrow70 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRE_REVISION_VOTER_DOC_URL_PG2");
            int columnIndexOrThrow71 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ANNEXURE_C_URL_PG2");
            int columnIndexOrThrow72 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IP_ADDRESS");
            int columnIndexOrThrow73 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "USER_ID");
            int columnIndexOrThrow74 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IS_LEGACY_OPT");
            int columnIndexOrThrow75 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_OVER_RIDDEN_FLG");
            int columnIndexOrThrow76 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EMAIL_ID");
            int columnIndexOrThrow77 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PASSPORT_NO");
            int columnIndexOrThrow78 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ELECTOR_TYPE");
            int columnIndexOrThrow79 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ELECTOR_NAME");
            int columnIndexOrThrow80 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRV_PARTNO");
            int columnIndexOrThrow81 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRV_PARTSLNO");
            int columnIndexOrThrow82 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRV_CAT");
            int columnIndexOrThrow83 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_TYPE");
            int columnIndexOrThrow84 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_PROOF_DOC_URL_PG1");
            int columnIndexOrThrow85 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_PROOF_DOC_URL_PG2");
            int columnIndexOrThrow86 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_OLD_AC_NO");
            int columnIndexOrThrow87 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_OLD_PART_NO");
            int columnIndexOrThrow88 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_OLD_PSL_NO");
            int columnIndexOrThrow89 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_DOC_TYPE");
            int columnIndexOrThrow90 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_DOC_URL_PG1");
            int columnIndexOrThrow91 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_DOC_URL_PG2");
            int columnIndexOrThrow92 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IS_RELATIVE_PRE_VOTER_FLG");
            int columnIndexOrThrow93 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_EPIC_NO");
            int columnIndexOrThrow94 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IS_THIS_YOU_FLG");
            int columnIndexOrThrow95 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IS_THIS_YOU_REL_FLG");
            int columnIndexOrThrow96 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_OLD_STATE_CD");
            int columnIndexOrThrow97 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "OLD_STATE_CD");
            int columnIndexOrThrow98 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tabName");
            int columnIndexOrThrow99 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "COMMENTS");
            int columnIndexOrThrow100 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "REQUEST_STATUS_CODE");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                Long lValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow));
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text12 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text13 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow15;
                String text14 = sQLiteStatementPrepare.isNull(i2) ? null : sQLiteStatementPrepare.getText(i2);
                columnIndexOrThrow16 = columnIndexOrThrow16;
                String text15 = sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow16);
                String text16 = sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17);
                String text17 = sQLiteStatementPrepare.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow18);
                String text18 = sQLiteStatementPrepare.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow19);
                String text19 = sQLiteStatementPrepare.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow20);
                String text20 = sQLiteStatementPrepare.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow21);
                String text21 = sQLiteStatementPrepare.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow22);
                String text22 = sQLiteStatementPrepare.isNull(columnIndexOrThrow23) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow23);
                String text23 = sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow24);
                String text24 = sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow25);
                String text25 = sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26);
                String text26 = sQLiteStatementPrepare.isNull(columnIndexOrThrow27) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow27);
                String text27 = sQLiteStatementPrepare.isNull(columnIndexOrThrow28) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow28);
                String text28 = sQLiteStatementPrepare.isNull(columnIndexOrThrow29) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow29);
                String text29 = sQLiteStatementPrepare.isNull(columnIndexOrThrow30) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow30);
                String text30 = sQLiteStatementPrepare.isNull(columnIndexOrThrow31) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow31);
                String text31 = sQLiteStatementPrepare.isNull(columnIndexOrThrow32) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow32);
                String text32 = sQLiteStatementPrepare.isNull(columnIndexOrThrow33) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow33);
                String text33 = sQLiteStatementPrepare.isNull(columnIndexOrThrow34) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow34);
                String text34 = sQLiteStatementPrepare.isNull(columnIndexOrThrow35) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow35);
                String text35 = sQLiteStatementPrepare.isNull(columnIndexOrThrow36) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow36);
                String text36 = sQLiteStatementPrepare.isNull(columnIndexOrThrow37) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow37);
                String text37 = sQLiteStatementPrepare.isNull(columnIndexOrThrow38) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow38);
                String text38 = sQLiteStatementPrepare.isNull(columnIndexOrThrow39) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow39);
                String text39 = sQLiteStatementPrepare.isNull(columnIndexOrThrow40) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow40);
                String text40 = sQLiteStatementPrepare.isNull(columnIndexOrThrow41) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow41);
                String text41 = sQLiteStatementPrepare.isNull(columnIndexOrThrow42) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow42);
                String text42 = sQLiteStatementPrepare.isNull(columnIndexOrThrow43) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow43);
                String text43 = sQLiteStatementPrepare.isNull(columnIndexOrThrow44) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow44);
                String text44 = sQLiteStatementPrepare.isNull(columnIndexOrThrow45) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow45);
                String text45 = sQLiteStatementPrepare.isNull(columnIndexOrThrow46) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow46);
                String text46 = sQLiteStatementPrepare.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow47);
                String text47 = sQLiteStatementPrepare.isNull(columnIndexOrThrow48) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow48);
                String text48 = sQLiteStatementPrepare.isNull(columnIndexOrThrow49) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow49);
                String text49 = sQLiteStatementPrepare.isNull(columnIndexOrThrow50) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow50);
                String text50 = sQLiteStatementPrepare.isNull(columnIndexOrThrow51) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow51);
                String text51 = sQLiteStatementPrepare.isNull(columnIndexOrThrow52) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow52);
                String text52 = sQLiteStatementPrepare.isNull(columnIndexOrThrow53) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow53);
                String text53 = sQLiteStatementPrepare.isNull(columnIndexOrThrow54) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow54);
                String text54 = sQLiteStatementPrepare.isNull(columnIndexOrThrow55) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow55);
                String text55 = sQLiteStatementPrepare.isNull(columnIndexOrThrow56) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow56);
                String text56 = sQLiteStatementPrepare.isNull(columnIndexOrThrow57) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow57);
                String text57 = sQLiteStatementPrepare.isNull(columnIndexOrThrow58) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow58);
                String text58 = sQLiteStatementPrepare.isNull(columnIndexOrThrow59) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow59);
                String text59 = sQLiteStatementPrepare.isNull(columnIndexOrThrow60) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow60);
                String text60 = sQLiteStatementPrepare.isNull(columnIndexOrThrow61) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow61);
                String text61 = sQLiteStatementPrepare.isNull(columnIndexOrThrow62) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow62);
                String text62 = sQLiteStatementPrepare.isNull(columnIndexOrThrow63) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow63);
                String text63 = sQLiteStatementPrepare.isNull(columnIndexOrThrow64) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow64);
                String text64 = sQLiteStatementPrepare.isNull(columnIndexOrThrow65) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow65);
                String text65 = sQLiteStatementPrepare.isNull(columnIndexOrThrow66) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow66);
                String text66 = sQLiteStatementPrepare.isNull(columnIndexOrThrow67) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow67);
                String text67 = sQLiteStatementPrepare.isNull(columnIndexOrThrow68) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow68);
                String text68 = sQLiteStatementPrepare.isNull(columnIndexOrThrow69) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow69);
                String text69 = sQLiteStatementPrepare.isNull(columnIndexOrThrow70) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow70);
                String text70 = sQLiteStatementPrepare.isNull(columnIndexOrThrow71) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow71);
                String text71 = sQLiteStatementPrepare.isNull(columnIndexOrThrow72) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow72);
                String text72 = sQLiteStatementPrepare.isNull(columnIndexOrThrow73) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow73);
                String text73 = sQLiteStatementPrepare.isNull(columnIndexOrThrow74) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow74);
                String text74 = sQLiteStatementPrepare.isNull(columnIndexOrThrow75) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow75);
                String text75 = sQLiteStatementPrepare.isNull(columnIndexOrThrow76) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow76);
                String text76 = sQLiteStatementPrepare.isNull(columnIndexOrThrow77) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow77);
                String text77 = sQLiteStatementPrepare.isNull(columnIndexOrThrow78) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow78);
                String text78 = sQLiteStatementPrepare.isNull(columnIndexOrThrow79) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow79);
                String text79 = sQLiteStatementPrepare.isNull(columnIndexOrThrow83) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow83);
                String text80 = sQLiteStatementPrepare.isNull(columnIndexOrThrow84) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow84);
                String text81 = sQLiteStatementPrepare.isNull(columnIndexOrThrow85) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow85);
                String text82 = sQLiteStatementPrepare.isNull(columnIndexOrThrow86) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow86);
                String text83 = sQLiteStatementPrepare.isNull(columnIndexOrThrow87) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow87);
                String text84 = sQLiteStatementPrepare.isNull(columnIndexOrThrow88) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow88);
                String text85 = sQLiteStatementPrepare.isNull(columnIndexOrThrow89) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow89);
                String text86 = sQLiteStatementPrepare.isNull(columnIndexOrThrow90) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow90);
                String text87 = sQLiteStatementPrepare.isNull(columnIndexOrThrow91) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow91);
                SpecialSurveyRevisionModel specialSurveyRevisionModel = new SpecialSurveyRevisionModel(lValueOf, text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22, text23, text24, text25, text26, text27, text28, text29, text30, text31, text32, text33, text34, text35, text36, text37, text38, text39, text40, text41, text42, text43, text44, text45, text46, text47, text48, text49, text50, text51, text52, text53, text54, text55, text56, text57, text58, text59, text60, text61, text62, text63, text64, text65, text66, text67, text68, text69, text70, text71, text72, text73, text74, text75, text76, text77, text78, text79, text85, text86, sQLiteStatementPrepare.isNull(columnIndexOrThrow92) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow92), text87, text80, text81, text82, text83, text84, sQLiteStatementPrepare.isNull(columnIndexOrThrow93) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow93), sQLiteStatementPrepare.isNull(columnIndexOrThrow94) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow94), sQLiteStatementPrepare.isNull(columnIndexOrThrow95) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow95), sQLiteStatementPrepare.isNull(columnIndexOrThrow98) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow98), sQLiteStatementPrepare.isNull(columnIndexOrThrow96) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow96), sQLiteStatementPrepare.isNull(columnIndexOrThrow97) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow97));
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow80;
                specialSurveyRevisionModel.setPrvPartNo(sQLiteStatementPrepare.isNull(i4) ? null : sQLiteStatementPrepare.getText(i4));
                columnIndexOrThrow81 = columnIndexOrThrow81;
                specialSurveyRevisionModel.setPrvPartSlNo(sQLiteStatementPrepare.isNull(columnIndexOrThrow81) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow81));
                columnIndexOrThrow82 = columnIndexOrThrow82;
                specialSurveyRevisionModel.setPrvCat(sQLiteStatementPrepare.isNull(columnIndexOrThrow82) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow82));
                int i5 = columnIndexOrThrow99;
                columnIndexOrThrow99 = i5;
                specialSurveyRevisionModel.setComments(sQLiteStatementPrepare.isNull(i5) ? null : sQLiteStatementPrepare.getText(i5));
                int i6 = columnIndexOrThrow3;
                int i7 = columnIndexOrThrow100;
                int i8 = columnIndexOrThrow4;
                specialSurveyRevisionModel.setRequestStatusCode((int) sQLiteStatementPrepare.getLong(i7));
                arrayList.add(specialSurveyRevisionModel);
                columnIndexOrThrow = i;
                columnIndexOrThrow3 = i6;
                columnIndexOrThrow4 = i8;
                columnIndexOrThrow15 = i2;
                columnIndexOrThrow80 = i4;
                columnIndexOrThrow100 = i7;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public LiveData<List<SpecialSurveyRevisionModel>> getAllForms() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"special_revision_survey"}, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return SpecialRevisionDao_Impl.lambda$getAllForms$4((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getAllForms$4(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from special_revision_survey order by rowid asc ");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EPIC_ID");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "STATE_CD");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EPIC_NO");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "HOUSE_NO");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "DOB_VERIFIED");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EROLL_DOB");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "DISTRICT_CD");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "AC_NO");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PART_NO");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PART_SERIAL_NO");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CREATED_DTTM");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CREATED_BY");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_DTTM");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_BY");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PHOTO_URL");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SR_FORM_PAGE_1_URL");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CITIZENSHIP_TYPE");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CITIZENSHIP_TYPE_CAT");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_1_DOC");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_2_DOC");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_3_DOC");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_4_DOC");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_5_DOC");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_6_DOC");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_7_DOC");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_1_DOC_URL");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_2_DOC_URL");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_3_DOC_URL");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_4_DOC_URL");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_5_DOC_URL");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_6_DOC_URL");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_7_DOC_URL");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SURVEY_CHANNEL");
            int columnIndexOrThrow34 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "AADHAR_NO");
            int columnIndexOrThrow35 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOBILE_NO");
            int columnIndexOrThrow36 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FATHERS_OR_GUARDIAN_NAME");
            int columnIndexOrThrow37 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FATHERS_OR_GUARDIAN_EPIC_NO");
            int columnIndexOrThrow38 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOTHERS_NAME");
            int columnIndexOrThrow39 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOTHERS_EPIC_NO");
            int columnIndexOrThrow40 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SPOUSE_NAME");
            int columnIndexOrThrow41 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SPOUSE_EPIC_NO");
            int columnIndexOrThrow42 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ANNEXURE_C_URL");
            int columnIndexOrThrow43 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRE_REVISION_VOTER_FLG");
            int columnIndexOrThrow44 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRE_REVISION_VOTER_DOC_URL");
            int columnIndexOrThrow45 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SUBMITTED_FOR_RECOMMENDATION");
            int columnIndexOrThrow46 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FATHERS_NATIONALITY");
            int columnIndexOrThrow47 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOTHERS_NATIONALITY");
            int columnIndexOrThrow48 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SR_FORM_PAGE_2_URL");
            int columnIndexOrThrow49 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "OLD_AC_NO");
            int columnIndexOrThrow50 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "OLD_PART_NO");
            int columnIndexOrThrow51 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "OLD_PSL_NO");
            int columnIndexOrThrow52 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "F_OLD_AC_NO");
            int columnIndexOrThrow53 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "F_OLD_PART_NO");
            int columnIndexOrThrow54 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "F_OLD_PSL_NO");
            int columnIndexOrThrow55 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "M_OLD_AC_NO");
            int columnIndexOrThrow56 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "M_OLD_PART_NO");
            int columnIndexOrThrow57 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "M_OLD_PSL_NO");
            int columnIndexOrThrow58 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_8_DOC");
            int columnIndexOrThrow59 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "DOCUMENT_UPLOADED_FLG");
            int columnIndexOrThrow60 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "citizen_signature_filepath");
            int columnIndexOrThrow61 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FORM_SUBMISSION_PLACE");
            int columnIndexOrThrow62 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_1_DOC_URL_PG2");
            int columnIndexOrThrow63 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_2_DOC_URL_PG2");
            int columnIndexOrThrow64 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_3_DOC_URL_PG2");
            int columnIndexOrThrow65 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_4_DOC_URL_PG2");
            int columnIndexOrThrow66 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_5_DOC_URL_PG2");
            int columnIndexOrThrow67 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_5_DOC_URL_PG3");
            int columnIndexOrThrow68 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_6_DOC_URL_PG2");
            int columnIndexOrThrow69 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LIST_7_DOC_URL_PG2");
            int columnIndexOrThrow70 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRE_REVISION_VOTER_DOC_URL_PG2");
            int columnIndexOrThrow71 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ANNEXURE_C_URL_PG2");
            int columnIndexOrThrow72 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IP_ADDRESS");
            int columnIndexOrThrow73 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "USER_ID");
            int columnIndexOrThrow74 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IS_LEGACY_OPT");
            int columnIndexOrThrow75 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_OVER_RIDDEN_FLG");
            int columnIndexOrThrow76 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EMAIL_ID");
            int columnIndexOrThrow77 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PASSPORT_NO");
            int columnIndexOrThrow78 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ELECTOR_TYPE");
            int columnIndexOrThrow79 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ELECTOR_NAME");
            int columnIndexOrThrow80 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRV_PARTNO");
            int columnIndexOrThrow81 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRV_PARTSLNO");
            int columnIndexOrThrow82 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PRV_CAT");
            int columnIndexOrThrow83 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_TYPE");
            int columnIndexOrThrow84 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_PROOF_DOC_URL_PG1");
            int columnIndexOrThrow85 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_PROOF_DOC_URL_PG2");
            int columnIndexOrThrow86 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_OLD_AC_NO");
            int columnIndexOrThrow87 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_OLD_PART_NO");
            int columnIndexOrThrow88 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_OLD_PSL_NO");
            int columnIndexOrThrow89 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_DOC_TYPE");
            int columnIndexOrThrow90 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_DOC_URL_PG1");
            int columnIndexOrThrow91 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_DOC_URL_PG2");
            int columnIndexOrThrow92 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IS_RELATIVE_PRE_VOTER_FLG");
            int columnIndexOrThrow93 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_EPIC_NO");
            int columnIndexOrThrow94 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IS_THIS_YOU_FLG");
            int columnIndexOrThrow95 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "IS_THIS_YOU_REL_FLG");
            int columnIndexOrThrow96 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "RELATION_OLD_STATE_CD");
            int columnIndexOrThrow97 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "OLD_STATE_CD");
            int columnIndexOrThrow98 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tabName");
            int columnIndexOrThrow99 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "COMMENTS");
            int columnIndexOrThrow100 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "REQUEST_STATUS_CODE");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                Long lValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow));
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text12 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text13 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow15;
                String text14 = sQLiteStatementPrepare.isNull(i2) ? null : sQLiteStatementPrepare.getText(i2);
                int i3 = columnIndexOrThrow16;
                String text15 = sQLiteStatementPrepare.isNull(i3) ? null : sQLiteStatementPrepare.getText(i3);
                int i4 = columnIndexOrThrow17;
                String text16 = sQLiteStatementPrepare.isNull(i4) ? null : sQLiteStatementPrepare.getText(i4);
                int i5 = columnIndexOrThrow18;
                String text17 = sQLiteStatementPrepare.isNull(i5) ? null : sQLiteStatementPrepare.getText(i5);
                int i6 = columnIndexOrThrow19;
                String text18 = sQLiteStatementPrepare.isNull(i6) ? null : sQLiteStatementPrepare.getText(i6);
                int i7 = columnIndexOrThrow20;
                String text19 = sQLiteStatementPrepare.isNull(i7) ? null : sQLiteStatementPrepare.getText(i7);
                int i8 = columnIndexOrThrow21;
                String text20 = sQLiteStatementPrepare.isNull(i8) ? null : sQLiteStatementPrepare.getText(i8);
                int i9 = columnIndexOrThrow22;
                String text21 = sQLiteStatementPrepare.isNull(i9) ? null : sQLiteStatementPrepare.getText(i9);
                int i10 = columnIndexOrThrow23;
                String text22 = sQLiteStatementPrepare.isNull(i10) ? null : sQLiteStatementPrepare.getText(i10);
                int i11 = columnIndexOrThrow24;
                String text23 = sQLiteStatementPrepare.isNull(i11) ? null : sQLiteStatementPrepare.getText(i11);
                int i12 = columnIndexOrThrow25;
                String text24 = sQLiteStatementPrepare.isNull(i12) ? null : sQLiteStatementPrepare.getText(i12);
                int i13 = columnIndexOrThrow26;
                String text25 = sQLiteStatementPrepare.isNull(i13) ? null : sQLiteStatementPrepare.getText(i13);
                int i14 = columnIndexOrThrow27;
                String text26 = sQLiteStatementPrepare.isNull(i14) ? null : sQLiteStatementPrepare.getText(i14);
                int i15 = columnIndexOrThrow28;
                String text27 = sQLiteStatementPrepare.isNull(i15) ? null : sQLiteStatementPrepare.getText(i15);
                int i16 = columnIndexOrThrow29;
                String text28 = sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16);
                int i17 = columnIndexOrThrow30;
                String text29 = sQLiteStatementPrepare.isNull(i17) ? null : sQLiteStatementPrepare.getText(i17);
                int i18 = columnIndexOrThrow31;
                String text30 = sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18);
                int i19 = columnIndexOrThrow32;
                String text31 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                int i20 = columnIndexOrThrow33;
                String text32 = sQLiteStatementPrepare.isNull(i20) ? null : sQLiteStatementPrepare.getText(i20);
                int i21 = columnIndexOrThrow34;
                String text33 = sQLiteStatementPrepare.isNull(i21) ? null : sQLiteStatementPrepare.getText(i21);
                int i22 = columnIndexOrThrow35;
                String text34 = sQLiteStatementPrepare.isNull(i22) ? null : sQLiteStatementPrepare.getText(i22);
                int i23 = columnIndexOrThrow36;
                String text35 = sQLiteStatementPrepare.isNull(i23) ? null : sQLiteStatementPrepare.getText(i23);
                int i24 = columnIndexOrThrow37;
                String text36 = sQLiteStatementPrepare.isNull(i24) ? null : sQLiteStatementPrepare.getText(i24);
                int i25 = columnIndexOrThrow38;
                String text37 = sQLiteStatementPrepare.isNull(i25) ? null : sQLiteStatementPrepare.getText(i25);
                int i26 = columnIndexOrThrow39;
                String text38 = sQLiteStatementPrepare.isNull(i26) ? null : sQLiteStatementPrepare.getText(i26);
                int i27 = columnIndexOrThrow40;
                String text39 = sQLiteStatementPrepare.isNull(i27) ? null : sQLiteStatementPrepare.getText(i27);
                int i28 = columnIndexOrThrow41;
                String text40 = sQLiteStatementPrepare.isNull(i28) ? null : sQLiteStatementPrepare.getText(i28);
                int i29 = columnIndexOrThrow42;
                String text41 = sQLiteStatementPrepare.isNull(i29) ? null : sQLiteStatementPrepare.getText(i29);
                int i30 = columnIndexOrThrow43;
                String text42 = sQLiteStatementPrepare.isNull(i30) ? null : sQLiteStatementPrepare.getText(i30);
                int i31 = columnIndexOrThrow44;
                String text43 = sQLiteStatementPrepare.isNull(i31) ? null : sQLiteStatementPrepare.getText(i31);
                int i32 = columnIndexOrThrow45;
                String text44 = sQLiteStatementPrepare.isNull(i32) ? null : sQLiteStatementPrepare.getText(i32);
                int i33 = columnIndexOrThrow46;
                String text45 = sQLiteStatementPrepare.isNull(i33) ? null : sQLiteStatementPrepare.getText(i33);
                int i34 = columnIndexOrThrow47;
                String text46 = sQLiteStatementPrepare.isNull(i34) ? null : sQLiteStatementPrepare.getText(i34);
                int i35 = columnIndexOrThrow48;
                String text47 = sQLiteStatementPrepare.isNull(i35) ? null : sQLiteStatementPrepare.getText(i35);
                int i36 = columnIndexOrThrow49;
                String text48 = sQLiteStatementPrepare.isNull(i36) ? null : sQLiteStatementPrepare.getText(i36);
                int i37 = columnIndexOrThrow50;
                String text49 = sQLiteStatementPrepare.isNull(i37) ? null : sQLiteStatementPrepare.getText(i37);
                int i38 = columnIndexOrThrow51;
                String text50 = sQLiteStatementPrepare.isNull(i38) ? null : sQLiteStatementPrepare.getText(i38);
                int i39 = columnIndexOrThrow52;
                String text51 = sQLiteStatementPrepare.isNull(i39) ? null : sQLiteStatementPrepare.getText(i39);
                int i40 = columnIndexOrThrow53;
                String text52 = sQLiteStatementPrepare.isNull(i40) ? null : sQLiteStatementPrepare.getText(i40);
                int i41 = columnIndexOrThrow54;
                String text53 = sQLiteStatementPrepare.isNull(i41) ? null : sQLiteStatementPrepare.getText(i41);
                int i42 = columnIndexOrThrow55;
                String text54 = sQLiteStatementPrepare.isNull(i42) ? null : sQLiteStatementPrepare.getText(i42);
                int i43 = columnIndexOrThrow56;
                String text55 = sQLiteStatementPrepare.isNull(i43) ? null : sQLiteStatementPrepare.getText(i43);
                int i44 = columnIndexOrThrow57;
                String text56 = sQLiteStatementPrepare.isNull(i44) ? null : sQLiteStatementPrepare.getText(i44);
                int i45 = columnIndexOrThrow58;
                String text57 = sQLiteStatementPrepare.isNull(i45) ? null : sQLiteStatementPrepare.getText(i45);
                int i46 = columnIndexOrThrow59;
                String text58 = sQLiteStatementPrepare.isNull(i46) ? null : sQLiteStatementPrepare.getText(i46);
                int i47 = columnIndexOrThrow60;
                String text59 = sQLiteStatementPrepare.isNull(i47) ? null : sQLiteStatementPrepare.getText(i47);
                int i48 = columnIndexOrThrow61;
                String text60 = sQLiteStatementPrepare.isNull(i48) ? null : sQLiteStatementPrepare.getText(i48);
                int i49 = columnIndexOrThrow62;
                String text61 = sQLiteStatementPrepare.isNull(i49) ? null : sQLiteStatementPrepare.getText(i49);
                int i50 = columnIndexOrThrow63;
                String text62 = sQLiteStatementPrepare.isNull(i50) ? null : sQLiteStatementPrepare.getText(i50);
                int i51 = columnIndexOrThrow64;
                String text63 = sQLiteStatementPrepare.isNull(i51) ? null : sQLiteStatementPrepare.getText(i51);
                int i52 = columnIndexOrThrow65;
                String text64 = sQLiteStatementPrepare.isNull(i52) ? null : sQLiteStatementPrepare.getText(i52);
                int i53 = columnIndexOrThrow66;
                String text65 = sQLiteStatementPrepare.isNull(i53) ? null : sQLiteStatementPrepare.getText(i53);
                int i54 = columnIndexOrThrow67;
                String text66 = sQLiteStatementPrepare.isNull(i54) ? null : sQLiteStatementPrepare.getText(i54);
                int i55 = columnIndexOrThrow68;
                String text67 = sQLiteStatementPrepare.isNull(i55) ? null : sQLiteStatementPrepare.getText(i55);
                int i56 = columnIndexOrThrow69;
                String text68 = sQLiteStatementPrepare.isNull(i56) ? null : sQLiteStatementPrepare.getText(i56);
                int i57 = columnIndexOrThrow70;
                String text69 = sQLiteStatementPrepare.isNull(i57) ? null : sQLiteStatementPrepare.getText(i57);
                int i58 = columnIndexOrThrow71;
                String text70 = sQLiteStatementPrepare.isNull(i58) ? null : sQLiteStatementPrepare.getText(i58);
                int i59 = columnIndexOrThrow72;
                String text71 = sQLiteStatementPrepare.isNull(i59) ? null : sQLiteStatementPrepare.getText(i59);
                int i60 = columnIndexOrThrow73;
                String text72 = sQLiteStatementPrepare.isNull(i60) ? null : sQLiteStatementPrepare.getText(i60);
                int i61 = columnIndexOrThrow74;
                String text73 = sQLiteStatementPrepare.isNull(i61) ? null : sQLiteStatementPrepare.getText(i61);
                int i62 = columnIndexOrThrow75;
                String text74 = sQLiteStatementPrepare.isNull(i62) ? null : sQLiteStatementPrepare.getText(i62);
                int i63 = columnIndexOrThrow76;
                String text75 = sQLiteStatementPrepare.isNull(i63) ? null : sQLiteStatementPrepare.getText(i63);
                int i64 = columnIndexOrThrow77;
                String text76 = sQLiteStatementPrepare.isNull(i64) ? null : sQLiteStatementPrepare.getText(i64);
                int i65 = columnIndexOrThrow78;
                String text77 = sQLiteStatementPrepare.isNull(i65) ? null : sQLiteStatementPrepare.getText(i65);
                int i66 = columnIndexOrThrow79;
                String text78 = sQLiteStatementPrepare.isNull(i66) ? null : sQLiteStatementPrepare.getText(i66);
                int i67 = columnIndexOrThrow83;
                String text79 = sQLiteStatementPrepare.isNull(i67) ? null : sQLiteStatementPrepare.getText(i67);
                int i68 = columnIndexOrThrow84;
                String text80 = sQLiteStatementPrepare.isNull(i68) ? null : sQLiteStatementPrepare.getText(i68);
                int i69 = columnIndexOrThrow85;
                String text81 = sQLiteStatementPrepare.isNull(i69) ? null : sQLiteStatementPrepare.getText(i69);
                int i70 = columnIndexOrThrow86;
                String text82 = sQLiteStatementPrepare.isNull(i70) ? null : sQLiteStatementPrepare.getText(i70);
                int i71 = columnIndexOrThrow87;
                String text83 = sQLiteStatementPrepare.isNull(i71) ? null : sQLiteStatementPrepare.getText(i71);
                int i72 = columnIndexOrThrow88;
                String text84 = sQLiteStatementPrepare.isNull(i72) ? null : sQLiteStatementPrepare.getText(i72);
                int i73 = columnIndexOrThrow89;
                String text85 = sQLiteStatementPrepare.isNull(i73) ? null : sQLiteStatementPrepare.getText(i73);
                int i74 = columnIndexOrThrow90;
                String text86 = sQLiteStatementPrepare.isNull(i74) ? null : sQLiteStatementPrepare.getText(i74);
                int i75 = columnIndexOrThrow91;
                String text87 = sQLiteStatementPrepare.isNull(i75) ? null : sQLiteStatementPrepare.getText(i75);
                int i76 = columnIndexOrThrow92;
                String text88 = sQLiteStatementPrepare.isNull(i76) ? null : sQLiteStatementPrepare.getText(i76);
                int i77 = columnIndexOrThrow93;
                String text89 = sQLiteStatementPrepare.isNull(i77) ? null : sQLiteStatementPrepare.getText(i77);
                int i78 = columnIndexOrThrow94;
                String text90 = sQLiteStatementPrepare.isNull(i78) ? null : sQLiteStatementPrepare.getText(i78);
                int i79 = columnIndexOrThrow95;
                String text91 = sQLiteStatementPrepare.isNull(i79) ? null : sQLiteStatementPrepare.getText(i79);
                int i80 = columnIndexOrThrow96;
                String text92 = sQLiteStatementPrepare.isNull(i80) ? null : sQLiteStatementPrepare.getText(i80);
                int i81 = columnIndexOrThrow97;
                String text93 = sQLiteStatementPrepare.isNull(i81) ? null : sQLiteStatementPrepare.getText(i81);
                int i82 = columnIndexOrThrow98;
                SpecialSurveyRevisionModel specialSurveyRevisionModel = new SpecialSurveyRevisionModel(lValueOf, text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22, text23, text24, text25, text26, text27, text28, text29, text30, text31, text32, text33, text34, text35, text36, text37, text38, text39, text40, text41, text42, text43, text44, text45, text46, text47, text48, text49, text50, text51, text52, text53, text54, text55, text56, text57, text58, text59, text60, text61, text62, text63, text64, text65, text66, text67, text68, text69, text70, text71, text72, text73, text74, text75, text76, text77, text78, text79, text85, text86, text88, text87, text80, text81, text82, text83, text84, text89, text90, text91, sQLiteStatementPrepare.isNull(i82) ? null : sQLiteStatementPrepare.getText(i82), text92, text93);
                int i83 = columnIndexOrThrow2;
                int i84 = columnIndexOrThrow80;
                specialSurveyRevisionModel.setPrvPartNo(sQLiteStatementPrepare.isNull(i84) ? null : sQLiteStatementPrepare.getText(i84));
                columnIndexOrThrow81 = columnIndexOrThrow81;
                specialSurveyRevisionModel.setPrvPartSlNo(sQLiteStatementPrepare.isNull(columnIndexOrThrow81) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow81));
                columnIndexOrThrow82 = columnIndexOrThrow82;
                specialSurveyRevisionModel.setPrvCat(sQLiteStatementPrepare.isNull(columnIndexOrThrow82) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow82));
                int i85 = columnIndexOrThrow99;
                columnIndexOrThrow99 = i85;
                specialSurveyRevisionModel.setComments(sQLiteStatementPrepare.isNull(i85) ? null : sQLiteStatementPrepare.getText(i85));
                int i86 = columnIndexOrThrow3;
                int i87 = columnIndexOrThrow100;
                int i88 = columnIndexOrThrow4;
                specialSurveyRevisionModel.setRequestStatusCode((int) sQLiteStatementPrepare.getLong(i87));
                arrayList.add(specialSurveyRevisionModel);
                columnIndexOrThrow = i;
                columnIndexOrThrow15 = i2;
                columnIndexOrThrow16 = i3;
                columnIndexOrThrow17 = i4;
                columnIndexOrThrow18 = i5;
                columnIndexOrThrow19 = i6;
                columnIndexOrThrow20 = i7;
                columnIndexOrThrow21 = i8;
                columnIndexOrThrow22 = i9;
                columnIndexOrThrow23 = i10;
                columnIndexOrThrow24 = i11;
                columnIndexOrThrow25 = i12;
                columnIndexOrThrow26 = i13;
                columnIndexOrThrow27 = i14;
                columnIndexOrThrow28 = i15;
                columnIndexOrThrow29 = i16;
                columnIndexOrThrow30 = i17;
                columnIndexOrThrow31 = i18;
                columnIndexOrThrow32 = i19;
                columnIndexOrThrow33 = i20;
                columnIndexOrThrow34 = i21;
                columnIndexOrThrow35 = i22;
                columnIndexOrThrow36 = i23;
                columnIndexOrThrow37 = i24;
                columnIndexOrThrow38 = i25;
                columnIndexOrThrow39 = i26;
                columnIndexOrThrow40 = i27;
                columnIndexOrThrow41 = i28;
                columnIndexOrThrow42 = i29;
                columnIndexOrThrow43 = i30;
                columnIndexOrThrow44 = i31;
                columnIndexOrThrow45 = i32;
                columnIndexOrThrow46 = i33;
                columnIndexOrThrow47 = i34;
                columnIndexOrThrow48 = i35;
                columnIndexOrThrow49 = i36;
                columnIndexOrThrow50 = i37;
                columnIndexOrThrow51 = i38;
                columnIndexOrThrow52 = i39;
                columnIndexOrThrow53 = i40;
                columnIndexOrThrow54 = i41;
                columnIndexOrThrow55 = i42;
                columnIndexOrThrow56 = i43;
                columnIndexOrThrow57 = i44;
                columnIndexOrThrow58 = i45;
                columnIndexOrThrow59 = i46;
                columnIndexOrThrow60 = i47;
                columnIndexOrThrow61 = i48;
                columnIndexOrThrow62 = i49;
                columnIndexOrThrow63 = i50;
                columnIndexOrThrow64 = i51;
                columnIndexOrThrow65 = i52;
                columnIndexOrThrow66 = i53;
                columnIndexOrThrow67 = i54;
                columnIndexOrThrow68 = i55;
                columnIndexOrThrow69 = i56;
                columnIndexOrThrow70 = i57;
                columnIndexOrThrow71 = i58;
                columnIndexOrThrow72 = i59;
                columnIndexOrThrow73 = i60;
                columnIndexOrThrow74 = i61;
                columnIndexOrThrow75 = i62;
                columnIndexOrThrow76 = i63;
                columnIndexOrThrow77 = i64;
                columnIndexOrThrow78 = i65;
                columnIndexOrThrow3 = i86;
                columnIndexOrThrow79 = i66;
                columnIndexOrThrow83 = i67;
                columnIndexOrThrow84 = i68;
                columnIndexOrThrow85 = i69;
                columnIndexOrThrow86 = i70;
                columnIndexOrThrow87 = i71;
                columnIndexOrThrow88 = i72;
                columnIndexOrThrow89 = i73;
                columnIndexOrThrow90 = i74;
                columnIndexOrThrow91 = i75;
                columnIndexOrThrow92 = i76;
                columnIndexOrThrow93 = i77;
                columnIndexOrThrow94 = i78;
                columnIndexOrThrow95 = i79;
                columnIndexOrThrow96 = i80;
                columnIndexOrThrow97 = i81;
                columnIndexOrThrow4 = i88;
                columnIndexOrThrow98 = i82;
                columnIndexOrThrow80 = i84;
                columnIndexOrThrow100 = i87;
                columnIndexOrThrow2 = i83;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public int getAllFormsFromDB() {
        return ((Integer) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return SpecialRevisionDao_Impl.lambda$getAllFormsFromDB$5((SQLiteConnection) obj);
            }
        })).intValue();
    }

    static /* synthetic */ Integer lambda$getAllFormsFromDB$5(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select count(*) from special_revision_survey");
        try {
            return Integer.valueOf(sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public List<String> getFormsFromDB() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return SpecialRevisionDao_Impl.lambda$getFormsFromDB$6((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getFormsFromDB$6(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select EPIC_NO from special_revision_survey ");
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public boolean isFormExist(final Long epicID) {
        return ((Boolean) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return SpecialRevisionDao_Impl.lambda$isFormExist$7(epicID, (SQLiteConnection) obj);
            }
        })).booleanValue();
    }

    static /* synthetic */ Boolean lambda$isFormExist$7(Long l, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select EXISTS(select 1 from special_revision_survey where EPIC_ID = ?)");
        boolean z = true;
        try {
            if (l == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindLong(1, l.longValue());
            }
            boolean z2 = false;
            if (sQLiteStatementPrepare.step()) {
                if (((int) sQLiteStatementPrepare.getLong(0)) == 0) {
                    z = false;
                }
                z2 = z;
            }
            Boolean boolValueOf = Boolean.valueOf(z2);
            sQLiteStatementPrepare.close();
            return boolValueOf;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public int getPendingCountFromDB() {
        return ((Integer) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return SpecialRevisionDao_Impl.lambda$getPendingCountFromDB$8((SQLiteConnection) obj);
            }
        })).intValue();
    }

    static /* synthetic */ Integer lambda$getPendingCountFromDB$8(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select count(*) from special_revision_survey WHERE REQUEST_STATUS_CODE IN (200,510,401)");
        try {
            return Integer.valueOf(sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public void deleteSpecialSurveyRevisionDetails(final Long epicID) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return SpecialRevisionDao_Impl.lambda$deleteSpecialSurveyRevisionDetails$9(epicID, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$deleteSpecialSurveyRevisionDetails$9(Long l, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM special_revision_survey WHERE EPIC_ID = ?");
        try {
            if (l == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindLong(1, l.longValue());
            }
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return null;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.SpecialRevisionDao
    public void UpdateErrorMessage(final Long epicID, final String errorMessage, final int statuscode) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return SpecialRevisionDao_Impl.lambda$UpdateErrorMessage$10(errorMessage, statuscode, epicID, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$UpdateErrorMessage$10(String str, int i, Long l, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("UPDATE special_revision_survey SET COMMENTS = ?, REQUEST_STATUS_CODE = ? WHERE EPIC_ID = ?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            sQLiteStatementPrepare.bindLong(2, i);
            if (l == null) {
                sQLiteStatementPrepare.bindNull(3);
            } else {
                sQLiteStatementPrepare.bindLong(3, l.longValue());
            }
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return null;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
