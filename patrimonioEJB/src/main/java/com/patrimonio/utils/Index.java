//package com.patrimonio.utils;
//
//import java.io.Serializable;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.event.ActionEvent;
//
//import com.patrimonio.master.GenericMB;
//
//@ManagedBean(name = "index")
//@ViewScoped
//public class Index extends GenericMB implements Serializable {
//
//	private static final long serialVersionUID = 225868591355672198L;
//
//	private String pagina;
//
//	public Index() {
//
//	}
//
//	public void setPagina(String pagina) {
//		this.pagina = pagina;
//	}
//
//	public String getPagina() {
//		return pagina;
//	}
//
//	public void passaPagina(ActionEvent ae) {
//		pagina = (String) ae.getComponent().getAttributes().get("pagina");
//	}
//
//	public String getPegaPagina() {
//		return pagina;
//	}
//
//}