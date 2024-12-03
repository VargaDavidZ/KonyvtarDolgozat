package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText bookTitleEditText;
    private EditText bookAuthorEditText;
    private EditText bookPageNumberEditText;



    private Button addBookButton;

    private ListView bookListView;

    private List<Book> books;
    bookAdapter adapter;


    //private LinearLayout listLinearLayout;
    private TextView detailsTitle;
  private TextView detailsAuthor;
   private TextView detailsPageNumber;
    private TextView detailsRandomYear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();




        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = bookTitleEditText.getText().toString();
                String author = bookAuthorEditText.getText().toString();
                String pageNum = bookPageNumberEditText.getText().toString();

                if(title.equals("")  || author.equals("") || pageNum.equals("") )
                {
                    Toast.makeText(MainActivity.this, "Minden mezőt ki kell tölteni", Toast.LENGTH_SHORT).show();
               
                } else if (Integer.parseInt(pageNum) < 50) {
                    Toast.makeText(MainActivity.this, "Az oldalszámnak legalább 50-nek kell lennie", Toast.LENGTH_SHORT).show();
                } else
                {
                    books.add(new Book(title,author ,pageNum));
                    adapter.notifyDataSetChanged();
                }


            }
        });

       bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               System.out.println();
               Intent details = new Intent(MainActivity.this, DetailsActivity.class);
               details.putExtra("authorKey",books.get(i).getAuthor());
               details.putExtra("titleKey",books.get(i).getTitle());
               details.putExtra("pageKey",books.get(i).getPageNumber());
               startActivity(details);


           }
       });








    }




    public void init()
    {
        bookTitleEditText = findViewById(R.id.bookTitleEditText);
        bookAuthorEditText = findViewById(R.id.bookAuthorEditText);
        bookPageNumberEditText = findViewById(R.id.bookPageNumberEditText);

        addBookButton = findViewById(R.id.addBookButton);

        bookListView = findViewById(R.id.bookListView);

       //listLinearLayout = findViewById(R.id.listLinearLayout);
//
//        detailsAuthor = findViewById(R.id.detailsAuthor);
//        detailsPageNumber = findViewById(R.id.detailsPageNumber);
//        detailsRandomYear = findViewById(R.id.detailsRandomYear);

        books = new ArrayList<>();
        adapter = new bookAdapter(books,MainActivity.this);
        bookListView.setAdapter(adapter);

        books.add(new Book("Test1","test2","1000"));
        books.add(new Book("Test1","test2","1000"));
        books.add(new Book("Test1","test2","1000"));
        books.add(new Book("Test1","test2","1000"));




    }
}