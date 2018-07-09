//--------------------------------------------------------------------
// AP: Christian Wilmer Asenjo Medina
//--------------------------------------------------------------------

var estadoAux;
var letraEstado;
var idAux="";
var tipoPrueba="";
var aae = "";
var idAlcanceAcreditacionAux="";
var aai = "";
var accion = "";
var aas = "";
var accionS = "";

$(function() {
	initInicioNuevoAlcanceAcreditacion();  
	$("#MensajeFECHA").hide();
	$('#MensajeValA').hide();
	$( "#txtFechaUA" ).datepicker();
    $( "#txtFechaA" ).datepicker();
    $("#txtFechaIV").datepicker();
    $("#txtFechaV").datepicker();
    
    $( "#txtFechaUA" ).attr( "readonly" , "readonly" );
    $( "#txtFechaA" ).attr( "readonly" , "readonly" );
    $( "#txtFechaIV" ).attr( "readonly" , "readonly" );
    $( "#txtFechaV" ).attr( "readonly" , "readonly" );
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

//----------Funciones de Validaciones----------

//validar ingreso de solo numeros
function validaNumericos(event) {
    if(event.charCode >= 48 && event.charCode <= 57){
      return true;
     }
     return false;        
}

//---------------------------------------------

$("#cmbTipoPrueba").change(function(){
	var text = $("#cmbTipoPrueba option:selected").text();
	if(text=="PRUEBA DE HERMETICIDAD"){
		$("#cmbTipoOrganismo").removeAttr('disabled');
	}else{
		$("#cmbTipoOrganismo").val(0);
		$("#cmbTipoOrganismo").attr('disabled','disabled');
	}
});

function initInicioNuevoAlcanceAcreditacion(){
	confirm.start();
	//cargarTipo();
	
	desactivarBotonesSIE();
	
	//cargar o no grillas
	if($("#idAlcanceAcreditacion").val()!=""){
		$("#MensajeAS").hide();
		listarSedes(0);
		$("#MensajeAI").hide();
		listarInspector(0);
		$("#MensajeAE").hide();
		listarEquipo(0);
		activarBotonesSIE();
	}
	
	$('#txtFechaIV').change(function(){
		//Fecha Ultima Acreditacion
		var fua = $('#txtFechaUA').val();
		//Fecha Primera Acreditacion
		var fa = $('#txtFechaA').val();
		//Fecha Inicio de Vigencia
		var fiv = $('#txtFechaIV').val();
		//Fecha Vencimiento
		var fv = $('#txtFechaV').val();
		
		var vua = fua.split("/");
		var dua = vua[0];
		var mua = vua[1];
		var aua = vua[2];
		
		var va = fa.split("/");
		var da = va[0];
		var ma = va[1];
		var aa = va[2];
		
		var viv = fiv.split("/");
		var div = viv[0];
		var miv = viv[1];
		var aiv = viv[2];
		
		var vv = fv.split("/");
		var dv = vv[0];
		var mv = vv[1];
		var av = vv[2];
		
		/*if(fua!=""){
			if(dua > div && mua >= miv && aua >= aiv){
			$("#MensajeFECHA").show();
			$('#txtFechaIV').val('');
			}
		}else{
			if(da > div && ma >= miv && aa >= aiv){
			$("#MensajeFECHA").show();
			$('#txtFechaIV').val('');
			}
		}*/
		
		//Si esta la fecha de vencimiento
		if(fv!=""){
			//validar que la fecha de inicio de vigencia (iv), no sea mayor a la de vencimiento (v)
			  //dias          meses          años         dias        meses       años
			if((div >= dv && miv >= mv && aiv >= av) || (div < dv && miv > mv && aiv >= av)){
			$("#MensajeFECHA").show();
			$('#txtFechaIV').val('');
			}
		}
		
	});
	
	$('#txtFechaIV').click(function(){
		$("#MensajeFECHA").hide();
		$("#MensajeValA").hide();
	});
	
	$('#txtFechaV').change(function(){
		var fiv2 = $('#txtFechaIV').val();
		var fv2 = $('#txtFechaV').val();
		
		var viv2 = fiv2.split("/");
		var div2 = viv2[0];
		var miv2 = viv2[1];
		var aiv2 = viv2[2];
		
		var vv2 = fv2.split("/");
		var dv2 = vv2[0];
		var mv2 = vv2[1];
		var av2 = vv2[2];
		
		if((dv2 <= div2 && mv2 <= miv2 && av2 <= aiv2) || (dv2 > div2 && mv2 < miv2 && av2 <= aiv2)){
			$("#MensajeFECHA").show();
			$('#txtFechaV').val('');
		}
	});
	
	$('#txtFechaV').click(function(){
		$("#MensajeFECHA").hide();
		$("#MensajeValA").hide();
	});
	//--- ocultar mensaje de validacion vacios
	$('#cmbTipoPrueba').click(function(){
		$("#MensajeValA").hide();
	});
	
	$('#txtResolucion').click(function(){
		$("#MensajeValA").hide();
	});
	
	$('#txtRegistro').click(function(){
		$("#MensajeValA").hide();
	});
	
	$('#txtNorma').click(function(){
		$("#MensajeValA").hide();
	});
	//---------------------------------
	
	$('#btnNuevoPersonal').click(function(){
    	var aaps = $('#idAlcanceAcreditacion').val();
    	abrirNuevoPersonal(aaps);
    });
	
	$('#btnNuevaSede').click(function(){
    	aas = $('#idAlcanceAcreditacion').val();
    	accionS = "R"
    	abrirNuevaSede(aas, accionS);
    });
	
	$('body').on('click', '.MostrarDoc',function(){
		
		   var cadena= $(this).attr("id");
	 	   
	 	   var arrayCadena = cadena.split("%");
	 	   
	 	   var nombreDocumento = arrayCadena[0];
	 	   var archivoAdjunto = arrayCadena[1];
	 	   
		    $.ajax({
		        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/buscarDocumentoAdjunto",
		        type:'post',
		        async:false,
		        data:{
		        	idDocumentoAdjunto:$('#txtAdjuntarArchivo').val()
		        },
		        beforeSend:muestraLoading,
		        success:function(data){
		        	
		            ocultaLoading();
		            $.each(data.filas, function( index, value ) {
		            	
		            	var blob = new Blob([value.archivoAdjunto], {type: 'application/pdf'});
		     	 	   
		      	 	  //creamos un FileReader para leer el Blob
		      	 	  var reader = new FileReader();
		      	 	  //Definimos la función que manejará el archivo
		      	 	  //una vez haya terminado de leerlo
		      	 	  reader.onload = function (event) {
		      	 	    //Usaremos un link para iniciar la descarga 
		      	 	    var save = document.createElement('a');
		      	 	    save.href = event.target.result;
		      	 	    save.target = '_blank';
		      	 	    //Truco: así le damos el nombre al archivo 
		      	 	    save.download = value.nombreDocumento;
		      	 	    var clicEvent = new MouseEvent('click', {
		      	 	      'view': window,
		      	 	      'bubbles': true,
		      	 	      'cancelable': true
		      	 	    });
		      	 	    //Simulamos un clic del usuario
		      	 	    //no es necesario agregar el link al DOM.
		      	 	    save.dispatchEvent(clicEvent);
		      	 	    //Y liberamos recursos...
		      	 	    (window.URL || window.webkitURL).revokeObjectURL(save.href);
		      	 	  };
		      	 	  //Leemos el blob y esperamos a que dispare el evento "load"
		      	 	  reader.readAsDataURL(blob);
		            });
		            
		        },
		        error:errorAjax
		    });
		    
		    //------ otro caso...
		    
		    /*var a = document.createElement("a");
	 	    document.body.appendChild(a);
	 	    a.style = "display: none";
	 	    
 	        var blob = new File([value.archivoAdjunto], value.nombreDocumento);
 	    	//var blob = new Blob([archivoAdjunto], {type: 'application/pdf'});
 	        url = window.URL.createObjectURL(blob);
 	        a.href = url;
 	        a.download = blob.name;
 	        //a.download =nombreDocumento;
 	        a.click();
 	        window.URL.revokeObjectURL(url);*/
	 	   
		    //------------
		    
	 	   /*var blob = new Blob([archivoAdjunto], {type: 'application/pdf'});
	 	   
	 	  //creamos un FileReader para leer el Blob
	 	  var reader = new FileReader();
	 	  //Definimos la función que manejará el archivo
	 	  //una vez haya terminado de leerlo
	 	  reader.onload = function (event) {
	 	    //Usaremos un link para iniciar la descarga 
	 	    var save = document.createElement('a');
	 	    save.href = event.target.result;
	 	    save.target = '_blank';
	 	    //Truco: así le damos el nombre al archivo 
	 	    save.download = nombreDocumento;
	 	    var clicEvent = new MouseEvent('click', {
	 	      'view': window,
	 	      'bubbles': true,
	 	      'cancelable': true
	 	    });
	 	    //Simulamos un clic del usuario
	 	    //no es necesario agregar el link al DOM.
	 	    save.dispatchEvent(clicEvent);
	 	    //Y liberamos recursos...
	 	    (window.URL || window.webkitURL).revokeObjectURL(save.href);
	 	  };
	 	  //Leemos el blob y esperamos a que dispare el evento "load"
	 	  reader.readAsDataURL(blob);*/
		    
		    
		    /*var xhr = new XMLHttpRequest();
		                xhr.open('GET', baseURL + '/file', true);
		                xhr.responseType = 'blob';

		                xhr.onload = function(e) {
		                  if (this.status == 200) {
		                    var blob = new Blob([this.response], {type: 'application/pdf'});
		                    var link = document.createElement('a');
		                    link.href = window.URL.createObjectURL(blob);
		                    link.download = value.nombreDocumento;
		                    link.click();       
		                  }
		                };

		                xhr.send();*/
	 	   
});
	
	//#txtAdjuntarAlcance
	$('body').on('click', '.MostrarDocAlc',function(){
		
		   var cadena= $(this).attr("id");
	 	   
	 	   var arrayCadena = cadena.split("%");
	 	   
	 	   var nombreDocumento = arrayCadena[0];
	 	   var archivoAdjunto = arrayCadena[1];
	 	   
		    $.ajax({
		        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/buscarDocumentoAdjunto",
		        type:'post',
		        async:false,
		        data:{
		        	idDocumentoAdjunto:$('#txtAdjuntarAlcance').val()
		        },
		        beforeSend:muestraLoading,
		        success:function(data){
		        	
		            ocultaLoading();
		            $.each(data.filas, function( index, value ) {
		            	
		            	var blob = new Blob([value.archivoAdjunto], {type: 'application/pdf'});
		     	 	   
		      	 	  //creamos un FileReader para leer el Blob
		      	 	  var reader = new FileReader();
		      	 	  //Definimos la función que manejará el archivo
		      	 	  //una vez haya terminado de leerlo
		      	 	  reader.onload = function (event) {
		      	 	    //Usaremos un link para iniciar la descarga 
		      	 	    var save = document.createElement('a');
		      	 	    save.href = event.target.result;
		      	 	    save.target = '_blank';
		      	 	    //Truco: así le damos el nombre al archivo 
		      	 	    save.download = value.nombreDocumento;
		      	 	    var clicEvent = new MouseEvent('click', {
		      	 	      'view': window,
		      	 	      'bubbles': true,
		      	 	      'cancelable': true
		      	 	    });
		      	 	    //Simulamos un clic del usuario
		      	 	    //no es necesario agregar el link al DOM.
		      	 	    save.dispatchEvent(clicEvent);
		      	 	    //Y liberamos recursos...
		      	 	    (window.URL || window.webkitURL).revokeObjectURL(save.href);
		      	 	  };
		      	 	  //Leemos el blob y esperamos a que dispare el evento "load"
		      	 	  reader.readAsDataURL(blob);
		            });
		            
		        },
		        error:errorAjax
		    });
	 	   
});
	
	
	$('body').on('click', '.EditarSede',function(){
		
		   var cadena= $(this).attr("id");
	 	   
	 	   var arrayCadena = cadena.split("%");
	 	   
	 	   var id = arrayCadena[0];
	 	   var direccion = arrayCadena[1];
	 	   var idDepartamento = arrayCadena[2];
	 	   var idProvincia = arrayCadena[3];
	 	   var idDistrito = arrayCadena[4];
	 	   var idTipoDocumento = arrayCadena[5];
	 	   var numeroDocumento = arrayCadena[6];
	 	   var idCargo = arrayCadena[7];
	 	   var idSedeAcreditacion = arrayCadena[8];
	 	   
	 	   if (id == '' || id == 'null'){id = '';
	 	   } else {id =arrayCadena[0];}
	 	   
	       if (direccion == ''  || direccion == 'null'){direccion ='' ;
	       } else {direccion =arrayCadena[1] ;}
	       
	       if (idDepartamento == '' || idDepartamento == 'null'){idDepartamento ='';
	       } else {idDepartamento = arrayCadena[2];} 
	       
	       if (idProvincia == '' || idProvincia == 'null'){idProvincia ='' ;
	       } else {idProvincia = arrayCadena[3];}
	       
	       if (idDistrito == '' || idDistrito == 'null'){idDistrito ='' ;
	       } else {idDistrito = arrayCadena[4];}
	       
	      if (idTipoDocumento == '' || idTipoDocumento == 'null'){idTipoDocumento ='';
	       } else {idTipoDocumento = arrayCadena[5];} 
	       
	       if (numeroDocumento == '' || numeroDocumento == 'null'){ numeroDocumento ='' ;
	       } else {numeroDocumento = arrayCadena[6];}
	       
	       if (idCargo == '' || idCargo == 'null'){idCargo ='' ;
	       } else {idCargo = arrayCadena[7];} 
	       
	       if (idSedeAcreditacion == '' || idSedeAcreditacion == 'null'){idSedeAcreditacion ='';
	       }else{idSedeAcreditacion = arrayCadena[8];} 
	       
	       aas = $('#idAlcanceAcreditacion').val();
	       accionS = "E"
	       abrirNuevaSede(aas, accionS);
	 	   cargarDatosSede(id,direccion,idDepartamento,idProvincia,idDistrito,idTipoDocumento,numeroDocumento,idCargo,idSedeAcreditacion);

});
	
	$('#btnNuevoInspector').click(function(){
		aai = $('#idAlcanceAcreditacion').val();
		accion = "R"
    	abrirInspectorAutorizado(aai,accion);
    });
	
	$('body').on('click', '.EditarInspector',function(){
		
		   var cadena= $(this).attr("id");
	 	   
	 	   var arrayCadena = cadena.split("%");
	 	   
	 	   var id = arrayCadena[0];
	 	   var direccion = arrayCadena[1];
	 	   var idTipoDocumento = arrayCadena[2];
	 	   var numeroDocumento = arrayCadena[3];
	 	   var idEspecialidad = arrayCadena[4];
	 	   
	 	   if (id == '' || id == 'null'){id = '';
	 	   } else {id =arrayCadena[0];}
	 	   
	       if (direccion == ''  || direccion == 'null'){direccion ='' ;
	 	   } else {direccion =arrayCadena[1] ;}
	       
	       if (idTipoDocumento == '' || idTipoDocumento == 'null'){idTipoDocumento ='';
	 	   } else {idTipoDocumento = arrayCadena[2];} 
	       
	       if (numeroDocumento == '' || numeroDocumento == 'null'){numeroDocumento ='' ;
	 	   } else {numeroDocumento = arrayCadena[3];}
	       
	       if (idEspecialidad == '' || idEspecialidad == 'null'){idEspecialidad ='' ;
	 	   } else {idEspecialidad = arrayCadena[4];} 
	       
	       aai = $('#idAlcanceAcreditacion').val();
	       accion = "E"
	       abrirInspectorAutorizado(aai, accion);
	 	   cargarDatosInspector(id,direccion,idTipoDocumento,numeroDocumento,idEspecialidad);
	 	   
 });
	
	$('#btnNuevoEquipo').click(function(){
		aae = $('#idAlcanceAcreditacion').val();
		tipoPrueba = $("#cmbTipoPrueba").val();
    	abrirEquipoCertificado(aae, "", tipoPrueba);
    });
	
	$('#btnGuardarAlcance').click(function(){
	 if(validarDatosFormularioAlcance() == true){
		if($('#estadoForm').val()=="SAVE"){
			if($('#RespuestaRegistrar').val()=="REGISTRADO"){
				//$('#dialogProcesoAcreditacion').dialog('close');
				window.location.href = baseURL+'pages/mantenimientoEmpresasAcreditadas';
				//listarProcesosAcreditacion();
				//desactivarBotonProceso();
			}else{
			confirm.open("¿Desea guardar el registro?","RegistrarAlcanceAcreditacion()");
			}
		}else{
		confirm.open("¿Desea actualizar los datos del registro?","RegistrarAlcanceAcreditacion()");
		//$('#dialogProcesoAcreditacion1').dialog('close');
		//listarEmpresasAcreditadas(0);
		}
	 }else{
		 $("#MensajeValA").show();
	 }
    });
	
	$('#btnRegresarAlcance').click(function(){
		if($('#estadoForm').val()=="UPDATE"){
			//confirm.open("Si usted agregó una Sede, Inspector o Equipo, Estos datos quedaran registrados. ¿Desea Seguir?","regresarDeEdicion()");
			$('#dialogProcesoAcreditacion1').dialog('close');
			listarProcesosAcreditacion();
		}else{
			$('#dialogProcesoAcreditacion').dialog('close');
			listarProcesosAcreditacion();
		}
    });
	
	$('body').on('click', '.Eliminar',function(){
    	var id= $(this).attr("id");
        confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarPersonalAutorizado('" + id + "')");
    });
	
	$('body').on('click', '.EditarEquipo',function(){
    	var id= $(this).attr("id");
    	aae = $('#idAlcanceAcreditacion').val();
    	tipoPrueba = $("#cmbTipoPrueba").val();
    	abrirEquipoCertificado(aae, id, tipoPrueba);
    	$("#cmbEstado").removeAttr('disabled');
    	cargarComponente(); 
        LimpiarComponentesEncontrados();
		
    });   
	
	$('body').on('click', '.EliminarEquipo',function(){
        var id= $(this).attr("id");
        confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarEquipoCertificado('" + id + "')");
        //listarPersonal();
    }); 
	
	$('#uploadfile').change(function() {
		$('#MensajeValA').hide();
	    var filename = $('#uploadfile')[0].files[0]
	    $('#nombreArchivo').text(filename.name);
	    if($('#nombreArchivo').text()!=="Subir Archivo, Click Aquí"){
	    registrarDocumento();
	    }
	});
	
	$('#uploadfileA').change(function() {
		$('#MensajeValA').hide();
	    var filename = $('#uploadfileA')[0].files[0]
	    $('#nombreArchivoA').text(filename.name);
	    if($('#nombreArchivoA').text()!=="Subir Archivo, Click Aquí"){
	    registrarDocumentoA();
	    }
	});
	
	/*$('#btnAdjuntarArchivo').click(function(){
		
		//$('#nombreArchivo').text("Subir Archivo, Click Aquí");
		if($('#nombreArchivo').text()=="Subir Archivo, Click Aquí"){
			$('#MensajeValA').show();
			$('#MensajeValA').html("POR FAVOR SUBA UN ARCHIVO ANTES DE GUARDAR");
		}else{
    	//confirm.open("¿Desea guardar el archivo adjunto?","registrarDocumento()");
    	registrarDocumento();
    	//listarDocumentoAdjuntoAA(0);
		}
    });*/
	
	/*$('#btnAdjuntarAlcance').click(function(){
		
		if($('#nombreArchivoA').text()=="Subir Archivo, Click Aquí"){
			$('#MensajeValA').show();
			$('#MensajeValA').html("POR FAVOR SUBA UN ARCHIVO ANTES DE GUARDAR");
		}else{
    	//confirm.open("¿Desea guardar el documento de alcance?","registrarDocumentoA()");
    	registrarDocumentoA();
    	//listarDocumentoAlcanceAA(0);
		}
    });*/
	
	$('body').on('click', '.EliminarDocumento',function(){
		
    	var id= $(this).attr("id");
		modificarEstadoxEliminar(id);
		$('#txtAdjuntarArchivo').val("");
		desbloquearItemsDocumentoAdjunto();
		$("#gridContenedorDocAA").html("");
		$("#gridContenedorDocAA1").attr('style','margin-left:790px;');
    });
	
	$('body').on('click', '.EliminarDocumentoA',function(){
		
		var id= $(this).attr("id");
		modificarEstadoxEliminar(id);
		$('#txtAdjuntarAlcance').val("");
		desbloquearItemsAlcanceAdjunto();
		$("#gridContenedorDocAA1").html("");
		$("#gridContenedorDocAA1").removeAttr('style');
    });
    
}

function desactivarBotonesSIE(){
	//Desactivar Botones
	$('#btnNuevaSede').attr('disabled','disabled');
	$('#btnNuevaSede').attr('style','background-color:#60869a; width:150px;');
	$('#btnNuevoPersonal').attr('disabled','disabled');
	$('#btnNuevoPersonal').attr('style','background-color:#60869a; width:150px;');
	$('#btnNuevoInspector').attr('disabled','disabled');
	$('#btnNuevoInspector').attr('style','background-color:#60869a; width:150px;');
	$('#btnNuevoEquipo').attr('disabled','disabled');
	$('#btnNuevoEquipo').attr('style','background-color:#60869a; width:150px;');
}

function activarBotonesSIE(){
	//Activar Botones
	$("#btnNuevaSede").removeAttr('disabled');
	$("#btnNuevaSede").removeAttr('style');
	$('#btnNuevaSede').attr('style','width:150px');
	$('#btnNuevoPersonal').removeAttr('disabled');
	$('#btnNuevoPersonal').removeAttr('style');
	$('#btnNuevoPersonal').attr('style','width:150px');
	$('#btnNuevoInspector').removeAttr('disabled');
	$('#btnNuevoInspector').removeAttr('style');
	$('#btnNuevoInspector').attr('style','width:150px');
	$('#btnNuevoEquipo').removeAttr('disabled');
	$('#btnNuevoEquipo').removeAttr('style');
	$('#btnNuevoEquipo').attr('style','width:150px');
}

function bloquearInput(){
    $('#idAlcanceAcreditacion').attr('disabled','disabled');
    $('#txtResolucion').attr('disabled','disabled');
   // $('#txtRegistro').attr('disabled','disabled');
    //$('#txtAdjuntarArchivo').attr('disabled','disabled');
    //$('#txtAdjuntarAlcance').attr('disabled','disabled');
    bloquearItemsDocumentoAdjunto();
    bloquearItemsAlcanceAdjunto();
    $('#txtNorma').attr('disabled','disabled');
    $('#idOrganismoAcreditador').attr('disabled','disabled');  
    $('#txtFechaUA').attr('disabled','disabled');
    $('#txtFechaA').attr('disabled','disabled');
    $('#txtFechaIV').attr('disabled','disabled');
    $('#txtFechaV').attr('disabled','disabled');
    $('#cmbTipoPrueba').attr('disabled','disabled');
    $('#cmbTipoOrganismo').attr('disabled','disabled');
    $('#idEAcreditada').attr('disabled','disabled');
    $('#btnGuardarAlcance').hide();
    $('#btnRegresarAlcance').hide();
}

function bloquearItemsDocumentoAdjunto(){
	$('#uploadfile').attr('disabled','disabled');
 	$('#nombreArchivo').attr('disabled','disabled');
 	$('#nombreArchivo').attr('style','font:normal 12px "Calibri"; cursor:not-allowed; background-color:#EBEBE4;');
}

function bloquearItemsAlcanceAdjunto(){
	$('#uploadfileA').attr('disabled','disabled');
 	$('#nombreArchivoA').attr('disabled','disabled');
 	$('#nombreArchivoA').attr('style','font:normal 12px "Calibri"; cursor:not-allowed; background-color:#EBEBE4;');
}

function desbloquearItemsDocumentoAdjunto(){
	$('#uploadfile').removeAttr('disabled');
 	$('#nombreArchivo').removeAttr('disabled');
 	$('#nombreArchivo').removeAttr('style');
 	$('#nombreArchivo').attr('style','font:normal 12px "Calibri";');
}

function desbloquearItemsAlcanceAdjunto(){
	$('#uploadfileA').removeAttr('disabled');
 	$('#nombreArchivoA').removeAttr('disabled');
 	$('#nombreArchivoA').removeAttr('style');
 	$('#nombreArchivoA').attr('style','font:normal 12px "Calibri";');
}

function validarDatosFormularioAlcance(){
	
	if($("#cmbTipoPrueba").val() == "" || $("#cmbTipoPrueba").val() == undefined){
		$('#MensajeValA').html("POR FAVOR SELECCIONE UN TIPO DE PRUEBA");
		return false;
	}
	
	if($("#txtResolucion").val() =="" || $('#txtResolucion').val() == undefined) {
		$('#MensajeValA').html("POR FAVOR COLOQUE EL NUMERO DE RESOLUCIÓN O CEDULA");
        return false;  
    } 

	if($("#txtAdjuntarArchivo").val() =="" || $('#txtAdjuntarArchivo').val() == undefined) {
		$('#MensajeValA').html("POR FAVOR ADJUNTAR UN ARCHIVO");
        return false;  
    } 
	
	if($("#txtFechaIV").val() =="" || $('#txtFechaIV').val() == undefined) {
		$('#MensajeValA').html("POR FAVOR COLOQUE LA FECHA DE INICIO DE VIGENCIA");
        return false;  
    } 
	
	if($("#txtFechaV").val() =="" || $('#txtFechaV').val() == undefined) {
		$('#MensajeValA').html("POR FAVOR COLOQUE LA FECHA DE VENCIMIENTO");
        return false;  
    } 
	return true;
}

function RetornarIdEmpAcred(IdEmpresaAcreditada,estadoForm){
	
	$('#idEAcreditada').val(IdEmpresaAcreditada);
	$('#estadoForm').val(estadoForm);
	$('#idAlcanceAcreditacion').val('');
	
	if($('#estadoForm').val()=="SAVE"){
		
		TraerFechaUltimaActualizacion();
		TraerIDPrimerAlcance();
	}
		
}

function OrgAcreditadorEnAlcance(idOrgAcredEA,idCbxPrueba){
	//idOrganismoAcreditador
	$('#idOrganismoAcreditador').val(idOrgAcredEA);
	
	cargarTipo();
	$('#cmbTipoPrueba').val(idCbxPrueba);
	$('#cmbTipoPrueba').attr('disabled','disabled');
	
	if(idCbxPrueba == '1467'){
		$("#cmbTipoOrganismo").removeAttr('disabled');
		cargarTipoOrganismo();
	}else{
		$("#cmbTipoOrganismo").attr('disabled','disabled');
	}
	
	/*$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/validarOrganismoAcreditadorIngreso",
        type:'post',
        async:false,
        data:{
            idOrganismoAcreditador:idOrgAcredEA
        },
        beforeSend:muestraLoading,
        success:function(data){
        	
            ocultaLoading();
                        
            $.each(data.filas, function( index, value ) {
            	    tiposOA = value.idTipoPrueba        	
            });
            
        },
        error:errorAjax
    });*/
	

}

function cargarEditarDatosAlcance(id,resolucionCedula,idDocumentoAdjunto,idDocumentoAlcanceAcredita,normaEvaluada,idOrganismoAcreditador,fechaIVigencia,fechaUActualizacion,fechaAcreditacion,fechaVencimiento,idTipoOrganismo,idTipoPrueba,estadoForm1,idEmpresaAcreditada,idPrimerAlcanceAcreditacion){

	$('#idAlcanceAcreditacion').val(id);
	$('#txtResolucion').val(resolucionCedula);
	//$('#txtRegistro').val(registro);
	$('#txtAdjuntarArchivo').val(idDocumentoAdjunto);
	$('#txtAdjuntarAlcance').val(idDocumentoAlcanceAcredita);
	$('#txtNorma').val(normaEvaluada);
	$('#idOrganismoAcreditador').val(idOrganismoAcreditador);
	
	if(fechaUActualizacion=="31/12/1969"){
		$('#txtFechaUA').val('');
	}else{
		$('#txtFechaUA').val(fechaUActualizacion);
	}
	
	if(fechaAcreditacion=="31/12/1969"){
		$('#txtFechaA').val('');
	}else{
		$('#txtFechaA').val(fechaAcreditacion);
	}
	$('#txtFechaIV').val(fechaIVigencia);
	$('#txtFechaV').val(fechaVencimiento);
	//$('#cmbTipoPrueba').val(idTipoPrueba);
	//alert(idTipoPrueba);
	cargarTipo();
	$('#cmbTipoPrueba').val(idTipoPrueba);
	$('#cmbTipoPrueba').attr('disabled','disabled');
	
	$('#cmbTipoOrganismo').val(idTipoOrganismo);
	//$('#estadoForm').val(estadoForm1);
	$('#idEAcreditada').val(idEmpresaAcreditada);
	//idPrimerAlcanceAcreditacion
	$('#idPrimerAlcanceAcreditacion').val(idPrimerAlcanceAcreditacion);
	
	$('#estadoForm').val(estadoForm1);
	$('#RespuestaRegistrar').val("");
	   //---- desploquear combo tipo organismo
 	   var text = $("#cmbTipoPrueba option:selected").text();
		
		if(text=="PRUEBA DE HERMETICIDAD"){
			$("#cmbTipoOrganismo").removeAttr('disabled');
		}else{
			$("#cmbTipoOrganismo").val(0);
			$("#cmbTipoOrganismo").attr('disabled','disabled');
		}
		//-------------------------
		if($('#txtAdjuntarArchivo').val()!=''){
			listarDocumentoAdjuntoAA();
			bloquearItemsDocumentoAdjunto();
		}
		if($('#txtAdjuntarAlcance').val()!=''){
			listarDocumentoAlcanceAA();
			$("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:790px;');
			bloquearItemsAlcanceAdjunto();
		}
		//-------------------------
		$("#MensajeFECHA").hide();
		$("#txtFechaUA").attr('disabled','disabled');
		$("#txtFechaA").attr('disabled','disabled');
		
		$("#MensajeAS").hide();
		listarSedes();
		$("#MensajeAI").hide();
		listarInspector();
		$("#MensajeAE").hide();
		listarEquipo();
		
		activarBotonesSIE();
	
}

function cargarConsultarDatosAlcance(id,resolucionCedula,idDocumentoAdjunto,idDocumentoAlcanceAcredita,normaEvaluada,idOrganismoAcreditador,fechaIVigencia,fechaUActualizacion,fechaAcreditacion,fechaVencimiento,idTipoOrganismo,idTipoPrueba,estadoForm1,idEmpresaAcreditada,idPrimerAlcanceAcreditacion){

	$('#idAlcanceAcreditacion').val(id);
	$('#txtResolucion').val(resolucionCedula);
	//$('#txtRegistro').val(registro);
	$('#txtAdjuntarArchivo').val(idDocumentoAdjunto);
	$('#txtAdjuntarAlcance').val(idDocumentoAlcanceAcredita);
	$('#txtNorma').val(normaEvaluada);
	$('#idOrganismoAcreditador').val(idOrganismoAcreditador);
	
	if(fechaUActualizacion=="31/12/1969"){
		$('#txtFechaUA').val('');
	}else{
		$('#txtFechaUA').val(fechaUActualizacion);
	}
	
	if(fechaAcreditacion=="31/12/1969"){
		$('#txtFechaA').val('');
	}else{
		$('#txtFechaA').val(fechaAcreditacion);
	}
	$('#txtFechaIV').val(fechaIVigencia);
	$('#txtFechaV').val(fechaVencimiento);
	//$('#cmbTipoPrueba').val(idTipoPrueba);
	cargarTipo();
	$('#cmbTipoPrueba').val(idTipoPrueba);
	$('#cmbTipoPrueba').attr('disabled','disabled');
	
	$('#cmbTipoOrganismo').val(idTipoOrganismo);
	//$('#estadoForm').val(estadoForm1);
	$('#idEAcreditada').val(idEmpresaAcreditada);
	//idPrimerAlcanceAcreditacion
	$('#idPrimerAlcanceAcreditacion').val(idPrimerAlcanceAcreditacion);
	
	$('#estadoForm').val("");
	$('#RespuestaRegistrar').val("consulta");
	//------------
	$("#MensajeAS").hide();
	listarSedes(0);
	$("#MensajeAI").hide();
	listarInspector(0);
	$("#MensajeAE").hide();
	listarEquipo(0);
	
	listarDocumentoAdjuntoAA(0);
	
	if($('#txtAdjuntarAlcance').val()!=''){
		listarDocumentoAlcanceAA(0);
		$("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:790px;');
	}
	
    bloquearInput();
	
}


function RegistrarAlcanceAcreditacion(){
	
	var idAlcanceAcreditacion = $('#idAlcanceAcreditacion').val();
	
	if (idAlcanceAcreditacion =="" && idAlcanceAcreditacion ==undefined){
		
		idAlcanceAcreditacion = 'null';		
		
	} else {
		
		idAlcanceAcreditacion = $('#idAlcanceAcreditacion').val();
	}
	
	//VALIDAR VACIOS DE DOCUMENTO ALCANCE ADJUNTO
	var idDA=$('#txtAdjuntarAlcance').val();
	
	if (idDA =="0"){
		
		idDA = 'null';		
		
	} else {
		
		idDA=$('#txtAdjuntarAlcance').val();
	}
  	//-------------------------------------------
  	
	//Enviar fechas vacias
	var ultimaF = $('#txtFechaUA').val();
	if(ultimaF == ''){
		ultimaF = new Date(null);
	}else{
		ultimaF = convertDateFormat($('#txtFechaUA').val());
	}
	
	var acredF = $('#txtFechaA').val();
	if(acredF == ''){
		acredF = new Date(null);
	}else{
		acredF = convertDateFormat($('#txtFechaA').val());
	}
	
	//-------------------------------------------
	
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarAlcanceAcreditacion",
        type:'post',
        async:false,
        data:{
        		idAlcanceAcreditacion: idAlcanceAcreditacion,
		        	     idTipoPrueba: $('#cmbTipoPrueba').val(),
		        	 resolucionCedula: $('#txtResolucion').val().latinize().toUpperCase(),
		           idDocumentoAdjunto: $('#txtAdjuntarArchivo').val(),
         idDocumentoAlcanceAcreditada: idDA,
        	          idTipoOrganismo: $('#cmbTipoOrganismo').val(),
        	            normaEvualada: $('#txtNorma').val().latinize().toUpperCase(),
        	   idOrganismoAcreditador: $('#idOrganismoAcreditador').val(),
        	      idEmpresaAcreditada: $('#idEAcreditada').val(),    
          idPrimerAlcanceAcreditacion: $('#idPrimerAlcanceAcreditacion').val(),
          	//---- fechas
	        /* fechaUltimaActualizacion: newFechaUA,
	                fechaAcreditacion: newFechaA,
	              fechaInicioVigencia: newFechaIV,
	                 fechaVencimiento: newFechaV,*/
      		 fechaUltimaActualizacion: ultimaF,
      				fechaAcreditacion: acredF,
      			  fechaInicioVigencia: convertDateFormat($('#txtFechaIV').val()),
      			  	 fechaVencimiento: convertDateFormat($('#txtFechaV').val()),
             //------------------------
	                           estado: 'A',
	                     estadoAccion: 'R',
              estadoEmpresaAcreditada: 'ACTIVO',
	                       estadoForm: $('#estadoForm').val(),
        	
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	
                //$('#dialogFrmEstadoAccion').dialog('close');
                //listarProcesosAcreditacion(0);
            	 var idAA = data.idAlcanceAcreditacion;
            	 $('#idAlcanceAcreditacion').val(idAA);
            	 if($('#estadoForm').val()=="SAVE" && $('#idAlcanceAcreditacion').val()!=""){
            		 $('#RespuestaRegistrar').val("REGISTRADO");
     			 }
            	 
            	 activarBotonesSIE();
            	 
            	 if($('#estadoForm').val()=="SAVE"){
            		 
            		 mensajeGrowl("success", global.confirm.save, "");
                	 
                	 //Esconder Mensajes y Listar
                	 $("#MensajeAS").hide();
                	 listarSedes(0);
                	 $("#MensajeAI").hide();
                	 listarInspector(0);
                	 $("#MensajeAE").hide();
                	 listarEquipo(0);
                	 
                	 listarDocumentoAdjuntoAA(0);
                	 if($('#txtAdjuntarAlcance').val()!=''){
             			listarDocumentoAlcanceAA(0);
             			$("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:790px;');
             		}
            	 
            		$.ajax({
            	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/RegistrarTrazAlcanceAcred",
            	        type:'post',
            	        async:false,
            	        data:{
            	        	
            	        	    idAlcanceAcreditacion: $('#idAlcanceAcreditacion').val(),
            		                           estado: 'A',
            		                     estadoAccion: 'R',
            	        	
            	        },
            	        beforeSend:muestraLoading,
            	        success:function(data){
            	            ocultaLoading();
            	            if(data.resultado=="0"){
            	            	
            	                //$('#dialogFrmEstadoAccion').dialog('close');
            	                //listarProcesosAcreditacion(0);
            	            	/*var idAA2 = data.idAlcanceAcreditacion;
            	            	$('#idAlcanceAcreditacion').val(idAA2);
            	            	if($('#estadoForm').val()=="SAVE" && $('#idAlcanceAcreditacion').val()!=""){
            	            		$('#RespuestaRegistrar').val("REGISTRADO");
            	     			}*/
            	            	
            	            }
            	        },
            	        error:errorAjax
            		});	
            		
            		$('#txtResolucion').attr('disabled','disabled');
        			//$('#txtRegistro').attr('disabled','disabled');
        			bloquearItemsDocumentoAdjunto();
        			bloquearItemsAlcanceAdjunto();
        			$('#txtNorma').attr('disabled','disabled');	
        			$('#txtFechaUA').attr('disabled','disabled');
        			$('#txtFechaA').attr('disabled','disabled');
        			$('#txtFechaIV').attr('disabled','disabled');
        			$('#txtFechaV').attr('disabled','disabled');
        			$('#cmbTipoPrueba').attr('disabled','disabled');
        			$('#cmbTipoOrganismo').attr('disabled','disabled');
        			
            	 }
            	 
            	 if($('#estadoForm').val()=="UPDATE"){
            		 
            		 //$("#dialogProcesoAcreditacion1").dialog('close');
            		 window.location.href = baseURL+'pages/mantenimientoEmpresasAcreditadas';
            		 //mensajeGrowl("success", global.confirm.edit2, "");
            		 //dialogProcesoAcreditacion1
            		 listarEmpresasAcreditadas(0);
            	 }
            }
        },
        error:errorAjax
	});		
}

//TRAER LA FECHA DE LA ULTIMA ACTUALIZACION
function TraerFechaUltimaActualizacion() {
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarFechaUA",
	        type:'post',
	        async:false,
	        data:{
	            idEmpresaAcreditada:$('#idEAcreditada').val(),
	            idOrganismoAcreditador:$('#idOrganismoAcreditador').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            if(data.filas!="[object Object]"){
	            	
	            	/*var hoy = new Date();
	            	var dd = hoy.getDate();
	            	var mm = hoy.getMonth()+1;
	            	var yyyy = hoy.getFullYear();

	            	if(dd<10) {dd='0'+dd} 

	            	if(mm<10) {mm='0'+mm} 

	            	var fActual = dd+'/'+mm+'/'+yyyy;*/
	            	
	            	//$("#txtFechaUA").val('');
	            	//$("#txtFechaA").val(fActual);
	            	//bloquear
	            	$('#txtFechaUA').attr('disabled','disabled');
        			$('#txtFechaA').attr('disabled','disabled');
        			
	            }else{
	            
	            $.each(data.filas, function( index, value ) {
	            	var FUA = value.fechaVencimiento;
	            	
	            	var f1=new Date(FUA);
	            	
	            	if(f1.getDate() < 10){
	        			var diaf1 = '0' + f1.getDate();
	        		}else{
	        			var diaf1 = f1.getDate();
	        		}
	        		if((f1.getMonth()+1) < 10){
	        			var mesf1 = '0' + (f1.getMonth() + 1);
	        		}else{
	        			var mesf1 = f1.getMonth() + 1;
	        		}
	        		
	        		var fechaUAct = diaf1 + '/' + mesf1 + '/' + f1.getFullYear();
	        		
	            	$("#txtFechaUA").val(fechaUAct);
	            	//bloquear
	            	$('#txtFechaUA').attr('disabled','disabled');
	            	
	            });
	            }
	        },
	        error:errorAjax
	    });
}

