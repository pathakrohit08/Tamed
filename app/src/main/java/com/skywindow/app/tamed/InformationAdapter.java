package com.skywindow.app.tamed;


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

import java.io.FileNotFoundException;
import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InformationViewHolder> {

    public static final int NEWS = 0;
    public static final int SHOP = 1;
    public static final int VET = 2;
    public static final int FORUM = 3;

    public static MainActivity mainActivity;

    public static final String[] IMAGE_NAME = {"image1", "image2", "image3", "image4", "image5", "image6","image7", "image8", "image9", "image10", "image11"};


   

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

    InformationAdapter(List<InformationItem> infoItems, int[] infoTypes,MainActivity activity){
        this.infoItems = infoItems;
        this.infoTypes = infoTypes;
        this.mainActivity = activity;
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

        for (String file : IMAGE_NAME){
            int imgResId = mainActivity.getResources().getIdentifier(file, "drawable", "com.skywindow.app.tamed");
            Uri path = Uri.parse("android.resource://com.skywindow.app.tamed/" + imgResId);
            adapter.add(adapter.getItemCount(),path);
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


    private Bitmap loadScaledBitmap(Uri src) throws FileNotFoundException {



        // required max width/height
        final int REQ_WIDTH = 150;
        final int REQ_HEIGHT = 150;

        Bitmap bm = null;

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(mainActivity.getBaseContext().getContentResolver().openInputStream(src),
                null, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, REQ_WIDTH,
                REQ_HEIGHT);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeStream(
                mainActivity.getBaseContext().getContentResolver().openInputStream(src), null, options);

        return bm;
    }

    public int calculateInSampleSize(BitmapFactory.Options options,
                                     int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and
            // width
            final int heightRatio = Math.round((float) height
                    / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }
}

