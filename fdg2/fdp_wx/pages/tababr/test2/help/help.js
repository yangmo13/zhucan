// pages/tababr/test2/help/help.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
arr:[
  {
    topic:"法律咨询",
    question:"一方或者双方是残障人士，能结婚么?",
    state:"未解决",
    date:"2020-05-13"
  },{
    topic:"党群心连心",
    question:"一方或者双方是残障人士，能结婚么?",
    state:"解决中",
    date:"2020-05-13"
  },{
    topic:"生活资讯",
    question:"残障人士就业形式有哪些?",
    state:"已解决",
    date:"2020-05-13"
  },{
    topic:"生活资讯",
    question:"残障人士就业形式有哪些?",
    state:"已关闭",
    date:"2020-05-13"
  }
],
isloading:2
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
    console.log("到300出发上拉加载")
  },  

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})