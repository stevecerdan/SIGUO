var arrayIdDocumentA       =  [];
var dataPersonaN           =  [];
var dataSolicitud          =  [];
var dataFechaProx          =  [];
var arrayIdPersonaN        =  [];
var EditarRpersonal        =  [];
var txtNumInforme          =  "";
var txtFechaInforme        =  "";
var txtIdPersonaJuridica   =  "";
var txtIdDocumento         =  "";
var txtflagPersona         =  "";
var txtIdInfoIndiceRiesgo  =  "";

$(function() {
    
	$( "#txtFechaInforme" ).datepicker();  
		
	initInicio();
	initDialogs();
	
});

function initInicio(){
    confirm.start();
	
	$('#btnNuevaPers').click(function(){   
		
		var idPersonaNatural = "";
    	abrirInspectorAutorizadoA(idPersonaNatural);  		
  		estado = "NUEVA_PERSONA";  		
  		nuevoPersonalAutorizado(estado);
    });
	
	$('#btnGuardarRegistro').click(function(){  
					
	 var NumInforme =$("#txtNumInforme").val();
	    
	   if(NumInforme.length <= 0) {
	    	
		    var addhtml2 = 'Ingrese un Número de Informe.';
			$("#dialog-message-content").html(addhtml2);
			$("#dialog-message").dialog("open");
			 
			return false;
	    }
	   
	var FechaInforme =$("#txtFechaInforme").val();
	    
	   if(FechaInforme.length <= 0) {
	    	
		    var addhtml2 = 'Ingrese una Fecha de Informe.';
			$("#dialog-message-content").html(addhtml2);
			$("#dialog-message").dialog("open");
			 
			return false;
	    }
	   
	 if (arrayIdDocumentA.length <= 0) {
			
		    var addhtml2 = 'Seleccione un Documento Adjunto.';
			$("#dialog-message-content").html(addhtml2);
			$("#dialog-message").dialog("open");
		 
           return false;
	 }
	 
	 var cmbTipoPersonal = $("#cmbTipoPersonal").val();
     
	     if(cmbTipoPersonal == 0) {
	        
	          var addhtml2 = 'Seleccione un Tipo de Personal.';
	          $("#dialog-message-content").html(addhtml2);
	          $("#dialog-message").dialog("open");
	       
	        return false;
	      
	      }  else {
         	  
          	if(cmbTipoPersonal == 1) {
          		
          		if (dataPersonaN.length <= 0) {
             		 
             		var addhtml2 = 'Agregar persona que elaboró el Informe.';
          		    $("#dialog-message-content").html(addhtml2);
          			$("#dialog-message").dialog("open");
          			 
          	        return false;
                 } 
          		
          	} else if(cmbTipoPersonal == 2) {
       	    
          	  var txtIdPersonaJuridica = $("#txtIdPersonaJuridica").val();
        	  
	              	if(txtIdPersonaJuridica.length <= 0) {
	                	   	
	               	   	 var addhtml2 = 'Ingrese RUC.';
	               		 $("#dialog-message-content").html(addhtml2);
	               		 $("#dialog-message").dialog("open");
	               			 
	               	     return false;
	               	 }
       	   
       	    
	              	if (dataPersonaN.length <= 0) {
	            		 
	                    var addhtml2 = 'Agregar persona que elaboró el Informe.';
           			    $("#dialog-message-content").html(addhtml2);
           			    $("#dialog-message").dialog("open");
	             			 
	             	        return false;
	                 } 
          	   }
            } 
	     
	     if (dataFechaProx.length <= 0) {
     		 
      		var addhtml2 = 'Agregar una Fecha Próx. Prueba de Hermeticidad a una solicitud.';
   		    $("#dialog-message-content").html(addhtml2);
   			$("#dialog-message").dialog("open");
   			 
   	        return false;
          }
		
    	confirm.open("¿Desea crear el informe de Índice de riesgos, asociando las pruebas de hermeticidad realizadas ?","informeIndiceRiesgos()");

     });
	
	 $('#btnValidarRUC').click(function(){
       
		if ( $('#txtRuc').val().length == 11 ){
            cargarDatosRuc();
        }            
	 });
	 
	 $('body').on('click', '.eliminarDoc',function(){
    
		   var idDocumento = $(this).attr("id");
		  
           confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarDoc('" + idDocumento + "')");
     });
	 
     $("#uploadfile").change(function(){
		 
		var filename = $("#uploadfile")[0].files[0];
	    $('#nombreArchivo').text(filename.name);

        confirm.open("¿ Desea guardar el registro ?","registrarDoc()");
    });
	
	$('#btnRegresar').click(function(){  
		
	    $('#dialogNuevoInformeRiesgo').dialog('close');
    });	 
	
	$('body').on('click', '#registroRV',function(){
		    
	    $('#dialogNuevoInformeRiesgo').dialog('close');
	    listarBandejaInformeIndiceRiesgo(0);
	    tab('tab_02','panel_02');
	});
};

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
	
	$("#dialog-message_registroRV").dialog({
		
		modal : true,
		autoOpen : false,
		maxWidth: "550px",
		buttons : {
			'Ok' : {
		        text : 'Aceptar',
		        id : 'registroRV',
		        click : function(){
		        	$(this).dialog("close");
		        }
		    },
		    close: function (event, ui) {
	            $(this).remove();
	            $('#dialogNuevoInformeRiesgo').dialog('close');
			    listarBandejaInformeIndiceRiesgo(0);
			    tab('tab_02','panel_02');
	            
	        }
		}
	});
}

