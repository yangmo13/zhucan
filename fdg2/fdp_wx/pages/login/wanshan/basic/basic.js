// pages/login/wanshan/basic/basic.js
const App = getApp()
import AppUtil from "../../../../utils/util.js"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew: true,
    //是否完成保存
    allowNext: false,
    //判断文字是否为正确
    iswrong: '',
    test_name: '',
    test_idcard: '',
    test_phone: '',
    test_local:'',
    must:'',
    height: 0,
    ok: true,
    form: {
      // 姓名
      'name': '',
      // 身份证
      'idcard': "",
      // 参加工作时间
      'job_time': "",
      // 现居住城市
      'city': "哈勒滨",
      // 手机号码,
      'phone': "",
    },
    'old_form': ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    let data = JSON.parse(options.form)
    let form = this.data.form
    Object.keys(form).forEach(key => {
      form[key] = data[key]
    })
    this.setData({
      height: App.globalData.navHeight,
      form: form,
      old_form: data
    })
    this.yanzheng()
    console.log(
      this.data.form
    )
  },
  iptBlur(e) {
    let name = 'form.' + e.currentTarget.dataset.name
    let test = e.currentTarget.dataset.test
    let data = AppUtil.test(e.detail, test)
    console.log(test, "data")
    console.log(data)

    if (data != '') {
      this.setData({
        allowNext: false,
        [test]: data
      })
    } else {
      this.setData({
        [name]: e.detail,
        [test]: data
      })
    }
  },
  yanzheng(){
    //找到所有必选项 将其发送到utils 进行验证
    //找到其它选项 发送到验证
    let name = this.data.form.name
    let form = this.data.form

    Object.keys(form).forEach(key=>{
     
      if(key =='name'){
        let name = 'test_name'
        let data = AppUtil.test(form[key], name)
        this.setData({
          [name]:data
        })
      }else if(key =='idcard'){
        let name = 'test_idcard'
        let data = AppUtil.test(form[key],name)
        this.setData({
          [name]:data
        })
      }else if(key =='phone'){
        let name = 'test_phone'
        let data = AppUtil.test(form[key],name)
        this.setData({
          [name]:data
        })
      }else if(key =='city'){
        let name = 'test_local'
        let data = AppUtil.test(form[key], name)
        console.log(data,"local")
        this.setData({
          [name]:data
        })
      }
    })

  },
  next() {
    let test_name = this.data.test_name
    let test_idcard = this.data.test_idcard
    let test_phone = this.data.test_phone
    let test_local = this.data.test_local
    let new_form = this.data.old_form
    let data = this.data.form

    Object.keys(new_form).forEach(key => {
      if (data[key]) {
        new_form[key] = data[key]
      }



    })

    this.setData({
      old_form: new_form
    })

    let form = JSON.stringify(this.data.old_form)
    if (test_name == '' && test_idcard == '' && test_phone == ''&&test_local=='') {
      wx.redirectTo({
        url: `../index?form=${form}`,
      })
    } else {
      wx.showModal({
        cancelColor: 'cancelColor',
        title: "错误提醒",
        content: "信息不正确或者为空，请仔细审查"
      })
    }


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