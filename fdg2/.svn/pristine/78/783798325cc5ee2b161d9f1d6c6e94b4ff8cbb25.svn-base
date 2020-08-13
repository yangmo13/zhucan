let form = layui.form;
form.on('submit(saveBtn)', function(form) {
	var table = layui.table;
	var url = '#(base)/config/save';
	$.post(url, $('#search-form').serializeJson(), function(data) {
		if (data.code == 20000) {
			top.layer.msg('保存成功！');
		} else {
			top.layer.msg('保存失败！');
		}
	}, 'json');
	return false; // 返回false阻止提交
});