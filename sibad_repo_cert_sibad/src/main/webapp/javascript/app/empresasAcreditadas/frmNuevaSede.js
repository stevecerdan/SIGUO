//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------
var DPTO;
var provincia;
var distrito;
var tipoDoc;
var idSedeAcreditacionAux;
var ncbx;
$(function() {
    initInicioNuevaSede(); 
    $('#btnGuardarSede').click(btnGuardarSede);
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

//---------------------------------------------

function initInicioNuevaSede(){
	confirm.start();
	//IdAlcanceASede();
	//alert($("#cmbSede").size());
	$('#MensajeValS').hide();
	$('#MensajeValP').hide();
	$("#cmbSede").attr('disabled','disabled');
	cargarDepartamento();
	cargarTipoDocumento();
	cargarCargo();
	
	  $("#txtNombre").attr('disabled','disabled');
	  $("#txtApellidoPaterno").attr('disabled','disabled');
	  $("#txtApellidoMaterno").attr('disabled','disabled');
	  $("#txtCIP").attr('disabled','disabled');
	  $("#btnGuardarSede").attr('disabled','disabled');
	  $('#btnGuardarSede').attr('style','background-color:#60869a');
	
	$('#SSede').click(function(){
		$('#MensajeValP').hide();
		$("#cmbDepaSede").val(0);
		$("#cmbDepaSede").attr('disabled','disabled');
		$("#cmbProvSede").val(0);
		$("#cmbProvSede").attr('disabled','disabled');
		$("#cmbDistSede").val(0);
		$("#cmbDistSede").attr('disabled','disabled');
		$("#txtDirection").attr('disabled','disabled');
		cargarDireccionSede();
		//alert(ncbx);
		if(ncbx!=""){
			$("#cmbSede").removeAttr('disabled');
		}else{
			$('#MensajeValS').show();
			$('#MensajeValS').html("POR FAVOR DEBE REGISTRAR UNA SEDE");
		}
	});
	
	$('#ASede').click(function(){
		$("#MensajeValS").hide();
		$('#MensajeValP').hide();
		$("#cmbDepaSede").removeAttr('disabled');
		$("#cmbProvSede").removeAttr('disabled');
		$("#cmbDistSede").removeAttr('disabled');
		$("#txtDirection").removeAttr('disabled');
		$("#cmbSede").attr('disabled','disabled');
	});
	
	$("#cmbSede").change(function(){
       	idSedeAcreditacionAux = $(this).val();
    });
	
	$("#cmbDocumento").change(function(){
        tipoDoc = $(this).val();
        if (tipoDoc == "1278"){
            $("#txtNumero").attr("maxlength", 8);
        }
        if (tipoDoc == "1279" || tipoDoc == "1280"){
            $("#txtNumero").attr("maxlength", 12);
        }
    });
	
	//----- ocultar mensaje----
	
	$('#cmbDepaSede').click(function(){
		$('#MensajeValP').hide();
	});
	$('#cmbProvSede').click(function(){
		$('#MensajeValP').hide();
	});
	$('#cmbDistSede').click(function(){
		$('#MensajeValP').hide();
	});
	$('#txtDirection').click(function(){
		$('#MensajeValP').hide();
	});
	$('#cmbSede').click(function(){
		$('#MensajeValP').hide();
	});
	$('#cmbDocumento').click(function(){
		$('#MensajeValP').hide();
	});
	$('#txtNumero').click(function(){
		$('#MensajeValP').hide();
	});
	$('#txtNombre').click(function(){
		$('#MensajeValP').hide();
	});
	$('#txtApellidoPaterno').click(function(){
		$('#MensajeValP').hide();
	});
	$('#txtApellidoMaterno').click(function(){
		$('#MensajeValP').hide();
	});
	$('#cmbCargo').click(function(){
		$('#MensajeValP').hide();
	});
	$('#txtCIP').click(function(){
		$('#MensajeValP').hide();
	});
	//-------------------------------

	$('#btnValidarP').click(function(){
		if($("#cmbDocumento").val() == "" || $("#cmbDocumento").val() == undefined){
			$('#MensajeValP').show();
			$('#MensajeValP').html("POR FAVOR SELECCIONE UN TIPO DE DOCUMENTO");
		}else{validarPersonal();}
	});
	
	$('#txtNumero').change(function(){
		$("#txtNombre").attr('disabled','disabled');
		$("#txtNombre").val('');
		$("#txtApellidoPaterno").attr('disabled','disabled');
		$("#txtApellidoPaterno").val('');
		$("#txtApellidoMaterno").attr('disabled','disabled');
		$("#txtApellidoMaterno").val('');
		$("#txtCIP").attr('disabled','disabled');
		$("#txtCIP").val('');
		$("#btnGuardarSede").attr('disabled','disabled');
		$('#btnGuardarSede').attr('style','background-color:#60869a');
	});
	
	$("#cmbDepaSede").change(function(){
	    DPTO =$(this).val();
	    cargarProvincia();
	    $("#cmbDistrito").val(0);
	});

	$("#cmbProvSede").change(function(){
		provincia =$(this).val();
		cargarDistrito();
	});

	$("#cmbDistSede").change(function(){
		distrito =$(this).val();
	});
	
	/*$('#btnGuardarSede').click(function(){
		confirm.open("¿Desea guardar el registro?");
    });*/
	
	$('#btnRegresarSede').click(function(){
		$('#dialogNuevaSede').dialog('close');
    });
    
}

function IdAlcanceASede(IAS=""){
	//Id Alcance Acreditacion
	$('#idAASede').val(IAS);
	
}

function validarDatosFormularioSede(){
	
	var opcion1 = $('input:radio[name=NSede]:checked').val();
	
	if(opcion1 == 'AS'){
		if($("#cmbDepaSede").val() == "" || $("#cmbDepaSede").val() == undefined){
			$('#MensajeValP').html("POR FAVOR SELECCIONE UN DEPARTAMENTO");
			return false;
		}
		if($("#cmbProvSede").val() == "" || $("#cmbProvSede").val() == undefined){
			$('#MensajeValP').html("POR FAVOR SELECCIONE UNA PROVINCIA");
			return false;
		}
		if($("#cmbDistSede").val() == "" || $("#cmbDistSede").val() == undefined){
			$('#MensajeValP').html("POR FAVOR SELECCIONE UN DISTRITO");
			return false;
		}
		if($("#txtDirection").val() =="" || $('#txtDirection').val() == undefined) {
			$('#MensajeValP').html("POR FAVOR COLOQUE LA DIRECCION DE LA SEDE");
	        return false;  
	    }
		if(tipoDoc == "1278" && $("#txtNumero").val().length !== 8) {
			$('#MensajeValP').html("EL NRO. DE DNI DEBE CONTENER 8 DÍGITOS");
	        return false;  
	    }
		if(tipoDoc == "1279" && $("#txtNumero").val().length !== 12) {
			$('#MensajeValP').html("EL NRO. DE CARNET DE EXTRANJ. DEBE CONTENER 12 DÍGITOS");
	        return false;  
	    }
		if(tipoDoc == "1280" && $("#txtNumero").val().length !== 12) {
			$('#MensajeValP').html("EL NRO. DE PASAPORTE DEBE CONTENER 12 DÍGITOS");
	        return false;  
	    }
		if($("#txtNombre").val() =="" || $('#txtNombre').val() == undefined) {
			$('#MensajeValP').html("POR FAVOR COLOQUE EL NOMBRE DEL PERSONAL AUTORIZADO");
	        return false;  
	    }
		if($("#txtApellidoPaterno").val() =="" || $('#txtApellidoPaterno').val() == undefined) {
			$('#MensajeValP').html("POR FAVOR COLOQUE EL APELLIDO PATERNO DEL PERSONAL AUTORIZADO");
	        return false;  
	    }
		if($("#txtApellidoMaterno").val() =="" || $('#txtApellidoMaterno').val() == undefined) {
			$('#MensajeValP').html("POR FAVOR COLOQUE EL APELLIDO MATERNO DEL PERSONAL AUTORIZADO");
	        return false;  
	    }
		if($("#cmbCargo").val() == "" || $("#cmbCargo").val() == undefined){
			$('#MensajeValP').html("POR FAVOR SELECCIONE EL CARGO DEL PERSONAL AUTORIZADO");
			return false;
		}
		if($("#txtCIP").val() =="" || $('#txtCIP').val() == undefined) {
			$('#MensajeValP').html("POR FAVOR COLOQUE EL CIP DEL PERSONAL AUTORIZADO");
	        return false;  
	    }
		return true
	}
	
	if(opcion1 == 'SS'){
		if($("#cmbSede").val() == "" || $("#cmbSede").val() == undefined){
			if(ncbx!=""){
				$('#MensajeValP').html("POR FAVOR SELECCIONE UNA SEDE");
				return false;
			}else{
				$('#MensajeValP').html("USTED AUN NO AGREGA NINGUNA SEDE");
				return false;
			}
		}
		if(tipoDoc == "1278" && $("#txtNumero").val().length !== 8) {
			$('#MensajeValP').html("EL NRO. DE DNI DEBE CONTENER 8 DÍGITOS");
	        return false;  
	    }
		if(tipoDoc == "1279" && $("#txtNumero").val().length !== 12) {
			$('#MensajeValP').html("EL NRO. DE CARNET DE EXTRANJ. DEBE CONTENER 12 DÍGITOS");
	        return false;  
	    }
		if(tipoDoc == "1280" && $("#txtNumero").val().length !== 12) {
			$('#MensajeValP').html("EL NRO. DE PASAPORTE DEBE CONTENER 12 DÍGITOS");
	        return false;  
	    }
		if($("#txtNombre").val() =="" || $('#txtNombre').val() == undefined) {
			$('#MensajeValP').html("POR FAVOR COLOQUE EL NOMBRE DEL PERSONAL AUTORIZADO");
	        return false;  
	    }
		if($("#txtApellidoPaterno").val() =="" || $('#txtApellidoPaterno').val() == undefined) {
			$('#MensajeValP').html("POR FAVOR COLOQUE EL APELLIDO PATERNO DEL PERSONAL AUTORIZADO");
	        return false;  
	    }
		if($("#txtApellidoMaterno").val() =="" || $('#txtApellidoMaterno').val() == undefined) {
			$('#MensajeValP').html("POR FAVOR COLOQUE EL APELLIDO MATERNO DEL PERSONAL AUTORIZADO");
	        return false;  
	    }
		if($("#cmbCargo").val() == "" || $("#cmbCargo").val() == undefined){
			$('#MensajeValP').html("POR FAVOR SELECCIONE EL CARGO DEL PERSONAL AUTORIZADO");
			return false;
		}
		if($("#txtCIP").val() =="" || $('#txtCIP').val() == undefined) {
			$('#MensajeValP').html("POR FAVOR COLOQUE EL CIP DEL PERSONAL AUTORIZADO");
	        return false;  
	    }
		return true
	}
}

//Cargar datos Persona Natural
function validarPersonal() {

	if ($("#txtNumero").val() !== "") {
		
		var J = tipoDoc
		
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/validarPersonal",
	        type:'post',
	        async:false,
	        data:{
	            numeroDoc:$('#txtNumero').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            //[object Object]
	            if(data.filas!="[object Object]"){
	            	
	            	$('#MensajeValP').show();
	    			$('#MensajeValP').html("DOCUMENTO NO ENCONTRADO, PUEDE REGISTRARLO");
	            	
	            	$("#txtNombre").removeAttr('disabled');
	            	$("#txtApellidoPaterno").removeAttr('disabled');
	            	$("#txtApellidoMaterno").removeAttr('disabled');
	            	$("#txtCIP").removeAttr('disabled');
	            	$("#btnGuardarSede").removeAttr('disabled');
	            	$("#btnGuardarSede").removeAttr('Style');

	            	$("#idPersonal").val("");
                    $("#txtNombre").val("");
                    $("#txtApellidoPaterno").val("");
                    $("#txtApellidoMaterno").val("");
                    $("#txtCIP").val("");

	            	return false;
	            	
	            }else{
	            
	            $.each(data.filas, function( index, value ) {
	            	
	            	var TD = value.idTipoDocumento;
		            
		            //alert(TD+' comparando con '+J);
		            
		            if(TD == J){
		            
		              $("#idPersonal").val(value.idPersonaNatural);
	            	  $("#txtNombre").val(value.nombre);
	            	  $("#txtApellidoPaterno").val(value.apellidoPaterno);
	            	  $("#txtApellidoMaterno").val(value.apellidoMaterno);
	            	  $("#txtCIP").val(value.cip);
	            	  
	            	  $("#txtNombre").attr('disabled','disabled');
	            	  $("#txtApellidoPaterno").attr('disabled','disabled');
	            	  $("#txtApellidoMaterno").attr('disabled','disabled');
	            	  $("#txtCIP").attr('disabled','disabled');
	            	  $("#btnGuardarSede").removeAttr('disabled');
	            	  $("#btnGuardarSede").removeAttr('Style');
	            	  
		            }else{
		            	$('#MensajeValP').show();
		    			$('#MensajeValP').html("DOCUMENTO NO ENCONTRADO, PUEDE REGISTRARLO");
		            	$("#txtNombre").removeAttr('disabled');
		            	  $("#txtApellidoPaterno").removeAttr('disabled');
		            	  $("#txtApellidoMaterno").removeAttr('disabled');
		            	  $("#txtCIP").removeAttr('disabled');
		            	  $("#btnGuardarSede").removeAttr('disabled');
		            	  $("#btnGuardarSede").removeAttr('Style');
		            }
	            });
	        }
	            
	        },
	        error:errorAjax
	    });
	}else{
		$('#MensajeValP').show();
		$('#MensajeValP').html("POR FAVOR COLOQUE EL NUMERO DE DOCUMENTO");
	}
}
//-------------------------------------------------------------------------

