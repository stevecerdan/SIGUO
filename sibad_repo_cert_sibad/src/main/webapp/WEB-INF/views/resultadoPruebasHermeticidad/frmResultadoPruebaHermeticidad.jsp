<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/resultadoPruebasHermeticidad/frmResultadoPruebaHermeticidad.js"/>' charset="utf-8"></script>   
             <!-- <script type="text/javascript" src='<c:url value="/javascript/app/resultadoPruebasHermeticidad/panelPestana.js" />' ></script> -->           
    </head>
    
    <style type="text/css">

        .customfile {
       
            position: relative;
            overflow: hidden;
            width: 230px;
            height: 19px;
            border: solid 0px red;
            background: #fff;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            border: solid 2px #002c53;
            padding: 2px;
            -webkit-box-shadow: inset 1px 1px 2px #e4e4e4;
            box-shadow: inset 1px 1px 2px #e4e4e4;
        }
        
        .customfile span.cust-btn {
            float: right;
            line-height: 20px;
            padding: 1px 10px;
            height: 18px;
            text-align: center;
            font-weight: bold;
            cursor: pointer;
            color: #333;
            background: #e1e1e1;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
            text-transform: uppercase;
        }
        
        .customfile span.cust-field {
            line-height: 20px;
            padding: 3px 4px;
            width: 225px;
            height: 20px;
            cursor: pointer;
            color: #212121;
            display: block;
            font-weight: normal;
            color: #333;
        }
        
        .customfile .fileinput {
            position: absolute;
            left: 0px;
            top: 0px;
            cursor: pointer;
            z-index: 99;
        }

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
	   
	   .container {
		    width: auto;
		}
    </style>
    <body>
        <div id="form_registroRepruebaCilindrosGNV">
             
             <input type="hidden" id="EmpAcredRPH" class="ipt-medium" name="Empresa Acreditada Ingresada" />
             <input type="hidden" id="AvisoEvento" class="ipt-medium" name="Tipo de Accion" />
             <input type="hidden" id="Compart" class="ipt-medium" name="Id del Compartimiento" />
             <input type="hidden" id="idResultadoPR" class="ipt-medium" name="Id del Resultado Prueba Reprueba" />
             <input type="hidden" id="estadoRegistro" class="ipt-medium" name="Estado de Registro" />
             <input type="hidden" id="idSolicitudPR" class="ipt-medium" name="Id Solicitud Prueba Reprueba" />
             <input type="hidden" id="idUnidadSupervisada" class="ipt-medium" name="Id Unidad Supervisada" />
             <input type="hidden" id="fechaActual" class="ipt-medium-large" name="Fecha Actual" value=''/>
             <input type="hidden" id="CodOsinergminUS" class="ipt-medium" name="Condigo Osinergmin de Unidad Supervisada" />
             <input type="hidden" id="numCompartimiento" class="ipt-medium" name="Condigo Osinergmin de Unidad Supervisada" />
             <input type="hidden" id="numTanque" class="ipt-medium" name="Condigo Osinergmin de Unidad Supervisada" />
             
             <!-- item de inicio focus -->
             <input type="text"   id="txtSetFocus" class="ipt-medium" name="txtSetFocus" style="background-color: transparent;color:#EFEFEF;border-style:none;height:0px;"/>
             
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <!-- <form id="frmReprueba" class="tac"> -->
                                <div class="form" style="width:auto; position: relative;float:left; margin: 0px 0px 0px 10px;padding:0px 20px 0px 0px">
                                    <span id="titulo_1" class="ui-panel-title">RESULTADOS DE EVALUACI&Oacute;N</span>
                                    
                                    <div class="filaForm" style="margin-top: 10px;">
                                        <div class="lble" style="width:90px;"><label for="txtFechaInicioRPH">Fecha Inicio (*):</label></div>
                                        <input id="txtFechaInicioRPH" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>

                                        <div style="margin: 0px 0px 0px 10px;">
                                            <div class="lble" style="width:15px;"><label for="txtHoraInicioRPH">-</label></div>
                                            <input id="txtHoraInicioRPH" class="ipt-medium" name="orden" type="time" style="text-align:center; width:90px;border: 2px solid #3B4959;border-radius: 4px;" max="23:59" min="00:00"/>
                                        </div>
                                    </div>

                                    <div class="filaForm"  style="" >
                                        <div class="lble" style="width:90px;"><label for="txtFechaFinRPH">Fecha Fin:</label></div>
                                        <input id="txtFechaFinRPH" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>

                                        <div style="margin: 0px 0px 0px 10px;">
                                            <div class="lble" style="width:15px;"><label for="txtHoraFinRPH">-</label></div>
                                            <input id="txtHoraFinRPH" class="ipt-medium" name="orden" type="time" style="text-align:center; width:90px;border: 2px solid #3B4959;border-radius: 4px;" max="23:59" min="00:00" />
                                        </div>
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:90px;"><label for="lblInspectorPH">Inspector:</label></div>
                                        <div class="slcta" style="width:258px;">
                                            <select id="cmbInspectorPH" style="width:258px;">
                                                <option value="0">--Seleccione--</option>
                                            </select>
                                        </div>
                                        <input type="button" id="btnAgregarInspector" title="Agregar" class="btnSimple" value="Agregar" style="width:100px;">
                                    </div>
                                    
                                    <div class="gridMargin">
			                            <div id="gridContenedorInspectorXResultado"></div>
			                        </div>	
                                    
                                    <div class="filaForm"  style="" >
                                         <div class="lble" style="width:130px;"><label for="txtResultado">¿TANQUE HERM&Eacute;TICO?</label></div>
                                         <span id="txtResultado" style="font-size:14px;font-weight:bold;">CONFORME</span>
                                       
                                    </div>
                                    
                                    <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeValRInsp"></span>
                                    
                                </div>
                                
                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;padding:0px 0px 80px 20px;border-left: 6px solid #ccc!important;">
                                    <span id="titulo_2" class="ui-panel-title">DATOS DE OPERADOR DE STE</span>

                                    <div class="filaForm" style="margin:10px 0px;">
                                        <div class="lble" style="width:97px;margin: 7px 0px 7px 0px;"><label for="txtNombreEmp">EMPRESA:</label></div>
                                        <span id="txtNombreEmp"></span>
                                    </div>
                                    
                                    
                                    <div class="filaForm" style="margin:10px 0px;">
                                        <div class="lble" style="width:97px;margin: 0px 0px 7px 0px;"><label for="txtRH">R.H.:</label></div>
                                        <span id="txtRH"></span>
                                    </div>

                                    <div class="filaForm"  style="margin:10px 0px;" >
                                        <div class="lble" style="width:97px;margin: 0px 0px 7px 0px;"><label for="txtUnidadOperativa">UNIDAD OPERATIVA:</label></div>
                                        <span id="txtUnidadSupervisada"></span>
                                    </div>
                                    
                                    <div class="filaForm"  style="margin:10px 0px;" >
                                        <div class="lble" style="width:97px;"><label for="txtDireccion">DIRECCION:</label></div>
                                        <span id="txtDireccion"></span><br>
                                        
                                    </div>
                                </div>  
                            <!-- </form> -->
                        </fieldset>
                        
                       <div class="container">								
							<div id="panel">
								<ul id="tabs">
							    	<li id="tab_01"><a href="#" onclick="tab('tab_01','panel_01');" id="titulo_panel" ></a></li>
							    </ul>
								<div id="paneles" style="height:auto;">
									<!-- <form id="panel_01"> -->
									  <div class="container">
				            		    <!-- <div class="pui-panel ui-widget-content"> -->
				            		    <span id="titulo_compartimiento" class="ui-panel-title" style="margin-left:10px;">Compartimientos</span>
				            		    <div class="gridMargin" style="margin-left:10px;">
				                            <div id="gridContenedorCompartimientoXResultado"></div>
				                        </div>	
				             			<div class="form" style="width:665px; position: relative;float:left; margin:10px;">
						             	  <fieldset class='tac' style="height: 173px;">
						             	  	<legend style="text-align:left;font-size:14px;">Documentos</legend>
						             	  	
						             	  	<div class="form" style="width:200px; position: relative;float:left; margin: 0px 0px 0px 10px;padding:0px 10px 0px 0px">
			                                     
			                                     <div class="filaForm">
			                                     <input type="button" id="btnGenerarCodigo" title="Generar Codigo" class="btnSimple" style="width: 140px;" value="Generar Codigo">
			                                     </div>
			                                     
			                                     <div class="filaForm">
			                                        <div class="lble" style="width:200px;margin: 7px 0px 7px 0px;"><label for="txtNumeroCertificado">N&deg; Certificado:</label></div>
			                                        <span id="txtNumeroCertificado"></span>
			                                    </div>
			                                    
			                                    
			                                    <div class="filaForm">
			                                        <div class="lble" style="width:200px;margin: 0px 0px 7px 0px;"><label for="txtNumeroInforme">N&deg; Informe:</label></div>
			                                        <span id="txtNumeroInforme"></span>
			                                    </div>
			                                </div>
			                                
			                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;padding:0px 0px 0px 20px;border-left: 6px solid #ccc!important;">
			                                    
			                                   <form id="fileUploadForm" class="tac" method="post" enctype="multipart/form-data">  
				                                    <div class="filaForm" style="">                    
				                                        <div class="customfile" style="position: absolute; width: 250px;">
				                                             <div class="innersec">
				                                                  <input type="file" class="fileinput" id="uploadfile"name="uploadfile" style="width: 100%;height: 100%;position: absolute;left: 0px;top: 0px;opacity: 0;">
				                                                  <span class="cust-btn" style="margin-right:-8px;">Examinar</span>
				                                                  <span class="cust-field" id="nombreArchivo"></span>
				                                             </div>
				                                         </div>				                         
				                                        <div style="width:5px"></div>	
				                                        <input type="button" id="btnAgregarDocRPH" title="Agregar" class="btnSimple" style="width: 100px; margin: 0px 0px 0px 255px;height: 25px" value="Agregar">
				                                    </div>
				                                    <div class="gridMargin">
							                            <div id="gridContenedorDocumentosRPH"></div>
							                       	</div>
							                   </form>
			                                    
			                                </div>
			                                
						                   </fieldset>
						                  </div>
						                 <!-- </div>	 -->							              
						                <!-- </div>	 -->
									  <!-- </form> -->
									  
										<div class="form" style="width:auto;margin:4px 12px;">
			                                <span id="titulo_3" class="ui-panel-title">Observaciones</span>
			
			                                <div class="filaForm">
			                                    <textarea id="txtObservacion" name="txtObservacion" rows="12" style="width: 400px;" cols="150"></textarea>                                        
			                                </div>
			                            </div>
		                             
		                            </div>    
		                            <div class="form" style="width:auto; float:left; margin-left: 10px;">
											<span id="titulo_4" class="ui-panel-title">Equipos Utilizados</span>
											
		                               <div class="filaForm">
		                               		<div class="lble" style="width:90px; margin-left:10px;"><label for="lblTipoEquipoPH">Tipo de Equipo:</label></div>
	                                        <div class="slcta" style="width:240px;">
	                                            <select id="cmbTipoEquipoPH" style="width:240px;">
	                                                <option value="0">--Seleccione--</option>
	                                            </select>
	                                        </div>
	                                        
	                                        <div class="lble" style="width:50px; margin-left:20px;"><label for="lblEquipoPH">Equipo:</label></div>
	                                        <div class="slcta" style="width:240px;">
	                                            <select id="cmbEquipoPH" style="width:240px;">
	                                                <option value="0">--Seleccione--</option>
	                                            </select>
	                                        </div>
	                                        
	                                        <div class="lble" style="width:80px; margin-left:20px;"><label for="lblComponentePH">Componente:</label></div>
	                                        <div class="slcta" style="width:240px;">
	                                            <select id="cmbComponentePH" style="width:240px;">
	                                                <option value="0">--Seleccione--</option>
	                                            </select>
	                                        </div>
	                                        <input type="button" id="btnAgregarEquipoRPH" title="Agregar" class="btnSimple" style="width: 100px; margin-left:5px;" value="Agregar">
		                               </div>
										<div class="gridMargin" style="margin-left:10px;">
				                            <div id="gridContenedorEquiposRPH"></div>
				                       </div>
		                            </div>
		                            <span class="ui-panel-title" style="margin-left:10px;font-size:13px;color: #008cd9;" id="MensajeValFormRPH"></span>
								 </div>
							  </div>
							  	<div class="filaform" style="text-align:center;margin-top:10px;">
						          	<button id="btnRegresarRPH" title="Regresar" class="btnSimple">Regresar</button>
						           	<button id="btnGuardarRPH" title="Guardar" class="btnSimple">Guardar</button>
						           	<button id="btnFinRegistroRPH" title="Finalizar Registro" class="btnSimple" style="width:150px;">Finalizar Registro</button>
						        </div> 
							  <script type="text/javascript">
									tab('tab_01','panel_01');
							  </script>
						</div>						                      
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>