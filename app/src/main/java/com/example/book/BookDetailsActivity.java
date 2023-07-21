package com.example.book;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BookDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_BOOK = "extra_book";

    public static Intent newIntent(Context context, Book book) {
        Intent intent = new Intent(context, BookDetailsActivity.class);
        intent.putExtra(EXTRA_BOOK, book);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        ImageView bookCoverImageView = findViewById(R.id.ivBookCover);
        TextView bookTitleTextView = findViewById(R.id.tvBookTitle);
        TextView authorTextView = findViewById(R.id.tvAuthor);
        TextView categoryTextView = findViewById(R.id.tvCategory);
        TextView contentTextView = findViewById(R.id.tvContent);

        // 处理"新手引导" TextView 的点击事件
        TextView guideEntryTextView = findViewById(R.id.text_guide_entry);
        guideEntryTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookDetailsActivity.this, GuideActivity.class));
            }
        });

        Book selectedBook = getIntent().getParcelableExtra(EXTRA_BOOK);
        if (selectedBook != null) {
            bookCoverImageView.setImageResource(selectedBook.getCoverResourceId());
            bookTitleTextView.setText(selectedBook.getName());
            authorTextView.setText("作者：" + selectedBook.getAuthor());
            categoryTextView.setText("分类：" + selectedBook.getCategory());
            contentTextView.setText(selectedBook.getContent());
        }
    }
}
