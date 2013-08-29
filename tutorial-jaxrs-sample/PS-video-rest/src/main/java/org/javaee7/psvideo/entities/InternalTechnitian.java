/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.psvideo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Masud
 */
@Entity
@Table(name = "internal_technitian", catalog = "pcstore", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InternalTechnitian.findAll", query = "SELECT i FROM InternalTechnitian i"),
    @NamedQuery(name = "InternalTechnitian.findById", query = "SELECT i FROM InternalTechnitian i WHERE i.id = :id"),
    @NamedQuery(name = "InternalTechnitian.findBySalary", query = "SELECT i FROM InternalTechnitian i WHERE i.salary = :salary")})
public class InternalTechnitian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "salary")
    private Integer salary;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Technitian technitian;

    public InternalTechnitian() {
    }

    public InternalTechnitian(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Technitian getTechnitian() {
        return technitian;
    }

    public void setTechnitian(Technitian technitian) {
        this.technitian = technitian;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InternalTechnitian)) {
            return false;
        }
        InternalTechnitian other = (InternalTechnitian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.javaee7.psvideo.entities.InternalTechnitian[ id=" + id + " ]";
    }
    
}
