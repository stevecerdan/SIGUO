//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------

var estadoAux;
var letraEstado;
var idAux="";
var tipoPrueba="";
var aae = "";
var idAlcanceAcreditacionAux="";

$(function() {
	//initDialogs();
	//listarSedes(0);
	//listarInspector(0);
	//listarEquipo(0);
	//listarDocumentoAdjuntoAA(0);
	//listarDocumentoAlcanceAA(0);
	initInicioNuevoAlcanceAcreditacion();  
	$("#MensajeFECHA").hide();
	$('#MensajeValA').hide();
	$( "#txtFechaUA" ).datepicker();
    $( "#txtFechaA" ).datepicker();
    $("#txtFechaIV").datepicker();
    $("#txtFechaV").datepicker();
    
    $( "#txtFechaUA" ).attr( "readonly" , "readonly" );
    $( "#txtFechaA" ).attr( "readonly" , "readonly" );
    $( "#txtFechaIV" ).attr( "readonly" , "readonly" );
    $( "#txtFechaV" ).attr( "readonly" , "readonly" );
});


function formattedDate(d = new Date) {
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return `${day}/${month}/${year}`;
}

function convertDateFormat(string) {
	var info = string.split('/');
	return info[1] + '/' + info[0] + '/' + info[2];
}

//----------Funciones de Validaciones----------

//validar ingreso de solo numeros
function validaNumericos(event) {
    if(event.charCode >= 48 && event.charCode <= 57){
      return true;
     }
     return false;        
}

//---------------------------------------------

$("#cmbTipoPrueba").change(function(){
	var text = $("#cmbTipoPrueba option:selected").text();
	if(text=="PRUEBA DE HERMETICIDAD"){
		$("#cmbTipoOrganismo").removeAttr('disabled');
	}else{
		$("#cmbTipoOrganismo").val(0);
		$("#cmbTipoOrganismo").attr('disabled','disabled');
	}
});

function initInicioNuevoAlcanceAcreditacion(){
	confirm.start();
	cargarTipo();
	cargarTipoOrganismo();
	$("#cmbTipoOrganismo").attr('disabled','disabled');
	desactivarBotonesSIE();
	
	//cargar o no grillas
	if($("#idAlcanceAcreditacion").val()!=""){
		$("#MensajeAS").hide();
		listarSedes(0);
		$("#MensajeAI").hide();
		listarInspector(0);
		$("#MensajeAE").hide();
		listarEquipo(0);
		activarBotonesSIE();
	}
	
	$('#txtFechaIV').change(function(){
		var fua = $('#txtFechaUA').val();
		var fiv = $('#txtFechaIV').val();
		var fv = $('#txtFechaV').val();
		
		var vua = fua.split("/");
		var dua = vua[0];
		var mua = vua[1];
		var aua = vua[2];
		
		var viv = fiv.split("/");
		var div = viv[0];
		var miv = viv[1];
		var aiv = viv[2];
		
		var vv = fv.split("/");
		var dv = vv[0];
		var mv = vv[1];
		var av = vv[2];
		
		if(dua > div && mua >= miv && aua >= aiv){
			$("#MensajeFECHA").show();
			$('#txtFechaIV').val('');
		}
		
		if(fv!=""){
			if(div > dv && miv >= mv && aiv >= av){
			$("#MensajeFECHA").show();
			$('#txtFechaV').val('');
			}
		}
		
	});
	
	$('#txtFechaIV').click(function(){
		$("#MensajeFECHA").hide();
		$("#MensajeValA").hide();
	});
	
	$('#txtFechaV').change(function(){
		var fiv2 = $('#txtFechaIV').val();
		var fv2 = $('#txtFechaV').val();
		
		var viv2 = fiv2.split("/");
		var div2 = viv2[0];
		var miv2 = viv2[1];
		var aiv2 = viv2[2];
		
		var vv2 = fv2.split("/");
		var dv2 = vv2[0];
		var mv2 = vv2[1];
		var av2 = vv2[2];
		
		if(dv2 < div2 && mv2 <= miv2 && av2 <= aiv2){
			$("#MensajeFECHA").show();
			$('#txtFechaV').val('');
		}
	});
	
	$('#txtFechaV').click(function(){
		$("#MensajeFECHA").hide();
		$("#MensajeValA").hide();
	});
	//--- ocultar mensaje de validacion vacios
	$('#cmbTipoPrueba').click(function(){
		$("#MensajeValA").hide();
	});
	
	$('#txtResolucion').click(function(){
		$("#MensajeValA").hide();
	});
	
	$('#txtRegistro').click(function(){
		$("#MensajeValA").hide();
	});
	
	$('#txtNorma').click(function(){
		$("#MensajeValA").hide();
	});
	//---------------------------------
	$('#btnNuevaSede').click(function(){
    	var aas = $('#idAlcanceAcreditacion').val();
    	abrirNuevaSede(aas);
    });
	
	$('#btnNuevoInspector').click(function(){
		var aai = $('#idAlcanceAcreditacion').val();
    	abrirInspectorAutorizado(aai);
    });
	
	$('#btnNuevoEquipo').click(function(){
		aae = $('#idAlcanceAcreditacion').val();
		tipoPrueba = $("#cmbTipoPrueba").val();
    	abrirEquipoCertificado(aae, "", tipoPrueba);
    });
	
	$('#btnGuardarAlcance').click(function(){
	 if(validarDatosFormularioAlcance() == true){
		if($('#estadoForm').val()=="SAVE"){
			if($('#RespuestaRegistrar').val()=="REGISTRADO"){
				//$('#dialogProcesoAcreditacion').dialog('close');
				window.location.href = baseURL+'pages/mantenimientoEmpresasAcreditadas';
				//listarProcesosAcreditacion();
				//desactivarBotonProceso();
			}else{
			confirm.open("¿Desea guardar el registro?","RegistrarAlcanceAcreditacion()");
			}
		}else{
		confirm.open("¿Desea actualizar los datos del registro?","RegistrarAlcanceAcreditacion()");
		//$('#dialogProcesoAcreditacion1').dialog('close');
		//listarEmpresasAcreditadas(0);
		}
	 }else{
		 $("#MensajeValA").show();
	 }
    });
	
	$('#btnRegresarAlcance').click(function(){
		if($('#estadoForm').val()=="UPDATE"){
			//confirm.open("Si usted agregó una Sede, Inspector o Equipo, Estos datos quedaran registrados. ¿Desea Seguir?","regresarDeEdicion()");
			$('#dialogProcesoAcreditacion1').dialog('close');
			listarProcesosAcreditacion();
		}else{
			$('#dialogProcesoAcreditacion').dialog('close');
			listarProcesosAcreditacion();
		}
    });
	
	$('body').on('click', '.Eliminar',function(){
    	var id= $(this).attr("id");
    	//alert("eliminar: " + id);
        confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarPersonalAutorizado('" + id + "')");
    });
	
	$('body').on('click', '.EditarEquipo',function(){
    	var id= $(this).attr("id");
    	aae = $('#idAlcanceAcreditacion').val();
    	tipoPrueba = $("#cmbTipoPrueba").val();
    	abrirEquipoCertificado(aae, id, tipoPrueba);
    	$("#cmbEstado").removeAttr('disabled');
    	//listarPersonal();
		
    });   
	
	$('body').on('click', '.EliminarEquipo',function(){
        var id= $(this).attr("id");
        confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarEquipoCertificado('" + id + "')");
        //listarPersonal();
    }); 
	
	$('#uploadfile').change(function() {
		$('#MensajeValA').hide();
	    var filename = $('#uploadfile')[0].files[0]
	    $('#nombreArchivo').text(filename.name);
	});
	
	$('#uploadfileA').change(function() {
		$('#MensajeValA').hide();
	    var filename = $('#uploadfileA')[0].files[0]
	    $('#nombreArchivoA').text(filename.name);
	});
	
	$('#btnAdjuntarArchivo').click(function(){
		
		//$('#nombreArchivo').text("Subir Archivo, Click Aquí");
		if($('#nombreArchivo').text()=="Subir Archivo, Click Aquí"){
			$('#MensajeValA').show();
			$('#MensajeValA').html("POR FAVOR SUBA UN ARCHIVO ANTES DE GUARDAR");
		}else{
    	//confirm.open("¿Desea guardar el archivo adjunto?","registrarDocumento()");
    	registrarDocumento();
    	//listarDocumentoAdjuntoAA(0);
		}
    });
	
	$('#btnAdjuntarAlcance').click(function(){
		
		if($('#nombreArchivoA').text()=="Subir Archivo, Click Aquí"){
			$('#MensajeValA').show();
			$('#MensajeValA').html("POR FAVOR SUBA UN ARCHIVO ANTES DE GUARDAR");
		}else{
    	//confirm.open("¿Desea guardar el documento de alcance?","registrarDocumentoA()");
    	registrarDocumentoA();
    	//listarDocumentoAlcanceAA(0);
		}
    });
	
	$('body').on('click', '.EliminarDocumento',function(){
		
    	var id= $(this).attr("id");
    	//alert("eliminar: " + id);
        //confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarPersonalAutorizado('" + id + "')");
        //eliminarPersonalAutorizado('id');
		modificarEstadoxEliminar(id);
		$('#txtAdjuntarArchivo').val("");
		desbloquearItemsDocumentoAdjunto();
		$("#gridContenedorDocAA").html("");
		$("#gridContenedorDocAA1").attr('style','margin-left:750px;');
    });
	
	$('body').on('click', '.EliminarDocumentoA',function(){
		
		var id= $(this).attr("id");
		//alert("eliminar: " + id);
        //confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarPersonalAutorizado('" + id + "')");
        //eliminarPersonalAutorizado('id');
		modificarEstadoxEliminar(id);
		$('#txtAdjuntarAlcance').val("");
		desbloquearItemsAlcanceAdjunto();
		$("#gridContenedorDocAA1").html("");
		$("#gridContenedorDocAA1").removeAttr('style');
    });
    
}

