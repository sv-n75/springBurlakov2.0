package task16.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum PersonDepartmentExceptionEnum {
    PERSON_OR_DEPARTMENT_NOT_FOUND("Person or Department is not found in this DB "),
    BAD_REQUEST("This request is bad! It is not working");


    private final String message;
}
