// pages/servers/guanai/weather/weather.js
const myAudio = wx.createInnerAudioContext({})
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  play(){
   
    
    let isplay =!this.data.isplay
    this.setData({
      isplay:isplay
    })
    if(this.data.isplay==true){
      myAudio.play()
    }else{
      myAudio.pause()
    }
    console.log(myAudio.duration);
  },
  onLoad: function (options) {
    myAudio.src='http://ws.stream.qqmusic.qq.com/C4000032jIGk4F2Ebe.m4a?guid=4443622582&vkey=3F8B45ED652B3744C6BB56825914E49BFA1D66FEB737DD4CDCBF1BFF6FA2669A048A90C8B9774219D14408378B9C71BEE750EED71212C99A&uin=508&fromtag=66'
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})