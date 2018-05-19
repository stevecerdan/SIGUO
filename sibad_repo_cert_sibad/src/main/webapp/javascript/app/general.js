//Funciones Generales --
var baseURL;
var id;
var caracteres = "abcdefghijklmn�opqrstuvwxyzABCDEFGHIJKLMN�OPQRSTUVWXYZ";
var numeros = "0123456789";
var numeros_caracteres = numeros + caracteres;
var moneda = numeros + ".";
var global = {
		   rowNum:5,
		   rowNumPrinc:10,
		   confirm:{
		       save:"Se  &nbsp;registr&oacute;  satisfactoriamente.",
		       edit:"Se  &nbsp;actualiz&oacute; el registro satisfactoriamente.",
		       edit2:"Se han actualizado los datos del registro",
		       delete:"Se  &nbsp;elimin&oacute; el registro satisfactoriamente."
		   },
		   accion:{ /* OSINE_SFS-480 - RSIS09 - mdiosesf - Inicio */
		       save:1,
		       update:2,
		       delete:3,
		       edit2:4,
		       consult:5
		   }, 
		   msjMaxNivel:{ 
		   	error:"No se puede agregar nuevo nivel."
		   }, /* OSINE_SFS-480 - RSIS09 - mdiosesf - Fin */
		   terminoUtilizarBaseLegal:{
		   	articulo: "A",
		   	numeral: "N"
		   },
		   si: 'S',
		   no: 'N'
		};

$(function() {
    baseURL = "/sibad/"; //TODO EMc
    $.ajaxSetup({
        cache: false,
        data: {
            wtf: $("#idSesion").val()
        }
    });
    validarCampo();
    anularEnter();
    anularCopyPasteInput();
    notify();
    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: '&#x3c;Ant',
        nextText: 'Sig&#x3e;',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre',
            'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul',
            'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles',
            'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Juv', 'Vie',
            'S&aacute;b'],
        dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'S&aacute;'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
    };

    $.datepicker.setDefaults($.datepicker.regional['es']);

    validateFormActive();

    //cierra dialogs, que tengas boton atributo css "btnCloseDialog"
    boton.closeDialog();
});

/*
 * valores para alphanum
 */
var codigo = {
    allowNumeric: true,
    allowLatin: true,
    allowUpper: true,
    allowLower: false,
    allowCaseless: true,
    allowOtherCharSets: false,
    allowSpace: false,
    allow: '-'
};

var numericOptions = {
    allowMinus: false,
    allowThouSep: false,
    allow: '.'
};

var alphaNumOptions = {
    allowNumeric: true,
    allowLatin: true,
    allowUpper: true,
    allowLower: true,
    allowCaseless: true,
    allowOtherCharSets: false,
    allowSpace: true,
    allow: '������������'
            //forceUpper    : true, 
};

var alphaNumOptionsDash = {
    allowNumeric: true,
    allowLatin: true,
    allowUpper: true,
    allowLower: true,
    allowCaseless: true,
    allowOtherCharSets: false,
    allowSpace: true,
    allow:  '������������.-'
            //forceUpper    : true, 
};

var alphaOptions = {
    allowNumeric: false,
    allowLatin: true,
    allowUpper: true,
    allowLower: true,
    allowCaseless: true,
    allowOtherCharSets: false,
    allowSpace: true,
    allow: '������������'
};

var onlyNumericOptions = {
    allowMinus: false,
    allowThouSep: false
};

var onlyAlphaNumOptions = {
    allowNumeric: true,
    allowLatin: true,
    allowUpper: true,
    allowLower: true,
    allowCaseless: true,
    allowOtherCharSets: false
};

var numericDecimal = {
	allowNumeric: true,
	allowLatin: false,
	allow: '.-'
	};
var numericDecimalPositivo = {
		allowNumeric: true,
		allowLatin: false,
		allow: '.'
		};
var numeric = {
		allowNumeric: true,
		allowLatin: false,
		allowOtherCharSets: false,
		allow: ''
		};

/*
 * funciones para llenado de datos
 */
var fill = {
    /*
     * llena combo 
     */
    combo: function(data, id, desc, tagDestino) {
        var html = '<option value="">--Seleccione--</option>';
        if (data != null) {
            $.each(data, function(k, v) {
                html += '<option value="' + v[id] + '">' + v[desc] + '</option>';
            });
        }
        $(tagDestino).html(html);
    },
    /*
     *llena combo y selecciona el valor con el texto de valorText 
     */
    comboValorTxt: function(data, id, desc, tagDestino, valorText) {
        var html = '<option value="">--Seleccione--</option>';
        if (data != null) {
            $.each(data, function(k, v) {
                html += '<option value="' + v[id] + '" ';
                if (v[desc] == valorText) {
                    html += ' selected  ';
                }
                html += '>' + v[desc] + '</option>';
            });
        }
        $(tagDestino).html(html);
    },
    /*
     *llena combo y selecciona el valor con el texto de valorId 
     */
    comboValorId: function(data, id, desc, tagDestino, valorId) {
        var html = '<option value="">--Seleccione--</option>';
        if (data != null) {
            $.each(data, function(k, v) {
                html += '<option value="' + v[id] + '">' + v[desc] + '</option>';
            });
        }
        $(tagDestino).html(html);
        $(tagDestino).val(valorId);
    },
    clean: function(tagDestino) {
        var html = '<option value="">--Seleccione--</option>';
        $(tagDestino).html(html);
    }
};

/*
 * funciones para botones con usos comun
 */
var boton = {
    closeDialog: function() {
        $('.btnCloseDialog').click(function() {
            var idP = $(this).parent().parent().attr('id');
            $('#' + idP).dialog('close');
        });
    }
};

/*
 * funciones para popups de confirmacion.
 */
var confirm = {
    start: function() {
        if ($('#dialogComunConf').html() == null || $('#dialogComunConf').html() == undefined) {
            $(document.body).append('<div id="dialogComunConf" class="dialogComunConf" style="display:none;" title="Confirmaci&oacute;n"><div><span class="ui-icon ui-icon-alert" id="icon"></span><span style="text-align:center;" id="textDialogComunConf"></span></div><div style="text-align:center;" id="botones"><button id="btnConfDialogComunConf">Aceptar</button><button onclick="confirm.close()">Cancelar</button></div></div>');
            $("#dialogComunConf").dialog({resizable: false, autoOpen: false, height: "auto", width: "auto", dialogClass: 'dialog', modal: true});
        }
    },
    open: function(msj, evtClick, objText) {
        //Valores Default
        var textAceptar = "Aceptar";
        var textCancelar = "Cancelar";
        //Nuevos Valores
        if (objText != undefined && objText != '') {
            textAceptar = (objText.textAceptar != undefined) ? objText.textAceptar : textAceptar;
            textCancelar = (objText.textCancelar != undefined) ? objText.textCancelar : textCancelar;
        }
        //Texto Botones
        $('#dialogComunConf #botones').find('button:eq(0)').html(textAceptar);
        $('#dialogComunConf #botones').find('button:eq(1)').html(textCancelar);

        $('#dialogComunConf #textDialogComunConf').html(msj);
        $('#dialogComunConf #btnConfDialogComunConf').attr('onclick', "confirm.close(); " + evtClick);
        $('#dialogComunConf').dialog('open');
    },
    close: function() {
        //$('#dialogComunConf').remove();
        $("#dialogComunConf").dialog("close");
        $('#dialogComunConf #textDialogComunConf').html('');
        $('#dialogComunConf #btnConfDialogComunConf').attr('onclick', '');
    }
};

