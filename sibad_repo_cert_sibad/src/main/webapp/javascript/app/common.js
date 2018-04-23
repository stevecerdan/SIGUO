var common = (function() {
	
    function descargarDirectorio(){
    	$('#linkDirectorio').attr('href', '/sibad/pages/bandejaSupervision/descargaDirectorio');
      	$('#linkDirectorio').attr('target',"");
      	$('#linkDirectorio')[0].click();
    }
    
	return{
		descargarDirectorio:descargarDirectorio
	};
	
})();
