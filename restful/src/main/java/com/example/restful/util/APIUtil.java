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
			
			String nome;
			for (String[] f : filmes) {
				String s = f[0].toString();
				if (s.contains(";yes")){
					nome = s.split(";")[3];
					if(nome.contains("and")){
						produtores.add(new ProdutorVencedor(Long.parseLong(s.split(";")[0]), nome.split(" and ")[0].trim()));
						produtores.add(new ProdutorVencedor(Long.parseLong(s.split(";")[0]), nome.split(" and ")[1].trim()));
					} else if(nome.contains(",")) {
						int qtWinners =  countOccurrences(nome, ',') + 1;
						for(int i=0;  i<qtWinners; i++) {
							produtores.add(new ProdutorVencedor(Long.parseLong(s.split(";")[i]), nome.split(",")[i].trim()));
						}
					} else {
						produtores.add(new ProdutorVencedor(Long.parseLong(s.split(";")[0]), nome.trim()));
					}
				}
					
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return produtores;
	}
	
	private static int countOccurrences(String str, char ch) {
	    return (int) str.chars()
	            .filter(c -> c == ch)
	            .count();
	}
}
