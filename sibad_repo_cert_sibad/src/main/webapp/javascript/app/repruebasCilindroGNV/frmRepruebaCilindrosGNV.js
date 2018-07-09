var arrayIdDocumentAdj  =  [];
var dataDocumentAdj     =  [];
var nombreDocumento     =  "";
var idDocumentoAdjunto  =  "";
var idSedePersonal      =  "";
var idResultadoPR       =  "";
var idResultadoPP       =  "";
var idResultadoPD       =  "";
var idUnidadSupervisada =  "";
var idSolicitudPR       =  "";
var fechaInicio         =  "";
var fechaFin            =  "";
var fechaEmision        =  "";
var fechaGNV            =  "";
var horaInicio          =  "";
var horaFin             =  "";
var resultadoRep        =  "";
var codCertificado      =  "";
var observacion         =  "";
var estadoSolicitud     =  "";
var estadoRegistro      =  "";
var idCilindroGlobal  =  "";


$(function() {
  
  $( "#txtFechaInicio" ).datepicker({ minDate: 0 });
  $( "#txtFechaFin" ).datepicker({ minDate: 0 });
  $( "#txtFechaProxReprueba" ).datepicker({minDate: 0 });
  $("#txtFechaEmision").datepicker({minDate: 0});
  $("#txtFechaInforme").datepicker({
    minDate: 0, 
  });

  $( "#txtFechaInforme" ).attr( "readonly" , "readonly" );
  $( "#txtFechaInicio" ).attr( "readonly" , "readonly" );
    $( "#txtFechaFin" ).attr( "readonly" , "readonly" );
    $( "#txtFechaEmision" ).attr( "readonly" , "readonly" );
    $( "#txtFechaProxReprueba" ).attr( "readonly" , "readonly" );
    $( "#txtFechaProxReprueba" ).prop( "disabled", true );
  
  fechaActual();
  initInicio();
  initDialogs();
  listarDocumentosLocal(0);
  
});

function formattedDate(d = new Date) {
    let day = String(d.getDate());
    let month = String(d.getMonth() + 1);
    const year = String(d.getFullYear());

    if (day.length < 2) day = '0' + day;
    if (month.length < 2) month = '0' + month;

    return `${day}/${month}/${year}`;
}

function convertDateFormat(string) {
  var info = string.split('/');
  return info[1] + '/' + info[0] + '/' + info[2];
}

