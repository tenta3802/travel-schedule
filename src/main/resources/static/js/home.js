const token = localStorage.getItem('jwtToken');
if (token) {
    fetch('/api/user/info', {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer ' + token
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            const userInfoElement = document.getElementById('userInfo');

            // 기존 내용 삭제
            userInfoElement.innerHTML = '';

            // 이메일
            const emailDiv = document.createElement('div');
            emailDiv.className = 'profile-top';
            emailDiv.textContent = `${data.email}`;
            userInfoElement.appendChild(emailDiv);

            // 나이
            const birthDiv = document.createElement('div');
            birthDiv.className = 'profile-bottom';
            birthDiv.textContent = `${data.birthDate}`;
            userInfoElement.appendChild(birthDiv);

            // 성별
            const genderDiv = document.createElement('div');
            genderDiv.className = 'profile-bottom';
            genderDiv.textContent = `${data.gender}`;
            userInfoElement.appendChild(genderDiv);

            // 국가
            const countryDiv = document.createElement('div');
            countryDiv.className = 'profile-bottom';
            countryDiv.textContent = `${data.country}`;
            userInfoElement.appendChild(countryDiv);
        })
        .catch(error => console.error('Error fetching user info:', error));
}
