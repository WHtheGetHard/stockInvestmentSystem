// 第一引数の文字列から、第二引数に指定した文字列を削除する
function replaceTarget(inputValue, target) {
	let targetRegex;

	if (target === 'comma') {
		targetRegex = /,/g;

	} else if (target === 'slash') {
		targetRegex = /\//g;

	} else if (target === 'period') {
		targetRegex = '\.';

	}

	let returnValue;

	returnValue = inputValue.replace(targetRegex,'');

	return returnValue;
}


// 半角数値チェックメソッド（正規表現を使用して、半角数値のみ(true)か否(false)を返す）
function onlyHalfNumberCheck(inputValue) {
	const regexp = new RegExp('^[0-9]+$');

	let isOnlyHalfNumber = isMatchedCheck(inputValue, regexp);

	return isOnlyHalfNumber;
}


// 日付入力チェックメソッド（yyyy/mm/dd形式で入力されている（true）か否（false）を返す）
function dateCheck(inputValue) {
	const regexp = new RegExp('^[0-9]{4}\/[0-9]{2}\/[0-9]{2}$');

	let isCorrectForm = isMatchedCheck(inputValue, regexp);

	return isCorrectForm;
}

// 半角数値以外を削除するメソッド（正規表現を使用して、半角数値以外を削除する）
// ※即時で削除するため、replaceメソッドを使用している⇒削除されるのは1文字のみ
function toOnlyHalfNumber(inputValue) {
	const regexp = new RegExp('[^0-9]');

	let alreadyCleared = inputValue.replace(regexp,'');

	return alreadyCleared;
}

// テキストボックスに入力されている値を変更するメソッド（jQueryオブジェクトのメソッドを使用して、属性を書き換える）
function overWriteTextBox($inputObj, replaceValue) {
	$inputObj.prop('value', replaceValue);
}

// ゼロサプレスメソッド（頭に0がついていた場合にreplaceメソッドで0を削除する)
//※即時で削除するため、replaceメソッドを使用している⇒削除されるのは1文字のみ
function zeroSuppression(inputValue) {
	const regexp = new RegExp('^0');

	let isHeadZero =  isMatchedCheck(inputValue, regexp);

	let suppressedValue;

	if (isHeadZero) {
		suppressedValue = inputValue.replace('0','');
	} else {
		suppressedValue = inputValue;
	}

	return suppressedValue;
}


// 適用開始日と適用終了日が入力されていること(true）を確認するメソッド
function allDateInputed($jQueryObjects) {
	let isAllInputed = false;

	$jQueryObjects.each(function(i, element) {
		if ($(element).val() !== '' && $(element).val() !== null) {
			isAllInputed = true;
		} else {
			isAllInputed = false;
		}
	});

	return isAllInputed;
}

// 適用開始日が適用終了日以前に設定されていることを確認するメソッド
function startSetBeforeEnd($jQueryObjects) {
	let isStartBeforeEnd = false;

	let startDate, endDate;
	$jQueryObjects.each(function(i, element) {
		let tempElementTitle = $(element).attr('title');

		if ("適用開始日" === tempElementTitle) {
			startDate = replaceTarget($(element).val(), 'slash');
		} else if ("適用終了日" === tempElementTitle) {
			endDate = replaceTarget($(element).val(), 'slash');
		}
	});

	if (startDate < endDate) {
		isStartBeforeEnd = true;
	} else {
		isStartBeforeEnd = false;
	}

	return isStartBeforeEnd;
}

// 税率を確認する。(小数点第3位まで許容する）
function percentageConfirm(inputValue) {
	const regexp = new RegExp('^[0-9]{1}\.[0-9]{0,3}$');

	let isThirdDecimal = isMatchedCheck(inputValue, regexp);

	return isThirdDecimal;
}

// 日付の存在チェック
function isExistDate(inputValue) {
	let isExistedDate = false;

	let splitToYMD = inputValue.split('/');

	let year = splitToYMD[0];
	let month = splitToYMD[1];
	let day = splitToYMD[2];

	// 月の存在チェック
	if (month < '01' && '12' < month) {
		console.log('存在しない月が入力されています。');
		return isExistedDate;
	}

	// 各月ごとの日付チェック
	if ('02' === month) {
		let isDivisibleBy4 = isRemainderZero(year, 4);
		let isDivisibleBy100= isRemainderZero(year, 100);
		let isDivisibleBy400 = isRemainderZero(year, 400);

		let isLeapYear = false;
		if (isDivisibleBy4 && !isDivisibleBy100 || isDivisibleBy400) {
			isLeapYear = true;
		} else {
			isLeapYear = false;
		}

		if (isLeapYear) {
			if ('01' <= day && day <= '29') {
				isExistedDate = true;

				return isExistedDate;
			} else {
				console.log('存在しない日付が入力されています。');

				isExistedDate = false;

				return isExistedDate;
			}
		} else {
			if ('01' <= day && day <= '28') {
				isExistedDate = true;

				return isExistedDate;
			} else {
				console.log('存在しない日付が入力されています。');

				isExistedDate = false;

				return isExistedDate;
			}
		}

	} else if ('04' === month || '06' === month || '09' === month || '11' === month) {
		if ('01' <= day && day <= '30') {
			isExistedDate = true;

			return isExistedDate;
		} else {
			console.log('存在しない日付が入力されています。');

			isExistedDate = false;

			return isExistedDate;
		}
	} else {
		if ('01' <= day && day <= '31') {
			isExistedDate = true;

			return isExistedDate;
		} else {
			console.log('存在しない日付が入力されています。');

			isExistedDate = false;

			return isExistedDate;
		}
	}


}


// 余りがゼロであるかの確認
function isRemainderZero(numerator, denominator) {
	let isRemainderZero = false;

	if ((numerator % denominator) == 0) {
		isRemainderZero = true;
	} else {
		isRemainderZero = false;
	}

	return isRemainderZero;
}

// カンマ編集
function editComma(inputValue) {
	let inputvalueToArray = inputValue.split('');

	let reverseArray = [''];

	let commaPoint = 0;

	for (let i = (inputvalueToArray.length - 1); i >= 0; i--) {
		if ((commaPoint % 3) === 0 && commaPoint !== 0) {
			reverseArray.push(',');
		}

		reverseArray.push(inputvalueToArray[i]);

		commaPoint++;
	}


	let returnValue = '';

	for (let i = (reverseArray.length - 1); i > 0; i--){
		returnValue += reverseArray[i];
	}

	return returnValue;
}

// 第一引数の文字列が、第二引数の正規表現に一致することをtrue・falseで返す
function isMatchedCheck(targetString, regexp) {
	let isMatched = false;

	let matchMethodResult = targetString.match(regexp);

	if (matchMethodResult === null) {
		isMatched = false;
	} else {
		isMatched = true;
	}

	return isMatched;
}