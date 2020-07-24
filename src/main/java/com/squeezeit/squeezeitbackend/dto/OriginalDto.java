package com.squeezeit.squeezeitbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data transfer object for passing original link in rest response
 * @author Adam Balski
 */
@Data
@AllArgsConstructor
public class OriginalDto {
    private String original;
}