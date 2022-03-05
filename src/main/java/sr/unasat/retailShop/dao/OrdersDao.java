package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Orders;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrdersDao {
    private EntityManager entityManager;

    public OrdersDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Orders> retrieveOrdersList() {
        entityManager.getTransaction().begin();
        String jpql = "select o from Orders o";
        TypedQuery<Orders> query = entityManager.createQuery(jpql, Orders.class);
        List<Orders> ordersList = query.getResultList();
        entityManager.getTransaction().commit();
        return ordersList;
    }

}
