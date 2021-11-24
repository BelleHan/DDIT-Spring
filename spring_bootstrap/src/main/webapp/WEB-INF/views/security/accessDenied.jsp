<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<head>
</head>

<title></title>
	
<body>    
	<script>
		alert("권한이 없습니다.");
		if (window.opener) {
			window.close();
		} else {
			history.go(-1);
		}
	</script>
</body>