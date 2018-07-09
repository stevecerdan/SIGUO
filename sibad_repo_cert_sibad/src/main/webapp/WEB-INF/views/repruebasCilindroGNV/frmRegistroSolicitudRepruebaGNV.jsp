<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/repruebasCilindroGNV/frmRegistroSolicitud.js"/>' charset="utf-8"></script>
    </head>
    <body>
        <div id="form_registro">
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-content ui-widget-content">
                    
                    <input type="text"   id="txtSetFocus" class="ipt-medium" name="txtSetFocus" style="background-color: transparent;color:#EFEFEF;border-style:none;height:0px;"/>
                        <fieldset>
                        	<!-- <span class="ui-panel-title"> DATOS DE LA EMPRESA ACREDITADA </span> -->
                            <form id="frmEmpAcreditada" class="tac">
                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;">
                                
                                    <div class="filaForm">
                                        <div class="lble" style="width:70px;"><label for="lblFecha">Fecha:</label></div>
                                        <input id="txtFecha" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:118px;"/>
                                    
                                    </div>
                                    
                                    <input type="hidden" id="idUnidSupervisada" />
                                    
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
                            
                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeValPH"></span>
                                           
                        </fieldset>
                        
                        <div id="ContenidoBox">

                        </div>
                        
                        <div id="sol">
							<textarea rows="5" style="display:none" id="txtAux" cols=""></textarea>
                        </div>

						<div class="gridMargin">
			                 <div id="gridContenedorSTEinspeccionar"></div>
			            </div>
				            
				        <div class="filaform" style="text-align:center;">
				          	<button id="btnRegresarSolGNV" title="Regresar" class="btnSimple">Regresar</button>
				           	<button id="btnGuardarSolGNV" title="Guardar" class="btnSimple">Guardar</button>
				        </div> 
						
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
		<div id="dialogProcesoAcreditacion" class="dialog"  title="NUEVO PROCESO" style="display:none;"></div>
		<div id="dialogFrmConfirmarSolicitudGNV" class="dialog"  title="NUEVO PROCESO" style="display:none;"></div>
    </body>
</html>