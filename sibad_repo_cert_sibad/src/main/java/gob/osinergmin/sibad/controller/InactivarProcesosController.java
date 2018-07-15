package gob.osinergmin.sibad.controller;

import gob.osinergmin.sibad.service.AlcanceAcreditacionService;
import gob.osinergmin.sibad.service.CorreoService;
import gob.osinergmin.sibad.service.DestinatarioCorreoService;
import gob.osinergmin.sibad.service.EmpresaAcreditadaService;
import gob.osinergmin.sibad.service.EquipoCertificadoService;
import gob.osinergmin.sibad.service.EquipoComponenteService;
import gob.osinergmin.sibad.service.MaestroColumnaTipoService;
import gob.osinergmin.sibad.service.OrganismoAcreditadorService;
import gob.osinergmin.sibad.service.TrazAlcanceAcredService;
import gob.osinergmin.sibad.domain.dto.MaestroColumnaTipoDTO;
import gob.osinergmin.sibad.domain.dto.OrganismoAcreditadorDTO;
import gob.osinergmin.sibad.filter.MaestroColumnaTipoFilter;
import gob.osinergmin.sibad.filter.OrganismoAcreditadorFilter;
import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.CorreoDTO;
import gob.osinergmin.sibad.domain.dto.DestinatarioCorreoDTO;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.EquipoCertificadoDTO;
import gob.osinergmin.sibad.domain.dto.EquipoComponenteDTO;
import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.filter.AlcanceAcreditacionFilter;
import gob.osinergmin.sibad.filter.DestinatarioCorreoFilter;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.EquipoCertificadoFilter;
import gob.osinergmin.sibad.filter.EquipoComponenteFilter;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.util.Constantes;
import gob.osinergmin.sibad.util.ConstantesWeb;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/VerificarProcesosVencidos")
public class InactivarProcesosController {
	
	private static final Logger LOG = LoggerFactory.getLogger(InactivarProcesosController.class);
	
