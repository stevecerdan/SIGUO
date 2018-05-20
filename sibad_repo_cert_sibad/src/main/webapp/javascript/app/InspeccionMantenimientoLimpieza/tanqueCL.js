$(function() {
	listarTanqueCL(0);
	initInicioTanqueCL();
	initDialogs();
	consultarTanqueCL();
	$( "#txtFechaInicio" ).datepicker();
    $( "#txtFechaFin" ).datepicker();
});

 function initInicioTanqueCL(){ 
	confirm.start();
	
    $('#btnBuscar').click(function(){
    	
    });
    
    $('#btnPrueba').click(function(){
    	
    	abrirFrmDocumentoAdjunto();

    });
    
    $('#btnNuevo').click(function(){
    	
    	abrirFrmIndivualMasiva();
    	
    	var idAlmacenamiento = $("#idAlmacenamiento").val();
    	var codigoOsinergmin = $("#codigoOsinergmin").val();
    	
    	enviarIdAlmacenamientoCodigoOsinergmin(idAlmacenamiento,codigoOsinergmin);
    	
    	
    });
    
    $('body').on('click', '.Reprogramar',function(){
		//letraEstado = "S";
		//var cadena= $(this).attr("id");
		//var arrayCadena = cadena.split("%");
		//var id = arrayCadena[0];
		//var idEmpresaAcreditada = arrayCadena[1];
		//estadoAux1 = "S";
		//estadoEmp = "A";
    	//abrirFrmEstadoAccion(id, estadoAux1, letraEstado,idEmpresaAcreditada,estadoEmp);
    	abrirFrmReprogramar();
    });
    
    $('body').on('click', '.Reprogramar',function(){
		//letraEstado = "S";
		//var cadena= $(this).attr("id");
		//var arrayCadena = cadena.split("%");
		//var id = arrayCadena[0];
		//var idEmpresaAcreditada = arrayCadena[1];
		//estadoAux1 = "S";
		//estadoEmp = "A";
    	//abrirFrmEstadoAccion(id, estadoAux1, letraEstado,idEmpresaAcreditada,estadoEmp);
    	abrirFrmCancelar();
    });
    
  }
  
  function consultarTanqueCL(){
	  
	   var codigo = $("#codigoOsinergmin").val();
	  
	    $.ajax({
	        url:baseURL + "pages/InspMantLimp/verificarUsuarioOsinergmin", 
	        type:'post',
	        async:false,
	        data:{
	        	codigoOsinergmin:codigo
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	 ocultaLoading();
	        	 
	        	 $.each(data.filas, function( index, value ) {
	        		
	        		 var IdUnidadadSupervisada= value.idUnidadSupervisada;
	        		  
	        		  $.ajax({
	        		        url:baseURL + "pages/InspMantLimp/verificarTanqueCL", 
	        		        type:'post',
	        		        async:false,
	        		        data:{
	        		        	idUnidadSupervisada:IdUnidadadSupervisada
	        		        },
	        		        beforeSend:muestraLoading,
	        		        success:function(data){
	        		        	 ocultaLoading();
	        		        	 
	        		        	 $.each(data.filas, function( index, value ) {
	        		        			        		        		  
	        		        		  if( value.idAlmacenamiento != ''){
	        		        			  
	        		        			  var addhtml2 = 'Cuenta con tanques CL';
		        						  $("#dialog-message-content").html(addhtml2);
		        						  $("#dialog-message").dialog("open");
		        						  
		        						  $("#idAlmacenamiento").val(value.idAlmacenamiento);
	        		        		  
	        		        		  } else {
	        		        			  
	        		        			  var addhtml2 = 'No existe información para programar';
		        						  $("#dialog-message-content").html(addhtml2);
		        						  $("#dialog-message").dialog("open");
	        		        		  }
	        		        		  
	        		        		});
	        		        },
	        		        error:errorAjax
	        		    });
	        		  
	        		});
	        },
	        error:errorAjax
	    });
  }
  
  function initDialogs() {
	  
	$("#dialog-message").dialog({
		modal : true,
		autoOpen : false,
		buttons : {
			Ok : function() {
				$(this).dialog("close");
			}
		}
	});
  }
  
  function listarTanqueCL(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridTanqueCL").html("");
    
    var grid = $("<table>", {
        "id": "gridTanqueCL"
    });
    
    var pager = $("<div>", {
        "id": "paginacionTanqueCL"
    });
    
    $("#gridTanqueCL").append(grid).append(pager);
    
    var nombres = ['TIPO DE REVISI&Oacute;N','N&deg; PROGRAMA','UNIDAD DE ALMACENAMIENTO','COMPARTIMIENTO', 'FECHA PROGRAMACI&Oacute;N', 'ESTADO', 'FECHA REGISTRO','RESULTADO','OPCI&Oacute;N'];
    var columnas = [
    	
        {name: "", width: 95, sortable: false, hidden: true, align: "left"},
        {name: "", width: 95, sortable: false, hidden: true, align: "left"},
        {name: "", width: 130, sortable: false, hidden: false, align: "left"},
        {name: "", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "", width: 80, sortable: false, hidden: false, align: "center"}, //,formatter:"fmtFecha"
        {name: "",width: 70, sortable: false, hidden: false, align: "center"},
        {name: "", width: 70, sortable: false, hidden: false, align: "center"},
        {name: "",width: 60, sortable: false, hidden: false, align: "center"},
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
        pager: "#paginacionTanqueCL",
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
    
    
    //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoNewEmpAcred: function(cellvalue, options, rowdata) {
            var sel = rowdata.estadoAlcance;
            var tex ='';
            if(sel=='A'){
            	tex='VIGENTE';
            }else{
            	if(sel=='I'){
            		tex='NO VIGENTE';
            	}else{
            		if(sel=='S'){
            			tex='SUSPENDIDO';
            		}else{
            			if(sel=='C'){
                			tex='CANCELADO';
                		}
            		}
            	}
            }
            return tex;
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	Opciones: function(cellvalue, options, rowdata) {
    		var sel = rowdata.estadoAlcance;
    		
    		var tex ='';
            
            if(sel=='A'){
           	 tex = "<a class='Consultar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>"+"\t"+
           	 	   "<a class='Reprogramar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Reprogramar </u></a>"+"\t"+
           	 	   "<a class='Cancelar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>";
           }
            if(sel=='S'){
            	tex= "<a class='Consultar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>"+"\t"+
           	 	   	 "<a class='Registrar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Registrar </u></a>"+"\t"+
           	 	   	 "<a class='Cancelar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>";
        	}
            if(sel=='I' || sel=='C'){
            	tex= "<a class='Consultar' id='"+ rowdata.idAlcanceAcreditacion +"%"+ rowdata.idEmpresaAcreditada +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
        	}
            return tex;
        }
    });
    
    //Fecha Programación
    jQuery.extend($.fn.fmatter, {
    	fmtFechaUA: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaUActualizacion;
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
    
  //Fecha Registro
    jQuery.extend($.fn.fmatter, {
    	fmtFechaA: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaAcreditacion;
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
  
 function abrirFrmReprogramar(){  
		
		var TB;
		
		if(letraEstado == "S"){
			TB="SUSPENDER PROCESO";
	   }
	    if(letraEstado == "H"){
	    	TB="HABILITAR PROCESO";
	    }
	    if(letraEstado == "C"){
	    	TB="CANCELAR PROCESO";
	    }
		
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirFrmEstadoAccion", 
	        type:'get',
	        async:false,
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            $("#dialogFrmReprogramar").html(data);
	        
	            $("#dialogFrmReprogramar").dialog({
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "500",
	                position: ['center', 'top+30'],
	                modal: true,
	                dialogClass: 'dialog',
	                title: TB,
	                closeText: "Cerrar"
	            });
	            //cargarMotivo(letraEstado);
	        },
	        
	        error:errorAjax
	    });
	}
 
 function abrirFrmIndivualMasiva(){  
		
	    $.ajax({
	        url:baseURL + "pages/InspMantLimp/abrirFrmIndivualMasiva", 
	        type:'get',
	        async:false,
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	           
	            $("#dialogFrmIndivualMasiva").html(data);
	        
	            $("#dialogFrmIndivualMasiva").dialog({
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "750",
	                position: ['center', 'top+30'],
	                modal: true,
	                dialogClass: 'dialog',
	                title: "PROGRAMACIÓN DE INSPECCIONES, MANTENIMIENTO Y LIMPIEZA",
	                closeText: "Cerrar"
	            });
	            
	        },
	        
	        error:errorAjax
	    });
	}
 
 function abrirFrmDocumentoAdjunto(){ 
	 
	    $.ajax({
	        url:baseURL + "pages/InspMantLimp/abrirFrmDocumentoAdjunto", 
	        type:'get',
	        async:false,
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	           
	            $("#dialogFrmPrueba").html(data);
	        
	            $("#dialogFrmPrueba").dialog({
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "750",
	                position: ['center', 'top+30'],
	                modal: true,
	                dialogClass: 'dialog',
	                title: "DOCUMENTO ADJUNTO",
	                closeText: "Cerrar"
	            });
	            
	        },
	        
	        error:errorAjax
	    });
	 
 }
