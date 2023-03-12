package sr.unasat.retailShop.controller;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.AccountDao;
import sr.unasat.retailShop.dto.AccountDto;
import sr.unasat.retailShop.entities.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("account")
public class AccountController {

    private AccountDao accountDao = new AccountDao(JpaConfig.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getClientList() {
        return accountDao.retrieveAccountList();
    }

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String helloWorld(){
        return "sibal saekkia!";
    }


    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addClient(Account account) {
        accountDao.insertClient(account);
        return "Account: " + account.getFirstname() + " " + account.getLastname() + "added ";

    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String removeClient(AccountDto number) {
        Account account = accountDao.findClientByNumber(number.getNumber());
        accountDao.deleteClient(account);
        return "Account has been deleted";
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateClient(Account newClient) {
        Account account = accountDao.findClientByNumber(newClient.getNumber());
        account.setFirstname(newClient.getFirstname());
        account.setLastname(newClient.getLastname());
        account.setAddress(newClient.getAddress());
        account.setNumber(newClient.getNumber());
        accountDao.updateClient(account);
        return "Account has been updated";
    }

    @Path("/getClient")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account getClient(Account account) {
        return accountDao.findPerson(account);
    }
}
