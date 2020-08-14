var laydate = layui.laydate;
var form = layui.form;
var editer = new Editer($("#ed"),`#(articleTmp.TXT??'')`,"#(base)/articleTmp/upload")
var subType='add'
	if($("#id").val()!=''){
		subType="update"
	}
laydate.render({ 
  elem: '#pubTime'
});
//仅保存
form.on('submit(save)', function(data){
	  if(isEditNull())return false;
	  data.field['contentTmp.TXT'] = editer.get();
	  data.field['contentTmp.STATUS'] = 1
	  var formData = objToForm(data.field)
	  appendFile(formData)//获取文件
	  subcommon(formData,subType) //公共提交js
	  return false;
});
//保存并提交
form.on('submit(subSave)', function(data){
	  if(isEditNull()) return false;
	  data.field['contentTmp.TXT'] = editer.get();
	  data.field['contentTmp.STATUS'] = 3
	  var formData = objToForm(data.field)
	  appendFile(formData)//获取文件
	  subcommon(formData,subType) //公共提交js
	  return false;
});
//获取文件
function appendFile(formdata){
	var id = $("#id").val()
	if($("#file")[0].files[0]!=undefined){
		formdata.append("file", $("#file")[0].files[0])
	}
}
