package com.ec.deckxel.utilidad;

import java.math.BigDecimal;

public class Utilidades {
	/* APROXIMACION DE DECIMALES */
	public static BigDecimal redondearDecimales(BigDecimal valorInicial, int numeroDecimales) {
		double parteEntera, resultado;
		resultado = valorInicial.doubleValue();
		parteEntera = Math.floor(resultado);
		Double resutl = BigDecimal.valueOf(resultado).subtract(BigDecimal.valueOf(parteEntera)).doubleValue();
		resultado = resutl * Math.pow(10, numeroDecimales);
		resultado = Math.round(resultado);
		BigDecimal resulDes = BigDecimal.valueOf(resultado);
		BigDecimal divide = BigDecimal.valueOf(resulDes.doubleValue())
				.divide(BigDecimal.valueOf(Math.pow(10, numeroDecimales)));
		resultado = (divide.add(BigDecimal.valueOf(parteEntera))).doubleValue();
		return BigDecimal.valueOf(resultado);
	}

	public static String numeroFacturaTexto(Integer numeroFactura) {
		String numeroFacturaText = "";
		for (int i = numeroFactura.toString().length(); i < 9; i++) {
			numeroFacturaText = numeroFacturaText + "0";
		}
		numeroFacturaText = numeroFacturaText + numeroFactura;
		System.out.println("nuemro texto " + numeroFacturaText);
		return numeroFacturaText;
	}

}
