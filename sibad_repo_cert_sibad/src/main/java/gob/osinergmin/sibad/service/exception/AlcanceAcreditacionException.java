/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.exception;

/**
 *
 * @author jpiro
 */
public class AlcanceAcreditacionException extends BaseException {
    public AlcanceAcreditacionException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public AlcanceAcreditacionException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public AlcanceAcreditacionException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public AlcanceAcreditacionException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public AlcanceAcreditacionException(String codigo) {
            super(codigo);	
    }
}
