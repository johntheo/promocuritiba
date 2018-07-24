package com.marcoscarvalho.promocuritiba.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Constantes {

	public static final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	public static final String VIRGULA = ", ";
	public static final String NOVA_LINHA = "\n";

	public static String formartarData(Date date) {
		return formatoData.format(date);
	}

	public static Date retornarDate(String data) {
		try {
			return formatoData.parse(data);
		} catch (ParseException e) {
			return new Date();
		}
	}

	public static <T> String retorarString(Set<T> set, String formato) {
		String str = "";
		List<T> list = new ArrayList<T>();
		list.addAll(set);
		for (int i = 0; i < list.size(); i++) {
			str += list.get(i).toString();
			if (list.size() != (i + 1)) {
				str += formato;
			}
		}
		return str;
	}

	public static String ajustarString(String valor) {
		if (valor == null || valor.trim().isEmpty()) {
			return valor;
		}

		return toCamelCase(valor.toLowerCase().trim(), " ");
	}

	private static String toCamelCase(String s, String regex) {
		String[] parts = s.split(regex);
		String camelCaseString = " ";
		for (String part : parts) {
			camelCaseString = camelCaseString + toProperCase(part);
		}
		return camelCaseString;
	}

	private static String toProperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

}
