function openWindow(title, url, width, height, callback) {
	$ = layui.jquery;
	top.layer.open({
		type : 2,
		title : title,
		closeBtn : 1,
		area : [ width, height ],
		anim : 1,
		move : false,
		resize : false,
		content : url, // iframe的url，no代表不显示滚动条
		end : function() { // 此处用于演示
			if (callback) {
				callback();
			}
		}
	});
}
$ = layui.jquery;
$.fn.serializeJson = function(otherString) {
	var serializeObj = {}, array = this.serializeArray();
	$(array).each(function() {
		if (serializeObj[this.name]) {
			serializeObj[this.name] += ';' + this.value;
		} else {
			serializeObj[this.name] = this.value;
		}
	});
	if (otherString != undefined) {
		var otherArray = otherString.split(';');
		$(otherArray).each(function() {
			var otherSplitArray = this.split(':');
			serializeObj[otherSplitArray[0]] = otherSplitArray[1];
		});
	}
	return serializeObj;
};

Date.prototype.format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "H+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function msg(msg, type) {
	top.layer.alert(msg, {title:'提示'});
}

function tabAdd(title,url,id) {
	tab.tabAdd(title,url,id);
}
function closeMe() {
	var index = top.layer.getFrameIndex(window.name);
	top.layer.close(index);
}
function downloadFile(url, filename) {
	let index = layer.load(2, {shade:0.2});
	var xhr = new XMLHttpRequest();
	xhr.open('POST', url, true);//get请求，请求地址，是否异步
	xhr.responseType = "blob";    // 返回类型blob
	xhr.onload = function () {// 请求完成处理函数
		if (this.status === 200) {
			layer.close(index);
			var blob = this.response;// 获取返回值
			var a = document.createElement('a');
			let typeName = $('#type').find("option:selected").text();
			a.download = filename;
			a.href=window.URL.createObjectURL(blob);
			a.click();
	    }
	};
	xhr.send();// 发送ajax请求
}
function isNotNaN(value) {
    return typeof value === 'number' && !isNaN(value);
}
let loadIndex;
function showLoad() {
	loadIndex = layui.layer.msg('正在加载中', {icon: 16, shade:0.1, time: 0});
}
function closeLoad() {
	layui.layer.close(loadIndex);
}