
package com.divyanshgoenka.octioncodingchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Auction implements Serializable {

    @SerializedName("auctionId")
    private String mAuctionId;
    @SerializedName("auctionsHeldCount")
    private String mAuctionsHeldCount;
    @SerializedName("bidCount")
    private String mBidCount;
    @SerializedName("bidderCount")
    private String mBidderCount;
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("end_time")
    private String mEndTime;
    @SerializedName("end_time_unix")
    private Long mEndTimeUnix;
    @SerializedName("isHidden")
    private String mIsHidden;
    @SerializedName("minimumPrice")
    private String mMinimumPrice;
    @SerializedName("name")
    private Object mName;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("productCurrency")
    private String mProductCurrency;
    @SerializedName("product_id")
    private String mProductId;
    @SerializedName("productPrice")
    private String mProductPrice;
    @SerializedName("profileImage")
    private Object mProfileImage;
    @SerializedName("start_time")
    private String mStartTime;
    @SerializedName("start_time_unix")
    private String mStartTimeUnix;
    @SerializedName("startingPrice")
    private String mStartingPrice;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;
    @SerializedName("unique_id")
    private String mUniqueId;
    @SerializedName("userId")
    private Object mUserId;
    @SerializedName("user_name")
    private Object mUserName;
    @SerializedName("winner_user_id")
    private Object mWinnerUserId;

    public String getAuctionId() {
        return mAuctionId;
    }

    public void setAuctionId(String auctionId) {
        mAuctionId = auctionId;
    }

    public String getAuctionsHeldCount() {
        return mAuctionsHeldCount;
    }

    public void setAuctionsHeldCount(String auctionsHeldCount) {
        mAuctionsHeldCount = auctionsHeldCount;
    }

    public String getBidCount() {
        return mBidCount;
    }

    public void setBidCount(String bidCount) {
        mBidCount = bidCount;
    }

    public String getBidderCount() {
        return mBidderCount;
    }

    public void setBidderCount(String bidderCount) {
        mBidderCount = bidderCount;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        mEndTime = endTime;
    }

    public Long getEndTimeUnix() {
        return mEndTimeUnix;
    }

    public void setEndTimeUnix(Long endTimeUnix) {
        mEndTimeUnix = endTimeUnix;
    }

    public String getIsHidden() {
        return mIsHidden;
    }

    public void setIsHidden(String isHidden) {
        mIsHidden = isHidden;
    }

    public String getMinimumPrice() {
        return mMinimumPrice;
    }

    public void setMinimumPrice(String minimumPrice) {
        mMinimumPrice = minimumPrice;
    }

    public Object getName() {
        return mName;
    }

    public void setName(Object name) {
        mName = name;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getProductCurrency() {
        return mProductCurrency;
    }

    public void setProductCurrency(String productCurrency) {
        mProductCurrency = productCurrency;
    }

    public String getProductId() {
        return mProductId;
    }

    public void setProductId(String productId) {
        mProductId = productId;
    }

    public String getProductPrice() {
        return mProductPrice;
    }

    public void setProductPrice(String productPrice) {
        mProductPrice = productPrice;
    }

    public Object getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(Object profileImage) {
        mProfileImage = profileImage;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public String getStartTimeUnix() {
        return mStartTimeUnix;
    }

    public void setStartTimeUnix(String startTimeUnix) {
        mStartTimeUnix = startTimeUnix;
    }

    public String getStartingPrice() {
        return mStartingPrice;
    }

    public void setStartingPrice(String startingPrice) {
        mStartingPrice = startingPrice;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUniqueId() {
        return mUniqueId;
    }

    public void setUniqueId(String uniqueId) {
        mUniqueId = uniqueId;
    }

    public Object getUserId() {
        return mUserId;
    }

    public void setUserId(Object userId) {
        mUserId = userId;
    }

    public Object getUserName() {
        return mUserName;
    }

    public void setUserName(Object userName) {
        mUserName = userName;
    }

    public Object getWinnerUserId() {
        return mWinnerUserId;
    }

    public void setWinnerUserId(Object winnerUserId) {
        mWinnerUserId = winnerUserId;
    }

}
