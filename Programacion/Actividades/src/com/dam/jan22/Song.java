package com.dam.jan22;

/*Necesitamos realizar un programa para almacenar una playlist de canciones. De cada
canción se deberá conocer el título, el grupo o solista y la duración en segundos.*/

public class Song {
    private String title;
    private String author;
    private int length;

    public Song(String title, String author, int length) {
        this.title = title;
        this.author = author;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Song [title=" + title + ", author=" + author + ", length=" + length + "]";
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        return true;
    }

    
}
