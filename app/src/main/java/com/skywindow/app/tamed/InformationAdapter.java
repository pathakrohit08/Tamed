package com.skywindow.app.tamed;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/**
 * Created by Rohit on 2/20/2016.
 */
public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InformationViewHolder> {

    public static final int NEWS = 0;
    public static final int SHOP = 1;
    public static final int VET = 2;
    public static final int FORUM = 3;

    public static class InformationViewHolder extends RecyclerView.ViewHolder {

        public InformationViewHolder(View v) {
            super(v);
        }
    }

    public static class NewsViewHolder extends InformationViewHolder {

        CardView cv;
        TextView newsHeader;
        TextView newsDescription;
        ImageView newsPhoto;

        NewsViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.item_news_cardview);
            newsHeader = (TextView)itemView.findViewById(R.id.item_news_newsHeader);
            newsDescription = (TextView)itemView.findViewById(R.id.item_news_newsDescription);
            newsPhoto = (ImageView)itemView.findViewById(R.id.item_news_newsImage);
        }
    }

    public static class ShopViewHolder extends InformationViewHolder {

        TextView temp;
        ShopViewHolder(View itemView) {
            super(itemView);
            this.temp = (TextView)itemView.findViewById(R.id.sampleText);
        }
    }

    public static class VetViewHolder extends InformationViewHolder {

        TextView temp;
        VetViewHolder(View itemView) {
            super(itemView);
            this.temp = (TextView)itemView.findViewById(R.id.sampleText);
        }
    }

    public static class ForumViewHolder extends InformationViewHolder {

        TextView temp;
        ForumViewHolder(View itemView) {
            super(itemView);
            this.temp = (TextView)itemView.findViewById(R.id.sampleText);
        }
    }

    List<InformationItem> infoItems;
    private int[] infoTypes;

    InformationAdapter(List<InformationItem> infoItems, int[] infoTypes){
        this.infoItems = infoItems;
        this.infoTypes = infoTypes;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public InformationViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == NEWS) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.news_item, viewGroup, false);

            return new NewsViewHolder(v);
        } else if (viewType == SHOP) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.shop_item, viewGroup, false);
            return new ShopViewHolder(v);
        }
        else if (viewType == VET) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.vet_item, viewGroup, false);
            return new VetViewHolder(v);
        }
        else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.forum_item, viewGroup, false);
            return new ForumViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(InformationViewHolder informationViewHolder, int position) {

        if (informationViewHolder.getItemViewType() == NEWS) {
            NewsViewHolder holder = (NewsViewHolder) informationViewHolder;

            NewsItem _weatherItem=(NewsItem)infoItems.get(position);

            holder.newsHeader.setText(_weatherItem.itemHeader);
            holder.newsDescription.setText(_weatherItem.itemDescription);
            holder.newsPhoto.setImageResource(_weatherItem.itemPhoto);

        } else if (informationViewHolder.getItemViewType() == SHOP) {
            ShopViewHolder holder = (ShopViewHolder) informationViewHolder;
            ShopItem _weather=(ShopItem)infoItems.get(position);
            holder.temp.setText(_weather.itemHeader);
        }
        else if (informationViewHolder.getItemViewType() == VET) {
            VetViewHolder holder = (VetViewHolder) informationViewHolder;
            VetItem _weather=(VetItem)infoItems.get(position);
            holder.temp.setText(_weather.itemHeader);
        }
        else {
            ForumViewHolder holder = (ForumViewHolder) informationViewHolder;
            ForumItem _weather=(ForumItem)infoItems.get(position);
            holder.temp.setText(_weather.itemHeader);
        }
    }

    @Override
    public int getItemCount() {
        return infoItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return infoTypes[position];
    }
}

