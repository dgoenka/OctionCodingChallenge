
package com.divyanshgoenka.octioncodingchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Medium implements Serializable {

    @SerializedName("display")
    private String mDisplay;
    @SerializedName("id")
    private String mId;
    @SerializedName("is_captcha")
    private String mIsCaptcha;
    @SerializedName("media")
    private String mMedia;
    @SerializedName("product_id")
    private String mProductId;

    public String getDisplay() {
        return mDisplay;
    }

    public void setDisplay(String display) {
        mDisplay = display;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getIsCaptcha() {
        return mIsCaptcha;
    }

    public void setIsCaptcha(String isCaptcha) {
        mIsCaptcha = isCaptcha;
    }

    public String getMedia() {
        return mMedia;
    }

    public void setMedia(String media) {
        mMedia = media;
    }

    public String getProductId() {
        return mProductId;
    }

    public void setProductId(String productId) {
        mProductId = productId;
    }

}
