$(function() {
	
		$("#btnJoin").on("click", function() {       //btnJoin 버튼을 누르면
			$("#loginModal").css("opacity","0.5");   //뒤에 있는 loginModal은 불투명해지고,
			$("#joinModal").modal({                  //새로 띄운 joinModal은 크기가 고정되며 보여진다.
				backdrop:"static",
				show:true
			});		
		});
		
	    $("#joinModal").on('hidden.bs.modal',function(){   //joinModal을 닫으면,
	    	$("#loginModal").css("opacity","1");           //loginModal의 불투명도는 1이 된 후에
	    	$("#loginModal").modal("show");                //바로 사라진다.
	    });
	    
	    $("#selectSemail").on("change", function() {
			$("#semail2").val($("#selectSemail").val());
		});
		
		$("#selectSname").on("change", function() {
			$("#sname").val($("#selectSname").val());
		});	
		
		$("#btnSubmit").on("click", function() {
    		
			console.info("상점 정보 입력 후 Join 버튼 클릭");
			
			var sid = $("#joinModal #sid").val();
			var semail1 = $("#joinModal #semail1").val();
			var semail2 = $("#joinModal #semail2").val();
			var semail = semail1 + "@" + semail2;
			var spw = $("#joinModal #spw").val();
			var sname = $("#joinModal #sname").val();
			var slocal = $("#joinModal #slocal").val();
			var saddr = $("#joinModal #saddr").val();
		    var stel = $("#joinModal #stel").val();
		    var sopen = $("#joinModal #sopen").val();
		    var sclosed = $("#joinModal #sclosed").val();
		    var sbeacon = $("#joinModal #sbeacon").val();
	        var sphoto = $("#joinModal #sphoto")[0];
		    
	        console.log("------------------회원가입 정보-----------------");
		    console.log("store : " + sid);
			console.log("store : " + semail1);
			console.log("store : " + semail2);
			console.log("store : " + semail);
			console.log("store : " + spw);
			console.log("store : " + sname);
			console.log("store : " + slocal);
			console.log("store : " + saddr);
			console.log("store : " + stel);
			console.log("store : " + sopen);
			console.log("store : " + sclosed);
			console.log("store : " + sbeacon);
			console.log("store : " + sphoto);
			console.log("------------------회원가입 정보-----------------");
			
			var data = new FormData();
			data.append("sid", sid);
			data.append("semail1", semail1);
			data.append("semail2", semail2);
			data.append("semail",semail);
			data.append("spw",spw);
			data.append("sname", sname);
			data.append("slocal", slocal);
			data.append("saddr", saddr);
			data.append("stel", stel);
			data.append("sopen", sopen);
			data.append("sclosed", sclosed);
			data.append("sbeacon", sbeacon);
			for(var i=0;i<sphoto.files.length;i++){
				data.append("sphoto", sphoto.files[i]);
			}
			
			$.ajax({
				url: "store/join",
				method: "post",
				data: data,
				cache:false,
				processData:false,
				contentType:false,
				success: function(data) {
					if(data.result == "success") {
						 console.log("매장등록 성공");
						 $("#joinModal").modal("hide");
						 $("#loginModal").css("opacity","1");
						 /*storeList();*/
					} else {
						console.log("매장등록 실패");
					}
				}
			});
		});
		
});




/*
function storeList() {
	console.log("storeList 시작");
	$.ajax({
		url:"store/info",
		data:{},
		success:function(data){
			console.log("storeList 중간");
			$("#storeTbody").empty();
			for(var i=0; i<data.storeList.length; i++) {
				var store = data.storeList[i];
				$("storeTbody").append(
					'<tr>'+
		            '<td>' + store.sid + '</td>' +
		            '<td>' + store.semail + '</td>' +
		            '<td>' + store.semail2 + '</td>' +
		            '<td>' + store.sname + '</td>' +
		            '<td>' + store.slocal + '</td>' +
		            '<td>' + store.saddr + '</td>' +
		            '<td>' + store.stel + '</td>' +
		            '<td>' + store.sopen + '</td>' +
		            '<td>' + store.sclosed + '</td>' +
		            '<td>' + store.sbeacon + '</td>' +
		            '<td>' + store.sphoto + '</td>' +
		            <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
			      	'</tr>'		
				);
			}
		},
		
		error:function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" +error);
			}
		});
}
*/

/*function storeInfo(sid) {
	console.log(sid);
	$.ajax({
		url:"store/info",
		data: {"sid":sid},
		cache: false,
		processData:false,
		success: function(data){
			console.log("ajax 성공 " + data.sid);
			console.log("ajax 성공 " + data.semail);
			console.log("ajax 성공 " + data.semail2);
			console.log("ajax 성공 " + data.sname);
			console.log("ajax 성공 " + data.slocal);
			console.log("ajax 성공 " + data.saddr);
			console.log("ajax 성공 " + data.stel);
			console.log("ajax 성공 " + data.sopen);
			console.log("ajax 성공 " + data.sclosed);
			console.log("ajax 성공 " + data.sbeacon);
			console.log("ajax 성공 " + data.sphoto);
			$("#storeInfo").empty();
			$("#storeInfo").append(
			  '<div class="media">' +
			    '<img class="media-object" width=150px src="sphoto/showPhoto?spic_savedfile=' + data.spic_savedfile + '">' +
			  		 '<div class="media-body">' +
			  		 	'<p>' + data.sid +'</p>' +
			            '<p>' + data.semail+ data.semail2 + '</p>' +
			  			'<p>' + data.sname + '<p>' + 
			  			'<p>' + data.slocal + '<p>' + 
			  			'<p>' + data.saddr + '<p>' + 
			  			'<p>' + data.stel + '<p>' + 
			  			'<p>' + data.sopen + '<p>' + 
			  			'<p>' + data.sclosed + '<p>' + 
			  			'<p>' + data.sphoto + '<p>' + 	
			        '</div>' +
			    '</div>'
				);
			$("#joinModal").css("opacity","0.5");
			$("#storeModal").modal({
				backdrop:"static",
				show:true
			});
		}
	});
	
	$("#storeModal").on('hidden.bs.modal',function(){
		$("#joinModal").css("opacity","1");
	});
}
*/




/*
$(function() {
	$("#btnJoin").on("click", function() {
		$("#joinModal").modal("show");
	});
	
	$("#selectSemail").on("change", function() {
		$("#inputSemail2").val($("#selectSemail").val());
	});
	
	$("#selectSname").on("change", function() {
		$("#inputSname").val($("#selectSname").val());
	});
});
*/
