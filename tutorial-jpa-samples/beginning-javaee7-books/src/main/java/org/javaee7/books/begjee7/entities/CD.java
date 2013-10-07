/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.books.begjee7.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;

/**
 *
 * @author Masud
 */
@Entity
public class CD implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Float price;
    private String description;
    @Lob
    private byte[] cover;
    @ElementCollection
    @CollectionTable(name = "credit_card")
    @MapKeyColumn(name = "card")
    @Column(name = "title")
    private Map<CreditCardType, Boolean> tracks = new HashMap<>();

    @ManyToMany(mappedBy = "appearsOnCDs")
    private List<Artist> createdByArtists;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public Map<CreditCardType, Boolean> getTracks() {
        return tracks;
    }

    public void setTracks(Map<CreditCardType, Boolean> tracks) {
        this.tracks = tracks;
    }

 

 

    public List<Artist> getCreatedByArtists() {
        return createdByArtists;
    }

    public void setCreatedByArtists(List<Artist> createdByArtists) {
        this.createdByArtists = createdByArtists;
    }
    
    

}
