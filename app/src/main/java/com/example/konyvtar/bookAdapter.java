package com.example.konyvtar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class bookAdapter extends BaseAdapter
{
    private List<Book> books;
    private Context context;

    public bookAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.book_list_item,viewGroup,false);

        TextView bookTitleTextView = view.findViewById((R.id.bookTitleTextView));
        TextView bookAuthorTextView = view.findViewById((R.id.bookAuthorTextView));
        TextView bookPageNumberTextView = view.findViewById((R.id.bookPageNumberTextView));

        LinearLayout listLinearLayout = view.findViewById(R.id.listLinearLayout);

        TextView detailsTitle = view.findViewById(R.id.detailsTitle);
        TextView detailsAuthor = view.findViewById(R.id.detailsAuthor);
        TextView detailsPageNumber = view.findViewById(R.id.detailsPageNumber);
        TextView detailsRandomYear = view.findViewById(R.id.detailsRandomYear);


//        listLinearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                detailsAuthor.setText(books.get(i).getAuthor());
//                detailsTitle.setText(books.get(i).getTitle());
//                detailsPageNumber.setText(books.get(i).getPageNumber());
//            }
//        });


        Button bookDeleteButton = view.findViewById(R.id.bookDeleteButton);


        bookDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Törlés");
                builder.setMessage("Biztosan törli a könyvet?");
                int myIndex = i;
                builder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        books.remove(myIndex);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Nem",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });



        Book b1 = books.get(i);


            bookTitleTextView.setText(b1.getTitle());
            bookAuthorTextView.setText(b1.getAuthor());
            bookPageNumberTextView.setText(b1.getPageNumber());



        return view;
    }
}
