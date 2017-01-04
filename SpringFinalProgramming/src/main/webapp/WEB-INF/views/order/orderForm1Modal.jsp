<%@ page contentType="text/html;charset=UTF-8" %>

<%--이명진 --%>

 	<script type="text/javascript">
 		function getSelectValue(frm)
 		{
  			frm.sname.value = frm.snameBox.options[frm.snameBox.selectedIndex].text;
  			frm.optionValue.value = frm.snameBox.options[frm.snameBox.selectedIndex].value;
 		}
 	</script>
 	
 <div id="orderForm1Modal" class="modal fade" tabindex="-1" role="dialog">
   <div class="modal-dialog" role="document" style="width:700px; height:600px;">
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
         <h4 class="modal-title"><b>Order Start All Menu</b></h4>
       </div>
       <div class="modal-body">
 		<%--여기부터 --%>
 		<div class="row">
     	<div class="btn-group btn-group-justified">
             <div class="btn-group">
                 <button onclick="orderMenuList('전체')" type="button" class="btn btn-nav">
                     <span class="glyphicon glyphicon-globe"></span>
     			    <p>전체</p>
                 </button>
             </div>
             <div class="btn-group">
                 <button onclick="orderMenuList('커피')" type="button" class="btn btn-nav">
                     <span class="glyphicon glyphicon-glass"></span>
     			    <p>커피</p>
                 </button>
             </div>
             <div class="btn-group">
                 <button onclick="orderMenuList('차')" type="button" class="btn btn-nav">
                     <span class="glyphicon glyphicon-leaf"></span>
     			    <p>차</p>
                 </button>
             </div>
             <div class="btn-group">
                 <button onclick="orderMenuList('디저트')" type="button" class="btn btn-nav">
                     <span class="glyphicon glyphicon-ice-lolly-tasted"></span>
     			    <p>디저트</p>
                 </button>
             </div>
             <div class="btn-group">
                 <button onclick="orderMenuList('기타')" type="button" class="btn btn-nav">
                     <span class="glyphicon glyphicon-apple"></span>
     			    <p>기타</p>
                 </button>
             </div>
         </div><br/>
         
         <div class="wrapper" align="center" style="margin-bottom: 0px;">
			<table id="acrylic" style="width:620px; margin-right: 23px; margin-bottom: 0px;">
	             <thead>
	                 <tr>
	                     <th style="width:70px">메뉴번호</th>
	                     <th style="width:70px">메뉴사진</th>
	                     <th style="width:70px">핫_아이스</th>
	                     <th style="width:70px">메뉴이름</th>
	                 </tr>
	             </thead>
	        </table>
        </div>

 		<div class="wrapper" align="center" style="height:400px; overflow-y:scroll; margin-top: 0px;">
     	
         <table id="acrylic" style="width:600px;margin-top: 0px;">
             <tbody id="menuTbody">
             </tbody> 
         </table>
     </div>
     
     <%--pagination--%>
       <div class="modal-footer">
       		<input id="payOrder" onclick="resultOrder()" class="btn btn-danger" type="submit" value="결제 완료"/>&nbsp;&nbsp;
       		<input id="cancelOrder" onclick="cancelOrder()" class="btn btn-success" type="submit" value="결제 취소"/>
       </div>
     
 	</div>
 	<%--여기까지 --%>
 		
     	
 	
     </div>
     </div>
   </div>
 </div> 