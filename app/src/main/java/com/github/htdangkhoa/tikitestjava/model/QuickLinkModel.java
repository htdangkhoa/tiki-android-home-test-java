package com.github.htdangkhoa.tikitestjava.model;

import com.google.gson.annotations.SerializedName;

public class QuickLinkModel {

    /**
     * title : Mã giảm giá
     * content :
     * url : https://tiki.vn/chuong-trinh/ma-giam-gia
     * authentication : false
     * web_url :
     * image_url : https://salt.tikicdn.com/ts/upload/73/50/e1/83afc85db37c472de60ebef6eceb41a7.png
     */

    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("url")
    private String url;
    @SerializedName("authentication")
    private boolean authentication;
    @SerializedName("web_url")
    private String webUrl;
    @SerializedName("image_url")
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
