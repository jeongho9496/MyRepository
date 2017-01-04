<%@ page contentType="text/html;charset=UTF-8"%>

		 <div id="eventRegModal" class="modal fade" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document" style="width:800px">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">Event 등록</h4>
		      </div> 
			      <div class="modal-body">
				 		<div class="row">
					    <div class="col-md-8">
					     <form class="form-horizontal" method="post" name="signup" id="signup" enctype="multipart/form-data" >        
					       <div class="form-group">
					          <label class="control-label col-sm-3">제목. <span class="text-danger">*</span></label>
					          <div class="col-md-8 col-sm-9">
					            <input type="text" class="form-control" name="etitle" id="etitle" placeholder="Enter your Name here">
					          </div>
					        </div>
					        <div class="form-group">
					          <label class="control-label col-sm-3">기간. <span class="text-danger">*</span></label>
					          <div class="col-md-8 col-sm-9">
					            <input type="date" class="form-control" name="estartperiod" id="estartperiod" placeholder="Enter your Name here"> ~
					            <input type="date" class="form-control" name="elastperiod" id="elastperiod" placeholder="Enter your Name here"> 
					          </div>
					        </div>
					        <div class="form-group">
					          <label class="control-label col-sm-3">내용. <span class="text-danger">*</span></label>
					          <div  class="col-md-8 col-sm-9">
					            <textarea cols=20 rows=3 class="form-control" name="econtents" id="econtents" placeholder="Enter your Name here"></textarea>
					          </div>
					        </div>
					        <div class="form-group">
					          <label class="control-label col-sm-3">첨부파일. </label>
					          <div class="col-md-5 col-sm-8">
					            <div class="input-group"> <span class="input-group-addon" id="file_upload"><i class="glyphicon glyphicon-upload"></i></span>
					              <input type="file" name="photo" id="photo" placeholder="" aria-describedby="file_upload">
					            </div>
					          </div>
					        </div>
					      </form>
					    </div>
					</div>
				 </div>
			      <div class="modal-footer">
		       	<input type="button" id="regEvent" class="btn btn-primary" value="등록하기"/>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->