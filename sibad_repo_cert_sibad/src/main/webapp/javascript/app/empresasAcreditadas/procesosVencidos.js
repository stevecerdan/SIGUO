var idEmpresa = "";
var idAlcance = "";
var nRegistros = "";
var est = "";
var parametroDias = 0;
//---Notificaciones---
var cuerpoPlantilla = "";
var asuntoPlantilla = "";
var destinoOsinergmin  = "";
var nombrePersonal = "";
var cuerpoPlantillaD = "";
var asuntoPlantillaD = "";
//----Correo Alcances por vencer----
var idOrganismo = "";
var empresa = "";
var correo = "";
var organismo = "";
var correoOrg = "";
var IDTipoPrueba = "";
var tipoPrueba = "";
var NResCed = "";
var FVigencia = "";
var FVencimiento = "";


$(function() {
	buscarAlcanceVencido();  
	//buscarFechaProximaCalibracion();
	//BuscarSolicitudXFecha();
	//buscarCompartimiento();
});

//---- Formato Fecha ------------

function convertDateFormat(string) {
	var info = string.split('/');
	return info[1] + '/' + info[0] + '/' + info[2];	
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

//-------------------------------

function BuscarPlantillaNotificacionVCD(){
	
	$.ajax({
        url:baseURL + "pages/VerificarProcesosVencidos/traerPlantillaMsj",
        type:'post',
        async:false,
        data:{
       	 idCorreo : '22'
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            $.each(data.filas, function( index, value ) {
            	//Cuerpo de Mensaje Plantilla
                cuerpoPlantilla = value.mensaje
            	//Asunto de Mensaje Plantilla
            	asuntoPlantilla = value.asunto;
            });
            
        },
        error:errorAjax
    });
	
    //cuerpoPlantilla = "Buen dia estimado.<br>Representante de la empresa {nombre_empresa}<br><br>Se informa que el Proceso de Acreditacion de Tipo {tipo_prueba} con Nro Resolucion / Nro Cedula {resolucion_cedula}, esta a punto de vencer.<br><br>Fecha Inicio de Vigencia : {fecha_vigencia}<br>Fecha Vencimiento : {fecha_vencimiento}<br><br>Saludos cordiales,<br>Nueva Plataforma de Supervision.";
	//asuntoPlantilla = "VENCIMIENTO DE PROCESO DE ACREDITACION - {tipo_prueba}";
}

function BuscarPlantillaDestinatario(){
	
	$.ajax({
        url:baseURL + "pages/VerificarProcesosVencidos/traerPlantillaPersonal",
        type:'post',
        async:false,
        data:{
       	 idCorreo : '30',
       	 idPersonal : '156'
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            $.each(data.filas, function( index, value ) {
            	//Correo de Usuario Osinergmin
            	//destinoOsinergmin  = value.correoElectronico;
                destinoOsinergmin  = "asenjochristian@gmail.com";
                //Nombre de Personal
                nombrePersonal = value.nombreCompleto;
            	//Cuerpo de Mensaje Plantilla
                cuerpoPlantillaD = value.mensaje;
            	//Asunto de Mensaje Plantilla
            	asuntoPlantillaD = value.asunto;
            });
            
        },
        error:errorAjax
    });
	
    //destinoOsinergmin  = "asenjochristian@gmail.com"
    //cuerpoPlantillaD = "Personal Autorizado OSINERGMIN.<br>{nombre_personal}<br><br>Se confirma el envio de notificacion a la empresa {nombre_empresa}<br><br>Informando que el Proceso de Acreditacion de Tipo {tipo_prueba} con Nro Resolucion / Nro Cedula {resolucion_cedula}, esta a punto de vencer.<br><br>Fecha Inicio de Vigencia : {fecha_vigencia}<br>Fecha Vencimiento : {fecha_vencimiento}<br><br>Saludos cordiales,<br>Nueva Plataforma de Supervision.";
	//asuntoPlantillaD = "PERSONAL AUTORIZADO OSINERMGIN - NOTIFICANDO VENCIMIENTO DE PROCESO DE ACREDITACION - {tipo_prueba}";
}

function EnviarCorreoVCD(correo, empresa, tipoPrueba, NResCed, FVigencia, FVencimiento){
	
	BuscarPlantillaNotificacionVCD();
	
	var asuntoFinal = asuntoPlantilla.replace(/{tipo_prueba}/g, tipoPrueba);
	
	var mensajeFinal = cuerpoPlantilla.replace(/<br>/g, '\n').
									   replace(/{nombre_empresa}/g, empresa).
									   replace(/{tipo_prueba}/g, tipoPrueba).
									   replace(/{resolucion_cedula}/g, NResCed).
									   replace(/{fecha_vigencia}/g, FVigencia).
									   replace(/{fecha_vencimiento}/g, FVencimiento);
	
	BuscarPlantillaDestinatario();
	
	var destinatario = destinoOsinergmin;
	
	var asuntoFinDest = asuntoPlantillaD.replace(/{tipo_prueba}/g, tipoPrueba);
	
	var mensajeFinDest = cuerpoPlantillaD.replace(/<br>/g, '\n').
										  replace(/{nombre_personal}/g, nombrePersonal).
										  replace(/{nombre_empresa}/g, empresa).
										  replace(/{tipo_prueba}/g, tipoPrueba).
										  replace(/{resolucion_cedula}/g, NResCed).
										  replace(/{fecha_vigencia}/g, FVigencia).
										  replace(/{fecha_vencimiento}/g, FVencimiento);
	
	$.ajax({
	    url: baseURL + "pages/VerificarProcesosVencidos/sendEmail",
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
	    	//alert("SE LE ENVIARA UNA NOTIFICACION A LA EMPRESA PARA CONFIRMAR SU SOLICITUD");
	    },
	 	error:errorAjax
	});
	
	EnviarNotificacionDestinatarioVCD(destinatario, mensajeFinDest, asuntoFinDest);
}

