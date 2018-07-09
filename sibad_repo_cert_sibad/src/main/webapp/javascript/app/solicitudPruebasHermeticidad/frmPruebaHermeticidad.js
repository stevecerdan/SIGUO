var ArrayDatosID = [];
var fecha = new Date();
var anioActual = fecha.getFullYear();
var numProg = 1;
var nroSolicitud = "";
var arrayNumeros = [];
//---
var IdCompartimiento = "";
var IdTipoPrueba = "";
var IdEmpresaAcreditada = "";
var FechaSolicitud = "";
var NroSolicitudUnidadSupervisa = "";
var CodOsinergmin = "";
//---
var correo = "";
var nroTanque = "";
var nroCompartimiento = "";
var Tprueba = "";

$(function() {
	//listarSTEinspeccionar(0);
	initInicioFrmPruebaHermeticidad();
    $('#MensajeValPH').hide();
    $('#btnGuardarPH').click(btnGuardarPruebaHermet);
    $( "#txtFecha" ).datepicker();
    $( "#txtFechaP" ).datepicker();
    $( "#txtFecha" ).attr( "readonly" , "readonly" );
    $( "#txtFechaP" ).attr( "readonly" , "readonly" );
    
});

//---- Formato Fecha ------------

function convertDateFormat(string) {
	var info = string.split('/');
	return info[1] + '/' + info[0] + '/' + info[2];	
}

//-------------------------------

function initInicioFrmPruebaHermeticidad(){ 
	confirm.start();
	$('#lblFechaP').hide();
	$('#txtFechaP').hide();
	cargarEmpresasAcreditadas();
	
	$("#txtFecha").click(function(){
		$('#MensajeValPH').hide();
    });
	
	$("#txtFecha").change(function(){
		var f = $('#txtFecha').val();
		var actual = new Date();
		
		var v = f.split("/");
		var d = v[0];
		var m = v[1];
		var a = v[2];
				
		if(actual.getDate() < 10){
			var dia = '0' + actual.getDate();
		}else{
			var dia = actual.getDate();
		}
		
		if((actual.getMonth()+1) < 10){
			var mes = '0' + (actual.getMonth() + 1);
		}else{
			var mes = actual.getMonth() + 1;
		}
		
		var anio = actual.getFullYear();
			
		//f2 = new Date (d+"/"+m+"/"+a);
		//factual = new Date(dia + '/' + mes + '/' + anio);
	
		if((d <= dia && m <= mes && a <= anio)||(d > dia && m < mes && a <= anio)){
			$('#MensajeValPH').show();
			$('#MensajeValPH').html("POR FAVOR AGREGAR UNA FECHA POSTERIOR A LA ACTUAL");
			$('#txtFecha').val('');
		}
		
    });
	
	$("#cmbAsignado").click(function(){
		$('#MensajeValPH').hide();
    });
	
	$("#cmbAsignado").change(function(){
		var EmpresaSelect = $(this).val();
		//alert(EmpresaSelect);
		verificarCompartimientosRegistrados(EmpresaSelect);
		
    });
	
	$('input[type=checkbox]:checked').click(function(){
		$('#MensajeValPH').hide();
    });
	
	$('body').on('click', '.filaSeleccionadaT',function(){
	     
	      var cadena= $(this).attr("id");

	      if(this.checked == true){
	    	   ArrayDatosID.push(cadena);  
	       }else{ 
	    	   if(this.checked == false){
	    	   var index = ArrayDatosID.indexOf(cadena);
	    	   ArrayDatosID.splice(index, 1);
	    	   }
    	   }
	     
	    });
    
    $('#btnRegresarPH').click(function(){
    	window.location.href = baseURL+'pages/solicitudPruebasHermeticidad';
    	listarBandejaPruebaHermeticidad(0);
    });
    
 }

