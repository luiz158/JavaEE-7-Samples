/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.psvideo.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Masud
 */
@Entity
@Table(name = "group", catalog = "pcstore", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Group1.findAll", query = "SELECT g FROM Group1 g"),
    @NamedQuery(name = "Group1.findByGroupname", query = "SELECT g FROM Group1 g WHERE g.group1PK.groupname = :groupname"),
    @NamedQuery(name = "Group1.findByUserId", query = "SELECT g FROM Group1 g WHERE g.group1PK.userId = :userId")})
public class Group1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Group1PK group1PK;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Group1() {
    }

    public Group1(Group1PK group1PK) {
        this.group1PK = group1PK;
    }

    public Group1(String groupname, int userId) {
        this.group1PK = new Group1PK(groupname, userId);
    }

    public Group1PK getGroup1PK() {
        return group1PK;
    }

    public void setGroup1PK(Group1PK group1PK) {
        this.group1PK = group1PK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (group1PK != null ? group1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Group1)) {
            return false;
        }
        Group1 other = (Group1) object;
        if ((this.group1PK == null && other.group1PK != null) || (this.group1PK != null && !this.group1PK.equals(other.group1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.javaee7.psvideo.entities.Group1[ group1PK=" + group1PK + " ]";
    }
    
}
