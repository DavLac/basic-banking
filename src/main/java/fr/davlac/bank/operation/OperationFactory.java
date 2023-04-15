package fr.davlac.bank.operation;

import fr.davlac.bank.operation.model.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OperationFactory {
    private final Map<OperationType, OperationProcess> operationProcesses;

    public OperationFactory(List<OperationProcess> checkProviders) {
        this.operationProcesses = checkProviders.stream()
                .collect(Collectors.toMap(OperationProcess::getType, operationProcess -> operationProcess));
    }

    public OperationProcess getOperation(OperationType operationType) {
        return Optional.ofNullable(operationProcesses.get(operationType))
                .orElseThrow(() -> new UnsupportedOperationException("Operation not supported!"));
    }
}