function desactivarBotonesSIE(){
	//Desactivar Botones
	$('#btnNuevaSede').attr('disabled','disabled');
	$('#btnNuevaSede').attr('style','background-color:#60869a; width:150px;');
	$('#btnNuevoInspector').attr('disabled','disabled');
	$('#btnNuevoInspector').attr('style','background-color:#60869a; width:150px;');
	$('#btnNuevoEquipo').attr('disabled','disabled');
	$('#btnNuevoEquipo').attr('style','background-color:#60869a; width:150px;');
}

function activarBotonesSIE(){
	//Activar Botones
	$("#btnNuevaSede").removeAttr('disabled');
	$("#btnNuevaSede").removeAttr('style');
	$('#btnNuevaSede').attr('style','width:150px');
	$('#btnNuevoInspector').removeAttr('disabled');
	$('#btnNuevoInspector').removeAttr('style');
	$('#btnNuevoInspector').attr('style','width:150px');
	$('#btnNuevoEquipo').removeAttr('disabled');
	$('#btnNuevoEquipo').removeAttr('style');
	$('#btnNuevoEquipo').attr('style','width:150px');
}

function bloquearInput(){
    $('#idAlcanceAcreditacion').attr('disabled','disabled');
    $('#txtResolucion').attr('disabled','disabled');
    $('#txtRegistro').attr('disabled','disabled');
    //$('#txtAdjuntarArchivo').attr('disabled','disabled');
    //$('#txtAdjuntarAlcance').attr('disabled','disabled');
    bloquearItemsDocumentoAdjunto();
    bloquearItemsAlcanceAdjunto();
    $('#txtNorma').attr('disabled','disabled');
    $('#idOrganismoAcreditador').attr('disabled','disabled');  
    $('#txtFechaUA').attr('disabled','disabled');
    $('#txtFechaA').attr('disabled','disabled');
    $('#txtFechaIV').attr('disabled','disabled');
    $('#txtFechaV').attr('disabled','disabled');
    $('#cmbTipoPrueba').attr('disabled','disabled');
    $('#cmbTipoOrganismo').attr('disabled','disabled');
    $('#idEAcreditada').attr('disabled','disabled');   
    //$('#btnGuardarAlcance').attr('disabled','disabled');
    //$('#btnGuardarAlcance').attr('style','background-color:#60869a; width:120px;');
    $('#btnGuardarAlcance').hide();
    $('#btnRegresarAlcance').hide();
    // $('.EditarEquipo').attr('disabled','disabled');
    // $('.EliminarEquipo').attr('disabled','disabled');
}

