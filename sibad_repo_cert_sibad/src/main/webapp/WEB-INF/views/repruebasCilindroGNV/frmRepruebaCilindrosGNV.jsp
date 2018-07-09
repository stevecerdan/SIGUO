<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
             <script type="text/javascript" src='<c:url value="/javascript/app/repruebasCilindroGNV/frmRepruebaCilindrosGNV.js"/>' charset="utf-8"></script> 
             <script type="text/javascript" src='<c:url value="/javascript/app/InspeccionMantenimientoLimpieza/panelPestana.js" />' ></script>           
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
					
		.ui-dialog .ui-button-icon-primary, .ui-dialog .ui-button-text {
			display: block;
	    }
	   
	   .container {
		    width: auto;
		}
		
/* 		.ui-dialog .ui-button-icon-primary, .ui-dialog .ui-button-text { */
/* 				    display: none; */
/* 	    } */
			  
	    .ui-dialog .ui-dialog-titlebar {
  
            height: 14px;
         }
  
    </style>
    <body>
        <div id="form_registroRepruebaCilindrosGNV">
             <input type="text"   id="txtSetFocus" class="ipt-medium" name="txtSetFocus" style="background-color: transparent;color:#EFEFEF;border-style:none;height:0px;"/>       
             <input type="hidden" id="idUnidadSupervisada" class="ipt-medium" name="idUnidadSupervisada" />
             <input type="hidden" id="idEmpresaSupervisada" class="ipt-medium" name="idEmpresaSupervisada" />
             <input type="hidden" id="fechaSolicitud" class="ipt-medium" name="fechaSolicitud" />
             <input type="hidden" id="idSolicitudPR" class="ipt-medium" name="idSolicitudPR" />
             <input type="hidden" id="idResultadoPR" class="ipt-medium" name="idResultadoPR" />
             <input type="hidden" id="estadoRegistro" class="ipt-medium" name="estadoRegistro" />
             <input type="hidden" id="fechaActual" class="ipt-medium-large" name="fechaActual" value=''/>
             
             <input type="hidden" id="" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             <input type="hidden" id="" class="ipt-medium" name="" />
             
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content" id="">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="frmReprueba" class="tac">
                                <div class="form" style="width:auto; position: relative;float:left; margin: 0px 0px 0px 10px;padding:0px 40px 0px 0px">
                                    <span id="titulo_1" class="ui-panel-title">RESULTADOS DE REPRUEBA</span>

                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="txtEmpAcreditada">Empresa Autorizada:</label></div>
                                        <span id="txtEmpAcreditada"></span>
                                        
                                        <div style="margin: 0px 0px 0px 32px;"></div>
                                      
                                    </div>
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;"><label for="txtFechaInicio">Fecha Prueba:</label></div>
                                        <input id="txtFechaInicio" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>

                                        <div style="margin: 0px 0px 0px 10px;">
                                            <!-- <div class="lble" style="width:15px;"><label for="txtHoraInicio">-</label></div>
                                            <input id="txtHoraInicioH" class="ipt-medium" name="orden" type="time" style="text-align:center; width:90px;border: 2px solid #3B4959;border-radius: 4px;" max="23:59" min="00:00"/> -->
                                        </div>
                                    </div>

                                    <div class="filaForm"  style="" >
                                        <!-- <div class="lble" style="width:97px;"><label for="txtFechaFin">Fecha Fin:</label></div>
                                        <input id="txtFechaFin" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>

                                        <div style="margin: 0px 0px 0px 10px;">
                                            <div class="lble" style="width:15px;"><label for="txtHoraFinH">-</label></div>
                                            <input id="txtHoraFinH" class="ipt-medium" name="orden" type="time" style="text-align:center; width:90px;border: 2px solid #3B4959;border-radius: 4px;" max="23:59" min="00:00" />
                                        </div> -->
                                    </div>
                                    <div class="filaForm"  style="" >
                                         <div class="lble" style="width:97px;"><label for="txtResultado">Resultado:</label></div>
                                         <span id="txtResultado"></span>
                                       
                                    </div>
                                </div>
                                
                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;padding:0px 0px 0px 30px;border-left: 6px solid #ccc!important;">
                                    <span id="titulo_2" class="ui-panel-title">DATOS DE OPERADOR</span>

                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;margin: 7px 0px 7px 0px;"><label for="txtNombreEmp">EMPRESA:</label></div>
                                        <div style="width:310px;"><span id="txtNombreEmp"></span> </div>
                                    </div>
                                    
                                    
                                    <div class="filaForm">
                                        <div class="lble" style="width:97px;margin: 0px 0px 7px 0px;"><label for="txtRH">R.H::</label></div>
                                        <div style="width:310px;"><span id="txtRH"></span> </div>
                                    </div>

                                    <div class="filaForm"  style="" >
                                        <div class="lble" style="width:97px;margin: 0px 0px 7px 0px;"><label for="txtUnidadOperativa">UNIDAD SUPERVISADA:</label></div>
                                        <div style="width:310px;"><span id="txtUnidadSupervisada"></span></div>
                                    </div>
                                    
                                    <div class="filaForm"  style="" >
                                        <div class="lble" style="width:97px;"><label for="txtDireccion">DIRECCION:</label></div>
                                        <div style="width:310px;"><span id="txtDireccion"></span></div>                                     
                                    </div>
                                </div>  
                            </form>
                        </fieldset>
                        
                       <div class="container">								
							<div id="panel">
								<ul id="tabs">
							    	<li id="tab_01"><a href="#" onclick="tab('tab_01','panel_01');">M&Oacute;DULO N&deg; <span id="txtModulo"></span></a></li>
							    </ul>
								<div id="paneles" style="height:auto;">
									<form id="panel_01">
									  <div class="container">
				            		    <div class="pui-panel ui-widget-content">
				             				
				             			  <div class="lble" style="width:25px;margin: 0px 0px 7px 0px;"> 
				                            <label for="txtRH">CILINDRO:<span id="txtCilindro"></span></label>
				                          </div>		
				                          <div class="lble" style="width: -1px;margin: -21px 0px 7px 85px;"> 
				                           	<label for="txtRG">N° SERIE:<span id="txtNroSerie"></span></label>
				                          </div>	

				                          <div class="filaForm" style="margin-left: 10px;">
		                                        <div class="lble" style="width:130px;"><label for="cmbResultReprueba">Resultado de Reprueba:</label></div>
		                                          <div>
					                                <select id="cmbResultReprueba" name="cmbResultReprueba" class="ipt-medium-small" style="width: 370px;">
					                                    <option value="">--Seleccione--</option>
					                                    <option value="A">APROBADO</option>
					                                    <option value="C">CONDENADO</option>
					                                    <option value="R">RECHAZADO</option>									                                   
					                                </select>
					                            </div>
		                                        <div style="width:75px"></div>						                                        
				                           </div>

				                          <div id ="mostrarFieldset" style="display:none">
						             	  <fieldset class='tac' style="margin: 10px 10px">
						                     <div class="form" style="width:auto; float:left; margin-left: 0px;">
				                                                                
				                                <span id="txtCilindro" class="ui-panel-title"></span>				                                
				                                <div class="uk-panel">
												    <div class="uk-panel-badge uk-badge">Datos del Certificado de Inspecci&oacute;n </div>
												    <div class="uk-panel-title" style="width:auto; float:left; margin-left: 30px;">
												      
												      <div class="filaForm">
				                                        <div class="lble" style="width:130px;"><label for="txtCodCertificado">C&oacute;digo de Certificado:</label></div>
				                                        <input id="txtCodCertificado" class="ipt-medium" name="orden" type="text" maxlength="" style="text-transform:uppercase; width:170px;"/>
				                                        
				                                        <div style="width:75px"></div>
				                                        
				                                        <div class="lble" style="width:130px;"><label for="txtFechaEmision">Fecha de Emisi&oacute;n:</label></div>
                                                        <input id="txtFechaEmision" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>
				                                      </div>
				                                      
											          <div class="filaForm">
				                                        <div class="lble" style="width:130px;"><label for="cmbInspector">Inspector que firma el Certificado:</label></div>
				                                          <div>
							                                <select id="cmbInspector" name="cmbInspector" class="ipt-medium-small" style="width: 370px;">
							                                    <option value="">--Seleccione--</option>									                                   
							                                </select>
							                            </div>
				                                        <div style="width:75px"></div>						                                        
				                                      </div>
												    
												    </div>
												</div>																		                           
						                     </div>
						                   </fieldset>
						                   </div> 

						                   <div id="mostrarFieldset2" style="display:none">
						                   	<fieldset class='tac' style="margin: 10px 10px">
						                   		<div class="filaForm">
				                                    <div class="lble" style="width:130px;"><label for="txtNumeroInforme">N&uacute;mero de Informe:</label></div>
				                                    <input id="txtNumeroInforme" class="ipt-medium" name="orden" type="text" maxlength="" style="text-transform:uppercase; width:170px;"/>
				                                        
				                                    <div style="width:75px"></div>
				                                        
				                                    <div class="lble" style="width:130px;"><label for="txtFechaInforme">Fecha de Informe:</label></div>
                                                    <input id="txtFechaInforme" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>
				                                </div>
						                   	</fieldset>
						                   </div>
				                           
				                           <div class="filaForm" style="margin-left: 10px;">	                                          
	                                          <div class="lble" style="width:130px;"><label for="txtFechaProxReprueba">Fecha Pr&oacute;xima Reprueba GNV:</label></div>
                                              <input id="txtFechaProxReprueba" class="ipt-medium" name="orden" type="text" maxlength="0" style="text-transform:uppercase; width:110px;"/>
	                                       </div>
						                 </div>								              
						                </div>
									  </form>
									  
									 <div class="form" style="width:auto; position: relative;float:left; margin: 0px 0px 30px 10px;padding:0px 40px 0px 0px">
		                                <span id="titulo_3" class="ui-panel-title">Observaciones:</span>
		
		                                <div class="filaForm">
		                                   <div class="lble">
		                                       <textarea id="txtObservacion" name="txtObservacion" rows="7" style="width: 390px;" cols="150"></textarea>                                        
		                                   </div>
		                                </div>
		                            </div>
		                                
		                            <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 300px;padding:0px 0px 0px 30px">
		                               <span id="titulo_2" class="ui-panel-title">Documentos:</span>
		
		                               <div class="filaForm">
		                                    <form id="fileUploadForm" class="tac" method="post" enctype="multipart/form-data">  
			                                    <div class="filaForm" style="">                    
			                                        <div class="customfile" style="position: absolute; width: 234px;">
			                                             <div class="innersec">
			                                                  <input type="file" class="fileinput" id="uploadfile"name="uploadfile" style="width: 100%;height: 100%;position: absolute;left: 0px;top: 0px;opacity: 0;">
			                                                  <span class="cust-btn">Examinar</span>
			                                                  <span class="cust-field" id="nombreArchivo"></span>
			                                             </div>
			                                         </div>				                         
			                                        <div style="width:5px"></div>	
			                                        <input type="button" id="btnAgregarDoc" title="Agregar" class="btnSimple" disabled="disabled" style="width: 80px; margin: 0px 0px 0px 240px;height: 25px" value="Agregar">
			                                    </div>
						                   </form>
						                   		        
					                       <div id="dialogInspectorAutorizadoRR" class="dialog"  title="PERSONAL AUTORIZADO" style="display:none;"></div>
		                                </div>
		                                
		                                <div class="gridMargin" style="margin:0px 0px 30px 0px;">
					                         <div id="gridContenedorDocumentos"></div>
					                    </div>	
		
		                            </div>
		                            
								 </div>
							  </div>
							  <div class="filaform" style="margin:10px 0px 10px 0px; text-align:center;">
                            	  <button id="btnRegresarReprueba" title="Regresar" class="btnSimple">Regresar</button>
                            	  <button id="btnGuardarRegistroReprueba" title="Guardar" class="btnSimple">Guardar</button>
                            	  <button id="btnFinalizarRegistroReprueba" title="Guardar" style="width: 150px" class="btnSimple">Finalizar Registro</button>
                       		  </div>
                       		   
							  <script type="text/javascript">
									tab('tab_01','panel_01');
							  </script>
						</div>						                      
                    </div>
                </div>
            </div>
        </div>
        <div id="dialogInactivarEquipoA" class="dialog"  title="INACTIVAR EQUIPO AUTORIZADO" style="display:none;"></div>
    </body>
</html>