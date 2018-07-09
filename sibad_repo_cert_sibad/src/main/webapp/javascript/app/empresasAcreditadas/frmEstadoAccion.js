var estadito;
$(function() {
    anularEnter();
    //listarDocumentoAdjuntoE();
    $('#btnCancelarEstado').click(btnCancelarEstado)
    $('#btnGuardarEstado').click(btnGuardarEstado);
    boton.closeDialog();
       
});

$('#uploadfileC').change(function() {
	$('#MensajeValEstado').hide();
    var filename = $('#uploadfileC')[0].files[0]
    $('#nombreArchivoC').text(filename.name);
    if($('#nombreArchivoC').text()!=="Subir Archivo, Click Aquí"){
	    registrarDocumentoEstado();
    }
});

$('body').on('click', '.EliminarArchivoE',function(){
	
	var id= $(this).attr("id");
	//alert("eliminar: " + id);
    //confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarPersonalAutorizado('" + id + "')");
    //eliminarPersonalAutorizado('id');
	editarEstadoxEliminarDocE(id);
	$('#txtCedula').val("");
	desbloquearItemsDocumentoEstado();
	$("#gridContenedorDocAE").html("");
});

function btnCancelarEstado(){
	$('#dialogFrmEstadoAccion').dialog('close');
};

function btnGuardarEstado(){
	if(validarDatosFormularioEstadoC() == true){
	confirm.open("¿Confirma el cambio de estado del registro?","registrarEstado()");
	}else{
	 $("#MensajeValEstado").show();
	}
}

$('#cmbMotivo').click(function(){
	$('#MensajeValEstado').hide();	
});

$('#txtObservacion').click(function(){
	$('#MensajeValEstado').hide();	
});

$('#txtCedula').change(function(){
	$('#MensajeValEstado').hide();	
});

function validarDatosFormularioEstadoC(){
	
	if($("#cmbMotivo").val() == "" || $("#cmbMotivo").val() == undefined){
		$('#MensajeValEstado').html("POR FAVOR SELECCIONE UN MOTIVO");
		return false;
	}
	
	if($("#txtObservacion").val() =="" || $('#txtObservacion').val() == undefined) {
		$('#MensajeValEstado').html("POR FAVOR COLOQUE UNA OBSERVACION");
        return false;  
    } 

	if($("#txtCedula").val() =="" || $('#txtCedula').val() == undefined) {
		$('#MensajeValEstado').html("POR FAVOR ADJUNTAR LA CEDULA SOLICITADA");
        return false;  
    } 
	return true;
}

function bloquearItemsDocumentoEstado(){
	$('#uploadfileC').attr('disabled','disabled');
 	$('#nombreArchivoC').attr('disabled','disabled');
 	$('#nombreArchivoC').attr('style','font:normal 12px "Calibri"; cursor:not-allowed; background-color:#EBEBE4;');
 	$('#btnSubirArchivo').attr('disabled','disabled');
 	$('#btnSubirArchivo').attr('style','margin-left:176px; width:50px;background-color:#60869a;');
}

function desbloquearItemsDocumentoEstado(){
	$('#uploadfileC').removeAttr('disabled');
 	$('#nombreArchivoC').removeAttr('disabled');
 	$('#nombreArchivoC').removeAttr('style');
 	$('#nombreArchivoC').attr('style','font:normal 12px "Calibri";');
 	//$('#nombreArchivoC').text("Subir Archivo, Click Aquí");
 	$('#btnSubirArchivo').removeAttr('disabled');
 	$('#btnSubirArchivo').attr('style','margin-left:176px; width:50px;');
}

function cargarMotivo(letraTraida="") {
	
	var encuentro ="";
	
	if(letraTraida=="S"){
		encuentro = "MOTIVO_SUSPENDER";
	}
	
	if(letraTraida=="H"){
		encuentro = "MOTIVO_HABILITAR";
	}
	
	if(letraTraida=="C"){
		encuentro = "MOTIVO_CANCELAR";
	}
	
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
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbMotivo');
	            
	        },
	        error:errorAjax
	    });
}

function registrarEstado(){
	
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarEstado",
        type:'post',
        async:false,
        data:{
        	
        	idEmpresaAcreditada : $('#idEmpresaAcreditada').val(),
        	estadoEmpresaAcreditada: $('#estadoEmpAcred').val(),
        	idAlcanceAcreditacion: $('#idAlcanceAcreditacion').val(),
        	estado: $('#estado').val(),
        	estadoAccion : $('#letraEstado').val(),
        	idDocumentoAdjunto : $('#txtCedula').val(),
        	idTipoMotivo : $('#cmbMotivo').val(),
        	observacion : $('#txtObservacion').val().latinize().toUpperCase()
        	
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                $('#dialogFrmEstadoAccion').dialog('close');
                //listarProcesosAcreditacion();
                cargarDatos();
              
            }
        },
        error:errorAjax
	});		
	
}

//REGISTRAR DOCUMENTO ADJUNTO
function registrarDocumentoEstado(){
	
	var form = $('#fileUploadForm1')[0];
    var data = new FormData(form);
	//alert(data);

	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarDocumentoEstado",
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
          	 var idDocC = data.idDocumentoAdjunto;
          	 $('#txtCedula').val(idDocC);
          	 listarDocumentoAdjuntoE(0);
          	 bloquearItemsDocumentoEstado();
		 }
          
      },
      error:errorAjax
	});		
}

function editarEstadoxEliminarDocE(idDocE){
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/modificarEstadoEliminarDocumento",
        type:'post',
        async:false,
        data:{
            idDocumentoAdjunto : idDocE,
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

//Listar Documento Adjunto Estados
function listarDocumentoAdjuntoE(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocAE").html("");
    
    var grid = $("<table>", {
        "id": "gridDocAE"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocAE"
    });
    
   $("#gridContenedorDocAE").append(grid).append(pager);


    var nombres = ['','DOCUMENTO','OPCION'];
    var columnas = [
    	{name: "idDocumentoAdjunto", width: 30, sortable: false, hidden: true, align: "center"},
        {name: "nombreDocumento", width: 168, sortable: false, hidden: false, align: "left"},
        {name: "opcion", width: 50, sortable: false, align: "center", formatter:"OpcionesDAE"}
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarDocumentoAdjunto",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idDocumentoAdjunto: $('#txtCedula').val()
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
    	OpcionesDAE: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
    		iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarArchivoE' id='"+ rowdata.idDocumentoAdjunto +"'style=\"cursor: pointer;\" title=\"Eliminar\"/>"  
    		return iconbutton;
    	}
    });
}