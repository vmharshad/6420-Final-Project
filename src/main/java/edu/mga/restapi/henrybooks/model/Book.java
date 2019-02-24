package edu.mga.restapi.henrybooks.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue
    Integer id;
    String author;
    String title;
    String description;
    String thumbnailUrl;
    Double price;

}