function estadoRegistro(estado, idInformeIndiceRiesgo){
	
    $("#txtEstado").val(estado);
	
    if(estado == "CONSULTAR"){
		
    	cargarCamposInformeIndiceRiesgo(idInformeIndiceRiesgo);

	} else if(estado == "NUEVO"){
		
			listarSolicitudes(0);
	}
}

function bloquearDesbloquearCampos(Rpt){
	
	if(Rpt == 'DESHABILITAR'){		  
		  
		  $("#txtNumInforme").attr('disabled','disabled');
		  $("#txtFechaInforme").attr('disabled','disabled');
		  $("#uploadfile").css({pointerEvents: "none"});
		  $("#cmbTipoPersonal").css({pointerEvents: "none"});
		  $("#btnNuevaPers").css({pointerEvents: "none"});
		  $("#btnGuardarRegistro").attr('disabled','disabled');
		  		  
	  }
	
}

function cargarCamposInformeIndiceRiesgo(idInformeIndiceRiesgo){
	 
	$.ajax({
		 
        url:baseURL + "pages/solicitudPruebasHermeticidad/listarInformeIndiceRiesgo",
       type:'post',
       async:false,
       data:{
    	   idInformeIndiceRiesgo : idInformeIndiceRiesgo,
    	     
       },
       beforeSend:muestraLoading,
       success:function(data){
           ocultaLoading();
        
           $.each(data.filas, function(index, value){
        	   
        	   $("#txtNumInforme").val(value.numeroInformeIndiceRiesgo);
        	   $("#txtFechaInforme").val(convertirFecha(value.fechaInformeIniceRiesgo));
        	   
        	   consultarDocumentoAdjunto(value.idDocumentoAdjunto);  
        	   consultarSolicitudes(value.idInformeIndiceRiesgo)
        	   
        	   if(value.flagPersona == "J"){
              	 
	         		 var vOption = "2";
	              	 llenarArrayTbPersonaNatural(value.idInformeIndiceRiesgo);
	              	 var IdPJ =value.idPersonaJuridica;
	              	 
	              	 if(IdPJ !== null){
		               
		                 listarPersonaJuridica(value.idPersonaJuridica);
	                   }
	
	             	 $('#cmbTipoPersonal option[value="'+ vOption +'"]').attr("selected", true);
	
	             	 $("#personaN").show();
	      		     $("#empresaJ").show();
	      		     $('#cmbTipoPersonal').show();
	
	          		  
	            } else if(value.flagPersona == "N") {
	          		  
	          		  var vOption = "1";
	               	  var IdPJ =value.idPersonaJuridica;
	               	  llenarArrayTbPersonaNatural(value.idInformeIndiceRiesgo);
	               	  
	          		  if(IdPJ !== null){
	          			  
	                  	  listarPersonaJuridica(value.idPersonaJuridica);
	                   }
	          		  
	                  $('#cmbTipoPersonal option[value="'+ vOption +'"]').attr("selected", true);
	
	          		  $("#personaN").show();
	       		      $("#empresaJ").hide();
	       		      $('#cmbTipoPersonal').show();
	
	          	  }

      	  
           });
           
       },
       error:errorAjax
   }); 
	
}

function consultarSolicitudes(idInformeIndiceRiesgo){

	$.ajax({
		 
        url: baseURL + "pages/solicitudPruebasHermeticidad/consultarSolicitudes",
       type:'post',
       async:false,
       data:{
    	   idInformeIndiceRiesgo : idInformeIndiceRiesgo,
    	     
       },
       beforeSend:muestraLoading,
       success:function(data){
           ocultaLoading();
        
           $.each(data.filas, function(index, value){
        	   
        	   var objeto = {};
	        	 
				 objeto['nroSolicitudUnidadSupervisa'] = value.nroSolicitudUnidadSupervisa;
				 objeto['numeroTanque'] = value.numeroTanque;
				 objeto['numeroCompartimiento'] = value.numeroCompartimiento;
				 objeto['fechaSolicitud'] =  value.fechaSolicitud; 
				 objeto['fechaProxPrueba'] =  value.fechaProximaPrueba;
		  			    			  
				 dataSolicitud.push(objeto);
				 
				 listarSolicitudLocal(0);
				 listarSolicitudLocal(0);
        	        	                 	          
           });
           
       },
       error:errorAjax
   }); 

}

