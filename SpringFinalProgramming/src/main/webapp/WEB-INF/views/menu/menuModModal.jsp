<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuModModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:600px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>Menu Modify</b></h4>
      </div>
      <div class="modal-body">
      	<form class="form-horizontal" method="post" enctype="multipart/form-data">
      		<input type="hidden" class="form-control" name="mid" id="mid">
			<fieldset>
				<!-- Text input-->
				<!-- Text input-->
				<div>
					<label style="width:90px">분류</label>
				  	<select name="mgroup" id="mgroup">
   						<option value="커피" <c:if test="${menu.mgroup eq '커피'}"> selected="selected"</c:if>>커피</option>
   						<option value="차" <c:if test="${menu.mgroup eq '차'}"> selected="selected"</c:if>>차</option>
   						<option value="디저트" <c:if test="${menu.mgroup eq '디저트'}"> selected="selected"</c:if>>디저트</option>
   						<option value="기타" <c:if test="${menu.mgroup eq '기타'}"> selected="selected"</c:if>>기타</option>
   					</select>
				</div>
				
				<!-- Text input-->
				<div>
					<label style="width:90px" >메뉴이름</label>  
					<input name="mname" id="mname" type="text" style="width:400px" placeholder="예: 아메리카노"/>
				</div>
				
				<!-- Text input-->
				<div>
					<label style="width:90px" for="hot_ice">핫/아이스</label>  
				  	<input type="radio" name="hot_ice" checked value="HOT"/> HOT
	   				<input type="radio" name="hot_ice" value="ICE"/> ICE
	   				<input type="radio" name="hot_ice" value=" "/> 없음 
				</div>
				
				<!-- Text input-->
				<div>
					<label style="width:90px" for="mprice">가격</label>
				  	<input name="mprice" id="mprice" type="text" style="width:200px" placeholder="예: 2500"/>원
				</div>
				
				<!-- Textarea -->
				<div>
					<label style="width:90px; align:center" for="mcontents">설명</label>
				    <textarea name="mcontents" id="mcontents" style="width:400px; height:200px" placeholder="예: 따뜻한 아메리카노입니다."></textarea>
				</div>
				
				<!-- Photo -->
				<div>
					<label style="width:90px" for="photo">사진</label>
					<img style="width:100px" id="msavedfile">
				    <input type="file" style="width:400px" id="photo" name="photo"/>
				</div>
			</fieldset>
		</form>
      </div>
       
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div> 