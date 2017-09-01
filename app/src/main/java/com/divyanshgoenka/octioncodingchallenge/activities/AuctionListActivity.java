package com.divyanshgoenka.octioncodingchallenge.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.divyanshgoenka.octioncodingchallenge.R;
import com.divyanshgoenka.octioncodingchallenge.adapter.OctionListAdapter;
import com.divyanshgoenka.octioncodingchallenge.android.util.BundleUtils;
import com.divyanshgoenka.octioncodingchallenge.android.util.FormatUtils;
import com.divyanshgoenka.octioncodingchallenge.model.OctionListing;
import com.divyanshgoenka.octioncodingchallenge.presenter.OctionListPresenter;
import com.divyanshgoenka.octioncodingchallenge.util.Constants;
import com.divyanshgoenka.octioncodingchallenge.view.UserListView;
import com.mugen.Mugen;
import com.mugen.MugenCallbacks;
import com.mugen.attachers.BaseAttacher;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by divyanshgoenka on 05/08/17.
 */

public class AuctionListActivity extends AppCompatActivity implements MugenCallbacks, UserListView, SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = "UserRepoListActivity";
    OctionListPresenter octionListPresenter = new OctionListPresenter();

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    BaseAttacher attacher;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.no_octions_view)
    View noOctionsView;

    LoadToast loadToast;



    @Override
    public void onRefresh() {
        octionListPresenter.onRefresh();
    }


    View titleView;

    final ArrayList<OctionListing> repos = new ArrayList<>();
    private OctionListAdapter octionListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.octions_list_activity);
        ButterKnife.bind(this);
        setupViews(savedInstanceState);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(Constants.Keys.ITEM_LIST, repos);
    }

    private void setupViews(Bundle savedInstanceState) {
        readFromBundle(savedInstanceState == null ? getIntent().getExtras() : savedInstanceState);
        setupRecyclerView();
        setupActionBar();
    }

    public void readFromBundle(Bundle bundle){
        repos.addAll((ArrayList<OctionListing>)BundleUtils.getSerializable(bundle, Constants.Keys.ITEM_LIST,new ArrayList<>()));
        octionListPresenter.onCreate();
    }

    public void setupRecyclerView(){
        swipeRefreshLayout.setOnRefreshListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    public void setupActionBar(){
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_view_layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        register();
        octionListPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregister();
    }

    /**
     * Method to contain all observer and BroadcastReceiver registrations (called in onResume)
     */
    public void register() {
        octionListPresenter.register(this);

    }

    /**
     * Method to contain all observer and BroadcastReceiver unregistrations (called in onPause)
     */
    public void unregister() {
        octionListPresenter.unregister();

    }

    @Override
    public void onLoadMore() {
        octionListPresenter.onLoadMore();
    }

    @Override
    public boolean isLoading() {
        return octionListPresenter.isLoading();
    }

    @Override
    public boolean hasLoadedAllItems() {
        return octionListPresenter.hasLoadedAllItems();
    }


    @Override
    public void addToList(List<OctionListing> repos) {
        swipeRefreshLayout.setRefreshing(false);
        recyclerView.setVisibility(View.VISIBLE);
        noOctionsView.setVisibility(View.GONE);
        this.repos.addAll(repos);
        if (octionListAdapter == null) {
            canShowData();
        } else {
            octionListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(Throwable e) {
        new MaterialDialog.Builder(this)
                .title(FormatUtils.titleForException(e))
                .content(FormatUtils.contentForException(e))
                .positiveText(R.string.okay)
                .show();
        if(loadToast!=null)
            loadToast.error();
        swipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void clearList() {
        repos.clear();
        if(octionListAdapter !=null)
            octionListAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLoadingState(Boolean isLoading, Boolean success) {
        swipeRefreshLayout.setRefreshing(isLoading);
        if (isLoading) {
            loadToast = new LoadToast(this).setText(getString(R.string.loading)).setTranslationY(getTranslationYForToast()).show();
        } else if (loadToast != null && success != null) {
            if (success)
                loadToast.success();
            else
                loadToast.error();
            loadToast=null;
        }

    }

    @Override
    public boolean canShowData() {
        if(repos.size()<1) return false;
        if(octionListAdapter ==null)
        {
            octionListAdapter = new OctionListAdapter(this.repos);
            recyclerView.setAdapter(octionListAdapter);
            attacher = Mugen.with(recyclerView, this);
            attacher.loadMoreOffset(Constants.ScrollLogic.LOAD_MORE_OFFSET);
            attacher.start();

        }
        return true;
    }

    private int getTranslationYForToast() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int ht = displaymetrics.heightPixels;
        int spaceToLeave = getResources().getDimensionPixelSize(R.dimen.load_toast_total_margin);
        return ht-spaceToLeave;
    }

}
