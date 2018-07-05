package com.example.hp15.hpc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by hp 15 on 7/25/2017.
 */

public class Contact extends Fragment {
    ImageButton address_btn , phone_btn , mail_btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact , container , false);
         address_btn = (ImageButton)v.findViewById(R.id.ib1);
         phone_btn = (ImageButton)v.findViewById(R.id.ib2);
         mail_btn = (ImageButton)v.findViewById(R.id.ib3);


        address_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo: 26.8999259,75.7351179"));
                Intent chooser = Intent.createChooser(i , "Launch Maps");
                startActivity(chooser);

            }
        });
        phone_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+91-7737003227"));
                if(ActivityCompat.checkSelfPermission(getActivity() , Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(getActivity() , new String[]{ Manifest.permission.CALL_PHONE} , 1);
                }
                else{
                    startActivity(i);
                }
            }
        });
        mail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("email"));
                String[] s = {"physicsbyhitenparmar@gmail.com"};
                i.putExtra(Intent.EXTRA_EMAIL , s) ;
                i.setType("message/rfc822");
                Intent chooser = Intent.createChooser(i , "Launch Email");
                startActivity(chooser);
            }
        });



    return   v ;
    }

}


