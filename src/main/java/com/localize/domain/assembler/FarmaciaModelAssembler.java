package com.localize.domain.assembler;

import org.springframework.stereotype.Component;

import com.localize.domain.Farmacia;
import com.localize.domain.dto.FarmaciaDto;

@Component
public class FarmaciaModelAssembler {

	public FarmaciaDto modelFarmaciaToFarmaciaDto (Farmacia obj) {
		FarmaciaDto farmacia = new FarmaciaDto();
		
		farmacia.setId(obj.getId());
		farmacia.setFundadaMaisDe1Ano(true);
		farmacia.setName(obj.getName());
		farmacia.setFarmacia24Horas(obj.getFarmacia24Horas());
		farmacia.setBairroLocalizado(obj.getBairroLocalizado());
		farmacia.setDataFundacao(obj.getDataFundacao());
		
		return farmacia;
	}
}
