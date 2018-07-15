<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Bienvenido " fecha="${fecha}" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/empresasAcreditadas/procesosVencidos.js" />' ></script>
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
		                    <div class="form" style="width:auto; float:left; margin-left: 30px;">
		                    
		                        <div class="filaForm">
		                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeCron">PROCESANDO CRON ... </span>
		                        </div>
		                        <div class="filaForm">
		                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeFinalCron"></span>
		                        </div>
		                        <div class="filaForm">
		                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeNotificacion"></span>
		                        </div>
		                        
		                        <div class="filaForm" style="margin-top:20px;">
		                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeCron1">PROCESANDO CRON ... </span>
		                        </div>
		                        <div class="filaForm">
		                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeFinalCron1"></span>
		                        </div>
		                        <div class="filaForm" style="margin-top:20px;">
		                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeCron2">PROCESANDO CRON ... </span>
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
