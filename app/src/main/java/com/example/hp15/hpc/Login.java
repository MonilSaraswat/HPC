package com.example.hp15.hpc;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class Login extends AppCompatActivity {
    String FileName1 = "myFile1";
    Button btn ;
    EditText user , pass ;
    String username , password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getId();
        getValue();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String l = "Logged_in";
                SharedPreferences sharedPreferences = getSharedPreferences(FileName1, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString("log_in_status", l);
                   if (username.equals("")) {
                    user.setError("Enter your username");
                 if (password == "") {
                    pass.setError("Enter your Password");
                }}
            else {
                    startActivity(new Intent(Login.this, Second.class));
                    finish();
                }
            }
        });
    }


    public void register(View v){
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }
    public void getId(){
        btn = (Button)findViewById(R.id.btn_signin);
        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
    }
    public void getValue(){
        username = user.getText().toString();
        password = pass.getText().toString();
    }
}