function switchSettingDiv(divtag){
	if(divtag == "allUsersDiv"){
		$("#allUsersDiv").css("background","white").css("border-color","white");
		$("#allSystemConfigsDiv").css("background","#9c0").css("border-color","#9c0");
		$("#usersDiv").css("display","block");
		$("#systemConfigsDiv").css("display","none");
	}else{
		$("#allUsersDiv").css("background","#9c0").css("border-color","#9c0");
		$("#allSystemConfigsDiv").css("background","white").css("border-color","white");
		$("#usersDiv").css("display","none");
		$("#systemConfigsDiv").css("display","block");
	}
}