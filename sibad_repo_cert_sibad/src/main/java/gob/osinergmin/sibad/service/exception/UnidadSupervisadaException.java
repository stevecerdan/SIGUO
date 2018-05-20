package gob.osinergmin.sibad.service.exception;

public class UnidadSupervisadaException extends BaseException{

	 public UnidadSupervisadaException(Exception exception) {
         super(exception);
 }

 /**
  * Constructor de la clase ContratoLocadorException que recibe como parametros message
  * y exception
  * 
  * @param message
  * @param exception
  */
 public UnidadSupervisadaException(String message, Exception exception) {
         super(message, exception);
 }

 /**
  * Constructor de la clase ContratoLocadorException que recibe como parametros message
  * y exception
  * 
  * @param message
  * @param exception
  */
 public UnidadSupervisadaException(String codigo, Exception exception, boolean buscarCodigo) {		
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
 public UnidadSupervisadaException(String codigo, String message, Exception exception) {		
         super(codigo, message, exception);		
 }

 /**
  * Constructor de la clase ContratoLocadorException que recibe como parametro
  * codigoException
  * 
  * @param codigo
  */
 public UnidadSupervisadaException(String codigo) {
         super(codigo);	
 }
}
