<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
       <script type="text/javascript" src='<c:url value="/javascript/app/solicitudPruebasHermeticidad/frmIndiceRiesgo.js"/>' charset="utf-8"></script>
    </head>
    <style type="text/css">

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
            border: solid 2px #002c53;
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
             <input type="text"   id="txtSetFocus" class="ipt-medium" name="txtSetFocus" style="background-color: transparent;color:#EFEFEF;border-style:none;height:0px;"/>       
             <input type="hidden" id="txtIdPersonaJuridica" class="ipt-medium" name="" />
             <input type="hidden" id="txtIdDocumento" class="ipt-medium" name="" />
             <input type="hidden" id="txtflagPersona" class="ipt-medium" name="" />
             <input type="hidden" id="txtEstado" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             
             
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset  style="border: none;">
                            <span id="titulo1" class="ui-panel-title" style="color: #494242;"></span>                      
                            <div class="tac">
                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;">
                                    <div class="filaForm">
                                        <div class="lble" style="width:125px;"><label for="txtNumInforme">N&uacute;mero de Informe (*):</label></div>
										<input id="txtNumInforme" class="ipt-medium" name="txtNumInforme" type="text" maxlength="" style="width:125px;"/>
                                    </div>
									
									<div class="filaForm">
                                        <div class="lble" style="width:125px;"><label for="txtFechaInforme">Fecha de Informe (*):</label></div>
                                        <input id="txtFechaInforme" class="ipt-medium" name="txtFechaInforme" type="text" style="width:125px"/>
                                    </div>
																    
									<form id="fileUploadForm" class="tac" method="post" enctype="multipart/form-data"> 
										<div class="form" style="width:500px; float:left; margin: 0px 0px 0px 3px;">
											<div class="filaForm">
												<div class="lble" style="width:125px;margin-top: 5px;"><label for="txtFechaInforme">Adjuntar Documento (*):</label></div>
												<div class="customfile" style="border:2px solid #3B4959 ;position: absolute; width: 230px;">
													<div class="innersec">
														<input type="file" class="fileinput" id="uploadfile"name="uploadfile" style="width: 100%;height: 100%;position: absolute;left: 0px;top: 0px;opacity: 0;">
														<span class="cust-btn">Examinar</span>
														<span class="cust-field" id="nombreArchivo"></span>
													</div> 
												 </div>
												 
												 <table id="tbl_documentos" style="width:100%;padding-left: 125px;padding-top: 5px;">
												 
												 </table>
											</div>	
										</div>												 
									</form>											 
	                                								
                                </div>  
                            </div>
                        </fieldset>

						<hr align="right" noshade="noshade" size="2" width="auto" />
						
                        <fieldset style="border:none">
                            <div class="filaForm" style="padding-top: 0px;padding-left: 12px;">                               
                                <div class="lble" style="width:125px;"><label for="cmbTipoPersonal">Tipo de Persona (*):</label></div>
                                <div class="slcta">
                                    <select id="cmbTipoPersonal" style="width:150px; display:block;">
                                        <option value="0"> -- Seleccione -- </option>
                                        <option value="1"> Natural </option>
                                        <option value="2"> Juridico </option>
                                    </select>
                                </div>
                            </div>

                            <div  id="empresaJ" style="display:none;padding-top: 10px;">
                                <span class="ui-panel-title"style="color:#494242;">Empresa que elabor&oacute; el Informe </span>
                                <div style="padding-left: 10px;">
									<div class="filaForm">
										<div class="lble" style="width:60px;"><label for="txtRuc">Ruc (*): </label></div>
										<input id="txtRuc" class="ipt-medium-large" name="ruc" type="text" maxlength="11" style="text-transform:uppercase;width: 80px;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
										<div class="lble" style="width:70px;"><input type="button" id="btnValidarRUC" title="Validar" class="btnSimple" value="Validar" style="width:80px;"></div>
										  
									</div>  

									<div class="filaForm">
										<div class="lble" style="width:60px;"><label for="txtTelefono">Tel&eacute;fono: </label></div>
										<input id="txtTelefono" class="ipt-medium-large" name="ruc" type="text" maxlength="11" style="text-transform:uppercase;width: 80px;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
										
										<div class="lble" style="width:70px;"><label for="txtRazonSocial">Raz&oacute;n Social: </label></div>
										<input id="txtRazonSocial" class="ipt-medium-large" name="FiltroBusqueda" type="text" maxlength="200" style="text-transform:uppercase;width: 325px;"/>
									</div>
                                </div>
                            </div>

                            <div style="display:none; padding-top: 10px;" id="personaN">
                                <span class="ui-panel-title"style="color: #494242;"> Persona que elabor&oacute; el informe de &Iacute;ndice de riesgo </span>

                                <input type="button" id="btnNuevaPers" title="Nuevo" class="btnSimple" style="margin: 0px 0px 0px 565px;width: 125px;" value="Nueva Persona">

                                <div class="gridMargin" style="margin:10px;">
                                    <div id="gridContenedorPersonas"></div>
                                </div>
                            </div>
                        </fieldset>

						<hr align="right" noshade="noshade" size="2" width="auto" />

                        <fieldset style="border:none">
                           <div style="display:block; padding-top: 10px;" id="solicitud">
                                <span class="ui-panel-title"style="color: #494242;"> Seleccione el Tanque - Compartimiento supervisado </span>

                                <div class="gridMargin" style="margin:10px;">
                                    <div id="gridContenedorSolicitud"></div>
                                </div>
                            </div>                          
                        </fieldset>
                        
                        <div class="filaform" style="margin:10px 0px 10px 0px; text-align:center;">
                            <button id="btnRegresar" title="Regresar" class="btnSimple">Regresar</button>
                            <button id="btnGuardarRegistro" title="Guardar" class="btnSimple">Guardar</button>
                        </div>                          
                    </div>
                </div>
            </div>
        </div>
		<div id="dialogInspectorAutorizado" class="dialog"  title="PERSONAL AUTORIZADO" style="display:none;"></div>
	    <div id="dialogProxPruebaHermeticidad" class="dialog"  title="PROXIMA PRUEBA HERMETICIDAD" style="display:none;"></div>		
    </body>
</html>
 
 
  
 
  