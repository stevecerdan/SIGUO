var dataPersonaN           =  [];
var dataDocumentA          =  [];
var arrayIdPersonaN        =  [];
var arrayIdDocumentA       =  [];
var EditarRpersonal        =  [];
var EliminarRpersonal      =  [];
var idCompartimiento       =  "";
var tipoPersonalAux        =  "";
var flagPersonaAux         =  "";
var resultadoRevisionAux   =  "";
var idResultadoRevisionAux =  "";
var idProgramacionAux      =  "";
var idPersonaJuridicaAux   =  "";
var idDocumentoAux         =  "";
var estadoResultado        =  "";
var nombreDocumento        =  "";
var Rpt                    =  "";
var estado                 =  "";

$(function() {
    
	$( "#txtFechaInicio" ).datepicker();
	$( "#txtFechaFin" ).datepicker();
	
	$( "#txtFechaInicio" ).attr( "readonly" , "readonly" );
	$( "#txtFechaFin" ).attr( "readonly" , "readonly" );

	initInicio();
	initDialogs();
	listarDocumentosLocal(0);

});

function validaNumericos(event) {
    if(event.charCode >= 48 && event.charCode <= 57){
      return true;
     }
     return false;        
}

function convertDateFormat(string) {
    var info = string.split('/');
    return info[1] + '/' + info[0] + '/' + info[2];
}

function compararFechas(fechaInicio, fechafin){

    if ( fechaInicio > fechafin || fechaInicio === fechafin)
        return false

     return true;
}