//TRAER EL ID DEL PRIMER ALCANCE
function TraerIDPrimerAlcance() {
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarPrimerAlcance",
	        type:'post',
	        async:false,
	        data:{
	            idEmpresaAcreditada:$('#idEAcreditada').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            
	            if(data.filas!="[object Object]"){
	            	
	            	$("#idPrimerAlcanceAcreditacion").val(""); 
        			
	            }else{
	            
	            $.each(data.filas, function( index, value ) {
	            	$("#idPrimerAlcanceAcreditacion").val(value.idAlcanceAcreditacion);
	            	
	            	var FA = value.fechaInicioVigencia;
	            	var f2 = new Date(FA);
	        		
	        		if(f2.getDate() < 10){
	        			var diaf2 = '0' + f2.getDate();
	        		}else{
	        			var diaf2 = f2.getDate();
	        		}
	        		if((f2.getMonth()+1) < 10){
	        			var mesf2 = '0' + (f2.getMonth() + 1);
	        		}else{
	        			var mesf2 = f2.getMonth() + 1;
	        		}
	        		
	        		var fechaAcred = diaf2 + '/' + mesf2 + '/' + f2.getFullYear();
	        		
	            	$("#txtFechaA").val(fechaAcred);
	            	//bloquear
        			$('#txtFechaA').attr('disabled','disabled');
	            	
	            });
	            }
	        },
	        error:errorAjax
	    });
}

