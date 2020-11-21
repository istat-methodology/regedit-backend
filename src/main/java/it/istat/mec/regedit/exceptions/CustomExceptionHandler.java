package it.istat.mec.regedit.exceptions;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Autowired
    public CustomExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<FaultResponse> notFoundException(TechnicalException ex) {
        FaultResponse response = new FaultResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<FaultResponse> noDataException(NoDataException ex) {
        FaultResponse response = new FaultResponse(HttpStatus.NO_CONTENT.toString(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FaultResponse> genericException(Exception ex) {
        FaultResponse response = new FaultResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Data
    public static class FaultResponse {
        @NonNull
        private String errorCode;
        @NonNull
        private String errorMessage;
        private Date timestamp;

        public FaultResponse(String errorCode, String errorMessage) {
            super();
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
            this.timestamp = new Date();
        }
    }
}
