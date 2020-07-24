package au.com.skoolbag.controller;

import au.com.skoolbag.entity.Student;
import au.com.skoolbag.repository.StudentRepository;
import au.com.skoolbag.util.constant.CommonConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Student controller.
 */
@CrossOrigin
@RestController
@RequestMapping(CommonConstant.API + CommonConstant.V1 + "/students")
@Api(tags = "Student", description = "Students Related Operations.")
public class StudentController {

    private static final Logger LOGGER = LogManager.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Gets students.
     *
     * @return the students
     */
    @ApiOperation(value = "Get All Students", notes = "Get All Students", response = Student.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> all() {
        LOGGER.debug("Get all students service invoked.");
        return studentRepository.findAll();
    }

    /**
     * Gets student count by school id.
     *
     * @param schoolId the school id
     * @return the student count by school id
     */
    @ApiOperation(value = "Get Students Count By School Id", notes = "Get Students Count By School Id", response = Long.class, responseContainer = "Long")
    @RequestMapping(value = "/countBySchoolId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long getStudentCountBySchoolId(@RequestParam long schoolId) {
        LOGGER.debug("getStudentCountBySchoolId service invoked. schoolId: {} ", schoolId);
        return studentRepository.countBySchoolId(schoolId);
    }
}
