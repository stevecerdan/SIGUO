/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.util;

/**
 *
 * @author DSR
 */
public class Constantes {

    // jasper
    public static final String CONTENT_TYPE_EXPORT_REPORTE_EXCEL = "application/vnd.ms-excel";
    public static final String HEADER_UNO_REPORTE_EXCEL = "Content-Disposition";
    public static final String VALOR_HEADER_UNO_REPORTE_EXCEL = "attachment; filename=\"";
    public static final String HEADER_DOS_REPORTE_EXCEL = "Cache-Control";
    public static final String VALOR_DOS_REPORTE_EXCEL = "no-store";
    public static final String HEADER_TRES_REPORTE_EXCEL = "Pragma";
    public static final String VALOR_TRES_REPORTE_EXCEL = "private";
    public static final String HEADER_CUATRO_REPORTE_EXCEL = "Expires";
    public static final int VALOR_CUATRO_REPORTE_EXCEL = 1;
    public static final String EXTENSION_ARCHIVO_EXCEL = ".xls";
    public static final String EXTENSION_ARCHIVO_EXCEL_XLSX = ".xlsx";
    
    //Contante generales
    public static final long TIPO_DEPENDENCIA_DSR = 2;
    public static final long TIPO_DEPENDENCIA_DSE = 3;
    public static final long TIPO_DEPENDENCIA_GSM = 5;
    public static final long TIPO_DEPARTAMENTO_LIMA = 150000;
    public static final long TIPO_DEPARTAMENTO_CALLAO = 70000;
    
    
    
    public static final String CONSTANTE_ESTADO_ACTIVO = "1";
    public static final String CONSTANTE_ESTADO_INACTIVO = "0";
    public static final String DOMINIO_AMBITO_PARAMETRICO = "AMBITO_PARAMETRICO";
    public static final String DOMINIO_TIPO_CONSULTA = "TIPO_PARAMETRO";
    public static final String DOMINIO_TIPO_SANCION = "TIPO_SANCION";
    public static final String APPLICACION = "SIBAD";
    public static final String DESC_PROCESO_PRE_OPERATIVA = "PRE-OPERATIVA";
    public static final String DOMINIO_ANEXO_RRH = "ANEXO_RRH";
    public static final String DOMINIO_CALIFICACION = "CALIFICACION";
    public static final String DOMINIO_VALOR_UIT = "VALOR_UIT";
    public static final String DOMINIO_EVALUACION_PREVIA = "EVALUACION_PREVIA";
    public static final String DOMINIO_INICIO_PROCEDIMIENTO = "INICIO_PROCEDIMIENTO";
    public static final String DOMINIO_AUTORIDAD_RESOLVER = "AUTORIDAD_RESOLVER";
    public static final String DOMINIO_INST_RESO_RECONSI = "INST_RESO_RECONSI";
    public static final String DOMINIO_INST_RESO_APEL = "INST_RESO_APEL";
//    public static final String CONSTANTE_ARCHIVO_CRITERIO = "archivoCriterio";
//    public static final String CONSTANTE_ARCHIVO_OBLIGACION = "archivoObligacion";
//    public static final String CONSTANTE_ARCHIVO_DESCRIPCON = "archivoDescripcion";
    public static final String CONSTANTE_ARCHIVO_CROQUIS = "archivoCroquis";
    public static final String CONSTANTE_ARCHIVO_FOTOGRAFIA = "archivoFotoGrafia";
    public static final String CONSTANTE_ARCHIVO_ANALISIS_TRABAJO_SEGURO = "archivoAnalisisTrabajoSeguro";
    public static final String CONSTANTE_ARCHIVO_PARTE_MEDICO = "archivoParteMedico";
    public static final String CONSTANTE_ARCHIVO_INFORME_INVES_ACCI_INCI = "archivoInformeInveAcciInci";
    public static final String CONSTANTE_ARCHIVO_OTROS = "archivoOtros";
    
