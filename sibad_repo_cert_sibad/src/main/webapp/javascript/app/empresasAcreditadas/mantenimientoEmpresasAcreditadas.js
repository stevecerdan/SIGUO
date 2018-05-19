var nombreEmpresa;
$(function() {
	listarEmpresasAcreditadas(0);
    initInicioEmpresasAcreditadas();  
});

function initInicioEmpresasAcreditadas(){ 
	confirm.start();
	
    $('#btnBuscarEmp').click(function(){
    	listarEmpresasAcreditadas();
    	//$("#cmbTipoBusqueda").val(0);
    	//$("#txtFiltroBusqueda").val('');
    });
    
    $('#btnNuevoEmp').click(function(){
    	abrirNuevaEmpresaAcreditada();
    });
    
    $("#btnExportar").click(function(e) {
        window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#gridContenedorEmpAcred').html()));
        e.preventDefault();
    });
    
    $('body').on('click', '.VerHistorial',function(){
    	tab('tab_02','panel_02');
    	$('#Titulo').html(nombreEmpresa);
    });
    
   /* $('body').on('click', '.EditarAlcance',function(){
    	
 	   var cadena= $(this).attr("id");
 	   
 	   var arrayCadena = cadena.split("%");
 	   
 	   var id = arrayCadena[0];
 	   var resolucionCedula = arrayCadena[1];
 	   var registro = arrayCadena[2];
 	   var idDocumentoAdjunto = arrayCadena[3];
 	   var idDocumentoAlcanceAcredita = arrayCadena[4];
 	   var normaEvaluada = arrayCadena[5];
 	   var idOrganismoAcreditador = arrayCadena[6];
 	   var fechaIVigencia = arrayCadena[7];
 	   var fechaUActualizacion = arrayCadena[8];  
 	   var fechaAcreditacion = arrayCadena[9];
 	   var fechaVencimiento = arrayCadena[10];
 	   var idTipoOrganismo = arrayCadena[11]; 
 	   var idTipoPrueba = arrayCadena[12];
 	   var estadoForm1 = arrayCadena[13];
 	   var idEmpresaAcreditada = arrayCadena[14];
 	  var idPrimerAlcanceAcreditacion = arrayCadena[15];
 	   
 	   if (id == '' || id == 'null'){
 		   
 		   id = '';
 	   
 	   } else {
 		   
 		   id =arrayCadena[0];
 		   
 	  }
 	   
       if (resolucionCedula == ''  || resolucionCedula == 'null'){
 		   
     	  resolucionCedula ='' ;
 	   
       } else {
 		   
     	  resolucionCedula =arrayCadena[1] ;
 		   
 	  }
       
       if (registro == '' || registro == 'null'){
 		   
     	  registro ='' ;
 	   
       } else {
 		   
     	  registro =arrayCadena[2];
 		   
 	  }
 		   

       if (idDocumentoAdjunto == '' || idDocumentoAdjunto == 'null'){
 		   
     	  idDocumentoAdjunto ='';
 	   
       } else {
 		   
     	  idDocumentoAdjunto = arrayCadena[3];
 		   
 	  } 
       
       if (idDocumentoAlcanceAcredita == '' || idDocumentoAlcanceAcredita == 'null'){
 		   
     	  idDocumentoAlcanceAcredita ='' ;
 	   
       } else {
 		   
     	  idDocumentoAlcanceAcredita = arrayCadena[4];
 		   
 	  } 
       
       if (normaEvaluada == '' || normaEvaluada == 'null'){
 		   
     	  normaEvaluada = '';
 	   
       } else {
 		   
     	  normaEvaluada =arrayCadena[5];
 		   
 	  } 
       
       if (idOrganismoAcreditador == '' || idOrganismoAcreditador == 'null'){
 		   
     	  idOrganismoAcreditador = '';
 	   
       } else {
 		   
     	  idOrganismoAcreditador =arrayCadena[6];
 		   
 	  } 
       
       if (fechaIVigencia == '' || fechaIVigencia == 'null'){
 		   
     	  fechaIVigencia = '';
 	   
       } else {
 		   
     	  fechaIVigencia =arrayCadena[7];
 		   
 	  } 
       
       if (fechaUActualizacion == '' || fechaUActualizacion == 'null'){
 		   
     	  fechaUActualizacion ='' ;
 	   
       } else {
 		   
     	  fechaUActualizacion = arrayCadena[8];
 		   
 	  } 
       
       if (fechaAcreditacion == '' || fechaAcreditacion == 'null'){
 		   
     	  fechaAcreditacion = '';
 	   
       } else {
 		   
     	  fechaAcreditacion =arrayCadena[9];
 		   
 	  } 
       
       if (fechaVencimiento == '' || fechaVencimiento == 'null'){
 		   
     	  fechaVencimiento = '';
 	   
       } else {
 		   
     	  fechaVencimiento =arrayCadena[10];
 		   
 	  } 
       
       if (idTipoOrganismo == '' || idTipoOrganismo == 'null'){
 		   
     	  idTipoOrganismo ='';
 	   
       } else {
 		   
     	  idTipoOrganismo = arrayCadena[11];
 		   
 	  } 
       
       if (idTipoPrueba == '' || idTipoPrueba == 'null'){
 		   
     	  idTipoPrueba ='' ;
 	   
       } else {
 		   
     	  idTipoPrueba =arrayCadena[12];
 		   
 	  }
       
       if (estadoForm1){
 		   
     	  estadoForm1 = arrayCadena[13];
 	   
       } 
       
       if (idPrimerAlcanceAcreditacion == '' || idPrimerAlcanceAcreditacion == 'null'){
 		   
      	  idPrimerAlcanceAcreditacion ='' ;
  	   
        } else {
  		   
      	  idPrimerAlcanceAcreditacion = arrayCadena[15];
  		   
  	  } 
       
 	   abrirAlcanceAcreditacion();
 	   cargarDatosAlcance(id,resolucionCedula,registro,idDocumentoAdjunto,idDocumentoAlcanceAcredita,normaEvaluada,idOrganismoAcreditador,fechaIVigencia,fechaUActualizacion,fechaAcreditacion,fechaVencimiento,idTipoOrganismo,idTipoPrueba,estadoForm1,idEmpresaAcreditada,idPrimerAlcanceAcreditacion);
 	   //---- desploquear combo tipo organismo
 	   var text = $("#cmbTipoPrueba option:selected").text();
		
		if(text=="PRUEBA DE HERMETICIDAD"){
			$("#cmbTipoOrganismo").removeAttr('disabled');
		}else{
			$("#cmbTipoOrganismo").val(0);
			$("#cmbTipoOrganismo").attr('disabled','disabled');
		}
		//-------------------------
		if($('#txtAdjuntarArchivo').val()!=''){
			listarDocumentoAdjuntoAA();
			bloquearItemsDocumentoAdjunto();
		}
		if($('#txtAdjuntarAlcance').val()!=''){
			listarDocumentoAlcanceAA();
			$("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:750px;');
			bloquearItemsAlcanceAdjunto();
		}
		//
		//-------------------------
		$("#MensajeFECHA").hide();
		$("#txtFechaUA").attr('disabled','disabled');
		$("#txtFechaA").attr('disabled','disabled');
		
		$("#MensajeAS").hide();
		listarSedes();
		$("#MensajeAI").hide();
		listarInspector();
		$("#MensajeAE").hide();
		listarEquipo();
		
		activarBotonesSIE();
		$("#btnRegresarAlcance").attr('disabled','disabled');
		$("#btnRegresarAlcance").attr('style','background-color:#60869a');
     });*/
    

    
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
        
       abrirNuevaEmpresaAcreditada();
  	   cargarDatosEmpresaAcreditada(id,ruc);
      });
     
 }

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
    
    var nombres = ['ID EMPRESA ACREDITADA','N°','RUC','NOMBRE EMPRESAS ACREDITADAS','DIRECCI&Oacute;N', 'dpto', 'prov', 'dist','UBIGEO','TELEFONO/FAX','email','web','EMAIL/WEB','N° CEDULA/N° RESOLUCI&Oacute;N','VIGENCIA','TIPO DE ORGANISMO','REGISTRO N°','ESTADO','OPCI&Oacute;N'];
    var columnas = [
    	//{name: "idAlcanceAcreditacion",width: 30, sortable: false, hidden: false, align: "center"},
    	{name: "idEmpresaAcreditada",width: 30, sortable: false, hidden: true, align: "center"},
    	{name: "n",width: 30, sortable: false, hidden: false, align: "center", formatter:"NumeroFilas"},
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
        {name: "fechaVencimiento", width: 80, sortable: false, hidden: false, align: "center", formatter:"fmtFecha"},
        {name: "tipoOrganismo",width: 70, sortable: false, hidden: false, align: "center"},
        {name: "registro", width: 70, sortable: false, hidden: false, align: "center"},
        {name: "estadoAlcance",width: 60, sortable: false, hidden: false, align: "center", formatter:"fmtEstadoEmpAcred"},
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
    	    	var buscaDistrito = $("#txtFiltroBusqueda").val();}
    	    }}}}
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
            distrito: buscaDistrito
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 5,
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
            if(sel=="A" || sel =="S"){
            	tex='VIGENTE';
            }else{
            	tex='NO VIGENTE';
            }
            return tex;
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
/*
function abrirAlcanceAcreditacion(){ 
	
	var title="ALCANCE ACREDITACIÓN";
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirNuevoAlcanceAcreditacion", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogProcesoAcreditacion1").html(data);
            $("#dialogProcesoAcreditacion1").dialog({
            	position: ['center', 'top+2'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "1120",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        },
        error:errorAjax
    });
}
*/