function cargarTipo() {

	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	        	dominio: 'TIPO_PRUEBA',
	        	aplicacion: 'SIBAD'
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbTipoPrueba');
	            
	        },
	        error:errorAjax
	    });
}

function cargarTipoOrganismo() {
	
	var encuentro = "TIPO_ORGANISMO";

	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	            dominio:encuentro
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbTipoOrganismo');
	            
	        },
	        error:errorAjax
	    });
}

function eliminarPersonalAutorizado(id){
	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/eliminarPersonalAutorizado",
        type:'post',
        async:false,
        data:{
        	idPersonalAut: id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	//mensajeGrowl("success", global.confirm.delete, "");
                listarSedes();
                listarInspector();
            }else{
                //mensajeGrowl("error", data.mensaje, "");
            	//alert("NO PUDO SER ELIMINADO");

            }
        },
        error:errorAjax
    });
}

function eliminarEquipoCertificado(id){
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/eliminarEquipoCertificado",
        type:'post',
        async:false,
        data:{
            idEquipoCertificado: id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                //alert("ELIMINADO!!");
            	//mensajeGrowl("success", global.confirm.delete, "");
            	listarEquipo();
            }else{
                //mensajeGrowl("error", data.mensaje, "");
                //alert("NO PUDO SER ELIMINADO");

            }
        },
        error:errorAjax
    });
}

