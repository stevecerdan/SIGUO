var tipoDoc              = "";
var idPersonaN           = "";
var idRRevisionAux       = "";
var idRPersonaNaturalAux = "";
var encontrado           = 0;

$(function() {
    initInicioNuevoInspector(); 
    initDialogs(); 
});

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

function nuevoPersonalAutorizado(Rpt){
	
	 $('#tipoEvento').val(Rpt);
}

function editarPersonalAutorizado(Rpt,idPersonaNatural,apellidoPaterno,apellidoMaterno,tipoDocumento,numeroDoc,telefono,idTipoDoc,nombre){

	 $('#tipoEvento').val(Rpt);
	     
	 tipoDoc=idTipoDoc;
		 
	 $('#idPersonalI').val(idPersonaNatural); 
	 $('#cmbDocumentoI option[value="'+ idTipoDoc +'"]').attr("selected", true);
	 $('#txtNumeroI').val(numeroDoc);
	 $('#txtNombreI').val(nombre);
	 $('#txtApellidoPaternoI').val(apellidoPaterno);
	 $('#txtApellidoMaternoI').val(apellidoMaterno);
	 $('#txtTELEFONOI').val(telefono);
	
}

//validar ingreso de solo numeros
function validaNumericos(event) {
    if(event.charCode >= 48 && event.charCode <= 57){
      return true;
     }
     return false;        
}

function bloquearInput(){
    $("#txtNombreI").attr('disabled','disabled');
    $("#txtApellidoPaternoI").attr('disabled','disabled');
    $("#txtApellidoMaternoI").attr('disabled','disabled');
    $("#txtCIPI").attr('disabled','disabled');
    $("#txtTELEFONOI").attr('disabled','disabled');
}

function desbloquearInput(){
	$("#txtNumeroI").attr('disabled','disabled'); 
	$("#cmbDocumentoI").attr('disabled', 'disabled');
	$("#btnValidarPI").attr('disabled', 'disabled');
	$("#txtNombreI").removeAttr("disabled");
	$("#txtApellidoPaternoI").removeAttr("disabled");
	$("#txtApellidoMaternoI").removeAttr("disabled");
	$("#txtCIPI").removeAttr("disabled");
	$("#txtTELEFONOI").removeAttr("disabled");
}

function initInicioNuevoInspector(){
	confirm.start();
	cargarTipoDocumentoI();
    bloquearInput();
	
	$("#cmbDocumentoI").change(function(){
        tipoDoc = $(this).val();
        if (tipoDoc == ""){
            $("#txtNumeroI").attr("maxlength", 0);
        
        }else if (tipoDoc == "1278"){
            $("#txtNumeroI").attr("maxlength", 8);
            
        }else{
            $("#txtNumeroI").attr("maxlength", 16);
        }
    });
	
	$('#btnValidarPI').click(function(){
		cargarDatosResultadoPN();
	});
		
	$('#btnRegresarInspector').click(function(){ 
		$('#dialogInspectorAutorizadoRR').dialog('close');
    });
	
	$('#form_registro #btnGuardarInspector').click(function(){
		
		 btnGuardarSedePersonalAutorizado(); 
		 
		 $( "#button-id").children().addClass( "button-ok" );
	     $(".button-ok").css({display: "block"});
	});
    
}

function verificarIDR(idRRevision, idPRN){
    idRRevisionAux = idRRevision;
    idRPersonaNaturalAux = idPRN;
    if ( idRPersonaNaturalAux !== null && idRPersonaNaturalAux !== "" && idRPersonaNaturalAux !== undefined){
        cargarDatosResultadoPN();
        desbloquearInput();
    }
}

//Cargar datos Persona Natural
function validarPersonalI() {

	if ($("#txtNumeroI").val() !== "") {
		
		var J = tipoDoc
		
	    $.ajax({
	        url:baseURL + "pages/InspMantLimp/validarPersonal",
	        type:'post',
	        async:false,
	        data:{
	            numeroDoc:$('#txtNumeroI').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            if(data.filas!="[object Object]"){

	            	 var addhtml2 = 'Documento no encontrado.';
	   	     	     $("#dialog-message-content").html(addhtml2);
	   	     	     $("#dialog-message").dialog("open");
	                
                     desbloquearInput();
	            	 $("#idPersonalI").val("");
	            	 $("#txtNombreI").val("");
	            	 $("#txtApellidoPaternoI").val("");
	            	 $("#txtApellidoMaternoI").val("");
	            	 $("#txtTELEFONOI").val("");

	            	return false;
	            	
	            }else{
	            	
	            $.each(data.filas, function( index, value ) {
	            	
	            	var TD = value.idTipoDocumento;		            
		            
		            if(TD == J){

		              idPersonaN = value.idPersonaNatural;
		              $("#idPersonalI").val(value.idPersonaNatural);
	            	  $("#txtNombreI").val(value.nombre);
	            	  $("#txtApellidoPaternoI").val(value.apellidoPaterno);
	            	  $("#txtApellidoMaternoI").val(value.apellidoMaterno);
                      $("#txtTELEFONOI").val(value.telefono);
	            	  
	            	  bloquearInput();
	            	  
		            }else {

	            	 var addhtml2 = 'Documento no encontrado.';
	   	     	     $("#dialog-message-content").html(addhtml2);
	   	     	     $("#dialog-message").dialog("open");
	   	     	     
	   	     	     return false;
		            }
	            });
	        }
	            
	        },
	        error:errorAjax
	    });
	}else{
		 var addhtml2 = 'Ingrese número de documento.';
    	 $("#dialog-message-content").html(addhtml2);
    	 $("#dialog-message").dialog("open");
    	 
    	 return false;
	}
}

