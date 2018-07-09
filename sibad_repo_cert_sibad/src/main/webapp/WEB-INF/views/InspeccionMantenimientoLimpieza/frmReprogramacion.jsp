<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/InspeccionMantenimientoLimpieza/frmReprogramacion.js" />' charset="utf-8"></script>
    </head>
    <body>
    	<fieldset>
    	    <input type="text"   id="txtSetFocus" class="ipt-medium" name="txtSetFocus" style="background-color: transparent;color:#EFEFEF;border-style:none;height:0px;"/>      	    
    	    <input type="hidden" id="idProgramacion" name="idProgramacion" class="ipt-medium-large" />
    	    <input type="hidden" id="estadoReprogramacion"  name="estadoReprogramacion" class="ipt-medium-large"/>
    	    <input type="hidden" id="idUnidadSupervisadaR"  name="idUnidadSupervisadaR" class="ipt-medium-large"/>
    	    <input type="hidden" id="idCompartimiento"  name="idCompartimiento" class="ipt-medium-large"/>
    	    <input type="hidden" id="tipoRevision"  name="tipoRevision" class="ipt-medium-large"/>
    	    <input type="hidden" id="tipoProgramacion"  name="tipoProgramacion" class="ipt-medium-large"/>
    	    <input type="hidden" id="numeroProgramacion"  name="numeroProgramacion" class="ipt-medium-large"/>
    	    <input type="hidden" id="fechaProgramacion"  name="fechaProgramacion" class="ipt-medium-large"/>
    	     
	        <form id="frmReprogramacion" class="tac">  
	            <div id="divMensajeValidaEstadoAccion" class="errorMensaje" tabindex='1' style="display: none" ></div>
	               
	            <div class="form">
	                <div class="filaForm">
	                    <div class="lble vat"><label for="cmbMotivo">Fecha Reprogramaci&oacute;n (*):</label></div>
	                    <div>
	                         <input type="text" class="ipt-medium-large" id="txtFechaReprogramacion"  name="txtFechaReprogramacion"  maxlength="0" style="text-transform:uppercase; width:138px;"/> 
	                    </div>
	                </div>
	                <div class="filaForm">
	                    <div class="lble vat"><label for="txtObservacion">Motivo (*):</label></div>
	                    <div>
	                         <select id="idMotivoReprogramacion" name="idMotivoReprogramacion" style="width: 250px;" validate="[O]">
	                     		<option value="">--Seleccione--</option>
	                     	</select>
	                    </div>
	                </div>
                    <div class="filaForm">
	                    <div class="lble vat"><label for="txtObservacion">Observaci&oacuten (*):</label></div>
	                    <div>
	                        <textarea name="observacion" id="txtObservacionReprogramacion" rows="4" style="width: 226px;" type="text" validate="[O]"></textarea>
	                    </div>
	                </div>          
	            </div>          
	        </form>
	   	</fieldset>	    
        <div id="botones" style="margin-top:10px;text-align:center;">
        	<input type="button" id="btnCancelarReprogramacion" title="Cancelar" class="btnSimple" value="Cancelar">
        	<input type="button" id="btnGuardarReprogramacion" title="Guargar" class="btnSimple" value="Guardar">
        </div>
    </body>
</html>