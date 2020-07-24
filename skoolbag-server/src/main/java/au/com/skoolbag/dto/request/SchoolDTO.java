package au.com.skoolbag.dto.request;

import lombok.Data;

/**
 * The type School dto.
 */
@Data
public class SchoolDTO {

    private String name;
    private AddressDTO address;
    private Integer noOfStudents;
}
