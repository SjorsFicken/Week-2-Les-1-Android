package com.example.myfragmentapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    private Pokemon[] _pokemon = {new Pokemon("Pikachu", R.drawable.pikachu)
            , new Pokemon("Dragonite", R.drawable.dragonite)
            , new Pokemon("Bulbasaur", R.drawable.bulbasaur)};

    final static String ARG_POKEMON = "pokemon";
    int mCurrentPokemon = -1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mCurrentPokemon = savedInstanceState.getInt(ARG_POKEMON);
        }

        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if(args != null){
            setPokemon(_pokemon[args.getInt(ARG_POKEMON)]);
            mCurrentPokemon = args.getInt(ARG_POKEMON);
        }else if (mCurrentPokemon != -1) {
            // Set article based on saved instance state defined during onCreateView
            setPokemon(_pokemon[mCurrentPokemon]);
        }
    }

    public void setPokemon(Pokemon p){
        ImageView image = getView().findViewById(R.id.imageView);
        TextView text = getView().findViewById(R.id.textView);

        image.setImageResource(p.image);
        text.setText(p.name);
    }
}
