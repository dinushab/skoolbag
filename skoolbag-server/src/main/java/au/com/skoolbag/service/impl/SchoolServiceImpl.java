package au.com.skoolbag.service.impl;

import au.com.skoolbag.dto.request.SchoolDTO;
import au.com.skoolbag.entity.School;
import au.com.skoolbag.repository.SchoolRepository;
import au.com.skoolbag.service.SchoolService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type School service implementation.
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    private static final Logger LOGGER = LogManager.getLogger(SchoolServiceImpl.class);

    @Autowired
    private SchoolRepository schoolRepository = null;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<School> getAllSchools() {
        LOGGER.debug("Fetching schools.");
        return schoolRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<School> getFilteredSchools(String schoolName, String address) {
        LOGGER.debug("Filtering. schoolName: {} address: {} ", schoolName, address);
        boolean isSchoolNameProvided = schoolName != null & !schoolName.isEmpty();
        boolean isAddressProvided = address != null & !address.isEmpty();
        LOGGER.debug("isSchoolNameProvided: {} isAddressProvided: {} ", isSchoolNameProvided, isAddressProvided);
        List schools = null;
        if (isSchoolNameProvided && isAddressProvided) {
            schools = schoolRepository.findByName(schoolName, address);
        } else if (isSchoolNameProvided) {
            schools = schoolRepository.findByName(schoolName);
        } else if (isAddressProvided) {
            schools = schoolRepository.findByAddress(address);
        }
        return schools;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean persistSchool(SchoolDTO schoolDTO) {
        LOGGER.debug("Persisting school.");
        boolean state = false;
        try {
            ModelMapper modelMapper = new ModelMapper();
            School school = modelMapper.map(schoolDTO, School.class);
            school.getAddress().setSchool(school);
            schoolRepository.save(school);
            state = true;
        } catch (Exception e) {
            LOGGER.error("Exception occurred while persisting.", e);
        }
        return state;
    }
}