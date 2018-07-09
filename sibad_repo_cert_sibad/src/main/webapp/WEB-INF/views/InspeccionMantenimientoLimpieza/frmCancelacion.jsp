<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/InspeccionMantenimientoLimpieza/frmCancelacion.js" />' charset="utf-8"></script>
    </head>
    <body>
        <input type="text"   id="txtSetFocus" class="ipt-medium" name="txtSetFocus" style="background-color: transparent;color:#EFEFEF;border-style:none;height:0px;"/>   
        <input type="hidden" id="idProgramacionC" name="idProgramacionC" class="ipt-medium-large" />
    	<input type="hidden" id="estadoCancelacion"  name="estadoCancelacion" class="ipt-medium-large"/>
    	<input type="hidden" id="idUnidadSupervisadaC"  name="idUnidadSupervisadaC" class="ipt-medium-large"/>
    	<input type="hidden" id="fechaProgramacion"  name="fechaProgramacion" class="ipt-medium-large"/>
    	
    	<fieldset>
	        <form id="frmCancelacion" class="tac">  
	            <div id="divMensajeValidaEstadoAccion" class="errorMensaje" tabindex='1' style="display: none" ></div>
	               
	            <div class="form">
	                <div class="filaForm">
	                    <div class="lble vat"><label for="cmbMotivo">Fecha Cancelaci&oacute;n (*):</label></div>
	                    <div>
	                         <input type="text" class="ipt-medium-large" id="txtFechaCancelacion"  name="txtFechaCancelacion"  maxlength="0"  style="text-transform:uppercase; width:138px;"/> 
	                    </div>
	                </div>
	                <div class="filaForm">
	                    <div class="lble vat"><label for="txtObservacion">Motivo (*):</label></div>
	                    <div>
	                         <select id="idMotivoCancelacion" name="idMotivoCancelacion" style="width: 250px;" validate="[O]">
	                     		<option value="">--Seleccione--</option>
	                     	</select>
	                    </div>
	                </div>
                    <div class="filaForm">
	                    <div class="lble vat"><label for="txtObservacion">Observaci&oacuten (*):</label></div>
	                    <div>
	                        <textarea name="observacion" id="txtObservacionCancelacion" rows="4" style="width: 226px;" type="text" validate="[O]"></textarea>
	                    </div>
	                </div>          
	            </div>          
	        </form>
	   	</fieldset>	    
        <div id="botones" style="margin-top:10px;text-align:center;">
        	<input type="button" id="btnCancelarProgramacion" title="Cancelar" class="btnSimple" value="Cancelar">
        	<input type="button" id="btnGuardarProgramacionCancelada" title="Guargar" class="btnSimple" value="Guardar">
        </div>
    </body>
</html>