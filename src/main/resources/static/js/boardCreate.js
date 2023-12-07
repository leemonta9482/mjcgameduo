var submitBtn = document.getElementById("submit-btn")

submitBtn.addEventListener("click", function(){
    var title = document.getElementById("title").value
    var game = document.getElementById("game").value
    var nick = document.getElementById("nick").value
    var person = document.getElementById("person").value
    var content = document.getElementById("content").value

    if (title === "" || game === "" || nick === "" || person === "" || content === "") {
            window.alert("입력하지 않은 값이 있는지 확인해주세요!");
            return; // Stop execution if any field is empty
    }

    if (!confirm("작성된 게시글이 있다면 삭제되고 새로 작성됩니다.\n게시글을 작성할까요?")){
        return;
    }

    fetch("/api/board/create",{
        method:"POST",
        headers:{
            "Content-type" : "application/json"
        },
        body:JSON.stringify({
            content:content,
            game:game,
            nick:nick,
            person:person,
            title:title
        })
    })
    .then(response => response.json())
    .then(data=>{
        if(data.success){
            location.href="/boardList"
        }else{
            location.href="/boardList"
        }
    })
})