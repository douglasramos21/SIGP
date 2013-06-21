package com.patrimonio.converter;

import java.sql.Time;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.patrimonio.converter.TimeConverter")
public class TimeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value == null || "".equals(value)) {
			return Time.valueOf("00:00:00");
		}
		
		String valueConcat = "";
		 
		if(value.length() == 5){
			valueConcat = value.concat(":00");
			return Time.valueOf(valueConcat);
		}
		
		return Time.valueOf(value);
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value.toString().length() > 5){
			return value.toString().substring(0,5);
		}
		return value.toString();
	}
	
	// @Override
	// public Object getAsObject(FacesContext context, UIComponent component,
	// String value) {
	//
	// if(value.equals("") || value == null){
	// return Time.valueOf("");
	// }
	//
	// String regex = "^([0-2]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$";
	// StringBuffer texto = new StringBuffer();
	// texto.append(value);
	//
	// Pattern pat = Pattern.compile(regex);
	// Matcher m = pat.matcher(texto);
	//
	// if(m.matches()){
	// return Time.valueOf(value);
	// }
	//
	//
	// }

}
