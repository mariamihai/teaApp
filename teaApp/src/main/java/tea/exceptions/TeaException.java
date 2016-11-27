package tea.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeaException extends RuntimeException {
		
	public TeaException(String codeId) {
		super(codeId);
	}
	
	public TeaException() {
		super("0");
	}
}