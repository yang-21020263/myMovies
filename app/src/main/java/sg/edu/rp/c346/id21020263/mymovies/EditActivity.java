package sg.edu.rp.c346.id21020263.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditActivity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etTitle, etGenre, etYear, etMovieID;
    Spinner editRating;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        btnCancel = findViewById(R.id.buttonEditCancel);
        etTitle = findViewById(R.id.editTextEditTitle);
        etGenre = findViewById(R.id.editTextEditGenre);
        etYear = findViewById(R.id.editTextEditYear);
        etMovieID = findViewById(R.id.editTextMovieID);
        editRating = findViewById(R.id.spinnerEditRating);

        Intent i = getIntent();
        movie = (Movie) i.getSerializableExtra("movie");
        etMovieID.setEnabled(false);
        etMovieID.setText(movie.getId()+"");
        etTitle.setText(movie.getTitle());
        etGenre.setText(movie.getGenre());
        etYear.setText(movie.getYear());
        int position = 0;
        if (movie.getRating() == "G") {
            position = 0;
        } else if (movie.getRating() == "PG") {
            position = 1;
        } else if (movie.getRating() == "PG13") {
            position = 2;
        } else if (movie.getRating() == "NC16") {
            position = 3;
        } else if (movie.getRating() == "M18") {
            position = 4;
        } else if (movie.getRating() == "R21") {
            position = 5;
        }
        editRating.setSelection(position);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                movie.setTitle(etTitle.getText().toString());
                movie.setGenre(etGenre.getText().toString());
                movie.setYear(etYear.getText().toString());
                movie.setRating(editRating.getSelectedItem().toString());
                dbh.updateMovie(movie);
                dbh.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteMovie(movie.getId());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}