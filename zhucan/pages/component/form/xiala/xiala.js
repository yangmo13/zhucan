// pages/component/form/input.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    isRed: Boolean,
    text: String,
    msg: String,
    arr: Object
  },

  /**
   * 组件的初始数据
   */
  data: {
    arr: [
      1, 2, 3, 4, 65, 6
    ],
    show: false,
    ishow:false,
    show_txt: ""
  },

  /**
   * 组件的方法列表
   */
  methods: {
    kkk() {
      let btn = !this.data.show

      this.setData({
        show: btn
      })
    },
    blur(){
     
      this.setData({
        ishow:false
      })
    },
    change(e) {
     
      let btn = !this.data.show
      console.log(e.currentTarget.dataset.msg)
      this.setData({
        show_txt: e.currentTarget.dataset.msg,
        ishow: false
      })
      this.triggerEvent('xiala',e.currentTarget.dataset.msg)
     

    },
    isShow() {
  
      this.setData({
        ishow: true
      })
    }
  }
})