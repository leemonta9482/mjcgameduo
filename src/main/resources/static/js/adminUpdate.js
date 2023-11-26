// ================================================== 신버전
// 전체 선택 버튼에 대한 이벤트 핸들러 등록
document.getElementById('selectAllBtn').addEventListener("click", function() {
    selectAllRows(true);
});

// 전체 해제 버튼에 대한 이벤트 핸들러 등록
document.getElementById('deselectAllBtn').addEventListener("click", function() {
    selectAllRows(false);
});

// 일괄 처리 버튼에 대한 이벤트 핸들러 등록
document.getElementById('batchUpdateBtn').addEventListener("click", function() {
    batchUpdateRows();
});

// 모든 행을 선택 또는 해제하는 함수
function selectAllRows(select) {
    var checkboxes = document.querySelectorAll('input[name="selectedRows"]');
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = select;
    });
}

// 선택된 행의 정보를 가져와 일괄 처리하는 함수
function batchUpdateRows() {
    var selectedRows = document.querySelectorAll('input[name="selectedRows"]:checked');
    if(selectedRows.length<=0){
        alert("1개라도 선택해야 합니다.")
        return;
    }

    if (!confirm("선택된 유저를 업데이트 하시겠습니까?")) {
        return;
    }

    var updateData = [];

    selectedRows.forEach(function(checkbox) {
        var selectedRow = checkbox.closest("tr");
        var createnum = selectedRow.querySelector('input[name="createnum"]').value;
        var hn = selectedRow.querySelector('input[name="hn"]').value;
        var pw = selectedRow.querySelector('input[name="pw"]').value;
        var name = selectedRow.querySelector('input[name="name"]').value;
        var gender = selectedRow.querySelector('select[name="gender"]').value;
        var nick = selectedRow.querySelector('input[name="nick"]').value;
        var state = selectedRow.querySelector('select[name="state"]').value;

        updateData.push({
            createnum: createnum,
            hn: hn,
            pw: pw,
            name: name,
            gender: gender,
            nick: nick,
            state: state
        });
    });

    for(var i=0; i<updateData.length; i++){
        fetch("/api/admin/update/"+updateData[i].createnum,{
            method:"PUT",
            headers:{
                "Content-type" : "application/json"
            },
            body:JSON.stringify({
                hn: updateData[i].hn,
                pw: updateData[i].pw,
                name: updateData[i].name,
                gender: updateData[i].gender,
                nick: updateData[i].nick,
                state: updateData[i].state
            })
        })
    }
    window.alert("정상적으로 내용이 수정되었습니다.")
    location.href="/admin"
}

// ================================================== 구버전
//var updateBtns = document.querySelectorAll('.btn-primary');
//updateBtns.forEach(function(btn) {
//    btn.addEventListener("click", function(){
//        updateRow(btn);
//    });
//});
//
//function updateRow(btn) {
//    if (!confirm("정말 이 내용으로 저장하시겠습니까?")) {
//        return;
//    }
//    // 클릭된 버튼이 속한 행에서 값을 가져오기
//    var selectedRow = btn.closest("tr");
//    var createnum = selectedRow.querySelector('input[name="createnum"]').value;
//    var hn = selectedRow.querySelector('input[name="hn"]').value;
//    var pw = selectedRow.querySelector('input[name="pw"]').value;
//    var name = selectedRow.querySelector('input[name="name"]').value;
//    var gender = selectedRow.querySelector('select[name="gender"]').value;
//    var nick = selectedRow.querySelector('input[name="nick"]').value;
//    var state = selectedRow.querySelector('select[name="state"]').value;
//
//    // 서버로 데이터 전송
//    fetch("/api/admin/update/"+createnum,{
//        method:"PUT",
//        headers:{
//            "Content-type" : "application/json"
//        },
//        body:JSON.stringify({
//            hn: hn,
//            pw: pw,
//            name: name,
//            gender: gender,
//            nick: nick,
//            state: state
//        })
//    })
//    .then(function(){
//        window.alert("정상적으로 내용이 수정되었습니다.")
//        location.href="/admin"
//    });
//}