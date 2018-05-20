//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------

var idEquipoCertificadoAux="";
var idCAux = "";

$(function() {
    initInicioNuevoEquipoCertificado();
    $("#MensajeFECHAC").hide();
	$("#txtFechaC").datepicker();
    $("#txtFechaPC").datepicker();
    $("#txtFechaC").attr( "readonly" , "readonly" );
    $("#txtFechaPC").attr( "readonly" , "readonly" );
    $("#cmbComponente").attr('disabled','disabled');
    $("#cmbEstado").attr('disabled','disabled');
    $("#btnAgregar").attr('disabled','disabled');
    $('#btnAgregar').attr('style','background-color:#60869a; width:100px;');
});

//----------Funciones de Validaciones----------

//validar ingreso de solo numeros
function validaNumericos(event) {
    if(event.charCode >= 48 && event.charCode <= 57){
      return true;
     }
     return false;        
}

//FOrmato de fecha
function formattedDate(fcali) {
	  d = new Date(fcali);
	  var dayf = d.getDate();
	  var monthf = d.getMonth() + 1;
	  var yearf = d.getFullYear();
	  
	  if(dayf<10) {dayf='0'+dayf}
	  if(monthf<10) {monthf='0'+monthf}
	  
	  var newFechCPC = dayf+'/'+monthf+'/'+yearf;

	  return newFechCPC;
	}

function convertDateFormat(string) {
	var info = string.split('/');
	return info[1] + '/' + info[0] + '/' + info[2];
}

//---------------------------------------------

function initInicioNuevoEquipoCertificado(){
	confirm.start();
	$('#MensajeValE').hide();
	cargarTipoEquipo();
	cargarComponente();
	
	$('#txtFechaC').change(function(){
		var fc = $('#txtFechaC').val();
		var fpc = $('#txtFechaPC').val();
		
		var vc = fc.split("/");
		var dc = vc[0];
		var mc = vc[1];
		var ac = vc[2];
		
		var vpc = fpc.split("/");
		var dpc = vpc[0];
		var mpc = vpc[1];
		var apc = vpc[2];
		
		if(fpc!=""){
			if(dc > dpc && mc >= mpc && ac >= apc){
			$("#MensajeFECHAC").show();
			$('#txtFechaC').val('');
			}
		}
	});
	
	$('#txtFechaC').click(function(){
		$("#MensajeFECHAC").hide();
		$('#MensajeValE').hide();
	});
	
	$('#txtFechaPC').change(function(){
		var fc1 = $('#txtFechaC').val();
		var fpc1 = $('#txtFechaPC').val();
		
		var vc1 = fc1.split("/");
		var dc1 = vc1[0];
		var mc1 = vc1[1];
		var ac1 = vc1[2];
		
		var vpc1 = fpc1.split("/");
		var dpc1 = vpc1[0];
		var mpc1 = vpc1[1];
		var apc1 = vpc1[2];
		
		if(dc1 > dpc1 && mc1 >= mpc1 && ac1 >= apc1){
			$("#MensajeFECHAC").show();
			$('#txtFechaPC').val('');
		}
		
	});
	
	$('#txtFechaPC').click(function(){
		$("#MensajeFECHAC").hide();
		$('#MensajeValE').hide();
	});
	
	$('#btnAgregar').click(function(){
		$('#MensajeValC').hide();
		$('#MensajeValE').hide();
		if ( $('#cmbComponente').val() !== "" && $('#cmbComponente').val() !== undefined ){
			confirm.open("¿Desea agregar el componente?", "registrarEquipoComponente()");
		}else{
			alert("Seleccione un componente");
		}
    });
	
	$("#cmbEstado").change(function(){
		var text = $("#cmbEstado option:selected").text();
		
		if(text=="INACTIVO"){
			abrirInactivarEquipoA();
		}
	});
	
	//----- ocultar mensaje----

	$('#cmbTipoEquipo').click(function(){
		$('#MensajeValE').hide();
	});
	$('#txtDescripcion').click(function(){
		$('#MensajeValE').hide();
	});
	$('#txtMarca').click(function(){
		$('#MensajeValE').hide();
	});
	$('#txtModelo').click(function(){
		$('#MensajeValE').hide();
	});
	$('#txtSerie').click(function(){
		$('#MensajeValE').hide();
	});
	//-------------------------------
	
	$('#btnGuardarEquipo').click(function(){
		if(validarDatosFormularioEquipo() == true){
			if($("#respuestaE").val()=="registrado"){
				$('#dialogEquipoCertificado').dialog('close');
                listarEquipo();
			}else{
				if (idEquipoCertificadoAux == "" || idEquipoCertificadoAux == undefined){
					confirm.open("¿Desea guardar el registro?", "registrarEquipoCertificado()");
				}else{ 
					if(idEquipoCertificadoAux !== "" && idEquipoCertificadoAux !== undefined){
					confirm.open("¿Desea actualizar el registro?", "registrarEquipoCertificado()");
					}
				}
			}
		}else{$('#MensajeValE').show();}
    });
	
	$('#btnRegresarEquipo').click(function(){
		$('#dialogEquipoCertificado').dialog('close');
    });
	
	$('body').on('click', '.EliminarComponente',function(){
        var id= $(this).attr("id");
        confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarComponente('" + id + "')");
    }); 
    
}

