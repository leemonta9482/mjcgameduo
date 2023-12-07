var searchBtn = document.getElementById("searchBtn");
searchBtn.addEventListener("click", function(event) {

    var game = document.getElementById("game").value;
    if(game===""){
        location.href="/boardList"
        return
    }
    fetch("/boardList/"+game,{
        method:"GET"
    })
    .then(function(){
        location.href="/boardList/"+game
    })
});