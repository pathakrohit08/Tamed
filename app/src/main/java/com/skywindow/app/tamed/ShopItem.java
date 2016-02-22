package com.skywindow.app.tamed;

import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by Rohit on 2/20/2016.
 */
class ShopItem extends InformationItem {

    ShoppingImageViewAdapter myadapter;
    LinearLayoutManager layoutManager;

    ShopItem(ShoppingImageViewAdapter adapter,LinearLayoutManager lmanager) {
        this.myadapter=adapter;
        this.layoutManager=lmanager;

    }
}
