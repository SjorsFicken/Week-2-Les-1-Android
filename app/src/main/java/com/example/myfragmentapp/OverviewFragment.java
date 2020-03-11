package com.example.myfragmentapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

interface pokemonListener{
    public void OnPokemonClick(String name);
}

public class OverviewFragment extends Fragment {
    private String[] _pokemonNames = {"Pikachu", "Dragonite", "Bulbasaur"};
    public pokemonListener listener;
    private ArrayAdapter<String> _adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        _adapter = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_list_item_1, _pokemonNames);

        return inflater.inflate(R.layout.overview_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener = (MainActivity) getActivity();
        ListView listView = getView().findViewById(R.id.list_view);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View v, int position, long
                    id) {
                listener.OnPokemonClick(_adapter.getItem(position));
            }
        });
        listView.setAdapter(_adapter);
    }
}
