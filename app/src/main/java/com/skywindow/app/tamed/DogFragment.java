package com.skywindow.app.tamed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by rohit.arun.pathak on 2/19/2016.
 */
public class DogFragment extends Fragment {

    private List<NewsItem> newsItems;
    private RecyclerView rv;

    public DogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View _dogView=inflater.inflate(R.layout.fragment_news, container, false);
        rv = (RecyclerView)_dogView.findViewById(R.id.tamedapp_main_news);
        rv.setHasFixedSize(false);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);


        initializeData();
        initializeAdapter();

        return _dogView;
    }

    private void initializeData(){
        newsItems = new ArrayList<>();
        newsItems.add(new NewsItem("In Memory of Diesel: Russia Sends Puppy to France to Express Solidarity",R.string.german,R.drawable.german));
        newsItems.add(new NewsItem("Check this new product from pedigree",R.string.ped,R.drawable.ped));

    }

    private void initializeAdapter(){
        NewsAdapter adapter = new NewsAdapter(newsItems);
        rv.setAdapter(adapter);
    }

}
