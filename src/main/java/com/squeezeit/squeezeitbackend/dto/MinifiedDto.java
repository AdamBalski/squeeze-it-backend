package com.squeezeit.squeezeitbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data transfer object for passing minified link in rest response
 * @author Adam Balski
 */
@Data
@AllArgsConstructor
public class MinifiedDto {
    String minified;
}
