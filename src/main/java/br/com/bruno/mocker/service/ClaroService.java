package br.com.bruno.mocker.service;

import br.com.bruno.mocker.controller.response.ClaroResponse;
import br.com.bruno.mocker.enumeration.ClaroEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ClaroService {

    @Autowired
    public LogService logService;

    @Autowired
    public FileService fileService;

    public ResponseEntity<ClaroResponse> mockService(String affClickId, String actionType, String status) throws IOException {
        logService.showLog("affClickId => " + affClickId + "-actionType => " + actionType + "-status => " + status);
        return getJsonReturn(status);
    }

    private ResponseEntity<ClaroResponse> getJsonReturn(String status) throws IOException {
        String path;
        HttpStatus returnCode;
        switch (status) {
            case "200":
                path = ClaroEnum.CLARO_200.local;
                returnCode = HttpStatus.OK;
                break;
            case "400":
                path = ClaroEnum.CLARO_400.local;
                returnCode = HttpStatus.BAD_REQUEST;
                break;
            case "500":
                path = ClaroEnum.CLARO_500.local;
                returnCode = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            default:
                path = ClaroEnum.CLARO_DEFAULT.local;
                returnCode = HttpStatus.NOT_FOUND;
                break;
        }

        String returnFile = fileService.getFileContent(path);

        return new ResponseEntity<ClaroResponse>(ClaroResponse.builder().responseBody(returnFile).httpStatus(returnCode).build(), returnCode);
    }
}