function initInicio(){
    confirm.start();
   
    $("#txtFechaInicio").datepicker();
    $("#txtFechaFin").datepicker();
    
    $("#txtFechaInicio").change(function(){
        
		var fecha = new Date();

		var fechaI = $("#txtFechaInicio").val();
		var fechaF = $("#txtFechaFin").val();
		var fechaA = $("#fechaActual").val();
		var fechaC = $("#fechaCreacion").val();
		var fechaP = $("#fechaProgramacion").val();

		
		var valor1 = fechaI.split("/");
		var dia1 =  valor1[0];
		var mes1 =  valor1[1];
		var anho1 =  valor1[2];
	
		var valor2= fechaF.split("/");
		var dia2 =  valor2[0];
		var mes2 =  valor2[1];
		var anho2 =  valor2[2];
		 
		var valor3 = fechaA.split("/");
		var dia =  valor3[0];
		var mes =  valor3[1];
		var anho =  valor3[2];
		
		var valor4 = fechaC.split("/");
		var dia4 =  valor4[0];
		var mes4 =  valor4[1];
		var anho4 =  valor4[2];
		
		var valor5 = fechaP.split("/");
		var dia5 =  valor5[0];
		var mes5 =  valor5[1];
		var anho5 =  valor5[2];
		
		
		var fI = new Date(anho1, Number(mes1)-1, dia1); 
        var fA = new Date(anho,  Number(mes)-1, dia); 
        var fF = new Date(anho2, Number(mes2)-1, dia2); 
		var fC = new Date(anho4, Number(mes4)-1, dia4); 
		var fP = new Date(anho5, Number(mes5)-1, dia5); 


		   
		   
        if(fechaA.length > 0){
			
			if(fI >= fC && fI <= fA){

			} else {
				
				var addhtml2 = "Fecha no válida.";
     		    $("#dialog-message-content").html(addhtml2);
     		    $("#dialog-message").dialog("open");
     		 
     		    $("#txtFechaInicio").val("");	
     		 
                return false;

			}
				
			
			if(fF < fI){

               var addhtml2 = "Fecha no válida." ;
     		   $("#dialog-message-content").html(addhtml2);
     		   $("#dialog-message").dialog("open");
     		 
     		   $("#txtFechaFin").val("");	
     		 
               return false;
              
			}			

       
	   }
	   
	   
    });
    
    $("#txtFechaFin").change(function(){
    	
       var fecha = new Date();

		var fechaI = $("#txtFechaInicio").val();
		var fechaF = $("#txtFechaFin").val();
		var fechaA = $("#fechaActual").val();
		var fechaC = $("#fechaCreacion").val();
		var fechaP = $("#fechaProgramacion").val();

		
		var valor1 = fechaI.split("/");
		var dia1 =  valor1[0];
		var mes1 =  valor1[1];
		var anho1 =  valor1[2];
	
		var valor2= fechaF.split("/");
		var dia2 =  valor2[0];
		var mes2 =  valor2[1];
		var anho2 =  valor2[2];
		 
		var valor3 = fechaA.split("/");
		var dia =  valor3[0];
		var mes =  valor3[1];
		var anho =  valor3[2];
		
		var valor4 = fechaC.split("/");
		var dia4 =  valor4[0];
		var mes4 =  valor4[1];
		var anho4 =  valor4[2];
		
		var valor5 = fechaP.split("/");
		var dia5 =  valor5[0];
		var mes5 =  valor5[1];
		var anho5 =  valor5[2];
		
		
		var fI = new Date(anho1, Number(mes1)-1, dia1); 
        var fA = new Date(anho,  Number(mes)-1, dia); 
        var fF = new Date(anho2, Number(mes2)-1, dia2); 
		var fC = new Date(anho4, Number(mes4)-1, dia4); 
		var fP = new Date(anho5, Number(mes5)-1, dia5); 
			  
        if(fechaA.length > 0){
			
			if(fF >= fC && fF <= fA){
				
			} else {
				
				var addhtml2 = 'Fecha no válida. Fecha de Fin no puede ser superior a la Fecha Actual: '+ dia +"/"+ mes +"/" + anho ;
				$("#dialog-message-content").html(addhtml2);
				$("#dialog-message").dialog("open");
				 
				$("#txtFechaFin").val("");	
				 
				return false;
              
			}
					
			if(fF < fI){

                var addhtml2 = "Fecha no válida.";
     		    $("#dialog-message-content").html(addhtml2);
     		    $("#dialog-message").dialog("open");
     		 
     		    $("#txtFechaFin").val("");	
     		 
                return false;
              
			}			

	   }
	   

    });
    
    $('#btnValidarRUC').click(function(){
        if ( $('#txtRuc').val().length == 11 ){
            cargarDatosRuc();
        }
            
    });

    $('#btnNuevaPers').click(function(){   
  		
    	abrirInspectorAutorizadoA();
  		
  		estado = "NUEVA_PERSONA";
  		
  		nuevoPersonalAutorizado(estado);
    });
    
    $("#uploadfile").change(function() {
        var filename = $("#uploadfile")[0].files[0];
        $('#nombreArchivoRR').text(filename.name); 
       
        $("#btnAgregarDoc").prop("disabled", this.files.length == 0);
      
    });

    $('#btnAgregarDoc').click(function(){
        confirm.open("¿Desea guardar el registro?","registrarDoc()");
    });
    
	//DescargarDoc
    $('body').on('click', '.DescargarDoc',function(){
		
  	  var cadena= $(this).attr("id");
  	  
  	  var arrayCadena = cadena.split("%");
  	  
  	  var nombreDocumento = arrayCadena[0];
  	  var archivoAdjunto = arrayCadena[1];
   	   
   	  var blob = new Blob([archivoAdjunto], {type: 'application/pdf'});
   	   
   	  //creamos un FileReader para leer el Blob
   	  var reader = new FileReader();
   	  //Definimos la función que manejará el archivo
   	  //una vez haya terminado de leerlo
   	  reader.onload = function (event) {
   	    //Usaremos un link para iniciar la descarga 
   	    var save = document.createElement('a');
   	    save.href = event.target.result;
   	    save.target = '_blank';
   	    //Truco: así le damos el nombre al archivo 
   	    save.download = nombreDocumento;
   	    var clicEvent = new MouseEvent('click', {
   	      'view': window,
   	      'bubbles': true,
   	      'cancelable': true
   	    });
   	    //Simulamos un clic del usuario
   	    //no es necesario agregar el link al DOM.
   	    save.dispatchEvent(clicEvent);
   	    //Y liberamos recursos...
   	    (window.URL || window.webkitURL).revokeObjectURL(save.href);
	  };
	  //Leemos el blob y esperamos a que dispare el evento "load"
	  reader.readAsDataURL(blob);
  });
    
   $('body').on('click', '#registroRV',function(){
    	
	    registrarResultadoRevision();
	   
    });

   $('#btnGuardarRegistro').click(function(){
	    	   
	    camposQueFaltanRegistrar();
	     
    });
   
    $('#btnFinalizarRegistro').click(function(){
        
	  var estadoRes = "F";    
	  var idResultadoRevision = $("#idResultadoRevision").val();
	  var estadoRegistro =$("#estadoRegistro").val();
		
	  var fecha = new Date();
	
	  var fechaI = $("#txtFechaInicio").val();
	  var fechaF = $("#txtFechaFin").val();
	  var fechaA = $("#fechaActual").val();
	  var horaI  = $("#txtHoraInicioH").val();
	  var horaF  = $("#txtHoraFinH").val();
	
	  var valor1 = fechaI.split("/");
	  var dia1 =  valor1[0];
	  var mes1 =  valor1[1];
	  var anho1 =  valor1[2];
		 
	  var valor2= fechaF.split("/");
	  var dia2 =  valor2[0];
	  var mes2 =  valor2[1];
	  var anho2 =  valor2[2];
	 
	  var valor3 = fechaA.split("/");
	  var dia =  valor3[0];
	  var mes =  valor3[1];
	  var anho = valor3[2];
		
	  var valor4 = horaI.split(":");
	  var hI =  valor4[0];
	  var mI =  valor4[1];
	
	  var valor5 = horaF.split(":");
	  var hF =  valor5[0];
	  var mF =  valor5[1];
					
	  var fI = new Date(anho1, Number(mes1)-1, dia1,hI, mI); 
	  var fA = new Date(anho,  Number(mes)-1, dia); 
	  var fF = new Date(anho2, Number(mes2)-1, dia2,hF, mF); 
	   
      var txtFechaInicio = $("#txtFechaInicio").val();
 	   
 	   if(txtFechaInicio.length <= 0) {
 		   
 		   var addhtml2 = 'Ingrese una fecha de inicio.';
 		   $("#dialog-message-content").html(addhtml2);
 		   $("#dialog-message").dialog("open");
 				 
 			return false;
 	   }
 	   
 	  var txtFechaFin =$("#txtFechaFin").val();
 	    
 	   if(txtFechaFin.length <= 0) {
 	    	
 		    var addhtml2 = 'Ingrese una fecha de fin.';
 			$("#dialog-message-content").html(addhtml2);
 			$("#dialog-message").dialog("open");
 			 
 			return false;
 	    }
 	   
 	  var txtHoraInicioH = $("#txtHoraInicioH").val();      
 		
 	   if(txtHoraInicioH.length <= 0) {
 	   	
 	   	 var addhtml2 = 'Ingrese una hora de inicio.';
 			 $("#dialog-message-content").html(addhtml2);
 			 $("#dialog-message").dialog("open");
 			 
 	        return false;
 	   }
 	   
 	  var txtHoraFinH = $("#txtHoraFinH").val();      
 		
 	   if(txtHoraFinH.length <= 0) {
 	   	
 	   	 var addhtml2 = 'Ingrese una hora de fin.';
 			 $("#dialog-message-content").html(addhtml2);
 			 $("#dialog-message").dialog("open");
 			 
 	         return false;
 	   } 
	   
	   if(fF < fI){

		  var addhtml2 = 'Hora no válida.';
		  $("#dialog-message-content").html(addhtml2);
		  $("#dialog-message").dialog("open");
		 
		  $("#txtHoraFinH").val("");	
		 
		  return false;
		  
		}		
 	   
 	  if ($('input[name=Personal]').is(':checked')) {
 	  
 	  } else  {
 		  
 		  var addhtml2 = 'Seleccione un tipo de personal.';
 		  $("#dialog-message-content").html(addhtml2);
 		  $("#dialog-message").dialog("open");
 			 
 		  return false;
 	  }
 	  
 	  if ($('input[id=chk_PsnalInterno]').is(':checked')) {
     	  
 		  if (dataPersonaN.length <= 0) { 
      		 
      		    var addhtml2 = 'Falta agregar persona que realizó el mantenimiento.';
   			    $("#dialog-message-content").html(addhtml2);
   			    $("#dialog-message").dialog("open");
   			 
   	        return false;
          } 
 		  
 	  } 
 	  
 	  if ($('input[id=chk_PsnalExterno]').is(':checked')) {
     	  
 		  var cmbTipoPersonal = $("#cmbTipoPersonal").val();
          
           if(cmbTipoPersonal == 0) {
              
                var addhtml2 = 'Seleccione un tipo de personal externo.';
                $("#dialog-message-content").html(addhtml2);
                $("#dialog-message").dialog("open");
             
              return false;
            
            }   else {
         	  
            	if(cmbTipoPersonal == 1) {
            		
            		if (dataPersonaN.length <= 0) {
               		 
               		    var addhtml2 = 'Agregar persona que realizó el mantenimiento.';
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
	            		 
	                		var addhtml2 = 'Agregar persona que realizó el mantenimiento.';
             			    $("#dialog-message-content").html(addhtml2);
             			    $("#dialog-message").dialog("open");
	             			 
	             	        return false;
	                 } 
            	}
            }          
 	  }
 	  
 	  if (dataDocumentA.length <= 0) {
 			
 		    var addhtml2 = 'Falta agregar documento .';
			$("#dialog-message-content").html(addhtml2);
			$("#dialog-message").dialog("open");
		 
            return false;
 	  }
 	 

      if(estadoRegistro == "EN_REGISTRO"){
 
        	confirm.open("No podrá realizar cambios.¿Está seguro de finalizar el registro?","ResultadoRevFinalizar('" + estadoRes +"','"+ idResultadoRevision +"')");
        
      } else if(estadoRegistro == "NUEVO_REGISTRO"){
        	
        	confirm.open("No podrá realizar cambios.¿Está seguro de finalizar el registro?","ResultadoRevFinalizar('" + estadoRes +"','"+ idResultadoRevision +"')");
      }

    });
    
   $('#btnRegresar').click(function(){
	   $('#dialogFrmRevision').dialog('close');
   });
   
   $('#txtRazonSocial').attr('disabled','disabled');
   $('#txtTelefono').attr('disabled','disabled');
};

