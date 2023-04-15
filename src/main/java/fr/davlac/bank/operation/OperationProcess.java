package fr.davlac.bank.operation;

import fr.davlac.bank.operation.model.Operation;
import fr.davlac.bank.operation.model.OperationType;

public interface OperationProcess {
    OperationType getType();

    Operation execute(double amount, double currentBalance);
}
