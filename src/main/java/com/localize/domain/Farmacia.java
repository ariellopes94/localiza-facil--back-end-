package com.localize.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_drugstores")
public class Farmacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@JsonInclude(JsonInclude.Include.NON_NULL)// Quando a a variavel for Null ela nao retorna pra tela
	@NotEmpty(message = "O campo nome, é obrigatorio")
	private String name;
	
	
	@NotNull(message = "O campo farmácia 24 horas, é obrigatorio")
	@Column(name="flg_round_the_clock")
	private boolean farmacia24Horas;
	
	
	/*
	@NotEmpty(message = "O campo Bairro de localização, é obrigatorio")
	@Column(name="id_neighborhood")
	private Bairro bairroLocalizado;
	*/
	

	@NotNull(message = "O campo bairro localizado, é obrigatorio")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_neighborhood")
	private Bairro bairroLocalizado;
	
	
	@NotNull(message = "O campo Data, é obrigatorio")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name="foundation_date")
	private Date dataFundacao;
	
	public Farmacia() {
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getFarmacia24Horas() {
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
		Farmacia other = (Farmacia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
