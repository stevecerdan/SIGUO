//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------
$(function() {
	listarProcesosAcreditacion(0)
    initInicioNuevaEmpresaAcreditada();  
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
	
   /* $('#btnNuevo').click(function(){
    	abrirNuevoPersonal();
    });*/
	
	$('#btnValidar').click(function(){
		cargarDatos();
		listarProcesosAcreditacion();
	});
	
	$('#btnGuardar').click(function(){
		confirm.open("¿Desea guardar el registro?");
    });
	
	$('#btnRegresar').click(function(){
		$('#dialogNuevaEmpresaAcreditada').dialog('close');
    });
    
}

/*function abrirNuevoPersonal(){ 
	
	var title="NUEVO PERSONAL";
    $.ajax({
        url:baseURL + "pages/mantenimientoOrganismosAcreditadores/abrirNuevoPersonal", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogNuevoPersonal").html(data);
            $("#dialogNuevoPersonal").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "650",
                position: ['center', 'top+30'],
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        },
        error:errorAjax
    });
}*/

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


    var nombres = ['N°', 'TIPO DE PRUEBA', 'RESOLUCI&Oacute;N','REGISTRO','FECHA DE ULTIMA ACTUALIZACI&Oacute;N','FECHA DE ACREDITACI&Oacute;N','FECHA DE VENCIMIENTO','ESTADO','OPCION'];
    var columnas = [
        {name: "idAlcanceAcreditacion", width: 20, sortable: false, hidden: false, align: "center"},
        {name: "tipoPrueba", width: 140, sortable: false, hidden: false, align: "center"},
        {name: "resolucionCedula", width: 125, sortable: false, hidden: false, align: "center"},
        {name: "registro", width: 70, sortable: false, hidden: false, align: "center"},
        {name: "fechaUActualizacion", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "fechaAcreditacion", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "fechaVencimiento", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "estadoAlcance", width: 65, sortable: false, hidden: false, align: "center", formatter: "fmtEstadoNewEmpAcred"},
        {name: "opcion", width: 200, sortable: false, hidden: false, align: "center", formatter:"Opciones"}
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarEmpresasAcreditadas",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            ruc: $("#txtRUC").val()
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionProcesos",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Procesos de Acreditación",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idAlcanceAcreditacion"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoNewEmpAcred: function(cellvalue, options, rowdata) {
            var sel = rowdata.estadoAlcance;
            var tex ='';
            if(sel=='A'){
            	tex='ACTIVO';
            }else{
            	if(sel=='I'){
            		tex='INACTIVO';
            	}else{
            		if(sel=='E'){
            			tex='ELIMINADO';
            		}
            	}
            }
            return tex;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	Opciones: function(cellvalue, options, rowdata) {
    		
            return "<a href='#" + cellvalue +"'><u>  Consultar  </u></a>"+"  "+
        		   "<a href='#' ><u>  Suspender  </u></a>"+"  "+
        		   "<a href='#' ><u>  Cancelar  </u></a>";
        }
    });
	
}

function cargarDatos() {
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
	            	  //alert(value.razonSocial );
	            	  $("#txtRazonSocial").val(value.razonSocial);
	            	  $("#cmbDepartamento").append('<option value ="" selected="selected">' + value.departamento + '</option>');
	            	  $("#cmbProvincia").append('<option value ="" selected="selected">' + value.provincia + '</option>');
	            	  $("#cmbDistrito").append('<option value ="" selected="selected">' + value.distrito + '</option>');
	            	  $("#txtDireccion").val(value.direccion);
	            	  $("#txtTelefono").val(value.telefono);
	            	  $("#txtEmail").val(value.email);
	            	  $("#txtWeb").val(value.web);
	            });
	            
	            //2° modo de For
	            /*for(var i in data.filas) {
	               alert(data.filas[i].razonSocial);  // (o el campo que necesites)
	            }*/
	            
	            //Carga Combos
	            //fill.combo(data.filas,'idActividad','nombre','#cmbSubSector');
	            
	        },
	        error:errorAjax
	    });
	}
}
