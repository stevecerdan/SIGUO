//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------

var tipoDoc3;
var idPersonaN2;
var ncbx3;
var iPS;
var IPNPS;
$(function() {
    initInicioNuevoPersonalSede(); 
    $('#btnGuardarPersonalSede').click(btnGuardarPersonalAutorizadoPS);
    boton.closeDialog();
});

//----------Funciones de Validaciones----------

//validar ingreso de solo numeros
function validaNumericos(event) {
    if(event.charCode >= 48 && event.charCode <= 57){
      return true;
     }
     return false;        
}

//------------------------------------------------

function initInicioNuevoPersonalSede(){
	confirm.start();
	//IdAlcanceAInspector();
	$('#MensajeValSPS').hide();
	$('#MensajeValPS').hide();
	cargarTipoDocumentoPS();
	cargarCargoPS();
	
	$("#txtNombrePS").attr('disabled','disabled');
	$("#txtApellidoPaternoPS").attr('disabled','disabled');
	$("#txtApellidoMaternoPS").attr('disabled','disabled');
	$("#txtCIPPS").attr('disabled','disabled');
	$("#btnGuardarPersonalSede").attr('disabled','disabled');
	$('#btnGuardarPersonalSede').attr('style','background-color:#60869a');
	
	$("#cmbDocumentoPS").change(function(){
        tipoDoc3 = $(this).val();
        if (tipoDoc3 == "1278"){
            $("#txtNumeroPS").attr("maxlength", 8);
        }
        if (tipoDoc3 == "1279" || tipoDoc3 == "1280"){
            $("#txtNumeroPS").attr("maxlength", 12);
        }
    });
	
	//----- ocultar mensaje----

	$('#cmbSedePS').click(function(){
		$('#MensajeValPS').hide();
	});
	$('#cmbDocumentoPS').click(function(){
		$('#MensajeValPS').hide();
	});
	$('#txtNumeroPS').click(function(){
		$('#MensajeValPS').hide();
	});
	$('#txtNombrePS').click(function(){
		$('#MensajeValPS').hide();
	});
	$('#txtApellidoPaternoPS').click(function(){
		$('#MensajeValPS').hide();
	});
	$('#txtApellidoMaternoPS').click(function(){
		$('#MensajeValPS').hide();
	});
	$('#cmbCargoPS').click(function(){
		$('#MensajeValPS').hide();
	});
	$('#txtCIPPS').click(function(){
		$('#MensajeValPS').hide();
	});
	//-------------------------------
	
	$('#btnValidarPPS').click(function(){
		if($("#cmbDocumentoPS").val() == ""){
			$('#MensajeValPS').show();
			$('#MensajeValPS').html("POR FAVOR SELECCIONE UN TIPO DE DOCUMENTO");
		}else{
			//alert('entro a la funcion');
			ValidarPSregistrado();
			//ValidarSedePersona();
			//ValidarPersonalI();
		}
	});
	
	$('#txtNumeroPS').change(function(){
		$("#txtNombrePS").attr('disabled','disabled');
		$("#txtNombrePS").val('');
		$("#txtApellidoPaternoPS").attr('disabled','disabled');
		$("#txtApellidoPaternoPS").val('');
		$("#txtApellidoMaternoPS").attr('disabled','disabled');
		$("#txtApellidoMaternoPS").val('');
		$("#txtCIPPS").attr('disabled','disabled');
		$("#txtCIPPS").val('');
		$("#btnGuardarPersonalSede").attr('disabled','disabled');
		$('#btnGuardarPersonalSede').attr('style','background-color:#60869a');
	});
	
	/*$('#btnGuardarPersonalSede').click(function(){
		confirm.open("¿Desea guardar el registro?");
    });*/
	
	$('#btnRegresarPersonalSede').click(function(){
		$('#dialogPersonalSede').dialog('close');
        listarSedes();
    });
    
}

function IdAlcanceAPersonalSede(IAPS){
	//Id Alcance Acreditacion
	$('#idAAPersonalSede').val(IAPS);
	cargarDireccionSedePS();
	if(ncbx3!=""){
		$("#cmbSedePS").removeAttr('disabled');
	}else{
		$("#cmbSedePS").attr('disabled','disabled');
		$('#MensajeValSPS').show();
		$('#MensajeValSPS').html("POR FAVOR DEBE REGISTRAR UNA SEDE");
		//Bloquear Formulario de Personal
		$("#cmbDocumentoPS").attr('disabled','disabled');
		$("#txtNumeroPS").attr('disabled','disabled');
		$("#cmbCargoPS").attr('disabled','disabled');
		//Bloquear Botones
		$("#btnValidarPPS").attr('disabled','disabled');
		$('#btnValidarPPS').attr('style','background-color:#60869a; width:80px;');
		
	}
	
}