/*
 * funciones de complemento para grillas.
 */
var fxGrilla = {
    divPto: '<div class="ptoGrilla">...</div>',
    setPtosSuspensivos: function(idGrilla, campo) {
        if ($('td[aria-describedby="' + idGrilla + '_' + campo + '"]').eq(0).length > 0) {
            var heightI = parseInt($('td[aria-describedby="' + idGrilla + '_' + campo + '"]').eq(0).css('height').replace('px', ''));
            $('td[aria-describedby="' + idGrilla + '_' + campo + '"]').css('white-space', 'normal');
            $('td[aria-describedby="' + idGrilla + '_' + campo + '"]').map(function() {
                var html = fxGrilla.limpiaPtos($(this).html());
                if (parseInt($(this).css('height').replace('px', '')) > heightI) {
                    $(this).css('position', 'relative');
                    html = html + fxGrilla.divPto;
                }
                $(this).html(html);
            });
            $('td[aria-describedby="' + idGrilla + '_' + campo + '"]').css('white-space', 'pre');
        }
    },
    limpiaPtos: function(valor) {
        return valor.replace(fxGrilla.divPto, '');
    }
};

/** Arbol de Obligacion Tipo */

var fxTreeObligacionTipo = {
    build: function(objData) {
        //ordenar json de ajax
        var cont = 0;
        var data = [];
        $.each(objData, function(k, v) {
            data[cont] = {'key': v.idObligacionTipo, 'title': v.nombre, 'idActividadPadre': v.idActividadPadre, 'children': [], 'folder': false};
            cont++;
        });
        //declaro auxiliares
        var dataF = [];//data a retornar
        var dataT = [];//data q almacena restantes, mientras se va armando el arbol
        //armo 1er nivel
        var x = fxTreeObligacionTipo.orderChild(data, null);
        dataF = x.resultado;
        dataT = x.restante;
        //armo 2do nivel
        $.each(dataF, function(k, v) {
            var idPadre = v.key;
            var x = fxTreeObligacionTipo.orderChild(dataT, idPadre);
            dataF[k]['children'] = x.resultado;
            dataT = x.restante;
        });
        return dataF;
    },
    orderChild: function(data, idPadre) {
        var dataA = [];
        var dataB = [];
        var contA = 0;
        var contB = 0;
        $.each(data, function(k, v) {
            if (v.idActividadPadre == idPadre) {
                v['folder'] = fxTreeObligacionTipo.isFather(v.key, data);
                dataA[contA] = v;
                contA++;
            } else {
                dataB[contB] = v;
                contB++;
            }
        });
        return {resultado: dataA, restante: dataB};
    },
    isFather: function(id, data) {
        var retorno = false;
        $.each(data, function(k, v) {
            if (id == v.idActividadPadre) {
                retorno = true;
            }
        });
        return retorno;
    }
};
/** Arbol de Procesos */

var fxTreeProceso = {
    build: function(objData) {
        //ordenar json de ajax
        var cont = 0;
        var data = [];
        $.each(objData, function(k, v) {
            data[cont] = {'key': v.idProceso, 'title': v.descripcion, 'idActividadPadre': v.idActividadPadre, 'children': [], 'folder': false};
            cont++;
        });
        //declaro auxiliares
        var dataF = [];//data a retornar
        var dataT = [];//data q almacena restantes, mientras se va armando el arbol
        //armo 1er nivel
        var x = fxTreeProceso.orderChild(data, null);
        dataF = x.resultado;
        dataT = x.restante;
        //armo 2do nivel
        $.each(dataF, function(k, v) {
            var idPadre = v.key;
            var x = fxTreeProceso.orderChild(dataT, idPadre);
            dataF[k]['children'] = x.resultado;
            dataT = x.restante;
        });
        return dataF;
    },
    orderChild: function(data, idPadre) {
        var dataA = [];
        var dataB = [];
        var contA = 0;
        var contB = 0;
        $.each(data, function(k, v) {
            if (v.idActividadPadre == idPadre) {
                v['folder'] = fxTreeProceso.isFather(v.key, data);
                dataA[contA] = v;
                contA++;
            } else {
                dataB[contB] = v;
                contB++;
            }
        });
        return {resultado: dataA, restante: dataB};
    },
    isFather: function(id, data) {
        var retorno = false;
        $.each(data, function(k, v) {
            if (id == v.idActividadPadre) {
                retorno = true;
            }
        });
        return retorno;
    }
};

/**
 * Funcion para Arbol de Temas 
 */
var fxTreeTema = {
    build: function(objData) {
        //ordenar json de ajax
        var cont = 0;
        var data = [];
        $.each(objData, function(k, v) {
            data[cont] = {'key': v.idMaestroColumna, 'title': v.descripcion, 'idActividadPadre': v.idActividadPadre, 'select': v.select,
                'selected': false, 'children': [], 'folder': true};
            cont++;
        });
        //declaro auxiliares
        var dataF = [];//data a retornar
        var dataT = [];//data q almacena restantes, mientras se va armando el arbol
        //armo 1er nivel
        var x = fxTreeTema.orderChild(data, null);
        dataF = x.resultado;
        dataT = x.restante;
        //armo 2do nivel
        $.each(dataF, function(k, v) {
            var idPadre = v.key;
            var x = fxTreeTema.orderChild(dataT, idPadre);
            dataF[k]['children'] = x.resultado;
            dataT = x.restante;
        });
        return dataF;
    },
    orderChild: function(data, idPadre) {
        var dataA = [];
        var dataB = [];
        var contA = 0;
        var contB = 0;
        $.each(data, function(k, v) {
            if (v.idActividadPadre == idPadre) {
                v['folder'] = fxTreeTema.isFather(v.key, data);
                v['selected'] = fxTreeTema.isChecked(v.select, data);
                dataA[contA] = v;
                contA++;
            } else {
                dataB[contB] = v;
                contB++;
            }
        });
        return {resultado: dataA, restante: dataB};
    },
    isFather: function(id, data) {
        var retorno = false;
        $.each(data, function(k, v) {
            if (id == v.idActividadPadre) {
                retorno = true;
            }
        });
        return retorno;
    },
    isChecked: function(select, data) {
        var retorno = false;
        $.each(data, function(k, v) {
            if (select == true) {
                retorno = true;
            }
        });
        return retorno;
    }

};

