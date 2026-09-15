# BLO App (in.gov.eci.bloapp) Comprehensive Software Change Log

## Overview of Version Evolution During SIR (June 2026 – September 2026)

| Version | Date | Version Code | Activities | Strings | ECI Classes | Major Changes Summary |
|---|---|---|---|---|---|---|
| 9.39 | 2026-06-02 | 233 | 141 | 2086 | 10897 | Minor maintenance / bugfix |
| 9.40 | 2026-06-07 | 234 | 143 | 2089 | 11006 | +2 activities (MigratedElectorsFormActivity, MigratedElectors); +3 strings; +109 classes |
| 9.41 | 2026-06-09 | 235 | 144 | 2091 | 11040 | +1 activities (PseVerifiedListActivity); +2 strings; +36 classes |
| 9.42 | 2026-06-17 | 236 | 145 | 2098 | 11076 | +1 activities (BloSuperVisorActivity); +7 strings; 2 modified strings; +40 classes |
| 9.43 | 2026-06-19 | 237 | 145 | 2098 | 11080 | +44 classes |
| 9.44 | 2026-06-25 | 238 | 146 | 2111 | 11128 | +1 activities (EpicDeliveryListActivity); +13 strings; +80 classes |
| 9.45 | 2026-06-27 | 239 | 146 | 2111 | 11128 | Minor maintenance / bugfix |
| 9.46 | 2026-06-29 | 240 | 146 | 2111 | 11145 | +38 classes |
| 9.47 | 2026-07-03 | 241 | 146 | 2112 | 11191 | +1 strings; +137 classes |
| 9.48 | 2026-07-04 | 242 | 146 | 2117 | 11218 | +5 strings; 1 modified strings; +74 classes |
| 9.49 | 2026-07-05 | 243 | 146 | 2117 | 11217 | Minor maintenance / bugfix |
| 9.50 | 2026-07-08 | 244 | 148 | 2121 | 11245 | +2 activities (ViewLogicalActivity, ReportAnomalyActivity); +4 strings; +31 classes |
| 9.51 | 2026-07-09 | 245 | 148 | 2121 | 11245 | Minor maintenance / bugfix |
| 9.52 | 2026-07-09 | 246 | 148 | 2121 | 11249 | +4 classes |
| 9.53 | 2026-07-10 | 247 | 148 | 2122 | 11249 | +1 strings |
| 9.54 | 2026-07-10 | 248 | 149 | 2122 | 11271 | +1 activities (AdditionalCommentListActivity); 2 modified strings; +23 classes |
| 9.55 | 2026-07-18 | 249 | 151 | 2130 | 11332 | +2 activities (ATModuleNoticeListActivity, ActivityNoticeUploadReceipt); +8 strings; +61 classes |
| 9.56 | 2026-07-31 | 250 | 152 | 2133 | 11354 | +1 activities (MarkVipListActivity); +3 strings; +22 classes |
| 9.57 | 2026-08-03 | 251 | 152 | 2134 | 11355 | +1 strings; +1 classes |
| 9.58 | 2026-08-05 | 252 | 152 | 2135 | 11363 | +1 strings; 1 modified strings; +21 classes |
| 9.59 | 2026-08-08 | 253 | 152 | 2141 | 11415 | +6 strings; +107 classes |
| 9.60 | 2026-08-11 | 254 | 153 | 2145 | 11451 | +1 activities (AddNotionalListActivity); +4 strings; +86 classes |
| 9.61 | 2026-08-12 | 255 | 153 | 2145 | 11452 | +1 classes |
| 9.62 | 2026-08-14 | 256 | 153 | 2150 | 11520 | +5 strings; +208 classes |
| 9.63 | 2026-08-16 | 257 | 153 | 2151 | 11537 | +1 strings; +64 classes |
| 9.64 | 2026-08-17 | 258 | 153 | 2152 | 11600 | +1 strings; +85 classes |
| 9.65 | 2026-08-22 | 259 | 154 | 2155 | 11628 | +1 activities (DseForm7Activity); +3 strings; 1 modified strings; +28 classes |
| 9.66 | 2026-08-25 | 260 | 154 | 2155 | 11628 | Minor maintenance / bugfix |
| 9.67 | 2026-08-27 | 261 | 154 | 2155 | 11628 | Minor maintenance / bugfix |
| 9.68 | 2026-09-06 | 262 | 154 | 2155 | 11642 | +14 classes |


