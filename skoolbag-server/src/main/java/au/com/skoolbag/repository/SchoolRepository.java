package au.com.skoolbag.repository;

import au.com.skoolbag.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface School repository.
 */
@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    @Query("select u from School u where lower(u.name) like lower(concat('%', :name,'%'))")
    List<School> findByName(@Param("name") String name);

    /**
     * Find by address list.
     *
     * @param address the address
     * @return the list
     */
    @Query("select s from School s,Address a where s.address=a and lower(a.street) like lower(concat('%', :address,'%')) or " +
            "lower(a.suburb) like lower(concat('%', :address,'%'))")
    List<School> findByAddress(@Param("address") String address);


    /**
     * Find by name list.
     *
     * @param name    the name
     * @param address the address
     * @return the list
     */
    @Query("select s from School s JOIN s.address a " +
            "where lower(s.name) like lower(concat('%', :name,'%'))  and " +
            "(lower(a.street) like lower(concat('%', :address,'%')) or lower(a.suburb) like lower(concat('%', :address,'%'))) ")
    List<School> findByName(@Param("name") String name, @Param("address") String address);

}