function showPageList(pageNo) {
	$.ajax({
      url: "order/list",
      data: {"pageNo":pageNo},
      success: function(data) {
         $("#orderTbody").empty();
         $("#orderModal .modal-footer").empty();
         for(var i=0; i<data.list.length; i++) {
            var order = data.list[i];
            $("#orderTbody").append(
               '<tr>' +
                   '<td data-label="주문번호" style="width:70px;"><a type="button" class="btn btn-primary" href="javascript:detailOrderList(\'' + order.ogid + '\')">' + order.ogid.substring(4, 7) + order.ogid.substring(11, 14) +'</a></td>' +
                   '<td data-label="아이디" style="width:70px; font-size:18px; font-weight:bold;">' + order.user_id + '</td>' +
                   '<td data-label="주문시간" style="width:70px; font-size:15px;">' + order.ogtime + '</td>' +
                   '<td data-label="총 가격" style="width:70px; font-size:18px; font-weight:bold;">' + order.ogtotalprice + '</td>' +
                   '<td data-label="결제 방식" style="width:70px; font-size:15px;">' + order.oghowpay + '</td>' +
                   '</tr>'
               );
            
         }
         
         var pageNo = data.pageNo;
         var rowsPerPage = data.rowsPerPage;
         var pagesPerGroup = data.pagesPerGroup;
         var totalBoardNo = data.totalBoardNo;
         var totalPageNo = data.totalPageNo;
         var totalGroupNo = data.totalGroupNo;
         var groupNo = data.groupNo;
         var startPageNo = data.startPageNo;
         var endPageNo = data.endPageNo;
         
         $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(1)">처음</a>');
         
         if(groupNo>1) {
            $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(' + (startPageNo-1) + ')">이전</a>');
         }
         
         for(var i=startPageNo; i<=endPageNo; i++) {
            if(pageNo == i) {
               $("#orderModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageList(' + i + ')">' + i + '</a>');
            } else {
               $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(' + i + ')">' + i + '</a>');
            }
         }
         
         if(groupNo<totalGroupNo) {
            $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(' + (endPageNo+1) + ')">다음</a>');
         }
         
         
         $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(' + totalPageNo + ')">맨끝</a>');
         
         
         $("#orderModal").modal("show");
      }
   });

}

function detailOrderList(ogid){
	var modifyogid = ogid;
	console.log("여기 옴");
	$("#orderModal").css("opacity","0.5");
	$.ajax({
	      url: "order/detailList",
	      data: {"ogid": ogid},
	      success: function(data) {
	    	  $("#detailTbody").empty();
	          $("#detailListModal .modal-footer").empty();
	         for(var i=0; i<data.detailList.length; i++) {
	            var detail = data.detailList[i];
	            $("#detailTbody").append(
	            	  '<tr>' +
	                   	'<td data-label="제품명" style="width:100px; font-size:15px; font-weight:bold;">'+detail.mname+'</td>' +
	                   	'<td data-label="핫_아이스" style="width:50px; font-size:18px; font-weight:bold;">' + detail.hot_ice + '</td>' +
	                   	'<td data-label="수량" style="width:50px; font-size:18px; font-weight:bold;">' + detail.sameItemCount + '</td>' +
	                   	'<td data-label="사이드" style="width:120px; font-size:15px; font-weight:bold;">' + detail.xname + '</td>' +
	                   	'<td data-label="가격" style="width:70px; font-size:18px;">' + detail.sameItemPrice + '</td>' +	
	                 '</tr>'
	               );
	            
	         }
	         if(detail==null){
	        	 var resultprice = 0;
		         var oghowpay = "카드 결제";
	         }else{
	        	 var resultprice = data.resultprice;
		         var oghowpay = detail.oghowpay; 
	         }
	         
	         
	         $("#detailListModal .modal-footer").append('총 가격 : <p class="btn btn-primary">'+resultprice+'</p>&nbsp;&nbsp;');
	         $("#detailListModal .modal-footer").append('결제방식 : <p class="btn btn-primary">'+oghowpay+'</p>&nbsp;&nbsp;');
	         $("#detailListModal .modal-footer").append('삭제 : <input id="deleteOrder" onclick="deleteOrder(\''+ogid+'\')" class="btn btn-success" type="submit" value="삭제"/>&nbsp;&nbsp;');
	   	  
	         
	         $("#detailListModal").modal({
	 			backdrop:"static",
				show:true
			});
	      }
	   });
	$("#detailListModal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
}

function termList(pageNo) {
	var term1 = $("#datepicker1").val();
	var term2 = $("#datepicker2").val();
	
	$.ajax({
      url: "order/termList",
      data: {"term1":term1,"term2":term2,"pageNo":pageNo},
      success: function(data) {
    	  location.reload();
    	 console.log("성공");
         $("#termTbody").empty();
         $("#termListModal .modal-footer").empty();
         for(var i=0; i<data.termList.length; i++) {
            var term = data.termList[i];
            $("#termTbody").append(
               '<tr>' +
                   '<td class="detailList" data-label="주문번호" style="width:70px"><a type="button" class="btn btn-primary" href="javascript:detailOrderList(\'' + term.ogid + '\')">' + term.ogid.substring(4, 7) + term.ogid.substring(11, 14) +'</a></td>' +
                   '<td data-label="아이디" style="width:70px; font-size:18px; font-weight:bold;">' + term.user_id + '</td>' +
                   '<td data-label="주문시간" style="width:70px; font-size:15px;">' + term.ogtime + '</td>' +
                   '<td data-label="총 가격" style="width:70px; font-size:18px; font-weight:bold;">' + term.ogtotalprice + '</td>' +
                   '<td data-label="결제 방식" style="width:70px; font-size:15px;">' + term.oghowpay + '</td>' +
              '</tr>'
               );
            
         }
         
         var termPageNo = data.pageNo;
         var termRowsPerPage = data.rowsPerPage;
         var termPagesPerGroup = data.pagesPerGroup;
         var termTotalBoardNo = data.totalBoardNo;
         var termTotalPageNo = data.totalPageNo;
         var termTotalGroupNo = data.totalGroupNo;
         var termGroupNo = data.groupNo;
         var termStartPageNo = data.startPageNo;
         var termEndPageNo = data.endPageNo;
         
         $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(1)">처음</a>');
         
         if(termGroupNo>1) {
            $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(' + (termStartPageNo-1) + ')">이전</a>');
         }
         
         for(var i=termStartPageNo; i<=termEndPageNo; i++) {
            if(termPageNo == i) {
               $("#termListModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:termList(' + i + ')">' + i + '</a>');
            } else {
               $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(' + i + ')">' + i + '</a>');
            }
         }
         
         if(termGroupNo<termTotalGroupNo) {
            $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(' + (termEndPageNo+1) + ')">다음</a>');
         }
         
         
         $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(' + termTotalPageNo + ')">맨끝</a>');
         
         $("#orderModal").css("opacity","0.5");
         $("#termListModal").modal({
			backdrop:"static",
			show:true
		});
         $("#termListModal").on('hidden.bs.modal',function(){
     		$("#orderModal").css("opacity","1");
     	});
         
      }
   });

}

function btnNewOrder(){
	orderMenuList("전체");
	$("#orderModal").css("opacity","0.5");
	$("#orderForm1Modal").modal({
		backdrop:"static",
		show:true
	});
	
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
}

function orderMenuList(mgroup) {
	$("#menuTbody").empty();
	$.ajax({
		url: "order/menuList",
		data: {"mgroup": mgroup},
		success: function(data) {
			location.reload();
			for(var i=0; i<data.length; i++) {
				var menu = data[i];
				$("#menuTbody").append(
	         		'<tr>' + 
	         		  '<td style="width:140px; font-size:25px;" data-label="메뉴번호">' + menu.mid + '</td>' + 
	             	  '<td style="width:135px" data-label="메뉴사진"><img src="menu/showPhoto?msavedfile=' + menu.msavedfile + '" width="50px" height="50px"/></td>' + 
	             	  '<td style="width:135px; font-size:25px;" data-label="핫_아이스">' + menu.hot_ice + '</td>' + 
	             	  '<td style="width:135px" data-label="메뉴이름"><a type="button" class="btn btn-primary" href="javascript:newOrderSideForm(\'' + menu.mid + '\')">' + menu.mname + '</a></td>' +
	             	'</tr>'
             	);
			}
		}
	});
}

function newOrderSideForm(mid){
	$.ajax({
		url: "order/sideList",
		data: {"mid": mid},
		type: "get",
		success: function(data) {
			location.reload();
			console.log("메뉴 그룹: "+data.mgroup);
			if(data != null){
				console.log("메뉴 존재");
			}else{
				console.log("메뉴 에러");
			}
			
			if(data.mgroup=="디저트"||data.mgroup=="기타"){
				$("#orderForm2Modal #orderSyrupN").css("visibility","hidden");
				$("#orderForm2Modal #orderSyrup").css("visibility","hidden");
				$("#orderForm2Modal #orderSyrup").val("없음").prop("selected", true);
				
				$("#orderForm2Modal #orderShotN").css("visibility","hidden");
				$("#orderForm2Modal #orderShot").css("visibility","hidden");
				$("#orderForm2Modal #orderShot").val("없음").prop("selected", true);
				
			}else{
				$("#orderForm2Modal #orderSyrupN").css("visibility","visible");
				$("#orderForm2Modal #orderSyrup").css("visibility","visible");
				$("#orderForm2Modal #orderShotN").css("visibility","visible");
				$("#orderForm2Modal #orderShot").css("visibility","visible");
				
			}
		}
	});

	
	$("#orderForm1Modal").css("opacity","0.5");
	$("#orderForm2Modal").modal({
		backdrop:"static",
		show:true
	});
	
	$("#orderForm2Modal").on('hidden.bs.modal',function(){
		$("#orderForm1Modal").css("opacity","1");
	});
}

function newOrderSave(){
	var ordercount = $("#orderQuantity").val();
	var orderSize = $("#orderSize").val();
	var orderSyrup = $("#orderSyrup").val();
	var orderShot = $("#orderShot").val();
	if(orderSyrup==null&&orderShot==null){
		orderSyrup = "";
		orderShot = "";
	}
	$.ajax({
		url: "order/sideList",
		data: {"ordercount": ordercount,"orderSize":orderSize,"orderSyrup":orderSyrup,"orderShot":orderShot},
		type: "post",
		success: function(data) {
			location.reload();
			if(data != null){
				console.log("주문 저장 성공");
			}else{
				console.log("주문 저장 실패");
			}
			
		}
	});
	$("#orderForm2Modal").modal('hide');
	$("#orderForm1Modal").modal({
		backdrop:"static",
		show:true
	});
	
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
}

function resultOrder(){
	
	$.ajax({
		url: "order/orderpay",
		success: function(data) {
			location.reload();
			showPageList(1);
			if(data != null){
				console.log("총 주문 완료");
			}else{
				console.log("총 주문 실패");
			}
			
		}
	});
	
	$("#orderForm1Modal").modal('hide');
	
	$("#orderModal").modal({
		backdrop:"static",
		show:true
	});
	
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
}

function cancelOrder(){
	
	$.ajax({
		url: "order/ordercancel",
		success: function(data) {
			location.reload();
			if(data == null){
				console.log("주문 취소 완료");
			}else{
				console.log("주문 취소 실패");
			}
			
		}
	});
	
	$("#orderForm1Modal").modal('hide');
	
	$("#orderModal").modal({
		backdrop:"static",
		show:true
	});
	
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
}

function deleteOrder(ogid){
	
	$.ajax({
		url: "order/orderdelete",
		data: {"ogid": ogid},
		success: function(data) {
			location.reload();
			if(data == null){
				console.log("주문 삭제 완료");
			}else{
				console.log("주문 삭제 실패");
			}
			
		}
	});
	
	$("#detailListModal").modal('hide');
	
	
}

var activeEl = 0;
$(function() {
    var items = $(".btn-nav");
    $( items[activeEl] ).addClass('active');
    $( ".btn-nav" ).click(function() {
        $( items[activeEl] ).removeClass('active');
        $( this ).addClass('active');
        activeEl = $( ".btn-nav" ).index( this );
    });
});





