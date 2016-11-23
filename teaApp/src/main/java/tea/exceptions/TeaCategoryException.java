package tea.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeaCategoryException extends RuntimeException {
		
	public TeaCategoryException(String codeId) {
		super(codeId);
	}
	
	public TeaCategoryException() {
		super("0");
	}
}