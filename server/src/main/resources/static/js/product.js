
let main = {
    init : function () {
        let _this = this;

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },

    delete : function () {
        let id = $('#id').text();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/product/'+ parseInt(id),
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            location.href = "/product";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