function consultarDocumentoAdjunto(idDocumentoAdjunto){
	
	$.ajax({
		 
        url:baseURL + "pages/solicitudPruebasHermeticidad/consultarDocumentoAdjunto",
       type:'post',
       async:false,
       data:{
    	   idDocumentoAdjunto : idDocumentoAdjunto,
    	     
       },
       beforeSend:muestraLoading,
       success:function(data){
           ocultaLoading();
        
           $.each(data.filas, function(index, value){
        	   
        	   $("#nombreArchivo").text(value.nombreDocumento);
        	        	                 	          
           });
           
       },
       error:errorAjax
   }); 
}

function convertirFecha(f){

    var dateVar = f;
    var d=new Date(dateVar);
            
    if(dateVar != null){
            
        if(d.getDate() < 10){
            var dia = '0' + d.getDate();
        }else{
            var dia = d.getDate();
        }
               
        if((d.getMonth()+1) < 10){
            var mes = '0' + (d.getMonth() + 1);
        }else{
            var mes = d.getMonth() + 1;
        }
                
        var fecha = dia + '/' + mes + '/' + d.getFullYear();
                
    }else{
        var fecha = '--/--/----';
    }
  
    return fecha;
} 

 
function convertDateFormat(string) {
	
	var info = string.split('/');
	return info[1] + '/' + info[0] + '/' + info[2];	
}

function informeIndiceRiesgos(){

	     txtNumInforme    =   $('#txtNumInforme').val();
	     txtFechaInforme  =   convertDateFormat( $('#txtFechaInforme').val() );
	 txtIdPersonaJuridica =   $('#txtIdPersonaJuridica').val();
	       txtflagPersona =   $('#txtflagPersona').val();
    	   txtIdDocumento =   $('#txtIdDocumento').val();
  	          	  
    	 $.ajax({
    		 
	        url:baseURL + "pages/solicitudPruebasHermeticidad/informeIndiceRiesgos",
	        type:'post',
	        async:false,
	        data:{
	        	
	        idInformeIndiceRiesgo : txtIdInfoIndiceRiesgo,
	        	       numInforme : txtNumInforme,
	        	     fechaInforme : txtFechaInforme,
	        	idPersonaJuridica : txtIdPersonaJuridica,
	        	      idDocumento : txtIdDocumento,
	        	      flagPersona : txtflagPersona,
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	  	          ocultaLoading();
                 	         	            
				if(data.resultado=="0"){
                      
	            	txtIdInfoIndiceRiesgo = data.idInformeIndiceRiesgo;

	            	if (arrayIdPersonaN.length > 0) {
	            		informePersonaNatural(txtIdInfoIndiceRiesgo);
	        		}
	        		
	            	if (dataFechaProx.length > 0){	            		
	            		informeSolicitudPrueba(txtIdInfoIndiceRiesgo);
	            	}
	        		 
	            }
				
				/*$('#dialogNuevoInformeRiesgo').dialog('close');
			    listarBandejaInformeIndiceRiesgo(0);
			    tab('tab_02','panel_02');*/
	             			   
				var addhtml2 = 'Se ha Generado el Informe de Índice de riesgos.';
				$("#dialog-message-content_registroRV").html(addhtml2);		   
				$("#dialog-message_registroRV").dialog("open");
				 
		        return false;

	        },
	        error:errorAjax
	    });  
}

function informePersonaNatural(idInfoIndiceRiesgo){
	
	$.each(arrayIdPersonaN, function(index,value){
	
	    var idPersonaNatural = value ;
		
		$.ajax({
			 
	        url:baseURL + "pages/solicitudPruebasHermeticidad/informePersonaNatural",
	        type:'post',
	        async:false,
	        data:{
	        	
	      idInformePersonaNatural :"",
	        idInformeIndiceRiesgo : idInfoIndiceRiesgo,
	             idPersonaNatural : idPersonaNatural,
	        	     
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	         
	            if(data.resultado=="0"){
	                  	                               	              
	            }
	            
	        },
	        error:errorAjax
	    });  
	});
}

function informeSolicitudPrueba(idInfoIndiceRiesgo){
	
	$.each(dataFechaProx, function(index,value){
		
		$.ajax({
			 
	        url:baseURL + "pages/solicitudPruebasHermeticidad/informeSolicitudPrueba",
	        type:'post',
	        async:false,
	        data:{
	        	
	       idInformeSolicitudPrueba : "",
	      idSolicitudPruebaReprueba : value.idSolicitudPruebaReprueba,
	                fechaProxPrueba : value.fechaProxPrueba,
	          idInformeIndiceRiesgo : idInfoIndiceRiesgo,
	        	     
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	         
	            if(data.resultado=="0"){
	                  	          
	            	resultadoPruebaReprueba(value.idResultadoPruebaReprueba,value.fechaProxPrueba);
	            	solicitudPruebaReprueba(value.idSolicitudPruebaReprueba);
	            	compartimiento(value.idCompartimiento,value.fechaProxPrueba);
	            }
	            
	        },
	        error:errorAjax
	    }); 
	});
}

