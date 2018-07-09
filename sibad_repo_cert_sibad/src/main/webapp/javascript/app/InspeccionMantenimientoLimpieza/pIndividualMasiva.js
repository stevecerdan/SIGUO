var ArrayDatosID = [];
var arrayAux;
var arrayMasiva = [];
var arrayInexistentes = [];
var arrayFechas = [];
var arrayTipos =  [];
var idCompartimientoB = "";
var fecha = new Date();
var anho = fecha.getFullYear();
var idCompartimiento = "";
var cmbUnidadAlmacenamiento = "";
var numeroSerie = "";
var fechaProgramacion = "";
var tipoRevision = "";
var tipoProgramacion = "";
var numProgramacion= "";
var abrevRevision= "";
var codOsinergmin= "";
var numProg = 1;
var idUndSup ="";
var error = 0;

$(function() {

	mostrarTablaIMLMasiva(0);
	
	mostrarTablaIMLIndivudal(0,0);
	$( "#txtFecha" ).datepicker({ minDate: 0 });

	initInicio();
	initDialogs();

 });

 function initInicio(){ 
	
	confirm.start();
	
	$('body').on('click', '.ui-dialog-titlebar-close',function(){
    	ArrayDatosID.length=0;
		window.setTimeout('location.reload()', 50);  	
    });
	
	$('#btnIniciarCarga').click(function(){
    	llenarDatosGrilla();
    });

    $('#btnDescargar').click(function(){
   		crearDescargarTabla();
    });

    $('#btnGuardar').click(function(){

    	if ( $('input:radio[name=pMasiva]:checked').val() !== "" && $('input:radio[name=pMasiva]:checked').val() !== undefined ){
	    		confirm.open("¿Desea guardar estos " + "(" +arrayMasiva.length+ ")"+ " registros?" ,"registroProgramacionMasiva()");
    	} else {	    	
 		        confirm.open("¿Desea guardar el registro?","RegistrarProgramacionIndividual()");
    	}
    });
    
    $('#btnRegresar').click(function(){

    	/*$('#dialogFrmIndivualMasiva').dialog('close');
    	
    	if(window.top==window) {
            
            window.setTimeout('location.reload()', 1000); 
            
            listarTanqueCL(0,idUnidadSupervisada);
        }*/
    	window.location.href = baseURL+'pages/InspMantLimp';
    	listarTanqueCL(0,idUnidadSupervisada);
    	
    });
    
    $('body').on('click', '.filaSeleccionada',function(){
     
      var cadena= $(this).attr("id");

      if(this.checked == true){
         
    	  ArrayDatosID.push(cadena);
    	            
       }else if(this.checked == false){
        	
          var index = ArrayDatosID.indexOf(cadena);

		  ArrayDatosID.splice(index, 1);

        }
     
    });
    
 }

 $('#pIndividual').on('change', function() {
    	
	$("#pMasiva").removeAttr('checked');
	$("#pIndividual").attr('checked','checked');
	
	$('#Individual').show();
	$('#Masiva').hide();
	   
 });
    
 $('#pMasiva').on('change', function() {
    	
 	$("#pMasiva").attr('checked','checked');
	$("#pIndividual").removeAttr('checked');
	
	$('#Individual').hide();
	$('#Masiva').show();
 	   
});

function formattedDate(d = new Date) {
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return `${day}/${month}/${year}`;
}

