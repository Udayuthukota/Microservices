package com.stackroute.service;

import com.stackroute.domain.Track;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track);
    public List<Track> getAllTrack();
    public boolean deleteTrack(int id);
    public ResponseEntity<Object> updateTrack(Track track, int id);
    public Optional<Track> getTrackById(int id);
    public List<Track> findByName(String name);
}