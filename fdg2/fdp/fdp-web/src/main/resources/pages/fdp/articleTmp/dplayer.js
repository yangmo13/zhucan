/**\
 * player
 * @param url 视频地址 *必填项
 * @param auto 是否自动播放 默认 false
 * @param id 容器id 默认 dplayer
 * @returns dp播放器实例
 * 郭翔宇
 */
function Player(url, auto, id) {
	// 默认约定
	if (url == undefined)return false;
	if (id == undefined)id = "dplayer";
	if (auto == undefined)auto = false;
	const dp = new DPlayer({
		container : document.getElementById(id),
		preload : 'auto',//视频预加载,如果无视频封面图片则开启预加载,默认会显示第一帧内容
		lang : 'zh-cn',//语言
		autoplay : auto,//自动播放
		video : {
			url : url,//地址
			type : 'hls'//类型 hls 为m3u8类型,也可以加载其他类型例如mp4
		}
	});
	return dp;
}
