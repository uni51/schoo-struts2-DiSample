<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Java入門</title>
  </head>
  <body>
  	<h1>Struts2の中でDIされているクラス（オブジェクト）</h1>
  	<table>
  		<%-- Actionクラスでセットしたリストを表示 --%>
	  	<s:iterator value="list" status="list">
	  		<tr>
	  			<td><s:property value="name"/></td>
	  		</tr>
	  	</s:iterator>
  	</table>
  </body>
</html>