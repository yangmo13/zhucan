// pages/servers/index/zhiye/zhidao/zhidao.js
const App = getApp()
import AppUtil from "../../../../../utils/util"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew: true,
    height: "",
    isNext:false,
    selectBox: 3,
    fuli: [{
        value: "福利企业",
        txt: "是"
      },
      {
        value: "非福利企业",
        txt: "否"
      }
    ],
    'idcard_': "",
    form: {
      "name": "",
      //身份证号
      "idcard": "",
      //手机号
      "phone": "",
      //残疾证信息
      "disabled": {
        //残疾证类型
        "type": [],
        //残疾等级
        "level": "",
      }
    },
    need: {
      //需求类别
      demand: [],
      //联系人,
      linkman: "",
      //联系电话
      phone: ""
    },
    //错误信息
    test_name: "",
    test_phone: "",
    demand: [
      "防褥疮垫",
      "拐杖",
      "轮椅",
      "助听器",
      "成人助听器",
      "盲杖",
      "听书器",
      "盲用手表",
      "光学放大器",
      "盲用眼睛",
    ],



    jiguan_show: false,
    minzu_txt: "",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height: App.globalData.navHeight
    })
    //onload 请求数据
    setTimeout(() => {
      let data = {
        "name": "李三",
        //身份证号
        "idcard": "230103199708555714",
        //手机号
        "phone": "18045478936",
        //残疾证信息
        "disabled": {
          //残疾证类型
          "type": ["听力残疾", "肢体残疾"],
          //残疾等级
          "level": "一级",
        }
      }
      let form = this.data.form
      Object.keys(form).forEach(key => {
        form[key] = data[key]

        if (key == 'idcard') {
          console.log(1)
          let idcard = form[key]
          if (idcard.length == 15) {
            idcard = idcard.replace(/(\d{6})\d{6}(\d{3})/, "$1******$2");
          } else {
            idcard = idcard.replace(/(\d{5})\d{6}(\d{6})/, "$1******$2");
          }
          this.setData({
            idcard_: idcard
          })
          console.log(this.data.idcard_)

        }

      })
      this.setData({
        form: form
      })
      console.log(this.data.form)
    }, 1500)


  },

  // change(e) {
  //   if (e.currentTarget.dataset.msg == "form.name") {
  //     //验证中文名字
  //     let reg = new RegExp(/^[\u4E00-\u9FA5]{2,4}$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的中文名字',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.name']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }
  //   } else if (e.currentTarget.dataset.msg == "form.disabled.num") {
  //     //残疾证验证
  //     let reg = new RegExp(/[\d]{17}[\dX][1-7][1-4]/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的残疾证号码',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.disabled.num']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }

  //   } else if (e.currentTarget.dataset.msg == "form.idcard") {
  //     //身份证验证
  //     let reg = new RegExp(/^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的身份证号码号码',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.idcard']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }

  //   } else if (e.currentTarget.dataset.msg == "form.nativePlace") {
  //     //籍贯验证
  //     let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的地址',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.nativePlace']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }

  //   } else if (e.currentTarget.dataset.msg == "form.localtion") {
  //     //身份证户籍地验证
  //     let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的地址',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.localtion']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }

  //   } else if (e.currentTarget.dataset.msg == "form.address") {
  //     //现居住地址验证
  //     let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的地址',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.address']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }

  //   } else if (e.currentTarget.dataset.msg == "form.phone") {
  //     //手机号验证
  //     let reg = new RegExp(/^1[3456789]\d{9}$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的手机号',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.phone']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }

  //   } else if (e.currentTarget.dataset.msg == "form.linkman.name") {
  //     //联系人姓名验证
  //     let reg = new RegExp(/^[\u4E00-\u9FA5]{2,4}$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的中文名字',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.linkman.name']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }

  //   } else if (e.currentTarget.dataset.msg == "form.linkman.phone") {
  //     //联系人手机验证
  //     let reg = new RegExp(/^1[3456789]\d{9}$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的手机号码',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.linkman.phone']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }
  //   } else if (e.currentTarget.dataset.msg == "form.work.company") {
  //     //工作单位验证
  //     let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确的工作单位',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form..work.company']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }
  //   } else if (e.currentTarget.dataset.msg == "form.work.profession") {
  //     //职业工种验证
  //     let reg = new RegExp(/^[0-9\u4e00-\u9fa5]+$/)
  //     if (reg.test(e.detail.value) == false) {
  //       wx.showToast({
  //         title: '请输入正确职业工种',
  //         icon: 'none',
  //         duration: 1500
  //       })
  //       this.setData({
  //         ['form.work.profession']: ''
  //       })
  //     } else {
  //       this.setData({
  //         [e.currentTarget.dataset.msg]: e.detail.value
  //       })
  //     }
  //   } else {
  //     this.setData({
  //       [e.currentTarget.dataset.msg]: e.detail.value
  //     })
  //   }
  //   console.log(this.data.form)

  // },
  // item_change(e) {
  //   console.log(e.detail.value)
  //   this.setData({
  //     [e.currentTarget.dataset.name]: e.detail.value
  //   })
  //   console.log(this.data.form)
  // },
  // jiguanShow() {
  //   let yes = this.data.jiguan_show
  //   yes == true ? yes = false : yes = true
  //   this.setData({
  //     jiguan_show: yes
  //   })
  //   console.log(yes)
  // },
  // checkedSelect(e) {
  //   console.log(e.currentTarget.dataset.name)
  //   if (e.currentTarget.dataset.msg == "xueli") {

  //     this.setData({
  //       xueli_txt: e.currentTarget.dataset.txt,
  //       xueli_show: false,
  //       [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
  //     })
  //   } else if (e.currentTarget.dataset.msg == "hunfou") {
  //     this.setData({
  //       hunfou_txt: e.currentTarget.dataset.txt,
  //       hunfou_show: false,
  //       [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
  //     })
  //   } else if (e.currentTarget.dataset.msg == "minzu") {
  //     this.setData({
  //       minzu_txt: e.currentTarget.dataset.txt,
  //       jiguan_show: false,
  //       [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
  //     })
  //   } else if (e.currentTarget.dataset.msg == "guanxi") {
  //     this.setData({
  //       guanxi_txt: e.currentTarget.dataset.txt,
  //       guanxi_show: false,
  //       [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
  //     })
  //   } else if (e.currentTarget.dataset.msg == "danwei") {
  //     this.setData({
  //       danwei_txt: e.currentTarget.dataset.txt,
  //       danwei_show: false,
  //       [e.currentTarget.dataset.name]: e.currentTarget.dataset.txt
  //     })
  //   }
  //   console.log(this.data.form)

  // },
  // leixingChange(e) {
  //   console.log(e.detail.value)
  //   this.setData({
  //     [e.currentTarget.dataset.name]: e.detail.value
  //   })
  //   console.log(this.data.form)
  // },
  // change2(e) {

  //   this.setData({
  //     selectBox: e.currentTarget.dataset.num
  //   })
  // },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */

  change(e) {
    console.log(e)
    let msg = e.currentTarget.dataset.msg
    if (msg == 'need.demand') {
      this.setData({
        [msg]: e.detail.value
      })
    } else {
      let test = e.currentTarget.dataset.test
      let data = AppUtil.test(e.detail, test)
      console.log(data!='',"WHAT FUCK")
      if (data == '') {
        this.setData({
          [msg]: e.detail,
          [test]:""
        })
      } else {
        this.setData({
          [test]: data,
          [msg]: ""
        })
      }


    }
    console.log(this.data.need)

  },
  changeNav(e){
    
    this.setData({
      selectBox: e.currentTarget.dataset.num
    })
  },
  next(){
    let need = this.data.need

    Object.keys(need).forEach(key=>{
      if(need[key]==''){
      wx.showToast({
        title: '必填选项不能为空',
        icon:"none"
      })
      }else{
        wx.switchTab({
          url: '/pages/servers/index/index',
        })
      }
  
    })
   
    
  },
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