    public static final String CONSTANTE_NOMBRE_ARCHIVO_CROQUIS = "CROQUIS";
    public static final String CONSTANTE_NOMBRE_ARCHIVO_FOTOGRAFIA = "FOTO";
    public static final String CONSTANTE_NOMBRE_ARCHIVO_ANALISIS_TRABAJO_SEGURO = "ANALIS_TRAB_SEGU";
    public static final String CONSTANTE_NOMBRE_ARCHIVO_PARTE_MEDICO = "PARTE_MEDICO";
    public static final String CONSTANTE_NOMBRE_ARCHIVO_INFORME_INVES_ACCI_INCI = "INFORME_INVES_ACCI_INCI";
    public static final String CONSTANTE_NOMBRE_ARCHIVO_OTROS = "OTROS";
    
    public static final String COSNTANTE_ARCHIVO_ACCIONES_CORRECTIVAS_F5="archivoAccionesCorrectivas";
    public static final String COSNTANTE_ARCHIVO_ACCIONES_PREVENTIVAS_F5="archivoAccionesPreventivas";
    public static final String CONSTANTE_TRAZABILIDAD_NUEVO = "N";
    public static final String CONSTANTE_TRAZABILIDAD_MODIFICAR = "U";
    public static final String CONSTANTE_TRAZABILIDAD_ELIMINAR = "D";
    
    //Nombres de Secuenciadores
    public static final String CONSTANTE_SECUENCIADOR_EMERGENCIA = "MEM_EMERGENCIA_SEQ";
    public static final String CONSTANTE_SECUENCIADOR_SINIESTRO = "MEM_SINIESTRO_SEQ";
    public static final String CONSTANTE_SECUENCIADOR_ACCIDENTE = "MEM_ACCIDENTE_SEQ";
    
    public static final String CONSTANTE_SECUENCIADOR_REPORTE_INCIDENTE_DERRAME="MEM_REPT_INCI_DERRA_SEQ";
    public static final String CONSTANTE_SECUENCIADOR_REPORTE_SEMESTRAL_ACCIDENTE = "MEM_REPT_SEMT_ACCI_SEQ";
    
    public static final String CONSTANTE_SECUENCIADOR_REPORTE_SIETE = "MEM_RPORTE_SIETE_SEQ";
    //Codigos de Formatos
    public static final String CONSTANTE_CODIGO_FORMATO_UNO = "F01";
    public static final String CONSTANTE_CODIGO_FORMATO_DOS = "F02";
    public static final String CONSTANTE_CODIGO_FORMATO_TRES = "F03";
    public static final String CONSTANTE_CODIGO_FORMATO_CUATRO = "F04";
    public static final String CONSTANTE_CODIGO_FORMATO_CINCO = "F05";
    public static final String CONSTANTE_CODIGO_FORMATO_SEIS = "F06";
    public static final String CONSTANTE_CODIGO_FORMATO_SIETE = "F07";
    public static final String CONSTANTE_CODIGO_FORMATO_OCHO = "F08";
    public static final String CONSTANTE_CODIGO_FORMATO_NUEVE = "F09";
    public static final String CONSTANTE_CODIGO_FORMATO_DIEZ = "F10";
    public static final String CONSTANTE_CODIGO_FORMATO_ONCE = "F11";
    public static final String CONSTANTE_CODIGO_FORMATO_DOCE = "F12";
    
    //Tipos de Formatos
    public static final String CONSTANTE_TIPO_FORMATO_PRELIMINAR = "TIP_FOR_PRE";
    public static final String CONSTANTE_TIPO_FORMATO_FINAL = "TIP_FOR_FIN";
    public static final String CONSTANTE_TIPO_FORMATO_REPORTE = "TIP_FOR_REP";
    //Constantes Ubigeo
    public static final String TIPO_DEPARTAMENTO = "2";
    public static final String TIPO_PROVINCIA = "3";
    public static final String TIPO_DISTRITO = "4";
    
    //Contante generales
    public static final Long TIPO_DANIO_PERSONAS=1L;
    public static final Long TIPO_DANIO_MATERIALES=2L;
    public static final Long TIPO_MONEDAS=3L;
//    public static final Long ESTADO_ACTIVO=11L;
//    public static final Long ESTADO_INACTIVO=12L;
    
