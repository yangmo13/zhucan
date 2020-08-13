function randomNum() {
    return Math.floor(Math.random() * 9) + 1;
}
function show(a, b, c) {
	var loop1, loop2, loop3,
	    time = 30, i = 0, number;
	loop3 = setInterval(function () {
	    if (i > 40) {
	        clearInterval(loop3);
	        document.querySelector('.thirdDigit').textContent = a;
	    } else {
	        document.querySelector('.thirdDigit').textContent = randomNum();
	        i++;
	    }
	}, time);
	loop2 = setInterval(function () {
	    if (i > 50) {
	        clearInterval(loop2);
	        document.querySelector('.secondDigit').textContent = b;
	    } else {
	        document.querySelector('.secondDigit').textContent = randomNum();
	        i++;
	    }
	}, time);
	loop1 = setInterval(function () {
	    if (i > 60) {
	        clearInterval(loop1);
	        document.querySelector('.firstDigit').textContent = c;
	    } else {
	        document.querySelector('.firstDigit').textContent = randomNum();
	        i++;
	    }
	}, time);
}