function convertDateFormat(string) {
	var info = string.split('/');
	return info[1] + '/' + info[0] + '/' + info[2];
	
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
 
 function RegistrarProgramacionIndividual(){
	 
	 
	tipoRevision = $("#cmbTipo").val();      
	
    if(tipoRevision.length <= 0) {
    	
    	 var addhtml2 = 'Seleccionar Tipo de Revisión.';
		 $("#dialog-message-content").html(addhtml2);
		 $("#dialog-message").dialog("open");
		 
         return false;
    }
    
    fechaProgramacion = $("#txtFecha").val();      
	
    if(fechaProgramacion.length <= 0) {
    	
    	 var addhtml2 = 'Seleccionar Fecha de Programación.';
		 $("#dialog-message-content").html(addhtml2);
		 $("#dialog-message").dialog("open");
		 
         return false;
    }
    
    cmbUnidadAlmacenamiento = $("#cmbUnidadAlmacenamiento").val();      
	
    if(cmbUnidadAlmacenamiento.length <= 0) {
    	
    	 var addhtml2 = 'Seleccionar Unidad de Almacenamiento.';
		 $("#dialog-message-content").html(addhtml2);
		 $("#dialog-message").dialog("open");
		 
         return false;
    }
    
    if ($('input[type=checkbox]:checked').length === 0) {

		var addhtml2 = 'Seleccionar al menos una opción.';
		 $("#dialog-message-content").html(addhtml2);
		 $("#dialog-message").dialog("open");
		 
		return false;
	}
	 
	var ultimoNumProgramacion = $("#ultimoNumProgramacion").val();
	var cadena = ultimoNumProgramacion.split("-");
	var    valor = cadena[2];
	
	//numProg = parseInt(valor);
	 
	 if(ultimoNumProgramacion.length > 0){
		 
		numProg = parseInt(valor);
	 } 
	 	
	 var fProgramacion = $("#txtFecha").val();
	 var cadena = fProgramacion.split("/");
	 var d = cadena[0];
	 var m = cadena[1];
	 var a = cadena[2];
	 
	 fechaProgramacion = m+"/"+d+"/"+a;

    $.each(ArrayDatosID, function(index,value){

		   idCompartimiento = value;
    cmbUnidadAlmacenamiento = $("#cmbUnidadAlmacenamiento").val();
		  fechaProgramacion = fechaProgramacion;
		       tipoRevision = $("#cmbTipo").val();
		   TipoProgramacion = $("#pIndividual").val();
		      codOsinergmin = $("#codOsinergmin").val();
		      

				 if(tipoRevision=='I'){
					   
					 abrevRevision ='INS';
					    
				 } else if(tipoRevision=='M'){
					   
					abrevRevision ='MAN';
					     		
				 } else if(tipoRevision=='L'){
								   
					 abrevRevision ='LIM';		
				}   
				 
				// var num = numProg+"";
				 
				 numProg = numProg + 1;
				 
				 //NumeroProgramacion = num; //String("00000" + num).slice(-5)
				 
				 NumeroProgramacion = numProg;

				 numProgramacion = abrevRevision + "-" + codOsinergmin + "-" + NumeroProgramacion + "-" + anho; 
		      
		$.ajax({
	          url:baseURL + "pages/InspMantLimp/RegistrarProgramacionIndividual",
	         type:'post',
	        async:false,
	        data:{
	        	
	        	   idCompartimiento : idCompartimiento,
	        cmbUnidadAlmacenamiento : cmbUnidadAlmacenamiento,
	    		  fechaProgramacion : fechaProgramacion,
	    		       tipoRevision : tipoRevision,
	    		   tipoProgramacion : TipoProgramacion,
	    		 numeroProgramacion : numProgramacion,
				     		 estado : "P"
	        	
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){
	        		
	            	var idProgramacion = data.idProgramacion;
	            	
	            	$.ajax({
            	        url:baseURL + "pages/InspMantLimp/RegistrarTrazProgramacion",
            	        type:'post',
            	        async:false,
            	        data:{
    	        	           idProgramacion: idProgramacion,
    		                           estado: 'P',
    		                fechaUltimoEstado: fechaProgramacion,           	        	
            	        },
            	        beforeSend:muestraLoading,
            	        success:function(data){
            	            ocultaLoading();
            	            
            	            if(data.resultado=="0"){
            	            		           	            	
            	            	//mensajeGrowl("sucess", global.confirm.save,"");
            	            	
            	            	var idUnidadSupervisada = $("#idUnidSupervisada").val();
            	            	
            	                //$('#dialogFrmIndivualMasiva').dialog('close');
            	                //window.setTimeout('location.reload()', 1000);
            	            	window.location.href = baseURL+'pages/InspMantLimp';
            	                    
            	                listarTanqueCL(0,idUnidadSupervisada);
            	               
            	            }
            	            	
            	           
            	        },
            	        error:errorAjax
            		});	
	            	 
	            }
	        },
	        error:errorAjax
		});	
		
		//numProg++;
		
	 })	 
	 
 }
 
 function enviarValores(idAlmacenamiento,codigoOsinergmin,idUnidadSupervisada){
	  
	  $("#idAlmacenamientoCompartimiento").val(idAlmacenamiento);
	  $("#codOsinergmin").val(codigoOsinergmin);
	  $("#idUnidSupervisada").val(idUnidadSupervisada);

	  idUndSup = idUnidadSupervisada;
	  listarUnidadAlmacenamiento(idUnidadSupervisada);
	  retornarUltimoNumProgramacion(idUnidadSupervisada);
  }
 
 function retornarUltimoNumProgramacion(idUnidadSupervisada){

		$.ajax({
	          url:baseURL + "pages/InspMantLimp/retornarUltimoNumProgramacion",
	         type:'post',
	        async:false,
	        data:{
	        	
	        	idUnidadSupervisada : idUnidadSupervisada,
	        	
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            
	            $.each(data.filas, function( index, value ) {
	            	
	            	$("#ultimoNumProgramacion").val(value.numeroProgramacion);
	            
	            });
	        },
	        error:errorAjax
		});
  }
  
  function listarUnidadAlmacenamiento(idUnidadSupervisada){
	  
	 if((idUnidadSupervisada != 'null') || (idUnidadSupervisada !='')){

		$.ajax({
	          url:baseURL + "pages/InspMantLimp/listarUnidadAlmacenamiento",
	         type:'post',
	        async:false,
	        data:{
	        	
	        	//idAlmacenamiento : idAlmacenamiento,
	        	idUnidadSupervisada : idUnidadSupervisada,
	        	
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            
	            $.each(data.filas, function( index, value ) {
	            	
	            	$("#cmbUnidadAlmacenamiento").append('<option id ="'+ value.numeroserie +'" value ="'+ value.idAlmacenamiento +'">Tanque ' + value.numero + '</option>');

	            });
	        },
	        error:errorAjax
		});	
	  
	  }
  }
 
 
  $('#cmbUnidadAlmacenamiento').on('change', function() {

	  var numeroSerie = $(this).children(":selected").attr("id");
	  var idAlmacenamiento =$(this).val();
	  
	  $("#txtSerie").val(numeroSerie);
	 
	  mostrarTablaIMLIndivudal(0,idAlmacenamiento);
	
  });
  
  function mostrarTablaIMLIndivudal(flg_load,idAlmacenamiento) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorProgIndividual").html("");
    
    var grid = $("<table>", {
        "id": "gridProgIndividual"
    });
    
    var pager = $("<div>", {
        "id": "paginacionProgIndividual"
    });
    
    $("#gridContenedorProgIndividual").append(grid).append(pager);
    
    var nombres = ['','COMPARTIMIENTO', 'CAPACIDAD','PRODUCTO','OPCI&Oacute;N'];
    var columnas = [
    	
    	{name: "idCompartimiento", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "numero", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "capacidad", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "nombreLargoProducto", width: 150, sortable: false, hidden: false, align: "left"},
        {name: "opcion",width: 120, sortable: false, hidden: false, align: "center", formatter:"Opciones"}
        
     ];
    
    
    grid.jqGrid({
    	url: baseURL + "pages/InspMantLimp/listarCompartimiento",
        datatype: "json",
        postData: {
        	
        	flg_load: flg_load,
        	idAlmacenamiento:  idAlmacenamiento
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionProgIndividual",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de compartimientos",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idAlmacenamiento"
           
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        } 
        ,
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	Opciones: function(cellvalue, options, rowdata) {
    		
            return  " <input type='checkbox'  name ='check' id='"+ rowdata.idCompartimiento +"' class='filaSeleccionada' value=''>";
        
    	}
    });
 }
  
  function mostrarTablaIMLIndivudalPorIdCompartimiento(flg_load,idCompartimiento) {
		
	  
		if (flg_load === undefined) {
	        flg_load = 1;
	    }
	    
	    $("#gridContenedorProgIndividual").html("");
	    
	    var grid = $("<table>", {
	        "id": "gridProgIndividual"
	    });
	    
	    var pager = $("<div>", {
	        "id": "paginacionProgIndividual"
	    });
	    
	    $("#gridContenedorProgIndividual").append(grid).append(pager);
	    
	    var nombres = ['','COMPARTIMIENTO', 'CAPACIDAD','PRODUCTO','OPCI&Oacute;N'];
	    var columnas = [
	    	
	    	{name: "idCompartimiento", width: 100, sortable: false, hidden: true, align: "left"},
	        {name: "numero", width: 100, sortable: false, hidden: false, align: "left"},
	        {name: "capacidad", width: 100, sortable: false, hidden: false, align: "left"},
	        {name: "nombreLargoProducto", width: 150, sortable: false, hidden: false, align: "left"},
	        {name: "opcion",width: 120, sortable: false, hidden: false, align: "center", formatter:"Opciones"}
	        
	     ];
	    
	    
	    grid.jqGrid({
	    	url: baseURL + "pages/InspMantLimp/listarCompartimientoPorId",
	        datatype: "json",
	        postData: {
	        		        	
	        	idCompartimiento: idCompartimiento
	        },
	        hidegrid: false,
	        rowNum: global.rowNumPrinc,
	        pager: "#paginacionProgIndividual",
	        emptyrecords: "No se encontraron resultados",
	        loadtext: "Cargando",
	        colNames: nombres,
	        colModel: columnas,
	        height: "auto",
	        viewrecords: true,
	        caption: "Listado de compartimientos",
	        autowidth: true,
	        jsonReader: {
	            root: "filas",
	            page: "pagina",
	            total: "total",
	            records: "registros",
	            repeatitems: false,
	            id: "idAlmacenamiento"
	           
	        },
	        onSelectRow: function(rowid, status) {
	            grid.resetSelection();
	        } 
	        ,
	        loadError: function(jqXHR) {
	            errorAjax(jqXHR);
	        }
	    });
	    
	    jQuery.extend($.fn.fmatter, {
	    	Opciones: function(cellvalue, options, rowdata) {
	    		
	            return  " <input type='checkbox'  name ='check' id='"+ rowdata.idCompartimiento +"' class='filaSeleccionada1' disabled='disabled' checked>";
	        
	    	}
	    });
	 }
 
  function bloquearDesbloquearCampos(Rpt){
	  
	  if(Rpt == 'HABILITAR'){
		  
		  $("#cmbTipo").attr('disabled',false);
	      $("#cmbUnidadAlmacenamiento").attr('disabled',false);
	      $("#txtFecha").attr('disabled',false);
	      $("#txtSerie").attr('disabled',false);
	      $("#btnGuardar").attr('disabled', false);
	      $("input[type=radio]").attr('disabled', false);
	    
	      	 
	  }else if(Rpt == 'DESHABILITAR'){
		  
		  $("#cmbTipo").attr('disabled','disabled');
		  $("#cmbUnidadAlmacenamiento").attr('disabled','disabled');
		  $("#txtFecha").attr('disabled','disabled');
		  $("#txtSerie").attr('disabled','disabled');
		  $("#btnGuardar").attr('disabled', 'disabled');
		  $("input[type=radio]").attr('disabled', 'disabled');
		  
	  }
  }
  
  function cargarCamposProgramacionIndividual(idProgramacion, tipoProgramacion, tipoRevision,fechaProgramacion,unidadAlmacenamiento,idCompartimiento,numeroSerie){
	
	  var I = $('#pIndividual').val();
	  var M = $('#pMasiva').val();
	  
	  if(I == tipoProgramacion){
		  
		  $("#pMasiva").removeAttr('checked');
		  $("#pIndividual").attr('checked','checked');
		  
	  } else if(M == tipoProgramacion) {
		    
		   $("#pIndividual").removeAttr('checked');
		   $("#pMasiva").attr('checked','checked'); 
	  }
	  
	  $("#cmbTipo option[value="+ tipoRevision +"]").attr("selected",true); 
	  $('#cmbUnidadAlmacenamiento').append('<option value="" selected="selected" >'+ unidadAlmacenamiento +'</option>');
	  $("#txtFecha").val(fechaProgramacion);
	  $("#txtSerie").val(numeroSerie);

	  mostrarTablaIMLIndivudalPorIdCompartimiento(0,idCompartimiento);
			  
  }
  
  $('#archivo').change(function() {
      var filename = $('#archivo')[0].files[0]
      $('#nombreArchivo').text(filename.name);
      window.ExcelApp.leer_excel(event); 		
  });
  
  window.ExcelApp = (function() {
	    var app = {
	    };

	    app.leer_excel = function (event) {
	        var file = event.target.files[0];
	        var reader = new FileReader();
	        reader.readAsArrayBuffer(file);
	        var json, csv, html;


	        reader.onload = function(e) {

	        	var arraybuffer = e.target.result;;
	        	
				  /* convert data to binary string */
				  var data = new Uint8Array(arraybuffer);
				  var arr = new Array();
				  for(var i = 0; i != data.length; ++i){
				  	arr[i] = String.fromCharCode(data[i]);
				  }
				  var bstr = arr.join("");

				  /* Call XLSX */
				  var workbook = XLSX.read(bstr, {type:"binary"});

				  /* DO SOMETHING WITH workbook HERE */
				  var first_sheet_name = workbook.SheetNames[0];
				  /* Get worksheet */
				  var worksheet = workbook.Sheets[first_sheet_name];
				  arrayAux = XLSX.utils.sheet_to_json(worksheet,{raw:true});
				  
				  console.log(arrayAux);
				  console.log(arrayMasiva);
	        };
	    };
	    return app;
	})();

	function comparaFechas(fecha){
		var fechaActual = new Date();

		var vua = formattedDate(fechaActual).split("/");
		var FAdia = vua[0];
		var FAmes = vua[1];
		var FAanio = vua[2].substr(-2);
		
		var va = fecha.split("/");
		var Fdia = va[0];
		var Fmes = va[1];
		var Fanio = va[2].substr(-2);

		if( (FAdia >= Fdia && FAmes >= Fmes && FAanio >= Fanio) || (FAdia < Fdia && FAmes > Fmes && FAanio >= Fanio) )
			return false;
		return true;
	}

  function llenarDatosGrilla(){

	    arrayAux.forEach(function (elemento, indice, array) {
			var objectRow = {};
			var tipoAux = "";

			tipoAux = elemento["tipo"];
			objectRow["tipo"] = elemento["tipo"];
			objectRow["numeroserie"] = elemento["numeroserie"];
			objectRow["numeroCompartimiento"] = elemento["numeroCompartimiento"];
			objectRow["fechaProgramacion"] = elemento["fechaProgramacion"];
			objectRow["idCompartimiento"] = elemento["idCompartimiento"];
			objectRow["producto"] = elemento["producto"];
			objectRow["capacidad"] = elemento["capacidad"];

			if( elemento["tipo"] !== undefined && elemento["tipo"] !== ""  &&
				elemento["fechaProgramacion"] !== undefined && elemento["fechaProgramacion"] !== ""  && 
				elemento["numeroserie"] !== undefined && elemento["numeroserie"] !== ""  && 
				elemento["numeroCompartimiento"] !== undefined && elemento["numeroCompartimiento"] !=="" &&
				elemento["idCompartimiento"] !== undefined && elemento["idCompartimiento"] !== "" &&
				elemento["producto"] !== undefined && elemento["producto"] !== "" &&
				elemento["capacidad"] !== undefined && elemento["capacidad"] !== "" ){

				if ( validarCompartimiento(elemento["numeroserie"] , elemento["numeroCompartimiento"]) > 0 ){
					if ( tipoAux.toUpperCase() == "I" || tipoAux.toUpperCase() == "L"  || tipoAux.toUpperCase() == "M" ){
						if ( comparaFechas( elemento["fechaProgramacion"] )  == true ){
							objectRow["idCompartimiento"] = idCompartimientoB;
							arrayMasiva.push(objectRow);
						}else{
							arrayFechas.push(objectRow);
							error = 1;
						}
					}else{
						arrayTipos.push(objectRow);
						error = 3;
					}
				}else{
					var nuevoObject= {};

					nuevoObject["numeroserie"] = elemento["numeroserie"];
					nuevoObject["numeroCompartimiento"] = elemento["numeroCompartimiento"];

					arrayInexistentes.push(nuevoObject);
				}
			}else{
				//error = 2;
			}
			mostrarTablaIMLMasiva(0); 
		});
	
	if(error == 1){
		ConfirmDialog('LAS FECHAS INGRESADAS NO PUEDEN SER MENOR O IGUALES A LA FECHA DE HOY');
	}else if(error == 2){
		ConfirmDialog2('ELEMENTOS VACÍOS');
	}else if(error == 3){
		ConfirmDialog('TIPO DE INSPECCION NO VÁLIDO');
	}else{
		ConfirmDialog('NO SE ENCONTRO REGISTRO DE LOS SIGUIENTES ELEMENTOS');}
}
    
    function ConfirmDialog(mensaje){
    	
		   $('<div id="nuevo"></div>').appendTo('body')
		   .html('<div id="aqui"> </div>')
		   .dialog({
		       modal: true, title: mensaje, zIndex: 10000, autoOpen: true,
		       width: 500, resizable: false,
		       buttons: {
		           Aceptar: function () {
		                               
		               $(this).dialog("close");
		           },
		       },
		       close: function (event, ui) {
		           $(this).remove();
		       }
		   });
    	

    if ( arrayInexistentes.length > 0 ){
	    arrayInexistentes.forEach(function (elemento, indice, array) {
	    	var tex = "";
	    	tex = '<h6>' + 'N° Serie: '+ elemento["numeroserie"] + ' - N° Compartimiento: ' + elemento["numeroCompartimiento"];
	    	tex = tex + '</h6>';
	    	$("#aqui").append(tex);
	    });
	}
	if ( arrayFechas.length > 0 ){
		arrayFechas.forEach(function (elemento, indice, array) {
	    	var tex = "";
	    	tex = '<h6>'  + 'N° Serie: '+ elemento["numeroserie"] + ' - Producto: ' + elemento["producto"] + ' - Fecha: '+ elemento["fechaProgramacion"];
	    	tex = tex + '</h6>';
	    	$("#aqui").append(tex);
	    });
	}
	if ( arrayTipos.length > 0 ){
		arrayTipos.forEach(function (elemento, indice, array) {
	    	var tex = "";
	    	tex = '<h6>'  + 'TIPO PRUEBA INGRESADO: '+ elemento["tipo"];
	    	tex = tex + '</h6>';
	    	$("#aqui").append(tex);
	    });
	}
 };
 
 function ConfirmDialog2(){
	
   $('<div id="nuevo2"></div>').appendTo('body')
   .html('<div id="aqui2"> </div>')
   .dialog({
       modal: true, title: 'INGRESE CORRECTAMENTE LOS DATOS', zIndex: 10000, autoOpen: true,
       width: 400, resizable: false,
       buttons: {
           Aceptar: function () {
                               
               $(this).dialog("close");
           },
       },
       close: function (event, ui) {
           $(this).remove();
       }
   });

   	var tex = "";
	tex = '<h6>' + 'LOS DATOS INGRESADOS ESTAN VACÍOS';
	tex = tex + '</h6>';
	$("#aqui2").append(tex);
	
};