function bloquearItemsDocumentoAdjunto(){
	$('#uploadfile').attr('disabled','disabled');
 	$('#nombreArchivo').attr('disabled','disabled');
 	$('#nombreArchivo').attr('style','font:normal 12px "Calibri"; cursor:not-allowed; background-color:#EBEBE4;');
 	$('#btnAdjuntarArchivo').attr('disabled','disabled');
 	$('#btnAdjuntarArchivo').attr('style','margin-left:176px; width:50px;background-color:#60869a;');
}

function bloquearItemsAlcanceAdjunto(){
	$('#uploadfileA').attr('disabled','disabled');
 	$('#nombreArchivoA').attr('disabled','disabled');
 	$('#nombreArchivoA').attr('style','font:normal 12px "Calibri"; cursor:not-allowed; background-color:#EBEBE4;');
 	$('#btnAdjuntarAlcance').attr('disabled','disabled');
 	$('#btnAdjuntarAlcance').attr('style','margin-left:215px; width:50px;background-color:#60869a;');
}

function desbloquearItemsDocumentoAdjunto(){
	$('#uploadfile').removeAttr('disabled');
 	$('#nombreArchivo').removeAttr('disabled');
 	$('#nombreArchivo').removeAttr('style');
 	$('#nombreArchivo').attr('style','font:normal 12px "Calibri";');
 	//$('#nombreArchivo').text("Subir Archivo, Click Aquí");
 	$('#btnAdjuntarArchivo').removeAttr('disabled');
 	$('#btnAdjuntarArchivo').attr('style','margin-left:176px; width:50px;');
}

function desbloquearItemsAlcanceAdjunto(){
	$('#uploadfileA').removeAttr('disabled');
 	$('#nombreArchivoA').removeAttr('disabled');
 	$('#nombreArchivoA').removeAttr('style');
 	$('#nombreArchivoA').attr('style','font:normal 12px "Calibri";');
 	//$('#nombreArchivoA').text("Subir Archivo, Click Aquí");
 	$('#btnAdjuntarAlcance').removeAttr('disabled');
 	$('#btnAdjuntarAlcance').attr('style','margin-left:215px; width:50px;');
}

function validarDatosFormularioAlcance(){
	
	if($("#cmbTipoPrueba").val() == "" || $("#cmbTipoPrueba").val() == undefined){
		$('#MensajeValA').html("POR FAVOR SELECCIONE UN TIPO DE PRUEBA");
		return false;
	}
	
	if($("#txtResolucion").val() =="" || $('#txtResolucion').val() == undefined) {
		$('#MensajeValA').html("POR FAVOR COLOQUE EL NUMERO DE RESOLUCIÓN O CEDULA");
        return false;  
    } 

	if($("#txtAdjuntarArchivo").val() =="" || $('#txtAdjuntarArchivo').val() == undefined) {
		$('#MensajeValA').html("POR FAVOR ADJUNTAR UN ARCHIVO");
        return false;  
    } 
	
	if($("#txtFechaIV").val() =="" || $('#txtFechaIV').val() == undefined) {
		$('#MensajeValA').html("POR FAVOR COLOQUE LA FECHA DE INICIO DE VIGENCIA");
        return false;  
    } 
	
	if($("#txtFechaV").val() =="" || $('#txtFechaV').val() == undefined) {
		$('#MensajeValA').html("POR FAVOR COLOQUE LA FECHA DE VENCIMIENTO");
        return false;  
    } 
	return true;
}

/*function initDialogs() {
	
	$("#dialog-message_error_msg").dialog({
		modal : true,
		autoOpen : false,
		buttons : {
			Ok : function() {
									
				$(this).dialog("close");
			}
		}
	});
}*/

function RetornarIdEmpAcred(IdEmpresaAcreditada,estadoForm){
	
	$('#idEAcreditada').val(IdEmpresaAcreditada);
	$('#estadoForm').val(estadoForm);
	
	if($('#estadoForm').val()=="SAVE"){
		
		TraerFechaUltimaActualizacion();
		TraerIDPrimerAlcance();
	}
		
}

