<%@ page contentType="text/html;charset=UTF-8" %>

 <%--이명진 --%>
 <%--중요 --%>
 
 <div id="termListModal" class="modal fade" tabindex="-1" role="dialog">
   <div class="modal-dialog" role="document" style="width:1000px;">
     <div class="modal-content" style="height:700px">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
         <h4 class="modal-title"><b>주문 기간 보기</b></h4>
       </div>
       <div class="modal-body">
 		<%--여기부터 --%>
 		<div class="wrapper" align="center">
     	
         <table id="acrylic" style="width:900px">
             <thead>
                 <tr>
                     <th style="width:70px">주문번호</th>
                     <th style="width:70px">아이디</th>
                     <th style="width:70px">주문시간</th>
                     <th style="width:70px">총 가격</th>
                     <th style="width:70px">결제 방식</th>
                 </tr>
             </thead>
             <tbody id="termTbody">
             </tbody>
         </table>
     	</div>
       </div>
       <div class="modal-footer" style="text-align: center;">
 
       </div>  
     </div>
   </div>
 </div> 