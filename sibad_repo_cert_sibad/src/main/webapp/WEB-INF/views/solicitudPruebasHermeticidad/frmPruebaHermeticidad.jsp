<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/solicitudPruebasHermeticidad/frmPruebaHermeticidad.js"/>' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
    </head>
    <body>
        <div id="form_registro">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-content ui-widget-content">
                    
                    <input type="text"   id="txtSetFocus" class="ipt-medium" name="txtSetFocus" style="background-color: transparent;color:#EFEFEF;border-style:none;height:0px;"/>
                    <p id="msjasunto" style="display:none;">${asuntito}</p>
                    <p id="msjcuerpo" style="display:none;"></p>
                    
                        <fieldset>
                        	<!-- <span class="ui-panel-title"> DATOS DE LA EMPRESA ACREDITADA </span> -->
                            <form id="frmEmpAcreditada" class="tac">
                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;">
                                
                                    <div class="filaForm">
                                        <div class="lble" style="width:70px;"><label for="lblFecha">Fecha:</label></div>
                                        <input id="txtFecha" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:118px;"/>
                                        
                                    </div>
                                    
                                    <input type="hidden" id="idCompartimiento" />
                                    
                                    <input type="hidden" id="aviso" />
                                    
                                    <input type="hidden" id="idUSupervisada" />
                                    
                                    <input type="hidden" id="idTipoPrueba" />
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:70px;"><label for="lblAsignado">Asignado A:</label></div>
                                        <div class="slcta">
                                            <select id="cmbAsignado" style="width:220px;">
                                                <option value="0">--Empresa--</option>
                                            </select>
                                        </div>
                                    </div>
                                    
                                </div>
                                
                            </form>
                                      
                        </fieldset>
                        
                        <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeValPH"></span>
                           
						<div class="gridMargin">
			                 <div id="gridContenedorSTEinspeccionar"></div>
			            </div>
			            
			            <div class="filaForm">
		                    <div>
		                        <textarea name="SOL" id="txtSOL" rows="5" style="display:none; width: 226px;" type="text" validate="[O]"></textarea>
		                    </div>
		                </div>
				            
				        <div class="filaform" style="text-align:center;">
				          	<button id="btnRegresarPH" title="Regresar" class="btnSimple">Regresar</button>
				           	<button id="btnGuardarPH" title="Guardar" class="btnSimple">Guardar</button>
				        </div> 
						
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
		<div id="dialogFrmConfirmarSolicitud" class="dialog" style="display:none;"></div>
    </body>
</html>