function resultadoPruebaReprueba(idResultadoPruebaReprueba, fechaProxPrueba){
	
	$.ajax({
		 
         url: baseURL + "pages/solicitudPruebasHermeticidad/resultadoPruebaReprueba",
        type:'post',
        async:false,
        data:{
 
        	idResultadoPruebaReprueba : idResultadoPruebaReprueba,
                      fechaProxPrueba : fechaProxPrueba,
        	     
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
         
            if(data.resultado=="0"){
                  	          
            }
            
        },
        error:errorAjax
    }); 
}

function solicitudPruebaReprueba(idSolicitudPruebaReprueba){

	$.ajax({
		 
        url:baseURL + "pages/solicitudPruebasHermeticidad/solicitudPruebaReprueba",
       type:'post',
       async:false,
       data:{

    	   idSolicitudPruebaReprueba : idSolicitudPruebaReprueba,
                              estado : "F",
             flagInformeIndiceRiesgo : "S",
       	     
       },
       beforeSend:muestraLoading,
       success:function(data){
           ocultaLoading();
        
           if(data.resultado=="0"){
                 	          
           }
           
       },
       error:errorAjax
   }); 

}

function compartimiento(idCompartimiento,fechaProxPrueba){
	
	$.ajax({
		 
        url:baseURL + "pages/solicitudPruebasHermeticidad/compartimiento",
       type:'post',
       async:false,
       data:{
    	        idCompartimiento : idCompartimiento,
                 fechaProxPrueba : fechaProxPrueba,      	     
       },
       beforeSend:muestraLoading,
       success:function(data){
           ocultaLoading();
        
           if(data.resultado=="0"){
                 	          
           }
           
       },
       error:errorAjax
   }); 

}

function eliminarDoc(idDocumentoAdjunto){
	
	var index = arrayIdDocumentA.indexOf(idDocumentoAdjunto);

	arrayIdDocumentA.splice(index, 1);

    $('#txtIdDocumento').val("");

	eliminarDocumentoAdjunto(idDocumentoAdjunto);
}

function eliminarDocumentoAdjunto(idDocumentoAdjunto){
 	  
	  $.ajax({
	        url:baseURL + "pages/solicitudPruebasHermeticidad/eliminarDocumentoAdjunto",
	        type:'post',
	        async:false,
	        data:{
	        	
	        	idDocumentoAdjunto: idDocumentoAdjunto
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){

		             $("#tbl_documentos tr").remove();

	            }else{
	              

	            }
	        },
	        error:errorAjax
	    });
}

$('body').on('click', '.filaSeleccionada',function(){
    
          var cadena= $(this).attr("id");
    var arrayCadena = cadena.split("%");
    
    var idSolicitudPruebaReprueba = arrayCadena[0];
    var idResultadoPruebaReprueba = arrayCadena[1];
             var idCompartimiento = arrayCadena[2];
    
    if(this.checked == true){
    	
    	 abrirProxPruebaHermeticidad();
    	 enviarIDs(idSolicitudPruebaReprueba,idResultadoPruebaReprueba,idCompartimiento);
   	     
    	 $(".filaSeleccionada").prop('checked', false);
  	 
    	 $( "#button-id").children().addClass( "button-ok" );
     	 $( "#registroRV").children().addClass( "button-ok" );
     	 $( ".button-ok").css({display: "block"});
  	  	 	            
     }else if(this.checked == false){
      
 		 eliminarDataSolicitud(idSolicitudPruebaReprueba);
 		 eliminarDataFechaProx(idSolicitudPruebaReprueba);
      }
   
  });

function eliminarDataSolicitud( idSolicitudPruebaReprueba ) {

	   for (var i in dataSolicitud) {
		 
	     if (dataSolicitud[i].idSolicitudPruebaReprueba == idSolicitudPruebaReprueba) {
	    	
	    	 dataSolicitud[i].fechaProxPrueba = "";
	  
	    	 break;
	     }
	   }	  
}

function eliminarDataFechaProx( idSolicitudPruebaReprueba ) {

	   for (var i in dataFechaProx) {
		 
	     if (dataFechaProx[i].idSolicitudPruebaReprueba == idSolicitudPruebaReprueba) {
	    	
	    	 dataFechaProx.splice(i, 1);
	  
	    	 break;
	     }
	   }

	  listarSolicitudLocal(0);
	  
	  for (var i in dataFechaProx) {
	      
		  $(".filaSeleccionada"+dataFechaProx[i].idSolicitudPruebaReprueba).prop('checked', true);
	  }	
}

