<template>
  <div>
    <div>方法一 : import + export 导入</div>
    <div id="test">失败</div>

    <div style="margin-top: 20px;margin-bottom: 20px">------------</div>

    <div>方法二 :</div>
    <div id="test2">失败</div>
    <button v-on:click="test2()">点击</button>
    <div style="margin-top: 20px;margin-bottom: 20px">------------</div>

    <div>方法三 :</div>
    <remote-js src="../../static/noexport.js"></remote-js>
    <button v-on:click="test3()">点击</button>
    <div id="test3">未修改 , 请点击</div>

    <div style="margin-top: 20px;margin-bottom: 20px">------------</div>

    <div>方法四 : indexHtml 引入</div>
    <div id="test4">未修改</div>

    <div style="margin-top: 20px;margin-bottom: 20px">------------</div>

    <div>方法五 : webpack 引入</div>
    <div id="test5">未修改</div>
  </div>
</template>

<script>

  // 方法一 : import + export 导入
  import {functionTest} from '@/assets/js/test.js';

  // 方法二 : 封装 remoteJs 组件

  // 方法三 : 使用 JS 手动导入
  var localJs = document.createElement("script");
  localJs.setAttribute("src", "../../static/manually.js");
  document.head.appendChild(localJs);

  // 方法四 : 加入 index.html

  export default {
    name: "indexJS",
    components: {
      // 方法 2
      'remote-js': {
        render(createElement) {
          return createElement('script', {attrs: {type: 'text/javascript', src: this.src}});
        },
        props: {
          src: {type: String, required: true}
        }
      }

    },
    mounted() {

      // 方法 1
      functionTest.changeText();

      // 方法 4
      testIndexHtml();

      // 方法 5 : 测试不行 , 后续完善
      // webpackjs()
    },
    updated() {

    },
    methods: {
      // 方法2
      test2: function () {
        console.log("onclick is ")
        noExport();
      },
      // 方法3
      test3: function () {
        console.log("onclick is ")
        manuallyFun();
      }
    }
  }


</script>