function cargarDatosAlcance(id,resolucionCedula,registro,idDocumentoAdjunto,idDocumentoAlcanceAcredita,normaEvaluada,idOrganismoAcreditador,fechaIVigencia,fechaUActualizacion,fechaAcreditacion,fechaVencimiento,idTipoOrganismo,idTipoPrueba,estadoForm1,idEmpresaAcreditada,idPrimerAlcanceAcreditacion,estadoAlcance){

	$('#idAlcanceAcreditacion').val(id);
	$('#txtResolucion').val(resolucionCedula);
	$('#txtRegistro').val(registro);
	$('#txtAdjuntarArchivo').val(idDocumentoAdjunto);
	$('#txtAdjuntarAlcance').val(idDocumentoAlcanceAcredita);
	$('#txtNorma').val(normaEvaluada);
	$('#idOrganismoAcreditador').val(idOrganismoAcreditador);	
	$('#txtFechaUA').val(fechaUActualizacion);
	$('#txtFechaA').val(fechaAcreditacion);
	$('#txtFechaIV').val(fechaIVigencia);
	$('#txtFechaV').val(fechaVencimiento);
	$('#cmbTipoPrueba').val(idTipoPrueba);
	$('#cmbTipoOrganismo').val(idTipoOrganismo);
	//$('#estadoForm').val(estadoForm1);
	$('#idEAcreditada').val(idEmpresaAcreditada);
	//idPrimerAlcanceAcreditacion
	$('#idPrimerAlcanceAcreditacion').val(idPrimerAlcanceAcreditacion);
	var est = estadoAlcance;
	if(est=='A' || est =='S'){
		$('#estadoForm').val(estadoForm1);
		$('#RespuestaRegistrar').val("");
		   //---- desploquear combo tipo organismo
	 	   var text = $("#cmbTipoPrueba option:selected").text();
			
			if(text=="PRUEBA DE HERMETICIDAD"){
				$("#cmbTipoOrganismo").removeAttr('disabled');
			}else{
				$("#cmbTipoOrganismo").val(0);
				$("#cmbTipoOrganismo").attr('disabled','disabled');
			}
			//-------------------------
			if($('#txtAdjuntarArchivo').val()!=''){
				listarDocumentoAdjuntoAA();
				bloquearItemsDocumentoAdjunto();
			}
			if($('#txtAdjuntarAlcance').val()!=''){
				listarDocumentoAlcanceAA();
				$("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:750px;');
				bloquearItemsAlcanceAdjunto();
			}
			//-------------------------
			$("#MensajeFECHA").hide();
			$("#txtFechaUA").attr('disabled','disabled');
			$("#txtFechaA").attr('disabled','disabled');
			
			$("#MensajeAS").hide();
			listarSedes();
			$("#MensajeAI").hide();
			listarInspector();
			$("#MensajeAE").hide();
			listarEquipo();
			
			activarBotonesSIE();
			//$("#btnRegresarAlcance").attr('disabled','disabled');
			//$("#btnRegresarAlcance").attr('style','background-color:#60869a');
	}else{
		$('#estadoForm').val("");
		$('#RespuestaRegistrar').val("consulta");
		//------------
		$("#MensajeAS").hide();
		listarSedes(0);
		$("#MensajeAI").hide();
		listarInspector(0);
		$("#MensajeAE").hide();
		listarEquipo(0);
		
		listarDocumentoAdjuntoAA(0);
		
		if($('#txtAdjuntarAlcance').val()!=''){
 			listarDocumentoAlcanceAA(0);
 			$("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:750px;');
 		}
		
        bloquearInput();
	}
	
	
}

/*function cargarDatosAlcanceCTRL(){
    idAlcanceAcreditacionAux = $('#idAlcanceAcreditacion').val();
    //alert ("Cargar: " + idAlcanceAcreditacionAux);

        if(idAlcanceAcreditacionAux !== null && idAlcanceAcreditacionAux !== undefined){
            //alert("Entrada alcance");
            $.ajax({
                url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarDatosAlcanceCTRL",
                type:'post',
                async:false,
                data:{
                    idAlcanceAcreditacion : $('#idAlcanceAcreditacion').val()
                },
                beforeSend:muestraLoading,
                success:function(data){
                    
                    ocultaLoading();
                    
                    $.each(data.filas, function( index, value ) {
                        
                        $('#idAlcanceAcreditacion').val( value.idAlcanceAcreditacion );
                        $('#txtResolucion').val( value.resolucionCedula );
                        $('#txtRegistro').val( value.registro );
                        $('#txtAdjuntarArchivo').val( value.idDocumentoAdjunto );
                        $('#txtAdjuntarAlcance').val( value.idDocumentoAlcanceAcredita );
                        $('#txtNorma').val( value.normaEvaluada );
                        $('#idOrganismoAcreditador').val( value.idOrganismoAcreditador ); 
                        $('#idPrimerAlcanceAcreditacion').val( value.idPrimerAlcanceAcreditacion );  
                        $('#txtFechaUA').val( formattedDate( new Date(value.fechaUActualizacion)) );
                        $('#txtFechaA').val( formattedDate( new Date(value.fechaAcreditacion)) );
                        $('#txtFechaIV').val( formattedDate( new Date(value.fechaIVigencia)) );
                        $('#txtFechaV').val( formattedDate( new Date(value.fechaVencimiento)) );
                        $('#cmbTipoPrueba').val( value.idTipoPrueba );
                        $('#cmbTipoOrganismo').val( value.idTipoOrganismo );
                        $('#idEAcreditada').val( value.idEmpresaAcreditada ); 
                        $('#RespuestaRegistrar').val( "consulta" );
                        //RespuestaRegistrar
                    });
                },
                error:errorAjax
            });
            $("#MensajeAS").hide();
    		listarSedes(0);
    		$("#MensajeAI").hide();
    		listarInspector(0);
    		$("#MensajeAE").hide();
    		listarEquipo(0);
    		
    		listarDocumentoAdjuntoAA(0);
    		
    		if($('#txtAdjuntarAlcance').val()!=''){
     			listarDocumentoAlcanceAA(0);
     			$("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:750px;');
     		}
    		
            bloquearInput();
        }
}*/

function RegistrarAlcanceAcreditacion(){
	
	var idAlcanceAcreditacion = $('#idAlcanceAcreditacion').val();
	
	if (idAlcanceAcreditacion =="" && idAlcanceAcreditacion ==undefined){
		
		idAlcanceAcreditacion = 'null';		
		
	} else {
		
		idAlcanceAcreditacion = $('#idAlcanceAcreditacion').val();
	}
	
	//VALIDAR VACIOS DE DOCUMENTO ALCANCE ADJUNTO
	var idDA=$('#txtAdjuntarAlcance').val();
	
	if (idDA =="0"){
		
		idDA = 'null';		
		
	} else {
		
		idDA=$('#txtAdjuntarAlcance').val();
	}
  	//-------------------------------------------
  	
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarAlcanceAcreditacion",
        type:'post',
        async:false,
        data:{
        		idAlcanceAcreditacion: idAlcanceAcreditacion,
		        	     idTipoPrueba: $('#cmbTipoPrueba').val(),
		        	 resolucionCedula: $('#txtResolucion').val().latinize().toUpperCase(),
		           idDocumentoAdjunto: $('#txtAdjuntarArchivo').val(),
         //idDocumentoAlcanceAcreditada: $('#txtAdjuntarAlcance').val(),
         idDocumentoAlcanceAcreditada: idDA,
        	          idTipoOrganismo: $('#cmbTipoOrganismo').val(),
        	                 registro: $('#txtRegistro').val().latinize().toUpperCase(),
        	            normaEvualada: $('#txtNorma').val().latinize().toUpperCase(),
        	   idOrganismoAcreditador: $('#idOrganismoAcreditador').val(),
        	      idEmpresaAcreditada: $('#idEAcreditada').val(),    
          idPrimerAlcanceAcreditacion: $('#idPrimerAlcanceAcreditacion').val(),
          	//---- fechas
	        /* fechaUltimaActualizacion: newFechaUA,
	                fechaAcreditacion: newFechaA,
	              fechaInicioVigencia: newFechaIV,
	                 fechaVencimiento: newFechaV,*/
      		 fechaUltimaActualizacion: convertDateFormat($('#txtFechaUA').val()),
      				fechaAcreditacion: convertDateFormat($('#txtFechaA').val()),
      			  fechaInicioVigencia: convertDateFormat($('#txtFechaIV').val()),
      			  	 fechaVencimiento: convertDateFormat($('#txtFechaV').val()),
             //------------------------
	                           estado: 'A',
	                     estadoAccion: 'R',
              estadoEmpresaAcreditada: 'ACTIVO',
	                       estadoForm: $('#estadoForm').val(),
        	
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	
                //$('#dialogFrmEstadoAccion').dialog('close');
                //listarProcesosAcreditacion(0);
            	 var idAA = data.idAlcanceAcreditacion;
            	 $('#idAlcanceAcreditacion').val(idAA);
            	 if($('#estadoForm').val()=="SAVE" && $('#idAlcanceAcreditacion').val()!=""){
            		 $('#RespuestaRegistrar').val("REGISTRADO");
     			 }
            	 
            	 activarBotonesSIE();
            	 
            	 if($('#estadoForm').val()=="SAVE"){
            		 
            		 mensajeGrowl("success", global.confirm.save, "");
                	 
                	 //Esconder Mensajes y Listar
                	 $("#MensajeAS").hide();
                	 listarSedes(0);
                	 $("#MensajeAI").hide();
                	 listarInspector(0);
                	 $("#MensajeAE").hide();
                	 listarEquipo(0);
                	 
                	 listarDocumentoAdjuntoAA(0);
                	 if($('#txtAdjuntarAlcance').val()!=''){
             			listarDocumentoAlcanceAA(0);
             			$("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:750px;');
             		}
            	 
            		$.ajax({
            	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarTrazAlcanceAcred",
            	        type:'post',
            	        async:false,
            	        data:{
            	        	
            	        	    idAlcanceAcreditacion: $('#idAlcanceAcreditacion').val(),
            		                           estado: 'A',
            		                     estadoAccion: 'R',
            	        	
            	        },
            	        beforeSend:muestraLoading,
            	        success:function(data){
            	            ocultaLoading();
            	            if(data.resultado=="0"){
            	            	
            	                //$('#dialogFrmEstadoAccion').dialog('close');
            	                //listarProcesosAcreditacion(0);
            	            	/*var idAA2 = data.idAlcanceAcreditacion;
            	            	$('#idAlcanceAcreditacion').val(idAA2);
            	            	if($('#estadoForm').val()=="SAVE" && $('#idAlcanceAcreditacion').val()!=""){
            	            		$('#RespuestaRegistrar').val("REGISTRADO");
            	     			}*/
            	            	
            	            }
            	        },
            	        error:errorAjax
            		});	
            		
            		$('#txtResolucion').attr('disabled','disabled');
        			$('#txtRegistro').attr('disabled','disabled');
        			bloquearItemsDocumentoAdjunto();
        			bloquearItemsAlcanceAdjunto();
        			$('#txtNorma').attr('disabled','disabled');	
        			$('#txtFechaUA').attr('disabled','disabled');
        			$('#txtFechaA').attr('disabled','disabled');
        			$('#txtFechaIV').attr('disabled','disabled');
        			$('#txtFechaV').attr('disabled','disabled');
        			$('#cmbTipoPrueba').attr('disabled','disabled');
        			$('#cmbTipoOrganismo').attr('disabled','disabled');
        			
            	 }
            	 
            	 if($('#estadoForm').val()=="UPDATE"){
            		 
            		 //$("#dialogProcesoAcreditacion1").dialog('close');
            		 window.location.href = baseURL+'pages/mantenimientoEmpresasAcreditadas';
            		 //mensajeGrowl("success", global.confirm.edit2, "");
            		 //dialogProcesoAcreditacion1
            		 listarEmpresasAcreditadas(0);
            	 }
            }
        },
        error:errorAjax
	});		
}

