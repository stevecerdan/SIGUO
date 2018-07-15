  var IdCompartimiento  =  "";
      var IdTipoPrueba  =  "";
   var dataInspectores  =  [];
       var dataEquipos  =  [];
var arrayIdInspectores  =  [];
    var arrayIdEquipos  =  [];
var arrayIdDocumentAdj  =  [];
   var dataDocumentAdj  =  [];
   var nombreDocumento  =  "";
var idDocumentoAdjunto  =  "";
          var resFinal  =  "H";
         var resPrueba  =  "A";
    var ResultadoFinal  =  "HERMÉTICO";
                var RC  =  "S";
                var RT  =  "S";
       var fechaInicio  =  "";
        var horaInicio  =  "";
          var fechaFin  =  "";
           var horaFin  =  "";
  var estadoResultadoC  =  "";
  var archivoAdjuntoM	=  "";
  var estadoResultadoT  =  "";
    var numCertificado  =  "";
        var numInforme  =  "";
       var observacion  =  "";
     var idResultadoPR  =  "";
   var estadoSolicitud  =  "";
    var estadoRegistro  =  "";
    var idSolicitudPR   =  "";
var  idEquipoComponente =  "";
var idResultadoPE       =  "";

//-- nuevos -

var avisoEst = "";
var Ncertificado = "";
var Ninforme = "";
var fechita = new Date();
var anioActual = fechita.getFullYear();

$(function() {
	fechaActual();
	listarDocumentosLocal(0);
	listarInspectorXResultado(0);
	//listarDocumentoXResultado(0);
	listarEquipoXResultado(0);
	initInicioResultadoPruebaHermeticidad();
	initDialogs();
	$('#MensajeValRInsp').hide();
	$('#MensajeValFormRPH').hide();
    //$('#btnGuardarRPH').click(btnGuardarResultadoPH);
    $( "#txtFechaInicioRPH" ).datepicker({ minDate: 0 });
	$( "#txtFechaFinRPH" ).datepicker({ minDate: 0 });
    $( "#txtFechaInicioRPH" ).attr( "readonly" , "readonly" );
    $( "#txtFechaFinRPH" ).attr( "readonly" , "readonly" );
    
});

//---- Formato Fecha ------------

function convertDateFormat(string) {
	var info = string.split('/');
	return info[1] + '/' + info[0] + '/' + info[2];	
}

//-------------------------------

