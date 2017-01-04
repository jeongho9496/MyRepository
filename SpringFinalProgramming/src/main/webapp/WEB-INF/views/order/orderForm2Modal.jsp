<%@ page contentType="text/html;charset=UTF-8" %>

  
<%--이명진 --%>

 	<script type="text/javascript">
  		function getSelectValue1(frm)
  		{
 				frm.xname1.value = frm.xnameBox1.options[frm.xnameBox1.selectedIndex].text;
 				frm.optionValue.value = frm.xnameBox1.options[frm.xnameBox1.selectedIndex].value;
  		}
  		function getSelectValue2(frm)
  		{
 				frm.xname2.value = frm.xnameBox2.options[frm.xnameBox2.selectedIndex].text;
 				frm.optionValue.value = frm.xnameBox2.options[frm.xnameBox2.selectedIndex].value;
  		}
  		function getSelectValue3(frm)
  		{
 				frm.xname3.value = frm.xnameBox3.options[frm.xnameBox3.selectedIndex].text;
 				frm.optionValue.value = frm.xnameBox3.options[frm.xnameBox3.selectedIndex].value;
  		}
 	</script>
 	
 <div id="orderForm2Modal" class="modal fade" tabindex="-1" role="dialog">
   <div class="modal-dialog" role="document" style="width:450px; height:600px; margin-top: 20%">
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
         <h4 class="modal-title"><b>Order Detail SideMenu Option</b></h4>
       </div>
       <div class="modal-body">
 	<%--여기부터 --%>
	
			<div class="container" style="width: 80%; height: 80%">
				<div class="row">
					<div class="bs-docs-example">
						  <table>
						  	<tr>
						  		<th class="btn btn-default" width="100px;">수량</th>
						  		<th width="100px;">
						  			<input id="orderQuantity" type="number" data-style="btn-primary" style="margin-left: 20px;" name="quantity" min="1" max="5" value="1" style="display: inline;">
						  		</th>
						  	</tr>
						  	
						  	<tr>
						  		<th class="btn btn-danger" width="100px;">SIZE</th>
						  		<th width="100px;">
									<select id="orderSize"  style="margin-left: 20px;" data-style="btn-info" style="display: inline;">
						      			<option>Midium</option>
						      			<option>Large</option>
						      			<option>Small</option>
						  			</select>
								</th>
						  	</tr>
						  	<tr>
						  		<th id="orderSyrupN" class="btn btn-warning" width="100px;">SIRUP</th>
						  		<th width="100px;">
						  			<select id="orderSyrup"  style="margin-left: 20px;" data-style="btn-success" style="display: inline;">
						      			<option>설탕시럽</option>
						      			<option>딸기시럽</option>
						      			<option>초코시럽</option>
						      			<option>없음</option>
						  			</select>
						  		</th>
						  	</tr>
						  	<tr>
						  		<th id="orderShotN" class="btn btn-danger" width="100px;">SHOT</th>
						  		<th>
									<select id="orderShot"  style="margin-left: 20px;" data-style="btn-success" style="display: inline;">
						      			<option>샷추가1</option>
						      			<option>샷추가2</option>
						      			<option>샷추가3</option>
						      			<option>없음</option>
						  			</select>
								</th>
						  	</tr>
						  </table>
						  <br/>
						  <input onclick="newOrderSave()" class="btn btn-primary" type="submit" value="담기"/>&nbsp;&nbsp;&nbsp;
			  			  <input class="btn btn-primary" type="button" onclick="alert('결제 기능 추가 예정')" value="바로 주문">				      
					  </div>
				</div>
			</div>

 	<%--여기까지 --%>
 	
     </div>
     </div>
   </div>
 </div> 