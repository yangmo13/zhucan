// pages/identification/identification.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ishow: true,
    id_num: 0,
    img1: "",
    img2: "",
    img3: "",
    isbtn: false,
    xiangce_img: "",
    height:"",
    // 是否翻转
    isTran: "back",
    isback:false


  },
  fanzhun(){
    let tran = this.data.isTran
    tran=='back'?tran="front":tran="back"
    this.setData({
      isTran:tran
    })
  },
  next(e){
    let url = e.currentTarget.dataset.url
    wx.navigateTo({
      url: `${url}`,
    })
  },
  onResize:function(){
    console.log("屏幕发生转动")
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
    this.setData({
      height:App.globalData.navHeight
    })
    this.ctx = wx.createCameraContext()
  },
  takexiangce() {
    let num = this.data.id_num
    let img_num = 'img'+num

    console.log(img_num,5454)
       wx.chooseImage({
         count: 1,
         sizeType: ['original', 'compressed'],
         sourceType: ['album', 'camera'],
         success: (res) => {
           this.setData({
             [img_num]: res.tempFilePaths[0],
             ishow:true   
           })
        
      }
    })
  },
  takePhoto() {
    var that = this
    let src1 = that.data.img1
    let num = this.data.id_num
    let src2 = that.data.img2
    let src3 = that.data.img3

    if (num == 1) {
      this.ctx.takePhoto({
        quality: "high",
        success: (res) => {
          let src = res.tempImagePath;
          this.setData({
            img1: src,
            ishow: true
          })
          if (that.data.img1 != '' && that.data.img2 != '' && that.data.img3 != '') {
            this.setData({
              isbtn: false
            })
          }


        }
      })
    } else if (num == 2) {
      this.ctx.takePhoto({
        quality: "high",
        success: (res) => {
          let src = res.tempImagePath;
          this.setData({
            img2: src,
            ishow: true
          })
          if (that.data.img1 != '' && that.data.img2 != '' && that.data.img3 != '') {
            this.setData({
              isbtn: false
            })
          }

        }
      })
    } else {
      this.ctx.takePhoto({
        quality: "high",
        success: (res) => {
          let src = res.tempImagePath;
          this.setData({
            img3: src,
            ishow: true
          })
          if (that.data.img1 != '' && that.data.img2 != '' && that.data.img3 != '') {
            this.setData({
              isbtn: false
            })
          }

        }
      })
    }
  },
  getAdd(e){
    console.log(e.detail)
    this.setData({
      ishow:e.detail
    })
  },
  go_camera(e) {
    let num = e.currentTarget.dataset.camera;
    console.log(num)
    this.setData({
      ishow: false,
      id_num: num,
      isback:true
    })


  },
  shibie() {
    let img1 = JSON.stringify(this.data.img1)
    let img2 = JSON.stringify(this.data.img2)
    let img3 = JSON.stringify(this.data.img3)
    let data = {
      "name": "刘铁柱",
      'idcard': "230103199708305714",
      "navtivePlace": "黑龙江",
      "age": "66",
      "nation": "汉族",
      "marital": "已婚",
      "education": "小学",
      "localtion": "楼下",
      "address": "不搞牛"
    }
    let data1 = JSON.stringify(data)
    wx.navigateTo({
      url: `../shibie/index?img1=${img1}&img2=${img2}&img3=${img3}&data=${data1}`
    })
  },

  goback() {
    this.setData({
      ishow: true
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