<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/frmPersonalSede.js"/>' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
        <div id="form_registro">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="frmPersonalSede" class="tac">
                                <div class="form" style="width:auto; float:left; margin-left: 15px;">
                                
                                    <input type="hidden" id="idAAPersonalSede"/>
                                    <input type="hidden" id="clonPersonalSede"/>
                                    <input type="hidden" id="avisoEditarPS"/>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:110px;"><label for="lblSedePS">Sede (*):</label></div>
                                        <div class="slcta">
                                            <select id="cmbSedePS" style="width:386px;">
                                                <option value="0">--Direccion--</option>
                                            </select>
                                        </div>
                                    </div>
                                    
                                    <!-- AVISO -->
                                    <span class="ui-panel-title" style="margin-left:100px;font-size:13px;color: #008cd9;" id="MensajeValSPS"></span>
                                    
                                    <div class="filaForm" style="margin:25px 0px 5px 0px">
                                        <div class="lble" style="width:110px;"><label for="cmbDocumentoPS">Documento (*):</label></div>
                                        <div class="slcta">
                                            <select id="cmbDocumentoPS" style="width:303px;">
                                                <option value="">--Seleccione--</option>
                                            </select>
                                        </div>
                                    </div>
                                    <input id="idPersonalPS" type="text" maxlength="190" style="display:none"/>                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:110px;"><label for="lblNumeroPS">Numero (*):</label></div>
                                        <input id="txtNumeroPS" class="ipt-medium" name="orden" type="text" maxlength="16" style="text-transform:uppercase;width: 280px;" onkeypress='return validaNumericos(event)'/>
                                        <input type="button" id="btnValidarPPS" title="Validar" class="btnSimple" value="Validar" style="width:80px;">
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:110px;"><label for="lblNombrePS">Nombre (*):</label></div>
                                        <input id="txtNombrePS" class="ipt-large" name="orden" type="text" maxlength="64" style="text-transform:uppercase;width: 362px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:110px;"><label for="lblApellidoPaternoPS">Apellido Paterno (*):</label></div>
                                        <input id="txtApellidoPaternoPS" class="ipt-large" name="orden" type="text" maxlength="32" style="text-transform:uppercase;width: 362px;"/>
                                    </div>
                                 	
                                 	<div class="filaForm">
                                        <div class="lble" style="width:110px;"><label for="lblApellidoMaternoPS">Apellido Materno (*):</label></div>
                                        <input id="txtApellidoMaternoPS" class="ipt-large" name="orden" type="text" maxlength="32" style="text-transform:uppercase;width: 362px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:110px;"><label for="lblCargoPS">Cargo (*):</label></div>
                                        <div class="slcta">
                                            <select id="cmbCargoPS" style="width:303px;">
                                                <option value="">--Seleccione--</option>
                                            </select>
                                        </div>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:110px;"><label for="lblCIPPS">CIP: </label></div>
                                        <input id="txtCIPPS" class="ipt-medium" name="orden" type="text" maxlength="6" style="text-transform:uppercase;width: 362px;" onkeypress='return validaNumericos(event)'/>
                                    </div>
                                    
                                </div>
                            </form>
                            
                            <span class="ui-panel-title" style="margin-left:15px; font-size:13px;color: #008cd9;" id="MensajeValPS"></span>  
                                           
                        </fieldset>
				            
				        <div class="filaform" style="margin:10px 0px 10px 0px; text-align:center;">
				          	<button id="btnRegresarPersonalSede" title="Regresar" class="btnSimple">Regresar</button>
				           	<button id="btnGuardarPersonalSede" title="Guardar" class="btnSimple">Guardar</button>
				        </div>  
						
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>