//Cargar Ubigeo (Departamento - Provincia - Distrito)
function cargarDepartamento() {

	var ceros = "00";
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarUbigeo",
	        type:'post',
	        async:false,
	        data:{
	            idProvincia:ceros,
	            idDistrito:ceros
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idDepartamento','nombre','#cmbDepaSede');
	            
	        },
	        error:errorAjax
	    });
}

function cargarProvincia() {

	var ceros = "00";
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarUbigeo",
	        type:'post',
	        async:false,
	        data:{
	        	idDepartamento:DPTO,
	            idDistrito:ceros
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idProvincia','nombre','#cmbProvSede');
	            
	        },
	        error:errorAjax
	    });
}

function cargarDistrito() {
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarUbigeo",
	        type:'post',
	        async:false,
	        data:{
	        	idDepartamento:DPTO,
	            idProvincia:provincia
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idDistrito','nombre','#cmbDistSede');
	            
	        },
	        error:errorAjax
	    });
}
//Fin Cargar Ubigeo

//----- CARGAR SEDE ACREDITACION ----------
function cargarDireccionSede() {

	var estadito = "A";
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarDireccionSede",
        type:'post',
        async:false,
        data:{
        	estado:estadito,
        	idAlcanceAcreditacion: $('#idAASede').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idSedeAcreditacion','direccion','#cmbSede');
            
            ncbx = data.filas;
            
        },
        error:errorAjax
    });
}

