const key = "";

window.onload = function() {
	
}

function encrypt(s) {
	var str = "";
	for (i = 0; i < s.length; i++) {
		x = s.charCodeAt(i);
		str += String(Math.round(Math.cos(x) * (1 + x) - 6 * x * x));
		for (j = 0; j < s.length - i; j++) {
			str += String(s.charCodeAt(j) - s.charCodeAt(s.length - j - 1));
			if (s.charCodeAt(j) % s.charCodeAt(0) <= 10) str += "$";
		}
	}
	var str2 = "";
	for (i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) <= "9".charCodeAt(0) && str.charCodeAt(i) >= "0".charCodeAt(0)) str2 += str[i];
	}
	var str3 = "";
	for (i = 0; i < str2.length; i++) {
		str3 += to_bin(parseInt(str2[i] + str2[str2.length - i - 1]));
	}
	return str3;
}

function to_bin(n) {
	if (n < 2) return n + "";
	return to_bin(n / 2 | 0) + (n % 2) + "";
}