function validarDatosFormularioPersonalSede(){
	
	if($("#cmbSedePS").val() == "" || $("#cmbSedePS").val() == undefined){
		$('#MensajeValPS').html("POR FAVOR SELECCIONE UN SEDE");
		return false;
	}
	if(tipoDoc3 == "1278" && $("#txtNumeroPS").val().length !== 8) {
		$('#MensajeValPS').html("EL NRO. DE DNI DEBE CONTENER 8 DÍGITOS");
        return false;  
    }
	if(tipoDoc3 == "1279" && $("#txtNumeroPS").val().length !== 12) {
		$('#MensajeValPS').html("EL NRO. DE CARNET DE EXTRANJ. DEBE CONTENER 12 DÍGITOS");
        return false;  
    }
	if(tipoDoc3 == "1280" && $("#txtNumeroPS").val().length !== 12) {
		$('#MensajeValPS').html("EL NRO. DE PASAPORTE DEBE CONTENER 12 DÍGITOS");
        return false;  
    }
	if($("#txtNombrePS").val() =="" || $('#txtNombrePS').val() == undefined) {
		$('#MensajeValPS').html("POR FAVOR COLOQUE EL NOMBRE DEL PERSONAL AUTORIZADO");
        return false;  
    }
	if($("#txtApellidoPaternoPS").val() =="" || $('#txtApellidoPaternoPS').val() == undefined) {
		$('#MensajeValPS').html("POR FAVOR COLOQUE EL APELLIDO PATERNO DEL PERSONAL AUTORIZADO");
        return false;  
    }
	if($("#txtApellidoMaternoPS").val() =="" || $('#txtApellidoMaternoPS').val() == undefined) {
		$('#MensajeValPS').html("POR FAVOR COLOQUE EL APELLIDO MATERNO DEL PERSONAL AUTORIZADO");
        return false;  
    }
	if($("#cmbCargoPS").val() == "" || $("#cmbCargoPS").val() == undefined){
		$('#MensajeValPS').html("POR FAVOR SELECCIONE EL CARGO DEL PERSONAL AUTORIZADO");
		return false;
	}
	if($("#txtCIPPS").val() !="") { 
		buscarCIPDePersonal();
        if($("#txtCIPPS").val().length !== 6) {  
        	$('#MensajeValPS').html("EL NRO DE CIP DEBE POSEER 6 DIGITOS");
            return false;  
            //$("#txtNumero").val(numeroDocumento);
        }else{ 
        	if ( $("#txtCIPPS").val() == i && $("#txtNumeroPS").val() !== IPN ){
        	$('#MensajeValPS').html("EL CIP QUE HA INGRESADO YA SE ENCUENTRA REGISTRADO");
            return false;            
            }
        }
    }else{
    	//guarda vacio
        return true;  
    } 
    return true;
}


