package gob.osinergmin.sibad.service.exception;

public class TrazAlcanceAcredException extends BaseException {

	public TrazAlcanceAcredException(Exception exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}
	
	
	public TrazAlcanceAcredException(String message, Exception exception) {
        super(message, exception);
}

	/**
	 * Constructor de la clase ContratoLocadorException que recibe como parametros message
	 * y exception
	 * 
	 * @param message
	 * @param exception
	 */
	public TrazAlcanceAcredException(String codigo, Exception exception, boolean buscarCodigo) {		
	        super(codigo, exception, buscarCodigo);
	}
	
	/**
	 * Constructor de la clase ContratoLocadorException que recibe como parametros
	 * codigoException, message y exception
	 * 
	 * @param codigo
	 * @param message
	 * @param exception
	 */
	public TrazAlcanceAcredException(String codigo, String message, Exception exception) {		
	        super(codigo, message, exception);		
	}
	
	/**
	 * Constructor de la clase ContratoLocadorException que recibe como parametro
	 * codigoException
	 * 
	 * @param codigo
	 */
	public TrazAlcanceAcredException(String codigo) {
	        super(codigo);	
	}

}
