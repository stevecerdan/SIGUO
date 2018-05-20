<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/nuevoAlcanceAcreditacion.js"/>' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/latinize.js"/>' charset="utf-8"></script>
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
		    color: #333;
		    background: #e1e1e1;
		    -moz-border-radius: 3px;
		    -webkit-border-radius: 3px;
		    border-radius: 3px;
		    text-transform: uppercase;
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
        <div id="form_registro">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                        	<input type="hidden" id="estadoForm" value=""/>
                            <form id="fileUploadForm" class="tac" method="post" enctype="multipart/form-data">
                                <div class="form" style="width:auto; float:left; margin: 10px 0px 0px 10px;">
                                
                                    <div class="filaForm">
                                        <div class="lble" style="width:105px;"><label for="cmbTipoPrueba">Tipo de Prueba:</label></div>
                                        <div class="slcta">
                                            <select id="cmbTipoPrueba">
                                                <option value="0">--Seleccion--</option>
                                            </select>
                                        </div>
                                    </div>
                                    
                                    <input type="hidden" id="idOrganismoAcreditador" value="1"/>
                                    
                                    <input type="hidden" id="idEAcreditada"/>
                                    
                                    <input type="hidden" id="idPrimerAlcanceAcreditacion"/>
                                    
                                    <input type="hidden" id="idAlcanceAcreditacion"/>
                                    
                                    <input type="hidden" id="RespuestaRegistrar"/>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:105px;"><label for="lblResolucion">Resoluci&oacute;n / Cedula:</label></div>
                                        <input id="txtResolucion" class="ipt-small" name="orden" type="text" maxlength="64" style="text-transform:uppercase;"/>
                                        
                                        <!-- SUBIR ARCHIVO -->
                                        <div class="lble" style="width:100px; margin-left:10px;"><label for="lblAdjuntarArchivo">Adjuntar Archivo:</label></div>
                                        <div class="customfile" style="border:2px solid #3B4959 ;position: absolute; width: 165px;">
								             <div class="innersec">
								                  <input type="file" class="fileinput" name="uploadfile" id="uploadfile" style="width: 100%;height: 100%;position: absolute;left: 0px;top: 0px;opacity: 0;">
								                  <span class="cust-field" style="font:normal 12px 'Calibri';" id="nombreArchivo">Subir Archivo, Click Aquí</span>
								             </div>
								         </div>
                                        <button type="button" class="btnSimple" title="Guardar Archivo Adjunto" id="btnAdjuntarArchivo" style="margin-left:176px; width:50px;"><img src="/sibad//../images/save.png" style="margin-left:-3px;"/></button>
                                        
                                        <input type="hidden" id="txtAdjuntarArchivo"/>
                                        
                                        <!-- SUBIR ARCHIVO -->
                                        <div class="lble" style="width:130px; margin-left:10px;"><label for="lblAdjuntarAlcance">Alcance de Acreditaci&oacute;n:</label></div>
                                        <div class="customfile" style="border:2px solid #3B4959 ;position: absolute; width: 204px;">
								             <div class="innersec">
								                  <input type="file" class="fileinput" name="uploadfileA" id="uploadfileA" style="width: 100%;height: 100%;position: absolute;left: 0px;top: 0px;opacity: 0;">
								                  <span class="cust-field" style="font:normal 12px 'Calibri';" id="nombreArchivoA">Subir Archivo, Click Aquí</span>
								             </div>
								         </div>
                                        <!--<input id="txtAdjuntarAlcance" placeholder="Subir Archivo, Click Aquí" class="ipt-medium-large" name="orden" type="text" maxlength="10" style="width:190px;" onkeypress='return validaNumericos(event)'/>-->
                                    	<button type="button" class="btnSimple" title="Guardar Archivo Adjunto" id="btnAdjuntarAlcance" style="margin-left:215px; width:50px;"><img src="/sibad//../images/save.png" style="margin-left:-3px;"/></button>
                                    	
                                    	<input type="hidden" id="txtAdjuntarAlcance"/>
                                    	
                                    </div>
                                    
                                    <div class="fileForm">
	                                    <div class="gridMargin" style="margin-right:20px;">
							                 <div id="gridContenedorDocAA"></div>
							            </div>
							            <div class="gridMargin">
							                 <div id="gridContenedorDocAA1"></div>
							            </div>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:105px;"><label for="cmbTipoOrganismo">Tipo de Organismo:</label></div>
                                        <div class="slcta">
                                            <select id="cmbTipoOrganismo">
                                                <option value="0">--Seleccion--</option>
                                            </select>
                                        </div>
                                        
                                        <div class="lble" style="width:70px; margin-left:5px;"><label for="lblRegistro">Registro N°:</label></div>
                                        <input id="txtRegistro" class="ipt-medium" name="orden" type="text" maxlength="64" style="text-transform:uppercase; width:200px;"/>
                                        
                                        <div class="lble" style="width:93px; margin-left:50px;"><label for="lblNorma">Norma Evaluada:</label></div>
                                        <input id="txtNorma" class="ipt-medium-large" name="orden" type="text" maxlength="64" style="text-transform:uppercase; width:240px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:125px;"><label for="lblFechaUA">Fecha de &Uacute;ltima Actua.:</label></div>
                                        <input id="txtFechaUA" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:118px;"/>
                                        
                                        <div class="lble" style="width:93px; margin-left:20px;"><label for="lblFechaA">Fecha de Acred.:</label></div>
                                        <input id="txtFechaA" class="ipt-medium-large" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:123px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:125px;"><label for="lblFechaIV">Fecha de Inicio Vigencia:</label></div>
                                        <input id="txtFechaIV" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:118px;"/>
                                        
                                        <div class="lble" style="width:93px; margin-left:20px;"><label for="lblFechaV">Fecha de Venc.:</label></div>
                                        <input id="txtFechaV" class="ipt-medium-large" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:123px;"/>
                                        
                                        <span class="ui-panel-title" style="margin-left:10px;font-size:12px;color: #008cd9;" id="MensajeFECHA">*COLOCAR UNA FECHA VALIDA Y CORRECTA</span>
                                    </div>
                                    
                                </div>
                            </form>  
                            
                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeValA"></span>
                                           
                        </fieldset>
                        
	                    <div id="botonesDerecha" style="margin: 5px 0px 5px 0px;">
						  	<input type="button" style="width:150px;" id="btnNuevaSede" title="Nueva Sede" class="btnSimple" value="Nueva Sede">
						</div>
						
						<span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeAS">----------------------------------------------------------------------- REGISTRE EL ALCANCE DE ACREDITACION PARA PODER REGISTRAR UNA SEDE AUTORIZADA ----------------------------------------------------------------------</span>
						    
						<div class="gridMargin">
			                 <div id="gridContenedorSedes"></div>
			            </div>
			            
			            <div id="botonesDerecha" style="margin: 8px 0px 5px 0px;">
						  	<input type="button" style="width:150px;" id="btnNuevoInspector" title="Nuevo Inspector" class="btnSimple" value="Nuevo Inspector">
						</div>
						
						<span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeAI">-------------------------------------------------------------------- REGISTRE EL ALCANCE DE ACREDITACION PARA PODER REGISTRAR UN INSPECTOR AUTORIZADO ------------------------------------------------------------------</span>
						
						<div class="gridMargin">
			                 <div id="gridContenedorInspector"></div>
			            </div>
			            
			            <div id="botonesDerecha" style="margin: 8px 0px 5px 0px;">
						  	<input type="button" style="width:150px;" id="btnNuevoEquipo" title="Nuevo Equipo" class="btnSimple" value="Nuevo Equipo">
						</div>
						
						<span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeAE">---------------------------------------------------------------------- REGISTRE EL ALCANCE DE ACREDITACION PARA PODER REGISTRAR UN EQUIPO CERTIFICADO ---------------------------------------------------------------------</span>
						
						<div class="gridMargin">
			                 <div id="gridContenedorEquipo"></div>
			            </div>
				            
				        <div class="filaform" style="text-align:center;">
				          	<button id="btnRegresarAlcance" title="Regresar" class="btnSimple">Regresar</button>
				           	<button id="btnGuardarAlcance" title="Guardar" class="btnSimple">Guardar</button>
				        </div>  
						
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
		<div id="dialogNuevaSede" class="dialog"  title="AGREGAR SEDE" style="display:none;"></div>
		<div id="dialogInspectorAutorizado" class="dialog"  title="AGREGAR INSPECTOR AUTORIZADO" style="display:none;"></div>
		<div id="dialogEquipoCertificado" class="dialog"  title="EQUIPO AUTORIZADO" style="display:none;"></div>
    </body>
</html>