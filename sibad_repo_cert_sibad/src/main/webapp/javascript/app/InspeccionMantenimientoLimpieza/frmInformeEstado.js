

$('#btnRegresarInfo').click(function() {
		
	$('#dialogInfo').dialog('close');
    	
});

function consultarEstado(id, estadoAccion,tipoRevision) {
	
	$.ajax({
	    url:baseURL + "pages/InspMantLimp/ConsultarTrazProgramacion",
	    type:'post',
	    async:false,
	    data:{
	               idProgramacion : id,
	                       estado : estadoAccion
	    },
	    beforeSend:muestraLoading,
	    success:function(data){
            ocultaLoading();
            
            $.each(data.filas, function( index, value ) {
            	
                var resultado;
            	
            	switch (tipoRevision) {
            	    
            	    case "I":
            	    	resultado = "INSPECCIÓN";
            	        break;
            	    case "M":
            	    	resultado = "MANTENIMIENTO";
            	        break;
            	    case "L":
            	    	resultado = "LIMPIEZA";

            	}
          	
            	if(value.estado == 'P'){
            		$('#EstadoInfo').text("PROGRAMADO");
            		$("#FechaUltimoInfo").text(convertDateFormat(value.fechaUltimoEstado));
	        		$('#MotivoInfo').text("REGISTRO PROGRAMADO");
	        		$('#ObservacionInfo').text(" SE REGISTRO UN PROGRAMA DE"+" "+resultado);
	        	}else{
	        		if(value.estado == 'E'){
	            		$('#EstadoInfo').text("EN REGISTRO");
	            		$("#FechaUltimoInfo").text(convertDateFormat(value.fechaUltimoEstado));
	        			$('#MotivoInfo').text("REGISTRO EN PROCESO");
		        		$('#ObservacionInfo').text("EL REGISTRO AÚN NO HA CONCLUIDO");
		        	}else{
		        		if(value.estado == 'F'){
		            		$('#EstadoInfo').text("CONCLUIDO / FINALIZADO");
		            		$("#FechaUltimoInfo").text(convertDateFormat(value.fechaUltimoEstado));
		        			$('#MotivoInfo').text("REGISTRO FINALIZADO - CONCLUIDO");
			        		$('#ObservacionInfo').text("EL REGISTRO DE RESULTADO DE PROGRAMACION HA FINALIZADO ");
			        	}else
			        	   if(value.estado == 'R'){
			        		
			        		     var dominio = "";
						    var idTipoMotivo = value.idTipoMotivo;
						            
			        		dominio = "MOTIVO_REPROGRAM";
			        		
			        		$('#EstadoInfo').text("REPROGRAMADO");
			        		$('#ObservacionInfo').text(value.observacion);
		            		$("#FechaUltimoInfo").text(convertDateFormat(value.fechaUltimoEstado));
			        		
			        		cargarMotivo(dominio,idTipoMotivo);	
			        		
			        	}else
				        	if(value.estado == 'C'){
					        		
				                 var dominio = "";
					            var idTipoMotivo = value.idTipoMotivo;
					            
					        	dominio = "MOTIVO_CANCELACION";
                                $('#EstadoInfo').text("CANCELADO");
    			        		$('#ObservacionInfo').text(value.observacion);
    		            		$("#FechaUltimoInfo").text(convertDateFormat(value.fechaUltimoEstado));

				                cargarMotivo(dominio,idTipoMotivo);		
				            
					       }
		        	}
	        	}

            }); 

	    },
	    error:errorAjax
	});
}


function cargarMotivo(dominio,idTipoMotivo) {
	
	    $.ajax({
	        url:baseURL + "pages/InspMantLimp/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	            dominio:dominio
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            $.each(data.filas, function( index, value ) {
	                
		            if (value.idMaestroColumna == idTipoMotivo){
			           
		            	$('#MotivoInfo').text(value.descripcion);

		            }


	            });
	            
	            
	        },
	        error:errorAjax
	    });
}

function convertDateFormat(string) {
    var info = string.split('-');
    return info[2] + '/' + info[1] + '/' + info[0];
}                