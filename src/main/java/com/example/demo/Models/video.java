package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;
@Document("videos")
public class video {
        @Indexed
        @Id
        private String id ;
        private String title;
        private InputStream stream;

    public video() {
    }

    public video(String title, InputStream stream) {
        this.title = title;
        this.stream = stream;
    }

    public String getTitle() {
        return title;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }
}
