package ${domain.namespace};


public class ForbiddenException extends ServiceException {

    public ForbiddenException(String msg) {
        super(msg);
    }
}
