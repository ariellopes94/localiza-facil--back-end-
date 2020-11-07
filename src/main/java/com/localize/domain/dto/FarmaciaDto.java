package com.localize.domain.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.localize.domain.Bairro;

public class FarmaciaDto {

	private Long id;
	private boolean fundadaMaisDe1Ano;
	private String name;
	private boolean farmacia24Horas;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private Bairro bairroLocalizado;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataFundacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isFundadaMaisDe1Ano() {
		
		calcularIdadeFarmaciaFundada();
		return fundadaMaisDe1Ano;
	}
	public void setFundadaMaisDe1Ano(boolean fundadaMaisDe1Ano) {
		this.fundadaMaisDe1Ano = fundadaMaisDe1Ano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFarmacia24Horas() {
		return farmacia24Horas;
	}
	public void setFarmacia24Horas(boolean farmacia24Horas) {
		this.farmacia24Horas = farmacia24Horas;
	}
	public Bairro getBairroLocalizado() {
		return bairroLocalizado;
	}
	public void setBairroLocalizado(Bairro bairroLocalizado) {
		this.bairroLocalizado = bairroLocalizado;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public void calcularIdadeFarmaciaFundada()  {
		
		  DateFormat sdf  = new SimpleDateFormat ("dd/MM/yyyy");
		  String dataAtual = sdf.format(new Date( System.currentTimeMillis()));
		  String dataFundacao = sdf.format(getDataFundacao());
		  
	      Date dtInicial = null;
	      Date dtFinal = null ;
	        
			try {
				dtInicial = sdf.parse (dataFundacao);
				System.out.print("DATA FUNDA" + dtInicial);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
	    	
			try {
				dtFinal = sdf.parse (dataAtual);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        
	        Long quantidadeDias=    (dtFinal.getTime() - dtInicial.getTime() + 3600000L) / 86400000L;
	        
	        if(quantidadeDias > 365) {
	        	setFundadaMaisDe1Ano(true);
	        }
	        else {
	        	setFundadaMaisDe1Ano(false);
	        }

		}

}
