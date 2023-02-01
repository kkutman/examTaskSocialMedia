package peaksoft.dao.car;

import peaksoft.classes.Car;

import java.util.List;

/**
 * name : kutman
 **/
public interface CarDao {
    String save(Car car);
    List<Car> getCarByPersonId(Long id);
    List<Car> getAllCars();
    String update(Long id,Car car);
    String deleteByName(String name);
}
