
$(function() {
	listarSolicitudesPendientesPruebaHermeticidad(0);
	listarSolicitudesAtendidasPruebaHermeticidad(0);
    initInicioBandejaResultadoPruebaHermeticidad();  
});

function initInicioBandejaResultadoPruebaHermeticidad(){ 
	confirm.start();
	
	$('#btnBuscarSolicitudPendiente').click(function(){
		listarSolicitudesPendientesPruebaHermeticidad();
    });
	
	$('#btnBuscarSolicitudAtendida').click(function(){
		listarSolicitudesAtendidasPruebaHermeticidad();
    });
	
	$('body').on('click', '.Reprogramar',function(){
        var tipoOpcion = "R";
        var id = $(this).attr("id");
        abrirFrmReprogCancel(id, tipoOpcion);
    });

    $('body').on('click', '.Cancelar',function(){
        var tipoOpcion = "C";
        var id = $(this).attr("id");
        abrirFrmReprogCancel(id, tipoOpcion);
    });

//---- FUNCION CONSULTAR - SOLICITUDES ATENDIDAS ---------
    $('body').on('click', '.Consultar',function(){
    	
       var estado ="CONSULTA";
        
   	   var cadena= $(this).attr("id");
    	   
	   var arrayCadena = cadena.split("%");
    	   
	   var idResultadoPruebaReprueba = arrayCadena[0];
 	   var idEmpresaAcreditada = arrayCadena[1];
 	   var idCompartimiento = arrayCadena[2];
 	   var numeroCompartimiento = arrayCadena[3];
   	   var numeroTanque = arrayCadena[4];
   	   var fInicio = arrayCadena[5];
   	   var resultadoPrueba = arrayCadena[6];
   	   var idUnidSupervTanque = arrayCadena[7];
    	   
	   if (idResultadoPruebaReprueba == '' || idResultadoPruebaReprueba == 'null'){idResultadoPruebaReprueba ='';
	   } else {idResultadoPruebaReprueba = arrayCadena[0];}
	   
	   if (idEmpresaAcreditada == ''  || idEmpresaAcreditada == 'null'){idEmpresaAcreditada ='' ;
	   } else {idEmpresaAcreditada =arrayCadena[1] ;}
	   
	   if (idCompartimiento == '' || idCompartimiento == 'null'){idCompartimiento = '';
	   } else {idCompartimiento =arrayCadena[2];}
	   
	   if (numeroCompartimiento == '' || numeroCompartimiento == 'null'){numeroCompartimiento = '';
 	   } else {numeroCompartimiento =arrayCadena[3];}
 	 
 	   if (numeroTanque == '' || numeroTanque == 'null'){numeroTanque = '';
 	   } else {numeroTanque =arrayCadena[4];}
	   
	   if (fInicio == '' || fInicio == 'null'){fInicio = '';
	   } else {fInicio =arrayCadena[5];}
	 
	   if (resultadoPrueba == '' || resultadoPrueba == 'null'){resultadoPrueba = '';
	   } else {resultadoPrueba = arrayCadena[6];}
	   
	   if (idUnidSupervTanque == '' || idUnidSupervTanque == 'null'){idUnidSupervTanque = '';
	   } else {idUnidSupervTanque = arrayCadena[7];}
      
      abrirFrmResultadoPruebaHermeticidadAux();
      TraerDatosConsultaResPH(idResultadoPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,fInicio,resultadoPrueba,idUnidSupervTanque,estado);
 	   
   });
//--- HASTA ACA --------------------------------------------------------------------------------------------------------------
    
    $('body').on('click', '.Registrar',function(){
        
        var estado ="NUEVO_REGISTRO";
        
  	   var cadena = $(this).attr("id");
   	   
   	   var arrayCadena = cadena.split("%");
   	   
   	   var idSolicitudPruebaReprueba = arrayCadena[0];
   	   var idEmpresaAcreditada       = arrayCadena[1];
   	   var idCompartimiento          = arrayCadena[2];
   	   var numeroCompartimiento      = arrayCadena[3];
   	   var numeroTanque              = arrayCadena[4];
   	   var idUnidSupervTanque        = arrayCadena[5];
   	   var idResultadoPruebaReprueba = arrayCadena[6];
   	   var fechaSolicitud            = arrayCadena[7];

   	   
   	   if (idSolicitudPruebaReprueba == '' || idSolicitudPruebaReprueba == 'null'){idSolicitudPruebaReprueba ='';
 	   } else {idSolicitudPruebaReprueba = arrayCadena[0];}
   	   
   	   if (idEmpresaAcreditada == ''  || idEmpresaAcreditada == 'null'){idEmpresaAcreditada ='' ;
        } else {idEmpresaAcreditada =arrayCadena[1] ;}
   	   
   	   if (idCompartimiento == '' || idCompartimiento == 'null'){idCompartimiento = '';
 	   } else {idCompartimiento =arrayCadena[2];}
   	   
   	   if (numeroCompartimiento == '' || numeroCompartimiento == 'null'){numeroCompartimiento = '';
 	   } else {numeroCompartimiento =arrayCadena[3];}
   	 
   	   if (numeroTanque == '' || numeroTanque == 'null'){numeroTanque = '';
 	   } else {numeroTanque =arrayCadena[4];}
         
         abrirFrmResultadoPruebaHermeticidad();
         TraerDatosResPH(idSolicitudPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,idUnidSupervTanque,idResultadoPruebaReprueba,fechaSolicitud,estado);
  	 	  
         $( "#button-id").children().addClass( "button-ok" );
     	 $( "#registroRV").children().addClass( "button-ok" );
     	 $(".button-ok").css({display: "block"});
         
      });
     
     $('body').on('click', '.RegistrarE',function(){
         
         var estado ="EN_REGISTRO";
         
   	   var cadena = $(this).attr("id");
    	   
    	   var arrayCadena = cadena.split("%");
    	   
    	   var idSolicitudPruebaReprueba = arrayCadena[0];
    	   var idEmpresaAcreditada       = arrayCadena[1];
    	   var idCompartimiento          = arrayCadena[2];
    	   var numeroCompartimiento      = arrayCadena[3];
    	   var numeroTanque              = arrayCadena[4];
    	   var idUnidSupervTanque        = arrayCadena[5];
    	   var idResultadoPruebaReprueba = arrayCadena[6];
    	   var fechaSolicitud            = arrayCadena[7];

    	   
    	   if (idSolicitudPruebaReprueba == '' || idSolicitudPruebaReprueba == 'null'){idSolicitudPruebaReprueba ='';
  	   } else {idSolicitudPruebaReprueba = arrayCadena[0];}
    	   
    	   if (idEmpresaAcreditada == ''  || idEmpresaAcreditada == 'null'){idEmpresaAcreditada ='' ;
         } else {idEmpresaAcreditada =arrayCadena[1] ;}
    	   
    	   if (idCompartimiento == '' || idCompartimiento == 'null'){idCompartimiento = '';
  	   } else {idCompartimiento =arrayCadena[2];}
    	   
    	   if (numeroCompartimiento == '' || numeroCompartimiento == 'null'){numeroCompartimiento = '';
  	   } else {numeroCompartimiento =arrayCadena[3];}
    	 
    	   if (numeroTanque == '' || numeroTanque == 'null'){numeroTanque = '';
  	   } else {numeroTanque =arrayCadena[4];}
          
          abrirFrmResultadoPruebaHermeticidad();
          TraerDatosResPH(idSolicitudPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,idUnidSupervTanque,idResultadoPruebaReprueba,fechaSolicitud,estado);
   	 	   
          $( "#button-id").children().addClass( "button-ok" );
      	  $( "#registroRV").children().addClass( "button-ok" );
      	  $(".button-ok").css({display: "block"});
          
       });
     
     $('body').on('click', '.ConsultarE',function(){
         
         var estado ="CONSULTAR";
         
   	   var cadena = $(this).attr("id");
    	   
    	   var arrayCadena = cadena.split("%");
    	   
    	   var idSolicitudPruebaReprueba = arrayCadena[0];
    	   var idEmpresaAcreditada       = arrayCadena[1];
    	   var idCompartimiento          = arrayCadena[2];
    	   var numeroCompartimiento      = arrayCadena[3];
    	   var numeroTanque              = arrayCadena[4];
    	   var idUnidSupervTanque        = arrayCadena[5];
    	   var idResultadoPruebaReprueba = arrayCadena[6];
    	   var fechaSolicitud            = arrayCadena[7];

    	   
    	   if (idSolicitudPruebaReprueba == '' || idSolicitudPruebaReprueba == 'null'){idSolicitudPruebaReprueba ='';
  	   } else {idSolicitudPruebaReprueba = arrayCadena[0];}
    	   
    	   if (idEmpresaAcreditada == ''  || idEmpresaAcreditada == 'null'){idEmpresaAcreditada ='' ;
         } else {idEmpresaAcreditada =arrayCadena[1] ;}
    	   
    	   if (idCompartimiento == '' || idCompartimiento == 'null'){idCompartimiento = '';
  	   } else {idCompartimiento =arrayCadena[2];}
    	   
    	   if (numeroCompartimiento == '' || numeroCompartimiento == 'null'){numeroCompartimiento = '';
  	   } else {numeroCompartimiento =arrayCadena[3];}
    	 
    	   if (numeroTanque == '' || numeroTanque == 'null'){numeroTanque = '';
  	   } else {numeroTanque =arrayCadena[4];}
          
          abrirFrmResultadoPruebaHermeticidad();
          TraerDatosResPH(idSolicitudPruebaReprueba,idEmpresaAcreditada,idCompartimiento,numeroCompartimiento,numeroTanque,idUnidSupervTanque,idResultadoPruebaReprueba,fechaSolicitud,estado);
          bloquearDesbloquearCampos();
          
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

//----------- ABRIR FORMULARIO RESULTADO PRUEBA DE HERMETICIDAD -----------------
function abrirFrmResultadoPruebaHermeticidad(){
	 
	 $.ajax({
	        url:baseURL + "pages/resultadosPruebasHermeticidad/abrirFrmResultadoPruebaHermeticidad", 
	        type:'get',
	        async:false,
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	           
	            $("#dialogResultadoSolicitudPruebaHermeticidad").html(data);
	        
	            $("#dialogResultadoSolicitudPruebaHermeticidad").dialog({
	            
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "1260",
	                position: ['center', 'top+30'],
	                modal: true,
	                dialogClass: 'dialog',
	                title: "PRUEBAS DE HERMETICIDAD - REGISTRO DE RESULTADOS",
	                closeText: "Cerrar"
	                
	            });
	            
	        },
	        
	        error:errorAjax
	    });
 }

//------- HASTA ACA -------------------------------------------------------------

function listarSolicitudesPendientesPruebaHermeticidad(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorSolicitudesPendientes").html("");
    
    var grid = $("<table>", {
        "id": "gridContenedorSolicitudesPendientes"
    });
    
    var pager = $("<div>", {
        "id": "paginacionSolicitudesPendientes"
    });
    
    $("#gridContenedorSolicitudesPendientes").append(grid).append(pager);
    
    var nombres = ['','','','','','N° SOLICITUD','EMPRESA','UNIDAD ALMACENAMIENTO','','COMPARTIMIENTO','ESTADO', 'FECHA DE SOLICITUD','FECHA PROGRAMADA','OPCI&Oacute;N'];
    var columnas = [
    	{name: "idSolicitudPruebaReprueba",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "idUnidSupervTanque",width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "idSolicitudPruebaReprueba ",width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "idResultadoPruebaReprueba",width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "idEmpresaAcreditada",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "nroSolicitudUnidadSupervisa",width: 190, sortable: false, hidden: false, align: "left"},
    	{name: "empresaAcreditada",width: 190, sortable: false, align: "left"},
        {name: "numeroTanque",width: 160, sortable: false, hidden: false, align: "left", formatter:"fmtNTanque"},
        {name: "idCompartimiento",width: 100, sortable: false, hidden: true, align: "left"},
        {name: "numeroCompartimiento",width: 120, sortable: false, hidden: false, align: "left"},
        {name: "estado",width: 120, sortable: false, hidden: false, align: "left", formatter:"fmtEstadoSol"},
        {name: "fechaCreacion", width: 150, sortable: false, hidden: false, align: "left", formatter:"fmtFechaSol"},
        {name: "fechaSolicitud",width: 150, sortable: false, hidden: false, align: "left", formatter:"fmtFechaProgSol"},
        {name: "opcion",width: 202, sortable: false, hidden: false, align: "center", formatter:"OpcionesSol"}
        
     ];
    
    //Filtro
    
    var id_option = document.getElementById("cmbTipoBusquedaSolP").selectedIndex;
    
    if (id_option == 1){
    	var buscaNSolicitud = $("#txtBusquedaSolP").val();}else{
    		if (id_option == 2){
    			var buscaEmpresa = $("#txtBusquedaSolP").val();}
		}
    //--------------------------------------
    
    grid.jqGrid({
        url: baseURL + "pages/resultadosPruebasHermeticidad/listarSolicitudPruebaReprueba",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            tipoPrueba : 'PRUEBA DE HERMETICIDAD',
            estado :'P',
            idTipoPrueba :'1467',
            nroSolicitudUnidadSupervisa :buscaNSolicitud,
            empresaAcreditada :buscaEmpresa
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 20,
        pager: "#paginacionSolicitudesPendientes",
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
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Descripcion Tanque
    jQuery.extend($.fn.fmatter, {
    	fmtNTanque: function(cellvalue, options, rowdata) {
            var Ntanque = rowdata.numeroTanque;
            
            return "Tanque N° "+Ntanque;
        }
    });
    
    //Botones Links
    jQuery.extend($.fn.fmatter, {
    	OpcionesSol: function(cellvalue, options, rowdata) {
    		
    		var estado = rowdata.estado;
            var text = "";
            var fechaSolicitud="";
            
    		var dateVar = rowdata.fechaSolicitud;
    		
    		fechaSolicitud = convertirFecha(dateVar);
    		    		
            if (estado.toUpperCase() == "P" ||  estado.toUpperCase() =="R"){
    			
            	text = "<a class='Reprogramar' id='"+ rowdata.idSolicitudPruebaReprueba +"' style='cursor: pointer;text-decoration:none;' ><u> Reprogramar </u></a>"+"  "+
	 	   		       "<a class='Registrar' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idEmpresaAcreditada +"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroCompartimiento +"%"+ rowdata.numeroTanque +"%"+ rowdata.idUnidSupervTanque +"%"+ rowdata.idResultadoPruebaReprueba + "%"+ fechaSolicitud +"' style='cursor: pointer;text-decoration:none;' ><u> Registrar </u></a>"+"  "+
	 	   		       "<a class='Cancelar' id='"+ rowdata.idSolicitudPruebaReprueba +"' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>";
            }
    		
    		if (estado.toUpperCase() == "E" ){
    			
    			text = "<a class='RegistrarE' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idEmpresaAcreditada +"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroCompartimiento +"%"+ rowdata.numeroTanque +"%"+ rowdata.idUnidSupervTanque +"%"+ rowdata.idResultadoPruebaReprueba + "%"+ fechaSolicitud +"' style='cursor: pointer;text-decoration:none;' ><u> Registrar </u></a>";
    			
    			/*text = "<a class='Reprogramar' id='"+ rowdata.idSolicitudPruebaReprueba +"' style='cursor: pointer;text-decoration:none;' ><u> Reprogramar </u></a>"+"  "+
	 	   		       "<a class='RegistrarE' id='"+ rowdata.idSolicitudPruebaReprueba +"%"+ rowdata.idEmpresaAcreditada +"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroCompartimiento +"%"+ rowdata.numeroTanque +"%"+ rowdata.idUnidSupervTanque +"%"+ rowdata.idResultadoPruebaReprueba + "%"+ fechaSolicitud +"' style='cursor: pointer;text-decoration:none;' ><u> Registrar </u></a>"+"  "+
	 	   		       "<a class='Cancelar' id='"+ rowdata.idSolicitudPruebaReprueba +"' style='cursor: pointer;text-decoration:none;' ><u> Cancelar </u></a>";  */  			
    		}
    		
    		return text;
    
        }
    });
    
    //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoSol: function(cellvalue, options, rowdata) {
            var sel = rowdata.estado;
            var tex ='';
            if(sel=="P"){
            	tex='PROGRAMADO';
            }else{
            	if(sel=="R"){
                	tex='REPROGRAMADO';
                }else{
                	if(sel=="E"){
                    	tex='EN REGISTRO';
                    }else{
                    	if(sel=="C"){
                        	tex='CANCELADO';
                        }
                    }
                }
            }
            return tex;
        }
    });
        
    jQuery.extend($.fn.fmatter, {
    	fmtFechaSol: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaCreacion;
    		var fecha = convertirFecha(dateVar);
    		return fecha;
    		 
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaProgSol: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaSolicitud;
    		var fecha = convertirFecha(dateVar);
    		return fecha;
    		 
        }
    });
	
}

