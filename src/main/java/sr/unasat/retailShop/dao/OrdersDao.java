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

    public Orders findOrderByNumber(String number) {
        entityManager.getTransaction().begin();
        String jpql = "select o from Orders o where o.number =: number";
        TypedQuery<Orders> query = entityManager.createQuery(jpql, Orders.class);
        query.setParameter("number", number);
        Orders orders = query.getSingleResult();
        entityManager.getTransaction().commit();
        return orders;
    }

    public Orders insertOrder(Orders orders) {
        entityManager.getTransaction().begin();
        entityManager.persist(orders);
        entityManager.getTransaction().commit();
        return orders;
    }

    public void deleteOrder(Orders orders) {
        entityManager.getTransaction().begin();
        entityManager.remove(orders);
        entityManager.getTransaction().commit();
    }

    public void updateOrder(Orders updateOrder) {
        entityManager.getTransaction().begin();
        entityManager.persist(updateOrder);
        entityManager.getTransaction().commit();
    }
}
