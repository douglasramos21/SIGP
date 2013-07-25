package com.patrimonio.controller.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

import com.patrimonio.controller.SelectLevelListener;
import com.patrimonio.master.EntityBean;
import com.patrimonio.master.GenericMB;
import com.patrimonio.master.interfaces.InterfaceViewMB;
import com.patrimonio.model.Cargo;
import com.patrimonio.model.Colaborador;
import com.patrimonio.model.ColaboradorDependente;
import com.patrimonio.model.ColaboradorDocumento;
import com.patrimonio.model.ColaboradorEndereco;
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
import com.patrimonio.service.ColaboradorBP;
import com.patrimonio.utils.Utils;

@ManagedBean(name = "colaboradorViewMB")
public class ColaboradorViewMB extends GenericMB implements InterfaceViewMB {

	/**
	 * 
	 */
	private static final long serialVersionUID = -942684871454520452L;

	private ColaboradorBP colaboradorBP = new ColaboradorBP();
	private Colaborador colaborador = new Colaborador();

	private List<? extends EntityBean> listColaboradores = new ArrayList<Colaborador>();
	private List<Cargo> listCargo = new ArrayList<Cargo>();
	private List<ColaboradorRelacao> listColaboradorRelacao = new ArrayList<ColaboradorRelacao>();
	private List<Empresa> listEmpresa = new ArrayList<Empresa>();
	private List<EstadoCivil> listEstadoCivil = new ArrayList<EstadoCivil>();
	private List<Filiacao> listFiliacao = new ArrayList<Filiacao>();
	private List<GrauInstrucao> listGrauInstrucao = new ArrayList<GrauInstrucao>();
	private List<Lotacao> listLotacao = new ArrayList<Lotacao>();
	private List<Nacionalidade> listNacionalidade = new ArrayList<Nacionalidade>();
	private List<Profissao> listProfissao = new ArrayList<Profissao>();
	private List<Provincia> listProvincia = new ArrayList<Provincia>();
	private List<Setor> listSetor = new ArrayList<Setor>();
	private List<String> listSexo = new ArrayList<String>();
	private List<TipoHorario> listTipoHorario = new ArrayList<TipoHorario>();
	private List<TipoDocumento> listTipoDocumento = new ArrayList<TipoDocumento>();
	private List<String> listTipoEndereco = new ArrayList<String>();
	private List<TipoVisto> listTipoVisto = new ArrayList<TipoVisto>();

	private List<ColaboradorEndereco> listaEnderecos = new ArrayList<ColaboradorEndereco>();
	private List<ColaboradorDependente> listaDependentes = new ArrayList<ColaboradorDependente>();
	private List<ColaboradorDocumento> listaDocumentos = new ArrayList<ColaboradorDocumento>();

	private transient SelectOneMenu ddlCargo = new SelectOneMenu();
	private transient SelectOneMenu ddlColaboradorRelacao = new SelectOneMenu();
	private transient SelectOneMenu ddlEmpresa = new SelectOneMenu();
	private transient SelectOneMenu ddlEstadoCivil = new SelectOneMenu();
	private transient SelectOneMenu ddlFiliacao = new SelectOneMenu();
	private transient SelectOneMenu ddlGrauInstrucao = new SelectOneMenu();
	private transient SelectOneMenu ddlLotacao = new SelectOneMenu();
	private transient SelectOneMenu ddlNacionalidade = new SelectOneMenu();
	private transient SelectOneMenu ddlProfissao = new SelectOneMenu();
	private transient SelectOneMenu ddlProvincia = new SelectOneMenu();
	private transient SelectOneMenu ddlProvinciaCad = new SelectOneMenu();
	private transient SelectOneMenu ddlSetor = new SelectOneMenu();
	private transient SelectOneMenu ddlSexo = new SelectOneMenu();
	private transient SelectOneMenu ddlTipoHorario = new SelectOneMenu();
	private transient SelectOneMenu ddlTipoDocumento = new SelectOneMenu();
	private transient SelectOneMenu ddlTipoEndereco = new SelectOneMenu();
	private transient HtmlSelectOneMenu ddlTipoVisto = new SelectOneMenu();
	private transient Calendar calDiaIni = new Calendar();
	private transient Calendar calDiaFim = new Calendar();
	private transient Calendar calTardeIni = new Calendar();
	private transient Calendar calTardeFim = new Calendar();
	private transient Calendar calNoiteIni = new Calendar();
	private transient Calendar calNoiteFim = new Calendar();
	private transient DataTable dtbColaborador = new DataTable();
	private transient DataTable dtbEndereco = new DataTable();
	private transient DataTable dtbDependente = new DataTable();
	private transient DataTable dtbDocumento = new DataTable();
	private transient InputText docClass = new InputText();

	@PostConstruct
	public void init() throws Exception {
		
 		pesquisar();
		if (!FacesContext.getCurrentInstance().isPostback()) {
			setColaborador((Colaborador) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("colaborador"));
			if (getColaborador() == null || getColaborador().getId() == null) {
				carregaObjetosNovo();
			} else {
				carregaObjetos();
			}
		}
		
	}

	@Override
	public void pesquisar() {
		setListColaboradores(getColaboradorBP().findAll(Colaborador.class));
		getDtbColaborador().setFilteredValue(getListColaboradores());

	}

