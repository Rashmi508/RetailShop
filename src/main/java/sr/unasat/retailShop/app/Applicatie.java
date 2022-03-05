package sr.unasat.retailShop.app;


import sr.unasat.retailShop.config.JpaConfig;

import static sr.unasat.retailShop.designpatterns.chainOfResponsibility.CouchTypeConstant.*;

import sr.unasat.retailShop.dao.CustomerDao;
import sr.unasat.retailShop.designpatterns.chainOfResponsibility.*;

import sr.unasat.retailShop.designpatterns.decorator.*;
import sr.unasat.retailShop.designpatterns.factory.MerkFactory;
import sr.unasat.retailShop.designpatterns.factory.Sealy;
import sr.unasat.retailShop.designpatterns.factory.Serta;
import sr.unasat.retailShop.designpatterns.factory.Sierra;
import sr.unasat.retailShop.entities.Bill;
import sr.unasat.retailShop.entities.Customer;
import sr.unasat.retailShop.entities.Employees;
import sr.unasat.retailShop.services.*;


import java.time.LocalDate;
import java.util.Scanner;


public class Applicatie {

    public static void main(String[] args) {

        AddressService as = new AddressService();
        //as.findAdress();
        //as.insertAdress(new Address("Kokrostraat", 30));
        //as.updateAdress(3,"Watermeloenstraat", 21);


        BillService bs = new BillService();
        //bs.retrieveBill();
        //bs.insertBill(new Bill(LocalDate.parse("2021-01-09"), "SRD 1000"));

        CustomerService cs = new CustomerService();
        //cs.findAllCustomers();
        //cs.insertCustomer(new Customer("Chis", "Bang", "8973645", "chrisB97@gmail.com"));
        //cs.deleteCustomer("8973645");

        EmployeeService es = new EmployeeService();
        //es.findEmployee();
        //es.insertEmployee(new Employees("Praveen", "Kalloe", LocalDate.parse("1999-06-18"), "SRD 2000", "verkoper", "FD3457392"));
        //es.deleteEmployee("FD3457392");
        //es.updateEmployee("FD93483489", "SRD 60,000");

        OrdersService os = new OrdersService();
        //os.findOrder();

        PaymentService ps = new PaymentService();
        //ps.findPayment();
        //ps.insertPayment(new Payment("kaart", 60134560450012987L, "Martha Pinas"));

        ProductService prs = new ProductService();
        //prs.findProduct();

        ProductDetailsService pds = new ProductDetailsService();
        //pds.findDetails();

        ProductGroupService pgs = new ProductGroupService();
        //pgs.findGroup();

        SupplierService ss = new SupplierService();
        //ss.getSupplier();

        JpaConfig.shutdown();




//          Decorator pattern!

        BedsetDec bed = new BedsetDec();
        //bed.getDecorator();



//          CHAIN OF RESPONSIBILITY!!

        CouchesChain chain = new CouchesChain();
        //chain.getchain();


//          FACTORY PATTERN!!!
        MerkFactory mf = new MerkFactory();
        //mf.chooseBedBrandScanner();


    }
}









    



