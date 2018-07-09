var nombreEmpresa;
var idUniSup = "";
var CodUniSup = "";
$(function() {
	listarBandejaPruebaHermeticidad(0);
	//listarBandejaInformeIndiceRiesgo(0);
    initInicioBandejaPruebaHermeticidad();  
});

function initInicioBandejaPruebaHermeticidad(){ 
	confirm.start();
	encontrarUnidadSupervisada();
	$("#cmbEstadoPHPrincipal").attr('disabled','disabled');
	$("#txtBusqueda").attr('disabled','disabled');
	
    $('#btnBuscarSolicitud').click(function(){
    	listarBandejaPruebaHermeticidad();
    });
    
    $('#btnBuscarInfoR').click(function(){
    	listarBandejaInformeIndiceRiesgo();
    });
    
    $('#btnNuevoInforme').click(function(){
    	abrirFrmIndiceRiesgo();

    	 var Rpt = "DESHABILITAR";
    	 var estado = "NUEVO";
    	 
    	 var idInformeIndiceRiesgo = "";
    	 
     	 estadoRegistro(estado, idInformeIndiceRiesgo); 
     	 
    	$( "#button-id").children().addClass( "button-ok" );
    	$( "#registroRV").children().addClass( "button-ok" );
    	$( ".button-ok").css({display: "block"});
    });
    
    $("#tab_02").click(function() {
    	$("#panelN2").show();
    	listarBandejaInformeIndiceRiesgo(0);
    });
        
    $('#cmbTipoBusqueda').change(function(){
		
    	var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
    	
    	if(id_option == 0){
    		$("#txtBusqueda").val("");
    		$("#txtBusqueda").attr('disabled','disabled');
    		$("#cmbEstadoPHPrincipal").append('<option value="0">--Seleccione--</option>');
        	$("#cmbEstadoPHPrincipal").attr('disabled','disabled');
    	}
        
        if (id_option == 1){
        	$("#txtBusqueda").removeAttr('disabled');
        	$("#cmbEstadoPHPrincipal").val(0);
        	$("#cmbEstadoPHPrincipal").empty();
        	$("#cmbEstadoPHPrincipal").append('<option value="0">--Seleccione--</option>');
        	$("#cmbEstadoPHPrincipal").attr('disabled','disabled');}else{
        		if (id_option == 2){
        			$("#txtBusqueda").removeAttr('disabled');
        			$("#cmbEstadoPHPrincipal").val(0);
        			$("#cmbEstadoPHPrincipal").empty();
        			$("#cmbEstadoPHPrincipal").append('<option value="0">--Seleccione--</option>');
        			$("#cmbEstadoPHPrincipal").attr('disabled','disabled');}else{
    			if (id_option == 3){
    				$("#txtBusqueda").val('');
    				$("#txtBusqueda").attr('disabled','disabled');
    				$("#cmbEstadoPHPrincipal").removeAttr('disabled');
    				$("#cmbEstadoPHPrincipal").val(0);
    				$("#cmbEstadoPHPrincipal").empty();
    				$("#cmbEstadoPHPrincipal").append('<option value="0">--Seleccione--</option>');
    				$("#cmbEstadoPHPrincipal").append('<option value="1">PROGRAMADO</option>');
    				$("#cmbEstadoPHPrincipal").append('<option value="2">REPROGRAMADO</option>');
    				$("#cmbEstadoPHPrincipal").append('<option value="3">CANCELADO</option>');
    				$("#cmbEstadoPHPrincipal").append('<option value="4">EN REGISTRO</option>');
    				$("#cmbEstadoPHPrincipal").append('<option value="5">CONCLUIDO</option>');
    				}else{
    					if (id_option == 4){
    						$("#txtBusqueda").val('');
    						$("#txtBusqueda").attr('disabled','disabled');
    	    				$("#cmbEstadoPHPrincipal").removeAttr('disabled');
    	    				$("#cmbEstadoPHPrincipal").val(0);
    	    				$("#cmbEstadoPHPrincipal").empty();
    	    				$("#cmbEstadoPHPrincipal").append('<option value="0">--Seleccione--</option>');
    	    				$("#cmbEstadoPHPrincipal").append('<option value="1">CONFORME</option>');
    	    				$("#cmbEstadoPHPrincipal").append('<option value="2">TOMAR ACCION</option>');
    					}else{
    						if (id_option == 5){
    							$("#txtBusqueda").val('');
        						$("#txtBusqueda").attr('disabled','disabled');
        						$("#cmbEstadoPHPrincipal").val(0);
        						$("#cmbEstadoPHPrincipal").empty();
        						$("#cmbEstadoPHPrincipal").append('<option value="0">--Seleccione--</option>');
        						$("#cmbEstadoPHPrincipal").attr('disabled','disabled');
        						
    						}
    					}
    				}
    			}
    		}
		
	});
	
	$('#txtFechaIV').click(function(){
		$("#MensajeFECHA").hide();
		$("#MensajeValA").hide();
	});
    
    $('#btnSolicitud').click(function(){
    	idUniSup = $('#UnidadSupervisada').val();
    	CodUniSup = $("#CodigoOsinergmin").val();
    	abrirNuevaPruebaHermeticidad(idUniSup, CodUniSup);
    });
    
   $("#btnExportar").click(function(e) {
	   
	   pasarDatosTabla();
		
    });
   
    $('body').on('click', '.ConsultarIdInformeIndiceRiesgo',function(){
 	   
    	 abrirFrmIndiceRiesgo();
    	
    	    var Rpt = "DESHABILITAR";
    	 var estado = "CONSULTAR";
    	 
    	 var idInformeIndiceRiesgo= $(this).attr("id");
    	 
     	 bloquearDesbloquearCampos(Rpt);
     	 estadoRegistro(estado, idInformeIndiceRiesgo);   
    });
    
    $('body').on('click', '.Consultar',function(){
    
	   var cadena= $(this).attr("id");
 	   
 	   var arrayCadena = cadena.split("%");
 	   
 	   var idCompartimiento = arrayCadena[0];
 	   var empresaAcreditada = arrayCadena[1];
 	   var fechaSolicitud = arrayCadena[2];
 	   var fechaCreacion = arrayCadena[3];
 	   var estado = arrayCadena[4];
 	   
 	   if (idCompartimiento == '' || idCompartimiento == 'null'){idCompartimiento = '';
 	   } else {idCompartimiento =arrayCadena[0];}
 	   
       if (empresaAcreditada == ''  || empresaAcreditada == 'null'){empresaAcreditada ='' ;
       } else {empresaAcreditada =arrayCadena[1] ;}
       
       if (fechaSolicitud == '' || fechaSolicitud == 'null'){fechaSolicitud ='';
       } else {fechaSolicitud = arrayCadena[2];} 
       
       if (fechaCreacion == '' || fechaCreacion == 'null'){fechaCreacion ='' ;
       } else {fechaCreacion = arrayCadena[3];} 
       
       if (estado == '' || estado == 'null'){estado = '';
       } else {estado =arrayCadena[4];} 
       
 	   abrirAuxPruebaHermeticidad();
 	   cargarConsultarDatosPruebaHermeticidad(idCompartimiento,empresaAcreditada,fechaSolicitud,fechaCreacion,estado);
	 	   
    });
    
    $('body').on('click', '.ReprogramarS',function(){
        var tipoOpcion = "R";
        var id = $(this).attr("id");
        abrirFrmReprogramarCancelar(id, tipoOpcion);
    });

    $('body').on('click', '.CancelarS',function(){
        var tipoOpcion = "C";
        var id = $(this).attr("id");
        abrirFrmReprogramarCancelar(id, tipoOpcion);
    });
    
    $('body').on('click', '.Informe',function(){
		
		   var cadena= $(this).attr("id");
	 	   
	 	   var arrayCadena = cadena.split("%");
	 	   
	 	   var idResultadoPruebaReprueba = arrayCadena[0];
	 	   var fechaProxPrueba = arrayCadena[1];
	 	   
	 	   
	 	   if (idResultadoPruebaReprueba == '' || idResultadoPruebaReprueba == 'null'){idResultadoPruebaReprueba = '';
	 	   } else {idResultadoPruebaReprueba =arrayCadena[0];}
	 	   
	       if (fechaProxPrueba == ''  || fechaProxPrueba == 'null'){fechaProxPrueba ='' ;
	       } else {fechaProxPrueba =arrayCadena[1] ;}
	       
	 	   abrirInformeIndiceRiesgos();
	 	   cargarInformePruebaHermeticidad(idResultadoPruebaReprueba,fechaProxPrueba);
	 	   
    });
    
    $('body').on('click', '.VerResultado',function(){
        var cadena= $(this).attr("id");
        var arrayCadena = cadena.split("%");
        var estado = "VRESULTADO";

        var idResultadoPruebaReprueba = arrayCadena[0];
        var idEmpresaAcreditada = arrayCadena[1];
        var idCompartimiento = arrayCadena[2];
        var numeroCompartimiento = arrayCadena[3];
        var numeroTanque = arrayCadena[4];
        var fInicio = arrayCadena[5];
        var resultadoPrueba = arrayCadena[6];
        var idUnidSupervTanque = arrayCadena[7];

        abrirFrmResultadoPruebaHermeticidadAux(idResultadoPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,fInicio,resultadoPrueba,idUnidSupervTanque,estado);
        
    });
    
    $('body').on('click', '.InformeES',function(){
    	
       var cadena= $(this).attr("id");
   	   
   	   var arrayCadena = cadena.split("%");
   	   
   	   var id = arrayCadena[0];
   	   var estado = arrayCadena[1];
   	   
   	   abrirInformacionEstado();
   	   cargarDatosInformacionEstado(id,estado);
   	   
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
                
        var fecha = dia + '/' + mes + '/' + d.getFullYear();
                
    }else{
        var fecha = '--/--/----';
    }
  
    return fecha;
}

function abrirFrmResultadoPruebaHermeticidadAux(idResultadoPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,fInicio,resultadoPrueba,idUnidSupervTanque,estado){
    
    $.ajax({
           url:baseURL + "pages/resultadosPruebasHermeticidad/abrirFrmResultadoPruebaHermeticidad", 
           type:'get',
           async:false,
           beforeSend:muestraLoading,
           success:function(data){
               ocultaLoading();
              
           $("#dialogVerResultadoPH").html(data);
       
           $("#dialogVerResultadoPH").dialog({
           
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

function abrirNuevaPruebaHermeticidad(idUniSup){
	var title="PRUEBA DE HERMETICIDAD";
	$.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/abrirNuevaPruebaHermeticidad", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogSolicitudPruebaHermeticidad").html(data);
            $("#dialogSolicitudPruebaHermeticidad").dialog({          	
            	position: { my: 'top', at: 'top+20' },
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "800",
                modal: true,
                dialogClass: 'dialog',	
                title: title,
                closeText:"Cerrar"
            });            
        },
        error:errorAjax
    });
	TraerIdUnidadSupervisada(idUniSup, CodUniSup);
}

function abrirAuxPruebaHermeticidad(){
	var title="CONSULTA DE SOLICITUD DE PRUEBA DE HERMETICIDAD";
	$.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/abrirNuevaPruebaHermeticidad", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogSolicitudPruebaHermeticidad2").html(data);
            $("#dialogSolicitudPruebaHermeticidad2").dialog({          	
            	position: { my: 'top', at: 'top+20' },
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "800",
                modal: true,
                dialogClass: 'dialog',	
                title: title,
                closeText:"Cerrar"
            });            
        },
        error:errorAjax
    });
}

