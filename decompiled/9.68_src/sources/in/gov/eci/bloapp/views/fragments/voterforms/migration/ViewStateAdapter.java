package in.gov.eci.bloapp.views.fragments.voterforms.migration;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.views.activity.newsir.model.DeclarationFormPayload;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class ViewStateAdapter extends FragmentStateAdapter {
    String addDocImageName;
    String addDocImageSize;
    String addDocName;
    String addDocUrl;
    private final String addresscor;
    private final String addresscorreg;
    private final String addresssor;
    private final String addresssorreg;
    private final String appdate;
    String blostatecode;
    private final String coedistrict;
    private final String cordob;
    private final String corgender;
    private final String corgendereg;
    private final String corname;
    private final String cornamereg;
    private final String correlname;
    private final String correlnamereg;
    String draftcreatedon;
    String draftname;
    String epicNumber;
    DeclarationFormPayload formverificationPayload;
    private Boolean isdeclarationEnabled;
    String location;
    private final String orgaddress;
    private final String orgaddressreg;
    private final String orgdob;
    private final String orggender;
    private final String orggenderreg;
    private final String orghouseno;
    private final String orghousenoreg;
    private final String orgrelatname;
    private final String orgrelatnamereg;
    private final String orgstreet;
    private final String ornamereg;
    private final String relationType;
    private final String sectionNumber;
    private String shiftingImage;
    private final String sordistrict;
    String uploadDoc1Photoname;
    String uploadDoc1Size;
    String uploadDoc2Photoname;
    String uploadDoc2Size;
    String uploadForm6Page1Url;
    String uploadForm6Page2Url;

    public int getItemCount() {
        return 2;
    }

    public ViewStateAdapter(FragmentActivity fragmentActivity, String blostatecode, String draftname, String draftcreatedon, String location, String epicnumber, String ornamereg, String corname, String cornamereg, String correlname, String correlnamereg, String orgrelatname, String orgrelatnamereg, String orggender, String orggenderreg, String corgender, String corgendereg, String orgdob, String cordob, String orgaddress, String orgaddressreg, String addresssor, String addresssorreg, String addresscor, String addresscorreg, String appdate, String relationType, String sordistrict, String coedistrict, String orgstreet, String orghouseno, String orghousenoreg, String sectionNumber, String shiftingImage, DeclarationFormPayload formverificationPayload, Boolean isdeclarationEnabled, String addDocUrl, String addDocImageName, String addDocImageSize, String addDocName, String uploadForm6Page1Url, String uploadForm6Page2Url, String uploadDoc1Photoname, String uploadDoc1Size, String uploadDoc2Photoname, String uploadDoc2Size) {
        super(fragmentActivity);
        this.blostatecode = blostatecode;
        this.draftname = draftname;
        this.draftcreatedon = draftcreatedon;
        this.location = location;
        this.epicNumber = epicnumber;
        this.ornamereg = ornamereg;
        this.corname = corname;
        this.cornamereg = cornamereg;
        this.correlname = correlname;
        this.correlnamereg = correlnamereg;
        this.orgrelatname = orgrelatname;
        this.orgrelatnamereg = orgrelatnamereg;
        this.orggender = orggender;
        this.orggenderreg = orggenderreg;
        this.corgender = corgender;
        this.corgendereg = corgendereg;
        this.orgdob = orgdob;
        this.cordob = cordob;
        this.orgaddress = orgaddress;
        this.orgaddressreg = orgaddressreg;
        this.addresssor = addresssor;
        this.addresssorreg = addresssorreg;
        this.addresscor = addresscor;
        this.addresscorreg = addresscorreg;
        this.appdate = appdate;
        this.relationType = relationType;
        this.sordistrict = sordistrict;
        this.coedistrict = coedistrict;
        this.orgstreet = orgstreet;
        this.orghouseno = orghouseno;
        this.orghousenoreg = orghousenoreg;
        this.sectionNumber = sectionNumber;
        this.shiftingImage = shiftingImage;
        this.formverificationPayload = formverificationPayload;
        this.isdeclarationEnabled = isdeclarationEnabled;
        this.addDocUrl = addDocUrl;
        this.addDocImageName = addDocImageName;
        this.addDocImageSize = addDocImageSize;
        this.addDocName = addDocName;
        this.uploadForm6Page1Url = uploadForm6Page1Url;
        this.uploadForm6Page2Url = uploadForm6Page2Url;
        this.uploadDoc1Photoname = uploadDoc1Photoname;
        this.uploadDoc1Size = uploadDoc1Size;
        this.uploadDoc2Photoname = uploadDoc2Photoname;
        this.uploadDoc2Size = uploadDoc2Size;
    }

    public Fragment createFragment(int position) {
        if (position == 0) {
            Migration_preview_Form migration_preview_Form = new Migration_preview_Form();
            Bundle bundle = new Bundle();
            bundle.putString("draftname", this.draftname);
            bundle.putString(XmlErrorCodes.DATE, this.draftcreatedon);
            bundle.putString(Constants.LOCATION, this.location);
            bundle.putBoolean("isdeclarationEnabled", this.isdeclarationEnabled.booleanValue());
            bundle.putParcelable("declarationForm", this.formverificationPayload);
            bundle.putString("addDocUrl", this.addDocUrl);
            bundle.putString("addDocImageName", this.addDocImageName);
            bundle.putString("addDocImageSize", this.addDocImageSize);
            bundle.putString("addDocName", this.addDocName);
            bundle.putString("offlineSignedPage1Url", this.uploadForm6Page1Url);
            bundle.putString("offlineSignedPage2Url", this.uploadForm6Page2Url);
            bundle.putString("addDoc1ImageName", this.uploadDoc1Photoname);
            bundle.putString("addDoc1ImageSize", this.uploadDoc1Size);
            bundle.putString("addDoc2ImageName", this.uploadDoc2Photoname);
            bundle.putString("addDoc2ImageSize", this.uploadDoc2Size);
            migration_preview_Form.setArguments(bundle);
            return migration_preview_Form;
        }
        if (this.blostatecode.equals("S06") || this.blostatecode.equals("S12")) {
            return new PreviewFrgamentGujarat();
        }
        Migration_preview_Epic migration_preview_Epic = new Migration_preview_Epic();
        Bundle bundle2 = new Bundle();
        bundle2.putString("Epicnumber", this.epicNumber);
        bundle2.putString("originalnameregional", this.ornamereg);
        bundle2.putString("CorrectName", this.corname);
        bundle2.putString("CorrectNameRegional", this.cornamereg);
        bundle2.putString("CorrectRelativeName", this.correlname);
        bundle2.putString("CorrectRelativeNameRegional", this.correlnamereg);
        bundle2.putString("Originalrelativename", this.orgrelatname);
        bundle2.putString("Originalrelativenameregional", this.orgrelatnamereg);
        bundle2.putString("Originalgender", this.orggender);
        bundle2.putString("Originalgenderregional", this.orggenderreg);
        bundle2.putString("Correctgender", this.corgender);
        bundle2.putString("Correctgenderregional", this.corgendereg);
        bundle2.putString("Originaldob", this.orgdob);
        bundle2.putString("CorrectDOB", this.cordob);
        bundle2.putString("Originaladdress", this.orgaddress);
        bundle2.putString("Originaladdressregional", this.orgaddressreg);
        bundle2.putString("CorrectedaddressSOR", this.addresssor);
        bundle2.putString("CorrectedaddressregionalSOR", this.addresssorreg);
        bundle2.putString("CorrectedaddressCOR", this.addresscor);
        bundle2.putString("CorrectedaddressregionalCOR", this.addresscorreg);
        bundle2.putString("Applicationdate", this.appdate);
        bundle2.putString("draftname", this.draftname);
        bundle2.putString(XmlErrorCodes.DATE, this.draftcreatedon);
        bundle2.putString("RelationType", this.relationType);
        bundle2.putString("SORDistrict", this.sordistrict);
        bundle2.putString("COEDistrict", this.coedistrict);
        bundle2.putString("orgstreet", this.orgstreet);
        bundle2.putString("orghouseno", this.orghouseno);
        bundle2.putString("orghousenoreg", this.orghousenoreg);
        bundle2.putString("SectionNumber", this.sectionNumber);
        bundle2.putString("shiftingImage", this.shiftingImage);
        migration_preview_Epic.setArguments(bundle2);
        return migration_preview_Epic;
    }
}
