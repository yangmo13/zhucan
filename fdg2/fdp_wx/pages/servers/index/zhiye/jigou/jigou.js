// pages/servers/index/zhiye/jigou/jigou.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew:false,
    height:"",
    arr:[
      {
        name:"哈尔滨医科大学附属第一医院",
        face:[
          "肢体","听力","视力"
        ],
        txt:"哈尔滨医科大学附属第一医院于1949年，总建筑面积已达60万余平方米，总床位6496张，下设血液肿瘤.哈尔滨医科大学附属第一医院于1949年，总建筑面积已达60万余平方米，总床位6496张，下设血液肿瘤.哈尔滨医科大学附属第一医院于1949年，总建筑面积已达60万余平方米，总床位6496张，下设血液肿瘤.",
        pos:"哈尔滨市南岗区邮政街23号",
        relation:"张医生 0451-53670428",
        src:"../../../../../image/head.png",
        url:"./xiangqing/xiangqing"
      },
      {
        name:"哈尔滨医科大学附属第一医院",
        face:[
          "脑力","动力","视力"
        ],
        txt:"哈尔滨医科大学附属第一医院于1949年，总建筑面积已达60万余平方米，总床位6496张，下设血液肿瘤.哈尔滨医科大学附属第一医院于1949年，总建筑面积已达60万余平方米，总床位6496张，下设血液肿瘤.哈尔滨医科大学附属第一医院于1949年，总建筑面积已达60万余平方米，总床位6496张，下设血液肿瘤.",
        pos:"哈尔滨市南岗区邮政街23号",
        relation:"张医生 0451-53670428",
        src:"../../../../../image/head.png"
      },
      {
        name:"哈尔滨医科大学附属第一医院",
        face:[
          "肢体","听力","视力"
        ],
        txt:"哈尔滨医科大学附属第一医院于1949年，总建筑面积已达60万余平方米，总床位6496张，下设血液肿瘤.哈尔滨医科大学附属第一医院于1949年，总建筑面积已达60万余平方米，总床位6496张，下设血液肿瘤.哈尔滨医科大学附属第一医院于1949年，总建筑面积已达60万余平方米，总床位6496张，下设血液肿瘤.",
        pos:"哈尔滨市南岗区邮政街23号",
        relation:"张医生 0451-53670428",
        src:"../../../../../image/head.png"
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height:App.globalData.navHeight
    })
  },
  next(e){
    let url =e.currentTarget.dataset.url
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