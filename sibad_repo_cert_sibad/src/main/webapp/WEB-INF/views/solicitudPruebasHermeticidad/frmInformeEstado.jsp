<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/solicitudPruebasHermeticidad/frmInformeEstado.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
    	<fieldset>
	        <form id="informe" class="tac" method="post"">  
	            <div id="divMensajeInformeEstado" class="errorMensaje" tabindex='1' style="display: none" ></div>
	               
	            <div class="form">
	            
	            	<input type="hidden" id="IDsolicitud"/>
	            	
	            	<div class="filaForm" style="text-align: center;">
	                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="EstadoTS">ESTADO</span>
                    </div>
                    <div class="filaForm" style="text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;" id="EstadoInfoS"></span>
                    </div>
                    <div class="filaForm" style="margin-top:20px; text-align: center;">   
	                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="MotivoTS">MOTIVO</span>
                    </div>
                    <div class="filaForm" style="text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;" id="MotivoInfoS"></span>
                    </div>
                    <div class="filaForm" style="margin-top:20px; text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="ObservacionTS">OBSERVACI&Oacute;N</span>
                    </div>
                    <div class="filaForm" style="text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;" id="ObservacionInfoS"></span>
                    </div>
                    <div class="filaForm" style="margin-top:20px; text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="FechaUltimoTS">FECHA DE CAMBIO DE ESTADO</span>
                    </div>
                    <div class="filaForm" style="text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;" id="FechaUltimoInfoS"></span>
	                </div>                             
	            </div>          
	        </form>
	        
	   	</fieldset>	  
	   	  
        <div id="botones" style="margin-top:10px;text-align:center;">
        	<input type="button" id="btnRegresarInfoS" title="Regresar" class="btnSimple" value="Regresar">
        </div>
    </body>
</html>