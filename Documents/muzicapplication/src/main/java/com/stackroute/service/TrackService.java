package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService implements ITrackService {

    @Autowired
    private TrackRepository repository;

    @Override
    public List<Track> findByName(String name) {
        List<Track> tracks = (List<Track>) repository.findByName(name);
        return tracks;
    }
}