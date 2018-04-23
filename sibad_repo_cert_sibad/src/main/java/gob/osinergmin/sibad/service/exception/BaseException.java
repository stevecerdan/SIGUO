/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.exception;

import gob.osinergmin.sibad.util.PropertyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DSR
 */
public class BaseException extends Exception  {
    private static final long serialVersionUID = -8988101228989337918L;
    public static final String ERROR_GENERICO = "generico.service.error";	
    private String codigo;
    private List<String> validationErrors = new ArrayList<String>(); 	

    /**
     * Constructor de la clase BaseException que recibe como parametro exception
     * 
     * @param exception
     */
    public BaseException(Exception exception) {
            super(exception);
            if(exception instanceof BaseException){
                    BaseException baseEx = (BaseException)exception;	
                    setCodigo(baseEx.getCodigo());
            }
    }

    /**
     * Constructor de la clase BaseException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public BaseException(String message, Exception exception) {
            super(message, exception);
            if(exception instanceof BaseException){
                    BaseException baseEx = (BaseException)exception;	
                    setCodigo(baseEx.getCodigo());
            }
    }

    /**
     * Constructor de la clase BaseException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public BaseException(String codigo, Exception exception, boolean buscarCodigo) {		
            super(PropertyUtils.getProperty(codigo) + " \n " +exception.getMessage(), exception);
            if(exception instanceof BaseException){
                    BaseException baseEx = (BaseException)exception;	
                    setCodigo(baseEx.getCodigo());
            }
    }

    /**
     * Constructor de la clase BaseException que recibe como parametros
     * codigoException, message y exception
     * 
     * @param codigo
     * @param message
     * @param exception
     */
    public BaseException(String codigo, String message, Exception exception) {		
            super(message, exception);
            this.codigo = codigo;
            if(exception instanceof BaseException){
                    BaseException baseEx = (BaseException)exception;	
                    setCodigo(baseEx.getCodigo());
            }
    }

    /**
     * Constructor de la clase BaseException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public BaseException(String codigo) {
            super(PropertyUtils.getProperty(codigo));
            this.codigo = codigo;
    }

    /**
     * @return the codigoException
     */
    public String getCodigo() {
            return codigo;
    }	

    public void setCodigo(String codigo) {
            this.codigo = codigo;
    }	

    public List<String> getValidationErrors() {
            return validationErrors;
    }

    public void setValidationErrors(List<String> validationErrors) {
            this.validationErrors = validationErrors;
    }
}
