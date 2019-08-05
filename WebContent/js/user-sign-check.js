$('input[type="text"]').blur(function() {
	let $blurObject = $(this);

	judgeContentsInput($blurObject);

	checkAllInputed();
});

function judgeContentsInput($blurObject) {
	let inputedValue = $blurObject.val();
	let isInputed = false;
	let inputedContents = $blurObject.prop('title');

	let name = $blurObject.attr('name');

	let errorMsg = '';
	if (name === 'user-name') {
		isInputed = simpleInputCheck(inputedValue);
		errorMsg = inputedContents + 'を入力してください。';
	} else if (name === 'user-password') {
		isInputed = checkOnlyHalfNumber(inputedValue);
		errorMsg = inputedContents + 'には半角英数字を入力してください。';
	} else if (name == 'user-mail') {
		isInputed = isMailFormat(inputedValue);
		errorMsg = inputedContents + 'はxxxx@xxx.xx形式で入力してください。';
	}

	isInvalid(isInputed, errorMsg);
}

function checkAllInputed() {
	let $allInputText = $('input[type=text]');
	let allTextNumber = $allInputText.length;
	let checkCount = 0;
	let isAllInputed = false;

	$allInputText.each(function(i, element) {
		let elementValue = $(element).val();
		let elemetName = $(element).prop('name');

		if (elemetName === 'user-name') {
			checkCount = checkCountHandle(checkCount, simpleInputCheck(elementValue));

		} else if (elemetName === 'user-password') {
			checkCount = checkCountHandle(checkCount, checkOnlyHalfNumber(elementValue));

		} else if (elemetName == 'user-mail') {
			checkCount = checkCountHandle(checkCount, isMailFormat(elementValue));
		}
	});

	if (checkCount == allTextNumber) {
		isAllInputed = true;
	} else {
		isAllInputed = false;
	}

	if (isAllInputed) {
		$('input[type="submit"]').prop('disabled',false);
	} else {
		$('input[type="submit"]').prop('disabled',true);
	}

}

function checkCountHandle(checkCount, checkResult) {
	let isAllInputed = false;

	if (checkResult) {
		checkCount++;
	} else {
		checkCount--;
	}

	return checkCount;
}