function EnviarCorreoPrueba(correo, nombreEmp, Tprueba, NroSolicitudUnidadSupervisa, FechaSolicitud, nroTanque, nroCompartimiento){
	
	//Cuerpo de Mensaje Plantilla
	var cuerpoPlantilla = "Buen dia estimado.\nRepresentante de la empresa -\n\nSe informa que fue confirmado la solicitud de -, Nro - para el Compartimiento Nro - del Modulo Nro -.\nPor favor proceder con la atencion de la solicitud asignada.\n\nFecha Programada : -\n\nSaludos cordiales,\nNueva Plataforma de Supervision.";
	//Asunto de Mensaje Plantilla
	var asuntoPlantilla = "CONFIRMACION DE TIPO DE PRUEBA - SOLICITUD NRO. ";
	
	var CMP = cuerpoPlantilla.split('-');
	var mensajeFinal = CMP[0] +nombreEmp+ CMP[1] +Tprueba+ CMP[2] +NroSolicitudUnidadSupervisa+ CMP[3] +nroCompartimiento+ CMP[4] +nroTanque+ CMP[5] +convertDateFormat(FechaSolicitud)+ CMP[6];	
	
	var asuntoFinal = asuntoPlantilla+NroSolicitudUnidadSupervisa;
	
	var msj = "Buen dia estimado."+
		"\nRepresentante de la empresa "+nombreEmp+
		"\n\nSe informa que fue confirmado la solicitud de "+Tprueba+", Nro "+NroSolicitudUnidadSupervisa+" para el Compartimiento Nro "+nroCompartimiento+" del Modulo Nro "+nroTanque+"."+
		"\nPor favor proceder con la atencion de la solicitud asignada."+
		"\n\nFecha Programada : "+convertDateFormat(FechaSolicitud)+
		"\n\nSaludos cordiales,"+
		"\nNueva Plataforma de Supervision.";
	
	/*var asuntito = document.getElementById("msjasunto");
	asuntito.innerHTML = "CONFIRMACION DE TIPO DE PRUEBA - SOLICITUD NRO {NroSolicitudUnidadSupervisa}";
	
	var emp = nombreEmp;
	
	var mensajito = document.getElementById("msjcuerpo");
	mensajito.innerHTML = "Buen d\u00eda estimado.<br />"+
						  "Representante de la empresa {emp}<br>"+
						  "Se informa que fue confirmado la solicitud de ${Tprueba}, Nro {NroSolicitudUnidadSupervisa} para el Compartimiento Nro ${nroCompartimiento} del Modulo Nro ${nroTanque}. <br>"+
						  "Por favor proceder con la atenci\u00f3n de la solicitud asignada.<br />"+
						  "Saludos cordiales,"+
						  "Nueva Plataforma de Supervisi\u00f3n.";*/
	
	//$('#msjasunto').innerHTML = "CONFIRMACION DE TIPO DE PRUEBA - SOLICITUD NRO {NroSolicitudUnidadSupervisa}";
	
	$.ajax({
	    url: baseURL + "pages/solicitudPruebasHermeticidad/sendEmail",
	    type: "get",
	    async: false,
	    data:{
		   destino : correo,
		   mensaje : mensajeFinal,
		   asunto : asuntoFinal
	    },
	    beforeSend:muestraLoading,
	    success: function (data) {
	    	ocultaLoading();
	    	alert("NOTIFICACION ENVIADA CON EXITO");
	    },
	 	error:errorAjax
	});
}

function validarDatosFormularioPH(){
	
	if($("#txtFecha").val() =="" || $('#txtFecha').val() == undefined) {
		$('#MensajeValPH').html("POR FAVOR AGREGAR LA FECHA DE SOLICITUD");
        return false;  
    } 
	if($("#cmbAsignado").val() == "" || $("#cmbAsignado").val() == undefined){
		$('#MensajeValPH').html("POR FAVOR SELECCIONE LA EMPRESA A LA QUE SE ASIGNARÁ");
		return false;
	}
	if ($('input[type=checkbox]:checked').length === 0) {
		$('#MensajeValPH').html("POR FAVOR SELECCIONE ALMENOS UN COMPARTIMIENTO");
        return false; 	 
	}
	return true;
}

function TraerIdUnidadSupervisada(idUniSup, CodUniSup){
	$('#idUSupervisada').val(idUniSup);
	//$('#CodOsinergmin').val(CodUniSup);
	CodOsinergmin = CodUniSup;
	listarSTEinspeccionar();
}

