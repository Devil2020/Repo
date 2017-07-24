package com.example.mohammedmorse.movie_app;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rec;
    RecyclerView.LayoutManager lm;
    recycleviewadapter ad;
    String url="http://api.themoviedb.org/3/movie/top_rated?api_key=107ed75bf9e25ec06bfe9fd33d042579";
    ArrayList<movies> arr1=new ArrayList<movies>();
    RequestQueue requestqueue;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec=(RecyclerView) findViewById(R.id.rec);
        lm= new GridLayoutManager(MainActivity.this,2);
        rec.setLayoutManager(lm);
        requestqueue = Volley.newRequestQueue(MainActivity.this);
        rec.setAdapter(ad);
        sendrequest(url);
    }
    public void sendrequest(String url){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    arr1.clear();
                    JSONArray jsonArray=response.getJSONArray("results");
                    for(int i=0;i<jsonArray.length();i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        movies movie = new movies();
                        movie.setMovieimageuri(jsonObject.getString("poster_path"));
                        movie.setMoviename(jsonObject.getString("original_title"));
                        movie.setMovierate(jsonObject.getString("vote_average"));
                        movie.setMovieoverview(jsonObject.getString("overview"));
                        movie.setMoviereleasedate(jsonObject.getString("release_date"));
                        movie.setMovieid(jsonObject.getString("id"));
                        arr1.add(movie);
                    }
                    ad.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestqueue.add(jsonObjectRequest);
    }
}
