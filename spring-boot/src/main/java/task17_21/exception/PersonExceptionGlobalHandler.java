package task17_21.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import task17_21.email.SendEmail;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class PersonExceptionGlobalHandler {

    @Autowired
    private SendEmail sendEmail;

    private Set<ConstraintViolation<?>> constraintViolations;

    @ExceptionHandler(value = {PersonDepartmentException.class})
    public ResponseEntity<Object> handlerRequest(PersonDepartmentException e) {
        log.error(e.getMessage());
        sendEmail.sendEmail(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handlerRequest(Exception e) {
        String message = PersonDepartmentExceptionEnum.BAD_REQUEST.getMessage();
        log.error(message);
        sendEmail.sendEmail(message);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Object> onConstraintValidationException(ConstraintViolationException e) {
        final List<Violation> violations = e.getConstraintViolations().stream()
                .map(
                        violation -> new Violation(
                                violation.getPropertyPath().toString(),
                                violation.getMessage()
                        )
                )
                .collect(Collectors.toList());

        return new ResponseEntity<>(violations, HttpStatus.BAD_REQUEST);
    }
}
