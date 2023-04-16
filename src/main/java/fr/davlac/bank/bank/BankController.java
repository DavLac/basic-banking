package fr.davlac.bank.bank;

import fr.davlac.bank.operation.model.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "accounts")
@RequiredArgsConstructor
@Validated
public class BankController {

    private final BankService bankService;

    /**
     * Deposit or withdrawal money on an account
     * Create an account if it's not existing
     */
    @PostMapping("{accountNumber}/operations")
    public Operation createOperationByAccountNumber(
            @PathVariable
            Long accountNumber,
            @Valid
            @RequestBody
            CreateOperationRequest createOperationRequest
    ) {
        return bankService.createOperationByAccountNumber(accountNumber, createOperationRequest);
    }

    /**
     * List account operation history
     */
    @GetMapping("{accountNumber}/operations")
    public List<Operation> getOperationHistoryByAccountNumber(
            @PathVariable
            Long accountNumber
    ) {
        return bankService.getOperationHistoryByAccountNumber(accountNumber);
    }

}
