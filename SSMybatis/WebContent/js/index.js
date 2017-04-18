$(document).ready(function(){
	$("#name").blur(function(){
		findUserByName($("#name").val());
	});
	$("#name").focus(function(){
		$("#content").text("");
	});
});

//判断用户名是否被注册
function findUserByName(name){
	if(name==""){
		alert("用户名不能为空!");
	}else{
		$.post(
		"/SSMybatis/findUserByName",
		{name:name},
		function(data){
			if(data.boolean){
				$("#content").html("<font size='14px' color='green'>该用户名可以使用!</font>");
			}else{
				$("#content").html("<font size='14px' color='red'>该用户名已被注册!</font>");
			}
		},
		"json"
		);
	}
}