//Cargar datos Persona Natural
function ValidarPersonalSede() {

	if ($("#txtNumeroPS").val() !== "") {
		
		//alert('ya debe hacer la funcion');
		var J = tipoDoc3
		
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/validarPersonal",
	        type:'post',
	        async:false,
	        data:{
	            numeroDoc:$('#txtNumeroPS').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            //[object Object]
	            if(data.filas!="[object Object]"){
	            	
	            	$('#MensajeValPS').show();
	            	$('#MensajeValPS').html("DOCUMENTO NO ENCONTRADO, PUEDE REGISTRARLO");
	            	$("#idPersonalPS").val("");
	            	$("#txtNombrePS").val("");
	            	$("#txtNombrePS").removeAttr('disabled');
	            	$("#txtApellidoPaternoPS").val("");
	            	$("#txtApellidoPaternoPS").removeAttr('disabled');
	            	$("#txtApellidoMaternoPS").val("");
	            	$("#txtApellidoMaternoPS").removeAttr('disabled');
	            	$("#txtCIPPS").val("");
	            	$("#txtCIPPS").removeAttr('disabled');
	            	$("#btnGuardarPersonalSede").removeAttr('disabled');
	            	$("#btnGuardarPersonalSede").removeAttr('Style');
	            	
	            	 
	            	  
	            	 // $("#txtNombreI").attr('disabled','disabled');
	            	 // $("#txtApellidoPaternoI").attr('disabled','disabled');
	            	 // $("#txtApellidoMaternoI").attr('disabled','disabled');
	            	 // $("#txtCIPI").attr('disabled','disabled');

	            	return false;
	            	
	            }else{
	            
	            $.each(data.filas, function( index, value ) {
	            	
	            	var TD = value.idTipoDocumento;
		            
		            //alert(TD+' comparando con '+J);
		            
		            if(TD == J){
		              idPersonaN2 = value.idPersonaNatural;
		              //alert(idPersonaN);
		              $("#idPersonalPS").val(value.idPersonaNatural);
	            	  $("#txtNombrePS").val(value.nombre);
	            	  $("#txtApellidoPaternoPS").val(value.apellidoPaterno);
	            	  $("#txtApellidoMaternoPS").val(value.apellidoMaterno);
	            	  $("#txtCIPPS").val(value.cip);
	            	  
	            	  $("#avisoEditarPS").val('GuardarCIP');
	            	  
	            	  $("#txtNombrePS").attr('disabled','disabled');
	            	  $("#txtApellidoPaternoPS").attr('disabled','disabled');
	            	  $("#txtApellidoMaternoPS").attr('disabled','disabled');
	            	  $("#txtCIPPS").removeAttr('disabled');
	            	  $("#btnGuardarPersonalSede").removeAttr('disabled');
	            	  $("#btnGuardarPersonalSede").removeAttr('Style');
	            	  
		            }else{
		            	$('#MensajeValPS').show();
		            	$('#MensajeValPS').html("DOCUMENTO NO ENCONTRADO, PUEDE REGISTRARLO");
		            	$("#txtNombrePS").removeAttr('disabled');
		            	$("#txtApellidoPaternoPS").removeAttr('disabled');
		            	$("#txtApellidoMaternoPS").removeAttr('disabled');
		            	$("#txtCIPPS").removeAttr('disabled');
		            	$("#btnGuardarPersonalSede").removeAttr('disabled');
		            	$("#btnGuardarPersonalSede").removeAttr('Style');
		            }
	            });
	        }
	            
	        },
	        error:errorAjax
	    });
	}else{
		$('#MensajeValPS').show();
    	$('#MensajeValPS').html("POR FAVOR COLOQUE EL NUMERO DE DOCUMENTO");
	}
}
//-------------------------------------------------------------------------

//Validar Sede Personal
function ValidarPSregistrado() {

	if ($("#txtNumeroPS").val() !== "") {
		
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/validarSedePersonal",
	        type:'post',
	        async:false,
	        data:{
	        	idAlcanceAcreditacion: $('#idAAPersonalSede').val(),
	        	//flagPersonalAutorizado: 'S',
	            numeroDocumento:$('#txtNumeroPS').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            //[object Object]
	            if(data.filas!="[object Object]"){
	            	
	            	ValidarPersonalSede();
	            	
	            }else{
	            	
	            	$('#MensajeValPS').show();
	            	$('#MensajeValPS').html("EL DNI PERTENECE A UN PERSONAL YA REGISTRADO");
	            	
	            	return false;
	            }
	            
	        },
	        error:errorAjax
	    });
	}else{
		$('#MensajeValPS').show();
    	$('#MensajeValPS').html("POR FAVOR COLOQUE EL NUMERO DE DOCUMENTO");
	}
}
//-------------------------------------------------------------------------

function buscarCIPDePersonal(){
    //var valor = 0;
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/validarPersonal",
        type:'POST',
        async:false,
        data:{
            cip : $("#txtCIPPS").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            /*if (data.registros > 0){
            return valor = 1;
	        }*/
	        $.each(data.filas, function( index, value ) {
	        	iPS = value.cip;
	        	IPNPS = value.numeroDoc;
	            //alert(IPN);
	        })     
        },
        error:errorAjax
    });
    //return valor;
}

//----- CARGAR SEDE ACREDITACION ----------
function cargarDireccionSedePS() {

    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarDireccionSede",
        type:'post',
        async:false,
        data:{
            //estado:"A",
            idAlcanceAcreditacion: $('#idAAPersonalSede').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idSedeAcreditacion','direccion','#cmbSedePS');
            
            ncbx3 = data.filas;
            
        },
        error:errorAjax
    });
}

//----- CARGAR TIPO DOCUMENTO ----------
function cargarTipoDocumentoPS() {
	
	var encuentro = "TIPO_DOCUMENTO";
	var app = "SIGUO";

    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarComboTipo",
        type:'post',
        async:false,
        data:{
            dominio:encuentro,
            aplicacion:app
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbDocumentoPS');
            
        },
        error:errorAjax
    });
}

