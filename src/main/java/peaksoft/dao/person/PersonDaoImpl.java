package peaksoft.dao.person;

import jakarta.persistence.EntityManager;
import peaksoft.classes.Car;
import peaksoft.classes.Person;
import peaksoft.config.HibernateConfig;

import java.util.List;

/**
 * name : kutman
 **/
public class PersonDaoImpl implements PersonDao {
    private final EntityManager entityManager = HibernateConfig.getEntity().createEntityManager();
    @Override
    public String save(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        return person.getName()+" сохранен!";
    }

    @Override
    public Person getById(Long id) {
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return person;
    }

    @Override
    public List<Person> getAll() {
        entityManager.getTransaction().begin();
        List<Person> resultList = entityManager.createQuery("select  p from Person p ", Person.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public String deleteById(Long id) {
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return person.getName()+" deleted...";
    }

    @Override
    public String update(Long id, Person person) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Person set name = :name,age = :age where id=:id").
                setParameter("name",person.getName()).
                setParameter("age",person.getAge()).
                setParameter("id",id).
                executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return person.getName()+" update!";
    }

    @Override
    public String saveCarByPersonId(Long id, Car car) {
        entityManager.getTransaction().begin();
        Person person =  entityManager.find(Person.class,id);
        person.setCars(List.of(car));
        car.setPerson(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return person.getName()+" added car"+car.getName();
    }
}