/*Actividad*/
var fxTreeActividad = {
    build: function(objData) {
        //ordenar json de ajax
        var cont = 0;
        var data = [];
        $.each(objData, function(k, v) {
            data[cont] = {'key': v.idActividad, 'title': v.nombre, 'idActividadPadre': v.idActividadPadre, 'children': [], 'folder': false,
                'check': true};
            cont++;
        });
        //declaro auxiliares
        var dataF = [];//data a retornar
        var dataT = [];//data q almacena restantes, mientras se va armando el arbol
        //armo 1er nivel
        var x = fxTree.orderChild(data, null);
        dataF = x.resultado;
        dataT = x.restante;
        //armo 2do nivel
        $.each(dataF, function(k, v) {
            var idPadre = v.key;
            var x = fxTree.orderChild(dataT, idPadre);
            dataF[k]['children'] = x.resultado;
            dataT = x.restante;
        });
        return dataF;
    },
    orderChild: function(data, idPadre) {
        var dataA = [];
        var dataB = [];
        var contA = 0;
        var contB = 0;
        $.each(data, function(k, v) {
            if (v.idActividadPadre == idPadre) {
                v['folder'] = fxTree.isFather(v.key, data);
                if (v['folder'] = true) {
                    v['check'] = false;
                }
                dataA[contA] = v;
                contA++;
            } else {
                dataB[contB] = v;
                contB++;
            }
        });
        return {resultado: dataA, restante: dataB};
    },
    isFather: function(id, data) {
        var retorno = false;
        $.each(data, function(k, v) {
            if (id == v.idActividadPadre) {
                retorno = true;
            }
        });
        return retorno;
    }
};
/*
 * Funciones para armado de arboles
 */
var fxTree = {
    build: function(objData) {
        //ordenar json de ajax
        var cont = 0;
        var data = [];
        $.each(objData, function(k, v) {
            data[cont] = {'key': v.idActividad, 'title': v.nombre, 'idActividadPadre': v.idActividadPadre, 'children': [], 'folder': false};
            cont++;
        });
        //declaro auxiliares
        var dataF = [];//data a retornar
        var dataT = [];//data q almacena restantes, mientras se va armando el arbol
        //armo 1er nivel
        var x = fxTree.orderChild(data, null);
        dataF = x.resultado;
        dataT = x.restante;
        //armo 2do nivel
        $.each(dataF, function(k, v) {
            var idPadre = v.key;
            var x = fxTree.orderChild(dataT, idPadre);
            dataF[k]['children'] = x.resultado;
            dataT = x.restante;
        });
        return dataF;
    },
    orderChild: function(data, idPadre) {
        var dataA = [];
        var dataB = [];
        var contA = 0;
        var contB = 0;
        $.each(data, function(k, v) {
            if (v.idActividadPadre == idPadre) {
                v['folder'] = fxTree.isFather(v.key, data);
                dataA[contA] = v;
                contA++;
            } else {
                dataB[contB] = v;
                contB++;
            }
        });
        return {resultado: dataA, restante: dataB};
    },
    isFather: function(id, data) {
        var retorno = false;
        $.each(data, function(k, v) {
            if (id == v.idActividadPadre) {
                retorno = true;
            }
        });
        return retorno;
    }
};
/*distritos*/
var fxTreeDistrito = {
    build: function(objData) {
        //ordenar json de ajax
        var data = [];
        var cont = 0;
        $.each(objData, function(k, v) {
            data[cont] = {'key': v.idDistrito, 'title': v.nombre, 'folder': false};
            cont++;
        });

        var datax = [];
        datax[0] = {'key': '00', 'title': 'Distritos', 'folder': true, 'children': data};
        return datax;
    }
};
var fxTreeSancAdm = {
    build: function(objData) {
        //ordenar json de ajax
        var data = [];
        var cont = 0;
        $.each(objData, function(k, v) {
            data[cont] = {'key': v.idTipoSancion, 'title': v.descripcion, 'folder': false};
            cont++;
        });

        var datax = [];
        datax[0] = {'key': '00', 'title': 'Sancion Administrativa', 'folder': true, 'children': data};
        return datax;
    }
};
var fxTxt = {
    resaltar: function(parrafo, txtResaltar) {
        var posic = parrafo.toUpperCase().indexOf($.trim(txtResaltar).toUpperCase());
        var longitud = $.trim(txtResaltar).length;
        var text = parrafo.substring(posic, (posic + longitud));
        var final = parrafo.replace(text, '<span style="color:red;">' + text + '</span>');
        return final;
    },
    limpiaResaltar: function(parrafo) {
        var retorno = "";
        if (parrafo != "") {
            retorno = parrafo.replace('<span style="color:red;">', "").replace('</span>', "");
        }
        return retorno;
    }
};

function quitaSlashDir(dir) {
    var sep = dir.split("\\");
    dir = sep[sep.length - 1];
    return dir;
}
function reverseFormatoLink(sel) {
    sel = sel.replace(sel.substring(sel.indexOf('<'), sel.indexOf('>') + 1), "");//para <a>
    sel = sel.replace(sel.substring(sel.indexOf('<'), sel.indexOf('>') + 1), "");//para </a>
    return sel;
}
function reverseFormatoDocumento(sel) {
    if (sel != "") {
        var y = sel.split(' - ');
        if (y.length > 0) {
            sel = y[1];
        } else {
            sel = "";
        }
    }
    return sel;
}
function errorAjax(jqXHR) {
    var msj1 = "El servicio no se encuentra disponible";
    var msj2 = "Intente mas tarde";
    if (jqXHR != undefined) {
        if (jqXHR.responseText.indexOf('@errorSesionExpired@') > 0) {
            msj1 = "Error sesion expirada";
            msj2 = "La sesion a expirado, por favor vuelva a autenticarse.";
        }
    }
    ocultaLoading();
    mensajeGrowl('error', msj1, msj2);
}
/*
 * @param {type} rowid, id del registro de la grilla, Ej. idLocador
 * @param {type} idGrilla, id de Grilla
 * @returns {unresolved}
 */
