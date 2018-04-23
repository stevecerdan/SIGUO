/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.util;

import org.jfree.util.Log;

/**
 *
 * @author DSR
 */
public class StringUtil {

    public static final String REGEX_BLANK_SPACE = "\\s{2,}";
    public static final String REGEX_BLANK_SPACE_SIMPLE = " ";

    public static boolean isEmpty(String obj) {
        if ((obj == null) || (obj.trim().length() == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmptyNum(Long obj) {
        if ((obj == null) || (obj.longValue() == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static String fixer(String cadena) {
        if (!isEmpty(cadena)) {
            cadena = (cadena.replaceAll(REGEX_BLANK_SPACE, " ")).trim();
        }
        return cadena;
    }

    public static String removeBlank(String cadena) {
        if (!isEmpty(cadena)) {
            cadena = (cadena.replaceAll(REGEX_BLANK_SPACE_SIMPLE, " ")).trim();
        }
        return cadena;
    }

    public static String fixerUpper(String cadena) {
        if (!isEmpty(cadena)) {
            cadena = (cadena.replaceAll(REGEX_BLANK_SPACE, " ")).trim().toUpperCase();
        }
        return cadena;
    }
    
	/**
	 * Convierte una cadena nula a vacio
	 * 
	 * @param texto
	 * @return cadena vacia
	 */
	public static String nullToBlank(Object texto) {
		try {
			if (texto == null) {
				return "";
			}
			if (texto.toString().trim().equals("null")) {
				return "";
			}
			return texto.toString().trim();
		} catch (Exception e) {
			Log.error("Error StringUtil metodo nullToBlank. ");
			return "";
		}

	}
	
	public static boolean isNumeric(String numero){
        try{
        	Long.parseLong(numero);
        }catch(Exception e){
        	return false;
        }
    	return true;
    }
}
