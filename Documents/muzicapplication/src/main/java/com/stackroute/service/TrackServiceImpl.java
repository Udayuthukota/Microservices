package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int id) throws TrackNotFoundException{
        if(!trackRepository.existsById(id)){
            throw new TrackNotFoundException("Track not found");
        }
        trackRepository.deleteById(id);
        return true;
    }

    @Override
    public ResponseEntity<Object> updateTrack(Track track,int id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id)){
            throw new TrackNotFoundException("Track not found");
        }
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (!trackOptional.isPresent())
            return ResponseEntity.notFound().build();
        track.setTrackId(id);
        trackRepository.save(track);
        return ResponseEntity.noContent().build();
    }

    @Override
    public Optional<Track> getTrackById(int id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id)){
            throw new TrackNotFoundException("Track not found");
        }
        if(trackRepository.existsById(id))
        {
            return trackRepository.findById(id);
        }
        return null;
    }

    @Override
    public List<Track> findByName(String name) {
        return trackRepository.findByName(name);
    }
}