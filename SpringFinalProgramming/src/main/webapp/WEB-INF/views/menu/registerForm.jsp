<%@ page contentType="text/html;charset=UTF-8" %>

<%-- 보나 20161116~ --%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
   </head> 
   <body>
   <h2>메뉴 등록</h2>
   <hr/>
   <form method="post" enctype="multipart/form-data">
   		<table>
   			<tr>
   				<td style="background-color:gold; width:70px">분류</td>
   				<td>
   					<select name="mgroup">
   						<option selected>커피</option>
   						<option>차</option>
   						<option>디저트</option>
   						<option>기타</option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">메뉴명</td>
   				<td><input type="text" name="mname" style="width:200px;"></td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">아이스/핫</td>
   				<td>
   					<input type="radio" name="hot_ice" checked value="HOT"> HOT
   					<input type="radio" name="hot_ice" value="ICE"> ICE
   					<input type="radio" name="hot_ice" value=" "> 없음
   				</td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">가격</td>
   				<td><input type="text" name="mprice" style="width:100px;"></td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">설명</td>
   				<td><input type="text" name="mcontents" style="width:600px;"></td>
   			</tr>
   			<tr>
				<td style="background-color:gold; width:70px">사진</td>
				<td><input type="file" name="photo"/></td>
			</tr>
   		</table>
   		<input type="submit" value="등록"/>
   		<input type="reset" value="취소"/>
   </form>
   
   </body>
</html>
  