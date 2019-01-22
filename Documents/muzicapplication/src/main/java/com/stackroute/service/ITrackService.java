package com.stackroute.service;

import com.stackroute.domain.Track;
import java.util.List;

public interface ITrackService {

    public List<Track> findByName(String name);
}