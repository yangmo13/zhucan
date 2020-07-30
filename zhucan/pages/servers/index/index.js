// pages/servers/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      daohang:[
        {
          url:"../../../image/u211.png",
          msg:"职业康复"
        },  {
          url:"../../../image/u238.png",
          msg:"就业培训"
        },  {
          url:"../../../image/u242.png",
          msg:"就业服务"
        },  {
          url:"../../../image/u246.png",
          msg:"托养服务"
        },  {
          url:"../../../image/u250.png",
          msg:"业务指南"
        },  {
          url:"../../../image/u254.png",
          msg:"康复资料"
        },  {
          url:"../../../image/u258.png",
          msg:"康复活动"
        },  {
          url:"../../../image/u262.png",
          msg:"辅具展示"
        },  {
          url:"../../../image/u266.png",
          msg:"康复机构"
        },
      ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.showTabBar({
      animation: true,
      success:(res)=>{
        console.log(res)
      },
      fail:(err)=>{
        console.log(err)
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