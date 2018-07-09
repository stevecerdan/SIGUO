//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------

var estadoAux;
//var letraEstado;
var estadoAux1;
var estadoEmp;
var IdEmpresaAcreditadaAux = "";
var idAlAcredAux = "";
var mensj = "";
var idOrgAcredEA = "";
var idCbxPrueba = "";
var valIDTP = "";

$(function() {
	//listarProcesosAcreditacion(0);
	initDialogs();
    initInicioNuevaEmpresaAcreditada(); 
	$('#btnGuardar').click(btnGuardar);
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

function initInicioNuevaEmpresaAcreditada(){
	confirm.start();
	$('#seccionTipoPrueba').hide();
	cargarDepartamento();
	desactivarBotonGuardar();
	desactivarBotonProceso();
	//cargarTipoPruebaEA();
	
	$("#txtRazonSocial").attr('disabled','disabled');
	$("#cmbDepartamento").attr('disabled','disabled');
	$("#cmbProvincia").attr('disabled','disabled');
	$("#cmbDistrito").attr('disabled','disabled');
	$("#txtDireccion").attr('disabled','disabled');
	$("#txtTelefono").attr('disabled','disabled');
	$("#txtEmail").attr('disabled','disabled');
	$("#txtWeb").attr('disabled','disabled');
	$("#txtRegistro").attr('disabled','disabled');
	
	$('#txtRUC').click(function(){
		$("#MensajeVal").hide();
	});
	
	$('#txtRazonSocial').click(function(){
		$("#MensajeVal").hide();
	});
	
	$('#cmbDepartamento').click(function(){
		$("#MensajeVal").hide();
	});
	
	$('#cmbProvincia').click(function(){
		$("#MensajeVal").hide();
	});
	
	$('#cmbDistrito').click(function(){
		$("#MensajeVal").hide();
	});
	
	$('#txtDireccion').click(function(){
		$("#MensajeVal").hide();
	});
	
	$('#txtEmail').click(function(){
		$("#MensajeVal").hide();
	});
	
	$('#btnNuevo').click(function(){
		$("#MensajeEA").hide();
		desactivarBotonGuardar();
		$("#txtRazonSocial").attr('disabled','disabled');
		$("#cmbDepartamento").attr('disabled','disabled');
		$("#cmbProvincia").attr('disabled','disabled');
		$("#cmbDistrito").attr('disabled','disabled');
		$("#txtDireccion").attr('disabled','disabled');
		$("#txtTelefono").attr('disabled','disabled');
		$("#txtEmail").attr('disabled','disabled');
		$("#txtWeb").attr('disabled','disabled');
		$("#txtRegistro").attr('disabled','disabled');
		idOrgAcredEA = $("#idOrgAcreditadorEA").val();
		idCbxPrueba = $("#cmbTipoPruebaEA").val();
    	abrirAlcanceAcreditacion(idOrgAcredEA,idCbxPrueba);
    	var IdEmpresaAcreditada = $('#idEmpresaAcreditada').val();
		var estadoForm = 'SAVE';
		RetornarIdEmpAcred(IdEmpresaAcreditada,estadoForm);
    });
	
	$('#btnValidar').click(function(){
		cargarDatos();
	});
	
	$('#txtRUC').change(function(){
		$("#txtRazonSocial").val('');
		$("#txtRazonSocial").attr('disabled','disabled');
		$("#cmbDepartamento").val(0);
		$("#cmbDepartamento").attr('disabled','disabled');
		$("#cmbProvincia").val(0);
		$("#cmbProvincia").attr('disabled','disabled');
		$("#cmbDistrito").val(0);
		$("#cmbDistrito").attr('disabled','disabled');
		$("#txtDireccion").val('');
		$("#txtDireccion").attr('disabled','disabled');
		$("#txtTelefono").val('');
		$("#txtTelefono").attr('disabled','disabled');
		$("#txtEmail").val('');
		$("#txtEmail").attr('disabled','disabled');
		$("#txtWeb").val('');
		$("#txtWeb").attr('disabled','disabled');
		$("#txtRegistro").val('');
		$("#txtRegistro").attr('disabled','disabled');
		$("#idEmpresaAcreditada").val('');
		$("#MensajeEA").hide();
		desactivarBotonGuardar();
	});
	
	$("#cmbDepartamento").change(function(){
	    cargarProvincia();
	    $("#cmbDistrito").val(0);
	});

	$("#cmbProvincia").change(function(){
		cargarDistrito();
	});
	
	$("#cmbTipoPruebaEA").change(function(){
		//alert($("#cmbTipoPruebaEA").val());
		valIDTP = $("#cmbTipoPruebaEA").val();
		if(valIDTP !== ""){
		validarEmpresaAcreditada();
		listarProcesosAcreditacion();
		}else{
			$("#MensajeEA").hide();
			desactivarBotonProceso();
			$("#gridContenedorProcesos").html("");
		}
	});
	
	$('body').on('click', '.InformeE',function(){
	       var cadena= $(this).attr("id");
	  	   
	  	   var arrayCadena = cadena.split("%");
	  	   
	  	   var id = arrayCadena[0];
	  	   var estadoAccion = arrayCadena[1];
	    	
	    	var avi = "P"
	    	
	    	abrirInformacion2();
	    	cargarDatosInformacion(id,estadoAccion,avi);
	    });
	
	$('body').on('click', '.Editar',function(){
		
		   var cadena= $(this).attr("id");
	 	   
	 	   var arrayCadena = cadena.split("%");
	 	   
	 	   var id = arrayCadena[0];
	 	   var resolucionCedula = arrayCadena[1];
	 	   var idDocumentoAdjunto = arrayCadena[2];
	 	   var idDocumentoAlcanceAcredita = arrayCadena[3];
	 	   var normaEvaluada = arrayCadena[4];
	 	   var idOrganismoAcreditador = arrayCadena[5];
	 	   var fechaIVigencia = arrayCadena[6];
	 	   var fechaUActualizacion = arrayCadena[7];  
	 	   var fechaAcreditacion = arrayCadena[8];
	 	   var fechaVencimiento = arrayCadena[9];
	 	   var idTipoOrganismo = arrayCadena[10]; 
	 	   var idTipoPrueba = arrayCadena[11];
	 	   var estadoForm1 = arrayCadena[12];
	 	   var idEmpresaAcreditada = arrayCadena[13];
	 	   var idPrimerAlcanceAcreditacion = arrayCadena[14];
	 	   
	 	   if (id == '' || id == 'null'){
	 		   
	 		   id = '';
	 	   
	 	   } else {
	 		   
	 		   id =arrayCadena[0];
	 		   
	 	  }
	 	   
	       if (resolucionCedula == ''  || resolucionCedula == 'null'){
	 		   
	     	  resolucionCedula ='' ;
	 	   
	       } else {
	 		   
	     	  resolucionCedula =arrayCadena[1] ;
	 		   
	 	  }
	       
	       if (idDocumentoAdjunto == '' || idDocumentoAdjunto == 'null'){
	 		   
	     	  idDocumentoAdjunto ='';
	 	   
	       } else {
	 		   
	     	  idDocumentoAdjunto = arrayCadena[2];
	 		   
	 	  } 
	       
	       if (idDocumentoAlcanceAcredita == '' || idDocumentoAlcanceAcredita == 'null'){
	 		   
	     	  idDocumentoAlcanceAcredita ='' ;
	 	   
	       } else {
	 		   
	     	  idDocumentoAlcanceAcredita = arrayCadena[3];
	 		   
	 	  } 
	       
	       if (normaEvaluada == '' || normaEvaluada == 'null'){
	 		   
	     	  normaEvaluada = '';
	 	   
	       } else {
	 		   
	     	  normaEvaluada =arrayCadena[4];
	 		   
	 	  } 
	       
	       if (idOrganismoAcreditador == '' || idOrganismoAcreditador == 'null'){
	 		   
	     	  idOrganismoAcreditador = '';
	 	   
	       } else {
	 		   
	     	  idOrganismoAcreditador =arrayCadena[5];
	 		   
	 	  } 
	       
	       if (fechaIVigencia == '' || fechaIVigencia == 'null'){
	 		   
	     	  fechaIVigencia = '';
	 	   
	       } else {
	 		   
	     	  fechaIVigencia =arrayCadena[6];
	 		   
	 	  } 
	       
	       if (fechaUActualizacion == '' || fechaUActualizacion == 'null'){
	 		   
	     	  fechaUActualizacion ='' ;
	 	   
	       } else {
	 		   
	     	  fechaUActualizacion = arrayCadena[7];
	 		   
	 	  } 
	       
	       if (fechaAcreditacion == '' || fechaAcreditacion == 'null'){
	 		   
	     	  fechaAcreditacion = '';
	 	   
	       } else {
	 		   
	     	  fechaAcreditacion =arrayCadena[8];
	 		   
	 	  } 
	       
	       if (fechaVencimiento == '' || fechaVencimiento == 'null'){
	 		   
	     	  fechaVencimiento = '';
	 	   
	       } else {
	 		   
	     	  fechaVencimiento =arrayCadena[9];
	 		   
	 	  } 
	       
	       if (idTipoOrganismo == '' || idTipoOrganismo == 'null'){
	 		   
	     	  idTipoOrganismo ='';
	 	   
	       } else {
	 		   
	     	  idTipoOrganismo = arrayCadena[10];
	 		   
	 	  } 
	       
	       if (idTipoPrueba == '' || idTipoPrueba == 'null'){
	 		   
	     	  idTipoPrueba ='' ;
	 	   
	       } else {
	 		   
	     	  idTipoPrueba =arrayCadena[11];
	 		   
	 	  }
	       
	       if (estadoForm1){
	 		   
	     	  estadoForm1 = arrayCadena[12];
	 	   
	       } 
	       
	       if (idPrimerAlcanceAcreditacion == '' || idPrimerAlcanceAcreditacion == 'null'){
	 		   
	      	  idPrimerAlcanceAcreditacion ='' ;
	  	   
	        } else {
	  		   
	      	  idPrimerAlcanceAcreditacion = arrayCadena[14];
	  		   
	  	  } 
	       idOrgAcredEA = $("#idOrgAcreditadorEA").val();
	 	   abrirAuxAlcanceAcreditacion(idOrgAcredEA);
	 	   cargarEditarDatosAlcance(id,resolucionCedula,idDocumentoAdjunto,idDocumentoAlcanceAcredita,normaEvaluada,idOrganismoAcreditador,fechaIVigencia,fechaUActualizacion,fechaAcreditacion,fechaVencimiento,idTipoOrganismo,idTipoPrueba,estadoForm1,idEmpresaAcreditada,idPrimerAlcanceAcreditacion);
	 	   
 });
	
	$('body').on('click', '.Consultar',function(){
			
		   var cadena= $(this).attr("id");
	 	   
	 	   var arrayCadena = cadena.split("%");
	 	   
	 	   var id = arrayCadena[0];
	 	   var resolucionCedula = arrayCadena[1];
	 	   var idDocumentoAdjunto = arrayCadena[2];
	 	   var idDocumentoAlcanceAcredita = arrayCadena[3];
	 	   var normaEvaluada = arrayCadena[4];
	 	   var idOrganismoAcreditador = arrayCadena[5];
	 	   var fechaIVigencia = arrayCadena[6];
	 	   var fechaUActualizacion = arrayCadena[7];  
	 	   var fechaAcreditacion = arrayCadena[8];
	 	   var fechaVencimiento = arrayCadena[9];
	 	   var idTipoOrganismo = arrayCadena[10]; 
	 	   var idTipoPrueba = arrayCadena[11];
	 	   var estadoForm1 = arrayCadena[12];
	 	   var idEmpresaAcreditada = arrayCadena[13];
	 	   var idPrimerAlcanceAcreditacion = arrayCadena[14];
	 	   
	 	   if (id == '' || id == 'null'){
	 		   
	 		   id = '';
	 	   
	 	   } else {
	 		   
	 		   id =arrayCadena[0];
	 		   
	 	  }
	 	   
	       if (resolucionCedula == ''  || resolucionCedula == 'null'){
	 		   
	     	  resolucionCedula ='' ;
	 	   
	       } else {
	 		   
	     	  resolucionCedula =arrayCadena[1] ;
	 		   
	 	  }
	       
	       if (idDocumentoAdjunto == '' || idDocumentoAdjunto == 'null'){
	 		   
	     	  idDocumentoAdjunto ='';
	 	   
	       } else {
	 		   
	     	  idDocumentoAdjunto = arrayCadena[2];
	 		   
	 	  } 
	       
	       if (idDocumentoAlcanceAcredita == '' || idDocumentoAlcanceAcredita == 'null'){
	 		   
	     	  idDocumentoAlcanceAcredita ='' ;
	 	   
	       } else {
	 		   
	     	  idDocumentoAlcanceAcredita = arrayCadena[3];
	 		   
	 	  } 
	       
	       if (normaEvaluada == '' || normaEvaluada == 'null'){
	 		   
	     	  normaEvaluada = '';
	 	   
	       } else {
	 		   
	     	  normaEvaluada =arrayCadena[4];
	 		   
	 	  } 
	       
	       if (idOrganismoAcreditador == '' || idOrganismoAcreditador == 'null'){
	 		   
	     	  idOrganismoAcreditador = '';
	 	   
	       } else {
	 		   
	     	  idOrganismoAcreditador =arrayCadena[5];
	 		   
	 	  } 
	       
	       if (fechaIVigencia == '' || fechaIVigencia == 'null'){
	 		   
	     	  fechaIVigencia = '';
	 	   
	       } else {
	 		   
	     	  fechaIVigencia =arrayCadena[6];
	 		   
	 	  } 
	       
	       if (fechaUActualizacion == '' || fechaUActualizacion == 'null'){
	 		   
	     	  fechaUActualizacion ='' ;
	 	   
	       } else {
	 		   
	     	  fechaUActualizacion = arrayCadena[7];
	 		   
	 	  } 
	       
	       if (fechaAcreditacion == '' || fechaAcreditacion == 'null'){
	 		   
	     	  fechaAcreditacion = '';
	 	   
	       } else {
	 		   
	     	  fechaAcreditacion =arrayCadena[8];
	 		   
	 	  } 
	       
	       if (fechaVencimiento == '' || fechaVencimiento == 'null'){
	 		   
	     	  fechaVencimiento = '';
	 	   
	       } else {
	 		   
	     	  fechaVencimiento =arrayCadena[9];
	 		   
	 	  } 
	       
	       if (idTipoOrganismo == '' || idTipoOrganismo == 'null'){
	 		   
	     	  idTipoOrganismo ='';
	 	   
	       } else {
	 		   
	     	  idTipoOrganismo = arrayCadena[10];
	 		   
	 	  } 
	       
	       if (idTipoPrueba == '' || idTipoPrueba == 'null'){
	 		   
	     	  idTipoPrueba ='' ;
	 	   
	       } else {
	 		   
	     	  idTipoPrueba =arrayCadena[11];
	 		   
	 	  }
	       
	       if (estadoForm1){
	 		   
	     	  estadoForm1 = arrayCadena[12];
	 	   
	       } 
	       
	       if (idPrimerAlcanceAcreditacion == '' || idPrimerAlcanceAcreditacion == 'null'){
	 		   
	      	  idPrimerAlcanceAcreditacion ='' ;
	  	   
	        } else {
	  		   
	      	  idPrimerAlcanceAcreditacion = arrayCadena[14];
	  		   
	  	  } 
	       idOrgAcredEA = $("#idOrgAcreditadorEA").val();
	 	   abrirAuxAlcanceAcreditacion(idOrgAcredEA);
	 	   cargarConsultarDatosAlcance(id,resolucionCedula,idDocumentoAdjunto,idDocumentoAlcanceAcredita,normaEvaluada,idOrganismoAcreditador,fechaIVigencia,fechaUActualizacion,fechaAcreditacion,fechaVencimiento,idTipoOrganismo,idTipoPrueba,estadoForm1,idEmpresaAcreditada,idPrimerAlcanceAcreditacion);
	 	   
    });
	
	$('body').on('click', '.Suspender',function(){
		letraEstado = "S";
		var cadena= $(this).attr("id");
		var arrayCadena = cadena.split("%");
		var id = arrayCadena[0];
		var idEmpresaAcreditada = arrayCadena[1];
		estadoAux1 = "S";
		estadoEmp = "ACTIVO";
    	abrirFrmEstadoAccion(id, estadoAux1, letraEstado,idEmpresaAcreditada,estadoEmp);
    	$('#lblCedula').html("Adjuntar Cédula de Suspensión:");
    });
	
	$('body').on('click', '.Cancelar',function(){
		letraEstado = "C";
		var cadena= $(this).attr("id");
		var arrayCadena = cadena.split("%");
		var id = arrayCadena[0];
		var idEmpresaAcreditada = arrayCadena[1];
		estadoEmp = "ACTIVO";
    	estadoAux1 = "C";
    	abrirFrmEstadoAccion(id, estadoAux1, letraEstado,idEmpresaAcreditada,estadoEmp);
    	$('#lblCedula').html("Adjuntar Cédula de Cancelación:");
    });
    
	$('body').on('click', '.Habilitar',function(){
		letraEstado = "H";
		var cadena= $(this).attr("id");
		var arrayCadena = cadena.split("%");
		var id = arrayCadena[0];
		var idEmpresaAcreditada = arrayCadena[1];
		
		estadoEmp = "ACTIVO";
    	estadoAux1 = "A";
    	abrirFrmEstadoAccion(id, estadoAux1, letraEstado,idEmpresaAcreditada,estadoEmp);
    	$('#lblCedula').html("Adjuntar Cédula de Habilitación:");
    });
	
	/*$('#btnGuardar').click(function(){
		confirm.open("¿Desea guardar el registro?");
    });*/
	
	$('#btnRegresar').click(function(){
		//$('#dialogNuevaEmpresaAcreditada').dialog('close');
		window.location.href = baseURL+'pages/mantenimientoEmpresasAcreditadas';
		listarEmpresasAcreditadas(0);
    });
}

function desactivarBotonGuardar(){
	$('#btnGuardar').attr('disabled','disabled');
	$('#btnGuardar').attr('style','background-color:#60869a');
}

function activarBotonGuardar(){
	$("#btnGuardar").removeAttr('disabled');
	$("#btnGuardar").removeAttr('style');
}

function desactivarBotonProceso(){
	$('#btnNuevo').attr('disabled','disabled');
	$('#btnNuevo').attr('style','background-color:#60869a');
}

function activarBotonProceso(){
	$("#btnNuevo").removeAttr('disabled');
	$("#btnNuevo").removeAttr('style');
}

function caracteresCorreoValido(email){
    console.log(email);
    var caract = new RegExp(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);

    if (caract.test(email) == false){
        return false;
    }else{
        return true;
    }
}

function cargarOrganismoEA(idOrgAcred){
	$("#idOrgAcreditadorEA").val(idOrgAcred);
	cargarTipoPruebaEA();
}

function initDialogs() {
	  
	$("#dialog-message").dialog({
		modal : true,
		autoOpen : false,
		buttons : {
			Ok : function() {
				$(this).dialog("close");
			}
		}
	});
  }


function validarDatosFormularioEA(){
	
	/*if($("#txtRUC").val().length !== 11) {  
		//alert("EL NRO DE RUC DEBE CONTENER 11 DÍGITOS.");
        return false;  
    }*/ 
	if($("#txtRazonSocial").val() =="" || $('#txtRazonSocial').val() == undefined) {
		$('#MensajeVal').html("POR FAVOR COLOQUE LA RAZON SOCIAL");
        return false;  
    } 
	if($("#cmbDepartamento").val() == "" || $("#cmbDepartamento").val() == undefined){
		$('#MensajeVal').html("POR FAVOR SELECCIONE UN DEPARTAMENTO");
		return false;
	}
	if($("#cmbProvincia").val() == "" || $("#cmbProvincia").val() == undefined){
		$('#MensajeVal').html("POR FAVOR SELECCIONE UNA PROVINCIA");
		return false;
	}
	if($("#cmbDistrito").val() == "" || $("#cmbDistrito").val() == undefined){
		$('#MensajeVal').html("POR FAVOR SELECCIONE UN DISTRITO");
		return false;
	}
	if($("#txtDireccion").val() =="" || $('#txtDireccion').val() == undefined) {
		$('#MensajeVal').html("POR FAVOR COLOQUE LA DIRECCION DE LA EMPRESA");
        return false;  
    }
	
	if($("#txtEmail").val() !="" || $('#txtEmail').val() != undefined) {
		
        if ( caracteresCorreoValido($("#txtEmail").val()) == false){
        	$('#MensajeVal').html("POR FAVOR COLOQUE UN EMAIL VALIDO");
            return false;
        }
        
    } 
	return true;
}

function cargarDatosEmpresaAcreditada(id,ruc,msg){

	$('#idEmpresaAcreditada').val(id);
	$('#txtRUC').val(ruc);
	mensj = msg;
	cargarDatos();
	$("#txtTelefono").removeAttr('disabled');
	$("#txtEmail").removeAttr('disabled');
	$("#txtWeb").removeAttr('disabled');
	$("#txtRegistro").removeAttr('disabled');
	activarBotonGuardar();
	
}

function cargarTipoPruebaEA() {

    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarComboTipoPruebaOrg",
        type:'post',
        async:false,
        data:{
        	idOrganismoAcreditador: $("#idOrgAcreditadorEA").val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idTipoPrueba','descripcion','#cmbTipoPruebaEA');
            
        },
        error:errorAjax
    });
    
    //$("#cmbTipoPruebaEA").val('1467');
    document.getElementById("cmbTipoPruebaEA").selectedIndex=1;
}

