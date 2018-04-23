<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp"%>
        <title><fmt:message key="403.titlebar"/></title>
    </head>

    <body>
        <h1><fmt:message key="403.title"/></h1>
        <p>
            <fmt:message key="403.message">
                <fmt:param><c:url value="/"/></fmt:param>
            </fmt:message>
        </p>
    </body>
</html>