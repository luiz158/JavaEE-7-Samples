/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.bvjsftest.web.util;

import java.net.MalformedURLException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Masudul Haque
 */
public class URLValidator implements ConstraintValidator<Url, String> {

    private String protocol;
    private String host;
    private int port;

    @Override
    public void initialize(Url url) {
        this.protocol = url.protocol();
        this.host = url.host();
        this.port = url.port();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() == 0) {
            return true;
        }

        java.net.URL url;
        try {
            // Transforms it to a java.net.URL to see if it has a valid format
            url = new java.net.URL(value);
        } catch (MalformedURLException e) {
            return false;
        }
        // Checks if the protocol attribute has a valid value
        if (protocol != null && protocol.length() > 0 && !url.getProtocol().equals(protocol)) {
            return false;
        }
        if (host != null && host.length() > 0 && !url.getHost().startsWith(host)) {
            return false;
        }
        if (port != -1 && url.getPort() != port) {
            return false;
        }
        return true;
    }

}
