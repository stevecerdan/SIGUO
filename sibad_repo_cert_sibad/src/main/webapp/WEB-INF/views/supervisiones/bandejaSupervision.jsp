<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Bienvenido " fecha="${fecha}" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/supervisiones/bandejaSupervision.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/common.js" />' ></script>
        <style>
			.ui-datepicker-calendar, .ui-datepicker-current {
				display: none;
			}
			.ui-jqgrid tr.jqgrow td { white-space: normal !important; height:auto; vertical-align:text-top; padding-top:2px; }
			.ui-jqgrid .ui-jqgrid-htable th div { height:auto; overflow:hidden; padding-right:4px; padding-top:2px; position:relative; vertical-align:text-top; white-space:normal !important; }
		</style>
    </jsp:attribute>
    
    <jsp:attribute name="bodyArea">
    	<div class="container">
            <div class="pui-panel ui-widget-content">
                <div class="pui-panel-titlebar ui-corner-all">
                    <span class="ui-panel-title">BANDEJA DE SUPERVISIONES</span>
                </div>
             </div>
             <div class="pui-panel-content ui-widget-content">
             	<form id="formBandejaSupervision" class="tac">
                    <div id="divMensajeValidacionFinSiniestro" class="errorMensaje" tabindex='1' style="display: none" ></div>
	             	<div class="form">
	             		<div><br></div>
		             	<div style="text-align:center;">
		             	    <div class="filaForm">
			        			<div class="lblo tal">
			        				<label for="txtCodigoOsinergmin">C&oacute;digo Osinergmin </label>
			        			</div>
			        			<div>
			        				<input type="text" id="txtCodigoOsinergmin" name="codigoOsinergmin" style="width: 255px;" maxlength="20">
			        			</div>
					        </div>	     
					        <div class="filaForm">
			        			<div class="lblo tal">
			        				<label for="txtRegistroHidrocarburos">Registro de Hidrocarburos </label>
			        			</div>
			        			<div>
			        				<input type="text" id="txtRegistroHidrocarburos" name="registroHidrocarburos" style="width: 255px;" maxlength="20">
			        			</div>
					        </div>        	     
		             	    <div class="filaForm">
					        	<div class="lblo tal">
					             	<label for="txtPeriodoSupervision">Periodo de Supervisi&oacute;n </label>
					            </div>
					            <div>
					            	<input type="text" id="txtPeriodoSupervision" name="periodoSupervision" value="" validate="[O][PERIODO]" style="width: 255px;">
					            </div>							       		
						   </div>
						   <div class="filaForm">
			        			<div class="lblo tal">
			        				<label for="txtNumeroExpediente">N&uacute;mero de Expediente </label>
			        			</div>
			        			<div>
			        				<input type="text" id="txtNumeroExpediente" name="numeroExpediente" style="width: 255px;" maxlength="20">
			        			</div>
					        </div>
					        <div class="filaForm">
			        			<div class="lblo tal">
			        				<label for="txtNumeroOrdenServicio">N&uacute;mero de Orden de Servicio </label>
			        			</div>
			        			<div>
			        				<input type="text" id="txtNumeroOrdenServicio" name="numeroOrdenServicio" style="width: 255px;" maxlength="20">
			        			</div>
					        </div>
				        </div>
					</div>
				</form>
				<div class="botones" style="text-align:center;">
					<br>
					<button id="btnBuscar" class="btnSimple" title="Buscar" style="width: 100px">BUSCAR</button>
					<button id="btnLimpiar" class="btnSimple" title="Limpiar" style="width: 100px">LIMPIAR</button>
					<button id="btnSalir" class="btnSimple" title="Salir" style="width: 100px;"  onClick="self.close();" onKeyPress="self.close();" >SALIR</button>
				</div>
				<center>
					<div id="gridContenedorSupervisiones"></div>
				</center>
			</div>
			<div></div>
		</div>       
        <div class="scrollPanel" id="scrollPrincipal">		
            <span id="contenedorIconos">				
            </span>		
        </div>        
    </jsp:attribute>    
</t:template>
