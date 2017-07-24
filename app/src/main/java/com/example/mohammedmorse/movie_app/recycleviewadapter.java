package com.example.mohammedmorse.movie_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Morse on 20/07/2017.
 */

public class recycleviewadapter extends RecyclerView.Adapter<recycleviewadapter.movies_holder> {
    ArrayList<movies> arr_data;
    Context con;
    public recycleviewadapter(ArrayList<movies> arr_data,Context con){
        this.arr_data= arr_data ;

        this.con=con;
    }

    @Override
    public movies_holder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        movies_holder h=new movies_holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(movies_holder holder, int position) {
        holder.name_txt.setText( arr_data.get(position).getMoviename());
        /*holder.image.setImage( arr_data.get(position).getMovieimageuri());*/
        Picasso.with(con).load(arr_data.get(position).getMovieimageuri()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return arr_data.size();
    }

    class movies_holder extends  RecyclerView.ViewHolder{
        TextView name_txt;
        ImageView image;
        public movies_holder(View itemView) {
            super(itemView);
       name_txt=(TextView)itemView.findViewById(R.id.text);
        image=(ImageView)itemView.findViewById(R.id.image);
        }
    }
}