function initInicioResultadoPruebaHermeticidad(){ 
	confirm.start();
	
	$("#txtFechaInicioRPH").click(function(){
		$('#MensajeValFormRPH').hide();
    });
	
	$('#txtFechaFinRPH').change(function(){
		
		var fir = $('#txtFechaInicioRPH').val();
		var ffr = $('#txtFechaFinRPH').val();
		var hir = $("#txtHoraInicioRPH").val();
		var hfr = $("#txtHoraFinRPH").val();
		
		//alert("Hora inicio: " +hir+" Hora fin: "+hfr);
		
		var vir = fir.split("/");
		var dir = vir[0];
		var mir = vir[1];
		var air = vir[2];

		var vfr = ffr.split("/");
		var dfr = vfr[0];
		var mfr = vfr[1];
		var afr = vfr[2];
		
		if(fir != ""){
			//validar que la fecha de inicio no sea mayor a la fecha fin
			if((dir > dfr && mir >= mfr && air >= afr) || (dir < dfr && mir > mfr && air >= afr) || (dir = dfr && mir > mfr && air >= afr)){
				$('#txtFechaFinRPH').val('');
				ConfirmDialogF("FECHA FIN NO VALIDA");
			}
			
			if( hir != "" && hfr != "" ) {
				if (fir = ffr){
					if( hir >= hfr ){
						$('#txtHoraFinRPH').val('');
						ConfirmDialogF("HORA FIN NO VALIDA");
					}
					
				}
			}
			
		}
		
	});


    $('#txtFechaInicioRPH').change(function(){
    	
    	var fir = $('#txtFechaInicioRPH').val();
		var ffr = $('#txtFechaFinRPH').val();
		var hir = $("#txtHoraInicioRPH").val();
		var hfr = $("#txtHoraFinRPH").val();
		
		var vir = fir.split("/");
		var dir = vir[0];
		var mir = vir[1];
		var air = vir[2];

		var vfr = ffr.split("/");
		var dfr = vfr[0];
		var mfr = vfr[1];
		var afr = vfr[2];
		
		if(ffr != ""){
			//validar que la fecha de inicio no sea mayor a la fecha fin
			if((dir > dfr && mir >= mfr && air >= afr) || (dir < dfr && mir > mfr && air >= afr) || (dir = dfr && mir > mfr && air >= afr)){
				$('#txtFechaInicioRPH').val('');
				ConfirmDialogF("FECHA INICIO NO VALIDA");
			}
			
			if( hir != "" && hfr != "" ) {
				if (fir = ffr){
					if( hir >= hfr ){
						$('#txtHoraInicioRPH').val('');
						ConfirmDialogF("HORA INICIO NO VALIDA");
					}
					
				}
			}
		}
	});
    
    $('#txtHoraInicioRPH').change(function(){
    	
    	var fir = $('#txtFechaInicioRPH').val();
		var ffr = $('#txtFechaFinRPH').val();
		var hir = $("#txtHoraInicioRPH").val();
		var hfr = $("#txtHoraFinRPH").val();
		
		var vir = fir.split("/");
		var dir = vir[0];
		var mir = vir[1];
		var air = vir[2];

		var vfr = ffr.split("/");
		var dfr = vfr[0];
		var mfr = vfr[1];
		var afr = vfr[2];
		
		var fIni = mir + "/" + dir + "/" + air;
		var fFin = mfr + "/" + dfr + "/" + afr; 
		
		if(Date.parse(fIni) == Date.parse(fFin)) {
			if (hfr != ""){
				if( hir >= hfr ){
					$('#txtHoraInicioRPH').val('');
					ConfirmDialogF("HORA INICIO NO VALIDA");
				}
			}
		}
		
	});
    
    $('#txtHoraFinRPH').change(function(){
    	
    	var fir = $('#txtFechaInicioRPH').val();
		var ffr = $('#txtFechaFinRPH').val();
		var hir = $("#txtHoraInicioRPH").val();
		var hfr = $("#txtHoraFinRPH").val();
		
		var vir = fir.split("/");
		var dir = vir[0];
		var mir = vir[1];
		var air = vir[2];

		var vfr = ffr.split("/");
		var dfr = vfr[0];
		var mfr = vfr[1];
		var afr = vfr[2];
		
		var fIni = mir + "/" + dir + "/" + air;
		var fFin = mfr + "/" + dfr + "/" + afr; 
		
		if(Date.parse(fIni) == Date.parse(fFin)) {
			if (hir != ""){
				if( hir >= hfr ){
					$('#txtHoraFinRPH').val('');
					ConfirmDialogF("HORA FIN NO VALIDA");
				}
			}
		}
		
	});
	
    //DescargarDocumentosRPH
    $('body').on('click', '.DescargarDocumentosRPH',function(){
		
	  var cadena= $(this).attr("id");
	  
	  var arrayCadena = cadena.split("%");
	  
	  var nombreDocumento = arrayCadena[0];
	  var archivoAdjunto = arrayCadena[1];
 	   
 	  console.log(archivoAdjunto);
 	  //var blob = new Blob([archivoAdjunto], {type: 'application/pdf'});
      var blob = b64toBlob(archivoAdjunto, 'application/pdf');
 	   
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
    
	$("#cmbInspectorPH").click(function(){
		$('#MensajeValRInsp').hide();
    });
	
	$("#btnAgregarInspector").click(function(){
		
    	if(validarComboInspector() == true){		
    		cargarArrayInspectores();
    		//ValidarComboLimpiarInspectores();
    	}else{   		
            $("#MensajeValRInsp").show(); 
    	}
    });
	
	$("#btnAgregarEquipoRPH").click(function(){
		
		if(validarComboComponente() == true){		
			cargarArrayComponente();
        	//var cmbC = document.getElementById("cmbComponentePH");
        	//cmbC.remove(document.getElementById("cmbComponentePH").selectedIndex);
    	}else{   		
            $("#MensajeValRInsp").show(); 
    	}
    });
	
	$("#cmbTipoEquipoPH").change(function(){
	    cargarEquipo();
	    $("#cmbComponentePH").val(0);
	});
	
	$("#uploadfile").change(function() {
	    
		var filename = $("#uploadfile")[0].files[0];
		
	    $('#nombreArchivo').text(filename.name); 
	    $("#btnAgregarDocRPH").prop("disabled", this.files.length == 0);
	  
	});
	
	 $('#btnAgregarDocRPH').click(function(){
	      
		 confirm.open("¿Desea guardar el registro?","registrarDoc()");
	 });
	        
	$('body').on('change', '.estadoResultadoC',function(){
	    RC = $(this).val();
	    RT = $(".estadoResultadoT").val();
	    
	    if(RC == 'S' && RT == 'S'){
			resFinal = 'H';
			resPrueba = 'A';
			$('#txtResultado').html("CONFORME");
			//Validacion
			if($('#estadoRegistro').val() == "EN_REGISTRO"){
				traerGenerarCodigo();
				if($('#txtNumeroCertificado').text()!="" && $('#txtNumeroInforme').text()!=""){
					
				}else{
					if($('#txtNumeroInforme').text()!=""){
						$('#txtNumeroInforme').html("");
					}else{
						if($('#txtNumeroCertificado').text()=="" && $('#txtNumeroInforme').text()==""){
							$('#txtNumeroCertificado').html("");
							$('#txtNumeroInforme').html("");
						}
					}
				}
			}else{
				if($('#estadoRegistro').val() == "NUEVO_REGISTRO"){
					$('#txtNumeroCertificado').html("");
					$('#txtNumeroInforme').html("");
				}
			}

		}else{
			
			resFinal = 'N';
			resPrueba = 'N';
			$('#txtResultado').html("NO CONFORME");
			//Validacion
			if($('#estadoRegistro').val() == "EN_REGISTRO"){
				traerGenerarCodigo();
				if($('#txtNumeroCertificado').text()!="" && $('#txtNumeroInforme').text()!=""){
					$('#txtNumeroCertificado').html("");
					$('#txtNumeroInforme').html("");
				}else{
					if($('#txtNumeroInforme').text()!=""){
						
					}else{
						if($('#txtNumeroCertificado').text()=="" && $('#txtNumeroInforme').text()==""){
							$('#txtNumeroCertificado').html("");
							$('#txtNumeroInforme').html("");
						}
					}
				}
			}else{
				if($('#estadoRegistro').val() == "NUEVO_REGISTRO"){
					$('#txtNumeroCertificado').html("");
					$('#txtNumeroInforme').html("");
				}
			}
		}
	    
	    listarCompartimientoXResultado();
	    
	});
	
	
	$('body').on('change', '.estadoResultadoT',function(){
	    RT = $(this).val();
	    RC = $(".estadoResultadoC").val();
	    
	    if(RC == 'S' && RT == 'S'){
			resFinal = 'H';
			resPrueba = 'A';
			$('#txtResultado').html("CONFORME");
			//Validacion
			if($('#estadoRegistro').val() == "EN_REGISTRO"){
				traerGenerarCodigo();
				if($('#txtNumeroCertificado').text()!="" && $('#txtNumeroInforme').text()!=""){
					
				}else{
					if($('#txtNumeroInforme').text()!=""){
						$('#txtNumeroInforme').html("");
					}else{
						if($('#txtNumeroCertificado').text()=="" && $('#txtNumeroInforme').text()==""){
							$('#txtNumeroCertificado').html("");
							$('#txtNumeroInforme').html("");
						}
					}
				}
			}else{
				if($('#estadoRegistro').val() == "NUEVO_REGISTRO"){
					$('#txtNumeroCertificado').html("");
					$('#txtNumeroInforme').html("");
				}
			}
		}else{
			resFinal = 'N';
			resPrueba = 'N';
			$('#txtResultado').html("NO CONFORME");
			//Validacion
			if($('#estadoRegistro').val() == "EN_REGISTRO"){
				traerGenerarCodigo();
				if($('#txtNumeroCertificado').text()!="" && $('#txtNumeroInforme').text()!=""){
					$('#txtNumeroCertificado').html("");
					$('#txtNumeroInforme').html("");
				}else{
					if($('#txtNumeroInforme').text()!=""){
						
					}else{
						if($('#txtNumeroCertificado').text()=="" && $('#txtNumeroInforme').text()==""){
							$('#txtNumeroCertificado').html("");
							$('#txtNumeroInforme').html("");
						}
					}
				}
			}else{
				if($('#estadoRegistro').val() == "NUEVO_REGISTRO"){
					$('#txtNumeroCertificado').html("");
					$('#txtNumeroInforme').html("");
				}
			}
		}
	    
	    listarCompartimientoXResultado();
	    
	});
	
	$("#cmbEquipoPH").change(function(){
		//cargarEquipoComponente();
		ValidarComboLimpiarComponentes();
	});
	
	$('#btnRegresarRPH').click(function() {
		if(avisoEst=='VER'){
			$('#dialogNuevaReprueba').dialog('close');
			tab('tab_02','panel_02');
    	}else{
    		if(avisoEst=='VRESULTADO'){
    			//$("#dialogVerResultadoPH").dialog('close');
        		window.location.href = baseURL+'pages/solicitudPruebasHermeticidad';
            	listarBandejaPruebaHermeticidad(0);
    		}else{
	    		if(avisoEst=='CONSULTA'){
	    			$("#dialogResultadoSolicitudPruebaHermeticidadAux").dialog('close');
	    			tab('tab_02','panel_02');
	    			//window.location.href = baseURL+'pages/resultadosPruebasHermeticidad';
		            //listarSolicitudesPendientesPruebaHermeticidad(0);
		        	//listarSolicitudesAtendidasPruebaHermeticidad(0);
	        	}else{
		    		window.location.href = baseURL+'pages/resultadosPruebasHermeticidad';
		            listarSolicitudesPendientesPruebaHermeticidad(0);
		        	listarSolicitudesAtendidasPruebaHermeticidad(0);
	        	}
    		}
    	}
	});
	
	$('#tab_01').click(function() {
		window.location.href = baseURL+'pages/resultadosPruebasHermeticidad';
	});
	
	$('#btnGenerarCodigo').click(function() {
		GenerarCodigoCorrelativo();
	});
	
	$('body').on('click', '#registroRV',function(){
		btnGuardarResultadoPH();   
	});
	 
	$('#btnGuardarRPH').click(function() {	
		camposQueFaltanRegistrar();
	});
    
	$('#btnFinRegistroRPH').click(function() {
		btnFinRegistroRPH();
	});
	
	$('body').on('click', '.EliminarDocumentosRPH',function(){
        
    	var cadena= $(this).attr("id");
        var arrayCadena=cadena.split("%");
        
        idDocumentoAdjunto = arrayCadena[0];
        idResultadoPD      = arrayCadena[1];
        
        confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarDoc('" + idResultadoPD + "','" + idDocumentoAdjunto + "')");
	});
 
	 $('body').on('click', '.EliminarEquipoRPH',function(){
	        
	    	var cadena= $(this).attr("id");
	        var arrayCadena=cadena.split("%");
	        
	        var idResultadoPruebaEquipo = arrayCadena[0];
	        var idEquipoComponente      = arrayCadena[1];
	        
	        confirm.open("¿Ud est&aacute; seguro de Eliminar?","EliminarEquipoRPH('" + idResultadoPruebaEquipo + "','" + idEquipoComponente + "')");
	 });
	 
	 $('body').on('click', '.EliminarInspectorXResultado',function(){
	    	
	    	var cadena= $(this).attr("id");
	        var arrayCadena=cadena.split("%");
	        
	        var idResultadoPruebaPersonal = arrayCadena[0];
	        var idSedePersonalAutorizado  = arrayCadena[1];
	       
	        confirm.open("¿Ud est&aacute; seguro de Eliminar?","EliminarInspectorXResultado('" + idResultadoPruebaPersonal + "','" + idSedePersonalAutorizado + "')");
	 });
 }

function b64toBlob(b64Data, contentType, sliceSize) {
  contentType = contentType || '';
  sliceSize = sliceSize || 512;

  var byteCharacters = atob(b64Data);
  var byteArrays = [];

  for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
    var slice = byteCharacters.slice(offset, offset + sliceSize);

    var byteNumbers = new Array(slice.length);
    for (var i = 0; i < slice.length; i++) {
      byteNumbers[i] = slice.charCodeAt(i);
    }

    var byteArray = new Uint8Array(byteNumbers);

    byteArrays.push(byteArray);
  }
    
  var blob = new Blob(byteArrays, {type: contentType});
  return blob;
}

function fechaActual(){
	
    $( "#fechaActual" ).datepicker({
	    dateFormat: "dd/mm/yy",
	    firstDay: 1
	}).datepicker("setDate", new Date());	
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

function ConfirmDialogF(mensaje){
	
	   $('<div id="nuevo"></div>').appendTo('body')
	   .html('<div id="aqui"> </div>')
	   .dialog({
	       modal: true, title: 'ERROR', zIndex: 10000, autoOpen: true,
	       width: 250, resizable: false,
	       buttons: {
	           Aceptar: function () {
	                               
	               $(this).dialog("close");
	           },
	       },
	       close: function (event, ui) {
	           $(this).remove();
	       }
	   });
	
 	var tex = "";
 	tex = '<h6>' + mensaje;
 	tex = tex + '</h6>';
 	$("#aqui").append(tex);
};

function camposQueFaltanRegistrar() {
	
    var fechaInicio = "";
       var fechaFin = "";
     var horaInicio = "";
        var horaFin = "";
 var numCertificado = "";
     var numInforme = "";
      var inspector = "";
         var equipo = "";
      var documento = "";
     var encontrado = "";
          	   	     
var txtFechaInicio = $("#txtFechaInicioRPH").val();
	   
   if(txtFechaInicio.length <= 0) {
			   
	   fechaInicio = '<span style="padding-left: 20px;">Seleccionar una fecha de inicio.</span><br>';
	    encontrado = 1;		 		
	} 
    
 var txtFechaFin = $("#txtFechaFinRPH").val();      
	
	 if(txtFechaFin.length <= 0) {
	  	
	     fechaFin = '<span style="padding-left: 20px;">Seleccionar una fecha de fin.</span><br>';
	   encontrado = 1;		  
	 }
  
 var txtHoraFinH = $("#txtHoraFinRPH").val();      
	
    if(txtHoraFinH.length <= 0) {
  	
	       horaFin = '<span style="padding-left: 20px;">Ingresar una hora de fin.</span><br>';
	    encontrado = 1;
     }

 var txtHoraInicioH = $("#txtHoraInicioRPH").val();      
		
 	 if(txtHoraInicioH.length <= 0) {
 	   	
 		 horaInicio = '<span style="padding-left: 20px;">Ingresar una hora de inicio.</span><br>';
 		 encontrado = 1;
 	 }
 	 
 var txtNumeroCertificado = $('#txtNumeroCertificado').text();
  	
  	 if(txtNumeroCertificado.length <= 0) {
  	   	
  	   	  numCertificado = '<span style="padding-left: 20px;">Ingresar Número de certificado.</span><br>';
  	       	  encontrado = 1;	
  	  }
  	   
 var txtNumeroInforme = $('#txtNumeroInforme').text();
	  	
  	if(txtNumeroInforme.length <= 0) {
  	   	
  	   	  numInforme = '<span style="padding-left: 20px;">Ingresar Número de informe.</span><br>';
  	      encontrado = 1;	
  	}
  	 
  if (dataInspectores.length <= 0) {
		
	      inspector = '<span style="padding-left: 20px;">Agregar inspector.</span><br>';
	     encontrado = 1;
  }
  
  if (dataEquipos.length <= 0) {
		
	         equipo = '<span style="padding-left: 20px;">Agregar equipo.</span><br>';
	     encontrado = 1;
  }
  
  if (dataDocumentAdj.length <= 0) {
		
	      documento = '<span style="padding-left: 20px;">Agregar documento.</span><br>';
	     encontrado = 1;
  }
 
if (encontrado == 1) {

	 //alert('encontro');
 	var addhtml2 = "Faltan campos obligatorios por llenar:"+"<br><br>"+ fechaInicio + fechaFin + horaInicio + horaFin + numCertificado+ numInforme + inspector + equipo + documento;
		
     $("#dialog-message-content_registroRV").html(addhtml2);		   
	 $("#dialog-message_registroRV").dialog("open");	
	
	 return false;

 } else {
	 //alert('no encontro');
	 btnGuardarResultadoPH();
 }

}

function validarDatosFormularioRPH(){
	
	if($("#txtFechaInicioRPH").val() =="" || $('#txtFechaInicioRPH').val() == undefined) {
		$('#MensajeValFormRPH').html("POR FAVOR COLOQUE LA FECHA DE INICIO");
        return false;  
    } 
	 
	return true;
}

function validarComboInspector(){

	if($("#cmbInspectorPH").val() == "" || $("#cmbInspectorPH").val() == undefined){
		$('#MensajeValRInsp').html("POR FAVOR SELECCIONE UN INSPECTOR");
		return false;
	}
	return true;
}

function validarComboComponente(){

	if($("#cmbComponentePH").val() == "" || $("#cmbComponentePH").val() == undefined){
		$('#MensajeValRInsp').html("POR FAVOR SELECCIONE UN COMPONENTE");
		return false;
	}
	return true;
}

function TraerDatosResPH(idSolicitudPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,idUnidSupervTanque,idResultadoPruebaReprueba,fechaSolicitud,estado){

	$('#EmpAcredRPH').val(idEmpresaAcreditada);
	$('#Compart').val(idCompartimiento);
	$('#idSolicitudPR').val(idSolicitudPruebaReprueba);
	$("#idResultadoPR").val(idResultadoPruebaReprueba);
	$('#estadoRegistro').val(estado);
	$('#txtFechaInicioRPH').val(fechaSolicitud);
	$('#idUnidadSupervisada').val(idUnidSupervTanque);
	$('#numCompartimiento').val(numeroCompartimiento);
	$('#numTanque').val(numeroTanque);
	
	if(estado == "NUEVO_REGISTRO"){
		  
		listarCompartimientoXResultado();
		cargarInspectores();
		cargarOperador(idUnidSupervTanque);
		cargarTipoEquipo();
		$('#titulo_panel').html("STE N° "+ numeroCompartimiento + " - TANQUE N° "+ numeroTanque);
		encontrarUnidadSupervisada(); 
			
	} else if(estado == "EN_REGISTRO"){
		  		
		//cargarInspectores();
		ValidarComboLimpiarInspectores()
		cargarOperador(idUnidSupervTanque);
		cargarTipoEquipo();
		$('#titulo_panel').html("STE N° "+ numeroCompartimiento + " - TANQUE N° "+ numeroTanque);
		listarResultadoPruebaReprueba(idResultadoPruebaReprueba);
		listarCompartimientoXResultado();
		llenarArrayTbDocumentos(idResultadoPruebaReprueba);
		cargarArrayConsultarInspectores();
		cargarArrayConsultarEquipoComponente(idResultadoPruebaReprueba);
		encontrarUnidadSupervisada(); 
	  
    } else if(estado == "CONSULTAR"){
		  
    	cargarInspectores();
    	cargarOperador(idUnidSupervTanque);
    	cargarTipoEquipo();
    	$('#titulo_panel').html("STE N° "+ numeroCompartimiento + " - TANQUE N° "+ numeroTanque);
		listarResultadoPruebaReprueba(idResultadoPruebaReprueba);
		listarCompartimientoXResultado();
		llenarArrayTbDocumentos(idResultadoPruebaReprueba);
		cargarArrayConsultarEquipoComponente(idResultadoPruebaReprueba);
		cargarArrayConsultarInspectores();

	}
	
}

function bloquearDesbloquearCampos(){
	
	$("#txtFechaInicioRPH").attr('disabled','disabled');
	$('#txtFechaFinRPH').attr('disabled','disabled');	
	$('#txtHoraInicioRPH').attr('disabled','disabled');
	$('#txtHoraFinRPH').attr('disabled','disabled');
	$('#txtObservacion').attr('disabled','disabled');
	$('#cmbInspectorPH').css({pointerEvents: "none"});
	$('#btnAgregarInspector').attr('disabled','disabled');
	$('#cmbTipoEquipoPH').css({pointerEvents: "none"});
	$('#cmbEquipoPH').css({pointerEvents: "none"});
	$('#cmbComponentePH').css({pointerEvents: "none"});
	$('#btnAgregarEquipoRPH').attr('disabled','disabled');
	$("#btnGuardarRPH").attr('disabled','disabled');
	$("#uploadfile").attr('disabled','disabled');
	$(".eliminarDoc").css({pointerEvents: "none"});
	$("#btnFinRegistroRPH").attr('disabled','disabled');
	$('.EliminarInspectorXResultado').css({pointerEvents: "none"});
	$('.EliminarEquipoRPH').css({pointerEvents: "none"});

}
//-------------------------------------- FUNCION DE BORRAR ITEMS YA INGRESADOS DEL COMBOBOX ------------------------------------

function ValidarComboLimpiarInspectores(){
	
	if($("#idResultadoPR").val() !== "null" || $("#idResultadoPR").val() == null || $("#idResultadoPR").val() == undefined){
		//alert($("#idResultadoPR").val());
		cargarInspectores();
		encontrarInspectoresTabla();
		//alert(arrayIdInspectores.length);
		if (arrayIdInspectores.length > 0){
			encontrarInspectoresIngresadosArray();
		}
	}else{
		//alert($("#idResultadoPR").val());
		cargarInspectores();
		//alert(arrayIdInspectores.length);
		if (arrayIdInspectores.length > 0){
			encontrarInspectoresIngresadosArray();
		}
	}
}

//Encontrar Inspectores Ingresados en el Array
function encontrarInspectoresIngresadosArray(){
	//var IdSPA = "";
	var cmbI = "";
	$.each(arrayIdInspectores, function(index,value){
		IdSPA  = value;
		if(IdSPA > 0){
		//No mostrarlos en el Combobox
		$("#cmbInspectorPH").val(IdSPA);
		cmbI = document.getElementById("cmbInspectorPH");
    	cmbI.remove(document.getElementById("cmbInspectorPH").selectedIndex);
    	}
	});	
}

//Encontrar Inspectores en la BDD
function encontrarInspectoresTabla() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/consultarResultadoPersonal",
        type:'post',
        async:false,
        data:{
        	idResultadoPruebaReprueba: $('#idResultadoPR').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            //array
            $.each(data.filas, function( index, value ) {
            	
            	$("#cmbInspectorPH").val(value.idSedePersonalAutorizado);
        		var cmbIT = document.getElementById("cmbInspectorPH");
            	cmbIT.remove(document.getElementById("cmbInspectorPH").selectedIndex);
            	
            });
                        
        },
        error:errorAjax
    });
}

