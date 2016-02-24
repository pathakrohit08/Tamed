package com.skywindow.app.tamed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohit.arun.pathak on 2/19/2016.
 */

/*Add Log to the code*/
public class BirdFragment extends Fragment implements ShoppingImageViewAdapter.OnItemClickListener{

    public static final int NEWS = 0;
    public static final int SHOP = 1;
    public static final int VET = 2;
    public static final int FORUM = 3;

    private List<InformationItem> infoItems;
    private RecyclerView rv;
    private int infoTypes[] = {NEWS,SHOP,VET,FORUM}; //view types



    public BirdFragment() {
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

        LinearLayoutManager llm = new LinearLayoutManager(rv.getContext());
        rv.setLayoutManager(llm);


        initializeData();
        initializeAdapter();

        return _dogView;
    }

    private void initializeData(){
        infoItems = SampleData.GetBirdData(getActivity().getBaseContext());

    }


    private void initializeAdapter(){
        InformationAdapter adapter = new InformationAdapter(infoItems,infoTypes,getActivity().getBaseContext());
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(ShoppingImageViewAdapter.ItemHolder item, int position) {

        /*ToDO*/

    }

}
