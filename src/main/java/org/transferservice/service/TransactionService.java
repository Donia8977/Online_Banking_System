package org.transferservice.service;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//import org.hibernate.Transaction;
import org.transferservice.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.transferservice.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private  AccountService accountService;


    @Transactional
    public Transaction createTransaction(Transaction transaction) {

        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

//    public List<Transaction> getTransactionsBySenderAccountId(Long senderAccountId) {
//        return transactionRepository.findBySenderAccountId(senderAccountId);
//    }
//
//    public List<Transaction> getTransactionsByRecipientAccountId(Long recipientAccountId) {
//        return transactionRepository.findByRecipientAccountId(recipientAccountId);
//    }
//
//    public List<Transaction> getTransactionsByAccountIdAndDateRange(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {
//        return transactionRepository.findBySenderAccountIdOrRecipientAccountIdAndTransactionDateBetween(
//                accountId, accountId, startDate, endDate
//        );
//    }


    public List<Transaction> getTransactionHistory(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {

        if (startDate == null && endDate == null) {
            return transactionRepository.findBySenderAccountIdOrRecipientAccountId(  accountId,  accountId);

        } else {

            return transactionRepository.findBySenderAccountIdOrRecipientAccountIdAndTransactionDateBetween(
                    accountId, accountId, startDate, endDate);
        }
    }
}