$('body').on('click', '.EditarRpersonal',function(){
    
    estado = "EDITAR_PERSONA";
		
    var cadena = $(this).attr("id");
	var arrayCadena = cadena.split("%");
	
	var idPersonaNatural = arrayCadena[0];
	var apellidoPaterno  = arrayCadena[1];
	var apellidoMaterno  = arrayCadena[2];
	var tipoDocumento    = arrayCadena[3];
	var numeroDoc        = arrayCadena[4];
	var telefono         = arrayCadena[5];
	var nombre           = arrayCadena[6];
	var idTipoDoc        = arrayCadena[7]
			
	abrirInspectorAutorizadoA(idPersonaNatural);
	editarPersonalAutorizado(estado,idPersonaNatural,apellidoPaterno,apellidoMaterno,tipoDocumento,numeroDoc,telefono,idTipoDoc,nombre);
	desbloquearInput();
});

$('body').on('click', '.EliminarRpersonal',function(){

    var IdPersonaNatural= $(this).attr("id");
    
    confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarRPersonaAutorizado('" + IdPersonaNatural + "')");
});

function listarSolicitudes(){
	
	  $.ajax({ 
		      url:baseURL + "pages/solicitudPruebasHermeticidad/listarSolicitudes",
	         type:'post',
	         async:false,
	         data:{       	
	        	flagInformeIndiceRiesgo: "N",
	         },
	         beforeSend:muestraLoading,
	
			 success:function(data){
			    ocultaLoading();
			    
			    if(data.filas) {
			    	
			        $.each(data.filas, function( index, value ) {
        	            
			        	 var objeto = {};
			        	 
			        	 objeto['idSolicitudPruebaReprueba'] = value.idSolicitudPruebaReprueba;
						 objeto['nroSolicitudUnidadSupervisa'] = value.nroSolicitudUnidadSupervisa;
						 objeto['idResultadoPruebaReprueba'] = value.idResultadoPruebaReprueba;
						 objeto['idCompartimiento'] = value.idCompartimiento;
						 objeto['numeroTanque'] = value.numeroTanque;
						 objeto['numeroCompartimiento'] = value.numeroCompartimiento;
						 objeto['fechaSolicitud'] =  value.fechaSolicitud; 
						 objeto['fechaProxPrueba'] =  value.fechaProxPrueba;
				  			    			  
						 dataSolicitud.push(objeto);
						 
						 listarSolicitudLocal(0);
						 listarSolicitudLocal(0);
				      });
			    } else {
			    	
			    	//alert("Listar Vacio");
			    	listarSolicitudLocal(0);
			    	
			    }
		          
			 },
			error:errorAjax
	}); 
}

function registrarDoc(){
     
           var tds = "";
	    var button = "";
          var form = $('#fileUploadForm')[0];
          var data = new FormData(form);
          
    if (arrayIdDocumentA.length < 1) {
 		
	    $.ajax({
		          url: baseURL + "pages/solicitudPruebasHermeticidad/registrar",
		      enctype: 'multipart/form-data',
		         type:'post',
		  processData: false,
	      contentType: false, 
	            cache: false,
	             data: data,
	       beforeSend: muestraLoading,
	      
	       success:function(data){
	          ocultaLoading();
	          if(data.resultado=="0"){
	        	  var input = $('#uploadfile');
	        	  input.replaceWith(input.val('').clone(true));
	        	  $('#nombreArchivo').text("")
	              
	        	  var idDocumentoAux  = data.idDocumento;
	              var nombreDocumento = data.nombreDocumento;
	              
				  button ="<img src=\"" + baseURL + "/../images/eliminar.gif\" class='eliminarDoc' id='"+ idDocumentoAux +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>";	          	
				   
	              tds += "<tr>";
				   
				  tds += "<td style='width: 200px;color: #ea0505;'>"+ nombreDocumento +"</td>";
	
				  tds += "<td>"+ button +"</td>";
	
	           	  tds += "</tr>";
				   
				  $("#tbl_documentos").append(tds);
				
	              arrayIdDocumentA.push(idDocumentoAux);
	              $('#txtIdDocumento').val(idDocumentoAux);
	          }
	       },
	      error:errorAjax
	    }); 
	    
   } else {     
	   
	    var addhtml2 = 'Solo se permite Subir un Archivo.';
	    $("#dialog-message-content").html(addhtml2);
		$("#dialog-message").dialog("open");
		 
        return false;
   }
}

function eliminarRPersonaAutorizado(IdPersonaNatural ){

	for (var i in dataPersonaN) {
	     if (dataPersonaN[i].idPersonaNatural == IdPersonaNatural) { 

	    	 dataPersonaN.splice(i, 1);
	    	 arrayIdPersonaN.splice(i, 1);
	    	 
	    	 break;
	     }
	 }
	
	 
	 listarPersonasLocal(0);      
}

