package com.sakshi.hope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class historyAcitvity extends AppCompatActivity {

    ListView hisList;
    ImageButton HomeButton, HistoryButton, LogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_acitvity);

        HomeButton=(ImageButton) findViewById(R.id.HomeButton);
        HistoryButton=(ImageButton) findViewById(R.id.HistoryButton);
        LogoutButton=(ImageButton) findViewById(R.id.LogoutButton);

        hisList= (ListView) findViewById(R.id.dHisList);

        ArrayList<String> Darray= new ArrayList<>();
        Darray.add("Name: XYZ user\n" +
                "Location: 1234, Bakers street\n" +
                "Type: Donor\n" +
                "Volunteer: None");
        Darray.add("Name: XYZ user\n" +
                "Location: 906, Henry street\n" +
                "Type: Donor\n" +
                "Volunteer: ABC");
        Darray.add("Name: XYZ user\n" +
                "Location: 121, Made up Street\n" +
                "Type: Volunteer\n" +
                "Volunteer: ABC");

        ArrayAdapter<String> Daa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Darray){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(22);
                textView.setBackgroundColor(getResources().getColor(R.color.cream));

                return view;
            }
        };
        hisList.setAdapter(Daa);
    }
}