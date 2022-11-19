package com.sakshi.hope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    TextView registerHere, forgotPass;
    EditText email, password;
    ImageButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.logoIcon);
        registerHere= (TextView) findViewById(R.id.registerHere);
        forgotPass= (TextView) findViewById(R.id.forgotPass);
        email= (EditText) findViewById(R.id.email);
        password= (EditText) findViewById(R.id.password);
        loginButton= (ImageButton) findViewById(R.id.loginButton);

        CountDownTimer ctd1 = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {
                //do nothing
            }

            @Override
            public void onFinish() {

                Intent loginIntent= new Intent(getApplicationContext(), loginActivity.class) ;
                startActivity(loginIntent);
            }
        }.start();

    }
}