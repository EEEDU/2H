package Controladores;

import Entidades.Componente;
import Controladores.util.JsfUtil;
import Controladores.util.PaginationHelper;
import Entidades.Lineapcliente;
import Entidades.Marca;
import Entidades.Productocomponente;
import Entidades.Productopropio;
import Repositorios.ComponenteFacade;

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

@Named("componenteController")
@SessionScoped
public class ComponenteController implements Serializable {

    private Componente current;
    private DataModel items = null;
    @EJB
    private Repositorios.ComponenteFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    private Marca marca;
    private List<Componente> listaComponentes;
    
    private Productopropio producto;
    private List<Productocomponente> listaComponentesProducto;
    private List<Lineapcliente> listaPedidoProducto;

    public ComponenteController() {
    }

    public List<Lineapcliente> getListaPedidoProducto() {
        return listaPedidoProducto;
    }

    public void setListaPedidoProducto(List<Lineapcliente> listaPedidoProducto) {
        this.listaPedidoProducto = listaPedidoProducto;
    }

    public Productopropio getProducto() {
        return producto;
    }

    public void setProducto(Productopropio producto) {
        this.producto = producto;
    }

    public List<Productocomponente> getListaComponentesProducto() {
        return listaComponentesProducto;
    }

    public void setListaComponentesProducto(List<Productocomponente> listaComponentesProducto) {
        this.listaComponentesProducto = listaComponentesProducto;
    }

    
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Componente> getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(List<Componente> listaComponentes) {
        this.listaComponentes = listaComponentes;
    }

    public Componente getSelected() {
        if (current == null) {
            current = new Componente();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ComponenteFacade getFacade() {
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
        current = (Componente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Componente();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ComponenteCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Componente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ComponenteUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Componente) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ComponenteDeleted"));
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
        return getSelectItems(ejbFacade.componentes_ordenados(), true);
    }
    
    public SelectItem[] getItemsAvailableSelectOneMarca() {
        return getSelectItems(ejbFacade.componentes_por_marca(marca), true);
    }

    public Componente getComponente(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Componente.class)
    public static class ComponenteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComponenteController controller = (ComponenteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "componenteController");
            return controller.getComponente(getKey(value));
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
            if (object instanceof Componente) {
                Componente o = (Componente) object;
                return getStringKey(o.getCodComponente());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Componente.class.getName());
            }
        }

    }
    public static SelectItem[] getSelectItems(List<Componente> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "Seleccione un componente");
            i++;
        }
        for (Componente x : entities) {
            items[i++] = new SelectItem(x, x.getDescripcion());
        }
        return items;
    }

    public void cargarComponentesMarcas(){
        listaComponentes = ejbFacade.componentes_por_marca(marca);
    }
    
    public void cargarComponentesypedidosProducto(){
       listaComponentesProducto = ejbFacade.componentes_por_producto(producto);
        
       listaPedidoProducto = ejbFacade.pedidos_por_producto(producto);
    }
}
