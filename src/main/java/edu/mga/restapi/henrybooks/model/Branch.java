package edu.mga.restapi.henrybooks.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
public class Branch {
    @Id
    @GeneratedValue
    Integer id;
    String branchName;
    String address;
    String city;
    String state;
    String zip;
    String phone;

}
