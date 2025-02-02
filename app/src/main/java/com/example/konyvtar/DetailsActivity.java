package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    private TextView detailsTitle;
    private  TextView detailsAuthor;
    private TextView detailsPageNumber;
    private TextView detailsRandomYear;
    private Random rng;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });






    }


    public void init()
    {
        detailsTitle = findViewById(R.id.detailsTitle);
        detailsAuthor = findViewById(R.id.detailsAuthor);
        detailsPageNumber = findViewById(R.id.detailsPageNumber);
        detailsRandomYear = findViewById(R.id.detailsRandomYear);
        backButton = findViewById(R.id.backButton);
        rng = new Random();

        Intent  intent = getIntent();
        String author = intent.getStringExtra("authorKey");
        String title = intent.getStringExtra("titleKey");
        String pageNum = intent.getStringExtra("pageKey");
        detailsAuthor.setText(author);
        detailsTitle.setText(title);
        detailsPageNumber.setText(pageNum);
        detailsRandomYear.setText(Integer.toString(rng.nextInt(2500)) );
    }



}