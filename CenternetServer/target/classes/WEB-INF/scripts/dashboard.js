function switchSettingDiv(divtag){
	if(divtag == "simpleConfigureTitleDiv"){
		// change focus div title
		$("#simpleConfigureTitleDiv").css("background","white").css("border-color","white");
		$("#detailEditTitleDiv").css("background","#9c0").css("border-color","#9c0");
		$("#customUploadTitleDiv").css("background","#9c0").css("border-color","#9c0");
		$("#editHelpTitleDiv").css("background","#9c0").css("border-color","#9c0");
		
		// change focus content to visible
		$("#simpleConfigureContentDiv").css("display","block");
		$("#detailEditContentDiv").css("display","none");
		$("#customUploadContentDiv").css("display","none");
		$("#editHelpContentDiv").css("display","none");
	}else if(divtag == "detailEditTitleDiv"){
		$("#simpleConfigureTitleDiv").css("background","#9c0").css("border-color","#9c0");
		$("#detailEditTitleDiv").css("background","white").css("border-color","white");
		$("#customUploadTitleDiv").css("background","#9c0").css("border-color","#9c0");
		$("#editHelpTitleDiv").css("background","#9c0").css("border-color","#9c0");
		
		
		$("#simpleConfigureContentDiv").css("display","none");
		$("#detailEditContentDiv").css("display","block");
		$("#customUploadContentDiv").css("display","none");
		$("#editHelpContentDiv").css("display","none");
	}else if(divtag == "customUploadTitleDiv"){
		
		$("#simpleConfigureTitleDiv").css("background","#9c0").css("border-color","#9c0");
		$("#detailEditTitleDiv").css("background","#9c0").css("border-color","#9c0");
		$("#customUploadTitleDiv").css("background","white").css("border-color","white");
		$("#editHelpTitleDiv").css("background","#9c0").css("border-color","#9c0");
		
		$("#simpleConfigureContentDiv").css("display","none");
		$("#detailEditContentDiv").css("display","none");
		$("#customUploadContentDiv").css("display","block");
		$("#editHelpContentDiv").css("display","none");
		
	}else if(divtag == "editHelpTitleDiv"){
		
		$("#simpleConfigureTitleDiv").css("background","#9c0").css("border-color","#9c0");
		$("#detailEditTitleDiv").css("background","#9c0").css("border-color","#9c0");
		$("#customUploadTitleDiv").css("background","#9c0").css("border-color","#9c0");
		$("#editHelpTitleDiv").css("background","white").css("border-color","white");
		
		$("#simpleConfigureContentDiv").css("display","none");
		$("#detailEditContentDiv").css("display","none");
		$("#customUploadContentDiv").css("display","none");
		$("#editHelpContentDiv").css("display","block");
		
	}
}



function customUploadInputValidation(){
	
}


/*  input validate for edit a simple portal packet */
function inputValidation() {
	var portalPacketTitle = document.getElementById("portalPacketTitle");
	var portalPacketContent = document.getElementById("portalPacketContent");
	var portalPacketFooter = document.getElementById("portalPacketFooter");
	var error = "";
	if (portalPacketTitle.value.length == 0) {
		error += "标题不能为空\n";
	}
	if (portalPacketContent.value.length == 0) {
		error += "描述文字不能为空\n";
	}
	if (portalPacketFooter.value.length == 0) {
		error += "页脚不能为空\n";
	}
	if (error.length != 0) {
		window.alert(error);
		return false;
	} else
		return true;
}

function PreviewImage() {
	oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("videoOrImageFileName").files[0]);
	oFReader.onload = function(oFREvent) {
		document.getElementById("previewImage").src = oFREvent.target.result;
	};
}

function PreviewVideo() {
	oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("videoOrImageFileName").files[0]);
	oFReader.onload = function(oFREvent) {
		document.getElementById("previewVideo").src = oFREvent.target.result;
	};
}

$(document).ready(function() {
	$("#previewbtn").mousedown(function() {
		// 设置预览的标题
		var title = $("#portalPacketTitle").val();
		if (title.length != 0) {
			$("#PreVeiwHeader").html(title);
		}
		// 设置预览的标题的字体和字体颜色
		var font_color = "#" + $("#font_color").val();
		var font_family = $("#portalPacketTitleFontStyle").val();
		$("#PreVeiwHeader").css("background", font_color);
		$("#PreVeiwHeader").css("font-family", font_family);
		// 设置预览的图片
		var imageOrVideo = $("#videoOrImageType").val();
		var imageOrVideoSrc = $("#videoOrImageFileName").val();
		if (imageOrVideo == 'video') {
			if (imageOrVideoSrc.length != 0) {
				PreviewVideo();
			}

		} else {
			if (imageOrVideoSrc.length != 0) {
				PreviewImage();
			}
		}
		// 设置预览的描述性文字
		var description = $("#portalPacketContent").val();
		$("#description").html(description);
		// 设置预览的footer
		var description = $("#portalPacketFooter").val();
		$("#footerdescription").html(description);
	})
});