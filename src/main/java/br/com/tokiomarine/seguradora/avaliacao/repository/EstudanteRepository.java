package br.com.tokiomarine.seguradora.avaliacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

@Repository
@Transactional
public interface EstudanteRepository extends CrudRepository<Estudante, Long>{

}
