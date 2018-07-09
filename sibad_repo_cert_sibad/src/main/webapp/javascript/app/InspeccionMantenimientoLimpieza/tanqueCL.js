var letra ="";

$(function() {
	fechaActual();
	initInicioTanqueCL();
	initDialogs();
	consultarTanqueCL();
	$( "#txtFechaInicio" ).datepicker();
    $( "#txtFechaFin" ).datepicker();

});

 function initInicioTanqueCL(){ 
	confirm.start();
	$("#btnExportar").click(function(){
		pasarDatosTablaIML();
    });
	
	$('body').on('click', '.InformeEstado',function(){
	   
	  abrirInformacion();

		    var cadena = $(this).attr("id");
       var arrayCadena = cadena.split("%");
    	
    	var idProgramacion = arrayCadena[0];
    	        var estado = arrayCadena[1];
    	  var tipoRevision = arrayCadena[2];
    	        
    	consultarEstado(idProgramacion,estado,tipoRevision);
    	
	});
	
    $('#btnBuscar').click(function(){
    	
    	listarTanqueCL(0,0);
    });
    
    $('#btnPrueba').click(function(){
    	
    	abrirFrmDocumentoAdjunto();
    });
    
   $('#btnReprueba').click(function(){
	   
    	abrirFrmReprueba();
    });
    
   $('#btnNuevo').click(function(){
      
        abrirFrmIndivualMasiva();
    	
    	Rpt = 'HABILITAR';

    	var idAlmacenamiento = $("#idAlmacenamiento").val();
    	var codigoOsinergmin = $("#codigoOsinergmin").val();
    	var idUnidadSupervisada = $("#idUnidadSupervisada").val();

    	enviarValores(idAlmacenamiento,codigoOsinergmin,idUnidadSupervisada);
    	bloquearDesbloquearCampos(Rpt);
    	
    	$( "#button-id").children().addClass( "button-ok" );
    	$( "#registroRV").children().addClass( "button-ok" );
    	$( ".button-ok").css({display: "block"});
    	

    });
    
    $('body').on('click', '.Consultar',function(){
    	
    	abrirFrmIndivualMasiva();
    	
    	Rpt = 'DESHABILITAR';
    	
    	var cadena= $(this).attr("id");
    	var arrayCadena = cadena.split("%");
    	
    	var idProgramacion = arrayCadena[0];
    	var tipoProgramacion = arrayCadena[1];
    	var tipoRevision = arrayCadena[2];
    	var fechaProgramacion = arrayCadena[3];
    	var unidadAlmacenamiento = arrayCadena[4];
    	var idCompartimiento = arrayCadena[5];
    	var numeroSerie = arrayCadena[6];
    	
    	bloquearDesbloquearCampos(Rpt);
    	cargarCamposProgramacionIndividual(idProgramacion, tipoProgramacion, tipoRevision,fechaProgramacion,unidadAlmacenamiento,idCompartimiento,numeroSerie);

    });
    
    $('body').on('click', '.ConsultarC',function(){
    	
    	abrirFrmCancelar();
    	
    	Rpt = 'DESHABILITAR';
    	var idProgramacion= $(this).attr("id");

    	bloquearDesbloquearCamposCancelacion(Rpt);
    	cargarCamposCancelacion(idProgramacion);

    });
    
   $('body').on('click', '.ConsultarE',function(){
	   
	    letra ="C";
	    
	    abrirFrmRevision(letra);
	    
    	Rpt = 'DESHABILITAR';

    	var cadena= $(this).attr("id");
    	var arrayCadena = cadena.split("%");
    	
    	var idProgramacion = arrayCadena[0];
    	var numeroProgramacion= arrayCadena[1];
    	var unidadAlmacenamiento= arrayCadena[2];
    	var tipoRevision= arrayCadena[3];
    	var idCompartimiento= arrayCadena[4];
    	var idUnidadSupervisada= arrayCadena[5];
    	var idResultadoRevision= arrayCadena[6];
    	var fechaInicio= arrayCadena[7];
    	var fechaFin= arrayCadena[8];
    	var fechaProgramacion= arrayCadena[9];
    	var resultadoRevision= arrayCadena[10];    	
    	var fechaCreacion= arrayCadena[11];
    	
    	informacionResultadoRevision(idProgramacion,numeroProgramacion,unidadAlmacenamiento,tipoRevision,idCompartimiento,idUnidadSupervisada,idResultadoRevision,fechaInicio,fechaFin,fechaProgramacion,resultadoRevision,fechaCreacion);
    	bloquearDesbloquearCamposResultadoRevision(Rpt);
    });
    
   $('body').on('click', '.RegistrarE',function(){
   	
		letra ="R";
		
	    abrirFrmRevision(letra);
	   	
	   	estado = "EN_REGISTRO";
	
	   	var cadena= $(this).attr("id");
	   	var arrayCadena = cadena.split("%");
	   	
	   	var idProgramacion = arrayCadena[0];
	   	var numeroProgramacion= arrayCadena[1];
	   	var unidadAlmacenamiento= arrayCadena[2];
	   	var tipoRevision= arrayCadena[3];
	   	var idCompartimiento= arrayCadena[4];
	   	var idUnidadSupervisada= arrayCadena[5];
	   	var idResultadoRevision= arrayCadena[6];
	   	var fechaInicio= arrayCadena[7];
	   	var fechaFin= arrayCadena[8];
		var fechaProgramacion= arrayCadena[9];
		var resultadoRevision= arrayCadena[10];
    	var fechaCreacion= arrayCadena[11];
		var idPersonaJuridica= arrayCadena[12];
		var flagPersona= arrayCadena[13];
		
	   	informacionResultadoRevision(idProgramacion,numeroProgramacion,unidadAlmacenamiento,tipoRevision,idCompartimiento,idUnidadSupervisada,idResultadoRevision,fechaInicio,fechaFin,fechaProgramacion,resultadoRevision,fechaCreacion,estado,idPersonaJuridica,flagPersona);
	   	continuarRegistroResultadoRevision(estado,idResultadoRevision);
	   	
	   	$( "#button-id").children().addClass( "button-ok" );
		$( "#registroRV").children().addClass( "button-ok" );
	   	$(".button-ok").css({display: "block"});
	   	
    });

    $('body').on('click', '.Cancelar',function(){
		
    	abrirFrmCancelar();
    	
    	var cadena= $(this).attr("id");
    	var arrayCadena = cadena.split("%");
    	
    	    var idProgramacion = arrayCadena[0];
    	 var estadoCancelacion = arrayCadena[1];
    	var unidadSupervisadaC = arrayCadena[2];
    	 var fechaProgramacion = arrayCadena[3];
    	
    	enviarDatosFrmCancelacion(idProgramacion,estadoCancelacion,unidadSupervisadaC,fechaProgramacion);
    	
    	$( "#button-id").children().addClass( "button-ok" );
    	$( "#registroRV").children().addClass( "button-ok" );
    	$(".button-ok").css({display: "block"});

    });
    
    $('body').on('click', '.Reprogramar',function(){
		
    	abrirFrmReprogramar();
    	
    	var cadena= $(this).attr("id");
    	var arrayCadena = cadena.split("%");
    	
    	var idProgramacion       = arrayCadena[0];
    	var estadoReprogramacion = arrayCadena[1];
    	var IdUnidadSupervisada  = arrayCadena[2];
    	var idCompartimiento     = arrayCadena[3];
    	var tipoRevision         = arrayCadena[4];
    	var tipoProgramacion     = arrayCadena[5];
    	var numeroProgramacion   = arrayCadena[6];

    	enviarDatosFrmReprogramacion(idProgramacion,estadoReprogramacion,IdUnidadSupervisada,idCompartimiento,tipoRevision,tipoProgramacion,numeroProgramacion);

    	$("#button-id").children().addClass("button-ok");
    	$( "#registroRV").children().addClass( "button-ok" );
    	$(".button-ok").css({display: "block"});
    	
    });
    
    
    $('body').on('click', '.Registrar',function(){
		
    	letra ="R";
    	
    	abrirFrmRevision(letra);
    	
    	estado="NUEVO_REGISTRO";
    	
    	var cadena= $(this).attr("id");
    	var arrayCadena = cadena.split("%");
    	
    	var idProgramacion = arrayCadena[0];
    	var numeroProgramacion= arrayCadena[1];
    	var unidadAlmacenamiento= arrayCadena[2];
    	var tipoRevision= arrayCadena[3];
    	var idCompartimiento= arrayCadena[4];
    	var idUnidadSupervisada= arrayCadena[5];
    	var fechaProgramacion= arrayCadena[6];
    	var fechaCreacion= arrayCadena[7];


    	informacionProgramacion(idProgramacion,numeroProgramacion,unidadAlmacenamiento,tipoRevision,idCompartimiento,idUnidadSupervisada,fechaProgramacion,estado,fechaCreacion);
    	
    	$("#button-id").children().addClass("button-ok");
    	$( "#registroRV").children().addClass( "button-ok" );
    	$(".button-ok").css({display: "block"});
    	
    });
    
    $('#cmbTipoBusqueda').on('change', function() {
    	
    	var unidadSupervisada= $("#idUnidadSupervisada").val();
    	
    	var valorOption = $(this).val();
    	
    	if(valorOption == '5'){
    		
    		listarTanqueCL(0,unidadSupervisada);
    	}
    	   
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
        var fecha = '--/--/----';
    }
  
    return fecha;
} 

  function  CancelarProgramacion(idProgramacion,estado,motivo,observacion,fecProgramacion){

    var fecCancelacion = $( "#fechaActual" ).val();

       var valor1 = fecCancelacion.split("/");
		 	
		 	var d1 =  valor1[0];
		 	var m1 =  valor1[1];
		 	var a1 =  valor1[2];
		 	
		 	var fechaCancelacion = m1+"/"+d1+"/"+a1;
    
       var valor2 = fecProgramacion.split("/");
			 	
		 	var d2 =  valor2[0];
		 	var m2 =  valor2[1];
		 	var a2 =  valor2[2];
		 	
		 	var fechaProgramacion = m2+"/"+d2+"/"+a2;

	$.ajax({
	    url:baseURL + "pages/InspMantLimp/reprogramarCancelar",
	    type:'post',
	    async:false,
	    data:{
	    	
	    	idProgramacion : idProgramacion,
	    	        estado : estado,
	    	         fecha : fechaProgramacion,
	    },
	    beforeSend:muestraLoading,
	    success:function(data){
	        ocultaLoading();
	        
	        if(data.resultado=="0"){
	        	 
	        	 $.ajax({
	        	        url:baseURL + "pages/InspMantLimp/RegistrarTrazProgramacion",
	        	        type:'post',
	        	        async:false,
	        	        data:{
	        	        	
	        	        	idProgramacion : idProgramacion,
	        	        	        estado : estado,
	        	         fechaUltimoEstado : fechaCancelacion,
	        	                    motivo : motivo,
	        	               observacion : observacion,
	        	        },
	        	        beforeSend:muestraLoading,
	        	        success:function(data){
	        	            ocultaLoading();
	        	            if(data.resultado=="0"){
	        	            	        	            	
	        	            	var idUnidadSupervisada = $("#idUnidadSupervisada").val();

	        	                listarTanqueCL(0,idUnidadSupervisada);
	        	            }
	        	        },
	        	        error:errorAjax
	        		});	

	        }
	    },
	    error:errorAjax
	});	
		
  }
 
  function fechaActual(){
		
	    $( "#fechaActual" ).datepicker({
		    dateFormat: 'dd/mm/yy',
		    firstDay: 1
		}).datepicker("setDate", new Date());	
	} 

   function verificarProgramacionesVencidas(IdUnidadadSupervisada){	
	
	var fecActual = $( "#fechaActual" ).val();
	var valor1 = fecActual.split("/");
	
	var d =  valor1[0];
	var m =  valor1[1];
	var a =  valor1[2];
	
	var fechaActual = m+"/"+d+"/"+a;
	
	    $.ajax({
	        url:baseURL + "pages/InspMantLimp/verificarProgramacionesVencidas",
	        type:'post',
	        async:false,
	        data:{
	        	
	        	 idUnidadSupervisada: IdUnidadadSupervisada,
	        	         fechaActual: fechaActual, 	        	         
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();

	            $.each(data.filas, function( index, value ) {
	            	
	            	var dateVar = value.fechaProgramacion;
	        		var d=new Date(dateVar);
	        		
	        		if((d.getMonth()+1) < 10){
	        			var mes = '0' + (d.getMonth() + 1);
	        		}else{
	        			var mes = d.getMonth() + 1;
	        		}
	            	 
	            	var idProgramacion = value.idProgramacion;
	            	        var estado  = 'C';
	            	        var motivo  = "1522";
	            	   var observacion  = "Por vencimiento de la programacion ";
	               var fecProgramacion  = d.getDate()  + '/' + mes + '/' + d.getFullYear();
	            	
	            	   CancelarProgramacion(idProgramacion,estado,motivo,observacion,fecProgramacion);

	            });
	            
	        },
	        error:errorAjax
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
	        		
	        		 $("#idUnidadSupervisada").val(value.idUnidadSupervisada);
	        		 
	        		 var IdUnidadadSupervisada= value.idUnidadSupervisada;
	        		 
	        		 listarTanqueCL(0,IdUnidadadSupervisada);
	        		 verificarProgramacionesVencidas(IdUnidadadSupervisada);
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
	        		        			  
	        		        			  /*var addhtml2 = 'Cuenta con tanques CL';
		        						  $("#dialog-message-content").html(addhtml2);
		        						  $("#dialog-message").dialog("open");*/
		        						  
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
				'Ok' : {
			        text : 'Ok',
			        id : 'button-id',
			        click : function(){
			        	$(this).dialog("close");
			        }
			    } 
			}
		});
	}
 
  function pasarDatosTablaIML(){

	  ListadoInsManLimEnTabla();

	    $('.jqgfirstrow').addClass('noExl');
	        
	    $('td[dir="ltr"]').attr ('class', 'noExl');

	    $("#tablitaIML").table2excel({
	        exclude: ".noExl",
	        name: "Excel Document Name",
	        filename: "ListadoProgramacionIML",
	        fileext: ".xls",
	        exclude_img: true,
	        exclude_links: true,
	        exclude_inputs: true
	    });  
	}
  
  function ListadoInsManLimEnTabla() {
		
	  //Filtro
	   var unidadAlmacenamiento = "";
	   var estado = "";
	   var numeroProgramacion = "";
	   var tipoRevision = "";
	    
	   var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
	   var id_option1 = document.getElementById("cmbEstadoPrincipal").selectedIndex;
	    
	        if (id_option == 1){
	    	     
	        	var sel1 = $("#txtFiltroBusqueda").val().toUpperCase();
	    	    
	             //alert(sel1);
	             if(sel1=='INSPECCION'){
	            	 tipoRevision='I';
	            	 //alert(tipoRevision);
	             }else if(sel1=='MANTENIMIENTO'){
	            	 tipoRevision='M';
	             
	             }else if(sel1=='LIMPIEZA'){
	             	
	            	 tipoRevision='L';	
	             }  
	             
	        }else{
				
	        	if (id_option == 2){
					 numeroProgramacion = $("#txtFiltroBusqueda").val().toUpperCase();
					
				}else{
					
					if (id_option == 3){
						 unidadAlmacenamiento = $("#txtFiltroBusqueda").val().toUpperCase();
						 
					}else{
						

				  }
			}
		 }
	  
	   if(id_option1==1){ 	
		   estado='P';
	   }else {
	    	
	    	if(id_option1==2){
	    		   estado='R';     
	    	 }else {
	    	    	
	    	      if(id_option1==3){
	    	    		   estado='C';    
	    	      }else {
	    	    	  
	    	    	  if(id_option1==4){
	   	    		   estado='E'; 
			   	      }else {
			   	    	 
			   	    	  if(id_option1==5){
			   	    		   estado='F';
					   	  }else {
		    
					   	 }	   	
			   	    	    
			   	      }	
	    	    	    
	    	      }	
	    	 }	
	    }	
	    //--------------------------------------
		
	    $.ajax({
	        url:baseURL + "pages/InspMantLimp/listarDatosProgramacionExcel",
	        type:'GET',
	        async:false,
	        data:{
	        	 idUnidadSupervisada: $("#idUnidadSupervisada").val(),
		                tipoRevision: tipoRevision,
		          numeroProgramacion: numeroProgramacion,
		        unidadAlmacenamiento: unidadAlmacenamiento,
		                      estado: estado
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            var tex ="<tr>";
	            tex = tex + "<th>Tipo_Revision</th>";
	            tex = tex + "<th>Nro_Programacion</th>";
	            tex = tex + "<th>Unidad_Almacenamiento</th>";
	            tex = tex + "<th>Compartimiento</th>";
	            tex = tex + "<th>Fecha_Programacion</th>";
	            tex = tex + "<th>Estado</th>";
	            tex = tex + "<th>Fecha_Inicio</th>";
	            tex = tex + "<th>Resultado</th>";
	            tex = tex + "</tr>";

	            ocultaLoading();
	            $.each(data.filas, function( index, value ) {
	            	
	            	var revision = "";
	                var estado = "";
	                var resultado = "";
	                
	                if(value.tipoRevision.toUpperCase()=='I'){
	                	revision ='Inspección';
	                }else if(value.tipoRevision.toUpperCase()=='M'){
	                	revision ='Mantenimiento';
	                }else if(value.tipoRevision.toUpperCase()=='L'){
	                	revision ='Limpieza';
	                }
	                
	                if(value.estado.toUpperCase()=='P')
	                    estado='Programado';
	                if(value.estado.toUpperCase()=='R')
	                    estado='Reprogramado';
	                if(value.estado.toUpperCase()=='C')
	                    estado='Cancelado';
	                if(value.estado.toUpperCase()=='E')
	                    estado='En Registro';
	                if(value.estado.toUpperCase()=='F')
	                    estado='Concluido / Finalizado';
	                
	                if(value.resultadoRevision !== ''){
	                	
	                	if(value.resultadoRevision == 'C'){
	                		resultado='Conforme';
	                   
	                    }else if(value.resultadoRevision == 'N'){
	                    	resultado='Tomar Acción';              
	                    }
	            
	                } else {
	                	
	                	resultado='';
	                }

	                tex = tex + "<tr>";
	                tex = tex + '<td>'+ revision +'</td>';
	                tex = tex + '<td>'+ value.numeroProgramacion +'</td>';
	                tex = tex + '<td>'+ value.unidadAlmacenamiento +'</td>';
	                tex = tex + '<td>'+ value.compartimiento +'</td>';
	                tex = tex + '<td>'+ convertirFecha( value.fechaProgramacion )+'</td>';
	                tex = tex + '<td>'+ estado +'</td>';
	                tex = tex + '<td>'+ convertirFecha( value.fechaInicio )+'</td>';
	                tex = tex + '<td>'+ resultado +'</td>';
	                tex = tex + "</tr>";
	                
	            });

	            $("#tablitaIML").append(tex);
	        },
	        error:errorAjax
	    });
	} 
  
  function listarTanqueCL(flg_load,idUnidadSupervisada) {
  //function listarTanqueCL(flg_load) {
	
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
    
    var nombres = ['','','','','','','','','','','TIPO DE REVISI&Oacute;N','N&deg; PROGRAMA','UNIDAD DE ALMACENAMIENTO','COMPARTIMIENTO', 'FECHA PROGRAMACI&Oacute;N', 'ESTADO', 'FECHA REGISTRO','RESULTADO','OPCI&Oacute;N'];
    var columnas = [
    	
    	{name: "fechaCreacion", width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "idProgramacion", width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "tipoProgramacion", width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "idResultadoRevision", width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "idCompartimiento", width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "numeroSerie", width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "idUnidadSupervisada", width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "flagPersona", width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "idPersonaJuridica", width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "fechaFin", width: 70, sortable: false, hidden: true, align: "center",formatter:"fmtFechaFin"},
    	{name: "tipoRevision", width: 60, sortable: false, hidden: false, align: "left",formatter:"fmtTipoRevision"},
        {name: "numeroProgramacion", width: 95, sortable: false, hidden: false, align: "left"},
        {name: "unidadAlmacenamiento", width: 80, sortable: false, hidden: false, align: "left",formatter:"fmtunidadAlmacenamiento"},
        {name: "compartimiento", width: 70, sortable: false, hidden: false, align: "left"},
        {name: "fechaProgramacion", width: 80, sortable: false, hidden: false, align: "center",formatter:"fmtFecha"},
        {name: "estado",width: 100, sortable: false, hidden: false, align: "center",formatter:"fmtEstado"},
        {name: "fechaFin", width: 70, sortable: false, hidden: false, align: "center",formatter:"fmtFechaFin"},
        {name: "resultadoRevision",width: 60, sortable: false, hidden: false, align: "center",formatter:"fmtResultadoRevision"},
        {name: "opcion",width: 250, sortable: false, hidden: false, align: "center", formatter:"Opciones"}
        
     ];
    
   var  unidadAlmacenamiento =0;
   var estado = '';
    
   var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
   var id_option1 = document.getElementById("cmbEstadoPrincipal").selectedIndex;
    
        if (id_option == 1){
    	     
        	var sel1 = $("#txtFiltroBusqueda").val().toUpperCase();
    	    var tipoRevision ='';
             //alert(sel1);
             if(sel1=='INSPECCION'){
            	 tipoRevision='I';
            	 //alert(tipoRevision);
             }else if(sel1=='MANTENIMIENTO'){
            	 tipoRevision='M';
             
             }else if(sel1=='LIMPIEZA'){
             	
            	 tipoRevision='L';	
             }  
             
        }else{
			
        	if (id_option == 2){
				var numeroProgramacion = $("#txtFiltroBusqueda").val().toUpperCase();
				
			}else{
				
				if (id_option == 3){
					 unidadAlmacenamiento = $("#txtFiltroBusqueda").val().toUpperCase();
					 
				}else{
					

			  }
		}
	 }
  
   if(id_option1==1){ 	
	   estado='P';
   }else {
    	
    	if(id_option1==2){
    		   estado='R';     
    	 }else {
    	    	
    	      if(id_option1==3){
    	    		   estado='C';    
    	      }else {
    	    	  
    	    	  if(id_option1==4){
   	    		   estado='E'; 
		   	      }else {
		   	    	 
		   	    	  if(id_option1==5){
		   	    		   estado='F';
				   	  }else {
	    
				   	 }	   	
		   	    	    
		   	      }	
    	    	    
    	      }	
    	 }	
    }	
    	
        
    grid.jqGrid({
        url: baseURL + "pages/InspMantLimp/listarProgramacion",
        datatype: "json",
        postData: {
                       flg_load: flg_load,
            idUnidadSupervisada: idUnidadSupervisada,
                   tipoRevision: tipoRevision,
             numeroProgramacion: numeroProgramacion,
           unidadAlmacenamiento: unidadAlmacenamiento,
                         estado: estado,
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
        caption: "Listado de Programación",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: ""
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    

    jQuery.extend($.fn.fmatter, {
    	fmtTipoRevision: function(cellvalue, options, rowdata) {
            var sel = rowdata.tipoRevision;
            var tex ='';
            
            if(sel=='I'){
            	tex='Inspección';
           
            }else if(sel=='M'){
            	tex='Mantenimiento';
            
            }else if(sel=='L'){
            	
            	tex='Limpieza';
            	
            }
            	            
            return tex;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtResultadoRevision: function(cellvalue, options, rowdata) {
    		
    		var sel = rowdata.resultadoRevision;
            var tex ='';

            if(sel){
            	
            	if(sel=='C'){
                	tex='Conforme';
               
                }else if(sel=='N'){
                	tex='Tomar Acción';              
                }
        
            } else {
            	
            	tex='';
            }
                    
            return tex;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtEstado: function(cellvalue, options, rowdata) {
           
    		var sel = rowdata.estado;
            var tex ='';
            
            if(sel=='P'){
            	tex='Programado';
           
            }else if(sel=='R'){
            	tex='Reprogramado'+" "+"<img src=\"" + baseURL + "/../images/info2.png\" class='InformeEstado' id='"+ rowdata.idProgramacion +"%"+ rowdata.estado+"%"+ rowdata.tipoRevision +"'style=\"cursor: pointer; width: 16px;\" title=\"Informe de Estado\"/>" ;;
            
            }else if(sel=='C'){
            	
            	tex='Cancelado'+" "+"<img src=\"" + baseURL + "/../images/info2.png\" class='InformeEstado' id='"+ rowdata.idProgramacion +"%"+ rowdata.estado+"%"+ rowdata.tipoRevision +"'style=\"cursor: pointer; width: 16px;\" title=\"Informe de Estado\"/>" ;;
            	
            }else if(sel=='E'){
            	
            	tex='En Registro'+" "+"<img src=\"" + baseURL + "/../images/info2.png\" class='InformeEstado' id='"+ rowdata.idProgramacion +"%"+ rowdata.estado+"%"+ rowdata.tipoRevision +"'style=\"cursor: pointer; width: 16px;\" title=\"Informe de Estado\"/>" ;;
            	
            }else if(sel=='F'){
            	
            	tex='Finalizado';
            }
            	            
            return tex; 
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtunidadAlmacenamiento: function(cellvalue, options, rowdata) {
            var num = rowdata.unidadAlmacenamiento;
            var tex ='';
            
            //tex = 'Tanque Nº'+ String("00000" + num).slice(-3);
            tex = 'Tanque Nº'+" "+ num;
            
            return tex;
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	Opciones: function(cellvalue, options, rowdata) {
    		
    		var estadoCancelacion="C";
    		var estadoReprogramacion="R";
    		
    		var fechaProgramacion="";
    		var dateVar = rowdata.fechaProgramacion;
    		var d=new Date(dateVar);
    		
    		if((d.getMonth()+1) < 10){
    			var mes = '0' + (d.getMonth() + 1);
    		}else{
    			var mes = d.getMonth() + 1;
    		}
    		
    		fechaProgramacion = d.getDate()  + '/' + mes + '/' + d.getFullYear();
    		
    		var fechaInicio="";
    		var dateVar = rowdata.fechaInicio;
    		var d1=new Date(dateVar);
    		
    		if((d1.getMonth()+1) < 10){
    			var mes = '0' + (d1.getMonth() + 1);
    		}else{
    			var mes = d1.getMonth() + 1;
    		}
    		
    		fechaInicio = d1.getDate()  + '/' + mes + '/' + d1.getFullYear();
    		
    		var fechaFin="";
    		var dateVar = rowdata.fechaFin;
    		var d2=new Date(dateVar);
    		
    		if((d2.getMonth()+1) < 10){
    			var mes = '0' + (d2.getMonth() + 1);
    		}else{
    			var mes = d2.getMonth() + 1;
    		}
    		
    		fechaFin = d2.getDate()  + '/' + mes + '/' + d2.getFullYear();
    		
    		var fechaCreacion="";
    		var dateVar = rowdata.fechaCreacion;
    		var d3=new Date(dateVar);
    		
    		if((d3.getMonth()+1) < 10){
    			var mes = '0' + (d3.getMonth() + 1);
    		}else{
    			var mes = d3.getMonth() + 1;
    		}
    		
    		fechaCreacion = d3.getDate()  + '/' + mes + '/' + d3.getFullYear();
    		
    		var num = rowdata.unidadAlmacenamiento;
            var unidadAlmacenamiento ='';
            
            unidadAlmacenamiento = 'Tanque Nº'+" "+ num; //'Tanque Nº'+ String("00000" + num).slice(-3);
               		
    		var sel = rowdata.estado;
    		
    		var tex ='';

    		
            if(sel=='P'){
            	
           	  tex = "<a class='Consultar' id='"+ rowdata.idProgramacion +"%"+ rowdata.tipoProgramacion +"%"+ rowdata.tipoRevision +"%"+ fechaProgramacion +"%"+ unidadAlmacenamiento +"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroSerie +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>"+"\t"+
     	 	        "<a class='Registrar' id='"+ rowdata.idProgramacion +"%"+ rowdata.numeroProgramacion +"%"+ unidadAlmacenamiento +"%"+ rowdata.tipoRevision +"%"+ rowdata.idCompartimiento +"%"+ rowdata.idUnidadSupervisada+"%"+  fechaProgramacion +"%"+ fechaCreacion + "' style='cursor: pointer;text-decoration:none;' ><u> Registrar </u></a>"+"\t"+
           	        "<a class='Cancelar' id='"+ rowdata.idProgramacion +"%"+ estadoCancelacion + "%"+ rowdata.idUnidadSupervisada+"%"+ fechaProgramacion+ "' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>"+"\t"+
           	 	    "<a class='Reprogramar' id='"+ rowdata.idProgramacion +"%"+ estadoReprogramacion + "%"+ rowdata.idUnidadSupervisada+"%"+ rowdata.idCompartimiento +"%"+ rowdata.tipoRevision +"%"+ rowdata.tipoProgramacion + "%"+ rowdata.numeroProgramacion +"' style='cursor: pointer;text-decoration:none;' ><u> Reprogramar </u></a>";
            } 
            
            if(sel=='R'){
            	
               tex = "<a class='Consultar' id='"+ rowdata.idProgramacion +"%"+ rowdata.tipoProgramacion +"%"+ rowdata.tipoRevision +"%"+ fechaProgramacion +"%"+ unidadAlmacenamiento +"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroSerie +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>"+"\t"+
	  	 	         "<a class='Registrar' id='"+ rowdata.idProgramacion + "%"+ rowdata.numeroProgramacion +"%"+ unidadAlmacenamiento +"%"+ rowdata.tipoRevision +"%"+ rowdata.idCompartimiento +"%"+ rowdata.idUnidadSupervisada+"%"+ fechaProgramacion +"%"+ fechaCreacion +"' style='cursor: pointer;text-decoration:none;' ><u> Registrar </u></a>"+"\t"+
	       	         "<a class='Cancelar' id='"+ rowdata.idProgramacion +"%"+ estadoCancelacion + "%"+ rowdata.idUnidadSupervisada+"%"+ fechaProgramacion+ "' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>"+"\t"+
       	 	         "<a class='Reprogramar' id='"+ rowdata.idProgramacion +"%"+ estadoReprogramacion + "%"+ rowdata.idUnidadSupervisada+"%"+ rowdata.idCompartimiento +"%"+ rowdata.tipoRevision +"%"+ rowdata.tipoProgramacion + "%"+ rowdata.numeroProgramacion +"' style='cursor: pointer;text-decoration:none;' ><u> Reprogramar </u></a>";
            } 
            
            if(sel=='E'){
                    
                tex = "<a class='RegistrarE' id='"+ rowdata.idProgramacion + "%"+ rowdata.numeroProgramacion +"%"+ unidadAlmacenamiento +"%"+ rowdata.tipoRevision +"%"+ rowdata.idCompartimiento +"%"+ rowdata.idUnidadSupervisada +"%"+ rowdata.idResultadoRevision+"%"+ fechaInicio+"%"+ fechaFin+"%"+ fechaProgramacion+"%" + rowdata.resultadoRevision + "%"+ fechaCreacion +"%"+ rowdata.idPersonaJuridica+"%"+ rowdata.flagPersona +"' style='cursor: pointer;text-decoration:none;' ><u> Registrar </u></a>"+"\t"+
                      "<a class='ConsultarE' id='"+ rowdata.idProgramacion + "%"+ rowdata.numeroProgramacion +"%"+ unidadAlmacenamiento +"%"+ rowdata.tipoRevision +"%"+ rowdata.idCompartimiento +"%"+ rowdata.idUnidadSupervisada +"%"+ rowdata.idResultadoRevision+"%"+ fechaInicio+"%"+ fechaFin+"%"+ fechaProgramacion+"%" + rowdata.resultadoRevision + "%"+ fechaCreacion +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
            }
            
            if(sel=='F'){
            	
            	tex = "<a class='ConsultarE' id='"+ rowdata.idProgramacion + "%"+ rowdata.numeroProgramacion +"%"+ unidadAlmacenamiento +"%"+ rowdata.tipoRevision +"%"+ rowdata.idCompartimiento +"%"+ rowdata.idUnidadSupervisada +"%"+ rowdata.idResultadoRevision+"%"+ fechaInicio+"%"+ fechaFin+"%"+ fechaProgramacion+"%" + rowdata.resultadoRevision + "%"+ fechaCreacion +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
    	    }
    
            if(sel=='C'){
            	
                 tex = "<a class='ConsultarC' id='"+ rowdata.idProgramacion +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
        	}
           
           return tex;
        }
    });

    jQuery.extend($.fn.fmatter, {
    	fmtFecha: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaProgramacion;
    		var d=new Date(dateVar);
    		
    		if((d.getMonth()+1) < 10){
    			var mes = '0' + (d.getMonth() + 1);
    		}else{
    			var mes = d.getMonth() + 1;
    		}
    		
    		var fecha = d.getDate()  + '-' + mes + '-' + d.getFullYear()
    		return fecha;
    		 
        }
    });
    
    //Fecha de Inicio
    jQuery.extend($.fn.fmatter, {
    	fmtFechaFin: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaFin;
            var d=new Date(dateVar);

            if(dateVar){
            	
	            if((d.getMonth()+1) < 10){
	    			var mes = '0' + (d.getMonth() + 1);
	    		} else {
	    			var mes = d.getMonth() + 1;
	    		}
	    		
	            var fecha = d.getDate()  + '-' + mes + '-' + d.getFullYear()
    		
            } else {
            	
            	var fecha= '';
    			
    		} 
    		
    		return fecha;
    		 
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaFin: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaFin;
            var d=new Date(dateVar);

            if(dateVar){
            	
	            if((d.getMonth()+1) < 10){
	    			var mes = '0' + (d.getMonth() + 1);
	    		} else {
	    			var mes = d.getMonth() + 1;
	    		}
	    		
	            var fecha = d.getDate() + '-' + mes + '-' + d.getFullYear()
    		
            } else {
            	
            	var fecha= '';
    			
    		} 
    		
    		return fecha;
    		 
        }
    });
 }
  
  
 function abrirInformacion(){ 
	    var title="INFORMACIÓN";
	    $.ajax({
	        url:baseURL + "pages/InspMantLimp/abrirConfirmarSolicitudGNV", 
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
	                    ///cargarDatos($.trim(estadoAux), idAux);
	                }
	            });
	        },
	        error:errorAjax
	    });
 }

 function abrirFrmReprueba(){
	 
	 $.ajax({
	        url:baseURL + "pages/InspMantLimp/abrirFrmRepruebaCilindrosGNV", 
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
	                title: "REPRUEBA DE CILINDROS DE GNV - REGISTRO DE RESULTADOS",
	                closeText: "Cerrar"
	            });
	            
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
 
 function abrirFrmCancelar(){
	 
	 $.ajax({
	        url:baseURL + "pages/InspMantLimp/abrirFrmCancelar", 
	        type:'get',
	        async:false,
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	           
	            $("#dialogFrmCancelacion").html(data);
	        
	            $("#dialogFrmCancelacion").dialog({
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "750",
	                position: ['center', 'top+30'],
	                modal: true,
	                dialogClass: 'dialog',
	                title: "CANCELAR INSP / MANT / LIMP",
	                closeText: "Cerrar"
	            });
	            
	        },
	        
	        error:errorAjax
	    });
 }
 
function abrirFrmReprogramar(){
	 
	 $.ajax({
	        url:baseURL + "pages/InspMantLimp/abrirFrmReprogramar", 
	        type:'get',
	        async:false,
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	           
	            $("#dialogFrmReprogramacion").html(data);
	        
	            $("#dialogFrmReprogramacion").dialog({
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "750",
	                position: ['center', 'top+30'],
	                modal: true,
	                dialogClass: 'dialog',
	                title: "REPROGRAMAR INSP / MANT / LIMP",
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
 
 function abrirFrmRevision(letra){ 
	 
		
	 if(letra == "R"){
		 
		 var titulo = "REGISTRO DE RESULTADO DE REVISIÓN";
		 
	 } else if(letra == "C"){
		 
		 var titulo = "CONSULTA DE RESULTADO DE REVISIÓN";
	 }
		 
	    $.ajax({
	        url:baseURL + "pages/InspMantLimp/abrirFrmRevision", 
	        type:'get',
	        async:false,
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	           
	            $("#dialogFrmRevision").html(data);
	        
	            $("#dialogFrmRevision").dialog({
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "850",
	                position: ['center', 'top+10'],
	                modal: true,
	                dialogClass: 'dialog',
	                title: titulo,
	                closeText: "Cerrar"
	            });
	            
	        },
	        
	        error:errorAjax
	    });
	 
}
