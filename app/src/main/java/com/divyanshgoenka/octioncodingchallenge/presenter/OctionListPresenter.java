package com.divyanshgoenka.octioncodingchallenge.presenter;

import android.util.Log;

import com.divyanshgoenka.octioncodingchallenge.model.OctionListing;
import com.divyanshgoenka.octioncodingchallenge.retrofit.OctionApi;
import com.divyanshgoenka.octioncodingchallenge.retrofit.ServiceGenerator;
import com.divyanshgoenka.octioncodingchallenge.util.Constants;
import com.divyanshgoenka.octioncodingchallenge.view.UserListView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by divyanshgoenka on 06/08/17.
 */

public class OctionListPresenter {
    private static final String TAG = "OctionListPresenter";
    private UserListView mainActivtyView;


    private OctionApi octionApi = ServiceGenerator.createService(Constants.Api.API_URL, OctionApi.class);

    private boolean isLoading;

    private int numberOfPages = Constants.ScrollLogic.PAGE_START_ONE;
    private int currentPage = Constants.ScrollLogic.PAGE_START_ZERO;


    private Observer<List<OctionListing>> octionsObserverable = new Observer<List<OctionListing>>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<OctionListing> repos) {
           if(mainActivtyView!=null) {
               if (currentPage == 1)
                   mainActivtyView.clearList();
                   mainActivtyView.addToList(repos);
           }

           setLoading(false, true);
        }

        @Override
        public void onError(Throwable e) {
            mainActivtyView.onError(e);
            setLoading(false, false);

        }

        @Override
        public void onComplete() {

        }
    };

    public void register(UserListView userListView) {
        this.mainActivtyView = userListView;
    }

    public void unregister() {
        this.mainActivtyView = null;
    }

    public void onResume() {
        Log.e(TAG,"in OctionListPresenter.onResume");
        if (!mainActivtyView.canShowData()) {
            startFetching();
            Log.e(TAG,"in OctionListPresenter.onResume, starting fetch");
        }else{
            Log.e(TAG,"in OctionListPresenter.onResume, used fetched data");
        }
    }


    private void startFetching() {
        currentPage = 0;
        continueFetching();
    }

    private void continueFetching() {
        setLoading(true, null);
        fetchRepos(++currentPage);
    }

    private void fetchRepos(int pageNumber) {
        Log.e(TAG, "in fetchRepos, fetching page number: " + pageNumber + " numberOfPages is " + numberOfPages);
        octionApi.getUserRepos(pageNumber).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(octionsObserverable);
    }




    public boolean isLoading() {
        return isLoading;
    }

    public synchronized void setLoading(Boolean isLoading, Boolean success) {
        this.isLoading = isLoading;
        mainActivtyView.setLoadingState(isLoading, success);

    }

    public void onCreate() {
    }

    public void onLoadMore() {
        continueFetching();
    }


    public boolean hasLoadedAllItems() {
        return currentPage >= numberOfPages;
    }

    public void onRefresh() {
        startFetching();
    }
}
