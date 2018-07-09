<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/InspeccionMantenimientoLimpieza/frmRevision.js"/>' charset="utf-8"></script>
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
             <input type="hidden" id="idProgramacionRevision" class="ipt-medium" name="idProgramacionRevision" />
             <input type="hidden" id="idCompartimientoRevision" class="ipt-medium" name="idCompartimientoRevision" />
             <input type="hidden" id="numeroProgramacionRevision" class="ipt-medium" name="numeroProgramacionRevision" />
             <input type="hidden" id="idUnidSupervisadaRevision" class="ipt-medium" name="idUnidSupervisadaRevision" />
             <input type="hidden" id="tipoPersonalAux" class="ipt-medium" name="tipoPersonalAux" value="-"/>
             <input type="hidden" id="flagPersonaAux" class="ipt-medium" name="flagPersonaAux" />
             <input type="hidden" id="estadoRegistro" class="ipt-medium" name="estadoRegistro" />
             <input type="hidden" id="idResultadoRevision" class="ipt-medium" name="idResultadoRevision" />
             <input type="hidden" id="fechaProgramacion" class="ipt-medium" name="fechaProgramacion" />
             <input type="hidden" id="txtIdPersonaJuridica" class="ipt-medium" name="txtIdPersonaJuridica" />
             <input type="hidden" id="fechaCreacion" class="ipt-medium" name="fechaCreacion" />
             
             
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset  style="border: none;">
                           <span id="titulo1" class="ui-panel-title" style="color: #494242;"></span>                      
                            <form id="frmEquipo" class="tac">
                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;">
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="txtFechaInicio">Fecha Inicio (*):</label></div>
                                        <input id="txtFechaInicio" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>

                                        <div style="margin: 0px 0px 0px 32px;">
                                            <div class="lble" style="width:85px;"><label for="txtHoraInicio">Hora Inicio (*):</label></div>
                                            <input id="txtHoraInicioH" class="ipt-medium" name="orden" type="time" style="text-align:center; width:90px;border: 2px solid #3B4959;border-radius: 4px;" max="23:59" min="00:00"/>                                            
                                        </div>
                                    </div>

                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="txtFechaFin">Fecha Fin (*):</label></div>
                                        <input id="txtFechaFin" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>

                                        <div style="margin: 0px 0px 0px 32px;">
                                            <div class="lble" style="width:85px;"><label for="txtHoraInicio">Hora Fin (*):</label></div>
                                            <input id="txtHoraFinH" class="ipt-medium" name="orden" type="time" style="text-align:center; width:90px;border: 2px solid #3B4959;border-radius: 4px;" max="23:59" min="00:00" />
                                        </div>                                       
                                    </div>
                                </div>  
                            </form>
                        </fieldset>

						<hr align="right" noshade="noshade" size="2" width="auto" />
						
                        <fieldset style="border:none">
                            <span id="titulo4" class="ui-panel-title"style="color: #494242;"></span>
                            <div class="filaForm" style="padding-top: 10px;">
                                <input id="chk_PsnalInterno" type="radio" name="Personal" value="0">
                                <label for="chk_PsnalInterno">PERSONAL INTERNO</label>&nbsp;&nbsp;

                                <input id="chk_PsnalExterno" type="radio" name="Personal" value="1">
                                <label for="chk_PsnalExterno">PERSONAL EXTERNO</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                <div class="slcta">
                                    <select id="cmbTipoPersonal" style="width:150px; display:none;">
                                        <option value="0"> -- Seleccione -- </option>
                                        <option value="1"> Natural </option>
                                        <option value="2"> Juridico </option>
                                    </select>
                                </div>
                            </div>

                            <div  id="empresaJ" style="display:none">
                                <span class="ui-panel-title"style="color: black;">Empresa que realiz&oacute; la revisi&oacute;n </span>

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

                        
                            <div style="display:none; padding-top: 10px;" id="personaN">
                                <span class="ui-panel-title"style="color: #494242;"> Persona que realiz&oacute; el mantenimiento (*)</span>

                                <input type="button" id="btnNuevaPers" title="Nuevo" class="btnSimple" style="margin: 0px 0px 0px 320px; width: 115px" value="Nueva Persona">

                                <div class="gridMargin" style="margin:10px;">
                                    <div id="gridContenedorPersonas"></div>
                                </div>
  
                                <hr align="right" noshade="noshade" size="2" width="100%" />
                            </div>
                       </fieldset>

                       <fieldset style="border:none">
                            <div>
                                <span id="titulo2" class="ui-panel-title" style="color:#494242"></span>

                                <div class="filaForm">
                                    <a class='Tipo' style='cursor: pointer;text-decoration:none;' ><u> Tipo: </u></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                    <a class='Inspeccion' style='cursor: pointer;text-decoration:none;' ><u> <span id="titulo3"></span> </u></a>
                                </div>

                                <span class="ui-panel-title" style="color:#494242"> Compartimientos y Productos </span>

                                <div class="gridMargin" style="margin:10px;">
                                    <div id="gridContenedorCompartimientos"></div>
                                </div>
                                
                            </div>
                        </fieldset>
                        
						<hr align="right" noshade="noshade" size="2" width="auto" />
                        
						<fieldset style="border:none">
                                <div class="filaForm">
                                    <span class="ui-panel-title" style="color: #494242;"> Detalle del Trabajo realizado/Observaciones/Evidencias </span>
                                    <p>
                                    <textarea id="txtDetalle" name="Detalle" rows="5" style="width: 300px;" cols="150"></textarea>                                   
                                </div>
                                <div id="formDoc">
	                                <form id="fileUploadForm" class="tac" method="post" enctype="multipart/form-data">  
	                                    <div class="filaForm" style="margin:-112px 1px 31px 250px;">

	                                        <span class="ui-panel-title" style="margin-left:-230px;color: #494242;"> Documentos (*)</span>
	                                        <p>
	                                        
	                                        <div class="customfile" style="position: absolute; width: 234px;">
	                                             <div class="innersec">
	                                                  <input type="file" class="fileinput" id="uploadfile"name="uploadfile" style="width: 100%;height: 100%;position: absolute;left: 0px;top: 0px;opacity: 0;">
	                                                  <span class="cust-btn">Examinar</span>
	                                                  <span class="cust-field" id="nombreArchivoRR"></span>
	                                             </div>
	                                         </div>                                       
	
	                                        <input type="button" id="btnAgregarDoc" title="Agregar" class="btnSimple" disabled="disabled" style="width: 80px; margin: 0px 0px 0px 240px;height: 25px;" value="Agregar">	                                                                         
	                                    </div>
	                                </form>
                                
                                <div class="gridMargin" style="margin:-27px 0px 0px 250px;">
                                    <div id="gridContenedorDocumentos"></div>
                                </div>
        
                                <div id="dialogInspectorAutorizadoRR" class="dialog"  title="PERSONAL AUTORIZADO" style="display:none;"></div>

                               </div>
                        </fieldset>

                        <div class="filaform" style="margin:10px 0px 10px 0px; text-align:center;">
                            <button id="btnRegresar" title="Regresar" class="btnSimple">Regresar</button>
                            <button id="btnGuardarRegistro" title="Guardar" class="btnSimple">Guardar</button>
                            <button id="btnFinalizarRegistro" title="Guardar" style="width: 150px" class="btnSimple">Finalizar Registro</button>
                        </div>  
                        
                    </div>
                </div>
            </div>
        </div>
        <div id="dialogInactivarEquipoA" class="dialog"  title="INACTIVAR EQUIPO AUTORIZADO" style="display:none;"></div>
    </body>
</html>
 
 
 