package com.example.hp15.hpc;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

/**
 * Created by hp 15 on 7/25/2017.
 */

public class Hof extends Fragment  {

    String names[]= {"Sparsh" ,"Apoorv" , "Pranjal" ,"Vishakha"  , "Shreyas" , "Rishabh Singh" , "Tanvi" , "Pradeep" , "Parth" , "Rishabh Chapola" ,
                    "Sarvagya" , "Vinayak" , "Umang" , "Sikhar" , "Aditi"};
    String desc[]={"NEET , VAT" , "JEE MAINS , CBSE 95 , Admitted to Hongkong Univ" , "JEE MAINS" , "VIT, SRM, COMEDK, CBSE-87" , "VIT, SRM, MANIPAL, COMEDK" ,
                          "NEET, CBSE-92" , "NEET, CBSE-95" , "JEE MAINS" , "NEET" , "NEET" , "VIT, SRM" , "NDA, SRM, MANIPAL, MERCHANT NAVY",
                        "JEE MAINS, KALINGA, VIT SRM, COMEDK" , "JEE MAINS AND ADV, CBSE-95, SRM, VIT" , "JEE MAINS, CBSE-93"};
    int images[] = {R.mipmap.sparsh ,R.mipmap.apoorv , R.mipmap.pranjal , R.mipmap.vishakha
                   , R.mipmap.shreyas , R.mipmap.rishabh_s , R.mipmap.tanvi , R.mipmap.pradeep
                      , R.mipmap.parth , R.mipmap.rishabh , R.mipmap.sarvagya , R.mipmap.vinayak,
                     R.mipmap.umang , R.mipmap.sikhar , R.mipmap.aditi};
    ListView listView ;

    String server_url = "http://www.physicsbyhitenparmar.com/storage/app/topper/thumb/1501141457_aadcab573fae4ad8378950c0e72a7a06.jpg";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hof , container , false) ;

        listView = (ListView)v.findViewById(R.id.listview);
        MyAdapter1 adapter = new MyAdapter1(getActivity() , names , desc , images);
        listView.setAdapter(adapter);

        return v;
    }

}

class MyAdapter1 extends ArrayAdapter{
    String [] titleArray ;
    String [] descArray ;
    int [] imageArray ;
    public  MyAdapter1(Context context , String[] titles1 , String[] description1 , int[] images1){
        super(context , R.layout.listview_course , R.id.title , titles1);

        this.titleArray = titles1 ;
        this.descArray = description1;
        this.imageArray = images1 ;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_hof , parent , false);

        TextView myTitle = (TextView) row.findViewById(R.id.names);
        TextView myDescription = (TextView)row.findViewById(R.id.desc);
        ImageView mySub = (ImageView)row.findViewById(R.id.pic);


        myTitle.setText(titleArray[position]);
        myDescription.setText(descArray[position]);
        mySub.setImageResource(imageArray[position]);
        return row ;
    }
}




