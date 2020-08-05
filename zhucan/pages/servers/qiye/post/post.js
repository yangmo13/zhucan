// pages/servers/qiye/post/post.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    height: 0,
    arr:{
      post_name:"爱心生产、行政后勤岗位",
      salary:"4000-8000",
      company_name:"广顺电子有限公司",
      company_major:"计算机、通信和其他电子设备制造业",
      company_label:[
        "20-99人",
        "私企",
        "互联网"
      ],
      demand:[
        "学历不限","经历不限","吃苦耐劳"
      ],
      date:"2020-05-20",
      position:"哈尔滨",
      post_describe:[
        "1、18~45岁优先，持残疾人证",
        "2、能够配合加班",
        "3、包吃住，年薪4万~7万（同工同酬)"
      ],
      trait:[
        "五险一金",
        "法定假日",
        "午餐",
        '包吃' ,
      "包住"     ]
    }
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