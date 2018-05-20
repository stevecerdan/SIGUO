 $(function() {

	 initInicio();

 });
 
function initInicio(){ 
	
	confirm.start();
	 
    
    $('#btnGuardarDocAdj').click(function(){
    	
    	confirm.open("¿Desea guardar el registro?","registrar()");
    });
    
    
}

function registrar(){
	
	alert("click");
	
	var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
	alert(data);

	$.ajax({
        url:baseURL + "pages/InspMantLimp/registrar",
        enctype: 'multipart/form-data',
       type:'post',
processData: false,
contentType: false, 
cache: false,
      data: data,
      beforeSend:muestraLoading,
      success:function(data){
          ocultaLoading();
          
          
      },
      error:errorAjax
	});	
	
	
}

$('#archivo').change(function() {
    var filename = $('#archivo')[0].files[0]
    $('#nombreArchivo').text(filename.name);
});