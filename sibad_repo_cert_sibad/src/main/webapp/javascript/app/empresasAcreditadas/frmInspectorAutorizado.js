//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------

var tipoDoc2;
var idPersonaN;
var ncbx2;
var IPNI;
var iI;
$(function() {
    initInicioNuevoInspector(); 
    $('#btnGuardarInspector').click(btnGuardarSedePersonalAutorizado);
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

function initInicioNuevoInspector(){
	confirm.start();
	//IdAlcanceAInspector();
	$('#MensajeValSI').hide();
	$('#MensajeValI').hide();
	cargarTipoDocumentoI();
	cargarEspecialidad();
	
	$("#txtNombreI").attr('disabled','disabled');
	$("#txtApellidoPaternoI").attr('disabled','disabled');
	$("#txtApellidoMaternoI").attr('disabled','disabled');
	$("#txtCIPI").attr('disabled','disabled');
	$("#btnGuardarInspector").attr('disabled','disabled');
	$('#btnGuardarInspector').attr('style','background-color:#60869a');
	
	$("#cmbDocumentoI").change(function(){
        tipoDoc2 = $(this).val();
        if (tipoDoc2 == "1278"){
            $("#txtNumeroI").attr("maxlength", 8);
        }
        if (tipoDoc2 == "1279" || tipoDoc2 == "1280"){
            $("#txtNumeroI").attr("maxlength", 12);
        }
    });
	
	//----- ocultar mensaje----

	$('#cmbSedeI').click(function(){
		$('#MensajeValI').hide();
	});
	$('#cmbDocumentoI').click(function(){
		$('#MensajeValI').hide();
	});
	$('#txtNumeroI').click(function(){
		$('#MensajeValI').hide();
	});
	$('#txtNombreI').click(function(){
		$('#MensajeValI').hide();
	});
	$('#txtApellidoPaternoI').click(function(){
		$('#MensajeValI').hide();
	});
	$('#txtApellidoMaternoI').click(function(){
		$('#MensajeValI').hide();
	});
	$('#cmbEspecialidad').click(function(){
		$('#MensajeValI').hide();
	});
	$('#txtCIPI').click(function(){
		$('#MensajeValI').hide();
	});
	//-------------------------------
	
	$('#btnValidarPI').click(function(){
		if($("#cmbDocumentoI").val() == ""){
			$('#MensajeValI').show();
			$('#MensajeValI').html("POR FAVOR SELECCIONE UN TIPO DE DOCUMENTO");
		}else{
			//alert('entro a la funcion');
			ValidarSedePersona();
			//ValidarPersonalI();
		}
	});
	
	$('#txtNumeroI').change(function(){
		$("#txtNombreI").attr('disabled','disabled');
		$("#txtNombreI").val('');
		$("#txtApellidoPaternoI").attr('disabled','disabled');
		$("#txtApellidoPaternoI").val('');
		$("#txtApellidoMaternoI").attr('disabled','disabled');
		$("#txtApellidoMaternoI").val('');
		$("#txtCIPI").attr('disabled','disabled');
		$("#txtCIPI").val('');
		$("#btnGuardarInspector").attr('disabled','disabled');
		$('#btnGuardarInspector').attr('style','background-color:#60869a');
	});
	
	/*$('#btnGuardarInspector').click(function(){
		confirm.open("¿Desea guardar el registro?");
    });*/
	
	$('#btnRegresarInspector').click(function(){
		$('#dialogInspectorAutorizado').dialog('close');
        listarInspector();
    });
    
}

function IdAlcanceAInspector(IAI){
	//Id Alcance Acreditacion
	$('#idAAInspector').val(IAI);
	cargarDireccionSedeI();
	if(ncbx2!=""){
		$("#cmbSedeI").removeAttr('disabled');
	}else{
		$("#cmbSedeI").attr('disabled','disabled');
		$('#MensajeValSI').show();
		$('#MensajeValSI').html("POR FAVOR DEBE REGISTRAR UNA SEDE");
		//Bloquear Formulario de Personal
		$("#cmbDocumentoI").attr('disabled','disabled');
		$("#txtNumeroI").attr('disabled','disabled');
		$("#cmbEspecialidad").attr('disabled','disabled');
		//Bloquear Botones
		$("#btnValidarPI").attr('disabled','disabled');
		$('#btnValidarPI').attr('style','background-color:#60869a; width:80px;');
		
	}
	
}

function validarDatosFormularioInspector(){
	
	if($("#cmbSedeI").val() == "" || $("#cmbSedeI").val() == undefined){
		$('#MensajeValI').html("POR FAVOR SELECCIONE UN SEDE");
		return false;
	}
	if(tipoDoc2 == "1278" && $("#txtNumeroI").val().length !== 8) {
		$('#MensajeValI').html("EL NRO. DE DNI DEBE CONTENER 8 DÍGITOS");
        return false;  
    }
	if(tipoDoc2 == "1279" && $("#txtNumeroI").val().length !== 12) {
		$('#MensajeValI').html("EL NRO. DE CARNET DE EXTRANJ. DEBE CONTENER 12 DÍGITOS");
        return false;  
    }
	if(tipoDoc2 == "1280" && $("#txtNumeroI").val().length !== 12) {
		$('#MensajeValI').html("EL NRO. DE PASAPORTE DEBE CONTENER 12 DÍGITOS");
        return false;  
    }
	if($("#txtNombreI").val() =="" || $('#txtNombreI').val() == undefined) {
		$('#MensajeValI').html("POR FAVOR COLOQUE EL NOMBRE DEL PERSONAL AUTORIZADO");
        return false;  
    }
	if($("#txtApellidoPaternoI").val() =="" || $('#txtApellidoPaternoI').val() == undefined) {
		$('#MensajeValI').html("POR FAVOR COLOQUE EL APELLIDO PATERNO DEL PERSONAL AUTORIZADO");
        return false;  
    }
	if($("#txtApellidoMaternoI").val() =="" || $('#txtApellidoMaternoI').val() == undefined) {
		$('#MensajeValI').html("POR FAVOR COLOQUE EL APELLIDO MATERNO DEL PERSONAL AUTORIZADO");
        return false;  
    }
	if($("#cmbEspecialidad").val() == "" || $("#cmbEspecialidad").val() == undefined){
		$('#MensajeValI').html("POR FAVOR SELECCIONE LA ESPECIALIDAD DEL PERSONAL AUTORIZADO");
		return false;
	}
	if($("#txtCIPI").val() !="") { 
		buscarCIPDeInspector();
        if($("#txtCIPI").val().length !== 6) {  
        	$('#MensajeValI').html("EL NRO DE CIP DEBE POSEER 6 DIGITOS");
            return false;  
            //$("#txtNumero").val(numeroDocumento);
        }else{ 
        	if ( $("#txtCIPI").val() == iI && $("#txtNumeroI").val() !== IPNI ){
        	$('#MensajeValI').html("EL CIP QUE HA INGRESADO YA SE ENCUENTRA REGISTRADO");
            return false;            
            }
        }
    }else{
    	//guarda vacio
        return true;  
    }
	return true;
}

function cargarDatosInspector(id,direccion,idTipoDocumento,numeroDocumento,idEspecialidad){
	$("#clonInspector").val(id);
	$("#cmbSedeI").append('<option value ="" selected="selected">' + direccion + '</option>');
	
	$("#cmbDocumentoI").val(idTipoDocumento);
	$("#txtNumeroI").val(numeroDocumento);
	$("#cmbEspecialidad").val(idEspecialidad);
	
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/validarPersonal",
        type:'post',
        async:false,
        data:{
            numeroDoc:numeroDocumento
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            $.each(data.filas, function( index, value ) {
            	
            	var TD = value.idTipoDocumento;
	            
	            if(TD == idTipoDocumento){
	              idPersonaN = value.idPersonaNatural;
	              //alert(idPersonaN);
	              $("#idPersonalI").val(value.idPersonaNatural);
            	  $("#txtNombreI").val(value.nombre);
            	  $("#txtApellidoPaternoI").val(value.apellidoPaterno);
            	  $("#txtApellidoMaternoI").val(value.apellidoMaterno);
            	  $("#txtCIPI").val(value.cip);
            	  
	            }else{
	            	$('#MensajeValI').show();
	            	$('#MensajeValI').html("DOCUMENTO NO ENCONTRADO");
	            }
            });
        },
        error:errorAjax
    });
	$("#avisoEditarI").val('Editando');
	//desbloquear para editar
	$("#cmbSedeI").attr('disabled','disabled');
	$("#cmbDocumentoI").attr('disabled','disabled');
	$("#txtNumeroI").attr('disabled','disabled');
	$("#txtNombreI").removeAttr('disabled');
	$("#txtApellidoPaternoI").removeAttr('disabled');
	$("#txtApellidoMaternoI").removeAttr('disabled');
	$("#txtCIPI").removeAttr('disabled');
	$("#btnValidarPI").attr('disabled','disabled');
	$('#btnValidarPI').attr('style','background-color:#60869a; width:80px;');
	$("#btnGuardarInspector").removeAttr('disabled');
	$("#btnGuardarInspector").removeAttr('Style');
}

