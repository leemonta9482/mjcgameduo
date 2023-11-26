// 테이블 요소와 페이지 번호 표시할 요소 가져오기
var table = document.getElementById("myTable");
var pagination = document.getElementById("pagination");
var rowsPerPageSelect = document.getElementById("rowsPerPage");

var currentPage = 1; // 현재 페이지

function displayTableRows() {
  var rows = table.getElementsByTagName("tbody")[0].getElementsByTagName("tr");
  var rowsPerPage = parseInt(rowsPerPageSelect.value); // 페이지당 행 수
  var pageCount = Math.ceil(rows.length / rowsPerPage); // 전체 페이지 수
  // 테이블 행 숨기기
  for (var i = 0; i < rows.length; i++) {
    rows[i].style.display = "none";
  }

  // 현재 페이지의 행만 보이도록 설정
  var startIndex = (currentPage - 1) * rowsPerPage;
  var endIndex = startIndex + rowsPerPage;
  for (var j = startIndex; j < endIndex && j < rows.length; j++) {
    rows[j].style.display = "table-row";
  }

  // 페이지 번호 생성
  pagination.innerHTML = "";
  var navElement = document.createElement("nav");
  navElement.setAttribute("aria-label", "Page navigation");

  var ulElement = document.createElement("ul");
  ulElement.className = "pagination";
  for (var k = 1; k <= pageCount; k++) {
    var listItem = document.createElement("li");
    listItem.className = "page-item";
    ulElement.appendChild(listItem);

    var link = document.createElement("a");
    link.href = "#";
    link.className = "page-link";
    link.innerHTML = k;

    if (k === currentPage) {
        listItem.classList.add("active");
    } else {
        link.addEventListener("click", function () {
            currentPage = parseInt(this.innerHTML);
            displayTableRows();
        });
    }
    ulElement.appendChild(listItem);
    listItem.appendChild(link);
  }
  navElement.appendChild(ulElement);
  pagination.appendChild(navElement);
}

// 이벤트 리스너 등록
rowsPerPageSelect.addEventListener("change", function () {
  currentPage = 1;
  displayTableRows();
});

// 초기 실행
displayTableRows();