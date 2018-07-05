package com.example.hp15.hpc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hp 15 on 7/25/2017.
 */

public class Course extends Fragment {

    String[] titles = {"Foundation Courses\n" , "Target Courses\n" , "Excel Courses\n"};
    String[] description = {"For class XI appearing students who wish to score high percentage in school examination, along with a strong foundation for various competitive examinations.\n"
            , "Students appearing for class XII, whose aim is to be selected in competitive exam with very good % in board exams also.\n"
            , "Lorem ipsum doloAr sit amet, conset adipiscing elitsed do eius\n" } ;
    String[] subtitles = {"XI PHYSICS (FOR ALL BOARDS)\nXII PHYSICS (FOR ALL BOARDS)"
            , "JEE FOUNDATION WITH XI\nJEE FOUNDATION WITH XII\nNEET FOUNDATION WITH X\nNEET FOUNDATION WITH XII\nJEE ADVANCE BATCH"
            , "JEE DROPPERS BATCH (MORNING/EVENING)\nNEET DROPPERS BATCH (MORNING/EVENING)\n\n\n"} ;

    ListView lv ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course , container , false) ;

        lv = (ListView)view.findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(getActivity() , titles , description , subtitles);
        lv.setAdapter(adapter);



        return view;
    }
}
class MyAdapter extends ArrayAdapter{
    String [] titleArray ;
    String [] descArray ;
    String[] subArray ;
    public  MyAdapter(Context context , String[] titles1 , String[] description1 , String[] Sub){
     super(context , R.layout.listview_course , R.id.title , titles1);

        this.titleArray = titles1 ;
        this.descArray = description1;
        this.subArray = Sub ;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_course , parent , false);

        TextView myTitle = (TextView) row.findViewById(R.id.title);
        TextView myDescription = (TextView)row.findViewById(R.id.desc);
        TextView mySub = (TextView)row.findViewById(R.id.sub);


        myTitle.setText(titleArray[position]);
        myDescription.setText(descArray[position]);
        mySub.setText(subArray[position]);
        return row ;
    }
}

