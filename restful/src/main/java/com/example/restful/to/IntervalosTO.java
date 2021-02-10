package com.example.restful.to;

import java.util.List;

public class IntervalosTO {

	private List<ProdutorVencedorTO> listaMaioresIntervalos;
	private List<ProdutorVencedorTO> listaMenoresIntervalos;
	
	public IntervalosTO(List<ProdutorVencedorTO> listaMaioresIntervalos,
			List<ProdutorVencedorTO> listaMenoresIntervalos) {
		super();
		this.listaMaioresIntervalos = listaMaioresIntervalos;
		this.listaMenoresIntervalos = listaMenoresIntervalos;
	}

	public List<ProdutorVencedorTO> getListaMaioresIntervalos() {
		return listaMaioresIntervalos;
	}

	public List<ProdutorVencedorTO> getListaMenoresIntervalos() {
		return listaMenoresIntervalos;
	}
	
	
}