//CARGA DATOS DE RESULTADO PERSONA NATURAL
function cargarDatosResultadoPN() {
    if(idRPersonaNaturalAux !== "" && idRPersonaNaturalAux !== undefined){
       
        $.ajax({
            url:baseURL + "pages/InspMantLimp/cargarDatosResultadoPN",
            type:'post',
            async:false,
            data:{
                idResultadoPersonaNatural : idRPersonaNaturalAux
            },
            beforeSend:muestraLoading,
            success:function(data){
                desbloquearInput();
                ocultaLoading();
                
                $.each(data.filas, function( index, value ) {
                    idPersonaN = value.idPersonaNatural;
                    idRPersonaNaturalAux = value.idResultadoPersonaNatural;
                    idRRevisionAux = value.idResultadoRevision;
                    tipoDoc = value.idTipoDocumento ;
                    $("#cmbDocumentoI").val(tipoDoc);
                    $("#txtNumeroI").val(value.numeroDocumento);
                    $("#txtNombreI").val(value.nombre);
                    $("#txtApellidoPaternoI").val(value.apellidoPaterno);
                    $("#txtApellidoMaternoI").val(value.apellidoMaterno);
                    $("#txtTELEFONOI").val(value.telefono);
                });
            },
            error:errorAjax
        });
           
    }else{
        validarPersonalI();
    }    
}

//VERIFICAR SI DNI EXISTE
function validarDni() {
	var val = 0;
	$.ajax({
        url:baseURL + "pages/InspMantLimp/cargarDatosResultadoPN",
        type:'post',
        async:false,
        data:{
        	numeroDocumento: $("#txtNumeroI").val()
        },
        beforeSend:muestraLoading,
        success:function(data){

            ocultaLoading();
            if (data.tamanio > 0){
            	return val = 1;
            }      
        },
        error:errorAjax
    });
	return val;
}

//----- CARGAR TIPO DOCUMENTO ----------
function cargarTipoDocumentoI() {
	
	var encuentro = "TIPO_DOCUMENTO";
	var app = "SIGUO";

    $.ajax({
        url:baseURL + "pages/InspMantLimp/cargarComboTipo",
        type:'post',
        async:false,
        data:{
            dominio:encuentro,
            aplicacion:app
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbDocumentoI');
            
        },
        error:errorAjax
    });
}

function btnGuardarSedePersonalAutorizado(){
	
	if($("#idPersonalI").val() !=""  && $("#idPersonalI").val() !=undefined ){
		
	    if (validarDatosFormulario() == true ){
	    	
	    	  confirm.open("¿Desea guardar el registro?","PersonaNaturalRegistrada()"); 
	    }
	    
    }else{
    	
	    if ( validarDatosFormulario() == true ){
	    	
	          confirm.open("¿Desea guardar el registro?","registrarPersonaNatural()");
	    }
    }	
}

function validarDatosFormulario(){

    if(tipoDoc == "1278" && $("#txtNumeroI").val().length !== 8){

        var addhtml2 = 'DNI debe tener 8 dígitos.';
   	    $("#dialog-message-content").html(addhtml2);
   	    $("#dialog-message").dialog("open");
   	    
        return false;
    }
    if(tipoDoc == "" || tipoDoc == undefined){
        return false;
    }
    if($("#txtNumeroI").val().length == 0 || $("#txtNumeroI").val().length > 11) {  
        
    	var addhtml2 = 'El Nro de documento no debe sobrepasar 11 caracteres.';
   	    $("#dialog-message-content").html(addhtml2);
   	    $("#dialog-message").dialog("open");
   	    
        return false;  
    } 
    if($("#txtApellidoPaternoI").val() =="" || $('#txtApellidoPaternoI').val() == undefined) { 
        return false;  
    } 
    if($("#txtApellidoMaternoI").val() =="" || $('#txtApellidoMaternoI').val() == undefined) {  
        return false;  
    }
    if($("#txtNombreI").val() =="" || $('#txtNombreI').val() == undefined) {  
        return false;  
    } 
    return true;
}

