var submitBtn = document.getElementById("submit-btn")

submitBtn.addEventListener("click", function(){
    var hn=document.getElementById("hn").value
    var pw=document.getElementById("pw").value
    var name=document.getElementById("name").value
    var gender=document.getElementById("gender").value
    var nick=document.getElementById("nick").value

    if (hn === "" || pw === "" || name === "" || gender === "" || nick === "") {
        window.alert("입력하지 않은 값이 있는지 확인해주세요!");
        return; // Stop execution if any field is empty
    }

    fetch("/api/register",{
        method:"POST",
        headers:{
            "Content-type" : "application/json"
        },
        body:JSON.stringify({
            hn:hn,
            pw:pw,
            name:name,
            gender:gender,
            nick:nick
        })
    })
    .then(response => response.json())
    .then(data=>{
        console.log(data)
        if(data.success){
            window.alert(data.message)
            location.href="/"
        }else{
            window.alert(data.message)
        }
    })
})