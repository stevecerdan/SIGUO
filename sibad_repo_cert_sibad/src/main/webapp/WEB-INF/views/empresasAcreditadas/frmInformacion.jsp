<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/frmInformacion.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
    	<fieldset>
	        <form id="informe" class="tac" method="post"">  
	            <div id="divMensajeInformacion" class="errorMensaje" tabindex='1' style="display: none" ></div>
	               
	            <div class="form">
	            
	            	<input type="hidden" id="IDalcance"/>
	            	
	            	<div class="filaForm" style="text-align: center;">
	                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="EstadoT">ESTADO</span>
                    </div>
                    <div class="filaForm" style="text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;" id="EstadoInfo"></span>
                    </div>
	                <div class="filaForm" style="margin-top:20px; text-align: center;">
	                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="EstadoAccionT">ESTADO DE LA &Uacute;LTIMA ACCI&Oacute;N</span>
                    </div>
                    <div class="filaForm" style="text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;" id="EstadoAccionInfo"></span>
                    </div>
                    <div class="filaForm" style="margin-top:20px; text-align: center;">   
	                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="MotivoT">MOTIVO</span>
                    </div>
                    <div class="filaForm" style="text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;" id="MotivoInfo"></span>
                    </div>
                    <div class="filaForm" style="margin-top:20px; text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="ObservacionT">OBSERVACI&Oacute;N</span>
                    </div>
                    <div class="filaForm" style="text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;" id="ObservacionInfo"></span>
                    </div>
                    <div class="filaForm" style="margin-top:20px; text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="FechaUltimoT">FECHA DE CAMBIO DE ESTADO</span>
                    </div>
                    <div class="filaForm" style="text-align: center;"> 
	                    <span class="ui-panel-title" style="font-size:13px;" id="FechaUltimoInfo"></span>
	                </div>                             
	            </div>          
	        </form>
	        
	   	</fieldset>	  
	   	  
        <div id="botones" style="margin-top:10px;text-align:center;">
        	<input type="button" id="btnRegresarInfo" title="Regresar" class="btnSimple" value="Regresar">
        </div>
    </body>
</html>