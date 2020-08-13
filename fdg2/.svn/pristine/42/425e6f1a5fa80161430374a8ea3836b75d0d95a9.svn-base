// pages/servers/guanai/map/map.js
const App = getApp()
var QQMapWX = require('../../../../utils/qqmap-wx-jssdk')
var qqmapsdk
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: [{
      txt: "康复机构",
      keyword: "康复机构"
    }, {
      txt: "培训机构",
      keyword: "培训机构"
    }, {
      txt: "托养机构",
      keyword: "托养机构"
    }, {
      txt: "爱心机构",
      keyword: "爱心机构"
    }, {
      txt: "附近餐厅",
      keyword: "餐厅"
    }, {
      txt: "附近医院",
      keyword: "医院"
    }, {
      txt: "附近超市",
      keyword: "超市"
    }, ],
    map: {
      latitude: 45.684075,
      longitude: 126.564175,
      markers: [{
        id: 1,
        width: "70rpx",
        height: "70rpx",
        latitude: 45.684075,
        longitude: 126.564175,
        iconPath: '/image/map/postion.png'
      }]
    },
    fujin: "",
    isTrue: false,

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    let lat = 'map.latitude'
    let lng = 'map.longitude'
    let lat_marker = 'map.markers[0].latitude'
    let lng_marker = 'map.markers[0].longitude'
    console.log(JSON.stringify(options) == '{}')
    if (JSON.stringify(options) == '{}') {
      //判断是否为第一次进入而没点击过其他组件
      wx.getLocation({
        type: "gcj02 ",
        success: (res) => {
          console.log(res)

          this.setData({
            [lat_marker]: res.latitude,
            [lng_marker]: res.longitude,
            [lat]: res.latitude,
            [lng]: res.longitude
          })
        }
      })
    } else {
      
      //是有子组件进行定位的 options.pos 为坐标
      let res = JSON.parse(options.pos)
      console.log(res)
      this.setData({
        [lat_marker]: res.lat,
        [lng_marker]: res.lng,
        [lat]: res.lat,
        [lng]: res.lng
      })
    }

    this.setData({
      height: App.globalData.navHeight
    })
  },
  next(e) {
    let data = e.currentTarget.dataset.msg
    this.setData({
      isTrue: false
    })
    wx.navigateTo({
      url: `./mapMes/mapMes?data=${data}`,
    })

  },
  change() {
    let isTrue = !this.data.isTrue
    this.setData({
      isTrue: isTrue
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