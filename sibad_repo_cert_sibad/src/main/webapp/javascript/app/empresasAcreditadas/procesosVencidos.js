var idEmpresa = "";
var idAlcance = "";
var nRegistros = "";
var est = "";
$(function() {
	buscarAlcanceVencido();  
	buscarFechaProximaCalibracion();
	BuscarSolicitudXFecha();
	buscarCompartimiento();
});

//BUSCAR ALCANCES VENCIDOS
function buscarAlcanceVencido() {
	
	var d = new Date();
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());
    
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    var anio = year.toString().substring(2);

    var fx = `${month}/${day}/${anio}`;
	
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