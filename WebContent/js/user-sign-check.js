$('input[type="text"]').blur(function() {
	let $blurObject = $(this);

	judgeContentsInput($blurObject);
});

function judgeContentsInput($blurObject) {
	let inputedValue = $blurObject.val();
	let inputedContents = $blurObject.prop('title');

	let name = $blurObject.attr('name');

	if (name === 'user-name') {
		let nameIsInputed = simpleInputCheck(inputedValue);

		if (nameIsInputed) {

		} else {
			dispErrorWindow('inputError.jsp?title='+inputedContents);
		}

	} else if (name === 'user-password') {
		let passwordIsValidInput = checkOnlyHalfNumber(inputedValue);

		if (passwordIsValidInput) {

		} else {
			dispErrorWindow('inputError.jsp?title='+inputedContents);
		}
	} else if (name == 'user-mail') {
		let mailIsValidInput = isMailFormat(inputedValue);

		if (mailIsValidInput) {

		} else
			dispErrorWindow('inputError.jsp?title='+inputedContents);
	}
}

function checkAllInputed() {

}