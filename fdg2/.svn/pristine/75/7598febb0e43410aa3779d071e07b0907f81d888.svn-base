// pages/servers/guanai/trip/tripMes/mapDetails/mapDetails.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    map: {
      latitude: 0,
      longitude: 0,
      markers: [{
        id: 1,
        width: "70rpx",
        height: "70rpx",
        latitude: 45.684075,
        longitude: 126.564175,
        iconPath: '/image/map/postion.png'
      }]
    },
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height: App.globalData.navHeight
    })
    let lat = ''
    let lng =""
    wx.getLocation({
      altitude: 'altitude',
      success:(res)=>{
        console.log(res)
   
        this.setData({
          ['map.latitude'] : res.latitude,
          ['map.longitude'] :res.longitude,
          
        })
      }

    })
    console.log(this.data,'Data')
    wx.openLocation({
      latitude: this.data.map.latitude,
      longitude: this.data.map.longitude,
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