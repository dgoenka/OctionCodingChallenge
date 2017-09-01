package com.divyanshgoenka.octioncodingchallenge.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.divyanshgoenka.octioncodingchallenge.R;
import com.divyanshgoenka.octioncodingchallenge.android.util.FormatUtils;
import com.divyanshgoenka.octioncodingchallenge.model.OctionListing;
import com.divyanshgoenka.octioncodingchallenge.util.Validations;

import java.net.URISyntaxException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by divyanshgoenka on 07/08/17.
 */

public class OctionListAdapter extends RecyclerView.Adapter<OctionListAdapter.ViewHolder> {

    private final List<OctionListing> repos;

    public OctionListAdapter(List<OctionListing> repos) {
        this.repos = repos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.oction_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OctionListing repo = repos.get(position);
        if (!Validations.isEmptyOrNull(repo.getMedia()) && repo.getMedia().get(0)!=null)
            try {
                Glide.with(holder.auctionImageView).load(FormatUtils.parseUrl(repo.getMedia().get(0).getMedia())).into(holder.auctionImageView);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        holder.auctionTitleTextView.setText(repo.getAuction().getTitle());
        holder.auctionDescriptionTextView.setText(repo.getAuction().getDescription());
        holder.auctionPriceTextView.setText(repo.getAuction().getProductCurrency()+" "+repo.getAuction().getProductPrice());
        holder.auctionTimeTextView.setText(FormatUtils.formatTime(repo.getAuction().getEndTimeUnix()));
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        Glide.with(holder.auctionImageView).clear(holder.auctionImageView);
    }

    @Override
    public int getItemCount() {
        return repos == null ? 0 : repos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.auction_image_view)
        ImageView auctionImageView;

        @BindView(R.id.auction_title_text_view)
        TextView auctionTitleTextView;

        @BindView(R.id.auction_description_text_view)
        TextView auctionDescriptionTextView;

        @BindView(R.id.auction_price_text_view)
        TextView auctionPriceTextView;

        @BindView(R.id.auction_time_text_view)
        TextView auctionTimeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