    //Constante Tipo Persona
    public static final String TIPO_PERSONA_ING_SEGURIDAD = "TIP_PER_ING_SEG";
    public static final String TIPO_PERSONA_REP_LEGAL = "TIP_PER_REP_LEG";
    public static final String TIPO_PERSONA_MEDICO = "TIP_PER_MEDICO";
    public static final String TIPO_PERSONA_SUPERVISOR = "TIP_PER_SUPER";
    public static final String TIPO_PERSONA_ACCIDENTADO = "TIP_PER_ACCIDNT";
    public static final String TIPO_PERSONA_TESTIGO = "TIP_PER_TESTIGO";
    
    //Constante Tipo Documentos
    public static final String TIPO_DOCUMENTO_CROQUIS = "TIPO_DOC_ADJ_CRO";
    public static final String TIPO_DOCUMENTO_ANALISIS_TRAB_SEGU = "TIPO_DOC_ADJ_ANLI_TR";
    public static final String TIPO_DOCUMENTO_FOTOGRAFIA = "TIPO_DOC_ADJ_FOTO";
    public static final String TIPO_DOCUMENTO_PARTE_MEDICO = "TIPO_DOC_ADJ_PART_ME";
    public static final String TIPO_DOCUMENTO_INFORME_INVES_ACCI_INCI = "TIPO_DOC_ADJ_INFORME";
    public static final String TIPO_DOCUMENTO_OTROS = "TIPO_DOC_ADJ_OTROS";
    
    
    //Tabla General
    public static final String TABLA_GENERAL_ESTADOS = "EST_SOLI";
    
//    
//    public static final String TABLA_GENERAL_TIPO_MONEDA = "TIPO_MONEDA";
//    public static final String TABLA_GENERAL_TIPO_SINIESTRO = "TIPO_SINIESTRO";
//    public static final String TABLA_GENERAL_TIPO_DOCUMENTO = "TIPO_DOCUMENTO";
//    public static final String TABLA_GENERAL_UNIDAD_AREA="UNIDAD_AREA";
//    public static final String TABLA_GENERAL_TIPO_FORMATO="TIPO_FORMATO";
//    public static final String TABLA_GENERAL_TIPO_DANIO_PERSONAL="TIPO_DANIO_PERSONAL";
//    public static final String TABLA_GENERAL_TIPO_PERSONAL="TIPO_PERSONAL";
//    public static final String TABLA_GENERAL_TIPO_JORNADA="TIPO_JORNADA";
//    public static final String TABLA_GENERAL_TIPO_LESION="TIPO_LESION";
//    public static final String TABLA_GENERAL_TIPO_TRABAJO="TIPO_TRABAJO";
//    public static final String TABLA_GENERAL_ACCIONES_SUBESTANDARES="ACCIONES_SUBSTNDRS";
//    public static final String TABLA_GENERAL_CONDICIONES_SUBESTANDARES="CONDCNS_SUBSTNDRS";
//    public static final String TABLA_GENERAL_FACTORES_PERSONALES="FACTOR_PERSONALES";
//    public static final String TABLA_GENERAL_FACTORES_TRABAJO="FACTOR_TRABAJO";
//    public static final String TABLA_GENERAL_ADEC_INADEC="ADEC_INADEC"; 
//    public static final String TABLA_GENETAL_TIPO_ARCHIVO_ADJUNTO="TIPO_ARCHIVO_ADJUNTO";
//    public static final String TIPO_DANIO_SI_NO="DANIOS_MATER";
//    public static final String TIPO_MESES="MESES";
//    public static final String TIPO_UNIDAD_MEDIDA_VOLUMEN="UNIDAD_VOL";
//    
//    public static final String TABLA_GENERAL_CAUSAS_BASICAS="CAUSAS_BASICAS";
//    public static final String TABLA_GENERAL_CAUSAS_INMEDIATAS="CAUSAS_INMEDIATAS";
    
//    //Constantes Tipos Causas
//    public static final Integer CONSTANTE_CAUSA_INMEDIATA = new Integer(1);
//    public static final Integer CONSTANTE_CAUSA_BASICA = new Integer(0);
//    
//    //Constantes Tipos Acciones
//    public static final Integer CONSTANTE_ACCION_CORRECTIVA = new Integer(1);
    