---

## Detailed Version-by-Version Breakdown

### Version 9.39 (Date: 2026-06-02, Version Code: 233)

### Version 9.40 (Date: 2026-06-07, Version Code: 234)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity`
- `in.gov.eci.bloapp.views.activity.sir.MigratedElectors`

#### New UI Strings / Features:
- **`color_code_info_ef`**: "Click here to view color code info"
- **`migrated_elector`**: "Migrated Electors From Last SIR 2025/2026 States"
- **`self_name_ef`**: "Name :"

#### Codebase Changes:
- Added 109 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity.newsir.activity`: 82 classes
    - `in.gov.eci.bloapp.views.activity.sir`: 12 classes
    - `in.gov.eci.bloapp.views.activity.newsir.fragment`: 6 classes
    - `in.gov.eci.bloapp.views.activity.newsir.adapter`: 5 classes
    - `in.gov.eci.bloapp`: 1 classes
    - `in.gov.eci.bloapp.api`: 1 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes
    - `in.gov.eci.bloapp.views.activity.sir.formdatanew`: 1 classes

### Version 9.41 (Date: 2026-06-09, Version Code: 235)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.PseVerifiedListActivity`

#### New UI Strings / Features:
- **`pseActivity_homeIcon`**: "Verify PSE Entries"
- **`pse_verified`**: "PSE Verification"

#### Codebase Changes:
- Added 36 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity`: 18 classes
    - `in.gov.eci.bloapp.views.activity.newsir.adapter`: 7 classes
    - `in.gov.eci.bloapp.views.activity.newsir.model`: 4 classes
    - `in.gov.eci.bloapp`: 2 classes
    - `in.gov.eci.bloapp.views.activity.newsir.callback`: 2 classes
    - `in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection`: 2 classes
    - `in.gov.eci.bloapp.views.fragments.home`: 1 classes

### Version 9.42 (Date: 2026-06-17, Version Code: 236)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity`

#### New UI Strings / Features:
- **`blo_details`**: "BLO Details"
- **`blo_name_new`**: "BLO Name"
- **`blo_number`**: "BLO Mobile Number"
- **`blo_part`**: "BLO Part No"
- **`blo_part_name`**: "Part No & Name:"
- **`blo_registered_mobile_number_bloss`**: "Registered Mobile Number/BLO Supervisor"
- **`last_2003_text_2006`**: "SIR 2002/2003/2005/2006"

#### Modified Strings:
- **`filled_relationtype_spinnert`**:
  - *Old*: "Elector Relationship with Relative details"
  - *New*: "Elector Relationship with Relative details  *"
- **`relationtype_spinnert`**:
  - *Old*: "Select Elector Relationship with Relative details"
  - *New*: "Select Elector Relationship with Relative details  *"

#### Codebase Changes:
- Added 40 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification`: 13 classes
    - `in.gov.eci.bloapp.views.fragments.home`: 10 classes
    - `in.gov.eci.bloapp.views.activity.newsir.adapter`: 5 classes
    - `in.gov.eci.bloapp.views.activity.sir`: 4 classes
    - `in.gov.eci.bloapp.views.fragments.login`: 4 classes
    - `in.gov.eci.bloapp`: 1 classes
    - `in.gov.eci.bloapp.api`: 1 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

### Version 9.43 (Date: 2026-06-19, Version Code: 237)

#### Codebase Changes:
- Added 44 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration`: 22 classes
    - `in.gov.eci.bloapp.views.fragments.voterforms.migration`: 20 classes
    - `in.gov.eci.bloapp.views.fragments.home`: 2 classes

### Version 9.44 (Date: 2026-06-25, Version Code: 238)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity`

#### New UI Strings / Features:
- **`assign_ero`**: "Return to ERO"
- **`blo_Document_for_Proof_of_AdditionalDoc`**: "Document for Proof of Additional Document"
- **`blo_add_doc`**: "Additional Document"
- **`blo_upload_additional_document`**: "Proof of Additional document *"
- **`epic_elector_name`**: "Elector Name"
- **`epic_mark_deliver`**: "Mark Delivered"
- **`epic_part_no`**: "Part Serial No"
- **`epic_reason`**: "Reason"
- **`epic_reason_undertaking`**: "I confirm that multiple delivery attempt has been made, but could not deliver the epic as the applicant has shifted. The Epic is being returned to ERO."
- **`epic_reference_id`**: "Reference Id"
- **`form8_correction_dialog`**: "This is only for correction in existing enteries of address, in case elector has shifted to new address please fill form 8 Shifting of Residence."
- **`home_epic_deliver`**: "Undelivered Epic"
- **`returnEROMessage`**: "Are you sure you want to return this Epic to ERO, and have tried delivery at least 3 times?"

