//package com.patrimonio.controller;
//
//import java.io.Serializable;
//
//import javax.el.ELContext;
//import javax.faces.FacesException;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//
//import com.patrimonio.model.Colaborador;
//
//@ManagedBean
//@ViewScoped
//public class ExampleMB implements Serializable {
//
//	private static final long serialVersionUID = 20111120L;
//
//	private List<Person> persons;
//	private List<SelectItem> availableLanguageSkills = null;
//	private List<String> selectedLanguageSkills = new ArrayList<String>();
//	private String languageSkillToAdd;
//
//	public ExampleMB() {
//		if (persons == null) {
//			persons = new ArrayList<Person>();
//
//			Calendar calendar = Calendar.getInstance();
//			calendar.set(1972, 5, 25);
//			persons.add(new Person("1", "Max Mustermann", 1, calendar.getTime()));
//			calendar.set(1981, 12, 10);
//			persons.add(new Person("2", "Sara Schmidt", 2, calendar.getTime()));
//			calendar.set(1968, 2, 13);
//			persons.add(new Person("3", "Jasper Morgan", 3, calendar.getTime()));
//		}
//	}
//
//	public List<Person> getPersons() {
//		return persons;
//	}
//
//	public List<SelectItem> getAvailableLanguageSkills() {
//		if (availableLanguageSkills == null) {
//			availableLanguageSkills = new ArrayList<SelectItem>();
//			availableLanguageSkills.add(new SelectItem("English", "English"));
//			availableLanguageSkills.add(new SelectItem("German", "German"));
//			availableLanguageSkills.add(new SelectItem("Russian", "Russian"));
//			availableLanguageSkills.add(new SelectItem("Turkish", "Turkish"));
//			availableLanguageSkills.add(new SelectItem("Dutch", "Dutch"));
//			availableLanguageSkills.add(new SelectItem("French", "French"));
//			availableLanguageSkills.add(new SelectItem("Italian", "Italian"));
//		}
//
//		return availableLanguageSkills;
//	}
//
//	public List<String> getSelectedLanguageSkills() {
//		return selectedLanguageSkills;
//	}
//
//	public void setLanguageSkillToAdd(String languageSkillToAdd) {
//		this.languageSkillToAdd = languageSkillToAdd;
//	}
//
//	public String getLanguageSkillToAdd() {
//		return languageSkillToAdd;
//	}
//
//	public String saveSuccess(Colaborador colab) {
//		FacesMessage message =
//		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Person " + colab.getNome()+ " has been saved", null);
//		FacesContext.getCurrentInstance().addMessage(null, message);
//
//		return null;
//	}
//
//	public String saveFailure(Colaborador colab) {
//		FacesContext fc = FacesContext.getCurrentInstance();
//		ELContext elContext = fc.getELContext();
//
//		SelectLevelListener selectLevelListener;
//		 try {
//			selectLevelListener =
//			    (SelectLevelListener) elContext.getELResolver().getValue(elContext, null, "selectLevelListener");
//			selectLevelListener.setErrorOccured(true);
//		} catch (RuntimeException e) {
//			throw new FacesException(e.getMessage(), e);
//		}
//
//		FacesMessage message =
//		    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Person " + colab.getNome()+ " could not be saved", null);
//		FacesContext.getCurrentInstance().addMessage(null, message);
//
//		return null;
//	}
//
//	public String delete(Person person) {
//		for (Person pers : persons) {
//			if (pers.getId().equals(person.getId())) {
//				persons.remove(pers);
//
//				break;
//			}
//		}
//
//		return null;
//	}
//
//	public void addLanguageSkill(Person person) {
//		if (languageSkillToAdd != null) {
//			person.addLanguageSkill(languageSkillToAdd);
//		}
//
//		languageSkillToAdd = null;
//	}
//}
