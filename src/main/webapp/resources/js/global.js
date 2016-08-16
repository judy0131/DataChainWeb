function initSubjectTree(callback) {
    $.ajax({
            type: "post",
            url: "/subject/all?ts=" + new Date().getTime(),
            async: false,
            success: function (data) {
                var treeDataSource = new DataSourceTree({data: data});
                $('#tree').ace_tree({
                    dataSource: treeDataSource,
                    loadingHTML: '<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
                    'open-icon': 'icon-folder-open',
                    'close-icon': 'icon-folder-close',
                    'selectable': true,
                    'selected-icon': null,
                    'unselected-icon': null,
                    'callback' : callback
                });
            }}
    );
}
$.extend({
    aModal:function(url,title,width){
        $.pgwModal({
            url: url,
            title: title,
            maxWidth: width,
            loading: '<span style="text-align:center">加载中</span>',
            close: true,
            closeOnEscape : false
        });
    },
    aModalClose:function(){
        $.pgwModal("close");
    },
    aModalReposition:function(){
        $.pgwModal('reposition');
    }
})

/**
 * 时间对象的格式化;
 */
Date.prototype.format = function(format) {
    /*
     * eg:format="yyyy-MM-dd hh:mm:ss";
     */
    var o = {
        "M+" : this.getMonth() + 1, // month
        "d+" : this.getDate(), // day
        "h+" : this.getHours(), // hour
        "m+" : this.getMinutes(), // minute
        "s+" : this.getSeconds(), // second
        "q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
        "S" : this.getMilliseconds()
        // millisecond
    }

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
        - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1
                ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}