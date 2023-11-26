var submitBtn = document.getElementById("submit-btn")
submitBtn.addEventListener("click", function(){
    var title = document.getElementById("title").value
    var game = document.getElementById("game").value
    var nick = document.getElementById("nick").value
    var person = document.getElementById("person").value
    var content = document.getElementById("content").value
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
            window.alert(data.message)
            location.href="/boardList"
        }else{
            window.alert(data.message)
            location.href="/boardList"
        }
    })
})