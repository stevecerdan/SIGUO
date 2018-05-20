<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/InspeccionMantenimientoLimpieza/pIndividualMasiva.js" />' charset="utf-8"></script>       
    </head>
    <style>
      
       /*.custom-file{  
       
         background-color: #EEE;
         width:400px;
         border: 1px solid #CCC;
         height:30px;
         position: relative;
         z-index:1
       }
       
       .custom-file input[type="file"]{  
        width:100%;
        height:100%;
        opacity:0;
        position: absolute;
        left:0;
        top:0;
        z-index:3;
       }
       
       .custom-file:after{  
        content:"Examinar";
        background-color: #F00;
        color: #FFF;
        width:100px;
        height:30px;
        position: absolute;
        top:0;
        right:0;
        line-height:30px;
        text-align:center;
        font-family:Tahoma, Arial;
        z-index5;
        
       }*/
       
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
		    border: solid 1px #c2c2c2;
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
		    /*margin-top: 1px;*/
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
		

    </style>
    <body>
    	<fieldset>
    	    <input type="hidden" id="idAlmacenamientoCompartimiento" name="idAlmacenamientoCompartimiento" class="ipt-medium-large" />
    	    <input type="hidden" id="codOsinergmin"  name="codOsinergmin" class="ipt-medium-large"/>
    	    
    	    
	        <form id="frmIndivualMasiva" class="tac">  
	            
	            <div id="divMensajeValidaIndivualMasiva" class="errorMensaje" tabindex='1' style="display: none" ></div>
	               
	            <div class="form">

	                <div class="filaForm">
	                    <div class="ipt-small vam" style="">
	                       <input type="radio" id="pIndividual" name="pIndividual" value="I" checked> Programaci&oacute;n Individual
	                    </div>
                        <div class="ipt-small vam" style="margin-left: 40px;"></div>
                        <input type="radio" id="pMasiva" name="pMasiva" value="M"> Programaci&oacute;n Masiva<br>
                        <div class="ipt-small vam" style="margin-left: 700px;"> </div>
	                </div>
	                <div class="ipt-small vam" style="margin-top: 13px;"> </div>
	                
	             <div id="Individual"> 
	             
	                <div class="filaForm">
                        <div class="ipt-small vam" style="margin-right: 20px;"><label>Tipo:</label> </div>
                        <div>
                            <select id="cmbTipo" name="cmbTipo" class="ipt-medium-small">
                                    <option value="">--Seleccione--</option>
                                    <option value="I">Inspecci&oacute;n</option>
                                    <option value="M">Mantenimiento</option>
                                    <option value="L">Limpieza</option>
                            </select>
                        </div>
				   </div> 
				   <div class="ipt-small vam" style="margin-top: 15px;"> </div>  
	                <div class="filaForm">
                        <div class="ipt-small vam" style="margin-right: 15px;"><label>Fecha:</label> </div>
                        <div>
                             <input type="text" class="ipt-medium-large" id="txtFecha"  name="txtFecha"  style="text-transform:uppercase; width:138px;"/>    
                        </div>
				   </div>   
				   <div class="ipt-small vam" style="margin-top: 15px;"> </div>
	               <div class="filaForm">
                        <div class="ipt-small vam" style="margin-right: 20px;"><label>Unidad de Almacenamiento:</label> </div>
                        <div>
                            <select id="cmbUnidadAlmacenamiento" name="cmbUnidadAlmacenamiento" class="ipt-medium-small">
                                    <option value="">--Seleccione--</option>
                            </select>
                        </div>
				   </div> 
				   <div class="ipt-small vam" style="margin-top: 15px;"> </div>
				   <div class="filaForm">
				        <div class="ipt-small vam" style="margin-right: 5px;"><label>N&deg; Serie:</label> </div>
				        <div>
				           	<input type="text" id="txtSerie" class="ipt-medium-large" name="txtSerie"  maxlength="" style="text-transform:uppercase;width: 255px;"/>  
				        </div>
				    </div>
				    
				    <div class="gridMargin" style="margin-right:220px;">
					       <div id="gridContenedorProgIndividual"></div>
					</div>
				  </div> 
				  
					   
				  
				 <div id="Masiva" style="display:none">
	                <div class="filaForm"> 
	                    <div id="botones" style="position: relative">	
				        	<input type="button" id="btnDescargar" title="Descargar" class="btnSimple" value="Descarga">
				        </div>
				         <div class="ipt-small vam" style="margin-left: 40px;"></div>

				         <div class="customfile" style="position: absolute; width: 234px;">
				             <div class="innersec">
				                  <input type="file" class="fileinput" id="archivo" style="width: 100%;height: 100%;position: absolute;left: 0px;top: 0px;opacity: 0;">
				                  <span class="cust-btn">Examinar</span>
				                  <span class="cust-field" id="nombreArchivo"></span>
				             </div>
				         </div>
				         
				         <div class="ipt-small vam" style="margin-left: 40px;"></div>
				         
				         <div id="botones" style="position: absolute;padding-left:325px">	
				        	<input type="button" id="btnIniciarCarga" title="Iniciar Carga" class="btnSimple" value="Iniciar Carga">
				        </div>
				          
	                </div>
	                
				   <div class="gridMargin" style="margin-right:230px;">
				       <div id="gridContenedorProgMasiva"></div>
				   </div>                                                                    
	            </div> 
				                                                                     
	            </div>          
	        </form>
	          
	   	</fieldset>
	   	
		<div id="botones" style="margin-top:10px;text-align:center;">
        	<input type="button" id="btnRegresar" title="Regresar" class="btnSimple" value="Regresar">
        	<input type="button" id="btnGuardar" title="Guargar" class="btnSimple" value="Guardar">
        </div>
    </body>
</html>