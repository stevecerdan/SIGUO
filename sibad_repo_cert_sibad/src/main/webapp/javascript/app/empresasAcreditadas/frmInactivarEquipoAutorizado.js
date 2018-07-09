var estadito;
$(function() {
    anularEnter();
    cargarMotivoInactivarEA();
    $('#btnCancelarInactivar').click(btnCancelarInactivar)
    $('#btnGuardarInactivar').click(btnGuardarInactivar);
    boton.closeDialog();
   
});

function btnCancelarInactivar(){
	$('#dialogInactivarEquipoA').dialog('close');
	$('#cmbEstado').val(0);
};

function btnGuardarInactivar(){
	
	confirm.open("¿Desea inactivar el registro?", "enviarDatos()");
}

function enviarDatos(){
	if ( $("#cmbMotivoI").val() !== "" &&  $("#cmbMotivoI").val() !== undefined ){
		if( $("#txtObservacionI").val () !== "" && $("#txtObservacionI").val () !== undefined ){
			$("#motivo").val( $("#cmbMotivoI").val().latinize());
			$("#observa").val( $("#txtObservacionI").val ().latinize() );
			$("#dialogInactivarEquipoA").dialog('close');
		}else{
			alert("INGRESE LA OBSERVACIÓN");
		}
	}else{
		alert("SELECCIONE UN MOTIVO");
	}
}

function cargarMotivoInactivarEA() {
	
	var motInactivar ="MOTIVO_INACTIVAR";
	
	    $.ajax({
	        url:baseURL + "pages/mantenimientoEmpresasAcreditadas/cargarComboTipo",
	        type:'post',
	        async:false,
	        data:{
	            dominio:motInactivar
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	        	
	            ocultaLoading();
	            fill.combo(data.filas,'idMaestroColumna','descripcion','#cmbMotivoI');
	            
	        },
	        error:errorAjax
	    });
}
