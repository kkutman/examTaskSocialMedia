package peaksoft.dao.car;

import jakarta.persistence.EntityManager;
import peaksoft.classes.Car;
import peaksoft.classes.Person;
import peaksoft.config.HibernateConfig;

import java.util.List;

/**
 * name : kutman
 **/
public class CarDaoImpl implements CarDao{
    private final EntityManager entityManager = HibernateConfig.getEntity().createEntityManager();
    @Override
    public String save(Car car) {
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
        return car.getName()+" сохранен!";
    }

    @Override
    public List<Car> getCarByPersonId(Long id) {
        entityManager.getTransaction().begin();
        List<Car> id1 = entityManager.createQuery("select c from Car c join Person p on p.id = c.id " +
                        "where p.id = :id",Car.class).
                setParameter("id", id).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public List<Car> getAllCars() {
        entityManager.getTransaction().begin();
        List<Car> c = entityManager.createQuery("select c from Car c", Car.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return c;
    }

    @Override
    public String update(Long id, Car car) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Car set name = :name,country = :age where id = :id")
                .setParameter("name", car.getName())
                .setParameter("id", id).
                setParameter("age", car.getCountry()).executeUpdate();
        entityManager.getTransaction().commit();
        return "update";
    }

    @Override
    public String deleteByName(String name) {
        entityManager.getTransaction().begin();
        List<Car> resultList = entityManager.createQuery("select c from Car c where c.name=?1", Car.class).setParameter(1, name).getResultList();
        Car car = resultList.get(0);
        entityManager.remove(car);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "delete";
    }
}
