// pages/servers/guanai/trip/tripMes/tripMes.js

const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    arr: [{
      txt: "想帮助他人，看看微心愿",
      url: "../../wish/wish",
    }, {
      txt: "看看我接取了哪些爱心出行",
      url: "../trip",
    }, {
      txt: "了解一下残疾人相关政策法规",
      url: "../../wish/wish",
    }, ],
    details:{
      from:"香港区政府",
      address:"香坊区残联",
      date:"07-17",
      time:"10:00",
      num:"3",
      level:"二级残疾",
      phone:'18045478936',
      trip:true
    }
  },
  // 拨打电话
  makePhoneCall(){
    //获取电话号码
    let num = this.data.details.phone
    console.log(num,666)
    wx.makePhoneCall({
      phoneNumber: `${num}`,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height: App.globalData.navHeight
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