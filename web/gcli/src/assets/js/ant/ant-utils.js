var antUtils = {
  cacheSet: function (name, value, option) {
    if (option != null) {
      storegeditOption(option);
    }
    window.localStorage.setItem(name, value);
  },
  cacheGet: function () {
    window.localStorage.getItem(name);
  },
  GetDateBefore: function (AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount); //获取AddDayCount天后的日期
    var year = dd.getFullYear();
    var month = dd.getMonth() + 1 < 10 ? "0" + (dd.getMonth() + 1) : dd.getMonth() + 1;
    var day = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate();
    return year + "-" + month + "-" + day;
  },
  buildScript: function (url) {
    var localJs = document.createElement("script");
    localJs.setAttribute("src", url);
    document.head.appendChild(localJs);
  }
}

export {
  antUtils
}
