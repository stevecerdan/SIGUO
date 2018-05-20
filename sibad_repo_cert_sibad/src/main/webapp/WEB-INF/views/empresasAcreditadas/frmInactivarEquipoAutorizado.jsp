<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/frmInactivarEquipoAutorizado.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
    	<fieldset>
	        <form id="frmInactivar" class="tac">  
	            <div id="divMensajeValidaInactivar" class="errorMensaje" tabindex='1' style="display: none" ></div>
	               
	            <div class="form">
	                <div class="filaForm">
	                    <div class="lble vat"><label for="cmbMotivoI">Motivo :</label></div>
	                    <div>
	                        <select id="cmbMotivoI" name="idMotivo" style="width: 250px;" validate="[O]">
	                     		<option value="">--Seleccione--</option>
	                     	</select> 
	                    </div>
	                </div>
	                <div class="filaForm">
	                    <div class="lble vat"><label for="txtObservacionI">Observaci&oacuten :</label></div>
	                    <div>
	                        <!-- <input name="observacion" id="txtObservacion" maxlength="6" style="width: 50px;" type="text" validate="[O]"/>-->
	                        <textarea name="observacion" id="txtObservacionI" rows="4" style="text-transform:uppercase;width: 226px;" type="text" validate="[O]"></textarea>
	                    </div>
	                </div>                               
	            </div>          
	        </form>
	   	</fieldset>	    
        <div id="botones" style="margin-top:10px;text-align:center;">
        	<input type="button" id="btnCancelarInactivar" title="Cancelar" class="btnSimple" value="Cancelar">
        	<input type="button" id="btnGuardarInactivar" title="Guargar" class="btnSimple" value="Guardar">
        </div>
    </body>
</html>