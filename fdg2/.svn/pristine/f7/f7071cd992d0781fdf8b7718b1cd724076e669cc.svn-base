function goAdd() {
	openWindow('添加', '#(base)/contentTmp/goAdd', '800px', '600px', submitForm);
}
var table = layui.table;
// 展示已知数据
table.render({
	elem : '#contentTmpTable',
	height : 'full-150',
	url : '#(base)/contentTmp/find',
	method: 'post',
	toolbar : '#toolbarTpl',
	defaultToolbar : [],
	cols : [ [
		{type: 'numbers',title : '序号',width : 60,align : 'center'}, 
		{field: 'id',title: '主键',width: 120,align: 'center', hide:true},
		{field: 'type',title: '类别，见数据字典fdp.contentType',width: 120,align: 'center', hide:false},
		{field: 'title',title: '标题',width: 120,align: 'center', hide:false},
		{field: 'txt',title: '内容，支持HTML',width: 120,align: 'center', hide:false},
		{field: 'registerOrgId',title: '登记机构ID',width: 120,align: 'center', hide:false},
		{field: 'registerOrgName',title: '登记机构名称，冗余存储，可用于追溯',width: 120,align: 'center', hide:false},
		{field: 'registerId',title: '登记人ID',width: 120,align: 'center', hide:false},
		{field: 'registerName',title: '登记人姓名，冗余存储，可用于追溯',width: 120,align: 'center', hide:false},
		{field: 'registTime',title: '登记时间',width: 120,align: 'center', hide:false},
		{field: 'submitorOrgId',title: '提交审核机构ID',width: 120,align: 'center', hide:false},
		{field: 'submitorOrgName',title: '提交审核机构名称，冗余存储，可用于追溯',width: 120,align: 'center', hide:false},
		{field: 'submitorId',title: '提交审核人ID',width: 120,align: 'center', hide:false},
		{field: 'submitorName',title: '提交审核人姓名，冗余存储，可用于追溯',width: 120,align: 'center', hide:false},
		{field: 'submitTime',title: '提交审核时间',width: 120,align: 'center', hide:false},
		{field: 'auditorOrgId',title: '审核机构ID',width: 120,align: 'center', hide:false},
		{field: 'auditorOrgName',title: '审核机构名称，冗余存储，可用于追溯',width: 120,align: 'center', hide:false},
		{field: 'auditorId',title: '审核人ID',width: 120,align: 'center', hide:false},
		{field: 'auditorName',title: '审核人姓名',width: 120,align: 'center', hide:false},
		{field: 'auditTime',title: '审核时间',width: 120,align: 'center', hide:false},
		{field: 'status',title: '审核状态，见数据字典fdp.auditStatus',width: 120,align: 'center', hide:false},
		{field: 'auditRemark',title: '审核批注',width: 120,align: 'center', hide:false},
		{field: 'deleted',title: '删除标志，0：未删除，1：已删除',width: 120,align: 'center', hide:false},
		{field: 'visible',title: '是否可见，0：不可见，1：可见',width: 120,align: 'center', hide:false},
		{field: 'opt',title: '操作',align: 'center',width: 120,templet: '#optTpl'} 
	] ],
	even : true,
	page : true
});
table.on('tool(contentTmpTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	if (layEvent === 'del') { // 删除
		top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
			$.post('#(base)/contentTmp/del', {
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
		openWindow('修改', '#(base)/contentTmp/goEdit?id=' + data.id, '800px','600px', submitForm);
	}
});
var form = layui.form;
form.render('select');
function submitForm() {
	table.reload('contentTmpTable', {
		where : $('#search-form').serializeJson()
	})
}