package com.patrimonio.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class Utils {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static String dataFormatPt(Date data) {
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");

		if (data != null) {
			String dataFormatada = dt.format(data);
			return dataFormatada;
		}
		return null;
	}
	
	public static boolean emailValidate(final String hex) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(hex);
		return matcher.matches();
	}

	public static String sexoCharForString(Character sexo) {

		if (sexo != null) {
			if (sexo.equals('F')) {
				return "Feminino";
			} else if (sexo.equals('M')) {
				return "Masculino";
			}
		}

		return null;

	}

	public static Character sexoStringForChar(String sexo) {
		if (sexo != null) {
			if (sexo.equals("Masculino")) {
				return 'M';
			} else if (sexo.equals("Feminino")) {
				return 'F';
			}
		}

		return null;

	}

	public static String tipoEnderecoCharForString(Character tipo) {

		if (tipo != null) {
			if (tipo.equals('L')) {
				return "Local";
			} else if (tipo.equals('O')) {
				return "Origem";
			}
		}

		return null;

	}

	public static Character tipoEnderecoStringForChar(String tipo) {

		if (tipo != null) {
			if (tipo.equals("Local")) {
				return 'L';
			} else if (tipo.equals("Origem")) {
				return 'O';
			}
		}

		return null;
	}

	public static Flash flashScope() {
		return FacesContext.getCurrentInstance().getExternalContext().getFlash();
	}

}
