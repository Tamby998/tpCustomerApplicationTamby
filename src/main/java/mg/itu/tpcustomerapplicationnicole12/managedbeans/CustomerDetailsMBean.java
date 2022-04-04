/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpCustomerApplicationTamby5.managedbeans;
import mg.itu.tpCustomerApplicationTamby5.entities.Customer;
import mg.itu.tpCustomerApplicationTamby5.session.CustomerManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mg.itu.tpCustomerApplicationTamby5.entities.DiscountCode;
import mg.itu.tpCustomerApplicationTamby5.session.DiscountCodeManager;



/**
 *
 * @author Tamby
 */
@Named
@ViewScoped
public class CustomerDetailsMBean implements Serializable{
        private int idCustomer;
    private Customer customer;

    @EJB
    private CustomerManager customerManager;
    @EJB
    private DiscountCodeManager discountCodeManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Renvoie les détails du client courant (celui dans l'attribut customer de
     * cette classe), qu'on appelle une propriété (property)
     */
    public Customer getDetails() {
        return customer;
    }

    /**
     * Action handler - met à jour la base de données en fonction du client
     * passé en paramètres.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        customer = customerManager.update(customer);
        return "CustomerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.getCustomer(idCustomer);
    }

    /**
     * Retourne la liste de tous les DiscountCode.
     */
    public List<DiscountCode> getDiscountCodes() {
        return discountCodeManager.getAllDiscountCodes();
    }

    /**
     * getter pour la propriété discountCodeConverter.
     */
    public Converter<DiscountCode> getDiscountCodeConverter() {
        return new Converter<DiscountCode>() {
            /**
             * Convertit une String en DiscountCode.
             *
             * @param value valeur à convertir
             */
            @Override
            public DiscountCode getAsObject(FacesContext context, UIComponent component, String value) {
                return discountCodeManager.findById(value);
            }

            /**
             * Convertit un DiscountCode en String.
             *
             * @param value valeur à convertir
             */
            @Override
            public String getAsString(FacesContext context, UIComponent component, DiscountCode value) {
                return value.getDiscountCode();
            }
        };
    }
    
}