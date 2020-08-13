table.on('tool(fContentTmpTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	if (layEvent === 'del') { // 删除
		top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
			$.post('#(base)/fContentTmp/del', {
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
		openWindow('修改', '#(base)/fContentTmp/goEdit?id=' + data.id, '800px','600px', submitForm);
	}
});
