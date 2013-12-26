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
                <td>进货金额</td>
                <td>商品数量</td>
                <td>进货次数</td>
                <td>进货均价</td>
                <td>订单金额</td>
                <td>商品数量</td>
                <td>订单数</td>
                <td>销售均价</td>
                <td>盈利</td>
                <td>剩余数量</td>
                <td>剩余均价</td>
            </tr>
            <c:forEach items="${tablelist}" var="item" varStatus="status">
	    		<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	    			<td>${status.index +1}</td>
	    			<td>${item.whoname}</td>
	    			<td>${item.name}</td>
	    			<td>${item.buy_money}</td>
	    			<td>${item.buy_num}</td>
	    			<td>${item.buy_count}</td>
	    			<td>${item.buy_money/item.buy_num}</td>
	    			<td>${item.sale_money}</td>
	    			<td>${item.sale_num}</td>
	    			<td>${item.sale_count}</td>
	    			<td>${item.sale_money/item.sale_num}</td>
	    			<td>${item.sale_money - item.buy_money}</td>
	    			<td>${item.buy_num - item.sale_num}</td>
	    			<td>${(item.buy_money -item.sale_money)/(item.buy_num - item.sale_num)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>