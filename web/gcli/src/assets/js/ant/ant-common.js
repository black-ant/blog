var baseUrl = "http://127.0.0.1:8089/";
var antAjax = {
    post: function (url, data, successFun) {
        $.ajax({
            type: "POST",
            dataType: "json",
            url: url,
            contentType: "application/json",
            data: JSON.stringify(data),
            success: successFun
        });
    },
    get: function (url, successFun) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url,
            contentType: "application/json",
            success: successFun
        });
    },
    urlCode: function (param, key, encode) {
        var urlEncode = function (param, key, encode) {
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
        };
    },
    baseUrl: function () {
        var curPageUrl = window.document.location.href;
        var rootPath = curPageUrl.split("//")[0] + curPageUrl.split("//")[1].split("/")[0]
            + "/";
        return rootPath;

    }
}
