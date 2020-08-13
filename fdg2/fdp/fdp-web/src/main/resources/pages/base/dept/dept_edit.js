let form = layui.form;
$.post('#(base)/dept/findById', {
	id : '#(dept.pid)'
}, function(data) {
	if (data.code == 20000 && data.data) {
		$('#parentName').text(data.data.title);
	} else {
		$('#parentName').text('无');
	}
}, 'json');
form.on('submit(saveBtn)', function(form) {
	var table = layui.table;
	var url = '#(base)/dept/' + (form.field['dept.id'] ? 'edit' : 'add');
	$.post(url, form.field, function(data) {
		if (data.code == 20000) {
			var index = top.layer.getFrameIndex(window.name);
			top.layer.close(index);
			top.layer.msg('操作成功！');
		} else {
			top.layer.msg('操作失败！');
		}
	}, 'json');
	return false; // 返回false阻止提交
});