function abrirInformeIndiceRiesgos(){
	var title="INFORME DE ÍNDICE DE RIESGOS Y FECHA PRÓXIMA PRUEBA";
	$.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/abrirInformeIndiceRiesgos", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogInformeIndiceRiesgos").html(data);
            $("#dialogInformeIndiceRiesgos").dialog({          	
            	position: { my: 'top', at: 'top+20' },
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "500",
                modal: true,
                dialogClass: 'dialog',	
                title: title,
                closeText:"Cerrar"
            });            
        },
        error:errorAjax
    });
}

function abrirInformacionEstado(){ 
	
	var title="INFORMACION - ESTADO DE LA SOLICITUD DE PRUEBA DE HERMETICIDAD";
    $.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/abrirInformacionEstado", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogInfoEstado").html(data);
            $("#dialogInfoEstado").dialog({
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

//----- ENCONTRAR UNIDAD SUPERVISADA ----------
function encontrarUnidadSupervisada() {

    $.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/encontrarUnidadSupervisada",
        type:'post',
        async:false,
        data:{
            idUnidadSupervisada :$('#UnidadSupervisada').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            $.each(data.filas, function( index, value ) {
            	$("#CodigoOsinergmin").val(value.codigoOsinergminUnidadSupervisada);
            });
            
        },
        error:errorAjax
    });
}

