package br.com.bruno.mocker.controller;

import br.com.bruno.mocker.controller.response.ClaroResponse;
import br.com.bruno.mocker.service.ClaroService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/claro")
public class ClaroController {

    @Autowired
    private ClaroService claroService;

    @ApiOperation(value = "Chamada do serviço Claro para enviar o token/hash", response = ResponseEntity.class)
    @GetMapping({"/{affClickId}&{actionType}&{status}"})
    public ResponseEntity<ClaroResponse> createNotification(@PathVariable String affClickId, @PathVariable String actionType, @PathVariable String status) throws IOException {
        return claroService.mockService(affClickId, actionType, status);
    }
}