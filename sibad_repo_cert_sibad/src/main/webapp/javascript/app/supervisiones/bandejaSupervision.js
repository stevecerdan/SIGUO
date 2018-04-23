var bandejaSupervision = (function() {
	function constructor(){				
		
		buscarSupervisiones(1);
		$('#btnBuscar').click(function(){
			buscarSupervisiones();
			return false;
		});
				
		$('#btnLimpiar').click(function(){  
			$('#txtCodigoOsinergmin').val('');
			$('#txtRegistroHidrocarburos').val('');
        	$('#txtPeriodoSupervision').val('');
        	$('#txtNumeroExpediente').val('');
        	$('#txtNumeroOrdenServicio').val('');
        	buscarSupervisiones(0);
		});
		
		$('#btnSalir').click(function(){
			$(window).unload();
		});
								
		$('#txtPeriodoSupervision').datepicker({
            changeMonth: true,
            changeYear: true,
            showOn: "focus",
            buttonImageOnly: true,
            showAnim: "fade",
            showButtonPanel: true,
            dateFormat: 'mm/yy',
            onClose: function(dateText, inst) { 
                $(this).datepicker('setDate', new Date(inst.selectedYear, inst.selectedMonth, 1));
            }
        });
		
		$('#txtPeriodoSupervision').keydown(function(event) {
            var key = event.keyCode || event.charCode;
            if (key != 8 && key !== 46)
                return false;
        });
		
		$("#txtCodigoOsinergmin").alphanum(numericDecimal);
		$("#txtNumeroExpediente").alphanum(numericDecimal);
	}

	function buscarSupervisiones(varLista){
		if(varLista == undefined){
			varLista=1;
		}
		var filtro = {
				codigoOsinergmin: $('#txtCodigoOsinergmin').val(),
				registroHidrocarburos: $('#txtRegistroHidrocarburos').val(),
				periodoSupervision : $('#txtPeriodoSupervision').val(),
				numeroExpediente: $('#txtNumeroExpediente').val(),
				numeroOrdenServicio: $('#txtNumeroOrdenServicio').val()
        };
		$("#gridContenedorSupervisiones").html("");
        var grid = $("<table>", {"id": "gridSupervisiones"});
        var pager = $("<div>", {"id": "paginacionSupervisiones"});
        $("#gridContenedorSupervisiones").append(grid).append(pager);
        
        var nombres = ['C&oacute;digo Osinergmin', 'Nro. Expediente', 'Nro. Orden de Servicio', 'Fecha de Supervisi&oacute;n', 'Actividad', 'Tipo de Supervisi&oacute;n', 'Resultado', 'Medida de Seguridad',
                       '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''];
        var columnas = [
            {name: "codigoOsinergmin", width: 70, sortable: false, align: "center"},
            {name: "nroExpediente", width: 90, sortable: false, align: "center"},            
            {name: "nroOrdenServicio", width: 150, sortable: false, align: "center"},
            {name: "rangoFechaSupervision", width: 140, sortable: false, align: "center", formatter: "rangoFechaSupervisionFormatter"},
            {name: "datosActividad", width: 250, sortable: false, align: "left", formatter: "datosActividadFormatter"},
            {name: "tipoSupervision", width: 180, sortable: false, align: "center"},
            {name: "datosResultado", width: 120, sortable: false, align: "center", formatter: "datosResultadoFormatter"},
            {name: "datosMedidaSeguridad", width: 200, sortable: false, align: "left", formatter: "datosMedidaSeguridadFormatter"},
            {name: "detalleSupervision", width: 40, sortable: false, align: "center", formatter: "verDetalleSupervisionFormatter"},
            {name: "rho", hidden: true},
            {name: "codigoActividad", hidden: true},
            {name: "nombreActividad", hidden: true},
            {name: "fechaInicioSupervisionString", hidden: true, formatter: "fechaInicioSupervisionStringFormatter"},
            {name: "fechaFinSupervisionString", hidden: true, formatter: "fechaFinSupervisionStringFormatter"},
            {name: "codigoResultado", hidden: true},
            {name: "resultado", hidden: true},
            {name: "codigoMedidaSeguridadEjecutada", hidden: true},
            {name: "nombreMedidaSeguridadEjecutada", hidden: true},
            {name: "productosScopSuspendidos", hidden: true},
            {name: "nombreEmpresaSupervisora", hidden: true},
            {name: "nombreSupervisor", hidden: true},
            {name: "nombreEspecialistaOsinergmin", hidden: true},
            {name: "nombreUnidadOrganicaOsinergmin", hidden: true},
            {name: "fechaLimiteMedidaSeguridadEjecutadaCadena", hidden: true}
        ];
        
        grid.jqGrid({
        	url: baseURL + "pages/bandejaSupervision/findNpsListado?varLista="+varLista,
            datatype: "json", 
            postData:  filtro,   	
            mtype: 'POST',
            hidegrid: false,
            rowNum: 20,
            pager: "#paginacionSupervisiones",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            rownumbers: true,
            rownumWidth: 40,
            height: "auto",
            width:"900px",
            viewrecords: true,
            caption: "Listado de Supervisiones",
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros", id: "idSupervision"},
            loadError: function(jqXHR) {
                errorAjax(jqXHR);
            }
        });
        
        grid.jqGrid('setLabel', 'rn', '&Iacute;tem');
	}
	
	jQuery.extend($.fn.fmatter, {
		rangoFechaSupervisionFormatter: function(cellvalue, options, rowdata) {
			var texto = fechaHoraFormateador(rowdata.fechaInicioSupervision) + ' - ' + fechaHoraFormateador(rowdata.fechaFinSupervision);
            return texto;
        },
        datosActividadFormatter: function(cellvalue, options, rowdata) {
            var texto = rowdata.codigoActividad + ' - ' + rowdata.nombreActividad
        	return texto;
        },
        datosResultadoFormatter: function(cellvalue, options, rowdata) {
            var texto = rowdata.resultado;
            if(texto == 'Con Incumplimientos'){
            	texto = '<span class="con-obs">' + texto + '</span>';
            }else{
            	texto = '<span class="sin-obs">' + texto + '</span>';
            }
        	return texto;
        },
        verDetalleSupervisionFormatter: function(cellvalue, options, rowdata) {
            var link = "<img src=\"" + baseURL + "/../images/search2.png\" onclick=\"bandejaSupervision.abrirDetalleSupervision('" + rowdata.idSupervision + "')\" style=\"cursor: pointer;\" title=\"Ver detalle\"/>";
            return link;
        },
        fechaInicioSupervisionStringFormatter: function(cellvalue, options, rowdata) {
			var texto = fechaHoraFormateador(rowdata.fechaInicioSupervision);
            return texto;
        },
        fechaFinSupervisionStringFormatter: function(cellvalue, options, rowdata) {
			var texto = fechaHoraFormateador(rowdata.fechaFinSupervision);
            return texto;
        },
        datosMedidaSeguridadFormatter: function(cellvalue, options, rowdata) {
            var texto = rowdata.resultado;
            var nombreMedidaSeguridadEjecutada = rowdata.nombreMedidaSeguridadEjecutada;
            var productosScopSuspendidos = rowdata.productosScopSuspendidos;
            var descripcionGenerica = 'Suspensi&oacute;n de compras de: ';
            if(texto == 'Con Incumplimientos'){
            	if (nombreMedidaSeguridadEjecutada != null && nombreMedidaSeguridadEjecutada != ''){
            		texto = nombreMedidaSeguridadEjecutada + '<br/>';
            	}else{
            		texto = "";
            	}
            	if (productosScopSuspendidos!=null && productosScopSuspendidos != ''){
            		texto += '<span class="con-med-seg">' + descripcionGenerica + '</span>' + productosScopSuspendidos;
            	}
            }else{
            	texto = '';
            }
        	return texto;
        }
    });
	
	function abrirDetalleSupervision(idSupervision){
		var rowdata = $('#gridSupervisiones').jqGrid('getRowData', idSupervision);
		var cabecera = {
				idSupervision: idSupervision,
				codigoOsinergmin: rowdata.codigoOsinergmin,
				rho: rowdata.rho,
				nroExpediente: rowdata.nroExpediente,
				nroOrdenServicio: rowdata.nroOrdenServicio,
				codigoActividad: rowdata.codigoActividad,
				nombreActividad: rowdata.nombreActividad,
				fechaInicioSupervisionString: rowdata.fechaInicioSupervisionString,
				fechaFinSupervisionString: rowdata.fechaFinSupervisionString,
				tipoSupervision: rowdata.tipoSupervision,
				codigoResultado: rowdata.codigoResultado,
				resultado: rowdata.resultado,
				codigoMedidaSeguridadEjecutada: rowdata.codigoMedidaSeguridadEjecutada,
				nombreMedidaSeguridadEjecutada: rowdata.nombreMedidaSeguridadEjecutada,
				productosScopSuspendidos: rowdata.productosScopSuspendidos,
				nombreEmpresaSupervisora: rowdata.nombreEmpresaSupervisora,
				nombreSupervisor: rowdata.nombreSupervisor,
				nombreEspecialistaOsinergmin: rowdata.nombreEspecialistaOsinergmin,
				nombreUnidadOrganicaOsinergmin: rowdata.nombreUnidadOrganicaOsinergmin,
				fechaLimiteMedidaSeguridadEjecutadaString: rowdata.fechaLimiteMedidaSeguridadEjecutadaCadena
		};
		muestraLoading();
		$.redirect(baseURL + "/pages/bandejaSupervision/openNpsDetalle", cabecera);
	}
	
	return{
		constructor: constructor,
		abrirDetalleSupervision: abrirDetalleSupervision
	};
})();

$(function() {
	bandejaSupervision.constructor();
	$("#divDirectorio").show();
});
