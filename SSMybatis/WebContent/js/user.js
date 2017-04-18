$(document).ready(function(){
	
});

function delUser(id){
	if(confirm("确定要删除吗?")){
		$.post(
		"deleteUserById",
		{id:id},
		function(data){
			if(data.boolean){
				alert("删除成功！");
				location.reload();
			}else{
				alert("删除失败");
			}
		},
		"json"
		);
	}
		
}