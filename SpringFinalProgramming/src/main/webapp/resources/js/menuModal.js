$(function() {	
	
	$("#btnMenuRegForm").on("click", function() {
		$("#menuModal").css("opacity", "0.5");
		$("#menuRegModal").modal({
			backdrop:"static",
			show:true			
		});
	});
	 
	$("#menuRegModal").on("hidden.bs.modal", function () {
		$("#menuModal").css("opacity", "1");
	})
	
	
	$("#btnMenuReg").on("click", function(){
		console.info("메뉴입력후등록클릭");
		
		var mgroup = $("#menuRegModal #mgroup").val();
		var mname = $("#menuRegModal #mname").val();
		var hot_ice = $("#menuRegModal input:radio[name=hot_ice]:checked").val();
		var mprice = $("#menuRegModal #mprice").val();
		var mcontents = $("#menuRegModal #mcontents").val();
		var photo = $("#menuRegModal #photo")[0];
		
		console.log(mgroup);
		console.log(mname);
		console.log(hot_ice);
		console.log(mprice);
		console.log(mcontents);
		console.log(photo.files[0]);
		
		var data = new FormData();
		data.append("mgroup", mgroup);
		data.append("mname", mname);
		data.append("hot_ice", hot_ice);
		data.append("mprice", mprice);
		data.append("mcontents", mcontents);
		
		console.log(mgroup);
		console.log(mname);
		console.log(hot_ice);
		console.log(mprice);
		console.log(mcontents);
		
		if(photo.files.length != 0) {
			data.append("photo", photo.files[0]);
		}
		
		console.log(photo.files[0]);
		
		$.ajax({
			url: "menu/register",
			method: "post",
			data: data,
			cache: false,
			processData:false,
			contentType: false,
			success: function(data){
				if(data.result == "success"){
					console.log("메뉴등록 성공");
					$("#menuRegModal").modal("hide");
					showPageMenuList(1, mgroup);
				} else {
					console.log("메뉴등록 실패");
				}
			}
		})
	});
	
	
	/*$("#menuImg").on("click", function(){
		$("#menuModal").css("opacity", "0.5");
		$("#menuInfoModal").modal({
			backdrop:"static",
			show:true
		});
	});*/
	
	$("#menuInfoModal").on("hidden.bs.modal", function(){
		$("#menuModal").css("opacity", "1");
	});
	
});
 
 
function showPageMenuList(pageNo, mgroup) {
	$("#menuListTd").empty();
	$.ajax({
		url: "menu/menuList",
		data: {"pageNo": pageNo, "keyword": mgroup},
		success: function(data){
			console.log("menuListJS success 처리중 중간");
			
			$("#menuListTd").empty();
			$("#menuModal .modal-footer").empty();
			for(var i=0; i<data.list.length; i++){
				var menu = data.list[i];
				console.log("메뉴리스트"+menu);
				$("#menuListTd").append(
					//<div style="width:150px;height:150px;display:inline-block; margin:10px;"' + menu.mgroup + '>' +
	        		'<div style="width:150px; height:150px; display:inline-block; margin:10px;">' +
	        			'<div>' +
	        				'<a href="javascript:showMenuInfo('+ menu.mid + ')"><img id="menuImg" width="150px" height="150px" src="menu/showPhoto?msavedfile=' + menu.msavedfile + '" ></a>' + 
	        			'</div>' +
	        			'<div align="center">' +
		        			menu.mname + ' ' + menu.hot_ice + '</a>' +
		        			'<br/>' +
		        			menu.mprice + 'won' +
	        			'</div>' +
	        		'</div>'
				);
			}
						
			var mgroup = data.mgroup;
			var pageNo = data.pageNo;
			var rowsPerPage = data.rowsPerPage;
			var pagesPerGroup = data.pagesPerGroup;
			var totalBoardNo = data.totalBoardNo;
			var totalPageNo = data.totalPageNo;
			var totalGroupNo = data.totalGroupNo;
			var groupNo = data.groupNo;
			var startPageNo = data.startPageNo;
			var endPageNo = data.endPageNo;
			var keyword = data.keyword;
	        
	        $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(1, \'' + keyword + '\')">처음</a>');
        	 
	         if(groupNo>1) {
	            $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + (startPageNo-1) + ', \'' + keyword + '\')">이전</a>');
	         }

	         for(var i=startPageNo; i<=endPageNo; i++) {
	            if(pageNo == i) {
	               $("#menuModal .modal-footer").append('<a type="button" class="btn btn-danger" href="javascript:showPageMenuList(' + i + ', \'' + keyword + '\')">' + i + '</a>');
	            } else {
	               $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + i + ', \'' + keyword + '\')">' + i + '</a>');
	            }
	         }

	         if(groupNo<totalGroupNo) {
	            $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + (endPageNo+1) + ', \'' + keyword + '\')">다음</a>');
	         }

	         $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + totalPageNo + ', \'' + keyword + '\')">맨끝</a>');
	         
		},
		error:function(request,status,error){
	           alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	});
}


