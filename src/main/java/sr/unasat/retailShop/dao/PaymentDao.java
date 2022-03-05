package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Payment;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PaymentDao {
    private EntityManager entityManager;

    public PaymentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Payment> retrievePaymentList() {
        entityManager.getTransaction().begin();
        String jpql = "select p from Payment p";
        TypedQuery<Payment> query = entityManager.createQuery(jpql, Payment.class);
        List<Payment> paymentList = query.getResultList();
        entityManager.getTransaction().commit();
        return paymentList;
    }

    public Payment insert (Payment payment) {
        entityManager.getTransaction().begin();
        entityManager.persist(payment);
        entityManager.getTransaction().commit();
        return payment;
    }
}
