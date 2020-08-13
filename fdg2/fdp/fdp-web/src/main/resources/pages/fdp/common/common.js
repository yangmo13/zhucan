/**
 * 封装请求对象 uploadFile:上传 downloadFile:下载 subForm:提交表单 subData:提交数据 getData:请求数据
 */
var resAJAX = {}
// 上传文件请求
resAJAX.uploadFile = function(url, formData, cellBack) {
	$.ajax({
		url : url,
		type : 'POST',
		data : formData,
		contentType : false,
		processData : false,
		dataType : "json",
		success : function(res) {
			if (cellBack == undefined) {
				if (res.code == 20000) {
					layer.msg("操作成功!")
				} else {
					layer.msg("操作失败!")
				}
			} else {
				cellBack(res)
			}
		},
		error : function(response) {
			layer.msg("上传失败!")
		}
	});
}
// 下载文件请求
resAJAX.downloadFile = function(url, data) {
	$.ajax({
				url : url,
				data : data == undefined ? {} : data,
				async : true,
				type : 'POST',
				success : function(data, status, req) {
					var name = req.getResponseHeader("content-disposition")
							.split(';')[1].split('=')[1];
					var a = document.createElement('a');
					blob = new Blob([ data ])
					var url = window.URL.createObjectURL(blob);
					a.href = url;
					a.download = name;
					a.click();
					window.URL.revokeObjectURL(url);
					$(a).remove();
				},
				error : function(response) {
					layer.msg("下载失败!")
				}
			});
}
// 提交表单请求
resAJAX.subForm = function(url, formData, cellBack) {
	$.post(api[url], formData, function(res) {
		if (cellBack == undefined) {
			if (res.code == 20000) {
				layer.msg("操作成功!");
			} else {
				layer.msg("操作失败!");
			}
		} else {
			cellBack(res)
		}
	})
}
// 提交数据请求
resAJAX.subData = function(url, data, cellBack) {
	$.post(api[url], data, function(res) {
		if (cellBack == undefined) {
			if (res.code == 20000) {
				layer.msg("操作成功!");
			} else {
				layer.msg("操作失败!");
			}
		} else {
			cellBack(res)
		}
	})
}
/**
 * get请求数据 默认同步
 */
resAJAX.getData = function(url, data, cellBack,asy) {
	var async = false;
	if(asy == undefined){
		async = asy;
	}
	var res;
	$.ajax({
        url: url,
        type: 'get',
        data:data == undefined ? {} : data,
        contentType: 'application/json',
        async: async, 
        success: function (result) {
        	res = result;
        	if(asy == undefined)cellBack(res)
        },
        error: function (result) {
        }
    });
	return res;
}

/**
 * 跳转
 * @param url
 * @returns
 */
function href(url) {
	window.location.href = url
}
/**
 * 返回
 * @returns
 */
function back(){
	history.back(-1);
}
/**
 * 对象转表单
 * @param obj
 * @returns
 */
function objToForm(obj) {
	var formData = new FormData();
	for ( var key in obj) {
		formData.append(key, obj[key])
	}
	return formData;
}