package ${domain.namespace}.handler;

import ${domain.namespace}.EntityExistsException;
import ${domain.namespace}.EntityNotFoundException;
import ${domain.namespace}.ErrorMessage;
import ${domain.namespace}.ForbiddenException;
import ${domain.namespace}.ServiceException;
import ${domain.namespace}.UnauthorizedException;
import ${domain.namespace}.ValidationException;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Log
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleException(ValidationException e) {
        log.log(Level.INFO, e.getMessage());
        return buildErrorMessage(e);
    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleException(EntityExistsException e) {
        log.log(Level.INFO, e.getMessage());
        return buildErrorMessage(e);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleException(EntityNotFoundException e) {
        log.log(Level.INFO, e.getMessage());
        return buildErrorMessage(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.log(Level.INFO, e.getMessage());
        return buildErrorMessage(e);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleConstraintViolationException(ConstraintViolationException e) {
        log.log(Level.INFO, e.getMessage());
        return buildErrorMessage(e);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleException(ServiceException e) {
        log.log(Level.WARNING, e.getMessage(), e);
        return buildErrorMessage(e);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessage handleException(UnauthorizedException e) {
        log.log(Level.INFO, e.getMessage());
        return buildErrorMessage(e);
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessage handleException(ForbiddenException e) {
        log.log(Level.INFO, e.getMessage());
        return buildErrorMessage(e);
    }

    private ErrorMessage buildErrorMessage(Exception e) {
        
        if (e instanceof ServiceException) {
            ServiceException ex = (ServiceException) e;
            Optional<ErrorMessage> errorMessage = ex.getErrorMessage();
            return errorMessage.orElseGet(() -> ErrorMessage.builder()
                    .key(getErrorMessage(e))
                    .error(e.getMessage())
                    .build());
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            BindingResult bindingResult = ex.getBindingResult();
            if (bindingResult != null) {
                String message = bindingResult.getAllErrors()
                        .stream().map(er -> {
                            String str = er.getObjectName();
                            if (er instanceof FieldError) {
                                str += '.' + ((FieldError) er).getField();
                            }
                            str += " : " + er.getDefaultMessage();
                            return str;
                        })
                        .collect(Collectors.joining(", "));
                return ErrorMessage.builder()
                        .error(message)
                        .build();
            }
        }
        return ErrorMessage.builder()
                .error(e.getMessage())
                .build();
    }

    private String getErrorMessage(Exception e) {
        return e.getCause() != null ? e.getCause().getMessage() : e.getMessage();
    }

}
