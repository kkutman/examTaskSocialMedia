package peaksoft.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * name : kutman
 **/

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "persons")
@ToString(exclude = {"socialMedia", "cars"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "person")
    private List<Car> cars;
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "people")
    private List<SocialMedia> socialMedia;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Person(String name, int age, List<Car> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }
}
