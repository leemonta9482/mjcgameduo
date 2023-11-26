var submitBtn = document.getElementById("submit-btn")
submitBtn.addEventListener("click", function(){
    if(!confirm("정말 이 내용으로 수정하시겠습니까?")){
        return
    }else{
        var pw=document.getElementById("pw").value
        var nick=document.getElementById("nick").value
        var hn=document.getElementById("hn").value
        fetch("/api/update/"+hn,{
            method:"PUT",
            headers:{
                "Content-type" : "application/json"
            },
            body:JSON.stringify({
                pw:pw,
                nick:nick
            })
        })
        .then(function(){
            window.alert("정상적으로 내용이 수정되었습니다.")
            location.href="/boardList"
        })
    }
})