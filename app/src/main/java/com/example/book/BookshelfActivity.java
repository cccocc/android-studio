package com.example.book;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;
import android.view.View;
public class BookshelfActivity extends AppCompatActivity {

    private List<Book> books;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookshelf);

        books = createDummyBooks(); // 创建一个包含虚拟书籍的列表
        gridView = findViewById(R.id.gridview_books);
        gridView.setAdapter(new BookAdapter(this, books));

        // 处理GridView中的项点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book selectedBook = books.get(position);
                // 启动BookDetailsActivity，并将选中的书籍作为额外数据传递
                Intent intent = new Intent(BookshelfActivity.this, BookDetailsActivity.class);
                intent.putExtra(BookDetailsActivity.EXTRA_BOOK, selectedBook);
                startActivity(intent);
            }
        });

        // 处理"新手引导" TextView 的点击事件
        TextView guideEntryTextView = findViewById(R.id.text_guide_entry);
        guideEntryTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookshelfActivity.this, GuideActivity.class));
            }
        });
    }

    // 创建一个包含虚拟书籍的列表（用于测试）
    private List<Book> createDummyBooks() {
        List<Book> books = new ArrayList<>();
        String bookContent1 = getString(R.string.book_content1); // 获取资源文件中的内容1
        String bookContent2 = getString(R.string.book_content2); // 获取资源文件中的内容2
        String bookContent3 = getString(R.string.book_content3); // 获取资源文件中的内容1
        String bookContent4 = getString(R.string.book_content4); // 获取资源文件中的内容2
        books.add(new Book(R.drawable.hongloumeng_cover, "红楼梦", "曹雪芹", "文学", bookContent1));
        books.add(new Book(R.drawable.sanguoyanyi_cover, "三国演义", "罗贯中", "文学", bookContent2));
        books.add(new Book(R.drawable.shuihuzhuan_cover, "水浒传", "施耐庵", "文学", bookContent3));
        books.add(new Book(R.drawable.xiyouji_cover, "西游记", "罗贯中", "文学", bookContent4));
        // 添加更多书籍，以便测试
        return books;
    }
}
