package com.example.restful.util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.example.restful.model.ProdutorVencedor;
import com.opencsv.CSVReader;

public class APIUtil {
	
	public static List<ProdutorVencedor> getProdutoresPremiados(){
		List<String[]> filmes = new ArrayList<String[]>();
		List<ProdutorVencedor> produtores = new ArrayList<>();
		
		try {
			String strFile = "./src/main/resources/files/movielist.csv";
			CSVReader reader = new CSVReader(new FileReader(strFile));
			
			filmes = reader.readAll();

			for (String[] f : filmes) {
				String s = f[0].toString();
				if (s.contains(";yes"))
					produtores.add(new ProdutorVencedor(Long.parseLong(s.split(";")[0]), s.split(";")[3]));
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return produtores;
	}
}
