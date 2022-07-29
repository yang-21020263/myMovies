package sg.edu.rp.c346.id21020263.mymovies;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_content;
    int layout_id;
    ArrayList<MovieList> contactlist;

    public CustomAdapter(Context context, int resource,  ArrayList<MovieList> objects) {
        super(context, resource, objects);
        parent_content = context;
        layout_id = resource;
        contactlist = objects;
    }

}
