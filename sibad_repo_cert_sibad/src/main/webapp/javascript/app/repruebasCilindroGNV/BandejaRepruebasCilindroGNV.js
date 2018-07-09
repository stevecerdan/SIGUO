var idunidadSupervisadaAux =  68352;
var codigoOsinergminAux    =  "";
var estado                 =  "";
var Rpt                    =  "";

$(function() {
    initInicioEmpresasAcreditadas();
});

function initInicioEmpresasAcreditadas(){
    listarRepruebas(0,idunidadSupervisadaAux);	
    verificarUsuarioOsinergmin();

    $('#btnSolicitar').click(function() {
        abrirFrmRegistroSolicitudRepruebaGNV("","","","","","","");
    }); 

    $('#btnBuscarEmp').click(function() {
        listarRepruebas(0,idunidadSupervisadaAux);
    });

    $('body').on('click', '.Reprogramar',function(){
        var tipoOp = "R";
        var id= $(this).attr("id");
        abrirFrmReprogramacionCancelacion(id, tipoOp);
    });

    $('body').on('click', '.Cancelar',function(){
        var tipoOp = "C"
        var id= $(this).attr("id");
        abrirFrmReprogramacionCancelacion(id, tipoOp);
        
    });

    $('body').on('click', '.Consultar',function(){
        var cadena= $(this).attr("id");
        var arrayCadena = cadena.split("%");

        var idSolicitudPruebaReprueba = arrayCadena[0];
        var idEmpresaAcreditada = arrayCadena[1];
        var modulo = arrayCadena[2];
        var cilindro = arrayCadena[3];
        var fechaSolicitud = arrayCadena[4];
    

        abrirFrmRegistroSolicitudRepruebaGNV(idSolicitudPruebaReprueba, idEmpresaAcreditada, modulo, cilindro, fechaSolicitud); 
    });
    
    $('body').on('click', '.Registrar',function(){
    	abrirFrmReprueba(1);	
    	
    	estado="NUEVO_REGISTRO";
    	
    	var cadena= $(this).attr("id");
    	var arrayCadena = cadena.split("%");
    	
    	var idUnidadSupervisada  = arrayCadena[0];
    	var idEmpresaAcreditada  = arrayCadena[1];
    	var nombreEmpresa        = arrayCadena[2];
    	var modulo               = arrayCadena[3];
    	var cilindro             = arrayCadena[4];
    	var fechaSolicitud       = arrayCadena[5];
    	var idSolicitudPR        = arrayCadena[6];
    	var idResultadoPR        = arrayCadena[7];
        var numeroSerie          = arrayCadena[8];
        var idCilindroGNV        = arrayCadena[9];
    	
    	repruebaCilindrosGNV(idUnidadSupervisada,idEmpresaAcreditada,nombreEmpresa,modulo,cilindro,fechaSolicitud,idSolicitudPR,estado,idResultadoPR,numeroSerie,idCilindroGNV);
    	
    	$( "#button-id").children().addClass( "button-ok" );
    	$( "#registroRV").children().addClass( "button-ok" );
    	$(".button-ok").css({display: "block"});
    });
    
    $('body').on('click', '.RegistrarE',function(){
    	abrirFrmReprueba(1);	
    	
    	estado="EN_REGISTRO";
    	
    	var cadena= $(this).attr("id");
    	var arrayCadena = cadena.split("%");
    	
    	var idUnidadSupervisada  = arrayCadena[0];
    	var idEmpresaAcreditada  = arrayCadena[1];
    	var nombreEmpresa        = arrayCadena[2];
    	var modulo               = arrayCadena[3];
    	var cilindro             = arrayCadena[4];
    	var fechaSolicitud       = arrayCadena[5];
    	var idSolicitudPR        = arrayCadena[6];
    	var idResultadoPR        = arrayCadena[7];
        var numeroSerie          = arrayCadena[8];
        var idCilindroGNV        = arrayCadena[9];
    	
    	repruebaCilindrosGNV(idUnidadSupervisada,idEmpresaAcreditada,nombreEmpresa,modulo,cilindro,fechaSolicitud,idSolicitudPR,estado,idResultadoPR,numeroSerie,idCilindroGNV);
    	
    	$( "#button-id").children().addClass( "button-ok" );
    	$( "#registroRV").children().addClass( "button-ok" );
    	$(".button-ok").css({display: "block"});
    });
    
    $('body').on('click', '.ConsultarE',function(){
    	abrirFrmReprueba(0);	
    	
    	estado="CONSULTAR";
    	Rpt = 'BLOQUEAR';
    	
    	var cadena= $(this).attr("id");
    	var arrayCadena = cadena.split("%");
    	
    	var idUnidadSupervisada  = arrayCadena[0];
    	var idEmpresaAcreditada  = arrayCadena[1];
    	var nombreEmpresa        = arrayCadena[2];
    	var modulo               = arrayCadena[3];
    	var cilindro             = arrayCadena[4];
    	var fechaSolicitud       = arrayCadena[5];
    	var idSolicitudPR        = arrayCadena[6];
    	var idResultadoPR        = arrayCadena[7];
        var numeroSerie          = arrayCadena[8];
        var idCilindroGNV        = arrayCadena[9];
    	
    	repruebaCilindrosGNV(idUnidadSupervisada,idEmpresaAcreditada,nombreEmpresa,modulo,cilindro,fechaSolicitud,idSolicitudPR,estado,idResultadoPR,numeroSerie,idCilindroGNV);
    	bloquearDesbloquearCampos(Rpt);
    	
    	$( "#button-id").children().addClass( "button-ok" );
    	$(".button-ok").css({display: "block"});
    });
       
    $('body').on('click', '.Informe',function(){
        var id= $(this).attr("id");
        abrirInformacion();
    });
    
    $("#btnExportar").click(function(e) {
        pasarDatos();
    });
}

