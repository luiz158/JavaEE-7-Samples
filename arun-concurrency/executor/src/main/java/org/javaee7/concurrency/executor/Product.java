package org.javaee7.concurrency.executor;

/**
 * @author Arun Gupta
 */
public class Product {
    private int id;

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
