package com.skywindow.app.tamed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingImageViewAdapter extends RecyclerView.Adapter<ShoppingImageViewAdapter.ItemHolder>{

    private List<ShopItem> shoppingItems;
    private LayoutInflater layoutInflater;
    private Context context;
    private OnItemClickListener onItemClickListener;


    public ShoppingImageViewAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        shoppingItems = new ArrayList<ShopItem>();


    }

    @Override
    public ShoppingImageViewAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemCardView =layoutInflater.inflate(R.layout.shop_item, parent, false);
        return new ItemHolder(itemCardView, this);
    }

    @Override
    public void onBindViewHolder(ShoppingImageViewAdapter.ItemHolder holder, int position) {
        ShopItem _shopItem = shoppingItems.get(position);
        holder.setShopitem(_shopItem);

        if (_shopItem != null){

            try {

                holder.setImageView(loadScaledBitmap(_shopItem.ImageUri));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    private Bitmap loadScaledBitmap(Uri src) throws FileNotFoundException {


        // required max width/height
        final int REQ_WIDTH = 150;
        final int REQ_HEIGHT = 150;

        Bitmap bm = null;

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(context.getContentResolver().openInputStream(src),
                null, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, REQ_WIDTH,
                REQ_HEIGHT);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeStream(
                context.getContentResolver().openInputStream(src), null, options);

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

    @Override
    public int getItemCount() {
        return shoppingItems.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener = listener;
    }

    public OnItemClickListener getOnItemClickListener(){
        return onItemClickListener;
    }

    public interface OnItemClickListener{
        public void onItemClick(ItemHolder item, int position);
    }

    public void add(int location, ShopItem shopItem){
        shoppingItems.add(location, shopItem);
        notifyItemInserted(location);
    }

    public void clearAll(){
        int itemCount = shoppingItems.size();

        if(itemCount>0){
            shoppingItems.clear();
            notifyItemRangeRemoved(0, itemCount);
        }
    }


    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ShoppingImageViewAdapter parent;
        private View cardView;
        ImageView imageView;
        ShopItem shopItem;
        TextView itemName;
        TextView itemPrice;

        public ItemHolder(View cardView, ShoppingImageViewAdapter parent) {
            super(cardView);
            itemView.setOnClickListener(this);
            this.cardView = cardView;
            this.parent = parent;
            imageView = (ImageView) cardView.findViewById(R.id.item_image);
            itemName=(TextView)cardView.findViewById(R.id.itemName);
            itemPrice=(TextView)cardView.findViewById(R.id.itemPrice);
        }

        public void setShopitem(ShopItem shopItem){
            this.shopItem = shopItem;
        }

        public ShopItem getShopitem(){
            return shopItem;
        }

        public void setImageView(Bitmap bitmap){
            imageView.setImageBitmap(bitmap);
            itemName.setText(shopItem.ItemName);
            itemPrice.setText(shopItem.ItemPrice);
        }

        @Override
        public void onClick(View v) {
            final OnItemClickListener listener = parent.getOnItemClickListener();
            if(listener != null){
                listener.onItemClick(this, getLayoutPosition());
                //or use
                //listener.onItemClick(this, getAdapterPosition());
            }
        }
    }
}