function abrirNuevaSede(aas, accionS){ 
	
	if(accionS == "R"){
		var title="AGREGAR SEDE";
	}else{
		var title="EDITAR SEDE";
	}
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirNuevaSede", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogNuevaSede").html(data);
            $("#dialogNuevaSede").dialog({
            	position: ['center', 'top+20'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "730",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        	IdAlcanceASede(aas);
            
        },
        error:errorAjax
    });
}

function abrirNuevoPersonal(aaps){ 
	
	var title="AGREGAR PERSONAL AUTORIZADO";
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirNuevoPersonalSede", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogPersonalSede").html(data);
            $("#dialogPersonalSede").dialog({
            	position: ['center', 'top+20'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "605",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
            IdAlcanceAPersonalSede(aaps);
        },
        error:errorAjax
    });
}

function abrirInspectorAutorizado(aai, accion){ 
	
	if(accion == "R"){
		var title="AGREGAR INSPECTOR AUTORIZADO";
	}else{
		var title="EDITAR INSPECTOR AUTORIZADO";
	}
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirInspectorAutorizado", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogInspectorAutorizado").html(data);
            $("#dialogInspectorAutorizado").dialog({
            	position: ['center', 'top+20'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "605",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
            IdAlcanceAInspector(aai);
        },
        error:errorAjax
    });
}


