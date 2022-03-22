/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mg.itu.tpCustomerApplicationTamby5.session;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mg.itu.tpCustomerApplicationTamby5.entities.Customer;

/**
 *
 * @author Tamby
 */
@Stateless
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    
    public List<Customer> getAllCustomers() {  
       Query query = em.createNamedQuery("Customer.findAll");
      return query.getResultList();  
    }  
        
    public Customer update(Customer customer) {
      return em.merge(customer);  
    }  

    public void persist(Customer customer) {
       em.persist(customer);
    }
    
}
