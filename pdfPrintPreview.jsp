<%@ page contentType="text/html; charset=utf-8" %>

<HTML>
	<HEAD>
		<title>pdf print</title>
		<SCRIPT ></SCRIPT>
	</HEAD>	
	<BODY>
	
		
<!--  <embed src="/ShowPdf" type="application/pdf" width="100%" height="100%"  id="xyz"> -->
 	
	<object data="${pageContext.request.contextPath}/ShowPdf" type="application/pdf" width="100%" height="100%" id="xyz" > </object>  
	
	</BODY>

</HTML>
