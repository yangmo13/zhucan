var form = layui.form;
form.render();
form.on('submit(saveBtn)', function(form) {
	var disabilityTypeCodes = [];
	$('input[name="disabilityTypeCodes"]:checked').each(function() {
		disabilityTypeCodes.push($(this).val());
		//disabilityTypeCodes.push($(this).attr('name'));
	});
	form.field.disabilityTypeCodes = disabilityTypeCodes.join(',');
	
	var url = '#(base)/archive/' + ($("#id").val() ? 'edit' : 'add');
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

var laydate = layui.laydate;
laydate.render({
	elem : '[name="archive.certPeriod"]',
    type: 'date',
    trigger : 'click'
});