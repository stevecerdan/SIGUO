var nombreEmpresa;
var idOrgAcred = "";
$(function() {
	listarEmpresasAcreditadas(0);
    initInicioEmpresasAcreditadas();  
});

function initInicioEmpresasAcreditadas(){ 
	confirm.start();
	
    $('#btnBuscarEmp').click(function(){
    	listarEmpresasAcreditadas();
    });
        
    $('body').on('click', '.consultarEA',function(){
        var cadena= $(this).attr("id");
        var arrayCadena = cadena.split("%");
        var estadoc="CONSULTAR";
        var estado = "VER";

        var idResultadoPruebaReprueba = arrayCadena[0];
        var idEmpresaAcreditada = arrayCadena[1];
        var idCompartimiento = arrayCadena[2];
        var numeroCompartimiento = arrayCadena[3];
        var numeroTanque = arrayCadena[4];
        var fInicio = arrayCadena[5];
        var resultadoPrueba = arrayCadena[6];
        var idUnidSupervTanque = arrayCadena[7];

        var idUnidadSupervisada  = arrayCadena[8];
        var idEmpresaAcreditada  = arrayCadena[9];
        var nombreEmpresa        = arrayCadena[10];
        var modulo               = arrayCadena[11];
        var cilindro             = arrayCadena[12];
        var fechaSolicitud       = arrayCadena[13];
        var idSolicitudPR        = arrayCadena[14];
        var idResultadoPR        = arrayCadena[15];

        
        if(modulo !== 'null'){ 
            abrirFrmReprueba(idUnidadSupervisada,idEmpresaAcreditada,nombreEmpresa,modulo,cilindro,fechaSolicitud,idSolicitudPR,estadoc,idResultadoPR);
       
        }else{
            abrirFrmResultadoPruebaHermeticidadAux(idResultadoPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,fInicio,resultadoPrueba,idUnidSupervTanque,estado);
        }
    });


    $('#btnNuevoEmp').click(function(){
    	var idOrgAcred = $("#idOrganismoAcreditadorEntrante").val();
    	$("#cmbTipoBusqueda").val(0);
    	$("#cmbEstadoPrincipal").val(0);
    	$("#txtFiltroBusqueda").val('');
    	abrirNuevaEmpresaAcreditada(idOrgAcred);
    });
    
    $("#btnExportar").click(function(e) {
    	
    	ExportarDatosTabla();
    	
    });
    
    $('body').on('click', '.VerHistorial',function(){
    	var idempresa= $(this).attr("id");
    	tab('tab_02','panel_02');
    	$("#tab_02").removeAttr('style');
    	$('#Titulo').html(nombreEmpresa);
        listarResultados(0, idempresa);
    });
    
    $("#tab_01").click(function(e) {
    	$("#tab_02").attr('style','display:none;');
    	tab('tab_01','panel_01');
    	
    });
    
    $('body').on('click', '.Informe',function(){
       var cadena= $(this).attr("id");
  	   
  	   var arrayCadena = cadena.split("%");
  	   
  	   var id = arrayCadena[0];
  	   var estadoAccion = arrayCadena[1];
    	
  	   var avi = "E"
    	
    	abrirInformacion();
    	cargarDatosInformacion(id,estadoAccion,avi);
    });
 
    
    $('body').on('click', '.EditarAlcance',function(){
    	
  	   var cadena= $(this).attr("id");
  	   
  	   var arrayCadena = cadena.split("%");
  	   
  	   var id = arrayCadena[0];
  	   var ruc = arrayCadena[1];
  	   
  	   if (id == '' || id == 'null'){
  		   
  		   id = '';
  	   
  	   } else {
  		   
  		   id =arrayCadena[0];
  		   
  	  }
  	   
        if (ruc == ''  || ruc == 'null'){
  		   
      	  ruc ='' ;
  	   
        } else {
  		   
      	  ruc =arrayCadena[1] ;
  		   
  	  }
        
        $("#cmbTipoBusqueda").val(0);
    	$("#txtFiltroBusqueda").val('');
       
    	var idOrgAcred = $("#idOrganismoAcreditadorEntrante").val();
       abrirNuevaEmpresaAcreditada(idOrgAcred);
       var msg = "EDIT";
  	   cargarDatosEmpresaAcreditada(id,ruc,msg);
  	   $("#txtRUC").attr('disabled','disabled');
      });
     
 }

 function abrirFrmResultadoPruebaHermeticidadAux(idResultadoPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,fInicio,resultadoPrueba,idUnidSupervTanque,estado){
     
     $.ajax({
            url:baseURL + "pages/resultadosPruebasHermeticidad/abrirFrmResultadoPruebaHermeticidad", 
            type:'get',
            async:false,
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
               
            $("#dialogNuevaReprueba").html(data);
        
            $("#dialogNuevaReprueba").dialog({
            
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "1260",
                position: ['center', 'top+30'],
                modal: true,
                dialogClass: 'dialog',
                title: "PRUEBAS DE HERMETICIDAD - CONSULTAR RESULTADOS",
                closeText: "Cerrar",
                open: function( event, ui ) {
                    TraerDatosConsultaResPH(idResultadoPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,fInicio,resultadoPrueba,idUnidSupervTanque,estado);
                },
            });
            
        },
        
        error:errorAjax
    });
}

 function abrirFrmReprueba(idUnidadSupervisada,idEmpresaAcreditada,nombreEmpresa,modulo,cilindro,fechaSolicitud,idSolicitudPR,estadoc,idResultadoPR){
     var Rpt = 'BLOQUEAR';
     $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/abrirFrmRepruebaCilindrosGNV", 
            type:'get',
            async:false,
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
               
                $("#dialogNuevaReprueba").html(data);
            
                $("#dialogNuevaReprueba").dialog({
                    resizable: false,
                    draggable: true,
                    autoOpen: true,
                    height:"auto",
                    width: "950",
                    position: ['center', 'top+30'],
                    modal: true,
                    dialogClass: 'dialog',
                    title: "REPRUEBA DE CILINDROS DE GNV - REGISTRO DE RESULTADOS",
                    closeText: "Cerrar",
                    open: function( event, ui ) {
                        repruebaCilindrosGNV(idUnidadSupervisada,idEmpresaAcreditada,nombreEmpresa,modulo,cilindro,fechaSolicitud,idSolicitudPR,estadoc,idResultadoPR);
                        bloquearDesbloquearCampos(Rpt);
                    },
                    close: function(event, ui)
                    {
                        window.location.href = baseURL+'pages/mantenimientoEmpresasAcreditadas';
                        $(this).dialog("close");
                        $(this).remove();
                    }
                });
                
            },
            
            error:errorAjax
        });
}

