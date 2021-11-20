package com.example.movieapimpr6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private RequestQueue requestqueue;
    private List<Movies>  moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        requestqueue = VolleySingleton.getmInstance(this).getRequestQueue();
        moviesList = new ArrayList<>();
        fetchMovies();
    }

    private void fetchMovies(){
        String url = "https://api.themoviedb.org/3/list/1?api_key="+getString(R.string.api_key);
        JsonObjectRequest jsonobjectrequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray items = response.getJSONArray("items");
                    for (int i = 0; i < response.getInt("item_count"); i++) {
                        JSONObject item = items.getJSONObject(i);
                        String urltoImage = "https://image.tmdb.org/t/p/original/" + item.getString("poster_path");
                        String title = item.getString("title");
                        String description = item.getString("overview");
                        String publishedAt = item.getString("release_date");

                        Movies movies = new Movies(title, description, publishedAt, urltoImage);
                        moviesList.add(movies);
                    }
                    MoviesAdapter adapter = new MoviesAdapter(MainActivity.this, moviesList);
                    recyclerview.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", error.toString());
            }
        });
        requestqueue.add(jsonobjectrequest);
    }
}