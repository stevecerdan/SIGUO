<%@tag language="java" pageEncoding="ISO-8859-15"%>
<%@ include file="/common/taglibs.jsp"%>
<%@attribute name="pageTitle"%>
<%@attribute name="scrollPanelTitle"%>
<%@attribute name="fecha"%>
<%@attribute name="usuario"%>
<%@attribute name="headArea" fragment="true" %>
<%@attribute name="bodyArea" fragment="true" %>

<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="<c:url value="/images/osinerg.ico"/>"/>
        <jsp:include page ="/WEB-INF/templates/css.jspf"/>
        <jsp:include page ="/WEB-INF/templates/js.jspf"/>
        <jsp:include page="/WEB-INF/templates/msg.jspf" />

        <jsp:invoke fragment="headArea"/>

        <title>SIBAD | ${pageTitle}</title>
    </head>
    <body>
        <div id="overlay_loading" style="display:none;">
            <div class="fancytree-loading"><span class="fancytree-expander"></span></div>
        </div>
        <div id="notifynormal"></div>

        <div id="header">
            <div id="logoWrapper">
                <img id="logo" alt="logo" src="<c:url value="/images/osinergminLogo.png"/>">
            </div>
            <div id="divDirectorio" style="position:absolute; right:260px; top:12px; display: none;">
            	<a  id="linkDirectorio" href="javascript:common.descargarDirectorio()" style="top:7px; left=1px; position:relative;"><img alt="" src="/sibad/images/folder.png" style="height: 28px;"></a>
            </div>
            <div id="userWrapper">
                <table>
                    <tr>
                        <td class="tar">Usuario : </td> 
                        <td class="tar">${usuario} &nbsp;&nbsp;&nbsp;</td> 
                    </tr>
                    <tr>
                        <td class="tar">Fecha : </td> 
                        <td class="tar">${fecha} &nbsp;&nbsp;&nbsp;</td>
                    </tr>
                </table>
            </div>
        </div>
        
        <div title="${scrollPanelTitle}" class="scrollPanel">
            <jsp:invoke fragment="bodyArea"/>
        </div>
    </body>
    
    <!-- ------------------------------------------------------------------------------------------- -->
        <div id="dialog-message" title="" style="display:none;">
			<p>
				<span class="ui-icon ui-icon-circle-check" style="float:left;margin-left: 0px;">
				<!-- margin:0 7px 50px 0; -->
				</span>
				<label id="dialog-message-content"></label>
				
			</p>	
        </div>
        
        <div id="dialog-message_registroRV" style="display:none;" title="">
			<p>
				<span class="ui-icon ui-icon-circle-check" style="float:left;margin-left: 0px;">
				<!-- margin:0 7px 50px 0; -->
				</span>
				<label id="dialog-message-content_registroRV"></label>
				
			</p>	
        </div>
        <!-- ------------------------------------------------------------------------------------------- -->
    
    <footer>
    	<div class="container">
	    	<div id="header" style="height:100px;"><br><br>
	    	</div>
        </div>
    </footer>
</html>