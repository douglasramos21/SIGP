package com.patrimonio.master;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;

import com.patrimonio.utils.JSFMessageUtil;

@ManagedBean(name = "GenericMB")
@ViewScoped
public abstract class GenericMB implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 6561907745413197182L;

	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";

	private transient CommandButton btnCancelar = new CommandButton();
	private transient CommandButton btnEditar = new CommandButton();
	private transient CommandButton btnExcluir = new CommandButton();
	private transient CommandButton btnNovo = new CommandButton();
	private transient CommandButton btnSalvar = new CommandButton();
	private transient CommandButton btnPesquisar = new CommandButton();
	private transient CommandButton btnLimpar = new CommandButton();
	private transient CommandButton btnRecarregar = new CommandButton();
	private transient CommandButton indexButton = new CommandButton();

	protected void printSaveMessage(BusinessProcess bp) throws IOException {
		// if (bp.isSaved()) {
		// FacesContext.getCurrentInstance().addMessage(null, new
		// FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", ""));
		// }
	}

	protected void displayErrorMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendErrorMessageToUser(message);
	}

	protected void displayInfoMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message);
	}

	protected void displayWarningMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message);
	}

	protected void closeDialog() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}

	protected void keepDialogOpen() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}

	protected RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}

	public void setBtnCancelar(CommandButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public CommandButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnEditar(CommandButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public CommandButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnExcluir(CommandButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public CommandButton getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnNovo(CommandButton btnNovo) {
		this.btnNovo = btnNovo;
	}

	public CommandButton getBtnNovo() {
		return btnNovo;
	}

	public void setBtnSalvar(CommandButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public CommandButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnPesquisar(CommandButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}

	public CommandButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnLimpar(CommandButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

	public CommandButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnRecarregar(CommandButton btnRecarregar) {
		this.btnRecarregar = btnRecarregar;
	}

	public CommandButton getBtnRecarregar() {
		return this.btnRecarregar;
	}

	public CommandButton getIndexButton() {
		return indexButton;
	}

	public void setIndexButton(CommandButton indexButton) {
		this.indexButton = indexButton;
	}

}