#### Codebase Changes:
- Added 80 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration`: 34 classes
    - `in.gov.eci.bloapp.views.fragments.voterforms.migration`: 15 classes
    - `in.gov.eci.bloapp.views.activity`: 13 classes
    - `in.gov.eci.bloapp.views.activity.newsir.model`: 6 classes
    - `in.gov.eci.bloapp.views.activity.newsir.adapter`: 4 classes
    - `in.gov.eci.bloapp.databinding`: 3 classes
    - `in.gov.eci.bloapp`: 2 classes
    - `in.gov.eci.bloapp.views.activity.newsir.callback`: 2 classes

### Version 9.45 (Date: 2026-06-27, Version Code: 239)

### Version 9.46 (Date: 2026-06-29, Version Code: 240)

#### Codebase Changes:
- Added 38 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.voterforms.migration`: 37 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

### Version 9.47 (Date: 2026-07-03, Version Code: 241)

#### New UI Strings / Features:
- **`blo_mapped_heading`**: "BLO mapping done during Pre-SIR"

#### Codebase Changes:
- Added 137 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.checklist.form6`: 68 classes
    - `in.gov.eci.bloapp.views.fragments.checklist`: 61 classes
    - `in.gov.eci.bloapp.views.activity.newsir.fragment`: 6 classes
    - `in.gov.eci.bloapp.api`: 1 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

### Version 9.48 (Date: 2026-07-04, Version Code: 242)

#### New UI Strings / Features:
- **`blo_doc_count`**: "Please provide number of document uploaded  *"
- **`doc_count_hint`**: "max. 4 documents"
- **`upload_doc2`**: "Upload Document 2 *"
- **`upload_doc3`**: "Upload Document 3 *"
- **`upload_doc4`**: "Upload Document 4 *"

#### Modified Strings:
- **`indian_citizen_by`**:
  - *Old*: "Name exists in last SIR electoral roll"
  - *New*: "Name exists in last SIR electoral roll %1$s"

#### Codebase Changes:
- Added 74 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity.newsir.activity.anomaly`: 49 classes
    - `in.gov.eci.bloapp.views.activity.newsir.activity`: 25 classes

### Version 9.49 (Date: 2026-07-05, Version Code: 243)

### Version 9.50 (Date: 2026-07-08, Version Code: 244)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity`
- `in.gov.eci.bloapp.views.activity.sir.ReportAnomalyActivity`

#### New UI Strings / Features:
- **`anomalySingleRow`**: "Report Anomaly"
- **`post_anomaly`**: "View Logical Discrepancies"
- **`reportAnomalyReason`**: "Report Anomaly reason:"
- **`reportBLORemark`**: "BLO Remark:"

#### Codebase Changes:
- Added 31 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity.newsir.activity.anomaly`: 15 classes
    - `in.gov.eci.bloapp.views.activity.sir`: 6 classes
    - `in.gov.eci.bloapp.views.activity.newsir.adapter`: 4 classes
    - `in.gov.eci.bloapp.views.activity.sir.formdatanew`: 3 classes
    - `in.gov.eci.bloapp`: 2 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

### Version 9.51 (Date: 2026-07-09, Version Code: 245)

### Version 9.52 (Date: 2026-07-09, Version Code: 246)

#### Codebase Changes:
- Added 4 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification`: 3 classes
    - `in.gov.eci.bloapp.views.activity.newsir.adapter`: 1 classes

### Version 9.53 (Date: 2026-07-10, Version Code: 247)

#### New UI Strings / Features:
- **`reportAnomalyDisclaimer`**: "Disclaimer: This feature is intended only for reporting suspected anomalies noticed by the BLO during field verification. It should be used only where there is a genuine discrepancy requiring further verification (For example if a BLO knows that an elector is not residing at the address , but the Enumeration form has still been signed by a family member or the age gap between the EROLL and in Aadhaar is too large or any other similar issue.). Reporting an anomaly does not confirm any irregularity; it only flags the case for verification by the ERO/AERO."

