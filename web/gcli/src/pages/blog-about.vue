<template>
  <div id="wrapper">
    <div id="bg"></div>
    <div id="overlay"></div>
    <div id="main">
      <!-- Header -->
      <header id="header">
        <h1>Ant Black </h1>
        <p>Email : 1016930479@qq.com &nbsp;&bull;&nbsp; Zengzg &nbsp;&bull;&nbsp;Thank you for your attention </p>
        <nav>
          <ul>
            <li><a href="#" class="fa fa-twitter"><span>Twitter</span></a></li>
            <li><a href="#" class="fa fa-facebook"><span>Facebook</span></a></li>
            <li><a href="#" class="fa fa-dribbble"><span>Dribbble</span></a></li>
            <li><a href="#" class="fa fa-github"><span>Github</span></a></li>
            <li><a href="#" class="fa fa-envelope-o"><span>Email</span></a></li>
          </ul>
        </nav>
      </header>

      <!-- Footer -->
      <footer id="footer">
        <span class="copyright">&copy; Untitled. Design: <a href="http://html5up.net">HTML5 UP</a>.</span>
      </footer>

    </div>
  </div>
</template>

<script>

  import {antUtils} from "../assets/js/ant/ant-utils";

  export default {
    name: "blog-about",
    mounted: function () {
      antUtils.buildScript("/static/about/js/skel.min.js");
      antUtils.buildScript("/static/about/js/init.js");
    }
  }
</script>

<style scoped>
  @import "../assets/about/css/font-awesome.min.css";
  @import "../assets/about/css/style.css";
  @import "../assets/about/css/skel.css";
  @import "../assets/about/css/style-noscript.css";
  @import "../assets/about/css/style-wide.css";
</style>
