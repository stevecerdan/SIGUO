package gob.osinergmin.sibad.service.exception;

public class ResultadoDocumentoException extends BaseException{

	public ResultadoDocumentoException(Exception exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}
	
    
	public ResultadoDocumentoException(String message, Exception exception) {
          super(message, exception);
    }
	  
   public ResultadoDocumentoException(String codigo, Exception exception, boolean buscarCodigo) {		
         super(codigo, exception, buscarCodigo);
   }

   public ResultadoDocumentoException(String codigo, String message, Exception exception) {		
       super(codigo, message, exception);	
       
   }
   
  public ResultadoDocumentoException(String codigo) {
       super(codigo);	
  } 
}
