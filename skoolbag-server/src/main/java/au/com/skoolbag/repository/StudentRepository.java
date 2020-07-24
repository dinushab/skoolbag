package au.com.skoolbag.repository;

import au.com.skoolbag.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Student repository.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     * Count by school id long.
     *
     * @param schoolId the school id
     * @return the long
     */
    Long countBySchoolId(long schoolId);

}