function abrirEquipoCertificado(aae, id, tipoPrueba){ 
	
	var title;
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/abrirEquipoCertificado", 
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogEquipoCertificado").html(data);
           if(id == "" || id == undefined){
        		title="NUEVO EQUIPO AUTORIZADO";
        		//$("#dialogEquipoCertificado").append(" <input type='hidden' name='idEquipoCertificado' id='idEquipoCertificado' value='0'/> ");
        		$("#dialogEquipoCertificado").append(" <input type='hidden' name='idpruebaHermeticidad' id='idpruebaHermeticidad' value='"+tipoPrueba+"'/> ");
        		$("#dialogEquipoCertificado").append(" <input type='hidden' name='aviso' id='aviso' value='save'/> ");
           }
           if(id !== "" && id !== undefined){
        	   title="EDITAR EQUIPO AUTORIZADO";
        	   $("#dialogEquipoCertificado").append(" <input type='hidden' name='idEquipoCertificado' id='idEquipoCertificado' value='"+id+"'/> ");
               $("#dialogEquipoCertificado").append(" <input type='hidden' name='idpruebaHermeticidad' id='idpruebaHermeticidad' value='"+tipoPrueba+"'/> ");
               $("#dialogEquipoCertificado").append(" <input type='hidden' name='aviso' id='aviso' value='update'/> ");
               //alert("Editar: " + id);
           }
            
            $("#dialogEquipoCertificado").dialog({
            	position: ['center', 'top+20'],
            	resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "630",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar",
                open: function( event, ui ) {
            	cargarEquipoCertificado();
                }
            });
            IdAlcanceAEquipo(aae);
        },
        error:errorAjax
    });
}

