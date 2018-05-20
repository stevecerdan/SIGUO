package gob.osinergmin.sibad.service.exception;

public class AlmacenamientoException extends BaseException{
	
	 public AlmacenamientoException(Exception exception) {
         super(exception);
 }

 /**
  * Constructor de la clase ContratoLocadorException que recibe como parametros message
  * y exception
  * 
  * @param message
  * @param exception
  */
 public AlmacenamientoException(String message, Exception exception) {
         super(message, exception);
 }

 /**
  * Constructor de la clase ContratoLocadorException que recibe como parametros message
  * y exception
  * 
  * @param message
  * @param exception
  */
 public AlmacenamientoException(String codigo, Exception exception, boolean buscarCodigo) {		
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
 public AlmacenamientoException(String codigo, String message, Exception exception) {		
         super(codigo, message, exception);		
 }

 /**
  * Constructor de la clase ContratoLocadorException que recibe como parametro
  * codigoException
  * 
  * @param codigo
  */
 public AlmacenamientoException(String codigo) {
         super(codigo);	
 }

}
