package fr.davlac.bank.operation.operationprocess;

import fr.davlac.bank.operation.error.OperationNotAllowedException;
import fr.davlac.bank.operation.model.Operation;
import fr.davlac.bank.operation.OperationProcess;
import fr.davlac.bank.operation.model.OperationType;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class WithdrawalOperationProcess implements OperationProcess {

    @Override
    public OperationType getType() {
        return OperationType.WITHDRAWAL;
    }

    @Override
    public Operation execute(double amount, double currentBalance) {
        if (currentBalance - amount < 0) {
            throw new OperationNotAllowedException(
                    "Operation %s not allowed. Not enough balance. Current balance = %s".formatted(
                            OperationType.WITHDRAWAL,
                            currentBalance
                    )
            );
        }

        return Operation.builder()
                .id(UUID.randomUUID().toString())
                .type(OperationType.WITHDRAWAL)
                .amount(amount)
                .balance(currentBalance - amount)
                .createdDate(Instant.now())
                .build();
    }
}
