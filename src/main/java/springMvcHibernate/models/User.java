package springMvcHibernate.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Введите имя")
    @Size(min = 3, max = 12, message = "Размер имени от 3 до 12")
    @Column
    private String name;
    @NotEmpty(message = "Введите фамилию")
    @Size(min = 3, max = 12, message = "Размер фамилии от 3 до 12")
    @Column
    private String surname;
    @Min(value = 7, message = "Количество лет не должно быть меньше 7")
    @Column
    private int age;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
