package com.ljt.androidbasereview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HelloFragment extends ListFragment {
    private ArrayAdapter<String>   adapter;
    private FragmentManager manager;
    private FragmentTransaction transaction;


    public HelloFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,getData());
        manager=getFragmentManager();
    }

    public List<String> getData(){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<30;i++){
            list.add("AA"+i);
        }
        return list;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hello, container, false);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String item = adapter.getItem(position);
        RightFragment rightFragment = new RightFragment();
        transaction.replace(R.id.lines,rightFragment,"fragment");
        transaction.addToBackStack("fragment");
        Bundle bundle = new Bundle();
        bundle.putString("item",item);
        rightFragment.setArguments(bundle);
        transaction.commit();


    }
}
