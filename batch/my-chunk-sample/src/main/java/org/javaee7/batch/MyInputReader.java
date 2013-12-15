package org.javaee7.batch;

import java.io.Serializable;

/**
 *
 * @author Masud
 */
public class MyInputReader implements Serializable{
    int id;

    public MyInputReader() {
    }

    public MyInputReader(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "My Input Reader "+id; //To change body of generated methods, choose Tools | Templates.
    }
    
}
