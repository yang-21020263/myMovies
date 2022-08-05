package sg.edu.rp.c346.id21020263.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> al;

    public CustomAdapter(Context context, int resource,  ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        al = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvGenre = rowView.findViewById(R.id.tvGenre);
        TextView tvYear = rowView.findViewById(R.id.tvDate);
        ImageView ivRating = rowView.findViewById(R.id.ivIcon);

        // Obtain the item information based on the position
        Movie movie = al.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(movie.getTitle());
        tvGenre.setText(movie.getGenre());
        tvYear.setText(movie.getYear());
        if (movie.getRating() == "G") {
            ivRating.setImageResource(R.drawable.rating_g);
        } else if (movie.getRating() == "PG") {
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if (movie.getRating() == "PG13") {
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if (movie.getRating() == "NC16") {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if (movie.getRating() == "M18") {
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if (movie.getRating() == "R21") {
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }

}