    //Constantes Estado del Registro
    public static final Long ESTADO_ACTIVO = new Long(1);
    public static final Long ESTADO_INACTIVO = new Long(0);
    
    //Constantes Estado Registro
    public static final Long ESTADO_REGISTRO_PENDIENTE = new Long(0);
    public static final Long ESTADO_REGISTRO_FINALIZADO = new Long(1);
    
    //Constantes de Session
    public static final String SESION_LISTA_CAUSA_IDENT_FORMATO="SESION_LISTA_CAUSA_IDENT_FORMATO";
    
    //Conexion a siged
    public static final String URL_EXPEDIENTE_CREAR="http://11.160.121.132:8180/siged-rest-old/remote/expediente/crear";
    public static final String URL_EXPEDIENTE_AGREGAR_DOCUMENTO="http://11.160.121.132:8180/siged-rest-old/remote/expediente/agregarDocumento";
    public static final String URL_EXPEDIENTE_AGREGAR_DESCARGA="http://11.160.121.132:8180/siged-rest-old/remote/expediente/documentosConVersiones";
    
    
    public static final String SESION_UNIDAD_OPERATIVA = "SESSION_UNIDAD_OPERATIVA";
    public static final String SESION_USUARIO = "SESSION_USUARIO"; 
    public static final String SESION_UNIDAD_SUPERVISADA = "SESSION_UNIDAD_SUPERVISADA";
        
  //Codigos de Formatos
    
    public static final String CONSTANTE_TIPOS_ARCHICOS = ".jpg|.docx|.xls|.pdf|.txt|.doc|.xlsx";
    public static final String CONSTANTE_TIPOS_ARCHIVOS_FORMATO_CUATRO = ".rar|.zip|.jpeg|.jpg|.pdf|.doc|.gif";
    public static final String CONSTANTE_TIPOS_ARCHIVOS_FORMATO_CINCO = ".rar|.zip|.jpeg|.jpg|.pdf|.doc|.gif";
    
    //Codigos de Formatos
    public static final String CONSTANTE_REPORTE_SOLICITUD = "/WEB-INF/reports/solicitud.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_DOS = "/WEB-INF/reports/formato_dos.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_DOS_SUB_REPORT_ACCIDENTADOS = "/WEB-INF/reports/formato_dos_sub_reporte_acciden.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_TRES = "/WEB-INF/reports/formato_tres.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CUATRO = "/WEB-INF/reports/formato_cuatro.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CUATRO_SUB_REPORT_CONDI_SUBESTND = "/WEB-INF/reports/formato_cuatro_subreporte_cond_subest.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CUATRO_SUB_REPORT_ACTO_SUBESTND = "/WEB-INF/reports/formato_cuatro_subreporte_acto_subest.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CUATRO_SUB_REPORT_FACT_PERS = "/WEB-INF/reports/formato_cuatro_subreporte_fact_pers.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CUATRO_SUB_REPORT_FACT_TRAB = "/WEB-INF/reports/formato_cuatro_subreporte_fact_trab.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CUATRO_SUB_REPORT_MEDI_ADOP = "/WEB-INF/reports/formato_cuatro_subreporte_medi_corr.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CUATRO_SUB_REPORT_TESTIGOS = "/WEB-INF/reports/formato_cuatro_subreporte_testigos.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CUATRO_SUB_REPORT_DOC_ADJ = "/WEB-INF/reports/formato_cuatro_subreporte_doc_adj.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CINCO = "/WEB-INF/reports/formato_cinco.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_SEIS = "/WEB-INF/reports/formato_seis.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_SEIS_SUB_REPORT_CAUSAS_EMER = "/WEB-INF/reports/formato_seis_subreporte_causas.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_CINCO_SUB_REPORT_CAUSAS_EMER = "/WEB-INF/reports/formato_cinco_subreporte_causas.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_SEIS_SUB_REPORT_MEDIDAS = "/WEB-INF/reports/formato_seis_subreporte_medidas.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_SEIS_SUB_REPORT_ACCIONES = "/WEB-INF/reports/formato_seis_subreporte_acciones.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_SIETE = "/WEB-INF/reports/formato_siete.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_OCHO = "/WEB-INF/reports/formato_ocho.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_NUEVE = "/WEB-INF/reports/formato_nueve.jasper";
    //ROY - INICIO
    public static final String CONSTANTE_REPORTE_FORMATO_DOCE = "/WEB-INF/reports/formato_doce.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_DOCE_SUB_REPORT_DETALLE = "/WEB-INF/reports/formato_doce_subreporte_detalle.jasper";
    public static final String CONSTANTE_REPORTE_FORMATO_DOCE_SUB_REPORT_SUBDETALLE = "/WEB-INF/reports/formato_doce_subreporte_subdetalle.jasper";
    //ROY - FIN
    
