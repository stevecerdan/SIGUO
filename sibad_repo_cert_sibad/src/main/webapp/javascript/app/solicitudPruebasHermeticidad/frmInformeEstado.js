//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------

$(function() {
	initInicioInformacionEstado(); 
	//$('#btnGuardar').click(btnGuardar);
	//boton.closeDialog();
});

function initInicioInformacionEstado(){
	confirm.start();
	
	$('#btnRegresarInfoS').click(function(){
		
		$('#dialogInfoEstado').dialog('close');
	
    });
}

function cargarDatosInformacionEstado(id,estado){

	var estS;
	
	$('#IDalcance').val(id);
	
	if(estado=='P'){
		estS = "PROGRAMADO";
	}
	if(estado=='R'){
		estS = "REPROGRAMADO";
	}
	if(estado=='E'){
		estS = "EN REGISTRO";
	}
	if(estado=='C'){
		estS = "CANCELADO";
	}
	if(estado=='I'){
		estS = "PRUEBA CONCLUIDA";
	}
	if(estado=='F'){
		estS = "FINALIZADO";
	}
	
	$('#EstadoInfoS').html(estS);
	//cargarDatos();
	TraerInformacionEstado(id, estado);
}

//TRAER DATOS DE TRAZABILIDAD PARA INFORMACION
function TraerInformacionEstado(id, estado) {
	
	$.ajax({
	    url:baseURL + "pages/solicitudPruebasHermeticidad/cargarInformeEstadoSolicitud",
	    type:'post',
	    async:false,
	    data:{
	        idSolicitudPruebaReprueba :id,
	        estado :estado
	    },
	    beforeSend:muestraLoading,
	    success:function(data){
	    	
	        ocultaLoading();
	        
	        if(data.filas!="[object Object]"){
	        	
	        	alert('Usted ha borrado el registro de trazabilidad');
				
	        }else{
	        
	        $.each(data.filas, function( index, value ) {
	        	
	        	var mot;
	        	
	        	if(value.estado == 'P'){
	        		$('#MotivoInfoS').html("SOLICITUD DE PRUEBA DE HERMETICIDAD PROGRAMADA");
	        		$('#ObservacionInfoS').html("ACTUAL REGISTRO DE UNA SOLICITUD DE PRUEBA DE HERMETICIDAD");
	        	}else{
	        		if(value.estado == 'E'){
	        			$('#MotivoInfoS').html("RESULTADO DE SOLICITUD EN REGISTRO");
		        		$('#ObservacionInfoS').html("LA SOLICITUD DE PRUEBA DE HERMETICIDAD EN PROCESO");
		        	}else{
		        		if(value.estado == 'I'){
		        			$('#MotivoInfoS').html("REGISTRO DE RESULTADO DE SOLICITUD CONCLUIDA");
			        		$('#ObservacionInfoS').html("LA SOLICITUD DE PRUEBA DE HERMETICIDAD YA A SIDO ATENDIDA");
			        	}else{
			        		if(value.estado == 'F'){
			        			$('#MotivoInfoS').html("REGISTRO FINALIZADO");
				        		$('#ObservacionInfoS').html("LA SOLICITUD DE PRUEBA DE HERMETICIDAD A FINALIZADO CON EXITO");
				        	}else{
				        		//$('#MotivoInfo').html(value.idTipoMotivo);
				        		mot = value.idTipoMotivo;
				        		describirMotivo(mot);
					        	$('#ObservacionInfoS').html(value.observacion);
				        	}
			        	}
		        	}
	        	}
	        	
	        	var FUE = value.fechaUltimoEstado;
	        	
	        	var f1=new Date(FUE);
	        	
	        	if(f1.getDate() < 10){
	    			var diaf1 = '0' + f1.getDate();
	    		}else{
	    			var diaf1 = f1.getDate();
	    		}
	    		if((f1.getMonth()+1) < 10){
	    			var mesf1 = '0' + (f1.getMonth() + 1);
	    		}else{
	    			var mesf1 = f1.getMonth() + 1;
	    		}
	    		
	    		var time = f1.toTimeString()
	    		time = time.split(' ')[0];
	    		
	    		var fechaUEst = diaf1 + '/' + mesf1 + '/' + f1.getFullYear() + " HORA: "+time;
	    		
	    		$('#FechaUltimoInfoS').html(fechaUEst);
	        });
	        }
	    },
	    error:errorAjax
	});
}

function describirMotivo(mot) {
	
	    $.ajax({
	        url:baseURL + "pages/solicitudPruebasHermeticidad/cargarDatosMaestroColumna",
	        type:'post',
	        async:false,
	        data:{
	            idMaestroColumna :mot
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            $.each(data.filas, function( index, value ) {
	            	$('#MotivoInfoS').html(value.descripcion);
	            });
	        },
	        error:errorAjax
	    });
}
