package peaksoft.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * name : kutman
 **/

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cars")
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Person person;

    public Car(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Car(String name, String country, Person person) {
        this.name = name;
        this.country = country;
        this.person = person;
    }
}
