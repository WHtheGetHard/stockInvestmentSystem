function isInvalid(isInputed, errorMsg) {
	if (!isInputed) {
		dispErrorWindow('inputError.jsp?message='+errorMsg);
	}
}

function dispErrorWindow(url){
	let subWidth = 500;
	let subHeight = 100;

	let subDisplayX = (screen.availWidth - subWidth) / 2;
	let subDisplayY = (screen.availHeight - subHeight) / 2;

	let subWindowsOption = "width=" +subWidth+", height=" + subHeight + ", top=" + subDisplayY +", left="+ subDisplayX+"";
	window.open(url, "window_name", subWindowsOption+",scrollbars=no");

}