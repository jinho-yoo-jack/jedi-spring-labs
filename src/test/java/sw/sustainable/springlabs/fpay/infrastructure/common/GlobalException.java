package sw.sustainable.springlabs.fpay.infrastructure.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;

@ConfigurationProperties("error-trace")
@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    private boolean stackTrace;

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        return ResponseEntity.status(status)
                .body(new ErrorResponse(null, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorResponse handleAllExceptions(Exception ex, WebRequest request) {
        List<StackTraceElement> stackTraces = null;
        if (stackTrace) {
            stackTraces = Arrays.asList(ex.getStackTrace());
        }
        return new ErrorResponse(stackTraces, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
