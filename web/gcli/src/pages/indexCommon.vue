<template>

  <!-- 注意 : 这里必须包在一个大的 DIV 里面-->
  <div>
    <div>这里是页面原代码,下面是公共代码</div>
    <common-top></common-top>
  </div>

</template>

<script>

  import commonTop from '@/components/commonTop'

  export default {
    name: "indexCommon",
    components: {
      commonTop
    }
  }


</script>