//Listar Sedes
function listarSedes(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorSedes").html("");
    
    var grid = $("<table>", {
        "id": "gridSedes"
    });
    
    var pager = $("<div>", {
        "id": "paginacionSedes"
    });
    
    $("#gridContenedorSedes").append(grid).append(pager);


    var nombres = ['','N°','','DIRECCI&Oacute;N','', '', '','dpto', 'prov', 'dist', 'UBIGEO','','tipoDoc', 'numeroDoc', 'nombre', 'apellidoPaterno', 'apellidoMaterno', 'PERSONA AUTORIZADA PARA FIRMAR LOS CERTIFICADOS / INFORMES DE INSPECCI&Oacute;N','','CARGO','CIP','OPCION'];
    var columnas = [
        {name: "idSedePersonalAutorizado", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "NS", width: 20, sortable: false, hidden: false, align: "center", fomatter:"NumeroFilasS"},
        {name: "idSedeAcreditacion", width: 30, sortable: false, hidden: true, align: "center"},
        {name: "direccion", width: 180, sortable: false, hidden: false, align: "left"},
        {name: "idDepartamento", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "idProvincia", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "idDistrito", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "departamento", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "provincia", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "distrito", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "ubigeo", width: 150, sortable: false, hidden: false, align: "center", formatter:"concatenaUbigeo"},
        {name: "idTipoDocumento", width: 30, sortable: false, hidden: true, align: "center"},
        {name: "tipoDocumento", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "numeroDocumento", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "nombre", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "apellidoPaterno", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "apellidoMaterno", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "personaAutorizada", width: 300, sortable: false, hidden: false, align: "left", formatter:"concatenaPersonalAutorizado"},
        {name: "idCargo", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "especialidadCargo", width: 180, sortable: false, hidden: false, align: "center"},
        {name: "cip", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "opcion", width: 100, sortable: false, hidden: false, align: "center", formatter:"OpcionesE"}
    ];
    
    var flag = "A";
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarSedePersonalAutorizado",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            flagPersonalAutorizado: flag,
            idAlcanceAcreditacion: $('#idAlcanceAcreditacion').val()
        },
        hidegrid: false,
        rowNum: 2,
        pager: "#paginacionSedes",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "SEDES CUBIERTAS POR LA ACREDITACIÓN",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idSedePersonalAutorizado"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Conteo de filas
    jQuery.extend($.fn.fmatter, {
    	NumeroFilasS: function(cellvalue, options, rowdata) {
          var n = $("#gridContenedorSedes tr").index() + 1;
          return n;
        }
    });
    
    //Concatenar
    jQuery.extend($.fn.fmatter, {
    	concatenaUbigeo: function(cellvalue, options, rowdata) {
            var EAdpto=rowdata.departamento;
            var EAprov=rowdata.provincia;
            var EAdist=rowdata.distrito;
            var sel = '';
            if (EAdpto != null && EAprov != '' && EAprov != undefined && EAprov != undefined){     
            	sel = EAdpto+' - '+EAprov+' - '+EAdist;
            }
            return sel;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	concatenaPersonalAutorizado: function(cellvalue, options, rowdata) {
            var TD=rowdata.tipoDocumento;
            var ND=rowdata.numeroDocumento;
            var N=rowdata.nombre;
            var AP=rowdata.apellidoPaterno;
            var AM=rowdata.apellidoMaterno;
            var sel = '';
            if (TD != null && ND != '' && ND != undefined && ND != undefined){     
            	sel = TD+' '+ND+' - '+N+' '+AP+' '+AM;
            }
            return sel;
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesE: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
    		if($('#RespuestaRegistrar').val()=="consulta"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    			
    		//iconbutton = "<img src=\"" + baseURL + "/../images/page_white_edit.png\" class='EditarSede' id='"+ rowdata.idSedePersonalAutorizado +"' style=\"cursor: pointer;\" title=\"Editar\"/>"+"\t\t"+
    		//"<img src=\"" + baseURL + "/../images/eliminar.gif\" class='Eliminar' id='"+ rowdata.idSedePersonalAutorizado +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>";
    		
			iconbutton = "<a class='EditarSede' id='"+ rowdata.idSedePersonalAutorizado +"%"+rowdata.direccion+"%"+rowdata.idDepartamento+"%"+rowdata.idProvincia+"%"+rowdata.idDistrito+"%"+rowdata.idTipoDocumento+"%"+rowdata.numeroDocumento+"%"+ rowdata.idCargo +"%"+ rowdata.idSedeAcreditacion +"' style='cursor: pointer;text-decoration:none;' ><u> Editar </u></a>"+"\t"+
      	 	"<a class='Eliminar' id='"+ rowdata.idSedePersonalAutorizado  +"' style='cursor: pointer;text-decoration:none;' ><u> Eliminar </u></a>";
        		
            return iconbutton;
    		}
        }
    });
}