function convertirFecha(f){

    var dateVar = f;
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
        var fecha = '';
    }
  
    return fecha;
} 

function abrirNuevaEmpresaAcreditada(idOrgAcred){
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
            cargarOrganismoEA(idOrgAcred);
        },
        error:errorAjax
    });
}

function ExportarDatosTabla(){

	ProcesosAcreditacionEnTabla();

    $('.jqgfirstrow').addClass('noExl');
        
    $('td[dir="ltr"]').attr ('class', 'noExl');

    $("#tablitaEA").table2excel({
        exclude: ".noExl",
        name: "Excel Document Name",
        filename: "ListadoProcesosAcreditacion",
        fileext: ".xls",
        exclude_img: true,
        exclude_links: true,
        exclude_inputs: true
    });  
}

function ProcesosAcreditacionEnTabla() {
	
	//Filtro
    
    var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
    var id_option2 = document.getElementById("cmbEstadoPrincipal").selectedIndex;
    
    var buscaEstado;
    var buscaEstadoA;
    var buscaEstadoE;
    
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
    	    	var buscaDistrito = $("#txtFiltroBusqueda").val();}
    	    }}}}
		}
    
    if (id_option2 == 1){
    	buscaEstado = "A";
    	buscaEstadoA = "R";
    	buscaEstadoE = "H";
	}else{
		if (id_option2 == 2){
	    	buscaEstado = "I";
	    	buscaEstadoA = "C";
	    	buscaEstadoE = "S";
		}
	}
    //--------------------------------------
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarDatosAlcanceCTRL",
        type:'GET',
        async:false,
        data:{
        	idOrganismoAcreditador:$("#idOrganismoAcreditadorEntrante").val(),
            ruc: buscaRuc,
            razonSocial: buscaRazonSocial,
            direccion: buscaDireccion,
            departamento: buscaDepartamento,
            provincia: buscaProvincia,
            distrito: buscaDistrito,
            estadoAlcance: buscaEstado,
            estadoAccion: buscaEstadoA,
            estadoEmpresa: buscaEstadoE
        },
        beforeSend:muestraLoading,
        success:function(data){
            var tex ="<tr>";
            tex = tex + "<th>RUC</th>";
            tex = tex + "<th>Razon_Social</th>";
            tex = tex + "<th>Direccion</th>";
            tex = tex + "<th>Ubigeo</th>";
            tex = tex + "<th>Telefono</th>";
            tex = tex + "<th>Email</th>";
            tex = tex + "<th>Web</th>";
            tex = tex + "<th>NroResolucion_NroCedula</th>";
            tex = tex + "<th>Fecha_Vencimiento</th>";
            tex = tex + "<th>Tipo_Organismo</th>";
            tex = tex + "<th>Nro_Registro</th>";
            tex = tex + "<th>Estado</th>";
            tex = tex + "</tr>";

            ocultaLoading();
            $.each(data.filas, function( index, value ) {
                var estado = "";
                if(value.estadoAlcance.toUpperCase()=='A'){
                	estado='VIGENTE ';
                }else{
                	estado='NO VIGENTE ';
                }
                
                var ubigeo = value.departamento + ' - ' + value.provincia + ' - ' + value.distrito;

                tex = tex + "<tr>";
                tex = tex + '<td>'+ value.ruc +'</td>';
                tex = tex + '<td>'+ value.razonSocial +'</td>';
                tex = tex + '<td>'+ value.direccion +'</td>';
                tex = tex + '<td>'+ ubigeo +'</td>';
                tex = tex + '<td>'+ value.telefono +'</td>';
                tex = tex + '<td>'+ value.email +'</td>';
                tex = tex + '<td>'+ value.web +'</td>';
                tex = tex + '<td>'+ value.resolucionCedula +'</td>';
                tex = tex + '<td>'+ convertirFecha( value.fechaVencimiento) +'</td>';
                tex = tex + '<td>'+ value.tipoOrganismo +'</td>';
                tex = tex + '<td>'+ value.registro +'</td>';
                tex = tex + '<td>'+ estado +'</td>';
                tex = tex + "</tr>";
                
            });

            $("#tablitaEA").append(tex);
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
        "id": "gridContenedorEmpAcred"
    });
    
    var pager = $("<div>", {
        "id": "paginacionEmpAcred"
    });
    
    $("#gridContenedorEmpAcred").append(grid).append(pager);
    
    var nombres = ['ID ALCANCE ACREDITACION','ID EMPRESA ACREDITADA','N°','RUC','NOMBRE EMPRESAS ACREDITADAS','DIRECCI&Oacute;N', 'dpto', 'prov', 'dist','UBIGEO','TELEFONO/FAX','email','web','EMAIL/WEB','N° CEDULA/N° RESOLUCI&Oacute;N','VIGENCIA','TIPO DE ORGANISMO','REGISTRO N°','ESTADO','ESTADO ACCION','OPCI&Oacute;N'];
    var columnas = [
    	
    	{name: "idAlcanceAcreditacion",width: 30, sortable: false, hidden: true, align: "center"},
    	{name: "idEmpresaAcreditada",width: 30, sortable: false, hidden: true, align: "center"},
    	{name: "n",width: 30, sortable: false, hidden: false, align: "center", formatter:"NumeroFilas"},
    	{name: "ruc",width: 70, sortable: false, align: "left"},
        {name: "razonSocial",width: 180, sortable: false, hidden: false, align: "left"},
        {name: "direccion",width: 130, sortable: false, hidden: false, align: "left"},
        {name: "departamento",width: 95, sortable: false, hidden: true, align: "left"},
        {name: "provincia",width: 95, sortable: false, hidden: true, align: "left"},
        {name: "distrito", width: 95, sortable: false, hidden: true, align: "left"},
        {name: "ubigeo",width: 95, sortable: false, hidden: false, align: "left", formatter:"concatenaUbigeo"},
        {name: "telefono",width: 95, sortable: false, hidden: false, align: "left"},
        {name: "email", width: 95, sortable: false, hidden: true, align: "left"},
        {name: "web", width: 95, sortable: false, hidden: true, align: "left"},
        {name: "email/web", width: 130, sortable: false, hidden: false, align: "left", formatter:"concatenaEmailWeb"},
        {name: "resolucionCedula", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "fechaVencimiento", width: 80, sortable: false, hidden: false, align: "left", formatter:"fmtFecha"},
        {name: "tipoOrganismo",width: 70, sortable: false, hidden: false, align: "left"},
        {name: "registro", width: 70, sortable: false, hidden: false, align: "left"},
        {name: "estadoAlcance",width: 82, sortable: false, hidden: false, align: "left", formatter:"fmtEstadoEmpAcred"},
        {name: "estadoAccion",width: 20, sortable: false, hidden: true, align: "left"},
        {name: "opcion",width: 125, sortable: false, hidden: false, align: "center", formatter:"Opciones"}
        
     ];
    
    
    //Filtro
    //$("#txtFiltroBusqueda").val('');
    //$("#cmbTipoBusqueda").val(0);
    
    var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
    var id_option2 = document.getElementById("cmbEstadoPrincipal").selectedIndex;
    
    var buscaEstado;
    var buscaEstadoA;
    var buscaEstadoE;
    
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
    	    	var buscaDistrito = $("#txtFiltroBusqueda").val();}
    	    }}}}
		}
    
    if (id_option2 == 1){
    	buscaEstado = "A";
    	buscaEstadoA = "R";
    	buscaEstadoE = "H";
	}else{
		if (id_option2 == 2){
	    	buscaEstado = "I";
	    	buscaEstadoA = "C";
	    	buscaEstadoE = "S";
		}
	}
    //--------------------------------------
     
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarEmpresasAcreditadas",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idOrganismoAcreditador:$("#idOrganismoAcreditadorEntrante").val(),
            ruc: buscaRuc,
            razonSocial: buscaRazonSocial,
            direccion: buscaDireccion,
            departamento: buscaDepartamento,
            provincia: buscaProvincia,
            distrito: buscaDistrito,
            estadoAlcance: buscaEstado,
            estadoAccion: buscaEstadoA,
            estadoEmpresa: buscaEstadoE
            
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 20,
        pager: "#paginacionEmpAcred",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Empresas Acreditadas",
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
            nombreEmpresa = rowData.razonSocial;
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    //Conteo de filas
    jQuery.extend($.fn.fmatter, {
    	NumeroFilas: function(cellvalue, options, rowdata) {
          var n = $("#gridContenedorEmpAcred tr").index() + 1;
          return n;
        }
    });
    
    //Concatenar
    jQuery.extend($.fn.fmatter, {
    	concatenaEmailWeb: function(cellvalue, options, rowdata) {
            var EAemail=rowdata.email;
            var EAweb=rowdata.web;
            var sel = '';
            if (EAweb != '' && EAweb != undefined){     
            	sel = EAemail+'\n'+EAweb;
            }else{
            	sel = EAemail;
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
    		    		
    		return "<a class='EditarAlcance' id='"+ rowdata.idEmpresaAcreditada +"%"+ rowdata.ruc+"' style='cursor: pointer;text-decoration:none;' ><u> Editar</u></a>"+"\t"+
 	 	   "<a class='VerHistorial' id='"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Ver Historial </u></a>";
        }
    });
    
    //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoEmpAcred: function(cellvalue, options, rowdata) {
            var sel = rowdata.estadoAlcance;
            var tex ='';
            if(sel=="A"){
            	tex='VIGENTE ';
            }else{
            	tex='NO VIGENTE ';
            }
            return tex+"<img src=\"" + baseURL + "/../images/info2.png\" class='Informe' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.estadoAccion+"'style=\"cursor: pointer; width: 16px;\" title=\"Informe\"/>" ;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFecha: function(cellvalue, options, rowdata) {
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
            //compararFechas(dateVar, idAlcance, idEmpresa);
    		 
        }
    });
	
}