function editarArrayPersonaNatural( nroDoc, idTipoDoc, ApPaterno, ApMaterno,nombre, TipoDoc, telefono) {

   for (var i in dataPersonaN) {
     if (dataPersonaN[i].numeroDoc == nroDoc) {
    	 
    	 dataPersonaN[i].tipoDocumento = TipoDoc;
    	 dataPersonaN[i].idTipoDoc = idTipoDoc;
    	 dataPersonaN[i].apellidoPaterno = ApPaterno;
    	 dataPersonaN[i].apellidoMaterno = ApMaterno;
    	 dataPersonaN[i].nombre = nombre;
    	 dataPersonaN[i].nombreCompleto = nombre+' '+ApPaterno+' '+ApMaterno;
    	 dataPersonaN[i].telefono = telefono;
  
    	 break;
     }
   }
	
  listarPersonasLocal(0);
}

function PersonaNaturalRegistrada(){
	
	var tEvento = $("#tipoEvento").val();
	
	var idPersonaNatural =  idPersonaN;
	var idTipoDoc  =    $("#cmbDocumentoI option:selected").val();
    var TipoDoc    =    $("#cmbDocumentoI option:selected").text();//tipoDoc
    var nroDoc     =    $("#txtNumeroI").val();
    var ApPaterno  =    $("#txtApellidoPaternoI").val().toUpperCase();
    var ApMaterno  =    $("#txtApellidoMaternoI").val().toUpperCase();
    var nombre     =    $("#txtNombreI").val().toUpperCase();
    var cip        =    $("#txtCIPI").val();
    var telefono   =    $("#txtTELEFONOI").val()


	if(tEvento == "EDITAR_PERSONA"){
		
		registrarPersonaNatural();
		editarArrayPersonaNatural(nroDoc, idTipoDoc, ApPaterno, ApMaterno,nombre,TipoDoc,telefono);
			 
	} else if (tEvento == "NUEVA_PERSONA"){
		
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

	    
	   if (dataPersonaN.length == 0) {

	        dataPersonaN.push(objeto);
	    	arrayIdPersonaN.push(idPersonaNatural);
	    	
	   } else {
		   
		   for (var i in dataPersonaN) {
			  
			     if (dataPersonaN[i].idPersonaNatural == idPersonaNatural) {
			    	
			          encontrado = 1;
			     } 
			}
		   
		   if(encontrado == 1){
			   
			   var addhtml2 = 'Personal Autorizado, ya se enuentra agregado en la tabla.';
	    	   $("#dialog-message-content").html(addhtml2);
	    	   $("#dialog-message").dialog("open");
			 
		   } else {
			   
	  	       dataPersonaN.push(objeto);
	  	       arrayIdPersonaN.push(idPersonaNatural);			   
		   }
	   }	   
	   
  }	
    
 listarPersonasLocal(0);

 $('#dialogInspectorAutorizadoRR').dialog('close');

}

function registrarPersonaNatural(){
	
  var tEvento = $("#tipoEvento").val();
  
    $.ajax({
        url:baseURL + "pages/InspMantLimp/registrarPersonaNatural",
        type:'post',
        async:false,
        data:{
            idPersonaNatural:   $("#idPersonalI").val(),
            idTipoDoc:          tipoDoc,
            nroDoc:             $("#txtNumeroI").val(),
            ApPaterno:          $("#txtApellidoPaternoI").val().toUpperCase(),
            ApMaterno:          $("#txtApellidoMaternoI").val().toUpperCase(),
            nombre:             $("#txtNombreI").val().toUpperCase(),
            cip:                $("#txtCIPI").val(),
            telefono:           $("#txtTELEFONOI").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            if(data.resultado=="0"){

                 idPersonaN = data.idPN;
                 $("#txtNumeroI").val(data.NroDoc);
                 $('#idPersonalI').val(data.idPN);
                
                if (tEvento == "NUEVA_PERSONA"){ 
                	
                	var idPersonaNatural =  idPersonaN;
                	var idTipoDoc  =    $("#cmbDocumentoI option:selected").val();
                    var TipoDoc    =    $("#cmbDocumentoI option:selected").text();//tipoDoc
                    var nroDoc     =    $("#txtNumeroI").val();
                    var ApPaterno  =    $("#txtApellidoPaternoI").val().toUpperCase();
                    var ApMaterno  =    $("#txtApellidoMaternoI").val().toUpperCase();
                    var nombre     =    $("#txtNombreI").val().toUpperCase();
                    var cip        =    $("#txtCIPI").val();
                    var telefono   =    $("#txtTELEFONOI").val()
                    
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
                	arrayIdPersonaN.push(idPersonaNatural);
                	
                	listarPersonasLocal(0);
                	$('#dialogInspectorAutorizadoRR').dialog('close');
                    //PersonaNaturalRegistrada();
                }
            
            }else if(data.resultado=="2"){
                mensajeGrowl("warn", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}