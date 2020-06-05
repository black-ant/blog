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
    }
}

var antLocation = {
    /**
     * 页面跳转
     */
    doLocation: function (url) {
        window.location.href = url;
    },
    /**
     *调用某个url参数
     *使用方法:
     *GetQueryString(name)
     **/
    GetQueryString: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if (r != null)
            return unescape(r[2]);
        return null; //返回参数值
    },
    GetQueryStringByEncode: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if (r != null)
            return unescape(decodeURI(r[2]));
        return null; //返回参数值
    },
    setQueryString: function (data) {
        var params = "";
        if (isnotnull(data) && (typeof (data) == "object" && Object.keys(data).length > 0)) {
            params += "?";
            var num = 0;
            for (var x in data) {
                num++;
                params += x + "=" + data[x];
                if (num < Object.keys(data).length) {
                    params += "&";
                }
            }
        }
        return params; //返回参数值
    },
    /**
     * param 将要转为URL参数字符串的对象
     * key URL参数字符串的前缀
     * encode true/false 是否进行URL编码,默认为true
     *
     * return URL参数字符串
     */
    urlEncode: function (param, key, encode) {
        if (param == null)
            return '';
        var paramStr = '';
        var t = typeof (param);
        if (t == 'string' || t == 'number' || t == 'boolean') {
            paramStr += '&' + key + '=' + ((encode == null || encode) ? encodeURIComponent(param) : param);
        } else {
            for (var i in param) {
                var k = key == null ? i : key + (param instanceof Array ? '[' + i + ']' : '.' + i);
                paramStr += urlEncode(param[i], k, encode);
            }
        }
        return paramStr;
    }
}

var antTime = {
    //long转时间戳
    timeFormat: function (time) {
        var date = new Date(time);
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        var Hours = date.getHours();
        var Minutes = date.getMinutes();
        month = month < 10 ? "0" + month : month;
        day = day < 10 ? "0" + day : day;
        Hours = Hours < 10 ? "0" + Hours : Hours;
        Minutes = Minutes < 10 ? "0" + Minutes : Minutes;
        return year + "-" + month + "-" + day + " " + Hours + ":" + Minutes;
    },


    timeFormatYYMMDD: function (time) {
        var date = new Date(time);
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        month = month < 10 ? "0" + month : month;
        day = day < 10 ? "0" + day : day;
        return year + "-" + month + "-" + day;
    },

    timeFormatYYMMDDChina: function (time) {
        var date = new Date(time);
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        return year + "年" + month + "月" + day + "日";
    },

    timeFormatYYMMDDChinaDate: function (date) {
        var date = new Date(date);
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        return year + "年" + month + "月" + day + "日";
    }
}

var antStringUtils = {
    splitToArray: function (str) {
        let regStr = str.split(/[(\r\n)\r\n]+/);
        regStr.forEach((item, index) => {
            if (!item) {
                regStr.splice(index, 1);
            }
        });
        return Array.from(regStr);
    }
}
