package validation;

import java.util.Objects;

public class Validator {

    public static final String OBJ_NOT_NULL = "ERROR!Passed parameter not allowed to be null.";

    public static void objectNotNull(Object obj) {
        if (Objects.isNull(obj)) throw new IllegalArgumentException(OBJ_NOT_NULL);
    }
}