function showMenuInfo(mid){
	console.log("showMenuInfo " + mid);
	$("#menuModal").css("opacity","0.5");
	$("#menuInfoModal").modal({
		backdrop:"static",
		show:true
	});
	$.ajax({
		url:"menu/info",
		data: {"mid":mid},
		success: function(data){
			$("#menuInfoModal .panel-body").empty();
			$("#menuInfoModal .modal-footer").empty();
			$("#menuInfoModal .panel-body").append(
					'<div class="thumbnail" style="width:300px; height:300px">' +
						'<img style="width:300; height:300px" src="menu/showPhoto?msavedfile=' + data.msavedfile + '"/>' +
					'</div>' +
					'<div class="icerik-bilgi">' +
   						'<h2>' + data.mname + data.hot_ice + '</h2>' +
   						'<p></p>' +
   						'<div style="width: 500px;">' +
   							'가격:' + data.mprice +
   						'</div>' +
   						'<div>'+
   							data.mcontents +
   						'</div>' +
   					'</div>'	
			);
			
			$("#menuInfoModal .modal-footer").append(
					'<div>' +
						'<button type="button" onclick="showMenuModForm('+ data.mid + ')" class="btn btn-primary">' +
							'수정' +
						'</button>' +
						'<button type="button" onclick="menuRemove(' + data.mid + ')" class="btn btn-danger">' +
							'삭제' +
						'</button>' +
					'</div>'
			);
			
			$("#menuModal").css("opacity", "0.5");
			$("#menuInfoModal").modal({
				backdrop: "static",
				show: true
			});
		}
	});

	
/*
	$("#btnModModal").on("click", function() {
		$("#menuModal").css("opacity", "0.5");
		$("#menuModModal").modal({
			backdrop:"static",
			show:true
		});
	});*/

}


function showMenuModForm(mid){
	console.log(mid);
	$("#menuModal").css("opacity", "0.5");
	$("#menuInfoModal").modal("hide");
	$("#menuModModal").modal({
		backdrop: "static",
		show: true
	});
	
	console.log("menuModify ajax 전" + mid);
	
	$.ajax({
		url: "menu/modify",
		data: {"mid": mid},
		success: function(data){
			console.log("-----------menu 수정 정보-----------");
			console.log(data.mid);
			console.log(data.mgroup);
			console.log(data.mname);
			console.log(data.hot_ice);
			console.log(data.mprice);
			console.log(data.mcontents);
			console.log(data.msavedfile);
			console.log("-----------menu 수정 정보-----------");
			
			$("#menuModModal .panel-body").empty();
			$("#menuModModal .modal-footer").empty();
			
			$("#menuModModal #mid").val(data.mid);
			$("#menuModModal #mgroup").val(data.mgroup);
			$("#menuModModal #mname").val(data.mname);
			$("#menuModModal #hot_ice").val(data.hot_ice);
			$("#menuModModal #mprice").val(data.mprice);
			$("#menuModModal #mcontents").text(data.mcontents);
			$("#menuModModal #msavedfile").attr("src", "menu/showPhoto?msavedfile=" + data.msavedfile);
			
			$("#menuModModal .modal-footer").append('<button id="btnMenuMod" onclick="btnMenuMod('+data.mid+')" type="submit" class="btn btn-warning">수정완료</button>');
			$("#menuModModal .modal-footer").append('<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>');
		}
	});
	
/*	$("#menuModModal").on('hidden.bs.modal',function(){
		$("#menuModal").css("opacity","1");
		showPageMenuList(1, "전체");
	});*/
	
}

function btnMenuMod(mid){
	var mid = $("#menuModModal #mid").val();
	var mgroup = $("#menuModModal #mgroup").val();
	var mname = $("#menuModModal #mname").val();
	var hot_ice = $("#menuModModal input:radio[name=hot_ice]:checked").val();
	var mprice =$("#menuModModal #mprice").val();
	var mcontents =$("#menuModModal #mcontents").val();
	var photo = $("#menuModModal #photo")[0];
	console.log(photo.files[0]);
	
	 
	var data = new FormData();
	data.append("mid", mid);
	data.append("mgroup", mgroup);
	data.append("mname", mname);
	data.append("hot_ice", hot_ice);
	data.append("mprice", mprice);
	data.append("mcontents", mcontents);
	
	
	console.log("data ajax test값 append성공");
	
	if(photo.files.length != 0) {
		data.append("photo", photo.files[0]);
		console.log("data ajax photo append성공");
	}			
	
	
	console.log("-----------menu DB 수정 정보-----------");
	console.log(mid);
	console.log(mgroup);
	console.log(mname);
	console.log(hot_ice);
	console.log(mprice);
	console.log(mcontents);
	console.log(msavedfile);
	console.log("-----------menu DB 수정 정보-----------");
	
	$.ajax({
		url:"menu/modify",
		method: "post",
		data: data,
		cache: false,
		processData: false,
		contentType: false,
		success: function(data) {
			if(data.result == "success") {
				$("#menuModModal").modal("hide");
				$("#menuModal").css("opacity","1");
				showPageMenuList(1, "전체");
			}
		}
	});
	
}

function menuRemove(mid){
	console.log("menuRemove 시작");
	$.ajax({
		url: "menu/remove",
		data: {"mid": mid},
		success:function(){
			
		}
	});
	showPageMenuList(1, "전체");
	$("#menuInfoModal").modal("hide");
	$("#menuModal").css("opacity","1");
	console.log("menuRemove 끝");
}