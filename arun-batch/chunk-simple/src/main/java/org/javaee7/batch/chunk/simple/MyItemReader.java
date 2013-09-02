package org.javaee7.batch.chunk.simple;

import java.io.Serializable;
import java.util.StringTokenizer;
import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

/**
 * @author Arun Gupta
 */
@Named
public class MyItemReader extends AbstractItemReader {
    
    private StringTokenizer tokens;
    
    
    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("Open is invoked");
        tokens = new StringTokenizer("1,2,3,4,5,6,7,8,9,10", ",");
    }
    
    @Override
    public MyInputRecord readItem() {
        System.out.println("Read Item is invoked");
        if (tokens.hasMoreTokens()) {
            return new MyInputRecord(Integer.valueOf(tokens.nextToken()));
        }
        return null;
    }
}
