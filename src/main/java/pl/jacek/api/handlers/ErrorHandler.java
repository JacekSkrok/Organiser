package pl.jacek.api.handlers;

import org.apache.commons.lang3.StringUtils;
import pl.jacek.api.model.Error;

public class ErrorHandler {

    public static Error getErrorResponse(Exception ex) {
        if (ex == null) {
            return new Error().message("Error occured");
        }
        return new Error().message(ex.getMessage());
    }

    public static Error getErrorResponse(String message) {
        if (StringUtils.isBlank(message)) {
            return new Error().message("Error occured");
        }
        return new Error().message(message);
    }
}
