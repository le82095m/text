package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Date date;
    private Integer viewCount;
    private Integer user_id;

}
