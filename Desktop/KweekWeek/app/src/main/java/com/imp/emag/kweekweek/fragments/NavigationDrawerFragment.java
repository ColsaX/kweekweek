package com.imp.emag.kweekweek.fragments;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.imp.emag.kweekweek.R;

/**
 * Created by tzury on 24/05/15.
 */
public class NavigationDrawerFragment extends android.support.v4.app.Fragment {



    private ListView categoriesListView;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    public NavigationDrawerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }


    public void setUp(DrawerLayout viewById, Toolbar toolbar) {
        drawerLayout = viewById;
        drawerToggle = new ActionBarDrawerToggle(getActivity(), viewById, toolbar, R.string.open, R.string.close) {

            @Override
            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
            }

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });
    }
}