function abrirAuxAlcanceAcreditacion(idOrgAcredEA){ 
	
	var title="ALCANCE ACREDITACIÓN";
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirNuevoAlcanceAcreditacion", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogProcesoAcreditacion1").html(data);
            $("#dialogProcesoAcreditacion1").dialog({
            	position: ['center', 'top+2'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "1120",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
            //OrgAcreditadorEnAlcance(idOrgAcredEA);
        },
        error:errorAjax
    });
}

function abrirFrmEstadoAccion(id, estadoAux, letraEstado,idEmpresaAcreditada,estadoEmp){  
	
	var TB;
	
	if(letraEstado == "S"){
		TB="SUSPENDER PROCESO";
   }
    if(letraEstado == "H"){
    	TB="HABILITAR PROCESO";
    }
    if(letraEstado == "C"){
    	TB="CANCELAR PROCESO";
    }
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirFrmEstadoAccion", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogFrmEstadoAccion").html(data);
            $("#dialogFrmEstadoAccion").append(" <input type='hidden' name='idAlcanceAcreditacion' id='idAlcanceAcreditacion' value='"+id+"'/> " +
            		" <input type='hidden' name='estado' id='estado' value='"+estadoAux+"'/> "+
            		" <input type='hidden' name='letraEstado' id='letraEstado' value='"+letraEstado+"'/> " +
            		" <input type='hidden' name='idEmpresaAcreditada' id='idEmpresaAcreditada' value='"+idEmpresaAcreditada+"'/> " +
            		" <input type='hidden' name='estadoEmpresaAcreditada' id='estadoEmpAcred' value='"+estadoEmp+"'/> ");
        
            $("#dialogFrmEstadoAccion").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "500",
                position: ['center', 'top+30'],
                modal: true,
                dialogClass: 'dialog',
                title: TB,
                closeText: "Cerrar"
            });
            cargarMotivo(letraEstado);
        },
        
        error:errorAjax
    });
}

