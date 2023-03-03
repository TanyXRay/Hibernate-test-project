import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.home.chernyadieva.model.Person;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

      //  try {
      //      session.beginTransaction();
      //      Person person = session.get(Person.class, 25666);
      //      System.out.println(person);
      //      session.getTransaction().commit();
      //  } finally {
      //      sessionFactory.close();
      //  }

        try {
            session.beginTransaction();
            List<Person> list = new ArrayList<>(List.of(new Person("Tom", 35),
                    new Person("Bob",15),
                    new Person("Silvy", 26)));

            list.forEach(session::persist);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