//TRAER LA FECHA DE LA ULTIMA ACTUALIZACION
function TraerFechaUltimaActualizacion() {
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarFechaUA",
	        type:'post',
	        async:false,
	        data:{
	            idEmpresaAcreditada:$('#idEAcreditada').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            if(data.filas!="[object Object]"){
	            	
	            	var hoy = new Date();
	            	var dd = hoy.getDate();
	            	var mm = hoy.getMonth()+1;
	            	var yyyy = hoy.getFullYear();

	            	if(dd<10) {dd='0'+dd} 

	            	if(mm<10) {mm='0'+mm} 

	            	var fActual = dd+'/'+mm+'/'+yyyy;
	            	
	            	$("#txtFechaUA").val('');
	            	$("#txtFechaA").val(fActual);
	            	//bloquear
	            	$('#txtFechaUA').attr('disabled','disabled');
        			$('#txtFechaA').attr('disabled','disabled');
        			
	            }else{
	            
	            $.each(data.filas, function( index, value ) {
	            	var FUA = value.fechaVencimiento;
	            	var FA = value.fechaAcreditacion;
	            	
	            	var f1=new Date(FUA);
	            	var f2=new Date(FA);
	            	
	            	if(f1.getDate() < 10){
	        			var diaf1 = '0' + f1.getDate();
	        		}else{
	        			var diaf1 = f1.getDate();
	        		}
	        		if((f1.getMonth()+1) < 10){
	        			var mesf1 = '0' + (f1.getMonth() + 1);
	        		}else{
	        			var mesf1 = f1.getMonth() + 1;
	        		}
	        		
	        		if(f2.getDate() < 10){
	        			var diaf2 = '0' + f2.getDate();
	        		}else{
	        			var diaf2 = f2.getDate();
	        		}
	        		if((f2.getMonth()+1) < 10){
	        			var mesf2 = '0' + (f2.getMonth() + 1);
	        		}else{
	        			var mesf2 = f2.getMonth() + 1;
	        		}
	        		
	        		var fechaUAct = diaf1 + '/' + mesf1 + '/' + f1.getFullYear();
	        		var fechaAcred = diaf2 + '/' + mesf2 + '/' + f2.getFullYear();
	        		
	            	$("#txtFechaUA").val(fechaUAct);
	            	$("#txtFechaA").val(fechaAcred);
	            	//bloquear
	            	$('#txtFechaUA').attr('disabled','disabled');
        			$('#txtFechaA').attr('disabled','disabled');
	            	
	            });
	            }
	        },
	        error:errorAjax
	    });
}

//TRAER EL ID DEL PRIMER ALCANCE
function TraerIDPrimerAlcance() {
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarPrimerAlcance",
	        type:'post',
	        async:false,
	        data:{
	            idEmpresaAcreditada:$('#idEAcreditada').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            if(data.filas!="[object Object]"){
	            	
	            	$("#idPrimerAlcanceAcreditacion").val(""); 
        			
	            }else{
	            
	            $.each(data.filas, function( index, value ) {
	            	$("#idPrimerAlcanceAcreditacion").val(value.idAlcanceAcreditacion);
	            	
	            });
	            }
	        },
	        error:errorAjax
	    });
}

