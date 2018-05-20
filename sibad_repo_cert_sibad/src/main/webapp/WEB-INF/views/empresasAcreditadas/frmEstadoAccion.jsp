<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/frmEstadoAccion.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
    	<fieldset>
	        <form id="fileUploadForm1" class="tac" method="post" enctype="multipart/form-data">  
	            <div id="divMensajeValidaEstadoAccion" class="errorMensaje" tabindex='1' style="display: none" ></div>
	               
	            <div class="form">
	                <div class="filaForm">
	                    <div class="lble vat"><label for="cmbMotivo">Motivo :</label></div>
	                    <div>
	                        <select id="cmbMotivo" name="idMotivo" style="width: 250px;" validate="[O]">
	                     		<option value="">--Seleccione--</option>
	                     	</select> 
	                    </div>
	                </div>
	                <div class="filaForm">
	                    <div class="lble vat"><label for="txtObservacion">Observaci&oacuten :</label></div>
	                    <div>
	                        <!-- <input name="observacion" id="txtObservacion" maxlength="6" style="width: 50px;" type="text" validate="[O]"/>-->
	                        <textarea name="observacion" id="txtObservacion" rows="4" style="text-transform:uppercase;width: 226px;" type="text" validate="[O]"></textarea>
	                    </div>
	                </div>
	                <div class="filaForm">
	                    <!-- <div class="lble vat"><label id="lblCedula">Adjuntar Cedula :</label></div> -->
	                    <span class="ui-panel-title" style="font:normal 12px 'Calibri';font-weight: bold;" id="lblCedula"></span>
	                    <div>
	                    	<div class="customfile" style="border:2px solid #3B4959 ;position: absolute; width: 162px;border-radius: 4px; padding: 5px 4px;">
					             <div class="innersec">
					                  <input type="file" class="fileinput" name="uploadfileC" id="uploadfileC" style="width: 100%;height: 100%;position: absolute;left: 0px;top: 0px;opacity: 0;">
					                  <span class="cust-field" style="font:normal 12px 'Calibri';" id="nombreArchivoC">Subir Archivo, Click Aquí</span>
					             </div>
				         	</div>
                            <button type="button" class="btnSimple" title="Subir Archivo" id="btnSubirArchivo" style="margin-left:176px; width:50px;"><img src="/sibad//../images/save.png" style="margin-left:-3px;"/></button>
	                        <!-- <input id="txtCedula" class="ipt-medium" name="orden" type="text" maxlength="64" style="text-transform:uppercase; width:172px;"/> -->
	                        <!-- <input type="button" id="btnSubirArchivo" title="Subir Archivo" class="btnSimple" value="..." style="width:50px;"/> -->
	                        <input type="hidden" id="txtCedula"/>
	                    </div>
	                </div> 
	                
	                <div class="fileForm">
                    	<div class="gridMargin" style="margin-right:20px;">
			                 <div id="gridContenedorDocAE"></div>
			            </div>
                    </div>
	                                              
	            </div>          
	        </form>
	        
	        <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeValEstado"></span>
	        
	   	</fieldset>	    
        <div id="botones" style="margin-top:10px;text-align:center;">
        	<input type="button" id="btnCancelarEstado" title="Cancelar" class="btnSimple" value="Cancelar">
        	<input type="button" id="btnGuardarEstado" title="Guargar" class="btnSimple" value="Guardar">
        </div>
    </body>
</html>