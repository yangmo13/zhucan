function goAdd() {
	window.location.href='#(base)/contentTmp/goAdd';
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
		{field: 'ID',title: '主键',width: 120,align: 'center', hide:true},
		{field: 'TITLE',title: '企业名称',align: 'center', hide:false},
		{field: 'TYPE',title: '类别',align: 'center', hide:false,templet:#widget("fdp.contentType",name="TYPE",type="render")},
		{field: 'SIZE',title: '规模',align: 'center', hide:false,templet:#widget("fdp.orgSize",name="SIZE",type="render")},
		{field: 'NATURE',title: '性质',align: 'center', hide:false,templet:#widget("fdp.orgNature",name="NATURE",type="render")},
		{field: 'LINKMAN',title: '联系人',align: 'center', hide:false},
		{field: 'TEL',title: '联系电话',align: 'center', hide:false},
		{field: 'ADDR',title: '地址',align: 'center', hide:false},
		{field: 'STATUS',title: '状态',align: 'center', hide:false,templet:#widget("fdp.auditStatus",name="STATUS",type="render")},
		{field: 'REGISTER_ORG_NAME',title: '登记机构',align: 'center', hide:false},
		{field: 'REGISTER_NAME',title: '登记人姓名',align: 'center', hide:false},
		{field: 'REGIST_TIME',title: '登记时间',align: 'center', hide:false},
		{field: 'opt',title: '操作',align: 'center',width: 150,templet: '#optTpl'} 
	] ],
	even : true,
	page : true
});
table.on('tool(contentTmpTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	console.log(obj.data)
	if (layEvent === 'del') { // 删除
		top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
			$.post('#(base)/contentTmp/del', {
				id : data.ID
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
		window.location.href='#(base)/contentTmp/goEdit?id=' + data.ID;
		//openWindow('修改', '#(base)/contentTmp/goEdit?id=' + data.id, '800px','600px', submitForm);
	}else if(layEvent === 'detil'){
		window.location.href='#(base)/contentTmp/goContentDetil?id='+data.ID;
	}
});
var form = layui.form;
form.render('select');
function submitForm() {
	var title = $("#title").val();
	var status = $("#status").val();
	table.reload('contentTmpTable', {
		//where : $('#search-form').serializeJson()
		page:{
            curr:1   //默认从第一页开始搜索
        },
		where: {
			title:title, 
			status: status
		}
	})
}
