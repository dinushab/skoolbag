package au.com.skoolbag.dto.request;

import lombok.Data;

/**
 * The type Address dto.
 */
@Data
public class AddressDTO {

    private String street;
    private String suburb;
    private String postCode;
    private String state;
}
