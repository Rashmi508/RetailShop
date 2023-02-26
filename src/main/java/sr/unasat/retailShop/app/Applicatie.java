package sr.unasat.retailShop.app;


import sr.unasat.retailShop.config.JpaConfig;


import sr.unasat.retailShop.designpatterns.chainOfResponsibility.*;

import sr.unasat.retailShop.designpatterns.decorator.*;
import sr.unasat.retailShop.designpatterns.factory.MerkFactory;
import sr.unasat.retailShop.entities.*;
import sr.unasat.retailShop.services.*;


import java.sql.Date;


public class Applicatie {

    public static void main(String[] args) {

        OrdersService os = new OrdersService();
        os.findOrder();


        ProductService prs = new ProductService();
        prs.findProduct();

        ProductGroupService pgs = new ProductGroupService();
        pgs.findGroup();


//          Decorator pattern!

        BedsetDec bed = new BedsetDec();
//        bed.getDecorator();



//          CHAIN OF RESPONSIBILITY!!

        CouchesChain chain = new CouchesChain();
//        chain.getchain();


//          FACTORY PATTERN!!!
        MerkFactory mf = new MerkFactory();
        mf.chooseBedBrandScanner();


//        OrdersDao ordersDao = new OrdersDao(JpaConfig.getEntityManager());
//        List<Orders> orderList = getOrderList(Date.valueOf("2022-01-01"), Date.valueOf("2022-03-31"));



        JpaConfig.shutdown();


    }
}









    



