// pages/servers/index/index.js
const App = getApp()
Page({
        
  /**
   * 页面的初始数据
   */
  data: {
    height:"",
      daohang:[
        {
          src:"../../../image/u211.png",
          msg:"职业康复",
          url:"./zhiye/zhiye"
        },  {
          src:"../../../image/u238.png",
          msg:"就业培训",
          url:"./peixun/peixun"
        },  {
          src:"../../../image/u242.png",
          msg:"就业服务",
          url:"../qiye/qiye"
        },  {
          src:"../../../image/u246.png",
          msg:"托养服务"
        },  {
          src:"../../../image/u250.png",
          msg:"业务指南",
          url:"./zhinan/zhinan"
        },  {
          src:"../../../image/u254.png",
          msg:"示范体验",
          url:"./zhiye/tiyan/tiyan"
        },  {
          src:"../../../image/u258.png",
          msg:"康复活动", url:"./zhiye/zhidao/zhidao"
        },  {
          src:"../../../image/u262.png",
          msg:"辅具展示",
          url:"./qiju/qiju"
        },  {
          src:"../../../image/u266.png",
          msg:"康复机构",
          url:"./zhiye/jigou/jigou"
        },
      ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height:App.globalData.navHeight
    })
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
  next(e){
    let url = e.currentTarget.dataset.url
    wx.navigateTo({
      url: `${url}`,
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