package pro.sky.java.course2.employeebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalEmployeeException extends RuntimeException {
    public IllegalEmployeeException(String message) {
        super(message);
    }
}
