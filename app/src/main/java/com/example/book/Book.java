package com.example.book;
import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private int coverResourceId;
    private String name;
    private String author;
    private String category;
    private String content;

    public Book(int coverResourceId, String name, String author, String category, String content) {
        this.coverResourceId = coverResourceId;
        this.name = name;
        this.author = author;
        this.category = category;
        this.content = content;
    }

    protected Book(Parcel in) {
        coverResourceId = in.readInt();
        name = in.readString();
        author = in.readString();
        category = in.readString();
        content = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public int getCoverResourceId() {
        return coverResourceId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(coverResourceId);
        dest.writeString(name);
        dest.writeString(author);
        dest.writeString(category);
        dest.writeString(content);
    }
}
