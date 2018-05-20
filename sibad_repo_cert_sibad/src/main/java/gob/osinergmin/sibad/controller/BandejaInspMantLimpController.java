package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.service.AlcanceAcreditacionService;
import gob.osinergmin.sibad.service.AlmacenamientoService;
import gob.osinergmin.sibad.service.CompartimientoService;
import gob.osinergmin.sibad.service.DocumentoAdjuntoService;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.MaestroColumnaTipoService;
import gob.osinergmin.sibad.service.PersonaJuridicaService;
import gob.osinergmin.sibad.service.PersonaNaturalVService;
import gob.osinergmin.sibad.service.ProgramacionService;
import gob.osinergmin.sibad.service.SedeAcreditacionService;
import gob.osinergmin.sibad.service.SedePersonalAutorizadoService;
import gob.osinergmin.sibad.service.TrazAlcanceAcredService;
import gob.osinergmin.sibad.service.UbigeoDPDService;
import gob.osinergmin.sibad.service.UnidadSupervisadaService;
import gob.osinergmin.sibad.domain.dto.UbigeodpdDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.filter.UbigeoDPDFilter;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
import gob.osinergmin.sibad.domain.dto.PersonaNaturalVDTO;
import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.SedeAcreditacionDTO;
import gob.osinergmin.sibad.filter.PersonaNaturalVFilter;
import gob.osinergmin.sibad.filter.SedeAcreditacionFilter;
import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.AlmacenamientoDTO;
import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.filter.AlmacenamientoFilter;
import gob.osinergmin.sibad.filter.CompartimientoFilter;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/InspMantLimp")
public class BandejaInspMantLimpController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BandejaInspMantLimpController.class);
	
	@Inject
	private UnidadSupervisadaService unidadSupervisadaService;
	
	@Inject
	private AlmacenamientoService almacenamientoService;
	
	@Inject
	private CompartimientoService compartimientoService;
	
	@Inject
	private DocumentoAdjuntoService documentoAdjuntoService;
	
	@Inject
	private ProgramacionService programacionService;
	
	@Inject
	private EmpresaAcreditadaService empAcredService;
	
	@Inject
	private SedePersonalAutorizadoService SedepersonalautorizadoService;
	
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
        return ConstantesWeb.Navegacion.PAGE_BANDEJA_TANQUE_CL;
	}
	
	// ANDERSON 
	
	@RequestMapping(value = "/abrirFrmIndivualMasiva", method = RequestMethod.GET)
    public String abrirFrmIndivualMasiva (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_NUEVA_PROGRAMACION_INSPECCION_MANTENIMIENTO_LIMPIEZA;
    }
	
	@RequestMapping(value = "/abrirFrmDocumentoAdjunto", method = RequestMethod.GET)
    public String abrirFrmDocumentoAdjunto (HttpSession sesion, Model model) {
     
        try{        	     	
            
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_FRM_PRUEBA;
    }
	
	
	// FIN CÓDIGO
	
	@RequestMapping(value="/listarCompartimiento",method= RequestMethod.GET)
	public @ResponseBody Map<String,Object> listarCompartimiento(CompartimientoFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("Iniciando.....");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<CompartimientoDTO> listado = compartimientoService.ListarCompartimiento(filtro);
            
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<CompartimientoDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
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

	@RequestMapping(value="/listarUnidadAlmacenamiento",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarUnidadAlmacenamiento(AlmacenamientoFilter filtro){
        LOG.info("procesando...");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<AlmacenamientoDTO> listado;
            listado= almacenamientoService.ListarAlmacenamiento(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	
	@RequestMapping(value="/verificarUsuarioOsinergmin",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> verificarUsuarioOsinergmin(UnidadSupervisadaFilter filtro){
        LOG.info("procesando.....");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<UnidadSupervisadaDTO> listado;
            listado= unidadSupervisadaService.ListarUnidadSupervisada(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

	@RequestMapping(value="/verificarTanqueCL",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> verificarTanqueCL(AlmacenamientoFilter filtro){
	        LOG.info("procesando....");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<AlmacenamientoDTO> listado;
	            listado= almacenamientoService.ListarAlmacenamiento(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		
	@RequestMapping(value="/RegistrarProgramacionIndividual", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> RegistrarProgramacionIndividual(@RequestParam Long idCompartimiento, String cmbUnidadAlmacenamiento, Date fechaProgramacion,String tipoRevision, String tipoProgramacion, String numeroProgramacion,String estado, HttpSession session,HttpServletRequest request){
	
		LOG.info(" IdComp :"+ idCompartimiento+" Nprogramacion :"+ numeroProgramacion+" Unid :"+ cmbUnidadAlmacenamiento);
		
		Map<String,Object> retorno = new HashMap<String,Object>();
		

		try{ 
			
			ProgramacionDTO programacionDTO = new ProgramacionDTO(); 
			UsuarioDTO usuarioDTO = new UsuarioDTO();

			
			programacionDTO.setIdCompartimiento(idCompartimiento);
			programacionDTO.setTipoProgramacion(tipoProgramacion);
			programacionDTO.setTipoRevision(tipoRevision);
			programacionDTO.setFechaProgramacion(fechaProgramacion);
			programacionDTO.setEstado(estado);
			programacionDTO.setIdCompartimiento(idCompartimiento);
			
			usuarioDTO.setLogin("USU01");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
			
            
            programacionDTO = programacionService.RegistrarProgramacion(programacionDTO, usuarioDTO);
            
            /*EmpresaAcreditadaDTO empresaAcreditadaDTO = new EmpresaAcreditadaDTO();
           
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
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);*/
            
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
           
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
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
            	
            	 
            }


            retorno.put("idAlcanceAcreditacion",alcanceAcreditacionDTO.getIdAlcanceAcreditacion());
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

			
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
	
	
	@RequestMapping(value="/registrar", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrar(@RequestParam("uploadfile") MultipartFile file, HttpSession session,HttpServletRequest request){
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
                    
                    usuarioDTO.setLogin("USU01");
                    usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
                   
                    documentoAdjuntoDTO = documentoAdjuntoService.RegistrarDocumentoAdjunto(documentoAdjuntoDTO, usuarioDTO);
          
                    //retorno.put("idAlcanceAcreditacion",trazAlcanceAcredDTO.getIdTrazAlcanceAcred());
                    retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                //}
            }

			
		}catch(Exception e){ 
        	
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error al guardar Empresa Acreditada: "+e.getMessage());
            e.printStackTrace();
            
        }        
        return retorno;
		
	}
	
}




