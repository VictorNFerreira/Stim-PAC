package br.cefetrj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.cefetrj.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>, JpaSpecificationExecutor<Conta>
{
    
}
