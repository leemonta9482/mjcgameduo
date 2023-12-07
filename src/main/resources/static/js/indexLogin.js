var submitBtn = document.getElementById("submit-btn")
submitBtn.addEventListener("click", function(){
    var hn=document.getElementById("hn").value
    var pw=document.getElementById("pw").value

    if (hn === "" || pw === "") {
            window.alert("아이디 혹은 비밀번호를 입력해주세요!");
            return;
    }

    fetch("/api/login",{
        method:"POST",
        headers:{
            "Content-type" : "application/json"
        },
        body:JSON.stringify({
            hn:hn,
            pw:pw
        })
    })
    .then(response => response.json())
    .then(data=>{
        if(data.success){
            if(data.admin===999){ // 관리자
                location.href="/admin"
            }else if(data.admin===0){ // 승인대기
                window.alert("회원가입 승인 대기중인 계정입니다.\n가입 승인이 완료되면 로그인이 가능합니다.")
                location.href="/logout"
            }else if(data.admin===1){ // 승인
                location.href="/boardList"
            }else if(data.admin===2){ // VIP
                location.href="/boardList"
            }else{
                window.alert("약관 위반으로 정지된 계정입니다!\n자세한 내용은 관리자에게 문의해주세요.")
            }
        }else{
            window.alert(data.message)
            location.href="/"
        }
    })
    .catch(error => {
        console.error("Error during login:", error);
    });
})