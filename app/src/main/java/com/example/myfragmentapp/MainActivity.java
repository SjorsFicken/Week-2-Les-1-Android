package com.example.myfragmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements pokemonListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void OnPokemonClick(String name) {
        DetailFragment f = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        f.setPokemon(name);
    }
}
