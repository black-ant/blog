function other() {
    var $table = $('#table');
    $('#toolbar').find('select').change(function () {
        $table.bootstrapTable('destroy').bootstrapTable({
            exportDataType: $(this).val()
        });
    });
}

function initTable(colume, data) {

    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable({
        columns: colume,
        data: data
    })
}


