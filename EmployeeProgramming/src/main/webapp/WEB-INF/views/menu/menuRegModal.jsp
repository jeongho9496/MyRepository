<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuRegModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:600px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>Menu Register</b></h4>
      </div>
      <div class="modal-body">
      	<form class="form-horizontal" method="post" enctype="multipart/form-data">
			<fieldset>
				<!-- Text input-->
				<div>
					<label style="width:90px">분류</label>
				  	<select name="mgroup" id="mgroup">
   						<option selected value="커피">커피</option>
   						<option>차</option>
   						<option>디저트</option>
   						<option>기타</option>
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
				    <input type="file" style="width:400px" id="photo" name="photo"/>
				</div>
			</fieldset>
		</form>
      </div>
       
      <div class="modal-footer">
	      <button id="btnMenuReg" type="button" class="btn btn-warning">등록</button>
	      <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div> 
