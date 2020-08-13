var form = layui.form;
form.on('submit(saveBtn)', function(form) {
	var url = '#(base)/role/' + (form.field['role.id'] ? 'edit' : 'add');
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