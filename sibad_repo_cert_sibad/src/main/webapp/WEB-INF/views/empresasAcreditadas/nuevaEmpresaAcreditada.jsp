<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/nuevaEmpresaAcreditada.js"/>' charset="utf-8"></script>
    </head>
    <body>
        <div id="form_registro">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                	<!-- <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> DATOS DE LA EMPRESA ACREDITADA </span>
                    </div> -->
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                        	<span class="ui-panel-title"> DATOS DE LA EMPRESA ACREDITADA </span>
                            <form id="frmEmpAcreditada" class="tac">
                                <div class="form" style="width:auto; float:left; margin: 10px 0px 0px 10px;">
                                
                                    <div class="filaForm" >
                                        <div class="lble"><label for="lblRUC">RUC:</label></div>
                                        <input id="txtRUC" class="ipt-medium" name="orden" type="text" maxlength="13" style="text-transform:uppercase; width: 250px;" onkeypress='return validaNumericos(event)'/>
                                        <input type="button" id="btnValidar" title="Validar" class="btnSimple" style="width: 100px; margin-left: 10px;" value="Validar">
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble"><label for="lblRazonSocial">Nombre del Organismo:</label></div>
                                        <input id="txtRazonSocial" class="ipt-medium-large" name="orden" type="text" maxlength="256" style="text-transform:uppercase;width: 363px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbDPTO">Ubigeo:</label></div>
                                        <div class="slcta">
                                            <select id="cmbDepartamento">
                                                <option value="">--Departamento--</option>
                                            </select>
                                        </div>
                                        
                                        <div class="slcta">
                                            <select id="cmbProvincia">
                                                <option value="">--Provincia--</option>
                                            </select>
                                        </div>
                                        
                                        <div class="slcta">
                                            <select id="cmbDistrito">
                                                <option value="">--Distrito--</option>
                                            </select>
                                        </div>
                                    </div>
                                 	
                                 	<div class="filaForm">
                                        <div class="lble"><label for="lblDireccion">Direcci&oacute;n:</label></div>
                                        <input id="txtDireccion" class="ipt-large" name="orden" type="text" maxlength="512" style="text-transform:uppercase;width: 545px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble"><label for="lblTelefono">Telefono / Fax:</label></div>
                                        <input id="txtTelefono" class="ipt-small" name="orden" type="text" maxlength="16" style="text-transform:uppercase;" onkeypress='return validaNumericos(event)'/>
                                        
                                        <div class="lble" style="width:55px; margin-left:45px;"><label for="lblEmail">Email:</label></div>
                                        <input id="txtEmail" class="ipt-medium" name="orden" type="text" maxlength="64" style="text-transform:uppercase; width:150px;"/>
                                        
                                        <div class="lble" style="width:55px; margin-left:45px;"><label for="lblWeb">Web:</label></div>
                                        <input id="txtWeb" class="ipt-medium-large" name="orden" type="text" maxlength="256" style="text-transform:uppercase; width:190px;"/>
                                    </div>
                                    
                                    <!--<div class="filaForm">
                                        <div class="lble"><label for="cmbTIPOPRUEBA">Tipo de Prueba:</label></div>
	                                    <div class="slcta">
	                                    	<select id="cmbTipoPrueba">
	                                        	<option value="">--Seleccione--</option>
	                                        </select>
	                                    </div>
                                    </div>-->
                                    
                                </div>
                            </form>  
                            
                                           
                        </fieldset>
                       	
	                    <div id="botonesDerecha" style="margin: 5px 0px 5px 0px;">
						  	<input type="button" id="btnNuevo" title="Nuevo" class="btnSimple" value="Nuevo Proceso">
						</div>
						    
						<div class="gridMargin">
			                 <div id="gridContenedorProcesos"></div> 
			                 <div id="divContextMenuAutoAyuda"></div>
			            </div>
				            
				        <div class="filaform" style="text-align:center;">
				          	<!-- <input type="button" id="btnRegresar" title="Regresar" class="btnSimple" value="Regresar"> -->
				          	<!-- <input type="button" id="btnGuardar" title="Guargar" class="btnSimple" value="Guardar"> -->
				          	<button id="btnRegresar" title="Regresar" class="btnSimple">Regresar</button>
				           	<button id="btnGuardar" title="Guardar" class="btnSimple">Guardar</button>
				        </div>  
						
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
		<div id="dialogProcesoAcreditacion" class="dialog"  title="NUEVO PROCESO" style="display:none;"></div>
    </body>
</html>