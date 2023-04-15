package fr.davlac.bank.account;

import fr.davlac.bank.operation.model.Operation;

import java.util.LinkedList;

public record Account(
        Long accountNumber,
        LinkedList<Operation> operationHistory
) {
    public Account(Long accountNumber, LinkedList<Operation> operationHistory) {
        this.accountNumber = accountNumber;
        this.operationHistory = operationHistory;
    }

    public Account(Long accountNumber) {
        this(accountNumber, new LinkedList<>());
    }
}
