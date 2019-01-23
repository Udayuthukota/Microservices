package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
    @Query("select t from Track t where t.trackName =?1")
    List<Track> findByName(String Name);
}