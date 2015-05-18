package com.imp.emag.kweekweek;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imp.emag.kweekweek.model.OneEvent;
import com.imp.emag.kweekweek.uiElements.RecyclerAdapter;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;



public class MainActivityFragment extends Fragment {

    private RecyclerView eventsList;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<OneEvent> events;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        eventsList = (RecyclerView) view.findViewById(R.id.recycler_view_item);
        eventsList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        eventsList.setLayoutManager(layoutManager);
        FetchData fetchData=new FetchData(events);
        try {
            events=fetchData.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        adapter = new RecyclerAdapter(events);
        eventsList.setAdapter(adapter);

        return view;


    }


}
