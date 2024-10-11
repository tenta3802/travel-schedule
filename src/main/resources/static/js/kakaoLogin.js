function openKakaoLogin() {
    const width = 600;  // 팝업 너비
    const height = 700; // 팝업 높이

    // 화면 중앙에 위치를 계산
    const left = window.screenX + (window.innerWidth / 2) - (width / 2);
    const top = window.screenY + (window.innerHeight / 2) - (height / 2);

    // 팝업 창 열기
    window.open(
        "/oauth2/authorization/kakao",
        "카카오 로그인",
        `width=${width},height=${height},top=${top},left=${left},resizable=yes,scrollbars=yes`
    );
}