// pages/servers/qiye/post/post.js
const App = getApp()
import appUtil from '../../../../utils/util'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    height: 0,
    finished: "false",
    loadingShow: false,
    arr: {
      post_name: "爱心生产、行政后勤岗位",
      salary: "4000-8000",
      company_name: "广顺电子有限公司",
      company_major: "计算机、通信和其他电子设备制造业",
      company_label: [
        "20-99人",
        "私企",
        "互联网"
      ],
      demand: [
        "学历不限", "经历不限", "吃苦耐劳"
      ],
      date: "1591403039",
      position: "哈尔滨",
      post_describe: [
        "1、18~45岁优先，持残疾人证",
        "2、能够配合加班",
        "3、包吃住，年薪4万~7万（同工同酬)"
      ],
      trait: [
        "五险一金",
        "法定假日",
        "午餐",
        '包吃',
        "包住"
      ]
    }
  },
  send() {

    let finished = this.data.finished
    if (finished == true) {
      console.log("已经完成简历")
    } else {
      wx.showModal({
        cancelColor: 'cancelColor',
        title: "简历检测",
        content: "检测到您未完成简历，前往完善?",
        success: (res) => {


          if (res.confirm == true) {
            console.log("去完成简历")
            wx.navigateTo({
              url: '/pages/login/shibie/index',
            })
          } else {
            console.log("不去完成简历")
          }

        }
      })
    }
  },

  /**s
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height: App.globalData.navHeight,
      loadingShow:true
    })
  setTimeout(()=>{
  
    //请求数据
    //数据传来的时间
    let time = this.data.arr.date
    //将时间处理为规定格式
    let date = appUtil.time(time)
    
    let data = 'arr.date' 
    wx.nextTick(() => {
      this.setData({
        [data]: date,
        loadingShow:false
      })
    })
    console.log(this.data.arr)
  },1000)

    
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