function ValidarComboLimpiarComponentes(){
	
	if($("#idResultadoPR").val() !== "null" || $("#idResultadoPR").val() == null || $("#idResultadoPR").val() == undefined){
		//alert($("#idResultadoPR").val());
		cargarEquipoComponente();
		encontrarComponentesTabla();
		//alert(arrayIdInspectores.length);
		if (arrayIdEquipos.length > 0){
			encontrarComponentesIngresadosArray();
		}
	}else{
		//alert($("#idResultadoPR").val());
		cargarEquipoComponente();
		//alert(arrayIdInspectores.length);
		if (arrayIdEquipos.length > 0){
			encontrarComponentesIngresadosArray();
		}
	}
}

//Encontrar Componentes Ingresados en el Array
function encontrarComponentesIngresadosArray(){
	//var IdEC = "";
	var cmbC = "";
	$.each(arrayIdEquipos, function(index,value){
		IdEC  = value;
		if(IdEC > 0){
		//No mostrarlos en el Combobox
		$("#cmbComponentePH").val(IdEC);
		cmbC = document.getElementById("cmbComponentePH");
    	cmbC.remove(document.getElementById("cmbComponentePH").selectedIndex);
    	}
	});	
}

//Encontrar componentes en la BDD
function encontrarComponentesTabla() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/consultarResultadoEquipoComp",
        type:'post',
        async:false,
        data:{
        	idResultadoPruebaReprueba: $('#idResultadoPR').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            //array
            $.each(data.filas, function( index, value ) {
            	
            	$("#cmbComponentePH").val(value.idEquipoComponente);
        		var cmbCT = document.getElementById("cmbComponentePH");
            	cmbCT.remove(document.getElementById("cmbComponentePH").selectedIndex);
            	
            });
                        
        },
        error:errorAjax
    });
}

//----------------------------------------------------------------------------------------------------------------------

//ELIMINAR RESULTADO INSPECTOR
function EliminarInspectorXResultado(idResultadoPruebaPersonal,idSedePersonalAutorizado ){
	
	for (var i in dataInspectores) {
	     if (dataInspectores[i].idSedePersonalAutorizado == idSedePersonalAutorizado) {

	    	 dataInspectores.splice(i, 1);
	    	 arrayIdInspectores.splice(i, 1);
	    	 break;
	     }
	 }
	
	listarInspectorXResultado(0);
	
	//alert(idResultadoPruebaPersonal);

	 if(idResultadoPruebaPersonal !== 'undefined'){
	
		 eliminarResultadoPruebaPersonal(idResultadoPruebaPersonal);
	 }
	 
	 ValidarComboLimpiarInspectores();
	 
}

function eliminarResultadoPruebaPersonal(idResultadoPruebaPersonal){

	$.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/eliminarResultadoPruebaPersonal",
        type:'post',
        async:false,
        data:{
        	
        	idResultadoPruebaPersonal : idResultadoPruebaPersonal
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){

            	listarInspectorXResultado(0);
                
            }else{
              

            }
        },
        error:errorAjax
    });

}
//------------------FIN-------------------------------------------

//ELIMINAR RESULTADO DOCUMENTO Y DOCUMENTO ADJUNTO

