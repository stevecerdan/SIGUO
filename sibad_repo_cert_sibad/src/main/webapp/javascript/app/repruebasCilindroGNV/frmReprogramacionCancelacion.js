var idSolicitudAux="";
var tipoAux ="";
$(function() {
    confirm.start();
    initInicio(); 
});

function convertDateFormat(string) {
    var info = string.split('/');
    return info[1] + '/' + info[0] + '/' + info[2];
}

function initInicio(){
    confirm.start();
	$( "#txtFechaCancelacion" ).datepicker({ minDate: 0 });

	$('#btnCancelarProgramacion').click(function() {
        $('#dialogFrmReprogramacionCancelacion').dialog('close');
	});

	$('#btnGuardarProgramacion').click(function() {
        btnGuardar();
    }); 
}

function verificarDatos(id, tipoOp){
	idSolicitudAux = id;
	tipoAux = tipoOp;
	cargarMotivo(tipoOp);
	if(tipoOp=="R") 
		$("#lblFecha").text("Fecha Reprogramación (*)");
}

function btnGuardar(){
	
	if($('#idMotivoCancelacion').val() !== null && $('#idMotivoCancelacion').val() !==""){
		if($('#txtObservacionCancelacion').val() !== null && $('#txtObservacionCancelacion').val() !== "") {


			if(tipoAux == 'R'){
            	confirm.open('¿Esta seguro de REPROGRAMAR?',"registrarPhgTrazSolicitud('R')");
			}else if(tipoAux == 'C'){
           		confirm.open('¿Esta seguro de CANCELAR?',"registrarPhgTrazSolicitud('C')");
			}

		}else{
			alert("Describa una observacion");
		}
	}else{
		alert("Seleccione un motivo");
	}
	
	
}

function cargarMotivo(tipoOp) {
	var encuentro;
	
	if($.trim(tipoOp) == 'R'){
		encuentro = "MOTIVO_REPROGRAMAR";
	}else if($.trim(tipoOp) == 'C'){
		encuentro = "MOTIVO_CANCELAR";
	}
	
	if (encuentro !== "" && encuentro !== undefined){
		$.ajax({
	        url:baseURL + "pages/repruebasCilindroGNV/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	            dominio:encuentro
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#idMotivoCancelacion');
	            
	        },
	        error:errorAjax
	    });
	}	    
}

function registrarPhgTrazSolicitud(estadoaux) {
	var fechaA = new Date();

	var month = fechaA.getMonth()+1;
	var day = fechaA.getDate();

	var output =(month<10 ? '0' : '') + month + '/' +	 
				(day<10 ? '0' : '') + day + '/' +
			    fechaA.getFullYear();

	output = output + " " +  fechaA.getHours() +":"+fechaA.getMinutes();
	
	$.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/registrarPhgTrazSolicitud",
        type:'post',
        async:false,
        data:{
        	
        	idSolicitudTraz : "",
        	idSolicitudPruebaRp : 	idSolicitudAux,
	        idTipoMotivo:  			 $('#idMotivoCancelacion').val(),
	        observacion:			 $('#txtObservacionCancelacion').val().toUpperCase(),
	        fecha:               	 convertDateFormat( $("#txtFechaCancelacion").val() ),
        	estado: 			 	 estadoaux
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	if (estadoaux == 'R') 
            		mensajeGrowl("success", global.confirm.reprog, "");
            	else
            		mensajeGrowl("success", global.confirm.cancel, "");
            		
                listarRepruebas("",idunidadSupervisadaAux);
                $('#dialogFrmReprogramacionCancelacion').dialog('close');
            }
        },
        error:errorAjax
	});		
}