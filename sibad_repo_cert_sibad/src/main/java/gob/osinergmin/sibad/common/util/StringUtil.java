package gob.osinergmin.sibad.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author diego.gil
 */
public class StringUtil {

    private static Logger log = LoggerFactory.getLogger(StringUtil.class);
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
    
    public static String formatDecimalSinComas(double number, int minDecimalDigits,int maxDecimalDigits)
            throws IllegalArgumentException{
            if(maxDecimalDigits<minDecimalDigits)throw new IllegalArgumentException(
                "maxDecimalDigits must be higher than minDecimalDigits");
            if(minDecimalDigits<0)throw new IllegalArgumentException(
                "decimalDigits parameters must be non negative");
            StringBuffer pattern=new StringBuffer("#####0");
            int decimalDigits=minDecimalDigits;
            if (decimalDigits>0)
            {   pattern.append('.');
                while (decimalDigits>0){
                    pattern.append('0');
                    decimalDigits--;
                }
            }
            if(maxDecimalDigits>0)
            {
                if(minDecimalDigits==0) pattern.append('.');
                decimalDigits=maxDecimalDigits-minDecimalDigits;
                while (decimalDigits>0){
                    pattern.append('#');
                    decimalDigits--;
                }
            }
            java.text.DecimalFormat df=new java.text.DecimalFormat(pattern.toString());
            java.text.DecimalFormatSymbols dfs=df.getDecimalFormatSymbols();
            dfs.setDecimalSeparator('.');
            dfs.setGroupingSeparator(',');
            df.setDecimalFormatSymbols(dfs);
            return df.format(round(number,maxDecimalDigits));
        }
    
    public static double round(double number, int decimalDigits){
        java.math.BigDecimal in=new java.math.BigDecimal(number);
        return in.setScale(decimalDigits,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}