function abrirAlcanceAcreditacion(idOrgAcredEA,idCbxPrueba){ 
	
	var title="ALCANCE ACREDITACIÓN";
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirNuevoAlcanceAcreditacion", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogProcesoAcreditacion").html(data);
            $("#dialogProcesoAcreditacion").dialog({
            	position: ['center', 'top+2'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "1120",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
            OrgAcreditadorEnAlcance(idOrgAcredEA,idCbxPrueba);
        },
        error:errorAjax
    });
}

//Listar en la Grilla Procesos de Acreditacion
function listarProcesosAcreditacion(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorProcesos").html("");
    
    var grid = $("<table>", {
        "id": "gridProcesos"
    });
    
    var pager = $("<div>", {
        "id": "paginacionProcesos"
    });
    
    $("#gridContenedorProcesos").append(grid).append(pager);


    var nombres = ['','','','','','','','','','','N°', 'TIPO DE PRUEBA', 'RESOLUCI&Oacute;N','REGISTRO','FECHA DE ULTIMA ACTUALIZACI&Oacute;N','FECHA DE ACREDITACI&Oacute;N','FECHA DE VENCIMIENTO','ESTADO','','OPCION'];
    var columnas = [
    	{name: "idDocumentoAdjunto",width: 30, sortable: false, hidden: true, align: "center"},
    	{name: "idDocumentoAlcanceAcredita",width: 30, sortable: true, hidden: true, align: "center"},
    	{name: "normaEvaluada",width: 30, sortable: false, hidden: true, align: "center"},
    	{name: "idOrganismoAcreditador",width: 30, sortable: false, hidden: true, align: "center"},
    	{name: "fechaIVigencia",width: 30, sortable: false, hidden: true, align: "center"},
    	{name: "idTipoPrueba",width: 30, sortable: false, hidden: true, align: "center"},
    	{name: "idTipoOrganismo",width: 30, sortable: false, hidden: true, align: "center"},
    	{name: "idPrimerAlcanceAcreditacion",width: 30, sortable: false, hidden: true, align: "center"},
        {name: "idEmpresaAcreditada", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "idAlcanceAcreditacion", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "NP", width: 20, sortable: false, hidden: false, align: "center", formatter:"NumeroFilasP"},
        {name: "tipoPrueba", width: 135, sortable: false, hidden: false, align: "left"},
        {name: "resolucionCedula", width: 70, sortable: false, hidden: false, align: "left"},
        {name: "registro", width: 70, sortable: false, hidden: false, align: "left"},
        {name: "fechaUActualizacion", width: 100, sortable: false, hidden: false, align: "left", formatter:"fmtFechaUA"},
        {name: "fechaAcreditacion", width: 93, sortable: false, hidden: false, align: "left", formatter:"fmtFechaA"},
        {name: "fechaVencimiento", width: 93, sortable: false, hidden: false, align: "left", formatter:"fmtFechaV"},
        {name: "estadoAlcance", width: 100, sortable: false, hidden: false, align: "left", formatter: "fmtEstadoNewEmpAcred"},
        {name: "estadoAccion", width: 65, sortable: false, hidden: true, align: "center"},
        {name: "opcion", width: 240, sortable: false, hidden: false, align: "center", formatter:"OpcionesEmpAcreditadas"}
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarEmpresasAcreditadas",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            email: $("#txtEmail").val(),
            idOrganismoAcreditador: $("#idOrgAcreditadorEA").val(),
            ruc: $("#txtRUC").val(),
            idTipoPrueba : $("#cmbTipoPruebaEA").val(),
        },
        hidegrid: false,
        rowNum: 4,
        pager: "#paginacionProcesos",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Procesos de Acreditación",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idEmpresaAcreditada"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            estadoAux = rowData.estadoAlcance;
            idAlAcredAux = rowData.idAlcanceAcreditacion;
            idEmpresaAcreditadaAux = rowData.idEmpresaAcreditada;
            //alert("rowdata: " + idAlAcredAux);
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Conteo de filas
    jQuery.extend($.fn.fmatter, {
    	NumeroFilasP: function(cellvalue, options, rowdata) {
          var n = $("#gridContenedorProcesos tr").index() + 1;
          return n;
        }
    });
    
  //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoNewEmpAcred: function(cellvalue, options, rowdata) {
            var sel = rowdata.estadoAlcance;
            var tex ='';
            if(sel=='A'){
            	tex='VIGENTE ';
            }else{
            	if(sel=='I'){
            		tex='NO VIGENTE ';
            	}else{
            		if(sel=='S'){
            			tex='SUSPENDIDO ';
            		}else{
            			if(sel=='C'){
                			tex='CANCELADO ';
                		}
            		}
            	}
            }
            return tex+"<img src=\"" + baseURL + "/../images/info2.png\" class='InformeE' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.estadoAccion+"'style=\"cursor: pointer; width: 16px;\" title=\"Informe\"/>" ;
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesEmpAcreditadas: function(cellvalue, options, rowdata) {
    		var sel = rowdata.estadoAlcance;
    		var tex ='';
    		var estadoForm1 = 'UPDATE';
    		var dateVar1 = rowdata.fechaIVigencia;
    		var dateVar2 = rowdata.fechaUActualizacion;
    		var dateVar3 = rowdata.fechaAcreditacion;
    		var dateVar4 = rowdata.fechaVencimiento;
    		
    		var d1=new Date(dateVar1);
    		var d2=new Date(dateVar2);
    		var d3=new Date(dateVar3);
    		var d4=new Date(dateVar4);
    		
    		if(d1.getDate() < 10){
    			var dia1 = '0' + d1.getDate();
    		}else{
    			var dia1 = d1.getDate();
    		}
    		if((d1.getMonth()+1) < 10){
    			var mes1 = '0' + (d1.getMonth() + 1);
    		}else{
    			var mes1 = d1.getMonth() + 1;
    		}    		
    		if(d2.getDate() < 10){
    			var dia2 = '0' + d2.getDate();
    		}else{
    			var dia2 = d2.getDate();
    		}
    		if((d2.getMonth()+1) < 10){
    			var mes2 = '0' + (d2.getMonth() + 1);
    		}else{
    			var mes2 = d2.getMonth() + 1;
    		}
    		if(d3.getDate() < 10){
    			var dia3 = '0' + d3.getDate();
    		}else{
    			var dia3 = d3.getDate();
    		}
    		if((d3.getMonth()+1) < 10){
    			var mes3 = '0' + (d3.getMonth() + 1);
    		}else{
    			var mes3 = d3.getMonth() + 1;
    		}
    		if(d4.getDate() < 10){
    			var dia4 = '0' + d4.getDate();
    		}else{
    			var dia4 = d4.getDate();
    		}
    		if((d4.getMonth()+1) < 10){
    			var mes4 = '0' + (d4.getMonth() + 1);
    		}else{
    			var mes4 = d4.getMonth() + 1;
    		}
    		
    		var fIVigencia = dia1 + '/' + mes1 + '/' + d1.getFullYear();
    		var fUActualizacion = dia2 + '/' + mes2 + '/' + d2.getFullYear();
    		var fAcreditacion = dia3 + '/' + mes3 + '/' + d3.getFullYear();
    		var fVencimiento = dia4 + '/' + mes4 + '/' + d4.getFullYear();
            
            if(sel=='A'){
           	 tex = "<a class='Editar' id='"+ rowdata.idAlcanceAcreditacion +"%"+rowdata.resolucionCedula+"%"+ rowdata.idDocumentoAdjunto +"%"+ rowdata.idDocumentoAlcanceAcredita +"%"+ rowdata.normaEvaluada +"%"+ rowdata.idOrganismoAcreditador +"%"+ fIVigencia +"%"+ fUActualizacion +"%"+ fAcreditacion +"%"+ fVencimiento +"%"+ rowdata.idTipoOrganismo +"%"+ rowdata.idTipoPrueba +"%"+estadoForm1+"%"+rowdata.idEmpresaAcreditada+"%"+rowdata.idPrimerAlcanceAcreditacion+"' style='cursor: pointer;text-decoration:none;' ><u> Editar </u></a>"+"\t"+
           		   "<a class='Consultar' id='"+ rowdata.idAlcanceAcreditacion +"%"+rowdata.resolucionCedula+"%"+ rowdata.idDocumentoAdjunto +"%"+ rowdata.idDocumentoAlcanceAcredita +"%"+ rowdata.normaEvaluada +"%"+ rowdata.idOrganismoAcreditador +"%"+ fIVigencia +"%"+ fUActualizacion +"%"+ fAcreditacion +"%"+ fVencimiento +"%"+ rowdata.idTipoOrganismo +"%"+ rowdata.idTipoPrueba +"%"+estadoForm1+"%"+rowdata.idEmpresaAcreditada+"%"+rowdata.idPrimerAlcanceAcreditacion+"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>"+"\t"+
           	 	   "<a class='Suspender' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Suspender </u></a>"+"\t"+
           	 	   "<a class='Cancelar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>";
           }
            if(sel=='S'){
            	tex= "<a class='Editar' id='"+ rowdata.idAlcanceAcreditacion +"%"+rowdata.resolucionCedula+"%"+ rowdata.idDocumentoAdjunto +"%"+ rowdata.idDocumentoAlcanceAcredita +"%"+ rowdata.normaEvaluada +"%"+ rowdata.idOrganismoAcreditador +"%"+ fIVigencia +"%"+ fUActualizacion +"%"+ fAcreditacion +"%"+ fVencimiento +"%"+ rowdata.idTipoOrganismo +"%"+ rowdata.idTipoPrueba +"%"+estadoForm1+"%"+rowdata.idEmpresaAcreditada+"%"+rowdata.idPrimerAlcanceAcreditacion+"' style='cursor: pointer;text-decoration:none;' ><u> Editar </u></a>"+"\t"+
            		 "<a class='Consultar' id='"+ rowdata.idAlcanceAcreditacion +"%"+rowdata.resolucionCedula+"%"+ rowdata.idDocumentoAdjunto +"%"+ rowdata.idDocumentoAlcanceAcredita +"%"+ rowdata.normaEvaluada +"%"+ rowdata.idOrganismoAcreditador +"%"+ fIVigencia +"%"+ fUActualizacion +"%"+ fAcreditacion +"%"+ fVencimiento +"%"+ rowdata.idTipoOrganismo +"%"+ rowdata.idTipoPrueba +"%"+estadoForm1+"%"+rowdata.idEmpresaAcreditada+"%"+rowdata.idPrimerAlcanceAcreditacion+"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>"+"\t"+
           	 	   	 "<a class='Habilitar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Habilitar </u></a>"+"\t"+
           	 	   	 "<a class='Cancelar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>";
        	}
            if(sel=='I' || sel=='C'){
            	tex= "<a class='Consultar' id='"+ rowdata.idAlcanceAcreditacion +"%"+rowdata.resolucionCedula+"%"+ rowdata.idDocumentoAdjunto +"%"+ rowdata.idDocumentoAlcanceAcredita +"%"+ rowdata.normaEvaluada +"%"+ rowdata.idOrganismoAcreditador +"%"+ fIVigencia +"%"+ fUActualizacion +"%"+ fAcreditacion +"%"+ fVencimiento +"%"+ rowdata.idTipoOrganismo +"%"+ rowdata.idTipoPrueba +"%"+estadoForm1+"%"+rowdata.idEmpresaAcreditada+"%"+rowdata.idPrimerAlcanceAcreditacion+"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
        	}
            return tex;
        }
    });
    
    //Fecha Ultima Actualizacion
    jQuery.extend($.fn.fmatter, {
    	fmtFechaUA: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaUActualizacion;
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
	    		
	    		var fecha = dia + '-' + mes + '-' + d.getFullYear();
    		
    		}else{
    			var fecha = '--/--/----'
    		}
    		return fecha;
    		 
        }
    });
    
  //Fecha Acreditacion
    jQuery.extend($.fn.fmatter, {
    	fmtFechaA: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaAcreditacion;
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
	    		
	    		var fecha = dia + '-' + mes + '-' + d.getFullYear();
    		
    		}else{
    			var fecha = '--/--/----'
    		}
    		return fecha;
    		 
        }
    });
    
  //Fecha Vencimiento
    jQuery.extend($.fn.fmatter, {
    	fmtFechaV: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaVencimiento;
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
	    		
	    		var fecha = dia + '-' + mes + '-' + d.getFullYear();
    		
    		}else{
    			var fecha = '--/--/----'
    		}
    		return fecha;
    		 
        }
    });
	
}

