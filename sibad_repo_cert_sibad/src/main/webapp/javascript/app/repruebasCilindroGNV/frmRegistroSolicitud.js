       var listaModulos = {};
    var listaCilindros = {};
    var listaIds = [];
    var objectRow = {};
    var arrayNumeros = [];
    var nroReprueba = "";
    var NroSolicitudUnidadSupervisa = "";
    var codOsinergminAux =  "";
    var idUnidSupAux = "";



    $(function() {
    	initInicioSolicitud(); 
    });

    function initInicioSolicitud(){
        confirm.start();
        cargarEmpresasAcreditadas();

    	$( "#txtFecha" ).datepicker({ minDate: 0 });
    	$( "#txtFecha" ).attr( "readonly" , "readonly" );
        $( "#btnGuardarSolGNV" ).click(function() {
            confirm.open('¿Esta seguro de registrar?',"registrarSolicitud()");
        });

        $( "#btnRegresarSolGNV" ).click(function() {
            $('#dialogNuevaReprueba').dialog('close');        
        });

        $('body').on('click', '.seleccion',function(){
     
          var cadena= $(this).attr("value");
          if(this.checked == true){
            listaIds.push(cadena);
                        
           }else if(this.checked == false){
        	   var index = listaIds.indexOf(cadena);
        	   listaIds.splice(index, 1);
            }
        });
    }

    function convertDateFormat(string) {
        var info = string.split('/');
        return info[1] + '/' + info[0] + '/' + info[2];
    }

    function verificarDatosSolicitud(idSolicitudPruebaReprueba, idEmpresaAcreditada, codigoOsinergminAux, idunidadSupervisadaAux, modulo, cilindro, fechaSolicitud){
        idUnidSupAux = idunidadSupervisadaAux;
        $('#idUnidSupervisada').val(idunidadSupervisadaAux);
        codOsinergminAux = codigoOsinergminAux;

        llenarDatos(idSolicitudPruebaReprueba, idEmpresaAcreditada, modulo, cilindro, fechaSolicitud);
    }

    function btnGuardaSolicitud(){
         
    }

    function registrarSolicitud() {
        if( validarDatos() == true  ){
            $.each(listaIds, function( index, value ) {
                var fechaA = new Date();

                var month = fechaA.getMonth()+1;
                var day = fechaA.getDate();

                var output =(month<10 ? '0' : '') + month + '/' +    
                            (day<10 ? '0' : '') + day + '/' +
                            fechaA.getFullYear();

                output = output + " " +  fechaA.getHours() +":"+fechaA.getMinutes();

                BuscarSolicitudXEmpresa();
                var numeroSerie = nroReprueba.split('-');
                var num = numeroSerie[1];
                
                var NumCorrelativo = parseInt(num);

                NumCorrelativo = NumCorrelativo + 1;
                         
                // Aca debe hacer el Numero Correlativo
                NroSolicitudUnidadSupervisa = "SOL Reprueba GNV. "+ codOsinergminAux+ "-"+NumCorrelativo+"-"+fechaA.getFullYear();

                $("#txtAux").append(NroSolicitudUnidadSupervisa+'\n');
        
        
                $.ajax({
                    url:baseURL + "pages/repruebasCilindroGNV/registrarSolicitud",
                    type:'post',
                    async:false,
                    data:{
                        
                        idSolicitud         : "",
                        idCilindroGnv       : value,
                        idEmpresaAcred      : $("#cmbAsignado").val(),
                        nroSolicitud        : NroSolicitudUnidadSupervisa,
                        idTipoPrueba        : "1526",
                        FechaSolicitud      :  convertDateFormat( $("#txtFecha").val() + " " + fechaA.getHours() + ":" + fechaA.getMinutes() ), //output,
                        estado              : 'P'

                    },
                    beforeSend:muestraLoading,
                    success:function(data){
                        ocultaLoading();
                        if(data.resultado=="0"){
                            registrarPhgTrazSolicitud(data.IdSolicitud);
                            var nuevoObject= {};

                            nuevoObject["numero"] = NroSolicitudUnidadSupervisa;
                            nuevoObject["idCilindro"] = value;

                            arrayNumeros.push(nuevoObject);
                        }
                    },
                    error:errorAjax
                }); 
            }); 
            ConfirmDialog();
        }   
    }

function ConfirmDialog(){
    $('<div id="nuevo"></div>').appendTo('body')
    .html('<div id="aqui"> </div>')
    .dialog({
        modal: true, title: 'SE REGISTRÓ LOS SIGUIENTES ELEMENTOS', zIndex: 10000, autoOpen: true,
        width: 400, resizable: false,
        buttons: {
            Aceptar: function () {              
                $(this).dialog("close");
                //$(dialogNuevaReprueba).dialog("close");  
                window.location.href = baseURL+'pages/repruebasCilindroGNV';
            },
        },
        close: function (event, ui) {
            $(this).remove();
            $(dialogNuevaReprueba).dialog("close"); 
        }
    });

    arrayNumeros.forEach(function (elemento, indice, array) {
        var tex = "";
        tex = '<h6>' + 'Numero Solicitud: '+ elemento["numero"];
        tex = tex + '</h6>';
        $("#aqui").append(tex);
    });

 };

