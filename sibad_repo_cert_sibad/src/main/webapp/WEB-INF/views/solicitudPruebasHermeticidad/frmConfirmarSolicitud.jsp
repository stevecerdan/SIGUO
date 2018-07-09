<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/solicitudPruebasHermeticidad/frmConfirmarSolicitud.js"/>' charset="utf-8"></script>
   	<style>
   	
			.ui-button {
		    display: none;
  			}
   	
   	</style>
    </head>
    <body>
        <div id="form_confirmar_solicitud">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarSolicitud">
                    <div class="pui-panel-content ui-widget-content">
                        
                        <span class="ui-panel-title"> Se ha generado: </span>
                        			            
			            <div class="filaForm">
		                    <div>
		                        <textarea name="solicitudes" id="txtSolicitudes" rows="5" disabled="disabled" style="cursor:auto; text-align:center; width: 226px;" type="text" validate="[O]"></textarea>
		                    </div>
		                </div>
				            
				        <div class="filaform" style="text-align:center;">
				          	<button id="btnAceptar" title="Aceptar" class="btnSimple">Aceptar</button>
				        </div> 
						
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>