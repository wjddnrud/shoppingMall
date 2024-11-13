// 공지사항 글 등록시 내용 textarea 영역 자동 조절
function resize(obj) {
    console.log("resize");
    if(obj.style.height == "0px" || obj.scrollHeight == 0) {
        obj.style.height = "100px";
    } else {
        obj.style.height = 'auto';
        obj.style.height = obj.scrollHeight + 'px';
    }
}