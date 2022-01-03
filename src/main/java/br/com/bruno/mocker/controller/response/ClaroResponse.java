package br.com.bruno.mocker.controller.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ClaroResponse {

    private HttpStatus httpStatus;
    private String responseBody;
}