function cargarTipo() {
	
	var encuentro = "TIPO_PRUEBA";

	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	            dominio:encuentro
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbTipoPrueba');
	            
	        },
	        error:errorAjax
	    });
}

function cargarTipoOrganismo() {
	
	var encuentro = "TIPO_ORGANISMO";

	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	            dominio:encuentro
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbTipoOrganismo');
	            
	        },
	        error:errorAjax
	    });
}

function eliminarPersonalAutorizado(id){
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/eliminarPersonalAutorizado",
        type:'post',
        async:false,
        data:{
        	idPersonalAut: id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	//mensajeGrowl("success", global.confirm.delete, "");
                listarSedes();
                listarInspector();
            }else{
                //mensajeGrowl("error", data.mensaje, "");
            	//alert("NO PUDO SER ELIMINADO");

            }
        },
        error:errorAjax
    });
}

function eliminarEquipoCertificado(id){
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/eliminarEquipoCertificado",
        type:'post',
        async:false,
        data:{
            idEquipoCertificado: id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                //alert("ELIMINADO!!");
            	//mensajeGrowl("success", global.confirm.delete, "");
            	listarEquipo();
            }else{
                //mensajeGrowl("error", data.mensaje, "");
                //alert("NO PUDO SER ELIMINADO");

            }
        },
        error:errorAjax
    });
}

function abrirNuevaSede(aas){ 
	
	var title="AGREGAR SEDE";
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirNuevaSede", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogNuevaSede").html(data);
            $("#dialogNuevaSede").dialog({
            	position: ['center', 'top+20'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "730",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        	IdAlcanceASede(aas);
            
        },
        error:errorAjax
    });
}

function abrirInspectorAutorizado(aai){ 
	
	var title="AGREGAR INSPECTOR AUTORIZADO";
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirInspectorAutorizado", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogInspectorAutorizado").html(data);
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
                closeText: "Cerrar"
            });
            IdAlcanceAInspector(aai);
        },
        error:errorAjax
    });
}

function abrirEquipoCertificado(aae, id, tipoPrueba){ 
	
	var title;
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirEquipoCertificado", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogEquipoCertificado").html(data);
           if(id == "" || id == undefined){
        		title="NUEVO EQUIPO AUTORIZADO";
        		//alert("Nuevo: " + id);
        		$("#dialogEquipoCertificado").append(" <input type='hidden' name='idpruebaHermeticidad' id='idpruebaHermeticidad' value='"+tipoPrueba+"'/> ");
           }
           if(id !== "" && id !== undefined){
        	   title="EDITAR EQUIPO AUTORIZADO";
        	   $("#dialogEquipoCertificado").append(" <input type='hidden' name='idEquipoCertificado' id='idEquipoCertificado' value='"+id+"'/> ");
               $("#dialogEquipoCertificado").append(" <input type='hidden' name='idpruebaHermeticidad' id='idpruebaHermeticidad' value='"+tipoPrueba+"'/> ");

               //alert("Editar: " + id);
           }
            
            $("#dialogEquipoCertificado").dialog({
            	position: ['center', 'top+20'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "630",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar",
                open: function( event, ui ) {
            	cargarEquipoCertificado();
                }
            });
            IdAlcanceAEquipo(aae);
        },
        error:errorAjax
    });
}

//Listar Sedes
function listarSedes(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorSedes").html("");
    
    var grid = $("<table>", {
        "id": "gridSedes"
    });
    
    var pager = $("<div>", {
        "id": "paginacionSedes"
    });
    
    $("#gridContenedorSedes").append(grid).append(pager);


    var nombres = ['','N°', 'DIRECCI&Oacute;N','dpto', 'prov', 'dist', 'UBIGEO','tipoDoc', 'numeroDoc', 'nombre', 'apellidoPaterno', 'apellidoMaterno', 'PERSONA AUTORIZADA PARA FIRMAR LOS CERTIFICADOS / INFORMES DE INSPECCI&Oacute;N','CARGO','CIP','OPCION'];
    var columnas = [
        {name: "idSedePersonalAutorizado", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "NS", width: 20, sortable: false, hidden: false, align: "center", fomatter:"NumeroFilasS"},
        {name: "direccion", width: 180, sortable: false, hidden: false, align: "left"},
        {name: "departamento", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "provincia", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "distrito", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "ubigeo", width: 150, sortable: false, hidden: false, align: "center", formatter:"concatenaUbigeo"},
        {name: "tipoDocumento", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "numeroDocumento", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "nombre", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "apellidoPaterno", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "apellidoMaterno", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "personaAutorizada", width: 300, sortable: false, hidden: false, align: "left", formatter:"concatenaPersonalAutorizado"},
        {name: "especialidadCargo", width: 180, sortable: false, hidden: false, align: "center"},
        {name: "cip", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "opcion", width: 100, sortable: false, hidden: false, align: "center", formatter:"OpcionesE"}
    ];
    
    var flag = "A";
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarSedePersonalAutorizado",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            flagPersonalAutorizado: flag,
            idAlcanceAcreditacion: $('#idAlcanceAcreditacion').val()
        },
        hidegrid: false,
        rowNum: 2,
        pager: "#paginacionSedes",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "SEDES CUBIERTAS POR LA ACREDITACIÓN",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idSedePersonalAutorizado"
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
    	NumeroFilasS: function(cellvalue, options, rowdata) {
          var n = $("#gridContenedorSedes tr").index() + 1;
          return n;
        }
    });
    
    //Concatenar
    jQuery.extend($.fn.fmatter, {
    	concatenaUbigeo: function(cellvalue, options, rowdata) {
            var EAdpto=rowdata.departamento;
            var EAprov=rowdata.provincia;
            var EAdist=rowdata.distrito;
            var sel = '';
            if (EAdpto != null && EAprov != '' && EAprov != undefined && EAprov != undefined){     
            	sel = EAdpto+' - '+EAprov+' - '+EAdist;
            }
            return sel;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	concatenaPersonalAutorizado: function(cellvalue, options, rowdata) {
            var TD=rowdata.tipoDocumento;
            var ND=rowdata.numeroDocumento;
            var N=rowdata.nombre;
            var AP=rowdata.apellidoPaterno;
            var AM=rowdata.apellidoMaterno;
            var sel = '';
            if (TD != null && ND != '' && ND != undefined && ND != undefined){     
            	sel = TD+' '+ND+' - '+N+' '+AP+' '+AM;
            }
            return sel;
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesE: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
    		if($('#RespuestaRegistrar').val()=="consulta"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    		iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='Eliminar' id='"+ rowdata.idSedePersonalAutorizado +"' onclick=\"bandejaSupervision.abrirDetalleSupervision('" + rowdata.idSedePersonalAutorizado + "')\" style=\"cursor: pointer;\" title=\"Eliminar\"/>"    		
            return iconbutton;
    		}
        }
    });
}

