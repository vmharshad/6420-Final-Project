package edu.mga.restapi.henrybooks.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode

@Embeddable
public class InventoryId implements Serializable {
    @Column(name = "book_id")
    Integer bookId;

    @Column(name = "branch_id")
    Integer branchId;
}
