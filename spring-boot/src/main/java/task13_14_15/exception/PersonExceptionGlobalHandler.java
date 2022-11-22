package task13_14_15.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionGlobalHandler {

    @ExceptionHandler(value = {PersonException.class})
    public ResponseEntity<Object> handlerRequest(PersonException e) {
        return new ResponseEntity<>(PersonExceptionEnum.PERSON_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handlerRequest(Exception e) {
        return new ResponseEntity<>(PersonExceptionEnum.BAD_REQUEST.getMessage(), HttpStatus.BAD_REQUEST);

    }
}