function initInicio(){
  confirm.start();
            
    $("#txtFechaInicio").change(function(){
      
    var fecha = new Date();

    var fecha1 = $("#txtFechaInicio").val();
    var fecha2 = $("#txtFechaFin").val();
    var fechaI = $("#fechaSolicitud").val();

    var valor1 = fecha1.split("/");
    var dia1 =  valor1[0];
    var mes1 =  valor1[1];
    var año1 =  valor1[2];
     
    var valor2= fecha2.split("/");
    var dia2 =  valor2[0];
    var mes2 =  valor2[1];
    var año2 =  valor2[2];
     
    var valor3 = fechaI.split("/");
    var dia =  valor3[0];
    var mes =  valor3[1];
    var año =  valor3[2];

    var f1 = new Date(año1, mes1, dia1); 
        var fi = new Date(año, mes, dia); 
        var f2 = new Date(año2, mes2, dia2); 

        if(fechaI.length > 0){
            
          if(f1 >= fi){
        
      }else{ 

              var addhtml2 = 'Fecha no válida.';
          $("#dialog-message-content").html(addhtml2);
          $("#dialog-message").dialog("open");
         
          $("#txtFechaInicio").val(""); 
         
              return false;
              
      }
       }
    });
    
    $("#txtFechaFin").change(function(){
      
    var fecha = new Date();

    var fecha1 = $("#txtFechaInicio").val();
    var fecha2 = $("#txtFechaFin").val();
    var fechaI = $("#fechaSolicitud").val();

    var valor1 = fecha1.split("/");
    var dia1 =  valor1[0];
    var mes1 =  valor1[1];
    var año1 =  valor1[2];
     
    var valor2= fecha2.split("/");
    var dia2 =  valor2[0];
    var mes2 =  valor2[1];
    var año2 =  valor2[2];
     
    var valor3 = fechaI.split("/");
    var dia =  valor3[0];
    var mes =  valor3[1];
    var año =  valor3[2];

    var f1 = new Date(año1, mes1, dia1); 
        var fi = new Date(año, mes, dia); 
        var f2 = new Date(año2, mes2, dia2); 

        if(fechaI.length > 0){
            
          if(f1 >= fi  && f1 < f2){
        
      }else{ 
        
        var addhtml2 = 'Fecha no válida.';
          $("#dialog-message-content").html(addhtml2);
          $("#dialog-message").dialog("open");
         
          $("#txtFechaFin").val("");
          
          return false;
      }
       }
    });

    $("#txtFechaEmision").change(function() {
        $( "#txtFechaProxReprueba" ).prop( "disabled", false );

        var fechaD = $("#txtFechaEmision").val();
        var valor1 = fechaD.split("/");
        var d =  valor1[0];
        var m =  valor1[1];
        var a =  valor1[2];

        var ffecha = new Date(m+'/'+d+'/'+a); 


        var suma = parseInt('5');
        ffecha.setFullYear(ffecha.getFullYear() + suma);
        ffecha.setDate(ffecha.getDate() + suma);
        var valor = formattedDate(ffecha).split("/");
            var dia =  valor[0];
        var mes =  valor[1];
        var anio =  valor[2];

      $("#txtFechaProxReprueba").val( dia + '/' + mes + '/' + anio );
        $( "#txtFechaProxReprueba" ).datepicker( "option", "maxDate", dia + '/' + mes + '/' + anio ); 
    //  $("#txtFechaProxReprueba").datepicker({
    //    minDate: 0 ,
    //    maxDate: new Date(selectedDate),
    // //       Date(anio +'/'+ (mes) +'/'+ dia),
    //  });
    });
    
    $("#cmbResultReprueba").change(function() {
        if ($("#cmbResultReprueba").val() == 'A'){
          $("#mostrarFieldset2").hide();
          $("#mostrarFieldset").show();
        }else{
          if ($("#cmbResultReprueba").val() == 'C'){
            $("#mostrarFieldset").hide();
            $("#mostrarFieldset2").show();

            if( $("#txtFechaInicio").val() !== "" && $("#txtFechaInicio").val() !== undefined){
                var fechaI = $("#txtFechaInicio").val();
            
              var valor1 = fechaI.split("/");
              var dia =  valor1[0];
              var mes =  valor1[1];
              var anio =  valor1[2];
              $( "#txtFechaInforme" ).datepicker( "option", "maxDate", dia + '/' + mes + '/' + anio ); 
            }
          }else{
            $("#mostrarFieldset").hide();
            $("#mostrarFieldset2").hide();
          }
        }
    });

    $("#txtFechaInicio").change(function() {
       var fechaI = $("#txtFechaInicio").val();
            
       var valor1 = fechaI.split("/");
       var dia =  valor1[0];
       var mes =  valor1[1];
       var anio =  valor1[2];
       $( "#txtFechaInforme" ).datepicker( "option", "maxDate", dia + '/' + mes + '/' + anio );       
    });

    $("#uploadfile").change(function() {
        
      var filename = $("#uploadfile")[0].files[0];
      
        $('#nombreArchivo').text(filename.name); 
        $("#btnAgregarDoc").prop("disabled", this.files.length == 0);
      
    });

    $('#btnAgregarDoc').click(function(){
        confirm.open("¿Desea guardar el registro?","registrarDoc()");
    });
    
    $('body').on('click', '#registroRV',function(){
      
      registrarReprueba();   
    });
    
    $('#btnGuardarRegistroReprueba').click(function(){
        
      camposQueFaltanRegistrar();
    });
    
    //DescargarDocGNV
    $('body').on('click', '.DescargarDocGNV',function(){
    
        var cadena= $(this).attr("id");
        
        var arrayCadena = cadena.split("%");
        
        var nombreDocumento = arrayCadena[0];
        var archivoAdjunto = arrayCadena[1];
         
        var blob = new Blob([archivoAdjunto], {type: 'application/pdf'});
         
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
        reader.readAsDataURL(blob);
    });
   
    $('#btnFinalizarRegistroReprueba').click(function(){
      
      estadoSolicitud =  "F";
        idResultadoPR   =  $("#idResultadoPR").val();
        estadoRegistro  =  $("#estadoRegistro").val();
        
        var txtFechaInicio = $("#txtFechaInicio").val();
       
         if(txtFechaInicio.length <= 0) {
           
           var addhtml2 = 'Ingrese una fecha de inicio.';
           $("#dialog-message-content").html(addhtml2);
           $("#dialog-message").dialog("open");
             
          return false;
         }
         
      var txtFechaFin =$("#txtFechaFin").val();
          
         if(txtFechaFin.length <= 0) {
            
            var addhtml2 = 'Ingrese una fecha de fin.';
          $("#dialog-message-content").html(addhtml2);
          $("#dialog-message").dialog("open");
           
          return false;
          }
         
      var txtHoraInicioH = $("#txtHoraInicioH").val();      
        
         if(txtHoraInicioH.length <= 0) {
          
           var addhtml2 = 'Ingrese una hora de inicio.';
           $("#dialog-message-content").html(addhtml2);
           $("#dialog-message").dialog("open");
           
              return false;
         }
         
      var txtHoraFinH = $("#txtHoraFinH").val();      
        
         if(txtHoraFinH.length <= 0) {
          
           var addhtml2 = 'Ingrese una hora de fin.';
           $("#dialog-message-content").html(addhtml2);
           $("#dialog-message").dialog("open");
           
               return false;
         } 
      
      var txtCodCertificado = $('#txtCodCertificado').val();
      
         if(txtCodCertificado.length <= 0) {
          
           var addhtml2 = 'Ingrese Número de Certificado de Inspección.';
           $("#dialog-message-content").html(addhtml2);
           $("#dialog-message").dialog("open");
           
               return false;
         }
      
      var txtFechaEmision = $('#txtFechaEmision').val();
     
       if(txtFechaEmision.length <= 0) {
          
          var addhtml2 = 'Ingrese una fecha de emisión.';
        $("#dialog-message-content").html(addhtml2);
        $("#dialog-message").dialog("open");
         
        return false;
         } 
            
      var cmbResultReprueba = $('#cmbResultReprueba').val();
    
          if(cmbResultReprueba.length <= 0) {
          
          var addhtml2 = 'Seleccione un resultado prueba.';
        $("#dialog-message-content").html(addhtml2);
        $("#dialog-message").dialog("open");
         
        return false;
          }
          
      var cmbInspector = $('#cmbInspector').val();
      
          if(cmbInspector.length <= 0) {
          
          var addhtml2 = 'Seleccione un Inspector .';
        $("#dialog-message-content").html(addhtml2);
        $("#dialog-message").dialog("open");
         
        return false;
          } 
      
      var txtFechaProxReprueba = $('#txtFechaProxReprueba').val();
      
          if(txtFechaProxReprueba.length <= 0) {
          
          var addhtml2 = 'Ingrese una fecha próxima de prueba.';
        $("#dialog-message-content").html(addhtml2);
        $("#dialog-message").dialog("open");
         
        return false;
          } 
        
       if (dataDocumentAdj.length <= 0) {
      
        var addhtml2 = 'Falta agregar documento .';
      $("#dialog-message-content").html(addhtml2);
      $("#dialog-message").dialog("open");
     
            return false;
      }
      

        if(estadoRegistro == "EN_REGISTRO"){
          
          confirm.open("No podrá realizar cambios. ¿Desea finalizar el registro?","registrarResultadoPR('" + estadoSolicitud +"','"+ idResultadoPR +"')");
          
        } else if(estadoRegistro == "NUEVO_REGISTRO"){
          
          confirm.open("No podrá realizar cambios. ¿Desea finalizar el registro?","registrarResultadoPR('" + estadoSolicitud +"','"+ idResultadoPR +"')");
        }
      
    });
    
    $('#btnRegresarReprueba').click(function(){
     
      $('#dialogFrmReprueba').dialog('close');
      
    });
    
    $('body').on('click', '.eliminarDoc',function(){
        
      var cadena= $(this).attr("id");
        var arrayCadena=cadena.split("%");
        
        idDocumentoAdjunto = arrayCadena[0];
        idResultadoPD      = arrayCadena[1];
        
        confirm.open("¿Ud est&aacute; seguro de Eliminar?","eliminarDoc('" + idResultadoPD + "','" + idDocumentoAdjunto + "')");
    });
};


