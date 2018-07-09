
$(function() {
    initInicioConfirmar();
    
});

function initInicioConfirmar(){ 
	confirm.start();
	
    $('#btnAceptar').click(function(){
    	window.location.href = baseURL+'pages/solicitudPruebasHermeticidad';
        listarBandejaPruebaHermeticidad(0);
    });
    
 }

function TraerSolicitudes(contenido){
	$('#txtSolicitudes').val(contenido);
}


