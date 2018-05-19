package gob.osinergmin.sibad.service.exception;

public class AlcanceAcreditacionException extends BaseException{

	public AlcanceAcreditacionException(Exception exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}
	
    
	public AlcanceAcreditacionException(String message, Exception exception) {
          super(message, exception);
    }
	  
   public AlcanceAcreditacionException(String codigo, Exception exception, boolean buscarCodigo) {		
         super(codigo, exception, buscarCodigo);
   }

   public AlcanceAcreditacionException(String codigo, String message, Exception exception) {		
       super(codigo, message, exception);	
       
   }
   
  public AlcanceAcreditacionException(String codigo) {
       super(codigo);	
  } 
}
