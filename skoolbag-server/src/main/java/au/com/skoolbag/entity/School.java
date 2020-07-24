package au.com.skoolbag.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

/**
 * The type School.
 */
@Data
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "noOfStudents")
    private Integer noOfStudents;

    @JsonManagedReference
    @OneToOne(mappedBy = "school", cascade = CascadeType.ALL)
    private Address address = new Address();

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private Set<Student> students = new HashSet<>();
}
