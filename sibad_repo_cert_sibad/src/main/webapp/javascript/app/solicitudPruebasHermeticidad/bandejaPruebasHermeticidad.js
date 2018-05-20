var nombreEmpresa;
$(function() {
	listarEmpresasAcreditadas(0);
    initInicioEmpresasAcreditadas();  
});

function initInicioEmpresasAcreditadas(){ 
	confirm.start();
	
    $('#btnBuscarSolicitud').click(function(){
    	//listarEmpresasAcreditadas();
    });
    
    $('#btnSolicitud').click(function(){
    	//abrirNuevaEmpresaAcreditada();
    });
    
   /* $("#btnExportar").click(function(e) {
        window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#gridContenedorEmpAcred').html()));
        e.preventDefault();
    });*/
     
 }
/*
function abrirNuevaEmpresaAcreditada(){
	var title="EMPRESA ACREDITADA - ORGANISMO DE INSPECCIÓN";
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirNuevaEmpresaAcreditada", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogNuevaEmpresaAcreditada").html(data);
            $("#dialogNuevaEmpresaAcreditada").dialog({          	
            	position: { my: 'top', at: 'top+20' },
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "1020",
                modal: true,
                dialogClass: 'dialog',	
                title: title,
                closeText:"Cerrar"
            });            
        },
        error:errorAjax
    });
}*/

function listarBandejaPruebaHermeticidad(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorPruebaHermeticidad").html("");
    
    var grid = $("<table>", {
        "id": "gridPruebaHermeticidad"
    });
    
    var pager = $("<div>", {
        "id": "paginacionPruebaHermeticidad"
    });
    
    $("#gridContenedorPruebaHermeticidad").append(grid).append(pager);
    
    var nombres = ['N° SOLICITUD','EMPRESA','UNIDAD ALMACENAMIENTO','ESTADO', 'FECHA DE REGISTRO', 'FECHA DE SOLICITUD', 'FECHA DE ATENCI&Oacute;N','RESULTADO','FECHA DE PR&Oacute;XIMA PRUEBA','OPCI&Oacute;N'];
    var columnas = [
    	{name: "numeroSolicitud",width: 30, sortable: false, hidden: false, align: "center", formatter:"NumeroFilas"},
    	{name: "empresa",width: 70, sortable: false, align: "center"},
        {name: "unidadAlmacenamiento",width: 180, sortable: false, hidden: false, align: "left"},
        {name: "estado",width: 130, sortable: false, hidden: false, align: "left", formatter:"fmtEstadoSol"},
        {name: "fechaRegistro",width: 95, sortable: false, hidden: false, align: "left", formatter:"fmtFecha"},
        {name: "fechaSolicitud", width: 130, sortable: false, hidden: false, align: "left", formatter:"fmtFecha"},
        {name: "fechaAtencion", width: 100, sortable: false, hidden: false, align: "left", formatter:"fmtFecha"},
        {name: "resultado", width: 80, sortable: false, hidden: false, align: "center"},
        {name: "fechaProximaPrueba",width: 70, sortable: false, hidden: false, align: "center", formatter:"fmtFecha"},
        {name: "opcion",width: 140, sortable: false, hidden: false, align: "center", formatter:"Opciones"}
        
     ];
    
    
    //Filtro
    
    var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
    
    if (id_option == 1){
    	var buscaNSolicitud = $("#txtBusqueda").val();}else{
    		if (id_option == 2){
    			var buscaEmpresa = $("#txtBusqueda").val();}else{
			if (id_option == 3){
				var buscaUnidadAlm = $("#txtBusqueda").val();}else{
			if (id_option == 4){
    	    	var buscaEstado = $("#txtBusqueda").val();}else{
    	    if (id_option == 5){
 				var buscaResultado = $("#txtBusqueda").val();}
    	    }}}
		}
    //--------------------------------------
    
    grid.jqGrid({
        url: baseURL + "pages/solicitudPruebasHermeticidad/listarEmpresasAcreditadas",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            numeroSolicitud :buscaNSolicitud,
            empresa :buscaEmpresa,
            unidadAlmacenamiento :buscaUnidadAlm,
            estado :buscaEstado,
            resultado :buscaResultado
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 5,
        pager: "#paginacionPruebaHermeticidad",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Solicitudes de Pruebas de Hermeticidad",
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
       /* onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            nombreEmpresa = rowData.razonSocial;
        },*/
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
    //Botones Links
    jQuery.extend($.fn.fmatter, {
    	Opciones: function(cellvalue, options, rowdata) {
    		
    		return "<a class='VerResultado' id='"+ rowdata.idEmpresaAcreditada +"%"+ rowdata.ruc+"' style='cursor: pointer;text-decoration:none;' ><u> Ver Resultado</u></a>"+"\t"+
 	 	   "<a class='Informe' id='"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Informe </u></a>";
        }
    });
    
    //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoSol: function(cellvalue, options, rowdata) {
            var sel = rowdata.estado;
            var tex ='';
            if(sel=="A" || sel =="S"){
            	tex='CONCLUIDO';
            }else{
            	tex='REPROGRAMADO';
            }
            return tex;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFecha: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaRegistro;
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
            //compararFechas(dateVar, idAlcance, idEmpresa);
    		 
        }
    });
	
}
