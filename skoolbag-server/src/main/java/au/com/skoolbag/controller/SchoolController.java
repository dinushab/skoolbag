package au.com.skoolbag.controller;

import au.com.skoolbag.dto.request.SchoolDTO;
import au.com.skoolbag.dto.response.GenericResponseDTO;
import au.com.skoolbag.entity.School;
import au.com.skoolbag.service.SchoolService;
import au.com.skoolbag.util.constant.CommonConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * The type School controller.
 */
@CrossOrigin
@RestController
@RequestMapping(CommonConstant.API + CommonConstant.V1 + "/schools")
@Api(tags = "School",  description = "School Related Operations.")
public class SchoolController {

    private static final Logger LOGGER = LogManager.getLogger(SchoolController.class);

    @Autowired
    private SchoolService schoolService;

    /**
     * Gets schools.
     *
     * @return the schools
     */
    @ApiOperation(value = "Get All Schools", notes = "Get All Schools",
            response = School.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<School> all() {
        LOGGER.debug("Get all schools service invoked.");
        return schoolService.getAllSchools();
    }

    /**
     * Filter list.
     *
     * @param schoolName the school name
     * @param address    the address
     * @return the list
     */
    @ApiOperation(value = "Search By School Name & Address", notes = "Search By School Name & Address",
            response = School.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "search")
    public List<School> search(@RequestParam String schoolName, @RequestParam String address) {
        LOGGER.debug("Filter schools service invoked.");
        return schoolService.getFilteredSchools(schoolName, address);
    }

    /**
     * Persist school generic response dto.
     *
     * @param schoolDTO the school dto
     * @return the generic response dto
     */
    @ApiOperation(value = "Add New School", notes = "Add New School",
            response = GenericResponseDTO.class, responseContainer = "Object")
    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponseDTO newSchool(@RequestBody SchoolDTO schoolDTO) {
        LOGGER.debug("Persist school service invoked.");
        GenericResponseDTO response = new GenericResponseDTO("FAILED", new Date());
        boolean state = schoolService.persistSchool(schoolDTO);
        if (state) {
            response.setStatus("SUCCESS");
        }
        return response;
    }
}