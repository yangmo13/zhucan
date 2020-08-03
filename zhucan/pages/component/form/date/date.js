// pages/component/form/input.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    isRed: Boolean,
    text: String,
    msg: String
  },

  /**
   * 组件的初始数据
   */
  data: {
      date:{
        start: "",
        end: ""
      }
   
    
  },

  /**
   * 组件的方法列表
   */
  methods: {
    change(e) {

      this.triggerEvent('blur', e.detail.value)
    },
    bindDateChange(e) {
      console.log(this.data)
      this.setData({
        [e.currentTarget.dataset.msg]:e.detail.value
      })
      // if(e.currentTarget.dataset.msg=='start'){
      //   this.triggerEvent('blur', {start:this.data[e.currentTarget.dataset.msg]})
      // }else{
      //   this.triggerEvent('blur', {end:this.data[e.currentTarget.dataset.msg]})
      // }
      this.triggerEvent('blur', this.data.date)

      
    }
  }
})