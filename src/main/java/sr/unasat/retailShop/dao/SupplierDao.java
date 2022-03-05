package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SupplierDao {
    private EntityManager entityManager;

    public SupplierDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Supplier> retrieveSupplier() {
        entityManager.getTransaction().begin();
        String jpql = "select s from Supplier s";
        TypedQuery<Supplier> query = entityManager.createQuery(jpql, Supplier.class);
        List<Supplier> supplierList = query.getResultList();
        entityManager.getTransaction().commit();
        return supplierList;
    }
}
