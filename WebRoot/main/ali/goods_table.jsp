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
        <div id="gamemain">
        <form action="goods!table.do">
       	批发商：<select id="goods.whoid" name="goods.whoid">
     			<option value="0">全部</option>
     			<c:forEach items="${wholist}" var="item" varStatus="status">
				<option value="${item.id}" <c:if test="${item.id==goods.whoid }">selected</c:if>>${item.name}</option>
				</c:forEach>
			</select>
       	<input type="submit" value="查询">
        </form>
        </div>
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
            
			<c:set var="count" value="0"/>
			<c:set var="count_buy_money" value="0"/>
			<c:set var="count_buy_num" value="0"/>
			<c:set var="count_buy_count" value="0"/>
			<c:set var="count_sale_money" value="0"/>
			<c:set var="count_sale_num" value="0"/>
			<c:set var="count_sale_count" value="0"/>
			
            <c:forEach items="${tablelist}" var="item" varStatus="status">
	    		<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	    			<td>${status.index +1}</td>
	    			<td>${item.whoname}</td>
	    			<td>${item.name}</td>
	    			<td><fmt:formatNumber value="${item.buy_money}" minFractionDigits="2" /></td>
	    			<td>${item.buy_num}</td>
	    			<td>${item.buy_count}</td>
	    			<td><fmt:formatNumber value="${item.buy_money/item.buy_num}" minFractionDigits="2" /></td>
	    			<td><fmt:formatNumber value="${item.sale_money}" minFractionDigits="2" /></td>
	    			<td>${item.sale_num}</td>
	    			<td>${item.sale_count}</td>
	    			<td><fmt:formatNumber value="${item.sale_money/item.sale_num}" minFractionDigits="2" /></td>
	    			<td><fmt:formatNumber value="${item.sale_money - item.buy_money}" minFractionDigits="2" /></td>
	    			<td>${item.buy_num - item.sale_num}</td>
	    			<td><fmt:formatNumber value="${(item.buy_money -item.sale_money)/(item.buy_num - item.sale_num)}" minFractionDigits="2" /></td>
				
					<c:set var="count" value="${count + 1}"/>
					<c:set var="count_buy_money" value="${count_buy_money + item.buy_money}"/>
					<c:set var="count_buy_num" value="${count_buy_num + item.buy_num}"/>
					<c:set var="count_buy_count" value="${count_buy_count + item.buy_count}"/>
					<c:set var="count_sale_money" value="${count_sale_money + item.sale_money}"/>
					<c:set var="count_sale_num" value="${count_sale_num + item.sale_num}"/>
					<c:set var="count_sale_count" value="${count_sale_count + item.sale_count}"/>
				</tr>
			</c:forEach>
			
            <tr id="title">
                <td>计数</td>
                <td> </td>
                <td>${count}笔</td>
                <td><fmt:formatNumber value="${count_buy_money}" minFractionDigits="2" />元</td>
                <td>${count_buy_num}件</td>
                <td>${count_buy_count}次</td>
                <td><fmt:formatNumber value="${count_buy_money/count_buy_num}" minFractionDigits="2" />元</td>
                <td><fmt:formatNumber value="${count_sale_money}" minFractionDigits="2" />元</td>
                <td>${count_sale_num}件</td>
                <td>${count_sale_count}次</td>
                <td><fmt:formatNumber value="${count_sale_money/count_sale_num}" minFractionDigits="2" />元</td>
                <td><fmt:formatNumber value="${count_sale_money - count_buy_money}" minFractionDigits="2" />元</td>
                <td>${count_buy_num-count_sale_num}件</td>
                <td><fmt:formatNumber value="${(count_buy_money-count_sale_money)/(count_buy_num-count_sale_num)}" minFractionDigits="2" />元</td>
            </tr>
		</table>
	</div>
</div>
</body>
</html>