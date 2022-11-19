package com.sakshi.hope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.HashMap;
import java.util.Map;

public class receiveactivity extends AppCompatActivity {

    ImageButton HomeButton, HistoryButton, LogoutButton;
    ImageButton rsubmit;
    EditText rname, rdescr;
    ImageView rmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiveactivity);

        Intent mapIntent = new Intent(receiveactivity.this, mapActivity.class);


        HomeButton=(ImageButton) findViewById(R.id.HomeButton);
        HistoryButton=(ImageButton) findViewById(R.id.HistoryButton);
        LogoutButton=(ImageButton) findViewById(R.id.LogoutButton);
        rname= (EditText) findViewById(R.id.rname);
        rdescr= (EditText) findViewById(R.id.rdescription);
        rmapImage=(ImageView) findViewById(R.id.rmapImage);
        rsubmit= (ImageButton) findViewById(R.id.rsubmitButton);

        rmapImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mapIntent);
            }
        });

        rsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = rname.getText().toString().trim();
                String description= rdescr.getText().toString().trim();
                String type= "Receiver";

                if(TextUtils.isEmpty(fullname))
                {
                    rname.setError("Name is Required.");
                    return;
                }
                if(TextUtils.isEmpty(description))
                {
                    rdescr.setError("Description is Required.");
                    return;
                }

                Toast.makeText(receiveactivity.this, "Someone will find you to give food... Please wait", Toast.LENGTH_SHORT).show();
                startActivity(mapIntent);
            }
        });
    }
}