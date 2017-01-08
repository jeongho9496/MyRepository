<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:740px">
    <div class="modal-content" style="height:700px">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h1 class="modal-title" align="center"><b>Menu List</b></h1>
       
      </div>
      <div class="modal-body" align="center">
      	<div class="btn-group">
      		<button onclick="showPageMenuList(1, '전체')" type="button" class="btn btn-info btn-filter">All</button>
		</div>
		<div class="btn-group">
			<button onclick="showPageMenuList(1, '커피')" type="button" class="btn btn-info btn-filter">Coffee</button>
		</div>
		<div class="btn-group">
			<button onclick="showPageMenuList(1, '차')" type="button" class="btn btn-info btn-filter">Tea</button>
		</div>
		<div class="btn-group">
			<button onclick="showPageMenuList(1, '디저트')" type="button" class="btn btn-info btn-filter">Dessert</button>
		</div>
		<div class="btn-group">
			<button onclick="showPageMenuList(1, '기타')" type="button" class="btn btn-info btn-filter">Etc</button>
		</div>
		<div class="wrapper" align="right">
   		 	<a id="btnMenuRegForm" type="button" class="btn btn-warning" href="#">메뉴 등록</a>
		</div>
		<hr/>
     		
   		<table style="width:100%; align:center">
   			<tr>
				<td id="menuListTd">
				</td>
   			</tr>
  		</table>
      </div>
      
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div> 
