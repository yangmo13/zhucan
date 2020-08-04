// pages/login/wanshan/jingli/jingli.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    old_form:{},
   
    form:{
      //培训机构
      'organization': "",
    //培训开始
    'peixun_start':"",
    //培训结束
    'prixun_end':"",
      //培训专业
      'major': '',
      //证明人
      'certifier': "",
      //证明人手机
      'certifier_phone': "",

    },
    height: 0,
    isnew:true
  },
  valueChange(e){
    this.setData({
      [e.currentTarget.dataset.msg]:e.detail
    })
    console.log(this.data.form,5555)
  },
  change(e){

    if(e.detail.value[0]){
      let recruitment = 'form.recruitment'
     this.setData({
       [recruitment]:"统招"
     })
    }else{
      let recruitment = 'form.recruitment'
      this.setData({
        [recruitment]:"非统招"
      })
    }
    console.log(this.data.form)
  },
  xialaChange(e){
    console.log(111111)
  },

  iptChnage(e){
    let msg = e.currentTarget.dataset.msg
    let start ='form.peixun_start'
    let end ='form.prixun_end'
    if(e.detail.start){
      this.setData({
        [start]:e.detail.start,
        [end]:e.detail.end,
      })
    }else{
      this.setData({
     
        [msg]:e.detail
      })
    }

    console.log(this.data.form)
    
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let data =JSON.parse( options.form)
    let form = this.data.form
  
      Object.keys(form).forEach(key=>{
        form[key]=data[key]
      })
    this.setData({
      height: App.globalData.navHeight,
      form:form,
      old_form:data
    })
    
  },
  next(){
    let new_form = this.data.old_form
    let data =this.data.form
    Object.keys(new_form).forEach(key=>{
      if(data[key]){
        new_form[key]=data[key]
      }
      
    })

    this.setData({
      old_form:new_form
    })

    let form = JSON.stringify(this.data.old_form)
    console.log(form)
    wx.redirectTo({
      url: `../index?form=${form}`,
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