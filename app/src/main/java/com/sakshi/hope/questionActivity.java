package com.sakshi.hope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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

public class questionActivity extends AppCompatActivity {

    ImageButton HomeButton, HistoryButton, LogoutButton;
    ImageButton yes, no;
    ConstraintLayout question, VList;
    ListView volunList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent mapIntent= new Intent(questionActivity.this, mapActivity.class);

        HomeButton=(ImageButton) findViewById(R.id.HomeButton);
        HistoryButton=(ImageButton) findViewById(R.id.HistoryButton);
        LogoutButton=(ImageButton) findViewById(R.id.LogoutButton);
        yes= (ImageButton) findViewById(R.id.yesButton);
        no= (ImageButton) findViewById(R.id.nobutton);
        question = (ConstraintLayout) findViewById(R.id.question);
        VList =(ConstraintLayout) findViewById(R.id.VList);
        volunList = (ListView) findViewById(R.id.volunList);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VList.setVisibility(View.VISIBLE);
                question.setVisibility(View.GONE);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "You can deliver the food as per your convenience to the available receivers.", Toast.LENGTH_SHORT).show();
                startActivity(mapIntent);
            }
        });


        ArrayList<String> Varray= new ArrayList<>();
        Varray.add("ABC user \nPhone number:234-543-XXXX");
        Varray.add("XYZ user \nPhone number:234-543-XXXX");
        Varray.add("POR user \nPhone number:234-543-XXXX");

        ArrayAdapter<String> Vaa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Varray){
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
        volunList.setAdapter(Vaa);

        volunList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Volunteer Selected!", Toast.LENGTH_SHORT).show();
                Toast.makeText(questionActivity.this, "Food will be picked up Shortly!!", Toast.LENGTH_SHORT).show();
                startActivity(mapIntent);
            }
        });

    }
}