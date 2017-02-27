package com.codes.toolbar;

/**
 * Created by Posti on 29/07/2016.
 */
public class RecyclerViewData {
    private String title;
    private String subtitle;

    public RecyclerViewData(String title, String subtitle) {
        this.subtitle = subtitle;
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
