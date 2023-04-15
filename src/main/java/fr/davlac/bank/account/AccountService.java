package fr.davlac.bank.account;

import fr.davlac.bank.operation.model.Operation;
import fr.davlac.bank.operation.OperationService;
import fr.davlac.bank.operation.model.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class AccountService {

    public static final int NEW_ACCOUNT_BALANCE = 0;
    private final OperationService operationService;

    public Account createOperation(Account account, OperationType operationType, double amount) {
        Operation operation = operationService.createOperation(operationType, amount, getBalance(account));
        account.operationHistory().addLast(operation);
        return account;
    }

    private double getBalance(Account account) {
        if (CollectionUtils.isEmpty(account.operationHistory())) {
            return NEW_ACCOUNT_BALANCE;
        }

        return account.operationHistory().getLast().balance();
    }
}
