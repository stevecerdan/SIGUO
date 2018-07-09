var etd = "";
$(function() {
    initInicioConfirmar();
    
});

function initInicioConfirmar(){ 
	confirm.start();
	
    $('#btnAceptar').click(function(){
    	window.location.href = baseURL+'pages/repruebasCilindroGNV';
        listarRepruebas(0);
    });
    
 }

function cargarDatos(estado, idAux){
	etd= estado;
	//alert(estado + " - " +  idAux);

	if (estado == 'PROGRAMADO')
		estado = 'P';
	if (estado == 'REPROGRAMADO')
		estado = 'R';
	if (estado == 'CANCELADO')
		estado = 'C';
	if (estado == 'EN REGISTRO')
		estado = 'E';
	if (estado == 'CONCLUIDO')
		estado = 'F';

	$('#solicitudes').hide();
	TraerInformacion(estado, idAux);
}

function TraerSolicitudes(contenido){
	$('#txtSolicitudes').val(contenido);
}

function TraerInformacion(estado , id) {
	
	$.ajax({
	    url:baseURL + "pages/repruebasCilindroGNV/cargarInforme",
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
	        	//alert('Usted ha borrado el registro de trazabilidad');				
	        }else{
	        	var tex="";
		        $.each(data.filas, function( index, value ) {
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

		        	tex = '<span class="ui-panel-title" style="font-size:13px;color: #008cd9;" id="EstadoAccionT">ESTADO DE LA &Uacute;LTIMA ACCI&Oacute;N</span><p>';
		        	tex = tex + '<span class="ui-panel-title" style="font-size:13px;" id="EstadoAccionInfo">'+ etd +'</span><br><br>';
	                
	                if(value.idTipoMotivo !== null && value.idTipoMotivo !== undefined){
			        	tex = tex + '<span class="ui-panel-title" style="font-size:13px;color: #008cd9;">MOTIVO</span><p>';
			        	tex = tex + '<span class="ui-panel-title" style="font-size:13px;">'+ describirMotivo(value.idTipoMotivo) +'</span><br><br>';
			        }

			        if( value.observacion !== null && value.observacion !== undefined ){
			        	tex = tex + '<span class="ui-panel-title" style="font-size:13px;color: #008cd9;">OBERVACION</span><p>';
			        	tex = tex + '<span class="ui-panel-title" style="font-size:13px;">'+ value.observacion +'</span><br><br>';
			        }

		        	tex = tex + '<span class="ui-panel-title" style="font-size:13px;color: #008cd9;">FECHA DE CAMBIO DE ESTADO</span><p>';
		        	tex = tex + '<span class="ui-panel-title" style="font-size:13px;">'+ fechaUEst +'</span><br><br>';		        
		        });
		        $("#solicitudesMain").append(tex);
	        }
	    },
	    error:errorAjax
	});
}

function describirMotivo(mot) {
	var mtvo = "";
	    $.ajax({
	        url:baseURL + "pages/repruebasCilindroGNV/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	            idMaestroColumna :mot
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            $.each(data.filas, function( index, value ) {
	            	mtvo = value.descripcion;
	            });
	        },
	        error:errorAjax
	    });
	    return mtvo;
}