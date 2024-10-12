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
            const userInfoTopElement = document.getElementById('userInfo-top');
            const userInfoBottomElement = document.getElementById('userInfo-bottom');

            userInfoTopElement.innerHTML = '';
            userInfoBottomElement.innerHTML = '';

            const emailDiv = document.createElement('div');
            emailDiv.textContent = `${getLocalPart(data.email)}`;
            userInfoTopElement.appendChild(emailDiv);

            const birthDiv = document.createElement('div');
            birthDiv.textContent = `${getAgeGroup(data.birthDate)} \u00B7`;
            userInfoBottomElement.appendChild(birthDiv);

            const genderDiv = document.createElement('div');
            genderDiv.textContent = `${getGender(data.gender)} \u00B7`;
            userInfoBottomElement.appendChild(genderDiv);

            const countryDiv = document.createElement('div');
            countryDiv.textContent = `${getCountry(data.country)}`;
            userInfoBottomElement.appendChild(countryDiv);
        })
        .catch(error => console.error('Error fetching user info:', error));
}

function getLocalPart(email) {
    const atIndex = email.indexOf('@');  // '@'의 위치를 찾음
    if (atIndex !== -1) {
        return email.substring(0, atIndex);  // '@' 앞부분을 반환
    } else {
        return email;  // '@'가 없는 경우 null 반환
    }
}

function getAgeGroup(birthDateStr) {
    const birthDate = new Date(birthDateStr);
    const today = new Date();
    const currentYear = today.getFullYear();
    const birthYear = birthDate.getFullYear();

    let age = currentYear - birthYear;

    const isBirthdayPassed = today.getMonth() > birthDate.getMonth() ||
        (today.getMonth() === birthDate.getMonth() && today.getDate() >= birthDate.getDate());

    if (!isBirthdayPassed) {
        age--;
    }

    if (age >= 10 && age < 20) {
        return '10대';
    } else if (age >= 20 && age < 30) {
        return '20대';
    } else if (age >= 30 && age < 40) {
        return '30대';
    } else if (age >= 40 && age < 50) {
        return '40대';
    } else if (age >= 50 && age < 60) {
        return '50대';
    } else if (age >= 60 && age < 70) {
        return '60대';
    } else if (age >= 70 && age < 80) {
        return '70대';
    } else {
        return '80대 이상';
    }
}

function getGender(gender) {
    if (gender === 'M') {
        return '남자'
    } else {
        return '여자'
    }
}

function getCountry(country) {
    if (country === 'KR') {
        return '한국'
    } else {
        return '해외'
    }
}