//Cargar datos Persona Natural
function ValidarPersonalI() {

	if ($("#txtNumeroI").val() !== "") {
		
		//alert('ya debe hacer la funcion');
		var J = tipoDoc2
		
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/validarPersonal",
	        type:'post',
	        async:false,
	        data:{
	            numeroDoc:$('#txtNumeroI').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            //[object Object]
	            if(data.filas!="[object Object]"){
	            	
	            	$('#MensajeValI').show();
	            	$('#MensajeValI').html("DOCUMENTO NO ENCONTRADO, PUEDE REGISTRARLO");
	            	$("#idPersonalI").val("");
	            	$("#txtNombreI").val("");
	            	$("#txtNombreI").removeAttr('disabled');
	            	$("#txtApellidoPaternoI").val("");
	            	$("#txtApellidoPaternoI").removeAttr('disabled');
	            	$("#txtApellidoMaternoI").val("");
	            	$("#txtApellidoMaternoI").removeAttr('disabled');
	            	$("#txtCIPI").val("");
	            	$("#txtCIPI").removeAttr('disabled');
	            	$("#btnGuardarInspector").removeAttr('disabled');
	            	$("#btnGuardarInspector").removeAttr('Style');
	            	
	            	 
	            	  
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
		              idPersonaN = value.idPersonaNatural;
		              //alert(idPersonaN);
		              $("#idPersonalI").val(value.idPersonaNatural);
	            	  $("#txtNombreI").val(value.nombre);
	            	  $("#txtApellidoPaternoI").val(value.apellidoPaterno);
	            	  $("#txtApellidoMaternoI").val(value.apellidoMaterno);
	            	  $("#txtCIPI").val(value.cip);
	            	  
	            	  $("#avisoEditarI").val('GuardarCIP');
	            	  
	            	  $("#txtNombreI").attr('disabled','disabled');
	            	  $("#txtApellidoPaternoI").attr('disabled','disabled');
	            	  $("#txtApellidoMaternoI").attr('disabled','disabled');
	            	  $("#txtCIPI").removeAttr('disabled');
	            	  $("#btnGuardarInspector").removeAttr('disabled');
	            	  $("#btnGuardarInspector").removeAttr('Style');
	            	  
		            }else{
		            	$('#MensajeValI').show();
		            	$('#MensajeValI').html("DOCUMENTO NO ENCONTRADO, PUEDE REGISTRARLO");
		            	$("#txtNombreI").removeAttr('disabled');
		            	$("#txtApellidoPaternoI").removeAttr('disabled');
		            	$("#txtApellidoMaternoI").removeAttr('disabled');
		            	$("#txtCIPI").removeAttr('disabled');
		            	$("#btnGuardarInspector").removeAttr('disabled');
		            	$("#btnGuardarInspector").removeAttr('Style');
		            }
	            });
	        }
	            
	        },
	        error:errorAjax
	    });
	}else{
		$('#MensajeValI').show();
    	$('#MensajeValI').html("POR FAVOR COLOQUE EL NUMERO DE DOCUMENTO");
	}
}
//-------------------------------------------------------------------------

