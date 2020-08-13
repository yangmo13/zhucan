// pages/login/wanshan/canji/canji.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    height: "",
    arr: [
      {'name':"视力残疾",'ischeck':false},
      {'name':"听力残疾",'ischeck':false},
      {'name':"言语残疾",'ischeck':false},
      {'name':"肢体残疾",'ischeck':false},
      {'name':"智力残疾",'ischeck':false},
      {'name':"精神残疾",'ischeck':false},
      {'name':"其他",'ischeck':false},
    ],
    arr2: [
      {'name':  "一级",'ischeck':false},
      {'name':  "二级",'ischeck':false},
      {'name':  "三级",'ischeck':false},
      {'name':  "其他",'ischeck':false},
    ],
    form: {
      //残疾证类型
      "type": [],
      //残疾等级
      "level": "",

    },
    old_form: {}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let data = JSON.parse(options.form)
    let form = this.data.form
    //残疾类型
    let type = data.type
    let arr = this.data.arr
    //残疾等级
    let level = data.level
    let arr2 = this.data.arr2
    console.log(arr,type,'sssss')
    for(var i=0;i<type.length;i++){
      Object.keys(arr).forEach(key=>{
        if(type[i]==arr[key]['name']){
          arr[key].ischeck=true;
          this.setData({
            arr:arr
          })
        }
        
      })
    }
    console.log(level,"LEVEL")
    //level
    for(var i=0;i<arr2.length;i++){
      if(level==arr2[i]['name']){
        arr2[i]['ischeck']=true
        this.setData({
            arr2:arr2
        })
      }
    
    }



    console.log(data.type,"this data")
    console.log(data, "data")
    Object.keys(form).forEach(key => {
      form[key] = data[key]
    })
    this.setData({
      height: App.globalData.navHeight,
      form: form,
      old_form: data
    })
    console.log(form)

  },
  change(e) {
    console.log(e.detail.value)
    this.setData({
      [e.currentTarget.dataset.msg]: e.detail.value
    })
    console.log(this.data.form,"ffff")
  },
  next() {
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

    console.log(this.data.form, "1111")
    let type = this.data.form.type
    let level = this.data.form.level
    if (type != '' && level != '') {
      wx.redirectTo({
        url: `../index?form=${form}`,
      })
    }else{
      wx.showToast({
        title: '必选项不能为空',
        image:"/image/servers/wrong.png",
        icon:'none'
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