//----- CARGAR TIPO DOCUMENTO ----------
function cargarTipoDocumento() {
	
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
            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbDocumento');
            
        },
        error:errorAjax
    });
}

//--------- CARGAR CARGO --------------------
function cargarCargo() {
	
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
            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbCargo');
            
        },
        error:errorAjax
    });
}

//------------- PREVIA PARA EL REGISTRAR ----------------
function btnGuardarSede(){
	
	var opcion = $('input:radio[name=NSede]:checked').val();
	
	if(validarDatosFormularioSede() == true){
		
	if(opcion == 'AS'){
		
			confirm.open("¿Confirma el registro?","RegistrarSedeAcreditacion()");
			//RegistrarSedeAcreditacion();
	} else {
		if ( $('#idPersonal').val() !== "" && $('#idPersonal').val() !== undefined ){
			confirm.open("¿Confirma el registro?","RegistrarSedePersonalAutorizado()");
		}else{
			confirm.open("¿Confirma el registro?","registrarPersonaNatural()");}
			//registrarPersonaNatural();
	}
	
	}else{$('#MensajeValP').show();}
}

function RegistrarSedeAcreditacion(){
	
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarSedeAcreditacion",
        type:'post',
        async:false,
        data:{
        	
        	idAlcanceAcreditacion: $('#idAASede').val(),
        	idDepartamento: $('#cmbDepaSede').val(),
        	idProvincia: $('#cmbProvSede').val(),
        	idDistrito: $('#cmbDistSede').val(),
        	direccion : $('#txtDirection').val().latinize().toUpperCase(),
        	estado : 'A'

        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
              
            	idSedeAcreditacionAux = data.idSedeAcreditacion;
            	
            	if ( idSedeAcreditacionAux !== null && idSedeAcreditacionAux !== undefined ){
            		// alert("_: " + idSedeAcreditacion);
            		// alert("_: " + $('#idPersonal').val());
            		if ( $('#idPersonal').val() !== "" && $('#idPersonal').val() !== undefined ){
            			//alert("Entra: " + $('#idPersonal').val());
            			//confirm.open("¿Confirma el registro?","RegistrarSedePersonalAutorizado()");
            			RegistrarSedePersonalAutorizado();
            		}else{
            			//alert("Agregar persona Natural");
            			registrarPersonaNatural();
            		}
            		
            	}         	
            }
        },
        error:errorAjax
	});		
	
}

