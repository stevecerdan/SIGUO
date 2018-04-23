<%-- 
    Document   : formatoNuevaSolicitudEstadoCuenta
    Created on : 08/11/2017, 09:35:03 AM
    Author     : Osinergmin
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Solicitud Estado de Cuenta" fecha="${fecha}" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/solicitudes/nuevo.js" />' charset="utf-8"></script>
    </jsp:attribute>

    <jsp:attribute name="bodyArea">        
        <div class="tac titua">SOLICITUD DE ESTADO DE CUENTA</div>
        <div class="container">
            <div class="pui-panel ui-widget-content">
                <form id="formSolicitudCuenta">
                    <input type="hidden" id="idNumeroSolicitud" name="numeroSolicituds" class="dn" value="${numeroSolicitud}"/>
                    <div id="divMensajeValidacion" class="errorMensaje dn" tabindex='1' style="display: none" ></div>
                    <input type="hidden" id="txtIdUnidadOperativa" name="idUnidadOperativa" />
                    <input type="hidden" id="txtIdNumeroSolicitud"  name="txtNumeroSolicitud" value="${numeroSolicitud}"/>
                    <input type="hidden" id="numeroRUC" value="${unidad.ruc}"/>                          		
                    <div id="datosSolicitudEstadoCuenta">                                                   
                        <h3><span class="ui-panel-title">DATOS DEL SOLICITANTE</span></h3>
                        <div>
                            <div class="filaForm">
                                <div class="lble">
                                    <label for="txtRuc">RUC </label>
                                </div>
                                <div class="lbly">
                                    <input  type="text" name="ruc" id="txtRuc" maxlength="11" value="${unidad.ruc}">
                                </div>                                
                            </div>                        
                            <div class="filaForm">
                                <div class="lble">
                                    <label for="razonSocial">Raz&oacute;n Social </label>
                                </div>
                                <div class="lblz">
                                    <input class="iptx" type="text" name="razonSocial" id="txtRazonSocial" maxlength="200" value="${unidad.razonSocial}">
                                </div>
                            </div>
                            
                            <div class="filaForm">
                                <div class="lble">
                                    <label for="txtLugar">Direcci&oacute;n </label>
                                </div>
                                <div class="lblz">
                                    <input class="iptx" type="text" name="direccion" id="txtDireccion" maxlength="200" value="${unidad.direccion}">
                                </div>
                            </div> 
                            <div class="filaForm">
                                <div class="lble">
                                    <label>Departamento </label>
                                </div>
                                <div class="lblm">
                                    <input type="text" name="departamento" id="txtDepartamento" value="${unidad.departamento}">
                                </div>
                                <div class="lblCenter">
                                    <label>Provincia </label>
                                </div>
                                <div class="lblm">
                                    <input type="text" name="provincia" id="txtProvincia" value="${unidad.provincia}">
                                </div>
                                <div class="lblCenter">
                                    <label>Distrito </label>
                                </div>
                                <div class="lblm">
                                    <input type="text" name="distrito" id="txtDistrito" value="${unidad.distrito}">
                                </div>
                            </div>
                            <div class="filaForm">
                                <div class="lble">
                                    <label for="txtRuc">Tel&eacute;fono </label>
                                </div>
                                <div class="lblm">
                                    <input type="hidden" id="heditarUO" value="0"/>
                                    <input type="text" name="telefono" id="txtTelefono" maxlength="15"  value="${unidad.telefono}">                                    
                                    <a id="btnCorregirSolicitante" title="Corregir"></a>
                                </div> 
                                <div class="lblCenter">
                                    <label for="txtRuc">Correo Electr&oacute;nico </label>
                                </div>
                                <div class="lblm">
                                    <input class="ipta" type="text" name="correo" id="txtCorreo" maxlength="50" value="${unidad.correo}">
                                </div>                               
                            </div>
                                                                                                                                                                    
                        </div>
                        <h3><span class="ui-panel-title">DATOS DE LA SOLICITUD</span></h3>
                        <div>                            
                            <div class="filaForm">
                                <div class="lble vat"><label for="lblDependencia">Dependencia que atenderá la solicitud </label></div>
                                <div class="slcta" >
                                    <input type="hidden" id="idDependencia" value="${unidad.idDependencia}"/>
                                    <input class="iptx" type="text" name="dependencia" id="txtDependencia" value="${unidad.dependencia}"> 
                                </div>
                            </div>
                            <div class="filaForm">
                               <c:if test="${unidad.idDependencia != 3 and unidad.idDependencia != 5}">
	                            <div class="lble">
	                                <label>C&oacute;digo Osinergmin </label>	                                
	                            </div>
	                            <div class="lblm">
	                                <input type="text" name="codigoOsinergmin" id="txtCodigoOsinergmin" value="${unidad.codigoOsinergmin}">	                               
	                            </div>	
	                           </c:if>
	                            <div  id="radiosetPeriodo" name="radiosetPeriodo" validate="[RADIO]">
                                   <div class="lbln">
                                        <input type="radio" id="radiosetPeriodo1" name="idTipoPeriodo" value="AF"><label for="radiosetPeriodo1" >A la Fecha</label>
                                        <input type="radio" id="radiosetPeriodo0" name="idTipoPeriodo" value="PE"><label for="radiosetPeriodo0" >Periodo Específico</label>
                                   </div>
                                </div>
	                                                        
                            </div>                            
                            <div class="filaForm">
                                <div class="lble"><label for="lblFechaInicio">Fecha Inicio </label></div>
                                <div class="lblm">
                                    <input id="txtFechaInicio" name="fechaInicio" type="text" maxlength="10" validate="[O][FECHA]"/>
                                </div>
                                <div class="lblCenter"><label for="lblFechaFin">Fecha Fin </label></div>
                                <div class="lblm">
                                    <input id="txtFechaFin" name="fechaFin" type="text" maxlength="10" validate="[O][FECHA]"/>
                                </div>                                
                            </div>                                                                                   
                            </div>
                    </div>
                </form> 
                <div class="botones">
                    <button id="btnGuardarSolicitud" class="btnSimple" name="btnGuardarSolicitud" title="Finalizar Solicitud">Grabar</button>
                    <button id="btnSalirSolicitud" class="btnSimple" name="btnSalirSolicitud"  title="Salir">Salir</button>
                </div>
            </div>
        </div>
        
        <div id="dialogConfirmacion" class="dialog"  title="Registro Exitoso" style="display:none;">
            <form id="frmConfirmacion" class="tac">
                <div class="form">
                    <div class="filaForm">
                        <div >El registro de la solicitud se realiz&oacute; exitosamente.</div>
                    </div>
                    <div class="filaForm">
                        <div id="divMensajeConfirmacion" ></div>
                    </div>
                </div>
            </form>
            <br>
            <div class="botones">
                <button id="btnImprimirReporte" title="Imprimir">Imprimir</button> 
                <button id="btnSalirPopup" title="Salir">Salir</button> 
            </div>
        </div>
        <div id="stack" class="ui-stack">
            <a title="Regresar" onclick="javascript:formSubmit('formSolicitudCuenta', '/sibad/pages/busquedaFormatos');"></a>
        </div> 
        
        <div id="dialog" title="Dialogo básico">
        	<span style='float:left; margin:0 7px 20px 0; ' id="notificacion"></span>
		</div>		
    </jsp:attribute>

</t:template>