//Listar Inspector
function listarInspector(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorInspector").html("");
    
    var grid = $("<table>", {
        "id": "gridInspector"
    });
    
    var pager = $("<div>", {
        "id": "paginacionInspector"
    });
    
    $("#gridContenedorInspector").append(grid).append(pager);


    var nombres = ['','N°', 'DIRECCI&Oacute;N','dpto', 'prov', 'dist', 'UBIGEO','TIPO DOCUMENTO', 'NUMERO', 'nombre', 'apellidoPaterno', 'apellidoMaterno', 'PERSONA','ESPECIALIDAD','CIP','OPCION'];
    var columnas = [
        {name: "idSedePersonalAutorizado", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "NI", width: 20, sortable: false, hidden: false, align: "center", formatter:"NumeroFilasI"},
        {name: "direccion", width: 148, sortable: false, hidden: false, align: "left"},
        {name: "departamento", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "provincia", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "distrito", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "ubigeo", width: 120, sortable: false, hidden: false, align: "center", formatter:"concatenaUbigeo"},
        {name: "tipoDocumento", width: 90, sortable: false, hidden: false, align: "center"},
        {name: "numeroDocumento", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "nombre", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "apellidoPaterno", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "apellidoMaterno", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "personaAutorizada", width: 200, sortable: false, hidden: false, align: "left", formatter:"concatenaPersona"},
        {name: "especialidadCargo", width: 148, sortable: false, hidden: false, align: "center"},
        {name: "cip", width: 90, sortable: false, hidden: false, align: "center"},
        {name: "opcion", width: 100, sortable: false, hidden: false, align: "center", formatter:"OpcionesE2"}
    ];
    
    var flag = "S";
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarSedePersonalAutorizado",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            flagPersonalAutorizado: flag,
            idAlcanceAcreditacion: $('#idAlcanceAcreditacion').val()
        },
        hidegrid: false,
        rowNum: 2,
        pager: "#paginacionInspector",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "INSPECTOR AUTORIZADO",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idSedePersonalAutorizado"
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
    	NumeroFilasI: function(cellvalue, options, rowdata) {
          var n = $("#gridContenedorInspector tr").index() + 1;
          return n;
        }
    });
    
    //Concatenar
    jQuery.extend($.fn.fmatter, {
    	concatenaUbigeo: function(cellvalue, options, rowdata) {
            var EAdpto=rowdata.departamento;
            var EAprov=rowdata.provincia;
            var EAdist=rowdata.distrito;
            var sel = '';
            if (EAdpto != null && EAprov != '' && EAprov != undefined && EAprov != undefined){     
            	sel = EAdpto+' - '+EAprov+' - '+EAdist;
            }
            return sel;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	concatenaPersona: function(cellvalue, options, rowdata) {
            var N=rowdata.nombre;
            var AP=rowdata.apellidoPaterno;
            var AM=rowdata.apellidoMaterno;
            var sel = '';
            if (N != null && AP != '' && AP != undefined && AP != undefined){     
            	sel = N+' '+AP+' '+AM;
            }
            return sel;
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesE2: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
    		
			if($('#RespuestaRegistrar').val()=="consulta"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    		
    		iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='Eliminar' id='"+ rowdata.idSedePersonalAutorizado +"' onclick=\"bandejaSupervision.abrirDetalleSupervision('" + rowdata.idSedePersonalAutorizado + "')\" style=\"cursor: pointer;\" title=\"Eliminar\"/>"
    		return iconbutton;
    		}
        }
    });
}

//Listar Equipo
function listarEquipo(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorEquipo").html("");
    
    var grid = $("<table>", {
        "id": "gridEquipo"
    });
    
    var pager = $("<div>", {
        "id": "paginacionEquipo"
    });
    
    $("#gridContenedorEquipo").append(grid).append(pager);


    var nombres = ['','N°', 'TIPO DE EQUIPO','DESCRIPCION', 'FECHA CALIBRACION', 'FECHA PROXIMA CALIBRACION', 'ESTADO','OPCION'];
    var columnas = [
        {name: "idEquipoCertificado", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "NE", width: 20, sortable: false, hidden: false, align: "center", formatter:"NumeroFilasE"},
        {name: "tipoEquipo", width: 150, sortable: false, hidden: false, align: "left"},
        {name: "descripcionEquipo", width: 130, sortable: false, hidden: false, align: "left"},
        {name: "fechaCalibracion", width: 110, sortable: false, hidden: false, align: "center", formatter:"fmtFechaC"},
        {name: "fechaProximaCalibracion", width: 110, sortable: false, hidden: false, align: "center", formatter:"fmtFechaPC"},
        {name: "estado", width: 100, sortable: false, hidden: false, align: "center", formatter:"fmtEstadoEquipo"},
        {name: "opcion", width: 120, sortable: false, align: "center", formatter:"OpcionesEE"}
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarEquipoCertificado",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idAlcanceAcreditacion: $('#idAlcanceAcreditacion').val()
            //idAlcanceAcreditacion: "1"
        },
        hidegrid: false,
        rowNum: 2,
        pager: "#paginacionEquipo",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "EQUIPOS CERTIFICADOS",
        //autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idEquipoComponente"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            //estadoAux = rowData.estado;
            idAux = rowData.idEquipoCertificado;
            //alert("onCellSelect: " +idAux);
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Conteo de filas
    jQuery.extend($.fn.fmatter, {
    	NumeroFilasE: function(cellvalue, options, rowdata) {
          var n = $("#gridContenedorEquipo tr").index() + 1;
          return n;
        }
    });
    
  //Fecha Calibracion
    jQuery.extend($.fn.fmatter, {
    	fmtFechaC: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaCalibracion;
    		var d=new Date(dateVar);
    		
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
    		
    		var fecha = dia + '-' + mes + '-' + d.getFullYear()
    		return fecha;
    		 
        }
    });
    
  //Fecha Proxima Calibracion
    jQuery.extend($.fn.fmatter, {
    	fmtFechaPC: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaProximaCalibracion;
    		var d=new Date(dateVar);
    		
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
    		
    		var fecha = dia + '-' + mes + '-' + d.getFullYear()
    		return fecha;
    		 
        }
    });
    
  //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoEquipo: function(cellvalue, options, rowdata) {
            var sel = rowdata.estado;
            var tex ='';
            if(sel=='A'){
            	tex='ACTIVO';
            }else{
        		tex='INACTIVO';
            }
            return tex;
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesEE: function(cellvalue, options, rowdata) {
    		
    		if($('#RespuestaRegistrar').val()=="consulta"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    		
    		return "<a class='EditarEquipo' id='"+ rowdata.idEquipoCertificado  +"' style='cursor: pointer;text-decoration:none;' ><u> Editar </u></a>"+"\t"+
 	 	   "<a class='EliminarEquipo' id='"+ rowdata.idEquipoCertificado  +"' style='cursor: pointer;text-decoration:none;' ><u> Eliminar </u></a>";
    		}
        }
    });
}

