package sg.edu.rp.c346.id21020263.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etGenre, etYear;
    Button btnInsert, btnList;
    Spinner ratings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.editTextTitle);
        etGenre = findViewById(R.id.editTextGenre);
        etYear = findViewById(R.id.editTextYear);
        btnInsert = findViewById(R.id.buttonInsert);
        btnList = findViewById(R.id.buttonList);
        ratings = findViewById(R.id.spinnerRating);


    }
}