function registrarPhgTrazSolicitud(idSolicitudAux) {
    var fechaA = new Date();

    var month = fechaA.getMonth()+1;
    var day = fechaA.getDate();

    var output =(month<10 ? '0' : '') + month + '/' +    
                (day<10 ? '0' : '') + day + '/' +
                fechaA.getFullYear();

    output = output + " " +  fechaA.getHours() +":"+fechaA.getMinutes();
    
    $.ajax({
        url:baseURL + "pages/repruebasCilindroGNV/registrarPhgTrazSolicitud",
        type:'post',
        async:false,
        data:{
            
            idSolicitudTraz : "",
            idSolicitudPruebaRp :   idSolicitudAux,
            idTipoMotivo:            "",
            observacion:             "",
            fecha:                   output,
            estado:                  "P"
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                listarRepruebas();
                //$('#dialogNuevaReprueba').dialog('close');
            }
        },
        error:errorAjax
    });     
}

    function abrirConfirmarSolicitud(contenido){
        var title="CONFIRMAR SOLICITUD";
        $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/abrirConfirmarSolicitudGNV", 
            type:'get',
            async:false,
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                $("#dialogFrmConfirmarSolicitudGNV").html(data);
                $("#dialogFrmConfirmarSolicitudGNV").dialog({              
                    position: { my: 'top', at: 'top+50' },
                    resizable: false,
                    draggable: true,
                    autoOpen: true,
                    height:"auto",
                    width: "305",
                    modal: true,
                    dialogClass: 'dialog',  
                    title: title,
                    closeText:"Cerrar",
                    open: function( event, ui ) {
                        TraerSolicitudes(contenido);
                },
                });            
            },
            error:errorAjax
        });
        
    }

    function validarDatos(){
        if (  $("#txtFecha").val() == "" || $("#txtFecha").val() == undefined )
            return false;
        if (  $("#cmbAsignado").val() == "" || $("#cmbAsignado").val() == 0 )
            return false; 
        if (  $('input:checkbox[name=cilindros]:checked').val() == "" || $('input:checkbox[name=cilindros]:checked').val() == undefined )
            return false; 
        return true;
    }

    function llenarDatos(idSolicitud, idEmpresaAcreditada, modulo, cilindro, fechaSolicitud){
        
        cargarRepruebasCilindros(idUnidSupAux,""); 
        var numeromod = 0;
        var tex = "";

        if( idSolicitud == ""){
            $.each(listaModulos, function( index, value ) { 
                
                if( numeromod != value.nroModulo) {
                    numeromod = value.nroModulo;
                    tex = tex + "<div id='modcil'>"
                    tex = "<fieldset> <span class='ui-panel-title' style='font-size:15px;color: #NNNNN;'> Modulo nro: "+ value.nroModulo+ "</span><p>";

                    cargarRepruebasCilindros("",value.idModulo);

                    
                        $.each(listaCilindros, function( index, values ) { 
                            var fechaA = new Date( values.fechaProximaRep );

                            var month = fechaA.getMonth()+1;
                            var day = fechaA.getDate();

                            var output =(day<10 ? '0' : '') + day + '/' +
                                        (month<10 ? '0' : '') + month + '/' +    
                                        fechaA.getFullYear();
                            
                            tex = tex + "<input type='checkbox' class='seleccion' name='cilindros' id='"+ values.idCilindro +"' value='"+ values.idCilindro +"'> Cilindro nro: "+values.nroCilindro+ " - N° Serie: " + values.numeroSerie +" - Fecha Prox. Reprueba: "+ output +"<br>";
                            
                        });
                    
                    tex = tex + "</fieldset>";
                    tex = tex + "</div>"

                    $("#ContenidoBox").append(tex);
                }
            });  

        }else{
            $("#txtFecha").prop('disabled', true);
            $("#cmbAsignado").prop('disabled', true);
            $("#btnGuardarPH").hide();
            $("#txtFecha").val(fechaSolicitud);
            $("#cmbAsignado").val(idEmpresaAcreditada);

            tex = "<fieldset> <span> Modulo nro: "+ modulo + "</span><p>";
            tex = tex + "<span> Cilindro nro: "+cilindro+" - Fecha Prox. Reprueba: "+ fechaSolicitud +"</span>";
            tex = tex + "</fieldset>";
            $("#ContenidoBox").append(tex);
        }
        
    }


    function cargarEmpresasAcreditadas() {

        $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/empresasXtipoPrueba",
            type:'post',
            async:false,
            data:{
            	idTipoPrueba :'1526'
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

    function BuscarSolicitudXEmpresa() {

        $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/encontrarSolicitudUltimaEmpresa",
            type:'post',
            async:false,
            data:{
            	idTipoPrueba :'1526',
                idUnidSupervTanque :'0',
                idUnidSupervModulo :$('#idUnidSupervisada').val()
            },
            beforeSend:muestraLoading,
            success:function(data){
                
                ocultaLoading();
                
                if(data.filas!="[object Object]"){
                    nroReprueba = "SOL Reprueba GNV. 0-0-0";
                }else{
                    $.each(data.filas, function( index, value ) {
                        nroReprueba = value.nroSolicitudUnidadSupervisa;
                    });
                }
            },
            error:errorAjax
        });
    }

     function buscarCilindro(idCilindroG) {
        tex = "";
        $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/listarSolicitudPruebaReprueba",
            type:'get',
            async:false,
            data:{
                idCilindro : idCilindroG
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading(); 
                
                
            },
            error:errorAjax
        });      
    }

    function cargarRepruebasCilindros(idUnidSupAux, idModulo) {
        tex = "";
        $.ajax({
            url:baseURL + "pages/repruebasCilindroGNV/cargarRepruebasCilindros",
            type:'post',
            async:false,
            data:{
                idUnidSuperv : idUnidSupAux,
                idModulo     : idModulo
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading(); 
                
                if (idUnidSupAux !== "" && idUnidSupAux !== undefined){
                    listaModulos = data.filas.slice();   
                }
                if (idModulo !== "" && idModulo !== undefined) { 

                    listaCilindros = data.filas.slice(); 
                    console.log(listaCilindros) ;
                }
            },
            error:errorAjax
        });      
    }