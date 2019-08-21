$('input[type="button"]').on('click', function() {
	let listIndex = $(this).attr('name');

	dispErrorWindow('subDispCompanyDetails.jsp?listIndex='+listIndex);
});

function dispErrorWindow(url){
	let subWidth = 500;
	let subHeight = 500;

	let subDisplayX = (screen.availWidth - subWidth) / 2;
	let subDisplayY = (screen.availHeight - subHeight) / 2;

	let subWindowsOption = "width=" +subWidth+", height=" + subHeight + ", top=" + subDisplayY +", left="+ subDisplayX+"";
	window.open(url, "window_name", subWindowsOption+",scrollbars=no");

}