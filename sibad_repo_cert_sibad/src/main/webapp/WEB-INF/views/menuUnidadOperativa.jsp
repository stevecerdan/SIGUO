<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Bienvenido " fecha="${fecha}" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <style>
			.ui-jqgrid tr.jqgrow td { white-space:pre-wrap; height:22px; text-align:center; padding-top:2px; }
			.ui-jqgrid .ui-jqgrid-htable th div { height:auto; overflow:hidden; padding-right:4px; padding-top:2px; position:relative; vertical-align:text-top; white-space:normal !important; }
			
		</style>
    </jsp:attribute>
    
    <jsp:attribute name="bodyArea">
    
    	<div class="container">
			<div></div>
				<div id="paneles" style="height:auto;">
					<form id="panel_01">
					
					<!-- <div class="container" style="width:auto; margin: auto;">
            			<div class="pui-panel-content ui-widget-content"> -->
					
					<div class="container">
            			<div class="pui-panel ui-widget-content">
             
		             	<fieldset class='tac' style="margin: 10px 10px">
		                    
		                    <div class="form" style="width:auto">
		                      <div class="filaForm">  
		                        <div style="margin-right:20px; text-align:center;">
		                            <a href="/sibad/pages/InspMantLimp"><img src="/sibad//../images/IconInsManLim.png" style="width:110px; padding:0px 0px 7px 72px; display:block;" />Programas de Mantenimiento, Inspección y Limpieza</a>
		                        </div> 
		                        <div style="margin-right:20px; text-align:center;">
		                            <a href="/sibad/pages/solicitudPruebasHermeticidad"><img src="/sibad//../images/IconPruHermet.png" style="width:110px; padding:0px 0px 7px 35px; display:block;"/>Solicitud de Pruebas de Hermeticidad</a>
		                        </div> 
		                        <div style="text-align:center;">
		                            <a href="/sibad/pages/repruebasCilindroGNV"><img src="/sibad//../images/IconRepGNV.png" style="width:110px; padding:0px 0px 7px 13px; display:block;"/>Solicitud de Repruebas GNV</a>
		                        </div> 
		                      </div>  
		                    </div>
		                </fieldset>
						
						</div>
					</div>
					
					</form>
					
				</div> 
    	   </div>
    </jsp:attribute>    
</t:template>
