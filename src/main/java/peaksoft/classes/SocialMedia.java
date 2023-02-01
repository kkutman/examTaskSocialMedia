package peaksoft.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * name : kutman
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "social_media")
public class SocialMedia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Person> people;

    public SocialMedia(String name) {
        this.name = name;
    }

    public SocialMedia(String name, List<Person> people) {
        this.name = name;
        this.people = people;
    }

    @Override
    public String toString() {
        return "SocialMedia{" +
                "id=" + id +
                ", name='" + name;
    }

}
