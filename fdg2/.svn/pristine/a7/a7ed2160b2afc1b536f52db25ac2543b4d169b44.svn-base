function goAdd() {
	openWindow('添加', '#(base)/tinyWishTmp/goAdd', '800px', '600px', submitForm);
}
var table = layui.table;
// 展示已知数据
table.render({
	elem : '#tinyWishTmpTable',
	height : 'full-150',
	url : '#(base)/tinyWishTmp/find',
	method: 'post',
	toolbar : '#toolbarTpl',
	defaultToolbar : [],
	cols : [ [
		{type: 'numbers',title : '序号',width : 60,align : 'center'}, 
		{field: 'id',title: '主键',width: 120,align: 'center', hide:true},
		{field: 'TITLE',title: '需求物品或事项',width: 120,align: 'center', hide:false},
		{field: 'realname',title: '姓名',width: 120,align: 'center', hide:false},
		{field: 'idCard',title: '身份证号',width: 120,align: 'center', hide:false},
		{field: 'tel',title: '联系电话',width: 120,align: 'center', hide:false},
		{field: 'startDate',title: '发起日期',width: 120,align: 'center', hide:false},
		{field: 'endDate',title: '结束日期',width: 120,align: 'center', hide:false},
		{
			field: 'takeStatus',title: '认领状态',width: 120,align: 'center', hide:false,
			templet:#widget("fdp.takeStatus",name="takeStatus",type="render")
		},
		{field: 'takerName',title: '认领人',width: 120,align: 'center', hide:false},
		{field: 'opt',title: '操作',align: 'center',width: 120,templet: '#optTpl'} 
	] ],
	even : true,
	page : true
});
table.on('tool(tinyWishTmpTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	
	if (layEvent === 'detail') { // 详情
		//openWindow('详情', '#(base)/tinyWishTmp/goDetail?id=' + data.id, '800px','600px', submitForm);
		window.location.href='#(base)/tinyWishTmp/goDetail?id='+data.id;
	} 
	else if (layEvent === 'close') { // 关闭
		top.layer.confirm('确定关闭您所选择的数据吗?', function(index) {
			$.post('#(base)/tinyWishTmp/close', {
				id : data.id
			}, function(d) {
				if (d.code == 20000) {
					submitForm();
				} else {
					top.layer.msg('关闭失败！');
				}
			}, 'json');
			top.layer.close(index);
		});
	} 
	else if (layEvent === 'del') { // 删除
		top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
			$.post('#(base)/tinyWishTmp/del', {
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
	}
});
var form = layui.form;
form.render('select');
function submitForm() {
	table.reload('tinyWishTmpTable', {
		where : $('#search-form').serializeJson()
	})
}