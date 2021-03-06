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
   wx.getLocation({
     altitude: 'altitude',
     success:(res)=>{
       console.log(res)
       let lat = res.latitude
       let long = res.longitude
       wx.request({
         url: `https://devapi.heweather.net/v7/weather/now?location=${long},${lat}&key=7cd711ae8fb24043b1294a4b9dfe570b`,
         success:(res)=>{
           console.log(res,'天气')
         }
       })
     }
   })
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