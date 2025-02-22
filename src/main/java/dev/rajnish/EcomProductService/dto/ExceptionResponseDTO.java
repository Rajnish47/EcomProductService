package dev.rajnish.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDTO {

    String message;
    int code;

    public ExceptionResponseDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }    
}