function fechaActual(){
  
    $( "#fechaActual" ).datepicker({
      dateFormat: "dd/mm/yy",
      firstDay: 1
  }).datepicker("setDate", new Date()); 
} 

function initDialogs() {
    
  $("#dialog-message").dialog({
    
       modal : true,
    autoOpen : false,
     buttons : {
      'Ok' : {
            text : 'Ok',
            id : 'button-id',
            click : function(){
              $(this).dialog("close");
            }
        } 
    }
  });

  $("#dialog-message_registroRV").dialog({
    
    modal : true,
    autoOpen : false,
    buttons : {
      'Ok' : {
            text : 'Ok',
            id : 'registroRV',
            click : function(){
              $(this).dialog("close");
            }
        } 
    }
  });
}

function formatFecha(fecha){
  
  var dateVar = fecha;
  var d=new Date(dateVar);
  
  if((d.getMonth()+1) < 10){
    var mes = '0' + (d.getMonth() + 1);
  }else{
    var mes = d.getMonth() + 1;
  }
  
  return  d.getDate()  + '/' + mes + '/' + d.getFullYear();
}

function formatoFecha(fecha){
  
  var info = fecha.split('/');
  
    return info[1] + '/' + info[0] + '/' + info[2];
    
}

function registrarReprueba(){
  
   estadoSolicitud =  "E";
    idResultadoPR   =  $("#idResultadoPR").val();
    estadoRegistro  =  $("#estadoRegistro").val();
   
   if(estadoRegistro == "EN_REGISTRO"){
    
    confirm.open("¿Desea guardar el registro?","registrarResultadoPR('" + estadoSolicitud +"','"+ idResultadoPR +"')");
    
   } else if(estadoRegistro == "NUEVO_REGISTRO"){
    
    confirm.open("¿Desea guardar el registro?","registrarResultadoPR('" + estadoSolicitud +"','"+ idResultadoPR +"')");
   }
}

