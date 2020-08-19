var laydate = layui.laydate;
var form = layui.form;
form.render()
var subType='add'
//富文本
var editer = new Editer($("#ed"),`#(articleTmp.TXT??'')`,"#(base)/documentTmp/upload")
//标签
var tag = new Tags()
//日期
laydate.render({ 
	elem: '#pubDate'
});
//监听分类切换
form.on('radio(type)', function(data){
	  if(data.value==1){
		  $("#selectFile").show()
		  return false;
	  }
	  $("#selectFile").hide()
});
//判断为添加操作还是修改操作
if($("#id").val()!=''){
	subType="update"
}
//选择文件
function selectFile(){
	$("#videoFile").val('')
	$("#videoFile").click()
}
$("#videoFile").on("change",function(){
	var file = $("#videoFile")[0].files[0]
	if(verifyType(file.name)) return false;
	$("#videoName").val(file.name)
});
//仅保存
form.on('submit(save)', function(data){
	  if(isEditNull())return false;
	  if(isTagNull())return false;
	  data.field['contentTmp.TXT'] = editer.get();
	  data.field['documentTmp.TAG'] = getTagData();
	  data.field['contentTmp.STATUS'] = 1;
	  var formData = objToForm(data.field)
	  appendFile(formData)//获取文件
	  subcommon(formData,subType) //公共提交js
	  return false;
});
//保存并提交
form.on('submit(subSave)', function(data){
	  if(isEditNull()) return false;
	  if(isTagNull())return false;
	  data.field['contentTmp.TXT'] = editer.get();
	  data.field['documentTmp.TAG'] = getTagData();
	  data.field['contentTmp.STATUS'] = 3
	  var formData = objToForm(data.field)
	  appendFile(formData)//获取文件
	  subcommon(formData,subType)
	  return false;
});
//获取文件
function appendFile(formdata){
	if($("#videoFile")[0].files[0]!=undefined){
		formdata.append("videoFile", $("#videoFile")[0].files[0])
	}
	if($("#file")[0].files[0]!=undefined){
		formdata.append("imgFile", $("#file")[0].files[0])
	}
}
//获取标签
function getTagData(){
	var tagData = tag.get()
	return tagData.join(',')
}
//提交
function subcommon(formdata,type){
	//编辑操作
	if(type=='update'){
	   resAJAX.uploadFile('#(base)/documentTmp/update',formdata,cellback)
	   return false;
	} 
	//添加操作
	resAJAX.uploadFile('#(base)/documentTmp/add',formdata,cellback)
}
//提交回调
function cellback(res){
	if(res.code==20000){
		layer.msg("操作成功!",{time:1000},function(){
			back();
		})
	}else{
		layer.msg("操作失败!")
	}
}
//校验富文本是否为空
function isEditNull(){
	var txt = editer.get();
	if(txt==''||txt==null){
		layer.msg("富文本不能为空!");
		return true
	}
}
//校验文件格式 rm rmvb 前端无法识别type 只能通过后缀进行校验
function verifyType(type){
	var arr = type.split(".");
	type = arr[arr.length-1]
	var typeArr = ['avi','mp4','rm','rmvb']
	if($.inArray(type, typeArr)<0){
		layer.msg("视频格式只支持avi、rmvb、rm、mp4格式!")
		return true;
	}
}
//校验标签
function isTagNull(){
	var tagData = tag.get();
	if(tagData==undefined||tagData==null||tagData.length==0){
		layer.msg("标签不能为空")
		return true;
	}
}
