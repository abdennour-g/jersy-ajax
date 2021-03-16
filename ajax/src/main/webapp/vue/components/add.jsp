<%@ include file="../services/jstl.jsp" %>
<div class="div_form_add panel panel-primary col-xs-4">
    <div class="panel-heading">new user</div>
    <div class="div_add panel-body">
    	    <div class=" form-group">
                <label for="username">username</label>
                <input type="text" class="form-control username" placeholder="Enter username" />
            </div>
            <div class="form-group">
                <label for="email">email</label>
                <input type="text" class="form-control email" placeholder="Enter email" />
            </div>
            <div class="form-group">
                <label for="password">password</label>
                <input type="text" class="form-control password" placeholder="Enter password" />
            </div>
        <button class="save_add btn btn-primary">SAVE</button>
    </div>
</div>