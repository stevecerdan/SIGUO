$(function() {
	initDialogs();
	initInicio();
	cargarMotivo();

	$( "#txtFechaReprogramacion" ).datepicker({ minDate: 0 });

});

function initInicio(){ 
	
	confirm.start();
	
    //$('#btnGuardarReprogramacion').click(function(){
    
    	//confirm.open("¿Desea guardar el registro?","EliminarProgramacion()");
    //});
	
	$('#btnGuardarReprogramacion').click(function(){
	    
    	confirm.open("¿Desea guardar el registro?","ReprogramarProgramacion()");
    });
    
    
    $('#btnCancelarReprogramacion').click(function(){
    	
    	 $('#dialogFrmReprogramacion').dialog('close');
    });
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

function enviarDatosFrmReprogramacion(idProgramacion,estadoReprogramacion,idUnidadSupervisadaR,idCompartimiento,tipoRevision,tipoProgramacion,numeroProgramacion,fechaProgramacion){
	
	$( "#idProgramacion" ).val(idProgramacion);
	$( "#estadoReprogramacion" ).val(estadoReprogramacion);
	$( "#idUnidadSupervisadaR" ).val(idUnidadSupervisadaR);
	$( "#idCompartimiento" ).val(idCompartimiento);
	$( "#tipoRevision" ).val(tipoRevision);
	$( "#tipoProgramacion" ).val(tipoProgramacion);
	$( "#numeroProgramacion" ).val(numeroProgramacion);
	$( "#fechaProgramacion" ).val(fechaProgramacion);

}

function cargarMotivo() {
	
	var dominio ="";
	
	dominio = "MOTIVO_REPROGRAM";
	
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
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#idMotivoReprogramacion');
	            
	        },
	        error:errorAjax
	    });
}

function ReprogramarProgramacion(){
	
	var fReprogramacion = $("#txtFechaReprogramacion").val();      
	
    if(fReprogramacion.length <= 0) {
    	
    	 var addhtml2 = 'Seleccionar Fecha de Reprogramación.';
		 $("#dialog-message-content").html(addhtml2);
		 $("#dialog-message").dialog("open");
		 
         return false;
    }
    
    var idProgramacion = $( "#idProgramacion" ).val();
	var estadoReprogra = $( "#estadoReprogramacion" ).val();
	       var motivo  = $( "#idMotivoReprogramacion" ).val();
	  var observacion  = $( "#txtObservacionReprogramacion" ).val();

	
	 var fReprogramacion = $("#txtFechaReprogramacion").val();
	 var cadena1 = fReprogramacion.split("/");
	 var d1 = cadena1[0];
	 var m1 = cadena1[1];
	 var a1 = cadena1[2];
	 
	 var fechaReprogramacion = m1+"/"+d1+"/"+a1;
	 
	 var fprogramacion =  $( "#fechaProgramacion" ).val();
     var cadena2 = fprogramacion.split("/");
	 var d2 = cadena2[0];
	 var m2 = cadena2[1];
	 var a2 = cadena2[2];
	 
	 var fechaProgramacion = m2+"/"+d2+"/"+a2;
	 
$.ajax({
    url:baseURL + "pages/InspMantLimp/reprogramarCancelar",
    type:'post',
    async:false,
    data:{
    	
    	idProgramacion : idProgramacion,
    	        estado : estadoReprogra,
    	         fecha : fechaReprogramacion,
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
        	        	        estado : estadoReprogra,
        	         fechaUltimoEstado : fechaReprogramacion,
        	                    motivo : motivo,
        	               observacion : observacion,
        	        },
        	        beforeSend:muestraLoading,
        	        success:function(data){
        	            ocultaLoading();
        	            if(data.resultado=="0"){
        	            	
                           mensajeGrowl("sucess", global.confirm.reprog,"");
        	            	
        	            	var idUnidadSupervisada = $("#idUnidadSupervisadaR").val();
        	            	
        	                $('#dialogFrmReprogramacion').dialog('close');
        	                
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


/*function EliminarProgramacion(){
	
	var idProgramacion = $( "#idProgramacion" ).val();
	
	 $.ajax({
	        url:baseURL + "pages/InspMantLimp/EliminarProgramacion",
	        type:'post',
	        async:false,
	        data:{
	        	
	        	idProgramacion : idProgramacion,	        	      
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){
	            	
	            	RegistrarReprogramacion();
	            }
	        },
	        error:errorAjax
		});	
	
}

function RegistrarReprogramacion(){
	
	var fReprogramacion = $("#txtFechaReprogramacion").val();      
	
    if(fReprogramacion.length <= 0) {
    	
    	 var addhtml2 = 'Seleccionar Fecha de Reprogramación.';
		 $("#dialog-message-content").html(addhtml2);
		 $("#dialog-message").dialog("open");
		 
         return false;
    }
    
		var estadoReprogra  =  $( "#estadoReprogramacion" ).val();
		        var motivo  =  $( "#idMotivoReprogramacion" ).val();
		   var observacion  =  $( "#txtObservacionReprogramacion" ).val();
	  var idCompartimiento  =  $( "#idCompartimiento" ).val();
	      var tipoRevision  =  $( "#tipoRevision" ).val();
	  var tipoProgramacion  =  $( "#tipoProgramacion" ).val();
    var numeroProgramacion  =  $( "#numeroProgramacion" ).val();	
       var fReprogramacion  =  $("#txtFechaReprogramacion").val();
	 
    var cadena = fReprogramacion.split("/");
		 var d = cadena[0];
		 var m = cadena[1];
		 var a = cadena[2];
    
		 var fechaReprogramacion = m+"/"+d+"/"+a;	  
		 
		$.ajax({
	          url:baseURL + "pages/InspMantLimp/RegistrarProgramacionIndividual",
	         type:'post',
	        async:false,
	        data:{
	        	
	        	   idCompartimiento : idCompartimiento,
	        cmbUnidadAlmacenamiento : "",
	    		  fechaProgramacion : fechaReprogramacion,
	    		       tipoRevision : tipoRevision,
	    		   tipoProgramacion : tipoProgramacion,
	    		 numeroProgramacion : numeroProgramacion,
	    		             estado : estadoReprogra,
	        	
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            
	            var idProgramacion = data.idProgramacion;
	            
	            if(data.resultado=="0"){
	            	
	            	 $.ajax({
	            	        url:baseURL + "pages/InspMantLimp/RegistrarTrazProgramacion",
	            	        type:'post',
	            	        async:false,
	            	        data:{
	            	        	
	            	        	idProgramacion : idProgramacion,
	            	        	        estado : estadoReprogra,
	            	         fechaUltimoEstado : fechaReprogramacion,
	            	                    motivo : motivo,
	            	               observacion : observacion,
	            	        },
	            	        beforeSend:muestraLoading,
	            	        success:function(data){
	            	            ocultaLoading();
	            	            if(data.resultado=="0"){
	            	            	
	            	            	var idUnidadSupervisada = $("#idUnidadSupervisadaR").val();
	            	            	
	            	                $('#dialogFrmReprogramacion').dialog('close');
	            	                
	            	                listarTanqueCL(0,idUnidadSupervisada);
	            	            }
	            	        },
	            	        error:errorAjax
	            		});	
	            }
	        },
	        error:errorAjax
		});	

}*/