function eliminarDoc(idResultadoPruebaDocumento , idDocumentoAdjunto ){
	
	for (var i in dataDocumentAdj) {
	     if (dataDocumentAdj[i].idDocumentoAdjunto == idDocumentoAdjunto) {

	    	 dataDocumentAdj.splice(i, 1);
	    	 arrayIdDocumentAdj.splice(i, 1);
	    	 break;
	     }
	 }
	
	 listarDocumentosLocal(0);
	 
	 
	 if(idDocumentoAdjunto !== 'undefined' ){
		 
			eliminarDocumentoAdjunto(idDocumentoAdjunto);
	 }
	 
	// alert(idResultadoPruebaDocumento);
	 if(idResultadoPruebaDocumento !== 'undefined' ){

			eliminarResultadoPruebaDocumento(idResultadoPruebaDocumento);
	 }
}

function eliminarDocumentoAdjunto(idDocumentoAdjunto){
 	  
	  $.ajax({
	        url:baseURL + "pages/resultadosPruebasHermeticidad/eliminarDocumentoAdjunto",
	        type:'post',
	        async:false,
	        data:{
	        	
	        	idDocumentoAdjunto: idDocumentoAdjunto
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){
	            	listarDocumentosLocal(0);
	                
	            }else{
	              

	            }
	        },
	        error:errorAjax
	    });
}

function eliminarResultadoPruebaDocumento(idResultadoPruebaDocumento){
	
	  $.ajax({
	        url:baseURL + "pages/resultadosPruebasHermeticidad/eliminarResultadoPruebaDocumento",
	        type:'post',
	        async:false,
	        data:{
	        	
	        	idResultadoPruebaDocumento: idResultadoPruebaDocumento
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){

	            	listarDocumentosLocal(0);
	                
	            }else{
	              

	            }
	        },
	        error:errorAjax
	    });
	
}

//---------------------------- FIN ------------------------------------------

//ELIMINAR RESULTADO EQUIPO 
function EliminarEquipoRPH(idResultadoPruebaEquipo, idEquipoComponente ){
	
	for (var i in dataEquipos) {
	     if (dataEquipos[i].idEquipoComponente == idEquipoComponente) {

	    	 dataEquipos.splice(i, 1);
	    	 arrayIdEquipos.splice(i, 1);
	    	 break;
	     }
	 }
	
	listarEquipoXResultado(0);
	
	 if(idResultadoPruebaEquipo !== 'undefined'){
		 
		 eliminarResultadoPruebaEquipo(idResultadoPruebaEquipo);
	 }
	 
	 ValidarComboLimpiarComponentes();

}

function eliminarResultadoPruebaEquipo(idResultadoPruebaEquipo){
	
	 $.ajax({
	        url:baseURL + "pages/resultadosPruebasHermeticidad/eliminarResultadoPruebaEquipo",
	        type:'post',
	        async:false,
	        data:{
	        	
	        	idResultadoPruebaEquipo : idResultadoPruebaEquipo
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){

	            	listarEquipoXResultado(0);
	                
	            }else{
	              

	            }
	        },
	        error:errorAjax
	    });
}
//------------------- FIN -------------------------------------------

function listarResultadoPruebaReprueba(idResultadoPruebaReprueba){
	
    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/listarResultadoPruebaReprueba",
        type:'post',
        async:false,
        data:{
        	idResultadoPruebaReprueba  : idResultadoPruebaReprueba,                
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
                         
            $.each(data.filas, function( index, value ) {
            	
            	var resultado;
            	
            	switch (value.resultadoPrueba) {
            	    
            	    case "A":
            	    	resultado = "CONFORME";
            	        break;
            	    case "C":
            	    	resultado = "CONDENADO";
            	        break;
            	    case "N":
            	    	resultado = "NO CONFORME";
            	        break;
            	    case "R":
            	    	resultado = "RECHAZADO";
            	}

            	$("#txtFechaInicioRPH").val(convertirFecha(value.fechaInicio));
            	$("#txtFechaFinRPH").val(convertirFecha(value.fechaFin));
            	$("#txtHoraInicioRPH").val(value.horaInicio);
            	$("#txtHoraFinRPH").val(value.horaFin);
            	$('#txtNumeroCertificado').html(value.numeroCertificado);
            	$('#txtNumeroInforme').html(value.numeroInforme);
            	$('#txtObservacion').val(value.observacion);
    			$('#txtResultado').html(resultado);

	            RC = value.flagResultadoCompartimiento;
	            RT = value.flagResutadoTuberia;
	            resFinal = value.flagResultadoFinal;

	            //RF = value.flagResultadoFinal;
	            
	            /*if(RF == "H"){
	            	
	            	ResultadoFinal = "HERMÉTICO";
	           
	            } else { 
	            	
	            	ResultadoFinal = "NO HERMÉTICO";
	            }*/
            	           	
            });
            
        },
        error:errorAjax
    });
}

function  llenarArrayTbDocumentos(idResultadoPruebaReprueba){

    $.ajax({
        url: baseURL + "pages/resultadosPruebasHermeticidad/listarDocumentosArray",
        type:'post',
        async:false,
        data:{
          idResultadoPruebaReprueba : idResultadoPruebaReprueba
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $.each(data.filas, function( index, value ) {

            	      idResultadoPD = value.idResultadoPruebaDocumento;
                      idResultadoPR = value.idResultadoPruebaReprueba;
            	 idDocumentoAdjunto = value.idDocumentoAdjunto;
                    nombreDocumento = value.nombreDocumento;
                    archivoAdjuntoM = value.archivoAdjunto;

              	  var objeto = {};
              	  
              	  objeto['idResultadoPruebaDocumento'] = idResultadoPD;
              	  objeto['idResultadoPruebaReprueba'] = idResultadoPR;
                  objeto['idDocumentoAdjunto'] = idDocumentoAdjunto;
                  objeto['nombreDocumento'] = nombreDocumento ;
                  objeto['archivoAdjunto'] = archivoAdjuntoM ;

                  dataDocumentAdj.push(objeto);
                  listarDocumentosLocal(0);

           });
        },
        error:errorAjax
    }); 
}

/*function cargarConsultarDatosRPruebaHermeticidad(idCompartimiento,empresaAcreditada,fechaSolicitud,fechaProxPruebaHermet,estado){
	
	$('#idCompartimiento').val(idCompartimiento);
	$('#txtFecha').val(fechaSolicitud);
	$('#txtFechaP').val(fechaProxPruebaHermet);
	
	if(estado=="P"){
		$('#lblFechaP').hide();
		$('#txtFechaP').hide();
	}else{
		$('#lblFechaP').show();
		$('#txtFechaP').show();
		$('#txtFechaP').attr('disabled','disabled');
	}
	
	$("#cmbAsignado").append('<option value ="" selected="selected">' + empresaAcreditada + '</option>');
	
	$('#aviso').val('consulta');
	
	$('#txtFecha').attr('disabled','disabled');
	$('#cmbAsignado').attr('disabled','disabled');
	
	listarSTEinspeccionar();
	$('#btnGuardarPH').hide();
	
}*/

function btnGuardarResultadoPH(){
	
   estadoSolicitud =  "E";
   idResultadoPR   =  $("#idResultadoPR").val();
   estadoRegistro  =  $("#estadoRegistro").val();
   
   if(estadoRegistro == "EN_REGISTRO"){
   	
   	   //confirm.open("Faltan campos obligatorios por llenar. ¿Desea guardar el registro?","RegistrarResultadoPruebaHermeticidad('" + estadoSolicitud +"','"+ idResultadoPR +"')");
   	   confirm.open("¿Desea guardar el registro?","RegistrarResultadoPruebaHermeticidad('" + estadoSolicitud +"','"+ idResultadoPR +"')");
   	
   } else if(estadoRegistro == "NUEVO_REGISTRO"){
   	
   	   //confirm.open("Faltan campos obligatorios por llenar. ¿Desea guardar el registro?","RegistrarResultadoPruebaHermeticidad('" + estadoSolicitud +"','"+ idResultadoPR +"')");
   	   confirm.open("¿Desea guardar el registro?","RegistrarResultadoPruebaHermeticidad('" + estadoSolicitud +"','"+ idResultadoPR +"')");
   }
}

function btnFinRegistroRPH(){

	estadoSolicitud =  "I";
    idResultadoPR   =  $("#idResultadoPR").val();
    estadoRegistro  =  $("#estadoRegistro").val();
    
    
    var txtFechaInicio = $("#txtFechaInicioRPH").val();
	   
	   if(txtFechaInicio.length <= 0) {
		   
		   var addhtml2 = 'Ingrese una fecha de inicio.';
		   $("#dialog-message-content").html(addhtml2);
		   $("#dialog-message").dialog("open");
				 
			return false;
	   }
	   
	var txtFechaFin =$("#txtFechaFinRPH").val();
	    
	   if(txtFechaFin.length <= 0) {
	    	
		    var addhtml2 = 'Ingrese una fecha de fin.';
			$("#dialog-message-content").html(addhtml2);
			$("#dialog-message").dialog("open");
			 
			return false;
	    }
	   
	var txtHoraInicioH = $("#txtHoraInicioRPH").val();      
		
	   if(txtHoraInicioH.length <= 0) {
	   	
	   	 var addhtml2 = 'Ingrese una hora de inicio.';
			 $("#dialog-message-content").html(addhtml2);
			 $("#dialog-message").dialog("open");
			 
	        return false;
	   }
	   
	var txtHoraFinH = $("#txtHoraFinRPH").val();      
		
	   if(txtHoraFinH.length <= 0) {
	   	
	   	 var addhtml2 = 'Ingrese una hora de fin.';
			 $("#dialog-message-content").html(addhtml2);
			 $("#dialog-message").dialog("open");
			 
	         return false;
	   } 
	   
	   if (dataDocumentAdj.length <= 0) {
			
		    var addhtml2 = 'Falta agregar documento .';
			$("#dialog-message-content").html(addhtml2);
			$("#dialog-message").dialog("open");
		 
           return false;
	    }
	   
	   if (dataInspectores.length <= 0) {
			
		    var addhtml2 = 'Seleccione un Inspector .';
			$("#dialog-message-content").html(addhtml2);
			$("#dialog-message").dialog("open");
		 
          return false;
	    }
	   
	   if (dataEquipos.length <= 0) {
			
		    var addhtml2 = 'Seleccione un Equipo .';
			$("#dialog-message-content").html(addhtml2);
			$("#dialog-message").dialog("open");
		 
         return false;
	    }	   

    
    if(estadoRegistro == "EN_REGISTRO"){
       	
       	confirm.open("No podrá realizar cambios. ¿Desea finalizar el registro?","RegistrarResultadoPruebaHermeticidad('" + estadoSolicitud +"','"+ idResultadoPR +"')");
       	
    } else if(estadoRegistro == "NUEVO_REGISTRO"){
       	
       	confirm.open("No podrá realizar cambios. ¿Desea finalizar el registro?","RegistrarResultadoPruebaHermeticidad('" + estadoSolicitud +"','"+ idResultadoPR +"')");
    }
}