	public void preencheObjeto(SelectEvent event) throws Exception {

		setColaborador((Colaborador) event.getObject());

		carregaObjetos();
	}

	@Override
	public void novo() throws Exception {
		FacesContext.getCurrentInstance().getViewRoot().clearInitialState();
		setColaborador(new Colaborador());

		carregaObjetosNovo();
	}

	@Override
	public void edit() throws Exception {
		// clearLists();
		// loadSelectItems();
		// setSelectItemsDefault();
		// setSelectItems();
	}

	@Override
	public void delete() throws Exception {
		try {
			getColaboradorBP().delete(getColaborador());
			deleteSuccess(getColaborador());
			novo();
		} catch (Exception e) {
			e.printStackTrace();
			deleteFailure(getColaborador());
		}
	}

	@Override
	public void cancel() throws Exception {
		
		setColaborador(getStateContext());
		
		if (getColaborador() == null || getColaborador().getId() == null) {
			hideToolbarButtons();
			setSelectItemsDefault();
		} else {
			showToolbarButtons();
			setSelectItems();
		}
		
		for (ColaboradorDocumento colDoc : getColaborador().getDocumentos()) {
			System.out.println(colDoc.getTipoDocumento().getNome());
		}

		saveStateContext();
	}

	@Override
	public void save() {
		try {
			getColaborador().setEnderecos(getListaEnderecos());
			getColaborador().setDependentes(getListaDependentes());
			getColaborador().setDocumentos(getListaDocumentos());

			getColaboradorBP().save(getColaborador());
			saveSuccess(getColaborador());
			setSelectItems();
			showToolbarButtons();
		} catch (Exception e) {
			e.printStackTrace();
			saveFailure(getColaborador());
		}
	}

	public void carregaObjetosNovo() {
		hideToolbarButtons();
		loadAllLists();
		// removeSelectItemsDefault();
		// addSelectItemsDefault();
		setSelectItemsDefault();
		saveStateContext();
	}

	public void carregaObjetos() {
		showToolbarButtons();
		clearLists();
		loadAllLists();
		loadTabsListsManyToMany();
		setSelectItems();
		saveStateContext();
	}

	public void loadAllLists() {
		loadLists();
		loadTabLists();
		loadSelectItems();
	}

	public String saveSuccess(Colaborador colab) {
		displayInfoMessageToUser("Colaborador " + colab.getApelido() + " foi salvo com sucesso!");
		return null;
	}

	public String saveFailure(Colaborador colab) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elContext = fc.getELContext();

		SelectLevelListener selectLevelListener;
		try {
			selectLevelListener = (SelectLevelListener) elContext.getELResolver().getValue(elContext, null, "selectLevelListener");
			selectLevelListener.setErrorOccured(2);
		} catch (RuntimeException e) {
			throw new FacesException(e.getMessage(), e);
		}

		displayErrorMessageToUser("Colaborador " + colab.getApelido() + " não pôde ser salvo!");

