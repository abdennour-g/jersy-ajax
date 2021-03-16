$(document).ready(function(){
	
	
	var url_jax='http://localhost:1000/users';
charge=()=>{	
	$.ajax({type:'GET',dataType:'json',url:url_jax,success:function(data0){
		var data=data0['user'];
		var x='<tbody>';
		for(var i=0;i<data.length;i++)
			x+='<tr><td>'+data[i]['id']+'</td><td>'+data[i]['username']+'</td><td>'+data[i]['email']+'</td><td>'+data[i]['password']+'</td></tr>';	
		x+='</tbody>';
			$('tbody').remove();
			$('.table').append(x);
	}});
select('update');
select('delete');
$('input').val('');
}
 
select=(tag)=>{	
	$.ajax({type:'GET',dataType:'json',url:url_jax,success:function(data0){
		var data=data0['user'];
		var x='<select name="'+(tag=='udpate'?'udpate':'id')+'" class="sel_'+tag+' col-xs-12 form-control" aria-label="Default select example" ><option value=""></option>';
		for(var i=0;i<data.length;i++)
			x+='<option value="'+data[i]['id']+'" data-id="'+data[i]['id']+'" data-username="'+data[i]['username']+'" data-email="'+data[i]['email']+'" data-password="'+data[i]['password']+'">'+data[i]['username']+'</option>';	
		x+='</select>';
			$('select.sel_'+tag).remove();
			$('.div_sel_'+tag).append(x);
			var obj=['id','username','email','password'];
	$('.sel_update').change(function(){
		for(o in obj)$('.div_update .'+obj[o]).val($(this).find(':selected').data(obj[o]));
	});
	$('.sel_delete').change(function(){
		$('.div_delete .id').val($(this).find(':selected').val());
	});
	}});
}
commit=(id,reqType,parent)=>{
	/*alert(
								'id= '+$(parent+' .id').val()+'\n'+
								'username= '+$(parent+' .username').val()+'\n'+
								'email= '+$(parent+' .email').val()+'\n'+
								'password= '+$(parent+' .password').val()	)*/
	var new_user=reqType=='DELETE'?{}:
								{
								'id':'',
								'username':$(parent+' .username').val(),
								'email':$(parent+' .email').val(),
								'password':$(parent+' .password').val(),		
								};
	$.ajax({url:url_jax+'/'+id,
		    type: reqType, 
		    contentType : 'application/json;charset=utf-8',
		    dataType: 'json',
			data:JSON.stringify(new_user),
			success:function(rep){
				charge();
				console.log('ok :'+rep);
				   },
			error:function (er) {
				console.log('error'+er);
				}
			});
};
charge();

$('.save_add').click(function(){
	commit('','POST','.div_add');
});
$('.save_update').click(function(){
	commit($('.div_update .id').val(),'PUT','.div_update');
});
$('.save_delete').click(function(){
	commit($('.div_delete .id').val(),'DELETE','.div_delete');
});
});

