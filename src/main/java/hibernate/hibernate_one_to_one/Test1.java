package hibernate.hibernate_one_to_one;

import hibernate.hibernate_one_to_one.entity.Detail;
import hibernate.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employee emp = new Employee("Andrey", "Guselnikov",
                    "IT", 500);
            Detail detail = new Detail("Moskow", "8006001366",
                    "guselnikov@mail.com");

            emp.setEmpDetail(detail);

            session.beginTransaction();

            session.save(emp);

            session.getTransaction().commit();
            System.out.println("done!");

//            Session session = factory.getCurrentSession();
//            Employee emp = new Employee("Oleg", "Smirnov",
//                    "Sales", 700);
//            Detail detail = new Detail("Baku", "9784505090",
//                    "smirnov@gmail.com");
//
//            emp.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(emp);
//
//            session.getTransaction().commit();
//            System.out.println("done!");

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 2);
//            session.delete(emp);
//            session.getTransaction().commit();
//            System.out.println("done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