function IdAlcanceAEquipo(IAE=""){
	//Id Alcance Acreditacion
	$('#idAAEquipo').val(IAE);
	
	var tipP = $('#idpruebaHermeticidad').val();
    if (tipP == "1467"){
    	$('#MensajeValC').show();
    	$('#MensajeValC').html("GUARDE LO DATOS DEL EQUIPO PARA PODER AGREGAR UN COMPONENTE");
    }else{
    	$('#MensajeValC').hide();
    }
	
}

function validarDatosFormularioEquipo(){
	
	if($("#cmbTipoEquipo").val() == "" || $("#cmbTipoEquipo").val() == undefined){
		$('#MensajeValE').html("POR FAVOR SELECCIONE UN TIPO DE EQUIPO");
		return false;
	}
	if($("#txtDescripcion").val() =="" || $('#txtDescripcion').val() == undefined) {
		$('#MensajeValE').html("POR FAVOR COLOQUE LA DESCRIPCION DEL EQUIPO");
        return false;  
    }
	if($("#txtMarca").val() =="" || $('#txtMarca').val() == undefined) {
		$('#MensajeValE').html("POR FAVOR COLOQUE LA MARCA DEL EQUIPO");
        return false;  
    }
	if($("#txtModelo").val() =="" || $('#txtModelo').val() == undefined) {
		$('#MensajeValE').html("POR FAVOR COLOQUE EL MODELO DEL EQUIPO");
        return false;  
    }
	if($("#txtSerie").val() =="" || $('#txtSerie').val() == undefined) {
		$('#MensajeValE').html("POR FAVOR COLOQUE EL NRO. DE SERIE DEL EQUIPO");
        return false;  
    }
	if($("#txtFechaC").val() =="" || $('#txtFechaC').val() == undefined) {
		$('#MensajeValE').html("POR FAVOR COLOQUE LA FECHA DE CALIBRACION DEL EQUIPO");
        return false;  
    }
	if($("#txtFechaPC").val() =="" || $('#txtFechaPC').val() == undefined) {
		$('#MensajeValE').html("POR FAVOR COLOQUE LA PROXIMA FECHA DE CALIBRACION DEL EQUIPO");
        return false;  
    }
	return true;
}

function cargarEquipoCertificado() {
	
	idEquipoCertificadoAux =  $('#idEquipoCertificado').val();
	var pruebita = $('#idpruebaHermeticidad').val();
    if (idEquipoCertificadoAux !== null && idEquipoCertificadoAux !== undefined){
    
        $.ajax({
            url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarEquipoCertificado",
            type:'post',
            async:false,
            data:{
                idEquipoCertificado : $('#idEquipoCertificado').val()
            },
            beforeSend:muestraLoading,
            success:function(data){
                
                ocultaLoading();
                
                $.each(data.filas, function( index, value ) {
                	
                	var est = value.estado;
                	var newEstado = "";
                	
                	//alert(est);
                	
                	if(est == "A"){
                		newEstado = 0;
                	}else{
                		newEstado = 1;
                	}
                                        
                    //alert(value.otroDato);
                    $("#cmbTipoEquipo").val(value.idTipoEquipo);
                    $("#txtDescripcion").val(value.descripcionEquipo);
                    $("#txtMarca").val(value.marca);
                    $("#txtModelo").val(value.modelo);
                    $("#txtSerie").val(value.serie);
                    $("#txtOdatos").val(value.otroDato);
                    $('#txtFechaC').val(formattedDate(value.fechaCalibracion));
                    $('#txtFechaPC').val(formattedDate(value.fechaProximaCalibracion));
                    $("#cmbEstado").val(newEstado);
                    $("#motivo").val(value.idTipoMotivo);
                    $("#observa").val(value.observacion);
                });
                //var pruebita = $('#idpruebaHermeticidad').val();
                if (pruebita == "1467"){
                    $("#btnAgregar").removeAttr('disabled');
                    $("#btnAgregar").removeAttr('style');
                    $("#btnAgregar").attr('style','width:100px;');
                    $("#cmbComponente").removeAttr('disabled');
                    listarComponentes();
                }
                //listarPersonal();
                //$('#btnNuevo').show();
            },
            error:errorAjax
        });  
    }
}

