package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {
    @Id
    int id;
    String musicName;
    String composer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getComposer() {
        return composer;
    }

    public Track() {
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Track(int id, String musicName, String composer) {
        this.id = id;
        this.musicName = musicName;
        this.composer = composer;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                ", composer='" + composer + '\'' +
                '}';
    }
}
