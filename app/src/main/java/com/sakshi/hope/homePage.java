package com.sakshi.hope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class homePage extends AppCompatActivity {

    ImageButton donateButton, receiveButton, volunteerButton, foodmapButton;
    ImageButton HomeButton, HistoryButton, LogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        donateButton=(ImageButton) findViewById(R.id.donateButton);
        receiveButton=(ImageButton) findViewById(R.id.receiveButton);
        volunteerButton=(ImageButton) findViewById(R.id.volunteerButton);
        foodmapButton=(ImageButton) findViewById(R.id.foodMapButton);
        HomeButton=(ImageButton) findViewById(R.id.HomeButton);
        HistoryButton=(ImageButton) findViewById(R.id.HistoryButton);
        LogoutButton=(ImageButton) findViewById(R.id.LogoutButton);


        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donateIntent = new Intent(homePage.this, donateActivity.class);
                startActivity(donateIntent);
            }
        });

        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent= new Intent(homePage.this, loginActivity.class);
                startActivity(loginIntent);
            }
        });

        foodmapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(homePage.this, mapActivity.class);
                startActivity(mapIntent);
            }
        });

        receiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent receiveIntent= new Intent(homePage.this, receiveactivity.class);
                startActivity(receiveIntent);
            }
        });

        volunteerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volunteerintent = new Intent(homePage.this, volunteerActivity.class);
                startActivity(volunteerintent);
            }
        });

        HistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hisIntent= new Intent(homePage.this, historyAcitvity.class);
                startActivity(hisIntent);
            }
        });
    }
}