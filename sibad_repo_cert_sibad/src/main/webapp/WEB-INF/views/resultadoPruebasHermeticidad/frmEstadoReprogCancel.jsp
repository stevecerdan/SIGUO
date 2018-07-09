<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/resultadoPruebasHermeticidad/frmEstadoReprogCancel.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
    	<fieldset>
	        <form id="frmCancelacion" class="tac">  
	            <div id="divMensajeValidaEstadoReprogCancel" class="errorMensaje" tabindex='1' style="display: none" ></div>
	            <input type="text"   id="txtSetFocus" class="ipt-medium" name="txtSetFocus" style="background-color: transparent;color:#EFEFEF;border-style:none;height:0px;"/>
	               
	            <div class="form">
	                <div class="filaForm">
	                    <div class="lble vat"><label id="lblFechaRC" for="txtFechaRC">Fecha Cancelaci&oacute;n (*):</label></div>
	                    <div>
	                         <input type="text" class="ipt-medium-large" id="txtFechaRC"  name="txtFechaRC"  maxlength="0"  style="text-transform:uppercase; width:138px;"/> 
	                    </div>
	                </div>
	                <div class="filaForm">
	                    <div class="lble vat"><label for="cmbMotivoRC">Motivo (*):</label></div>
	                    <div>
	                        <select id="cmbMotivoRC" name="cmbMotivoRC" style="width: 250px;" validate="[O]">
	                     		<option value="">--Seleccione--</option>
	                     	</select>
	                    </div>
	                </div>
                    <div class="filaForm">
	                    <div class="lble vat"><label for="txtObservacionRC">Observaci&oacute;n (*):</label></div>
	                    <div>
	                        <textarea name="observacion" id="txtObservacionRC" rows="4" style="text-transform:uppercase; width:226px;" type="text" validate="[O]"></textarea>
	                    </div>
	                </div>          
	            </div>          
	        </form>
	   	</fieldset>	 
	   	
	   	<span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeValRC"></span>
	   	   
        <div id="botones" style="margin-top:10px;text-align:center;">
        	<button id="btnCancelarRC" title="Cancelar" class="btnSimple">Cancelar</button>
			<button id="btnGuardarRC" title="Guardar" class="btnSimple">Guardar</button>
        </div>
    </body>
</html>