function camposQueFaltanRegistrar() {
  
    var fechaInicio = "";
       var fechaFin = "";
     var horaInicio = "";
        var horaFin = "";
 var CodCertificado = "";
   var FechaEmision = "";
 var ResultReprueba = "";
      var Inspector = "";
var FechaProxReprueba = "";
      var documento = "";
     var encontrado = "";
     var fechaInforme ="";
     var numeroInforme = "";

if ($("#cmbResultReprueba").val() == 'A'){
                     
var txtFechaInicio = $("#txtFechaInicio").val();
     
   if(txtFechaInicio.length <= 0) {
         
     fechaInicio = '<span style="padding-left: 20px;">Seleccionar una fecha de inicio.</span><br>';
      encontrado = 1;       
  } 

 var txtCodCertificado = $('#txtCodCertificado').val();
    
       if(txtCodCertificado.length <= 0) {
        
          CodCertificado = '<span style="padding-left: 20px;">Ingresar Número de Certificado.</span><br>';
              encontrado = 1; 
       }
    
 var txtFechaEmision = $('#txtFechaEmision').val();
   
     if(txtFechaEmision.length <= 0) {
      
       FechaEmision = '<span style="padding-left: 20px;">Ingresar una fecha de emisión.</span><br>';  
         encontrado = 1;  
     } 
        
 var cmbResultReprueba = $('#cmbResultReprueba').val();
  
   if(cmbResultReprueba.length <= 0) {
      
       ResultReprueba = '<span style="padding-left: 20px;">Seleccionar un resultado prueba.</span><br>';
           encontrado = 1;  
   }
   
 var cmbInspector = $('#cmbInspector').val();
    
   if(cmbInspector.length <= 0) {
      
       Inspector = '<span style="padding-left: 20px;">Seleccionar un Inspector.</span><br>';
      encontrado = 1; 
   } 
    
 var txtFechaProxReprueba = $('#txtFechaProxReprueba').val();
    
   if(txtFechaProxReprueba.length <= 0) {
      
       FechaProxReprueba = '<span style="padding-left: 20px;">Ingresar una fecha próxima de prueba.</span><br>';    
            encontrado = 1; 
   } 
     
 if (dataDocumentAdj.length <= 0) {
      
        documento = '<span style="padding-left: 20px;">Agregar documento.</span><br>';
       encontrado = 1;
 }
}else{
  if ($("#cmbResultReprueba").val() == 'C'){
    if( $("#txtFechaInforme").val() == "" || $("#txtFechaInforme").val() == undefined || 
        $("#txtNumeroInforme").val() == "" || $("#txtNumeroInforme").val() == undefined){
      fechaInforme = '<span style="padding-left: 10px;">Ingresar fecha y numero de informe correctamente.</span><br>';    
      encontrado = 2;      
    }

  }
}
   

if (encontrado == 1) {
  
  var addhtml2 = "Faltan campos obligatorios por llenar:"+"<br><br>"+ fechaInicio + CodCertificado + FechaEmision + ResultReprueba + Inspector + FechaProxReprueba + documento;
    
     $("#dialog-message-content_registroRV").html(addhtml2);       
     $("#dialog-message_registroRV").dialog("open"); 
  
   return false;

 } else {
    if (encontrado == 2){
      var addhtml2 = fechaInforme+"<br>";
    
      $("#dialog-message-content_registroRV").html(addhtml2);      
      $("#dialog-message_registroRV").dialog("open"); 
      $("#dialog-message_registroRV").dialog({
        title:'FALTAN CAMPOS OBLIGATORIOS POR LLENAR',
        buttons: {
            Aceptar: function () {              
                $(this).dialog("close");
            },
        },
      });  
      return false;
    }else  
      registrarReprueba();
 }

}

function repruebaCilindrosGNV(idUnidadSupervisada,idEmpresaAcreditada,nombreEmpresa,modulo,cilindro,fechaSolicitud,idSolicitudPR,estado,idResultadoPR,numeroSerie,idcilindro){

  $("#txtFechaInicio").val(fechaSolicitud);
  $('#idUnidadSupervisada').val(idUnidadSupervisada); 
  $('#idEmpresaSupervisada').val(idEmpresaAcreditada);
  $('#txtEmpAcreditada').text(nombreEmpresa);
  $('#txtModulo').text(modulo);
  $('#txtCilindro').text(cilindro);
  $('#txtNroSerie').text(' '+numeroSerie);
  $('#fechaSolicitud').val(fechaSolicitud);
  $('#idSolicitudPR').val(idSolicitudPR);
  $("#idResultadoPR").val(idResultadoPR);
  $('#estadoRegistro').val(estado);
  idCilindroGlobal = idcilindro;
  
    if(estado == "NUEVO_REGISTRO"){
      
      cargarInspector(idEmpresaAcreditada);
      cargarOperador(idUnidadSupervisada);
      
    } else if(estado == "EN_REGISTRO"){
            
      cargarInspector(idEmpresaAcreditada);
      cargarOperador(idUnidadSupervisada);
      listarResultadoPruebaReprueba(idResultadoPR);
      llenarArrayTbDocumentos(idResultadoPR);
    
    } else if(estado == "CONSULTAR"){
      
        cargarInspector(idEmpresaAcreditada);
      cargarOperador(idUnidadSupervisada);
      listarResultadoPruebaReprueba(idResultadoPR);
      llenarArrayTbDocumentos(idResultadoPR);
    }
    

}

