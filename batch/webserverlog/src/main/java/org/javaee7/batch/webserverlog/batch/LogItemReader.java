package org.javaee7.batch.webserverlog.batch;

import java.io.Serializable;
import java.util.StringTokenizer;
import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Dependent
@Named
public class LogItemReader implements ItemReader{
    private StringTokenizer tokens;
    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("Reader open");
        tokens=new StringTokenizer("5,6,7,23,11,40,22,5,52,22,12,13,9,8,7,6,5,4", ",");
    }

    @Override
    public void close() throws Exception {
    
    System.out.println("Reader close");
    }

    @Override
    public Object readItem() throws Exception {
        System.out.println("Reader readItem");
        while(tokens.hasMoreTokens()){
            return Integer.valueOf(tokens.nextToken());
        }
        return null;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        System.out.println("Reader checkpointInfo");
        return null;
    }

}
