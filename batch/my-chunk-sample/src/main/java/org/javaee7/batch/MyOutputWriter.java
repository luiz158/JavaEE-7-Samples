package org.javaee7.batch;

/**
 *
 * @author Masud
 */
public class MyOutputWriter {
    int id;

    public MyOutputWriter(int id) {
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