function bloquearDesbloquearCampos(Rpt){
  
  if(Rpt == 'BLOQUEAR'){
    
    $("#txtFechaInicio").attr('disabled','disabled');
    $('#txtFechaFin').attr('disabled','disabled');  
    $('#txtHoraInicioH').attr('disabled','disabled');
    $('#txtHoraFinH').attr('disabled','disabled');
    $('#txtCodCertificado').attr('disabled','disabled');
    $('#txtFechaEmision').attr('disabled','disabled');
    $('#cmbResultReprueba').css({pointerEvents: "none"});
    $('#cmbInspector').css({pointerEvents: "none"});
    $('#txtFechaProxReprueba').attr('disabled','disabled');;
    $("#txtObservacion").attr('disabled','disabled');
    $("#uploadfile").attr('disabled','disabled');
    $(".eliminarDoc").css({pointerEvents: "none"});
    $("#btnGuardarRegistroReprueba").attr('disabled','disabled');
    $("#btnFinalizarRegistroReprueba").attr('disabled','disabled');
  }
  
  
}
$('#cmbResultReprueba').on('change', function() {
  
  var resultado;
  
  switch ($(this).val()) {
      
      case "A":
        resultado = "APROBADO";
          break;
      case "C":
        resultado = "CONDENADO";
          break;
      case "R":
        resultado = "RECHAZADO";
  }
     
  $('#txtResultado').text(resultado);

 });


function listarResultadoPruebaReprueba(idResultadoPruebaReprueba){
  
    $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/listarResultadoPruebaReprueba",
        type:'post',
        async:false,
        data:{
          idResultadoPruebaReprueba  : idResultadoPruebaReprueba,                
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
                         
            $.each(data.filas, function( index, value ) {
              
              var resultado;
              
              switch (value.resultadoPrueba) {
                  
                  case "A":
                    resultado = "APROBADO";
                      break;
                  case "C":
                    resultado = "CONDENADO";
                      break;
                  case "R":
                    resultado = "RECHAZADO";
              }
              
              $("#txtFechaInicio").val(formatFecha(value.fechaInicio));
              $('#txtFechaFin').val(formatFecha(value.fechaFin)); 
              $('#txtHoraInicioH').val(value.horaInicio);
              $('#txtHoraFinH').val(value.horaFin);
              $('#txtResultado').text(resultado);
              $('#txtCodCertificado').val(value.numeroCertificado);
              $('#txtFechaEmision').val(formatFecha(value.fechaEmisionCertificado));
              $('#cmbResultReprueba option[value="'+ value.resultadoPrueba +'"]').attr("selected", true);
              $('#txtFechaProxReprueba').val(formatFecha(value.fechaProximaPrueba));
              $("#txtObservacion").val(value.observacion);
              
              consultarPersonalAutorizado(idResultadoPruebaReprueba)
              
              
            });
            
        },
        error:errorAjax
    });
}

function consultarPersonalAutorizado(idResultadoPruebaReprueba){
  
  $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/consultarTablaResultadoPruebaPersonal",
        type:'post',
        async:false,
        data:{
           idResultadoPruebaReprueba : idResultadoPruebaReprueba,          
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();

         if(data.registros > 0){
           
          $.each(data.filas, function( index, value ) {
              
            $('#cmbInspector option[value="'+ value.idSedePersonalAutorizado +'"]').attr("selected", true);
            });
           
         }

        },
        error:errorAjax
    });
}

