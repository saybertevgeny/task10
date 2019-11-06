package ru.lanit.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "flat")
    private String flat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Person person;

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getHouse() {
        return house;
    }

    public Address setHouse(String house) {
        this.house = house;
        return this;
    }

    public String getFlat() {
        return flat;
    }

    public Address setFlat(String flat) {
        this.flat = flat;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Address setPerson(Person person) {
        this.person = person;
        return this;
    }
}
