package ${domain.namespace};

public class EntityNotFoundException extends ServiceException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
