<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Bienvenido " fecha="${fecha}" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/supervisiones/detalleSupervision.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/common.js" />' ></script>
        <style>
			.ui-jqgrid tr.jqgrow td { white-space: normal !important; height:auto; vertical-align:text-top; padding-top:2px; }
			.ui-jqgrid .ui-jqgrid-htable th div { height:auto; overflow:hidden; padding-right:4px; padding-top:2px; position:relative; vertical-align:text-top; white-space:normal !important; }
		</style>
    </jsp:attribute>
    
    <jsp:attribute name="bodyArea">
    	<div class="container">
            <div class="pui-panel ui-widget-content">
                <div class="pui-panel-titlebar ui-corner-all">
                    <span class="ui-panel-title">DETALLE DE LA SUPERVISI&Oacute;N</span>
                </div>
             </div>
             <div class="pui-panel-content ui-widget-content">
             	<form id="formDetalleSupervision" class="tac">
                    <div id="divMensajeValidacionFinSiniestro" class="errorMensaje" tabindex='1' style="display: none" ></div>
	             	<input type="hidden" id="resultado" value="${resultado}" />
	             	<input type="hidden" id="mensaje" value="${mensaje}" />
	             	<input type="hidden" id="esSupervisionDshl" value="${esSupervisionDshl}" />
	             	<input type="hidden" id="mostrarGrilla" value="${mostrarGrilla}" />
	             	<input type="hidden" id="mensajeNoResultado" value="${mensajeNoResultado}" />
	             	<input type="hidden" id="idSupervision" value="${idSupervision}" />
	             	<input type="hidden" id="numeroExpediente" value="${numeroExpediente}" />
	             	<input type="hidden" id="codigoResultado" value="${codigoResultado}" />
	             	<input type="hidden" id="nombreResultado" value="${nombreResultado}" />
	             	<div class="form">
	             		<div><br></div>
		             	<div style="text-align:center;">
		             	    <div id="datosCabeceraDshl" class="filaForm" style="display:none;">
			        			<div class="lbll tal vat">
			        				<label>C&oacute;digo Osinergmin </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				<c:out value="${codigoOsinergmin}" />
			        			</div>
			        			<div class="lbll tal vat">
			        				<label>Fecha de Supervisio&oacute;n </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				Del&nbsp;<c:out value="${fechaInicioSupervision}" />&nbsp;al&nbsp;<c:out value="${fechaFinSupervision}" />
			        			</div>
					        </div>
		             	    <div class="filaForm">
			        			<div class="lbll tal vat">
			        				<label>Nro. Expediente </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				<c:out value="${numeroExpediente}" />
			        			</div>
			        			<div class="lbll tal vat">
			        				<label>Nro. Orden de Servicio </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				<c:out value="${numeroOrdenServicio}" />
			        			</div>
							</div>
							<div class="filaForm">
			        			<div class="lbll tal vat">
			        				<label>Registro de Hidrocarburos </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				<c:out value="${registroHidrocarburos}" />
			        			</div>
			        			<div class="lbll tal vat">
			        				<label>Actividad </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				<c:out value="${codigoActividad}" />&nbsp;-&nbsp;<c:out value="${nombreActividad}" />
			        			</div>
					        </div>
					        <div class="filaForm">
			        			<div class="lbll tal vat">
			        				<label>Tipo de Supervisi&oacute;n </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				<c:out value="${tipoSupervision}" />
			        			</div>
			        			<div class="lbll tal vat">
			        				<label>Resultado </label>
			        			</div>
			        			<div class='lbly tal vat <c:out value="${estiloResultado}" />'>
			        				<c:out value="${nombreResultado}" />
			        			</div>
							</div>
							<c:if test="${not empty nombreResultado and nombreResultado ne 'Sin Incumplimientos'}">
								<div class="filaForm">
									<div class="lbll tal vat">
										<label>Medida de Seguridad </label>
									</div>
									<div class="lbly tal vat">
										<c:if test = "${not empty nombreMedidaSeguridadEjecutada and nombreMedidaSeguridadEjecutada ne ''}">
									    	${nombreMedidaSeguridadEjecutada} <br/>
									    </c:if>
										<c:if  test = "${not empty productosScopSuspendidos and productosScopSuspendidos ne ''}">
											<label>Suspensi&oacute;n de Compras de:</label> ${productosScopSuspendidos}
									    </c:if>
					        		</div>
					        		<div class="lblx tal vat">
					        			<c:if test="${not empty fechaLimiteMedidaSeguridadEjecutada and fechaLimiteMedidaSeguridadEjecutada ne ''}">
					        				La medida de seguridad se aplicar&aacute; como m&iacute;nimo hasta: ${fechaLimiteMedidaSeguridadEjecutada}
					        			</c:if>
					        		</div>
								</div>
							</c:if>
							<div class="filaForm">
			        			<div class="lbll tal vat">
			        				<label>Empresa Supervisora </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				<c:out value="${nombreEmpresaSupervisora}" />
			        			</div>
			        			<div class="lbll tal vat">
			        				<label>Especialista de Osinergmin </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				<c:out value="${nombreEspecialistaOsinergmin}" />
			        				<br />
			        				<c:out value="${nombreUnidadOrganicaOsinergmin}" />
			        			</div>
							</div>
							<div class="filaForm" style="display:none;">
			        			<div class="lbll tal vat">
			        				<label>Supervisor </label>
			        			</div>
			        			<div class="lbly tal vat">
			        				<c:out value="${nombreSupervisor}" />
			        			</div>
			        			<div class="lbll tal vat">
			        			</div>
			        			<div class="lbly tal vat"></div>
							</div>
				        </div>
					</div>
				</form>
				<div class="botones" style="text-align:center;">
					<br>
					<button id="btnVerDocumentosSupervision" class="btnSimple" title="Ver Documentos de la Supervisi&oacute;n" style="width: 250px">VER DOCUMENTOS DE LA SUPERVISI&Oacute;N</button>
					<button id="btnSalir" class="btnSimple" title="Salir" style="width: 100px;">SALIR</button>
				</div>
				<center>
					<div id="gridContenedorInfracciones" style="display:none;"></div>
					<div id="detalleSupervisionSinDatos-div" style="display:none;">
						<c:if test="${not empty nombreResultado and nombreResultado ne 'Sin Incumplimientos'}">
							<br />
							<label id="detalleSupervisionSinDatos" class="tal">El informe de Supervisi&oacute;n se encuentra en proceso de evaluaci&oacute;n</label>
							<br /><br />
						</c:if>
					</div>
				</center>
			</div>
			<div></div>
		</div>       
        <div class="scrollPanel" id="scrollPrincipal">		
            <span id="contenedorIconos">				
            </span>		
        </div>
        <div id="dialogDocumentosAdjuntos" class="dialog" title="DOCUMENTOS ADJUNTOS">
        	<div id="datosCabeceraDocumentosSupervisionDsr" class="form" style="display:none;">
				<div style="text-align:left;">
					<div class="filaForm">
						<div class="lblp tal">
							<label>Descripci&oacute;n </label>
						</div>
						<div id="descripcionDocumentosSupervisionDsr" class="tal"></div>
					</div>
				</div>
			</div>
            <div class="botones" style="text-align:right;">
				<button id="btnDescargaMultiple" class="btnSimple" title="Descarga m&uacute;ltiple" style="width: 200px">DESCARGA M&Uacute;LTIPLE</button>			                 			                
			</div>
			<center>
				<div id="gridContenedorDocumentosAdjuntos"></div>
			</center>
            <div class="botones">
                <button id="btnSalirDialogDocumentosAdjuntos" title="Salir" style="width: 100px;">SALIR</button> 
            </div>
        </div>
        <div id="stack" class="ui-stack">
            <a title="Regresar" onclick="javascript:formSubmit('formDetalleSupervision', '/sibad/pages/bandejaSupervision');"></a>
        </div> 
    </jsp:attribute>    
</t:template>
