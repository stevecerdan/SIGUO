<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Bienvenido " fecha="${fecha}" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/repruebasCilindroGNV/BandejaRepruebasCilindroGNV.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/latinize.js"/>' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/third-party/jquery.table2excel.min.js"/>' ></script>
       
        <style>
			
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
		  			
		  			.ui-dialog .ui-dialog-titlebar {
	  
	                  height: 14px;
	               }
	                         
	              .ui-dialog .ui-button-icon-primary{
	                 /* display: block; */
	                 display: none;
	              }
		</style>
    </jsp:attribute>
    
    <jsp:attribute name="bodyArea">
        
    	<div class="container">
			<div></div>
			
			<div id="panel">
				<div id="paneles" style="height:auto;">
					<form id="panel_01">
					
					<!-- <div class="container" style="width:auto; margin: auto;">
            			<div class="pui-panel-content ui-widget-content"> -->
					
					<div class="container">
            			<div class="pui-panel ui-widget-content">
             
		             	<fieldset class='tac' style="margin: 10px 10px">
		                    <div class="form" style="width:auto; float:left; margin-left: 25px;">
		                    
		                        <div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 20px;"><label>Buscar por :</label> </div>
			                            <div>
			                                <select id="cmbTipoBusqueda" name="tipoBusqueda" class="ipt-medium-small">
			                                    <option value="">--Seleccione--</option>
			                                    <option value="1">Nro Solicitud</option>
		                                    	<option value="2">Empresa</option>
			                                    <!-- <option value="2">Serie Tanque</option>
			                                    <option value="4">Unidad</option>  -->
			                                </select>
			                            </div>
		                            <div class="ipt-small vam" style="margin-left: 40px;"> </div>
		                            <input id="txtFiltroBusqueda" class="ipt-medium-large" name="FiltroBusqueda" type="text" maxlength="200" style="text-transform:uppercase;width: 325px;"/>                           
		                            
		                           	<div style="margin-left: 30px;">
				                    <input type="button" id="btnBuscarEmp" title="Buscar" class="btnSimple" style="width: 100px" value="Buscar"/>
				                   
				                    <input type="button" id="btnSolicitar" title="Solicitar" class="btnSimple" style="margin-left: 344px; width: 150px" value="Solicitar Reprueba"/>
				                	</div>
				                    
		                        </div>

		                        <div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 39px;"><label>Estado :</label> </div>
		                            <select id="cmbTipoEstado" name="tipoEstado" class="ipt-medium-small">
		                                <option value="0">--Seleccione--</option>
		                                <option value="1">PROGRAMADO</option>  
		                                <option value="2">REPROGRAMADO</option>
		                                <option value="3">CANCELADO</option>
		                                <option value="4">EN REGISTRO</option>
		                                <option value="5">CONCLUIDO</option>
		                            </select>
		                        </div>
		                        
		                    </div>
		                </fieldset>
		
		                <div class="gridMargin" style="margin:10px;">
		                	<div id="gridContenedorRepruebas"></div>
		                </div>
		                
		                <div style="margin: 20px 0px 10px 1175px;" text-align="left">
		                   <input type="button" id="btnExportar" title="Exportar a Excel" class="btnSimple" style="width: 150px" value="Exportar a Excel">
	                    </div>

		                <div id="dialogNuevaReprueba" class="dialog"  title="Nueva Empresa Acreditada" style="display:none;"></div>
		                <div id="dialogFrmReprogramacionCancelacion" class="dialog"  title="Repruebas" style="display:none;"></div>
		                <div id="dialogInfo" class="dialog"  title="INFO" style="display:none;"></div>
					    <div id="dialogFrmReprueba" class="dialog"  title="INFO" style="display:none;"></div>
						
						</div>
						
					</div>
					
					</form>
					
				</div>
				
			</div>  
    	   </div>
    	  
    </jsp:attribute>    
</t:template>