function RegistrarResultadoPruebaHermeticidad(estadoSolicitud,idResultadoPruebaReprueba){
	
    if(idResultadoPruebaReprueba !== 'null'){
		
    	idResultadoPR = idResultadoPruebaReprueba;
		
	} else {
		
		idResultadoPR = "";
	}
    
	if ( $("#txtFechaInicioRPH").val() == "" ||  $("#txtFechaInicioRPH").val() == undefined){
    	
		 fechaInicio = new Date( $("#txtFechaInicioRPH").val());
		 
	 } else {
	    	
		 fechaInicio = convertDateFormat($("#txtFechaInicioRPH").val());  
	 }
    
    if ( $("#txtFechaFinRPH").val() == "" ||  $("#txtFechaFinRPH").val() == undefined){
	    	
		 fechaFin = new Date(null);
		 
	 } else {
	    	
		 fechaFin = convertDateFormat($("#txtFechaFinRPH").val());  
	 }
              
        idSolicitudPR  =  $('#idSolicitudPR').val();
           horaInicio  =  $('#txtHoraInicioRPH').val();
              horaFin  =  $('#txtHoraFinRPH').val();
     estadoResultadoC  =  $('.estadoResultadoC').val();
     estadoResultadoT  =  $('.estadoResultadoT').val();
       numCertificado  =  $('#txtNumeroCertificado').text();
           numInforme  =  $('#txtNumeroInforme').text();
          observacion  =  $('#txtObservacion').val();
     
     $.ajax({
         url:baseURL + "pages/resultadosPruebasHermeticidad/registrarResultadoPruebaReprueba",
        type:'post',
       async:false,
        data:{
        	
        	idResultadoPR  : idResultadoPR,
        	idSolicitudPR  : idSolicitudPR,
       flagResultadoFinal  : resFinal,
          resultadoPrueba  : resPrueba,
        	  fechaInicio  : fechaInicio,
        	     fechaFin  : fechaFin,
        	   horaInicio  : horaInicio,
        	      horaFin  : horaFin,
         estadoResultadoC  : estadoResultadoC, 
         estadoResultadoT  : estadoResultadoT,
           numCertificado  : numCertificado,
        	   numInforme  : numInforme, 
        	  observacion  : observacion,                     
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
               
  	            if(data.resultado=="0"){ 	            	
  	            	
  	            	idResultadoPR  =  data.idResultadoPruebaReprueba;
                         
                    $("#idResultadoPR").val(idResultadoPR);
                    
	            	actualizarEstadoSolicitudPruebaReprueba(estadoSolicitud,idSolicitudPR);
                    
                    listarSolicitudesPendientesPruebaHermeticidad();
                	listarSolicitudesAtendidasPruebaHermeticidad();
	            
                	if (arrayIdDocumentAdj.length > 0) {
	            		 //alert("Documentos :"+arrayIdDocumentAdj.length);
	        	  		 registrarResultadoDoc(idResultadoPR);
	        		}
	            	
	            	if (arrayIdInspectores.length > 0) {
	            		// alert("Inspector :"+arrayIdInspectores.length);

	            		registrarResultadoPruebaPersonal(idResultadoPR);
	        		}
	            	
	            	if (arrayIdEquipos.length > 0) {
	            		 //alert("Equipo :"+arrayIdEquipos.length);
	            		registrarResultadoPruebaEquipo(idResultadoPR);
	            	}
	            	
	            	listarDocumentosLocal(0);
	             	arrayIdDocumentAdj.length=0;
	             	arrayIdInspectores.length=0;
	             	arrayIdEquipos.length=0;
	             	
	             	//$('#dialogResultadoSolicitudPruebaHermeticidad').dialog('close'); 
	             	window.location.href = baseURL+'pages/resultadosPruebasHermeticidad';
	            }
            
        },
        error:errorAjax
    });
     
}

function registrarResultadoPruebaEquipo(idResultadoPruebaReprueba) {
	
    $.each(arrayIdEquipos, function(index,value){
		
    	  idEpoComponente  = value;
		    idResultadoPR  = idResultadoPruebaReprueba;
		    
			$.ajax({
		        url:baseURL + "pages/resultadosPruebasHermeticidad/registrarResultadoPruebaEquipo",
		        type:'post',
		        async:false,
		        data:{
		        	
		        	idResultadoPE  : "",
		        	idResultadoPR  : idResultadoPR,
		        idEquipoComponente : idEpoComponente
		        },
		        beforeSend:muestraLoading,
		        success:function(data){
		            ocultaLoading();
		                idUnidadSupervisada  =  $("#idUnidadSupervisada").val();
		                      idResultadoPR  =  $("#idResultadoPR").val();
		             
			            if(data.resultado=="0"){
					        		                          	              
			            }
		            
		        },
		        error:errorAjax
		    });
    });
}

function registrarResultadoPruebaPersonal(idResultadoPruebaReprueba) {
	 
	$.each(arrayIdInspectores, function(index,value){
		
		idSedePersonal = value;
		idResultadoPR  = idResultadoPruebaReprueba;
		
		$.ajax({
	        url:baseURL + "pages/resultadosPruebasHermeticidad/registrarResultadoPruebaPersonal",
	        type:'post',
	        async:false,
	        data:{
	        	
	        	idResultadoPP  : "",
	        	idResultadoPR  : idResultadoPR,
	        	idSedePersonal : idSedePersonal
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	                idUnidadSupervisada  =  $("#idUnidadSupervisada").val();
	                      idResultadoPR  =  $("#idResultadoPR").val();
	             
		            if(data.resultado=="0"){
				        		                          	              
		            }
	            
	        },
	        error:errorAjax
	    });
	});
}

function registrarDoc(){
    
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
    
    $.ajax({
	          url:baseURL + "pages/resultadosPruebasHermeticidad/registrarDocumento",
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
        	  $("#btnAgregarDocRPH").attr('disabled','disabled');
              
        	      idResultadoPD = "";
        	 idDocumentoAdjunto = data.idDocumento;
                nombreDocumento = data.nombreDocumento;

          	  var objeto = {};
          	  
          	  objeto['idResultadoPruebaDocumento'] = idResultadoPD;
              objeto['idDocumentoAdjunto'] = idDocumentoAdjunto;
              objeto['nombreDocumento'] = nombreDocumento ;

              dataDocumentAdj.push(objeto);
              arrayIdDocumentAdj.push(idDocumentoAdjunto);   
              listarDocumentosLocal(0);
              
          }else{

          }
      },
      error:errorAjax
    });     
}

function registrarResultadoDoc(idResultadoPruebaReprueba){
	 
	  $.each(arrayIdDocumentAdj, function(index,value){
			
	    idDocumentoAdjunto = value;
	         idResultadoPR = idResultadoPruebaReprueba;
			
	    $.ajax({
	        url:baseURL + "pages/resultadosPruebasHermeticidad/registrarResultadoDocumento",
	        type:'post',
	        async:false,
	        data:{
	        	
	        	idResultadoPruebaReprueba : idResultadoPR,
	            idDocumentoAdjunto        : idDocumentoAdjunto,
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

function actualizarEstadoSolicitudPruebaReprueba(estadoSolicitud,idSolicitudPruebaReprueba){

	$.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/actualizarEstadoSolicitudPruebaReprueba",
        type:'post',
        async:false,
        data:{
            
         idSolicitudPruebaRp : idSolicitudPruebaReprueba,
                      estado : estadoSolicitud,

        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            if(data.resultado=="0"){
           	                
                 $.ajax({
                        url:baseURL + "pages/resultadosPruebasHermeticidad/registrarPhgTrazSolicitud",
                        type:'post',
                        async:false,
                        data:{
                            
                           idSolicitudTraz : "",
                              idTipoMotivo : "",
                       idSolicitudPruebaRp : idSolicitudPruebaReprueba,
                                    estado : estadoSolicitud,
                                     fecha : convertDateFormat($("#fechaActual").val()) ,
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

function cargarOperador(idUnidadSupervisada) {
	
    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/cargarOperador",
        type:'post',
        async:false,
        data:{
        	idUnidadSupervisada:idUnidadSupervisada
        },
        beforeSend:muestraLoading,
        success:function(data){
        	  ocultaLoading();
         	 $.each(data.filas, function( index, value ) {
         		$("#txtNombreEmp").text(value.razonSocial);
         		$("#txtRH").text(value.numeroIdentificacion);
         		$("#txtUnidadSupervisada").text(value.nombreUnidad);
         		$("#txtDireccion").text(value.direccion);
         	 });
            
        },
        error:errorAjax
    });
}

//----- CARGAR INSPECTORES ----------
function cargarInspectores() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/cargarInspector",
        type:'post',
        async:false,
        data:{
        	idEmpresaAcreditada: $('#EmpAcredRPH').val(),
            idTipoPrueba :'1467',
            flagSedePersonalAutoriazado : 'S'
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idSedePersonalAutorizado','nombreCompleto','#cmbInspectorPH');
                        
        },
        error:errorAjax
    });
}

//----- CARGAR TIPO EQUIPO ----------
function cargarTipoEquipo() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/cargarTipoEquipo",
        type:'post',
        async:false,
        data:{
        	idEmpresaAcreditada: $('#EmpAcredRPH').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idTipoEquipo','tipoEquipo','#cmbTipoEquipoPH');
                        
        },
        error:errorAjax
    });
}

//----- CARGAR EQUIPO CERTIFICADO ----------
function cargarEquipo() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/cargarEquipo",
        type:'post',
        async:false,
        data:{
        	idEmpresaAcreditada: $('#EmpAcredRPH').val(),
        	idTipoEquipo : $("#cmbTipoEquipoPH").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idEquipoCertificado','descripcionEquipo','#cmbEquipoPH');
                        
        },
        error:errorAjax
    });
}

//----- CARGAR EQUIPO COMPONENTE ----------
function cargarEquipoComponente() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/cargarEquipoComponente",
        type:'post',
        async:false,
        data:{
        	idEmpresaAcreditada: $('#EmpAcredRPH').val(),
        	idEquipoCertificado : $("#cmbEquipoPH").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idEquipoComponente','componenteTanque','#cmbComponentePH');
                        
        },
        error:errorAjax
    });
}

