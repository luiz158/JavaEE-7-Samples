package org.javaee7.batch.webserverlog.batch;

import javax.batch.api.listener.JobListener;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Dependent
@Named("InfoJobListener")
public class InfoJobListener implements JobListener{

    @Override
    public void beforeJob() throws Exception {
        System.out.println("Job Started");
    }

    @Override
    public void afterJob() throws Exception {
        System.out.println("Job Finished");
    }

}