function searchInJqGridByID(rowid, idGrilla) {
    var retorno = null;
    $.each($('#' + idGrilla).jqGrid('getDataIDs'), function(key, val) {
        if (rowid == val) {
            retorno = $('#' + idGrilla).jqGrid('getRowData', val);
        }
    });
    return retorno;
}
/*
 * @param {type} idDivMsje, id del div que mostrara el mensaje
 * @param {type} Msje, texto a mostrar
 * @param {type} ElementError, elementos del Formulario que generan error, Ej. #txtNombre
 * @returns {undefined}*
 */
function muestraDivError(idDivMsje, Msje, ElementError) {
    $(idDivMsje).show();
    $(idDivMsje).html(Msje);
    $(ElementError).addClass("error");
}
function limpiaValidacionesMostradas(idDivMsje, idForm) {
    $('#' + idDivMsje).html("").hide();
    $('#' + idForm).find('input,select,textarea').removeClass('error');
}
function muestraLoading() {
    $('#overlay_loading').css('display', 'block');
}
function ocultaLoading() {
    $('#overlay_loading').css('display', 'none');
}
function trim(stringToTrim) {
    return stringToTrim.replace(/^\s+|\s+$/g, "");
}

function mensajeGrowl0(type, title, detail) {
    if (type == "success")
        type = "info";

    $('#default').puigrowl('show', [{severity: type, summary: title, detail: detail}]);
}
function notify() {
    $('#notifynormal').puinotify({
        easing: 'easeInOutCirc'
    });
    $("#notifynormal").click(function(e) {
        $('#notifynormal').puinotify('hide');
    });
}
function mensajeGrowl(type, title, detail, time) {
    if (title == undefined) {
        title = "";
    }
    if (detail == undefined) {
        detail = "";
    }
    if (time == undefined || isNaN(time)) {
        time = 8000;
    }
    if ($('#notifynormal').hasClass('error')) {
        $('#notifynormal').removeClass('error');
    } else if ($('#notifynormal').hasClass('warn')) {
        $('#notifynormal').removeClass('warn');
    } else if ($('#notifynormal').hasClass('success')) {
        $('#notifynormal').removeClass('success');
    }
    $('#notifynormal').addClass(type);
    $('#notifynormal').puinotify('show', '<h1>' + title + '</h1> <p>' + detail + '</p>');
    id = '#notifynormal';

    window.setTimeout(closeMessage, time);
}
function cerrarMessage() {
    if ($('#notify').is(":visible")) {
        $('#notify').puinotify('hide');
    }
}

function closeMessage() {
    if ($(id).is(":visible")) {
        $(id).puinotify('hide');
    }
}
window.history.forward();

function noBack() {
    window.history.forward();
}

function validarCampo() {
    (function($) {
        $.fn.validCampoNumero = function(cadena) {
            $(this).on({
                keypress: function(e) {
                    var key = e.which,
                            keye = e.keyCode,
                            tecla = String.fromCharCode(key).toLowerCase(),
                            letras = cadena;
                    if (letras.indexOf(tecla) == -1 && keye != 9 && (key == 37 || keye != 37) && (keye != 39 || key == 39) && keye != 8 && (keye != 46 || key == 46) || key == 161) {
                        e.preventDefault();
                    }
                }
            });
        };
    })(jQuery);
}

