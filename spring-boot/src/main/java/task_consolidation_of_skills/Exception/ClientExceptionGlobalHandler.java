package task_consolidation_of_skills.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientExceptionGlobalHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handlerRequest(ClientException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<Object> handlerRequest(Exception e){
        return new ResponseEntity<>(ClientExceptionEnum.BAD_REQUEST.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
