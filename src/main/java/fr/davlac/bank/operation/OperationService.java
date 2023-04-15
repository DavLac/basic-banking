package fr.davlac.bank.operation;

import fr.davlac.bank.operation.model.Operation;
import fr.davlac.bank.operation.model.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationFactory operationFactory;

    public Operation createOperation(OperationType operationType, double amount, double currentBalance) {
        OperationProcess operationProcess = operationFactory.getOperation(operationType);
        return operationProcess.execute(amount, currentBalance);
    }
}