function validateFormActive() {
    var html = "<a  data-title='?' class='tooltip'><img src='/sglss/images/error_small.png'  style='float: left;'/></a>";

    (function($) {
        $.fn.validateAllForm = function(div) {

            $(div).hide();
            var validar = true;
            var form = $(this);
            var id = "#" + form.attr("id");
            var errorTotal = "";
            $(id + ' input, ' + id + ' select, ' + id + ' textarea').each(
                    function(index) {
                        var texto = "";
                        var input = $(this);
                        var error = validateInput(input, html);
                        if (error != "") {
                            validar = false;

                            if (error != "[O]") {
                                var label = $("label[for='" + $(this).attr('id') + "']");
                                if (label.length != 0)
                                    texto = label.html().replace('(*)', '');//+"<br/>";
                                if (errorTotal != "")
                                    errorTotal += "<//>" + texto + error;
                                else {
                                    errorTotal += texto + error;
                                }
                            } else {
                                if ($(this).attr('class').indexOf('hasDatepicker') == -1 && this.type != "select-one") {//TODO evitar se abra datepicker
                                    //$(this).focus();  //DSR, focus cambia estilo css y no se ve rojo, confunde usuario
                                }
                            }
                        }

                        $(this).on({
                            blur: function(e) {
                                var input = $(this);
                                validateInput(input, html);

                            }});

                    }
            );
            //DSR valida checks - inicio
            var errorCheck = "";
            //if (validar) {
                var cont = 0;
                $(id).find('[validate|="[CHECK]"]').map(function() {
                    $(this).find('input:checked').map(function() {
                        cont++;
                    });
                    if (cont == 0) {
                        validar = false;
                        var texto = "";
                        var error = " Debe Seleccionar uno al menos.";
                        var label = $("label[for='" + $(this).attr('id') + "']");
                        if (label.length != 0)
                            texto = label.html().replace('(*)', '');
                        errorCheck += texto + error;
                    }
                });
            //}

            //DSR valida checks - fin
          //DSR valida radio - inicio
            var errorCheck = "";
            //if (validar) {
            	//alert(validar);
                var cont = 0;
                var contradio=0;
                $(id).find('[validate|="[RADIO]"]').map(function() {
                	//contradio++;
                	cont = 0;
                    $(this).find('input:checked').map(function() {
                        cont++;
                    });
                    //cambio eog
                    if (cont == 0) {
                    //if (cont < contradio) {
                        validar = false;
                        var texto = "";
                        var error = " Debe seleccionar una opci&oacute;n.";
                        var label = $("label[for='" + $(this).attr('id') + "']");
                        if (label.length != 0)
                            texto = label.html().replace('(*)', '');
                        errorCheck += texto + error+"<br>";
                        $(this).find('label').addClass('radioError');
                    }else{
                    	$(this).find('label').removeClass('radioError');
                    }
                });
            //}

            //DSR valida radios - fin

            if (errorTotal != "") {

                var array = errorTotal.split('<//>');
                $(div).show();
                $(div).focus();
                $(div).html(array[0]);
            } else if (errorCheck != "") {
                $(div).show();
                $(div).focus();
                $(div).html(errorCheck);
            }
            //DSR, caso inputs dentro de tabs, mostrar tab con campo con class=error
            $('[aria-controls|="' + $(form).find('.error').eq(0).attr('validatetab') + '"] a').trigger('click').effect("pulsate", "slow");

            return validar;
        };
    })(jQuery);

    (function($) {
        $.fn.validarForm = function(data) {
            var form = $(this);
            var id = "#" + form.attr("id");
            $(id + ' input,' + id + ' textarea').each(
                    function(index) {
                        var cadena = "";
                        var input = $(this);

                        var validacion = input.attr('validate');
                        if (validacion !== null && typeof validacion !== "undefined")
                            if (validacion.indexOf("[SL]") !== -1 || validacion.indexOf("[SN]") !== -1 || validacion.indexOf("[SNP]") !== -1 || validacion.indexOf("[MONEDA]") !== -1) {//TODO para otros casos

                                if (validacion.indexOf("[SL]") !== -1) {
                                    cadena = caracteres;
                                } else if (validacion.indexOf("[SN]") !== -1) {
                                    cadena = numeros;
                                } else if (validacion.indexOf("[SNP]") !== -1) {
                                    cadena = numeros;
                                } else if (validacion.indexOf("[MONEDA]") !== -1) {
                                    cadena = moneda;
                                }

                                $(this).on({
                                    keypress: function(e) {
                                        var key = e.which,
                                                keye = e.keyCode,
                                                tecla = String.fromCharCode(key).toLowerCase(),
                                                letras = cadena;
                                        if (letras.indexOf(tecla) == -1 && keye != 9 && (key == 37 || keye != 37) && (keye != 39 || key == 39) && keye != 8 && (keye != 46 || key == 46) || key == 161) {
                                            e.preventDefault();
                                        }
                                    }
                                });
                            }
                    }
            );

        };
    })(jQuery);
}
function validateInput(input, html) {
    var validaciones = input.attr('validate');
    var error = "";
    if (validaciones !== null && typeof validaciones !== "undefined")
        error = validaCampos(input.val(), validaciones);
    if (error !== "") {
        input.addClass("error");
    } else {
        input.removeClass("error");
        
    }
    return error;
}
function myTrim(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}
function validaCampos(value, tipo) {
    var mensaje = "";
    var error;
    if (tipo.indexOf("[O]") !== -1) { //para los obligatorios
        if (value == null || myTrim(value) === "") {
            error = true;
            mensaje = "[O]";
            return mensaje;
        }
    }
    if (tipo.indexOf("[SL]") !== -1) {
        var expreg = new RegExp("^$|^([�-��-�]|[a-zA-Z�]|\s)*$");
        if (!expreg.test(value)) {
            mensaje = " Formato de solo letras.";
            return mensaje;
        }
    }
    if (tipo.indexOf("[SN]") !== -1) {
        var expreg = new RegExp("^$|[0-9][0-9]*");
        if (!expreg.test(value) || isNaN(value)) {
            mensaje = " Formato de solo N&uacute;meros.";
            return mensaje;
        }
    }
    if (tipo.indexOf("[SNP]") !== -1) {//sono numero entero
        var expreg = new RegExp("^$|[1-9][0-9]*");
        if (!expreg.test(value) || isNaN(value) || value < 0) {
            mensaje = " Formato de N&uacute;meros, no v&aacute;lido.";
            return mensaje;
        }
    }

    if (tipo.indexOf("[CORREO]") !== -1) {
        var expreg = new RegExp("(^$|^.*@.*\..*$)");//("/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/");  
        if (!expreg.test(value)) {
            mensaje = " Ingrese un formato valido de correo.";
            return mensaje;
        }
    }

    if (tipo.indexOf("[MONEDA]") !== -1) {
        var expreg = new RegExp("^$|[0-9]+(\.[0-9]+)?$");
        if (!expreg.test(value)) {
            mensaje = " Ingrese un formato valido de moneda.";
            return mensaje;
        }
    }
    if (tipo.indexOf("[FECHA]") !== -1) {
    	var expreg =  /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;
        if (value.trim() != "" && !expreg.test(value.trim())) 
        {
            mensaje = "Ingrese un formato valido para la fecha";
            return mensaje;
        }
    }
    if (tipo.indexOf("[HORA]") !== -1) {
    	var expreg =  /^(0?[1-9]|1[012])(:[0-5]\d) [AP][M]$/;
        if (value.trim() != "" && !expreg.test(value.trim())) 
        {
            mensaje = "Ingrese un formato valido para la hora";
            return mensaje;
        }
    }
    if (tipo.indexOf("[PERIODO]") !== -1) {
    	var expreg =  /^(((0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|(02\/((19|[2-9]\d)\d{2}))|(02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;
        if (value.trim() != "" && !expreg.test(value.trim())) 
        {
            mensaje = "Ingrese un formato valido para el periodo";
            return mensaje;
        }
    }
    return mensaje;
}


function anularEnter() {
    $("input[type=text]").keypress(function(e) {
        if (e.which == 13 || e.keyCode == 13) {
            return false;
        }
    });
}

function anularEnterTextArea(id) {
    $(id).keypress(function(e) {
        if (e.which == 13 || e.keyCode == 13) {
            return false;
        }
    });
}

function anularCopyPasteInput() {
    $('input').bind('copy paste', function(e) {

        e.preventDefault();
    });
}

function validarHoras(obj){
	var expreg =  /^(0?[1-9]|1[012])(:[0-5]\d) [AP][M]$/;
	if(obj == null || obj == ""){
		return true;
	}else{
		if (!expreg.test(obj.trim())) 
	    {	        
	        return false;
	    }else{
	    	return true;
	    }
	}    
}


function validarFechas(obj){	
	var expreg =  /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;
	if(obj == null || obj == ""){
		return true;
	}else{
		if (!expreg.test(obj.trim())) 
	    {
	        return false;
	    }else{
	    	return true;
	    }   
	}     
}

function validaEnteros(obj, nDec) {
    var expreg = /^\d*$/;
    if (!isNaN(nDec) && (Number(nDec) > 0))
        expreg = new RegExp("^\\d*(\\.\\d{1," + nDec + "})?$");
    if (expreg.test(obj))
        return true;
    else
        return false;
}

function validaSoloEnteros(obj, nEnt) {
    var expreg = /^\d*$/;
    expreg = new RegExp("^\\d{1,"+nEnt+"}?$");
    if (expreg.test(obj))
        return true;
    else
        return false; 
}

function validaEnteros(obj, nEnt ,nDec) {
    var expreg = /^\d*$/;
    if (!isNaN(nDec) && (Number(nDec) > 0))
        expreg = new RegExp("^\\d{1,"+nEnt+"}(\\.\\d{1," + nDec + "})?$");
    if (expreg.test(obj))
        return true;
    else
        return false; 
}

function validaDecimal(obj, nEnt ,nDec) {
    var expreg = /^\d*$/;
    if (!isNaN(nDec) && (Number(nDec) > 0))
        expreg = new RegExp("^(-)?\\d{1,"+nEnt+"}(\\.\\d{1," + nDec + "})?$");
    if (expreg.test(obj))
        return true;
    else
        return false;
}

function validaDecimalPosi(obj, nEnt ,nDec) {
    var expreg = /^\d*$/;
    if (!isNaN(nDec) && (Number(nDec) > 0))
        expreg = new RegExp("^\\d{1,"+nEnt+"}(\\.\\d{1," + nDec + "})?$");
    if (expreg.test(obj))
        return true;
    else
        return false;
}

function comparingDates(fromDate, toDate, fromDateName, toDateName) {

    if (fromDate != '' && toDate != '') {

        var datefrom = new Date();
        var dateto = new Date();

        try {
            var arrayfrom = fromDate.split('/');
            datefrom.setFullYear(arrayfrom[2]);
            datefrom.setMonth(parseFloat(arrayfrom[1]) - 1);
            datefrom.setDate(parseFloat(arrayfrom[0]));
            datefrom.setHours('0');
            datefrom.setMinutes('0');
            datefrom.setSeconds('0');

        } catch (ex) {
            alert('El campo' + fromDateName + ' es una fecha invalida.');
            return false;
        }

        try {
            var arrayto = toDate.split('/');
            dateto.setFullYear(arrayto[2]);
            dateto.setMonth(parseFloat(arrayto[1]) - 1);
            dateto.setDate(parseFloat(arrayto[0]));
            dateto.setHours('0');
            dateto.setMinutes('0');
            dateto.setSeconds('0');

        } catch (ex) {
            alert('El campo' + toDateName + ' es una fecha invalida.');
            return false;
        }

        if (datefrom > dateto) {
            return false;
        }
    }
    return true;
}

function dias_entre(date1, date2) {
    var resultado = comparaFecha(date1, date2);
    if (isNaN(resultado))
        return resultado;

    var f1 = date1.split("/");
    var f2 = date2.split("/");
    // The number of milliseconds in one day
    var ONE_DAY = 1000 * 60 * 60 * 24;

    // Convert both dates to milliseconds
    var date1_ms = new Date(f1[2], f1[1], f1[0]).getTime();
    var date2_ms = new Date(f2[2], f2[1], f2[0]).getTime();

    // Calculate the difference in milliseconds
    var difference_ms = date2_ms - date1_ms;
    // Convert back to days and return
    return Math.round(difference_ms / ONE_DAY);

}
Date.daysBetween = function(date1, date2) {
    //Get 1 day in milliseconds
    var one_day = 1000 * 60 * 60 * 24;

    // Convert both dates to milliseconds
    var date1_ms = date1.getTime();
    var date2_ms = date2.getTime();

    // Calculate the difference in milliseconds
    var difference_ms = date2_ms - date1_ms;

    // Convert back to days and return
    return Math.round(difference_ms / one_day);
};

//devuelve 1 si fecha1>fecha2, -1 si fecha1<fecha2 y 0 si fecha1=fecha2
function comparaFecha(fecha1, fecha2)
{
    if (!esFecha(fecha1)) {
        return fecha1 + " no es una fecha correcta";
    }
    if (!esFecha(fecha2)) {
        return fecha2 + " no es una fecha correcta";
    }
    if (fecha1 == fecha2)
        return 0;
    else {
        var f1 = fecha1.split("/");
        var f2 = fecha2.split("/");
        if ((for1 = f1[2] + f1[1] + f1[0]) > (for2 = f2[2] + f2[1] + f2[0]))
            return 1;
        else if (for1 < for2)
            return -1;
        else
            return 0;
    }
}

// retorno una fecha en el formato dd/MM/yyyy
function obtenerFechaFormateada(date) {
    var year = date.getFullYear();
    var month = (1 + date.getMonth()).toString();
    month = month.length > 1 ? month : '0' + month;
    var day = date.getDate().toString();
    day = day.length > 1 ? day : '0' + day;
    return day + '/' + month + '/' + year;
}

//devuelve 1 si fechaHoraInicio>fechaHoraFin, -1 si fechaHoraInicio<fechaHoraFin y 0 si fechaHoraInicio=fechaHoraFin
function comparaHora(fechaHoraInicio, fechaHoraFin) {
    if (fechaHoraInicio.getHours() < fechaHoraFin.getHours()) {
        return -1;
    } else if (fechaHoraInicio.getHours() > fechaHoraFin.getHours()) {
        return 1;
    } else { // las horas son iguales
        if (fechaHoraInicio.getMinutes() < fechaHoraFin.getMinutes()) {
            return -1;
        } else if (fechaHoraInicio.getMinutes() > fechaHoraFin.getMinutes()) {
            return 1;
        } else {
            return 0;
        }
    }
}

function parseDate(fecha) {
    var curr_date = fecha.getDate();
    var curr_month = fecha.getMonth();
    curr_month++;   
    var curr_year = fecha.getFullYear();
    var formattedDate = (('' + curr_date).length < 2 ? '0' : '') + curr_date + "/" + (('' + curr_month).length < 2 ? '0' : '') + curr_month + "/" + curr_year;
    return formattedDate;
}
function esFecha(fecha)
{
   
    for (var i = 0; i < fecha.length; i++) {
        //var carac = fecha.substring(i,i+1);
        var carac = fecha.charAt(i);
        if ((carac < "0" || carac > "9") && carac != "/") {
            return false;
        }
    }

    //Obtenemos el dia de la fecha
    var pos1 = fecha.indexOf("/");
    aux = fecha.substring(0, pos1);
    if (aux.length != 2)
        return false;  //verificamos que la parte del dia tenga dos caracteres
    if (aux.charAt(0) == "0") {
        aux = aux.substr(1, 1);
    }
    var dia = parseInt(aux);

    //Obtenemos el mes de la fecha
    var pos2 = fecha.indexOf("/", pos1 + 1);
    var aux = fecha.substring(pos1 + 1, pos2);
    if (aux.length != 2)
        return false;  //verificamos que la parte del mes tenga dos caracteres
    if (aux.charAt(0) == "0") {
        aux = aux.substr(1, 1);
    }
    var mes = parseInt(aux);

   
    aux = fecha.substring(pos2 + 1, fecha.length);
    if (aux.length != 4)
        return false;  
    var anno = parseInt(aux);


    if (mes < 1 || mes > 12)
        return false;  
    if (dia < 1 || dia > 31)
        return false;  
    if (anno < 1754 || anno > 9999)
        return false;  

    if (mes == 2 && dia > 29)
        return false;  

    if ((anno % 4) != 0 && dia == 29 && (mes == 2))
        return false; 

    if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) & dia > 30)
        return false;  //Meses de 30 dias.

    return true;
}

//
//function validatecla(event, tipo, textbox) {
//
//    var tecla;
//    if (navigator.appName.indexOf("Netscape") != -1) {
//        tecla = event.which;
//    } else {
//        tecla = event.keyCode;
//    }
//
//    var key = String.fromCharCode(tecla);
//
//    /*---Mayuscula---*/
//    key = key.toUpperCase();
//
//    var telefonos = "-/#";
//    var numeros = "0123456789";
//    var especiales = "'#�()_;:�[]{}!�/?�``��+�=&%$*";
//    var letras = "AaBbCcDdEeFfGgHhIiJjKkLlMmNn��OoPpQqRrSsTtUuVvWwXxYyZz";
//
//    if (tecla == 8)
//        return true;
//    if (tecla == 127)
//        return true;
//    if (tecla == 0)
//        return true;
//
//    if (tipo == 'letras') {
//        window.event.keyCode = window.event.keyCode - 32;
//        if (tecla == 32)
//            return true;
//        if (letras.indexOf(key) != -1)
//            return true;
//        return false;
//    }
//
//    if (tipo == 'enteros') {
//
//        if (numeros.indexOf(key) != -1)
//            return true;
//        return false;
//    }
//
//    if (tipo == 'ruc') {
//        if (numeros.indexOf(key) != -1) {
//            return true;
//        }
//
//        return false;
//    }
//
//    if (tipo == 'decimales') {
//        if (numeros.indexOf(key) != -1)
//            return true;
//        var cadena = textbox.value;
//        if (cadena.indexOf('.') != -1)
//            return false;
//        if (tecla == 46)
//            return true;
//        return false;
//    }
//
//    if (tipo == 'decimales2') {
//
//        if (numeros.indexOf(key) != -1) {
//            if (textbox.value.length == 5) {
//                if (textbox.value.indexOf('.') == -1) {
//                    textbox.value = textbox.value + '.';
//                }
//            }
//
//            return true;
//        }
//
//        var cadena = textbox.value;
//        if (cadena.indexOf('.') != -1)
//            return false;
//        if (tecla == 46)
//            return true;
//
//        return false;
//    }
//
//    if (tipo == 'decimales3') {
//
//        if (numeros.indexOf(key) != -1) {
//            if (textbox.value.length == 6) {
//                if (textbox.value.indexOf('.') == -1) {
//                    textbox.value = textbox.value + '.';
//                }
//            }
//
//            return true;
//        }
//
//        var cadena = textbox.value;
//        if (cadena.indexOf('.') != -1)
//            return false;
//        if (tecla == 46)
//            return true;
//
//        return false;
//    }
//
//    if (tipo == 'NoNumeros') {
//        if (tecla == 32)
//            return true;
//        if (numeros.indexOf(key) != -1 || especiales.indexOf(key) != -1)
//            return false;
//        return true;
//    }
//
//    if (tipo == 'especiales') {
//        if (tecla == 32)
//            return true;
//        if (especiales.indexOf(key) != -1)
//            return false;
//        return true;
//    }
//
//    if (tipo == 'num_letras') {
//        if (tecla == 32)
//            return true;
//        if (numeros.indexOf(key) != -1 || letras.indexOf(key) != -1)
//            return true;
//        return false;
//    }
//
//    if (tipo == 'telefonos') {
//        if (tecla == 32)
//            return true;
//        if (numeros.indexOf(key) != -1 || telefonos.indexOf(key) != -1)
//            return true;
//        return false;
//    }
//
//    if (tipo == 'todo') {
//        if (tecla == 32)
//            return true;
//        if (numeros.indexOf(key) != -1 || especiales.indexOf(key) != -1
//                || letras.indexOf(key) != -1)
//            return false;
//        return true;
//    }
//
//}

function redir(url) {
    //IE 7 detectado
    if (document.all && (!document.documentMode || (document.documentMode && document.documentMode < 8))) {
        window.location.replace(url);
    } else {
        window.location = url;
    }
}

function formateafecha(fecha)
{
    var long = fecha.length;
    var dia;
    var mes;
    var ano;

    if ((long >= 2) && (primerslap == false)) {
        dia = fecha.substr(0, 2);
        if ((IsNumeric(dia) == true) && (dia <= 31) && (dia != "00")) {
            fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
            primerslap = true;
        }
        else {
            fecha = "";
            primerslap = false;
        }
    }
    else
    {
        dia = fecha.substr(0, 1);
        if (IsNumeric(dia) == false)
        {
            fecha = "";
        }
        if ((long <= 2) && (primerslap = true)) {
            fecha = fecha.substr(0, 1);
            primerslap = false;
        }
    }
    if ((long >= 5) && (segundoslap == false))
    {
        mes = fecha.substr(3, 2);
        if ((IsNumeric(mes) == true) && (mes <= 12) && (mes != "00")) {
            fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
            segundoslap = true;
        }
        else {
            fecha = fecha.substr(0, 3);
            ;
            segundoslap = false;
        }
    }
    else {
        if ((long <= 5) && (segundoslap = true)) {
            fecha = fecha.substr(0, 4);
            segundoslap = false;
        }
    }
    if (long >= 7)
    {
        ano = fecha.substr(6, 4);
        if (IsNumeric(ano) == false) {
            fecha = fecha.substr(0, 6);
        }
        else {
            if (long == 10) {
                if ((ano == 0) || (ano < 1900) || (ano > 2100)) {
                    fecha = fecha.substr(0, 6);
                }
            }
        }
    }

    if (long >= 10)
    {
        fecha = fecha.substr(0, 10);
        dia = fecha.substr(0, 2);
        mes = fecha.substr(3, 2);
        ano = fecha.substr(6, 4);

        if ((ano % 4 != 0) && (mes == 02) && (dia > 28)) {
            fecha = fecha.substr(0, 2) + "/";
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia == 31)
                fecha = fecha.substr(0, 2) + "/";
        }
    }
    return (fecha);
}

function valida_numero(xinput, tipval)
{
    var xkey = event.keyCode;
    if (tipval == "int")
        if ((xkey < 48) || (xkey > 57))
            event.returnValue = false;
    if (tipval == "dec")
    {
        if (xkey < 46 || xkey > 57 || xkey == 47)
            event.returnValue = false;
    }
    if (tipval == "stn") {
        if (((xkey != 46) && (xkey < 48)) || ((xkey > 57) && (xkey < 65)) || ((xkey > 90) && (xkey != 95) && (xkey < 97)) || (xkey > 122))
            event.returnValue = false;
    }
    if (tipval == "str") {
        if (((xkey != 32) && (xkey < 65)) || ((xkey > 90) && (xkey < 97)))
            event.returnValue = false;
    }
    if (tipval == "stn2") {
        if (((xkey != 32) && (xkey < 46)) || ((xkey > 57) && (xkey < 65)) || ((xkey > 90) && (xkey != 95) && (xkey < 97)) || (xkey > 122))
            event.returnValue = false;
    }
    if (tipval == "tlf")
        if (((xkey != 32) && (xkey < 45)) || (xkey > 57))
            event.returnValue = false;

    if (tipval == "afn")
    {
        if (((xkey != 32) && (xkey < 45)) || (xkey > 57) ||
                ((xkey < 48) || (xkey > 57)))
            event.returnValue = false;
    }

}
function validarTextarea() {
    $('textarea').bind('keyup change', function() {
        var texto = $(this).val();
        var longitud = $(this).val().length;
        var maximo = parseInt($(this).attr("maxlength"));
        if (longitud > maximo) {
            $(this).val(texto.substr(0, maximo));
        }
    });
    $('textarea').bind('copy paste', function(e) {

        e.preventDefault();
    });
    $("textarea[maxlength]").keypress(function(event) {
        var key = event.which;

        //all keys including return.
        if (key >= 33 || key == 13 || key == 32) {
            var maxLength = $(this).attr("maxlength");
            var length = this.value.length;
            if (length >= maxLength) {
                event.preventDefault();
            }
        }
    });

}
function validateDouble(objeto, cantEnt, cantDec) {
    var encontrado = '0';
    var valor = objeto.value;
    if (valor != '') {
        ind = valor.indexOf('.');
        if (ind != -1)
            encontrado = 1;
        if (encontrado == '1') {
            if (valor.charAt(valor.length - 1) == '.' && (valor.length - 1) > ind)
                valor = valor.substring(0, valor.length - 1);
            dec = valor.substring(ind + 1, valor.length);
            if (dec.length > cantDec)
                valor = valor.substring(0, ind + cantDec + 1);
        } else {
            if (valor.length > cantEnt)
                valor = valor.substring(0, cantEnt);
        }
    }
    objeto.value = valor;
}

/*EOG*/
function redir(url) {
    //IE 7 detectado
    if (document.all && (!document.documentMode || (document.documentMode && document.documentMode < 8))) {
        window.location.replace(url);
    } else {
        window.location = url;
    }
}
/**
 * 
 * @param {type} data
 * @returns {String}
 */
function fecha(data) {
    if (data == null) {
        return "&nbsp;";
    } else {
        if (data == '-62135751600000') {
            return '01/01/0001';
        } else {
            if (typeof data == "string") {
                return data;
            } else {
                return $.datepicker.formatDate('dd/mm/yy', new Date(data));
            }
        }
    }
}

/**           Funciones Globales              **/
/**
 * @param idDiv identificador del div donde se renderizara el dialog
 * @param title titulo del dialog
 * @param autoopen booleano que indica si el dialog se mostrara al inicializar (true o false)
 * @param dialogClass clase del dialog
 **/
function dialog(idDiv, title, autoopen, dialogClass) {
    $('#' + idDiv).dialog({
        resizable: false,
        draggable: true,
        title: title,
        autoOpen: autoopen,
        height: "auto",
        width: "auto",
        dialogClass: dialogClass,
        modal: true
    });
}


/**
 * 
 * @param idSelect identificador del select
 * @param url URL que devuelve el JSON con los datos
 */
function comboboxMaestroColumna(idSelect, url) {
    $.ajax({
        url: url,
        type: "post",
        success: function(response) {
            if (!response.error) {
                $combo = $("#" + idSelect);
                $combo.empty();
                if (response.lista) {
                    $items = '<option value="">--Seleccione--</option>';
                    $.each(response.lista, function(index, value) {
                        $items += "<option value='" + value.idMaestroColumna + "'>" + value.descripcion + "</option>";
                    });
                    $combo.html($items);
                } else {
                    $combo.html('<option value="">--Seleccione--</option>');
                }
            } else {
            }
        },
        error: function() {
        }
    });
}

/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////

/**
 * Funcion que permite realizar las validaciones los Tipos Documentos;
 */
function validarTipoDocumento(cmb, txtNroDocumento) {
    $('#'+txtNroDocumento).unbind("keyup change paste");
    $('#'+txtNroDocumento).unbind("keypress");
    $('#'+txtNroDocumento).val("");
    var text = $("#"+cmb.id+" option:selected").text();
    if(text == "DNI"){
        $('#'+txtNroDocumento).numeric(onlyNumericOptions);
    	$('#'+txtNroDocumento).attr("maxlength", "8");
        $('#'+txtNroDocumento).alphanum(numeric);
    }else if(text == "CE") {
    	//$('#'+txtNroDocumento).alphanum(onlyAlphaNumOptions);
    	$('#'+txtNroDocumento).alphanum(alphaNumOptionsDash);
        $('#'+txtNroDocumento).attr("maxlength", "12");

    }
}
/**
 * Remover class radioError
 * @param id
 */
function removeClassError(id){
	$('#'+id).find('label').removeClass('radioError');
}
    
function asignacionValorCheck(nombreObjeto, valor) {
        $("input[name=" + nombreObjeto + "]").each(
                function(index) {
                    if ($(this).val() == valor) {
                        $(this).attr('checked', 'checked').button('refresh');
                    }
                }
        );
    }

function format(input){
	var num = input.value.replace(/\./g,'');
	if(!isNaN(num)){
	console.info("numero: --> "+num);
	num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{2})/g,'$1.');
	console.info("numero: --> "+num);
	num = num.split('').reverse().join('').replace(/^[\.]/,'');
	console.info("numero: --> "+num);
	input.value = num;
	}else{
	input.value = input.value.replace(/[^\d\.]*/g,'');
	}
	}

function formSubmit(form, action){
	$("#"+form).attr('action', action);
	$("#"+form).attr('method', 'post');
	$("#"+form).submit();
}

function fechaHoraFormateador(data, time){
    if(data == null){
          return "&nbsp;";
    }else{
          if(data == '-62135751600000'){
                 return '01/01/0001';
          }else{
                 if(typeof data == "string"){
                        return data;
                 }else{
                	 var date = new Date(data);
                	 tiempo = "";
                	 if(time){
                		 tiempo = ("00" + date.getHours()).slice(-2) + ":" + 
                		 	      ("00" + date.getMinutes()).slice(-2) + ":" + 
                		 	      ("00" + date.getSeconds()).slice(-2);
                		 return $.datepicker.formatDate('dd/mm/yy',date) + " " + tiempo; 
                	 }else{
                		 return $.datepicker.formatDate('dd/mm/yy',date);
                	 }                	                 	 	
                 }
          }
    }
}