### Version 9.54 (Date: 2026-07-10, Version Code: 248)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.AdditionalCommentListActivity`

#### Modified Strings:
- **`anomalySingleRow`**:
  - *Old*: "Report Anomaly"
  - *New*: "Additional comments of BLO(optional)"
- **`reportAnomalyReason`**:
  - *Old*: "Report Anomaly reason:"
  - *New*: "BLO comments (Optional)"

#### Codebase Changes:
- Added 23 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity`: 7 classes
    - `in.gov.eci.bloapp.views.activity.newsir.fragment`: 7 classes
    - `in.gov.eci.bloapp.views.activity.newsir.adapter`: 3 classes
    - `in.gov.eci.bloapp.databinding`: 2 classes
    - `in.gov.eci.bloapp`: 1 classes
    - `in.gov.eci.bloapp.views.activity.newsir.callback`: 1 classes
    - `in.gov.eci.bloapp.views.activity.newsir.utils`: 1 classes
    - `in.gov.eci.bloapp.views.activity.sir.formdatanew`: 1 classes

### Version 9.55 (Date: 2026-07-18, Version Code: 249)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.sir.formdatanew.ATModuleNoticeListActivity`
- `in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt`

#### New UI Strings / Features:
- **`completed_text_dash`**: "Delivered"
- **`flag_incorrect_mapping`**: "Flag incorrect Mapping"
- **`flag_incorrect_mapping_des`**: "Please confirm if the mapping of this elector as SELF in last SIR is correct, and it is already mapped in another state. As of now, you may map this elector as a progeny/no mapping and continue filling the Enumeration Form (EF)."
- **`generated_notice`**: "Generated Notice Document:"
- **`notice_delivery`**: "AT Notice Delivery"
- **`notice_mark_delievered`**: "Mark As Delivered"
- **`notice_pending`**: "Pending notice"
- **`pending_text_dash`**: "Pending Delivery"

#### Codebase Changes:
- Added 61 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity.sir.formdatanew`: 47 classes
    - `in.gov.eci.bloapp.views.activity.newsir.fragment`: 7 classes
    - `in.gov.eci.bloapp.adapter`: 3 classes
    - `in.gov.eci.bloapp.views.activity.newsir.model`: 2 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes
    - `in.gov.eci.bloapp.views.fragments.home`: 1 classes

### Version 9.56 (Date: 2026-07-31, Version Code: 250)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity`

#### New UI Strings / Features:
- **`home_mark_vip`**: "Mark VIP"
- **`not_submitted_the_form_new`**: "The applicant is not listed above and has not submitted this form."
- **`vip_relation_name`**: "Relation Name:"

#### Codebase Changes:
- Added 22 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity.sir.formdatanew`: 8 classes
    - `in.gov.eci.bloapp.views.fragments.home`: 5 classes
    - `in.gov.eci.bloapp.adapter`: 4 classes
    - `in.gov.eci.bloapp.databinding`: 2 classes
    - `in.gov.eci.bloapp.views.activity.newsir.model`: 2 classes
    - `in.gov.eci.bloapp.views.activity.newsir.callback`: 1 classes

### Version 9.57 (Date: 2026-08-03, Version Code: 251)

#### New UI Strings / Features:
- **`othername_mandatory`**: "Other Name :  *"

#### Codebase Changes:
- Added 1 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.api`: 1 classes

### Version 9.58 (Date: 2026-08-05, Version Code: 252)

#### New UI Strings / Features:
- **`aerl_already_enrolled`**: "Yes,The Elector and the Applicant are found to be the same person enrolled multiple times"

#### Modified Strings:
- **`othername_mandatory`**:
  - *Old*: "Other Name :  *"
  - *New*: "Other Person Name :  *"

#### Codebase Changes:
- Added 21 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.checklist`: 20 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

### Version 9.59 (Date: 2026-08-08, Version Code: 253)

#### New UI Strings / Features:
- **`blo_form6_upload`**: "Offline Form 6 Upload"
- **`blo_upload_form6_page1`**: "Please Upload Page 1 of Form *"
- **`blo_upload_form6_page2`**: "Please Upload Page 2 of Form *"
- **`blo_uploaded_form6_page1`**: "Uploaded Page 1 of Form"
- **`blo_uploaded_form6_page2`**: "Uploaded Page 2 of Form"
- **`check_form6_upload`**: "I confirm that the form is duly signed by the Applicant."

#### Codebase Changes:
- Added 107 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity.newsir.activity.anomaly`: 64 classes
    - `in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration`: 41 classes
    - `in.gov.eci.bloapp.api`: 1 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