$("#cmbTipoPersonal").change(function(){
    if( $("#cmbTipoPersonal").val() == "0"  ){
        $("#personaN").hide(); 
        $("#empresaJ").hide();
        $("#txtflagPersona").val("");
    }
    
    if( $("#cmbTipoPersonal").val() == "1"  ){
        $("#personaN").show(); 
        $("#empresaJ").hide();
        
        $("#txtflagPersona").val("N");
   	    listarPersonasLocal(0);

    }
    if( $("#cmbTipoPersonal").val() == "2"  ){
        $("#personaN").show(); 
        $("#empresaJ").show();
   	    listarPersonasLocal(0);

        $("#txtflagPersona").val("J");
    }
});

function listarPersonasLocal(flg_load) {
    
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorPersonas").html("");
    
    var grid = $("<table>", {
        "id": "gridPersonas"
    });
    
    var pager = $("<div>", {
        "id": "paginacionPersonas"
    });
    
    $("#gridContenedorPersonas").append(grid).append(pager);
    
    var nombres = ['','','','','', 'Nro', 'TIPO DOCUMENTO', 'NUMERO', 'PERSONA', 'TELEFONO','OPCION'];
    var columnas = [
        {name: "idPersonaNatural", sortable: false, hidden: true},
        {name: "apellidoPaterno", width: 5, sortable: false, hidden: true, align: "center"},
        {name: "apellidoMaterno", width: 5, sortable: false, hidden: true, align: "center"},
        {name: "idTipoDoc", width: 5, sortable: false, hidden: true, align: "center"},
        {name: "nombre", width: 5, sortable: false, hidden: true, align: "center"},
        {name: "n", width: 30, sortable: false, hidden: false, formatter:"NroFilasR"},
        {name: "tipoDocumento", width: 105, sortable: false, hidden: false, align: "center"},
        {name: "numeroDoc", width: 85, sortable: false, hidden: false, align: "center"},
        {name: "nombreCompleto", width: 150, sortable: false, hidden: false, align: "center"},
        {name: "telefono", width: 90, sortable: false, hidden: false, align: "center"},
        {name: "opcion", width: 110, sortable: false, hidden: false, align: "center", formatter:"OpcionR"}
    ]; 
   
        grid.jqGrid({       	
        	data: dataPersonaN,
            datatype: "local",
            hidegrid: false,
            rowNum: 2,
            pager: "#paginacionPersonas",
            emptyrecords: "No se encontraron resultados",
            recordtext: "{0} - {1}",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: "auto",
            viewrecords: true,
            caption: "Listado de Personas",
            jsonReader: {
                root: "dataPersonaN",
                page: "pagina",
                total: "total",
                records: "registros",
                repeatitems: false
            },
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onCellSelect: function (cellcontent) {
                var rowdata = $(this).jqGrid("getRowData", cellcontent);
                idRPN = rowdata.idResultadoPersonaNatural;
            },
            loadError: function(jqXHR) {
                errorAjax(jqXHR);
            }
        });
        jQuery.extend($.fn.fmatter, {
            NroFilasR: function(cellvalue, options, rowdata) {
              var n = $("#gridContenedorPersonas tr").index() + 1;
              return n;
            }
        }),    
        jQuery.extend($.fn.fmatter, {
            OpcionR: function(cellvalue, options, rowdata) {
            	
            	var n = 0;
            	          	
            	var estado = $("#txtEstado").val();
            		
        	    if(estado == "CONSULTAR"){
        			
        	    	return "<a class='EditarRpersonal' id='"+ rowdata.idPersonaNatural + "%"+ rowdata.apellidoPaterno+"%"+ rowdata.apellidoMaterno +"%"+ rowdata.tipoDocumento+"%"+ rowdata.numeroDoc +"%"+ rowdata.telefono +"%"+ rowdata.nombre +"%"+ rowdata.idTipoDoc + "%"+"' style='cursor: pointer;text-decoration:none;pointer-events: none;' ><u> Editar </u></a>" +"\t"+
                           "<a class='EliminarRpersonal' id='"+ rowdata.idPersonaNatural +"' style='cursor: pointer;text-decoration:none;pointer-events: none;' ><u> Eliminar</u></a>";
            
        		} else if(estado == "NUEVO"){
        			
        			return "<a class='EditarRpersonal' id='"+ rowdata.idPersonaNatural + "%"+ rowdata.apellidoPaterno+"%"+ rowdata.apellidoMaterno +"%"+ rowdata.tipoDocumento+"%"+ rowdata.numeroDoc +"%"+ rowdata.telefono +"%"+ rowdata.nombre +"%"+ rowdata.idTipoDoc + "%"+"' style='cursor: pointer;text-decoration:none;' ><u> Editar </u></a>" +"\t"+
                           "<a class='EliminarRpersonal' id='"+ rowdata.idPersonaNatural +"' style='cursor: pointer;text-decoration:none;' ><u> Eliminar</u></a>";            
        		}
                
                n++;
            }
        });
}