function pasarDatosTabla(){

	SolicitudesPruebasHermeticidadEnTabla();

    $('.jqgfirstrow').addClass('noExl');
        
    $('td[dir="ltr"]').attr ('class', 'noExl');

    $("#tablitaPH").table2excel({
        exclude: ".noExl",
        name: "Excel Document Name",
        filename: "SolicitudesPruebaHermeticidad",
        fileext: ".xls",
        exclude_img: true,
        exclude_links: true,
        exclude_inputs: true
    });  
}

function SolicitudesPruebasHermeticidadEnTabla() {
	
	//Filtro
	var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
    var id_option2 = document.getElementById("cmbEstadoPHPrincipal").selectedIndex;
    var buscaNSolicitud = "";
    var buscaEmpresa = "";
    var buscaEstado = "";
    var buscaResultado = "";
    
    if (id_option == 1){
    	buscaNSolicitud = $("#txtBusqueda").val();}else{
    		if (id_option == 2){
    			buscaEmpresa = $("#txtBusqueda").val();}else{
    				if (id_option == 3){
    					buscaNSolicitud = "";
    				    buscaEmpresa = "";
    				    buscaResultado = "";
    				}else{
    					if (id_option == 4){
        					buscaNSolicitud = "";
        				    buscaEmpresa = "";
        				    buscaEstado = "";
        				}else{
        					if (id_option == 5){
            					buscaNSolicitud = "";
            				    buscaEmpresa = "";
            				    buscaEstado = "";
            				    buscaResultado = "";
            				}
        				}
    				}
    			}
		}
    
    if (id_option == 3 && id_option2 == 1){
    	buscaEstado = "P";
	}else{
		if (id_option == 3 && id_option2 == 2){
	    	buscaEstado = "R";
		}else{
			if (id_option == 3 && id_option2 == 3){
		    	buscaEstado = "C";
			}else{
				if (id_option == 3 && id_option2 == 4){
			    	buscaEstado = "E";
				}else{
					if (id_option == 3 && id_option2 == 5){
				    	buscaEstado = "F";
					}
				}
			}
		}
	}
    
    if (id_option == 4 && id_option2 == 1){
    	buscaResultado = "A";
	}else{
		if (id_option == 4 && id_option2 == 2){
	    	buscaResultado = "N";
		}
	}
    //--------------------------------------
	
    $.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/listarPruebaHermeticidad",
        type:'GET',
        async:false,
        data:{
        	resultadoPrueba :buscaResultado,
            idUnidSupervTanque :$('#UnidadSupervisada').val(),
            nroSolicitudUnidadSupervisa :buscaNSolicitud,
            empresaAcreditada :buscaEmpresa,
            estado :buscaEstado
        },
        beforeSend:muestraLoading,
        success:function(data){
            var tex ="<tr>";
            tex = tex + "<th>Nro_Solicitud_Unidad_Supervisada</th>";
            tex = tex + "<th>Empresa_Acreditada</th>";
            tex = tex + "<th>Nro_Tanque</th>";
            tex = tex + "<th>Nro_Compartimiento</th>";
            tex = tex + "<th>Estado</th>";
            tex = tex + "<th>Fecha_Creacion</th>";
            tex = tex + "<th>Fecha_Solicitud</th>";
            tex = tex + "<th>Fecha_Atencion</th>";
            tex = tex + "<th>Resultado</th>";
            tex = tex + "<th>Fecha_Proxima_Prueba_Hermeticidad</th>";
            tex = tex + "</tr>";

            ocultaLoading();
            $.each(data.filas, function( index, value ) {
                var estado = "";
                if(value.estado.toUpperCase()=='P')
                    estado='PROGRAMADO';
                if(value.estado.toUpperCase()=='R')
                    estado='REPROGRAMADO';
                if(value.estado.toUpperCase()=='C')
                    estado='CANCELADO';
                if(value.estado.toUpperCase()=='E')
                    estado='EN REGISTRO';
                if(value.estado.toUpperCase()=='F')
                    estado='CONCLUIDO';
                
                var resultado = "";
                if(value.resultadoPrueba=="A"){
                	resultado='CONFORME';
                }else{
                	if(value.resultadoPrueba=="N"){
                		resultado='TOMAR ACCION';
                    }
                }

                tex = tex + "<tr>";
                tex = tex + '<td>'+ value.nroSolicitudUnidadSupervisa +'</td>';
                tex = tex + '<td>'+ value.empresaAcreditada +'</td>';
                tex = tex + '<td>'+ value.numeroTanque +'</td>';
                tex = tex + '<td>'+ value.numeroCompartimiento +'</td>';
                tex = tex + '<td>'+ estado +'</td>';
                tex = tex + '<td>'+ convertirFecha( value.fechaCreacion )+'</td>';
                tex = tex + '<td>'+ convertirFecha( value.fechaSolicitud) +'</td>';
                tex = tex + '<td>'+ convertirFecha( value.fechaInicio) +'</td>';
                tex = tex + '<td>'+ resultado +'</td>';
                tex = tex + '<td>'+ convertirFecha( value.fechaProxPrueba ) +'</td>';
                tex = tex + "</tr>";
                
            });

            $("#tablitaPH").append(tex);
        },
        error:errorAjax
    });
} 