//Validar Sede Personal
function ValidarSedePersona() {

	if ($("#txtNumeroI").val() !== "") {
		
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/validarSedePersonal",
	        type:'post',
	        async:false,
	        data:{
	        	idAlcanceAcreditacion: $('#idAAInspector').val(),
	        	//flagPersonalAutorizado: 'S',
	            numeroDocumento:$('#txtNumeroI').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            //[object Object]
	            if(data.filas!="[object Object]"){
	            	
	            	ValidarPersonalI();
	            	
	            }else{
	            	
	            	$('#MensajeValI').show();
	            	$('#MensajeValI').html("EL DNI PERTENECE A UN PERSONAL YA REGISTRADO");
	            	
	            	return false;
	            }
	            
	        },
	        error:errorAjax
	    });
	}else{
		$('#MensajeValI').show();
    	$('#MensajeValI').html("POR FAVOR COLOQUE EL NUMERO DE DOCUMENTO");
	}
}
//-------------------------------------------------------------------------

function buscarCIPDeInspector(){
    //var valor = 0;
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/validarPersonal",
        type:'POST',
        async:false,
        data:{
            cip : $("#txtCIPI").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            /*if (data.registros > 0){
            return valor = 1;
	        }*/
	        $.each(data.filas, function( index, value ) {
	        	iI = value.cip;
	        	IPNI = value.numeroDoc;
	            //alert(IPN);
	        })     
        },
        error:errorAjax
    });
    //return valor;
}