function EnviarNotificacionDestinatarioVCD(destinatario,mensajeDest,asuntoDest){
	
	$.ajax({
	    url: baseURL + "pages/VerificarProcesosVencidos/sendEmail",
	    type: "get",
	    async: false,
	    data:{
		   destino : destinatario,
		   mensaje : mensajeDest,
		   asunto : asuntoDest
	    },
	    beforeSend:muestraLoading,
	    success: function (data) {
	    	ocultaLoading();
	    	//alert("NOTIFICACION LLEGO A DESTINATARIO CON EXITO");
	    },
	 	error:errorAjax
	});
}

//BUSCAR ALCANCES VENCIDOS
function buscarAlcanceVencido() {
	
	//---
	cargarTipo('1573');
	var info = tipoPrueba.split('=');
	parametroDias = parseInt(info[1]);	
	//---
	
	var d = new Date();
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());
    
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    var anio = year.toString().substring(2);

    var fx = `${month}/${day}/${anio}`;
    
    let diaNew = parseInt(day) + parametroDias;
    if (diaNew.length < 2) diaNew = '0' + diaNew

    var fechaCercana = `${month}/${diaNew}/${anio}`;
    
    //-------- BUSCAR PROCESOS A PUNTO DE VENCER Y NOTIFICAR ----------
    //alert(fechaCercana);
	
	$.ajax({
        url:baseURL + "pages/VerificarProcesosVencidos/BuscarAlcance",
        type:'post',
        async:false,
        data:{
        	estadoAccion : 'S',
            fechaVencimiento: fechaCercana
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
        	if(data.filas){
        	
	            ocultaLoading();
	            $.each(data.filas, function( index, value ) {
	            	
	            	idEmpresa = value.idEmpresaAcreditada;
	            	IDTipoPrueba = value.idTipoPrueba;
	            	NResCed = value.resolucionCedula;
	            	FVigencia = convertirFecha(value.fechaInicioVigencia);
	            	FVencimiento = convertirFecha(value.fechaVencimiento);
	            	idOrganismo = value.idOrganismoAcreditador;
	            	
	            	traerDatosEmpresaAcreditada(idEmpresa);
	            	cargarTipo(IDTipoPrueba);
	            	traerDatosOrganismoAcreditador(idOrganismo);
	            	
	            	//alert("EMPRESA: "+ empresa + " EMAIL: " + correo +" TIPO PRUEBA: " + tipoPrueba + " RESOLUCION - CEDULA: " + NResCed + " FECHA DE VIGENCIA: " + FVigencia);
	            	
	            	EnviarCorreoVCD("asenjochristian@gmail.com", empresa, tipoPrueba, NResCed, FVigencia, FVencimiento);
	            	EnviarCorreoVCD("asenjochristian@gmail.com", organismo, tipoPrueba, NResCed, FVigencia, FVencimiento);
	
	            });
	            
	            alert("=> CONFIRMANDO NOTIFICACIONES =>");
	            $('#MensajeNotificacion').html("SE ENVIARON LAS NOTIFICACIONES CON EXITO...");
	            
            }else{
            	$('#MensajeNotificacion').html("NO SE ENCONTRARON REGISTROS POR VENCER, VERIFICADOS CON EXITO...");
            }
        },
        error:errorAjax
    });
    
    /*
    //--------------- FIN BUSCAR PROCESOS A PUNTO DE VENCER Y NOTIFICAR -------------------
	
	    $.ajax({
	        url:baseURL + "pages/VerificarProcesosVencidos/BuscarAlcance",
	        type:'post',
	        async:false,
	        data:{
	            fechaVencimiento: fx
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            $.each(data.filas, function( index, value ) {
	            	
	            	idEmpresa = value.idEmpresaAcreditada;
	            	idAlcance = value.idAlcanceAcreditacion;
	            	
	            	//alert("ID EMPRESA: "+ idEmpresa + " ID ALCANCE: " + idAlcance);
	            	buscarAlcanceVigente();
	            	
	            	$.ajax({
	                    url:baseURL + "pages/VerificarProcesosVencidos/modificarEstados",
	                    type:'post',
	                    async:false,
	                    data:{
	                        idEmpresaAcreditada : idEmpresa,
	                        idAlcanceAcreditacion: idAlcance,
	                        estadoA: "I",
	                        estadoE: est,
	                        estadoAccion: "V"
	                    },
	                    beforeSend:muestraLoading,
	                    success:function(data){
	                        ocultaLoading();
	                        if(data.resultado=="0"){
	                        	registrarTraz(idAlcance);
	                        	//MensajeFinalCron
	                        	$('#MensajeFinalCron').html("ALCANCES DE ACREDITACION VENCIDOS, VERIFICADOS CON EXITO...");
	                        }
	                    },
	                    error:errorAjax
	                });
	            	//--- FIN MODIFICAR ESTADO ---
	            });
	        },
	        error:errorAjax
	    });*/
}

