package com.example.myfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements pokemonListener {
    private DetailFragment mDetailFragment;
    private OverviewFragment mOverviewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOverviewFragment = new OverviewFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mOverviewFragment).commit();
    }

    @Override
    public void OnPokemonClick(String name) {
        int selected = 0;
        if(name == "Dragonite") {
            selected = 1;
        }
        if(name == "Bulbasaur"){
            selected = 2;
        }
        mDetailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("pokemon", selected);
        mDetailFragment.setArguments(args);

        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.fragment_container, mDetailFragment);
        trans.addToBackStack(null);
        trans.commit();
    }
}
