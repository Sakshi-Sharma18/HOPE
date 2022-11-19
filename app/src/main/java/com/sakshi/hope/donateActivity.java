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

public class donateActivity extends AppCompatActivity {

    EditText Dname, Dphone, Dfood, Ddescription;
    ImageButton submitButton;
    ImageButton HomeButton, HistoryButton, LogoutButton;
    ImageView DmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        HomeButton=(ImageButton) findViewById(R.id.HomeButton);
        HistoryButton=(ImageButton) findViewById(R.id.HistoryButton);
        LogoutButton=(ImageButton) findViewById(R.id.LogoutButton);
        Dname=(EditText) findViewById(R.id.Dname);
        Ddescription=(EditText) findViewById(R.id.Ddescription);
        Dfood= (EditText) findViewById(R.id.Dfood);
        Dphone= (EditText) findViewById(R.id.Dphone);
        submitButton=(ImageButton) findViewById(R.id.submitButton);
        DmapImage=(ImageView) findViewById(R.id.DmapImage);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = Dname.getText().toString().trim();
                String fooditem= Dfood.getText().toString().trim();
                String description= Ddescription.getText().toString().trim();
                String phone= Dphone.getText().toString().trim();
                String type= "Donor";

                if(TextUtils.isEmpty(fullname))
                {
                    Dname.setError("Name is Required.");
                    return;
                }

                if(TextUtils.isEmpty(fooditem))
                {
                    Dfood.setError("Required.");
                    return;
                }

                if(phone.length() < 10)
                {
                    Dphone.setError("Phone Number Must be >=10 Characters");
                    return;
                }

                Intent questionIntent= new Intent(donateActivity.this, questionActivity.class);
                startActivity(questionIntent);
            }
        });

        /*HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity(0);
            }
        });*/

    }
}