function registrarEquipoCertificado(){
    var aux="";
    var idMotivoAux="";
    var obs="";
    var pruebita = $('#idpruebaHermeticidad').val();
   // alert("Motivo: " + $("#motivo").val() + "Observacion: " + $("#observa").val());
    
    if (idEquipoCertificadoAux == "" || idEquipoCertificadoAux == undefined){
        aux = "";
    }else if(idEquipoCertificadoAux !== "" && idEquipoCertificadoAux !== undefined){
        aux = idEquipoCertificadoAux;
    }
    
    if( $("#motivo").val() !== "" &&  $("#motivo").val() !== undefined ){
    	idMotivoAux = $("#motivo").val();
    }
    if ( $("#observa").val() !== "" &&  $("#observa").val() !== undefined ){
    	obs = $("#observa").val();
    }
    	
    if ( $("#cmbEstado").val() == 0){
    	idMotivoAux="";
        obs="";
    }
  //FORMATO PARA FECHAS
	var fechC = $('#txtFechaC').val();
	var fechPC = $('#txtFechaPC').val();
	
	var v1 = fechC.split("/");
	var d1 = v1[0];
	var m1 = v1[1];
	var a1 = v1[2];
	
	
	var v2 = fechPC.split("/");
	var d2 = v2[0];
	var m2 = v2[1];
	var a2 = v2[2];
	
	var newFechaC = d1 + "/" + m1 + "/" + a1;
	var newFechaPC = d2 + "/" + m2 + "/" + a2;
	
  	//-------------------------------------------
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarEquipoCertificado",
        type:'POST',
        async:false,
        data:{

        	id:                    aux,			  
        	idAlcanceAcreditacion: $("#idAAEquipo").val(),
        	idTipoEquipo:		   $("#cmbTipoEquipo").val(),
        	descripcion:		   $("#txtDescripcion").val().latinize().toUpperCase(),
        	marca:				   $("#txtMarca").val().latinize().toUpperCase(),
        	modelo:				   $("#txtModelo").val().latinize().toUpperCase(),
        	serie:				   $("#txtSerie").val().latinize().toUpperCase(),
        	otroDatoAdicional:	   $("#txtOdatos").val().latinize().toUpperCase(),
        	//fechaC:	   			   newFechaC,
        	//fechaPC:  			   newFechaPC,
        	fechaC:	   			   convertDateFormat($('#txtFechaC').val()),
        	fechaPC:  			   convertDateFormat($('#txtFechaPC').val()),
        	estado:				   $("#cmbEstado").val(),
        	idTipoMotivo:		   idMotivoAux,
        	observacion:		   obs
        	
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            //alert("resultado: " + data.resultado);
            if(data.resultado=="0"){ 
            	mensajeGrowl("success", global.confirm.save, "");
            	$("#respuestaE").val("registrado");
                idEquipoCertificadoAux = data.idEquipoCertificado;
                $("#idEquipoRegistrado").val(idEquipoCertificadoAux);
                //Bloquear Input
                $("#cmbTipoEquipo").attr('disabled','disabled');
                $("#txtDescripcion").attr('disabled','disabled');
                $("#txtMarca").attr('disabled','disabled');
                $("#txtModelo").attr('disabled','disabled');
                $("#txtSerie").attr('disabled','disabled');
                $("#txtOdatos").attr('disabled','disabled');
                $('#txtFechaC').attr('disabled','disabled');
                $('#txtFechaPC').attr('disabled','disabled');
                //Desbloquear Componente
                if (pruebita == "1467"){
                	$('#MensajeValC').show();
                	$('#MensajeValC').html("YA PUEDE AGREGAR UN COMPONENTE");
                    $("#btnAgregar").removeAttr('disabled');
                    $("#btnAgregar").removeAttr('style');
                    $("#btnAgregar").attr('style','width:100px;');
                    $("#cmbComponente").removeAttr('disabled');
                    //listarComponentes();
                }
                //---------------------
                //$('#dialogEquipoCertificado').dialog('close');
                //listarEquipo();
                
                 //$('#cmbComponente').prop('disabled', false);
                 //$('#btnAgregar').show();
                //listarComponentes(0);
                //-----------------------
                //$('#dialogEquipoCertificado').dialog('close');
            	//mensajeGrowl("success", global.confirm.save, "");
            }else
            	alert("NO PUDO SER REGISTRADO");
        },
        error:errorAjax
	});			
	
}

