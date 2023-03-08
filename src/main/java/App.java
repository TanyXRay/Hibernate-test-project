import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.home.chernyadieva.model.Item;
import ru.home.chernyadieva.model.Passport;
import ru.home.chernyadieva.model.Person;

public class App {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //Person person = (Person) session.createQuery("FROM Person WHERE name='Bob'").getSingleResult();
            //List<Person> resultList = session.createQuery("from Person where age > 5").getResultList();
            //List<Person> resultList = session.createQuery("from Person where name LIKE 'B%'").getResultList();
            //---------------------------------------------------------------
            // Person person = session.get(Person.class,2);
            // System.out.println(person);

            //List <Item> items = person.getItems();
            // items.forEach(System.out::println);

            // System.out.println("next next next");

            // Item item = session.get(Item.class, 3);
            // System.out.println(item);

            // Person person1 = item.getOwner();
            // System.out.println(person1);
            //---------------------------------------------------------------
            // Person person = new Person("Test3", 35);

            // person.addItem(new Item("TestItemName11"));
            // person.addItem(new Item("TestItemName12"));
            // person.addItem(new Item("TestItemName13"));

            // session.persist(person);
            //session.save(person); // деприкат!
            //---------------------------------------------------------------
          Person person = new Person("Test888", 42);
          Passport passport = new Passport(145237);

          person.setPassport(passport);
          session.persist(person);

         //Person person = session.get(Person.class, 14);
        // session.remove(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