function listarPersonaJuridica(idpersonaJuridica){
	
    $.ajax({
         url:baseURL + "pages/solicitudPruebasHermeticidad/cargarDatos",
         type:'post',
         async:false,
         data:{
        	 idPersonaJuridica:idpersonaJuridica
         },
   beforeSend:muestraLoading,
      success:function(data){
          ocultaLoading();
          
          $.each(data.filas, function( index, value ) {
        	  
        	  $("#txtRuc").val(value.ruc);
        	  $("#txtRazonSocial").val(value.razonSocial);
        	  $("#txtTelefono").val(value.telefono);
        	  
          });
         
      },
      error:errorAjax
    });  
	
}

function  llenarArrayTbPersonaNatural(idInformeIndiceRiesgo){

    $.ajax({
       url: baseURL + "pages/solicitudPruebasHermeticidad/listarPersonasArray",
       type:'post',
       async:false,
       data:{
    	   idInformeIndiceRiesgo: idInformeIndiceRiesgo
       },
       beforeSend:muestraLoading,
       success:function(data){
           ocultaLoading();
          $.each(data.filas, function( index, value ) {
			    
                var idPersonaNatural =  value.idPersonaNatural;
				var idTipoDoc  =    value.idTipoDocumento;
				var TipoDoc    =    value.tipoDocumento
			    var nroDoc     =    value.numeroDocumento;
			    var ApPaterno  =    value.apellidoPaterno;
			    var ApMaterno  =    value.apellidoMaterno;
			    var nombre     =    value.nombre;
			    var cip        =    value.cip;
			    var telefono        =    value.telefono;

			    var objeto = {};
	
			    objeto['idPersonaNatural'] = idPersonaNatural;
			    objeto['idTipoDoc'] = idTipoDoc;
			    objeto['tipoDocumento'] = TipoDoc;
			    objeto['numeroDoc'] =   nroDoc;
			    objeto['apellidoPaterno'] =  ApPaterno;
			    objeto['apellidoMaterno'] =  ApMaterno;
			    objeto['nombre'] =  nombre;
			    objeto['nombreCompleto'] = nombre +" "+  ApPaterno +" "+ ApMaterno;
			    objeto['telefono'] =  telefono;

			    dataPersonaN.push(objeto);
			    listarPersonasLocal(0);   	   

          });
          
		    listarPersonasLocal(0);

       },
       error:errorAjax
  });    
}    

