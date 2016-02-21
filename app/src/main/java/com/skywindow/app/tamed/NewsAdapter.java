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
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

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

    List<NewsItem> newsItems;

    NewsAdapter(List<NewsItem> newsItems){
        this.newsItems = newsItems;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false);
        NewsViewHolder pvh = new NewsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder personViewHolder, int i) {
        personViewHolder.newsHeader.setText(newsItems.get(i).itemHeader);
        personViewHolder.newsDescription.setText(newsItems.get(i).itemDescription);
        personViewHolder.newsPhoto.setImageResource(newsItems.get(i).itemPhoto);
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }
}

