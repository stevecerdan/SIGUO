package gob.osinergmin.sibad.service.exception;

public class SigedException extends BaseException{

	private static final long serialVersionUID = -3547542456201836536L;

	/**
	 * Constructor de la clase SigedException que recibe como parametro exception
	 * 
	 * @param exception
	 */
	public SigedException(Exception exception) {
		super(exception);
	}

	/**
	 * Constructor de la clase SigedException que recibe como parametros message
	 * y exception
	 * 
	 * @param message
	 * @param exception
	 */
	public SigedException(String message, Exception exception) {
		super(message, exception);
	}
	
	/**
	 * Constructor de la clase SigedException que recibe como parametros message
	 * y exception
	 * 
	 * @param message
	 * @param exception
	 */
	public SigedException(String codigo, Exception exception, boolean buscarCodigo) {		
		super(codigo, exception, buscarCodigo);
	}

	/**
	 * Constructor de la clase SigedException que recibe como parametros
	 * codigoException, message y exception
	 * 
	 * @param codigo
	 * @param message
	 * @param exception
	 */
	public SigedException(String codigo, String message, Exception exception) {		
		super(codigo, message, exception);		
	}

	/**
	 * Constructor de la clase SigedException que recibe como parametro
	 * codigoException
	 * 
	 * @param codigo
	 */
	public SigedException(String codigo) {
		super(codigo);	
	}
}
