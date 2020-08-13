var functableIns;
layui.use(['treeSelect','form'], function () {
    var treeSelect= layui.treeSelect,form = layui.form;
    treeSelect.render({
        elem: '#pid',
        data: '#(base)/menu/findForTreeSelect?id=#(menu.id)',
        search: false,
        click: function(d){
            $('#pid').val(d.current.id);
        },
        success: function(d){
        	treeSelect.checkNode('pid',#(menu.pid));
        }
    });
    form.on('submit(saveBtn)', function(form) {
		var table = layui.table;
		var funcdatas = table.cache["functionTable"];
		var funcs = "";
		for (var i = 0; i < funcdatas.length; i++) {
			var tmp = funcdatas[i];
			if (tmp instanceof Array)
				continue;
			if (!tmp.name) {
				top.layer.msg('第' + (i + 1) + '行数据中【功能名称】不能为空！')
				return false;
			}
			if (!tmp.permission) {
				top.layer.msg('第' + (i + 1) + '行数据中【权限路径】不能为空！')
				return false;
			}
			funcs += (i == 0) ? '' : ',';
			funcs += tmp.name + '|' + tmp.permission;
		}
		form.field.functions = funcs;
		var url = '#(base)/menu/'
				+ (form.field['menu.id'] ? 'edit' : 'add');
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
});
var functiondatas = [];
#for(item : functions)
	functiondatas.push({
		name : '#(item.name)',
		permission : '#(item.permission)'
	});
#end
$(function() {
	var table = layui.table;
	// 展示已知数据
	functableIns = table.render({
		elem : '#functionTable',
		height : 'full-320',
		limit : 1000,
		cols : [ [ // 标题栏
		{
			field : 'SEQ',
			title : '序号',
			width : 60,
			align : 'center',
			templet : '#indexTpl'
		}, {
			field : 'name',
			title : '功能名称',
			align : 'center',
			edit : 'text',
			width : 200
		}, {
			field : 'permission',
			title : '权限路径',
			align : 'center',
			edit : 'text',
			width : 250
		}, {
			field : 'opt',
			title : '操作',
			align : 'center',
			width : 80,
			templet : '#optTpl'
		} ] ],
		data : functiondatas,
		even : true
	});
	table.on('tool(fun)', function(obj) {
		var data = obj.data; // 获得当前行数据
		var layEvent = obj.event;
		if (layEvent === 'del') { // 删除
			obj.del();
		}
	});
	$("#addFunction").click(function() {
		var oldData = table.cache["functionTable"];
		oldData.push({
			"name" : "功能名称",
			"permission" : "func:test"
		});
		table.reload('functionTable', {
			data : oldData
		});
	});
});