//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------

var avisoInfo = "";

$(function() {
	initInicioInformacion(); 
	//$('#btnGuardar').click(btnGuardar);
	//boton.closeDialog();
});

function initInicioInformacion(){
	confirm.start();
	
	$('#btnRegresarInfo').click(function(){
		//$('#dialogNuevaEmpresaAcreditada').dialog('close');
		
		if(avisoInfo == "E"){
			window.location.href = baseURL+'pages/mantenimientoEmpresasAcreditadas';
			//listarEmpresasAcreditadas(0);
		}else{
			$('#dialogInfo2').dialog('close');
		}
		
    });
}

function cargarDatosInformacion(id,estadoAccion,avi){

	var estA;
	
	avisoInfo = avi;
	
	$('#IDalcance').val(id);
	if(estadoAccion=='R'){
		estA = "REGISTRADO";
	}
	if(estadoAccion=='S'){
		estA = "SUSPENDIDO";
	}
	if(estadoAccion=='H'){
		estA = "HABILITADO";
	}
	if(estadoAccion=='C'){
		estA = "CANCELADO";
	}
	if(estadoAccion=='V'){
		estA = "VENCIDO";
	}
	$('#EstadoAccionInfo').html(estA);
	//cargarDatos();
	TraerInformacion(id, estadoAccion);
}

//TRAER DATOS DE TRAZABILIDAD PARA INFORMACION
function TraerInformacion(id, estadoAccion) {
	
	$.ajax({
	    url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarInforme",
	    type:'post',
	    async:false,
	    data:{
	        idAlcanceAcreditacion :id,
	        estadoAccion :estadoAccion
	    },
	    beforeSend:muestraLoading,
	    success:function(data){
	    	
	        ocultaLoading();
	        
	        if(data.filas!="[object Object]"){
	        	
	        	alert('Usted ha borrado el registro de trazabilidad');
				
	        }else{
	        
	        $.each(data.filas, function( index, value ) {
	        	
	        	var mot;
	        	
	        	if (value.estado=="A"){
	        		$('#EstadoInfo').html("VIGENTE");
	        	}else{
	        		$('#EstadoInfo').html("NO VIGENTE");
	        	}
	        	
	        	if(value.estadoAccion == 'R'){
	        		$('#MotivoInfo').html("NUEVO REGISTRO");
	        		$('#ObservacionInfo').html("ACTUAL REGISTRO DE UN PROCESO DE ACREDITACI&Oacute;N");
	        	}else{
	        		if(value.estadoAccion == 'V'){
	        			$('#MotivoInfo').html("REGISTRO VENCIDO");
		        		$('#ObservacionInfo').html("EL PROCESO DE ACREDITACI&Oacute;N ALCANZO SU &Uacute;LTIMO D&Iacute;A DE VIGENCIA");
		        	}else{
		        		//$('#MotivoInfo').html(value.idTipoMotivo);
		        		mot = value.idTipoMotivo;
		        		describirMotivo(mot);
			        	$('#ObservacionInfo').html(value.observacion);
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
	    		
	    		$('#FechaUltimoInfo').html(fechaUEst);
	        });
	        }
	    },
	    error:errorAjax
	});
}

function describirMotivo(mot) {
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	            idMaestroColumna :mot
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            $.each(data.filas, function( index, value ) {
	            	$('#MotivoInfo').html(value.descripcion);
	            });
	        },
	        error:errorAjax
	    });
}
