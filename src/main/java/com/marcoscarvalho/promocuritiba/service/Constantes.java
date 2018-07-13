package com.marcoscarvalho.promocuritiba.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constantes {

	public static final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	public static final String VIRGULA = ", ";
	public static final String NOVA_LINHA = "\n";

	public static String formartarData(Date date) {
		return formatoData.format(date);
	}

}
