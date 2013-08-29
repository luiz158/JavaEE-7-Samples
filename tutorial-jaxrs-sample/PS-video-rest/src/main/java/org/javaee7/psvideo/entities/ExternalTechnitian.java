/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.psvideo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Masud
 */
@Entity
@Table(name = "external_technitian", catalog = "pcstore", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExternalTechnitian.findAll", query = "SELECT e FROM ExternalTechnitian e"),
    @NamedQuery(name = "ExternalTechnitian.findById", query = "SELECT e FROM ExternalTechnitian e WHERE e.id = :id"),
    @NamedQuery(name = "ExternalTechnitian.findByCountry", query = "SELECT e FROM ExternalTechnitian e WHERE e.country = :country"),
    @NamedQuery(name = "ExternalTechnitian.findByVigitingFee", query = "SELECT e FROM ExternalTechnitian e WHERE e.vigitingFee = :vigitingFee"),
    @NamedQuery(name = "ExternalTechnitian.findByVigitingDate", query = "SELECT e FROM ExternalTechnitian e WHERE e.vigitingDate = :vigitingDate")})
public class ExternalTechnitian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Column(name = "vigiting_fee")
    private Integer vigitingFee;
    @Column(name = "vigiting_date")
    @Temporal(TemporalType.DATE)
    private Date vigitingDate;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Technitian technitian;

    public ExternalTechnitian() {
    }

    public ExternalTechnitian(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getVigitingFee() {
        return vigitingFee;
    }

    public void setVigitingFee(Integer vigitingFee) {
        this.vigitingFee = vigitingFee;
    }

    public Date getVigitingDate() {
        return vigitingDate;
    }

    public void setVigitingDate(Date vigitingDate) {
        this.vigitingDate = vigitingDate;
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
        if (!(object instanceof ExternalTechnitian)) {
            return false;
        }
        ExternalTechnitian other = (ExternalTechnitian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.javaee7.psvideo.entities.ExternalTechnitian[ id=" + id + " ]";
    }
    
}