//CARGAR DATOS DE PERSONA JURIDICA
function cargarDatos() {
	
	if ($("#txtRUC").val() !== "") {
		
		if($("#txtRUC").val().length !== 11) {
			
            $('#MensajeVal').html("EL NRO. DE RUC DEBE CONTENER 11 DÍGITOS");
            $("#MensajeVal").show();
			//alert("EL NRO DE RUC DEBE CONTENER 11 DÍGITOS");
	        return false;
	        
	    }else{
	    	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarDatos",
	        type:'post',
	        async:false,
	        data:{
	            ruc:$('#txtRUC').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
				if(data.filas!="[object Object]"){
	            	
					$('#MensajeVal').html("EL NRO. DE RUC NO ESTÁ REGISTRADO");
		            $("#MensajeVal").show();
					$('#txtRPTA').val("NO")
					//-----
					$("#txtRazonSocial").removeAttr('disabled');
	            	$("#cmbDepartamento").removeAttr('disabled');
	            	$("#cmbProvincia").removeAttr('disabled');
	            	$("#cmbDistrito").removeAttr('disabled');
	            	$("#txtDireccion").removeAttr('disabled');
	            	$("#txtTelefono").removeAttr('disabled');
	            	$("#txtEmail").removeAttr('disabled');
	            	$("#txtWeb").removeAttr('disabled');
	            	$("#txtRegistro").removeAttr('disabled');
	            	//-----
	            	$("#MensajeGAA").hide();
	            	$('#seccionTipoPrueba').show();
	            	$('#cmbTipoPrueba').attr('disabled','disabled');
	            	listarProcesosAcreditacion();
	            	activarBotonGuardar();
	            	return false;
	            	
	            }else{
	            
	            $.each(data.filas, function( index, value ) {
	            	 
	            	$('#txtRPTA').val("SI")
	            	  $("#idPersonaJuridica").val(value.idPersonaJuridica);
	            	  $("#txtRazonSocial").val(value.razonSocial);
	            	  //$("#cmbDepartamento").append('<option value ="" selected="selected">' + value.departamento + '</option>');
	            	  //$("#cmbProvincia").append('<option value ="" selected="selected">' + value.provincia + '</option>');
	            	  //$("#cmbDistrito").append('<option value ="" selected="selected">' + value.distrito + '</option>');
	            	  $("#cmbDepartamento").val(value.departamento);
	            	  cargarProvincia(); 
	            	  $("#cmbProvincia").val(value.provincia);
	            	  cargarDistrito();
	            	  $("#cmbDistrito").val(value.distrito);
	            	  $("#txtDireccion").val(value.direccion);
	            	  $("#txtTelefono").val(value.telefono);
	            	  $("#txtEmail").val(value.email);
	            	  $("#txtWeb").val(value.web);
	            	  //if($("#idEmpresaAcreditada").val()==''){
	            	  $("#txtRegistro").val('');
	            	  $("#txtRegistro").removeAttr('disabled');
	            	  //}
	            	  $('#seccionTipoPrueba').show();
	            	  validarEmpresaAcreditada();
	            	  listarProcesosAcreditacion();
	            	  
	            	  $('#cmbTipoPrueba').removeAttr('disabled');
	            	  $('#cmbTipoPrueba').attr('style','width:210px;');
	            	  $("#MensajeGAA").hide();
          			  //listarProcesosAcreditacion();
	            	  
	            });
	            
	            	 $("#txtRazonSocial").attr('disabled','disabled');
	            	 $("#cmbDepartamento").attr('disabled','disabled');
	            	 $("#cmbProvincia").attr('disabled','disabled');
	            	 $("#cmbDistrito").attr('disabled','disabled');
	            	 $("#txtDireccion").attr('disabled','disabled');
	            	 $("#txtTelefono").attr('disabled','disabled');
	            	 $("#txtEmail").attr('disabled','disabled');
	            	 $("#txtWeb").attr('disabled','disabled');
	            	 $('#cmbTipoPrueba').attr('disabled','disabled');
	            	 //$("#txtRegistro").attr('disabled','disabled');
	            	 
	            }
	              
	        },
	        error:errorAjax
	    });
	    
	    }
		
	}else{
		$('#MensajeVal').html("EL NRO. DE RUC DEBE CONTENER 11 DÍGITOS");
        $("#MensajeVal").show();
	}
}

