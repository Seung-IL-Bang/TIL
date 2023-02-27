# jQuery ajax

mustache 서버 템플릿 엔진으로 화면을 구성하는 과정에서, 버튼을 클릭할 경우 어떤 동작을 수행하기 위해 jQuery 를 이용하였다. 아래 자바스크립트 코드는 이벤트 발생시 수행할 동작들을 정의한 코드이다. 아래 코드를 살펴보면서 jQuery의 ajax가 어떻게 동작하는지 알아보자.

```javascript
let main = {
    init : function() {
        let _this = this;
        $('#btn-save').on('click', function() {
            _this.save()
        });
        $('#btn-update').on('click', function() {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        })
    },

    save : function () {
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error))
        })
    },

    update : function () {
        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        let id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete : function () {
        let id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
};

main.init();
```

<br>

```javascript
let _this = this;
```
`_this` 는 기명함수 안에서 정의 되었기 때문에 `main` 을 가리키게 된다.

