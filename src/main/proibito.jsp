<html>
<body style="font-family: Arial;">
<center>
<div style="width: 50%; height: 300px; border: 1px solid red; margin: 50px;">
<br/>
<b>Utente non autorizzato.</b>
<br/>
<br/>
<%
String scheme = request.getScheme();
String hostName = request.getServerName();
int port = request.getServerPort();
String url = scheme + "://" + hostName + ":" + port + request.getContextPath();
String loginHost = scheme + "://" + hostName + ":" + port;
%>
Si prega di rieseguire il <a href="<%=loginHost%>/cas/logout?service=<%=url%>">login</a>.
</div>
</center>
</body>
</html>
<%
	try {

		if (session != null) {
			session.invalidate();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>