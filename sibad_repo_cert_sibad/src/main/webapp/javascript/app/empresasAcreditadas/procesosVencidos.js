
$(function() {
	buscarAlcanceVencido();  
	buscarFechaProximaCalibracion();
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
	            	
	            	var idEmpresa = value.idEmpresaAcreditada;
	            	var idAlcance = value.idAlcanceAcreditacion;
	            	
	            	//alert("ID EMPRESA: "+ idEmpresa + " ID ALCANCE: " + idAlcance);
	            	
	            	$.ajax({
	                    url:baseURL + "pages/VerificarProcesosVencidos/modificarEstados",
	                    type:'post',
	                    async:false,
	                    data:{
	                        idEmpresaAcreditada : idEmpresa,
	                        idAlcanceAcreditacion: idAlcance,
	                        estado: "I",
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
	            });
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

/*function registrarEquipoCertificado(){
	
	$.ajax({
        url:baseURL + "pages/VerificarProcesosVencidos/EditarEstadoEquipoCertificado",
        type:'POST',
        async:false,
        data:{

        	id:                    aux,
        	estado:				   "I",
        	idTipoMotivo:		   "",
        	observacion:		   ""
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){ 
            }
        },
        error:errorAjax
	});			
	
}*/

