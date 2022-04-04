/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpCustomerApplicationTamby5.managedbeans;

import javax.ejb.EJB;  
import javax.inject.Named;  
import javax.faces.view.ViewScoped;  
import java.io.Serializable;  
import java.util.List;  
import mg.itu.tpCustomerApplicationTamby5.entities.Customer;
import mg.itu.tpCustomerApplicationTamby5.session.CustomerManager;

/**
 *
 * @author Tamby
 */
@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {
    private List<Customer> customers;  
    @EJB
    private CustomerManager customerManager;

    /** 
   * Retourne la liste des clients pour affichage dans une DataTable 
   * @return 
   */  
    public CustomerMBean() {
    }
    public List<Customer> getCustomers() {
        if (customers == null) {
          customers = customerManager.getAllCustomers();
        }
    return customers;
    }  
    
    
}