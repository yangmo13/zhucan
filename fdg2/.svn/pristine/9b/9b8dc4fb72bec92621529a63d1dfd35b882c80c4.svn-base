// pages/servers/index/zhiye/zhiye.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   * 
   */
  data: {
      isNew:true,
      height:"",
      top_arr:[
        {
          src:"../../../../image/u280.png",
          txt:"康复服务机构",
          url:"./jigou/jigou"
        },
        {
          src:"../../../../image/u283.png",
          txt:"康复指导",
          url:"./zhidao/zhidao"
        },
        {
          src:"../../../../image/u286.png",
          txt:"示范体验",
          url:"./tiyan/tiyan"
        },
        {
          src:"../../../../image/u289.png",
          txt:"辅具展示"
        },
        {
          src:"../../../../image/u292.png",
          txt:"远程诊疗"
        },
        {
          src:"../../../../image/u295.png",
          txt:"心里咨询"
        },

      ],
      video_list:[
        {
          src:"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400",
          text:"精神残疾沟通及适应训练"
        },
        {
          src:"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400",
          text:"视觉功能训练"
        },{
          src:"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400",
          text:"挖偶"
        }
      ]
  },
  tiaozhuan(){
    wx.navigateTo({
      url: '../../../../compation/header/index',
    })
  },
  next(e){
    let url = e.currentTarget.dataset.url
    wx.navigateTo({
      url: `${url}`,
    })
  },
  change(){
    let yes =! this.data.isNew
    this.setData({
      isNew:yes
    })
    console.log(this.data.isNew)

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height:App.globalData.navHeight
    })
      let  menu = wx.getMenuButtonBoundingClientRect()
      console.log(menu)
      wx.getSystemInfo({
        success: (res) => {console.log(res,545545)},
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