var baseUrl = "http://127.0.0.1:8086/";
var restApi = {
    doPullGit: function () {
        var body = {
            "projectPath": "https://gitee.com/antblack/blog-doc.git",
            "type": "git"
        }
        return restUtils.post("pull/bypath", body);
    },
    doPullFile: function (code) {
        var body = {
            "projectPath": code,
            "type": "file"
        }
        return restUtils.post("pull/bypath", body);
    },
    doBuildDoc: function (code, findChild) {
        var body = {
            "folderCode": code,
            "findChild": findChild
        }
        return restUtils.post("docbuild/byCode", body);
    },
    doSelectWorkSpace: function () {
        return restUtils.get("folder/rootList");
    },
    doSelectWorkSpaceFolder: function () {
        var root = $.base64.encode("D:\\java\\workspace\\doc");
        return restUtils.get("folder/folderList?root=" + root);
    },
    doSelectFolderDoc: function (folderId) {
        return restUtils.get("content/byFolder?folderId=" + folderId);
    },
    selectDocById: function (folderId) {
        return restUtils.get("/content/getOne/" + folderId);
    },
}

var restUtils = {
    get: function (url, param = {}, dataType = 'json') {
        return new Promise((resolve, reject) => {
            $.ajax({
                url: baseUrl + url,
                type: "GET",
                data: param,
                dataType: dataType,
                async: true,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
                    xhr.setRequestHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,DELETE,PUT");
                },
                success: function (result) {
                    resolve(result)
                },

                error: function (result) {
                    reject(result)
                }
            });
        })
    },
    post: function (url, param = {}, dataType = 'json') {
        return new Promise((resolve, reject) => {
            $.ajax({
                type: "post",
                url: baseUrl + url,
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify(param),
                dataType: dataType,
                crossDomain: true,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
                    xhr.setRequestHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,DELETE,PUT");
                },
                success: function (result) {
                    resolve(result);
                },
                error: function (err) {
                    reject(result);
                }
            });
        })
    }
}
