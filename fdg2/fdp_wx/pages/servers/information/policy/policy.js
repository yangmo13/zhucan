// 政策法规
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    height: "",
    arr: [{
      id:"1",
      msg: "哈尔滨残疾人及特困残疾人子女接受中高等教育和培训资助办法",
      time: "2020-5-22",
      policy: "市发规",
    }, {
      msg: "工作动态",
      time: "2020-5-22",
      policy: "市发规",
    }, {
      msg: "哈尔滨残疾人及特困残疾人子女接受中高等教育和培训资助办法",
      time: "2020-5-22",
      policy:"市发规"
    }, {
      msg: "党建工作",
      time: "2020-5-22",
      policy: "市发规",
    }, {
      msg: "哈尔滨残疾人及特困残疾人子女接受中高等教育和培训资助办法",
      time: "2020-5-22",
      policy: "市发规市发规"
    },
    {
      msg: "哈尔滨残疾人及特困残疾人子女接受中高等教育和培训资助办法-帮帮我",
      time: "2020-5-22",
      policy: "市发规"
    },],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height: App.globalData.navHeight
    })
    wx.showTabBar({
      animation: true,
      success: (res) => {
        console.log(res)
      },
      fail: (err) => {
        console.log(err)
      }
    })
  },
  noticeXiangqing(e) {
    console.log(e.currentTarget.dataset)
    let key = e.currentTarget.dataset
    wx.navigateTo({
      url: `./details/details?key=${key}`,
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