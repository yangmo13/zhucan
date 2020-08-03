// pages/login/shibie/index.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    height:"",
    form: {
      "name": "",
      //身份证号
      "idcard": "",
      //性别
      "sex":"",
      //籍贯
      "nativePlace": "",
      //年龄
      'age':'',
      //民族
      "nation": "",
      //婚否
      "marital": "",
      //学历
      "education": "",
      //身份证户籍地
      "localtion": "",
      //现居住地
      "address": "",
      //手机号
      "phone": "",
     
      //户口类型,
      "registered": "",
      //联系人信息，
      "linkman": {
        "name": "",
        //与其关系
        "relation": "",
        //联系电话
        "phone": ""
      },
      //工作信息，
      "work": {
        //工作单位
        "company": "",
        //工种
        "profession": "",
        //单位性质
        "unit": "",
        //是否福利企业
        "weal": "",
        //工作年龄
        'workTime':"",
        //求职意向
        'purpose':"",
        //薪资
        'pay':"",
        //期望工作地点
        'workplace':"",
        //期望岗位
        'station':""

      },
      //残疾证信息
      "disabled": {
        //残疾证号码
        "num": "",
        //残疾证类型
        "type": [],
        //残疾等级
        "level": "",
        //残疾证有效日期
        "date": ""
      }
    },
    form2: [],

    //新消息
    isNew: false,
    // 籍贯
    jiguan: [
      "汉族", "满族", "回族"
    ],
    // 婚否
    hunfou: [
      "未婚", "已婚", "丧偶", "离异"
    ],
    // 户口
    hukou: [{
        value: "农业户口",
        txt: "农业",
      },
      {
        value: "非农业户口",
        txt: "非农业",
      }
    ],
    // 关系
    guanxi: [
      "夫妻", "父子", "母子", "父女", "母女", "其他"
    ],
    fuli: [{
        value: "福利企业",
        txt: "是"
      },
      {
        value: "非福利企业",
        txt: "否"
      }
    ],
    // 学历
    xueli: [
      "无",
      "小学",
      "初中",
      "高中",
      "中专",
      "职高",
      "高职",
      "本科",
      "硕士",
      "博士"
    ],
    // 残疾证
    canjizheng: [{
      value: "视力残疾",
      txt: "视力残疾"
    }, {
      value: "听力残疾",
      txt: "听力残疾"
    }, {
      value: "言语残疾",
      txt: "言语残疾"
    }, {
      value: "肢体残疾",
      txt: "肢体残疾"
    }, {
      value: "智力残疾",
      txt: "智力残疾"
    }, {
      value: "精神残疾",
      txt: "精神残疾"
    }, {
      value: "其他",
      txt: "其他"
    }, ],
    //单位性质
    danwei: ["国企", "外商投资", "合资", "民营", "股份制企业", "上市公司", "上市公司", "国家机关", "事业单位", "银行", "医院", "学校/下级学院", "律师事务所", "社会团体", "其他"],
    //残疾等级
    level: [

      {
        value: "一级",
        txt: "一级"
      }, {
        value: "二级",
        txt: "二级"
      }, {
        value: "三级",
        txt: "三级"
      }, {
        value: "其他",
        txt: "其他"
      },
    ],

    jiguan_show: false,
    minzu_txt: "",
    hunfou_show: false,
    hunfou_txt: "",
    xueli_show: false,
    xueli_txt: "",
    guanxi_show: false,
    guanxi_txt: "",
    danwei_show: false,
    danwei_txt: ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let data =JSON.parse(options.data)
    let form = this.data.form
    Object.keys(form).forEach(key=>{
      if(data[key]){
        form[key]=data[key]
      }
    })
    this.setData({
      height:App.globalData.navHeight,
      form:form
    })