//----- TRAER DATOS DE EMPRESA ACREDITADA ----------
function traerDatosEmpresaAcreditada(idEmpresaAcreditada) {

    $.ajax({
        url:baseURL + "pages/VerificarProcesosVencidos/traerDatosEmpresa",
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
            	empresa = value.razonSocial;
            });
            
        },
        error:errorAjax
    });
}

//----- TRAER DATOS DE ORGANISMO ACREDITADOR ----------
function traerDatosOrganismoAcreditador(idOrganismo) {

    $.ajax({
        url:baseURL + "pages/VerificarProcesosVencidos/datosOrganismoAcreditador",
        type:'post',
        async:false,
        data:{
       	 idOrganismoAcreditador : idOrganismo
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            
            $.each(data.filas, function( index, value ) {
            	correoOrg = value.email;
            	organismo = value.nombreOrgAcreditador;
            });
            
        },
        error:errorAjax
    });
}

//Buscar Tipo Prueba en Maestro Columna
function cargarTipo(IdMaestro) {

    $.ajax({
        url:baseURL + "pages/VerificarProcesosVencidos/cargarComboTipo",
        type:'post',
        async:false,
        data:{
        	idMaestroColumna : IdMaestro
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
        	$.each(data.filas, function( index, value ) {
            	
        		tipoPrueba = value.descripcion;
        		
            });
            
        },
        error:errorAjax
    });
}

//BUSCAR ALCANCES VENCIDOS
function buscarAlcanceVigente() {
	$.ajax({
        url:baseURL + "pages/VerificarProcesosVencidos/BuscarAlcance",
        type:'post',
        async:false,
        data:{
            estado : 'A',
            idEmpresaAcreditada : idEmpresa,
            idAlcanceAcreditacion : idAlcance
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
            if (data.registros > 0){
            //nRegistros = data.registros;
            //alert(nRegistros);
            	est = "A";
	        }else{
	        	est = "I";
	        }
        },
        error:errorAjax
    });
}

function registrarTraz(idAlcance){
    $.ajax({
        url:baseURL + "pages/VerificarProcesosVencidos/RegistrarTrazabilidad",
        type:'post',
        async:false,
        data:{
                              
            idAlcanceAcreditacion: idAlcance,
            estado: 'I',
            estadoAccion: 'V'            
                               
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            }
        },
        error:errorAjax
    }); 
}

