<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模块列表</title>
<link rel="StyleSheet" href="../css/admin/style.css" type="text/css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>列表</h2></div>
        <table class="GF-listTab">
            <tbody>
            <tr id="title">
                <td>ID</td>
                <td>批发商</td>
                <td>商品</td>
                <td>状态</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${list}" var="item" varStatus="status">
	    		<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	    			<td>${status.index +1}</td>
					<td>
					<c:forEach items="${wholist}" var="it" varStatus="st">
						<c:if test="${it.id==item.whoid}">${it.name}</c:if>
					</c:forEach>
					</td>
	    			<td align="left"><a href='goods!up.do?goods.id=${item.id}'>${item.name}</a></td>
					<td><c:if test="${item.state==0}">待定</c:if><c:if test="${item.state==1}">上架</c:if><c:if test="${item.state==2}">下架</c:if></td>
					<td><c:if test="${item.state==0 || item.state==2}"><a href='goods!up.do?goods.id=${item.id}&goods.state=1'>上架</a></c:if>
					<c:if test="${item.state==1}"><a href='goods!up.do?goods.id=${item.id}&goods.state=2'>下架</a></c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>