function abrirInformacion(){ 
    var title="INFORMACIÓN";
    $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/abrirConfirmarSolicitudGNV", 
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
                closeText: "Cerrar",
                open: function( event, ui ) {
                    cargarDatos($.trim(estadoAux), idAux);
                }
            });
        },
        error:errorAjax
    });
}

function pasarDatos(){

    $('.jqgfirstrow').addClass('noExl');
        
        $('td[aria-describedby="gridContenedorRepruebas_idSolicitudPruebaRp"]').attr ('class', 'noExl');
        $('td[aria-describedby="gridContenedorRepruebas_opcion"]').attr ('class', 'noExl');
        
        $('th[id="gridContenedorRepruebas_idSolicitudPruebaRp"]').addClass('noExl');
        $('th[id="gridContenedorRepruebas_opcion"]').addClass('noExl');
        
        $('td[id="paginacionEmpAcred_center"]').attr ('class', 'noExl');
        $('td[id="paginacionEmpAcred_left"]').attr ('class', 'noExl');
        $('td[id="paginacionEmpAcred_right"]').attr ('class', 'noExl');
        
        $('td[dir="ltr"]').attr ('class', 'noExl');

        $("#gridContenedorRepruebas").table2excel({
            exclude: ".noExl",
            name: "Excel Document Name",
            filename: "SolicitudesRepruebasGNV",
            fileext: ".xls",
            exclude_img: true,
            exclude_links: true,
            exclude_inputs: true
        });
        
}

function verificarUsuarioOsinergmin() {

    $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/verificarUsuarioOsinergmin",
        type:'post',
        async:false,
        data:{
            idUnidadSupervisada : idunidadSupervisadaAux,
        },
        beforeSend:muestraLoading,
        success:function(data){
            
            ocultaLoading();

            $.each(data.filas, function( index, value ) {
                codigoOsinergminAux = value.codigoOsinergminUnidadSupervisada;
            });
            
        },
        error:errorAjax
    });
}

