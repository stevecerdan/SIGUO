package gob.osinergmin.sibad.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    private FileUtil() {
    }
    
    public static void copyFile(InputStream instream, String pathTo) throws Exception {
    	try{
	        OutputStream os = new FileOutputStream(pathTo);
	        byte[] buffer = new byte[8192];
	        int bytesRead = 0;
	        while((bytesRead = instream.read(buffer, 0, 8192)) != -1){
	        	os.write(buffer, 0, bytesRead);
	        }
	        os.close();
	        instream.close();
    	}catch(Exception ex){
    		LOG.error("Ocurrió un error al copiar el archivo", ex);
    		throw ex;
    	}
    }
    
    public static void deleteFile(String pathFile) throws Exception {
    	try{
	        File file = new File(pathFile);
	        if(!file.delete()){
	        	throw new Exception("No se pudo borrar el archivo");
	        }
    	}catch(Exception ex){
    		LOG.error("Ocurrió un error al borrar el archivo", ex);
    		throw ex;
    	}
    }
    
    public static String getFileExtension(String filename) throws Exception {
    	String extension = null;
    	try{
    		extension = filename.substring(filename.lastIndexOf('.') + 1).toUpperCase();
    	}catch(Exception ex){
    		LOG.error("Ocurrió un error al intentar obtener la extensión del archivo", ex);
    		throw ex;
    	}
    	return extension;
    }
   
    public static boolean esExtensionArchivoValida(String originalFileName, String extensionesValidas) throws Exception{
    	boolean esExtensionArchivoValida = false;
    	String extensionArchivo = getFileExtension(originalFileName).toLowerCase();
    	if(Arrays.asList(extensionesValidas.toLowerCase().split(",")).contains(extensionArchivo)){
    		esExtensionArchivoValida = true;
		}
    	return esExtensionArchivoValida;
    }
    
   public static boolean esTamanioArchivoValido(long tamanioArchivoMaximo, long tamanioArchivo){
	   boolean esTamanioArchivoValido = false;
	   if(tamanioArchivoMaximo >= tamanioArchivo){
		   esTamanioArchivoValido = true;
	   }
	   return esTamanioArchivoValido;
   }

}
