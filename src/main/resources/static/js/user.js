let index = {
    init: function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });
        $("#btn-login").on("click", ()=>{
            this.login();
        });
    },

    save: function(){
        let data = {
            username: $("#username").val(),
            name: $("#name").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            phone: $("#phone").val()
        };

        $.ajax({
            type: "POST",
            url: "/auth/signup",
            data: JSON.stringify(data), // http body데이터
            contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
            dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
        }).done(function(resp){
            location.href = "/";
            alert("회원가입이 완료되었습니다")
        }).fail(function(error){
            alert(JSON.stringify(error));
        });

    },

    login: function(){
            let data = {
                username: $("#username").val(),
                password: $("#password").val(),
            };

            $.ajax({
                type: "POST",
                url: "/auth/login",
//                beforeSend: function(xhr) {
//                            xhr.setRequestHeader('authorization ',token);
//                            },
                data: JSON.stringify(data), // http body데이터
                contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
                dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
            }).done(function(resp){
                var token = localStorage.setItem("token",resp.data.token);
                alert(resp.data.token)
                location.href = "/";
                alert("로그인이 완료되었습니다")
            }).fail(function(error){
                alert(JSON.stringify(error));
            });

        },


}

index.init();
