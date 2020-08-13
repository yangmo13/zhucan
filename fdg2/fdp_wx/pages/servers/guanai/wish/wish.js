// pages/servers/guanai/wish/wish.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    num:1,
    list:[
    ],
    //模拟数据
    arr1:[
      {
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },
      {
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },
      
    ],
    arr2:[
      {
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },{
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },{
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },{
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },
      {
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },{
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },
      {
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },{
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },
      {
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },{
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },
    ],
    arr3:[
      {
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },{
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },{
        txt:"一台电饭煲",
        name:"康*候",
        start:"2020-05-22",
        end:"2020-05-22"
      },
    ]
  },
  changeList(e){
    let num = e.currentTarget.dataset.num
  let data =this.data['arr'+num]
    console.log(data)
    this.setData({
      num:num,
      list:data
    })
  },
  next(){
    let claim = this.data.num
    wx.navigateTo({
      url: `./wishMes/wishMes?claim=${claim}`,
    })
  },
  wishLogin(){
    wx.navigateTo({
      url: './wishLogin/wishLogin',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let arr1 =this.data.arr1
    this.setData({
      height:App.globalData.navHeight,
      list:arr1
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