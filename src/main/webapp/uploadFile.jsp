<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/easyui/themes/icon.css">
<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Hello World!</h2>
	<form id="form" action="uploadFile" method="POST" enctype="multipart/form-data">
		<input type="file"  id="file1" name="file1" />

		<input type="submit" value="upload"/>
	</form>
	<script>
		function click(){
			$('#form').submit();
		}
	</script>
</body>
</html>
