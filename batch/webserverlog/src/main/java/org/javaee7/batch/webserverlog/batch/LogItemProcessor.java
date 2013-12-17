package org.javaee7.batch.webserverlog.batch;

import java.io.Serializable;
import javax.batch.api.chunk.ItemProcessor;
import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Dependent
@Named
public class LogItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        System.out.println("ItemProcessor processItem");
        Long res = 1L;
        Integer input = (Integer) item;
        for (int i = 1; i <= input; i++) {
            res *= i;
        }
        return res;
    }

}
