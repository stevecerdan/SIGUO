package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.service.AlcanceAcreditacionService;
import gob.osinergmin.sibad.service.DocumentoAdjuntoService;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.EquipoCertificadoService;
import gob.osinergmin.sibad.service.EquipoComponenteService;
import gob.osinergmin.sibad.service.MaestroColumnaTipoService;
import gob.osinergmin.sibad.service.PersonaJuridicaService;
import gob.osinergmin.sibad.service.PersonaNaturalVService;
import gob.osinergmin.sibad.service.SedeAcreditacionService;
import gob.osinergmin.sibad.service.SedePersonalAutorizadoService;
import gob.osinergmin.sibad.service.TrazAlcanceAcredService;
import gob.osinergmin.sibad.service.UbigeoDPDService;
import gob.osinergmin.sibad.domain.dto.UbigeodpdDTO;
import gob.osinergmin.sibad.filter.UbigeoDPDFilter;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
import gob.osinergmin.sibad.domain.dto.PersonaNaturalVDTO;
import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;
import gob.osinergmin.sibad.filter.PersonaNaturalVFilter;
import gob.osinergmin.sibad.filter.SedeAcreditacionFilter;
import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.EquipoCertificadoDTO;
import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;
import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import gob.osinergmin.sibad.filter.DocumentoAdjuntoFilter;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.EquipoCertificadoFilter;
import gob.osinergmin.sibad.filter.EquipoComponenteFilter;
import gob.osinergmin.sibad.filter.PersonaJuridicaFilter;
import gob.osinergmin.sibad.filter.SedePersonalAutorizadoFilter;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.ConstantesWeb;

