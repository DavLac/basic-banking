package fr.davlac.bank.operation.operationprocess;

import fr.davlac.bank.operation.model.Operation;
import fr.davlac.bank.operation.OperationProcess;
import fr.davlac.bank.operation.model.OperationType;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class DepositOperationProcess implements OperationProcess {

    @Override
    public OperationType getType() {
        return OperationType.DEPOSIT;
    }

    @Override
    public Operation execute(double amount, double currentBalance) {
        return Operation.builder()
                .id(UUID.randomUUID().toString())
                .type(OperationType.DEPOSIT)
                .amount(amount)
                .balance(currentBalance + amount)
                .createdDate(Instant.now())
                .build();
    }
}