//Listar Inspector
function listarInspector(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorInspector").html("");
    
    var grid = $("<table>", {
        "id": "gridInspector"
    });
    
    var pager = $("<div>", {
        "id": "paginacionInspector"
    });
    
    $("#gridContenedorInspector").append(grid).append(pager);


    var nombres = ['','N°', 'DIRECCI&Oacute;N','dpto', 'prov', 'dist', 'UBIGEO','','TIPO DOCUMENTO', 'NUMERO', 'nombre', 'apellidoPaterno', 'apellidoMaterno', 'PERSONA','','ESPECIALIDAD','CIP','OPCION'];
    var columnas = [
        {name: "idSedePersonalAutorizado", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "NI", width: 20, sortable: false, hidden: false, align: "center", formatter:"NumeroFilasI"},
        {name: "direccion", width: 148, sortable: false, hidden: false, align: "left"},
        {name: "departamento", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "provincia", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "distrito", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "ubigeo", width: 120, sortable: false, hidden: false, align: "center", formatter:"concatenaUbigeo"},
        {name: "idTipoDocumento", width: 30, sortable: false, hidden: true, align: "center"},
        {name: "tipoDocumento", width: 90, sortable: false, hidden: false, align: "center"},
        {name: "numeroDocumento", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "nombre", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "apellidoPaterno", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "apellidoMaterno", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "personaAutorizada", width: 200, sortable: false, hidden: false, align: "left", formatter:"concatenaPersona"},
        {name: "idEspecialidad", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "especialidadCargo", width: 148, sortable: false, hidden: false, align: "center"},
        {name: "cip", width: 90, sortable: false, hidden: false, align: "center"},
        {name: "opcion", width: 100, sortable: false, hidden: false, align: "center", formatter:"OpcionesE2"}
    ];
    
    var flag = "S";
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarSedePersonalAutorizado",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            flagPersonalAutorizado: flag,
            idAlcanceAcreditacion: $('#idAlcanceAcreditacion').val()
        },
        hidegrid: false,
        rowNum: 2,
        pager: "#paginacionInspector",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "INSPECTOR AUTORIZADO",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idSedePersonalAutorizado"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Conteo de filas
    jQuery.extend($.fn.fmatter, {
    	NumeroFilasI: function(cellvalue, options, rowdata) {
          var n = $("#gridContenedorInspector tr").index() + 1;
          return n;
        }
    });
    
    //Concatenar
    jQuery.extend($.fn.fmatter, {
    	concatenaUbigeo: function(cellvalue, options, rowdata) {
            var EAdpto=rowdata.departamento;
            var EAprov=rowdata.provincia;
            var EAdist=rowdata.distrito;
            var sel = '';
            if (EAdpto != null && EAprov != '' && EAprov != undefined && EAprov != undefined){     
            	sel = EAdpto+' - '+EAprov+' - '+EAdist;
            }
            return sel;
        }
    });
    
    jQuery.extend($.fn.fmatter, {
    	concatenaPersona: function(cellvalue, options, rowdata) {
            var N=rowdata.nombre;
            var AP=rowdata.apellidoPaterno;
            var AM=rowdata.apellidoMaterno;
            var sel = '';
            if (N != null && AP != '' && AP != undefined && AP != undefined){     
            	sel = N+' '+AP+' '+AM;
            }
            return sel;
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesE2: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
    		
			if($('#RespuestaRegistrar').val()=="consulta"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    		
    		//iconbutton = "<img src=\"" + baseURL + "/../images/page_white_edit.png\" class='EditarInspector' id='"+ rowdata.idSedePersonalAutorizado +"' style=\"cursor: pointer;\" title=\"Editar\"/>"+"\t\t"+
    		//"<img src=\"" + baseURL + "/../images/eliminar.gif\" class='Eliminar' id='"+ rowdata.idSedePersonalAutorizado +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>";
    		
    		iconbutton = "<a class='EditarInspector' id='"+ rowdata.idSedePersonalAutorizado +"%"+rowdata.direccion+"%"+rowdata.idTipoDocumento+"%"+rowdata.numeroDocumento+"%"+ rowdata.idEspecialidad +"' style='cursor: pointer;text-decoration:none;' ><u> Editar </u></a>"+"\t"+
  	 	   	"<a class='Eliminar' id='"+ rowdata.idSedePersonalAutorizado  +"' style='cursor: pointer;text-decoration:none;' ><u> Eliminar </u></a>";
    		
    		return iconbutton;
    		}
			
		}
    });
}

//Listar Equipo
function listarEquipo(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorEquipo").html("");
    
    var grid = $("<table>", {
        "id": "gridEquipo"
    });
    
    var pager = $("<div>", {
        "id": "paginacionEquipo"
    });
    
    $("#gridContenedorEquipo").append(grid).append(pager);


    var nombres = ['','N°', 'TIPO DE EQUIPO','DESCRIPCION', 'FECHA CALIBRACION', 'FECHA PROXIMA CALIBRACION', 'ESTADO','OPCION'];
    var columnas = [
        {name: "idEquipoCertificado", width: 20, sortable: false, hidden: true, align: "center"},
        {name: "NE", width: 20, sortable: false, hidden: false, align: "center", formatter:"NumeroFilasE"},
        {name: "tipoEquipo", width: 150, sortable: false, hidden: false, align: "left"},
        {name: "descripcionEquipo", width: 130, sortable: false, hidden: false, align: "left"},
        {name: "fechaCalibracion", width: 110, sortable: false, hidden: false, align: "center", formatter:"fmtFechaC"},
        {name: "fechaProximaCalibracion", width: 110, sortable: false, hidden: false, align: "center", formatter:"fmtFechaPC"},
        {name: "estado", width: 100, sortable: false, hidden: false, align: "center", formatter:"fmtEstadoEquipo"},
        {name: "opcion", width: 120, sortable: false, align: "center", formatter:"OpcionesEE"}
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarEquipoCertificado",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idAlcanceAcreditacion: $('#idAlcanceAcreditacion').val()
            //idAlcanceAcreditacion: "1"
        },
        hidegrid: false,
        rowNum: 2,
        pager: "#paginacionEquipo",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "EQUIPOS CERTIFICADOS",
        //autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idEquipoComponente"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            //estadoAux = rowData.estado;
            idAux = rowData.idEquipoCertificado;
            //alert("onCellSelect: " +idAux);
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Conteo de filas
    jQuery.extend($.fn.fmatter, {
    	NumeroFilasE: function(cellvalue, options, rowdata) {
          var n = $("#gridContenedorEquipo tr").index() + 1;
          return n;
        }
    });
    
  //Fecha Calibracion
    jQuery.extend($.fn.fmatter, {
    	fmtFechaC: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaCalibracion;
    		var d=new Date(dateVar);
    		
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
    		
    		var fecha = dia + '-' + mes + '-' + d.getFullYear()
    		return fecha;
    		 
        }
    });
    
  //Fecha Proxima Calibracion
    jQuery.extend($.fn.fmatter, {
    	fmtFechaPC: function(cellvalue, options, rowdata) {
    		
    		var dateVar = rowdata.fechaProximaCalibracion;
    		var d=new Date(dateVar);
    		
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
    		
    		var fecha = dia + '-' + mes + '-' + d.getFullYear()
    		return fecha;
    		 
        }
    });
    
  //Estado
    jQuery.extend($.fn.fmatter, {
    	fmtEstadoEquipo: function(cellvalue, options, rowdata) {
            var sel = rowdata.estado;
            var tex ='';
            if(sel=='A'){
            	tex='ACTIVO';
            }else{
        		tex='INACTIVO';
            }
            return tex;
        }
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesEE: function(cellvalue, options, rowdata) {
    		
    		if($('#RespuestaRegistrar').val()=="consulta"){
    			
    			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
    			
    		}else{
    		
    		return "<a class='EditarEquipo' id='"+ rowdata.idEquipoCertificado  +"' style='cursor: pointer;text-decoration:none;' ><u> Editar </u></a>"+"\t"+
 	 	   "<a class='EliminarEquipo' id='"+ rowdata.idEquipoCertificado  +"' style='cursor: pointer;text-decoration:none;' ><u> Eliminar </u></a>";
    		}
        }
    });
}

