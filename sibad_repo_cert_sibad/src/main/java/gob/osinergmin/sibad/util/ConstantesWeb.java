package gob.osinergmin.sibad.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import gob.osinergmin.sibad.util.ConstantesWeb;

/**
 *
 * @author DSR
 */
public class ConstantesWeb {
    public static final int VV_EXITO = 0;
    public static final int VV_ERROR = 1;
    public static final int VV_ADVERTENCIA = 2;
    
    public static final String VV_RESULTADO = "resultado";
    public static final String VV_MENSAJE = "mensaje";
    
    public static String FECHA="";
    public static String USUARIO="";
    public static final String CSRF_TOKEN_NAME = "ctoken";
    public static final int VV_URL_INSECURE = 2;
    
    private ConstantesWeb() {
    }
    
    public static String getFECHA() {
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        String prefix = DATE_FORMAT.format(today);
        ConstantesWeb.FECHA=prefix;
        return ConstantesWeb.FECHA;
    }
    
    public static String getUSUARIO(HttpServletRequest request) {
        String usuario = ((String) request.getSession().getAttribute("j_username"));
        ConstantesWeb.USUARIO=usuario;
        return ConstantesWeb.USUARIO;
    }
   
    
    public static class Navegacion{
    	public static final String PAGE_ERROR_403 = "error/403";
    	public static final String PAGE_ERROR_404 = "error/404";
    	public static final String PAGE_ERROR_405 = "error/405";
    	public static final String PAGE_ERROR_ACCESS = "error/accessError";
    	public static final String PAGE_ERROR = "error/error";
    	public static final String PAGE_ERROR_EXPIRED = "error/expired";
    	
    	public static final String PAGE_BUSQUEDA_FORMATOS = "busquedaFormatos";        
        public static final String PAGE_FORMATO_NUEVO = "solicitudes/nuevo";
        
        public static final String PAGE_BANDEJA_SUPERVISION = "supervisiones/bandejaSupervision";
        public static final String PAGE_DETALLE_SUPERVISION = "supervisiones/detalleSupervision";
        
        public static final String PAGE_MENU_PRINCIPAL= "menuGeneral";
        public static final String PAGE_MENU_UNIDAD_OPERATIVA= "menuUnidadOperativa";
        
        public static final String PAGE_BANDEJA_EMPRESAS_ACREDITADAS = "empresasAcreditadas/mantenimientoEmpresasAcreditadas";
        public static final String PAGE_FRM_NUEVA_EMPRESA_ACREDITADA = "empresasAcreditadas/nuevaEmpresaAcreditada";
        public static final String PAGE_GENERAL_FRM_ESTADO_ACCION = "empresasAcreditadas/frmEstadoAccion";
        public static final String PAGE_FRM_NUEVO_ALCANCE_ACREDITACION = "empresasAcreditadas/nuevoAlcanceAcreditacion";
        public static final String PAGE_FRM_NUEVA_SEDE = "empresasAcreditadas/frmNuevaSede";
        public static final String PAGE_FRM_PERSONAL_SEDE = "empresasAcreditadas/frmPersonalSede";
        public static final String PAGE_FRM_INSPECTOR_AUTORIZADO = "empresasAcreditadas/frmInspectorAutorizado";
        public static final String PAGE_FRM_EQUIPO_CERTIFICADO = "empresasAcreditadas/frmEquipoCertificado";
        public static final String PAGE_FRM_INACTIVAR_EQUIPO_AUTORIZADO = "empresasAcreditadas/frmInactivarEquipoAutorizado";
        public static final String PAGE_FRM_INFORMACION = "empresasAcreditadas/frmInformacion";
        
        public static final String PAGE_FRM_VENTANA_CRON = "empresasAcreditadas/VentanaCron";
        
        public static final String PAGE_BANDEJA_TANQUE_CL = "InspeccionMantenimientoLimpieza/tanqueCL";
        public static final String PAGE_FRM_NUEVA_PROGRAMACION_INSPECCION_MANTENIMIENTO_LIMPIEZA = "InspeccionMantenimientoLimpieza/pIndividualMasiva";
    	public static final String PAGE_FRM_PRUEBA = "InspeccionMantenimientoLimpieza/frmDocumentoAdjunto";
    	public static final String PAGE_FRM_CANCELAR_PROGRAMACION = "InspeccionMantenimientoLimpieza/frmCancelacion";
    	public static final String PAGE_FRM_REPROGRAMAR = "InspeccionMantenimientoLimpieza/frmReprogramacion";
    	public static final String PAGE_FRM_REVISION = "InspeccionMantenimientoLimpieza/frmRevision";
    	public static final String PAGE_FRM_RESUTADO_PERSONAL_AUTORIZADO = "InspeccionMantenimientoLimpieza/frmResultadoPersonalAut";
    	public static final String PAGE_FRM_INFORMACION_ESTADO_IML = "InspeccionMantenimientoLimpieza/frmInformeEstado";
        
