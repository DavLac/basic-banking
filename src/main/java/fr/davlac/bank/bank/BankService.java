package fr.davlac.bank.bank;

import fr.davlac.bank.operation.OperationService;
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
    private final OperationService operationService;

    public Operation createOperation(CreateOperationRequest request) {
        Account account = getOrCreateAccount(request.getAccountNumber());
        Operation createdOperation = operationService.createOperation(
                request.getOperationType(),
                request.getAmount(),
                account.getBalance()
        );
        account.operationHistory().addLast(createdOperation);
        return createdOperation;
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
