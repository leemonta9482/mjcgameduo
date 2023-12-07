var searchBtn = document.getElementById("searchBtn");
searchBtn.addEventListener("click", function(event) {

    var game = document.getElementById("hn").value;
    if(game===""){
        location.href="/admin"
        return
    }
    fetch("/admin/"+hn,{
        method:"GET"
    })
    .then(function(){
        location.href="/admin/"+game
    })
});