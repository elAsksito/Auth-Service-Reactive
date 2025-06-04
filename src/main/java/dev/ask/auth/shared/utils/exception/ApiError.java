package dev.ask.auth.shared.utils.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
    private String errorCode;
    private String errorTitle;
    private String errorDescription;
    private String errorUri;
    private String errorType;
    private String errorStatus;
    private String errorTimestamp;
    private int httpStatus;
    private Object extraData;
}