function listarBandejaPruebaHermeticidad(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorPruebaHermeticidad").html("");
    
    var grid = $("<table>", {
        "id": "gridContenedorPruebaHermeticidad"
    });
    
    var pager = $("<div>", {
        "id": "paginacionPruebaHermeticidad"
    });
    
    $("#gridContenedorPruebaHermeticidad").append(grid).append(pager);
    
    var nombres = ['','','','','N° SOLICITUD','EMPRESA','UNIDAD ALMACENAMIENTO','','COMPARTIMIENTO','ESTADO', 'FECHA DE SOLICITUD', 'FECHA PROGRAMADA', 'FECHA DE ATENCI&Oacute;N','RESULTADO','FECHA DE PR&Oacute;XIMA PRUEBA','OPCI&Oacute;N'];
    var columnas = [
    	{name: "idResultadoPruebaReprueba",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "idUnidSupervTanque",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "idEmpresaAcreditada",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "idSolicitudPruebaReprueba",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "nroSolicitudUnidadSupervisa",width: 175, sortable: false, hidden: false, align: "left"},
    	{name: "empresaAcreditada",width: 148, sortable: false, align: "left"},
        {name: "numeroTanque",width: 150, sortable: false, hidden: false, align: "left", formatter:"fmtNumeroTanque"},
        {name: "idCompartimiento",width: 100, sortable: false, hidden: true, align: "left"},
        {name: "numeroCompartimiento",width: 100, sortable: false, hidden: false, align: "left"},
        {name: "estado",width: 97, sortable: false, hidden: false, align: "left", formatter:"fmtEstadoSolicitud"},
        {name: "fechaCreacion",width: 70, sortable: false, hidden: false, align: "left", formatter:"fmtFechaC"},
        {name: "fechaSolicitud", width: 76, sortable: false, hidden: false, align: "left", formatter:"fmtFechaS"},
        {name: "fechaInicio", width: 70, sortable: false, hidden: false, align: "left", formatter:"fmtFechaA"},
        {name: "resultadoPrueba", width: 85, sortable: false, hidden: false, align: "left", formatter:"fmtResultadoPrueba"},
        {name: "fechaProxPrueba",width: 100, sortable: false, hidden: false, align: "left", formatter:"fmtFechaPPH"},
        {name: "opcion",width: 198, sortable: false, hidden: false, align: "center", formatter:"OpcionesS"}
        
     ];
    
    //Filtro
    
    var id_option = document.getElementById("cmbTipoBusqueda").selectedIndex;
    var id_option2 = document.getElementById("cmbEstadoPHPrincipal").selectedIndex;
    var buscaNSolicitud = "";
    var buscaEmpresa = "";
    var buscaEstado = "";
    var buscaResultado = "";
    
    if (id_option == 1){
    	buscaNSolicitud = $("#txtBusqueda").val();}else{
    		if (id_option == 2){
    			buscaEmpresa = $("#txtBusqueda").val();}else{
    				if (id_option == 3){
    					buscaNSolicitud = "";
    				    buscaEmpresa = "";
    				    buscaResultado = "";
    				}else{
    					if (id_option == 4){
        					buscaNSolicitud = "";
        				    buscaEmpresa = "";
        				    buscaEstado = "";
        				}else{
        					if (id_option == 5){
            					buscaNSolicitud = "";
            				    buscaEmpresa = "";
            				    buscaEstado = "";
            				    buscaResultado = "";
            				}
        				}
    				}
    			}
		}
    
    //Buscar x Estado
    if (id_option == 3 && id_option2 == 1){
    	buscaEstado = "P";
	}else{
		if (id_option == 3 && id_option2 == 2){
	    	buscaEstado = "R";
		}else{
			if (id_option == 3 && id_option2 == 3){
		    	buscaEstado = "C";
			}else{
				if (id_option == 3 && id_option2 == 4){
			    	buscaEstado = "E";
				}else{
					if (id_option == 3 && id_option2 == 5){
				    	buscaEstado = "F";
					}
				}
			}
		}
	}
    
    //Buscar X Resultado
    if (id_option == 4 && id_option2 == 1){
    	buscaResultado = "A";
	}else{
		if (id_option == 4 && id_option2 == 2){
	    	buscaResultado = "N";
		}
	}
    //--------------------------------------
    
    grid.jqGrid({
        url: baseURL + "pages/solicitudPruebasHermeticidad/listarSolicitudPruebaReprueba",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            resultadoPrueba :buscaResultado,
            idUnidSupervTanque :$('#UnidadSupervisada').val(),
            nroSolicitudUnidadSupervisa :buscaNSolicitud,
            empresaAcreditada :buscaEmpresa,
            estado :buscaEstado
            
            
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 20,
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
            id: "idSolicitudPruebaReprueba"
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
    
  //Descripcion Tanque
    jQuery.extend($.fn.fmatter, {
    	fmtNumeroTanque: function(cellvalue, options, rowdata) {
            var Ntanque = rowdata.numeroTanque;
            
            return "Tanque N° "+Ntanque;
        }
    });
    
    //Botones Links
    jQuery.extend($.fn.fmatter, {
    	OpcionesS: function(cellvalue, options, rowdata) {
    		var est = rowdata.estado;
    		var dateVar1 = rowdata.fechaSolicitud;
    		var dateVar2 = rowdata.fechaCreacion;
    		var dateVar3 = rowdata.fechaProxPrueba;
    		
    		var fSolicitud = convertirFecha(dateVar1);
    		var fCreacion = convertirFecha(dateVar2);
    		var fProxPrueba = convertirFecha(dateVar3);;
    		
    		if(est=="P" || est=="R"){
    			return "<a class='Consultar' id='"+ rowdata.idCompartimiento +"%"+ rowdata.empresaAcreditada+"%"+ fSolicitud+"%"+ fCreacion+"%"+ rowdata.estado+"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>"+"  "+
    				   "<a class='ReprogramarS' id='"+ rowdata.idSolicitudPruebaReprueba +"' style='cursor: pointer;text-decoration:none;' ><u> Reprogramar </u></a>"+"  "+
    				   "<a class='CancelarS' id='"+ rowdata.idSolicitudPruebaReprueba +"' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>";
    		}else{
    			if(est=="E"){
    				return "<a class='Consultar' id='"+ rowdata.idCompartimiento +"%"+ rowdata.empresaAcreditada+"%"+ fSolicitud+"%"+ fCreacion+"%"+ rowdata.estado+"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
    			}else{
    				if(est=="F" || est=="I"){
        				/*return "<a class='VerResultado' id='"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.idEmpresaAcreditada+"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroCompartimiento +"%"+ rowdata.numeroTanque + "%" +  convertirFecha( rowdata.fechaInicio ) + "%" + rowdata.resultadoPrueba +"%"+ rowdata.idUnidSupervTanque +"' style='cursor: pointer;text-decoration:none;' ><u> Ver Resultado </u></a>"+"  "+
        	 	 	   	"<a class='Informe' id='"+ rowdata.idResultadoPruebaReprueba +"%"+ fProxPrueba+"' style='cursor: pointer;text-decoration:none;' ><u> Informe </u></a>";*/
    					return "<a class='VerResultado' id='"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.idEmpresaAcreditada+"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroCompartimiento +"%"+ rowdata.numeroTanque + "%" +  convertirFecha( rowdata.fechaInicio ) + "%" + rowdata.resultadoPrueba +"%"+ rowdata.idUnidSupervTanque +"' style='cursor: pointer;text-decoration:none;' ><u> Ver Resultado </u></a>";
        			}else{
        				return "";
        			}
    			}
    		}
        }
    });
    
    //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoSolicitud: function(cellvalue, options, rowdata) {
            var sel = rowdata.estado;
            var tex ='';
            if(sel=="P"){
            	tex='PROGRAMADO ';
            	return tex;
            }else{
            	if(sel=="R"){
                	tex='REPROGRAMADO ';
                	return tex+"<img src=\"" + baseURL + "/../images/info2.png\" class='InformeES' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.estado+"'style=\"cursor: pointer; width: 16px;\" title=\"Informe de Estado\"/>" ;
                }else{
                	if(sel=="C"){
                    	tex='CANCELADO ';
                    	return tex+"<img src=\"" + baseURL + "/../images/info2.png\" class='InformeES' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.estado+"'style=\"cursor: pointer; width: 16px;\" title=\"Informe de Estado\"/>" ;
                    }else{
                    	if(sel=="E"){
                        	tex='EN REGISTRO ';
                        	return tex+"<img src=\"" + baseURL + "/../images/info2.png\" class='InformeES' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.estado+"'style=\"cursor: pointer; width: 16px;\" title=\"Informe de Estado\"/>" ;
                        }else{
                        	if(sel=="I"){
                            	tex='PRUEBA CONCLUIDA ';
                            	return tex+"<img src=\"" + baseURL + "/../images/info2.png\" class='InformeES' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.estado+"'style=\"cursor: pointer; width: 16px;\" title=\"Informe de Estado\"/>" ;
                            }else{
                            	if(sel=="F"){
                                	tex='FINALIZADO ';
                                	return tex;
                                }
                            }
                        }
                    }
                }
            }
            //return tex+"<img src=\"" + baseURL + "/../images/info2.png\" class='InformeES' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.estado+"'style=\"cursor: pointer; width: 16px;\" title=\"Informe de Estado\"/>" ;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtResultadoPrueba: function(cellvalue, options, rowdata) {
            var sel = rowdata.resultadoPrueba;
            var tex ='';
            if(sel=="A"){
            	tex='CONFORME';
            }else{
            	if(sel=="N"){
                	tex='TOMAR ACCION';
                }
            }
            return tex;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaC: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaCreacion;
    		
	    	var fechaR = convertirFecha(dateVar);
	    	
    		return fechaR; 
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaS: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaSolicitud;
    		
	    	var fechaS = convertirFecha(dateVar);
	    	
    		return fechaS; 
    		 
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaA: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaInicio;

	    	var fechaA = convertirFecha(dateVar);
	    	
    		return fechaA; 
    		 
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaPPH: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaProxPrueba;

	    	var fechaPPH = convertirFecha(dateVar);
	    	
    		return fechaPPH; 
    		 
        }
    });
	
}

