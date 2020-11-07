package com.localize.services;

import java.text.Normalizer;

import org.springframework.stereotype.Component;

@Component
public class UteisService {

	public String removeAccents(String str) {
	    str = Normalizer.normalize(str, Normalizer.Form.NFD);
	    str = str.replaceAll("[^\\p{ASCII}]", "");
	    return str;
	}
}
