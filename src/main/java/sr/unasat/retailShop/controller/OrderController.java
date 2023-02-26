package sr.unasat.retailShop.controller;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.OrdersDao;
import sr.unasat.retailShop.dto.OrdersDto;
import sr.unasat.retailShop.entities.Orders;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("order")
public class OrderController {
    private OrdersDao ordersDao = new OrdersDao(JpaConfig.getEntityManager());

    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Orders> retrieveOrdersList() {
        return ordersDao.retrieveOrdersList();
    }

    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String add(Orders orders) {
        ordersDao.insertOrder(orders);
        return "Order: " + orders.getFirstname() + " " + orders.getLastname() + " added ";

    }
    @Path("remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String remove(OrdersDto number) {
        Orders orders = ordersDao.findOrderByNumber(number.getNumber());
        ordersDao.deleteOrder(orders);
        return "Order has been deleted";
    }

    @Path("update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateOrder(Orders newOrder) {
        Orders orders = ordersDao.findOrderByNumber(newOrder.getAddress());
        orders.setFirstname(newOrder.getFirstname());
        orders.setLastname(newOrder.getLastname());
        orders.setAddress(newOrder.getAddress());
        orders.setNumber(newOrder.getNumber());
        ordersDao.updateOrder(orders);
        return "Order has been updated";
    }

    @Path("getOrder")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Orders getOrder(OrdersDto ordersDto) {
        return ordersDao.findOrderByNumber(ordersDto.getNumber());
    }
}
