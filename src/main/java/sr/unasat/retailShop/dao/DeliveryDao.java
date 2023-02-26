package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Delivery;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DeliveryDao {
    private EntityManager entityManager;

    public DeliveryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Delivery> retrieveDeliveryList() {
        entityManager.getTransaction().begin();
        String jpql = "select d from Delivery d";
        TypedQuery<Delivery> query = entityManager.createQuery(jpql, Delivery.class);
        List<Delivery> deliveryList = query.getResultList();
        entityManager.getTransaction().commit();
        return deliveryList;
    }

    public Delivery findDeliveryByNumber(String price) {
        entityManager.getTransaction().begin();
        String jpql = "select d from Delivery d where d.price =: price";
        TypedQuery<Delivery> query = entityManager.createQuery(jpql, Delivery.class);
        query.setParameter("price", price);
        Delivery delivery = query.getSingleResult();
        entityManager.getTransaction().commit();
        return delivery;
    }

    public Delivery insertDelivery(Delivery delivery) {
        entityManager.getTransaction().begin();
        entityManager.persist(delivery);
        entityManager.getTransaction().commit();
        return delivery;
    }

    public void deleteOrder(Delivery delivery) {
        entityManager.getTransaction().begin();
        entityManager.remove(delivery);
        entityManager.getTransaction().commit();
    }

    public void updateOrder(Delivery updateDelivery) {
        entityManager.getTransaction().begin();
        entityManager.persist(updateDelivery);
        entityManager.getTransaction().commit();
    }
}