function cargarConsultarDatosPruebaHermeticidad(idCompartimiento,empresaAcreditada,fechaSolicitud,fechaCreacion,estado){
	
	$('#idCompartimiento').val(idCompartimiento);
	$('#txtFecha').val(fechaSolicitud);
	
	$("#cmbAsignado").append('<option value ="" selected="selected">' + empresaAcreditada + '</option>');
	
	$('#aviso').val('consulta');
	
	$('#txtFecha').attr('disabled','disabled');
	$('#cmbAsignado').attr('disabled','disabled');
	
	listarSTEinspeccionar();
	$('#btnGuardarPH').hide();
	
}

function abrirConfirmarSolicitud(contenido){
	var title="CONFIRMAR SOLICITUD";
	$.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/abrirConfirmarSolicitud", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogFrmConfirmarSolicitud").html(data);
            $("#dialogFrmConfirmarSolicitud").dialog({          	
            	position: { my: 'top', at: 'top+50' },
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "305",
                modal: true,
                dialogClass: 'dialog',	
                title: title,
                closeText:"Cerrar"
            });            
        },
        error:errorAjax
    });
	TraerSolicitudes(contenido);
}

function btnGuardarPruebaHermet(){

	if(validarDatosFormularioPH() == true){
	
		confirm.open("¿Desea generar y enviar la solicitud a la empresa asignada?","RegistrarSolicitudPruebaHermeticidad()");
		//alert("Ya puede registrar");

	}else{
		
        $("#MensajeValPH").show();
        
	}
}

function RegistrarSolicitudPruebaHermeticidad(){
	
	BuscarSolicitudXEmpresa();
	
	var numeroSerie = nroSolicitud.split('-');
	var num = numeroSerie[1];
	
	var NumCorrelativo = parseInt(num);
	
	//alert(NumCor);
	
	$.each(ArrayDatosID, function(index,value){

		   IdCompartimiento = value;
  			   IdTipoPrueba = $("#idTipoPrueba").val();
		IdEmpresaAcreditada = $("#cmbAsignado").val();
		     FechaSolicitud = convertDateFormat($('#txtFecha').val());
		     
		     NumCorrelativo = NumCorrelativo + 1;
		     
		      // Aca debe hacer el Numero Correlativo
		      NroSolicitudUnidadSupervisa = "SOL Prueba Hermet. "+CodOsinergmin+"-"+NumCorrelativo+"-"+anioActual;
		      
		      //$("#txtSOL").append(NroSolicitudUnidadSupervisa+'\n');
		      
		$.ajax({
	          url:baseURL + "pages/solicitudPruebasHermeticidad/RegistrarSolicitudPruebaReprueba",
	         type:'post',
	        async:false,
	        data:{
	        	
	      idSolicitudPruebaReprueba : "",
	    nroSolicitudUnidadSupervisa : NroSolicitudUnidadSupervisa, 
	        	   	   idTipoPrueba : IdTipoPrueba,
	    		idEmpresaAcreditada : IdEmpresaAcreditada,
	    		     fechaSolicitud : FechaSolicitud,
	    		   idCompartimiento : IdCompartimiento
	    
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){
	        		
	            	var idSolicitudPruebaReprueba = data.idSolicitudPruebaReprueba;
	            	
	            	traerDatosEmpresaAcreditada(IdEmpresaAcreditada);
	            	//alert("Empresa: "+ nombreEmp + " correo: " +correo);
	            	BuscarSolicitudPH(IdTipoPrueba);
	            	//alert("Prueba: "+Tprueba+" Tanque Nro: "+nroTanque+" Comp. Nro: "+nroCompartimiento);
	            	//asenjochristian@gmail.com
	            	EnviarCorreoPrueba("syctel@gmail.com", nombreEmp, Tprueba, NroSolicitudUnidadSupervisa, FechaSolicitud, nroTanque, nroCompartimiento);
	            	
	            	//Registrar Trazabilidad
	            	$.ajax({
         	        url:baseURL + "pages/solicitudPruebasHermeticidad/RegistrarTrazSolicitud",
         	        type:'post',
         	        async:false,
         	        data:{
         	        	  idSolicitudPruebaReprueba: idSolicitudPruebaReprueba,
 		                  estado: 'P'
 		               // fechaUltimoEstado: fechaProgramacion,           	        	
         	        },
         	        beforeSend:muestraLoading,
         	        success:function(data){
         	            ocultaLoading();
         	            
         	            if(data.resultado=="0"){
         	            		           	            	
         	            	//abrirConfirmarSolicitud($("#txtSOL").val());
         	            	mensajeGrowl("sucess", global.confirm.save,"");
         	            	//window.location.href = baseURL+'pages/solicitudPruebasHermeticidad';
         	                listarBandejaPruebaHermeticidad();
         	               
         	            }
         	        },
         	        error:errorAjax
         		});
	            	
	            	var nuevoObject= {};

                    nuevoObject["numero"] = NroSolicitudUnidadSupervisa;

                    arrayNumeros.push(nuevoObject);
	            	 
	            }
	        },
	        error:errorAjax
		});	
		
	 });
	
	ConfirmDialog();
}

