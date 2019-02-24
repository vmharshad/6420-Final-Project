package edu.mga.restapi.henrybooks.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"branch_id", "book_id"})
})
public class Inventory {
    @Id
    @GeneratedValue
    Integer id;

    @ManyToOne
    Branch branch;

    @ManyToOne
    Book book;

    Integer quantity;
}