//----- CARGAR CONTENEDOR INSPECTORES ----------
function cargarArrayInspectores() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/cargarSedePersonalAutorizado",
        type:'post',
        async:false,
        data:{
        	idSedePersonalAutorizado: $('#cmbInspectorPH').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            //array
            $.each(data.filas, function( index, value ) {
            	
            	var idSedePersonalAutorizado = value.idSedePersonalAutorizado;
            	var tipoDocumento = value.tipoDocumento;
            	var numeroDocumento = value.numeroDocumento;
            	var nombre = value.nombre;
            	var apellidoPaterno = value.apellidoPaterno;
            	var apellidoMaterno = value.apellidoMaterno;
            	
            	var objeto = {};
            	
            	objeto['idSedePersonalAutorizado'] = idSedePersonalAutorizado;
            	objeto['tipoDocumento'] = tipoDocumento;
            	objeto['numeroDocumento'] = numeroDocumento;
            	objeto['nombre'] = nombre;
            	objeto['apellidoPaterno'] = apellidoPaterno;
            	objeto['apellidoMaterno'] = apellidoMaterno;
            	
            	dataInspectores.push(objeto);
            	arrayIdInspectores.push(idSedePersonalAutorizado);
            	listarInspectorXResultado(0);
            	
            });
            
            ValidarComboLimpiarInspectores();
                        
        },
        error:errorAjax
    });
}

