package ${domain.namespace};

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
public class ErrorMessage implements Serializable {

    private String key;

    private String error;

    private Map<String, Serializable> params;
}
