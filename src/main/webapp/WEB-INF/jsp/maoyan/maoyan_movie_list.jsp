<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="/js/easyui/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="/css/easyui/themes/default/easyui.css" type="text/css" />

<title>Insert title here</title>
</head>
<body>
	<table class="easyui-datagrid" title="Basic DataGrid" style="width:98%;width:98%" data-options="
	url : 'http://localhost/maoyanMovie/findPageByParam',
	ctrlSelect : true,
	pagination : true,
	rownumbers : true,
	scrollOnSelect : true
	
	">
		<thead>
			<tr>
				<th data-options="field:'nm',width:'20%'">影片名称</th>
				<th data-options="field:'cat',width:'20%'">影片类型</th>
				<th data-options="field:'dir',width:'20%'">导演</th>
				<th data-options="field:'star',width:'20%'">主演</th>
				<th data-options="field:'img',width:'20%',formatter: function(value,row,index){
				return '<img src=\'' + value + '\'>';
			}">图片</th>
			</tr>
		</thead>	
	</table>
</body>
</html>