function registrarResultadoPR(estadoSolicitud,idResultadoPruebaReprueba){
    if(idResultadoPR !== 'null'){
    
    idResultadoPR = idResultadoPruebaReprueba;
    
  }else{
    
    idResultadoPR = "";
  }
  
  idSolicitudPR  =  $('#idSolicitudPR').val();
    horaInicio     =  $('#txtHoraInicioH').val();
    horaFin        =  $('#txtHoraFinH').val();
    codCertificado =  $('#txtCodCertificado').val();
    resultadoRep   =  $('#cmbResultReprueba').val();
    observacion    =  $('#txtObservacion').val();
    var fechaInforme;
    
    if(estadoSolicitud == 'C'){
        if ( $("#txtFechaInforme").val() == "" ||  $("#txtFechaInforme").val() == undefined)
          fechaInforme = new Date("");
        else
          fechaInforme = new Date( $("#txtFechaFin").val() );
    }
    
    
    if ( $("#txtFechaFin").val() == "" ||  $("#txtFechaFin").val() == undefined){
        
     fechaFin = new Date( $("#txtFechaFin").val() );
     
   } else {
        
     fechaFin = formatoFecha($("#txtFechaFin").val());  
  }
      
  if ( $("#txtFechaInicio").val() == "" ||  $("#txtFechaInicio").val() == undefined){
        
     fechaInicio  = new Date( $("#txtFechaInicio").val() );
  
  } else {
          
     fechaInicio  = formatoFecha($("#txtFechaInicio").val());       
  }
  
  if ( $("#txtFechaEmision").val() == "" ||  $("#txtFechaEmision").val() == undefined){
        
     fechaEmision  = new Date( $("#txtFechaEmision").val() );
  
  } else {
         
     fechaEmision  = formatoFecha($("#txtFechaEmision").val());       
  }
  
  if ( $("#txtFechaProxReprueba").val() == "" ||  $("#txtFechaProxReprueba").val() == undefined){
        
    fechaGNV  = new Date( $("#txtFechaProxReprueba").val() );
  
  } else {
         
    fechaGNV  = formatoFecha($("#txtFechaProxReprueba").val());       
  }

    $.ajax({
         url:baseURL + "pages/repruebasCilindroGNV/registrarResultadoPruebaReprueba",
        type:'post',
       async:false,
        data:{
          idResultadoPR  : idResultadoPR,
          idSolicitudPR  : idSolicitudPR,
          fechaInicio    : fechaInicio,
            horaInicio     : horaInicio,
            fechaFin       : fechaFin, 
            horaFin        : horaFin,
            codCertificado : codCertificado,
            fechaEmision   : fechaEmision, 
            resultadoRep   : resultadoRep,
            fechaGNV       : fechaGNV,
            observacion    : observacion, 
            fechaInforme   : fechaInforme,
            numeroInforme  : $("#txtNumeroInforme").val()         
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
               
                if(data.resultado=="0"){
                  
                  idUnidadSupervisada  =  $("#idUnidadSupervisada").val();
                    idResultadoPR  =  data.idResultadoPruebaReprueba;
                         
                    $("#idResultadoPR").val(idResultadoPR);
                actualizarCilindro();                    
                actualizarEstadoSolicitudPruebaReprueba(estadoSolicitud,idSolicitudPR);
                    listarRepruebas(0,idUnidadSupervisada)
                consultarTablaResultadoPruebaPersonal(idResultadoPR); 
                
                if (arrayIdDocumentAdj.length > 0) {

                   registrarResultadoDoc(idResultadoPR);
              }
                
                listarDocumentosLocal(0);
                arrayIdDocumentAdj.length=0;
                
                $('#dialogFrmReprueba').dialog('close'); 
              }
            
        },
        error:errorAjax
    });
}

