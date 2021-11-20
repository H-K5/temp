package com.example.movieapimpr6;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static VolleySingleton aV;
    private RequestQueue requestQueue;

    private VolleySingleton(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }
    public static VolleySingleton getmInstance(Context context){
        if (aV==null){
            aV=new VolleySingleton(context);
        }
        return aV;
    }
    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
