function remove(){
    if(!confirm("작성한 글을 지우시겠습니까?")){
        return
    }else{
        var id = document.getElementById("hn").value
        fetch("/api/board/delete/"+id,{
            method:"DELETE"
        })
        .then(function(){
            window.alert("글이 정상적으로 삭제되었습니다.")
            location.replace("/boardList")
        })
    }
}