package task17_21.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum PersonDepartmentExceptionEnum {
    PERSON_NOT_FOUND("Person is not found in this DB "),
    DEPARTMENT_NOT_FOUND("Department is not found in this DB"),
    BAD_REQUEST("This request is bad! It is not working");

    private final String message;
}
