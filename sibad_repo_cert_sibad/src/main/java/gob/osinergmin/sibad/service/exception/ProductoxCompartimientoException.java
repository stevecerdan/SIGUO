package gob.osinergmin.sibad.service.exception;

public class ProductoxCompartimientoException  extends BaseException{
	public ProductoxCompartimientoException(Exception exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}
	
    
	public ProductoxCompartimientoException(String message, Exception exception) {
          super(message, exception);
    }
	  
   public ProductoxCompartimientoException(String codigo, Exception exception, boolean buscarCodigo) {		
         super(codigo, exception, buscarCodigo);
   }

   public ProductoxCompartimientoException(String codigo, String message, Exception exception) {		
       super(codigo, message, exception);	
       
   }
   
  public ProductoxCompartimientoException(String codigo) {
       super(codigo);	
  } 
}
