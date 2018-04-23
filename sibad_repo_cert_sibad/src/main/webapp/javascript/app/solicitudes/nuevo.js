/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var formatoNuevaSolicitudEstadoCuenta = (function() {
    
    function constructor() {
        confirm.start();
        inicializacionComponentes();          
       
        $("#dialogConfirmacion").dialog({
            resizable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            dialogClass: 'dialog',
            modal: true,
            beforeClose: function(event, ui) {                
                formSubmit('formSolicitudCuenta', '/sibad/pages/busquedaFormatos');
                return true;
            }
        });        
    
        $('#btnSalirSolicitud').click(function(){        	   
        	formSubmit('formSolicitudCuenta', '/sibad/pages/busquedaFormatos');

        });
        
        $("#txtRuc").attr("disabled", "disabled");
        $("#txtRazonSocial").attr("disabled", "disabled");
        $("#txtDireccion").attr("disabled", "disabled");
        $("#txtDepartamento").attr("disabled", "disabled");
        $("#txtProvincia").attr("disabled", "disabled");
        $("#txtDistrito").attr("disabled", "disabled");
        $("#txtTelefono").attr("disabled", "disabled");
        $("#txtCorreo").attr("disabled", "disabled");
        $("#txtCodigoOsinergmin").attr("disabled", "disabled");
        $("#txtDependencia").attr("disabled", "disabled");
    }

    function inicializacionComponentes() {
        $('#datosSolicitudEstadoCuenta').puiaccordion({multiple: true});    
        $("#radiosetPeriodo").buttonset();           
        
        $('#txtFechaInicio').datepicker({
            changeMonth: true,
            changeYear: true,
            showOn: "focus",
            buttonImageOnly: true,
            showAnim: "fade",
            dateFormat: "dd/mm/yy"
        });
		
		$('#txtFechaInicio').keydown(function(event) {
            var key = event.keyCode || event.charCode;
            if (key != 8 && key !== 46)
                return false;
        });
		
		$("#txtFechaInicio").change(function() {
            test = $(this).datepicker('getDate');
            testm = new Date(test.getTime());
            testm.setDate(testm.getDate());
            $("#txtFechaFin").datepicker("option", "minDate", testm);            
        });
		
		$('#txtFechaFin').datepicker({
            changeMonth: true,
            changeYear: true,
            showOn: "focus",
            buttonImageOnly: true,
            showAnim: "fade",
            dateFormat: "dd/mm/yy"            
        });
		
		$('#txtFechaFin').keydown(function(event) {
            var key = event.keyCode || event.charCode;
            if (key != 8 && key !== 46)
                return false;
        });
                
        $('#txtRuc').alphanum(numericDecimal);
        $('#txtTelefono').alphanum(numericDecimal);
       
        $('#radiosetPeriodo1').change(function() {  
            id = "radiosetPeriodo";            
            removeClassError(id);                       
            ocultarRango();            
        });
        
        $('#radiosetPeriodo0').change(function() { 
            id = "radiosetPeriodo";           
            removeClassError(id);                      
            mostrarRango();
                                          
        });
                
        $('#btnCorregirSolicitante').puibutton({ icon: 'ui-icon-pencil' });
                   
        $('#btnGuardarSolicitud').click(function() {
            registrarSolicitudCuenta();
        });
               
        $("#btnImprimirReporte").click(imprimirSolicitudCuenta);        
        $("#btnSalirPopup").click(cerrarFormulario);
        
        $("#btnCorregirSolicitante").click(function(){           	
        	$("#txtTelefono").removeAttr("disabled");
        	$("#txtCorreo").removeAttr("disabled");
        	$('#heditarUO').val("1");        	
         	$("#txtTelefono").attr("validate","[O]");
         	$("#txtCorreo").attr("validate","[O]");        	
        });
 
     valorPorDefecto();
    
    }
    
    function valorPorDefecto(){
    	$('#datosSolicitudEstadoCuenta .pui-accordion-content').show();
    	id = "radiosetPeriodo";            
        removeClassError(id);                       
        ocultarRango(); 
        $('#radiosetPeriodo1').attr('checked', 'checked').button('refresh');
    	
    }
    

    function cerrarFormulario() {        
        formSubmit('formSolicitudCuenta', '/sibad/pages/busquedaFormatos');
    }
    
    function ocultarRango() {    	
    	$('#txtFechaInicio').attr('disabled','disabled'); 
    	$('#txtFechaInicio').removeAttr('validate');
    	document.getElementById('txtFechaInicio').value='';    	
    	$('#txtFechaFin').attr('disabled','disabled'); 
    	$('#txtFechaFin').removeAttr('validate');
    	document.getElementById('txtFechaFin').value='';    		
    }
    
    function mostrarRango() {    	
    	$('#txtFechaInicio').removeAttr('disabled'); 
    	$('#txtFechaFin').removeAttr('disabled'); 
    	$('#txtFechaInicio').attr('validate','[O][FECHA]'); 
    	$('#txtFechaFin').attr('validate','[O][FECHA]');     	
    }

    function cerrarFormulario() {      
    	formSubmit('formSolicitudCuenta', '/sibad/pages/busquedaFormatos');
    }

    function validacionPrincipal() {
        var mensajeValidacion = "";
        var validarFormularioUno = true;
        validarFormularioUno = $('#formSolicitudCuenta').validateAllForm('#divMensajeValidacion');
        if (validarFormularioUno) {
            mensajeValidacion = validacionForma();
            if (mensajeValidacion != "") {
                var divValidacion = $('#divMensajeValidacion');
                var mensaje = "Por favor validar el correcto ingreso de los siguientes campos: <br>";
                mensaje += mensajeValidacion;
                divValidacion.show();
                divValidacion.focus();
                divValidacion.html(mensaje);
                return false;            
            }else{
            	return true;
            }
        } else {
            var divValidacion = $('#divMensajeValidacion');
            mensajeValidacion = validacionForma();
            var mensaje = "Por favor completar los datos obligatorios <br>";
            mensaje += mensajeValidacion;
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html(mensaje);
            $('#datosSolicitudEstadoCuenta .pui-accordion-content').show();
            return false;
        }
    }

    function validacionForma() {   
    	var mensajeValidacion = "";    	
    	
    	if ($("#heditarUO").val()== "1"){    		
	      if (!validarCadenaVacia($("#txtTelefono").val())) {
	    	  mensajeValidacion =  "* Debe ingresar el Tel&eacute;fono del Solicitante <br>";
	      }
	      
	      var correo = $("#txtCorreo").val();		
		  if(!validarCadenaVacia(correo)){ 
			  mensajeValidacion += "* Debe ingresar el Correo Electr&oacute;nico del Solicitante <br>";				 
		  }else if(!validarFormatoCorreo(correo)){ 
			  mensajeValidacion += "* Formato del Correo Electr&oacute;nico incorrecto <br>";			  
		  }	
	      	                       	
    	}    	

    	if (!($('#radiosetPeriodo0').is(':checked')) && !($('#radiosetPeriodo1').is(':checked'))){
    		mensajeValidacion += "* Debe seleccionar el periodo de su solicitud <br>";
    		if (!validarCadenaVacia($("#txtFechaInicio").val())) {
    			mensajeValidacion += "* Debe ingresar fecha Inicio <br>";
            }
            if (!validarCadenaVacia($("#txtFechaFin").val())) {
            	mensajeValidacion += "* Debe ingresar fecha Fin <br>";
            }
    	}
    	    	
    	
        if ($('#radiosetPeriodo0').is(':checked')) {
            if (!validarCadenaVacia($("#txtFechaInicio").val())) {
            	mensajeValidacion += "* Debe ingresar fecha Inicio <br>";
            }
            if (!validarCadenaVacia($("#txtFechaFin").val())) {
            	mensajeValidacion += "* Debe ingresar fecha Fin <br>";
            }
        }
    	    	
        return mensajeValidacion;
    }
    
    function validarFormatoCorreo(string){       
        if(!validarCadenaVacia(string)){       
        	return false;
        }      
        if (string.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1){ 
    		  return true;
        }else{
    		  return false;
        }	  
    }
    
    function validarCadenaVacia(cadena){
        valido = true;
        if(cadena == null || $.trim(cadena)==0){
              valido = false;
        }
        return valido;
    }

    function registrarSolicitudCuenta() {
        console.info("-- registrarSolicitud --");
        var validarFormularioSolicitud = validacionPrincipal();
        
        if (validarFormularioSolicitud) { 
            confirmarFinalizar();
        }
    }
    
    function confirmarFinalizar() {    	
			confirm.open('Se considerar\u00E1n como v\u00E1lidos todos los datos ingresados para emitir el estado de cuenta. Considerar que luego ya no podr\u00E1 realizar cambios en esta misma solicitud. <br/> <br/> Para cualquier modificaci\u00F3n posterior tendr\u00E1 que realizar otra solicitud. <br/><br/>&iquest; Esta seguro? <br/><br/>', 'formatoNuevaSolicitudEstadoCuenta.finalizarSolicitudCuenta()');	 
					
	}

    function finalizarSolicitudCuenta() {    	    
    	$('#overlay_loading').css('display', 'block');
    	$.post(baseURL + "pages/AtachToken/atachTokenToURL",{href : baseURL + "pages/estadoCuenta/guardar"},function(data) {
    		if(data.resultado == 1){
    			mensajeGrowl('error','No se pudo agregar el token a la URL','Intente de nuevo');
            }else{
            	var url =data.href;
                console.info('URL '+url);
                $.ajax({
				    url: url,
				    type: 'post',				   
				    cache:false,
				    data: $('#formSolicitudCuenta').serialize(),
				    beforeSend: muestraLoading,
				    success: function(data) {
				    	if (data.resultado == 0) {
				    		var mensaje = "El N\u00famero de Solicitud: " + data.numeroSolicitud + "<br>";
				            
				            if(data.numeroExpediente !=null && data.numeroExpediente != ""){
	                        	 mensaje += "El N\u00famero de Expediente : " + data.numeroExpediente + "<br>";
	                        }
		                   
	                        if(data.fechaPresentacion !=null && data.fechaPresentacion != ""){
	                        	 mensaje += "Fecha de Presentaci\u00f3n : " + data.fechaPresentacion + "<br>";
	                        }
				            
				            $("#divMensajeConfirmacion").html(mensaje);
				            $("#dialogConfirmacion").dialog("open");
				            $('#idNumeroSolicitud').val(data.numeroSolicitud);
				            $('#txtIdNumeroSolicitud').val(data.numeroSolicitud);
				            mensajeGrowl("success", data.mensaje);
				            mensajeGrowl("success", data.mensaje);
				            ocultaLoading();
				    	} else if (data.resultado == 1) {
				            mensajeGrowl('error', data.mensaje);
				            ocultaLoading();
				        }
				    },
				    error: errorAjax
                });
            }
    });
    }

    function imprimirSolicitudCuenta() {
        console.info("-- imprimirSolicitudCuenta --");
        var path = "/sibad/pages/estadoCuenta";
        var url = path + '/imprimirReporteFinalizar';
        console.info("URL:"+url);
		var parametros = "identificador=" + $("#txtIdNumeroSolicitud").val();
		console.info("parametros"+parametros);
	        $.download(url, parametros, "post");
    }
	    
    return{
        constructor: constructor,
        finalizarSolicitudCuenta: finalizarSolicitudCuenta,
        registrarSolicitudCuenta:registrarSolicitudCuenta,
        confirmarFinalizar:confirmarFinalizar       
    };
})();
$(function() {
	formatoNuevaSolicitudEstadoCuenta.constructor();
});