//----- CARGAR SEDE ACREDITACION ----------
function cargarDireccionSedeI() {

    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarDireccionSede",
        type:'post',
        async:false,
        data:{
           // estado :"A",
            idAlcanceAcreditacion: $('#idAAInspector').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idSedeAcreditacion','direccion','#cmbSedeI');
            
            ncbx2 = data.filas;
            
        },
        error:errorAjax
    });
}

//----- CARGAR TIPO DOCUMENTO ----------
function cargarTipoDocumentoI() {
	
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
            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbDocumentoI');
            
        },
        error:errorAjax
    });
}

//--------- CARGAR CARGO --------------------
function cargarEspecialidad() {
	
	var encuentro = "ESPECIALIDAD";
	var app = "MYC";

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
            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbEspecialidad');
            
        },
        error:errorAjax
    });
    
}

function btnGuardarSedePersonalAutorizado(){
	
	if($("#avisoEditarI").val()=='Editando'){
		//validarEdicionInspector()
		if(validarDatosFormularioInspector() == true){
			confirm.open("¿Confirma la actualizacion de datos?","modificacionGeneralInspector()");
		}else{
			$('#MensajeValI').show();}
		
	}else{
		if(validarDatosFormularioInspector() == true){
			
			if($("#idPersonalI").val() !==""  && $("#idPersonalI").val() !==undefined ){
				//alert("PersonalAuto");
		        confirm.open("¿Confirma el registro?","RegistrarSedePersonalAutorizado()");        
		    }else{
		    	confirm.open("¿Confirma el registro?","registrarPersonaNatural()");
		    	//registrarPersonaNatural();
		    }
			
		}else{$('#MensajeValI').show();}
	}
	//confirm.open("¿Confirma el registro?","RegistrarSedePersonalAutorizado()");
	
}

function registrarPersonaNatural(){
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarPersonaNatural",
        type:'post',
        async:false,
        data:{
            idTipoDoc: tipoDoc2,
            nroDoc:    $("#txtNumeroI").val(),
            ApPaterno: $("#txtApellidoPaternoI").val().latinize().toUpperCase(),
            ApMaterno: $("#txtApellidoMaternoI").val().latinize().toUpperCase(),
            nombre:    $("#txtNombreI").val().latinize().toUpperCase(),
            cip:       $("#txtCIPI").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            if(data.resultado=="0"){
                 //alert("resultado idPN:" + data.idPN);
                 idPersonaN = data.idPN;
                 $("#txtNumeroI").val(data.NroDoc);
                 $('#idPersonalI').val(data.idPN);
                 //confirm.open("¿Confirma el registro?","RegistrarSedePersonalAutorizado()");
                 RegistrarSedePersonalAutorizado();
            }else if(data.resultado=="2"){
                mensajeGrowl("warn", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function RegistrarSedePersonalAutorizado(){
	
	if($("#avisoEditarI").val()=='GuardarCIP'){
		modificarDatosInspector();
	}
	
$.ajax({
    url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarSedePersonalAutorizado",
    type:'post',
    async:false,
    data:{
    	
    	flagSedePersonalAutorizado: 'S',
    	idSedeAcreditacion: $('#cmbSedeI').val(),
    	idPersonaNatural : idPersonaN,//id pers natural
    	idEspecialidad : $('#cmbEspecialidad').val(),
    	idCargo : '',                    	

    	
    },
    beforeSend:muestraLoading,
    success:function(data){
        ocultaLoading();
        if(data.resultado=="0"){
        	$('#dialogInspectorAutorizado').dialog('close');
            listarInspector();
            mensajeGrowl("success", global.confirm.save, "");
        }
    },
    error:errorAjax
});		

}

function modificacionGeneralInspector(){
	modificarDatosInspector();
	modificarCargoEspecialidad();
	$('#dialogInspectorAutorizado').dialog('close');
	listarSedes();
    listarInspector();
}

function modificarDatosInspector(){
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/modificarPersonaNatural",
        type:'post',
        async:false,
        data:{
            idPersonaNatural :$("#idPersonalI").val(),
            nombre :$("#txtNombreI").val().latinize().toUpperCase(),
            apellidoPaterno :$("#txtApellidoPaternoI").val().latinize().toUpperCase(),
            apellidoMaterno :$("#txtApellidoMaternoI").val().latinize().toUpperCase(),
            cip :$("#txtCIPI").val()
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

function modificarCargoEspecialidad(){
	
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
}