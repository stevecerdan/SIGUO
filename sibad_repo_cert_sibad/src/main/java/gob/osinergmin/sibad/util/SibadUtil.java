package gob.osinergmin.sibad.util;

import gob.osinergmin.sibad.domain.dto.UsuarioDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

public class SibadUtil {
    /**
     * 
     * @param request
     * @return
     */
    public static UsuarioDTO obtenerUsuario(HttpServletRequest request) {
        //	UsuarioDTO usuarioView = (UsuarioDTO) sesion.getAttribute(Constantes.SESION_USUARIO);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        String usuario = ((String) request.getSession().getAttribute("j_username"));
        String nombre =((String) request.getSession().getAttribute("j_username"));//averiguar el los datos del logueo
        try {
        	if(usuario!=null){
        		usuarioDTO.setLogin(usuario);
        		usuarioDTO.setNombre(nombre);
        	}else{
        		usuarioDTO.setLogin("00002");
        		usuarioDTO.setNombre("Usuario Osinergmin");
        	}
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioDTO;
    }
    
    public static String obtenerTerminal() {
    	String terminal="";
        try {
        	terminal = Inet4Address.getLocalHost().getHostAddress().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terminal;
    }
    /**
     * 
     * @param string
     * @param largo
     * @return
     */
    public static String agregarCerosCodigoOsinerg(String string, int largo) {
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += "0";
            }

            return (ceros + string);
        } else {
            return string;
        }
    }
    /**
     * 
     * @param numero
     * @return
     * @throws ParseException
     */
    public static Double numeroConDosDecimales(Double numero) throws ParseException {
        DecimalFormat numFormat = new DecimalFormat("#.00");
        String resultado = numFormat.format(numero);
        Number numberRes = numFormat.parse(resultado);
        return numberRes.doubleValue();       
        /*
        resultado = resultado.replaceAll(",", ".");
        return new Double(resultado);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        String a = nf.format(numero);
        a = a.replaceAll(",", ".");
        return new Double(a);
        */
    }
    
    public static void imprimir(File filePdf, String ruta){
    	try {
    		InputStream in = new FileInputStream(filePdf);
            File file = new File(ruta);
//            File file = new File("D:\\imprimir");
            OutputStream out = new FileOutputStream(file);
            int b = 0;
            while (b != -1) {
              b = in.read();
              if (b != -1)
                out.write(b);
            }
            out.close();
            in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}