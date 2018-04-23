/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author DSR
 */
public class FechaUtil {

    public static String FORMATO_FECHA_LARGE = "dd/MM/yyyy hh:mm:ss";
    public static String FORMATO_FECHA_LARGE_1 = "dd/MM/yyyy h:mm a";
    public static String FORMATO_FECHA_LARGE_2 = "dd/MM/yyyy hh:mm";
    public static String FORMATO_FECHA_CORTA = "dd/MM/yyyy";
    public static String FORMATO_FECHA_CORTA_1 = "dd-MM-yyyy";
    public static String FORMATO_HORA_CORTA_1 = "h:mm a";

    /**
     * Retorna una cadena vacia en caso de ser null
     *
     * @param texto
     * @return
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
            return "";
        }

    }

    /**
     * entrega un objetod el tipo GregorianCalendar con la fecha indicada
     *
     * @param fecha texto a convertir en fecha
     * @param formato usar Utils.FORMATO_FECHA_CORTA o Utils.FORMATO_FECHA_LARGE
     * @return objeto gregoriancalendar con la fecha en el formato indicado
     * @throws Exception
     */
    public static GregorianCalendar stringToCalendar(String fecha,
            String formato){
        GregorianCalendar gc = new GregorianCalendar();
        try {
            fecha = nullToBlank(fecha);
            SimpleDateFormat df = new SimpleDateFormat(formato);
            gc.setTime(df.parse(fecha));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gc;
    }

    /**
     * Convierte fecha de tipo calendar a String con formato
     *
     * @param fecha
     * @param formato
     * @return
     * @throws Exception
     */
    public static String CalendarToString(Calendar fecha, String formato)
            throws Exception {
        if (nullToBlank(fecha).equals("")) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(formato);
        return df.format(fecha.getTime());
    }

    /**
     * Convierte Date a String con formato
     *
     * @param fecha
     * @param formato
     * @return
     * @throws Exception
     */
    public static String DateToString(Date fecha, String formato){
        if (nullToBlank(fecha).equals("")) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(formato);
        return df.format(fecha);
    }

    /**
     * Valida si es una fecha correcta
     *
     * @param fecha
     * @param formato
     * @return
     * @throws Exception
     */
    public static String ValidaDate(String fecha, String formato)
            throws Exception {
        fecha = nullToBlank(fecha);
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat(formato);
        gc.setTime(df.parse(fecha));
        return df.format(gc.getTime());
    }

    /**
     * Convierte fecha cadena a fecha Date
     *
     * @param fecha
     * @param formato
     * @return
     * @throws Exception
     */
    public static Date stringToDate(String fecha, String formato){
        if(fecha==null || fecha.equals("")){
            return null;
        }        
        GregorianCalendar gc = new GregorianCalendar();
        try {
            fecha = nullToBlank(fecha);
            SimpleDateFormat df = new SimpleDateFormat(formato);
            gc.setTime(df.parse(fecha));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gc.getTime();
    }

    /**
     * Convierte Date a tipo Calendar
     *
     * @param fecha
     * @param formato
     * @return
     * @throws Exception
     */
    public static Calendar dateToCalendar(Date fecha, String formato)
            throws Exception {
        if (nullToBlank(fecha).equals("")) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(formato);
        String text = df.format(fecha);
        return stringToCalendar(text, formato);
    }

    /**
     * Calcula los dias para un determinada fecha
     *
     * @param fechafin
     * @return
     */
    public static int diasParaFecha(Date fechafin) {
        try {
            System.out.println("Fecha = " + fechafin + " / ");
            GregorianCalendar fin = new GregorianCalendar();
            fin.setTime(fechafin);
            System.out.println("fin=" + CalendarToString(fin, "dd/MM/yyyy"));
            GregorianCalendar hoy = new GregorianCalendar();
            System.out.println("hoy=" + CalendarToString(hoy, "dd/MM/yyyy"));

            if (fin.get(Calendar.YEAR) == hoy.get(Calendar.YEAR)) {
                System.out.println("Valor de Resta simple: "
                        + String.valueOf(fin.get(Calendar.DAY_OF_YEAR)
                        - hoy.get(Calendar.DAY_OF_YEAR)));
                return fin.get(Calendar.DAY_OF_YEAR)
                        - hoy.get(Calendar.DAY_OF_YEAR);
            } else {
                int diasAnyo = hoy.isLeapYear(hoy.get(Calendar.YEAR)) ? 366
                        : 365;
                int rangoAnyos = fin.get(Calendar.YEAR)
                        - hoy.get(Calendar.YEAR);
                int rango = (rangoAnyos * diasAnyo)
                        + (fin.get(Calendar.DAY_OF_YEAR) - hoy
                        .get(Calendar.DAY_OF_YEAR));
                System.out.println("dias restantes: " + rango);
                return rango;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
