package maven.prac;
import java.io.ObjectInputFilter.Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(configuration.class);
        idea obj = ac.getBean(idea.class);
//        obj.setDatatype(11);
        obj.typeofSim();
        
        Airtel obj1 = ac.getBean(Airtel.class);
//        obj.setDatatype(13);
        obj1.datatypeofSim();
        
        
        
//        sim obj2 = ac.getBean(sim.class);
//        obj2.datatypeofSim();
    }
}

