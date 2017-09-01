
package com.divyanshgoenka.octioncodingchallenge.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OctionListing implements Serializable {

    @SerializedName("auction")
    private Auction mAuction;
    @SerializedName("media")
    private List<Medium> mMedia;

    public Auction getAuction() {
        return mAuction;
    }

    public void setAuction(Auction auction) {
        mAuction = auction;
    }

    public List<Medium> getMedia() {
        return mMedia;
    }

    public void setMedia(List<Medium> media) {
        mMedia = media;
    }

}
