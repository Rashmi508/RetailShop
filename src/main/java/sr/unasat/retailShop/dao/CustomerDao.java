package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Customer;
import sr.unasat.retailShop.entities.Orders;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDao {
    private EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  Customer findByTelefoonNummer(String telefoonNummer) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c where c.telefoonNummer = :telefoonNummer";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        Customer customer = query.setParameter("telefoonNummer", telefoonNummer).getSingleResult();
        entityManager.getTransaction().commit();
        return customer;
    }

    public  Customer findByBestelling(String bestelling) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c where c.bestelling = :bestelling";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        Customer customer = query.setParameter("bestelling", bestelling).getSingleResult();
        entityManager.getTransaction().commit();
        return customer;
    }

    public List<Customer> retrieveCustomerList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        List<Customer> customerList = query.getResultList();
        entityManager.getTransaction().commit();
        return customerList;
    }

    public Customer insert(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        return customer;
    }

    public int delete(String telefoonNummer) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Customer c where c.telefoonNummer = :telefoonNummer");
        query.setParameter("telefoonNummer", telefoonNummer);
        int rowsDeleted = query.executeUpdate();
        System.out.println("deleted:" + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

}
