package com.sakshi.hope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;

public class loginActivity extends AppCompatActivity {

    TextView registerHere, forgotPass;
    EditText email, password, Rname, Rpass, Remail, Rphone;
    ImageButton loginButton, regButton;
    ConstraintLayout registerLayout, loginLayout;

    //-----------------------------------------------------------------------------
    //private FirebaseAuth mAuth;
    //public static final String TAG = "TAG";
    //-----------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerHere= (TextView) findViewById(R.id.registerHere);
        forgotPass= (TextView) findViewById(R.id.forgotPass);
        email= (EditText) findViewById(R.id.email);
        password= (EditText) findViewById(R.id.password);
        loginButton= (ImageButton) findViewById(R.id.loginButton);
        registerLayout = (ConstraintLayout) findViewById(R.id.registerLayout);
        loginLayout = (ConstraintLayout) findViewById(R.id.loginLayout);
        Rname= (EditText) findViewById(R.id.Rname);
        Rpass= (EditText) findViewById(R.id.rPass);
        Remail= (EditText) findViewById(R.id.Remail);
        Rphone= (EditText) findViewById(R.id.Rphone);
        regButton= (ImageButton) findViewById(R.id.regButton);
        //----------------------------------------------------------------------------------------
        /*mAuth=FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            //reload();
            Intent intent = new Intent(loginActivity.this, homePage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }*/

        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerLayout.setVisibility(View.VISIBLE);
                loginLayout.setVisibility(View.GONE);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Memail = email.getText().toString().trim();
                String Mpassword= password.getText().toString().trim();
                int f1=0,f2=0,f3=0;

                if(TextUtils.isEmpty(Memail))
                {
                    email.setError("Email is Required.");
                    f1=1;
                    return;
                }

                if(TextUtils.isEmpty(Mpassword))
                {
                    password.setError("Password is Required.");
                    f2=1;
                    return;
                }

                if(password.length() < 6)
                {
                    password.setError("Password Must be >=6 Characters");
                    f3=1;
                    return;
                }

               if(f1==0 && f2==0 && f3==0)
                {
                    Intent homeIntent = new Intent(loginActivity.this, homePage.class);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(homeIntent);
                }



                //authenticate the user
               /*mAuth.signInWithEmailAndPassword(Memail,Mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(loginActivity.this, "Logged in Successfully.", Toast.LENGTH_SHORT) .show();
                            Intent intent = new Intent(loginActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }else{
                            Toast.makeText(loginActivity.this, "Error! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/
            }
        });
        //-------------------------------------------------Register Layout-------------------------------------------------------
        regButton.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v)
            {
                String email = Remail.getText().toString().trim();
                String password= Rpass.getText().toString().trim();
                String name= Rname.getText().toString().trim();
                String phone= Rphone.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Remail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    Rpass.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6)
                {
                    Rpass.setError("Password Must be >=6 Characters");
                    return;
                }

                Toast.makeText(loginActivity.this, "User Created.", Toast.LENGTH_SHORT) .show();
                registerLayout.setVisibility(View.GONE);
                loginLayout.setVisibility(View.VISIBLE);
                Intent intent = new Intent(loginActivity.this, homePage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                /*fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Signup.this, "User Created.", Toast.LENGTH_SHORT) .show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("name",name);
                            user.put("email",email);
                            user.put("phone",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"onSuccess: user Profile is created for "+ userID);
                                    Toast.makeText(Signup.this, "Registered Successfully.", Toast.LENGTH_SHORT) .show();
                                }
                            });
                            //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Intent intent = new Intent(Signup.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Signup.this, "Error!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/
            }
        });
    }
}