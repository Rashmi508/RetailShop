package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.SupplierDao;
import sr.unasat.retailShop.entities.Supplier;

import java.util.List;

public class SupplierService {

    SupplierDao supplierDao = new SupplierDao(JpaConfig.getEntityManager());

    public void getSupplier() {

        List<Supplier> supplierList = supplierDao.retrieveSupplier();
        for (Supplier supplier : supplierList) {
            System.out.println(supplier);
        }
    }
}
