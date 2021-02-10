package com.example.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.restful.model.ProdutorVencedor;
import com.example.restful.to.ProdutorVencedorTO;

@Repository
public interface VencedorRepository extends JpaRepository<ProdutorVencedor, Long> {
	
	@Query("SELECT new com.example.restful.to.ProdutorVencedorTO(e.vencedor, max(e.ano), min(e.ano)) "
		   + "FROM ProdutorVencedor e "
		   + "group by e.vencedor ")
	public List<ProdutorVencedorTO> getProdutorPremioMaiorMenorAno();

}