		return null;
	}

	public String deleteSuccess(Colaborador colab) {
		displayInfoMessageToUser("Colaborador " + colab.getApelido() + " foi excluído com sucesso!");
		return null;
	}

	public String deleteFailure(Colaborador colab) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elContext = fc.getELContext();

		SelectLevelListener selectLevelListener;
		try {
			selectLevelListener = (SelectLevelListener) elContext.getELResolver().getValue(elContext, null, "selectLevelListener");
			selectLevelListener.setErrorOccured(1);
		} catch (RuntimeException e) {
			throw new FacesException(e.getMessage(), e);
		}

		displayErrorMessageToUser("Colaborador " + colab.getApelido() + " não pôde ser deletado!");

		return null;
	}

	public void changeHorario() {
		TipoHorario horario = null;

		if (getDdlTipoHorario() != null && getDdlTipoHorario().getValue() != null) {
			horario = (TipoHorario) getDdlTipoHorario().getValue();
		} else if (getColaborador() != null && getColaborador().getTipoHorario() != null) {
			horario = getColaborador().getTipoHorario();
		} else if (!getListTipoHorario().isEmpty()) {
			horario = getListTipoHorario().get(0);
		} else {
			try {
				throw new Exception("Method changeHorario() não conseguiu settar horário.");
			} catch (Exception e) {
			}
		}

		switch (horario.getNome()) {
		case "Comercial": {
			getColaborador().setHoraManhaInicio(Time.valueOf("08:00:00"));
			getColaborador().setHoraManhaFim(Time.valueOf("12:00:00"));
			getColaborador().setHoraTardeInicio(Time.valueOf("14:00:00"));
			getColaborador().setHoraTardeFim(Time.valueOf("18:00:00"));
			getColaborador().setHoraNoiteInicio(Time.valueOf("00:00:00"));
			getColaborador().setHoraNoiteFim(Time.valueOf("00:00:00"));
			disabledHorario(true);
			break;
		}
		case "Diurno": {
			getColaborador().setHoraManhaInicio(Time.valueOf("08:00:00"));
			getColaborador().setHoraManhaFim(Time.valueOf("12:00:00"));
			getColaborador().setHoraTardeInicio(Time.valueOf("00:00:00"));
			getColaborador().setHoraTardeFim(Time.valueOf("00:00:00"));
			getColaborador().setHoraNoiteInicio(Time.valueOf("00:00:00"));
			getColaborador().setHoraNoiteFim(Time.valueOf("00:00:00"));
			disabledHorario(true);
			break;
		}
		case "Vespertino": {
			getColaborador().setHoraManhaInicio(Time.valueOf("00:00:00"));
			getColaborador().setHoraManhaFim(Time.valueOf("00:00:00"));
			getColaborador().setHoraTardeInicio(Time.valueOf("14:00:00"));
			getColaborador().setHoraTardeFim(Time.valueOf("18:00:00"));
			getColaborador().setHoraNoiteInicio(Time.valueOf("00:00:00"));
			getColaborador().setHoraNoiteFim(Time.valueOf("00:00:00"));
			disabledHorario(true);
			break;
		}
		case "Noturno": {
			getColaborador().setHoraManhaInicio(Time.valueOf("00:00:00"));
			getColaborador().setHoraManhaFim(Time.valueOf("00:00:00"));
			getColaborador().setHoraTardeInicio(Time.valueOf("00:00:00"));
			getColaborador().setHoraTardeFim(Time.valueOf("00:00:00"));
			getColaborador().setHoraNoiteInicio(Time.valueOf("18:00:00"));
			getColaborador().setHoraNoiteFim(Time.valueOf("22:00:00"));
			disabledHorario(true);
			break;
		}
		default: {
			getColaborador().setHoraManhaInicio(Time.valueOf("08:00:00"));
			getColaborador().setHoraManhaFim(Time.valueOf("12:00:00"));
			getColaborador().setHoraTardeInicio(Time.valueOf("14:00:00"));
			getColaborador().setHoraTardeFim(Time.valueOf("18:00:00"));
			getColaborador().setHoraNoiteInicio(Time.valueOf("00:00:00"));
			getColaborador().setHoraNoiteFim(Time.valueOf("00:00:00"));
			disabledHorario(false);
			break;
		}
		}

	}

	private void disabledHorario(boolean disable) {
		getCalDiaIni().setDisabled(disable);
		getCalDiaFim().setDisabled(disable);
		getCalTardeIni().setDisabled(disable);
		getCalTardeFim().setDisabled(disable);
		getCalNoiteIni().setDisabled(disable);
		getCalNoiteFim().setDisabled(disable);

	}

	public void saveStateContext() {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getSession(true);
		fc.getExternalContext().getSessionMap().put("colaborador", getColaborador());
	}

	public Colaborador getStateContext() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return (Colaborador) fc.getExternalContext().getSessionMap().get("colaborador");
	}

	public void clearLists() {
		getListCargo().clear();
		getListColaboradorRelacao().clear();
		getListEmpresa().clear();
		getListEstadoCivil().clear();
		getListFiliacao().clear();
		getListGrauInstrucao().clear();
		getListLotacao().clear();
		getListNacionalidade().clear();
		getListProfissao().clear();
		getListProvincia().clear();
		getListSetor().clear();
		getListTipoHorario().clear();
		getListTipoDocumento().clear();
	}

	@SuppressWarnings("unchecked")
	public void loadTabsListsManyToMany() {
		try {

			setListaEnderecos((List<ColaboradorEndereco>) getColaboradorBP().findEnderecos(ColaboradorEndereco.class, getColaborador().getId()));
			setListaDependentes((List<ColaboradorDependente>) getColaboradorBP().findDependentes(ColaboradorDependente.class, getColaborador().getId()));
			setListaDocumentos((List<ColaboradorDocumento>) getColaboradorBP().findDocumentos(ColaboradorDocumento.class, getColaborador().getId()));

			getDtbEndereco().setFilteredValue(getListaEnderecos());
			getDtbDependente().setFilteredValue(getListaDependentes());
			getDtbDocumento().setFilteredValue(getListaDocumentos());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showToolbarButtons() {
		getBtnEditar().setRendered(true);
		getBtnExcluir().setRendered(true);
	}

	public void hideToolbarButtons() {
		getBtnEditar().setRendered(false);
		getBtnExcluir().setRendered(false);
	}

	@SuppressWarnings("unchecked")
	public void loadTabLists() {

		try {
			setListTipoDocumento(((List<TipoDocumento>) getColaboradorBP().findAll(TipoDocumento.class)));
			setListFiliacao(((List<Filiacao>) getColaboradorBP().findAll(Filiacao.class)));
			setListProvincia(((List<Provincia>) getColaboradorBP().findAll(Provincia.class)));
			setListTipoVisto((List<TipoVisto>) getColaboradorBP().findAll(TipoVisto.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void loadTabSelectItems() {
	// populateSelectItemsFromList(getListTipoDocumento(),
	// getDdlTipoDocumento());
	// populateSelectItemsFromList(getListFiliacao(), getDdlFiliacao());
	// populateSelectItemsFromList(getListProvincia(), getDdlProvincia());
	// populateSelectItemsFromList(getListTipoVisto(), getDdlTipoVisto());
	// }

	public void setLists() {
		// getListSetor().add(getColaborador().getSetor());
		// getListCargo().add(getColaborador().getCargo());
		// getListColaboradorRelacao().add(getColaborador().getColaboradorRelacao());
		// getListEmpresa().add(getColaborador().getEmpresa());
		// getListEstadoCivil().add(getColaborador().getEstadoCivil());
		// getListGrauInstrucao().add(getColaborador().getGrauInstrucao());
		// getListLotacao().add(getColaborador().getLotacao());
		// getListNacionalidade().add(getColaborador().getNacionalidade());
		// getListProfissao().add(getColaborador().getProfissao());
		// getListTipoHorario().add(getColaborador().getTipoHorario());
	}

	@SuppressWarnings("unchecked")
	public void loadLists() {

		try {
			setListCargo((List<Cargo>) getColaboradorBP().findAll(Cargo.class));
			setListColaboradorRelacao((List<ColaboradorRelacao>) getColaboradorBP().findAll(ColaboradorRelacao.class));
			setListEmpresa((List<Empresa>) getColaboradorBP().findAll(Empresa.class));
			setListEstadoCivil((List<EstadoCivil>) getColaboradorBP().findAll(EstadoCivil.class));
			setListGrauInstrucao((List<GrauInstrucao>) getColaboradorBP().findAll(GrauInstrucao.class));
			setListLotacao((List<Lotacao>) getColaboradorBP().findAll(Lotacao.class));
			setListNacionalidade((List<Nacionalidade>) getColaboradorBP().findAll(Nacionalidade.class));
			setListProfissao((List<Profissao>) getColaboradorBP().findAll(Profissao.class));
			setListSetor((List<Setor>) getColaboradorBP().findAll(Setor.class));
			setListTipoHorario((List<TipoHorario>) getColaboradorBP().findAll(TipoHorario.class));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void loadSelectItems() {

		try {
			populateSelectItemsFromList(getListCargo(), getDdlCargo());
			populateSelectItemsFromList(getListColaboradorRelacao(), getDdlColaboradorRelacao());
			populateSelectItemsFromList(getListEmpresa(), getDdlEmpresa());
			populateSelectItemsFromList(getListEstadoCivil(), getDdlEstadoCivil());
			populateSelectItemsFromList(getListGrauInstrucao(), getDdlGrauInstrucao());
			populateSelectItemsFromList(getListLotacao(), getDdlLotacao());
			populateSelectItemsFromList(getListNacionalidade(), getDdlNacionalidade());
			populateSelectItemsFromList(getListProfissao(), getDdlProfissao());
			populateSelectItemsFromList(getListSetor(), getDdlSetor());
			populateSelectItemsFromList(getListTipoHorario(), getDdlTipoHorario());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearSelectItems() {

		try {
			clearSelectItemsFromList(getDdlCargo());
			clearSelectItemsFromList(getDdlColaboradorRelacao());
			clearSelectItemsFromList(getDdlEmpresa());
			clearSelectItemsFromList(getDdlEstadoCivil());
			clearSelectItemsFromList(getDdlGrauInstrucao());
			clearSelectItemsFromList(getDdlLotacao());
			clearSelectItemsFromList(getDdlNacionalidade());
			clearSelectItemsFromList(getDdlProfissao());
			clearSelectItemsFromList(getDdlSetor());
			clearSelectItemsFromList(getDdlTipoHorario());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSelectItems() {

		try {
			addItemSelectOneMenu(getDdlCargo(), getColaborador().getCargo(), getColaborador().getCargo().getNome());
			addItemSelectOneMenu(getDdlColaboradorRelacao(), getColaborador().getColaboradorRelacao(), getColaborador().getColaboradorRelacao().getNome());
			addItemSelectOneMenu(getDdlEmpresa(), getColaborador().getEmpresa(), getColaborador().getEmpresa().getApelido());
			addItemSelectOneMenu(getDdlEstadoCivil(), getColaborador().getEstadoCivil(), getColaborador().getEstadoCivil().getNome());
			addItemSelectOneMenu(getDdlGrauInstrucao(), getColaborador().getGrauInstrucao(), getColaborador().getGrauInstrucao().getNome());
			addItemSelectOneMenu(getDdlLotacao(), getColaborador().getLotacao(), getColaborador().getLotacao().getNome());
			addItemSelectOneMenu(getDdlNacionalidade(), getColaborador().getNacionalidade(), getColaborador().getNacionalidade().getNome());
			addItemSelectOneMenu(getDdlProfissao(), getColaborador().getProfissao(), getColaborador().getProfissao().getNome());
			addItemSelectOneMenu(getDdlSetor(), getColaborador().getSetor(), getColaborador().getSetor().getNome());
			addItemSelectOneMenu(getDdlTipoHorario(), getColaborador().getTipoHorario(), getColaborador().getTipoHorario().getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void removeSelectItems() {

		try {
			removeItemSelectOneMenu(getDdlCargo(), getColaborador().getCargo(), getColaborador().getCargo().getNome());
			removeItemSelectOneMenu(getDdlColaboradorRelacao(), getColaborador().getColaboradorRelacao(), getColaborador().getColaboradorRelacao().getNome());
			removeItemSelectOneMenu(getDdlEmpresa(), getColaborador().getEmpresa(), getColaborador().getEmpresa().getApelido());
			removeItemSelectOneMenu(getDdlEstadoCivil(), getColaborador().getEstadoCivil(), getColaborador().getEstadoCivil().getNome());
			removeItemSelectOneMenu(getDdlGrauInstrucao(), getColaborador().getGrauInstrucao(), getColaborador().getGrauInstrucao().getNome());
			removeItemSelectOneMenu(getDdlLotacao(), getColaborador().getLotacao(), getColaborador().getLotacao().getNome());
			removeItemSelectOneMenu(getDdlNacionalidade(), getColaborador().getNacionalidade(), getColaborador().getNacionalidade().getNome());
			removeItemSelectOneMenu(getDdlProfissao(), getColaborador().getProfissao(), getColaborador().getProfissao().getNome());
			removeItemSelectOneMenu(getDdlSetor(), getColaborador().getSetor(), getColaborador().getSetor().getNome());
			removeItemSelectOneMenu(getDdlTipoHorario(), getColaborador().getTipoHorario(), getColaborador().getTipoHorario().getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setSelectItems() {
		try {
			getDdlCargo().setValue(getColaborador().getCargo());
			getDdlColaboradorRelacao().setValue(getColaborador().getColaboradorRelacao());
			getDdlEmpresa().setValue(getColaborador().getEmpresa());
			getDdlEstadoCivil().setValue(getColaborador().getEstadoCivil());
			getDdlGrauInstrucao().setValue(getColaborador().getGrauInstrucao());
			getDdlLotacao().setValue(getColaborador().getLotacao());
			getDdlNacionalidade().setValue(getColaborador().getNacionalidade());
			getDdlProfissao().setValue(getColaborador().getProfissao());
			getDdlSetor().setValue(getColaborador().getSetor());
			getDdlSexo().setValue(getColaborador().getSexo());
			getDdlTipoHorario().setValue(getColaborador().getTipoHorario());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// public void addSelectItemsDefault() {
	//
	// addItemSelectOneMenu(getDdlColaboradorRelacao(), 0, "Selecione");
	// addItemSelectOneMenu(getDdlCargo(), 0, "Selecione");
	// addItemSelectOneMenu(getDdlEmpresa(), 0, "Selecione");
	// addItemSelectOneMenu(getDdlEstadoCivil(), 0, "Selecione");
	// addItemSelectOneMenu(getDdlGrauInstrucao(), 0, "Selecione");
	// addItemSelectOneMenu(getDdlLotacao(), 0, "Selecione");
	// addItemSelectOneMenu(getDdlNacionalidade(), 0, "Selecione");
	// addItemSelectOneMenu(getDdlProfissao(), 0, "Selecione");
	// addItemSelectOneMenu(getDdlSetor(), 0, "Selecione");
	// }
	//
	// public void removeSelectItemsDefault() {
	//
	// removeItemSelectOneMenu(getDdlColaboradorRelacao(), 0, "Selecione");
	// removeItemSelectOneMenu(getDdlCargo(), 0, "Selecione");
	// removeItemSelectOneMenu(getDdlEmpresa(), 0, "Selecione");
	// removeItemSelectOneMenu(getDdlEstadoCivil(), 0, "Selecione");
	// removeItemSelectOneMenu(getDdlGrauInstrucao(), 0, "Selecione");
	// removeItemSelectOneMenu(getDdlLotacao(), 0, "Selecione");
	// removeItemSelectOneMenu(getDdlNacionalidade(), 0, "Selecione");
	// removeItemSelectOneMenu(getDdlProfissao(), 0, "Selecione");
	// removeItemSelectOneMenu(getDdlSetor(), 0, "Selecione");
	// }

	public void setSelectItemsDefault() {

		try {

			getColaborador().setSexo('M');

			if (!getListColaboradorRelacao().isEmpty()) {
				getDdlColaboradorRelacao().setValue(getListColaboradorRelacao().get(0));
			}

			if (!getListCargo().isEmpty()) {
				getDdlCargo().setValue(getListCargo().get(0));
			}

			if (!getListEmpresa().isEmpty()) {
				getDdlEmpresa().setValue(getListEmpresa().get(0));
			}

			if (!getListEstadoCivil().isEmpty()) {
				getDdlEstadoCivil().setValue(getListEstadoCivil().get(0));
			}

			if (!getListGrauInstrucao().isEmpty()) {
				getDdlGrauInstrucao().setValue(getListGrauInstrucao().get(0));
			}

			if (!getListLotacao().isEmpty()) {
				getDdlLotacao().setValue(getListLotacao().get(0));
			}

			if (!getListNacionalidade().isEmpty()) {
				getDdlNacionalidade().setValue(getListNacionalidade().get(0));
			}

			if (!getListProfissao().isEmpty()) {
				getDdlProfissao().setValue(getListProfissao().get(0));
			}

			if (!getListSetor().isEmpty()) {
				getDdlSetor().setValue(getListSetor().get(0));
			}

			if (!getListTipoHorario().isEmpty()) {
				getDdlTipoHorario().setValue(getListTipoHorario().get(0));
			}

			setListaEnderecos(new ArrayList<ColaboradorEndereco>());
			setListaDependentes(new ArrayList<ColaboradorDependente>());
			setListaDocumentos(new ArrayList<ColaboradorDocumento>());

			getColaborador().setEnderecos(new ArrayList<ColaboradorEndereco>());
			getColaborador().setDependentes(new ArrayList<ColaboradorDependente>());
			getColaborador().setDocumentos(new ArrayList<ColaboradorDocumento>());

			getDtbEndereco().setFilteredValue(new ArrayList<>());
			getDtbDependente().setFilteredValue(new ArrayList<>());
			getDtbDocumento().setFilteredValue(new ArrayList<>());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSelectItemsClear() {

		try {
			getDdlColaboradorRelacao().getChildren().clear();
			getDdlCargo().getChildren().clear();
			getDdlEmpresa().getChildren().clear();
			getDdlEstadoCivil().getChildren().clear();
			getDdlGrauInstrucao().getChildren().clear();
			getDdlLotacao().getChildren().clear();
			getDdlNacionalidade().getChildren().clear();
			getDdlProfissao().getChildren().clear();
			getDdlProvincia().getChildren().clear();
			getDdlSetor().getChildren().clear();
			getDdlSexo().getChildren().clear();
			getDdlTipoEndereco().getChildren().clear();
			getDdlTipoHorario().getChildren().clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private <T> void populateSelectItemsFromList(List<?> Lista, Object ddlList) {

		HtmlSelectOneMenu selectOneMenu = null;

		if (ddlList instanceof HtmlSelectOneMenu) {
			selectOneMenu = (HtmlSelectOneMenu) ddlList;
		} else if (ddlList instanceof SelectOneMenu) {
			selectOneMenu = (SelectOneMenu) ddlList;
		}

		for (Object object : Lista) {
			try {
				Method methodLabel = object.getClass().getMethod("getNome", new Class<?>[] {});
				String itemLabel = ((String) methodLabel.invoke(object));
				addItemSelectOneMenu(selectOneMenu, object, itemLabel);

			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

	}

	private void clearSelectItemsFromList(SelectOneMenu ddlList) {
		for (UIComponent uiComp : ddlList.getChildren()) {
			UISelectItem item = (UISelectItem) uiComp;
			removeItemSelectOneMenu(ddlList, item.getItemValue(), item.getItemLabel());
		}
	}

	public void addItemSelectOneMenu(Object ddlList, Object itemValue, String itemLabel) {
		HtmlSelectOneMenu selectOneMenu = null;

		if (ddlList instanceof HtmlSelectOneMenu) {
			selectOneMenu = (HtmlSelectOneMenu) ddlList;
		} else if (ddlList instanceof SelectOneMenu) {
			selectOneMenu = (SelectOneMenu) ddlList;
		}

		UISelectItem item = new UISelectItem();
		item.setItemValue(itemValue);
		item.setItemLabel(itemLabel);
		selectOneMenu.getChildren().add(item);
	}

	public void removeItemSelectOneMenu(SelectOneMenu ddlList, Object itemValue, String itemLabel) {
		HtmlSelectOneMenu selectOneMenu = null;

		if (ddlList instanceof HtmlSelectOneMenu) {
			selectOneMenu = (HtmlSelectOneMenu) ddlList;
		} else if (ddlList instanceof SelectOneMenu) {
			selectOneMenu = (SelectOneMenu) ddlList;
		}

		UISelectItem item = new UISelectItem();
		item.setItemValue(itemValue);
		item.setItemLabel(itemLabel);
		selectOneMenu.getChildren().remove(item);
	}

	public String addEnderecoRow() {
		ColaboradorEndereco colEnd = new ColaboradorEndereco();
		colEnd.setColaborador(getColaborador());
		colEnd.setEndereco("");
		colEnd.setProvincia(new Provincia());
		getListaEnderecos().add(colEnd);

		return null;

	}

	public String addDependenteRow() {
		ColaboradorDependente colDep = new ColaboradorDependente();
		colDep.setColaborador(getColaborador());
		colDep.setNome("");
		colDep.setDataNascimento(new Date());
		colDep.setFiliacao(new Filiacao());

		getListaDependentes().add(colDep);

		return null;
	}

	public String addDocumentoRow() {
		ColaboradorDocumento colDoc = new ColaboradorDocumento();
		colDoc.setColaborador(getColaborador());
		colDoc.setClassificacaoDocumento("");
		colDoc.setNumDocumento("");
		colDoc.setLocalEmissao(new Provincia());
		colDoc.setTipoDocumento(new TipoDocumento());
		colDoc.setDataEmissao(new Date());
		colDoc.setDataValidade(new Date());
		getListaDocumentos().add(colDoc);

		return null;

	}

	// public void changeClassDocumento(ColaboradorDocumento colDoc) {
	// if (colDoc.getTipoDocumento() != null &&
	// colDoc.getTipoDocumento().getNome().equals("Visto")) {
	// getDdlTipoVisto().setRendered(true);
	// getDocClass().setRendered(false);
	// // getDdlTipoVisto().setStyle("display: inline");
	// // getDocClass().setStyle("display: none");
	//
	// } else {
	// getDdlTipoVisto().setRendered(false);
	// getDocClass().setRendered(true);
	// // getDdlTipoVisto().setStyle("display: none");
	// // getDocClass().setStyle("display: inline");
	// }
	//
	// }

	public void removeEnderecoRow() {
		if (getListaEnderecos() != null && !getListaEnderecos().isEmpty()) {
			ColaboradorEndereco colEnd = new ColaboradorEndereco();
			for (int i = 0; i < getListaEnderecos().size(); i++) {

				colEnd = getListaEnderecos().get(i);

				if (colEnd.getEndereco().trim().equals("") || colEnd.getProvincia() == null || colEnd.getProvincia().getId() == null || colEnd.getTipoEndereco() == null) {
					getListaEnderecos().remove(i);
				}
			}
		}
	}

	public void removeDependenteRow() {
		if (getListaDependentes() != null && !getListaDependentes().isEmpty()) {
			ColaboradorDependente colDep = new ColaboradorDependente();
			for (int i = 0; i < getListaDependentes().size(); i++) {

				colDep = getListaDependentes().get(i);

				if (colDep.getNome().trim().equals("") || colDep.getFiliacao() == null || colDep.getFiliacao().getId() == null || colDep.getDataNascimento() == null) {
					getListaDependentes().remove(i);
				}
			}
		}
	}

	public void removeDocumentoRowEdit() {
		removeDocumentoRow(true);
	}

	public void removeDocumentoRowEditCancel() {
		removeDocumentoRow(false);
	}
	
	public void removeDocumentoRow(){
		removeDocumentoRow(false);
	}

	private void removeDocumentoRow(boolean isDone) {

		if (getListaDocumentos() != null && !getListaDocumentos().isEmpty()) {
			ColaboradorDocumento colDoc = new ColaboradorDocumento();
			for (int i = 0; i < getListaDocumentos().size(); i++) {

				colDoc = getListaDocumentos().get(i);

				if (((colDoc.getClassificacaoDocumento() == null || colDoc.getClassificacaoDocumento().trim().equals("")) && colDoc.getTipoVisto() == null) 
						|| (colDoc.getDataEmissao() == null) 
						|| (colDoc.getDataValidade() == null) 
						|| (colDoc.getNumDocumento() == null || colDoc.getNumDocumento().trim().equals(""))) {

					getListaDocumentos().remove(i);

				} else if (isDone) {
					if (getListaDocumentos().get(i).getTipoDocumento().getNome().equals("Visto")) {
						getListaDocumentos().get(i).setClassificacaoDocumento(null);
					} else {
						getListaDocumentos().get(i).setTipoVisto(null);
					}
				}
			}
		}
	}
	
	// public void removeDocumentoAtList(ColaboradorDocumento colDoc) {
	// for (int i = 0; i < getListaDocumentos().size(); i++) {
	// if (getListaDocumentos().get(i).equals(colDoc)) {
	// getListaDocumentos().remove(i);
	// break;
	// }
	// }
	// }

	// public void clearClassificacaoDocumento(ColaboradorDocumento colDoc) {
	// for (int i = 0; i < getListaDocumentos().size(); i++) {
	// if (colDoc.equals(getListaDocumentos().get(i))) {
	// if
	// (getListaDocumentos().get(i).getTipoDocumento().getNome().equals("Visto"))
	// {
	// getListaDocumentos().get(i).setClassificacaoDocumento(null);
	// } else {
	// getListaDocumentos().get(i).setTipoVisto(null);
	// }
	// break;
	// }
	// }
	// }

	// public void removeDocumentoRow(ColaboradorDocumento colDoc) {
	// if (((colDoc.getClassificacaoDocumento() == null ||
	// colDoc.getClassificacaoDocumento().trim().equals("")) &&
	// colDoc.getTipoVisto() == null)
	// || (colDoc.getDataEmissao() == null)
	// || (colDoc.getDataValidade() == null)
	// || (colDoc.getNumDocumento() == null ||
	// colDoc.getNumDocumento().trim().equals(""))) {
	//
	// getListaDocumentos().remove(colDoc);
	// }
	// }

	public void removeRowOnButton(ColaboradorDocumento documento) {
		for (int i = 0; i < getListaDocumentos().size(); i++) {
			if(getListaDocumentos().get(i).getNumDocumento().equals(documento.getNumDocumento())){
				getListaDocumentos().remove(i);
			}
		}
	}

	public void loadApelido() {
		String nomeSubtr = getColaborador().getNome();

		if (nomeSubtr.indexOf(" ") != -1) {
			nomeSubtr = nomeSubtr.substring(0, nomeSubtr.indexOf(" "));
			getColaborador().setApelido(nomeSubtr);
		}

	}

	public void emailValidator() {
		Utils.emailValidate(getColaborador().getEmail());
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
		if (colaborador == null) {
			colaborador = new Colaborador();
		}

		return colaborador;
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

	public List<Nacionalidade> getListNacionalidade() {
		return listNacionalidade;
	}

	public void setListNacionalidade(List<Nacionalidade> listNacionalidade) {
		this.listNacionalidade = listNacionalidade;
	}

	public SelectOneMenu getDdlNacionalidade() {
		return ddlNacionalidade;
	}

	public void setDdlNacionalidade(SelectOneMenu ddlNacionalidade) {
		this.ddlNacionalidade = ddlNacionalidade;
	}

	public List<Provincia> getListProvincia() {
		return listProvincia;
	}

	public void setListProvincia(List<Provincia> listProvincia) {
		this.listProvincia = listProvincia;
	}

	public SelectOneMenu getDdlProvincia() {
		return ddlProvincia;
	}

	public void setDdlProvincia(SelectOneMenu ddlProvincia) {
		this.ddlProvincia = ddlProvincia;
	}

	public List<String> getListSexo() {
		return listSexo;
	}

	public void setListSexo(List<String> listSexo) {
		this.listSexo = listSexo;
	}

	public SelectOneMenu getDdlSexo() {
		return ddlSexo;
	}

	public void setDdlSexo(SelectOneMenu ddlSexo) {
		this.ddlSexo = ddlSexo;
	}

	public SelectOneMenu getDdlTipoDocumento() {
		return ddlTipoDocumento;
	}

	public void setDdlTipoDocumento(SelectOneMenu ddlTipoDocumento) {
		this.ddlTipoDocumento = ddlTipoDocumento;
	}

	public List<Filiacao> getListFiliacao() {
		return listFiliacao;
	}

	public void setListFiliacao(List<Filiacao> listFiliacao) {
		this.listFiliacao = listFiliacao;
	}

	public SelectOneMenu getDdlFiliacao() {
		return ddlFiliacao;
	}

	public void setDdlFiliacao(SelectOneMenu ddlFiliacao) {
		this.ddlFiliacao = ddlFiliacao;
	}

	public List<TipoDocumento> getListTipoDocumento() {
		return listTipoDocumento;
	}

	public void setListTipoDocumento(List<TipoDocumento> listTipoDocumento) {
		this.listTipoDocumento = listTipoDocumento;
	}

	public List<String> getListTipoEndereco() {
		return listTipoEndereco;
	}

	public void setListTipoEndereco(List<String> listTipoEndereco) {
		this.listTipoEndereco = listTipoEndereco;
	}

	public SelectOneMenu getDdlTipoEndereco() {
		return ddlTipoEndereco;
	}

	public void setDdlTipoEndereco(SelectOneMenu ddlTipoEndereco) {
		this.ddlTipoEndereco = ddlTipoEndereco;
	}

	public Calendar getCalDiaIni() {
		return calDiaIni;
	}

	public void setCalDiaIni(Calendar calDiaIni) {
		this.calDiaIni = calDiaIni;
	}

	public Calendar getCalDiaFim() {
		return calDiaFim;
	}

	public void setCalDiaFim(Calendar calDiaFim) {
		this.calDiaFim = calDiaFim;
	}

	public Calendar getCalTardeIni() {
		return calTardeIni;
	}

	public void setCalTardeIni(Calendar calTardeIni) {
		this.calTardeIni = calTardeIni;
	}

	public Calendar getCalTardeFim() {
		return calTardeFim;
	}

	public void setCalTardeFim(Calendar calTardeFim) {
		this.calTardeFim = calTardeFim;
	}

	public Calendar getCalNoiteIni() {
		return calNoiteIni;
	}

	public void setCalNoiteIni(Calendar calNoiteIni) {
		this.calNoiteIni = calNoiteIni;
	}

	public Calendar getCalNoiteFim() {
		return calNoiteFim;
	}

	public void setCalNoiteFim(Calendar calNoiteFim) {
		this.calNoiteFim = calNoiteFim;
	}

	public SelectOneMenu getDdlProvinciaCad() {
		return ddlProvinciaCad;
	}

	public void setDdlProvinciaCad(SelectOneMenu ddlProvinciaCad) {
		this.ddlProvinciaCad = ddlProvinciaCad;
	}

	public DataTable getDtbColaborador() {
		return dtbColaborador;
	}

	public void setDtbColaborador(DataTable dtbColaborador) {
		this.dtbColaborador = dtbColaborador;
	}

	public DataTable getDtbEndereco() {
		return dtbEndereco;
	}

	public void setDtbEndereco(DataTable dtbEndereco) {
		this.dtbEndereco = dtbEndereco;
	}

	public DataTable getDtbDependente() {
		return dtbDependente;
	}

	public void setDtbDependente(DataTable dtbDependente) {
		this.dtbDependente = dtbDependente;
	}

	public DataTable getDtbDocumento() {
		return dtbDocumento;
	}

	public void setDtbDocumento(DataTable dtbDocumento) {
		this.dtbDocumento = dtbDocumento;
	}

	public List<ColaboradorEndereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<ColaboradorEndereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}

	public List<ColaboradorDependente> getListaDependentes() {
		return listaDependentes;
	}

	public void setListaDependentes(List<ColaboradorDependente> listaDependentes) {
		this.listaDependentes = listaDependentes;
	}

	public List<ColaboradorDocumento> getListaDocumentos() {
		return listaDocumentos;
	}

	public void setListaDocumentos(List<ColaboradorDocumento> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}

	public List<TipoVisto> getListTipoVisto() {
		return listTipoVisto;
	}

	public void setListTipoVisto(List<TipoVisto> listTipoVisto) {
		this.listTipoVisto = listTipoVisto;
	}

	public InputText getDocClass() {
		return docClass;
	}

	public void setDocClass(InputText docClass) {
		this.docClass = docClass;
	}

	// public HtmlSelectOneMenu getDdlTipoVisto() {
	// return ddlTipoVisto;
	// }
	//
	// public void setDdlTipoVisto(HtmlSelectOneMenu ddlTipoVisto) {
	// this.ddlTipoVisto = ddlTipoVisto;
	// }

	public HtmlSelectOneMenu getDdlTipoVisto() {
		return ddlTipoVisto;
	}

	public void setDdlTipoVisto(HtmlSelectOneMenu ddlTipoVisto) {
		this.ddlTipoVisto = ddlTipoVisto;
	}

}
