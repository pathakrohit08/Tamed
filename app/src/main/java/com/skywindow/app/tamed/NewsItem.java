package com.skywindow.app.tamed;

/**
 * Created by Rohit on 2/20/2016.
 */
class NewsItem extends InformationItem{
    String itemHeader;
    int itemDescription;
    int itemPhoto;

    NewsItem(String itemHeader, int itemDescription, int itemPhoto) {
        this.itemHeader = itemHeader;
        this.itemDescription = itemDescription;
        this.itemPhoto=itemPhoto;

    }
}
