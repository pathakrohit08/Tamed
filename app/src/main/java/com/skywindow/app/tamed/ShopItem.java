package com.skywindow.app.tamed;

import android.net.Uri;

/**
 * Created by Rohit on 2/20/2016.
 */
class ShopItem extends InformationItem {

    String ItemName;
    String ItemPrice;
    Uri ImageUri;

    ShopItem(String itemName, String itemPrice,Uri imageID) {
        this.ItemName=itemName;
        this.ItemPrice=itemPrice;
        this.ImageUri =imageID;

    }
}
