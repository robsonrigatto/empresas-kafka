package br.com.rr.mastertech.empresa.cadastro.repository;

import br.com.rr.mastertech.empresa.cadastro.domain.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
}
