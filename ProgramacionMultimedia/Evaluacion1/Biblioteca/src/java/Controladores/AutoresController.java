package Controladores;

import Entidades.Autores;
import Controladores.util.JsfUtil;
import Controladores.util.PaginationHelper;
import Entidades.AutorPremio;
import Entidades.Paises;
import Entidades.Premios;
import Facades.AutoresFacade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("autoresController")
@SessionScoped
public class AutoresController implements Serializable {

    private Autores current;
    private DataModel items = null;
    @EJB
    private Facades.AutoresFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Premios premio;
    private AutorPremio autorPremio;
    private List<AutorPremio> listaAP;
    
    private Paises pais;
    private List<Autores> listaAPaises;
    private List<Premios> listaPPaises;

    public AutoresController() {
    }
 
    public List<Premios> getListaPPaises() {
        return listaPPaises;
    }

    public void setListaPPaises(List<Premios> listaPPaises) {
        this.listaPPaises = listaPPaises;
    }
    
    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public List<Autores> getListaAPaises() {
        return listaAPaises;
    }

    public void setListaAPaises(List<Autores> listaAPaieses) {
        this.listaAPaises = listaAPaieses;
    }

    
    public List<AutorPremio> getListaAP() {
        return listaAP;
    }

    public void setListaAP(List<AutorPremio> listaAP) {
        this.listaAP = listaAP;
    }
    
    public Premios getPremio() {
        return premio;
    }

    public void setPremio(Premios premio) {
        this.premio = premio;
    }

    public Autores getSelected() {
        if (current == null) {
            current = new Autores();
            selectedItemIndex = -1;
        }
        return current;
    }

    private AutoresFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(getItemsAvailableSelectMany().length) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Autores) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Autores();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AutoresCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Autores) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AutoresUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Autores) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AutoresDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return getSelectItems(ejbFacade.autores_orden(), true);
    }
    
    public SelectItem[] getItemsAvailableSelectOnePais() {
        return getSelectItems(ejbFacade.autores_pais(pais), true);
    }
    
    public SelectItem[] getItemsAvailableSelectOnePremio() {
        return getSelectItems(ejbFacade.autores_premio(premio), true);
    }

    public Autores getAutores(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Autores.class, value = "AutorConverter")
    public static class AutoresControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AutoresController controller = (AutoresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "autoresController");
            return controller.getAutores(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Autores) {
                Autores o = (Autores) object;
                return getStringKey(o.getCodAutor());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Autores.class.getName());
            }
        }

    }
    
     public int calcularEdad(Date fnac){
         Calendar fecha_actual = Calendar.getInstance();
         Calendar fecha_nac = Calendar.getInstance();
         fecha_nac.setTime(fnac);
         
         int edad = fecha_actual.get(Calendar.YEAR) - fecha_nac.get(Calendar.YEAR);
         int mes = fecha_actual.get(Calendar.MONTH) - fecha_nac.get(Calendar.MONTH);
         int dia = fecha_actual.get(Calendar.DATE) - fecha_nac.get(Calendar.DATE);
         
         if (mes < 0) {
             edad -= 1;
         }
         else if (mes == 0){
             if(dia < 0){
                 edad -= 1;
             }   
         }
         return edad;
     }
     
     public String mostrarEdad(Autores autor){
         Date fecha_def = autor.getFDef();
         if (autor.getFDef() == null) {
             return null;
         }
         else{
             return "muerto";
         }
     }
     
    public static SelectItem[] getSelectItems(List<Autores> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "Selecciona un autor");
            i++;
        }
        for (Autores x : entities) {
            items[i++] = new SelectItem(x, x.getApellido1() /*+ " " + x.getApellido2()*/ + ", " + x.getNomAutor());
        }
        return items;
    }
    
    public void cargarAutoresPremios(){
        listaAP = ejbFacade.autores_por_premio(premio);
    }

    public void cargarAutoresPaises(){
        listaAPaises = ejbFacade.autores_por_pais(pais);
    }
}
