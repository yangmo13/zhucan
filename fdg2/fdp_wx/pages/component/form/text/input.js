// pages/component/form/input.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    isRed: Boolean,
    text: String,
    msg: String,
    placeholder:String
  },

  /**
   * 组件的初始数据
   */
  data: {

  },

  /**
   * 组件的方法列表
   */
  methods: {
    
    change(e) {
    console.log(e) 
      this.triggerEvent('blur',e.detail.value)
    }
  }
})