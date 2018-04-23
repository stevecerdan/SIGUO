var busquedaFormatos = (function() {
	function constructor(){				
		
		gridBusquedaFormatos(0);
		$('#btnBuscar').click(function(){
			gridBusquedaFormatos();
			return false;
		});
		
		$('#btnNuevo').click(function(){
			nuevo();
			
			return false;
		});
				
		$('#btnLimpiar').click(function(){  
			$('#txtNumeroSolicitud').val('');
        	$('#txtFechaInicio').val('');
        	$('#txtFechaFin').val('');
        	$('#cmbEstadoSolicitud').val('');
        	gridBusquedaFormatos(0);
		});
		
		$('#btnSalir').click(function(){
			$(window).unload();
		});
								
		$('#txtFechaInicio').datepicker({
            changeMonth: true,
            changeYear: true,
            showOn: "focus",
            buttonImageOnly: true,
            showAnim: "fade",
            dateFormat: "dd/mm/yy"            
        });
		
		$('#txtFechaInicio').keydown(function(event) {
            var key = event.keyCode || event.charCode;
            if (key != 8 && key !== 46)
                return false;
        });
		
		$("#txtFechaInicio").change(function() {
            test = $(this).datepicker('getDate');
            testm = new Date(test.getTime());
            testm.setDate(testm.getDate());
            $("#txtFechaFin").datepicker("option", "minDate", testm);            
        });
		
		$('#txtFechaFin').datepicker({
            changeMonth: true,
            changeYear: true,
            showOn: "focus",
            buttonImageOnly: true,
            showAnim: "fade",
            dateFormat: "dd/mm/yy"            
        });
		
		$('#txtFechaFin').keydown(function(event) {
            var key = event.keyCode || event.charCode;
            if (key != 8 && key !== 46)
                return false;
        });
		
		$("#txtNumeroSolicitud").alphanum(numericDecimal);
		
	}
	
	function nuevo(){
		var url = baseURL + "pages/estadoCuenta";				
		document.location.href = url;
	}

	function gridBusquedaFormatos(varLista){
		if(varLista==undefined){varLista=1;}
		var bandeja = {
				numeroSolicitud: $('#txtNumeroSolicitud').val(),
				fechaInicio : $('#txtFechaInicio').val(),
				fechaFin : $('#txtFechaFin').val(),
            	estadoSolicitud: $('#cmbEstadoSolicitud').val()
        };
		$("#gridContenedorFormatos").html("");
        var grid = $("<table>", {"id": "gridFormatos"});
        var pager = $("<div>", {"id": "paginacionFormatos"});
        $("#gridContenedorFormatos").append(grid).append(pager);
        
        var nombres = ['ID','Nro Solicitud','Fecha de Solicitud','RUC','Raz&oacute;n Social','Estado de Solicitud','Nro Expediente',''];
        var columnas = [
            {name: "idRegistroSolicitud", sortable: false, align: "center", hidden: true},
            {name: "numeroSolicitud", width: 100, sortable: false, align: "center"},            
            {name: "fechaCreacion",width: 150, sortable: false, align: "center"},
            {name: "ruc",width: 130, sortable: false, align: "center"},
            {name: "razonSocial", width: 300, sortable: false, align: "center"},
            {name: "descEstadoSolicitud", width: 120, align: "center"},
            {name: "numeroExpediente", width: 120, align: "center"},
            {name: "idRegistroSolicitud", width: 70, sortable: false, align: "center",formatter: "descargarFileFormato"}           
        ];
        
        grid.jqGrid({
        	url: baseURL + "pages/busquedaFormatos/formatoBandeja?varLista="+varLista,
            datatype: "json", 
            postData:  bandeja,   	
            mtype: 'POST',
            hidegrid: false,
            rowNum: 5,
            pager: "#paginacionFormatos",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: "auto",
            width:"900px",
            viewrecords: true,
            caption: "Listado de Solicitudes",
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros",id:"idRegistroSolicitud"},
            onSelectRow: function(rowid, status) {
//                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
               
            },
            loadComplete: function(data) {

            },
            loadError: function(jqXHR) {
                errorAjax(jqXHR);
            }
            
        });
	}
	jQuery.extend($.fn.fmatter, {
		descargarFileFormato: function(cellvalue, options, rowdata) {           
            var idFormulario = rowdata.numeroSolicitud;
            var sel = '';   
            
            sel="<img src=\""+baseURL+"/../images/pdf16x16.png\" onclick=\"busquedaFormatos.abrirFormatoReporte('"+idFormulario+"')\" style=\"cursor: pointer;\" alt=\"Ver Solicitud\"/>";
            return sel;
        }
    });
	
	function abrirFormatoReporte(idFormulario){
		var url = baseURL +"/pages/busquedaFormatos/abrirFormatoReporte";
    	$.post(url, {idFormulario:idFormulario}, function(data) {
            if (data.ruta != "") {            	
            	llamarImprimir(data.ruta, data.identificador);
            }
        });
	}
	
	function llamarImprimir(ruta,id){
		var cadena = "identificador="+id;
		$.download(ruta, cadena, "POST");
	}
	
	return{
		constructor:constructor,
		abrirFormatoReporte:abrirFormatoReporte		
	};
})();

$(function() {
	busquedaFormatos.constructor();
});