//--------- CARGAR CARGO --------------------
function cargarCargoPS() {
	
	var encuentro = "CARGO";
	var app = "SIBAD";

    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarComboTipo",
        type:'post',
        async:false,
        data:{
            dominio:encuentro,
            aplicacion:app
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbCargoPS');
            
        },
        error:errorAjax
    });
    
}

function btnGuardarPersonalAutorizadoPS(){
	
/*	if($("#avisoEditarI").val()=='Editando'){
		//validarEdicionInspector()
		if(validarEdicionInspector() == true){
			confirm.open("¿Confirma la actualizacion de datos?","modificacionGeneralInspector()");
		}else{
			$('#MensajeValI').show();}
	}else{*/
		if(validarDatosFormularioPersonalSede() == true){
			
			if($("#idPersonalPS").val() !==""  && $("#idPersonalPS").val() !==undefined ){
				//alert("PersonalAuto");
		        confirm.open("¿Confirma el registro?","RegistrarSedePersonalAutorizadoPS()");        
		    }else{
		    	confirm.open("¿Confirma el registro?","registrarPersonaNaturalPS()");
		    	//registrarPersonaNatural();
		    }
			
		}else{$('#MensajeValPS').show();}
	//}
	//confirm.open("¿Confirma el registro?","RegistrarSedePersonalAutorizado()");
	
}

function registrarPersonaNaturalPS(){
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarPersonaNatural",
        type:'post',
        async:false,
        data:{
            idTipoDoc: tipoDoc3,
            nroDoc:    $("#txtNumeroPS").val(),
            ApPaterno: $("#txtApellidoPaternoPS").val().latinize().toUpperCase(),
            ApMaterno: $("#txtApellidoMaternoPS").val().latinize().toUpperCase(),
            nombre:    $("#txtNombrePS").val().latinize().toUpperCase(),
            cip:       $("#txtCIPPS").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            if(data.resultado=="0"){
                 //alert("resultado idPN:" + data.idPN);
                 idPersonaN2 = data.idPN;
                 $("#txtNumeroPS").val(data.NroDoc);
                 $('#idPersonalPS').val(data.idPN);
                 //confirm.open("¿Confirma el registro?","RegistrarSedePersonalAutorizado()");
                 RegistrarSedePersonalAutorizadoPS();
            }else if(data.resultado=="2"){
                mensajeGrowl("warn", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function RegistrarSedePersonalAutorizadoPS(){
	
	if($("#avisoEditarPS").val()=='GuardarCIP'){
		modificarDatosPersonalSede();
	}
	
$.ajax({
    url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarSedePersonalAutorizado",
    type:'post',
    async:false,
    data:{
    	
    	flagSedePersonalAutorizado: 'A',
    	idSedeAcreditacion: $('#cmbSedePS').val(),
    	idPersonaNatural : idPersonaN2,//id pers natural
    	idCargo : $('#cmbCargoPS').val(),
    	idEspecialidad : '',                    	

    	
    },
    beforeSend:muestraLoading,
    success:function(data){
        ocultaLoading();
        if(data.resultado=="0"){
        	$('#dialogPersonalSede').dialog('close');
            listarSedes();
            mensajeGrowl("success", global.confirm.save, "");
        }
    },
    error:errorAjax
});		

}

/*function modificacionGeneralInspector(){
	modificarDatosInspector();
	modificarCargoEspecialidad();
	$('#dialogInspectorAutorizado').dialog('close');
	listarSedes();
    listarInspector();
}*/

function modificarDatosPersonalSede(){
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/modificarPersonaNatural",
        type:'post',
        async:false,
        data:{
            idPersonaNatural :$("#idPersonalPS").val(),
            nombre :$("#txtNombrePS").val().latinize().toUpperCase(),
            apellidoPaterno :$("#txtApellidoPaternoPS").val().latinize().toUpperCase(),
            apellidoMaterno :$("#txtApellidoMaternoPS").val().latinize().toUpperCase(),
            cip :$("#txtCIPPS").val()
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

/*function modificarCargoEspecialidad(){
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/modificarSedeInspector",
        type:'post',
        async:false,
        data:{
            idSedePersonalAutorizado :$("#clonInspector").val(),
            idCargo :'',
            idEspecialidad :$('#cmbEspecialidad').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            }
        },
        error:errorAjax
    });     
}*/