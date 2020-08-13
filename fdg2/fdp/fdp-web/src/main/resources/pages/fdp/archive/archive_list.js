function goAdd() {
	openWindow('添加', '#(base)/archive/goAddOrEdit', '1000px', '700px', submitForm);
}
var table = layui.table;
// 展示已知数据
table.render({
	elem : '#archiveTable',
	height : 'full-150',
	url : '#(base)/archive/find',
	method: 'post',
	toolbar : '#toolbarTpl',
	defaultToolbar : [],
	cols : [ [
		{type: 'numbers',title : '序号',width : 60,align : 'center'}, 
		{field: 'realname',title: '姓名',width: 120,align: 'center', hide:false},
		{field: 'idCard',title: '身份证号',width: 200,align: 'center', hide:false},
		{field: 'tel',title: '联系电话',width: 150,align: 'center', hide:false},
		{
			field: 'disabilityType',title: '残疾类型',width: 300,align: 'center', hide:false,
			templet: function(d) {
				//alert(d.disabilityType);
				var disabilityTypeSplit=d.disabilityType.split(",");
				var disabilityTypeStr="";
				for(i = 0,len=disabilityTypeSplit.length; i < len; i++) 
				{
					if("1"==disabilityTypeSplit[i])
					{
						disabilityTypeStr+="视力残疾,";
					}
					else if("2"==disabilityTypeSplit[i]){
						disabilityTypeStr+="听力残疾,";
					}
					else if("3"==disabilityTypeSplit[i]){
						disabilityTypeStr+="言语残疾,";
					}
					else if("4"==disabilityTypeSplit[i]){
						disabilityTypeStr+="肢体残疾,";
					}
					else if("5"==disabilityTypeSplit[i]){
						disabilityTypeStr+="智力残疾,";
					}
					else if("6"==disabilityTypeSplit[i]){
						disabilityTypeStr+="精神残疾,";
					}
					else{
						disabilityTypeStr+="无残疾,";
					}
				}
				
				return disabilityTypeStr.substring(0,disabilityTypeStr.length-1);
			}
		},
		{
			field: 'disabilityLevel',title: '残疾等级',width: 120,align: 'center', hide:false,
			templet:#widget("fdp.disabilityLevel",name="disabilityLevel",type="render")
		},
		{field: 'addr',title: '现居住地',width: 300,align: 'center', hide:false},
		{field: 'opt',title: '操作',align: 'center',width: 120,templet: '#optTpl'} 
	] ],
	even : true,
	page : true
});
table.on('tool(archiveTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	if (layEvent === 'del') { // 删除
		top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
			$.post('#(base)/archive/del', {
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
		openWindow('修改', '#(base)/archive/goAddOrEdit?id=' + data.id, '1000px','700px', submitForm);
	}
});
var form = layui.form;
form.render('select');
function submitForm() {
	table.reload('archiveTable', {
		where : $('#search-form').serializeJson()
	})
}