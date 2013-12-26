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
        <div id="gamefeatures"><h2>批发商添加</h2></div>
        <form method="post" action="buy!up.do" name="up">
        	<input type="hidden" name="buy.id" value="${buy.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>商品商:</b></td>
                    <td>
                    <select id="buy.goodsid" name="buy.goodsid">
						<c:forEach items="${goodslist}" var="item" varStatus="status">
							<option value="${item.id}" <c:if test="${item.id==buy.goodsid}">selected</c:if>>${item.name}</option>
						</c:forEach>
					</select>
                    </td>
                    </tr>
                    <tr><td class="title"><b>进货说明:</b></td><td><input type="text" name="buy.name" value="${buy.name}" size=30></td></tr>
                    <tr><td class="title"><b>介 绍:</b></td><td><input type="text" name="buy.info" value="${buy.info}" size=30></td></tr>
                    <tr><td class="title"><b>单价:</b></td><td><input type="text" name="buy.price" value="${buy.price}" size=30></td></tr>
                    <tr><td class="title"><b>数量:</b></td><td><input type="text" name="buy.num" value="${buy.num}" size=30></td></tr>
                    <tr><td class="title"><b>运费:</b></td><td><input type="text" name="buy.fare" value="${buy.fare}" size=30></td></tr>
                    <tr><td class="title"><b>进货日期:</b></td><td><input type="text" name="buy.date" value="${buy.date}" size=30 onclick="new Calendar().show(this);"></td></tr>
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
		var name = $('input[name="buy.name"]').val();
		if(name == ''){
			alert('名不能为空!');
			$('input[name="buy.name"]').focus();
			return false;
		}

		$('form').submit();

	});
});
</script>

</html>