//REGISTRAR DOCUMENTO ADJUNTO
function registrarDocumento(){
	
	var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
	//alert(data);

	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarDocumentoAdjunto",
        enctype: 'multipart/form-data',
       type:'post',
processData: false,
contentType: false, 
cache: false,
      data: data,
      beforeSend:muestraLoading,
      success:function(data){
          ocultaLoading();
          if(data.resultado=="0"){
          	 var idDoc = data.idDocumentoAdjunto;
          	 $('#txtAdjuntarArchivo').val(idDoc);
          	 listarDocumentoAdjuntoAA(0);
          	 if($('#txtAdjuntarAlcance').val()!=""){
          	 $("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:750px;');
          	 }
          	 bloquearItemsDocumentoAdjunto();
		 }
          
      },
      error:errorAjax
	});		
}

//REGISTRAR DOCUMENTO ALCANCE
function registrarDocumentoA(){
	
	var form1 = $('#fileUploadForm')[0];
    var data1 = new FormData(form1);
	//alert(data1);

	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarDocumentoAlcance",
        enctype: 'multipart/form-data',
       type:'post',
       processData: false,
       contentType: false, 
       cache: false,
      data: data1,
      beforeSend:muestraLoading,
      success:function(data){
          ocultaLoading();
          if(data.resultado=="0"){
           	 var idDocA = data.idDocumentoAdjunto;
           	 $('#txtAdjuntarAlcance').val(idDocA);
           	 listarDocumentoAlcanceAA(0);
           	 if($('#txtAdjuntarArchivo').val()!=""){
           	 $("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:750px;');
           	 }else{
       		 $("#gridContenedorDocAA1").attr('style','margin-left:750px;');
           	 }
           	 bloquearItemsAlcanceAdjunto();
 		 }
          
      },
      error:errorAjax
	});		
}

function modificarEstadoxEliminar(idDocumento){
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/modificarEstadoEliminarDocumento",
        type:'post',
        async:false,
        data:{
            idDocumentoAdjunto : idDocumento,
            estadoDocumento: "0"
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

//Listar Documento Adjunto Alcance Acreditacion
function listarDocumentoAdjuntoAA(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocAA").html("");
    
    var grid = $("<table>", {
        "id": "gridDocAA"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocAA"
    });
    
   $("#gridContenedorDocAA").append(grid).append(pager);


    var nombres = ['','DOCUMENTO','OPCION'];
    var columnas = [
    	{name: "idDocumentoAdjunto", width: 30, sortable: false, hidden: true, align: "center"},
        {name: "nombreDocumento", width: 168, sortable: false, hidden: false, align: "left"},
        {name: "opcion", width: 50, sortable: false, align: "center", formatter:"OpcionesDA"}
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarDocumentoAdjunto",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idDocumentoAdjunto: $('#txtAdjuntarArchivo').val()
        },
        hidegrid: false,
        rowNum: 1,
        //pager: "#paginacionDocAA",
        emptyrecords: "No se encontraron resultados",
        //recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        //caption: "DOCUMENTO ADJUNTO",
        //autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idDocumentoAdjunto"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesDA: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
    	
		if($('#RespuestaRegistrar').val()=="consulta" || $('#RespuestaRegistrar').val()=="REGISTRADO"){
			
			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
			
		}else{	
    		iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarDocumento' id='"+ rowdata.idDocumentoAdjunto +"'style=\"cursor: pointer;\" title=\"Eliminar\"/>"  
    		return iconbutton;
        }
    	}
    });
}

//Listar Documento Alcance Acreditacion
function listarDocumentoAlcanceAA(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocAA1").html("");
    
    var grid = $("<table>", {
        "id": "gridDocAA1"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocAA1"
    });
    
   $("#gridContenedorDocAA1").append(grid).append(pager);

    var nombres = ['','DOCUMENTO','OPCION'];
    var columnas = [
    	{name: "idDocumentoAdjunto", width: 30, sortable: false, hidden: true, align: "center"},
        {name: "nombreDocumento", width: 168, sortable: false, hidden: false, align: "left"},
        {name: "opcion", width: 50, sortable: false, align: "center", formatter:"OpcionesDAA"}
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarDocumentoAdjunto",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idDocumentoAdjunto: $('#txtAdjuntarAlcance').val()
        },
        hidegrid: false,
        rowNum: 1,
        //pager: "#paginacionDocAA1",
        emptyrecords: "No se encontraron resultados",
        //recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        //caption: "DOCUMENTO ADJUNTO",
        //autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idDocumentoAdjunto"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesDAA: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
    		
		if($('#RespuestaRegistrar').val()=="consulta" || $('#RespuestaRegistrar').val()=="REGISTRADO"){
			
			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
			
		}else{
    		iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarDocumentoA' id='"+ rowdata.idDocumentoAdjunto +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"
    		return iconbutton;
    	}
		
        }
    });
}
