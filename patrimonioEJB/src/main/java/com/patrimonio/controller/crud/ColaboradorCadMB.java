package com.patrimonio.controller.crud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;

import org.primefaces.component.selectonemenu.SelectOneMenu;

import com.patrimonio.master.EntityBean;
import com.patrimonio.master.GenericMB;
import com.patrimonio.master.interfaces.InterfaceCadMB;
import com.patrimonio.model.Cargo;
import com.patrimonio.model.Colaborador;
import com.patrimonio.model.ColaboradorRelacao;
import com.patrimonio.model.ColaboradorSituacao;
import com.patrimonio.model.Empresa;
import com.patrimonio.model.EstadoCivil;
import com.patrimonio.model.GrauInstrucao;
import com.patrimonio.model.Lotacao;
import com.patrimonio.model.Profissao;
import com.patrimonio.model.Setor;
import com.patrimonio.model.TipoHorario;
import com.patrimonio.service.ColaboradorBP;

@ManagedBean(name = "colaboradorCadMB")
@RequestScoped
public class ColaboradorCadMB extends GenericMB implements InterfaceCadMB {

	private static final long serialVersionUID = -2659182542128760528L;

	private HtmlForm formColaboradorCad = new HtmlForm();

	private ColaboradorBP colaboradorBP = new ColaboradorBP();
	private Colaborador colaborador = new Colaborador();

	private List<? extends EntityBean> listColaboradores = new ArrayList<Colaborador>();
	private List<Setor> listSetor = new ArrayList<Setor>();
	private List<Empresa> listEmpresa = new ArrayList<Empresa>();
	private List<Cargo> listCargo = new ArrayList<Cargo>();
	private List<Lotacao> listLotacao = new ArrayList<Lotacao>();
	private List<TipoHorario> listTipoHorario = new ArrayList<TipoHorario>();
	private List<ColaboradorRelacao> listColaboradorRelacao = new ArrayList<ColaboradorRelacao>();
	private List<ColaboradorSituacao> listColaboradorSituacao = new ArrayList<ColaboradorSituacao>();
	private List<EstadoCivil> listEstadoCivil = new ArrayList<EstadoCivil>();
	private List<GrauInstrucao> listGrauInstrucao = new ArrayList<GrauInstrucao>();
	private List<Profissao> listProfissao = new ArrayList<Profissao>();

	private transient SelectOneMenu ddlSetor = new SelectOneMenu();
	private transient SelectOneMenu ddlEmpresa = new SelectOneMenu();
	private transient SelectOneMenu ddlCargo = new SelectOneMenu();
	private transient SelectOneMenu ddlLotacao = new SelectOneMenu();
	private transient SelectOneMenu ddlTipoHorario = new SelectOneMenu();
	private transient SelectOneMenu ddlColaboradorRelacao = new SelectOneMenu();
	private transient SelectOneMenu ddlColaboradorSituacao = new SelectOneMenu();
	private transient SelectOneMenu ddlEstadoCivil = new SelectOneMenu();
	private transient SelectOneMenu ddlGrauInstrucao = new SelectOneMenu();
	private transient SelectOneMenu ddlProfissao = new SelectOneMenu();

	@PostConstruct
	public void init() {

		// setListCategoriaColaborador(getColaboradorBP().findCategColaboradorAll());
		// setListMarcaColaborador(getColaboradorBP().findMarcColaboradorAll());
		// setListModeloColaborador(getColaboradorBP().findModColaboradorAll());
		// setListTipoColaborador(getColaboradorBP().findTpColaboradorAll());

		if (getColaborador().getId() == null) {
			getDdlColaboradorRelacao().setValue(0);
			getDdlColaboradorSituacao().setValue(0);
			getDdlCargo().setValue(0);
			getDdlEmpresa().setValue(0);
			getDdlEstadoCivil().setValue(0);
			getDdlGrauInstrucao().setValue(0);
			getDdlLotacao().setValue(0);
			getDdlProfissao().setValue(0);
			getDdlSetor().setValue(0);
			getDdlTipoHorario().setValue(0);
		} else {
			getListSetor().add(getColaborador().getSetor());
			getListCargo().add(getColaborador().getCargo());
			getListColaboradorRelacao().add(getColaborador().getColaboradorRelacao());
			getListColaboradorSituacao().add(getColaborador().getColaboradorSituacao());
			getListEmpresa().add(getColaborador().getEmpresa());
			getListEstadoCivil().add(getColaborador().getEstadoCivil());
			getListGrauInstrucao().add(getColaborador().getGrauInstrucao());
			getListLotacao().add(getColaborador().getLotacao());
			getListProfissao().add(getColaborador().getProfissao());
			getListTipoHorario().add(getColaborador().getTipoHorario());
		}

	}

