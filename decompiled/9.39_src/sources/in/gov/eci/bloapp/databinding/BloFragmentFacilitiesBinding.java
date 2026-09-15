package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentFacilitiesBinding implements ViewBinding {
    public final ImageButton addphoto;
    public final LinearLayout addphotolayout;
    public final TextView addtext;
    public final RecyclerView allFacilitiesRv;
    public final AppCompatButton button;
    public final LinearLayout captureGPSCOOrdinatesLayout;
    public final CardView cardView;
    public final CardView cardView2;
    public final CardView cardView3;
    public final RadioButton checkBox;
    public final RadioButton checkBox5;
    public final RadioButton checkBox6;
    public final RadioButton checkBox7;
    public final LinearLayout checkboxes;
    public final View divider1;
    public final View divider2;
    public final View divider3;
    public final SearchView editTextFacilitySearch;
    public final ImageButton editbtn;
    public final NoDefaultSpinner facilityAmfEmfDropdown;
    public final LinearLayout facilityAmfEmfDropdownLayout;
    public final ImageView facilitySearchButton;
    public final RelativeLayout femaleCountLayout;
    public final ImageView femaleImage;
    public final TextView gpsadd;
    public final ImageView homeBtnIv;
    public final ImageView homeBtnIv1;
    public final ImageView image;
    public final ImageView imageButton;
    public final ImageView imageButton1;
    public final TextView imageDel;
    public final TextView imageName;
    public final RecyclerView images;
    public final ConstraintLayout imglayout;
    public final ImageView leftButton;
    public final LinearLayout linear;
    public final LinearLayout linearLayoutForBtn;
    public final LinearLayout linearLayoutForBtns;
    public final View mainDivider;
    public final NestedScrollView mainScrollView;
    public final RelativeLayout maleCountLayout;
    public final ImageView maleImage;
    public final ImageView personImage;
    public final RelativeLayout pollingStationFacilitiesLayout;
    public final RelativeLayout pollingStationFacilitiesSearchLayout;
    public final ConstraintLayout pollingStationNameLayout;
    public final LinearLayout pollingStationPhotosLayout;
    public final TextView pollingstationadd1;
    public final TextView pollingstationadd2;
    public final ConstraintLayout preview;
    public final RelativeLayout pwdCountLayout;
    public final ImageView pwdImage;
    public final RadioGroup radiohead;
    public final ImageView rightButton;
    private final SwipeRefreshLayout rootView;
    public final ImageView searchBackButton;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final TextView textVieew;
    public final TextView textViewCaptureGPSCOOrdinatesHeader;
    public final TextView textViewFemale;
    public final TextView textViewFemaleCount;
    public final TextView textViewMale;
    public final TextView textViewMaleCount;
    public final TextView textViewPollingStationFacilitiesHeader;
    public final TextView textViewPollingStationNameHeader;
    public final TextView textViewPollingStationPhotosHeader;
    public final TextView textViewPwd;
    public final TextView textViewPwdCount;
    public final TextView textViewThirdGender;
    public final TextView textViewThirdGenderCount;
    public final TextView textViewTotalElectorHeader;
    public final RelativeLayout thirdGenderCountLayout;
    public final ImageView thirdGenderImage;
    public final TextView title;
    public final TextView title1;
    public final ConstraintLayout titleBar;
    public final ConstraintLayout titleBarprev;
    public final HorizontalScrollView totalElectorHorizontalscrollview;
    public final RelativeLayout totalElectorLayout;
    public final AppCompatButton updateButton;

    private BloFragmentFacilitiesBinding(SwipeRefreshLayout rootView, ImageButton addphoto, LinearLayout addphotolayout, TextView addtext, RecyclerView allFacilitiesRv, AppCompatButton button, LinearLayout captureGPSCOOrdinatesLayout, CardView cardView, CardView cardView2, CardView cardView3, RadioButton checkBox, RadioButton checkBox5, RadioButton checkBox6, RadioButton checkBox7, LinearLayout checkboxes, View divider1, View divider2, View divider3, SearchView editTextFacilitySearch, ImageButton editbtn, NoDefaultSpinner facilityAmfEmfDropdown, LinearLayout facilityAmfEmfDropdownLayout, ImageView facilitySearchButton, RelativeLayout femaleCountLayout, ImageView femaleImage, TextView gpsadd, ImageView homeBtnIv, ImageView homeBtnIv1, ImageView image, ImageView imageButton, ImageView imageButton1, TextView imageDel, TextView imageName, RecyclerView images, ConstraintLayout imglayout, ImageView leftButton, LinearLayout linear, LinearLayout linearLayoutForBtn, LinearLayout linearLayoutForBtns, View mainDivider, NestedScrollView mainScrollView, RelativeLayout maleCountLayout, ImageView maleImage, ImageView personImage, RelativeLayout pollingStationFacilitiesLayout, RelativeLayout pollingStationFacilitiesSearchLayout, ConstraintLayout pollingStationNameLayout, LinearLayout pollingStationPhotosLayout, TextView pollingstationadd1, TextView pollingstationadd2, ConstraintLayout preview, RelativeLayout pwdCountLayout, ImageView pwdImage, RadioGroup radiohead, ImageView rightButton, ImageView searchBackButton, SwipeRefreshLayout swipeRefreshLayout, TextView textVieew, TextView textViewCaptureGPSCOOrdinatesHeader, TextView textViewFemale, TextView textViewFemaleCount, TextView textViewMale, TextView textViewMaleCount, TextView textViewPollingStationFacilitiesHeader, TextView textViewPollingStationNameHeader, TextView textViewPollingStationPhotosHeader, TextView textViewPwd, TextView textViewPwdCount, TextView textViewThirdGender, TextView textViewThirdGenderCount, TextView textViewTotalElectorHeader, RelativeLayout thirdGenderCountLayout, ImageView thirdGenderImage, TextView title, TextView title1, ConstraintLayout titleBar, ConstraintLayout titleBarprev, HorizontalScrollView totalElectorHorizontalscrollview, RelativeLayout totalElectorLayout, AppCompatButton updateButton) {
        this.rootView = rootView;
        this.addphoto = addphoto;
        this.addphotolayout = addphotolayout;
        this.addtext = addtext;
        this.allFacilitiesRv = allFacilitiesRv;
        this.button = button;
        this.captureGPSCOOrdinatesLayout = captureGPSCOOrdinatesLayout;
        this.cardView = cardView;
        this.cardView2 = cardView2;
        this.cardView3 = cardView3;
        this.checkBox = checkBox;
        this.checkBox5 = checkBox5;
        this.checkBox6 = checkBox6;
        this.checkBox7 = checkBox7;
        this.checkboxes = checkboxes;
        this.divider1 = divider1;
        this.divider2 = divider2;
        this.divider3 = divider3;
        this.editTextFacilitySearch = editTextFacilitySearch;
        this.editbtn = editbtn;
        this.facilityAmfEmfDropdown = facilityAmfEmfDropdown;
        this.facilityAmfEmfDropdownLayout = facilityAmfEmfDropdownLayout;
        this.facilitySearchButton = facilitySearchButton;
        this.femaleCountLayout = femaleCountLayout;
        this.femaleImage = femaleImage;
        this.gpsadd = gpsadd;
        this.homeBtnIv = homeBtnIv;
        this.homeBtnIv1 = homeBtnIv1;
        this.image = image;
        this.imageButton = imageButton;
        this.imageButton1 = imageButton1;
        this.imageDel = imageDel;
        this.imageName = imageName;
        this.images = images;
        this.imglayout = imglayout;
        this.leftButton = leftButton;
        this.linear = linear;
        this.linearLayoutForBtn = linearLayoutForBtn;
        this.linearLayoutForBtns = linearLayoutForBtns;
        this.mainDivider = mainDivider;
        this.mainScrollView = mainScrollView;
        this.maleCountLayout = maleCountLayout;
        this.maleImage = maleImage;
        this.personImage = personImage;
        this.pollingStationFacilitiesLayout = pollingStationFacilitiesLayout;
        this.pollingStationFacilitiesSearchLayout = pollingStationFacilitiesSearchLayout;
        this.pollingStationNameLayout = pollingStationNameLayout;
        this.pollingStationPhotosLayout = pollingStationPhotosLayout;
        this.pollingstationadd1 = pollingstationadd1;
        this.pollingstationadd2 = pollingstationadd2;
        this.preview = preview;
        this.pwdCountLayout = pwdCountLayout;
        this.pwdImage = pwdImage;
        this.radiohead = radiohead;
        this.rightButton = rightButton;
        this.searchBackButton = searchBackButton;
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.textVieew = textVieew;
        this.textViewCaptureGPSCOOrdinatesHeader = textViewCaptureGPSCOOrdinatesHeader;
        this.textViewFemale = textViewFemale;
        this.textViewFemaleCount = textViewFemaleCount;
        this.textViewMale = textViewMale;
        this.textViewMaleCount = textViewMaleCount;
        this.textViewPollingStationFacilitiesHeader = textViewPollingStationFacilitiesHeader;
        this.textViewPollingStationNameHeader = textViewPollingStationNameHeader;
        this.textViewPollingStationPhotosHeader = textViewPollingStationPhotosHeader;
        this.textViewPwd = textViewPwd;
        this.textViewPwdCount = textViewPwdCount;
        this.textViewThirdGender = textViewThirdGender;
        this.textViewThirdGenderCount = textViewThirdGenderCount;
        this.textViewTotalElectorHeader = textViewTotalElectorHeader;
        this.thirdGenderCountLayout = thirdGenderCountLayout;
        this.thirdGenderImage = thirdGenderImage;
        this.title = title;
        this.title1 = title1;
        this.titleBar = titleBar;
        this.titleBarprev = titleBarprev;
        this.totalElectorHorizontalscrollview = totalElectorHorizontalscrollview;
        this.totalElectorLayout = totalElectorLayout;
        this.updateButton = updateButton;
    }

    public SwipeRefreshLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentFacilitiesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentFacilitiesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_facilities, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentFacilitiesBinding bind(View rootView) {
        int i = R.id.addphoto;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.addphoto);
        if (imageButton != null) {
            i = R.id.addphotolayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.addphotolayout);
            if (linearLayout != null) {
                i = R.id.addtext;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.addtext);
                if (textView != null) {
                    i = R.id.all_facilities_rv;
                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.all_facilities_rv);
                    if (recyclerViewFindChildViewById != null) {
                        i = R.id.button;
                        AppCompatButton appCompatButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.button);
                        if (appCompatButtonFindChildViewById != null) {
                            i = R.id.capture_GPS_COOrdinates_layout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.capture_GPS_COOrdinates_layout);
                            if (linearLayout2 != null) {
                                i = R.id.cardView;
                                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                                if (cardViewFindChildViewById != null) {
                                    i = R.id.cardView2;
                                    CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cardView2);
                                    if (cardViewFindChildViewById2 != null) {
                                        i = R.id.cardView3;
                                        CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.cardView3);
                                        if (cardViewFindChildViewById3 != null) {
                                            i = R.id.checkBox;
                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.checkBox);
                                            if (radioButton != null) {
                                                i = R.id.checkBox5;
                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.checkBox5);
                                                if (radioButton2 != null) {
                                                    i = R.id.checkBox6;
                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.checkBox6);
                                                    if (radioButton3 != null) {
                                                        i = R.id.checkBox7;
                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.checkBox7);
                                                        if (radioButton4 != null) {
                                                            i = R.id.checkboxes;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.checkboxes);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.divider1;
                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider1);
                                                                if (viewFindChildViewById != null) {
                                                                    i = R.id.divider2;
                                                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.divider2);
                                                                    if (viewFindChildViewById2 != null) {
                                                                        i = R.id.divider3;
                                                                        View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.divider3);
                                                                        if (viewFindChildViewById3 != null) {
                                                                            i = R.id.editText_facility_search;
                                                                            SearchView searchView = (SearchView) ViewBindings.findChildViewById(rootView, R.id.editText_facility_search);
                                                                            if (searchView != null) {
                                                                                i = R.id.editbtn;
                                                                                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.editbtn);
                                                                                if (imageButton2 != null) {
                                                                                    i = R.id.facility_amf_emf_Dropdown;
                                                                                    NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.facility_amf_emf_Dropdown);
                                                                                    if (noDefaultSpinner != null) {
                                                                                        i = R.id.facility_amf_emf_Dropdown_Layout;
                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.facility_amf_emf_Dropdown_Layout);
                                                                                        if (linearLayout4 != null) {
                                                                                            i = R.id.facility_search_Button;
                                                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.facility_search_Button);
                                                                                            if (imageView != null) {
                                                                                                i = R.id.female_count_layout;
                                                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.female_count_layout);
                                                                                                if (relativeLayout != null) {
                                                                                                    i = R.id.female_image;
                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.female_image);
                                                                                                    if (imageView2 != null) {
                                                                                                        i = R.id.gpsadd;
                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gpsadd);
                                                                                                        if (textView2 != null) {
                                                                                                            i = R.id.home_btn_iv;
                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                                                                            if (imageView3 != null) {
                                                                                                                i = R.id.home_btn_iv1;
                                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv1);
                                                                                                                if (imageView4 != null) {
                                                                                                                    i = 2131364126;
                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, 2131364126);
                                                                                                                    if (imageView5 != null) {
                                                                                                                        i = R.id.imageButton;
                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageButton);
                                                                                                                        if (imageView6 != null) {
                                                                                                                            i = R.id.imageButton1;
                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageButton1);
                                                                                                                            if (imageView7 != null) {
                                                                                                                                i = R.id.image_del;
                                                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.image_del);
                                                                                                                                if (textView3 != null) {
                                                                                                                                    i = R.id.image_name;
                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.image_name);
                                                                                                                                    if (textView4 != null) {
                                                                                                                                        i = R.id.images;
                                                                                                                                        RecyclerView recyclerViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.images);
                                                                                                                                        if (recyclerViewFindChildViewById2 != null) {
                                                                                                                                            i = R.id.imglayout;
                                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.imglayout);
                                                                                                                                            if (constraintLayoutFindChildViewById != null) {
                                                                                                                                                i = R.id.left_button;
                                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.left_button);
                                                                                                                                                if (imageView8 != null) {
                                                                                                                                                    i = 2131364341;
                                                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364341);
                                                                                                                                                    if (linearLayout5 != null) {
                                                                                                                                                        i = R.id.linear_layout_for_btn;
                                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_layout_for_btn);
                                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                                            i = R.id.linear_layout_for_btns;
                                                                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_layout_for_btns);
                                                                                                                                                            if (linearLayout7 != null) {
                                                                                                                                                                i = R.id.main_divider;
                                                                                                                                                                View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.main_divider);
                                                                                                                                                                if (viewFindChildViewById4 != null) {
                                                                                                                                                                    i = R.id.mainScrollView;
                                                                                                                                                                    NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.mainScrollView);
                                                                                                                                                                    if (nestedScrollViewFindChildViewById != null) {
                                                                                                                                                                        i = R.id.male_count_layout;
                                                                                                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.male_count_layout);
                                                                                                                                                                        if (relativeLayout2 != null) {
                                                                                                                                                                            i = R.id.male_image;
                                                                                                                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.male_image);
                                                                                                                                                                            if (imageView9 != null) {
                                                                                                                                                                                i = R.id.person_image;
                                                                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
                                                                                                                                                                                if (imageView10 != null) {
                                                                                                                                                                                    i = R.id.polling_station_facilities_layout;
                                                                                                                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.polling_station_facilities_layout);
                                                                                                                                                                                    if (relativeLayout3 != null) {
                                                                                                                                                                                        i = R.id.polling_station_facilities_search_layout;
                                                                                                                                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.polling_station_facilities_search_layout);
                                                                                                                                                                                        if (relativeLayout4 != null) {
                                                                                                                                                                                            i = R.id.polling_Station_Name_layout;
                                                                                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.polling_Station_Name_layout);
                                                                                                                                                                                            if (constraintLayoutFindChildViewById2 != null) {
                                                                                                                                                                                                i = R.id.polling_Station_Photos_layout;
                                                                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.polling_Station_Photos_layout);
                                                                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                                                                    i = R.id.pollingstationadd1;
                                                                                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pollingstationadd1);
                                                                                                                                                                                                    if (textView5 != null) {
                                                                                                                                                                                                        i = R.id.pollingstationadd2;
                                                                                                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pollingstationadd2);
                                                                                                                                                                                                        if (textView6 != null) {
                                                                                                                                                                                                            i = R.id.preview;
                                                                                                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.preview);
                                                                                                                                                                                                            if (constraintLayoutFindChildViewById3 != null) {
                                                                                                                                                                                                                i = R.id.pwd_count_layout;
                                                                                                                                                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pwd_count_layout);
                                                                                                                                                                                                                if (relativeLayout5 != null) {
                                                                                                                                                                                                                    i = R.id.pwd_image;
                                                                                                                                                                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pwd_image);
                                                                                                                                                                                                                    if (imageView11 != null) {
                                                                                                                                                                                                                        i = R.id.radiohead;
                                                                                                                                                                                                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.radiohead);
                                                                                                                                                                                                                        if (radioGroup != null) {
                                                                                                                                                                                                                            i = R.id.right_button;
                                                                                                                                                                                                                            ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.right_button);
                                                                                                                                                                                                                            if (imageView12 != null) {
                                                                                                                                                                                                                                i = R.id.search_Back_Button;
                                                                                                                                                                                                                                ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.search_Back_Button);
                                                                                                                                                                                                                                if (imageView13 != null) {
                                                                                                                                                                                                                                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) rootView;
                                                                                                                                                                                                                                    i = R.id.textVieew;
                                                                                                                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textVieew);
                                                                                                                                                                                                                                    if (textView7 != null) {
                                                                                                                                                                                                                                        i = R.id.textView_capture_GPS_COOrdinates_header;
                                                                                                                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_capture_GPS_COOrdinates_header);
                                                                                                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                                                                                                            i = R.id.textView_female;
                                                                                                                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_female);
                                                                                                                                                                                                                                            if (textView9 != null) {
                                                                                                                                                                                                                                                i = R.id.textView_female_count;
                                                                                                                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_female_count);
                                                                                                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                                                                                                    i = R.id.textView_male;
                                                                                                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_male);
                                                                                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                                                                                        i = R.id.textView_male_count;
                                                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_male_count);
                                                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                                                            i = R.id.textView_polling_station_facilities_header;
                                                                                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_polling_station_facilities_header);
                                                                                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                                                                                i = R.id.textView_polling_Station_Name_header;
                                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_polling_Station_Name_header);
                                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                                    i = R.id.textView_polling_Station_Photos_header;
                                                                                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_polling_Station_Photos_header);
                                                                                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                                                                                        i = R.id.textView_pwd;
                                                                                                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_pwd);
                                                                                                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                                                                                                            i = R.id.textView_pwd_count;
                                                                                                                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_pwd_count);
                                                                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                                                                i = R.id.textView_third_gender;
                                                                                                                                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_third_gender);
                                                                                                                                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.textView_third_gender_count;
                                                                                                                                                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_third_gender_count);
                                                                                                                                                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.textView_total_Elector_header;
                                                                                                                                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_total_Elector_header);
                                                                                                                                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.third_gender_count_layout;
                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.third_gender_count_layout);
                                                                                                                                                                                                                                                                                            if (relativeLayout6 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.third_gender_image;
                                                                                                                                                                                                                                                                                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.third_gender_image);
                                                                                                                                                                                                                                                                                                if (imageView14 != null) {
                                                                                                                                                                                                                                                                                                    i = 2131366197;
                                                                                                                                                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, 2131366197);
                                                                                                                                                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.title1;
                                                                                                                                                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title1);
                                                                                                                                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.titleBar;
                                                                                                                                                                                                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                                                                                                                                                                                                                                                                                                            if (constraintLayoutFindChildViewById4 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.titleBarprev;
                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayoutFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.titleBarprev);
                                                                                                                                                                                                                                                                                                                if (constraintLayoutFindChildViewById5 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.total_Elector_horizontalscrollview;
                                                                                                                                                                                                                                                                                                                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(rootView, R.id.total_Elector_horizontalscrollview);
                                                                                                                                                                                                                                                                                                                    if (horizontalScrollView != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.total_Elector_layout;
                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.total_Elector_layout);
                                                                                                                                                                                                                                                                                                                        if (relativeLayout7 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.updateButton;
                                                                                                                                                                                                                                                                                                                            AppCompatButton appCompatButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.updateButton);
                                                                                                                                                                                                                                                                                                                            if (appCompatButtonFindChildViewById2 != null) {
                                                                                                                                                                                                                                                                                                                                return new BloFragmentFacilitiesBinding(swipeRefreshLayout, imageButton, linearLayout, textView, recyclerViewFindChildViewById, appCompatButtonFindChildViewById, linearLayout2, cardViewFindChildViewById, cardViewFindChildViewById2, cardViewFindChildViewById3, radioButton, radioButton2, radioButton3, radioButton4, linearLayout3, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, searchView, imageButton2, noDefaultSpinner, linearLayout4, imageView, relativeLayout, imageView2, textView2, imageView3, imageView4, imageView5, imageView6, imageView7, textView3, textView4, recyclerViewFindChildViewById2, constraintLayoutFindChildViewById, imageView8, linearLayout5, linearLayout6, linearLayout7, viewFindChildViewById4, nestedScrollViewFindChildViewById, relativeLayout2, imageView9, imageView10, relativeLayout3, relativeLayout4, constraintLayoutFindChildViewById2, linearLayout8, textView5, textView6, constraintLayoutFindChildViewById3, relativeLayout5, imageView11, radioGroup, imageView12, imageView13, swipeRefreshLayout, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, relativeLayout6, imageView14, textView21, textView22, constraintLayoutFindChildViewById4, constraintLayoutFindChildViewById5, horizontalScrollView, relativeLayout7, appCompatButtonFindChildViewById2);
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
