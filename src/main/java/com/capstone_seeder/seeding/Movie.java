package com.capstone_seeder.seeding;


import javax.persistence.*;

@Entity
@Table(name= "movies")
public class Movie {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "overview", columnDefinition = "TEXT")
    private String overview;
    @Column(name = "title")
    private String title;
    @Column(name = "poster_path")
    private String posterPath;
    @Column(name = "backdrop_path")
    private String backdropPath;
    @Column(name = "release_date")
    private String releaseDate;

    public Movie(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", overview='" + overview + '\'' +
                ", title='" + title + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
