package Controladores;

import Entidades.Productopropio;
import Controladores.util.JsfUtil;
import Controladores.util.PaginationHelper;
import Entidades.Componente;
import Entidades.Productocomponente;
import Repositorios.ProductopropioFacade;

import java.io.Serializable;
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

@Named("productopropioController")
@SessionScoped
public class ProductopropioController implements Serializable {

    private Productopropio current;
    private DataModel items = null;
    @EJB
    private Repositorios.ProductopropioFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    private Componente componente;
    private List<Productocomponente> listaProductospropiosComponentes;

    public ProductopropioController() {
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public List<Productocomponente> getListaProductospropiosComponentes() {
        return listaProductospropiosComponentes;
    }

    public void setListaProductospropiosComponentes(List<Productocomponente> listaProductospropiosComponentes) {
        this.listaProductospropiosComponentes = listaProductospropiosComponentes;
    }

    
    
    public Productopropio getSelected() {
        if (current == null) {
            current = new Productopropio();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProductopropioFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

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
        current = (Productopropio) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Productopropio();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductopropioCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Productopropio) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductopropioUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Productopropio) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductopropioDeleted"));
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
        return getSelectItems(ejbFacade.productos_ordenados(), true);
    }

    public Productopropio getProductopropio(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Productopropio.class)
    public static class ProductopropioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductopropioController controller = (ProductopropioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productopropioController");
            return controller.getProductopropio(getKey(value));
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
            if (object instanceof Productopropio) {
                Productopropio o = (Productopropio) object;
                return getStringKey(o.getCodProducto());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Productopropio.class.getName());
            }
        }

    }
    
        public static SelectItem[] getSelectItems(List<Productopropio> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "Seleccione un producto");
            i++;
        }
        for (Productopropio x : entities) {
            items[i++] = new SelectItem(x, x.getDenominacion());
        }
        return items;
    }

    public void cargarProductosComponentes(){
        listaProductospropiosComponentes = ejbFacade.productos_por_componente(componente);
    }
        
}
