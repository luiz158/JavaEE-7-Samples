package org.javaee7.batch;

import java.io.Serializable;
import java.util.StringTokenizer;
import javax.batch.api.chunk.ItemReader;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Named("myReader2")
public class MyItemReader implements ItemReader{

    StringTokenizer st;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("Open the Item Reader");
        st = new StringTokenizer("1,2,3,54,6,7,8,23,78,8,4,3,2", ",");
    }

    @Override
    public MyInputReader readItem() throws Exception {

        System.out.println("Read Item is called");
        while (st.hasMoreTokens()) {
            return new MyInputReader(Integer.valueOf(st.nextToken()));
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return new MyInputReader();
    }

}
