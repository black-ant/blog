<template>
  <div>
    <button v-on:click="testGet()">点击请求</button>
  </div>
</template>

<script>
  export default {
    name: "indexAxios",
    methods: {
      testGet: function () {
        console.log("this is in");
        this.selfRequest.requests.get('/api/user/test').then(res => {
          console.log(res)
          alert(res.data);
        })
      }
    }
  }
</script>

<style scoped>

</style>
