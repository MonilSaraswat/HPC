package com.example.hp15.hpc;

import android.content.Context;
import android.provider.CalendarContract;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by hp 15 on 8/1/2017.
 */

public class Singleton {

    private static Singleton mySingleton ;
    private RequestQueue requestQueue ;
    private static Context cnxt ;


    private Singleton(Context context){

        cnxt = context ;
        requestQueue = getRequestQueue() ;

    }



    public RequestQueue  getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(cnxt.getApplicationContext());

        }

        return requestQueue;
    }

    public static synchronized Singleton getMySingleton(Context context){

        if(mySingleton==null){

            mySingleton = new Singleton(context);



        }
        return mySingleton ;


    }


    public <T> void addToRequestQue(Request<T> request){

        requestQueue.add(request);

    }



}
