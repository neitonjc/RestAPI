package com.example.restful.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.restful.model.ProdutorVencedor;
import com.example.restful.repository.VencedorRepository;
import com.example.restful.to.IntervalosTO;
import com.example.restful.to.ProdutorVencedorTO;
import com.example.restful.util.APIUtil;

@RestController
@RequestMapping("/vencedores")
public class Controller {
	
	@Autowired
	private VencedorRepository vencedorRepository;
	
	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	public IntervalosTO getProdutoresVencedores(){
		List<ProdutorVencedor> listP = APIUtil.getProdutoresPremiados();
		
		for (ProdutorVencedor p : listP) {
			vencedorRepository.save(p);
		}
		
		List<ProdutorVencedorTO> list = vencedorRepository.getProdutorPremioMaiorMenorAno();
		Long maiorItervalo=0l;
		Long menorItervalo=10l;
		for (ProdutorVencedorTO pTO : list) {
			if(pTO.getIntervalo().compareTo(maiorItervalo)==1)
				maiorItervalo = pTO.getIntervalo();
			
			if(menorItervalo.equals(0l)
					&& !pTO.getIntervalo().equals(0l))
				menorItervalo = pTO.getIntervalo();
			
			if(!pTO.getIntervalo().equals(0l) 
					&& pTO.getIntervalo().compareTo(menorItervalo)==-1)
				menorItervalo = pTO.getIntervalo();
			
		}
		
		List<ProdutorVencedorTO> listaMaioresIntervalos = new ArrayList<>();
		List<ProdutorVencedorTO> listaMenoresIntervalos = new ArrayList<>();
		for (ProdutorVencedorTO pTO : list) {
			if(!maiorItervalo.equals(0l)
					&& pTO.getIntervalo().equals(maiorItervalo))
				listaMaioresIntervalos.add(pTO);
			if(!maiorItervalo.equals(0l)
					&& pTO.getIntervalo().equals(menorItervalo))
				listaMenoresIntervalos.add(pTO);
		}
		
		return new IntervalosTO(listaMaioresIntervalos, listaMenoresIntervalos);
	}
	
}