//REGISTRAR DOCUMENTO ADJUNTO
function registrarDocumento(){
	
	var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
	//alert(data);

	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarDocumentoAdjunto",
        enctype: 'multipart/form-data',
       type:'post',
processData: false,
contentType: false, 
cache: false,
      data: data,
      beforeSend:muestraLoading,
      success:function(data){
          ocultaLoading();
          if(data.resultado=="0"){
          	 var idDoc = data.idDocumentoAdjunto;
          	 $('#txtAdjuntarArchivo').val(idDoc);
          	 listarDocumentoAdjuntoAA(0);
          	 if($('#txtAdjuntarAlcance').val()!=""){
          	 $("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:790px;');
          	 }
          	 bloquearItemsDocumentoAdjunto();
		 }
          
      },
      error:errorAjax
	});		
}

//REGISTRAR DOCUMENTO ALCANCE
function registrarDocumentoA(){
	
	var form1 = $('#fileUploadForm')[0];
    var data1 = new FormData(form1);
	//alert(data1);

	$.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/registrarDocumentoAlcance",
        enctype: 'multipart/form-data',
       type:'post',
       processData: false,
       contentType: false, 
       cache: false,
      data: data1,
      beforeSend:muestraLoading,
      success:function(data){
          ocultaLoading();
          if(data.resultado=="0"){
           	 var idDocA = data.idDocumentoAdjunto;
           	 $('#txtAdjuntarAlcance').val(idDocA);
           	 listarDocumentoAlcanceAA(0);
           	 if($('#txtAdjuntarArchivo').val()!=""){
           	 $("#gridContenedorDocAA1").attr('style','margin-top:-60px; margin-left:790px;');
           	 }else{
       		 $("#gridContenedorDocAA1").attr('style','margin-left:790px;');
           	 }
           	 bloquearItemsAlcanceAdjunto();
 		 }
          
      },
      error:errorAjax
	});		
}

function modificarEstadoxEliminar(idDocumento){
	
    $.ajax({
        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/modificarEstadoEliminarDocumento",
        type:'post',
        async:false,
        data:{
            idDocumentoAdjunto : idDocumento,
            estadoDocumento: "0"
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

//Listar Documento Adjunto Alcance Acreditacion
function listarDocumentoAdjuntoAA(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocAA").html("");
    
    var grid = $("<table>", {
        "id": "gridDocAA"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocAA"
    });
    
   $("#gridContenedorDocAA").append(grid).append(pager);

   //, formatter:"LinkURL"

    var nombres = ['','DOCUMENTO','','OPCION'];
    var columnas = [
    	{name: "idDocumentoAdjunto", width: 30, sortable: false, hidden: true, align: "center"},
        {name: "nombreDocumento", width: 168, sortable: false, hidden: false, align: "left", formatter:"LinkURL"},
        {name: "archivoAdjunto", width: 30, sortable: false, hidden: true, align: "left"},
        {name: "opcion", width: 50, sortable: false, align: "center", formatter:"OpcionesDA"}
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarDocumentoAdjunto",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idDocumentoAdjunto: $('#txtAdjuntarArchivo').val()
        },
        hidegrid: false,
        rowNum: 1,
        //pager: "#paginacionDocAA",
        emptyrecords: "No se encontraron resultados",
        //recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        //caption: "DOCUMENTO ADJUNTO",
        //autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idDocumentoAdjunto"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Link Mostrar Documento
    jQuery.extend($.fn.fmatter, {
    	LinkURL: function(cellvalue, options, rowdata) {
			
    		//var arch = rowdata.archivoAdjunto;
    		
    		//var blob = new Blob([arch], {type: 'application/octet-binary'});
    		//var url = URL.createObjectURL(blob);
    		
    		return "<a class='MostrarDoc' id='"+rowdata.idDocumentoAdjunto+"' style='cursor: pointer;text-decoration:none;' ><u>"+rowdata.nombreDocumento+"</u></a>";
    		
    		//  http://docs.google.com/viewer?url=nombre_archivo.extension
			//return "<a href='http://docs.google.com/viewer?url="+url+"' title='Mostrar Archivo' target='_blank'>"+rowdata.nombreDocumento+"</a>";
			
    	}
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesDA: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
    	
		if($('#RespuestaRegistrar').val()=="consulta" || $('#RespuestaRegistrar').val()=="REGISTRADO"){
			
			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
			
		}else{	
    		iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarDocumento' id='"+ rowdata.idDocumentoAdjunto +"'style=\"cursor: pointer;\" title=\"Eliminar\"/>"  
    		return iconbutton;
        }
    	}
    });
}

//Listar Documento Alcance Acreditacion
function listarDocumentoAlcanceAA(flg_load) {

	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocAA1").html("");
    
    var grid = $("<table>", {
        "id": "gridDocAA1"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocAA1"
    });
    
   $("#gridContenedorDocAA1").append(grid).append(pager);

    var nombres = ['','DOCUMENTO','','OPCION'];
    var columnas = [
    	{name: "idDocumentoAdjunto", width: 30, sortable: false, hidden: true, align: "center"},
        {name: "nombreDocumento", width: 168, sortable: false, hidden: false, align: "left",formatter:"LinkURL2"},
        {name: "archivoAdjunto", width: 30, sortable: false, hidden: true, align: "left"},
        {name: "opcion", width: 50, sortable: false, align: "center", formatter:"OpcionesDAA"}
    ];
    
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoEmpresasAcreditadas/listarDocumentoAdjunto",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idDocumentoAdjunto: $('#txtAdjuntarAlcance').val()
        },
        hidegrid: false,
        rowNum: 1,
        //pager: "#paginacionDocAA1",
        emptyrecords: "No se encontraron resultados",
        //recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        //caption: "DOCUMENTO ADJUNTO",
        //autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idDocumentoAdjunto"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    
  //Link Mostrar Documento
    jQuery.extend($.fn.fmatter, {
    	LinkURL2: function(cellvalue, options, rowdata) {
			
    		//var arch = rowdata.archivoAdjunto;
    		
    		//var blob = new Blob([arch], {type: 'application/octet-binary'});
    		//var url = URL.createObjectURL(blob);
    		
    		return "<a class='MostrarDocAlc' id='"+ rowdata.nombreDocumento +"%"+rowdata.archivoAdjunto+"' style='cursor: pointer;text-decoration:none;' ><u>"+rowdata.nombreDocumento+"</u></a>";
    		
    		//  http://docs.google.com/viewer?url=nombre_archivo.extension
			//return "<a href='http://docs.google.com/viewer?url="+url+"' title='Mostrar Archivo' target='_blank'>"+rowdata.nombreDocumento+"</a>";
			
    	}
    });
    
    //Opciones
    jQuery.extend($.fn.fmatter, {
    	OpcionesDAA: function(cellvalue, options, rowdata) {
    		var iconbutton ='';
    		
		if($('#RespuestaRegistrar').val()=="consulta" || $('#RespuestaRegistrar').val()=="REGISTRADO"){
			
			return "<img src=\"" + baseURL + "/../images/cancel2.png\" style=\"cursor: pointer;\" title=\"SOLO LECTURA\"/>"
			
		}else{
    		iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='EliminarDocumentoA' id='"+ rowdata.idDocumentoAdjunto +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"
    		return iconbutton;
    	}
		
        }
    });
}
