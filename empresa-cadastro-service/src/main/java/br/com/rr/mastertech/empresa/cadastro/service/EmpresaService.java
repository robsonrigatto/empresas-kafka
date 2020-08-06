package br.com.rr.mastertech.empresa.cadastro.service;

import br.com.rr.mastertech.empresa.cadastro.domain.Empresa;
import br.com.rr.mastertech.empresa.cadastro.dto.request.CriarEmpresaRequest;
import br.com.rr.mastertech.empresa.cadastro.dto.response.EmpresaResponse;
import br.com.rr.mastertech.empresa.cadastro.mapper.EmpresaMapper;
import br.com.rr.mastertech.empresa.cadastro.producer.ReceitaProducer;
import br.com.rr.mastertech.empresa.cadastro.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private EmpresaMapper mapper;

    @Autowired
    private ReceitaProducer receitaProducer;

    @Transactional
    public EmpresaResponse create(CriarEmpresaRequest request) {
        Empresa empresa = mapper.toEmpresa(request);
        empresa = repository.save(empresa);

        receitaProducer.send(empresa.getCnpj());
        return mapper.toEmpresaResponse(empresa);
    }
}
