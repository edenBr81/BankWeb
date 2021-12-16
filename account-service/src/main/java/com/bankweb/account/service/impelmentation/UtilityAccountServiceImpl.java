package com.bankweb.account.service.impelmentation;

import com.bankweb.account.entity.Account;
import com.bankweb.account.entity.UtilityAccount;
import com.bankweb.account.model.AccountStatus;
import com.bankweb.account.model.Transaction;
import com.bankweb.account.repository.AccountRepository;
import com.bankweb.account.repository.UtilityAccountRepository;
import com.bankweb.account.service.UtilityAccountService;
import com.bankweb.account.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;


@Service
public class UtilityAccountServiceImpl implements UtilityAccountService {


    @Autowired
    UtilityAccountRepository utilityAccountRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public UtilityAccount findByProviderName(String provider) {
        return utilityAccountRepository.findByProviderName(provider);
    }

    @Override
    public UtilityAccount getUtilityAccountById(Long id) {
        return utilityAccountRepository.getById(id);
    }

    @Override
    public UtilityAccount findByAccountNumber(String accountNumber) {
        return utilityAccountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Message Pay(String senderAccountNUmber, String utilityProviderNUmber, String utilityAccountNumber, BigDecimal amount, String transferBy) {


        Account accountSender=accountRepository.findByAccountNumber(senderAccountNUmber);

       if(accountSender.getCurrentBalance().compareTo(amount)>0 && accountSender.getAccountStatus().equals(AccountStatus.ACTIVE)) {
           Account utilityAccount = accountRepository.findByAccountNumber(utilityAccountNumber);

           if (utilityAccount.getAccountStatus().equals(AccountStatus.ACTIVE)) {

               utilityAccount.setPreviousBalance(utilityAccount.getCurrentBalance());
               utilityAccount.setCurrentBalance(utilityAccount.getCurrentBalance().add(amount));
               accountSender.setPreviousBalance(accountSender.getPreviousBalance());
               accountSender.setCurrentBalance(accountSender.getCurrentBalance().subtract(amount));


               Transaction transaction = new Transaction();

               transaction.setTransactionBy(transferBy);

               transaction.setSenderPrevBalance(accountSender.getPreviousBalance());
               transaction.setReceiverPrevBalance(utilityAccount.getPreviousBalance());
               transaction.setSenderCurrentBalance(accountSender.getCurrentBalance());
               transaction.setReceiverCurrentBalance(utilityAccount.getCurrentBalance());
               transaction.setSenderAccountNumber(senderAccountNUmber);
               transaction.setReceiverAccountNumber(utilityAccountNumber);

               accountRepository.save(accountSender);
               accountRepository.save(utilityAccount);

               transaction=restTemplate.postForObject("http://localhost:9000/transactions/create", transaction,Transaction.class);

           }else{
               return new Message(Message.Status.FAILED, "The Utility Account is Active");
           }
       }else{
           return new Message(Message.Status.FAILED,"The Sender Account Is Not Active Or The Account Doesn't has Sufficient");
       }
        return new Message(Message.Status.SUCCESS, "Payment Successful");
    }


}
