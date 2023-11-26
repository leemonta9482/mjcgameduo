// ====================================== 신버전
// 일괄 처리 버튼에 대한 이벤트 핸들러 등록
document.getElementById('batchDeleteBtn').addEventListener("click", function() {
    batchDeleteRows();
});

// 선택된 행의 정보를 가져와 일괄 처리하는 함수
function batchDeleteRows() {
    var selectedRows = document.querySelectorAll('input[name="selectedRows"]:checked');
    if(selectedRows.length<=0){
        alert("1개라도 선택해야 합니다.")
        return;
    }
    if (!confirm("선택된 유저의 회원탈퇴를 진행 하시겠습니까?")) {
        return;
    }
    var updateData = [];

    selectedRows.forEach(function(checkbox) {
        var selectedRow = checkbox.closest("tr");
        var createnum = selectedRow.querySelector('input[name="createnum"]').value;

        updateData.push({
            createnum:createnum
        });
    });

    for(var i=0; i<updateData.length; i++){
        fetch("/api/admin/delete/"+updateData[i].createnum,{
            method:"DELETE"
        })
    }
    window.alert("정상적으로 회원탈퇴 되었습니다.")
    location.replace("/admin")
}

// ====================================== 구버전
//// 삭제 버튼에 대한 이벤트 핸들러 등록
//var deleteBtns = document.querySelectorAll('.btn-danger');
//deleteBtns.forEach(function(btn) {
//    btn.addEventListener("click", function(){
//        deleteRow(btn);
//    });
//});
//
//function deleteRow(btn){
//    if(!confirm("해당 유저를 회원탈퇴 하시겠습니까?\n해당 유저의 작성된 게시글도 삭제됩니다.")){
//        return
//    }else{
//        var selectedRow = btn.closest("tr");
//        var createnum = selectedRow.querySelector('input[name="createnum"]').value;
//        fetch("/api/admin/delete/"+createnum,{
//            method:"DELETE"
//        })
//        .then(function(){
//            window.alert("정상적으로 회원탈퇴 되었습니다.")
//            location.replace("/admin")
//        })
//    }
//}