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
                <td>商品</td>
                <td>买家</td>
                <td>旺旺</td>
                <td>付费</td>
                <td>数量</td>
                <td>运费</td>
                <td>日期</td>
                <td>合计单价</td>
            </tr>
            <c:forEach items="${list}" var="item" varStatus="status">
	    		<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	    			<td>${status.index +1}</td>
					<td>
					<c:forEach items="${goodslist}" var="it" varStatus="st">
						<c:if test="${it.id==item.goodsid}"><a href='buy!up.do?buy.id=${it.id}'>${it.name}</a></c:if>
					</c:forEach>
					</td>
	    			<td align="left"><a href='sale!up.do?sale.id=${item.id}'>${item.buyer}</a></td>
					<td>${item.buyer_ww}</td>
					<td>${item.price}</td>
					<td>${item.num}</td>
					<td>${item.fare}</td>
					<td>${item.date}</td>
					<td>${(item.price-item.fare)/item.num}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>