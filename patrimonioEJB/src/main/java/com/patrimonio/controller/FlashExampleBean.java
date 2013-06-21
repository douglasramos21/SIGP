package com.patrimonio.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.Flash;

import com.patrimonio.model.Colaborador;

@ManagedBean
@RequestScoped
public class FlashExampleBean implements Serializable {

	@PostConstruct
	public void init() {
		System.out.println("FLASH");
		System.out.println("INIT "+(Colaborador) getFlash().get("colaborador"));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -921427214036542084L;

	@ManagedProperty("#{flash}")
	private Flash flash;

	private Colaborador colaborador = new Colaborador();

	public String getInputFromFlash() {
		String inputText = (String) flash.get("inputText");

		flash.keep("inputText");
		return inputText;
	}
	
	public void processaDados(){
		getFlash().put("colaborador", getColaborador());
		
		System.out.println("PROCESSA DADOS "+getFlash().get("colaborador"));
		
	}

	public void setFlash(Flash flash) {
		this.flash = flash;
	}

	public Flash getFlash() {
		return flash;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

}
