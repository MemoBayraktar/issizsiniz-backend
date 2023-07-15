package com.group3.issizsiniz.entity;

import com.group3.issizsiniz.enums.Location;
import com.group3.issizsiniz.enums.Position;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class JobPosts {
    private int post_id;
    private String title;
    private Date datePosted;
    private String description;
    private Location location;
    private Position position;

}
