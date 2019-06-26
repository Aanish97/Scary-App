package com.example.a3_smd;

public class Site {

    String bookName;
    String writerName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public Site(String bookName, String writerName) {
        this.bookName = bookName;
        this.writerName = writerName;
    }
}