//VALIDA LA EMPRESA ACREDITADA SI YA EXISTE
function validarEmpresaAcreditada() {
	
	var estadoProceso = "";
	var letraAccion = "";
	var org = "";
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarIdEmpresaAcreditada",
	        type:'post',
	        async:false,
	        data:{
	            idPersonaJuridica:$('#idPersonaJuridica').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            $.each(data.filas, function( index, value ) {
	            	$("#idEmpresaAcreditada").val(value.idEmpresaAcreditada);
	            	$("#txtRegistro").val(value.registro);
	            	//$("#txtRegistro").removeAttr('disabled');
	            	//$("#txtRegistro").attr('disabled','disabled');
	            	//estadoProceso = value.estado;
	            	//alert(estadoProceso);
	            });
	            
	            $.ajax({
	                url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarFechaUA",
	                type:'post',
	                async:false,
	                data:{
	                    idEmpresaAcreditada:$('#idEmpresaAcreditada').val(),
	                    idOrganismoAcreditador:$("#idOrgAcreditadorEA").val(),
	                    idTipoPrueba : $("#cmbTipoPruebaEA").val()
	                },
	                beforeSend:muestraLoading,
	                success:function(data){
	                	
	                    ocultaLoading();
	                    
	                    if(data.filas!="[object Object]"){
	                    	
	                    	$("#MensajeEA").show();
        		            $('#MensajeEA').html("ESTA EMPRESA YA PUEDE INICIAR UN PROCESO DE ACREDITACION");
        		            activarBotonProceso();
	            			
	                    }else{
	                    
	                    $.each(data.filas, function( index, value ) {
	                    	letraAccion = value.estadoAccion;
	                    	org = value.idOrganismoAcreditador
	                    	//alert("Letra de Estado Accion: "+letraAccion+" -- Id de Organismo: "+org);
	                    }); 
	                    
	                    if($("#idEmpresaAcreditada").val()!=""){
	                    	$("#txtRegistro").attr('disabled','disabled');
	                    	if(letraAccion == "R" || letraAccion == "S" || letraAccion == "H"){
	        		            $("#MensajeEA").show();
	        		            $('#MensajeEA').html("ESTA EMPRESA CUENTA CON UN PROCESO DE ACREDITACION VIGENTE");
	        		            desactivarBotonProceso();
	                    	}else{
	                    		$("#MensajeEA").show();
	        		            $('#MensajeEA').html("ESTA EMPRESA YA PUEDE INICIAR UN PROCESO DE ACREDITACION");
	        		            activarBotonProceso();
	                    	}
	                    desactivarBotonGuardar();
	                    }else{
	                    	$("#MensajeEA").hide();
	                    	activarBotonGuardar();
	                    }
	                    
	                    }
	                },
	                error:errorAjax
	            });
	        },
	        error:errorAjax
	    });
}

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
	            fill.combo(data.filas,'idDepartamento','nombre','#cmbDepartamento');
	            
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
	        	idDepartamento:$("#cmbDepartamento").val(),
	            idDistrito:ceros
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idProvincia','nombre','#cmbProvincia');
	            
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
	        	idDepartamento:$("#cmbDepartamento").val(),
	            idProvincia:$("#cmbProvincia").val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idDistrito','nombre','#cmbDistrito');
	            
	        },
	        error:errorAjax
	    });
}
//Fin Cargar Ubigeo