function listarRepruebas(flg_load,idunidadSupervisadaAux) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorRepruebas").html("");
    
    var grid = $("<table>", {
        "id": "gridEmpAcred"
    });
    
    var pager = $("<div>", {
        "id": "paginacionEmpAcred"
    });
    
    $("#gridContenedorRepruebas").append(grid).append(pager);
    
    var nombres = ['','','','','','','Nº REPRUEBA','EMPRESA','MODULO','CILINDRO','ESTADO','FECHA DE CREACIÓN', 'FECHA PROGRAMADA', 'FECHA DE SOLICITUD', 'FECHA DE CERTIFICADO','RESULTADO','OPCIÓN'];
    var columnas = [
    	{name: "idCilindroGNV",width: 0, sortable: false, hidden: true, align: "left"},
        {name: "idResultadoPruebaReprueba",width: 0, sortable: false, hidden: true, align: "left"},
        {name: "numeroSerie",width: 0, sortable: false, hidden: true, align: "left"},
        {name: "idSolicitudPruebaReprueba",width: 0, sortable: false, hidden: true, align: "left"},
        {name: "idUnidSupervModulo",width: 0, sortable: false, hidden: true, align: "left"},
        {name: "idEmpresaAcreditada",width: 0, sortable: false, hidden: true, align: "left"},
    	{name: "nroSolicitudUnidadSupervisa",width: 195, sortable: false, hidden: false, align: "left"},
    	{name: "empresaAcreditada",width: 200, sortable: false, hidden: false, align: "left"},
    	{name: "modulo",width: 50, sortable: false, hidden: false, align: "left"},
    	{name: "cilindro",width: 50, sortable: false, align: "left"},
        {name: "estado",width: 105, sortable: false, hidden: false, align: "left", formatter: "fmtEstado"},
        {name: "fechaCreacion",width: 95, sortable: false, hidden: false, align: "left", formatter: "fmtFecha"},
        {name: "fechaSolicitud",width: 95, sortable: false, hidden: false, align: "left", formatter: "fmtFechaP"},
        {name: "fechaInicio",width: 95, sortable: false, hidden: false, align: "left", formatter: "fmtFechaR"},
        {name: "fechaFin", width: 95, sortable: false, hidden: false, align: "left", formatter: "fmtFechaFin"},
        {name: "resultadoPrueba",width: 90, sortable: false, hidden: false, align: "left", formatter:"fmtEstadoOP"},
        {name: "opcion",width: 197, sortable: false, hidden: false, align: "center", formatter:"Opciones"} 
     ];
    
    var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
    
    var buscaEstado;
    var buscaEstado2;
    
            if (id_option == 1){
            	var buscaNumeroRep = $("#txtFiltroBusqueda").val();}else{
    		if (id_option == 2){
    			var buscaNombreEmp = $("#txtFiltroBusqueda").val();}else{
			
    	    		
    	    if ( $("#cmbTipoEstado").val() > 0 ) {
                var buscaEstado ;
                if ( $("#cmbTipoEstado").val() == 1 )
                    buscaEstado = "P";
                if ( $("#cmbTipoEstado").val() == 2 ) 
                    buscaEstado = "R";
                if ( $("#cmbTipoEstado").val() == 3 ) 
                    buscaEstado = "C";
                if ( $("#cmbTipoEstado").val() == 4 ) 
                    buscaEstado = "E";
                if ( $("#cmbTipoEstado").val() == 5 ) 
                    buscaEstado = "F";
            }
    	    
    	    }}
    
    grid.jqGrid({
        url: baseURL + "pages/repruebasCilindroGNV/listarSolicitudPruebaReprueba",
        datatype: "json",
        postData: {
        	
        	idUnidSupervModulo: idunidadSupervisadaAux,
        	    numeroReprueba: buscaNumeroRep,
             empresaAcreditada: buscaNombreEmp,
                        estado: buscaEstado
        },
        hidegrid: false,     
        rowNum: 20,
        pager: "#paginacionEmpAcred",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "REPRUEBAS CILINDROS GNV",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idSolicitudPruebaReprueba"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            idAux = rowData.idSolicitudPruebaReprueba;
            estadoAux = rowData.estado;
            nombreEmpresa = rowData.razonSocial;
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    jQuery.extend($.fn.fmatter, {
        fmtFecha: function(cellvalue, options, rowdata) {
            var dateVar = rowdata.fechaCreacion;
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
                
                var fecha = ''
            }
            return fecha;             
        }
    }); 
    jQuery.extend($.fn.fmatter, {
        Opciones: function(cellvalue, options, rowdata) {
            var estado = rowdata.estado;
            var text = "";
            var fechaSolicitud="";
            
    		var dateVar = rowdata.fechaSolicitud;
    		var d=new Date(dateVar);
    		
    		if((d.getMonth()+1) < 10){
    			var mes = '0' + (d.getMonth() + 1);
    		}else{
    			var mes = d.getMonth() + 1;
    		}
    		
    		fechaSolicitud = d.getDate()  + '/' + mes + '/' + d.getFullYear();
    		
            var fechaA = new Date( rowdata.fechaSolicitud );

            var month = fechaA.getMonth()+1;
            var day = fechaA.getDate();

            var output =(day<10 ? '0' : '') + day + '/' +
                        (month<10 ? '0' : '') + month + '/' +    
                         fechaA.getFullYear();

            if (estado.toUpperCase() == "P" ||  estado.toUpperCase() =="R"){
               text = "<a class='Reprogramar' id='"+ rowdata.idSolicitudPruebaReprueba +"' style='cursor: pointer;text-decoration:none;' ><u> Reprogramar </u></a>&nbsp;&nbsp;"+
                      "<a class='Registrar' id='"+ rowdata.idUnidSupervModulo +"%"+ rowdata.idEmpresaAcreditada + "%"+ rowdata.empresaAcreditada + "%"+ rowdata.modulo + "%"+ rowdata.cilindro +"%"+ fechaSolicitud +"%"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.numeroSerie +"%"+ rowdata.idCilindroGNV +"' style='cursor: pointer;text-decoration:none;' ><u> Registrar </u></a>&nbsp;&nbsp;" +
                      "<a class='Cancelar' id='"+ rowdata.idSolicitudPruebaReprueba +"' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>";
            }
            
            if (estado.toUpperCase() == "E" ){
               text = "<a class='RegistrarE' id='"+ rowdata.idUnidSupervModulo +"%"+ rowdata.idEmpresaAcreditada + "%"+ rowdata.empresaAcreditada + "%"+ rowdata.modulo + "%"+ rowdata.cilindro +"%"+ fechaSolicitud +"%"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.numeroSerie +"%"+ rowdata.idCilindroGNV +"' style='cursor: pointer;text-decoration:none;' ><u> Registrar </u></a>&nbsp;&nbsp;" +
                      "<a class='ConsultarE' id='"+ rowdata.idUnidSupervModulo +"%"+ rowdata.idEmpresaAcreditada + "%"+ rowdata.empresaAcreditada + "%"+ rowdata.modulo + "%"+ rowdata.cilindro +"%"+ fechaSolicitud +"%"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.numeroSerie +"%"+ rowdata.idCilindroGNV +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
            }
            
            if (estado.toUpperCase() == "F" ){
                text = "<a class='ConsultarE' id='"+ rowdata.idUnidSupervModulo +"%"+ rowdata.idEmpresaAcreditada + "%"+ rowdata.empresaAcreditada + "%"+ rowdata.modulo + "%"+ rowdata.cilindro +"%"+ fechaSolicitud +"%"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.numeroSerie +"%"+ rowdata.idCilindroGNV +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
             }
            
            if (estado.toUpperCase() == 'C'){
               text = "<a class='Consultar' id='"+ rowdata.idSolicitudPruebaReprueba + "%" + rowdata.idEmpresaAcreditada + "%" + rowdata.modulo + "%" + rowdata.cilindro + "%" + output + "' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
            }
            return text;             
        }
    });

    jQuery.extend($.fn.fmatter, {
        fmtFechaP: function(cellvalue, options, rowdata) {
            var dateVar = rowdata.fechaSolicitud;
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
                
                var fecha = ''
            }
            return fecha;             
        }
    });

    jQuery.extend($.fn.fmatter, {
        fmtFechaFin: function(cellvalue, options, rowdata) {
            var dateVar = rowdata.fechaFin;
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
                
                var fecha = ''
            }
            return fecha;             
        }
    });

    jQuery.extend($.fn.fmatter, {
        fmtFechaR: function(cellvalue, options, rowdata) {
            var dateVar = rowdata.fechaInicio;
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
                
                var fecha = ''
            }
            return fecha;             
        }
    });

    jQuery.extend($.fn.fmatter, {
        fmtFechaC: function(cellvalue, options, rowdata) {
            var dateVar = rowdata.fechaCertificado;
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
                
                var fecha = ''
            }
            return fecha;             
        }
    });

    //Estado
    jQuery.extend($.fn.fmatter, {
        fmtEstado: function(cellvalue, options, rowdata) {
           var sel = rowdata.estado;
            var tex ='';
            
            if(sel.toUpperCase()=='P')
                tex='PROGRAMADO';
            if(sel.toUpperCase()=='R')
                tex='REPROGRAMADO';
            if(sel.toUpperCase()=='C')
                tex='CANCELADO' + '  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp';
            if(sel.toUpperCase()=='E')
                tex='EN REGISTRO' +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp';
            if(sel.toUpperCase()=='F')
                tex='FINALIZADO';
                        
            if( sel.toUpperCase() != 'P' && sel.toUpperCase() !='F')
                tex = tex +"<img src=\"" + baseURL + "/../images/info2.png\" class='Informe' id='"+ rowdata.idSolicitudPruebaReprueba +"'style=\"cursor: pointer; width: 16px; text-align: right;\" title=\"Informe\"/>" ;

            return tex;
        }
    });

    jQuery.extend($.fn.fmatter, {
        fmtEstadoOP: function(cellvalue, options, rowdata) {
            var sel = rowdata.resultadoPrueba;
            var tex ='';
            if (sel !== null){
                if(sel.toUpperCase()=='A')
                            tex='APROBADO' ;
                if(sel.toUpperCase()=='R')
                            tex='RECHAZADO';
                if(sel.toUpperCase()=='C')
                            tex='CONDENADO';
            }
        
            return tex;
            //+"<img src=\"" + baseURL + "/../images/info2.png\" class='Informe' id='"+ rowdata.idSolicitudPruebaReprueba +"'style=\"cursor: pointer; width: 16px; text-align: right;\" title=\"Informe\"/>" ;
        }
    });
}

