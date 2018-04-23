package gob.osinergmin.sibad.task;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component(value="periodicTask")
public class PeriodicTask implements ApplicationContextAware {
	
    private ApplicationContext context;  	
    private static final Logger LOG = LoggerFactory.getLogger(PeriodicTask.class);       
    
    @Value("${ruta_archivos_temporales}")    
    private String rutaZipGenerados;

    /**
     * Se ejecuta de acuerdo al property establecido, borra los archivos en la carpeta que tengan mas de un dia de antiguedad.
     */
	@Scheduled(cron="${archivo_intervalo_limpieza}")
	public synchronized void execute(){
	    try{
	    	LOG.info("Iniciando metodo: execute()");			    	
	    	eliminarArchivos(rutaZipGenerados);
	    }catch(Exception ex){
	    	LOG.error("Error metodo: execute()", ex);
	    }	    
	    LOG.info("Finalizando metodo: execute()");
	}
	
	private void eliminarArchivos(String rutaContenedor){
		LOG.info("Iniciando metodo: eliminarArchivos()");

		File folder = new File(rutaContenedor);     
		Calendar cal = (GregorianCalendar) Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -1);

		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);	        	
		Date fechaAyer = new GregorianCalendar(year, month, day).getTime();

		for (File f : folder.listFiles()) {			
			if (f.isFile() && FileUtils.isFileOlder(f, fechaAyer)) {
				try{
					LOG.info("borrando " + f.getAbsolutePath());
					f.delete();
				}catch(Exception ex){
					LOG.error("error al borrar " + f.getAbsolutePath(), ex);
				}
			} 
			if (f.isDirectory() && FileUtils.isFileOlder(f, fechaAyer)) {			
				try{
					LOG.info("borrando " + f.getAbsolutePath());
					FileUtils.deleteDirectory(f);
				}catch(Exception ex){
					LOG.error("error al borrar " + f.getAbsolutePath(), ex);
				}
			}
		}

		LOG.info("Finalizando metodo: eliminarArchivos()");
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context=context;
	}	

	public ApplicationContext getContext() {
		return context;
	}

}