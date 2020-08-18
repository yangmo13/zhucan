// pages/servers/guanai/literature/literaMes/literaMes.js
const App =getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:{
      topic:"哈尔滨市开展助残日系列活动",
      src:"http://222.32.73.38:8180/fdp/images/1_1_2_2_%E6%8C%87%E5%AF%BC%E6%B4%BB%E5%8A%A8%E8%AF%A6%E6%83%85-%E5%85%B6%E4%BB%96/u681.svg",
      state:{
        apply:"报名未开始",
        date:"2020-05-30",
        time:"13:00~15:00"
      },
      txt:'<p>1</p><p>1</p><p>1</p><p>1</p><p>1</p>'
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height:App.globalData.navHeight
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