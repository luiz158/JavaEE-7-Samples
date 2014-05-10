package org.javaee7.tutorial.jsf;

import java.io.Serializable;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named
@SessionScoped
public class UserNumberBean implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    private int minimum = 0;
    private int maximum = 10;
    private Integer guessNumber = null;
    private Integer randInt = null;
    private String response;

    public UserNumberBean() {
        Random rand = new Random();
        randInt = rand.nextInt(maximum + 1);
    }

    public String getResponse() {
        if (guessNumber == null || !guessNumber.equals(randInt)) {
            return "Sorry, your guess is not correct";
        } else {
            return "Yes ! I got it";
        }
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public Integer getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(Integer guessNumber) {
        this.guessNumber = guessNumber;
    }

    public Integer getRandInt() {
        return randInt;
    }

    public void setRandInt(Integer randInt) {
        this.randInt = randInt;
    }

}