	@Inject
	private EmpresaAcreditadaService empAcredService;
	@Inject
	private AlcanceAcreditacionService alcanceAcreditacionService;
	@Inject
	private TrazAlcanceAcredService trazAlcanceAcredService;
	@Inject
	private EquipoCertificadoService equipoCertificadoService;
	@Inject
	private CorreoService correoService;
	@Inject
	private DestinatarioCorreoService destinatarioCorreoService;
	@Inject
	private MaestroColumnaTipoService maestroColumnaTipoService;
	@Inject
	private OrganismoAcreditadorService orgAcreditadorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model, HttpSession session, HttpServletRequest request){
		
		String j_username = "JHIDALGOM";
        session.setAttribute("j_username", j_username);
        //----------------------------------------------------
        //----------------------------------------------------

        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_FRM_VENTANA_CRON;
	}
	
	//-------------------------- Buscar ID de Alcance Vencido -----------------------------
		@RequestMapping(value="/BuscarAlcance",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> BuscarAlcance(AlcanceAcreditacionFilter filtro){
	        LOG.info("procesando Buscar Alcance");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<AlcanceAcreditacionDTO> listado;
	            listado= alcanceAcreditacionService.listarDatosAlcance(filtro);
	            
	            Long contador = (long) listado.size();
	            
	            retorno.put("filas", listado);
	            
	            retorno.put("registros", contador);
	            
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		//------------------------ FIN Buscar ID de Alcance Vencido -----------------------------
	
	//-------------------------- MODIFICAR ESTADO X FECHA DE VENCIMIENTO --------------------------------
	
		@RequestMapping(value="/modificarEstados", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> modificarEstados(@RequestParam Long idEmpresaAcreditada, Long idAlcanceAcreditacion, String estadoA, String estadoE,String estadoAccion ,HttpSession session,HttpServletRequest request){
		
			Map<String,Object> retorno = new HashMap<String,Object>();
			
			LOG.info(" Datos antes del TRY CATCH:"+idAlcanceAcreditacion+" - " +estadoA);

			try{ 
				
				LOG.info(" Datos despues del TRY CATCH :"+idAlcanceAcreditacion+" - " +estadoA);
				
				AlcanceAcreditacionDTO alcanceAcreditacionDTO = new AlcanceAcreditacionDTO();
				EmpresaAcreditadaDTO EmpresaAcreditadaDTO = new EmpresaAcreditadaDTO();
				
				UsuarioDTO usuarioDTO = new UsuarioDTO();
	           
				usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            
	            alcanceAcreditacionDTO.setIdAlcanceAcreditacion(idAlcanceAcreditacion);
	            alcanceAcreditacionDTO.setEstado(estadoA);
	            alcanceAcreditacionDTO.setEstadoAccion(estadoAccion);
	            
	            EmpresaAcreditadaDTO.setIdEmpresaAcreditada(idEmpresaAcreditada);
	            EmpresaAcreditadaDTO.setEstado(estadoE);
	            
	            alcanceAcreditacionService.EditarEstadoAlcanceEmpresa(alcanceAcreditacionDTO, usuarioDTO);
	            empAcredService.RegistrarEmpresaAcreditada(EmpresaAcreditadaDTO, usuarioDTO);
	           
	            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
			}catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error al guardar LA MODIFICACION DEL ESTADO: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
			
		}
		
		//-------------------------- FIN MODIFICAR ESTADO X FECHA DE VENCIMIENTO -----------------------------
		
		@RequestMapping(value="/RegistrarTrazabilidad", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> RegistrarTrazabilidad(@RequestParam Long idAlcanceAcreditacion,String estado, String estadoAccion, HttpSession session,HttpServletRequest request){
		                             
			Map<String,Object> retorno = new HashMap<String,Object>();
			
			LOG.info(" Datos ANTES DE TRY:"+idAlcanceAcreditacion+" - " +estado+" - " +estadoAccion);

			try{ 
				
				LOG.info(" Datos DESPUES DE TRY:"+idAlcanceAcreditacion+" - " +estado+" - " +estadoAccion);

				TrazAlcanceAcredDTO trazAlcanceAcredDTO = new TrazAlcanceAcredDTO();			
	            
				trazAlcanceAcredDTO.setIdTrazAlcanceAcred(null);
				trazAlcanceAcredDTO.setIdAlcanceAcreditacion(idAlcanceAcreditacion);
	            trazAlcanceAcredDTO.setEstado(estado);
	            trazAlcanceAcredDTO.setEstadoAccion(estadoAccion);
	           // trazAlcanceAcredDTO.setFechaUltimoEstado(fechaUltimo);
	          
	            
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
		
		//-------------------------- BUSCAR FECHA DE PROXIMA CALIBRACION -----------------------------
		@RequestMapping(value="/BuscarFechaProxCalibracion",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> BuscarFechaProxCalibracion(EquipoCertificadoFilter filtro){
	        LOG.info("procesando BuscarFechaProxCalibracion");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<EquipoCertificadoDTO> listado;
	            listado= equipoCertificadoService.listarEquipoCertificado(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		//------------------------ FIN BUSCAR FECHA DE PROXIMA CALIBRACION -----------------------------
	
		
		@RequestMapping(value="/EditarEstadoEquipoCertificado", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> EditarEstadoEquipoCertificado(@RequestParam Long id,Long idTipoMotivo,String observacion, String estado, HttpSession session,HttpServletRequest request){
			
			Map<String,Object> retorno = new HashMap<String,Object>();
			
			try{ 
				
				EquipoCertificadoDTO equipoCertificadoDTO = new EquipoCertificadoDTO();
				UsuarioDTO usuarioDTO = new UsuarioDTO();
	           
				usuarioDTO.setLogin("USU01");
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            
	            equipoCertificadoDTO.setIdEquipoCertificado(id);
	            equipoCertificadoDTO.setIdTipoMotivo(idTipoMotivo);
	            equipoCertificadoDTO.setObservacion(observacion);
	            equipoCertificadoDTO.setEstado(Constantes.ESTADO_INACTIVO_LETRA);
	            
	            LOG.info(equipoCertificadoDTO.getIdEquipoCertificado()+" - "+ equipoCertificadoDTO.getEstado()+" - "+ 
	            		 equipoCertificadoDTO.getIdTipoMotivo() + " - " + equipoCertificadoDTO.getObservacion());
	            
	            equipoCertificadoService.updateEquipoCertificado(equipoCertificadoDTO, usuarioDTO);
	            
	            LOG.info("DESPUES DEL UPDATE: "+ equipoCertificadoDTO.getIdEquipoCertificado()+" - "+ equipoCertificadoDTO.getEstado()+" - "+ 
	            		 equipoCertificadoDTO.getIdTipoMotivo() +" - "+ equipoCertificadoDTO.getObservacion());
	            
	            //retorno.put("idEquipoCertificado", equipoCertificadoDTO.getIdEquipoCertificado());
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
	            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_UPDATE);
			}catch(Exception e){ 
	        	
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error al guardar EditarEstado: "+e.getMessage());
	            e.printStackTrace();
	            
	        }        
	        return retorno;
			
		}
		//----------------------- VALIDAR ORGANISMO ACREDITADOR QUE INGRESO --------------------------------
		
		@RequestMapping(value="datosOrganismoAcreditador",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> datosOrganismoAcreditador(OrganismoAcreditadorFilter filtro){
	        LOG.info("procesando buscar Organismo Acreditador");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<OrganismoAcreditadorDTO> listado;
	            listado= orgAcreditadorService.listarOrganismoAcreditador(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		
		//-------------------------FIN VALIDAR ORGANISMO ACREDITADOR QUE INGRESO ------------------------------------
		
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
		
		//-------------------------- ENCONTRAR EMPRESA ACREDITADA -----------------------------
		@RequestMapping(value="/traerDatosEmpresa",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> traerDatosEmpresa(EmpresaAcreditadaFilter filtro){
	        LOG.info("procesando traerDatosEmpresa");
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
	   //------------------------ FIN ENCONTRAR EMPRESA ACREDITADA -----------------------------
		
		//-------------------------- ENCONTRAR PLANTILLA DE CORREO -----------------------------
		@RequestMapping(value="/traerPlantillaMsj",method=RequestMethod.POST)
	    public @ResponseBody Map<String,Object> traerPlantillaMsj(DestinatarioCorreoFilter filtro){
	        LOG.info("procesando traerPlantillaMsj");
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        try{
	            List<CorreoDTO> listado;
	            listado= correoService.listarCorreo(filtro);
	            retorno.put("filas", listado);
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
		//------------------------ FIN ENCONTRAR PLANTILLA DE CORREO -----------------------------
			
	   //-------------------------- ENCONTRAR PLANTILLA DE CORREO + PERSONAL DESTINATARIO -----------------------------
			@RequestMapping(value="/traerPlantillaPersonal",method=RequestMethod.POST)
		    public @ResponseBody Map<String,Object> traerPlantillaPersonal(DestinatarioCorreoFilter filtro){
		        LOG.info("procesando traerPlantillaPersonal");
		        Map<String,Object> retorno=new HashMap<String,Object>();
		        try{
		            List<DestinatarioCorreoDTO> listado;
		            listado= destinatarioCorreoService.listarDestinatarioCorreo(filtro);
		            retorno.put("filas", listado);
		        }catch(Exception ex){
		            LOG.error("",ex);
		        }
		        return retorno;
		    }
	   //------------------------ FIN ENCONTRAR PLANTILLA DE CORREO + PERSONAL DESTINATARIO -----------------------------
	     
	   //--------------------------
			
		@Autowired
		private JavaMailSender mailSenderObj;
		
		@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
		public @ResponseBody Map<String,Object> sendEmailToClient(final @RequestParam String destino, final String mensaje, final String asunto, HttpServletRequest request) {
			
			Map<String,Object> retorno = new HashMap<String,Object>();
	
			mailSenderObj.send(new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					
					//mimeMessage.setHeader ("Content-Type", "text/html"); 
	
					MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
					mimeMsgHelperObj.setTo(destino);
					mimeMsgHelperObj.setFrom("asenjochristian@gmail.com");				
					mimeMsgHelperObj.setText(mensaje);
					mimeMsgHelperObj.setSubject(asunto);
				}
			});
			System.out.println("\nMensaje de Confirmacion.... Llego con exito!\n");
			
			retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
			
			return  retorno;	
		}
		
		//-----------------------------
		
}




