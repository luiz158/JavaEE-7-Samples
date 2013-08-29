package org.javaee7.psvideo.sessions; 

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.javaee7.psvideo.entities.Student;

@Singleton
@DependsOn("CountryCodeEJB")
@Startup
public class TestBean {
    @Inject
    StatelessSessionBean ssb;
    @PostConstruct
    public void init(){
        System.out.println("Test bean has been initialized");
//        System.out.println(ssb.sayHello("Masud"));
//        List<Student> students=ssb.getAllStudents();
//        for (Student student : students) {
//            System.out.println(student.getName()); 
//        }
        ssb.create("Rasel");
    }
}
