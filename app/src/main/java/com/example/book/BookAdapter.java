package com.example.book;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class BookAdapter extends BaseAdapter {
    private Context context;
    private List<Book> books;

    public BookAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.bookCoverImageView = convertView.findViewById(R.id.ivBookCover);
            viewHolder.bookTitleTextView = convertView.findViewById(R.id.tvBookTitle);
            viewHolder.authorTextView = convertView.findViewById(R.id.tvAuthor);
            viewHolder.categoryTextView = convertView.findViewById(R.id.tvCategory);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Book book = books.get(position);
        viewHolder.bookCoverImageView.setImageResource(book.getCoverResourceId());
        viewHolder.bookTitleTextView.setText(book.getName());
        viewHolder.authorTextView.setText(book.getAuthor());
        viewHolder.categoryTextView.setText(book.getCategory());

        return convertView;
    }

    private static class ViewHolder {
        ImageView bookCoverImageView;
        TextView bookTitleTextView;
        TextView authorTextView;
        TextView categoryTextView;
    }
}
