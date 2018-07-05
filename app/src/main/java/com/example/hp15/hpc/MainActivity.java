package com.example.hp15.hpc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String FileName = "myFile";
    String FileName1 = "myFile1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView)findViewById(R.id.v1);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.slide_up);
        imageView.startAnimation(animation);


        Thread th = new Thread(){
            public void run(){
                try{
                    sleep(4000);

                }
                catch(Exception e){

                }
                finally {
                    SharedPreferences sharedPreferences1 = getSharedPreferences(FileName1, Context.MODE_PRIVATE);
                    String value = "logged_out";
                    SharedPreferences sharedPreferences = getSharedPreferences(FileName, Context.MODE_PRIVATE);
                    String defaultValue = "unlaunched";

                    String name = sharedPreferences.getString("status", defaultValue);
                    String name1 = sharedPreferences1.getString("log_in_status" , value);
                    if (name == "unlaunched") {
                        Intent i = new Intent(MainActivity.this, Intro.class);
                        startActivity(i);
                        finish();
                    }if(name1== "logged_out"){
                        startActivity(new Intent(MainActivity.this , Login.class));
                        finish();
                    }

                    else {
                        Intent i = new Intent(MainActivity.this, Second.class);
                        startActivity(i);
                        finish();


                    }
                }

            }
        };
        th.start();

    }





    }

   // @Override
   // public boolean onCreateOptionsMenu(Menu menu) {
     //   MenuInflater menuInflater = getMenuInflater();
      //  menuInflater.inflate(R.menu.menu , menu);

//        return true ;
  //  }


   // @Override
   // public boolean onOptionsItemSelected(MenuItem item) {
     //   int res = item.getItemId() ;
       // if (res == R.id.m1
         //       ){
        //    Toast.makeText(getApplicationContext(), "Search Selected", Toast.LENGTH_SHORT).show();
       // }
        //return true ;


