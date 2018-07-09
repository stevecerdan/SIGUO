<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/nuevaEmpresaAcreditada.js"/>' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
        <div id="form_registro">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                        	<span class="ui-panel-title"> DATOS DE LA EMPRESA ACREDITADA </span>
                            <form id="frmEmpAcreditada" class="tac">
                                <div class="form" style="width:auto; float:left; margin: 10px 0px 0px 10px;">
                                
                                    <div class="filaForm" >
                                        <div class="lble"><label for="lblRUC">RUC (*):</label></div>
                                        <input id="txtRUC" class="ipt-medium" name="orden" type="text" maxlength="11" style="text-transform:uppercase; width: 250px;" onkeypress='return validaNumericos(event)'/>
                                        <input type="button" id="btnValidar" title="Validar" class="btnSimple" style="width: 100px; margin-left: 10px;" value="Validar">
                                    </div>
                                    
                                    <input type="hidden" id="idPersonaJuridica" />
                                    
                                    <input type="hidden" id="idTraidoPJ" />
                                    
                                    <input type="hidden" id="txtRPTA" />
                                    
                                    <input type="hidden" id="idEmpresaAcreditada" />
                                    
                                    <input type="hidden" id="idOrgAcreditadorEA"/>
                                    
                                    <div class="filaForm">
                                        <div class="lble"><label for="lblRazonSocial">Nombre del Organismo (*):</label></div>
                                        <input id="txtRazonSocial" class="ipt-medium-large" name="orden" type="text" maxlength="256" style="text-transform:uppercase;width: 363px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbUbigeo">Ubigeo (*):</label></div>
                                        <div class="slcta">
                                            <select id="cmbDepartamento">
                                                <option value="0">--Departamento--</option>
                                            </select>
                                        </div>
                                        
                                        <div class="slcta">
                                            <select id="cmbProvincia">
                                                <option value="0">--Provincia--</option>
                                            </select>
                                        </div>
                                        
                                        <div class="slcta">
                                            <select id="cmbDistrito">
                                                <option value="0">--Distrito--</option>
                                            </select>
                                        </div>
                                    </div>
                                 	
                                 	<div class="filaForm">
                                        <div class="lble"><label for="lblDireccion">Direcci&oacute;n (*):</label></div>
                                        <input id="txtDireccion" class="ipt-large" name="orden" type="text" maxlength="512" style="text-transform:uppercase;width: 545px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble"><label for="lblTelefono">Telefono / Fax:</label></div>
                                        <input id="txtTelefono" class="ipt-small" name="orden" type="text" maxlength="16" style="text-transform:uppercase;" onkeypress='return validaNumericos(event)'/>
                                        
                                        <div class="lble" style="width:55px; margin-left:45px;"><label for="lblEmail">Email (*):</label></div>
                                        <input id="txtEmail" class="ipt-medium" name="orden" type="text" maxlength="64" style="text-transform:uppercase; width:150px;"/>
                                        
                                        <div class="lble" style="width:55px; margin-left:45px;"><label for="lblWeb">Web:</label></div>
                                        <input id="txtWeb" class="ipt-medium-large" name="orden" type="text" maxlength="256" style="text-transform:uppercase; width:190px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble"><label for="lblRegistro">Registro N°:</label></div>
                                        <input id="txtRegistro" class="ipt-small" name="orden" type="text" maxlength="64" style="text-transform:uppercase;"/>
                                    </div>
                                    
                                </div>
                                
                            </form>
                            
                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeVal"></span>
                                           
                        </fieldset>
                        
                        <span class="ui-panel-title" style="margin-left:10px;font-size:14px;color: #008cd9;" id="MensajeEA"></span>
                       	
	                    <div id="botonesDerecha" style="margin: 5px 0px 5px 0px;">
						  	<input type="button" id="btnNuevo" title="Nuevo Proceso" class="btnSimple" value="Nuevo Proceso">
						</div>
						
						<div id="seccionTipoPrueba" class="filaForm" style="margin-left:10px;">
                            <div class="lble" style="width:90px;"><label for="cmbTipoPruebaEA">Tipo de Prueba:</label></div>
                            <div class="slcta">
                            <select id="cmbTipoPruebaEA" style="width:210px;"></select>
                                <!-- <select id="cmbTipoPruebaEA">
                                    <option value="0">--Seleccion--</option>
                                </select> -->
                            </div>
                        </div>
						
						<span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeGAA">-------------------------------------------------------------------------- VALIDE UN RUC PARA MOSTRAR SUS ALCANCES DE ACREDITACION -------------------------------------------------------------------------</span>
						    
						<div class="gridMargin">
			                 <div id="gridContenedorProcesos"></div>
			            </div>
				            
				        <div class="filaform" style="text-align:center;">
				          	<button id="btnRegresar" title="Regresar" class="btnSimple">Regresar</button>
				           	<button id="btnGuardar" title="Guardar" class="btnSimple">Guardar</button>
				        </div>  
						
						<div id="dialog-message" title="Osinergmin">
							<p>
								<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;">
								</span>
								<label id="dialog-message-content" style="font: normal 14px 'Calibri';"></label>
							</p>	
			          	</div>
						
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
		<div id="dialogProcesoAcreditacion" class="dialog"  title="NUEVO PROCESO" style="display:none;"></div>
		<div id="dialogFrmEstadoAccion" class="dialog" style="display:none;"></div>
		<div id="dialogProcesoAcreditacion1" class="dialog"  title="Editar Proceso Acreditado" style="display:none;"></div>
		<!-- <div id="dialogProcesoAcreditacion2" class="dialog"  title="CONSULTAR PROCESO" style="display:none;"></div> -->
		<div id="dialogInfo2" class="dialog"  title="Informacion Alcance Acreditacion" style="display:none;"></div>
    </body>
</html>