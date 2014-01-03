<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模块列表</title>
<link rel="StyleSheet" href="../css/admin/style.css" type="text/css" />
<script language="javascript" type="text/javascript" src="../js/Calendar3.js" ></script>
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>列表</h2></div>
        <div id="gamemain">
        <form action="sale!list.do">
       	商品：<select id="sale.goodsid" name="sale.goodsid">
     			<option value="">全部</option>
     			<c:forEach items="${goodslist}" var="item" varStatus="status">
				<option value="${item.id}" <c:if test="${item.id==sale.goodsid }">selected</c:if>>${item.name}</option>
				</c:forEach>
			</select>
		时间:<input type="text" name="sale.date" value="${sale.date}" size="10" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"/>
		用户名:<input type="text" name="sale.buyer" value="${sale.buyer}" size="10" maxlength="10"/>
       	<input type="submit" value="查询">
        </form>
        </div>
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
            
			<c:set var="count" value="0"/>
			<c:set var="count_price" value="0"/>
			<c:set var="count_num" value="0"/>
			<c:set var="count_fare" value="0"/>
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
					<td><fmt:formatNumber value="${item.price}" minFractionDigits="2" /></td>
					<td>${item.num}</td>
					<td><fmt:formatNumber value="${item.fare}" minFractionDigits="2" /></td>
					<td>${item.date}</td>
					<td><fmt:formatNumber value="${(item.price-item.fare)/item.num}" minFractionDigits="2" /></td>
					
					<c:set var="count" value="${count + 1}"/>
					<c:set var="count_price" value="${count_price + item.price}"/>
					<c:set var="count_num" value="${count_num + item.num}"/>
					<c:set var="count_fare" value="${count_fare + item.fare}"/>
				</tr>
			</c:forEach>
			
            <tr id="title">
                <td>计数</td>
                <td> </td>
                <td> </td>
                <td>${count}笔</td>
                <td><fmt:formatNumber value="${count_price}" minFractionDigits="2" />元</td>
                <td>${count_num}件</td>
                <td><fmt:formatNumber value="${count_fare}" minFractionDigits="2" />元</td>
                <td> </td>
                <td><fmt:formatNumber value="${(count_price-count_fare)/count_num}" minFractionDigits="2" />元</td>
            </tr>
		</table>
	</div>
</div>
</body>
</html>