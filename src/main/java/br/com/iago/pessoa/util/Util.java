package br.com.iago.pessoa.util;

import java.util.Calendar;
import java.util.Date;

public class Util {
	
	public static Integer calculaIdade(Date dataNasc) {

	    Calendar dataNascimento = Calendar.getInstance();  
	    dataNascimento.setTime(dataNasc); 
	    Calendar hoje = Calendar.getInstance();  

	    Integer idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); 

	    if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
	      idade--;  
	    } 
	    else 
	    { 
	        if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
	            idade--; 
	        }
	    }

	    return idade;
	}
	
}
