package au.com.skoolbag.service;

import au.com.skoolbag.dto.request.SchoolDTO;
import au.com.skoolbag.entity.School;

import java.util.List;

/**
 * The interface School service.
 */
public interface SchoolService {

    /**
     * Gets all schools.
     *
     * @return the all schools
     */
    List<School> getAllSchools();

    /**
     * Gets filtered schools.
     *
     * @param schoolName the school name
     * @param address    the address
     * @return the filtered schools
     */
    List<School> getFilteredSchools(String schoolName, String address);

    /**
     * Persist school boolean.
     *
     * @param schoolDTO the school dto
     * @return the boolean
     */
    boolean persistSchool(SchoolDTO schoolDTO);

}
