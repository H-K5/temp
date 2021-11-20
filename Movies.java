package com.example.movieapimpr6;

public class Movies {
    private String title;
    private String description;
    private String publishedAt;
    private String urlToImage;

    public Movies(String title, String description, String publishedAt, String urlToImage) {
        this.title = title;
        this.description = description;
        this.publishedAt = publishedAt;
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