function listarSolicitudesAtendidasPruebaHermeticidad(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorSolicitudesAtendidas").html("");
    
    var grid = $("<table>", {
        "id": "gridContenedorSolicitudesAtendidas"
    });
    
    var pager = $("<div>", {
        "id": "paginacionSolicitudesAtendidas"
    });
    
    $("#gridContenedorSolicitudesAtendidas").append(grid).append(pager);
    
    var nombres = ['','','','','N° SOLICITUD','EMPRESA','UNIDAD ALMACENAMIENTO','','COMPARTIMIENTO','ESTADO', 'FECHA DE SOLICITUD','FECHA PROGRAMADA','FECHA DE EJECUCI&OacuteN','RESULTADO','OPCI&Oacute;N'];
    var columnas = [
    	{name: "idUnidSupervTanque",width: 5, sortable: false, hidden: true, align: "left"},
    	{name: "idResultadoPruebaReprueba",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "idEmpresaAcreditada",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "idSolicitudPruebaReprueba",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "nroSolicitudUnidadSupervisa",width: 180, sortable: false, hidden: false, align: "left"},
    	{name: "empresaAcreditada",width: 180, sortable: false, align: "left"},
        {name: "numeroTanque",width: 150, sortable: false, hidden: false, align: "left", formatter:"fmtNTanque2"},
        {name: "idCompartimiento",width: 100, sortable: false, hidden: true, align: "left"},
        {name: "numeroCompartimiento",width: 100, sortable: false, hidden: false, align: "left"},
        {name: "estado",width: 100, sortable: false, hidden: false, align: "left", formatter:"fmtEstadoSol2"},
        {name: "fechaCreacion", width: 120, sortable: false, hidden: false, align: "left", formatter:"fmtFechaSol2"},
        {name: "fechaSolicitud",width: 120, sortable: false, hidden: false, align: "left", formatter:"fmtFechaPPHSol2"},
        {name: "fechaInicio",width: 120, sortable: false, hidden: false, align: "left", formatter:"fmtFechaESol2"},
        {name: "resultadoPrueba",width: 104, sortable: false, hidden: false, align: "left", formatter:"fmtResultadoSol2"},
        {name: "opcion",width: 100, sortable: false, hidden: false, align: "center", formatter:"OpcionesSol2"}
        
     ];
    
    //Filtro
    
    var id_optionA = document.getElementById("cmbTipoBusquedaSolA").selectedIndex;
    
    if (id_optionA == 1){
    	var buscaNSolicitudA = $("#txtBusquedaSolA").val();}else{
    		if (id_optionA == 2){
    			var buscaEmpresaA = $("#txtBusquedaSolA").val();}
		}

    
    grid.jqGrid({
        url: baseURL + "pages/resultadosPruebasHermeticidad/listarSolicitudPruebaReprueba",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            tipoPrueba : 'PRUEBA DE HERMETICIDAD',
            estado :'F',
            idTipoPrueba :'1467',
            nroSolicitudUnidadSupervisa :buscaNSolicitudA,
            empresaAcreditada :buscaEmpresaA
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 20,
        pager: "#paginacionSolicitudesAtendidas",
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
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Descripcion Tanque
    jQuery.extend($.fn.fmatter, {
    	fmtNTanque2: function(cellvalue, options, rowdata) {
            var Ntanque = rowdata.numeroTanque;
            
            return "Tanque N° "+Ntanque;
        }
    });
    
    //Botones Links
    jQuery.extend($.fn.fmatter, {
    	OpcionesSol2: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaInicio;
    		var fInicio = convertirFecha(dateVar);
    		var est = rowdata.estado;
    		
    		if(est=="I" || est=="F"){
    			return "<a class='Consultar' id='"+ rowdata.idResultadoPruebaReprueba +"%"+ rowdata.idEmpresaAcreditada +"%"+ rowdata.idCompartimiento +"%"+ rowdata.numeroCompartimiento +"%"+ rowdata.numeroTanque +"%"+ fInicio +"%"+ rowdata.resultadoPrueba +"%"+ rowdata.idUnidSupervTanque +"' style='cursor: pointer;text-decoration:none;' ><u> Consultar </u></a>";
    		}
        }
    });
    
    //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoSol2: function(cellvalue, options, rowdata) {
            var sel = rowdata.estado;
            var tex ='';
            if(sel=="F"){
            	tex='FINALIZADO';
            }else{
            	if(sel=="I"){
                	tex='PRUEBA CONCLUIDA';
                }
            }
            return tex;
        }
    });
    
  //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtResultadoSol2: function(cellvalue, options, rowdata) {
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
    	fmtFechaSol2: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaCreacion;
    		var fecha = convertirFecha(dateVar);
    		return fecha;
    		 
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaPPHSol2: function(cellvalue, options, rowdata) {
    		
    		var dateVar2 = rowdata.fechaSolicitud;
    		    		
    		var fecha = convertirFecha(dateVar2);
    		
    		return fecha;
    		 
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaESol2: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaInicio;
    		var fecha = convertirFecha(dateVar);
    		return fecha;
    		 
        }
    });
   
}

