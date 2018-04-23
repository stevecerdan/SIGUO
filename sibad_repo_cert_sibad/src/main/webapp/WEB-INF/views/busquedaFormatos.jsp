<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Bienvenido " fecha="${fecha}" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/busquedaFormatos.js" />' charset="utf-8"></script>
    </jsp:attribute>
    
    <jsp:attribute name="bodyArea">
    	<div class="container">
            <div class="pui-panel ui-widget-content">
                <div class="pui-panel-titlebar ui-corner-all">
                    <span class="ui-panel-title">BANDEJA DE SOLICITUDES</span>
                </div>
             </div>
             <div class="pui-panel-content ui-widget-content">
             	<form id="formFormatoBandeja" class="tac">
                    <div id="divMensajeValidacionFinSiniestro" class="errorMensaje" tabindex='1' style="display: none" ></div>
	             	<input id="idUnidadOperativa" class="dn" value="10000" />
	             	<div class="form">
	             		<div><br></div>
		             	<div style="text-align:center;">
		             	    <div class="filaForm">
			        			<div class="lble">
			        				<label for="txtNumeroSolicitud">N&uacute;mero de Solicitud </label>
			        			</div>
			        			<div>
			        				<input type="text" id="txtNumeroSolicitud" name="numeroSolicitud" style="width: 255px;" maxlength="10">
			        			</div>
					        </div>		             	     
		             	    <div class="filaForm">					        	
					        	<div class="lble">
					             	<label for="lblFechaInicio">Fecha Inicio </label>
					            </div>
					            <div>
					            	<input type="text" name="fechaInicio" id="txtFechaInicio" value="" validate="[O][FECHA]" style="width: 255px;">
					            </div>							       		
						   </div>
						   <div class="filaForm">					        	
					        	<div class="lble">
					             	<label for="lblFechaFin">Fecha Fin </label>
					            </div>
					            <div>
					            	<input type="text" name="fechaFin" id="txtFechaFin" value="" validate="[O][FECHA]" style="width: 255px;">
					            </div>							       		
						   </div> 
		             			           
			             	<div class="filaForm">
			        			<div class="lble">
			        				<label for="lblEstadoSolicitud">Estado de la Solicitud </label>
			        			</div>
			        			<div>
			        			   <select name="estadoSolicitud" id="cmbEstadoSolicitud" style="width: 280px;">
                                            <option value="">--Seleccione--</option>
                                            <c:forEach items="${listaEstado}" var="e">
                                                <option value="${e.codigo}">${e.nombreCorto}</option>
                                            </c:forEach>
                                   </select>
			        			</div>
					        </div>
				        </div>
				    	</div>
				    	
				   </form>
				        <div class="botones" style="text-align:center;">
			             	<br>
			                <button id="btnBuscar" class="btnSimple" title="Buscar" style="width: 100px">BUSCAR</button>
			                <button id="btnNuevo" class="btnSimple" title="Nuevo" style="width: 110px">NUEVO</button>
			                <button id="btnLimpiar" class="btnSimple" title="Limpiar" style="width: 130px">LIMPIAR</button>
			                <button id="btnSalir" class="btnSimple" title="Salir" style="width: 130px;"  onClick="self.close();" onKeyPress="self.close();" >SALIR</button>			                 			                
			            </div>
			            <center>
			            <div id="gridContenedorFormatos"></div>
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
