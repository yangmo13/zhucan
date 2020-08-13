### 表格序号列模板
#define deptRender(name)
function(d) {
	var deptId = d.#(name);
	if (deptId == null) return '无';
	var title = null;
	#for(dept : dictService.findDeptsForShow())
	if('#(dept.get("id"))' == deptId) title = '#(dept.get("title"))';
	#end
	if (!title) return '无';
	return title;
}
#end

#define deptRenderForClick(name, funcname)
function(d) {
	var deptId = d.#(name);
	if (deptId == null) return '无';
	var title = null;
	#for(dept : dictService.findDeptsForShow())
	if('#(dept.get("id"))' == deptId) title = '#(dept.get("title"))';
	#end
	if (!title) return '无';
	return '<a href=\'javascript:#(funcname)(' + deptId + ')\' style=\'color:blue;text-decoration:underline;\'>' + title + '</a>';
}
#end

#define deptSelect(id, value,isSearch)
var d#(id) = function(id, deptId) {
	if (deptId == 0) {
		$('##(id)+div').find(".layui-input").val('');
		return;
	}
	$('#' + id).val(deptId);
	var title = null;
	#for(dept : dictService.findDeptsForShow())
	if('#(dept.get("id"))' == deptId) {
		title = '#(dept.get("title"))';
	}
	#end
	if (title) {
		$('##(id)+div').find(".layui-input").val(title);
	}
};
layui.use(['treeSelect','form'], function () {
	var treeSelect= layui.treeSelect;
	treeSelect.render({
        elem: '##(id)',
        data: '#(base)/dept/findForTreeSelect',
        search: false,
        click: function(d){
        	d#(id)('#(id)',d.current.id);
        },
        success: function(d){
        	#if(value??)
        	treeSelect.checkNode('#(id)','#(value)');
        	d#(id)('#(id)','#(value)');
        	#end
        }
    });
});
#end