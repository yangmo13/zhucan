// pages/servers/index/fuwu/qiye/qiye.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    height: 0,
    keyword:"",
    show:true,
    value:"",
    arr: [
      {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: true
      },
      {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: false
      },
       {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: true
      }, {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: false
      }, {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: false
      }, {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: false
      }, {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: false
      }, {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: false
      }, {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: false
      }, {
        post: "爱心生产、行政后勤",
        condition: [
          "30-35岁",
          "学历不限",
          "经验不限"
        ],
        salary: "4000-6000",
        date: "2020-05-22",
        welfare: [
          "五险一金",
          "节日福利",
          "包吃包住",
          "啤酒节"
        ],
        name: "广顺电子有限公司",
        recommend: false
      },
    ]
  },
  nextXiangqing(e){
      console.log(e.currentTarget.dataset)
      let key =e.currentTarget.dataset
      wx.navigateTo({
        url: `./post/post?key=${key}`,
      })
  },
  search(){
    // let keyword = this.data.keyword
    this.setData({
      show:false
    })
    setTimeout(()=>{
      this.setData({
          show:true,
          value:""
      })

    },2000)

  },
  changeKyWord(e){
    console.log(e.detail.value)
    this.setData({
        keyword:e.detail.value
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