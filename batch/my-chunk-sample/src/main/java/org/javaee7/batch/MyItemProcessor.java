package org.javaee7.batch;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Named
public class MyItemProcessor implements ItemProcessor {

    @Override
    public MyOutputWriter processItem(Object t) {
        System.out.println("processItem: " + t);
        return (((MyInputReader) t).getId() % 2 == 0) ? null : new MyOutputWriter(((MyInputReader) t).getId() * 2);
    }

}
