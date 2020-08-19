// pages/tababr/test2/wish/wish.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    arr: [{
      name: "一台电饭煲",
      state: "待审核",
      start: "2020-05-13",
      end: "2020-06-13"
    }, {
      name: "一条春秋被",
      state: "认领中",
      start: "2020-05-13",
      end: "2020-06-13"
    }, {
      name: "一条春秋被",
      state: "认领中",
      start: "2020-05-13",
      end: "2020-06-13"
    }, {
      name: "一条春秋被",
      state: "认领中",
      start: "2020-05-13",
      end: "2020-06-13"
    }, {
      name: "一条春秋被",
      state: "认领中",
      start: "2020-05-13",
      end: "2020-06-13"
    }, {
      name: "一条春秋被",
      state: "认领中",
      start: "2020-05-13",
      end: "2020-06-13"
    }, {
      name: "一条春秋被",
      state: "认领中",
      start: "2020-05-13",
      end: "2020-06-13"
    }, {
      name: "一条春秋被",
      state: "认领中",
      start: "2020-05-13",
      end: "2020-06-13"
    }],
    num: 0,
    isloading: 0
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
    let num = this.data.num
    let list = this.data.arr
    let arr = []
    num++
    if (num < 5) {
     setTimeout(()=>{
      for (var i = 0; i < 6; i++) {
        arr.push({
          name: `一条哈森${i}`
        })
      }
      list = list.concat(arr)
      this.setData({
        num: num,
        arr: list,
        isloading: 1
      })
     },1500)
    } else {
      this.setData({
        isloading: 2
      })
    }
    console.log(num)
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})