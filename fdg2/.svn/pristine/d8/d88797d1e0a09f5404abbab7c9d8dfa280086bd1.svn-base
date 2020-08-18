// pages/component/other/other.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    arr:Object
  },

  /**
   * 组件的初始数据
   */
  data: {
  
  },
  attached(){
    console.log(this.properties.arr,"111")
  },

  /**
   * 组件的方法列表
   */
  methods: {
    next(e) {
      console.log(e.currentTarget.dataset.url)
      let url = e.currentTarget.dataset.url
        wx.navigateTo({
          url: `${url}`,
        })
    }
  }
})