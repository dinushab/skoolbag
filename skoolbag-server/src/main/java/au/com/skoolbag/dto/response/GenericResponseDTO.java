package au.com.skoolbag.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * The type Generic response dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponseDTO {

    private String status;
    private Date timeStamp;
}
