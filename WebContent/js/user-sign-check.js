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
			console.log(inputedContents + "を入力してください。");
		}

	} else if (name === 'user-password') {
		let passwordIsValidInput = checkOnlyHalfNumber(inputedValue);

		if (passwordIsValidInput) {

		} else {
			console.log(inputedContents + "には半角英数字を入力してください。");
		}
	} else if (name == 'user-mail') {
		let mailIsValidInput = isMailFormat(inputedValue);

		if (mailIsValidInput) {

		} else
			console.log(inputedContents + "はxxxx@xxx.xxx形式で入力してください。");
	}
}

function checkAllInputed() {

}