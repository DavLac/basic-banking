package fr.davlac.bank.operation.model;

import lombok.Builder;

import java.time.Instant;


@Builder
public record Operation(
        String id,
        double amount,
        OperationType type,
        double balance,
        Instant createdDate
) {
}
