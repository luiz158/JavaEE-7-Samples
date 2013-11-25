
package org.javaee7.components.model;

/**
 *
 * @author Masudul Haque
 */
public class User {
  private String name;
  private double price;
  private String photoURI;

    public User(String name, double price, String photoURI) {
        this.name = name;
        this.price = price;
        this.photoURI = photoURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhotoURI() {
        return photoURI;
    }

    public void setPhotoURI(String photoURI) {
        this.photoURI = photoURI;
    }
  
}
