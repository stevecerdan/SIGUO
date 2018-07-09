package gob.osinergmin.sibad.service.exception;

public class ResultadoPersonaNaturalException extends BaseException{
	public ResultadoPersonaNaturalException(Exception exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}
	
    
	public ResultadoPersonaNaturalException(String message, Exception exception) {
          super(message, exception);
    }
	  
   public ResultadoPersonaNaturalException(String codigo, Exception exception, boolean buscarCodigo) {		
         super(codigo, exception, buscarCodigo);
   }

   public ResultadoPersonaNaturalException(String codigo, String message, Exception exception) {		
       super(codigo, message, exception);	
       
   }
   
  public ResultadoPersonaNaturalException(String codigo) {
       super(codigo);	
  } 
}
