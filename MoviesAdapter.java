package com.example.movieapimpr6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {

    private Context context;
    private List movieList;

    public MoviesAdapter(Context context, List movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MoviesHolder(view);
    }

    public void onBindViewHolder(MoviesHolder holder, int position) {
        Movies movies= (Movies) movieList.get(position);
        holder.title.setText(movies.getTitle());
        holder.description.setText(movies.getDescription());
        holder.publisedAt.setText(movies.getPublishedAt());
        Picasso.get().load(movies.getUrlToImage()).into(holder.imageView);
    }

    public int getItemCount() {
        return movieList.size();
    }

    public class MoviesHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,description,publisedAt;
        public MoviesHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.gambarfilm);
            title=itemView.findViewById(R.id.judulfilm);
            description=itemView.findViewById(R.id.deskripsifilm);
            publisedAt=itemView.findViewById(R.id.tanggalrilisfilm);

        }
    }
}