function ConfirmDialog(){
    $('<div id="nuevo"></div>').appendTo('body')
    .html('<div id="VSol"> </div>')
    .dialog({
        modal: true, title: 'SE REGISTRÓ LOS SIGUIENTES SOLICITUDES', zIndex: 10000, autoOpen: true,
        width: 300, resizable: false,
        buttons: {
            Aceptar: function () {              
                $(this).dialog("close");
                //$(dialogSolicitudPruebaHermeticidad).dialog("close"); 
                window.location.href = baseURL+'pages/solicitudPruebasHermeticidad';
            },
        },
        close: function (event, ui) {
            $(this).remove();
            //$(dialogSolicitudPruebaHermeticidad).dialog("close");
            window.location.href = baseURL+'pages/solicitudPruebasHermeticidad';
        }
    });

    arrayNumeros.forEach(function (elemento, indice, array) {
        var tex = "";
        tex = '<h6>' + 'Numero Solicitud: '+ elemento["numero"];
        tex = tex + '</h6>';
        $("#VSol").append(tex);
    });

 };

//----- VERIFICAR COMPARTIMIENTOS REGISTRADOS X EMPRESA ACREDITADA ----------
 function verificarCompartimientosRegistrados(ES) {

     $.ajax({
         url:baseURL + "pages/solicitudPruebasHermeticidad/encontrarSolicitudUltimaEmpresa",
         type:'post',
         async:false,
         data:{
        	 idEmpresaAcreditada : ES,
             idTipoPrueba :'1467'
         },
         beforeSend:muestraLoading,
         success:function(data){
         	
             ocultaLoading();
             
             $.each(data.filas, function( index, value ) {
             	//alert(value.idCompartimiento);
             	//$(value.idCompartimiento).closest('#gridContenedorSTEinspeccionar').remove();
             });
             
         },
         error:errorAjax
     });
 }
 
//----- TRAER DATOS DE EMPRESA ACREDITADA ----------
 function traerDatosEmpresaAcreditada(idEmpresaAcreditada) {

     $.ajax({
         url:baseURL + "pages/solicitudPruebasHermeticidad/traerDatosEmpresa",
         type:'post',
         async:false,
         data:{
        	 idEmpresaAcreditada : idEmpresaAcreditada
         },
         beforeSend:muestraLoading,
         success:function(data){
         	
             ocultaLoading();
             
             $.each(data.filas, function( index, value ) {
             	correo = value.email;
             	nombreEmp = value.razonSocial;
             });
             
         },
         error:errorAjax
     });
 }
 
//----- BUSCAR ULTIMA SOLICITUD DE PRUEBA DE HERMETICIDAD ----------
 function BuscarSolicitudPH(IdTipoPrueba) {

     $.ajax({
         url:baseURL + "pages/solicitudPruebasHermeticidad/encontrarSolicitudUltimaEmpresa",
         type:'post',
         async:false,
         data:{
             idTipoPrueba :IdTipoPrueba,
             idUnidSupervTanque :$('#idUSupervisada').val(),
             idUnidSupervModulo :'0'
         },
         beforeSend:muestraLoading,
         success:function(data){
         	
             ocultaLoading();
             
             $.each(data.filas, function( index, value ) {
            	nroTanque = value.numeroTanque;
            	nroCompartimiento = value.numeroCompartimiento;
            	Tprueba = value.tipoPrueba;
            });
         },
         error:errorAjax
     });
 }
 
//----- CARGAR EMPRESAS ACREDITADAS ----------
function cargarEmpresasAcreditadas() {

    $.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/empresasXtipoPrueba",
        type:'post',
        async:false,
        data:{
            idTipoPrueba :'1467'
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            fill.combo(data.filas,'idEmpresaAcreditada','razonSocial','#cmbAsignado');
            
            $.each(data.filas, function( index, value ) {
            	$("#idTipoPrueba").val(value.idTipoPrueba);
            });
            
        },
        error:errorAjax
    });
}