function registrarPersonaNatural(){
//  alert("entro a registrarPersonaNatural");
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarPersonaNatural",
        type:'post',
        async:false,
        data:{
            idTipoDoc: tipoDoc,
            nroDoc:    $("#txtNumero").val(),
            ApPaterno: $("#txtApellidoPaterno").val().latinize().toUpperCase(),
            ApMaterno: $("#txtApellidoMaterno").val().latinize().toUpperCase(),
            nombre:    $("#txtNombre").val().latinize().toUpperCase(),
            cip:       $("#txtCIP").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            if(data.resultado=="0"){
                 //alert("resultado idPN:" + data.idPN);
                 $("#txtNumero").val(data.NroDoc);
                 $('#idPersonal').val(data.idPN);
                 //confirm.open("¿Confirma el registro?","RegistrarSedePersonalAutorizado()");
                 RegistrarSedePersonalAutorizado();
                 //$("#dialogNuevoPersonal").close();
            }else if(data.resultado=="2"){
                mensajeGrowl("warn", data.mensaje, "");
            }
        },
        error:errorAjax
    });

}

function RegistrarSedePersonalAutorizado(){
	//alert( "RegistrarSedePersonalAutorizado: " + $('#idPersonal').val());
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarSedePersonalAutorizado",
        type:'post',
        async:false,
        data:{
        	
        	flagSedePersonalAutorizado: 'A',
        	idSedeAcreditacion: idSedeAcreditacionAux,
        	idPersonaNatural : $('#idPersonal').val(),
        	idCargo : $('#cmbCargo').val(),
        	
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	listarSedes();
            	$('#dialogNuevaSede').dialog('close');
            	mensajeGrowl("success", global.confirm.save, "");
            }
        },
        error:errorAjax
	});			
}