package com.patrimonio.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.extensions.component.masterdetail.SelectLevelEvent;

@ManagedBean
@RequestScoped
public class SelectLevelListener {

	private int errorOccured = 0;

	public int handleNavigation(SelectLevelEvent selectLevelEvent) {
		if (errorOccured != 0) {
			return errorOccured;
		} else {
			return selectLevelEvent.getNewLevel();
		}
	}

	public void setErrorOccured(int errorOccured) {
		this.errorOccured = errorOccured;
	}
}