function btnGuardar(){
	 
	var rpta = $('#txtRPTA').val();
	
	if(mensj=="EDIT"){
		confirm.open("¿Confirma la actualización de datos?","modificacionGeneralEmpresaAcreditada()");
		
	}else{
	
		if(rpta == 'NO'){
			
			if(validarDatosFormularioEA() == true){
			confirm.open("¿Desea guardar el registro?","RegistrarPersonaJuridica()");
			//validarEmpresaAcreditada();
			}else{
	            $("#MensajeVal").show();
			}
			
		} else {
			
			if(validarDatosFormularioEA() == true){
			confirm.open("¿Desea guardar el registro?","RegistrarEmpresaAcreditada()");
			//validarEmpresaAcreditada();
			}else{
	            $("#MensajeVal").show();
			}
			 
		}
	}
	
}

function RegistrarEmpresaAcreditada(){
	
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarEmpresaAcreditada",
        type:'post',
        async:false,
        data:{
        	
        	idPersonaJuridica : $('#idPersonaJuridica').val(),
        	estado: 'INACTIVO',
        	registro : $('#txtRegistro').val().latinize().toUpperCase()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            validarEmpresaAcreditada();
            $('#cmbTipoPrueba').removeAttr('disabled');
            $('#cmbTipoPrueba').attr('style','width:210px;');
            if(data.resultado=="0"){
                
                //var idEmpresaAcreditada = data.idEmpresaAcreditada;
           	 	//$('#idEmpresaAcreditada').val(data.idEmp);
            	mensajeGrowl("success", global.confirm.save, "");
            	$("#dialog-message-content").html('Se han registrado los datos principales de la empresa acreditada, para visualizar su información en la bandeja principal, debe ingresar el proceso de acreditación');
				$("#dialog-message").dialog("open");
            }
        },
        error:errorAjax
	});	
	
}

