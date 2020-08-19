// pages/servers/guanai/star/star.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
      arr:[
        {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },  {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },  {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },  {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },  {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },  {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },  {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },  {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },  {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },  {
          src:"/image/other/u3396.svg",
          name:"姓名"
        },
      ],
      isloading:false
  },
  next(e){
    let msg = e.currentTarget.dataset.msg
    wx.redirectTo({
      url: `./starMes/starMes?msg=${msg}`,
    })

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height:App.globalData.navHeight
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
    console.log(1515)
    this.setData({
      isloading:true
    })
    //下拉加载事件
    let arr = []
    setTimeout(()=>{
      for(var i = 0;i<10;i++){
        arr.push({
          src:"/image/other/u3396.svg",
          name:`${i}name`
        })
      }
      let arr2  = this.data.arr
      arr2 = arr2.concat(arr)
      this.setData({
        arr:arr2,
        isloading:false
      })
    },1500)
    console.log(this.data.arr)
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})