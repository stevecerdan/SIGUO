var idSolicitudPR="";
var tipoEstadoAux ="";
$(function() {
    initInicioEstadoReprogCancel();
    $('#MensajeValRC').hide();
    $('#btnGuardarRC').click(GuardarEstadoReprogCancel);
});

function convertDateFormat(string) {
    var info = string.split('/');
    return info[1] + '/' + info[0] + '/' + info[2];
}

function initInicioEstadoReprogCancel(){
	confirm.start();
	$( "#txtFechaRC" ).datepicker({ minDate: 0 });
	
	$('#txtFechaRC').click(function() {
		$("#MensajeValRC").hide();
	});
	
	$('#txtObservacionRC').click(function() {
		$("#MensajeValRC").hide();
	});
	
	$('#cmbMotivoRC').click(function() {
		$("#MensajeValRC").hide();
	});

	$('#btnCancelarRC').click(function() {
		//window.location.href = baseURL+'pages/resultadosPruebasHermeticidad';
		$('#dialogFrmEstadoReprogCancel').dialog('close');
        listarSolicitudesPendientesPruebaHermeticidad(0);
    	//listarSolicitudesAtendidasPruebaHermeticidad(0);
	});
}

function verificarDatosSolicitud(id, tipoOpcion){
	idSolicitudPR = id;
	tipoEstadoAux = tipoOpcion;
	cargarMotivo(tipoOpcion);
	if(tipoOpcion=="R") {
		$("#lblFechaRC").text("Fecha Reprogramación (*)");}
}

function validarDatosFrmReprogCancel(){
	
	if($("#txtFechaRC").val() =="" || $('#txtFechaRC').val() == undefined) {
		$('#MensajeValRC').html("POR FAVOR AGREGAR LA FECHA");
        return false;  
    } 
	if($("#cmbMotivoRC").val() == "" || $("#cmbMotivoRC").val() == undefined){
		$('#MensajeValRC').html("POR FAVOR SELECCIONE UN MOTIVO");
		return false;
	}
	return true;
}

function GuardarEstadoReprogCancel(){
	
	if(validarDatosFrmReprogCancel() == true){
		
		//alert('G U A R D A R');	
		if(tipoEstadoAux == 'R'){
   		 confirm.open("¿Esta seguro de registrar la REPROGRAMACION?","registrarTrazabilidadSolicitud(tipoEstadoAux)");
		}else if(tipoEstadoAux == 'C'){
  		 confirm.open("¿Esta seguro de registrar la CANCELACION?","registrarTrazabilidadSolicitud(tipoEstadoAux)");
		}

	}else{
		
        $("#MensajeValRC").show();
        
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
        url:baseURL + "pages/resultadosPruebasHermeticidad/registrarTrazabilidadYcambioEstado",
        type:'post',
        async:false,
        data:{
        	
        	idSolicitudTraz : "",
        	idSolicitudPruebaReprueba : idSolicitudPR,
	        idTipoMotivo 			  :	$('#cmbMotivoRC').val(),
	        observacion 			  : $('#txtObservacionRC').val().latinize().toUpperCase(),
	        fecha     				  : convertDateFormat( $("#txtFechaRC").val() ),
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
            	
                //window.location.href = baseURL+'pages/resultadosPruebasHermeticidad';
            	$('#dialogFrmEstadoReprogCancel').dialog('close');
                listarSolicitudesPendientesPruebaHermeticidad();
            	//listarSolicitudesAtendidasPruebaHermeticidad();
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
	        url:baseURL + "pages/resultadosPruebasHermeticidad/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	            dominio:encuentro
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbMotivoRC');
	            
	        },
	        error:errorAjax
	    });
	}	    
}
