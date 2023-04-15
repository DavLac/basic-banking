package fr.davlac.bank.bank;

import fr.davlac.bank.account.Account;
import fr.davlac.bank.account.AccountService;
import fr.davlac.bank.operation.model.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BankService {

    private static final Map<Long, Account> accounts = new HashMap<>();

    private final AccountService accountService;

    public Operation createOperation(CreateOperationRequest request) {
        Account account = getOrCreateAccount(request.getAccountNumber());
        Account operatedAccount = accountService.createOperation(account, request.getOperationType(), request.getAmount());
        return operatedAccount.operationHistory().getLast();
    }

    public List<Operation> getAccountHistory(Long accountNumber) {
        Account account = getOrCreateAccount(accountNumber);
        List<Operation> operationHistory = account.operationHistory();
        Collections.reverse(operationHistory);
        return operationHistory;
    }

    private Account getOrCreateAccount(Long accountNumber) {
        Account account = accounts.getOrDefault(accountNumber, null);
        if (Objects.isNull(account)) {
            Account newAccount = new Account(accountNumber);
            accounts.put(accountNumber, newAccount);
            return newAccount;
        } else {
            return account;
        }
    }

}
