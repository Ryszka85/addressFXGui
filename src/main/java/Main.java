import databaseUtil.DAOModel.AddressDAO;
import databaseUtil.DAOModel.PersonDAO;
import datamodel.Address;
import datamodel.Country;
import datamodel.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Date;

public class Main extends Application {
    /*private static final SessionFactory ourSessionFactory;*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/mainGui.fxml"));
        primaryStage.setTitle("Test");

        final Scene scene = new Scene(root, 700, 600);
        scene.getStylesheets().add("css/testing.css");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    /*static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure()
                    .addAnnotatedClass(Person.class);
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }*/

    public static void main(String[] args) {
       // final Session session = getSession();
        try {


            /*Date utilDate = new Date();
            Person person = new Person(
                    "Zeck",
                    "Buum",
                    new java.sql.Date(utilDate.getTime())
            );
            PersonDAO personDAO = new PersonDAO();
            personDAO.save(person);
            Address address = new Address("Foopak 33", "3344", "Bldld", person, new Country("AUT", "Austria"));

            AddressDAO addressDAO = new AddressDAO();
            addressDAO.save(address);*/


           /* Date utilDate = new Date();
            Person person = new Person(
                    "Hugo",
                    "platzer",
                    new java.sql.Date(utilDate.getTime())
            );

            GUIPerson guiPerson = new GUIPerson(person);
            PropertyChangeListener p = evt -> System.out.println(evt.getNewValue());
            guiPerson.addPropertyChangeListener(p);
            guiPerson.setFirstName("Heinbär");*/

            /*PersonDAO personDAO = new PersonDAO();
            personDAO.selectAll()
                    .get(0)
                    .getAddresses()
                    .forEach(address ->
                            System.out.println(address.getPostal_code() +
                                    " " + address.getCity() +
                                    " " + address.getStreet() +
                                    " " + address.getCountry()
                            )
                    );*/

            /*sbs1.setTest("fuck");
            sbs1.setTest("One");*/
            /*obs.addToListen(obsAble -> System.out.println("seas"));
            obs.setDescription("Milchbubbi");*/
            /*PersonDAO personDAO = new PersonDAO();*/
            /*System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory()
                    .getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                    *//*Person p = (Person) o;
                    System.out.println(p);*//*
                }
            }*/

            launch(args);
        } finally {
            /*session.close();*/
        }
    }
}