function validarFechaHora(){
	

		

		
		

	   
	
}

function registrarResultadoRevision(){
	
	           var estadoRes = "E";
     var idResultadoRevision = $("#idResultadoRevision").val();
          var estadoRegistro = $("#estadoRegistro").val(); 
			
     if(estadoRegistro == "EN_REGISTRO"){
     	
     	confirm.open("¿Desea guardar el registro?","registrarResultadoRev('" + estadoRes +"','"+ idResultadoRevision +"')");
     	
     } else if(estadoRegistro == "NUEVO_REGISTRO"){
     	
     	confirm.open("¿Desea guardar el registro?","registrarResultadoRev('" + estadoRes +"','"+ idResultadoRevision +"')");
     }
}

function camposQueFaltanRegistrar() {
	
	    var fechaInicio = "";
           var fechaFin = "";
         var horaInicio = "";
            var horaFin = "";
       var tipoPersonal = "";
     var personaNatural = "";
var tipoPersonalExterno = "";
    var personaJuridica = "";
          var documento = "";
         var encontrado = "";
    
	var txtFechaInicio = $("#txtFechaInicio").val();
		   
	   if(txtFechaInicio.length <= 0) {
				   
		   fechaInicio = '<span style="padding-left: 20px;">Seleccionar una fecha de inicio.</span><br>';
		    encontrado = 1;		 		
		} 
	    
	var txtFechaFin = $("#txtFechaFin").val();      
		
	  if(txtFechaFin.length <= 0) {
	  	
		     fechaFin = '<span style="padding-left: 20px;">Seleccionar una fecha de fin.</span><br>';
		   encontrado = 1;		  
	  }
	  
	 var txtHoraFinH = $("#txtHoraFinH").val();      
		
	    if(txtHoraFinH.length <= 0) {
	  	
		       horaFin = '<span style="padding-left: 20px;">Ingresar una hora de fin.</span><br>';
		    encontrado = 1;
	     }
	
	 var txtHoraInicioH = $("#txtHoraInicioH").val();      
 		
	 	 if(txtHoraInicioH.length <= 0) {
	 	   	
	 		 horaInicio = '<span style="padding-left: 20px;">Ingresar una hora de inicio.</span><br>';
	 		 encontrado = 1;
	 	 }
	
	if ($('input[name=Personal]').is(':checked')) {
	 	 	  
	 } else  {
	 		  
	    tipoPersonal = '<span style="padding-left: 20px;">Seleccionar un tipo de personal.</span><br>';
	      encontrado = 1;
	 }
	 	  
	 if ($('input[id=chk_PsnalInterno]').is(':checked')) {
	     	  
	    if (dataPersonaN.length <= 0) { 
	      		 
	       personaNatural = '<span style="padding-left: 20px;">Agregar personal autorizado.</span><br>';
	           encontrado = 1;	         	      
	     } 
	 		  
	  } 
	 	  
	  if ($('input[id=chk_PsnalExterno]').is(':checked')) {
	     	  
	 	    var cmbTipoPersonal = $("#cmbTipoPersonal").val();
	          
	         if(cmbTipoPersonal == 0) {
	              
	                tipoPersonalExterno = '<span style="padding-left: 20px;">Seleccionar un tipo de personal externo.</span><br>';
	                         encontrado = 1;	            
	         } else {
	         	  
	            	if(cmbTipoPersonal == 1) {
	            		
	            		if (dataPersonaN.length <= 0) {
	               		 
	            			personaNatural = '<span style="padding-left: 20px;">Agregar persona que realizó el mantenimiento.</span><br>';
	            			    encontrado = 1;
	                   } 
	            		
	            	} else if(cmbTipoPersonal == 2) {
	         	    
	            	  var txtIdPersonaJuridica = $("#txtIdPersonaJuridica").val();
	          	  
		              	if(txtIdPersonaJuridica.length <= 0) {
		                	   	
		                   personaJuridica  = '<span style="padding-left: 20px;">Ingresar RUC.</span><br>';
		               	        encontrado  = 1;		               	   
		               	 }
	         	   	         	    
		              	if (dataPersonaN.length <= 0) {
		            		 
		              		personaNatural = '<span style="padding-left: 20px;">Agregar Persona Natural.</span><br>';
		              		    encontrado = 1;	
		                 } 
	            	}
	            }          
	 	  }
	 	  
	 if (dataDocumentA.length <= 0) {
	 			
	 	      documento = '<span style="padding-left: 20px;">Agregar documento.</span><br>';
	 	     encontrado = 1;
	 }
	 	 
  
	if (encontrado == 1) {
		
	 	var addhtml2 = "Faltan campos obligatorios por llenar:"+"<br><br>"+ fechaInicio + fechaFin + horaInicio + horaFin + tipoPersonal + personaNatural + tipoPersonalExterno + personaJuridica + documento;
			
	     $("#dialog-message-content_registroRV").html(addhtml2);		   
		 $("#dialog-message_registroRV").dialog("open");	
		
		 return false;

	 } else {
		 
		 registrarResultadoRevision();
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
	
  $("#dialog-message_registroRV").dialog({
		
		modal : true,
		autoOpen : false,
		maxWidth: "550px",
		buttons : {
			'Ok' : {
		        text : 'Ok',
		        id : 'registroRV',
		        click : function(){
		        	$(this).dialog("close");
		        }
		    } 
		}
	});
}

$('body').on('click', '.EliminarRpersonal',function(){

    var cadena= $(this).attr("id");
    var arrayCadena=cadena.split("%");
    var IdPersonaNatural = arrayCadena[0];
    var IdResultadoPersonaNatural = arrayCadena[1];
    var IdResultadoRevision = arrayCadena[2];

    confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarRPersonaAutorizado('" + IdPersonaNatural + "','"+ IdResultadoPersonaNatural +"','"+ IdResultadoRevision +"')");
});


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

$('body').on('click', '.eliminarDoc',function(){
    
	var cadena= $(this).attr("id");
    var arrayCadena=cadena.split("%");
    var IdResultadoRevision = arrayCadena[0];
    var IdResultadoDocumento = arrayCadena[1];
    
    confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarDoc('" + IdResultadoRevision + "','" + IdResultadoDocumento + "')");
});

$("input[name=Personal]").change(function () {    
    if( $('input:radio[name=Personal]:checked').val() == "0"  ){
    	   	 
    	 listarPersonasLocal(0);
    	  
    	 $("#cmbTipoPersonal").hide();
         $("#empresaJ").hide();
         $("#personaN").show();   
         
         $("#tipoPersonalAux").val("I");
         $("#flagPersonaAux").val(""); 

     } 
    
     if( $('input:radio[name=Personal]:checked').val() == "1"  ){
    	
         $("#cmbTipoPersonal").val(0);
         $("#cmbTipoPersonal").show();
         $("#personaN").hide();
         
         $("#tipoPersonalAux").val("E");
         $("#flagPersonaAux").val("");         
    
     } 
});

 
$("#cmbTipoPersonal").change(function(){
    if( $("#cmbTipoPersonal").val() == "0"  ){
        $("#personaN").hide(); 
        $("#empresaJ").hide();
        $("#flagPersonaAux").val("");
    }
    
    if( $("#cmbTipoPersonal").val() == "1"  ){
        $("#personaN").show(); 
        $("#empresaJ").hide();
        
        $("#flagPersonaAux").val("N");
   	    listarPersonasLocal(0);

    }
    if( $("#cmbTipoPersonal").val() == "2"  ){
        $("#personaN").show(); 
        $("#empresaJ").show();
   	    listarPersonasLocal(0);

        $("#flagPersonaAux").val("J");

    }
});

function cargarDatosRuc(){
    $.ajax({
            url:baseURL + "pages/InspMantLimp/cargarDatos",
            type:'post',
            async:false,
            data:{
                ruc:$('#txtRuc').val()
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                
                if(data.tamanio == 0){
                	
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
function listarResultadoRevision(idResultadoRevision,fechaInicio,fechaFin){
	
    $.ajax({
         url:baseURL + "pages/InspMantLimp/ConsultarResultadoRevision",
         type:'post',
         async:false,
         data:{
        	 idResultadoRevision:idResultadoRevision
         },
   beforeSend:muestraLoading,
      success:function(data){
          ocultaLoading();
              
        	  $.each(data.filas, function( index, value ) {
                  
            	  if(value.tipoPersonal == 'I'){
            		  
            		  llenarArrayTbPersonaNatural(idResultadoRevision);
            		  
            		  $("#tipoPersonalAux").val(value.tipoPersonal); 
            		  $("#chk_PsnalExterno").removeAttr('checked');
            		  $("#chk_PsnalInterno").attr('checked','checked');
            		  $("#personaN").show();
            		  $("empresaJ").hide();
            		  
            	  } else if(value.tipoPersonal == 'E') {
            		   $("#tipoPersonalAux").val(value.tipoPersonal); 
            		   $("#chk_PsnalInterno").removeAttr('checked');
            		   $("#chk_PsnalExterno").attr('checked','checked'); 
            	  }
            	  
                 if(value.flagPersona == "J"){
                	 
           		     var vOption = "2";
                	 llenarArrayTbPersonaNatural(idResultadoRevision);
                	 var IdPJ =value.idPersonaJuridica;
                	 if(IdPJ !== null){
	                	  $("#flagPersonaAux").val(value.flagPersona);
	                   	  listarPersonaJuridica(value.idPersonaJuridica);
                     }

               		 $('#cmbTipoPersonal option[value="'+ vOption +'"]').attr("selected", true);

               	     $("#personaN").show();
        		     $("#empresaJ").show();
        		     $('#cmbTipoPersonal').show();

            		  
            	  } else if(value.flagPersona == "N") {
            		  
            		  var vOption = "1";
                 	  var IdPJ =value.idPersonaJuridica;
                 	  llenarArrayTbPersonaNatural(idResultadoRevision);
                 	  
            		  if(IdPJ !== null){
                    	  
                    	  listarPersonaJuridica(value.idPersonaJuridica);
                      }
            		  
                      $('#cmbTipoPersonal option[value="'+ vOption +'"]').attr("selected", true);

            		  $("#personaN").show();
         		      $("#empresaJ").hide();
         		      $('#cmbTipoPersonal').show();

            	  }
         		 
            	  $("#txtFechaInicio").val(fechaInicio);
                  $("#txtFechaFin").val(fechaFin);
                  $("#txtHoraInicioH").val(value.horaInicio);
                  $("#txtHoraFinH").val(value.horaFin);
                  $("#txtDetalle").val(value.observacion);
                                                                      
              });
        	         
      },
      error:errorAjax
    });  
	
}

function listarPersonaJuridica(idpersonaJuridica){
	
    $.ajax({
         url:baseURL + "pages/InspMantLimp/cargarDatos",
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

function bloquearDesbloquearCamposResultadoRevision(Rpt){
	  
	  if(Rpt == 'HABILITAR'){
		  
	      $(".estadoResultado").css({pointerEvents: "null"});
		  $("#txtFechaInicio").attr('disabled',false);
		  $("#txtFechaFin").attr('disabled',false);
		  $("#txtHoraInicioH").attr('disabled',false);
		  $("#txtHoraFinH").attr('disabled',false);
		  $("#btnNuevaPers").attr('disabled', false);
		  $("#btnAgregarDoc").attr('disabled', false);
		  $("#btnGuardarRegistro").attr('disabled', false);
	      $("#btnFinalizarRegistro").attr('disabled', false);
		  $("input[type=radio]").attr('disabled', false);
		  $("#txtDetalle").attr('disabled',false);
		  $("#uploadfile").attr('disabled',false);
		  $(".eliminarDoc").css({pointerEvents: "null"});
		  $('.EditarRpersonal').css({pointerEvents: "null"});
		  $('.EliminarRpersonal').css({pointerEvents: "null"});
	      	 
	  }else if(Rpt == 'DESHABILITAR'){
		  
		  $(".estadoResultado").css({pointerEvents: "none"});
		  $("#cmbTipoPersonal").css({pointerEvents: "none"});
		  $("#txtFechaInicio").attr('disabled','disabled');
		  $("#txtFechaFin").attr('disabled','disabled');
		  $("#txtHoraInicioH").attr('disabled','disabled');
		  $("#txtHoraFinH").attr('disabled','disabled');
		  $("#btnNuevaPers").attr('disabled', 'disabled');
		  $("#btnAgregarDoc").attr('disabled', 'disabled');
		  $("#btnGuardarRegistro").attr('disabled', 'disabled');
	      $("#btnFinalizarRegistro").attr('disabled', 'disabled');
		  $("input[type=radio]").attr('disabled', 'disabled');
		  $("#txtDetalle").attr('disabled','disabled');
		  $("#uploadfile").attr('disabled','disabled');
		  $(".eliminarDoc").css({pointerEvents: "none"});
		  $('.EditarRpersonal').css({pointerEvents: "none"});
		  $('.EliminarRpersonal').css({pointerEvents: "none"});
		  
	  }
}
function continuarRegistroResultadoRevision(estado,idResultadoRevision){
	 $("#estadoRegistro").val(estado);
	 $("#idResultadoRevision").val(idResultadoRevision);
}

function informacionResultadoRevision(idProgramacion,numeroProgramacion,unidadAlmacenamiento,tipoRevision,idCompartimiento,idUnidadSupervisada,idResultadoRevision,fechaInicio,fechaFin,fechaProgramacion,resultadoRevision,fechaCreacion,estado,idPersonaJuridica,flagPersona){

    var cadena = numeroProgramacion.split("-");
    var V1 = cadena[0];
    var v2 = cadena[2];
    var v3 = cadena[3];
    var revision = "";
    
    if(V1=='INS'){
           
        revision ='INSPECCIÓN';
            
     } else if(V1=='MAN'){
           
         revision ='MANTENIMIENTO';
                    
     } else if(V1=='LIM'){
                       
         revision ='LIMPIEZA';      
    }   
    
    var tRevision = tipoRevision;
    var tex ='';
    
    if(tRevision=='I'){
        tex='Inspección';
   
    }else if(tRevision=='M'){
        tex='Mantenimiento';
    
    }else if(tRevision=='L'){
        tex='Limpieza'; 
    }
    
   if (idPersonaJuridica == 'null'){
	   
		var idPersonaJuridicaRV = "";
	} else {
		
		var idPersonaJuridicaRV = idPersonaJuridica;
	}
	
   if (flagPersona == 'null'){
	   
	    var flagPersonaRV = "";
	} else {
		
		var flagPersonaRV = flagPersona;
	}
   
    $("#idProgramacionRevision").val(idProgramacion);
    $("#numeroProgramacionRevision").val(numeroProgramacion);
    $("#titulo1").text("Datos de"+" "+revision+" "+"N°"+" "+v2+"-"+v3);
    $("#titulo2").text(unidadAlmacenamiento);
    $("#titulo3").text(tex);
    $("#idCompartimientoRevision").val(idCompartimiento);
    $("#idUnidSupervisadaRevision").val(idUnidadSupervisada);
    $("#fechaProgramacion").val(fechaProgramacion);
    $("#txtIdPersonaJuridica").val(idPersonaJuridicaRV);
    $("#flagPersonaAux").val(flagPersonaRV);
    $("#fechaCreacion").val(fechaCreacion );

    
    var estadoRegistro =estado;

    if(estadoRegistro == "EN_REGISTRO"){
        listarCompartimientos(0,idCompartimiento,resultadoRevision,estado);
    	listarResultadoRevision(idResultadoRevision,fechaInicio,fechaFin);
        llenarArrayTbDocumentos(idResultadoRevision);

    } else {
    	
    	listarCompartimientos(0,idCompartimiento,resultadoRevision,estado);
    	listarResultadoRevision(idResultadoRevision,fechaInicio,fechaFin);
    	llenarArrayTbDocumentos(idResultadoRevision);    	
    }

}

function informacionProgramacion(idProgramacion,numeroProgramacion,unidadAlmacenamiento,tipoRevision,idCompartimiento,idUnidadSupervisada,fechaProgramacion,estado,fechaCreacion){

    var cadena = numeroProgramacion.split("-");
    var V1 = cadena[0];
    var v2 = cadena[2];
    var v3 = cadena[3];
    var revision = "";
    
    if(V1=='INS'){
           
        revision ='INSPECCIÓN';
            
     } else if(V1=='MAN'){
           
         revision ='MANTENIMIENTO';
                    
     } else if(V1=='LIM'){
                       
         revision ='LIMPIEZA';      
    }   
    
    var tRevision = tipoRevision;
    var tex ='';
    
    if(tRevision=='I'){
        tex='Inspección';
   
    }else if(tRevision=='M'){
        tex='Mantenimiento';
    
    }else if(tRevision=='L'){
        tex='Limpieza'; 
    }
   
    if(tRevision=='I'){
        tex1='la Inspección';
   
    }else if(tRevision=='M'){
        tex1='el Mantenimiento';
    
    }else if(tRevision=='L'){
        tex1='la Limpieza'; 
    }
   
    $("#estadoRegistro").val(estado);
    $("#idProgramacionRevision").val(idProgramacion);
    $("#numeroProgramacionRevision").val(numeroProgramacion);
    $("#titulo1").text("Datos de"+" "+revision+" "+"N°"+" "+v2+"-"+v3);
    $("#titulo2").text(unidadAlmacenamiento);
    $("#titulo3").text(tex);
    $("#titulo4").text("Seleccione el tipo de personal que realizó "+ tex1);
    $("#idCompartimientoRevision").val(idCompartimiento);
    $("#idUnidSupervisadaRevision").val(idUnidadSupervisada);
    $("#fechaProgramacion").val(fechaProgramacion);
    $("#txtFechaInicio").val( $("#fechaActual").val() );
    $("#fechaCreacion").val(fechaCreacion );


    listarCompartimientos(0,idCompartimiento,"",estado);

}

function compararFechas(fechaInicio, fechafin){

    if ( fechaInicio > fechafin)
        return false
    if ( fechaInicio === fechafin)
        return false

     return true;
}

function actualizaEstadoProgramacion(estadoRes){
	 
	 idProgramacionAux = $("#idProgramacionRevision").val();
     var fProgramacion = $("#txtFechaFin").val();
	 var cadena = fProgramacion.split("/");
	 var d = cadena[0];
	 var m = cadena[1];
	 var a = cadena[2];
	 
	 var fechaProgramacion = m+"/"+d+"/"+a;
	 
	 var fInicio = $("#fechaActual").val();
	 var cadena = fInicio.split("/");
	 var d = cadena[0];
	 var m = cadena[1];
	 var a = cadena[2];
	 
	 var fechaInicio = m+"/"+d+"/"+a;

    $.ajax({
        url:baseURL + "pages/InspMantLimp/reprogramarCancelar",
        type:'post',
        async:false,
        data:{
            
            idProgramacion : idProgramacionAux,
                    estado : estadoRes,
                    fecha  : fechaProgramacion,
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            if(data.resultado=="0"){
            	var idUnidadSupervisada = $("#idUnidSupervisadaRevision").val();
                listarTanqueCL(0,idUnidadSupervisada);
                
                 $.ajax({
                        url:baseURL + "pages/InspMantLimp/RegistrarTrazProgramacion",
                        type:'post',
                        async:false,
                        data:{
                            
                            idProgramacion : idProgramacionAux,
                                    estado : estadoRes,
                         fechaUltimoEstado : fechaInicio,
                                    motivo : "",
                               observacion : "",
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
        },
        error:errorAjax
    }); 
}

function registrarDoc(){
    
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
    
    $.ajax({
	          url:baseURL + "pages/InspMantLimp/registrar",
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
        	  $('#nombreArchivoRR').text("")
        	  $("#btnAgregarDoc").attr('disabled','disabled');
              
        	  var idDocumentoAux  = data.idDocumento;
              var nombreDocumento = data.nombreDocumento;

          	  var objeto = {};

              objeto['idResultadoDocumento'] = idDocumentoAux;
              objeto['nombreDocumento'] = nombreDocumento ;

              dataDocumentA.push(objeto);
              arrayIdDocumentA.push(idDocumentoAux);   
              listarDocumentosLocal(0);
              
          }else{

          }
      },
      error:errorAjax
    });     
}

function registrarResultadoRev(estadoRes,idResultadoRevision){
		 
	idProgramacionAux     =  $("#idProgramacionRevision").val();
    resultadoRevisionAux  =  $(".estadoResultado").val();
    idPersonaJuridicaAux  =  $("#txtIdPersonaJuridica").val();
    
    if ( $("#txtFechaFin").val() == "" ||  $("#txtFechaFin").val() == undefined){
    	fechaFin = new Date( $("#txtFechaFin").val() );
    } else {
    	
         var fecFin =  $("#txtFechaFin").val();
         var cadena = fecFin.split("/");
    		 var df = cadena[0];
    		 var mf = cadena[1];
    		 var af = cadena[2];
        
       var fechaFin = mf+"/"+df+"/"+af;
    }
    
    if ( $("#txtFechaInicio").val() == "" ||  $("#txtFechaInicio").val() == undefined){
    	fechaInicio = new Date( $("#txtFechaInicio").val() );
    } else {

      var fecInicio =  $("#txtFechaInicio").val();	 
	     var cadena = fecInicio.split("/");
			 var di = cadena[0];
			 var mi = cadena[1];
			 var ai = cadena[2];
 
    var fechaInicio = mi+"/"+di+"/"+ai;
    }
    
    if(resultadoRevisionAux == 1){
    	var CmbResultado = 'C';    
    } else {
    	var CmbResultado = 'N';
    }
 	
    $.ajax({
        url:baseURL + "pages/InspMantLimp/registrarResultadoRevision",
        type:'post',
        async:false,
        data:{
            idResultadoRevision : idResultadoRevision,
            idProgramacion      : idProgramacionAux,
            fechaInicio         : fechaInicio,
            horaInicio          : $("#txtHoraInicioH").val() +"", 
            fechaFin            : fechaFin,
            horaFin             : $("#txtHoraFinH").val() +"",
            tipoPersonal        : $("#tipoPersonalAux").val(), 
            flagPersona         : $("#flagPersonaAux").val(),
            idPersonaJuridica   : idPersonaJuridicaAux,
            resultadoRevision   : CmbResultado, 
            observacion         : $("#txtDetalle").val().toUpperCase(),
            estadoResultado     : estadoRes,
            
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            var idUnidadSupervisada  =  $("#idUnidSupervisadaRevision").val();
             idResultadoRevisionAux  =  data.idResultadoRev;
             
            $("#idResultadoRevision").val(idResultadoRevisionAux);

            if(data.resultado=="0"){

        		actualizaEstadoProgramacion(estadoRes);
        		listarTanqueCL(0,idUnidadSupervisada);
        		
        		if (arrayIdPersonaN.length > 0) {
        	  		 registrarResultadoPersonaNaturalRV(idResultadoRevisionAux);
        		}
        			
        		if (arrayIdDocumentA.length > 0) {
        	  		 registrarResultadoDoc(idResultadoRevisionAux);
        		}
        		
        		listarPersonasLocal(0);
                listarDocumentosLocal(0);
                
            	arrayIdPersonaN.length=0;
            	arrayIdDocumentA.length=0;
            	
                $('#dialogFrmRevision').dialog('close'); 
                
                window.setTimeout('location.reload()', 1000);                                 	              
            }
            
        },
        error:errorAjax
    });  
}

function ResultadoRevFinalizar(estadoRes,idResultadoRevision){
	
   registrarResultadoRev(estadoRes,idResultadoRevision);   
}

function registrarResultadoDoc(idResultadoRevision){
 
  $.each(arrayIdDocumentA, function(index,value){
		
    var idDocumentoAdjunto_ = value;
		
    $.ajax({
        url:baseURL + "pages/InspMantLimp/registrarResultadoDocumento",
        type:'post',
        async:false,
        data:{
            idResultadoRevision: idResultadoRevision,
            idDocumentoAdjunto:  idDocumentoAdjunto_
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            if(data.resultado=="0"){
                //listarDocumentos(0);
                //mensajeGrowl("success", global.confirm.save, "");
            }
        },
        error:errorAjax
    }); 
    
  });
} 

function  consultarTbResultadoDocumentos(IdResultadoRevision,IdResultadoDocumento){
	
    $.ajax({
        url: baseURL + "pages/InspMantLimp/listarDocumentosArray",
        type:'post',
        async:false,
        data:{
           idResultadoRevision: IdResultadoRevision
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $.each(data.filas, function( index, value ) {

			  var idResultadoDocumento = value.idResultadoDocumento;
              
              if(idResultadoDocumento == IdResultadoDocumento){
            	  
            	  $.ajax({
            	        url:baseURL + "pages/InspMantLimp/eliminarRDoc",
            	        type:'post',
            	        async:false,
            	        data:{
            	            idResultadoDocumento: IdResultadoDocumento
            	        },
            	        beforeSend:muestraLoading,
            	        success:function(data){
            	            ocultaLoading();
            	            if(data.resultado=="0"){
            	                //listarDocumentos();
            	            	listarDocumentosLocal(0);
            	                //mensajeGrowl("success", global.confirm.delete, "");
            	            }else{
            	              

            	            }
            	        },
            	        error:errorAjax
            	    });
              } else {
            	  
              }
             
           });
        },
        error:errorAjax
    }); 
  
}

function  consultarTbResultadoPersonaNatural(IdResultadoRevision,IdResultadoPersonaNatural){

     $.ajax({
        url: baseURL + "pages/InspMantLimp/listarPersonasArray",
        type:'post',
        async:false,
        data:{
           idResultadoRevision: IdResultadoRevision
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
           $.each(data.filas, function( index, value ) {
			                
                var idResultadoPersonaNatural = value.idResultadoPersonaNatural;
                
                if(idResultadoPersonaNatural == IdResultadoPersonaNatural){
                	
               	 $.ajax({
                     url:baseURL + "pages/InspMantLimp/eliminarRPersonaAutorizado",
                     type:'post',
                     async:false,
                     data:{
                         idRPersonaN: IdResultadoPersonaNatural
                     },
                     beforeSend:muestraLoading,
                     success:function(data){
                         ocultaLoading();
                         if(data.resultado=="0"){
                         	listarPersonasLocal(0);
                         }else{
                             
                         }
                     },
                     error:errorAjax
                 });
               	 
                } else {
                	
                }
			
           });
           
		    listarPersonasLocal(0);

        },
        error:errorAjax
    });        
  }
 

function eliminarRPersonaAutorizado(IdPersonaNatural , IdResultadoPersonaNatural, IdResultadoRevision ){

	for (var i in dataPersonaN) {
	     if (dataPersonaN[i].idPersonaNatural== IdPersonaNatural) { //idResultadoPersonaNatural

	    	 //delete dataPersonaN[i];
	    	 dataPersonaN.splice(i, 1);
	    	 arrayIdPersonaN.splice(i, 1);
	    	 break;
	     }
	 }
	
	 listarPersonasLocal(0);
     
	  var IRV = IdResultadoRevision;
	  var IRPN = IdResultadoPersonaNatural;
	  
	  if(IRV !== 'undefined' ){
		  
		  consultarTbResultadoPersonaNatural(IdResultadoRevision,IdResultadoPersonaNatural);

	  } 
}

function eliminarDoc(IdResultadoRevision,IdResultadoDocumento){
	
	for (var i in dataDocumentA) {
	     if (dataDocumentA[i].idResultadoDocumento == IdResultadoDocumento) {

	    	 //delete dataPersonaN[i];
	    	 dataDocumentA.splice(i, 1);
	    	 arrayIdDocumentA.splice(i, 1);
	    	 break;
	     }
	 }
	
	
	listarDocumentosLocal(0);
	
	var IRV = IdResultadoRevision;
	var IRD = IdResultadoDocumento;
	  
	 if(IRV !== 'undefined' ){

		consultarTbResultadoDocumentos(IdResultadoRevision,IdResultadoDocumento);
	}
}

function listarPersonas(flg_load,IdResultadoRevision) {
    
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorPersonas").html("");
    
    var grid = $("<table>", {
        "id": "gridPersonas1"
    });
    
    var pager = $("<div>", {
        "id": "paginacionPersonas1"
    });
    
    $("#gridContenedorPersonas").append(grid).append(pager);
    
    var nombres = ['','', 'Nro', 'TIPO DOCUMENTO', 'NUMERO', 'PERSONA', 'TELEFONO','OPCION'];
    var columnas = [
        {name: "idPersonaNatural", sortable: false, hidden: true},
        {name: "n", width: 30, sortable: false, hidden: false, formatter:"NroFilasR"},
        {name: "tipoDocumento", width: 105, sortable: false, hidden: false, align: "center"},
        {name: "numeroDoc", width: 85, sortable: false, hidden: false, align: "center"},
        {name: "nombreCompleto", width: 130, sortable: false, hidden: false, align: "center"},
        {name: "telefono", width: 90, sortable: false, hidden: false, align: "center"},
        {name: "opcion", width: 110, sortable: false, hidden: false, align: "center", formatter:"OpcionR"}
    ]; 
   
        grid.jqGrid({       
          
          url: baseURL + "pages/InspMantLimp/listarPersonas",
          postData: {
            	idResultadoRevision: IdResultadoRevision
            },
            datatype: "json",
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
                root: "filas",
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
            	
                return "<a class='EditarRpersonal' id='"+ rowdata.idPersonaNatural +"' style='cursor: pointer;text-decoration:none;' ><u> Editar </u></a>" +"\t"+
                "<a class='EliminarRpersonal' id='"+ rowdata.idResultadoPersonaNatural +"' style='cursor: pointer;text-decoration:none;' ><u> Eliminar</u></a>";
 
            }
        });
}


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
    
    var nombres = ['','','','','','','', 'Nro', 'TIPO DOCUMENTO', 'NUMERO', 'PERSONA', 'TELEFONO','OPCION'];
    var columnas = [
        {name: "idPersonaNatural", sortable: false, hidden: true},
        {name: "idResultadoPersonaNatural", sortable: false, hidden: true},
        {name: "idResultadoRevision", sortable: false, hidden: true},
        {name: "apellidoPaterno", width: 5, sortable: false, hidden: true, align: "center"},
        {name: "apellidoMaterno", width: 5, sortable: false, hidden: true, align: "center"},
        {name: "idTipoDoc", width: 5, sortable: false, hidden: true, align: "center"},
        {name: "nombre", width: 5, sortable: false, hidden: true, align: "center"},
        {name: "n", width: 30, sortable: false, hidden: false, formatter:"NroFilasR"},
        {name: "tipoDocumento", width: 105, sortable: false, hidden: false, align: "center"},
        {name: "numeroDoc", width: 85, sortable: false, hidden: false, align: "center"},
        {name: "nombreCompleto", width: 130, sortable: false, hidden: false, align: "center"},
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
            	
            	
                return "<a class='EditarRpersonal' id='"+ rowdata.idPersonaNatural + "%"+ rowdata.apellidoPaterno+"%"+ rowdata.apellidoMaterno +"%"+ rowdata.tipoDocumento+"%"+ rowdata.numeroDoc +"%"+ rowdata.telefono +"%"+ rowdata.nombre +"%"+ rowdata.idTipoDoc + "%"+"' style='cursor: pointer;text-decoration:none;' ><u> Editar </u></a>" +"\t"+
                       "<a class='EliminarRpersonal' id='"+ rowdata.idPersonaNatural + "%"+ rowdata.idResultadoPersonaNatural +"%"+ rowdata.idResultadoRevision +"' style='cursor: pointer;text-decoration:none;' ><u> Eliminar</u></a>";
               
                n++;
            }
        });
}

function abrirInspectorAutorizadoA(idResultadoRevisionAux, idPRN){ 
    
    var title="";
    $.ajax({
        url:baseURL + "pages/InspMantLimp/abrirFrmResultadoPersonal", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogInspectorAutorizadoRR").html(data);
            
            $("#dialogNuevo").html(data);
            
            if(idPRN == "" || idPRN == "null")
                title="NUEVO PERSONAL AUTORIZADO";
            if(idPRN !== "" && idPRN !== "null")
               title="EDITAR PERSONAL AUTORIZADO";
            
            $("#dialogInspectorAutorizadoRR").dialog({
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

function listarCompartimientos(flg_load,idCompartimiento,resultadoRevision,estado) {
    
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorCompartimientos").html("");
    
    var grid = $("<table>", {
        "id": "gridCompartimiento"
    });
    
    var pager = $("<div>", {
        "id": "paginacionCompartimiento"
    });
    
    $("#gridContenedorCompartimientos").append(grid).append(pager);
        
    var nombres = ['COMPARTIMIENTO', 'CAPACIDAD', 'PRODUCTO', 'RESULTADO FINAL'];
    var columnas = [
        {name: "numero", width: 180, sortable: false, hidden: false, align: "center"},
        {name: "capacidad", width: 120, sortable: false, hidden: false, align: "center"},
        {name: "nombreLargoProducto", width: 120, sortable: false, hidden: false, align: "left"},
        {name: "resultadoFinal", width: 130, sortable: false, hidden: false, align: "center", formatter:"OpcionesRF"}
    ]; 
    
    grid.jqGrid({
        url: baseURL + "pages/InspMantLimp/listarCompartimientoPorId",
        datatype: "json",
        postData: {
            idCompartimiento: idCompartimiento
        },
        hidegrid: false,
        rowNum: 5,
        pager: "#paginacionCompartimiento",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Compartimientos",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            nombreEmpresa = rowData.razonSocial;
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });   
    jQuery.extend($.fn.fmatter, {
        OpcionesRF: function(cellvalue, options, rowdata) {
          
        if(estado == "EN_REGISTRO"){
        	
        	if(resultadoRevision == "C"){
            
                return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultado' style='width:120px'> <option value='1' selected> Conforme </option> <option value='2'> Tomar Accion </option> </select>";

            } else if(resultadoRevision == "N"){
            	
                return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultado' style='width:120px'> <option value='1'> Conforme </option> <option value='2'selected> Tomar Accion </option> </select>";

            } else {
                
            	return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultado' style='width:120px'><option value='1'> Conforme </option> <option value='2'> Tomar Accion </option> </select>";
            }
        
        } else if(estado == "NUEVO_REGISTRO"){
        	
        	    return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultado' style='width:120px'><option value='1'> Conforme </option> <option value='2'> Tomar Accion </option> </select>";
        
        } else {
        	
        	if(resultadoRevision == "C"){
                
                return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultado' style='width:120px;pointer-events: none;'> <option value='1' selected> Conforme </option> <option value='2'> Tomar Accion </option> </select>";

            } else if(resultadoRevision == "N"){
            	
                return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultado' style='width:120px;pointer-events: none;'> <option value='1'> Conforme </option> <option value='2'selected> Tomar Accion </option> </select>";

            } else {
                
            	return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultado' style='width:120px;pointer-events: none;'><option value='1'> Conforme </option> <option value='2'> Tomar Accion </option> </select>";
            }
        } 
        
        }
    });
}
//gridContenedorDocumentos

function listarDocumentos(flg_load,idResultadoRevision) {
    
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocumentos").html("");
    
    var grid = $("<table>", {
        "id": "gridDocumentos"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocumentos"
    });
    
    $("#gridContenedorDocumentos").append(grid).append(pager);
    
    var nombres = ['','DOCUMENTO', 'ARCHIVO', 'OPCION'];
    var columnas = [
        {name: "idResultadoDocumento", sortable: false, hidden: true, align: "center"},
        {name: "nombreDocumento", width: 140, sortable: false, hidden: false, align: "center"},
        {name: "archivo", width: 105, sortable: false, hidden: false, align: "center"},
        {name: "opcion", width: 60, sortable: false, hidden: false, align: "center", formatter:"OpLDE"}
    ]; 
        
    grid.jqGrid({
        url: baseURL + "pages/InspMantLimp/listarDocumentos",
        datatype: "json",
        postData: {
            idResultadoRevision: idResultadoRevision
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 5,
        pager: "#paginacionDocumentos",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Documentos",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            nombreEmpresa = rowData.razonSocial;
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    jQuery.extend($.fn.fmatter, {
        OpLDE: function(cellvalue, options, rowdata) {
            var iconbutton ='';
            //tex = "<a class='Eliminar' id='"+ rowdata.idAlcanceAcreditacion +"' src='images/cancel.png' style='cursor: pointer;text-decoration:none;' ></a>";
            iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='eliminarDoc' id='"+ rowdata.idResultadoDocumento +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"
            return iconbutton;
        }
    });
}

function listarDocumentosLocal(flg_load) {
    
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocumentos").html("");
    
    var grid = $("<table>", {
        "id": "gridDocumentos"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocumentos"
    });
    
    $("#gridContenedorDocumentos").append(grid).append(pager);
    
    var nombres = ['','','DOCUMENTO', '', 'ARCHIVO', 'OPCION'];
    var columnas = [
        {name: "idResultadoDocumento", sortable: false, hidden: true, align: "center"},
        {name: "idResultadoRevision", sortable: false, hidden: true, align: "center"},
        {name: "nombreDocumento", width: 140, sortable: false, hidden: false, align: "center"},
        {name: "archivoAdjunto", sortable: false, hidden: true, align: "center"},
        {name: "archivo", width: 105, sortable: false, hidden: false, align: "center", formatter:"ArchivoLDE"},
        {name: "opcion", width: 60, sortable: false, hidden: false, align: "center", formatter:"OpLDE"}
    ]; 
        
    grid.jqGrid({
        
    	data: dataDocumentA,
    	datatype: "local",
        hidegrid: false,
        rowNum: 5,
        pager: "#paginacionDocumentos",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Documentos",
        jsonReader: {
            root: "dataDocumentA",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            nombreEmpresa = rowData.razonSocial;
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    jQuery.extend($.fn.fmatter, {
        OpLDE: function(cellvalue, options, rowdata) {
            var iconbutton ='';
            //tex = "<a class='Eliminar' id='"+ rowdata.idAlcanceAcreditacion +"' src='images/cancel.png' style='cursor: pointer;text-decoration:none;' ></a>";
            iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='eliminarDoc' id='"+ rowdata.idResultadoRevision +"%"+ rowdata.idResultadoDocumento +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"
            return iconbutton;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	ArchivoLDE: function(cellvalue, options, rowdata) {
    		
    		return "<img src=\"" + baseURL + "/../images/file_doc.png\" class='DescargarDoc' id='"+ rowdata.nombreDocumento +"%"+ rowdata.archivoAdjunto +"' style=\"cursor: pointer;\" title=\"Descargar\"/>"
        		
        }
    });
}

function registrarResultadoPersonaNaturalRV(idResultadoRevision){
    
	$.each(arrayIdPersonaN, function(index,value){
		
		var idPersonaNatural = value ;
		var idRPersonaNatural="";
		 
		$.ajax({
	        url:baseURL + "pages/InspMantLimp/registrarResultadoPersonaNatural",
	        type:'post',
	        async:false,
	        data:{
	            idRPersonaNatural  : idRPersonaNatural,
	            idResultadoRevision: idResultadoRevision,
	            idPersonaNatural:    idPersonaNatural
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            
	            if(data.resultado=="0"){
	                //listarPersonas(0);
	                //mensajeGrowl("success", global.confirm.save, "");
	                //$('#dialogInspectorAutorizadoRR').dialog('close');
	            }
	        },
	        error:errorAjax
	    }); 
	})

}

function  llenarArrayTbDocumentos(IdResultadoRevision){

    $.ajax({
        url: baseURL + "pages/InspMantLimp/listarDocumentosArray",
        type:'post',
        async:false,
        data:{
           idResultadoRevision: IdResultadoRevision
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $.each(data.filas, function( index, value ) {

			  var idDocumentoAux  = value.idDocumentoAdjunto;
              var nombreDocumento = value.nombreDocumento;

          	  var objeto = {};

              objeto['idResultadoDocumento'] = idDocumentoAux;
              objeto['nombreDocumento'] = nombreDocumento ;

              dataDocumentA.push(objeto);
              //arrayIdDocumentA.push(idDocumentoAux); 
              listarDocumentosLocal(0);

           });
        },
        error:errorAjax
    }); 
}

function  llenarArrayTbPersonaNatural(IdResultadoRevision){

     $.ajax({
        url: baseURL + "pages/InspMantLimp/listarPersonasArray",
        type:'post',
        async:false,
        data:{
           idResultadoRevision: IdResultadoRevision
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
           $.each(data.filas, function( index, value ) {
			    
                var idPersonaNatural =  value.idPersonaNatural;
                var idResultadoPersonaNatural = value.idResultadoPersonaNatural;
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
			    objeto['idResultadoPersonaNatural'] = idResultadoPersonaNatural;
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
    	        //arrayIdPersonaN.push(idPersonaNatural);

           });
           
		    listarPersonasLocal(0);

        },
        error:errorAjax
    });        

 }

