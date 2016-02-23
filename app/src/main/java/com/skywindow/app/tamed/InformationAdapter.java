package com.skywindow.app.tamed;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InformationViewHolder> {

    public static final int NEWS = 0;
    public static final int SHOP = 1;
    public static final int VET = 2;
    public static final int FORUM = 3;

    private boolean IsViewLoaded;
    public static Context baseContext;
    public static final String[] IMAGE_NAME = {"ped","bird","fish"};


   

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


       RecyclerView rview;
        ShopViewHolder(View itemView) {
            super(itemView);
            rview=(RecyclerView)itemView.findViewById(R.id.myrecyclerview);

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

    InformationAdapter(List<InformationItem> infoItems, int[] infoTypes,Context baseContext){
        this.infoItems = infoItems;
        this.infoTypes = infoTypes;
        this.baseContext=baseContext;

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
            ShopItem _weatherItem=(ShopItem)infoItems.get(position);
            holder.rview.setAdapter(_weatherItem.myadapter);
            holder.rview.setLayoutManager(_weatherItem.layoutManager);
            prepareGallery(_weatherItem.myadapter);

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

    private void prepareGallery(ShoppingImageViewAdapter adapter){

        if(IsViewLoaded==false) {
            for (String file : IMAGE_NAME) {
                int imgResId = baseContext.getResources().getIdentifier(file, "drawable", "com.skywindow.app.tamed");
                Uri path = Uri.parse("android.resource://com.skywindow.app.tamed/" + imgResId);
                adapter.add(adapter.getItemCount(), path);
            }


            IsViewLoaded = true;
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

