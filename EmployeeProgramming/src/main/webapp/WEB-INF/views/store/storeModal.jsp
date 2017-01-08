<%@ page contentType="text/html;charset=UTF-8" %>

<div id="storeModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>가맹점 정보</b></h4>
      </div>
      <div id="modal-body" class="modal-body">
	    <table class="table table-striped custab">
		    <thead>
		    <!--  <a href="#" id="btnStoreInfo" class="btn btn-primary btn-xs pull-right"><b>+</b> 목록 추가</a> -->

		        <tr>
		            <th>매장아이디</th>
		            <th>매장이메일</th>
		            <th>매장이름</th>
		            <th>지점명</th>
		            <th>매장주소</th>
		            <th>매장전화번호</th>
		            <th>매장오픈시간</th>
		            <th>매장마감시간</th>
		            <th>비콘번호</th>
		            <th>매장사진</th>
		            <th class="text-center">수정/삭제</th>
		        </tr>
		    </thead>
		    	<tbody id="storeTbody"></tbody>
				<!-- <tr>
		            <td id="sid"></td>
		            <td id="semail"></td>
		            <td id="semail2"></td>
		            <td id="sname"></td>
		            <td id="slocal"></td>
		            <td id="saddr"></td>
		            <td id="stel"></td>
		            <td id="sopen"></td>
		            <td id="sclosed"></td>
		            <td id="abeacon"></td>
		            <td>사진1</td>
		            <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
		      	</tr>
		  -->
	       		 <tr>
		             <td>starbucks1</td>
		             <td>storebucks1@naver.com</td>
		             <td>스타벅스</td>
		             <td>송파구청점</td>
		             <td>서울 송파구 오금로 87</td>
		             <td>0221450300</td>
		             <td>07:00</td>
		             <td>11:00</td>
		             <td>503</td>
		             <td><img src="${pageContext.servletContext.contextPath}/resources/image/스타벅스 송파구청점-1.JPG" width="100"></td>
		             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	        	 </tr>

	    </table>
      </div>
      <div class="modal-footer">
        <button id="btnContents" type="button" class="btn btn-primary">변경사항 저장</button> 
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        
      </div>
    </div>
  </div>
</div> 
