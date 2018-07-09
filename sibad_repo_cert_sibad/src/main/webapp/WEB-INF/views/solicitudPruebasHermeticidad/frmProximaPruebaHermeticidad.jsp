<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
       <script type="text/javascript" src='<c:url value="/javascript/app/solicitudPruebasHermeticidad/frmProximaPruebaHermeticidad.js"/>' charset="utf-8"></script>
    </head>
    <style type="text/css">

        .customfile {
       
            position: relative;
            overflow: hidden;
            width: 230px;
            height: 19px;
            border: solid 0px red;
            background: #fff;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            border: solid 2px #002c53;
            padding: 2px;
            -webkit-box-shadow: inset 1px 1px 2px #e4e4e4;
            box-shadow: inset 1px 1px 2px #e4e4e4;
        }
        
        .customfile span.cust-btn {
            float: right;
            line-height: 20px;
            padding: 1px 10px;
            height: 18px;
            text-align: center;
            font-weight: bold;
            cursor: pointer;
            color: #333;
            background: #e1e1e1;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
            text-transform: uppercase;
            /*margin-top: 1px;*/
        }
        
        .customfile span.cust-field {
            line-height: 20px;
            padding: 3px 4px;
            width: 225px;
            height: 20px;
            cursor: pointer;
            color: #212121;
            display: block;
            font-weight: normal;
            color: #333;
        }
        
        .customfile .fileinput {
            position: absolute;
            left: 0px;
            top: 0px;
            cursor: pointer;
            z-index: 99;
        }

    </style>
    <body>
        <div id="form_registro">
             <input type="text"   id="txtSetFocus" class="ipt-medium" name="txtSetFocus" style="background-color: transparent;color:#EFEFEF;border-style:none;height:0px;"/>       
             <input type="hidden" id="IDSolicitudPruebaReprueba" class="ipt-medium" name="" />
             <input type="hidden" id="IDResultadoPruebaReprueba" class="ipt-medium" name="" />
             <input type="hidden" id="IDCompartimiento" class="ipt-medium" name="" />
                          
            <div class="container" style="width:auto;">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset  style="border: none;">
                            <span id="titulo1" class="ui-panel-title" style="color: #494242;"></span>                      
                            <div class="tac">
                                <div class="form" style="width:auto; float:left; margin: 0px 0px 0px 10px;">                                  									
									<div class="filaForm">
                                        <div class="lble" style="width:225px;"><label for="txtFechaProxima">Fecha Pr&oacute;x. Prueba de Hermeticidad (*):</label></div>
                                        <input id="txtFechaProxima" class="ipt-medium" name="txtFechaProxima" type="text" style="width:125px"/>
                                    </div>																    										 	                                								
                                </div>  
                            </div>
                        </fieldset>

                        <div class="filaform" style="margin:10px 0px 10px 0px; text-align:center;">
                            <button id="btnGuardarFechaProx" title="Guardar" class="btnSimple">Guardar</button>                           
                        </div>                          
                    </div>
                </div>
            </div>
        </div>		
    </body>
</html>