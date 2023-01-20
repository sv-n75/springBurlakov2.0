package task16.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionGlobalHandler {

    @ExceptionHandler(value = {PersonDepartmentException.class})
    public ResponseEntity<Object> handlerRequest(PersonDepartmentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handlerRequest(Exception e) {
        return new ResponseEntity<>(PersonDepartmentExceptionEnum.BAD_REQUEST.getMessage(), HttpStatus.BAD_REQUEST);

    }
}
