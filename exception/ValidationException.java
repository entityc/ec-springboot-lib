package ${domain.namespace};

@SuppressWarnings("serial")
public class ValidationException extends ServiceException {
    public ValidationException(String message) {
        super(message);
    }
}
