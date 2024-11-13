// 공지사항 글 삭제
function deleteNotice(idx) {
    if(confirm('정말 삭제하시겠습니까?')) {
        fetch('/board/notice/' + idx, {
            method: 'delete'
        }).then(response => {
            if(response.redirected) {
                window.location.href = response.url;
            }
        }).catch(error => {
            console.error("삭제 요청 중 오류 발생:", error);
        });
    }
}