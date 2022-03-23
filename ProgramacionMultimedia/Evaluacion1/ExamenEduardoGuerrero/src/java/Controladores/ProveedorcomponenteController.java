package Controladores;

import Entidades.Proveedorcomponente;
import Controladores.util.JsfUtil;
import Controladores.util.PaginationHelper;
import Repositorios.ProveedorcomponenteFacade;

import java.io.Serializable;
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

@Named("proveedorcomponenteController")
@SessionScoped
public class ProveedorcomponenteController implements Serializable {

    private Proveedorcomponente current;
    private DataModel items = null;
    @EJB
    private Repositorios.ProveedorcomponenteFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ProveedorcomponenteController() {
    }

    public Proveedorcomponente getSelected() {
        if (current == null) {
            current = new Proveedorcomponente();
            current.setProveedorcomponentePK(new Entidades.ProveedorcomponentePK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProveedorcomponenteFacade getFacade() {
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
        current = (Proveedorcomponente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Proveedorcomponente();
        current.setProveedorcomponentePK(new Entidades.ProveedorcomponentePK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getProveedorcomponentePK().setCodProveedor(current.getProveedor().getCodProveedor());
            current.getProveedorcomponentePK().setCodComponente(current.getComponente().getCodComponente());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProveedorcomponenteCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Proveedorcomponente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getProveedorcomponentePK().setCodProveedor(current.getProveedor().getCodProveedor());
            current.getProveedorcomponentePK().setCodComponente(current.getComponente().getCodComponente());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProveedorcomponenteUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Proveedorcomponente) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProveedorcomponenteDeleted"));
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
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Proveedorcomponente getProveedorcomponente(Entidades.ProveedorcomponentePK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Proveedorcomponente.class)
    public static class ProveedorcomponenteControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProveedorcomponenteController controller = (ProveedorcomponenteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proveedorcomponenteController");
            return controller.getProveedorcomponente(getKey(value));
        }

        Entidades.ProveedorcomponentePK getKey(String value) {
            Entidades.ProveedorcomponentePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new Entidades.ProveedorcomponentePK();
            key.setCodProveedor(Integer.parseInt(values[0]));
            key.setCodComponente(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(Entidades.ProveedorcomponentePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodProveedor());
            sb.append(SEPARATOR);
            sb.append(value.getCodComponente());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Proveedorcomponente) {
                Proveedorcomponente o = (Proveedorcomponente) object;
                return getStringKey(o.getProveedorcomponentePK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Proveedorcomponente.class.getName());
            }
        }

    }

}
