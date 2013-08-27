/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.books.begjee7.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author Masud
 */
@Entity
public class News implements Serializable{

    @EmbeddedId
    private NewsId id;
    private String content;

    public NewsId getId() {
        return id;
    }

    public void setId(NewsId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
