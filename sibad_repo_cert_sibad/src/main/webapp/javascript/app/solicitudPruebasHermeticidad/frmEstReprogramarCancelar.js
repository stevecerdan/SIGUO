var idSolicitudPR="";
var tipoEstadoAux ="";
$(function() {
    initInicioEstadoReprogCancel();
    $('#MensajeValSRC').hide();
    $('#btnGuardarSRC').click(GuardarEstReprogramarCancelar);
});

function convertDateFormat(string) {
    var info = string.split('/');
    return info[1] + '/' + info[0] + '/' + info[2];
}

function initInicioEstadoReprogCancel(){
	confirm.start();
	$( "#txtFechaSRC" ).datepicker({ minDate: 0 });
	
	$('#txtFechaSRC').click(function() {
		$("#MensajeValSRC").hide();
	});
	
	$('#txtObservacionSRC').click(function() {
		$("#MensajeValSRC").hide();
	});
	
	$('#cmbMotivoSRC').click(function() {
		$("#MensajeValSRC").hide();
	});

	$('#btnCancelarSRC').click(function() {
		//window.location.href = baseURL+'pages/solicitudPruebasHermeticidad';
		$('#dialogFrmEstReprogramarCancelar').dialog('close');
		listarBandejaPruebaHermeticidad(0);
	});
}

function verificarDatosSolicitudRC(id, tipoOpcion){
	idSolicitudPR = id;
	tipoEstadoAux = tipoOpcion;
	cargarMotivo(tipoOpcion);
	if(tipoOpcion=="R") {
		$("#lblFechaSRC").text("Fecha Reprogramación (*)");}
}

function validarDatosFrmReprogramarCancelar(){
	
	if($("#txtFechaSRC").val() =="" || $('#txtFechaSRC').val() == undefined) {
		$('#MensajeValSRC').html("POR FAVOR AGREGAR LA FECHA");
        return false;  
    } 
	if($("#cmbMotivoSRC").val() == "" || $("#cmbMotivoSRC").val() == undefined){
		$('#MensajeValSRC').html("POR FAVOR SELECCIONE UN MOTIVO");
		return false;
	}
	return true;
}

function GuardarEstReprogramarCancelar(){
	
	if(validarDatosFrmReprogramarCancelar() == true){
		
		//alert('G U A R D A R');	
		if(tipoEstadoAux == 'R'){
   		 confirm.open("¿Esta seguro de registrar la REPROGRAMACION?","registrarTrazabilidadSolicitud(tipoEstadoAux)");
		}else if(tipoEstadoAux == 'C'){
  		 confirm.open("¿Esta seguro de registrar la CANCELACION?","registrarTrazabilidadSolicitud(tipoEstadoAux)");
		}

	}else{
		
        $("#MensajeValSRC").show();
        
	}
}

function registrarTrazabilidadSolicitud(TEst) {
	var fechaA = new Date();

	var month = fechaA.getMonth()+1;
	var day = fechaA.getDate();

	var output =(month<10 ? '0' : '') + month + '/' +	 
				(day<10 ? '0' : '') + day + '/' +
			    fechaA.getFullYear();

	output = output + " " +  fechaA.getHours() +":"+fechaA.getMinutes();
	
	$.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/registrarTrazabilidadYcambioEstado",
        type:'post',
        async:false,
        data:{
        	
        	idSolicitudTraz : "",
        	idSolicitudPruebaReprueba : idSolicitudPR,
	        idTipoMotivo 			  :	$('#cmbMotivoSRC').val(),
	        observacion 			  : $('#txtObservacionSRC').val().latinize().toUpperCase(),
	        fecha     				  : convertDateFormat( $("#txtFechaSRC").val() ),
        	estado 					  : TEst
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	if(TEst == "R"){
            		mensajeGrowl("success", global.confirm.reprog, "");
            	}else{
            		mensajeGrowl("success", global.confirm.cancel, "");
            	}
            	
                //window.location.href = baseURL+'pages/solicitudPruebasHermeticidad';
            	$('#dialogFrmEstReprogramarCancelar').dialog('close');
            	listarBandejaPruebaHermeticidad();
            }
        },
        error:errorAjax
	});		
}

function cargarMotivo(tipoOpcion) {
	var encuentro;
	
	if($.trim(tipoOpcion) == 'R'){
		encuentro = "MOTIVO_REPROG_PH";
	}else if($.trim(tipoOpcion) == 'C'){
		encuentro = "MOTIVO_CANCEL_PH";
	}
	
	if (encuentro !== "" && encuentro !== undefined){
		$.ajax({
	        url:baseURL + "pages/solicitudPruebasHermeticidad/cargarDatosMaestroColumna",
	        type:'post',
	        async:false,
	        data:{
	            dominio:encuentro
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbMotivoSRC');
	            
	        },
	        error:errorAjax
	    });
	}	    
}
