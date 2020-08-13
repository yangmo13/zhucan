const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    height: "",
    lunbo: [{
      url: "../../../image/banner22.jpg",
      msg: "通知公告"
    }, {
      url: "../../../image/banner22.jpg",
      msg: "工作动态"
    }, {
      url: "../../../image/banner22.jpg",
      msg: "政策法规"
    }, {
      url: "../../../image/banner22.jpg",
      msg: "党建工作"
    }, {
      url: "../../../image/banner22.jpg",
      msg: "组织机构"
    }],
    daohang: [{
      src: "../../../image/u2094.png",
      msg: "通知公告",
      url:"./notice/notice"
    }, {
      src: "../../../image/u2095.png",
      msg: "工作动态",
      url:"./workingcondition/workingcondition"
    }, {
      src: "../../../image/u2096.png",
      msg: "政策法规",
      url:"./policy/policy"
    }, {
      src: "../../../image/u2095.png",
      msg: "党建工作",
      url:"./partybuild/partybuild"
    }, {
      src: "../../../image/u250.png",
      msg: "组织机构",
      url:"./organization/organization"
    }],
    arr: [{
      id:"1",
      msg: "关于开展“温馨工程”杯身残志坚脱贫攻坚——残疾人云端",
      time: "16点22分",
      url: "",
    }, {
      msg: "工作动态",
      time: "16点22分",
      url: "",
    }, {
      msg: "政策法规",
      time: "16点22分" ,
      url: "",
    }, {
      msg: "通知公告组织机构组织机构组织机构组织机构组织机构组织机构组织机构组织机构组织机构",
      time: "16点22分",
      url: ""
    }, {
      msg: "组织机构",
      time: "16点22分",     
      url: ""
    }],
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

  next(e){
    let url = e.currentTarget.dataset.url
    console.log(JSON.stringify(url))
    wx.navigateTo({
      url: `${url}`,
    })
  },
  // 加载更多、通知公告
  morenotice(e) {
    console.log(e.currentTarget.dataset)
    let key = e.currentTarget.dataset
    wx.navigateTo({
      url: `./notice/notice?key=${key}`,
    })
  },
  // 更新公告详情
  noticeXiangqing(e) {
    console.log(e.currentTarget.dataset)
    let key = e.currentTarget.dataset
    wx.navigateTo({
      url: `./notice/details/details?key=${key}`,
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