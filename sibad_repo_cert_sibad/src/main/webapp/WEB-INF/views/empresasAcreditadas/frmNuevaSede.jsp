<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/frmNuevaSede.js"/>' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
        <div id="form_registro">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="frmSede" class="tac">
                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;">
                                
                                    <!-- <div class="filaForm" >
                                        <div class="lble" style="width:108px;"><label for="lblAccion">Acción:</label></div>
                                        <input type="radio" name="NSede" id="ASede" value="AS" checked> Agregar Sede
  										<input type="radio" style="margin-left:10px" name="NSede" id="SSede" value="SS"> Seleccionar Sede
                                    </div> -->
                                    
                                    <input type="hidden" id="idAASede"/>
                                    <input type="hidden" id="clonSede"/>
                                    <input type="hidden" id="idDeSede"/>
                                    <input type="hidden" id="avisoEditarS"/>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:108px;"><label for="cmbUbigeo">Ubigeo:</label></div>
                                        <div class="slcta" style="width:170px;">
                                            <select id="cmbDepaSede">
                                                <option value="0">--Departamento--</option>
                                            </select>
                                        </div>
                                        
                                        <div class="slcta" style="width:170px;">
                                            <select id="cmbProvSede">
                                                <option value="0">--Provincia--</option>
                                            </select>
                                        </div>
                                        
                                        <div class="slcta" style="width:170px;">
                                            <select id="cmbDistSede">
                                                <option value="0">--Distrito--</option>
                                            </select>
                                        </div>
                                    </div>
                                 	
                                 	<div class="filaForm">
                                        <div class="lble" style="width:108px;"><label for="lblDireccion">Direcci&oacute;n:</label></div>
                                        <input id="txtDirection" class="ipt-large" name="orden" type="text" maxlength="512" style="text-transform:uppercase;width: 485px;"/>
                                    </div>
                                    
                                    <!-- <div class="filaForm">
                                        <div class="lble" style="width:108px;"><label for="lblSede">Sede:</label></div>
                                        <div class="slcta">
                                            <select id="cmbSede" style="width:509px;">
                                                <option value="0">--Direccion--</option>
                                            </select>
                                        </div>
                                    </div> -->
                                    
                                    <!-- AVISO -->
                                    <span class="ui-panel-title" style="margin-left:100px;font-size:13px;color: #008cd9;" id="MensajeValS"></span>
                                    
                                    <div class="filaForm" style="margin:10px 0px 5px 0px">
                                    <span class="ui-panel-title"> Persona Autorizada para firmar los Cert. e Inf. de Inspecci&oacute;n </span>
                                    </div>
                                    
                                    <div class="filaForm" >
                                        <div class="lble" style="width:108px;"><label for="cmbDocumento">Documento (*):</label></div>
                                        <div class="slcta">
                                            <select id="cmbDocumento" style="width:303px;">
                                                <option value="">--Seleccione--</option>
                                            </select>
                                        </div>
                                    </div>
                                    <input id="idPersonal" type="text" maxlength="190" style="display:none"/>                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:108px;"><label for="txtNumero">Numero (*):</label></div>
                                        <input id="txtNumero" class="ipt-medium" name="orden" type="text" maxlength="16" style="text-transform:uppercase;width: 280px;" onkeypress='return validaNumericos(event)'/>
                                        <input type="button" id="btnValidarP" title="Validar" class="btnSimple" value="Validar" style="width:80px;">
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:108px;"><label for="txtNombre">Nombre (*):</label></div>
                                        <input id="txtNombre" class="ipt-large" name="orden" type="text" maxlength="64" style="text-transform:uppercase;width: 362px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:108px;"><label for="txtApellidoPaterno">Apellido Paterno (*):</label></div>
                                        <input id="txtApellidoPaterno" class="ipt-large" name="orden" type="text" maxlength="32" style="text-transform:uppercase;width: 362px;"/>
                                    </div>
                                 	
                                 	<div class="filaForm">
                                        <div class="lble" style="width:108px;"><label for="txtApellidoMaterno">Apellido Materno (*):</label></div>
                                        <input id="txtApellidoMaterno" class="ipt-large" name="orden" type="text" maxlength="32" style="text-transform:uppercase;width: 362px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:108px;"><label for="txtCargo">Cargo (*):</label></div>
                                        <div class="slcta">
                                            <select id="cmbCargo" style="width:303px;">
                                                <option value="">--Seleccione--</option>
                                            </select>
                                        </div>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:108px;"><label for="txtCIP">CIP: </label></div>
                                        <input id="txtCIP" class="ipt-medium" name="orden" type="text" maxlength="6" style="text-transform:uppercase;width: 362px;" onkeypress='return validaNumericos(event)'/>
                                    </div>
                                    
                                </div>
                            </form>  
                            
                            <span class="ui-panel-title" style="margin-left:10px; font-size:13px;color: #008cd9;" id="MensajeValP"></span>
                                           
                        </fieldset>
				            
				        <div class="filaform" style="margin:10px 0px 10px 0px; text-align:center;">
				          	<button id="btnRegresarSede" title="Regresar" class="btnSimple">Regresar</button>
				           	<button id="btnGuardarSede" title="Guardar" class="btnSimple">Guardar</button>
				        </div>  
						
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>