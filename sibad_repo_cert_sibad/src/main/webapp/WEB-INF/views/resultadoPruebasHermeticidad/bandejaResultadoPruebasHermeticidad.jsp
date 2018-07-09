<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Bienvenido " fecha="${fecha}" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/resultadoPruebasHermeticidad/bandejaResultadoPruebasHermeticidad.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/resultadoPruebasHermeticidad/panelPestana.js" />' ></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/jquery.table2excel.min.js"/>' ></script>
        
        <style>
			/*.ui-datepicker-calendar, .ui-datepicker-current {
				display: none;
			}*/
			
			.ui-datepicker-today a.ui-state-highlight {
				background: #9cbcdc !important;
				color: #333 !important;
			}
			.ui-jqgrid tr.jqgrow td { white-space:pre-wrap; height:22px; text-align:center; padding-top:2px; }
			.ui-jqgrid .ui-jqgrid-htable th div { height:auto; overflow:hidden; padding-right:4px; padding-top:2px; position:relative; vertical-align:text-top; white-space:normal !important; }
			
			<!-- style panel -->
			/* tamaño y forma del panel principal */
			div#panel {
				position: relative; width:400px; height: 300px;
			}
			
			/* configuracion de las pestañas */
			ul#tabs {
				left: 0px; top: 0px; margin:0; padding:0; width: 400px; height: 24px; z-index: 20;
			}
				ul#tabs li {
					float:left; height: 23px; padding-left: 8px; list-style: none; margin-right: 1px; background: #cadada;
				}
				ul#tabs li.actual {
					height: 24px; background: #016aa3;
				}
					ul#tabs li a {
						display: block;
							/* hack para ie6 */
							.display: inline-block;
							/* fin del hack */
						height: 23px; line-height: 23px; padding-right: 8px; outline: 0px none; font-family: arial; 
						font-size: 10px; text-decoration: none; color: #000; background: #cadada;
					}
					
					ul#tabs li.actual a {
						height: 24px; line-height: 24px; background: #016aa3; cursor: default; color: #FFF;	
					}
			
					/* Configuración de los paneles */
					div#panel #paneles {
						left: 0px; top: 23px; width: auto; height: 275px; border: 1px solid #91a7b4;
						background: #fff; overflow: hidden; z-index: 10px;
					}
					
					.ui-dialog .ui-button-text {
				    display: block;
		  			}
		  			
		  			.ui-dialog .ui-dialog-titlebar {
	                  height: 14px;
	               	}
		</style>
    </jsp:attribute>
    
    <jsp:attribute name="bodyArea">
    
    	<div class="container">
			<div></div>
			
			<div id="panel">
				<ul id="tabs">
			    	<li id="tab_01"><a href="#" onclick="tab('tab_01','panel_01');">Solicitudes Pendientes</a></li>
			        <li id="tab_02"><a href="#" onclick="tab('tab_02','panel_02');">Solicitudes Atendidas</a></li>
			    </ul>
				<div id="paneles" style="height:auto;">
					<form id="panel_01" class="tabs">
					
					<div class="container">
            			<div class="pui-panel ui-widget-content">
             
		             	<fieldset class='tac' style="margin: 10px 10px">
		                    <div class="form" style="width:auto; float:left; margin-left: 30px;">
		                    
		                        <div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 20px;"><label>Buscar por :</label> </div>
			                            <div>
			                                <select id="cmbTipoBusquedaSolP" name="tipoBusquedaSolP" class="ipt-medium-small">
			                                    <option value="">--Seleccione--</option>
			                                    <option value="1">N° Solicitud</option>  
			                                    <option value="2">Empresa</option>
			                                </select>
			                            </div>
		                            <div class="ipt-small vam" style="margin-left: 40px;"> </div>
		                            <input id="txtBusquedaSolP" class="ipt-medium-large" name="Busqueda" type="text" maxlength="200" style="text-transform:uppercase;width: 325px;"/>                           
		                            
		                            <!-- <input type="hidden" id="UnidSupervisada" value="293"/>
		                            <input type="hidden" id="CodOsinergmin"/> -->
		                            
		                           	<div style="margin-left: 30px;">
				                    <input type="button" id="btnBuscarSolicitudPendiente" title="Buscar" class="btnSimple" style="width: 100px" value="Buscar">
				                    </div>
		                        </div>
		                        
		                    </div>
		                </fieldset>
		
		                <div class="gridMargin" style="margin:10px;">
		                	<div id="gridContenedorSolicitudesPendientes"></div>
		                </div>
		                
		                <!-- <div style="margin: 10px 10px 5px 0px; text-align: right;">
		                    <input type="button" id="btnExportarP" title="Exportar a Excel" class="btnSimple" style="width: 150px" value="Exportar a Excel">
	                    </div> -->

		                <div id="dialogResultadoSolicitudPruebaHermeticidad" class="dialog"  title="Resultado Solicitud Prueba Hermeticidad" style="display:none;"></div>
		                <div id="dialogFrmEstadoReprogCancel" class="dialog"  title="Reprogramar / Cancelar - Solicitud Prueba Hermeticidad" style="display:none;"></div>
						
						</div>
					</div>
					
					</form>
					<form id="panel_02" class="tabs">
					
					<div class="container">
            			<div class="pui-panel ui-widget-content">
             
		             	<fieldset class='tac' style="margin: 10px 10px">
		                    <div class="form" style="width:auto; float:left; margin-left: 30px;">
		                    
		                        <div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 20px;"><label>Buscar por :</label> </div>
			                            <div>
			                                <select id="cmbTipoBusquedaSolA" name="tipoBusquedaSolA" class="ipt-medium-small">
			                                    <option value="">--Seleccione--</option>
			                                    <option value="1">N° Solicitud</option>  
			                                    <option value="2">Empresa</option>
			                                </select>
			                            </div>
		                            <div class="ipt-small vam" style="margin-left: 40px;"> </div>
		                            <input id="txtBusquedaSolA" class="ipt-medium-large" name="Busqueda" type="text" maxlength="200" style="text-transform:uppercase;width: 325px;"/>                           
		                            		                            
		                           	<div style="margin-left: 30px;">
				                    <input type="button" id="btnBuscarSolicitudAtendida" title="Buscar" class="btnSimple" style="width: 100px" value="Buscar">
				                    </div>
		                        </div>
		                        
		                    </div>
		                </fieldset>
		
		                <div class="gridMargin" style="margin:10px;">
		                	<div id="gridContenedorSolicitudesAtendidas"></div>
		                </div>
		                
		                <!-- <div style="margin: 10px 10px 5px 0px; text-align: right;">
		                    <input type="button" id="btnExportarA" title="Exportar a Excel" class="btnSimple" style="width: 150px" value="Exportar a Excel">
	                    </div> -->

		               	<div id="dialogResultadoSolicitudPruebaHermeticidadAux" class="dialog"  title="Resultado Solicitud Prueba Hermeticidad" style="display:none;"></div>
						
						</div>
					</div>
						
					</form>
				</div>
				<script type="text/javascript">
					tab('tab_01','panel_01');
				</script>
			</div>  
    	   </div>
    </jsp:attribute>    
</t:template>