function registrarEquipoComponente(){
	
	var idEC;
	
	if($("#respuestaE").val()=="registrado"){
		idEC = $('#idEquipoRegistrado').val();
	}else{
		idEC = $('#idEquipoCertificado').val();
	}
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarEquipoComponente",
        type:'POST',
        async:false,
        data:{

            idEquipoCertificado: idEC,
            idComponenteTanque : $("#cmbComponente").val(),
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            //alert("resultado: " + data.resultado);
            if(data.resultado=="0"){  
            	//alert("COMPONENTE REGISTRADO");
                listarComponentes(0);       
            }else
            	alert("COMPONENTE NO REGISTRADO");
        },
        error:errorAjax
    });     
}

function eliminarComponente(idC){
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/eliminarComponente",
        type:'post',
        async:false,
        data:{
        	idComponente: idC
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	listarComponentes(0);
                //mensajeGrowl("success", global.confirm.delete, "");
                
            }else{
                //mensajeGrowl("error", data.mensaje, "");
            	//alert("NO PUDO SER ELIMINADO");

            }
        },
        error:errorAjax
    });
	
} 

function cargarTipoEquipo() {
	
	var encuentro = "TIPO_EQUIPO";

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
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbTipoEquipo');
	            
	        },
	        error:errorAjax
	    });
}

function cargarComponente() {
	
	var encuentro = "COMPONENTE_TANQUE";

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
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbComponente');
	            
	        },
	        error:errorAjax
	    });
}

//Listar Componentes
function listarComponentes(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorComponentes").html("");
    
    var grid = $("<table>", {
        "id": "gridComponentes"
    });
    
    var pager = $("<div>", {
        "id": "paginacionComponentes"
    });
    
    $("#gridContenedorComponentes").append(grid).append(pager);


    var nombres = ['N°', 'COMPONENTE DE USO EN TANQUE','OPCION'];
    var columnas = [
        {name: "idEquipoComponente", width: 30, sortable: false, hidden: false, align: "center"},
        {name: "componenteTanque", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "opcion", width: 100, sortable: false, hidden: false, align: "center", formatter:"OpcionEliminar"}
    ]; 
    
    var idEC2;
	
	if($("#respuestaE").val()=="registrado"){
		idEC2 = $('#idEquipoRegistrado').val();
	}else{
		idEC2 = $('#idEquipoCertificado').val();
	}
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarEquipoComponente",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idEquipoCertificado: idEC2
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionComponentes",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "COMPONENTES",
        autowidth: true,
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
            idCAux = rowData.idEquipoComponente;
            //alert("onCellSelect: " +idAux);
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionEliminar: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
           	//tex = "<a class='Eliminar' id='"+ rowdata.idAlcanceAcreditacion +"' src='images/cancel.png' style='cursor: pointer;text-decoration:none;' ></a>";
    		iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarComponente' id='"+ rowdata.idEquipoComponente +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"; 
            return iconbutton;
        }
    });
}

function abrirInactivarEquipoA(){  
	
	var title="INACTIVAR EQUIPO AUTORIZADO";
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirInactivarEquipoA", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogInactivarEquipoA").html(data);
            $("#dialogInactivarEquipoA").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "500",
                position: ['center', 'top+30'],
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        },
        error:errorAjax
    });
}

