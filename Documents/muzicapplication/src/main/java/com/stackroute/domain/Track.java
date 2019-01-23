package com.stackroute.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Track {
    @Id
    int trackId;
    String trackName;
    String trackComments;
}
