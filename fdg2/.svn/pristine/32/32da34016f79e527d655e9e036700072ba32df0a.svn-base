/**
 * 标签组件
 * @param filter 标识 默认tag 
 * @returns
 */
function Tags(filter){
	//默认约定
	if(filter==undefined)filter="tag"
	var tag;
	layui.use(['tag'],function(){
		tag = layui.tag;
		tag.render(filter);
	});
	return {
		get:function(){
			return tag.data(filter);
		},
		set:function(doms){
			doms.forEach(function(dom,index){
				$("[lay-filter='"+filter+"']").append(`<button lay-id="${index}" type="button" class="tag-item">${dom}</button>`)
			})
		}
	}
}