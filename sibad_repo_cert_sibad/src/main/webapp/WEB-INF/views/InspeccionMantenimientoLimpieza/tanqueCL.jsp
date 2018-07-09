<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Bienvenido " fecha="${fecha}" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/InspeccionMantenimientoLimpieza/tanqueCL.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/InspeccionMantenimientoLimpieza/panelPestana.js" />' ></script>
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
					
			  /*.ui-dialog .ui-button-icon-primary, .ui-dialog .ui-button-text {
				    display: none;
			  }*/
			  
			  .ui-dialog .ui-button-icon-primary {
				    display: none;
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
    
        <input type="hidden" id="codigoOsinergmin" class="ipt-medium-large" name="codigoOsinergmin" value='9655'/>
        <input type="hidden" id="idAlmacenamiento" class="ipt-medium-large" name="idAlmacenamiento" value=''/>
        <input type="hidden" id="idUnidadSupervisada" class="ipt-medium-large" name="idUnidadSupervisada" value=''/>
        <input type="hidden" id="fechaActual" class="ipt-medium-large" name="fechaActual" value=''/>
         
    	<div class="container">
			<div></div>
			
			<div id="panel">
				<ul id="tabs">
			    	<li id="tab_01"><a href="#" onclick="tab('tab_01','panel_01');">Tanque CL</a></li>
			        <!--<li id="tab_02"><a href="#" onclick="tab('tab_02','panel_02');">Historial de Inspecciones</a></li>-->
			    </ul>
				<div id="paneles" style="height:auto;">
					<form id="panel_01">

					<div class="container">
            		    <div class="pui-panel ui-widget-content">
             
		             	<fieldset class='tac' style="margin: 10px 10px">
		                    <div class="form" style="width:auto; float:left; margin-left: 30px;">

		                        <div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 20px;"><label>Buscar por :</label> </div>
			                            <div>
			                                <select id="cmbTipoBusqueda" name="tipoBusqueda" class="ipt-medium-small">
			                                    <option value="">--Seleccione--</option>
			                                    <option value="1">Tipo de Revisi&oacute;n</option>  
			                                    <option value="2">N&deg; Programa</option>
			                                    <option value="3">Unidad Almacenamiento</option> 
			                                    <option value="4">Estado</option>
			                                    <option value="5">Mostrar Todo</option>
			                                </select>
			                            </div>
		                            <div class="ipt-small vam" style="margin-left: 40px;"> </div>
		                            <input id="txtFiltroBusqueda" class="ipt-medium-large" name="FiltroBusqueda" type="text" maxlength="200" style="text-transform:uppercase;width: 325px;"/>                           
		                            
		                            
		                           	<div style="margin-left: 30px;">
				                    <input type="button" id="btnBuscar" title="Buscar" class="btnSimple" style="width: 100px" value="Buscar">
				                    <input type="button" id="btnNuevo" title="Nuevo" class="btnSimple" style="margin-left: 300px; width: 170px" value="Programar Inps/ Man/ Limp">
				                    <!--<input type="button" id="btnReprueba" title="Reprueba" class="btnSimple" style="margin-left: 300px; width: 170px" value="Reprueba">-->
				                    
				                    </div>
		                        </div>
		                        
		                        <div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 40px;"><label>Estado :</label> </div>
			                            <div>
			                                <select id="cmbEstadoPrincipal" name="estadoPrincipal" class="ipt-medium-small">
			                                    <option value="">--Seleccione--</option>
			                                    <option value="1">Programado</option>
			                                    <option value="2">Reprogramado</option> 
			                                    <option value="3">Cancelado</option> 
			                                    <option value="4">En registro</option> 
			                                    <option value="5">Concluido/ Finalizado</option> 
			                                </select>
			                            </div>
		                        </div>
		                        
		                        <!--<div class="filaForm">
		                            <div class="ipt-small vam" style="margin-right: 20px;"><label>Fecha Inicio:</label> </div>
			                        <div>
			                             <input id="txtFechaInicio" class="ipt-medium-large" name="txtFechaInicio" type="text" style="text-transform:uppercase; width:123px;"/>  
			                        </div>
			                        
		                            <div class="ipt-small vam" style="margin-left: 40px;"> </div>
		                            
		                            <div class="ipt-small vam" style="margin-right: 20px; margin-left: 13px;"><label>Fecha Fin:</label> </div>
			                        <div>
			                            <input id="txtFechaFin" class="ipt-medium-large" name="txtFechaFin" type="text" style="text-transform:uppercase; width:123px;"/>     
			                        </div>
		                            
		                           
				                </div>-->
		                     </div>
		                  </fieldset>
		               </div>
		               
		                <div class="gridMargin" style="margin:10px;">
		                	<div id="gridTanqueCL"></div>
		                </div>
		                <input type="button" id="btnExportar" title="Exportar a Excel" class="btnSimple" style="margin-left: 87%; width: 170px" value="Exportar a Excel">
		                	               
						<div style="margin:10px;">
			             	<table id= "tablitaIML" border="1" style="display:none;"></table>
			           </div> 
						
		                <div id="dialogFrmIndivualMasiva" class="dialog"  title="PROGRAMACI&Oacute;N DE INSPECCIONES, MANTENIMIENTO Y LIMPIEZA" style="display:none;"></div>
                        <div id="dialogFrmCancelacion" class="dialog"  title="CANCELAR INSP / MANT / LIMP" style="display:none;"></div>
                        <div id="dialogFrmReprogramacion" class="dialog"  title="REPROGRAMAR INSP / MANT / LIMP" style="display:none;"></div>
                        <div id="dialogFrmRegistrar" class="dialog"  title="REGISTRAR INSP / MANT / LIMP" style="display:none;"></div>
                        <div id="dialogFrmRevision" class="dialog"  title="REGISTRAR INSP / MANT / LIMP" style="display:none;"></div>
                        <div id="dialogFrmPrueba" class="dialog"  title="PROGRAMACI&Oacute;N DE INSPECCIONES, MANTENIMIENTO Y LIMPIEZA" style="display:none;"></div>
                        <div id="dialogInfo" class="dialog"  title="INFORMACION DE ESTADO" style="display:none;"></div>                      
                        <div id="dialogFrmReprueba" class="dialog"  title="" style="display:none;"></div>
                        
						</div>
					
					   </form>
					</div>
				</div>
				<script type="text/javascript">
					tab('tab_01','panel_01');
				</script>
			</div>  
			
			<!-- <div id="dialog-message" title="">
				<p>
					<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;">
					</span>
					<label id="dialog-message-content"></label>
					
				</p>	
            </div> -->
    	   
    </jsp:attribute>    
</t:template>
