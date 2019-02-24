package edu.mga.restapi.henrybooks.model;

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
