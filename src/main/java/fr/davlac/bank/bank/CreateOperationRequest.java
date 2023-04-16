package fr.davlac.bank.bank;

import fr.davlac.bank.operation.model.OperationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOperationRequest(
        @Positive
        double amount,
        @NotNull
        OperationType operationType
) {
}