    	public static final String PAGE_BANDEJA_PRUEBA_HERMETICIDAD = "solicitudPruebasHermeticidad/bandejaPruebasHermeticidad";
    	public static final String PAGE_FRM_PRUEBA_HERMETICIDAD = "solicitudPruebasHermeticidad/frmPruebaHermeticidad";
    	public static final String PAGE_FRM_EST_REPROGRAMAR_CANCELAR = "solicitudPruebasHermeticidad/frmEstReprogramarCancelar";
    	public static final String PAGE_FRM_CONFIRMAR_SOLICITUD = "solicitudPruebasHermeticidad/frmConfirmarSolicitud";
    	public static final String PAGE_FRM_INFORMACION_ESTADO = "solicitudPruebasHermeticidad/frmInformeEstado";
    	public static final String PAGE_FRM_INFORME_RIESGO = "solicitudPruebasHermeticidad/frmIndiceRiesgo";
    	public static final String PAGE_FRM_PROXIMA_PRUEBA_HERMETICIDAD = "solicitudPruebasHermeticidad/frmProximaPruebaHermeticidad";
    	public static final String PAGE_FRM_RESULTADO_PERSONA_AUT = "solicitudPruebasHermeticidad/frmResultadoPersonalAut";
    	
    	public static final String PAGE_BANDEJA_REPRUEBA_CILINDRO_GNV = "repruebasCilindroGNV/BandejaRepruebasCilindroGNV";
    	public static final String PAGE_FRM_REGISTRO_SOLICITUD_REPRUEBA = "repruebasCilindroGNV/frmRegistroSolicitudRepruebaGNV";
    	public static final String PAGE_FRM_REPROGRAMACION_CANCELACION = "repruebasCilindroGNV/frmReprogramacionCancelacion";
    	public static final String PAGE_FRM_CONFIRMAR_SOLICITUD_GNV = "repruebasCilindroGNV/frmMsjConfirmacion";
    	
    	//PAGE_FRM_REPRUEBA_CILINDROS_GNV
		public static final String PAGE_FRM_REPRUEBA_CILINDROS_GNV = "repruebasCilindroGNV/frmRepruebaCilindrosGNV";
    	
    	public static final String PAGE_BANDEJA_RESULTADOS_PRUEBA_HERMETICIDAD = "resultadoPruebasHermeticidad/bandejaResultadoPruebasHermeticidad";
    	public static final String PAGE_FRM_ESTADO_REPROG_CANCEL = "resultadoPruebasHermeticidad/frmEstadoReprogCancel";
    	public static final String PAGE_FRM_RESULTADO_PRUEBA_HERMETICIDAD = "resultadoPruebasHermeticidad/frmResultadoPruebaHermeticidad";
    	
    	
    }
    
    public static class mensajes{
    	//Mensajes 
        public static final String MSG_OPERATION_SUCCESS_CREATE="Se guardo satisfactoriamente: ";
        public static final String MSG_OPERATION_SUCCESS_UPDATE="Se actualizo satisfactoriamente:";
        public static final String MSG_OPERATION_SUCCESS_DELETE="Se elimino satisfactoriamente:";
        
        public static final String MSG_OPERATION_FAIL_CREATE="Fallo al guardar: ";
        public static final String MSG_OPERATION_FAIL_UPDATE="Fallo al actualizar: ";
        public static final String MSG_OPERATION_FAIL_DELETE="Fallo al eliminar: ";
        
        public static final String MSG_OPERATION_FAIL_CREATE_DUPLICATE="Ya Existe ";
        
        public static final String MSG_OPERATION_SUCCESS_GENERAR_SEMESTRE="Se genero satisfactoriamente";
        public static final String MSG_OPERATION_SUCCESS_CREATE_RELATION="Se asign\u00F3 satisfactoriamente: ";
        public static final String MSG_OPERATION_SUCCESS_UPDATE_RELATION="Se actualiz\u00F3 satisfactoriamente: ";
        public static final String MSG_OPERATION_SUCCESS_DELETE_RELATION="Se elimin\u00F3 satisfactoriamente: ";
        //ROY - INICIO
        public static final String MSG_OPERATION_SUCCESS_CREATE_FRM="Se registr\u00F3 satisfactoriamente: ";
        //ROY - FIN
        public static final String MSG_OPERATION_FAIL_CREATE_RELATION="Fallo al asignar: ";
        public static final String MSG_OPERATION_FAIL_DELETE_RELATION="Fallo al desasignar: ";
                
        //Entidades
        public static final String MSG_ENTITY_SOLICITUD_EEC="Solicitud Estado Cuenta";
        
    }
    
}
