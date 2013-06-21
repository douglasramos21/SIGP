package com.patrimonio.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.patrimonio.master.EntityBean;
import com.patrimonio.utils.Utils;

@Entity
@Table(schema = "public", name = "colaborador")
public class Colaborador extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public Colaborador() {
	}

	/**
	 * 
	 */
	private Setor setor;
	private Empresa empresa;
	private Cargo cargo;
	private Lotacao lotacao;
	private Nacionalidade nacionalidade;
	private ColaboradorSituacao colaboradorSituacao;
	private ColaboradorRelacao colaboradorRelacao;
	private String nome;
	private String nomeMae;
	private String nomePai;
	private String nomeConjugue;
	private String apelido;
	private Date dataNascimento;
	private Date dataAdmissao;
	private Character sexo;
	private EstadoCivil estadoCivil;
	private Provincia localNascimento;
	private GrauInstrucao grauInstrucao;
	private Profissao profissao;
	private TipoHorario tipoHorario;
	private String email;
	private String skype;
	private Double salarioBase;
	private String observacao;
	private Time horaManhaInicio;
	private Time horaManhaFim;
	private Time horaTardeInicio;
	private Time horaTardeFim;
	private Time horaNoiteInicio;
	private Time horaNoiteFim;
	private Date dataDesligamento;
	private Integer numMatricula;
	private List<ColaboradorDependente> dependentes = new ArrayList<ColaboradorDependente>();
	private List<ColaboradorDocumento> documentos = new ArrayList<ColaboradorDocumento>();
	private List<ColaboradorEndereco> enderecos = new ArrayList<ColaboradorEndereco>();

	/**
	 * 
	 * M�todos
	 */

	/**
	 * Joins Columns
	 */

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_setor")
	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cargo")
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lotacao")
	public Lotacao getLotacao() {
		return lotacao;
	}

	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_nacionalidade")
	public Nacionalidade getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Nacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colaborador_situacao")
	public ColaboradorSituacao getColaboradorSituacao() {
		return colaboradorSituacao;
	}

	public void setColaboradorSituacao(ColaboradorSituacao colaboradorSituacao) {
		this.colaboradorSituacao = colaboradorSituacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colaborador_relacao")
	public ColaboradorRelacao getColaboradorRelacao() {
		return colaboradorRelacao;
	}

	public void setColaboradorRelacao(ColaboradorRelacao colaboradorRelacao) {
		this.colaboradorRelacao = colaboradorRelacao;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "apelido")
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@Column(name = "data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "sexo")
	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado_civil")
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grau_instrucao")
	public GrauInstrucao getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(GrauInstrucao grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profissao")
	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "skype")
	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	@Column(name = "salario_base")
	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	@Column(name = "observacao")
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_horario")
	public TipoHorario getTipoHorario() {
		return tipoHorario;
	}

	public void setTipoHorario(TipoHorario tipoHorario) {
		this.tipoHorario = tipoHorario;
	}

	@Column(name = "hora_manha_inicio")
	public Time getHoraManhaInicio() {
		return horaManhaInicio;
	}

	public void setHoraManhaInicio(Time horaManhaInicio) {
		this.horaManhaInicio = horaManhaInicio;
	}

	@Column(name = "hora_manha_fim")
	public Time getHoraManhaFim() {
		return horaManhaFim;
	}

	public void setHoraManhaFim(Time horaManhaFim) {
		this.horaManhaFim = horaManhaFim;
	}

	@Column(name = "hora_tarde_inicio")
	public Time getHoraTardeInicio() {
		return horaTardeInicio;
	}

	public void setHoraTardeInicio(Time horaTardeInicio) {
		this.horaTardeInicio = horaTardeInicio;
	}

	@Column(name = "hora_tarde_fim")
	public Time getHoraTardeFim() {
		return horaTardeFim;
	}

	public void setHoraTardeFim(Time horaTardeFim) {
		this.horaTardeFim = horaTardeFim;
	}

	@Column(name = "hora_noite_inicio")
	public Time getHoraNoiteInicio() {
		return horaNoiteInicio;
	}

	public void setHoraNoiteInicio(Time horaNoiteInicio) {
		this.horaNoiteInicio = horaNoiteInicio;
	}

	@Column(name = "hora_noite_fim")
	public Time getHoraNoiteFim() {
		return horaNoiteFim;
	}

	public void setHoraNoiteFim(Time horaNoiteFim) {
		this.horaNoiteFim = horaNoiteFim;
	}

	@Column(name = "nome_mae")
	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	@Column(name = "nome_pai")
	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	@Column(name = "nome_conjugue")
	public String getNomeConjugue() {
		return nomeConjugue;
	}

	public void setNomeConjugue(String nomeConjugue) {
		this.nomeConjugue = nomeConjugue;
	}

	@Column(name = "data_admissao")
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	@Transient
	public String getDataAdmissaoFormatada() {
		return Utils.dataFormatPt(getDataAdmissao());
	}

	@Transient
	public String getDataNascimentoFormatada() {
		return Utils.dataFormatPt(getDataNascimento());
	}

	@Transient
	public String getSexoFormatado() {
		return Utils.sexoCharForString(getSexo());
	}

	@Column(name = "data_desligamento")
	public Date getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(Date dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia")
	public Provincia getLocalNascimento() {
		return localNascimento;
	}

	public void setLocalNascimento(Provincia localNascimento) {
		this.localNascimento = localNascimento;
	}

	@OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<ColaboradorDependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<ColaboradorDependente> dependentes) {
		this.dependentes = dependentes;
	}

	@OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<ColaboradorEndereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<ColaboradorEndereco> enderecos) {
		this.enderecos = enderecos;
	}

	@OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<ColaboradorDocumento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<ColaboradorDocumento> documentos) {
		this.documentos = documentos;
	}

	public void setNumMatricula(Integer numMatricula) {
		this.numMatricula = numMatricula;
	}

	@Column(name = "num_matricula")
	public Integer getNumMatricula() {
		return numMatricula;
	}

}