function crearDescargarTabla(){

	BuscarUnidadSup(idUndSup); 

    $('.jqgfirstrow').addClass('noExl');
        
    $('td[dir="ltr"]').attr ('class', 'noExl');

    $("#tablitaMasiva").table2excel({
        exclude: ".noExl",
        name: "Excel Document Name",
        filename: "InspMantLimp",
        fileext: ".xls",
        exclude_img: true,
        exclude_links: true,
        exclude_inputs: true
    }); 
}
	
function BuscarUnidadSup(idUnidadSupervisada) {
	
	$.ajax({
        url:baseURL + "pages/InspMantLimp/BuscarCompartimientoAlm",
        type:'post',
        async:false,
        data:{
        	idUnidadSupervisada : idUnidadSupervisada
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            var tex ="";

			tex = tex + "<tr>";
			tex = tex + "<th>tanque</th>";
			tex = tex + "<th>idCompartimiento</th>";
		    tex = tex + "<th>producto</th>";
		    tex = tex + "<th>capacidad</th>";
		    tex = tex + "<th>numeroserie</th>";
		    tex = tex + "<th>numeroCompartimiento</th>";
		    tex = tex + "<th>tipo</th>";
		    tex = tex + "<th>fechaProgramacion</th>";
		    tex = tex + "</tr>";

		    if (data.tamanio > 0){
            	$.each(data.filas, function( index, value ) {

            		tex = tex + "<tr>";
				    tex = tex + '<td>'+ value.tanque +'</td>';            		
				    tex = tex + '<td>'+ value.idCompartimiento +'</td>';
				    tex = tex + '<td>'+ value.nombreProd +'</td>';
				    tex = tex + '<td>'+ value.capacidad +'</td>';
				    tex = tex + '<td>'+ value.numeroSerie +'</td>';
				    tex = tex + '<td>'+ value.numero +'</td>';
				    tex = tex + '<td></td>';
				    tex = tex + '<td>\'</td>';
				    tex = tex + "</tr>";
            		
                });
            	
            }     
            tex = tex + "<tr>";
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    tex = tex + "</tr>";

            tex = tex + "<tr>";
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    tex = tex + "</tr>"; 

            tex = tex + "<tr>";
		    // tex = tex + '<th></th>';
		    // tex = tex + '<th></th>';
		    tex = tex + '<th>LEYENDA</th>';
		    // tex = tex + '<th></th>';
		    tex = tex + '<th style="background:#FF0000">IMPORTANTE</th>';
		    // tex = tex + '<th></th>';
		    // tex = tex + '<th></th>';
		    tex = tex + "</tr>"; 

		    tex = tex + "<tr>";
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    tex = tex + '<td>I : INSPECCIÓN </td>';
		    // tex = tex + '<td></td>';
		    tex = tex + '<td style="background:#FF0000"> GUARDAR COMO LIBRO DE EXCEL </td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    tex = tex + "</tr>"; 

		    tex = tex + "<tr>";
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    tex = tex + '<td>M : MANTENIMIENTO</td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    tex = tex + "</tr>"; 

		    tex = tex + "<tr>";
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    tex = tex + '<td>L : LIMPIEZA</td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    // tex = tex + '<td></td>';
		    tex = tex + "</tr>"; 

		    $("#tablitaMasiva").append(tex);
        },
        error:errorAjax
    });
}


	function validarCompartimiento(numSerie, num) {
		var val = 0;
		$.ajax({
	        url:baseURL + "pages/InspMantLimp/BuscarCompartimientoAlm",
	        type:'post',
	        async:false,
	        data:{
	        	numeroSerie: numSerie,
	        	numero 	   : num
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            //alert(data.tamanio);

	            if (data.tamanio > 0){
	            	val = 1;

	            	$.each(data.filas, function( index, value ) {
	                    idCompartimientoB =  value.idCompartimiento;
	                });
	            }      
	        },
	        error:errorAjax
	    });
		return val;
	}

	function registroProgramacionMasiva(){

		var ultimoNumProgramacion = $("#ultimoNumProgramacion").val();
		var cadena = ultimoNumProgramacion.split("-");
		var valor = cadena[2];
		 
		 if(ultimoNumProgramacion.length > 0){
			 numProg = parseInt(valor);
		}

		arrayMasiva.forEach(function (elemento, indice, array) {

			if(elemento["tipo"].toUpperCase() =='I'){
						   
				abrevRevision ='INS';
				    
			} else if(elemento["tipo"].toUpperCase() =='M'){
						   
				abrevRevision ='MAN';
					     		
			} else if(elemento["tipo"].toUpperCase() =='L'){
							   
				abrevRevision ='LIM';		
			}   
					 
			numProg = numProg+1;
					 
			NumeroProgramacion = numProg;//String("00000" + num).slice(-5)
			
			numProgramacion = abrevRevision + "-" + $("#codOsinergmin").val() + "-" + NumeroProgramacion + "-" + anho; 

			// var dateVar =  elemento["fechaProgramacion"];
		 //    var d=new Date(dateVar);           	
			//     if((d.getMonth()+1) < 10)
			// 		var mes = '0' + (d.getMonth() + 1);
			// 	else
			// 		var mes = d.getMonth() + 1;
			// var fecha = (d.getDate() + 1) + '/' + mes + '/' + d.getFullYear()

			var fProgramacion = elemento["fechaProgramacion"];
			var cadena = fProgramacion.split("/");
			var d = cadena[0];
			var m = cadena[1];
			var a = cadena[2];
			 
			var fechaAux = m+"/"+d+"/"+a;

			$.ajax({
		          url:baseURL + "pages/InspMantLimp/RegistrarProgramacionIndividual",
		         type:'post',
		        async:false,
		        data:{
		        	
		        	   idCompartimiento : elemento["idCompartimiento"], 
		    		  fechaProgramacion : fechaAux, //elemento["fechaProgramacion"], 
		    		       tipoRevision : elemento["tipo"].toUpperCase(),
		    	cmbUnidadAlmacenamiento	: 'X',
		    		   tipoProgramacion : 'M', 
		    		 numeroProgramacion : numProgramacion,
		    		 			 estado : 'P'
		        	
		        },
		        beforeSend:muestraLoading,
		        success:function(data){
		            ocultaLoading();
		            if(data.resultado=="0"){
		        		
		            	var idProgramacion = data.idProgramacion;
		            	
		            	$.ajax({
	            	        url:baseURL + "pages/InspMantLimp/RegistrarTrazProgramacion",
	            	        type:'post',
	            	        async:false,
	            	        data:{
	            	        	           idProgramacion: idProgramacion,
	            		                           estado: 'P',
	            		                fechaUltimoEstado: fechaAux,
	            	        	
	            	        },
	            	        beforeSend:muestraLoading,
	            	        success:function(data){
	            	            ocultaLoading();
	            	            
	            	            if(data.resultado=="0"){
	            	            		           	            	
	            	            	//mensajeGrowl("sucess", global.confirm.save,"");
	            	            	
	            	            	var idUnidadSupervisada = $("#idUnidSupervisada").val();
	            	            	
	            	               /* $('#dialogFrmIndivualMasiva').dialog('close');
	            	                
	            	                if(window.top==window) {
	            	                    
	            	                    window.setTimeout('location.reload()', 50); 
	            	                    
	            	                    listarTanqueCL(0,idUnidadSupervisada);
	            	                }*/
	            	            	
	            	            	window.location.href = baseURL+'pages/InspMantLimp';
	            	            	
	            	            	listarTanqueCL(0,idUnidadSupervisada);
	            	               
	            	            }
	            	            	
	            	           
	            	        },
	            	        error:errorAjax
	            		});	
		            	 
		            }
		        },
		        error:errorAjax
			});		
			numProg++;
		});
	}
  