console.log(this.data.form,"obj")
    

    this.setData({
      form2:data
    })
    console.log(this.data.form2.name,151551)
  },
  item_change(e) {
    console.log(e.detail.value)
    this.setData({
      [e.currentTarget.dataset.name]: e.detail.value
    })
    console.log(this.data.form)
  },
  change(e) {
    console.log(this.data.form,555555)
    if (e.currentTarget.dataset.msg == "form.name") {
      //验证中文名字
      let reg = new RegExp(/^[\u4E00-\u9FA5]{2,4}$/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的中文名字',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.name']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      
      }
    } else if (e.currentTarget.dataset.msg == "form.disabled.num") {
      //残疾证验证
      let reg = new RegExp(/[\d]{17}[\dX][1-7][1-4]/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的残疾证号码',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.disabled.num']: ''
        })
       
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
       
      }

    } else if (e.currentTarget.dataset.msg == "form.idcard") {
      //身份证验证
      let reg = new RegExp(/^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/)
      console.log(reg.test(e.detail.value),"test")
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的身份证号码号码',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.idcard']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      }
      console.log(e.currentTarget.dataset.msg)

    } else if (e.currentTarget.dataset.msg == "form.nativePlace") {
      //籍贯验证
      let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的地址',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.nativePlace']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      }

    } else if (e.currentTarget.dataset.msg == "form.localtion") {
      //身份证户籍地验证
      let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的地址',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.localtion']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      }

    } else if (e.currentTarget.dataset.msg == "form.address") {
      //现居住地址验证
      let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的地址',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.address']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      }

    } else if (e.currentTarget.dataset.msg == "form.phone") {
      //手机号验证
      let reg = new RegExp(/^1[3456789]\d{9}$/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的手机号',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.phone']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      }

    } else if (e.currentTarget.dataset.msg == "form.linkman.name") {
      //联系人姓名验证
      let reg = new RegExp(/^[\u4E00-\u9FA5]{2,4}$/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的中文名字',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.linkman.name']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      }

    } else if (e.currentTarget.dataset.msg == "form.linkman.phone") {
      //联系人手机验证
      let reg = new RegExp(/^1[3456789]\d{9}$/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的手机号码',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.linkman.phone']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      }
    } else if (e.currentTarget.dataset.msg == "form.work.company") {
      //工作单位验证
      let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确的工作单位',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form..work.company']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      }
    } else if (e.currentTarget.dataset.msg == "form.work.profession") {
      //职业工种验证
      let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
      if (reg.test(e.detail.value) == false) {
        wx.showToast({
          title: '请输入正确职业工种',
          icon: 'none',
          duration: 1500
        })
        this.setData({
          ['form.work.profession']: ''
        })
      } else {
        this.setData({
          [e.currentTarget.dataset.msg]: e.detail.value
        })
      }
    }

  },
  //残疾类型改变
  leixingChange(e) {
    console.log(e.detail.value)
    this.setData({
      [e.currentTarget.dataset.name]: e.detail.value
    })
    console.log(this.data.form)
  },
  //民族选项
  jiguanShow() {
    let yes = this.data.jiguan_show
    yes == true ? yes = false : yes = true
    this.setData({
      jiguan_show: yes
    })
    console.log(yes)
  },
  //婚姻选项
  hunfouShow() {
    let yes = this.data.hunfou_show
    yes == true ? yes = false : yes = true
    this.setData({
      hunfou_show: yes
    })
    console.log(yes)
  },
  //学历选项
  xueliShow() {
    let yes = this.data.xueli_show
    yes == true ? yes = false : yes = true
    this.setData({
      xueli_show: yes
    })
    console.log(yes)
  },
  //选择哪个
  checkedSelect(e) {
    console.log(e.currentTarget.dataset.name)
    if (e.currentTarget.dataset.msg == "xueli") {

      this.setData({
        xueli_txt: e.currentTarget.dataset.txt,
        xueli_show: false,
        [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
      })
    } else if (e.currentTarget.dataset.msg == "hunfou") {
      this.setData({
        hunfou_txt: e.currentTarget.dataset.txt,
        hunfou_show: false,
        [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
      })
    } else if (e.currentTarget.dataset.msg == "minzu") {
      this.setData({
        minzu_txt: e.currentTarget.dataset.txt,
        jiguan_show: false,
        [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
      })
    } else if (e.currentTarget.dataset.msg == "guanxi") {
      this.setData({
        guanxi_txt: e.currentTarget.dataset.txt,
        guanxi_show: false,
        [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
      })
    } else if (e.currentTarget.dataset.msg == "danwei") {
      this.setData({
        danwei_txt: e.currentTarget.dataset.txt,
        danwei_show: false,
        [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
      })
    }
    console.log(this.data.form)

  },
  //与其关系选项
  guanxiShow() {
    let yes = this.data.guanxi_show
    yes == true ? yes = false : yes = true
    this.setData({
      guanxi_show: yes
    })
    console.log(yes)
  },
  //单位性质选项
  danweiShow() {
    let yes = this.data.danwei_show
    yes == true ? yes = false : yes = true
    this.setData({
      danwei_show: yes
    })
    console.log(yes)
  },
  //点击选择
  clickChnage(e) {
    console.log(e.currentTarget.dataset.msg)
  },
  //点击下一步
  next() {
    let form = JSON.stringify(this.data.form)
    console.log(form)
    wx.navigateTo({
      url: `../wanshan/index?form=${form}`,
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