function RegistrarPersonaJuridica() {
	
	
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarPersonaJuridica",
        type:'post',
        async:false,
        data:{
        	
        	ruc : $('#txtRUC').val(),
        	razonSocial : $('#txtRazonSocial').val().latinize().toUpperCase(),
        	idDepartamento : $('#cmbDepartamento').val(),
        	idProvincia : $('#cmbProvincia').val(),
        	idDistrito : $('#cmbDistrito').val(),
        	direccion : $('#txtDireccion').val().latinize().toUpperCase(),
        	telefono : $('#txtTelefono').val(),
        	email : $('#txtEmail').val().latinize().toUpperCase(),
        	web : $('#txtWeb').val().latinize().toUpperCase(),
        	
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            traerId();
            if(data.resultado=="0"){
            	
            	var idPersonaJuridica = $("#idPersonaJuridica").val();
            	

            	$.ajax({
                    url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarEmpresaAcreditada",
                    type:'post',
                    async:false,
                    data:{
                    	
                    	idPersonaJuridica : idPersonaJuridica,
                    	estado: 'INACTIVO',
                    	registro : $('#txtRegistro').val().latinize().toUpperCase()
                    },
                    beforeSend:muestraLoading,
                    success:function(data){
                        ocultaLoading();
                        validarEmpresaAcreditada();
                        $('#cmbTipoPrueba').removeAttr('disabled');
                        $('#cmbTipoPrueba').attr('style','width:210px;');
                        if(data.resultado=="0"){
                        	mensajeGrowl("success", global.confirm.save, "");
                        	$("#MensajeGAA").hide();
                        	listarProcesosAcreditacion();
                        	//Bloqueando Campos
                        	$("#txtRazonSocial").attr('disabled','disabled');
	       	            	$("#cmbDepartamento").attr('disabled','disabled');
	       	            	$("#cmbProvincia").attr('disabled','disabled');
	       	            	$("#cmbDistrito").attr('disabled','disabled');
	       	            	$("#txtDireccion").attr('disabled','disabled');
	       	            	$("#txtTelefono").attr('disabled','disabled');
	       	            	$("#txtEmail").attr('disabled','disabled');
	       	            	$("#txtWeb").attr('disabled','disabled');
	       	            	$("#txtRegistro").attr('disabled','disabled');
	       	            	
                        	$("#dialog-message-content").html('Se han registrado los datos principales de la empresa acreditada, para visualizar su información en la bandeja principal, debe ingresar el proceso de acreditación');
            				$("#dialog-message").dialog("open");
                        	
                            
                        }
                    },
                    error:errorAjax
            	});	
            }
        },
        error:errorAjax
	});	
}

