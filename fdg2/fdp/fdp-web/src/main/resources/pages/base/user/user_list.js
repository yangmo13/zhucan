function goAdd() {
	openWindow('添加用户', '#(base)/user/goAddOrEdit', '600px', '400px', submitForm);
}
layui.use(['treeSelect','form'], function () {
    var treeSelect= layui.treeSelect;
    treeSelect.render({
        elem: '#deptId',
        data: '#(base)/dept/findForTreeSelect',
        click: function(d){
            $('#deptId').val(d.current.id);
        }
    });
});
var table = layui.table;
// 展示已知数据
table.render({
	elem : '#userTable',
	height : 'full-150',
	url : '#(base)/user/find',
	method: 'post',
	toolbar : '#toolbarTpl',
	defaultToolbar : [],
	cols : [ [ // 标题栏
	{type: 'numbers',title : '序号',width : 60,align : 'center'}, 
	{
		field : 'realname',
		title : '姓名',
		align : 'center',
		width : 250
	}, {
		field : 'username',
		title : '用户名',
		align : 'center',
		width : 150
	}, {
		field : 'deptId',
		title : '单位',
		align : 'center',
		templet : function(d) {
		    #for(item : depts)
	    	if ('#(item.id)'==d.deptId) {
				return '#(item.title)';
			}
			#end
		    return '无';
		},
		width : 150
	},/* {
		field : 'sex',
		title : '性别',
		align : 'center',
		templet : #widget("user.gender",name="sex",type="render"),
		width : 80
	},*/ {
		field : 'editable',
		title : '可编辑',
		align : 'center',
		templet : #widget("global.yesno",name="editable",type="render"),
		width : 80
	}, {
		field : 'deletable',
		title : '可删除',
		align : 'center',
		templet : #widget("global.yesno",name="deletable",type="render"),
		width : 80
	}, {
		field : 'status',
		title : '状态',
		align : 'center',
		templet : #widget("user.status",name="status",type="render"),
		width : 100
	}, {
		field : 'startTime',
		title : '允许访问时间',
		align : 'center',
		templet : function(d) {
			if (d.startTime==null&&d.endTime==null) return "永久访问权限";
			if (d.startTime==null) return "截止到" + d.endTime.substr(0, 11);
			if (d.endTime==null) return "从" + d.startTime.substr(0, 11) + "到永久";
			return d.startTime.substr(0, 11) + "~" + d.endTime.substr(0, 11);
		},
		width : 200
	}, {
		field : 'opt',
		title : '操作',
		align : 'center',
		width : 120,
		templet : '#optTpl'
	} ] ],
	even : true,
	page : true
});
table.on('tool(userTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	if (layEvent === 'del') { // 删除
		top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
			$.post('#(base)/user/del', {
				id : data.id
			}, function(d) {
				if (d.code == 20000) {
					submitForm();
				} else {
					top.layer.msg('删除失败！');
				}
			}, 'json');
			top.layer.close(index);
		});
	} else if (layEvent === 'edit') {
		openWindow('修改用户', '#(base)/user/goAddOrEdit?id=' + data.id, '600px',
				'400px', submitForm);
	} else if (layEvent === 'unlock') {
		top.layer.confirm('确定解锁您所选择的用户吗?', function(index) {
			$.post('#(base)/user/unlock', {
				id : data.id
			}, function(d) {
				if (d.code == 20000) {
					submitForm();
				} else {
					top.layer.msg('操作失败！');
				}
			}, 'json');
			top.layer.close(index);
		});
	} else if (layEvent === 'lock') {
		top.layer.confirm('确定锁定您所选择的用户吗？锁定后该用户将无法登陆！', function(index) {
			$.post('#(base)/user/lock', {
				id : data.id
			}, function(d) {
				if (d.code == 20000) {
					submitForm();
				} else {
					top.layer.msg('操作失败！');
				}
			}, 'json');
			top.layer.close(index);
		});
	}  else if (layEvent === 'resetpwd') {
		top.layer.confirm('确定重置您所选择用户的密码吗?', function(index) {
			$.post('#(base)/user/resetpwd', {
				id : data.id
			}, function(d) {
				if (d.code == 20000) {
					top.layer.msg('密码已重置为#(defaultPwd??)！');
				} else {
					top.layer.msg('操作失败！');
				}
			}, 'json');
			top.layer.close(index);
		});
	}
});
var form = layui.form;
form.render('select');
function submitForm() {
	table.reload('userTable', {
		where : $('#search-form').serializeJson()
	})
}