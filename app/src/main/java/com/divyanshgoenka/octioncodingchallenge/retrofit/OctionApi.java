package com.divyanshgoenka.octioncodingchallenge.retrofit;


import com.divyanshgoenka.octioncodingchallenge.model.OctionListing;
import com.divyanshgoenka.octioncodingchallenge.util.Constants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by divyanshgoenka on 03/08/17.
 */

public interface OctionApi {

    @GET("/api/v2/auctions?count="+ Constants.ScrollLogic.NO_ITEMS_PER_PAGE)
    Observable<List<OctionListing>>  getUserRepos(@Query("page") int page);
}