function abrirFrmReprogramacionCancelacion(id, tipoOp){  
    var title = ""
    if(tipoOp == "R")
        title= "REPROGRAMAR SOLICITUD"
    if(tipoOp == "C")
        title= "CANCELAR SOLICITUD"
    $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/abrirFrmReprogramacionCancelacion", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
        ocultaLoading();
            
        $("#dialogFrmReprogramacionCancelacion").html(data);
            
        $("#dialogFrmReprogramacionCancelacion").dialog({
            resizable: false,
            draggable: true,
            autoOpen: true,
            height:"auto",
            width: "500",
            position: ['center', 'top+30'],
            modal: true,
            dialogClass: 'dialog',
            title: title,
            closeText: "Cerrar",
            open: function( event, ui ) {
                verificarDatos(id, tipoOp);
            },
        });
                
        },
            
        error:errorAjax
    });
} //

function abrirFrmRegistroSolicitudRepruebaGNV(idSolicitudPruebaReprueba, idEmpresaAcreditada, modulo, cilindro, fechaSolicitud){  
    var title = "";  
    if ( idSolicitudPruebaReprueba == "" )
        title= "REGISTRO SOLICITUD DE REPRUEBA CILINDRO GNV";
    if ( idSolicitudPruebaReprueba !== "" && idSolicitudPruebaReprueba !== undefined)
        title= "CONSULTA SOLICITUD DE REPRUEBA CILINDRO GNV";
    $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/abrirFrmRegistroSolicitudRepruebaGNV", 
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
            width: "600",
            position: ['center', 'top+30'],
            modal: true,
            dialogClass: 'dialog',
            title: title,
            closeText: "Cerrar",
            open: function( event, ui ) {
                verificarDatosSolicitud(idSolicitudPruebaReprueba, idEmpresaAcreditada, codigoOsinergminAux, idunidadSupervisadaAux, modulo, cilindro, fechaSolicitud);
            },
        });
                
        },
            
        error:errorAjax
    });
}

function abrirFrmReprueba(numero){
	var title = "";
	 if(numero == 1)
		 title = "REPRUEBA DE CILINDROS DE GNV - REGISTRO DE RESULTADOS";
	 if(numero == 0)
		 title = "REPRUEBA DE CILINDROS DE GNV - CONSULTA DE RESULTADOS";
		 
	 $.ajax({
	        url:baseURL + "pages/repruebasCilindroGNV/abrirFrmRepruebaCilindrosGNV", 
	        type:'get',
	        async:false,
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	           
	            $("#dialogFrmReprueba").html(data);
	        
	            $("#dialogFrmReprueba").dialog({
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "950",
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