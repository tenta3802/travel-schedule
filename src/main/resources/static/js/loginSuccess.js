window.onload = function () {
    console.log('sadadasdasdasdasdasdasdasdadad')
    if (window.opener) {
        const token = /*[[${token}]]*/ 'default-token'; // Thymeleaf에서 전달된 토큰을 가져옴

        localStorage.setItem('jwtToken', token);

        window.opener.location.href = '/'; // 홈 페이지로 리다이렉트
        window.close(); // 팝업창을 닫음
    }
};