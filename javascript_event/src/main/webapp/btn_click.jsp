<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<% request.setAttribute("name", "kim"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<button type="button" data="1234" id="btn">누르세요</button> <br>
	<button type="button" data="1234" id="jquery_btn">누르세요</button>
	
	<hr/>
	
	<button type="button" id="btn2" onclick="display_go('${name}');">누르세요</button>
	
	<div id="displayDiv" style="background:green; width: 100px; height: 100px"></div>
	<div id="btnDiv"></div>
	
	<script>
		document.getElementById("btn").onclick=function(event){
			alert(event.currentTarget.getAttribute("data"));
		}
	</script>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$('button#jquery_btn').click(function(){
			alert($(this).attr("data"));
		});
	</script>
	<script>
		display_go("여기에 낙서를 하세요!!");
		function display_go(message){
			//document.querySelector('div#displayDiv').innerText=message;
			$('div#displayDiv').text(message);
		}
	</script>
		
	<script>
		var button = $('<button>').attr({
										type : "button",
										data : "mimi",
										id : "onBtn"
									}).text("역시 누르시오!");
		$('div#btnDiv').css("background","yellow").append(button);

	$('div#btnDiv').on('click','button#onBtn',function(){
		alert($(this).attr("data"));
	});
	</script>
	
	
</body>
</html>