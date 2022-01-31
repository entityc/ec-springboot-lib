package ${domain.namespace};

import java.util.Optional;

public class ServiceException extends Exception {

    private final ErrorMessage errorMessage;

    public ServiceException(String msg, Throwable e) {
        this(ErrorMessage.builder()
                .key(msg)
                .error(e.getCause() != null ? e.getCause().getMessage() : e.getMessage())
                .build());
    }

    public ServiceException(String msg) {
        this(ErrorMessage.builder()
                .key(msg)
                .build());
    }

    public ServiceException(ErrorMessage errorMessage) {
        this(errorMessage, null);
    }

    public ServiceException(ErrorMessage errorMessage, Throwable e) {
        super(errorMessage.getKey(), e);
        this.errorMessage = errorMessage;
    }

    public Optional<ErrorMessage> getErrorMessage() {
        return Optional.ofNullable(errorMessage);
    }

}
