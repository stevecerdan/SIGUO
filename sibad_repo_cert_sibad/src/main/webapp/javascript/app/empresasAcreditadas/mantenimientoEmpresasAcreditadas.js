
$(function() {
	listarEmpresasAcreditadas(0);
    initInicioEmpresasAcreditadas();  
});

function initInicioEmpresasAcreditadas(){ 
	confirm.start();
	
    $('#btnBuscarEmp').click(function(){
    	listarEmpresasAcreditadas();
    });
    
    $('#btnNuevoEmp').click(function(){
    	abrirNuevaEmpresaAcreditada();
    });
    
    $('#vh').click(function(){
    	alert('ya hiciste click');
    });
    
    /*
    $('#btnInactivar').click(function(){
    	abrirFrmInactivar();
    });*/
    
}
/*
function abrirFrmInactivar(){   
	var title="INACTIVAR ORGANISMO";
    $.ajax({
        url:baseURL + "pages/mantenimientoOrganismosAcreditadores/abrirFrmInactivar", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogFrmInactivar").html(data);
            $("#dialogFrmInactivar").dialog({
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
}*/

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
}

function listarEmpresasAcreditadas(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorEmpAcred").html("");
    
    var grid = $("<table>", {
        "id": "gridEmpAcred"
    });
    
    var pager = $("<div>", {
        "id": "paginacionEmpAcred"
    });
    
    $("#gridContenedorEmpAcred").append(grid).append(pager);
    
    var nombres = ['N°','RUC','NOMBRE EMPRESAS ACREDITADAS','DIRECCI&Oacute;N', 'dpto', 'prov', 'dist','UBIGEO','TELEFONO/FAX','email','web','EMAIL/WEB','N° CEDULA/N° RESOLUCI&Oacute;N','VIGENCIA','TIPO DE ORGANISMO','REGISTRO N°','ESTADO','OPCI&Oacute;N'];
    var columnas = [
    	{name: "idAlcanceAcreditacion",width: 30, sortable: false, hidden: false, align: "center"},
    	{name: "ruc",width: 70, sortable: false, align: "center"},
        {name: "razonSocial",width: 180, sortable: false, hidden: false, align: "left"},
        {name: "direccion",width: 130, sortable: false, hidden: false, align: "left"},
        {name: "departamento",width: 95, sortable: false, hidden: true, align: "left"},
        {name: "provincia",width: 95, sortable: false, hidden: true, align: "left"},
        {name: "distrito", width: 95, sortable: false, hidden: true, align: "left"},
        {name: "ubigeo",width: 95, sortable: false, hidden: false, align: "center", formatter:"concatenaUbigeo"},
        {name: "telefono",width: 95, sortable: false, hidden: false, align: "left"},
        {name: "email", width: 95, sortable: false, hidden: true, align: "left"},
        {name: "web", width: 95, sortable: false, hidden: true, align: "left"},
        {name: "email/web", width: 130, sortable: false, hidden: false, align: "left", formatter:"concatenaEmailWeb"},
        {name: "resolucionCedula", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "fechaIVigencia", width: 80, sortable: false, hidden: false, align: "center", formatter:"fmtFecha"},
        {name: "tipoOrganismo",width: 70, sortable: false, hidden: false, align: "center"},
        {name: "registro", width: 70, sortable: false, hidden: false, align: "center"},
        {name: "estadoEmpresa",width: 60, sortable: false, hidden: false, align: "center", formatter:"fmtEstadoEmpAcred"},
        {name: "opcion",width: 140, sortable: false, hidden: false, align: "center", formatter:"Opciones"}
        
     ];
    
    //Filtro
    
    var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
    
    if (id_option == 1){
    	var buscaRuc = $("#txtFiltroBusqueda").val();}else{
    		if (id_option == 2){
    			var buscaRazonSocial = $("#txtFiltroBusqueda").val();}else{
			if (id_option == 3){
				var buscaDireccion = $("#txtFiltroBusqueda").val();}else{
			if (id_option == 4){
    	    	var buscaDepartamento = $("#txtFiltroBusqueda").val();}else{
    	    if (id_option == 5){
 				var buscaProvincia = $("#txtFiltroBusqueda").val();}else{
    	    if (id_option == 6){
    	    	var buscaDistrito = $("#txtFiltroBusqueda").val();}else{
			if (id_option == 7){
    	    	var buscaTelefono = $("#txtFiltroBusqueda").val();}
    	   }}}}}
		}
    //--------------------------------------
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarEmpresasAcreditadas",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            ruc: buscaRuc,
            razonSocial: buscaRazonSocial,
            direccion: buscaDireccion,
            departamento: buscaDepartamento,
            provincia: buscaProvincia,
            distrito: buscaDistrito,
            telefono: buscaTelefono
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionEmpAcred",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Empresas Acreditadas",
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
    //Concatenar
    jQuery.extend($.fn.fmatter, {
    	concatenaEmailWeb: function(cellvalue, options, rowdata) {
            var EAemail=rowdata.email;
            var EAweb=rowdata.web;
            var sel = '';
            if (EAemail != null && EAweb != '' && EAweb != undefined && EAweb != undefined){     
            	sel = EAemail+'\n'+EAweb;
            }
            return sel;
        }
    });
    
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
    
    //Botones Links
    jQuery.extend($.fn.fmatter, {
    	Opciones: function(cellvalue, options, rowdata) {
    		
            return "<a href='#" + cellvalue +"'><u> Editar </u></a>"+"   "+
        		   "<a href='#' id='vh' ><u> Ver Historial </u></a>";
        }
    });
    
    //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoEmpAcred: function(cellvalue, options, rowdata) {
            var sel = rowdata.estadoEmpresa;
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
    	fmtFecha: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaIVigencia;
    		var d=new Date(dateVar);
    		
    		if((d.getMonth()+1) < 10){
    			var mes = '0' + (d.getMonth() + 1);
    		}else{
    			var mes = d.getMonth() + 1;
    		}
    		
    		var fecha = d.getDate() + '-' + mes + '-' + d.getFullYear()
    		return fecha;
    		 
        }
    });
	
}
