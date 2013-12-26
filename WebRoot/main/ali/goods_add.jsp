<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" href="../css/admin/style.css" type="text/css"/>
<script language="javascript" type="text/javascript" src="../js/Calendar3.js" ></script>
</head>
<body>

<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>商品添加</h2></div>
        <form method="post" action="goods!add.do" name="add" id="add">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>批发商:</b></td>
                    <td>
                    <select id="goods.whoid" name="goods.whoid">
						<c:forEach items="${wholist}" var="item" varStatus="status">
							<option value="${item.id}" <c:if test="${item.id==goods.whoid}">selected</c:if>>${item.name}</option>
						</c:forEach>
					</select>
                    </td>
                    </tr>
                    <tr><td class="title"><b>商品名:</b></td><td><input type="text" name="goods.name" value="${goods.name}" size=30></td></tr>
                    <tr><td class="title"><b>介 绍:</b></td><td><input type="text" name="goods.info" value="${goods.info}" size=30></td></tr>
                    <tr><td colspan="2"><input type="submit" value="提  交" name="submit" id="submit" class="sub-btn"></td></tr>
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
		var name = $('input[name="goods.name"]').val();
		if(name == ''){
			alert('名不能为空!');
			$('input[name="goods.name"]').focus();
			return false;
		}

		$('submit').submit();

	});
});
</script>

</html>