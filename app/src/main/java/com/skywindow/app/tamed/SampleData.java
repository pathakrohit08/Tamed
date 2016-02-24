package com.skywindow.app.tamed;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohit.arun.pathak on 2/24/2016.
 */
public class SampleData {



    public static List<InformationItem> GetDogData(Context baseContext)
    {
        List<InformationItem> _InfoItem = new ArrayList<>();

        NewsItem _newsItem= new NewsItem("Family Dog Saves Toddler From Drowning",R.string.german,R.drawable.german);
        _InfoItem.add(_newsItem);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false);

        ShoppingImageViewAdapter shoppingImageViewAdapter = new ShoppingImageViewAdapter(baseContext);
        ShopMain shopitem=new ShopMain(shoppingImageViewAdapter,linearLayoutManager);
        _InfoItem.add(shopitem);


        VetItem vetItem=new VetItem("This is vet section");
        _InfoItem.add(vetItem);

        ForumItem forumItem=new ForumItem("Q.How can I keep my dog busy for the whole day");
        _InfoItem.add(forumItem);



        return _InfoItem;
    }

    public static List<InformationItem> GetCatData(Context baseContext)
    {
        List<InformationItem> _InfoItem = new ArrayList<>();

        NewsItem _newsItem= new NewsItem("I married my cats after my last relationship ended in heartache - and it's purr-fect",R.string.cat,R.drawable.image9);
        _InfoItem.add(_newsItem);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false);

        ShoppingImageViewAdapter shoppingImageViewAdapter = new ShoppingImageViewAdapter(baseContext);
        ShopMain shopitem=new ShopMain(shoppingImageViewAdapter,linearLayoutManager);
        _InfoItem.add(shopitem);


        VetItem vetItem=new VetItem("This is vet section");
        _InfoItem.add(vetItem);

        ForumItem forumItem=new ForumItem("Q.Why is my cat loosing so much fur ?");
        _InfoItem.add(forumItem);



        return _InfoItem;
    }

    public static List<InformationItem> GetBirdData(Context baseContext)
    {
        List<InformationItem> _InfoItem = new ArrayList<>();

        NewsItem _newsItem= new NewsItem("Small birds prefer flying in company",R.string.bird,R.drawable.bird_new);
        _InfoItem.add(_newsItem);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false);

        ShoppingImageViewAdapter shoppingImageViewAdapter = new ShoppingImageViewAdapter(baseContext);
        ShopMain shopitem=new ShopMain(shoppingImageViewAdapter,linearLayoutManager);
        _InfoItem.add(shopitem);


        VetItem vetItem=new VetItem("This is vet section");
        _InfoItem.add(vetItem);

        ForumItem forumItem=new ForumItem("Q.Does mocking bird really mocks ?");
        _InfoItem.add(forumItem);



        return _InfoItem;
    }

    public static List<InformationItem> GetFishData(Context baseContext)
    {
        List<InformationItem> _InfoItem = new ArrayList<>();

        NewsItem _newsItem= new NewsItem("Genetics help fish thrive in toxic environments, collaborative study finds",R.string.fish,R.drawable.fish_new);
        _InfoItem.add(_newsItem);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false);

        ShoppingImageViewAdapter shoppingImageViewAdapter = new ShoppingImageViewAdapter(baseContext);
        ShopMain shopitem=new ShopMain(shoppingImageViewAdapter,linearLayoutManager);
        _InfoItem.add(shopitem);


        VetItem vetItem=new VetItem("This is vet section");
        _InfoItem.add(vetItem);

        ForumItem forumItem=new ForumItem("Q.How can I  maintain my aquarium ?");
        _InfoItem.add(forumItem);



        return _InfoItem;
    }
}
