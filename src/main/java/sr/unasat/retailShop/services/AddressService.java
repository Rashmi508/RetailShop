package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.AdressDao;
import sr.unasat.retailShop.entities.Address;

import java.util.List;

public class AddressService {
    AdressDao adressDao = new AdressDao(JpaConfig.getEntityManager());
    Address address = new Address();

    public void findAdress() {
        List<Address> addressList = adressDao.retrieveAddressList();
        for(Address address : addressList){
            System.out.println(address);
        }
    }
    public void insertAdress(Address address) {

        System.out.println("address: " + adressDao.insert(address));
    }

    public void updateAdress(int addressId, String straatNaam, int nummer) {


        System.out.println("update: " + adressDao.updateAddress(addressId, straatNaam, nummer));
    }
}
