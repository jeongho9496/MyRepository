$(function() {
	$("#btnLogin").on("click", function() {
		$("#loginModal").modal("show");
	});
	
	$("#btnLogout").on("click",function(){
		$.ajax({
			url:"store/logout",
			success: function(data){
				if(data.result = "success") {
					$("#btnLogin").show();
					$("#btnLogout").hide();
				}
			}
		});
	});
	
	
	$("#btnStore").on("click", function () { 
		$("#storeModal").modal("show");
	});
	
	$("#btnMenu").on("click", function() {
		$("#menuModal").modal("show");
		showPageMenuList(1, "전체");
	});
	
	$("#btnEvent").on("click", function() {
		$("#eventModal").modal("show");
		eventList();
	});
	
	$("#btnOrder").on("click", function() {
		showPageList(1);
	}); 
});




