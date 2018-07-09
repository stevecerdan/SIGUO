var idSolicitudPruebaReprueba;
var idResultadoPruebaReprueba;
var idCompartimiento;
var fechaProxPrueba;


$(function() {
	
	$( "#txtFechaProxima" ).datepicker();    
	initInicio();
	initDialogs();
});

function initInicio(){
    
	confirm.start();

	$('#btnGuardarFechaProx').click(function(){  		
    	confirm.open("¿Desea guardar el registro?","guardarFechaProx()");
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

function enviarIDs(idSolicitudPruebaReprueba,idResultadoPruebaReprueba,idCompartimiento){

	$('#IDSolicitudPruebaReprueba').val(idSolicitudPruebaReprueba);  
	$('#IDResultadoPruebaReprueba').val(idResultadoPruebaReprueba);    
	$('#IDCompartimiento').val(idCompartimiento);    	
}

function guardarFechaProx(){
	 
	  var FechaInforme =$("#txtFechaProxima").val();
    
		  if(FechaInforme.length <= 0) {
		    	
			  var addhtml2 = 'Ingrese una Fecha Próx. Prueba de Hermeticidad.';
			  $("#dialog-message-content").html(addhtml2);
			  $("#dialog-message").dialog("open");
				 
			  return false;
		   }
	
	  idSolicitudPruebaReprueba = $('#IDSolicitudPruebaReprueba').val();                 
      idResultadoPruebaReprueba = $('#IDResultadoPruebaReprueba').val();    
               idCompartimiento = $('#IDCompartimiento').val();    	
                fechaProxPrueba = convertDateFormat( $('#txtFechaProxima').val() );
      
      var objeto = {};
      
      objeto['idSolicitudPruebaReprueba'] = idSolicitudPruebaReprueba;
      objeto['idResultadoPruebaReprueba'] = idResultadoPruebaReprueba;
      objeto['idCompartimiento'] = idCompartimiento;
	  objeto['fechaProxPrueba'] =  fechaProxPrueba;

      dataFechaProx.push(objeto);
      
	  editarArray( idSolicitudPruebaReprueba,fechaProxPrueba );
	 
	 $('#dialogProxPruebaHermeticidad').dialog('close');
}

function editarArray( idSolicitudPruebaReprueba,fechaProxPrueba ) {

   for (var i in dataSolicitud) {
	 
     if (dataSolicitud[i].idSolicitudPruebaReprueba == idSolicitudPruebaReprueba) {
    	
		 dataSolicitud[i].fechaProxPrueba = fechaProxPrueba;
  
    	 break;
     }
   }

  listarSolicitudLocal(0);
  
  for (var i in dataFechaProx) {
      
	  $(".filaSeleccionada"+dataFechaProx[i].idSolicitudPruebaReprueba).prop('checked', true);
  }
  
  //alert('Guardando en Array'+ JSON.stringify(dataFechaProx));
	    
}

function convertDateFormat(string) {
	
	var info = string.split('/');
	return info[1] + '/' + info[0] + '/' + info[2];	
}
