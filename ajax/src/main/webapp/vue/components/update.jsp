<%@ include file="../services/jstl.jsp" %>
<div class="div_form_add panel panel-primary  col-xs-4">
   <div class="panel-heading">update user</div>
    <div class="div_sel_update panel-body">
        
    </div>
    <div class="div_update panel-body">
    	    <div class="form-group">
                <label for="username">username</label>
                <input type="hidden" class="id form-control"  />  
                 <input type="text" class="username form-control username" placeholder="Enter username" />
            </div>
            <div class="form-group">
                <label for="email">email</label>
                <input type="text" class="email form-control email" placeholder="Enter email" />
            </div>
            <div class="form-group">
                <label for="password">password</label>
                <input type="text" class="password form-control password" placeholder="Enter password" />
            </div>
              <button class="save_update btn btn-primary">SAVE</button>
    </div>
</div>
