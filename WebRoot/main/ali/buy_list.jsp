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
        <form action="buy!list.do">
       	商品：<select id="buy.goodsid" name="buy.goodsid">
     			<option value="">全部</option>
     			<c:forEach items="${goodslist}" var="item" varStatus="status">
				<option value="${item.id}" <c:if test="${item.id==buy.goodsid }">selected</c:if>>${item.name}</option>
				</c:forEach>
			</select>
		时间:<input type="text" name="buy.date" value="${buy.date}" size="10" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"/>
       	<input type="submit" value="查询">
        </form>
        </div>
        <table class="GF-listTab">
            <tbody>
            <tr id="title">
                <td>ID</td>
                <td>商品名</td>
                <td>进货说明</td>
                <td>单价</td>
                <td>数量</td>
                <td>运费</td>
                <td>日期</td>
                <td>总价</td>
                <td>均摊运费价</td>
            </tr>
			<c:set var="count" value="0"/>
			<c:set var="count_price" value="0"/>
			<c:set var="count_num" value="0"/>
			<c:set var="count_fare" value="0"/>
			<c:set var="count_sum" value="0"/>
            <c:forEach items="${list}" var="item" varStatus="status">
	    		<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	    			<td>${status.index +1}</td>
					<td>
					<c:forEach items="${goodslist}" var="it" varStatus="st">
						<c:if test="${it.id==item.goodsid}">${it.name}</c:if>
					</c:forEach>
					</td>
	    			<td align="left"><a href='buy!up.do?buy.id=${item.id}'>${item.name}</a></td>
					<td><fmt:formatNumber value="${item.price}" minFractionDigits="2" /></td>
					<td>${item.num}</td>
					<td><fmt:formatNumber value="${item.fare}" minFractionDigits="2" /></td>
					<td>${item.date}</td>
					<td><fmt:formatNumber value="${item.price * item.num + item.fare}" minFractionDigits="2" /></td>
					<td><fmt:formatNumber value="${item.price + item.fare/item.num }" minFractionDigits="2" /></td>
					
					<c:set var="count" value="${count + 1}"/>
					<c:set var="count_price" value="${count_price + item.price}"/>
					<c:set var="count_num" value="${count_num + item.num}"/>
					<c:set var="count_fare" value="${count_fare + item.fare}"/>
					<c:set var="count_sum" value="${count_sum + (item.price * item.num + item.fare)}"/>
				</tr>
			</c:forEach>
            <tr id="title">
                <td>计数</td>
                <td> </td>
                <td>${count}笔</td>
                <td><fmt:formatNumber value="${count_price}" minFractionDigits="2" />元</td>
                <td>${count_num}件</td>
                <td><fmt:formatNumber value="${count_fare}" minFractionDigits="2" />元</td>
                <td> </td>
                <td><fmt:formatNumber value="${count_sum}" minFractionDigits="2" /></td>
                <td><fmt:formatNumber value="${count_sum/count_num}" minFractionDigits="2" />元</td>
            </tr>
		</table>
	</div>
</div>
</body>
</html>