### Version 9.60 (Date: 2026-08-11, Version Code: 254)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.sir.formdatanew.AddNotionalListActivity`

#### New UI Strings / Features:
- **`home_AddNotional`**: "Add Notional House No"
- **`houseNo`**: "House No. :"
- **`notional_houseNo`**: "Notional H.No. :"
- **`updateAddNotinal`**: "Update Notional H.No"

#### Codebase Changes:
- Added 86 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.checklist.form6`: 66 classes
    - `in.gov.eci.bloapp.views.activity.sir.formdatanew`: 7 classes
    - `in.gov.eci.bloapp.adapter`: 6 classes
    - `in.gov.eci.bloapp.databinding`: 3 classes
    - `in.gov.eci.bloapp.views.activity.newsir.model`: 2 classes
    - `in.gov.eci.bloapp.views.activity.newsir.callback`: 1 classes
    - `in.gov.eci.bloapp.views.fragments.home`: 1 classes

### Version 9.61 (Date: 2026-08-12, Version Code: 255)

#### Codebase Changes:
- Added 1 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.home`: 1 classes

### Version 9.62 (Date: 2026-08-14, Version Code: 256)

#### New UI Strings / Features:
- **`blo_form7_upload`**: "Offline Form 7 Upload"
- **`check_form6_add_doc`**: "I confirm that Applicant has not provided any valid Additional Document"
- **`no_dse`**: "No DSE Found"
- **`no_dse_form`**: "DSE Found - Fill Form7"
- **`view_dse_details`**: "View DSE Details"

#### Codebase Changes:
- Added 208 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.checklist`: 76 classes
    - `in.gov.eci.bloapp.views.fragments.voterforms.migration`: 50 classes
    - `in.gov.eci.bloapp.views.fragments.checklist.form6`: 47 classes
    - `in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection`: 32 classes
    - `in.gov.eci.bloapp.databinding`: 3 classes

### Version 9.63 (Date: 2026-08-16, Version Code: 257)

#### New UI Strings / Features:
- **`blo_form8_upload`**: "Offline Form 8 Upload"

#### Codebase Changes:
- Added 64 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.checklist`: 63 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

### Version 9.64 (Date: 2026-08-17, Version Code: 258)

#### New UI Strings / Features:
- **`blo_form6a_upload`**: "Offline Form 6A Upload"

#### Codebase Changes:
- Added 85 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments.voterforms.overseas`: 47 classes
    - `in.gov.eci.bloapp.views.fragments.checklist`: 37 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

### Version 9.65 (Date: 2026-08-22, Version Code: 259)

#### New Activities Added:
- `in.gov.eci.bloapp.views.activity.DseForm7Activity`

#### New UI Strings / Features:
- **`blo_Age_mandatory`**: "Age *"
- **`blo_declaration_dse`**: "I submit application for objection for proposed inclusion/deletion of name in existing electoral roll."
- **`blo_objection_details_header_new`**: "(2) The details of the person in respect of whom objection has been raised, are as\nbelow"

#### Modified Strings:
- **`no_dse_form`**:
  - *Old*: "DSE Found - Fill Form7"
  - *New*: "DSE Found - Generate Form7"

#### Codebase Changes:
- Added 28 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.activity`: 19 classes
    - `in.gov.eci.bloapp.views.fragments.checklist`: 8 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

### Version 9.66 (Date: 2026-08-25, Version Code: 260)

### Version 9.67 (Date: 2026-08-27, Version Code: 261)

### Version 9.68 (Date: 2026-09-06, Version Code: 262)

#### Codebase Changes:
- Added 14 new classes.
  - Package breakdown of added classes:
    - `in.gov.eci.bloapp.views.fragments`: 6 classes
    - `in.gov.eci.bloapp.utils`: 5 classes
    - `in.gov.eci.bloapp.views.fragments.login`: 2 classes
    - `in.gov.eci.bloapp.databinding`: 1 classes

