package com.sumit.springai.web.dto;

public class BookRequest {

    private String title;
    private String description;
    private String genre;
    private int totalChapters;
    private int wordsPerChapter;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTotalChapters() {
        return totalChapters;
    }

    public void setTotalChapters(int totalChapters) {
        this.totalChapters = totalChapters;
    }

    public int getWordsPerChapter() {
        return wordsPerChapter;
    }

    public void setWordsPerChapter(int wordsPerChapter) {
        this.wordsPerChapter = wordsPerChapter;
    }
}
