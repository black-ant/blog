<template>
  <!-- Wrapper-->
  <div id="wrapper">

    <!-- Nav -->
    <nav id="nav">
      <a href="#me" class="fa fa-home active"><span>Home</span></a>
      <a href="#two" class="fa fa-home active"><span>Home</span></a>
      <a href="#work" class="fa fa-folder"><span>Work</span></a>
      <a href="#email" class="fa fa-envelope"><span>Email Me</span></a>
      <a href="http://twitter.com/n33co" class="fa fa-twitter"><span>Twitter</span></a>
    </nav>

    <!-- Main -->
    <div id="main">

      <!-- Me -->
      <article id="me" class="panel">
        <header>
          <h1>Jane Doe</h1>
          <span class="byline">Senior Astral Projectionist</span>
        </header>
        <a href="#work" class="jumplink pic">
          <span class="arrow fa fa-chevron-right"><span>See my work</span></span>
          <img src="images/me.jpg" alt=""/>
        </a>
      </article>
      <!-- Me -->
      <article id="two" class="panel">
        <header>
          <h1>Jane Doe</h1>
          <span class="byline">Senior Astral Projectionist</span>
        </header>
        <a href="#work" class="jumplink pic">
          <span class="arrow fa fa-chevron-right"><span>See my work</span></span>
          <img src="images/me.jpg" alt=""/>
        </a>
      </article>

      <!-- Work -->
      <article id="work" class="panel">
        <header>
          <h2>Work</h2>
        </header>
        <p>
          Phasellus enim sapien, blandit ullamcorper elementum eu, condimentum eu elit.
          Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia
          luctus elit eget interdum.
        </p>
      </article>

      <!-- Email -->
      <article id="email" class="panel">
        <header>
          <h2>Work</h2>
        </header>
        <p>
          Phasellus enim sapien, blandit ullamcorper elementum eu, condimentum eu elit.
          Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia
          luctus elit eget interdum.
        </p>
      </article>

    </div>
  </div>

</template>

<script>

  import {antUtils} from "../assets/js/ant/ant-utils";

  export default {
    name: "blog-project",
    mounted: function () {
      antUtils.buildScript("/static/project/html5shiv.js");
      antUtils.buildScript("/static/project/skel.min.js");
      antUtils.buildScript("/static/project/init.js");
    },
  }


</script>

<style scoped>
  @import "../assets/css/project/style.css";
  @import "../assets/css/project/style-desktop.css";
  @import "../assets/css/project/style-mobile.css";
  @import "../assets/css/project/skel-noscript.css";
</style>


