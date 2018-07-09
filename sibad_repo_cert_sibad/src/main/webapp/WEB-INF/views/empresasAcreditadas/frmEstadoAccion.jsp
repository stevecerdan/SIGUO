<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/frmEstadoAccion.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
    </head>
    <style>
       .customfile {
       
		    position: relative;
		    overflow: hidden;
		    width: 230px;
		    height: 19px;
		    border: solid 0px red;
		    background: #fff;
		    -moz-border-radius: 5px;
		    -webkit-border-radius: 5px;
		    border-radius: 5px;
		    border: solid 1px #c2c2c2;
		    padding: 2px;
		    -webkit-box-shadow: inset 1px 1px 2px #e4e4e4;
		    box-shadow: inset 1px 1px 2px #e4e4e4;
		}
		
		.customfile span.cust-btn {
		    float: right;
		    line-height: 20px;
		    padding: 1px 10px;
		    height: 18px;
		    text-align: center;
		    font-weight: bold;
		    cursor: pointer;
		    color: #fff;
		    background: #e1e1e1;
		    -moz-border-radius: 3px;
		    -webkit-border-radius: 3px;
		    border-radius: 3px;
		    text-transform: uppercase;
		    background-color: #002c53;
		    /*margin-top: 1px;*/
		}
		
		.customfile span.cust-field {
		    line-height: 20px;
		    padding: 3px 4px;
		    width: 225px;
		    height: 20px;
		    cursor: pointer;
		    color: #212121;
		    display: block;
		    font-weight: normal;
		    color: #333;
		}
		
		.customfile .fileinput {
		    position: absolute;
		    left: 0px;
		    top: 0px;
		    cursor: pointer;
		    z-index: 99;
		}
		

    </style>
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
	                <div class="filaForm" style="margin-top:10px">
	                	<span class="ui-panel-title" style="margin-right:8px; font:normal 11.5px 'Calibri';font-weight: bold;" id="lblCedula"></span>
	                    <div>
	                    	<div class="customfile" style="border:2px solid #3B4959 ;position: absolute; width:220px; margin-top:-19px;">
					             <div class="innersec">
					                  <input type="file" class="fileinput" name="uploadfileC" id="uploadfileC" style="width: 100%;height: 100%;position: absolute;left: 0px;top: 0px;opacity: 0;">
					                  <span class="cust-btn" style="margin-right:12px;">Adjuntar</span>
					                  <span class="cust-field" style="font:normal 12px 'Calibri';" id="nombreArchivoC">Subir Archivo, Click Aquí</span>
					             </div>
				         	</div>
                            <!-- <button type="button" class="btnSimple" title="Subir Archivo" id="btnSubirArchivo" style="margin-left:176px; width:50px;"><img src="/sibad//../images/save.png" style="margin-left:-3px;"/></button> -->
	                        
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