function traerId() {
	if ($("#txtRUC").val() !== "") {
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarDatos",
	        type:'post',
	        async:false,
	        data:{
	            ruc:$('#txtRUC').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            $.each(data.filas, function( index, value ) {
	            	
	            	  $("#idPersonaJuridica").val(value.idPersonaJuridica);
	            });
	        },
	        error:errorAjax
	    });
	}
}

function abrirInformacion2(){ 
	
	var title="INFORMACION - ESTADO DEL ALCANCE DE ACREDITACION";
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirInformacion", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogInfo2").html(data);
            $("#dialogInfo2").dialog({
            	position: ['center', 'top+2'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "400",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        },
        error:errorAjax
    });
}

function modificacionGeneralEmpresaAcreditada(){
	modificarDatosPersonaJuridica();
	modificarDatosEmpresaAcreditada();
	$("#txtTelefono").attr('disabled','disabled');
 	$("#txtEmail").attr('disabled','disabled');
 	$("#txtWeb").attr('disabled','disabled');
 	$("#txtRegistro").attr('disabled','disabled');
 	desactivarBotonGuardar()
	
}

function modificarDatosPersonaJuridica(){
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/modificarDatosPersonaJuridica",
        type:'post',
        async:false,
        data:{
            idPersonaJuridica :$("#idPersonaJuridica").val(),
            telefono : $('#txtTelefono').val(),
        	email : $('#txtEmail').val().latinize().toUpperCase(),
        	web : $('#txtWeb').val().latinize().toUpperCase()
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

function modificarDatosEmpresaAcreditada(){
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/modificarDatosEmpresaAcreditada",
        type:'post',
        async:false,
        data:{
            idEmpresaAcreditada :$("#idEmpresaAcreditada").val(),
            registro : $('#txtRegistro').val().latinize().toUpperCase()
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