//----- BUSCAR SOLICITUD POR EMPRESA ----------
function BuscarSolicitudXEmpresa() {

    $.ajax({
        url:baseURL + "pages/solicitudPruebasHermeticidad/encontrarSolicitudUltimaEmpresa",
        type:'post',
        async:false,
        data:{
            idTipoPrueba :'1467',
            idUnidSupervTanque :$('#idUSupervisada').val(),
            idUnidSupervModulo :'0'
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            if(data.filas!="[object Object]"){
            	nroSolicitud = "SOL Prueba Hermet. 0-0-0";
            }else{
	            $.each(data.filas, function( index, value ) {
	            	nroSolicitud = value.nroSolicitudUnidadSupervisa;
	            });
            }
        },
        error:errorAjax
    });
}

function listarSTEinspeccionar(flg_load) {
	
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorSTEinspeccionar").html("");
    
    var grid = $("<table>", {
        "id": "gridSTEinspeccionar"
    });
    
    var pager = $("<div>", {
        "id": "paginacionSTEinspeccionar"
    });
    
    $("#gridContenedorSTEinspeccionar").append(grid).append(pager);
    
    var nombres = ['TANQUE','','COMPARTIMIENTO','','','CAPACIDAD','PRODUCTO','FECHA PROX. PRUEBA','OPCI&Oacute;N'];
    var columnas = [
    	{name: "numeroTanque",width: 130, sortable: false, hidden: false, align: "left", formatter:"fmtTanqueDes"},
    	{name: "idCompartimiento",width: 30, sortable: false, hidden: true, align: "left"},
    	{name: "numeroCompartimiento",width: 120, sortable: false, hidden: false, align: "left"},
    	{name: "capacidad",width: 30, sortable: false, hidden: true,align: "left"},
    	{name: "abreviaturaMedida",width: 30, sortable: false, hidden: true,align: "left"},
    	{name: "capacidadMedida",width: 130, sortable: false, hidden: false,align: "left", formatter:"fmtCapacidadMedida"},
    	{name: "nombreLargoProducto",width: 130, sortable: false, hidden: false,align: "left"},
        {name: "fechaProxPrueba",width: 125, sortable: false, hidden: false, align: "left", formatter:"fmtFechaPPT"},
        {name: "opcion",width: 80, sortable: false, hidden: false, align: "center", formatter:"OpcionesT"}
        
     ];
    
    
    grid.jqGrid({
        url: baseURL + "pages/solicitudPruebasHermeticidad/listarAlmacenamientoCompartimientoProducto",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idCompartimiento :$('#idCompartimiento').val(),
            idUnidSupervTanque :$('#idUSupervisada').val()
        },
        hidegrid: false,
        //rowNum: global.rowNumPrinc,
        rowNum: 5,
        pager: "#paginacionSTEinspeccionar",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "STE a Inspeccionar",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idProductoXCompartimiento"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
    //Botones Links
    jQuery.extend($.fn.fmatter, {
    	OpcionesT: function(cellvalue, options, rowdata) {
    		
    		if($('#aviso').val()=="consulta"){
    			return " <input type='checkbox'  name ='check' id='"+ rowdata.idCompartimiento +"'class='filaSeleccionadaT2' disabled='disabled' checked>";
    		}else{
    			return " <input type='checkbox'  name ='check' id='"+ rowdata.idCompartimiento +"' class='filaSeleccionadaT' value=''>";
    		}
        }
    });
    
  //Capacidad y Medida
    jQuery.extend($.fn.fmatter, {
    	fmtCapacidadMedida: function(cellvalue, options, rowdata) {
            var C = rowdata.capacidad;
            var M = rowdata.abreviaturaMedida;
            
            return C + " " + M;
        }
    });
    
    //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtTanqueDes: function(cellvalue, options, rowdata) {
            var NT = rowdata.numeroTanque;
            
            return "Tanque "+NT;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	fmtFechaPPT: function(cellvalue, options, rowdata) {
    		var dateVar = rowdata.fechaProxPrueba;
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
    		 
        }
    });
	
}