	@PreDestroy
	public void cleanUp() {

		try {
			finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void cancel() throws IOException {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getSessionMap().clear();
		fc.getExternalContext().getSessionMap().put("colaborador", getColaborador());
	}

	@Override
	public void save() throws Exception {
		getColaboradorBP().save(getColaborador());
	}

	public void setColaboradorBP(ColaboradorBP colaboradorBP) {
		this.colaboradorBP = colaboradorBP;
	}

	public ColaboradorBP getColaboradorBP() {
		return colaboradorBP;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Colaborador getColaborador() {
		if (colaborador != null) {
			if (colaborador.getId() == null) {
				colaborador = (Colaborador) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("colaborador");
				if (colaborador != null) {
					return colaborador;
				}
				colaborador = new Colaborador();
			}
		}

		return colaborador;
	}

	public HtmlForm getFormColaboradorCad() {
		return formColaboradorCad;
	}

	public void setFormColaboradorCad(HtmlForm formColaboradorCad) {
		this.formColaboradorCad = formColaboradorCad;
	}


	public List<? extends EntityBean> getListColaboradores() {
		return listColaboradores;
	}

	public void setListColaboradores(List<? extends EntityBean> listColaboradores) {
		this.listColaboradores = listColaboradores;
	}

	public List<Setor> getListSetor() {
		return listSetor;
	}

	public void setListSetor(List<Setor> listSetor) {
		this.listSetor = listSetor;
	}

	public List<Empresa> getListEmpresa() {
		return listEmpresa;
	}

	public void setListEmpresa(List<Empresa> listEmpresa) {
		this.listEmpresa = listEmpresa;
	}

	public List<Cargo> getListCargo() {
		return listCargo;
	}

	public void setListCargo(List<Cargo> listCargo) {
		this.listCargo = listCargo;
	}

	public List<Lotacao> getListLotacao() {
		return listLotacao;
	}

	public void setListLotacao(List<Lotacao> listLotacao) {
		this.listLotacao = listLotacao;
	}

	public List<TipoHorario> getListTipoHorario() {
		return listTipoHorario;
	}

	public void setListTipoHorario(List<TipoHorario> listTipoHorario) {
		this.listTipoHorario = listTipoHorario;
	}

	public List<ColaboradorRelacao> getListColaboradorRelacao() {
		return listColaboradorRelacao;
	}

	public void setListColaboradorRelacao(List<ColaboradorRelacao> listColaboradorRelacao) {
		this.listColaboradorRelacao = listColaboradorRelacao;
	}

	public List<ColaboradorSituacao> getListColaboradorSituacao() {
		return listColaboradorSituacao;
	}

	public void setListColaboradorSituacao(List<ColaboradorSituacao> listColaboradorSituacao) {
		this.listColaboradorSituacao = listColaboradorSituacao;
	}

	public List<EstadoCivil> getListEstadoCivil() {
		return listEstadoCivil;
	}

	public void setListEstadoCivil(List<EstadoCivil> listEstadoCivil) {
		this.listEstadoCivil = listEstadoCivil;
	}

	public List<GrauInstrucao> getListGrauInstrucao() {
		return listGrauInstrucao;
	}

	public void setListGrauInstrucao(List<GrauInstrucao> listGrauInstrucao) {
		this.listGrauInstrucao = listGrauInstrucao;
	}

	public List<Profissao> getListProfissao() {
		return listProfissao;
	}

	public void setListProfissao(List<Profissao> listProfissao) {
		this.listProfissao = listProfissao;
	}

	public SelectOneMenu getDdlSetor() {
		return ddlSetor;
	}

	public void setDdlSetor(SelectOneMenu ddlSetor) {
		this.ddlSetor = ddlSetor;
	}

	public SelectOneMenu getDdlEmpresa() {
		return ddlEmpresa;
	}

	public void setDdlEmpresa(SelectOneMenu ddlEmpresa) {
		this.ddlEmpresa = ddlEmpresa;
	}

	public SelectOneMenu getDdlCargo() {
		return ddlCargo;
	}

	public void setDdlCargo(SelectOneMenu ddlCargo) {
		this.ddlCargo = ddlCargo;
	}

	public SelectOneMenu getDdlLotacao() {
		return ddlLotacao;
	}

	public void setDdlLotacao(SelectOneMenu ddlLotacao) {
		this.ddlLotacao = ddlLotacao;
	}

	public SelectOneMenu getDdlTipoHorario() {
		return ddlTipoHorario;
	}

	public void setDdlTipoHorario(SelectOneMenu ddlTipoHorario) {
		this.ddlTipoHorario = ddlTipoHorario;
	}

	public SelectOneMenu getDdlColaboradorRelacao() {
		return ddlColaboradorRelacao;
	}

	public void setDdlColaboradorRelacao(SelectOneMenu ddlColaboradorRelacao) {
		this.ddlColaboradorRelacao = ddlColaboradorRelacao;
	}

	public SelectOneMenu getDdlColaboradorSituacao() {
		return ddlColaboradorSituacao;
	}

	public void setDdlColaboradorSituacao(SelectOneMenu ddlColaboradorSituacao) {
		this.ddlColaboradorSituacao = ddlColaboradorSituacao;
	}

	public SelectOneMenu getDdlEstadoCivil() {
		return ddlEstadoCivil;
	}

	public void setDdlEstadoCivil(SelectOneMenu ddlEstadoCivil) {
		this.ddlEstadoCivil = ddlEstadoCivil;
	}

	public SelectOneMenu getDdlGrauInstrucao() {
		return ddlGrauInstrucao;
	}

	public void setDdlGrauInstrucao(SelectOneMenu ddlGrauInstrucao) {
		this.ddlGrauInstrucao = ddlGrauInstrucao;
	}

	public SelectOneMenu getDdlProfissao() {
		return ddlProfissao;
	}

	public void setDdlProfissao(SelectOneMenu ddlProfissao) {
		this.ddlProfissao = ddlProfissao;
	}

}
