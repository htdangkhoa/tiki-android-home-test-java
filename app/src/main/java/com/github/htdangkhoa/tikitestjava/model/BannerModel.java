package com.github.htdangkhoa.tikitestjava.model;

import com.google.gson.annotations.SerializedName;

public class BannerModel {

    /**
     * id : 40514
     * title : https://tiki.vn/chuong-trinh/uu-dai-moi-ngay-bam-la-mua-ngay
     * content :
     * url : https://tiki.vn/chuong-trinh/uu-dai-moi-ngay-bam-la-mua-ngay
     * image_url : https://salt.tikicdn.com/ts/banner/36/33/d7/ee3a154f02e5dff19821f5b13de2df5c.jpg
     * thumbnail_url :
     * mobile_url : https://salt.tikicdn.com/cache/w750/ts/banner/36/33/d7/d61fa48da7c086ed79747b347567a0d3.jpg
     * ratio : 3.1
     */

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("url")
    private String url;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("thumbnail_url")
    private String thumbnailUrl;
    @SerializedName("mobile_url")
    private String mobileUrl;
    @SerializedName("ratio")
    private double ratio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