import java.net.Inet4Address;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/mantenimientoEmpresasAcreditadas")
public class BandejaEmpresasAcreditadasController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BandejaEmpresasAcreditadasController.class);
	
	@Inject
	private EmpresaAcreditadaService empAcredService;
	@Inject
	private SedePersonalAutorizadoService SedepersonalautorizadoService;
	@Inject
	private DocumentoAdjuntoService documentoadjuntoService;
	@Inject
	private EquipoComponenteService equipoComponenteService;
	@Inject
	private EquipoCertificadoService equipoCertificadoService;
	@Inject
	private PersonaJuridicaService personajuridicaService;  
	@Inject
	private UbigeoDPDService ubigeoDPDService;
	@Inject
	private MaestroColumnaTipoService maestroColumnaTipoService;
	@Inject
	private PersonaNaturalVService personanaturalService;
	@Inject
	private SedeAcreditacionService sedeacreditacionService;
	@Inject
	private AlcanceAcreditacionService alcanceAcreditacionService;
	@Inject
	private TrazAlcanceAcredService trazAlcanceAcredService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model, HttpSession session, HttpServletRequest request){
		
		String j_username = "JHIDALGOM";
        session.setAttribute("j_username", j_username);
        //----------------------------------------------------
        //----------------------------------------------------

        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_BANDEJA_EMPRESAS_ACREDITADAS;
	}
	
	@RequestMapping(value="/listarEmpresasAcreditadas",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarEmpresaAcreditada(EmpresaAcreditadaFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarEmpresaAcreditada");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<EmpresaAcreditadaDTO> listado = empAcredService.listarEmpAcred(filtro);
    
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<EmpresaAcreditadaDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
               
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/listarSedePersonalAutorizado",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarSedePersonalAutorizado(SedePersonalAutorizadoFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarSedePersonalAutorizado");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<SedePersonalAutorizadoDTO> listado = SedepersonalautorizadoService.listarSedePersonalAutorizado(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<SedePersonalAutorizadoDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
               
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/listarEquipoCertificado",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarEquipoCertificado(EquipoCertificadoFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarEquipoCertificado");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<EquipoCertificadoDTO> listado = equipoCertificadoService.listarEquipoCertificado(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<EquipoCertificadoDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
               
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/listarEquipoComponente",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarEquipoComponente(EquipoComponenteFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarEquipoComponente");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<EquipoComponenteDTO> listado = equipoComponenteService.listarEquipoComponente(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<EquipoComponenteDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
               
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	//Listar Documento Adjunto
	
	@RequestMapping(value="/listarDocumentoAdjunto",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarDocumentoAdjunto(DocumentoAdjuntoFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Inicia el listarDocumentoAdjunto");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<DocumentoAdjuntoDTO> listado = documentoadjuntoService.listarDocumentoAdjunto(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<DocumentoAdjuntoDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
               
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	//--------------------------------------------------------------------------
	
	@RequestMapping(value = "/abrirNuevaEmpresaAcreditada", method = RequestMethod.GET)
    public String abrirFrmNuevoEmpresaAcreditada (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_NUEVA_EMPRESA_ACREDITADA;
    }
	
	@RequestMapping(value = "/abrirFrmEstadoAccion", method = RequestMethod.GET)
    public String abrirFrmEstadoAccion (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_GENERAL_FRM_ESTADO_ACCION;
    }
	
	@RequestMapping(value = "/abrirNuevoAlcanceAcreditacion", method = RequestMethod.GET)
    public String abrirFrmNuevoAlcanceAcreditacion (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_NUEVO_ALCANCE_ACREDITACION;
    }
	
	@RequestMapping(value = "/abrirNuevaSede", method = RequestMethod.GET)
    public String abrirFrmNuevaSede (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_NUEVA_SEDE;
    }
	
	@RequestMapping(value = "/abrirInspectorAutorizado", method = RequestMethod.GET)
    public String abrirFrmInspectorAutorizado (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_INSPECTOR_AUTORIZADO;
    }
	
	@RequestMapping(value = "/abrirEquipoCertificado", method = RequestMethod.GET)
    public String abrirFrmEquipoCertificado (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_EQUIPO_CERTIFICADO;
    }
	
	@RequestMapping(value = "/abrirInactivarEquipoA", method = RequestMethod.GET)
    public String abrirInactivarEquipoA (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_INACTIVAR_EQUIPO_AUTORIZADO;
    }
	
	//-------------------------- VALIDAR PERSONA JURIDICA -----------------------------
	@RequestMapping(value="/cargarDatos",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarDatos(PersonaJuridicaFilter filtro){
        LOG.info("procesando cargarDatos");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<PersonaJuridicaDTO> listado;
            listado= personajuridicaService.listarPersonaJuridica(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	//------------------------ FIN VALIDAR PERSONA JURIDICA -----------------------------
	
	//-------------------------- CONSULTAR ALCANCE ACREDITACION -----------------------------
		@RequestMapping(value="/cargarDatosAlcanceCTRL",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> cargarDatosAlcanceCTRL(EmpresaAcreditadaFilter filtro){
	        LOG.info("procesando cargarDatos");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<EmpresaAcreditadaDTO> listado;
	            listado = empAcredService.listarEmpAcred(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		//------------------------ FIN CONSULTAR ALCANCE ACREDITACION -----------------------------
	
	//---------------------------- CARGAR UBIGEO -----------------------------------
	@RequestMapping(value="/cargarUbigeo",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarUbigeo(UbigeoDPDFilter filtro){
        LOG.info("procesando cargarUbigeo");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<UbigeodpdDTO> listado;
            listado= ubigeoDPDService.listarUbigeoDPD(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	//----------------------------- FIN CARGAR UBIGEO -----------------------------
	
	//-------------------------- ENCONTRAR EMPRESA ACREDITADA -----------------------------
		@RequestMapping(value="/cargarIdEmpresaAcreditada",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> cargarIdEmpresaAcreditada(EmpresaAcreditadaFilter filtro2){
	        LOG.info("procesando cargarIdEmpresaAcreditada");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<EmpresaAcreditadaDTO> listado2;
	            listado2= empAcredService.listarEmpAcred2(filtro2);
	            retorno.put("filas", listado2);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
	//------------------------ FIN ENCONTRAR EMPRESA ACREDITADA -----------------------------
	
		@RequestMapping(value="/registrarPersonaNatural", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarPersonaNatural(@RequestParam  Long idTipoDoc, String nroDoc, String ApPaterno, String ApMaterno, String nombre, Long cip,HttpSession session,HttpServletRequest request){
			
			LOG.info("procesando registrarPersonaNatural");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        try{    	
	        	UsuarioDTO usuarioDTO = new UsuarioDTO();
	            //usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
	        	usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            
	            PersonaNaturalVDTO personaNaturalDTO = new PersonaNaturalVDTO();            
	            
	            personaNaturalDTO.setIdTipoDocumento(idTipoDoc);
	            personaNaturalDTO.setNumeroDoc(nroDoc);
	            personaNaturalDTO.setNombre(nombre);
	            personaNaturalDTO.setApellidoPaterno(ApPaterno);
	            personaNaturalDTO.setApellidoMaterno(ApMaterno);
	            personaNaturalDTO.setCip(cip);
	            
	            LOG.info(personaNaturalDTO.getApellidoMaterno()+" - "+personaNaturalDTO.getApellidoPaterno()
	            		 +" - "+personaNaturalDTO.getNombre() +" - "+personaNaturalDTO.getCip());
	            LOG.info(usuarioDTO.getLogin()+" - "+usuarioDTO.getTerminal());
	            
	            personaNaturalDTO = personanaturalService.guardarPersonaNatural(personaNaturalDTO, usuarioDTO);
	         
	            LOG.info("Controller ID PN: " + personaNaturalDTO.getIdPersonaNatural() +" - " + personaNaturalDTO.getIdTipoDocumento() +" - " + personaNaturalDTO.getNumeroDoc());
	            
	            retorno.put("idPN", personaNaturalDTO.getIdPersonaNatural());
	            retorno.put("NroDoc", personaNaturalDTO.getNumeroDoc());
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
	            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
	            
	        }catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error en guardar Personal: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
	    }
		
		//-------------------------- REGISTRAR EMPRESA ACREDITADA ----------------------------
				@RequestMapping(value="/RegistrarEmpresaAcreditada", method= RequestMethod.POST)
			    public @ResponseBody Map<String,Object> RegistrarEmpresaAcreditada(@RequestParam Long idPersonaJuridica,String estado, HttpSession session,HttpServletRequest request){
				
					Map<String,Object> retorno = new HashMap<String,Object>();
					
					try{ 
						
						EmpresaAcreditadaDTO empresaAcreditadaDTO = new EmpresaAcreditadaDTO();
						UsuarioDTO usuarioDTO = new UsuarioDTO();
			           
						usuarioDTO.setLogin("USU01");
			            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
						
			            empresaAcreditadaDTO.setIdEmpresaAcreditada(null);
						empresaAcreditadaDTO.setIdPersonaJuridica(idPersonaJuridica);
						
						if(estado.equals("INACTIVO") ) {
							empresaAcreditadaDTO.setEstado(Constantes.ESTADO_INACTIVO_LETRA);
			            }
						
			            LOG.info(empresaAcreditadaDTO.getIdPersonaJuridica()+" - "+ empresaAcreditadaDTO.getEstado());
			            
			            empresaAcreditadaDTO = empAcredService.RegistrarEmpresaAcreditada(empresaAcreditadaDTO, usuarioDTO); 
			            
			            LOG.info(" IdEmp :"+empresaAcreditadaDTO.getIdEmpresaAcreditada());

			            retorno.put("idEmp",empresaAcreditadaDTO.getIdEmpresaAcreditada());
			            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
			            
					}catch(Exception e){ 
			        	
			            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
			            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
			           
			            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
			            e.printStackTrace();
			            
			        }        
			        return retorno;
					
				}
	
	//-------------------------- ENCONTRAR EMPRESA ACREDITADA - ID PRIMER ALCANCE -----------------------------
	@RequestMapping(value="/cargarPrimerAlcance",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarPrimerAlcance(AlcanceAcreditacionFilter filtro){
        LOG.info("procesando cargarPrimerAlcance");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<AlcanceAcreditacionDTO> listado;
            listado= alcanceAcreditacionService.listarDatosAlcance(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	//------------------------ FIN ENCONTRAR EMPRESA ACREDITADA - ID PRIMER ALCANCE -----------------------------
		
	//-------------------------- ENCONTRAR EMPRESA ACREDITADA - FECHA ULTIMA ACTUALIZACION -----------------------------
			@RequestMapping(value="/cargarFechaUA",method=RequestMethod.POST)
		    public @ResponseBody Map<String,Object> cargarFechaUA(EmpresaAcreditadaFilter filtro){
		        LOG.info("procesando cargarFechaUA");
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<EmpresaAcreditadaDTO> listado;
		            listado= empAcredService.listarEmpAcred(filtro);
		            retorno.put("filas", listado);
		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		    }
	//------------------------ FIN ENCONTRAR EMPRESA ACREDITADA - FECHA ULTIMA ACTUALIZACION -----------------------------
	
	//-------------------------- CARGAR COMBOS TIPOS -----------------------------
	@RequestMapping(value="/cargarComboTipo",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarComboTipo(MaestroColumnaTipoFilter filtro){
        LOG.info("procesando cargarComboTipo");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<MaestroColumnaTipoDTO> listado;
            listado= maestroColumnaTipoService.listarMaestroColumnaTipo(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	//------------------------ FIN CARGAR COMBOS TIPOS --------------------------------
	
	//-------------------------- CARGAR DIRECCION SEDE ACREDITACION -----------------------------
		@RequestMapping(value="/cargarDireccionSede",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> cargarDireccionSede(SedeAcreditacionFilter filtro){
	        LOG.info("procesando cargarComboTipo");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<SedeAcreditacionDTO> listado;
	            listado= sedeacreditacionService.listarSedeAcreditacion(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		//------------------------ FIN CARGAR DIRECCION SEDE ACREDITACION --------------------------------
	
	//-------------------------- REGISTRAR PERSONA JURIDICA ----------------------------
	@RequestMapping(value="/RegistrarPersonaJuridica", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> RegistrarPersonaJuridica(@RequestParam String ruc, String idDepartamento,String idProvincia, String idDistrito, String razonSocial,  String direccion, String telefono,  String email,String web, HttpSession session,HttpServletRequest request){
	
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos ANTES DE TRY:"+ruc+" - " +idDepartamento+" - " +idProvincia+" - " +idDistrito+" - " +razonSocial+" - " +direccion+" - " +telefono+" - " +email+" - " +web);

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY :"+ruc+" - " +idDepartamento+" - " +idProvincia+" - " +idDistrito+" - " +razonSocial+" - " +direccion+" - " +telefono+" - " +email+" - " +web);
			PersonaJuridicaDTO personaJuridicaDTO = new PersonaJuridicaDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
           
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            personaJuridicaDTO.setIdPersonaJuridica(null);
            personaJuridicaDTO.setRuc(ruc);
            personaJuridicaDTO.setIdDepartamento(idDepartamento);
            personaJuridicaDTO.setIdProvincia(idProvincia);
            personaJuridicaDTO.setIdDistrito(idDistrito);
            personaJuridicaDTO.setRazonSocial(razonSocial);
            personaJuridicaDTO.setDireccion(direccion);
            personaJuridicaDTO.setTelefono(telefono);
            personaJuridicaDTO.setEmail(email);
            personaJuridicaDTO.setWeb(web);
			
            
            personajuridicaService.RegistrarPersonaJuridica(personaJuridicaDTO, usuarioDTO);
            
			LOG.info(" IdPersonaJuridica :"+personaJuridicaDTO.getIdPersonaJuridica());

            retorno.put("idPersonaJuridica",personaJuridicaDTO.getIdPersonaJuridica());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	//----------------- VALIDAR PERSONA NATURAL -----------------------------------
	@RequestMapping(value="/validarPersonal",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> validarPersonal(PersonaNaturalVFilter filtro){
        LOG.info("procesando validarPersonal");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<PersonaNaturalVDTO> listado;
            listado= personanaturalService.listarPersonaNatural(filtro);
            
            Long contador = (long) listado.size();
            
            if(contador == 0) {
            	
            	 retorno.put("filas", "REGISTRO NO ENCONTRADO");
             
            } else {
            	
            	 retorno.put("filas", listado);
            	
            }
           
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	//------------ FIN VALIDAR PERSONAL---------------------------
	
	//----------------------- REGISTRAR ESTADO ---------------------------------
	
	@RequestMapping(value="/RegistrarEstado", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> RegistrarEstado(@RequestParam Long idEmpresaAcreditada, String estadoEmpresaAcreditada,Long idAlcanceAcreditacion, String estado,String estadoAccion, Long idDocumentoAdjunto, String idTipoMotivo,  String observacion, HttpSession session,HttpServletRequest request){
	
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos antes del TRY CATCH:"+idAlcanceAcreditacion+" - " +estado+" - " +estadoAccion+" - " +idDocumentoAdjunto+" - " +idTipoMotivo+" - " +observacion);

		try{ 
			
			LOG.info(" Datos despues del TRY CATCH :"+idAlcanceAcreditacion+" - " +estado+" - " +estadoAccion+" - " +idDocumentoAdjunto+" - " +idTipoMotivo+" - " +observacion);
			
			AlcanceAcreditacionDTO alcanceAcreditacionDTO = new AlcanceAcreditacionDTO();
			TrazAlcanceAcredDTO trazAlcanceAcredDTO = new TrazAlcanceAcredDTO();
			EmpresaAcreditadaDTO EmpresaAcreditadaDTO = new EmpresaAcreditadaDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
           
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            alcanceAcreditacionDTO.setIdAlcanceAcreditacion(idAlcanceAcreditacion);
            alcanceAcreditacionDTO.setEstado(estado);
            alcanceAcreditacionDTO.setEstadoAccion(estadoAccion);  
            
            trazAlcanceAcredDTO.setIdAlcanceAcreditacion(idAlcanceAcreditacion);
            trazAlcanceAcredDTO.setIdTipoMotivo(idTipoMotivo);
            trazAlcanceAcredDTO.setEstado(estado);
            trazAlcanceAcredDTO.setEstadoAccion(estadoAccion);
            trazAlcanceAcredDTO.setIdDocumentoAdjunto(idDocumentoAdjunto);
            trazAlcanceAcredDTO.setObservacion(observacion);

            	
            EmpresaAcreditadaDTO.setIdEmpresaAcreditada(idEmpresaAcreditada);
            
            if(estadoEmpresaAcreditada.equals("INACTIVO") ) {
				EmpresaAcreditadaDTO.setEstado(Constantes.ESTADO_INACTIVO_LETRA);
            }
            if(estadoEmpresaAcreditada.equals("ACTIVO") ) {
				EmpresaAcreditadaDTO.setEstado(Constantes.ESTADO_ACTIVO_LETRA);
            }
            
            alcanceAcreditacionService.EditarEstadoAlcanceAcreditacion(alcanceAcreditacionDTO, usuarioDTO);
            trazAlcanceAcredService.RegistrarObservacionTrazAlcanceAcred(trazAlcanceAcredDTO);
            empAcredService.RegistrarEmpresaAcreditada(EmpresaAcreditadaDTO, usuarioDTO);
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	//----------------------- FIN REGISTRAR ESTADO ---------------------------------
	
	@RequestMapping(value="/RegistrarSedeAcreditacion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> RegistrarSedeAcreditacion(@RequestParam Long idAlcanceAcreditacion, String idDepartamento,String idProvincia, String idDistrito, String direccion,  String estado, HttpSession session,HttpServletRequest request){
	
		
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos ANTES DE TRY:"+idAlcanceAcreditacion+" - " +idDepartamento+" - " +idProvincia+" - " +idDistrito+" - " +direccion+" - " +estado);

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY :"+idAlcanceAcreditacion+" - " +idDepartamento+" - " +idProvincia+" - " +idDistrito+" - " +direccion+" - " +estado);
			
			SedeAcreditacionDTO sedeAcreditacionDTO = new SedeAcreditacionDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
           
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            sedeAcreditacionDTO.setIdSedeAcreditacion(null);
            sedeAcreditacionDTO.setIdAlcanceAcreditacion(idAlcanceAcreditacion);
            sedeAcreditacionDTO.setIdDepartamento(idDepartamento);
            sedeAcreditacionDTO.setIdProvincia(idProvincia);
            sedeAcreditacionDTO.setIdDistrito(idDistrito);
            sedeAcreditacionDTO.setDireccion(direccion);
            sedeAcreditacionDTO.setEstado(estado);
            
            sedeAcreditacionDTO = sedeacreditacionService.RegistrarSedeAcreditacion(sedeAcreditacionDTO, usuarioDTO);
            
			LOG.info(" IdSA :"+sedeAcreditacionDTO.getIdSedeAcreditacion());

            retorno.put("idSedeAcreditacion",sedeAcreditacionDTO.getIdSedeAcreditacion());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	@RequestMapping(value="/RegistrarSedePersonalAutorizado", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> RegistrarSedePersonalAutorizado(@RequestParam String flagSedePersonalAutorizado, Long idSedeAcreditacion,Long idPersonaNatural, Long idCargo, Long idEspecialidad, HttpSession session,HttpServletRequest request){
	
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos ANTES DE TRY:"+flagSedePersonalAutorizado+" - " +idSedeAcreditacion+" - " +idPersonaNatural+" - " +idCargo+" - " +idEspecialidad);

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY :"+flagSedePersonalAutorizado+" - " +idSedeAcreditacion+" - " +idPersonaNatural+" - " +idCargo+" - " +idEspecialidad);
			
			SedePersonalAutorizadoDTO sedePersonalAutorizadoDTO = new SedePersonalAutorizadoDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
           
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            sedePersonalAutorizadoDTO.setIdSedePersonalAutorizado(null);
            sedePersonalAutorizadoDTO.setFlagSedePersonalAutorizado(flagSedePersonalAutorizado);
            sedePersonalAutorizadoDTO.setIdSedeAcreditacion(idSedeAcreditacion);
            sedePersonalAutorizadoDTO.setIdPersonaNatural(idPersonaNatural);
            
            if(flagSedePersonalAutorizado.equals("A")) {
            	
            	  sedePersonalAutorizadoDTO.setIdCargo(idCargo);
            	  
            } else {
            	
            	  sedePersonalAutorizadoDTO.setIdEspecialidad(idEspecialidad);
            }
          
         
            sedePersonalAutorizadoDTO = SedepersonalautorizadoService.RegistrarSedePersonalAutorizado(sedePersonalAutorizadoDTO, usuarioDTO);
            
			LOG.info(" IdSPA :"+sedePersonalAutorizadoDTO.getIdSedePersonalAutorizado());

            retorno.put("idSedePersonalAutorizado",sedePersonalAutorizadoDTO.getIdSedePersonalAutorizado());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
	}
	
	@RequestMapping(value="/RegistrarAlcanceAcreditacion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> RegistrarAlcanceAcreditacion(@RequestParam  Long idAlcanceAcreditacion, Long idEmpresaAcreditada, String estadoEmpresaAcreditada, Long idTipoPrueba, Long idOrganismoAcreditador,String resolucionCedula, Long idPrimerAlcanceAcreditacion, Long idDocumentoAdjunto,Long idDocumentoAlcanceAcreditada, Long idTipoOrganismo, String registro, String normaEvualada, Date fechaUltimaActualizacion, Date fechaAcreditacion, Date fechaInicioVigencia, Date fechaVencimiento,String estado, String estadoAccion, String estadoForm, HttpSession session,HttpServletRequest request){
	                             
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos ANTES DE TRY:"+idEmpresaAcreditada+" - " +idTipoPrueba+" - " +idOrganismoAcreditador+" - " +resolucionCedula+" - " +idPrimerAlcanceAcreditacion+" - " +idDocumentoAdjunto+" - " +idDocumentoAlcanceAcreditada+" - " +idTipoOrganismo+" - " +registro+" - " +normaEvualada+" - " +fechaUltimaActualizacion+" - " +fechaAcreditacion+" - " +fechaInicioVigencia+" - " +fechaVencimiento+" - " +estado+" - " +estadoAccion);

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY:"+idEmpresaAcreditada+" - " +idTipoPrueba+" - " +idOrganismoAcreditador+" - " +resolucionCedula+" - " +idPrimerAlcanceAcreditacion+" - " +idDocumentoAdjunto+" - " +idDocumentoAlcanceAcreditada+" - " +idTipoOrganismo+" - " +registro+" - " +normaEvualada+" - " +fechaUltimaActualizacion+" - " +fechaAcreditacion+" - " +fechaInicioVigencia+" - " +fechaVencimiento+" - " +estado+" - " +estadoAccion);


			LOG.info(" Estado empresa :"+ estadoEmpresaAcreditada);
			LOG.info(" Id empresa :"+ idEmpresaAcreditada);
			
			AlcanceAcreditacionDTO alcanceAcreditacionDTO = new AlcanceAcreditacionDTO();
			EmpresaAcreditadaDTO empresaAcreditadaDTO = new EmpresaAcreditadaDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
           
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
           if(estadoForm.equals("SAVE")) {
            	
            	LOG.info(" Insertar :");
            	
            	 alcanceAcreditacionDTO.setIdAlcanceAcreditacion(idAlcanceAcreditacion);
                 alcanceAcreditacionDTO.setIdEmpresaAcreditada(idEmpresaAcreditada);      
                 alcanceAcreditacionDTO.setIdTipoPrueba(idTipoPrueba);
                 alcanceAcreditacionDTO.setIdOrganismoAcreditador(idOrganismoAcreditador);
                 alcanceAcreditacionDTO.setResolucionCedula(resolucionCedula);
                 alcanceAcreditacionDTO.setIdPrimerAlcanceAcreditacion(idPrimerAlcanceAcreditacion);
                 alcanceAcreditacionDTO.setIdDocumentoAdjunto(idDocumentoAdjunto);
                 alcanceAcreditacionDTO.setIdDocumentoAlcanceAcreditada(idDocumentoAlcanceAcreditada);
                 alcanceAcreditacionDTO.setIdTipoOrganismo(idTipoOrganismo);
                 alcanceAcreditacionDTO.setRegistro(registro);
                 alcanceAcreditacionDTO.setNormaEvualada(normaEvualada);
                 alcanceAcreditacionDTO.setFechaAcreditacion(fechaAcreditacion);
                 alcanceAcreditacionDTO.setFechaUltimaActualizacion(fechaUltimaActualizacion);
                 alcanceAcreditacionDTO.setFechaInicioVigencia(fechaInicioVigencia);
                 alcanceAcreditacionDTO.setFechaVencimiento(fechaVencimiento);
                 alcanceAcreditacionDTO.setEstado(estado);
                 alcanceAcreditacionDTO.setEstadoAccion(estadoAccion);
               
                 empresaAcreditadaDTO.setIdEmpresaAcreditada(idEmpresaAcreditada);
                 if(estadoEmpresaAcreditada.equals("ACTIVO") ) {
     				empresaAcreditadaDTO.setEstado(Constantes.ESTADO_ACTIVO_LETRA);
                 }
                 
                 empAcredService.RegistrarEmpresaAcreditada(empresaAcreditadaDTO, usuarioDTO);
                 alcanceAcreditacionDTO = alcanceAcreditacionService.RegistrarAlcanceAcreditacion(alcanceAcreditacionDTO, usuarioDTO);
                 
      			LOG.info(" idAlcanceAcreditacion :"+alcanceAcreditacionDTO.getIdAlcanceAcreditacion());
      			
      			retorno.put("idAlcanceAcreditacion",alcanceAcreditacionDTO.getIdAlcanceAcreditacion());
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            	
            } else if(estadoForm.equals("UPDATE")) {
            	
            	LOG.info(" Editar :");
            	
            	 alcanceAcreditacionDTO.setIdAlcanceAcreditacion(idAlcanceAcreditacion);
                 alcanceAcreditacionDTO.setIdEmpresaAcreditada(idEmpresaAcreditada);      
                 alcanceAcreditacionDTO.setIdTipoPrueba(idTipoPrueba);
                 alcanceAcreditacionDTO.setIdOrganismoAcreditador(idOrganismoAcreditador);
                 alcanceAcreditacionDTO.setResolucionCedula(resolucionCedula);
                 alcanceAcreditacionDTO.setIdPrimerAlcanceAcreditacion(idPrimerAlcanceAcreditacion);
                 alcanceAcreditacionDTO.setIdDocumentoAdjunto(idDocumentoAdjunto);
                 alcanceAcreditacionDTO.setIdDocumentoAlcanceAcreditada(idDocumentoAlcanceAcreditada);
                 alcanceAcreditacionDTO.setIdTipoOrganismo(idTipoOrganismo);
                 alcanceAcreditacionDTO.setRegistro(registro);
                 alcanceAcreditacionDTO.setNormaEvualada(normaEvualada);
                 alcanceAcreditacionDTO.setFechaAcreditacion(fechaAcreditacion);
                 alcanceAcreditacionDTO.setFechaUltimaActualizacion(fechaUltimaActualizacion);
                 alcanceAcreditacionDTO.setFechaInicioVigencia(fechaInicioVigencia);
                 alcanceAcreditacionDTO.setFechaVencimiento(fechaVencimiento);
                 alcanceAcreditacionDTO.setEstado(estado);
                 alcanceAcreditacionDTO.setEstadoAccion(estadoAccion);
               
                 
                alcanceAcreditacionDTO = alcanceAcreditacionService.RegistrarAlcanceAcreditacion(alcanceAcreditacionDTO, usuarioDTO);
                 
     			LOG.info(" idAlcanceAcreditacion :"+alcanceAcreditacionDTO.getIdAlcanceAcreditacion());
     			
     			retorno.put("idAlcanceAcreditacion",alcanceAcreditacionDTO.getIdAlcanceAcreditacion());
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
             
            }
			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	@RequestMapping(value="/RegistrarTrazAlcanceAcred", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> RegistrarTrazAlcanceAcred(@RequestParam Long idAlcanceAcreditacion,String estado, String estadoAccion, HttpSession session,HttpServletRequest request){
	                             
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos ANTES DE TRY:"+idAlcanceAcreditacion+" - " +estado+" - " +estadoAccion);

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY:"+idAlcanceAcreditacion+" - " +estado+" - " +estadoAccion);

			TrazAlcanceAcredDTO trazAlcanceAcredDTO = new TrazAlcanceAcredDTO();			
            
			trazAlcanceAcredDTO.setIdTrazAlcanceAcred(null);
			trazAlcanceAcredDTO.setIdAlcanceAcreditacion(idAlcanceAcreditacion);
            trazAlcanceAcredDTO.setEstado(estado);
            trazAlcanceAcredDTO.setEstadoAccion(estadoAccion);
          
            
            trazAlcanceAcredDTO = trazAlcanceAcredService.RegistrarTrazAlcanceAcred(trazAlcanceAcredDTO);
            
			LOG.info(" idtrazAlcanceAcred :"+trazAlcanceAcredDTO.getIdTrazAlcanceAcred());

            retorno.put("idAlcanceAcreditacion",trazAlcanceAcredDTO.getIdTrazAlcanceAcred());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	@RequestMapping(value = "/eliminarPersonalAutorizado", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarPersonalAutorizado(Long idPersonalAut){
        LOG.info("procesando eliminarPersonal");
        LOG.info("ID: " + idPersonalAut);
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	SedePersonalAutorizadoDTO sedePersonaAutorizadoDTO = new SedePersonalAutorizadoDTO();
        	sedePersonaAutorizadoDTO.setIdSedePersonalAutorizado(idPersonalAut);
        	
        	sedePersonaAutorizadoDTO = SedepersonalautorizadoService.eliminarPersonal(sedePersonaAutorizadoDTO);
            
            //concursoDTO = concursoServiceNeg.eliminarConcurso(concursoDTO);
        	LOG.info("ELIMINADO!!!");
            retorno.put("concurso",sedePersonaAutorizadoDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en SedepersonalautorizadoService",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/registrarEquipoCertificado", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarEquipoCertificado(@RequestParam Long id,Long idTipoMotivo,String observacion, Long idAlcanceAcreditacion, Long idTipoEquipo, String descripcion, String marca, String modelo, String serie , String otroDatoAdicional, Date fechaC, Date fechaPC, String estado, HttpSession session,HttpServletRequest request){
//		       Date fechaProxCalibracion,
		
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		try{ 
			
			EquipoCertificadoDTO equipoCertificadoDTO = new EquipoCertificadoDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
           
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            equipoCertificadoDTO.setIdEquipoCertificado(id);
            equipoCertificadoDTO.setIdAlcanceAcreditacion(idAlcanceAcreditacion);
            equipoCertificadoDTO.setIdTipoEquipo(idTipoEquipo);
            equipoCertificadoDTO.setDescripcionEquipo(descripcion);
            equipoCertificadoDTO.setMarca(marca);
            equipoCertificadoDTO.setModelo(modelo);
            equipoCertificadoDTO.setSerie(serie);
            equipoCertificadoDTO.setOtroDato(otroDatoAdicional);
            equipoCertificadoDTO.setFechaCalibracion(fechaC);
            equipoCertificadoDTO.setFechaProximaCalibracion(fechaPC);
            equipoCertificadoDTO.setIdTipoMotivo(idTipoMotivo);
            equipoCertificadoDTO.setObservacion(observacion);
            if (estado.equals("0"))
            	equipoCertificadoDTO.setEstado(Constantes.ESTADO_ACTIVO_LETRA);
            if (estado.equals("1"))
            	equipoCertificadoDTO.setEstado(Constantes.ESTADO_INACTIVO_LETRA);
            
            LOG.info(equipoCertificadoDTO.getIdEquipoCertificado()+" - "+ equipoCertificadoDTO.getIdAlcanceAcreditacion()+" - "+ 
            		 equipoCertificadoDTO.getFechaCalibracion() +" - "+ equipoCertificadoDTO.getFechaProximaCalibracion() +" - "+
            		 equipoCertificadoDTO.getOtroDato() + " - " + equipoCertificadoDTO.getIdTipoMotivo() + " - " + equipoCertificadoDTO.getObservacion());
            
            equipoCertificadoDTO = equipoCertificadoService.registrarEquipoCertificado(equipoCertificadoDTO, usuarioDTO);
            
            LOG.info("DESPUES DEL CREATE: "+ equipoCertificadoDTO.getIdEquipoCertificado()+" - "+ equipoCertificadoDTO.getIdAlcanceAcreditacion()+" - "+ 
            		 equipoCertificadoDTO.getFechaCalibracion() +" - "+ equipoCertificadoDTO.getFechaProximaCalibracion() +" - "+
            		 equipoCertificadoDTO.getOtroDato());
            
            retorno.put("idEquipoCertificado", equipoCertificadoDTO.getIdEquipoCertificado());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	//REGISTRAR EQUIPO COMPONENTE
	@RequestMapping(value="/registrarEquipoComponente", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarEquipoComponente(@RequestParam Long idEquipoCertificado, Long idComponenteTanque, HttpSession session,HttpServletRequest request){
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		try {
			EquipoComponenteDTO equipoComponenteDTO = new EquipoComponenteDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            equipoComponenteDTO.setIdEquipoComponente(null);
            equipoComponenteDTO.setIdEquipoCertificado(idEquipoCertificado);
            equipoComponenteDTO.setIdComponenteTanque(idComponenteTanque);
            
            LOG.info("ANTES DEL CREATE: " + equipoComponenteDTO.getIdEquipoComponente() + " - " + equipoComponenteDTO.getIdEquipoCertificado() + " - " + equipoComponenteDTO.getIdComponenteTanque());
            
            equipoComponenteDTO = equipoComponenteService.registrarEquipoComponente(equipoComponenteDTO , usuarioDTO);
            //equipoComponenteDTO = 
            LOG.info("DESPUES DEL CREATE: " + equipoComponenteDTO.getIdEquipoComponente() + " - " + equipoComponenteDTO.getIdEquipoCertificado() + " - " + equipoComponenteDTO.getIdComponenteTanque());	            
            
            retorno.put("idEquipoCertificado", equipoComponenteDTO.getIdEquipoComponente());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE); 
            
		} catch (Exception e) {
			
			retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar EquipoComponente: "+e.getMessage());
            e.printStackTrace();
		}
		
		return retorno;
	}		
	
	@RequestMapping(value = "/eliminarEquipoCertificado", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarEquipoCertificado(Long idEquipoCertificado){
        LOG.info("procesando eliminarPersonal");
        LOG.info("ID: " + idEquipoCertificado);
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
//        	EquipoComponenteDTO equipoComponenteDTO = new EquipoComponenteDTO();
//        	equipoComponenteDTO.setIdEquipoCertificado(idEquipoCertificado);
        	EquipoCertificadoDTO equipoCertificadoDTO = new EquipoCertificadoDTO();
        	equipoCertificadoDTO.setIdEquipoCertificado(idEquipoCertificado);
        	
        	//equipoComponenteDTO = equipoComponenteService.eliminarComponente(equipoComponenteDTO);
        	equipoCertificadoDTO = equipoCertificadoService.eliminarEquipoCertificado(equipoCertificadoDTO);
        	            
        	LOG.info("ELIMINADO!!!");
            retorno.put("concurso",equipoCertificadoDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en SedepersonalautorizadoService",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value = "/eliminarComponente", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarComponente(Long idComponente){
        LOG.info("procesando eliminarComponente");
        LOG.info("ID: " + idComponente);
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	EquipoComponenteDTO equipoComponenteDTO = new EquipoComponenteDTO();
        	equipoComponenteDTO.setIdEquipoComponente(idComponente);
        	LOG.info("DTO: " + equipoComponenteDTO.getIdEquipoComponente());
        	
        	equipoComponenteDTO = equipoComponenteService.eliminarComponente(equipoComponenteDTO);
            
            //concursoDTO = concursoServiceNeg.eliminarConcurso(concursoDTO);
        	LOG.info("ELIMINADO!!!");
            retorno.put("equipoComponenteService",equipoComponenteDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en eliminarComponente",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/cargarEquipoCertificado",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> cargarEquipoCertificado(EquipoCertificadoFilter filtro){
        LOG.info("procesando cargarEquipoCertificado");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<EquipoCertificadoDTO> listado;
            listado= equipoCertificadoService.listarEquipoCertificado(filtro);
            
            retorno.put("tamanio",listado.size());
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/registrarDocumentoAdjunto", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarDocumentoAdjunto(@RequestParam("uploadfile") MultipartFile file, HttpSession session,HttpServletRequest request){
    //public String registrar(HttpServletRequest request,@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
                            
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos ANTES DE TRY UPLOAD:");

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY UPLOAD:");

			DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			   
            if (file != null) {
            	
            	//for (CommonsMultipartFile aFile : fileUpload){
                      
                    System.out.println("Saving file: " + file.getOriginalFilename());
                    
                    documentoAdjuntoDTO.setIdDocumentoAdjunto(null);
                    documentoAdjuntoDTO.setNombreDocumento(file.getOriginalFilename());
                    documentoAdjuntoDTO.setArchivoAdjunto(file.getBytes());
                    documentoAdjuntoDTO.setEstadoDocumento("1");
                    
                    usuarioDTO.setLogin("USU01");
                    usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
                   
                    documentoAdjuntoDTO = documentoadjuntoService.RegistrarDocumentoAdjunto(documentoAdjuntoDTO, usuarioDTO);
          
                    retorno.put("idDocumentoAdjunto",documentoAdjuntoDTO.getIdDocumentoAdjunto());
                    retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                //}
            }

		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Documento Adjunto: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	@RequestMapping(value="/registrarDocumentoAlcance", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarDocumentoAlcance(@RequestParam("uploadfileA") MultipartFile file, HttpSession session,HttpServletRequest request){
    //public String registrar(HttpServletRequest request,@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
                            
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos ANTES DE TRY UPLOAD:");

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY UPLOAD:");

			DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			   
            if (file != null) {
            	
            	//for (CommonsMultipartFile aFile : fileUpload){
                      
                    System.out.println("Saving file A: " + file.getOriginalFilename());
                    
                    documentoAdjuntoDTO.setIdDocumentoAdjunto(null);
                    documentoAdjuntoDTO.setNombreDocumento(file.getOriginalFilename());
                    documentoAdjuntoDTO.setArchivoAdjunto(file.getBytes());
                    documentoAdjuntoDTO.setEstadoDocumento("1");
                    
                    usuarioDTO.setLogin("USU01");
                    usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
                   
                    documentoAdjuntoDTO = documentoadjuntoService.RegistrarDocumentoAdjunto(documentoAdjuntoDTO, usuarioDTO);
          
                    retorno.put("idDocumentoAdjunto",documentoAdjuntoDTO.getIdDocumentoAdjunto());
                    retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                //}
            }

		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Documento Alcance: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	@RequestMapping(value="/registrarDocumentoEstado", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarDocumentoEstado(@RequestParam("uploadfileC") MultipartFile file, HttpSession session,HttpServletRequest request){
    //public String registrar(HttpServletRequest request,@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
                            
		Map<String,Object> retorno = new HashMap<String,Object>();
		
		LOG.info(" Datos ANTES DE TRY UPLOAD:");

		try{ 
			
			LOG.info(" Datos DESPUES DE TRY UPLOAD:");

			DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			   
            if (file != null) {
            	
            	//for (CommonsMultipartFile aFile : fileUpload){
                      
                    System.out.println("Saving file C: " + file.getOriginalFilename());
                    
                    documentoAdjuntoDTO.setIdDocumentoAdjunto(null);
                    documentoAdjuntoDTO.setNombreDocumento(file.getOriginalFilename());
                    documentoAdjuntoDTO.setArchivoAdjunto(file.getBytes());
                    documentoAdjuntoDTO.setEstadoDocumento("1");
                    
                    usuarioDTO.setLogin("USU01");
                    usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
                   
                    documentoAdjuntoDTO = documentoadjuntoService.RegistrarDocumentoAdjunto(documentoAdjuntoDTO, usuarioDTO);
          
                    retorno.put("idDocumentoAdjunto",documentoAdjuntoDTO.getIdDocumentoAdjunto());
                    retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                //}
            }

		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Documento Alcance: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
	//-------------------------- MODIFICAR ESTADO DOCUMENTO AL ELIMINAR --------------------------------
	
		@RequestMapping(value="/modificarEstadoEliminarDocumento", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> modificarEstadoEliminarDocumento(@RequestParam Long idDocumentoAdjunto, String estadoDocumento ,HttpSession session,HttpServletRequest request){
		
			Map<String,Object> retorno = new HashMap<String,Object>();
			
			LOG.info(" Datos antes del TRY CATCH:"+idDocumentoAdjunto+" - " +estadoDocumento);

			try{ 
				
				LOG.info(" Datos despues del TRY CATCH :"+idDocumentoAdjunto+" - " +estadoDocumento);
				
				DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
				
				UsuarioDTO usuarioDTO = new UsuarioDTO();
	           
				usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            
	            documentoAdjuntoDTO.setIdDocumentoAdjunto(idDocumentoAdjunto);
	            documentoAdjuntoDTO.setEstadoDocumento(estadoDocumento);
	            
	            documentoadjuntoService.EditarDocumentoAdjunto(documentoAdjuntoDTO, usuarioDTO);
	           
	            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
			}catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error al guardar LA MODIFICACION DEL ESTADO: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
			
		}
		
		//-------------------------- FIN MODIFICAR ESTADO DOCUMENTO AL ELIMINAR -----------------------------
	
		
		
}




