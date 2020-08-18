var form = layui.form;
form.render();
console.log($("logo").val())
var editer = new Editer($("#tiny"),`#(contentTmp.TXT??'')`,"#(base)/contentTmp/uploadimg")
//仅保存
form.on('submit(save)', function(form){
	var len = $("input:checked").length;
    if (len < 1) {
      layer.msg('请至少选择一项类别！', { icon: 5 });
      return false;
    }
	
	  form.field['contentTmp.txt'] = editer.get();
	  form.field['contentTmp.status'] = 1;
	  form.field['contentTmp.type'] = 'C301';
	  form.field['contentTmp.deleted'] = 0;
	  form.field['contentTmp.visible'] = 1;
    //获取checkbox[name='level']的值，获取所有选中的复选框，并将其值放入数组中
    var arr = new Array();
    $("input:checkbox[name='orgTop.roles']:checked").each(function(i){
        arr[i] = $(this).val();
    }); 
    console.log(form)
    //  替换 data.field.level的数据为拼接后的字符串
    form.field['orgTop.roles'] = arr.join(",");//将数组合并成字符串
	var url = '#(base)/contentTmp/' + ($("#id").val() ? 'edit' : 'add');
	$.post(url, form.field, function(data) {
		if (data.code == 20000) {
			var index = top.layer.getFrameIndex(window.name);
			top.layer.close(index);
			top.layer.msg('操作成功！');
			window.history.back()
		} else {
			top.layer.msg('操作失败！');
		}
	}, 'json');
	  return false;
});
//保存并提交
form.on('submit(subSave)', function(form){
	var len = $("input:checked").length;
    if (len < 1) {
      layer.msg('请至少选择一项类别！', { icon: 5 });
      return false;
    }
	  form.field['contentTmp.txt'] = editer.get();
	  form.field['contentTmp.status'] = 3
	  form.field['contentTmp.type'] = 'C301';
	  form.field['contentTmp.deleted'] = 0;
	  form.field['contentTmp.visible'] = 1;
    //获取checkbox[name='level']的值，获取所有选中的复选框，并将其值放入数组中
    var arr = new Array();
    $("input:checkbox[name='orgTop.roles']:checked").each(function(i){
        arr[i] = $(this).val();
    }); 
    console.log(form)
    //  替换 data.field.level的数据为拼接后的字符串
    form.field['orgTop.roles'] = arr.join(",");//将数组合并成字符串
   
	var url = '#(base)/contentTmp/' + ($("#id").val() ? 'edit' : 'add');
	$.post(url, form.field, function(data) {
		if (data.code == 20000) {
			var index = top.layer.getFrameIndex(window.name);
			top.layer.close(index);
			top.layer.msg('操作成功！');
			window.history.back()
		} else {
			top.layer.msg('操作失败！');
		}
	}, 'json');
	  return false;
});

$("#mapselect").on("click",function(){
	layer.open({
		type : 2,
		title : '请选择地址',
		closeBtn : 1,
		area : [ '650px', '680px' ],
		anim : 1,
		move : false,
		resize : false,
		content : '#(base)/contentTmp/map'
	});
})
//初始化坐标
layui.use('layer',function(){
var layer = layui.layer;
    layer.ready(function(){
    	var hidaddr=$("#hidAddr").val()
    	if(hidaddr!=""&&hidaddr!=undefined&&hidaddr!=null){
    	 	$("#addr").html(hidaddr);
    		var x = $("#x").val();
        	
    		$("#coord").val(x+","+$("#y").val());
    	}
    
    	findCategory();
    	
    });  
 
});

//坐标录入
function showAddr(addrseall){
   	console.log(addrseall);
   	$("#addr").html(addrseall.address);
   	$("#hidAddr").val(addrseall.address);
	$("#coord").val(addrseall.location.lat+","+addrseall.location.lng);
	$("#x").val(addrseall.location.lat);
	$("#y").val(addrseall.location.lng);
}

//图片上传
layui.use('upload', function(){
	  var $ = layui.jquery
	  ,upload = layui.upload;
	  
	  //普通图片上传
	  var uploadInst = upload.render({
	    elem: '#test1'
	    ,url: '#(base)/contentTmp/upload' //改成您自己的上传接口
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	        $('#demo1').attr('src', result); //图片链接（base64）
	       
	      });
	    }
	    ,done: function(res){
	    	 $('#logo').val(res.filePath)
	      //如果上传失败
	    	console.log(res)
	      if(res.code > 0){
	        return layer.msg('上传失败');
	      }
	      //上传成功
	    }
	    ,error: function(){
	      //演示失败状态，并实现重传
	      var demoText = $('#demoText');
	      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
	      demoText.find('.demo-reload').on('click', function(){
	        uploadInst.upload();
	      });
	    }
	  });
});

//获取文件