function abrirInformacion(){ 
	
	var title="INFORMACION - ESTADO DEL ALCANCE DE ACREDITACION";
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirInformacion", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogInfo").html(data);
            $("#dialogInfo").dialog({
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

function listarResultados(flg_load, idempresa) {

    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorResultados").html("");
    
    var grid = $("<table>", {
        "id": "grid"
    });
    
    var pager = $("<div>", {
        "id": "paginacion"
    });
    
   $("#gridContenedorResultados").append(grid).append(pager);


    var nombres = ['','','','EMPRESA','DIRECCION','UBIGEO','N° SOLICITUD/PRUEBA','TIPO PRUEBA','','','','','UNID. ALMACENAMIENTO','ESTADO','FECHA SOLICITUD', 'FECHA PROGRAMADA','FECHA EJECUCIÓN','RESULTADO','VER'];
    var columnas = [
        
        
        {name: "idSolicitudPruebaReprueba", width: 0, sortable: false, hidden: true, align: "left"},
        {name: "idUnidSupervModulo", width: 150, sortable: false, hidden: true, align: "left"},
        {name: "idUnidSupervTanque", width: 200, sortable: false, hidden: true, align: "left"},
        {name: "nombreUnid", width: 150, sortable: false, hidden: false, align: "left"},
        {name: "direccion", width: 200, sortable: false, hidden: false, align: "left"},
        {name: "ubigeo", width: 140, sortable: false, align: "left"},
        {name: "nroSolicitudUnidadSupervisa", width: 120, sortable: false, hidden: false, align: "left"},
        {name: "tipoPrueba", width: 80, sortable: false, hidden: false, align: "left"},
        {name: "nombreUnidModulo", width: 0, sortable: false, hidden: true, align: "left"},
        {name: "nombreUnidTanque", width: 0, sortable: false, hidden: true, align: "left"},
        {name: "unidAlmacenamiento1", width: 110, sortable: false, hidden: true, align: "left"},
        {name: "unidAlmacenamiento2", width: 110, sortable: false, hidden: true, align: "left"},
        {name: "unidAlmacenamiento", width: 110, sortable: false, align: "left",formatter:"OpcionesUndAlm"},
        {name: "estado", width: 77, sortable: false, hidden: false, align: "left", formatter:"fmtEstado"},
        {name: "fechaCreacion", width: 80, sortable: false, hidden: false, align: "left",formatter:"fmtFechaC"},
        {name: "fechaSolicitud", width: 80, sortable: false, align: "left", formatter:"fmtFechaS"},
        {name: "fechaInicio", width: 80, sortable: false, hidden: false, align: "left", formatter:"fmtFechaI"},
        {name: "resultadoPrueba", width: 100, sortable: false, hidden: false, align: "left", formatter:"fmtResultado"},
        {name: "ver", width: 40, sortable: false, align: "center", formatter:"OpcionVer"},
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarSolicitudes",
        datatype: "json",
        postData: {
        	idEmpresaAcreditada: idempresa
        },
        hidegrid: false,
        rowNum: 10,
        pager: "#paginacion",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "LISTA DE RESULTADOS",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
            //id: "idDocumentoAdjunto"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
    jQuery.extend($.fn.fmatter, {
        OpcionesNombUnd: function(cellvalue, options, rowdata) {
            var undTanque = rowdata.nombreUnidModulo;
            var undCilindro = rowdata.nombreUnidTanque;

            if(undTanque !== null && undTanque !== undefined)
                return undTanque;
            else
                return undCilindro
        }
    });

    jQuery.extend($.fn.fmatter, {
        fmtEstado: function(cellvalue, options, rowdata) {
            var sel = rowdata.estado;
            var tex ='';
            
            if(sel.toUpperCase()=='P')
                tex='PROGRAMADO' + '  &nbsp;&nbsp;';
            if(sel.toUpperCase()=='R')
                tex='REPROGRAMADO';
            if(sel.toUpperCase()=='C')
                tex='CANCELADO' + '  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp';
            if(sel.toUpperCase()=='E')
                tex='EN REGISTRO' +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp';
            if(sel.toUpperCase()=='F')
                tex='FINALIZADO' +' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp';
        
            return tex ;
            //+"<img src=\"" + baseURL + "/../images/info2.png\" class='Informe' id='"+ rowdata.idSolicitudPruebaReprueba +"'style=\"cursor: pointer; width: 16px; text-align: right;\" title=\"Informe\"/>" ;
        }
    }); 

    jQuery.extend($.fn.fmatter, {
        fmtResultado: function(cellvalue, options, rowdata) {
            var sel = rowdata.resultadoPrueba;
            var tex ='';
            
            if(sel.toUpperCase()=='A')
                tex='CONFORME';
            if(sel.toUpperCase()=='C')
                tex='CONDENADO';
            if(sel.toUpperCase()=='R')
                tex='RECHAZADO';
            if(sel.toUpperCase()=='N')
                tex='NO CONFORME';
        
            return tex ;
            //+"<img src=\"" + baseURL + "/../images/info2.png\" class='Informe' id='"+ rowdata.idSolicitudPruebaReprueba +"'style=\"cursor: pointer; width: 16px; text-align: right;\" title=\"Informe\"/>" ;
        }
    }); 

    jQuery.extend($.fn.fmatter, {
        OpcionesUndAlm: function(cellvalue, options, rowdata) {
            var idUndModulo = rowdata.idUnidSupervModulo;
            var idUndTanque = rowdata.idUnidSupervTanque;

            if(idUndModulo !== null && idUndModulo !== undefined)
                return rowdata.unidAlmacenamiento2;
            else
                return rowdata.unidAlmacenamiento1;
        }
    });

    jQuery.extend($.fn.fmatter, {
        OpcionVer: function(cellvalue, options, rowdata) {
            //alert(rowdata.idCompartimiento +"%"+ rowdata.empresaAcreditada+"%"+ convertirFecha(rowdata.fechaCreacion)+"%"+ convertirFecha(rowdata.fechaSolicitud)+"%"+ rowdata.estado+ "%" + rowdata.idSolicitudPruebaReprueba + "%" + rowdata.idEmpresaAcreditada + "%" + rowdata.modulo + "%" + rowdata.cilindro );
            var iconbutton="";
            iconbutton = "<input type='button' id='"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.idEmpresaAcreditada+"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroCompartimiento +"%"+ rowdata.numeroTanque + "%" +  convertirFecha( rowdata.fechaInicio ) + "%" + rowdata.resultadoPrueba +"%"+ rowdata.idUnidSupervTanque +"%"+ rowdata.idUnidSupervModulo +"%"+ rowdata.idEmpresaAcreditada + "%"+ rowdata.empresaAcreditada + "%"+ rowdata.modulo + "%"+ rowdata.cilindro +"%"+ convertirFecha(rowdata.fechaSolicitud) +"%"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idResultadoPruebaReprueba +"' title='CONSULTAR' class='btnSimple consultarEA' style='width: 20px' value='...'>";
                                                    //rowdata.idResultadoPruebaReprueba +"%"+ rowdata.idEmpresaAcreditada +"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroCompartimiento +"%"+ rowdata.numeroTanque +"%"+ fInicio +"%"+ rowdata.resultadoPrueba +"%"+ rowdata.idUnidSupervTanque +

            return iconbutton;
        }
    });

    jQuery.extend($.fn.fmatter, {
        fmtFechaC: function(cellvalue, options, rowdata) {
            return convertirFecha(rowdata.fechaCreacion);              
        }
    });
    jQuery.extend($.fn.fmatter, {
        fmtFechaS: function(cellvalue, options, rowdata) {
            return convertirFecha(rowdata.fechaSolicitud);             
        }
    });
    jQuery.extend($.fn.fmatter, {
        fmtFechaI: function(cellvalue, options, rowdata) {
            return convertirFecha(rowdata.fechaInicio);             
        }
    });
}