<%@ page language="java" isErrorPage="true" %>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title><fmt:message key="errorPage.title"/></title>
    </head>

    <body>
        <h1><fmt:message key="errorPage.heading"/></h1>
        <p>
            <fmt:message key="errorPage.message">
                <fmt:param><c:url value="/"/></fmt:param>
            </fmt:message>
        </p>
    </body>
</html>
