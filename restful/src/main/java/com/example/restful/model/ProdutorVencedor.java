package com.example.restful.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdutorVencedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column
	public Long ano;
	
	@Column
	public String vencedor;
	
	public ProdutorVencedor(Long ano, String vencedor) {
		super();
		this.ano = ano;
		this.vencedor = vencedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutorVencedor other = (ProdutorVencedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
