package in.gov.eci.bloapp.model.app_model;

import android.text.SpannableStringBuilder;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ExpandModel {
    public SpannableStringBuilder builder;
    public Boolean isExpandable;
    public String item;
    public String title;

    public ExpandModel(String title, String item, SpannableStringBuilder builder, Boolean isExpandable) {
        this.title = title;
        this.item = item;
        this.builder = builder;
        this.isExpandable = isExpandable;
    }

    public String getTitle() {
        return this.title;
    }

    public String getItem() {
        return this.item;
    }

    public Boolean getIsExpandable() {
        return this.isExpandable;
    }

    public SpannableStringBuilder getBuilder() {
        return this.builder;
    }

    public void setIsExpandable(Boolean isExpandable) {
        this.isExpandable = isExpandable;
    }
}
