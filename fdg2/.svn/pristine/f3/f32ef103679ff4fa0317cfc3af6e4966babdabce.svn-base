var form = layui.form;
form.render("select");
function onSaveDataAuthBtnClick() {
	var roleId = $("#roleId");
	var dataAuthTable = $("#dataAuthTable");
	var dataIds = [];
	var auths = [];
	dataAuthTable.find("tbody tr").each(function() {
		var tds = $(this).find("td");
		var dataId = $(tds[0]).find("input").val();
		var auth = $(tds[3]).find("select").val();
		dataIds.push(dataId);
		if (auth) {
			auths.push(auth);
		}
	});
	if (dataIds.length != auths.length) {
		top.layer.msg('请配置数据权限！');
		return;
	}
	$.post('#(base)/role/setDataAuth', {
		roleId : '#(roleId)',
		dataIds : dataIds.join(','),
		auths : auths.join(',')
	}, function(data) {
		if (data.code == 20000) {
			var index = top.layer.getFrameIndex(window.name);
			top.layer.close(index);
			top.layer.msg('操作成功！');
		} else {
			top.layer.msg('操作失败！');
		}
	}, 'json');
}