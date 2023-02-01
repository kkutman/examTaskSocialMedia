package peaksoft.dao.person;

import peaksoft.classes.Car;
import peaksoft.classes.Person;

import java.util.List;

/**
 * name : kutman
 **/
public interface PersonDao {
    String save(Person person);
    Person getById(Long id);
    List<Person> getAll();
    String deleteById(Long id);
    String update(Long id,Person person);
    String saveCarByPersonId(Long id, Car car);
}