function mostrarTablaIMLMasiva(flg_load) {	
		
		if (flg_load === undefined) {
	        flg_load = 1;
	    }
    
	    $("#gridContenedorProgMasiva").html("");
	    
	    var grid = $("<table>", {
	        "id": "gridProgMasiva"
	    });
	    
	    var pager = $("<div>", {
	        "id": "paginacionProgMasiva"
	    });
	    
	    $("#gridContenedorProgMasiva").append(grid).append(pager);
	    
	    var nombres = ['TIPO', 'FECHA','N&Uacute;MERO SERIE TANQUE','COMPARTIMIENTO'];
	    var columnas = [
	    	
	        {name: "tipo", width: 130, sortable: false, hidden: false, align: "left", formatter:"tipoF"},
	        {name: "fechaProgramacion", width: 95, sortable: false, hidden: false, align: "left", formatter:"fechaF"},
	        {name: "numeroserie", width: 130, sortable: false, hidden: false, align: "left"},
	        {name: "numeroCompartimiento", width: 95, sortable: false, hidden: false, align: "left"},
	        
	     ];
	    
	    grid.jqGrid({
	    	data: arrayMasiva,
          	datatype: "local",
           	hidegrid: false,
           	rowNum: 5,
           	pager: "#paginacionProgMasiva",
           	emptyrecords: "No se encontraron resultados",
           	recordtext: "{0} - {1}",
           	loadtext: "Cargando",
           	colNames: nombres,
	        colModel: columnas,
	        height: "auto",
	        viewrecords: true,
	        caption: "Listado Carga Masiva",
	        jsonReader: {
	            root: "arrayMasiva",
	            page: "pagina",
	            total: "total",
	            records: "registros",
	            repeatitems: false,
	           
	        },
	        
	        onSelectRow: function(rowid, status) {
	            grid.resetSelection();
	        }, 
	        
	        loadError: function(jqXHR) {
	            errorAjax(jqXHR);
	        }
	        
	    });
	    //Tipo de Inspeccion
	    jQuery.extend($.fn.fmatter, {
	        tipoF: function(cellvalue, options, rowdata) {
	            var tipoAux=rowdata.tipo;
	            var sel = '';
	            if (tipoAux.toUpperCase() == 'I'){     
	                sel = "INSPECCIÓN";
	            }
	            if (tipoAux.toUpperCase() == 'M'){     
	                sel = "MANTENIMIENTO";
	            }
	            if (tipoAux.toUpperCase() == 'L'){     
	                sel = "LIMPIEZA";
	            }

	            return sel;
	        }
	    });
	    //Fecha
	    jQuery.extend($.fn.fmatter, {
    	fechaF: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaProgramacion;

    		var fProgramacion = rowdata.fechaProgramacion;
			var cadena = fProgramacion.split("/");
			var d = cadena[0];
			var m = cadena[1];
			var a = cadena[2];
		 
			var fechaAux = d+"/"+m+"/"+a;

            var d=new Date(dateVar);

            if(dateVar){
            	
	            if((d.getMonth()+1) < 10){
	    			var mes = '0' + (d.getMonth() + 1);
	    		} else {
	    			var mes = d.getMonth() + 1;
	    		}
	    		
	            var fecha = (d.getDate() + 1) + '-' + mes + '-' + d.getFullYear()
    		
            } else {
            	
            	var fecha= '';
    			
    		} 
    		
    		return fechaAux;
    		 
        }
    });

}