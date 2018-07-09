$(function() {
	
	initDialogs();
	initInicio();
	cargarMotivo();
	
    $( "#txtFechaCancelacion" ).datepicker({ minDate: 0 });
});

function enviarDatosFrmCancelacion(idProgramacion,estadoCancelacion,idUnidadSupervisadaC,fechaProgramacion){
	
	$( "#idProgramacionC" ).val(idProgramacion);
	$( "#estadoCancelacion" ).val(estadoCancelacion);
	$( "#idUnidadSupervisadaC" ).val(idUnidadSupervisadaC);
	$( "#fechaProgramacion" ).val(fechaProgramacion);
}

function initInicio(){ 
	
	confirm.start();
	
    $('#btnGuardarProgramacionCancelada').click(function(){
    
    	confirm.open("¿Desea guardar el registro?","CancelarProgramacion()");
    });
    
    $('#btnCancelarProgramacion').click(function(){
    	
    	 $('#dialogFrmCancelacion').dialog('close');
    });
}   

function cargarCamposCancelacion(idProgramacion){
	
	 $.ajax({
	        url:baseURL + "pages/InspMantLimp/ConsultarTrazProgramacion",
	        type:'post',
	        async:false,
	        data:{
	        	
	        	idProgramacion : idProgramacion,
	        	        
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            	
           	  $.each(data.filas, function( index, value ) {
           		
           		  $("#txtFechaCancelacion").val(value.fechaUltimoEstado);
 	              $("#idMotivoCancelacion option[value="+ value.idTipoMotivo +"]").attr("selected",true); 
 	              $("#txtObservacionCancelacion").val(value.observacion);
 	                  
           	  });	

	        },
	        error:errorAjax
	});	
}

function bloquearDesbloquearCamposCancelacion(Rpt){
	  
	  if(Rpt == 'HABILITAR'){
	      
	      $("#txtFechaCancelacion").attr('disabled',false);
          $("#idMotivoCancelacion").attr('disabled',false);
          $("#txtObservacionCancelacion").attr('disabled',false);
          $("#btnGuardarProgramacionCancelada").attr('disabled', false);
	    	      	 
	  }else if(Rpt == 'DESHABILITAR'){
		 		  
		  $("#txtFechaCancelacion").attr('disabled','disabled');
          $("#idMotivoCancelacion").attr('disabled','disabled');
          $("#txtObservacionCancelacion").attr('disabled','disabled');
          $("#btnGuardarProgramacionCancelada").attr('disabled', 'disabled');
		  
	  }
}

function initDialogs() {
	  
	$("#dialog-message").dialog({
		
		modal : true,
		autoOpen : false,
		buttons : {
			'Ok' : {
		        text : 'Ok',
		        id : 'button-id',
		        click : function(){
		        	$(this).dialog("close");
		        }
		    } 
		}
	});
}

function CancelarProgramacion(){
	
	var fCancelacion = $("#txtFechaCancelacion").val();      
		
    if(fCancelacion.length <= 0) {
    	
    	 var addhtml2 = 'Seleccionar Fecha de Cancelación.';
		 $("#dialog-message-content").html(addhtml2);
		 $("#dialog-message").dialog("open");
		 
         return false;
    }

	   var idProgramacion = $( "#idProgramacionC" ).val();
	var estadoCancelacion = $( "#estadoCancelacion" ).val();
	          var motivo  = $( "#idMotivoCancelacion" ).val();
	     var observacion  = $( "#txtObservacionCancelacion" ).val();

	
	 var fCancelacion = $("#txtFechaCancelacion").val();
	 
	 var cadena1 = fCancelacion.split("/");
	 
	 var d1 = cadena1[0];
	 var m1 = cadena1[1];
	 var a1 = cadena1[2];
	 
	 var fechaCancelacion = m1+"/"+d1+"/"+a1;
	 
	 var fProgramacion =$( "#fechaProgramacion" ).val();
	 
	 var cadena2 = fProgramacion.split("/");
	 	
	 	var d2 =  cadena2[0];
	 	var m2 =  cadena2[1];
	 	var a2 =  cadena2[2];
	 	
	 	var fechaProgramacion = m2+"/"+d2+"/"+a2;

$.ajax({
    url:baseURL + "pages/InspMantLimp/reprogramarCancelar",
    type:'post',
    async:false,
    data:{
    	
    	idProgramacion : idProgramacion,
    	        estado : estadoCancelacion,
    	         fecha : fechaProgramacion,
    },
    beforeSend:muestraLoading,
    success:function(data){
        ocultaLoading();
        
        if(data.resultado=="0"){
        	 
        	 $.ajax({
        	        url:baseURL + "pages/InspMantLimp/RegistrarTrazProgramacion",
        	        type:'post',
        	        async:false,
        	        data:{
        	        	
        	        	idProgramacion : idProgramacion,
        	        	        estado : estadoCancelacion,
        	         fechaUltimoEstado : fechaCancelacion,
        	                    motivo : motivo,
        	               observacion : observacion,
        	        },
        	        beforeSend:muestraLoading,
        	        success:function(data){
        	            ocultaLoading();
        	            if(data.resultado=="0"){
        	            	
                           mensajeGrowl("sucess", global.confirm.cancel,"");
        	            	
        	            	var idUnidadSupervisada = $("#idUnidadSupervisadaC").val();
        	            	
        	                $('#dialogFrmCancelacion').dialog('close');
        	                
        	                listarTanqueCL(0,idUnidadSupervisada);
        	            }
        	        },
        	        error:errorAjax
        		});	

        }
    },
    error:errorAjax
});	
	
}

function cargarMotivo() {
	
	var dominio ="";
	
	dominio = "MOTIVO_CANCELACION";
	
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
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#idMotivoCancelacion');
	            
	        },
	        error:errorAjax
	    });
}