function listarInspectorXResultado(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorInspectorXResultado").html("");
    
    var grid = $("<table>", {
        "id": "gridInspectorXResultado"
    });
    
    var pager = $("<div>", {
        "id": "paginacionInspectorXResultado"
    });
    
    $("#gridContenedorInspectorXResultado").append(grid).append(pager);
    
    var nombres = ['','','TIPO','N&Uacute;MERO','NOMBRES','APELLIDO PATERNO','APELLIDO MATERNO','OPCI&Oacute;N'];
    var columnas = [
    	{name: "idResultadoPruebaPersonal",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "idSedePersonalAutorizado",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "tipoDocumento",width: 80, sortable: false, hidden: false, align: "left"},
    	{name: "numeroDocumento",width: 120, sortable: false, hidden: false, align: "left"},
    	{name: "nombre",width: 120, sortable: false, hidden: false,align: "left"},
    	{name: "apellidoPaterno",width: 130, sortable: false, hidden: false,align: "left"},
    	{name: "apellidoMaterno",width: 130, sortable: false, hidden: false,align: "left"},
        {name: "opcion",width: 80, sortable: false, hidden: false, align: "center", formatter:"OpcionesIXR"}
        
     ];
	grid.jqGrid({
        data: dataInspectores,
        datatype: "local",
        hidegrid: false,
        rowNum: 2,
        pager: "#paginacionInspectorXResultado",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        //caption: "STE a Inspeccionar",
        jsonReader: {
            root: "dataInspectores",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
	//Botones Links
    jQuery.extend($.fn.fmatter, {
    	OpcionesIXR: function(cellvalue, options, rowdata) {
    		
    		if($('#AvisoEvento').val()=="CONSULTA"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    			
        		return "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarInspectorXResultado' id='"+ rowdata.idResultadoPruebaPersonal +"%"+ rowdata.idSedePersonalAutorizado +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"
        		
        	}
        }
    });
	
}

function listarCompartimientoXResultado(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorCompartimientoXResultado").html("");
    
    var grid = $("<table>", {
        "id": "gridCompartimientoXResultado"
    });
    
    var pager = $("<div>", {
        "id": "paginacionCompartimientoXResultado"
    });
    
    $("#gridContenedorCompartimientoXResultado").append(grid).append(pager);
    
    var nombres = ['','COMPARTIMIENTO','','','CAPACIDAD','PRODUCTO','RESULTADO COMPARTIMIENTO','RESULTADO TUBER&Iacute;A','RESULTADO FINAL'];
    var columnas = [
    	{name: "idCompartimiento",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "numeroCompartimiento",width: 100, sortable: false, hidden: false, align: "left"},
    	{name: "capacidad",width: 30, sortable: false, hidden: true,align: "left"},
    	{name: "abreviaturaMedida",width: 30, sortable: false, hidden: true,align: "left"},
    	{name: "capacidadMedida",width: 100, sortable: false, hidden: false,align: "left", formatter:"fmtCapMedida"},
    	{name: "nombreLargoProducto",width: 100, sortable: false, hidden: false,align: "left"},
    	{name: "ResultadoCompartimiento",width: 117, sortable: false, hidden: false,align: "left", formatter:"ResCompartimiento"},
    	{name: "ResultadoTuberia",width: 117, sortable: false, hidden: false,align: "left", formatter:"ResTuberia"},
        {name: "ResultadoFinal",width: 100, sortable: false, hidden: false, align: "left", formatter:"ResFinal"}
        
     ];
        
    grid.jqGrid({
        url: baseURL + "pages/resultadosPruebasHermeticidad/listarCompartimientosXResultado",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idCompartimiento :$('#Compart').val()
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 1,
       // pager: "#paginacionCompartimientoXResultado",
        emptyrecords: "No se encontraron resultados",
        //recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        //caption: "Compartimientos",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idProductoXCompartimiento"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Capacidad y Medida
    jQuery.extend($.fn.fmatter, {
    	fmtCapMedida: function(cellvalue, options, rowdata) {
            var C = rowdata.capacidad;
            var M = rowdata.abreviaturaMedida;
            
            return C + " " + M;
        }
    });
    
    //Combo box en grilla
    jQuery.extend($.fn.fmatter, {
    	ResCompartimiento: function(cellvalue, options, rowdata) {
    	
    	if($('#AvisoEvento').val()=="CONSULTA"){
    		
    		if(RC == 'S'){	
	    		
	    		return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultadoC' disabled='disabled' style='width:117px'><option value='S' selected> Sin Fuga </option> <option value='C'> Con Fuga </option> </select>";
	    		
	    	}else{
	    		
	    		return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultadoC' disabled='disabled' style='width:117px'><option value='S'> Sin Fuga </option> <option value='C' selected> Con Fuga </option> </select>";
	    		
	    	}
    		
    	}else{
    		
	    	if(RC == 'S'){
	    		return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultadoC' style='width:117px'><option value='S' selected> Sin Fuga </option> <option value='C'> Con Fuga </option> </select>";
	    	
	    	}else{
	    		return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultadoC' style='width:117px'><option value='S'> Sin Fuga </option> <option value='C' selected> Con Fuga </option> </select>";
	    		
	    	}
    	}
    	
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	ResTuberia: function(cellvalue, options, rowdata) {
    		
		if($('#AvisoEvento').val()=="CONSULTA"){
			
			if(RT == 'S'){	
        		
        		return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultadoT' disabled='disabled' style='width:117px'><option value='S' selected> Sin Fuga </option> <option value='C'> Con Fuga </option> </select>";
        	
        	}else{
        	
        		return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultadoT' disabled='disabled' style='width:117px'><option value='S'> Sin Fuga </option> <option value='C' selected> Con Fuga </option> </select>";
        		
        	}
			
		}else{	
    			
    		if(RT == 'S'){
        		return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultadoT' style='width:117px'><option value='S' selected> Sin Fuga </option> <option value='C'> Con Fuga </option> </select>";
        	
        	}else{
        		return "<select id='"+ rowdata.idCompartimiento +"' class='estadoResultadoT' style='width:117px'><option value='S'> Sin Fuga </option> <option value='C' selected> Con Fuga </option> </select>";
        		
        	}
		}
		
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	ResFinal: function(cellvalue, options, rowdata) {
    		
    		if(resFinal == 'H'){
    			ResultadoFinal = "HERMÉTICO";
    		}else{
    			if(resFinal == 'N'){
    			ResultadoFinal = "NO HERMÉTICO";
    			}
    		}
    		
    		return ResultadoFinal;

        }
    });
	
}

/*function listarDocumentoXResultado(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocumentosRPH").html("");
    
    var grid = $("<table>", {
        "id": "gridDocumentosRPH"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocumentosRPH"
    });
    
    $("#gridContenedorDocumentosRPH").append(grid).append(pager);
    
    var nombres = ['','DOCUMENTO','ARCHIVO','OPCI&Oacute;N'];
    var columnas = [
    	{name: "idDocumento",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "nombreDocumento",width: 200, sortable: false, hidden: false, align: "left"},
    	{name: "archivo",width: 80, sortable: false, hidden: false,align: "center", formatter:"ArchivoRPH"},
        {name: "opcion",width: 80, sortable: false, hidden: false, align: "center", formatter:"OpcionDocRPH"}
        
     ];
        
    grid.jqGrid({
        url: baseURL + "pages/resultadosPruebasHermeticidad/listarDocumentosRPH",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idEmpresaAcreditada :$('#EmpAcredRPH').val()
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 2,
        //pager: "#paginacionDocumentosRPH",
        emptyrecords: "No se encontraron resultados",
        //recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        //caption: "STE a Inspeccionar",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idDocumentosRPH"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
    //Botones Links
    jQuery.extend($.fn.fmatter, {
    	OpcionDocRPH: function(cellvalue, options, rowdata) {
    		
    		if($('#AvisoEvento').val()=="CONSULTA"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    			
        		return "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarDocumentosRPH' id='"+ rowdata.idInspector +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"
        		
        	}
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	ArchivoRPH: function(cellvalue, options, rowdata) {
    		
    		return "<img src=\"" + baseURL + "/../images/pdf16x16.png\" class='DescargarDocumentosRPH' id='"+ rowdata.idInspector +"' style=\"cursor: pointer;\" title=\"Descargar\"/>"
        		
        }
    });
	
}*/

//----- CARGAR EQUIPO COMPONENTE ----------
function cargarArrayComponente() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/cargarEquipoComponente",
        type:'post',
        async:false,
        data:{
        	idEquipoComponente : $("#cmbComponentePH").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            //array
            $.each(data.filas, function( index, value ) {
            	
            	var idEquipoComponente = value.idEquipoComponente;
            	var tipoEquipo = value.tipoEquipo;
            	var descripcionEquipo = value.descripcionEquipo;
            	var componenteTanque = value.componenteTanque;
            	
            	var objeto = {};
            	
            	objeto['idEquipoComponente'] = idEquipoComponente;
            	objeto['tipoEquipo'] = tipoEquipo;
            	objeto['descripcionEquipo'] = descripcionEquipo;
            	objeto['componenteTanque'] = componenteTanque;
            	
            	dataEquipos.push(objeto);
            	arrayIdEquipos.push(idEquipoComponente);
            	listarEquipoXResultado(0);
            	
            });
            
            ValidarComboLimpiarComponentes();
                        
        },
        error:errorAjax
    });
}

function listarEquipoXResultado(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorEquiposRPH").html("");
    
    var grid = $("<table>", {
        "id": "gridEquiposRPH"
    });
    
    var pager = $("<div>", {
        "id": "paginacionEquiposRPH"
    });
    
    $("#gridContenedorEquiposRPH").append(grid).append(pager);
    
    var nombres = ['','','N°','TIPO DE EQUIPO','EQUIPO','COMPONENTE DE USO EN TANQUE','OPCI&Oacute;N'];
    var columnas = [
    	{name: "idResultadoPruebaEquipoComp",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "idEquipoComponente",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "numeroIndice",width: 50, sortable: false, hidden: false, align: "center", formatter:"indice"},
    	{name: "tipoEquipo",width: 270, sortable: false, hidden: false,align: "left"},
    	{name: "descripcionEquipo",width: 270, sortable: false, hidden: false,align: "left"},
    	{name: "componenteTanque",width: 280, sortable: false, hidden: false,align: "left"},
        {name: "opcion",width: 100, sortable: false, hidden: false, align: "center", formatter:"OpcionEquipoRPH"}
        
     ];
        
    grid.jqGrid({
        data: dataEquipos,
        datatype: "local",
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 2,
        pager: "#paginacionEquiposRPH",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        //caption: "STE a Inspeccionar",
        jsonReader: {
            root: "dataEquipos",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Conteo de filas
    jQuery.extend($.fn.fmatter, {
    	indice: function(cellvalue, options, rowdata) {
          var n = $("#gridContenedorEquiposRPH tr").index() + 1;
          return n;
        }
    });
    
    //Botones Links
    jQuery.extend($.fn.fmatter, {
    	OpcionEquipoRPH: function(cellvalue, options, rowdata) {
    		
    		if($('#AvisoEvento').val()=="CONSULTA"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    			
        		return "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarEquipoRPH' id='"+ rowdata.idResultadoPruebaEquipoComp +"%"+ rowdata.idEquipoComponente +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"
        		
        	}
        }
    });
	
}

function listarDocumentosLocal(flg_load) {
    
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocumentosRPH").html("");
    
    var grid = $("<table>", {
        "id": "gridDocumentosRPH"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocumentosRPH"
    });
    
    $("#gridContenedorDocumentosRPH").append(grid).append(pager);
    
    var nombres = ['','','','DOCUMENTO', '', 'ARCHIVO', 'OPCI&Oacute;N'];
    var columnas = [
        {name: "idResultadoPruebaDocumento", sortable: false, hidden: true, align: "center"},
        {name: "idDocumentoAdjunto", sortable: false, hidden: true, align: "center"},
        {name: "idResultadoPruebaReprueba", sortable: false, hidden: true, align: "center"},
        {name: "nombreDocumento", width: 140, sortable: false, hidden: false, align: "left"},
        {name: "archivoAdjunto", sortable: false, hidden: true, align: "center"},
        {name: "archivo",width: 80, sortable: false, hidden: false,align: "center", formatter:"ArchivoRPH"},
        {name: "opcion",width: 80, sortable: false, hidden: false, align: "center", formatter:"OpcionDocRPH"}
    ]; 
 
    grid.jqGrid({
        
    	data: dataDocumentAdj,
    	datatype: "local",
        hidegrid: false,
        rowNum: 2,
        pager: "#paginacionDocumentosRPH",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        //caption: "Listado de Documentos",
        jsonReader: {
            root: "dataDocumentAdj",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        /*onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            nombreEmpresa = rowData.razonSocial;
        },*/
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    jQuery.extend($.fn.fmatter, {
    	OpcionDocRPH: function(cellvalue, options, rowdata) {
    		
    		if($('#AvisoEvento').val()=="CONSULTA"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    			
        		return "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarDocumentosRPH' id='"+ rowdata.idResultadoPruebaDocumento +"%"+ rowdata.idDocumentoAdjunto +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"
        		
        	}
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	ArchivoRPH: function(cellvalue, options, rowdata) {
    		
    		return "<img src=\"" + baseURL + "/../images/file_doc.png\" class='DescargarDocumentosRPH' id='"+ rowdata.nombreDocumento +"%"+ rowdata.archivoAdjunto +"' style=\"cursor: pointer;\" title=\"Descargar\"/>"
        		
        }
    });
}

//-------------------------------------------- OPCION CONSULTAR -----------------------------------------------------

function TraerDatosConsultaResPH(idResultadoPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,fInicio,resultadoPrueba,idUnidSupervTanque,estado){
	
	avisoEst = estado
	$('#AvisoEvento').val("CONSULTA");
	$('#idUnidadSupervisada').val(idUnidSupervTanque);
	$('#idResultadoPR').val(idResultadoPruebaReprueba);
	$('#EmpAcredRPH').val(idEmpresaAcreditada);
	$('#Compart').val(idCompartimiento);
	$('#txtFechaInicioRPH').val(fInicio);
	llenarDatosFrmResultado();
	//Bloquear items
	$('#txtFechaInicioRPH').attr('disabled','disabled');
	$('#txtHoraInicioRPH').attr('disabled','disabled');
	$('#txtFechaFinRPH').attr('disabled','disabled');
	$('#txtHoraFinRPH').attr('disabled','disabled');
	//---------------
	cargarArrayConsultarInspectores();
	//Bloquear items
	$('#cmbInspectorPH').attr('disabled','disabled');
	$('#btnAgregarInspector').attr('disabled','disabled');
	$('#btnAgregarInspector').attr('style','background-color:#60869a;');
	//---------------
	if(resultadoPrueba=='A'){
		$('#txtResultado').html("CONFORME");
	}else{
		$('#txtResultado').html("NO CONFORME");	
	}
	cargarOperador(idUnidSupervTanque);
	$('#titulo_panel').html("STE N° "+ numeroCompartimiento + " - TANQUE N° "+ numeroTanque);
	listarCompartimientoXResultado();
	cargarArrayConsultarDocumentos();
	//Bloquear items
	$('#btnGenerarCodigo').attr('disabled','disabled');
	$('#btnGenerarCodigo').attr('style','background-color:#60869a; width:140px;');
	$('#txtObservacion').attr('disabled','disabled');
	//--
	$('#uploadfile').attr('disabled','disabled');
 	$('#nombreArchivo').attr('disabled','disabled');
 	$('#nombreArchivo').attr('style','font:normal 12px "Calibri"; cursor:not-allowed; background-color:#EBEBE4;');
 	$('#btnAgregarDocRPH').attr('disabled','disabled');
	$('#btnAgregarDocRPH').attr('style','background-color:#60869a; width:100px; margin: 0px 0px 0px 255px; height:25px;');
	//---------------
	
	cargarArrayConsultarEquipoComponente(idResultadoPruebaReprueba)
	//Bloquear items
	$('#cmbTipoEquipoPH').attr('disabled','disabled');
	$('#cmbEquipoPH').attr('disabled','disabled');
	$('#cmbComponentePH').attr('disabled','disabled');
	$('#btnAgregarEquipoRPH').attr('disabled','disabled');
	$('#btnAgregarEquipoRPH').attr('style','background-color:#60869a; width:100px;');
	//--
	$('#btnGuardarRPH').hide();
	$('#btnFinRegistroRPH').hide();
	//---------------
}

//-----  ----------
function traerGenerarCodigo(){
	
	var Finicio = "";
	var Ffin = "";

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/consultarResultadoPruebaReprueba",
        type:'post',
        async:false,
        data:{
        	idResultadoPruebaReprueba: $('#idResultadoPR').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            $.each(data.filas, function( index, value ) {
            	
            	$('#txtNumeroCertificado').html(value.numeroCertificado);
            	$('#txtNumeroInforme').html(value.numeroInforme);
            	
            });
            
            /*if($('#txtNumeroCertificado').text()!== ""){
    			$('#btnGenerarCodigo').attr('disabled','disabled');
    			$('#btnGenerarCodigo').attr('style','background-color:#60869a; width:140px;');
    		}*/
                        
        },
        error:errorAjax
    });
}

//----- LLENAR DATOS DEL FORMULARIO RESULTADO ----------
function llenarDatosFrmResultado() {
	
	var Finicio = "";
	var Ffin = "";

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/consultarResultadoPruebaReprueba",
        type:'post',
        async:false,
        data:{
        	idResultadoPruebaReprueba: $('#idResultadoPR').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            $.each(data.filas, function( index, value ) {
            	
            	Finicio = convertirFecha(value.fechaInicio);
            	Ffin = convertirFecha(value.fechaFin);
            	
            	$('#txtFechaInicioRPH').val(Finicio);
            	$('#txtHoraInicioRPH').val(value.horaInicio);
            	$('#txtFechaFinRPH').val(Ffin);
            	$('#txtHoraFinRPH').val(value.horaFin);
            	$('#txtObservacion').val(value.observacion);
            	$('#txtNumeroCertificado').html(value.numeroCertificado);
            	$('#txtNumeroInforme').html(value.numeroInforme);
            	
                RC  =  value.flagResultadoCompartimiento;
                RT  =  value.flagResutadoTuberia;
                resFinal  =  value.flagResultadoFinal;
            	
            });
                        
        },
        error:errorAjax
    });
}

//----- CONSULTAR - CARGAR CONTENEDOR INSPECTORES ----------
function cargarArrayConsultarInspectores() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/consultarResultadoPersonal",
        type:'post',
        async:false,
        data:{
        	idResultadoPruebaReprueba: $('#idResultadoPR').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            //array
            $.each(data.filas, function( index, value ) {
            	
            	var idResultadoPruebaPersonal = value.idResultadoPruebaPersonal;
            	var idSedePersonalAutorizado = value.idSedePersonalAutorizado;
            	var tipoDocumento = value.tipoDocumento;
            	var numeroDocumento = value.numeroDocumento;
            	var nombre = value.nombre;
            	var apellidoPaterno = value.apellidoPaterno;
            	var apellidoMaterno = value.apellidoMaterno;
            	
            	var objeto = {};
            	
            	objeto['idResultadoPruebaPersonal'] = idResultadoPruebaPersonal;
            	objeto['idSedePersonalAutorizado'] = idSedePersonalAutorizado;
            	objeto['tipoDocumento'] = tipoDocumento;
            	objeto['numeroDocumento'] = numeroDocumento;
            	objeto['nombre'] = nombre;
            	objeto['apellidoPaterno'] = apellidoPaterno;
            	objeto['apellidoMaterno'] = apellidoMaterno;
            	
            	dataInspectores.push(objeto);
            	//arrayIdInspectores.push(idSedePersonalAutorizado);
            	listarInspectorXResultado();
            	
            });
                        
        },
        error:errorAjax
    });
}

//----- CONSULTAR - CARGAR CONTENEDOR DOCUMENTOS ----------
function  cargarArrayConsultarDocumentos(){

    $.ajax({
        url: baseURL + "pages/resultadosPruebasHermeticidad/listarDocumentosArray",
        type:'post',
        async:false,
        data:{
          idResultadoPruebaReprueba : $('#idResultadoPR').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $.each(data.filas, function( index, value ) {

            	 idResultadoPruebaDocumento = value.idResultadoPruebaDocumento;
                 idResultadoPruebaReprueba = value.idResultadoPruebaReprueba;
            	 idDocumentoAdjunto = value.idDocumentoAdjunto;
                 nombreDocumento = value.nombreDocumento;
                 archivoAdjuntoM = value.archivoAdjunto;

              	 var objeto = {};
              	 
              	 objeto['idResultadoPruebaDocumento'] = idResultadoPruebaDocumento;
              	 objeto['idResultadoPruebaReprueba'] = idResultadoPruebaReprueba;
                 objeto['idDocumentoAdjunto'] = idDocumentoAdjunto;
                 objeto['nombreDocumento'] = nombreDocumento ;
                 objeto['archivoAdjunto'] = archivoAdjuntoM ;

                 dataDocumentAdj.push(objeto);
                 listarDocumentosLocal();

           });
        },
        error:errorAjax
    }); 
}

//----- CONSULTAR - CARGAR CONTENEDOR EQUIPO COMPONENTE ----------
function cargarArrayConsultarEquipoComponente(idResultadoPruebaReprueba) {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/consultarResultadoEquipoComp",
        type:'post',
        async:false,
        data:{
        	idResultadoPruebaReprueba: idResultadoPruebaReprueba
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            //array
            $.each(data.filas, function( index, value ) {
            	
            	var idResultadoPruebaEquipoComp = value.idResultadoPruebaEquipoComp
            	var idEquipoComponente = value.idEquipoComponente;
            	var tipoEquipo = value.tipoEquipo;
            	var descripcionEquipo = value.descripcionEquipo;
            	var componenteTanque = value.componenteTanque;
            	
            	var objeto = {};
            	
            	objeto['idResultadoPruebaEquipoComp'] = idResultadoPruebaEquipoComp;
            	objeto['idEquipoComponente'] = idEquipoComponente;
            	objeto['tipoEquipo'] = tipoEquipo;
            	objeto['descripcionEquipo'] = descripcionEquipo;
            	objeto['componenteTanque'] = componenteTanque;
            	
            	dataEquipos.push(objeto);
            	//arrayIdEquipos.push(idEquipoComponente);
            	listarEquipoXResultado();
            	
            });
                        
        },
        error:errorAjax
    });
}

//--------- nuevo para el correlativo--------------

//----- ENCONTRAR UNIDAD SUPERVISADA ----------
function encontrarUnidadSupervisada() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/encontrarUnidadSupervisada",
        type:'post',
        async:false,
        data:{
            idUnidadSupervisada :$('#idUnidadSupervisada').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            $.each(data.filas, function( index, value ) {
            	$("#CodOsinergminUS").val(value.codigoOsinergminUnidadSupervisada);
            });
            
        },
        error:errorAjax
    });
}

