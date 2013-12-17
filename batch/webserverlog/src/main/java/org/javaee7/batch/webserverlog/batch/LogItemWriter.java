package org.javaee7.batch.webserverlog.batch;

import java.io.Serializable;
import java.util.List;
import javax.batch.api.chunk.ItemReader;
import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Dependent
@Named
public class LogItemWriter implements ItemWriter{

    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("ItemWriter open");
    }

    @Override
    public void close() throws Exception {
        System.out.println("ItemWriter close");
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        System.out.println("ItemWriter writes = "+items);
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        System.out.println("ItemWriter checkpointInfo");
        
        return null;
    }

}
