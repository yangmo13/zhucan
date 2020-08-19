var table = layui.table;
var type = 'C010'
table.render({
	elem : '#documentTmpTable',
	height : 'full-150',
	url : '#(base)/documentTmp/find',
	method: 'post',
	where:{type:type},
	toolbar : '#toolbarTpl',
	defaultToolbar : [],
	cols : [ [
		{type: 'numbers',title : '序号',width : 60,align : 'center'}, 
		{field: 'ID',title: '主键',align: 'center', hide:true},
		{field: 'TITLE',title: '标题',width : 400,align: 'center', hide:false},
		{field: '',title: '类别',width : 400,align: 'center', hide:false},
		{field: 'PUB_TIME',title: '发布时间',width : 200,align: 'center', hide:false},
		{field: 'STATUS',title: '状态',align: 'center',width : 100, hide:false,templet:#widget("fdp.auditStatus",name="STATUS",type="render")},
		{field: 'REGISTER_ORG_NAME',title: '登记机构',width : 200,align: 'center', hide:false},
		{field: 'REGISTER_NAME',title: '登记人',width : 200,align: 'center', hide:false},
		{field: 'REGIST_TIME',title: '登记时间',width : 200,align: 'center', hide:false},
		{field: 'opt',title: '操作',align: 'center',width : 200,templet: '#optTpl'} 
	] ],
	even : true,
	page : true
});

table.on('tool(articleTmpTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	if (layEvent === 'del') { // 删除
		del(data.ID);
	}else if (layEvent === 'edit') {//编辑
		goEdit(data.ID)
	}else if(layEvent === 'detil'){//详情
		goDetil(data.ID)
	}
});
//添加
function goAdd(){
	href('#(base)/documentTmp/goEdit?type='+type)
}
//编辑
function goEdit(id){
	href('#(base)/documentTmp/goEdit?id='+id+"&type="+type)
}
//详情
function goDetil(id){
	href('#(base)/documentTmp/goContentDetil?id='+id+"&type="+type)
}
//删除
function del(id){
	top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
		delcommon(id)
		top.layer.close(index);
	});
}
//查询操作
var form = layui.form;
form.render('select');
function submitForm() {
	table.reload('documentTmpTable', {
		where : $('#search-form').serializeJson()
	})
}
//执行删除
function delcommon(id){
	$.post('#(base)/documentTmp/del', {
		id : id
	}, function(d) {
		if (d.code == 20000) {
			submitForm();
		} else {
			top.layer.msg('删除失败！');
		}
	}, 'json');
}

