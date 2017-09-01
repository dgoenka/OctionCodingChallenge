package com.divyanshgoenka.octioncodingchallenge.view;

import com.divyanshgoenka.octioncodingchallenge.model.OctionListing;


import java.util.List;

/**
 * Created by divyanshgoenka on 06/08/17.
 */

public interface UserListView {
    void addToList(List<OctionListing> repos);

    void onError(Throwable e);

    boolean canShowData();

    void clearList();

    void setLoadingState(Boolean isLoading, Boolean success);
}
