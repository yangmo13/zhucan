function init() {
    var map = new qq.maps.Map(document.getElementById("container"),{
        center: new qq.maps.LatLng(45.800369,126.541665),
        zoom: 13
    });
    //添加监听事件  获取鼠标单击事件
    qq.maps.event.addListener(map, 'click', function(event) {
      var marker=new qq.maps.Marker({
                position:event.latLng,
                map:map
          });   
       var va = event.latLng.getLat() + ',' +event.latLng.getLng();
		addrmsg(va);
      qq.maps.event.addListener(map, 'click', function(event) {
            marker.setMap(null);     
    });
    });
}
var addrse;
function addrmsg(addr){
	      var data={
	      　　　　　　location:addr,
	               /*key*/
	      　　　　　　key:"VVOBZ-JXDCK-DBSJ7-AXHWL-SX4ZZ-76F5L",
	     　　　　　　get_poi:0    
	      　　　　}
	      var url="http://apis.map.qq.com/ws/geocoder/v1/?";
	      data.output="jsonp";  
	      $.ajax({
	         type:"get",
	        dataType:'jsonp',
	         data:data,
	        jsonp:"callback",
	        jsonpCallback:"QQmap",
	         url:url,
	        success:function(json){
	            console.log(json.result.address)
	            parent.showAddr(json.result);
	            var index=parent.layer.getFrameIndex(window.name); //获取当前窗口的name
	            parent.layer.close(index);
	         },
	         error : function(err){alert("服务端错误，请刷新浏览器后重试")}
	      })
}


