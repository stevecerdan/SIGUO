package gob.osinergmin.sibad.filter;

import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.util.Constantes;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SibadFilter implements Filter{
    private static Logger logger = LoggerFactory.getLogger(SibadFilter.class);
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Entrando doFilter");
        if(pasaSinProblemas(((HttpServletRequest)request).getRequestURI())){
            logger.info("Es un file comun");
            chain.doFilter(request,response);
            return;
        }
        HttpServletRequest objRequest = (HttpServletRequest)request; 
        HttpSession session = objRequest.getSession();
        logger.info("sessionId "+session.getId());
        
        String p_k = (String)request.getParameter("kasutaja");
        String p_u = (String)request.getParameter("p_usuario");
        
        if (p_k==null && p_u==null){
            UsuarioDTO usuario = (UsuarioDTO)session.getAttribute(Constantes.SESION_USUARIO);
            if(usuario!=null && !usuario.getLogin().equals("")){
                chain.doFilter(request,response);
            }else{
                logger.info("sin sesion, redireccionando");
                String ruta = "/common/expired.jsp";//session terminada
                request.getRequestDispatcher(ruta).forward(request,response);
            }
        }else{
        	logger.info("acaaa..");
            chain.doFilter(request,response);
        }
        return;
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
		
    }

    public void destroy() {
        // TODO Auto-generated method stub
    	
    }
        
    ////////////////////////////////////////////////////
    private boolean pasaSinProblemas(String uri){
        return uri==null ||
                uri.indexOf("/common/")>=0 ||
                uri.indexOf("/css/")>=0 ||
                uri.indexOf("/images/")>=0 ||
                uri.indexOf("/xls/")>=0 ||
                //uri.indexOf("/javascript/")>=0 ||
                uri.indexOf("/stylesheets/")>=0 ||
                uri.indexOf("/js/")>=0;
    }
}
