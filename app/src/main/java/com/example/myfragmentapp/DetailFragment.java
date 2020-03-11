package com.example.myfragmentapp;

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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    public void setPokemon(String p){
        ImageView image = getView().findViewById(R.id.imageView);
        TextView text = getView().findViewById(R.id.textView);
        int selected = 0;
        if(p == "Dragonite") {
            selected = 1;
        }
        if(p == "Bulbasaur"){
            selected = 2;
        }
        image.setImageResource(_pokemon[selected].image);
        text.setText(_pokemon[selected].name);
    }
}
