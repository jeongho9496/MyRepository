$(function() {
	$("#btnRegEvent").on("click",function() {
		$("#eventModal").css("opacity","0.5");
		$("#eventRegModal").modal({
			backdrop:"static",
			show:true
		});
	});
	
	
	$("#eventRegModal").on('hidden.bs.modal',function(){
		$("#eventModal").css("opacity","1");
	});
	
	
	$("#regEvent").on("click",function() {
		var etitle = $("#eventRegModal #etitle").val();
		var estartperiod = $("#eventRegModal #estartperiod").val();
		var elastperiod = $("#eventRegModal #elastperiod").val();
		var econtents =$("#eventRegModal #econtents").val();
		var photo = $("#eventRegModal #photo")[0];
		 
		var data = new FormData();
		data.append("etitle", etitle);
		data.append("estartperiod", estartperiod);
		data.append("elastperiod", elastperiod);
		data.append("econtents", econtents);
		
		console.log("eventReg 성공 " + etitle);
		console.log("eventReg 성공 " + estartperiod);
		console.log("eventReg 성공 " + elastperiod);
		console.log("eventReg 성공 " + econtents);
		console.log("eventReg 성공 " + photo);
		
		
		
		if(photo.files.length != 0) {
			data.append("photo", photo.files[0]);
		}			
		
		$.ajax({
			url:"event/register",
			method: "post",
			data: data,
			cache: false,
			processData: false,
			contentType: false,
			success: function(data) {
				if(data.result == "success") {
					$("#eventRegModal").modal("hide");
					eventList();
				}
			}
		});
		
	});
	
	
	
	$("#eventModiModal #modiEvent").on("click",function() {
		var eid = $("#eventModiModal #eid").val();
		var etitle = $("#eventModiModal #etitle").val();
		var estartperiod = $("#eventModiModal #estartperiod").val();
		var elastperiod = $("#eventModiModal #elastperiod").val();
		var econtents =$("#eventModiModal #econtents").val();
		var photo = $("#eventModiModal #photo")[0];
		
		 
		var data = new FormData();
		data.append("eid", eid);
		data.append("etitle", etitle);
		data.append("estartperiod", estartperiod);
		data.append("elastperiod", elastperiod);
		data.append("econtents", econtents);
		
		console.log("------------------------------------------");
		console.log(photo.files[0]);
		console.log("eventModi(etitle) 성공 " + etitle);
		console.log("eventModi(estartperiod) 성공 " + estartperiod);
		console.log("eventModi(elastperiod) 성공 " + elastperiod);
		console.log("eventModi(econtents) 성공 " + econtents);
		if(photo.files.length != 0) {
			data.append("photo", photo.files[0]);
			console.log("eventModi(phtoto) 성공 " + photo);
		}			
		console.log("------------------------------------------");
		
		
		$.ajax({
			url:"event/modify",
			method: "post",
			data: data,
			cache: false,
			processData: false,
			contentType: false,
			success: function(data) {
				if(data.result == "success") {
					$("#eventModiModal").modal("hide");
					eventList();
				}
			}
		});
		
	});
});

function eventList(){
	console.log("eventList 시작");
	$.ajax({
		url:"event/eventList",
		data:{},
		success:function(data){
			console.log("eventList 중간");
			$("#eventTbody").empty();
			for(var i=0; i<data.eventList.length; i++) {
				var event = data.eventList[i];
				$("#eventTbody").append(
			         '<tr>'+
		             '<td>'+ event.eid +'</td>' +
		             '<td><a href="javascript:eventInfo('+ event.eid + ')">'+ event.etitle +'</td>'+
		             '<td>'+ event.estartperiod + ' ~ ' + event.elastperiod + '</td>'+
		             /*'<td>'+ event.econtents + '~' + '</td>'+*/
		             '<td class="text-center"><a class="btn btn-info btn-xs" href="javascript:eventModify(' + event.eid +')" id="btnModiEvent"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="javascript:eventRemove(' + event.eid +')" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>'+
			         '</tr>'
            	);
			}
		},
		error:function(request,status,error){
	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	       }
	});
}

function eventInfo(eid){
	console.log(eid);
	$.ajax({
		url:"event/info",
		data: {"eid":eid},
		success: function(data){
			console.log("ajax 성공 " + data.eid);
			console.log("ajax 성공 " + data.etitle);
			console.log("ajax 성공 " + data.econtents);
			console.log("ajax 성공 " + data.estartperiod);
			console.log("ajax 성공 " + data.elastperiod);
			console.log("ajax 성공 " + data.esavedfile);
			$("#eventInfo").empty();
			$("#eventInfo").append(
			  '<div class="row">' +
			    '<div class="col-xs-12 col-sm-3 col-md-3">' +
			      '<img class="img-responsive img-box img-thumbnail" src="event/showPhoto?esavedfile=' + data.esavedfile + '">' +
			    '</div>' + 
			     '<div class="col-xs-12 col-sm-9 col-md-9">' +
			       '<div class="list-group">'+
			        	'<div class="row-content">' +
			        		'<small>'+
			        		'<br>'+
			        		' <i class="glyphicon glyphicon-calendar"></i>'+ '<span>' +data.estartperiod + '~' + data.elastperiod + '</span>' +
			        		'</small>' +
			           		'<h4 id="etitle">' + data.etitle +'</h4>' +
			           		'<p>' + data.econtents+ '</p>' +
			           '</div>'+
			          '</div>'+
			         '</div>'+
			        '</div>' +
			    '</div>'
				);
			$("#eventModal").css("opacity","0.5");
			$("#eventInfoModal").modal({
				backdrop:"static",
				show:true
			});
		}
	});
	
	$("#eventInfoModal").on('hidden.bs.modal',function(){
		$("#eventModal").css("opacity","1");
	});
	
}

function eventModify(eid){
	$("#eventModal").css("opacity","0.5");
	$("#eventModiModal").modal({
		backdrop:"static",
		show:true
	});
	console.log("eventModify(): "+eid);
	$.ajax({
		url:"event/modify",
		method:"get",
		data:{"eid":eid},
		success: function(data){
			console.log("----------------------------------");
			console.log("ajax modify성공 " + data.eid);
			console.log("ajax modify성공 " + data.etitle);
			console.log("ajax modify성공 " + data.econtents);
			console.log("ajax modify성공 " + data.estartperiod);
			console.log("ajax modify성공 " + data.elastperiod);
			console.log("ajax modify성공 " + data.esavedfile);
			console.log("----------------------------------");
			$("#eventModiModal #eid").val(data.eid);
			$("#eventModiModal #etitle").val(data.etitle);
			$("#eventModiModal #estartperiod").val(data.estartperiod);
			$("#eventModiModal #elastperiod").val(data.elastperiod);
			$("#eventModiModal #econtents").text(data.econtents);
			$("#eventModiModal #esavedfile").attr("src", "event/showPhoto?esavedfile=" + data.esavedfile);
			
		},
		error:function(request,status,error){
	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
		
	});
	
	
	$("#eventModiModal").on('hidden.bs.modal',function(){
		$("#eventModal").css("opacity","1");
	});
}

function eventRemove(eid){
	$.ajax({
		url:"event/remove",
		data:{"eid":eid},
		success:function(){
			eventList();
		}
	});
}
