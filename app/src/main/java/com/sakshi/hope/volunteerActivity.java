package com.sakshi.hope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class volunteerActivity extends AppCompatActivity {

    ImageButton HomeButton, HistoryButton, LogoutButton;
    ImageButton vsubmit;
    EditText vname, vphone;
    ImageView vimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        HomeButton=(ImageButton) findViewById(R.id.HomeButton);
        HistoryButton=(ImageButton) findViewById(R.id.HistoryButton);
        LogoutButton=(ImageButton) findViewById(R.id.LogoutButton);
        vsubmit=(ImageButton) findViewById(R.id.vsubmitButton);
        vname= (EditText) findViewById(R.id.vname);
        vphone= (EditText) findViewById(R.id.vphone);
        vimage= (ImageView) findViewById(R.id.vmapImage);

        Intent mapIntent= new Intent(volunteerActivity.this, mapActivity.class);

        vimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mapIntent);
            }
        });

        vsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = vname.getText().toString().trim();
                String description= vphone.getText().toString().trim();
                String type= "Receiver";

                if(TextUtils.isEmpty(fullname))
                {
                    vname.setError("Name is Required.");
                    return;
                }
                if(TextUtils.isEmpty(description))
                {
                    vphone.setError("Phone Number is Required.");
                    return;
                }

                Toast.makeText(volunteerActivity.this, "Here are the donor and receiver locations..", Toast.LENGTH_SHORT).show();
                startActivity(mapIntent);
            }
        });

    }
}