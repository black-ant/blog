<template>
  <div>
    <button v-on:click="test()">点击</button>
    <div id="test">未修改 ,请点击修改</div>
  </div>
</template>

<script>
  import $ from 'jquery' ;


  export default {
    name: "indexJQuery",
    mounted() {
    },
    methods: {
      test: function () {
        $("#test").html("已修改完成");
      }
    }
  }
</script>

<style scoped>

</style>
