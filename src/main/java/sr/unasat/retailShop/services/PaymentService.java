package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.PaymentDao;
import sr.unasat.retailShop.entities.Address;
import sr.unasat.retailShop.entities.Payment;

import java.util.List;

public class PaymentService {

    PaymentDao paymentDao = new PaymentDao(JpaConfig.getEntityManager());

    public void findPayment(){
        List<Payment> paymentList = paymentDao.retrievePaymentList();
       for (Payment payment : paymentList) {
           System.out.println(payment);
       }
    }

    public void insertPayment(Payment payment) {
//        Payment payment = new Payment("kaart", 60134560450012987L, "Martha Pinas");
//
//        Payment savedPayment = paymentDao.insert(payment);
          System.out.println("payment:" + paymentDao.insert(payment));
    }
}
