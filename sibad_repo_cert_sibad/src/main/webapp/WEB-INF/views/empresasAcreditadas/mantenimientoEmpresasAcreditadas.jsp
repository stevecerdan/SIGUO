<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Bienvenido " fecha="${fecha}" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/mantenimientoEmpresasAcreditadas.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/panelPestana.js" />' ></script>
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
			/* tama�o y forma del panel principal */
			div#panel {
				position: relative; width:400px; height: 300px;
			}
			
			/* configuracion de las pesta�as */
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
			
					/* Configuraci�n de los paneles */
					div#panel #paneles {
						left: 0px; top: 23px; width: auto; height: 275px; border: 1px solid #91a7b4;
						background: #fff; overflow: hidden; z-index: 10px;
					}
					/*div#panel #paneles div {
						margin:10px;
						width: 378px;
						height: 255px;
						font-family: arial;
						font-size: 12px;
						text-decoration: none;
						color: #000;
						overflow: auto;
					}*/
					
					.ui-dialog .ui-button-text {
				    display: block;
		  			}
		</style>
    </jsp:attribute>
    
    <jsp:attribute name="bodyArea">
    
    	<div class="container">
			<div></div>
			
			<div id="panel">
				<ul id="tabs">
			    	<li id="tab_01"><a href="#" onclick="tab('tab_01','panel_01');">Empresas Acreditadas</a></li>
			        <li id="tab_02" style="display:none;"><a href="#" onclick="tab('tab_02','panel_02');">Historial de Inspecciones</a></li>
			    </ul>
				<div id="paneles" style="height:auto;">
					<form id="panel_01">
					
					<!-- <div class="container" style="width:auto; margin: auto;">
            			<div class="pui-panel-content ui-widget-content"> -->
					
					<div class="container">
            			<div class="pui-panel ui-widget-content">
             
		             	<fieldset class='tac' style="margin: 10px 10px">
		                    <div class="form" style="width:auto; float:left; margin-left: 30px;">
		                    
		                        <div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 20px;"><label>Buscar por :</label> </div>
			                            <div>
			                                <select id="cmbTipoBusqueda" name="tipoBusqueda" class="ipt-medium-small">
			                                    <option value="">--Seleccione--</option>
			                                    <option value="1">RUC</option>  
			                                    <option value="2">Raz&oacute;n Social</option>
			                                    <option value="3">Direcci&oacute;n</option> 
			                                    <option value="4">Departamento</option> 
			                                    <option value="5">Provincia</option> 
			                                    <option value="6">Distrito</option>
			                                    <option value="7">Estado</option>   
			                                </select>
			                            </div>
		                            <div class="ipt-small vam" style="margin-left: 40px;"> </div>
		                            <input id="txtFiltroBusqueda" class="ipt-medium-large" name="FiltroBusqueda" type="text" maxlength="200" style="text-transform:uppercase;width: 325px;"/>                           
		                            
		                           	<div style="margin-left: 30px;">
				                    <input type="button" id="btnBuscarEmp" title="Buscar" class="btnSimple" style="width: 100px" value="Buscar">
				                    <input type="button" id="btnNuevoEmp" title="Nuevo" class="btnSimple" style="margin-left: 370px; width: 100px" value="Nuevo">
				                    </div>
		                        </div>
		                        
		                        <div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 40px;"><label>Estado :</label> </div>
		                            <div>
		                                <select id="cmbEstadoPrincipal" name="estadoPrincipal" class="ipt-medium-small">
		                                    <option value="">--Seleccione--</option>
		                                    <option value="1">VIGENTE</option>
		                                    <option value="2">NO VIGENTE</option>
		                                </select>
		                            </div>
		                        </div>
		                        
		                        <input type="hidden" id="idOrganismoAcreditadorEntrante" value="414"/>
		                        
		                    </div>
		                </fieldset>
						
		                <div class="gridMargin" style="margin:10px;">
		                	<div id="gridContenedorEmpAcred"></div>
		                </div>
		                
		                <div style="margin:10px;">
		                	<table id= "tablitaEA" border="1" style="display:none;"> 
		                	</table>
		                </div>
		                
		                <div style="margin: 10px 10px 5px 0px; text-align: right;">
		                   <input type="button" id="btnExportar" title="Exportar a Excel" class="btnSimple" style="width: 150px" value="Exportar a Excel">
		                  
	                    </div>
	                    
	                    

		                <div id="dialogNuevaEmpresaAcreditada" class="dialog"  title="Nueva Empresa Acreditada" style="display:none;"></div>
		                <!-- <div id="dialogProcesoAcreditacion1" class="dialog"  title="Editar Proceso Acreditado" style="display:none;"></div> -->
						<div id="dialogInfo" class="dialog"  title="Informacion Alcance Acreditacion" style="display:none;"></div>
						
						</div>
					</div>
					
					</form>
					<form id="panel_02">
						
						<div class="container">
            			<div class="pui-panel ui-widget-content">
            			
            			<span class="ui-panel-title" style="margin-left:10px;font-size:30px;" id="Titulo"></span>
             
		             	<fieldset class='tac' style="margin: 10px 10px">
		                    <div class="form" style="width:auto; float:left; margin-left: 30px;">
		                        
		                        <div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 20px;"><label>Buscar por :</label> </div>
			                            <div>
			                                <select id="cmbTipoBusquedaH" name="tipoBusqueda" class="ipt-medium-small">
			                                    <option value="">--Seleccione--</option>
			                                    <option value="1">Empresa</option>  
			                                    <option value="2">Unidad Operativa</option>
			                                    <option value="3">Tipo de Prueba</option> 
			                                </select>
			                            </div>
		                            <div class="ipt-small vam" style="margin-left: 40px;"> </div>
		                            <input id="txtFiltroBusquedaHistorial" class="ipt-medium-large" name="FiltroBusqueda" type="text" maxlength="200" style="text-transform:uppercase;width: 325px;"/>                           
		                            
		                           	<div style="margin-left: 30px;">
				                    <input type="button" id="btnBuscarHistorial" title="Buscar" class="btnSimple" style="width: 100px" value="Buscar">
				                    </div>
		                        </div>		                        
		                    </div>
		                </fieldset>
						
						<div class="gridMargin" style="margin:10px;">
					       	<div id="gridContenedorResultados"></div>
					    </div>

					    <div id="dialogNuevaReprueba" class="dialog"  title="repruebita" style="display:none;"></div>
		                	
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
