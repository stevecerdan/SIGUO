<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/frmEquipoCertificado.js"/>' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
        <div id="form_registro">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="frmEquipo" class="tac">
                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;">
                                
                                    <div class="filaForm" >
                                        <div class="lble" style="width:97px;"><label for="cmbTipoEquipo">Tipo de Equipo:</label></div>
                                        <div class="slcta">
                                            <select id="cmbTipoEquipo" style="width:260px;">
                                                <option value="">--Seleccione--</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Id del Alcance -->
                                    <input type="hidden" id="idAAEquipo"/>
                                    
                                    <!-- Descripcion CmbTipoPrueba -->
                                    <input type="hidden" id="DTP"/>  
                                    
                                    <!-- Id del Equipo Registrado -->
                                    <input type="hidden" id="idEquipoRegistrado"/> 
                                    <input type="hidden" id="respuestaE"/>
                                    
                                    <!-- Id Motivo -->
                                    <input type="hidden" id="motivo"/>
                                    
                                    <!-- Observacion -->
                                    <input type="hidden" id="observa"/>  
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="lblDescripcion">Descripci&oacute;n:</label></div>
                                        <input id="txtDescripcion" class="ipt-large" name="orden" type="text" maxlength="128" style="text-transform:uppercase;width: 400px;"/>
                                    </div>
                                    
                                 	
                                 	<div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="lblMarca">Marca:</label></div>
                                        <input id="txtMarca" class="ipt-large" name="orden" type="text" maxlength="36" style="text-transform:uppercase;width: 236px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="lblModelo">Modelo:</label></div>
                                        <input id="txtModelo" class="ipt-large" name="orden" type="text" maxlength="36" style="text-transform:uppercase;width: 236px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="lblSerie">Serie:</label></div>
                                        <input id="txtSerie" class="ipt-large" name="orden" type="text" maxlength="128" style="text-transform:uppercase;width: 236px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="lblOdatos">Otros datos:</label></div>
                                        <input id="txtOdatos" class="ipt-large" name="orden" type="text" maxlength="128" style="text-transform:uppercase;width: 400px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="lblFechaC">Fecha de Calibr.:</label></div>
                                        <input id="txtFechaC" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="lblFechaPC">Fecha Prox. Calibr.:</label></div>
                                        <input id="txtFechaPC" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>
                                    </div>
                                    
                                    <span class="ui-panel-title" style="margin-left:10px;font-size:12px;color: #008cd9;" id="MensajeFECHAC">*COLOCAR UNA FECHA VALIDA Y CORRECTA</span>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="lblComponente">Componente:</label></div>
                                        <div class="slcta" style="width:320px;">
                                            <select id="cmbComponente" style="width:320px;">
                                                <option value="0">--Seleccione--</option>
                                            </select>
                                        </div>
                                        <input type="button" id="btnAgregar" title="Agregar" class="btnSimple" value="Agregar" style="width:100px;">
                                    </div>
                                    
                                    <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="MensajeValC"></span>
                                    
                                    <div class="gridMargin">
						                 <div id="gridContenedorComponentes"></div>
						            </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:50px;"><label for="cmbEstado">Estado:</label></div>
                                        <div class="slcta">
                                            <select id="cmbEstado" style="width:132px;">
                                                <option value="0">ACTIVO</option>
                                                <option value="1">INACTIVO</option>
                                            </select>
                                        </div>
                                    </div>
                                    
                                </div>
                            </form>  
                            
                            <span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="MensajeValE"></span>
                                           
                        </fieldset>
				            
				        <div class="filaform" style="margin:10px 0px 10px 0px; text-align:center;">
				          	<button id="btnRegresarEquipo" title="Regresar" class="btnSimple">Regresar</button>
				           	<button id="btnGuardarEquipo" title="Guardar" class="btnSimple">Guardar</button>
				        </div>  
						
                    </div>
                </div>
            </div>
        </div>
        <div id="dialogInactivarEquipoA" class="dialog"  title="INACTIVAR EQUIPO AUTORIZADO" style="display:none;"></div>
    </body>
</html>