function listarSolicitudLocal(flg_load) {
    
	 if (flg_load === undefined) {
	        flg_load = 1;
	    }
	    
	    $("#gridContenedorSolicitud").html("");
	    
	    var grid = $("<table>", {
	        "id": "gridSolicitud"
	    });
	    
	    var pager = $("<div>", {
	        "id": "paginacionSolicitud"
	    });
	    
	    $("#gridContenedorSolicitud").append(grid).append(pager);
	    
	    var nombres = ['','','','Nro','SOLICITUD', 'TANQUE', 'COMPARTIMIENTO', 'FECHA SOLICITUD', 'FECHA PROX.PRUEBA','OPCION'];
	    var columnas = [
	        {name: "idSolicitudPruebaReprueba",width: 5, sortable: false, hidden: true},
	        {name: "idResultadoPruebaReprueba",width: 5, sortable: false, hidden: true},
	        {name: "idCompartimiento", width: 5,sortable: false, hidden: true},
	        {name: "n", width: 30, sortable: false, hidden: false, formatter:"NroFilasR"},
	        {name: "nroSolicitudUnidadSupervisa", width: 150, sortable: false, hidden: false},
	        {name: "numeroTanque", width: 85, sortable: false, hidden: false, align: "center",formatter:"nroTanque"},
	        {name: "numeroCompartimiento", width: 95, sortable: false, hidden: false, align: "center"},
	        {name: "fechaSolicitud", width: 100, sortable: false, hidden: false, align: "center",formatter:"fmtFechaSolicitud"},
	        {name: "fechaProxPrueba", width: 100, sortable: false, hidden: false, align: "center",formatter:"fmtFechaProxPrueba"},
	        {name: "opcion", width: 75, sortable: false, hidden: false, align: "center", formatter:"Opcion"}
	    ]; 
	    
        grid.jqGrid({       	
        	data: dataSolicitud,
            datatype: "local",
            hidegrid: false,
            rowNum: 2,
            pager: "#paginacionSolicitud",
            emptyrecords: "No se encontraron resultados",
            recordtext: "{0} - {1}",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: "auto",
            viewrecords: true,
            caption: "Listado de Solicitudes",
            jsonReader: {
                root: "dataSolicitud",
                page: "pagina",
                total: "total",
                records: "registros",
                repeatitems: false
            },
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onCellSelect: function (cellcontent) {
                var rowdata = $(this).jqGrid("getRowData", cellcontent);
                idRPN = rowdata.idResultadoPersonaNatural;
            },
            loadError: function(jqXHR) {
                errorAjax(jqXHR);
            }
        });
        jQuery.extend($.fn.fmatter, {
            NroFilasR: function(cellvalue, options, rowdata) {
              var n = $("#gridContenedorSolicitud tr").index() + 1;
              return n;
            }
        }), 
        
        jQuery.extend($.fn.fmatter, {
        	nroTanque: function(cellvalue, options, rowdata) {
               
        		var num = rowdata.numeroTanque;
                var tex ='';
                
                tex = 'Tanque'+" "+ num;
                
                return tex;
            }
        });
        
        jQuery.extend($.fn.fmatter, {
        	fmtFechaSolicitud: function(cellvalue, options, rowdata) {
        		
        	var dateVar = rowdata.fechaSolicitud;
        	      var d = new Date(dateVar);
        		
            if(dateVar){
        	
        		if((d.getMonth()+1) < 10){
        			var mes = '0' + (d.getMonth() + 1);
        		}else{
        			var mes = d.getMonth() + 1;
        		}
        		
        		var fecha = d.getDate()  + '-' + mes + '-' + d.getFullYear()
        		
        	} else {           	
            	var fecha= '';       			
    	    }
    		
    	   return fecha;
        }
        		           
        });
        
        jQuery.extend($.fn.fmatter, {
        	fmtFechaProxPrueba: function(cellvalue, options, rowdata) {
        		
        		var dateVar = rowdata.fechaProxPrueba;
        		      var d = new Date(dateVar);
        		
        	   if(dateVar){
        		   
	        		if((d.getMonth()+1) < 10){
	        			var mes = '0' + (d.getMonth() + 1);
	        		}else{
	        			var mes = d.getMonth() + 1;
	        		}
	        		
	        		var fecha = d.getDate()  + '-' + mes + '-' + d.getFullYear()
 
        		} else {               	
                	var fecha= '';       			
        	    }
        		
        	   return fecha;
            }
        });

        jQuery.extend($.fn.fmatter, {
            Opcion: function(cellvalue, options, rowdata) {
            	
            	var estado = $("#txtEstado").val();
        		
    	        if(estado == "CONSULTAR"){
    		
                    return  " <input type='checkbox'  name ='check' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.idCompartimiento +"' class='filaSeleccionada filaSeleccionada"+ rowdata.idSolicitudPruebaReprueba +"' value='' style='pointer-events: none;' checked>";

	    		} else if(estado == "NUEVO"){
	    			
	                return  " <input type='checkbox'  name ='check' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.idCompartimiento +"' class='filaSeleccionada filaSeleccionada"+ rowdata.idSolicitudPruebaReprueba +"' value=''>";

	    		}

            }
        });
}

function abrirInspectorAutorizadoA(idPRN){ 
   
    var title="";
    $.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/abrirFrmResultadoPersonal", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogInspectorAutorizado").html(data);
            
            $("#dialogNuevo").html(data);
            
            if(idPRN == "")
				
                title="AGREGAR PERSONAL AUTORIZADO";
				
            if(idPRN != "")

               title="EDITAR PERSONAL AUTORIZADO";
            
            $("#dialogInspectorAutorizado").dialog({
                position: ['center', 'top+20'],
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "600",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar",
                open: function( event, ui ) { 
                
                }
            });

            
        },
        error:errorAjax
    });
}

function abrirProxPruebaHermeticidad(){ 
	   
    var title="PRÓXIMA PRUEBA DE HERMETICIDAD";
    
    $.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/abrirProxPruebaHermeticidad", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogProxPruebaHermeticidad").html(data);
            
            $("#dialogNuevo").html(data);
                      
            $("#dialogProxPruebaHermeticidad").dialog({
                position: ['center', 'top+20'],
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "500",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar",
                open: function( event, ui ) { 
                
                }
            });
            
        },
        error:errorAjax
    });
}

function cargarDatosRuc(){
    $.ajax({
            url:baseURL + "pages/solicitudPruebasHermeticidad/cargarDatos",
            type:'post',
            async:false,
            data:{
                ruc:$('#txtRuc').val()
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                
                if(data.registros == 0){
                	
                    var addhtml2 = 'RUC no se encuentra registrado.';
           		    $("#dialog-message-content").html(addhtml2);
           		    $("#dialog-message").dialog("open");
           		    
           		    return false;
           		 
                    $("#txtRazonSocial").val("");
                    $("#txtTelefono").val("");
                }else{
                    $.each(data.filas, function( index, value ) {
                    	$("#txtIdPersonaJuridica").val(value.idPersonaJuridica);
                        $("#txtRazonSocial").val(value.razonSocial);
                        $("#txtTelefono").val(value.telefono);
                    });   
                }       
            },
            error:errorAjax
        });
}


