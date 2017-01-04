function onClickLogin() {
	var sid = $("#storeId").val();
	var spw = $("#storePw").val();
	console.log(sid);
	console.log(spw);
	
	$.ajax({
		url: "store/login",
		data: {"sid":sid, "spw":spw},
		method: "post",
		success: function(data) {
			if(data.result == "LOGIN_SUCCESS") {
				$("#loginModal").modal("hide");
				$("#btnLogin").hide();
				$("#btnLogout").show();
			} else {
				$("#loginResultModal").modal("show");
				$("#loginResultModal .modal-body").html(data.result);
			}
		}
	});
};


