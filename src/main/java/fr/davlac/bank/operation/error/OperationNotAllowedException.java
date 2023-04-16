package fr.davlac.bank.operation.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class OperationNotAllowedException extends RuntimeException{
    public OperationNotAllowedException(String message){
        super(message);
    }
}
