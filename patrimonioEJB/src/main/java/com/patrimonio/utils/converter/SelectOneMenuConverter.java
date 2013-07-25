package com.patrimonio.utils.converter;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.patrimonio.master.EntityBean;
import com.patrimonio.model.Cargo;
import com.patrimonio.model.ColaboradorRelacao;
import com.patrimonio.model.Empresa;
import com.patrimonio.model.EstadoCivil;
import com.patrimonio.model.Filiacao;
import com.patrimonio.model.GrauInstrucao;
import com.patrimonio.model.Lotacao;
import com.patrimonio.model.Nacionalidade;
import com.patrimonio.model.Profissao;
import com.patrimonio.model.Provincia;
import com.patrimonio.model.Setor;
import com.patrimonio.model.TipoDocumento;
import com.patrimonio.model.TipoHorario;
import com.patrimonio.model.TipoVisto;

@FacesConverter("com.patrimonio.converter.SelectOneMenuConverter")
public class SelectOneMenuConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {

		if (value != null) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object value) {

		if (value != null && !"".equals(value)) {

			try {
				Class<?> classe = Class.forName(value.getClass().getCanonicalName());
				EntityBean obj = (EntityBean) classe.newInstance();

				if (obj instanceof Cargo) {
					obj = (Cargo) value;
				} else if (obj instanceof Empresa) {
					obj = (Empresa) value;
				} else if (obj instanceof ColaboradorRelacao) {
					obj = (ColaboradorRelacao) value;
				} else if (obj instanceof EstadoCivil) {
					obj = (EstadoCivil) value;
				} else if (obj instanceof Filiacao) {
					obj = (Filiacao) value;
				} else if (obj instanceof GrauInstrucao) {
					obj = (GrauInstrucao) value;
				} else if (obj instanceof Lotacao) {
					obj = (Lotacao) value;
				} else if (obj instanceof Nacionalidade) {
					obj = (Nacionalidade) value;
				} else if (obj instanceof Profissao) {
					obj = (Profissao) value;
				} else if (obj instanceof Provincia) {
					obj = (Provincia) value;
				} else if (obj instanceof Setor) {
					obj = (Setor) value;
				} else if (obj instanceof TipoDocumento) {
					obj = (TipoDocumento) value;
				} else if (obj instanceof TipoHorario) {
					obj = (TipoHorario) value;
				} else if (obj instanceof TipoVisto) {
					obj = (TipoVisto) value;
				}

				this.addAttribute(component, obj);

				if (obj != null) {
					return String.valueOf(obj);
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}

		return (String) value;
	}

	protected void addAttribute(UIComponent component, EntityBean obj) {
		String key = obj.toString();
		this.getAttributesFrom(component).put(key, obj);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}
