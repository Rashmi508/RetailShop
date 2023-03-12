//package sr.unasat.retailShop.services;
//
//import sr.unasat.retailShop.config.JpaConfig;
//import sr.unasat.retailShop.dao.AccountDao;
//import sr.unasat.retailShop.entities.Account;
//import sr.unasat.retailShop.interfaces.AccountInterface;
//
//import java.util.List;
//
//public class AccountServiceImpl implements AccountInterface {
//    AccountDao accountDao = new AccountDao(JpaConfig.getEntityManager());
//
//    @Override
//    public List<Account> retrieveAccountList() {
//        return accountDao.retrieveAccountList();
//    }
//
//    @Override
//    public Account insertClient(Account account) {
//        List<Account> accounts = accountDao.retrieveAccountList();
//        return accountDao.insertClient(account);
//    }
//
//    @Override
//    public Account deleteClient(Account account) {
//        int index = -1;
//
//        for (int i = 0; i < retrieveAccountList().size(); i++) {
//            if(retrieveAccountList().get(i).getId() == account.getId()) {
//                index = i;
//                break;
//            }
//        }
//        Account acc;
//        acc = retrieveAccountList().get(index);
//
//        accountDao.deleteClient(account);
//        return acc;
//    }
//
//    @Override
//    public Account updateClient(Account account) {
//        for (int i = 0; i < retrieveAccountList().size(); i++) {
//            if (retrieveAccountList().get(i).getId() == account.getId()){
//                accountDao.updateClient(account);
//                break;
//            }
//        }
//        return account;
//    }
//
//    @Override
//    public Account findClientByNumber(Account account) {
//        Account findClient = new Account(account.getId());
//        for (int i = 0; i < retrieveAccountList().size(); i++) {
//            if (retrieveAccountList().get(i).getId() == account.getId()) {
//                findClient = retrieveAccountList().get(i);
//            }
//        }
//        return findClient;
//    }
//}
