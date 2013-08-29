/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.psvideo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Masud
 */
@Entity
@Table(name = "technitian", catalog = "pcstore", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Technitian.findAll", query = "SELECT t FROM Technitian t"),
    @NamedQuery(name = "Technitian.findById", query = "SELECT t FROM Technitian t WHERE t.id = :id"),
    @NamedQuery(name = "Technitian.findByName", query = "SELECT t FROM Technitian t WHERE t.name = :name"),
    @NamedQuery(name = "Technitian.findByQualification", query = "SELECT t FROM Technitian t WHERE t.qualification = :qualification")})
public class Technitian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "qualification")
    private String qualification;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "technitian")
    private ExternalTechnitian externalTechnitian;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "technitian")
    private InternalTechnitian internalTechnitian;

    public Technitian() {
    }

    public Technitian(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public ExternalTechnitian getExternalTechnitian() {
        return externalTechnitian;
    }

    public void setExternalTechnitian(ExternalTechnitian externalTechnitian) {
        this.externalTechnitian = externalTechnitian;
    }

    public InternalTechnitian getInternalTechnitian() {
        return internalTechnitian;
    }

    public void setInternalTechnitian(InternalTechnitian internalTechnitian) {
        this.internalTechnitian = internalTechnitian;
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
        if (!(object instanceof Technitian)) {
            return false;
        }
        Technitian other = (Technitian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.javaee7.psvideo.entities.Technitian[ id=" + id + " ]";
    }
    
}
