var permissionTree;
$(function() {
	$('#permission_tree').height($("#savePermissionBtn").parentsUntil('.layui-layer').parent().height() - 100);
});
var setting = {
	check : {
		enable : true
	},
	data : {
		simpleData : {
			enable : true
		}
	}
};

var zNodes = [];
#for(data:datas)
zNodes.push({
	id : '#(data.id)',
	pId : '#(data.pId)',
	name : '#(data.name)',
	checked : '#(data.checked)' == 'true',
	permission : '#(data.permission)',
	type : '#(data.type)',
	open : true
});
#end

$(function() {
	permissionTree = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
});
function onSaveFuncAuthClick() {
	var nodes = permissionTree.getCheckedNodes(true);
	var menuIds = [];
	var functions = [];
	for (var i = 0; i < nodes.length; i++) {
		if (nodes[i].type == 'M') {
			menuIds.push(nodes[i].id);
		} else {
			functions.push(nodes[i].pId + '|' + nodes[i].permission);
		}
	}
	$.post('#(base)/role/setFuncAuth', {
		roleId : '#(roleId)',
		menuIds : menuIds.join(','),
		functions : functions.join(',')
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