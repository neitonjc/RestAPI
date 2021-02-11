package com.example.restful.to;

public class ProdutorVencedorTO {
	
	public String vencedor;
	public Long maiorAno;
	public Long menorAno;

	public ProdutorVencedorTO(String vencedor, Long maiorAno, Long menorAno) {
		super();
		this.vencedor = vencedor;
		this.maiorAno = maiorAno;
		this.menorAno = menorAno;
	}

	public ProdutorVencedorTO() {
		super();
	}



	public Long getIntervalo(){
		if (maiorAno!=null && menorAno!=null)
			return maiorAno-menorAno;
		else 
			return 0l;
	}
}