function actualizarEstadoSolicitudPruebaReprueba(estadoSolicitud,idSolicitudPruebaReprueba){
  
  $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/actualizarEstadoSolicitudPruebaReprueba",
        type:'post',
        async:false,
        data:{
            
         idSolicitudPruebaRp : idSolicitudPruebaReprueba,
                      estado : estadoSolicitud,

        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            
            if(data.resultado=="0"){
                idUnidadSupervisada  =  $("#idUnidadSupervisada").val();
                //listarTanqueCL(0,idUnidadSupervisada);
                
                 $.ajax({
                        url:baseURL + "pages/repruebasCilindroGNV/registrarPhgTrazSolicitud",
                        type:'post',
                        async:false,
                        data:{
                            //queda aqui
                           idSolicitudTraz : "",
                              idTipoMotivo : "",
                       idSolicitudPruebaRp : idSolicitudPruebaReprueba,
                                    estado : estadoSolicitud,
                                     fecha : formatoFecha($("#fechaActual").val()) ,
                                    motivo : "",
                               observacion : "",
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
        },
        error:errorAjax
    }); 
}

function actualizarCilindro(){
  var estadoC
  if ( $("#cmbResultReprueba").val() == 'C' )
    estadoC = '0';
  if ( $("#cmbResultReprueba").val() == 'A' )
    estadoC = '1';
  if ( $("#cmbResultReprueba").val() == 'R' )
    estadoC = '2';

  $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/actualizarEstadoCilindro",
        type:'post',
        async:false,
        data:{
            
          idCilindro : idCilindroGlobal,
          estado : estadoC,

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

function consultarTablaResultadoPruebaPersonal(idResultadoPruebaReprueba) {
  
    $.ajax({
          url:baseURL + "pages/repruebasCilindroGNV/consultarTablaResultadoPruebaPersonal",
          type:'post',
          async:false,
          data:{
             idResultadoPruebaReprueba : idResultadoPruebaReprueba,          
          },
          beforeSend:muestraLoading,
          success:function(data){
              ocultaLoading();
              
              
           if(data.registros > 0){
             
            $.each(data.filas, function( index, value ) {
                
                  idResultadoPP  =  value.idResultadoPruebaPersonal;
                  registrarResultadoPruebaPersonal(idResultadoPP);
              });
             
           } else {
             
                 registrarResultadoPruebaPersonal("");
           }

          },
          error:errorAjax
      });
}

function registrarResultadoPruebaPersonal(idResultadoPruebaPersonal) {
  
  idResultadoPR  = $("#idResultadoPR").val();
  idSedePersonal = $("#cmbInspector").val();
   
  $.ajax({
          url:baseURL + "pages/repruebasCilindroGNV/registrarResultadoPruebaPersonal",
          type:'post',
          async:false,
          data:{
            
            idResultadoPP  : idResultadoPruebaPersonal,
            idResultadoPR  : idResultadoPR,
            idSedePersonal : idSedePersonal
          },
          beforeSend:muestraLoading,
          success:function(data){
              ocultaLoading();
                  idUnidadSupervisada  =  $("#idUnidadSupervisada").val();
                        idResultadoPR  =  $("#idResultadoPR").val();
               
                if(data.resultado=="0"){
                                                              
                }
              
          },
          error:errorAjax
      });
}

function registrarDoc(){
    
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
    
    $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/registrarDocumento",
        enctype: 'multipart/form-data',
           type:'post',
    processData: false,
      contentType: false, 
            cache: false,
             data: data,
       beforeSend: muestraLoading,
      
       success:function(data){
          ocultaLoading();
          if(data.resultado=="0"){
            var input = $('#uploadfile');
            input.replaceWith(input.val('').clone(true));
            $('#nombreArchivo').text("")
            $("#btnAgregarDoc").attr('disabled','disabled');
              
                idResultadoPD = "";
           idDocumentoAdjunto = data.idDocumento;
                nombreDocumento = data.nombreDocumento;

              var objeto = {};
              
              objeto['idResultadoPruebaDocumento'] = idResultadoPD;
              objeto['idDocumentoAdjunto'] = idDocumentoAdjunto;
              objeto['nombreDocumento'] = nombreDocumento ;

              dataDocumentAdj.push(objeto);
              arrayIdDocumentAdj.push(idDocumentoAdjunto);   
              listarDocumentosLocal(0);
              
          }else{

          }
      },
      error:errorAjax
    });     
}

function registrarResultadoDoc(idResultadoPruebaReprueba){
   
    $.each(arrayIdDocumentAdj, function(index,value){
      
      idDocumentoAdjunto = value;
           idResultadoPR = idResultadoPruebaReprueba;
      
      $.ajax({
          url:baseURL + "pages/repruebasCilindroGNV/registrarResultadoDocumento",
          type:'post',
          async:false,
          data:{
            
            idResultadoPruebaReprueba : idResultadoPR,
              idDocumentoAdjunto        : idDocumentoAdjunto,
          },
          beforeSend:muestraLoading,
          success:function(data){
              ocultaLoading();
              
              if(data.resultado=="0"){
                 
              }
          },
          error:errorAjax
      }); 
      
    });
} 

function  llenarArrayTbDocumentos(idResultadoPruebaReprueba){

    $.ajax({
        url: baseURL + "pages/repruebasCilindroGNV/listarDocumentosArray",
        type:'post',
        async:false,
        data:{
          idResultadoPruebaReprueba : idResultadoPruebaReprueba
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $.each(data.filas, function( index, value ) {

                    idResultadoPD = value.idResultadoPruebaDocumento;
                      idResultadoPR = value.idResultadoPruebaReprueba;
               idDocumentoAdjunto = value.idDocumentoAdjunto;
                    nombreDocumento = value.nombreDocumento;

                  var objeto = {};
                  
                  objeto['idResultadoPruebaDocumento'] = idResultadoPD;
                  objeto['idResultadoPruebaReprueba'] = idResultadoPR;
                  objeto['idDocumentoAdjunto'] = idDocumentoAdjunto;
                  objeto['nombreDocumento'] = nombreDocumento ;

                  dataDocumentAdj.push(objeto);
                  listarDocumentosLocal(0);

           });
        },
        error:errorAjax
    }); 
}

function cargarInspector(idEmpresaAcreditada) {
  
      $.ajax({
          url:baseURL + "pages/repruebasCilindroGNV/cargarInspector",
          type:'post',
          async:false,
          data:{
            idEmpresaAcreditada:idEmpresaAcreditada,
        idTipoPrueba : '1526',
        flagSedePersonalAutoriazado : 'S'
          },
          beforeSend:muestraLoading,
          success:function(data){
            
              ocultaLoading();
              fill.combo(data.filas,'idSedePersonalAutorizado','nombreCompleto','#cmbInspector');
              
          },
          error:errorAjax
      });
}

function cargarOperador(idUnidadSupervisada) {
  
    $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/cargarOperador",
        type:'post',
        async:false,
        data:{
          idUnidadSupervisada:idUnidadSupervisada
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
           $.each(data.filas, function( index, value ) {
            $("#txtNombreEmp").text(value.razonSocial);
            $("#txtRH").text(value.numeroIdentificacion);
            $("#txtUnidadSupervisada").text(value.nombreUnidad);
            $("#txtDireccion").text(value.direccion);
           });
            
        },
        error:errorAjax
    });
}

