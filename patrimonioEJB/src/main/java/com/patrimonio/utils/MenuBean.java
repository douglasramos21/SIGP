


















//package com.consultorio.utils;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;  
//import javax.faces.application.FacesMessage.Severity;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;  
//import javax.faces.event.AbortProcessingException;
//import javax.faces.event.ActionEvent;
//import javax.faces.event.ActionListener;
//
//import org.primefaces.component.commandlink.CommandLink;
//import org.primefaces.component.menuitem.MenuItem;  
//import org.primefaces.component.submenu.Submenu;  
//import org.primefaces.context.RequestContext;
//import org.primefaces.model.DefaultMenuModel;  
//import org.primefaces.model.MenuModel;  
//  
//public class MenuBean implements Serializable, ActionListener  {
//
//   /**
//	 * 
//	 */
//	private static final long serialVersionUID = -4410630818538616586L;
//
//@Override
//    public void processAction(ActionEvent ae) throws AbortProcessingException 
//    {
//                CommandLink itm = (CommandLink)ae.getSource();
//                String menu_name = itm.getValue().toString();
//                String message = "CLICK ON MENU ITEM: " + menu_name;
//                Severity severity = FacesMessage.SEVERITY_INFO;
//
//                FacesMessage msg = new FacesMessage(severity, "PROGRAM SELECT", message);
//
//                FacesContext.getCurrentInstance().addMessage(null, msg);
//
//                RequestContext requestContext = RequestContext.getCurrentInstance();
//                
//                requestContext.update("");
//
//    }
//
//    public class MenuList implements Serializable{
//
//        /**
//		 * 
//		 */
//		private static final long serialVersionUID = -1663441308736049503L;
//		
//		private String id;
//        private String name;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//    }
//
//    public class MenuTab implements Serializable {
//
//        /**
//		 * 
//		 */
//		private static final long serialVersionUID = 3833715486971602275L;
//		private String id;
//        private String title;
//        private List<MenuList> list;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public List<MenuList> getList() {
//            return list;
//        }
//
//        public void setList(List<MenuList> list) {
//            this.list = list;
//        }
//    }
//
//    private List<MenuTab> menus = new ArrayList<MenuTab>();
//
//    public List<MenuTab> getMenus() {
//        return menus;
//    }
//
//    @PostConstruct
//    private void initModel() {
//
//        List<MenuList> list;
//        MenuTab tab;
//        MenuList item;
//
//        for(int i=1; i< 4; i++){
//                list = new ArrayList<MenuList>();
//                tab = new MenuTab();        
//                tab.setId("tab" + i);
//                tab.setTitle("Menu "+i);
//
//                for(int j=1; j<5; j++){
//                      item = new MenuList();
//                      item.setId();
//                      item.setName("Submenu "+i+" - "+j);
//        
//                      list.add(item);
//               }
//
//               tab.setList(list);
//               menus.add(tab);
//
//       }
//
//    }
//
//}