let index = {
    init: function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });
        $("#btn-search").on("click", ()=>{
            this.search();
        });
    },

    save: function(){
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };

        $.ajax({
            type: "POST",
            url: "/boards/new",
            data: JSON.stringify(data), // http body데이터
            contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
            dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
        }).done(function(resp){
            location.href = "/";
            alert("작성이 완료되었습니다")
        }).fail(function(error){
            alert(JSON.stringify(error));
        });

    },

    search: function(){
            let data = {
                title: $("#title").val(),
//                content: $("#content").val()
            };

            $.ajax({
                type: "GET",
                url: "/boards/search",
                data: JSON.stringify(data), // http body데이터
                contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
                dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
            }).done(function(resp){
//                location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });

        },

}

index.init();