    //flag de button: guardar avance o finalizar.
    public static final Integer CONSTANTE_FINALIZAR = new Integer(1);
    public static final Integer CONSTANTE_GUARDAR_AVANCE = new Integer(0);
    
    //ROY - INICIO
    public static final Long TIPO_PLANTILLA_DOCE = new Long(168);
    public static final Long CAMPO_DESCRIPCION = new Long(1);
    public static final Long CAMPO_NUMERO_CASOS = new Long(2);
    public static final String TIPO_REGISTRO_DETALLE_LIBRE = "3";
    public static final Long TIPO_PLANTILLA_CAMPO_DESCRIPCION = new Long(1);
    public static final Long TIPO_PLANTILLA_CAMPO_NUMEROCASOS = new Long(2);
    public static final Long TIPO_RUTAS_FORMATOS = new Long(28);
    //ROY - FIN
    
    public static final String NO_APLICA = "No Aplica";
    
    
    public static final String CONSTANTE_CODIGO_RUTA_FORMATO = "/sibad/pages/estadoCuenta/imprimirReporteFinalizar";
    
    //IDs de unidades orgánicas
    public static final String ID_UNIDAD_ORGANICA_DSHL = "11499";
    public static final String ID_UNIDAD_ORGANICA_DSR = "11500";
    
    //constantes de supervisión DSHL y DSR
    public static final Long SIGED_PVO_DOCUMENTO_OFICIO_INICIO_PAS = 218L;
    public static final Long SIGED_PVO_DOCUMENTO_ARCHIVO_INSTRUCCION_PRELIMINAR = 130L;
    public static final String PVO_SUPERVISION_CON_INCUMPLIMIENTOS = "CON INCUMPLIMIENTOS";
    public static final String PVO_SUPERVISION_SIN_INCUMPLIMIENTOS = "SIN INCUMPLIMIENTOS";
    
    //constantes de documentos
    public static final String TIPO_ARCHIVO_ACTA = "ACTA";
    
    //constantes de maestro columna del MDI
    public static final String APLICACION_INPS = "INPS";
    public static final String DOMINIO_TIPO_DOCUMENTO_SUPERVISION_SIGED_ADMINISTRADO = "TIP_DOC_SUP_SIGED_AD";
    
    public static final String NOMBRE_REPORTE_DIRECTORIO = "directorio";
    public static final String NOMBRE_HOJA_REPORTE_DIRECTORIO = "DIRECTORIO";
    public static final String COLUMNA_NOMBRE_REPORTE_DIRECTORIO = "NOMBRE";
    public static final String COLUMNA_APELLIDO_PATERNO_REPORTE_DIRECTORIO = "APELLIDO PATERNO";
    public static final String COLUMNA_APELLIDO_MATERNO_REPORTE_DIRECTORIO = "APELLIDO MATERNO";
    public static final String COLUMNA_NRO_DOCUMENTO_REPORTE_DIRECTORIO = "NRO. DOCUMENTO";
    public static final String COLUMNA_CORREO_ELECTRONICO_REPORTE_DIRECTORIO = "CORREO ELECTRONICO";
    public static final String NOMBRE_FUENTE_REPORTE_DIRECTORIO = "Arial";
    
    public static final String ESTADO_ACTIVO_LETRA="A";
    public static final String ESTADO_INACTIVO_LETRA="I";
    
}