function eliminarDoc(idResultadoPruebaDocumento , idDocumentoAdjunto ){
  
  for (var i in dataDocumentAdj) {
       if (dataDocumentAdj[i].idDocumentoAdjunto == idDocumentoAdjunto) {

         dataDocumentAdj.splice(i, 1);
         arrayIdDocumentAdj.splice(i, 1);
         break;
       }
   }
  
   listarDocumentosLocal(0);
   
   
   if(idDocumentoAdjunto !== '' ){
     
      eliminarDocumentoAdjunto(idDocumentoAdjunto);
   }
   
   if(idResultadoPruebaDocumento !== '' ){

      eliminarResultadoPruebaDocumento(idResultadoPruebaDocumento);
   }
}

function eliminarDocumentoAdjunto(idDocumentoAdjunto){
        
      $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/eliminarDocumentoAdjunto",
            type:'post',
            async:false,
            data:{
              
              idDocumentoAdjunto: idDocumentoAdjunto
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data.resultado=="0"){

                  listarDocumentosLocal(0);
                    
                }else{
                  

                }
            },
            error:errorAjax
        });
}

function eliminarResultadoPruebaDocumento(idResultadoPruebaDocumento){
  
    $.ajax({
          url:baseURL + "pages/repruebasCilindroGNV/eliminarResultadoPruebaDocumento",
          type:'post',
          async:false,
          data:{
            
            idResultadoPruebaDocumento: idResultadoPruebaDocumento
          },
          beforeSend:muestraLoading,
          success:function(data){
              ocultaLoading();
              if(data.resultado=="0"){

                listarDocumentosLocal(0);
                  
              }else{
                

              }
          },
          error:errorAjax
      });
  
}

function listarDocumentosLocal(flg_load) {
    
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorDocumentos").html("");
    
    var grid = $("<table>", {
        "id": "gridDocumentos"
    });
    
    var pager = $("<div>", {
        "id": "paginacionDocumentos"
    });
    
    $("#gridContenedorDocumentos").append(grid).append(pager);
    
    var nombres = ['','','','DOCUMENTO', '', 'ARCHIVO', 'OPCION'];
    var columnas = [
        {name: "idResultadoPruebaDocumento", sortable: false, hidden: true, align: "center"},
        {name: "idDocumentoAdjunto", sortable: false, hidden: true, align: "center"},
        {name: "idResultadoPruebaReprueba", sortable: false, hidden: true, align: "center"},
        {name: "nombreDocumento", width: 140, sortable: false, hidden: false, align: "center"},
        {name: "archivoAdjunto", sortable: false, hidden: true, align: "center"},
        {name: "archivo", width: 105, sortable: false, hidden: false, align: "center", formatter:"ArchivoLDE"},
        {name: "opcion", width: 60, sortable: false, hidden: false, align: "center", formatter:"OpLDE"}
    ]; 
 
    grid.jqGrid({
        
      data: dataDocumentAdj,
      datatype: "local",
        hidegrid: false,
        rowNum: 5,
        pager: "#paginacionDocumentos",
        emptyrecords: "No se encontraron resultados",
        recordtext: "{0} - {1}",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Documentos",
        jsonReader: {
            root: "dataDocumentAdj",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onCellSelect: function (cellcontent) {
            var rowData = $(this).jqGrid("getRowData", cellcontent);
            nombreEmpresa = rowData.razonSocial;
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
    jQuery.extend($.fn.fmatter, {
        OpLDE: function(cellvalue, options, rowdata) {
            
           var iconbutton ='';

           iconbutton = "<img src=\"" + baseURL + "/../images/eliminar.gif\" class='eliminarDoc' id='"+ rowdata.idDocumentoAdjunto +"%"+ rowdata.idResultadoPruebaDocumento +"' style=\"cursor: pointer;\" title=\"Eliminar\"/>"  
             
           return iconbutton;

        }
    });
    
    jQuery.extend($.fn.fmatter, {
      ArchivoLDE: function(cellvalue, options, rowdata) {
        
        return "<img src=\"" + baseURL + "/../images/file_doc.png\" class='DescargarDocGNV' id='"+ rowdata.nombreDocumento +"%"+ rowdata.archivoAdjunto +"' style=\"cursor: pointer;\" title=\"Descargar\"/>"
            
        }
    });
}