function abrirFrmReprogramarCancelar(id, tipoOpcion){  
    var title = ""
    if(tipoOpcion == "R"){
        title= "REPROGRAMAR SOLICITUD"}
    if(tipoOpcion == "C"){
        title= "CANCELAR SOLICITUD"}
    $.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/abrirEstReprogramarCancelar", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
        ocultaLoading();
            
        $("#dialogFrmEstReprogramarCancelar").html(data);
            
        $("#dialogFrmEstReprogramarCancelar").dialog({
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
               verificarDatosSolicitudRC(id, tipoOpcion);
            },
        });
                
        },
            
        error:errorAjax
    });
}

//------------------------------------------- PANEL - INFORME DE INDICE DE RIESGO ------------------------------------------------

function listarBandejaInformeIndiceRiesgo(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorInformeRiesgo").html("");
    
    var grid = $("<table>", {
        "id": "gridContenedorInformeRiesgo"
    });
    
    var pager = $("<div>", {
        "id": "paginacionInformeRiesgo"
    });
    
    $("#gridContenedorInformeRiesgo").append(grid).append(pager);
    
    var nombres = ['','N° INFORME INDICE DE RIESGO','FECHA DE INFORME', 'TANQUE - COMPARTIMIENTO','OPCI&Oacute;N'];
    var columnas = [
    	{name: "idInformeIndiceRiesgo",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "nroInformeIndiceRiesgo",width: 350, sortable: false, hidden: false, align: "left"},
    	{name: "fechaInformeIndiceRiesgo",width: 250, sortable: false, hidden: false, align: "left", formatter:"fmtFechaIR"},
        {name: "listaTanquesCompartimientos",width: 550, sortable: false, hidden: false, align: "left", formatter:"ListarIR"},
        {name: "opcion",width: 153, sortable: false, hidden: false, align: "center", formatter:"OpcionesIR"}
        
     ];
    
    //Filtro
    
    var id_option = document.getElementById("cmbTipoBusquedaInfoR").selectedIndex;
    var buscaNInforme = "";
    var buscaTanComp = "";
    
    if (id_option == 1){
    	buscaNInforme = $("#txtBusquedaInfoR").val();}else{
    		if (id_option == 2){
    			buscaTanComp = $("#txtBusquedaInfoR").val();
    		}
		}
    
    //--------------------------------------
    
    grid.jqGrid({
        url: baseURL + "pages/solicitudPruebasHermeticidad/listarSolicitudXInformeRiesgo",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            nroInformeIndiceRiesgo :buscaNInforme,
            listaTanquesCompartimentos :buscaTanComp,
            
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 20,
        pager: "#paginacionInformeRiesgo",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Informes de Indice de Riesgo",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idInformeIndiceRiesgo"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Juntar Solicitudes en un solo campo
    jQuery.extend($.fn.fmatter, {
    	ListarIR: function(cellvalue, options, rowdata) {
    		var nroSOL = rowdata.listaTanquesCompartimientos;
    		
    		var idList  = nroSOL.split('/');
    		
    		var lista = ""

    	    //Recorrer las listas para agregar el salto de página
    	    for (var indice in idList) {
    	        lista = lista.concat(idList[indice] + "<br />");
    	    }
    		
    		return lista;
    		
        }
    });
    
    //Botones Links
    jQuery.extend($.fn.fmatter, {
    	OpcionesIR: function(cellvalue, options, rowdata) {
    		
    		/*var dateVar1 = rowdata.fechaInformeIndiceRiesgo;
    		var fSolicitud = convertirFecha(dateVar1);*/
    		
    		return "<a class='ConsultarIdInformeIndiceRiesgo' id='"+ rowdata.idInformeIndiceRiesgo +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
    		
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaIR: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaInformeIndiceRiesgo;

	    	var fechaIIR = convertirFecha(dateVar);
	    	
    		return fechaIIR; 
    		 
        }
    });
	
}

//FORMULARIO INDORME INDICE RIESGO
function abrirFrmIndiceRiesgo(){ 
	
 var titulo = "INFORME DE ÍNDICE DE RIESGO"; 
 
    $.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/abrirFrmIndiceRiesgo", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
           
            $("#dialogNuevoInformeRiesgo").html(data);
        
            $("#dialogNuevoInformeRiesgo").dialog({
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
