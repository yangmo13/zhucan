// pages/servers/guanai/map/mapMes/mapMes.js
var QQMapWX = require('../../../../../utils/qqmap-wx-jssdk')
var qqmapsdk
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    arr: [{
      title: "黑皮肘子锅包肉（赣水路分店）",
      tel: "0451-898825565",
      address: "黑龙江省哈尔滨市香坊区赣水路222-21"
    }, {
      title: "黑皮肘子锅包肉（赣水路分店）",
      tel: "0451-898825565",
      address: "黑龙江省哈尔滨市香坊区赣水路222-21"
    }, {
      title: "黑皮肘子锅包肉（赣水路分店）",
      tel: "0451-898825565",
      address: "黑龙江省哈尔滨市香坊区赣水路222-21"
    }, {
      title: "黑皮肘子锅包肉（赣水路分店）",
      tel: "0451-898825565",
      address: "黑龙江省哈尔滨市香坊区赣水路222-21"
    }, {
      title: "黑皮肘子锅包肉（赣水路分店）",
      tel: "0451-898825565",
      address: "黑龙江省哈尔滨市香坊区赣水路222-21"
    }, {
      title: "黑皮肘子锅包肉（赣水路分店）",
      tel: "0451-898825565",
      address: "黑龙江省哈尔滨市香坊区赣水路222-21"
    }, ],
    keyword: "",
    isshow:false
  },
  next(e) {
    let data = e.currentTarget.dataset.location
    data =JSON.stringify(data)
    wx.redirectTo({
      url: `../map?pos=${data}`,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options, 666)
    if (options.data == '餐厅' || options.data == '医院' || options.data == '超市') {
      this.setData({
        keyword: options.data
      })
      qqmapsdk = new QQMapWX({
        key: "FXIBZ-4FUA6-V65S5-MBRLZ-2PKOF-HZB74"
      })
    } else {
      console.log("搜索机构")
      this.setData({
        isshow:true
      })
    }
    this.setData({
      height: App.globalData.navHeight
    })
  },
  onPullDownRefresh(){
    console.log(1)
  },
  onReachBottom(){
    console.log(2)
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

    qqmapsdk.search({
      keyword: this.data.keyword,
      success: (res) => {
        console.log(res)
        this.setData({
          arr: res.data,
          isshow:true
        })
      }
    })
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