package it.istat.mec.regedit.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.istat.mec.regedit.bean.FaultResponse;
import lombok.extern.slf4j.Slf4j;

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
	public ResponseEntity<FaultResponse> noDataException(Exception ex) {
		FaultResponse response = new FaultResponse(HttpStatus.NO_CONTENT.toString(), ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<FaultResponse> genericException(Exception ex) {
		FaultResponse response = new FaultResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
