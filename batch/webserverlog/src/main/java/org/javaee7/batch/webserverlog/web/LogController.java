package org.javaee7.batch.webserverlog.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Named
@SessionScoped
public class LogController implements Serializable {
   
    private JobOperator jobOperator;
    private long execId;
    private String logData;
    public String getLogData() {

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream is = cl.getResourceAsStream("logs.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer output = new StringBuffer();
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                output.append(line).append('\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return output.toString();
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }
   

    public String jobStart() {
        jobOperator=BatchRuntime.getJobOperator();
        execId = jobOperator.start("webserverlog", null);
        System.out.println(execId);
        return "jobStarted";
    }
}
