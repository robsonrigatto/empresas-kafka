package br.com.rr.mastertech.empresa.cadastro.controller;

import br.com.rr.mastertech.empresa.cadastro.dto.request.CriarEmpresaRequest;
import br.com.rr.mastertech.empresa.cadastro.dto.response.EmpresaResponse;
import br.com.rr.mastertech.empresa.cadastro.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @PostMapping
    public ResponseEntity<EmpresaResponse> create(@RequestBody CriarEmpresaRequest request) {
        EmpresaResponse response = service.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
