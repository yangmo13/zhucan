//公共提交-修改
function subcommon(formdata,type){
	//编辑操作
	if(type=='update'){
	   resAJAX.uploadFile('#(base)/articleTmp/update',formdata,cellback)
	   return false;
	} 
	//添加操作
	resAJAX.uploadFile('#(base)/articleTmp/add',formdata,cellback)
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
//公共删除
function delcommon(id){
	$.post('#(base)/articleTmp/del', {
		id : id
	}, function(d) {
		if (d.code == 20000) {
			submitForm();
		} else {
			top.layer.msg('删除失败！');
		}
	}, 'json');
}
//校验富文本是否为空
function isEditNull(){
	var txt = editer.get();
	if(txt==''||txt==null){
		layer.msg("富文本不能为空!");
		return true
	}
}