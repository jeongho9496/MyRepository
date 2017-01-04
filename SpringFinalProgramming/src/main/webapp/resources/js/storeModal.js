$(function() {
	
	$("#btnContents").on("click", function() {
		$("#storeModal").css("opacity","0.5");  
		$("#storeModal").modal("hide");
	});		
	
	
	$("#btnStore").on("click", function() {
		$("#storeModal").modal("show");
		$("#storeModal").css("opacity","1");  	
	});		
	
	$("#btnStoreInfo").on("click", function() {
		$("#storeModal").modal("opacity","0.5");
		$("#storeInfoModal").modal("show");  	
	});	
	
	$("#storeInfoModal").on('hidden.bs.modal',function(){
		$("#storeModal").css("opacity","1");
	});
});

	
	
	
function storeInfo(sid) {
	console.log(sid);
	$.ajax({
		url:"store/info",
		data: {"sid":sid},
		success: function(data){
			console.log("ajax 성공 " + data.sphoto);
			console.log("ajax 성공 " + data.sid);
			console.log("ajax 성공 " + data.semail);
			console.log("ajax 성공 " + data.spw);
			console.log("ajax 성공 " + data.sname);
			console.log("ajax 성공 " + data.slocal);
			console.log("ajax 성공 " + data.saddr);
			console.log("ajax 성공 " + data.stel);
			console.log("ajax 성공 " + data.sopen);
			console.log("ajax 성공 " + data.sclosed);
			console.log("ajax 성공 " + data.sbeacon);
			$("#storeInfo").empty();
			$("#storeInfo").append(
			  '<div class="media">' +
			  		 '<div class="media-body">' +
			    		'<h4 class="media-heading" id="sid">' + data.sid +'</h4>' +
			            '<p>' + data.semail+ '</p>' +
			            '<p>' + data.spw+ '</p>' +
			            '<p>' + data.sname+ '</p>' +
			            '<p>' + data.slocal+ '</p>' +
			            '<p>' + data.saddr+ '</p>' +
			            '<p>' + data.stel+ '</p>' +
			            '<p>' + data.sopen+ '</p>' +
			            '<p>' + data.sclosed+ '</p>' +
			            '<p>' + data.sbeacon+ '</p>' +
			            '<img class="media-object" width=150px src="store/showPhoto?savedfile=' + data.savedfile + '">' +
			        '</div>' +
			    '</div>'
				);
			$("#storeModal").css("opacity","0.5");
			$("#storeInfoModal").modal({
				backdrop:"static",
				show:true
			});
		}
	 });
	$("#storeInfoModal").on('hidden.bs.modal',function(){
		$("#storeModal").css("opacity","1");
	});
}