package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{
    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track) {
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int id) {
        trackRepository.deleteById(id);
        return true;
    }

    @Override
    public ResponseEntity<Object> updateTrack(Track track,int id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (!trackOptional.isPresent())
            return ResponseEntity.notFound().build();
        track.setTrackId(id);
        trackRepository.save(track);
        return ResponseEntity.noContent().build();
    }

    @Override
    public Optional<Track> getTrackById(int id) {

        if(trackRepository.existsById(id))
        {
            return trackRepository.findById(id);
        }
        return null;
    }

    @Override
    public List<Track> findByName(String name) {
//        List<Track> tracks = (ResponseEntity<ArrayList<Track>>) trackRepository.findByName(name);
        return trackRepository.findByName(name);
    }
}