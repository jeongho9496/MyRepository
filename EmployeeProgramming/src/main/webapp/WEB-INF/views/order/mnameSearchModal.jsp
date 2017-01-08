<%@ page contentType="text/html;charset=UTF-8" %>

 <%--이명진 --%>
 	<script type="text/javascript">
 		function getSelectValue(frm)
 		{
  			frm.sname.value = frm.snameBox.options[frm.snameBox.selectedIndex].text;
  			frm.optionValue.value = frm.snameBox.options[frm.snameBox.selectedIndex].value;
 		}
 	</script>
 	
 <div id="mnameSearchModal" class="modal fade" tabindex="-1" role="dialog">
   <div class="modal-dialog" role="document">
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
         <h4 class="modal-title"><b>주문 1차 화면&메뉴 단어 검색 화면</b></h4>
       </div>
       <div class="modal-body">
 		<%--여기부터 --%>
 		<div class="row">
     	
 		<div class="wrapper" align="center">
     	
         <table id="acrylic">
             <thead>
                 <tr>
                     <th>메뉴번호</th>
                     <th>메뉴사진</th>
                     <th>메뉴이름</th>
                 </tr>
             </thead>
             <tbody>
             
             	<%--테스트 데이터 --%>
             		<tr>
                     	<td data-label="메뉴번호">메뉴번호1</td>
                     	<td data-label="메뉴사진">메뉴사진1</td>
                     	<td class="orderForm2" data-label="메뉴이름"><a  type="button" class="btn btn-primary" href="#">아메리카노</a></td>
                 	</tr>
                 	<tr>
                     	<td data-label="메뉴번호">메뉴번호2</td>
                     	<td data-label="메뉴사진">메뉴사진2</td>
                     	<td class="orderForm2" data-label="메뉴이름"><a  type="button" class="btn btn-primary" href="#">카페모카</a></td>
                 	</tr>
             
             	<c:forEach var="menuList" items="${menuList}">
                 	<tr>
                     	<td data-label="메뉴번호">${menuList.mid}</td>
                     	<td data-label="메뉴사진">${menuList.msavedfile}</td>
                     	<td data-label="메뉴이름"><a href="orderItems2?mname=${menuList.mname}">${menuList.mname}</a></td>
                 	</tr>
                 </c:forEach>
             </tbody>
         </table>
         
     </div>
     
     <%--pagination--%>
       <div class="modal-footer">
       	<a type="button" class="btn btn-primary" href="list?pageNo=1">처음</a>
       	
 		<c:if test="${groupNo>1 }">
 			<a type="button" class="btn btn-primary" href="list?pageNo=${startPageNo-1}">이전</a>
 		</c:if>
 		
 		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
 			<a type="button" class="btn btn-primary" href="list?pageNo=${i}" <c:if test="${pageNo==i}">style="color:red"</c:if>>${i}</a>
 		</c:forEach> 
 		 
 		<c:if test="${groupNo<totalGroupNo }">
 			<a type="button" class="btn btn-primary" href="list?pageNo=${endPageNo1 }">다음</a>
 		</c:if>
 		
 		<a type="button" class="btn btn-primary" href="list?pageNo=${totalPageNo }">맨끝</a>  
       </div>
     
 	</div>
 	<%--여기까지 --%>
 		
     	
 	
     </div>
     </div>
   </div>
 </div> 