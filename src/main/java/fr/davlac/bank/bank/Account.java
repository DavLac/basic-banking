package fr.davlac.bank.bank;

import fr.davlac.bank.operation.model.Operation;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;

public record Account(
        Long accountNumber,
        LinkedList<Operation> operationHistory
) {

    public static final int NEW_ACCOUNT_BALANCE = 0;

    public Account(Long accountNumber, LinkedList<Operation> operationHistory) {
        this.accountNumber = accountNumber;
        this.operationHistory = operationHistory;
    }

    public Account(Long accountNumber) {
        this(accountNumber, new LinkedList<>());
    }

    public double getBalance() {
        if (CollectionUtils.isEmpty(this.operationHistory())) {
            return NEW_ACCOUNT_BALANCE;
        }

        return this.operationHistory().getLast().balance();
    }
}
