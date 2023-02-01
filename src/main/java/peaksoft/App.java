package peaksoft;

import peaksoft.classes.Car;
import peaksoft.classes.Person;
import peaksoft.classes.SocialMedia;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.car.CarDao;
import peaksoft.dao.car.CarDaoImpl;
import peaksoft.dao.person.PersonDao;
import peaksoft.dao.person.PersonDaoImpl;
import peaksoft.dao.socialMedia.MediaDaoImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        HibernateConfig.getEntity();
        Scanner scanner = new Scanner(System.in);
        PersonDao personDao = new PersonDaoImpl();
        CarDao carDao = new CarDaoImpl();
        MediaDaoImpl mediaDao = new MediaDaoImpl();

        while (true){
            System.out.println("""
                    нажмите 1 чтобы создать PERSON
                    нажмите 2 чтобы создать СAR без влдельца
                    нажмите 3 чтобы SOCIAL MEDIA
                    нажмите 4 чтобы создать СAR  влдельcom
                    нажмите 5 get bi id person
                    нажмите 6 get all person
                    нажмите 7 delete bi id person 
                    нажмите 8 update person by id
                    нажмите 9 getCarByPersonId
                    нажмите 10 get all cars 
                    нажмите 11 update car 
                    нажмите 12 delete by name car
                    нажмите 13 getSocialMediaByPersonName
                    нажмите 14 delete by id social media 
                    нажмите 15 get all social media  
                    нажмите 16 привязать social media и person 
                    """);
            System.out.println("нажми : ");
            switch (new Scanner(System.in).nextInt()){
                case 1:
                    String d = scanner.nextLine();
                    System.out.print("name : ");
                    String name = scanner.nextLine();
                    System.out.print("age : ");
                    int age = scanner.nextInt();
                    System.out.println(personDao.save(new Person(name, age)));
                    break;
                case 2:
                    String s = scanner.nextLine();
                    System.out.print("name : ");
                    String carName = scanner.nextLine();
                    System.out.print("country : ");
                    String country = scanner.nextLine();
                    System.out.println(carDao.save(new Car(carName, country)));
                    break;
                case 3:
                    System.out.print("name : ");
                    System.out.println(mediaDao.save(new SocialMedia(scanner.nextLine())));
                    break;
                case 4:
                    System.out.print("person id : ");
                    long personId = scanner.nextLong();
                    String sd = scanner.nextLine();
                    System.out.print("name : ");
                    String carName2 = scanner.nextLine();
                    System.out.print("country : ");
                    String country2 = scanner.nextLine();
                    System.out.println(personDao.saveCarByPersonId(personId, new Car(carName2, country2)));
                    break;
                case 5:
                    System.out.print("person id : ");
                    System.out.println(personDao.getById(scanner.nextLong()));
                    break;
                case 6:
                    personDao.getAll().forEach(System.out::println);
                    break;
                case 7:
                    System.out.print("person id : ");
                    System.out.println(personDao.deleteById(scanner.nextLong()));
                    break;
                case 8:
                    System.out.print("person id : ");
                    long personId2 = scanner.nextLong();
                    String df = scanner.nextLine();
                    System.out.print("name : ");
                    String named = scanner.nextLine();
                    System.out.print("age : ");
                    int aged = scanner.nextInt();
                    System.out.println(personDao.update(personId2, new Person(named, aged)));
                    break;
                case 9:
                    System.out.print("person id : ");
                    long ids = scanner.nextLong();
                    System.out.println(carDao.getCarByPersonId(ids));
                    break;
                case 10:
                    carDao.getAllCars().forEach(System.out::println);
                    break;
                case 11:
                    System.out.print("car id : ");
                    long carID = scanner.nextLong();
                    String sdd= scanner.nextLine();
                    System.out.print("name : ");
                    String carName3 = scanner.nextLine();
                    System.out.print("country : ");
                    String country3 = scanner.nextLine();
                    System.out.println(carDao.update(carID, new Car(carName3, country3)));
                    break;
                case 12:
                    System.out.print("name : ");
                    System.out.println(carDao.deleteByName(scanner.nextLine()));
                    break;
                case 13:
                    System.out.print("name : ");
                    System.out.println(mediaDao.getSocialMediaByPersonName(scanner.nextLine()));
                    break;
                case 14:
                    System.out.print("id : ");
                    System.out.println(mediaDao.deleteById(scanner.nextLong()));
                    break;
                case 15:
                    mediaDao.getAllSocialMediaSortByNameByDesc().forEach(System.out::println);
                    break;
                case 16:
                    System.out.print("person id : ");
                    Long person = scanner.nextLong();
                    System.out.print("media id : ");
                    Long social  =scanner.nextLong();
                    System.out.println(mediaDao.addPersonVSocialMediaByID(social, person));
                    break;


            }
        }


    }
}
