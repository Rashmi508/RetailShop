package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Account;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AccountDao {
    private EntityManager entityManager;

    public AccountDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Account> retrieveAccountList() {
        entityManager.getTransaction().begin();
        String jpql = "select ac from Account ac";
        TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
        List<Account> accountList = query.getResultList();
        entityManager.getTransaction().commit();
        return accountList;
    }

    public Account findClientByNumber(String number) {
        entityManager.getTransaction().begin();
        String jpql = "select ac from Account ac where ac.number=: number";
        TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
        query.setParameter("number", number);
        Account account = query.getSingleResult();
        entityManager.getTransaction().commit();
        return account;
    }

    public Account insertClient(Account account) {
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        return account;
    }

    public void deleteClient(Account account) {
        entityManager.getTransaction().begin();
        entityManager.remove(account);
        entityManager.getTransaction().commit();
    }

    public void updateClient(Account updateClient) {
        entityManager.getTransaction().begin();
        entityManager.persist(updateClient);
        entityManager.getTransaction().commit();
    }

}