//---- ABRIR FORMULARIO RESULTADO PRUEBA DE HERMETICIDAD - MODO CONSULTA ---------------------------
function abrirFrmResultadoPruebaHermeticidadAux(){
	 
	 $.ajax({
	        url:baseURL + "pages/resultadosPruebasHermeticidad/abrirFrmResultadoPruebaHermeticidad", 
	        type:'get',
	        async:false,
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	           
            $("#dialogResultadoSolicitudPruebaHermeticidadAux").html(data);
        
            $("#dialogResultadoSolicitudPruebaHermeticidadAux").dialog({
            
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "1260",
                position: ['center', 'top+30'],
                modal: true,
                dialogClass: 'dialog',
                title: "PRUEBAS DE HERMETICIDAD - CONSULTAR RESULTADOS",
                closeText: "Cerrar"
                
            });
            
        },
        
        error:errorAjax
    });
}

function abrirFrmReprogCancel(id, tipoOpcion){  
    var title = ""
    if(tipoOpcion == "R"){
        title= "REPROGRAMAR SOLICITUD"}
    if(tipoOpcion == "C"){
        title= "CANCELAR SOLICITUD"}
    $.ajax({
        url:baseURL + "pages/resultadosPruebasHermeticidad/abrirEstadoReprogCancel", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
        ocultaLoading();
            
        $("#dialogFrmEstadoReprogCancel").html(data);
            
        $("#dialogFrmEstadoReprogCancel").dialog({
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
               verificarDatosSolicitud(id, tipoOpcion);
            },
        });
                
        },
            
        error:errorAjax
    });
}