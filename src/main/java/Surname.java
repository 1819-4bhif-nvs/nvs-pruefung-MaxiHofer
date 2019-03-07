
import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Surname.findAll", query = "select s from Surname s")
public class Surname implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Gender gender;
    private String firstName;

    public Surname() {
    }

    public Surname(String firstName,Gender gender) {
        this.firstName = firstName;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
