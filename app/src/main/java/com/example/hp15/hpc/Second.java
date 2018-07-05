package com.example.hp15.hpc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Second extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String FileName1 = "myFile1";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView  = (BottomNavigationView)findViewById(R.id.buttonPanel);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.m1 :
                        Home fragement = new Home();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame1 , fragement).commit();
                        break;
                    case R.id.m2 :
                        Downloads fragement1 = new Downloads();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction().replace(R.id.frame1 , fragement1).commit();
                        break;
                case  R.id.m3 :
                    Contact fragment2 = new Contact();
                    FragmentManager fragmentManager2 = getSupportFragmentManager() ;
                    fragmentManager2.beginTransaction().replace(R.id.frame1 , fragment2).commit();
                    break;

                }
              return true ;

            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {

            String l = "logged_out";
            SharedPreferences sharedPreferences = getSharedPreferences(FileName1, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor1 = sharedPreferences.edit();
            editor1.putString("log_in_status" , l);
            startActivity(new Intent(Second.this , Login.class));


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home_menu) {

            Home fragement = new Home();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame1 , fragement).commit();
        } else if (id == R.id.about_menu) {

            About fragment = new About();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame1 , fragment).commit();

        } else if (id == R.id.course_menu) {

            Course fragement = new Course();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame1 , fragement).commit();

        } else if (id == R.id.download_menu) {
            Downloads fragement = new Downloads();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame1 , fragement).commit();

        } else if (id == R.id.hof_menu) {
            Hof fragement = new Hof();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame1 , fragement).commit();

        } else if (id == R.id.contact_menu) {
            Contact fragement = new Contact();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame1 , fragement).commit();

        } else if (id == R.id.blog_menu) {
            Blog fragement = new Blog();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame1 , fragement).commit();

        }
        else if (id == R.id.whatsapp_menu) {
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "hello");
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this, "Please install Whatsapp app", Toast.LENGTH_SHORT).show();
            }
        }
        else if (id == R.id.facebook_menu) {
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "hello");
                intent.setPackage("com.facebook.katana");
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this, "Please install Facebook app", Toast.LENGTH_SHORT).show();
            }
        }
        else if (id == R.id.twitter_menu) {
         try{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "hello");
            intent.setPackage("advanced.twitter.android");
            startActivity(intent);
        }catch (Exception e){
             Toast.makeText(this, "Please install Twitter app", Toast.LENGTH_SHORT).show();
         }

        }
        else if (id == R.id.google_menu) {
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "hello");
                intent.setPackage("com.google.android.apps.plus");
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this, "Please install Google plus app", Toast.LENGTH_SHORT).show();
            }


        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }



}
