package org.javaee7.batch;

import java.io.Serializable;
import java.util.List;
import java.util.StringTokenizer;
import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Named
public class MyItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List items) throws Exception {
        System.out.println("Item Writer "+items);
    }

}
