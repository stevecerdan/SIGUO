package gob.osinergmin.sibad.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseUtil.class);

    private ResponseUtil() {
    }

    public static void escribirEnResponse(HttpServletResponse response, String mensaje) {
        escribirEnResponse(response, mensaje, true);
    }

    public static void escribirEnResponse(HttpServletResponse response, String mensaje, boolean cerrarWriter) {
        PrintWriter writer = null;
        try {
            try {
                writer = response.getWriter();
                writer.write(mensaje);
                writer.flush();
            } finally {
                if (cerrarWriter && writer != null) {
                    writer.close();
                }
            }
        } catch (Exception ex2) {
            LOG.error("No se pudo escribir en el response", ex2);
        }
    }
    
    public static void escribirArchivoEnResponse(HttpServletResponse response, byte[] archivo, String nombreArchivo) {
        LOG.debug("Inicia la escritura del archivo en el objeto response");
        try{
            if(archivo != null && archivo.length > 0){
            	response.setHeader("Content-Disposition", "; filename=\"" + nombreArchivo + "\";");
        		response.setContentLength(Long.valueOf(archivo.length).intValue());
        		response.setContentType("application/octet-stream");

        		IOUtils.write(archivo, response.getOutputStream());
        		response.flushBuffer();
            }
        } catch (Exception ex) {
            LOG.error("No se pudo escribir el archivo en el response", ex);
        }
        LOG.debug("Termina la escritura del archivo en el objeto response");
    }
    
    public static void escribirArchivoEnResponse(HttpServletResponse response, File archivo, String nombreArchivo) {
        LOG.debug("Inicia la escritura del archivo en el objeto response");
        try{
        	response.setHeader("Content-Disposition", "; filename=\"" + nombreArchivo + "\";");
    		response.setContentLength(Long.valueOf(archivo.length()).intValue());
    		response.setContentType("application/octet-stream");

    		InputStream inputStream = new FileInputStream(archivo);
    		IOUtils.copy(inputStream, response.getOutputStream());
    		response.flushBuffer();
        }catch(Exception ex){
            LOG.error("No se pudo escribir el archivo en el response", ex);
        }
        LOG.debug("Termina la escritura del archivo en el objeto response");
    }
    
}