//BUSCAR FECHAS PROXIMAS DE CALIBRACION
function buscarFechaProximaCalibracion() {
	
	var d = new Date();
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());
    
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    var anio = year.toString().substring(2);

    var fpcx = `${month}/${day}/${anio}`;
	
	    $.ajax({
	        url:baseURL + "pages/VerificarProcesosVencidos/BuscarFechaProxCalibracion",
	        type:'post',
	        async:false,
	        data:{
	        	fechaProximaCalibracion: fpcx
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            $.each(data.filas, function( index, value ) {
	            	var idEquipo = value.idEquipoCertificado;
	            	
	            	//alert("EL EQUIPO CON EL ID "+ idEquipo + ", HOY ES LA FECHA DE PROXIMA CALIBRACION");
	            	
	            	$.ajax({
	                    url:baseURL + "pages/VerificarProcesosVencidos/EditarEstadoEquipoCertificado",
	                    type:'POST',
	                    async:false,
	                    data:{

	                    	id:                    idEquipo,
	                    	estado:				   "I",
	                    	idTipoMotivo:		   "1491",
	                    	observacion:		   "Cambio automatico realizado por el sistema"
	                    },
	                    beforeSend:muestraLoading,
	                    success:function(data){
	                        ocultaLoading();
	                        if(data.resultado=="0"){ 
	                        	$('#MensajeFinalCron1').html("EQUIPOS CON PROXIMA FECHA DE CALIBRACION, VERIFICADO CON EXITO...");
	                        }
	                    },
	                    error:errorAjax
	            	});	
	            	  
	            });
	        },
	        error:errorAjax
	    });
}

//LISTAR SOLICITUDES DE REPRUEBAS GNV
function BuscarSolicitudXFecha() {
	var d = new Date();
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());
    
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    var anio = year.toString().substring(2);

    var fechaActual = `${month}/${day}/${anio}`;
    
        $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/encontrarSolicitudUltimaEmpresa",
            type:'post',
            async:false,
            data:{
            	fechaProxPrueba : fechaActual
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
	            $.each(data.filas, function( index, value ) {
                	var idSolicitud = value.idSolicitudPruebaReprueba;
                    var idCilindro = value.idCilindroGNV;
                	//actualizarEstadoSolicitud(idSolicitud);
                    actualizarCilindro(idCilindro);
                });
            },
            error:errorAjax
        });
}

//ACTUALIZAR ESTADO SOLICITUD
function actualizarEstadoSolicitud(idSolicitud) {
        $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/actualizarEstadoSolicitudPruebaReprueba",
            type:'post',
            async:false,
            data:{
            	idSolicitudPruebaRp : idSolicitud,
            	estado 	: '3'
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data.resultado=="0"){ 
	                $('#MensajeCron2').html("EQUIPOS CON PROXIMA FECHA DE PRUEBA, VERIFICADO CON EXITO...");
	            }
	            
            },
            error:errorAjax
        });
}

//ACTUALIZAR ESTADO CILINDRO
function actualizarCilindro(idCilindro){
    
    $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/actualizarEstadoCilindro",
        type:'post',
        async:false,
        data:{
            
            idCilindro : idCilindro,
            estado : '3',

        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            if(data.resultado=="0"){
               
            }
        },
        error:errorAjax
    }); 
}

//BUSCAR COMPARTIMIENTO
function buscarCompartimiento() {
	var d = new Date();
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());
    
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    var anio = year.toString().substring(2);

    var fechaActual = `${month}/${day}/${anio}`;
    
        $.ajax({
            url:baseURL + "pages/InspMantLimp/retornarUltimoNumProgramacion",
            type:'post',
            async:false,
            data:{
            	fechaProxPrueba : fechaActual
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                $.each(data.filas, function( index, value ) {
                	var idCompartimiento = value.idCompartimiento;
                	var idAlmacenamiento = value.idAlmacenamiento;

                	 actualizarEstadoCompartimiento(idCompartimiento);
                	 actualizarEstadoAlmacenamiento(idAlmacenamiento);
                });
	            
            },
            error:errorAjax
        });
}

//ACTUALIZAR ESTADO COMPARTIMIENTO
function actualizarEstadoCompartimiento(idCompartimiento) {
        $.ajax({
            url:baseURL + "pages/InspMantLimp/actualizarEstadoCompartimiento",
            type:'post',
            async:false,
            data:{
            	idCompartimiento : idCompartimiento,
            	estado 	: '3'
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data.resultado=="0"){ 
	                $('#MensajeCron2').html("EQUIPOS, VERIFICADO CON EXITO...");
	            }
	            
            },
            error:errorAjax
        });
}

//ACTUALIZAR ESTADO ALMACENAMIENTO
function actualizarEstadoAlmacenamiento(idAlmacenamiento) {
        $.ajax({
            url:baseURL + "pages/InspMantLimp/actualizarEstadoAlmacenamiento",
            type:'post',
            async:false,
            data:{
            	idAlmacenamiento : idAlmacenamiento,
            	estado 	: '3'
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data.resultado=="0"){ 
	                $('#MensajeCron2').html("EQUIPOS, VERIFICADO CON EXITO...");
	            }
	            
            },
            error:errorAjax
        });
}