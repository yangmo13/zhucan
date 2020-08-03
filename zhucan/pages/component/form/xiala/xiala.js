// pages/component/form/input.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    isRed: Boolean,
    text: String,
    msg: String,
    arr2: Object
  },

  /**
   * 组件的初始数据
   */
  data: {
    arr: [
      1, 2, 3, 4, 65, 6
    ],
    show:false,
    show_txt:""
  },

  /**
   * 组件的方法列表
   */
  methods: {
    change(e) {
      console.log(e.currentTarget.dataset.msg)
      this.setData({
        show_txt:e.currentTarget.dataset.msg,
        show:false
      })
      console.log(this.data.show)

    },
    isShow() {
      this.setData({
        show:true
      })
    }
  }
})