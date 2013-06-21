package com.patrimonio.service;

import java.io.Serializable;
import java.util.List;

import com.patrimonio.data.ColaboradorDAO;
import com.patrimonio.master.BusinessProcess;
import com.patrimonio.master.EntityBean;
import com.patrimonio.model.Colaborador;
import com.patrimonio.model.ColaboradorDependente;
import com.patrimonio.model.ColaboradorDocumento;
import com.patrimonio.model.ColaboradorEndereco;

public class ColaboradorBP extends BusinessProcess implements Serializable {

	private static final long serialVersionUID = -2807857432081560884L;

	@Override
	public EntityBean delete(EntityBean entity) throws Exception {
		return getDao().delete(entity);
	}

	@Override
	public void save(EntityBean entity) throws Exception {
		getDao().save(entity);
	}

	@Override
	public List<? extends EntityBean> findAll(Class<? extends EntityBean> entityClass) {
		List<? extends EntityBean> findAll = getDao().findAll(entityClass);
		return (List<? extends EntityBean>) findAll;
	}

	@SuppressWarnings("unchecked")
	public List<? extends EntityBean> findEnderecos(Class<? extends EntityBean> entityClass, int entityId) {
		List<ColaboradorEndereco> lista = (List<ColaboradorEndereco>) getDao().findTabsByColaborador(entityClass, entityId);
		return (List<ColaboradorEndereco>) lista;
	}

	@SuppressWarnings("unchecked")
	public List<? extends EntityBean> findDependentes(Class<? extends EntityBean> entityClass, int entityId) {
		List<ColaboradorDependente> lista = (List<ColaboradorDependente>) getDao().findTabsByColaborador(entityClass, entityId);
		return (List<ColaboradorDependente>) lista;
	}

	@SuppressWarnings("unchecked")
	public List<? extends EntityBean> findDocumentos(Class<? extends EntityBean> entityClass, int entityId) {
		List<ColaboradorDocumento> lista = (List<ColaboradorDocumento>) getDao().findTabsByColaborador(entityClass, entityId);
		return (List<ColaboradorDocumento>) lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends EntityBean> findById(Class<? extends EntityBean> entityClass, int entityId) {
		List<Colaborador> lista = (List<Colaborador>) getDao().findTabsByColaborador(entityClass, entityId);
		return (List<Colaborador>) lista;
	}

	public ColaboradorDAO getDao() {
		return new ColaboradorDAO();
	}

	/*
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findCargos(Class<? extends EntityBean> entityClass, int entityId) {
	 * List<Cargo> lista = (List<Cargo>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<Cargo>) lista; }
	 * 
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findSetores(Class<? extends EntityBean> entityClass, int entityId) {
	 * List<Setor> lista = (List<Setor>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<Setor>) lista; }
	 * 
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findColaboradoresRelacao(Class<? extends EntityBean> entityClass, int
	 * entityId) { List<ColaboradorRelacao> lista = (List<ColaboradorRelacao>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<ColaboradorRelacao>) lista; }
	 * 
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findEmpresas(Class<? extends EntityBean> entityClass, int entityId) {
	 * List<Empresa> lista = (List<Empresa>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<Empresa>) lista; }
	 * 
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findEstadoCivil(Class<? extends EntityBean> entityClass, int entityId) {
	 * List<EstadoCivil> lista = (List<EstadoCivil>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<EstadoCivil>) lista; }
	 * 
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findGrauInstrucao(Class<? extends EntityBean> entityClass, int entityId)
	 * { List<GrauInstrucao> lista = (List<GrauInstrucao>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<GrauInstrucao>) lista; }
	 * 
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findLotacao(Class<? extends EntityBean> entityClass, int entityId) {
	 * List<Lotacao> lista = (List<Lotacao>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<Lotacao>) lista; }
	 * 
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findNacionalidade(Class<? extends EntityBean> entityClass, int entityId)
	 * { List<Nacionalidade> lista = (List<Nacionalidade>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<Nacionalidade>) lista; }
	 * 
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findProfissao(Class<? extends EntityBean> entityClass, int entityId) {
	 * List<Profissao> lista = (List<Profissao>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<Profissao>) lista; }
	 * 
	 * @SuppressWarnings("unchecked") public List<? extends EntityBean>
	 * findTipoHorario(Class<? extends EntityBean> entityClass, int entityId) {
	 * List<TipoHorario> lista = (List<TipoHorario>)
	 * dao.findAllAndRemoveEqualObject(entityClass, entityId); return
	 * (List<TipoHorario>) lista; }
	 */

}
