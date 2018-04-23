/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.util;

/**
 *
 * @author DSR
 */
public class MensajeUtil {

    public static String controlMessagesStaticEntity(String msgStatic, String msgEntity) {
        String concatenado = "";
        String[] s = new String[2];
        s[0] = msgStatic;
        s[1] = msgEntity;
        concatenado = s[0] + " " + s[1];
        return concatenado;
    }
}
