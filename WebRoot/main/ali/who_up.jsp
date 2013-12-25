<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" href="../css/admin/style.css" type="text/css"/>
</head>
<body>

<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>批发商添加</h2></div>
        <form method="post" action="who!up.do" name="up">
        	<input type="hidden" name="who.id" value="${who.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>批发商名:</b></td><td><input type="text" name="who.name" value="${who.name}" size=30></td></tr>
                    <tr><td class="title"><b>介 绍:</b></td><td><input type="text" name="who.info" value="${who.info}" size=30></td></tr>
                    <tr><td class="title"><b>网站地址:</b></td><td><input type="text" name="who.url" value="${who.url}" size=30></td></tr>
                    <tr><td colspan="2"><input type="submit" value="提  交" name="submit" class="sub-btn"></td></tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</div>
</body>

<script language="javascript" type="text/javascript" src="/js/jquery/jquery.js" ></script>
<script language="javascript" type="text/javascript" >
$(function() {
	$('input[name="submit"]').click(function() {
		var name = $('input[name="who.name"]').val();
		if(name == ''){
			alert('模块名不能为空!');
			$('input[name="who.name"]').focus();
			return false;
		}

		$('form').submit();

	});
});
</script>

</html>