//----- ENCONTRAR ULTIMO RESULTADO CON CERTIFICADO ----------
function encontrarUltResCertificadoPH() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/encontrarUltimoResultadoPH",
        type:'post',
        async:false,
        data:{
        	numeroCompartimiento : $('#numCompartimiento').val(),
            resultadoPrueba :'A',
            idTipoPrueba: '1467'
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            if(data.filas!="[object Object]"){
            	Ncertificado = "CERTIFICADO 0-0-"+anioActual;
            	
            }else{
            
	            $.each(data.filas, function( index, value ) {
	            	Ncertificado = value.numeroCertificado;
	            });
            }
        },
        error:errorAjax
    });
}

//----- ENCONTRAR ULTIMO RESULTADO CON INFORME ----------
function encontrarUltResInformePH() {

    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/encontrarUltimoResultadoPH",
        type:'post',
        async:false,
        data:{
        	numeroTanque : $('#numTanque').val(),
            idTipoPrueba: '1467'
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            if(data.filas!="[object Object]"){
            	Ninforme = "INFORME 0-0-"+anioActual;
            	
            }else{
            
	            $.each(data.filas, function( index, value ) {
	            	Ninforme = value.numeroInforme;
	            });
            }
        },
        error:errorAjax
    });
}

//CORRELATIVO
function GenerarCodigoCorrelativo(){
	
	encontrarUltResCertificadoPH();
	
	var numeroC = Ncertificado.split('-');
	var numC = "";
	var numAC = numeroC[2];
	
	if(numAC == anioActual){
		numC = numeroC[1];
	}else{
		numC = '0';
	}
	
	var NumCertCorrelativo = parseInt(numC);
	
	encontrarUltResInformePH();
	
	var numeroI = Ninforme.split('-');
	var numI = "";
	var numAI = numeroC[2];
	
	if(numAI == anioActual){
		numI = numeroI[1];
	}else{
		numI = '0';
	}
	
	var NumInfoCorrelativo = parseInt(numI);
	
	//Incrementar Correlativo
	NumCertCorrelativo = NumCertCorrelativo + 1;
	NumInfoCorrelativo = NumInfoCorrelativo + 1;
	
	//$('#txtNumeroCertificado').html("CERTIFICADO "+$("#CodOsinergminUS").val()+"-"+NumCertCorrelativo+"-"+anioActual);
	//$('#txtNumeroInforme').html("INFORME "+$("#CodOsinergminUS").val()+"-"+NumInfoCorrelativo+"-"+anioActual);
	
	//Si es Nuevo Registro
	if($('#estadoRegistro').val()=="NUEVO_REGISTRO"){
		if(resPrueba == "A"){
			$('#txtNumeroCertificado').html("CERTIFICADO "+$("#CodOsinergminUS").val()+"-"+NumCertCorrelativo+"-"+anioActual);
			$('#txtNumeroInforme').html("INFORME "+$("#CodOsinergminUS").val()+"-"+NumInfoCorrelativo+"-"+anioActual);
		}else{
			if(resPrueba == "N"){
				$('#txtNumeroInforme').html("INFORME "+$("#CodOsinergminUS").val()+"-"+NumInfoCorrelativo+"-"+anioActual);
			}
		}
	}
	
	//Si está en Registro
	if($('#estadoRegistro').val()=="EN_REGISTRO"){
		if(resPrueba == "A"){
			traerGenerarCodigo();
			if($('#txtNumeroCertificado').text()!="" && $('#txtNumeroInforme').text()!=""){
				
			}else{
				if($('#txtNumeroInforme').text()!=""){
					$('#txtNumeroCertificado').html("CERTIFICADO "+$("#CodOsinergminUS").val()+"-"+NumCertCorrelativo+"-"+anioActual);
				}else{
					if($('#txtNumeroCertificado').text()=="" && $('#txtNumeroInforme').text()==""){
						$('#txtNumeroCertificado').html("CERTIFICADO "+$("#CodOsinergminUS").val()+"-"+NumCertCorrelativo+"-"+anioActual);
						$('#txtNumeroInforme').html("INFORME "+$("#CodOsinergminUS").val()+"-"+NumInfoCorrelativo+"-"+anioActual);
					}
				}
			}
		}else{
			if(resPrueba == "N"){
				traerGenerarCodigo();
				if($('#txtNumeroCertificado').text()!="" && $('#txtNumeroInforme').text()!=""){
					$('#txtNumeroCertificado').html("");
				}else{
					if($('#txtNumeroInforme').text()!=""){
						
					}else{
						if($('#txtNumeroCertificado').text()=="" && $('#txtNumeroInforme').text()==""){
							$('#txtNumeroInforme').html("INFORME "+$("#CodOsinergminUS").val()+"-"+NumInfoCorrelativo+"-"+anioActual);
						}
					}
				}
			}
		}
	}
	
}