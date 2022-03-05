package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class AdressDao {
    private EntityManager entityManager;

    public AdressDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Address> retrieveAddressList() {
        entityManager.getTransaction().begin();
        String jpql = "select a from Address a";
        TypedQuery<Address> query = entityManager.createQuery(jpql, Address.class);
        List<Address> addressList = query.getResultList();
        entityManager.getTransaction().commit();
        return addressList;
    }

    public Address findByNaam(String straatNaam) {
        entityManager.getTransaction().begin();
        String jpql = "select a from Address a where a.straatNaam = :straatNaam";
        TypedQuery<Address> query = entityManager.createQuery(jpql, Address.class);
        Address address = query.setParameter("straatNaam", straatNaam).getSingleResult();
        entityManager.getTransaction().commit();
        return address;
    }

    public Address insert(Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    public int updateAddress (int addressId, String straatNaam, int nummer) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Address a set a.straatNaam = :straatNaam, a.nummer = :nummer where addressId = :addressId");
        query.setParameter("addressId", addressId);
        query.setParameter("nummer", nummer);
        query.setParameter("straatNaam", straatNaam);
        int rowsupdated = query.executeUpdate();
        System.out.println("entities updated: " + rowsupdated);
        entityManager.getTransaction().commit();
        return rowsupdated;
    }
}

