<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/InspeccionMantenimientoLimpieza/frmResultadoPersonalAut.js"/>' charset="utf-8"></script>
        <!-- <script type="text/javascript" src='<c:url value="/javascript/app/InspeccionMantenimientoLimpieza/frmRevision.js"/>' charset="utf-8"></script> -->
    </head>
    <body>
        <div id="form_registro">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="frmInspector" class="tac">
                                <div class="form" style="width:auto; float:left; margin-left: 15px;">
                                
                                    <input type="hidden" id="idAAInspector"/>
                                    <input type="hidden" id="tipoEvento"/>
                                 
                                    <div class="filaForm" >
                                        <div class="lble" style="width:93px;"><label for="cmbDocumentoI">Documento:</label></div>
                                        <div class="slcta">
                                            <select id="cmbDocumentoI" style="width:303px;">
                                                <option value="">--Seleccione--</option>
                                            </select>
                                        </div>
                                    </div>
                                    <input id="idPersonalI" type="text" maxlength="190" style="display:none"/>                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:93px;"><label for="txtNumeroI">Numero:</label></div>
                                        <input id="txtNumeroI" class="ipt-medium" name="orden" type="text" maxlength="16" style="text-transform:uppercase;width: 280px;" onkeypress='return validaNumericos(event)'/>
                                        <input type="button" id="btnValidarPI" title="Validar" class="btnSimple" value="Validar" style="width:80px;">
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:93px;"><label for="txtNombre">Nombre:</label></div>
                                        <input id="txtNombreI" class="ipt-large" name="orden" type="text" maxlength="64" style="text-transform:uppercase;width: 362px;"/>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:93px;"><label for="txtApellidoPaterno">Apellido Paterno:</label></div>
                                        <input id="txtApellidoPaternoI" class="ipt-large" name="orden" type="text" maxlength="32" style="text-transform:uppercase;width: 362px;"/>
                                    </div>
                                 	
                                 	<div class="filaForm">
                                        <div class="lble" style="width:93px;"><label for="txtApellidoMaterno">Apellido Materno:</label></div>
                                        <input id="txtApellidoMaternoI" class="ipt-large" name="orden" type="text" maxlength="32" style="text-transform:uppercase;width: 362px;"/>
                                    </div>
                                    
                                    <div class="filaForm" id = "divTelefono" >
                                        <div class="lble" style="width:93px;"><label for="txtTELEFONO">Telefono: </label></div>
                                        <input id="txtTELEFONOI" class="ipt-medium" name="orden" type="text" maxlength="11" style="text-transform:uppercase;width: 362px;" onkeypress='return validaNumericos(event)'/>
                                    </div>

                                </div>
                            </form>  
                                           
                        </fieldset>
				            
				        <div class="filaform" style="margin:10px 0px 10px 0px; text-align:center;">
				          	<button id="btnRegresarInspector" title="Regresar" class="btnSimple">Regresar</button>
				           	<button id="btnGuardarInspector" title="Guardar" class="btnSimple">Guardar</button>
				        </div>  
						
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>