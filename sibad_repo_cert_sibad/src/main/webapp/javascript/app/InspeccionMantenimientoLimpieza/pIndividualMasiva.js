var ArrayDatosID = [];
var idCompartimiento = "";
var cmbUnidadAlmacenamiento = "";
var numeroSerie = "";
var fechaProgramacion = "";
var tipoRevision = "";
var tipoProgramacion = "";
var numProgramacion= "";
var abrevRevision= "";
var codOsinergmin= "";
var i = 1;

$(function() {

	//mostrarTablaIMLMasiva(0);
	mostrarTablaIMLIndivudal(0,0);
	$( "#txtFecha" ).datepicker();
	initInicio();

 });

 function initInicio(){ 
	
	confirm.start();
	
    $('#btnGuardar').click(function(){
    
    	confirm.open("¿Desea guardar el registro?","RegistrarProgramacionIndividual()");
    });
    
    $('#btnRegresar').click(function(){
    	
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
 
 function RegistrarProgramacionIndividual(){
	 
	 var fecha = new Date();
	 var ano = fecha.getFullYear();

    $.each(ArrayDatosID, function(index,value){
    	
		   idCompartimiento = value;
    cmbUnidadAlmacenamiento = $("#cmbUnidadAlmacenamiento").val();
		  fechaProgramacion = $("#txtFecha").val();
		       tipoRevision = $("#cmbTipo").val();
		   TipoProgramacion = $("#pIndividual").val();
		      codOsinergmin = $("#codOsinergmin").val();
		   
			 
		   if(tipoRevision=='I'){
			   
			   abrevRevision='INS';
			    
		      }else if(tipoRevision=='M'){
			   
			      abrevRevision='MAN';
			     		
					 }else if(sel=='L'){
						   
						 revision='LIM';		
					  }   
			  
            
		   numProgramacion = abrevRevision + "-" + codOsinergmin + "-" + i + "-" + ano;
		   
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
	        	
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){
	            	
	            	 
	            }
	        },
	        error:errorAjax
		});	
		
		 i++;
	 })
 }
 
  function enviarIdAlmacenamientoCodigoOsinergmin(idAlmacenamiento,codigoOsinergmin){
	  
	  $("#idAlmacenamientoCompartimiento").val(idAlmacenamiento);
	  $("#codOsinergmin").val(codigoOsinergmin);
	  
	  listarUnidadAlmacenamiento(idAlmacenamiento);
  }
  
  function listarUnidadAlmacenamiento(idAlmacenamiento){
	  
	 if((idAlmacenamiento != 'null') || (idAlmacenamiento !='')){

		$.ajax({
	          url:baseURL + "pages/InspMantLimp/listarUnidadAlmacenamiento",
	         type:'post',
	        async:false,
	        data:{
	        	
	        	idAlmacenamiento : idAlmacenamiento,
	        	
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
        {name: "", width: 150, sortable: false, hidden: false, align: "left"},
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
    		
            return  " <input type='checkbox'  id='"+ rowdata.idCompartimiento +"' class='filaSeleccionada' value=''>";
        
    	}
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
	    	
	        {name: "s", width: 130, sortable: false, hidden: false, align: "left"},
	        {name: "w", width: 95, sortable: false, hidden: false, align: "left"},
	        {name: "q", width: 130, sortable: false, hidden: false, align: "left"},
	        {name: "y", width: 95, sortable: false, hidden: false, align: "left"},
	        
	     ];
	    
	    grid.jqGrid({
    	   url: baseURL + "pages/InspMantLimp/listarMasivos",
           datatype: "json",
           postData: {},
	        hidegrid: false,
	        pager: "#paginacionProgMasiva",
	        emptyrecords: "No se encontraron resultados",
	        loadtext: "Cargando",
	        colNames: nombres,
	        colModel: columnas,
	        height: "auto",
	        viewrecords: true,
	        caption: "Listado",
	        autowidth: true,
	        jsonReader: {
	            root: "filas",
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
	 }
  
  $('#archivo').change(function() {
      var filename = $('#archivo')[0].files[0]
      $('#nombreArchivo').text(filename.name);
  });