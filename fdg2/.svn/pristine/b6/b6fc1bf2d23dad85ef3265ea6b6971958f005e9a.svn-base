var form = layui.form;
form.render();
form.on('submit(saveBtn)', function(form) {
	var roleids = [];
	$('input[name="roleids"]:checked').each(function() {
		roleids.push($(this).val());
	});
	form.field.roleids = roleids.join(',');
	form.field['user.deptId'] = $('#user_deptId').val();
	var url = '#(base)/user/' + (form.field['user.id'] ? 'edit' : 'add');
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
#call("deptSelect", "user_deptId", user.deptId??'0', false)
var laydate = layui.laydate;
laydate.render({
	elem : '[name="user.startTime"]',
    type: 'date',
    trigger : 'click'
});
laydate.render({
	elem : '[name="user.endTime"]',
    type: 'date',
    trigger : 'click'
});