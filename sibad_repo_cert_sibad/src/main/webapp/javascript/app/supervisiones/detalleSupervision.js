var esSupervisionDshl = '';
var tipoDocumentoAdjunto = {
		documentoSupervision: '1',
		medioProbatorio: '2'
}

var detalleSupervision = (function() {
	function constructor(){
		//para saber si se trata de una supervisión de DSHL o de DSR
		esSupervisionDshl = $('#esSupervisionDshl').val();
		//para ver si la carga inicial ha sido exitosa
		var resultado = $('#resultado').val();
		if(resultado == '1'){
            mensajeGrowl('error', $('#mensaje').val());
        }else if(resultado == '0'){
        	var mostrarGrilla = $('#mostrarGrilla').val();
        	if(esSupervisionDshl == '1'){
        		$('#datosCabeceraDshl').show();
        		
        		//TEMPORAL
        		$('#gridContenedorInfracciones').show();
    			$('#detalleSupervisionSinDatos-div').hide();
    			buscarInfracciones(1);
    			
        		//TEMPORAL
    			/*
        		if(mostrarGrilla == '1'){
        			$('#gridContenedorInfracciones').show();
        			$('#detalleSupervisionSinDatos-div').hide();
        			buscarInfracciones(1);
    			}else{
    				$('#gridContenedorInfracciones').hide();
    				$('#detalleSupervisionSinDatos-div').show();
    				$('#detalleSupervisionSinDatos').html($('#mensajeNoResultado').val());
    			}
    			*/
        	}else if(esSupervisionDshl == '0'){
        		$('#datosCabeceraDshl').hide();
        		if($('#nombreResultado').val() == 'Sin Incumplimientos'){
        			$('#gridContenedorInfracciones').hide();
        			$('#detalleSupervisionSinDatos-div').show();
        		}else{
        			if(mostrarGrilla == '1'){
            			$('#gridContenedorInfracciones').show();
            			buscarInfracciones(1);
            		}else{
            			$('#gridContenedorInfracciones').hide();
            		}
        			$('#detalleSupervisionSinDatos-div').hide();
        		}
        	}
        }
		
		$('#btnVerDocumentosSupervision').click(function(){        	   
			detalleSupervision.buscarDocumentosAdjuntos(tipoDocumentoAdjunto.documentoSupervision, '1');
        });
		
		$('#btnSalir').click(function(){        	   
        	formSubmit('formDetalleSupervision', '/sibad/pages/bandejaSupervision');
        });
		
		$('#btnSalirDialogDocumentosAdjuntos').click(function(){        	   
			$('#dialogDocumentosAdjuntos').dialog('close');
        });
		
		//dialog de documentos adjuntos
		$("#dialogDocumentosAdjuntos").dialog({
            resizable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            dialogClass: 'dialog',
            modal: true,
            open: function(){                
            	var tipo = $(this).data('tipo');
            	var title = 'DOCUMENTOS ADJUNTOS';
            	if(tipo == tipoDocumentoAdjunto.documentoSupervision){
            		title = 'DOCUMENTOS DE LA SUPERVISIÓN';
            		$('#btnDescargaMultiple').click(detalleSupervision.descargaMultipleZipDocumentosSupervision);
            	}else if(tipo == tipoDocumentoAdjunto.medioProbatorio){
            		title = 'DOCUMENTOS ADJUNTOS';
            		$('#btnDescargaMultiple').click(detalleSupervision.descargaMultipleZipDocumentosAdjuntosDetalleSupervision);
            	}
            	$(this).dialog('option', 'title', title);
            },
            close: function(){
            	$('#datosCabeceraDocumentosSupervisionDsr').hide();
            	$('#descripcionDocumentosSupervisionDsr').html('');
            	$('#btnDescargaMultiple').off('click');
            }
        });        
	}

	function buscarInfracciones(varLista){
		if(varLista == undefined){
			varLista=1;
		}
		var urlInfracciones = '';
		var filtro = {};
		var nombres = [];
        var columnas = [];
		if(esSupervisionDshl == '1'){
			urlInfracciones = 'pages/bandejaSupervision/filasDetalleDshl';
			filtro = {
					idSupervision: $('#idSupervision').val()
	        };
			nombres = ['Base Legal', 'Descripci&oacute;n', 'Documentos adjuntos', ''];
	        columnas = [
	            {name: "baseLegal", width: 400, sortable: false, align: "left"},            
	            {name: "incumplimiento", width: 400, sortable: false, align: "left"},
	            {name: "documentosAdjuntos", width: 70, sortable: false, align: "center", formatter: "documentosAdjuntosFormatter"},
	            {name: "tieneMediosProbatorios", hidden: true}
	        ];
		}else if(esSupervisionDshl == '0'){
			urlInfracciones = 'pages/bandejaSupervision/filasDetalleDsr';
			filtro = {
					idSupervision: $('#idSupervision').val(),
					codigoResultado : 2
	        };
			nombres = ['Infracci&oacute;n', 'Descripci&oacute;n de la condici&oacute;n verificada', 'Documentos adjuntos', ''];
	        columnas = [
	            {name: "infraccion", width: 400, sortable: false, align: "left"},
	            {name: "condicionVerificada", width: 700, sortable: false, align: "left", formatter: "descripcionCondicionVerificadaFormatter"},
	            {name: "documentosAdjuntos", width: 70, sortable: false, align: "center", formatter: "documentosAdjuntosFormatter"},
	            {name: "tieneMediosProbatorios", hidden: true}
	        ];
		}
		
		$("#gridContenedorInfracciones").html("");
        var grid = $("<table>", {"id": "gridInfracciones"});
        var pager = $("<div>", {"id": "paginacionInfracciones"});
        $("#gridContenedorInfracciones").append(grid).append(pager);
        
        grid.jqGrid({
        	url: baseURL + urlInfracciones + "?varLista="+varLista,
            datatype: "json", 
            postData:  filtro,   	
            mtype: 'POST',
            hidegrid: false,
            rowNum: 20,
            pager: "#paginacionInfracciones",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            rownumbers: true,
            rownumWidth: 40,
            height: "auto",
            width: "900px",
            viewrecords: true,
            caption: "Listado de Incumplimientos",
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros", id: "idDetalleSupervision"},
            loadError: function(jqXHR) {
                errorAjax(jqXHR);
            },
            loadComplete: function(data) {
            	if(data.filas.length > 0){
            		var contador = '<div class="tal redText"><br />&nbsp;Cantidad de Incumplimientos: <label>' + data.filas.length + '</label><br /><br /></div>';
                    $('#gbox_gridInfracciones').append(contador);
            	}
            }
        });
        
        grid.jqGrid('setLabel', 'rn', '&Iacute;tem');
	}
	
	function buscarDocumentosAdjuntos(tipo, varLista, idDetalleSupervision){
		muestraLoading();
		if(varLista == undefined){
			varLista=1;
		}
		var urlDocumentosAdjuntos = '';
		var filtro = {};
		var descargaDocumentoFormatter = '';
		if(tipo == tipoDocumentoAdjunto.documentoSupervision){
			urlDocumentosAdjuntos = 'pages/bandejaSupervision/viewDocumentosSupervision';
			filtro = {
					idSupervision: $('#idSupervision').val(),
					numeroExpediente: $('#numeroExpediente').val()
	        };
			descargaDocumentoFormatter = 'descargaDocumentoFormatter';
		}else if(tipo == tipoDocumentoAdjunto.medioProbatorio){
			urlDocumentosAdjuntos = 'pages/bandejaSupervision/viewDocumentosAdjuntosDetalleSupervision';
			filtro = {
					idDetalleSupervision: idDetalleSupervision
	        };
			descargaDocumentoFormatter = 'descargaDocumentoMedioProbatorioFormatter';
		}
		var nombres = ['Tipo de Documento', 'Descripci&oacute;n', 'Descarga', 
		               '<input type="checkbox" id="descargaArchivo-chk-header" onclick="detalleSupervision.clickCheckboxHeaderDescargaArchivo(this);" /><label for="descargaArchivo-chk-header" class="checkbox"></label>'];
		var columnas = [
		                {name: "tipoDocumento", width: 300, sortable: false, align: "left"},            
		                {name: "descripcion", width: 300, sortable: false, align: "left"},
		                {name: "descargaDocumento", width: 50, sortable: false, align: "center", formatter: descargaDocumentoFormatter},
		                {name: 'idArchivo', width: 21, sortable: false, align: 'center', formatter: "chkDescargaArchivoFormatter"}
		                ];
		
		$("#gridContenedorDocumentosAdjuntos").html("");
        var grid = $("<table>", {"id": "gridDocumentosAdjuntos"});
        var pager = $("<div>", {"id": "paginacionDocumentosAdjuntos"});
        $("#gridContenedorDocumentosAdjuntos").append(grid).append(pager);
        
        grid.jqGrid({
        	url: baseURL + urlDocumentosAdjuntos + "?varLista="+varLista,
            datatype: "json", 
            postData:  filtro,   	
            mtype: 'POST',
            hidegrid: false,
            rowNum: -1,
            pager: "#paginacionDocumentosAdjuntos",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            rownumbers: true,
            rownumWidth: 40,
            height: "auto",
            width: "900px",
            viewrecords: true,
            pgbuttons: false,
            pgtext: false,
            recordtext: "",
            caption: "Listado de Documentos",
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros"},
            loadError: function(jqXHR) {
            	ocultaLoading();
                errorAjax(jqXHR);
            },
            loadComplete: function(data) {
            	//para colocar descripción de los documentos de supervisión (sólo para DSR)
            	if(tipo == tipoDocumentoAdjunto.documentoSupervision && esSupervisionDshl == '0'){
            		if(data.filas.length > 0){
            			$('#datosCabeceraDocumentosSupervisionDsr').show();
            			$('#descripcionDocumentosSupervisionDsr').html(data.filas[0].descripcion);
            			$(this).jqGrid('hideCol', 'descripcion');
            		}
            	}
            	//para mostrar el dialog contenedor
            	ocultaLoading();
            	$('#dialogDocumentosAdjuntos').data('tipo', tipo).dialog('open');
            }
        });
        
        grid.jqGrid('setLabel', 'rn', '&Iacute;tem');
        $('#descargaArchivo-chk-header').parent().removeClass('ui-jqgrid-sortable');
        $('.descargaArchivo-chk').parent().removeClass('ui-jqgrid-sortable');
	}
	
	function clickCheckboxHeaderDescargaArchivo(chkHeader){
    	var checked = false;
    	if($(chkHeader).is(':checked')){
    		checked = true;
    	}
    	$.each($('.descargaArchivo-check'), function(idx, chk) {
    		$(chk).prop('checked', checked);
    	});
    }
    
    function clickCheckboxDescargaArchivo(chkElement){
    	var chkHeader = $('#descargaArchivo-chk-header');
    	if($(chkElement).is(':checked')){
    		var todosChecked = true;
    		$.each($('.descargaArchivo-check:not(:checked)'), function(idx, chk) {
    			todosChecked = false;
    			return false;
        	});
    		if(todosChecked){
    			chkHeader.prop('checked', true);
    		}
    	}else{
    		chkHeader.prop('checked', false);
    	}
    }
    
    function descargaMultipleZipDocumentosSupervision(){
    	var idsArchivos = "";
    	var appender = null;
		var countSelected = $(".archivoInps:checked").length;
		var idArchivo = null;
		var archivo = null;
		//para los archivos del INPS
		$(".archivoInps:checked").each(function(index, item){
			appender = "";
			if(index < countSelected - 1){
				appender = "&";
			}
			idArchivo = $(item).attr('id').replace('descargaArchivoInps-check-', '');
			archivo = $('#descargaArchivoInps-a-' + idArchivo);
			idsArchivos += "idArchivo[" + index + "]=" + archivo.attr("idArchivo") + appender;
		});
		//para los archivos del SIGED
		countSelected = $(".archivoSiged:checked").length;
		$(".archivoSiged:checked").each(function(index, item){
			if(index == 0 && idsArchivos != ""){
				idsArchivos += "&";
			}
			appender = "";
			if(index < countSelected - 1){
				appender = "&";
			}
			idArchivo = $(item).attr('id').replace('descargaArchivoSiged-check-', '');
			archivo = $('#descargaArchivoSiged-a-' + idArchivo);
			idsArchivos += "archivosSiged[" + index + "].idArchivo=" + archivo.attr("idArchivo") + "&archivosSiged[" + index + "].nombreArchivo=" + archivo.attr("nombreArchivo") + appender;
		});							
		if(idsArchivos!=""){
			$.download(baseURL + "pages/bandejaSupervision/descargaMultipleZipDocumentosSupervision", idsArchivos, "post");
		}else{
			alert("No ha seleccionado ningún archivo");
		}
    }
    
    function descargaMultipleZipDocumentosAdjuntosDetalleSupervision(){
		var idsArchivos = "";
		var appender = null;
		var countSelected = $(".descargaArchivo-check:checked").length;
		var idArchivo = null;
		var archivo = null;
		$(".descargaArchivo-check:checked").each(function(index, item){			
			appender = "";
			if(index < countSelected - 1){
				appender = "&";
			}
			idArchivo = $(item).attr('id').replace('descargaArchivoSiged-check-', '').replace('descargaArchivoInps-check-', '');
			archivo = $('#descargaArchivo-a-' + idArchivo);
			if(archivo.attr("tipoDescarga") == "otrosArchivos"){
				idsArchivos += "idArchivo[" + index + "]=" + archivo.attr("idsArchivo") + appender;
			}else if(archivo.attr("tipoDescarga") == "imagenPdf"){
				appender = "";
				if(idsArchivos != ""){
					appender = "&";
				}
				idsArchivos += appender + archivo.attr("idsArchivo");
			}
		});
		if(idsArchivos != ""){
			$.download(baseURL + "pages/bandejaSupervision/descargaMultipleZipDocumentosAdjuntosDetalleSupervision", idsArchivos, "post");
		}else{
			alert("No ha seleccionado ningún archivo");
		}
	}
    
	jQuery.extend($.fn.fmatter, {
		datosComentarioFormatter: function(cellvalue, options, rowdata) {
			var texto = '';
			if(rowdata.comentarios){
				$.each(rowdata.comentarios, function(index, value){
					texto += value;
					texto += "<br />";
				});
			}
            return texto;
        },
        documentosAdjuntosFormatter: function(cellvalue, options, rowdata) {
        	var link = '';
        	if(rowdata.tieneMediosProbatorios != null && rowdata.tieneMediosProbatorios != undefined && rowdata.tieneMediosProbatorios){
        		link = "<img src=\"" + baseURL + "/../images/search_documents.png\" onclick=\"detalleSupervision.buscarDocumentosAdjuntos('" + tipoDocumentoAdjunto.medioProbatorio + "', '1', '" + rowdata.idDetalleSupervision + "')\" style=\"cursor: pointer;\" title=\"Ver documentos adjuntos\"/>";
			}
            return link;
        },
        descargaDocumentoFormatter: function(cellvalue, options, rowdata) {
        	var link = '';
        	if(rowdata.idArchivo != null && rowdata.idArchivo != undefined && rowdata.idArchivo != ''){
        		if(rowdata.provieneSiged != null && rowdata.provieneSiged != undefined && rowdata.provieneSiged == 'S'){
        			link = "<a id=\"descargaArchivoSiged-a-" + rowdata.idArchivo + "\" href=\"" + baseURL + "pages/bandejaSupervision/descargaArchivoSiged?idArchivo=" + rowdata.idArchivo + "&nombreArchivo=" + rowdata.nombreArchivo + "\" idArchivo=\"" + rowdata.idArchivo + "\" nombreArchivo=\"" + rowdata.nombreArchivo + "\"><img src=\"" + baseURL + "/../images/descarga.png\" title=\"Descargar documento\"/></a>";
        		}else{
        			link = "<a id=\"descargaArchivoInps-a-" + rowdata.idArchivo + "\" href=\"" + baseURL + "pages/bandejaSupervision/descargaArchivo?idArchivo=" + rowdata.idArchivo + "\" idArchivo=\"" + rowdata.idArchivo + "\"><img src=\"" + baseURL + "/../images/descarga.png\" title=\"Descargar documento\"/></a>";
        		}
			}
            return link;
        },
        descargaDocumentoMedioProbatorioFormatter: function(cellvalue, options, rowdata) {
        	var link = '';
        	var urlDescarga = '';
    		var listaIdsArchivo = '';
    		var tipoDescarga = '';
        	if(rowdata.idArchivo != null && rowdata.idArchivo != undefined && rowdata.idArchivo != ''){
        		urlDescarga = baseURL + 'pages/bandejaSupervision/descargaArchivo?idArchivo=' + rowdata.idArchivo;
    			listaIdsArchivo = rowdata.idArchivo;
    			tipoDescarga = 'otrosArchivos';
			}else if(rowdata.idImagenes && rowdata.idImagenes != null){
				var archivos = '';
    			var longitud = rowdata.idImagenes.length - 1;
    			$.each(rowdata.idImagenes, function(i, fila){
    				archivos += 'idArchivoImagen[' + i + ']=' + fila;				
    				if(i < longitud){
    					archivos += '&';
    				}				
    			});
    			urlDescarga = baseURL + 'pages/bandejaSupervision/descargaPdfArchivo?' + archivos;
    			listaIdsArchivo = archivos;
    			tipoDescarga = 'imagenPdf';
			}
        	link = "<a id=\"descargaArchivo-a-" + rowdata.idArchivo + "\" href=\"" + urlDescarga + "\" tipoDescarga=\"" + tipoDescarga + "\" idsArchivo=\"" + listaIdsArchivo + "\"><img src=\"" + baseURL + "/../images/descarga.png\" title=\"Descargar documento\"/></a>";
            return link;
        },
        chkDescargaArchivoFormatter: function(cellvalue, options, rowdata) {
        	var idCheck = '';
        	var classCheck = '';
        	if(rowdata.provieneSiged != null && rowdata.provieneSiged != undefined && rowdata.provieneSiged == 'S'){
        		idCheck = 'descargaArchivoSiged-check-' + rowdata.idArchivo;
        		classCheck = 'archivoSiged';
        	}else{
        		idCheck = 'descargaArchivoInps-check-' + rowdata.idArchivo;
        		classCheck = 'archivoInps';
        	}
        	var check = '<input type="checkbox" id="' + idCheck + '" class="descargaArchivo-check ' + classCheck + '" onclick="detalleSupervision.clickCheckboxDescargaArchivo(this);" /><label for="' + idCheck + '" class="checkbox"></label>';
        	return check;
        },
        descripcionCondicionVerificadaFormatter: function(cellvalue, options, rowdata) {
        	var html = rowdata.condicionVerificada;
        	return html;
        }
    });
	
	return{
		constructor: constructor,
		buscarDocumentosAdjuntos: buscarDocumentosAdjuntos,
		clickCheckboxHeaderDescargaArchivo: clickCheckboxHeaderDescargaArchivo,
		clickCheckboxDescargaArchivo: clickCheckboxDescargaArchivo,
		descargaMultipleZipDocumentosSupervision: descargaMultipleZipDocumentosSupervision,
		descargaMultipleZipDocumentosAdjuntosDetalleSupervision: descargaMultipleZipDocumentosAdjuntosDetalleSupervision
	};
})();

$(function() {
	detalleSupervision.constructor();
	$("#divDirectorio").show();
});
