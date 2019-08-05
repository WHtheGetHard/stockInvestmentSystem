// 詳細なチェックは、input-check-common-handling.jsで定義された関数を用いて判定する。

// 各入力チェックの値を判別する
var isValidInput = false;

// 売買委託手数料の入力チェック（動的にチェックする）
$('input[data-type="currency"]').on('keyup', function() {
	let $currencyObj = $(this);


	// 入力値が文字列型でない場合は、処理を終了
	let isString = isStrings($currencyObj.val());

	if (!isString) {
		isValidInput = false;
		return;
	}


	// カンマ編集されている場合を考慮して、カンマを削除した入力値を取得する。
	let inputValue = replaceTarget($currencyObj.val(), 'comma');


	// 半角数値のみ(true)かをチェックする(onlyHalfNumberCheck())
	let isOnlyHalfNumber = onlyHalfNumberCheck(inputValue);

	// 半角数値のみの場合は、前ゼロの場合を考慮して、ゼロサプレス(zeroSuppression())を実施する。
	if (isOnlyHalfNumber) {
		inputValue = zeroSuppression(inputValue);
		// ゼロサプレスされた入力値をテキストボックスに反映する。
		overWriteTextBox($currencyObj, inputValue);

		// 各入力チェックの値をtrueに設定する
		isValidInput = true;

	// 半角数値以外の場合は、半角数値以外の値を削除（convertToOnlyHalfNumber())
	} else {
		inputValue = convertToOnlyHalfNumber(inputValue);
		// 半角数値以外の値が削除された入力値をテキストボックスに反映する。
		overWriteTextBox($currencyObj, inputValue);

		// 各入力チェックの値をfalseに設定する
		isValidInput = true;
	}


	// これまでの処理で半角数値しか残っていないため、3桁ごとのカンマ編集(editComma())を実施する。
	overWriteTextBox($currencyObj,editComma(inputValue));
});

// 税率の入力項目のチェックを実施する。(フォーカスアウト時にチェックする)
$('input[data-type="percentage"]').blur(function() {
	let inputValue = $(this).val();
	let elementTitle = $(this).prop('title');


	// 入力値が文字列型でない場合は、処理を終了
	let isString = isStrings(inputValue);

	if (!isString) {
		isValidInput = false;
		return;
	}

	// ピリオドを削除した値を取得する。
	let replacePeriodInputValue = replaceTarget(inputValue, 'period');

	let isOnlyHalfNumber = onlyHalfNumberCheck(replacePeriodInputValue);

	let errorMsg = '';

	if (!isOnlyHalfNumber) {
		errorMsg = elementTitle + 'にはx.xxx形式で入力してください。';
		isInvalid(isOnlyHalfNumber, errorMsg);
		// 各入力チェックの値をfalseに設定する
		isValidInput = false;

		return;
	}


	// 小数点第三位までの小数であることを確認する。
	let isThirdDecimal = confirmPercentageType(inputValue);

	if (isThirdDecimal) {
		isValidInput = true;
	} else {
		errorMsg = elementTitle + 'にはx.xxx形式で入力してください。';
		isInvalid(isThirdDecimal, errorMsg);

		isValidInput = false;
	}
});



// 日付項目の入力チェック（フォーカスアウト時にチェックする）
$('input[data-type="yyyymmdd"]').blur(function() {
	let inputValue = $(this).val();

	// 入力値が文字列型でない場合は、処理を終了
	let isString = isStrings(inputValue);

	if (!isString) {
		isValidInput = false;
		return;
	}


	// yyyy/mm/dd形式で入力(true)されていることを確認する。
	// TODO:dateCheck()の命名規則⇒checkDate～に変更（動詞＋〇〇～）すること
	let isCorrectForm = dateCheck(inputValue);

	let isAllInputed = false;

	let errorMsg = '';

	if (!isCorrectForm) {
		errorMsg = '日付項目はyyyy/mm/dd形式で入力してください。';
		isInvalid(isCorrectForm, errorMsg);
		isAllInputed = false;

		// 各入力チェックの値をfalseに設定する
		isValidInput = false;

		return;
	}

	// 適用開始日と適用終了日の入力チェックと相関チェックを実施する。
	let $yyyymmddObjs = $('input[data-type="yyyymmdd"]');

	// 適用開始日と適用終了日の両方が入力されている(true)ことを確認する。
	isAllInputed = allDateInputed($yyyymmddObjs);

	if (isAllInputed) {
		// 適用開始日に適用終了日以前の日付が入力(true)ことを確認する。
		let isStartBeforeEnd = startSetBeforeEnd($yyyymmddObjs);

		if (isStartBeforeEnd) {
			// 各入力チェックの値をtrueに設定する
			isValidInput = true;

			return;

		} else {
			errorMsg = '適用開始日には適用終了日以前の日付を入力してください。';
			isInvalid(isStartBeforeEnd, errorMsg);

			// 各入力チェックの値をfalseに設定する
			isValidInput = false;
		}

		// 各入力チェックの値をfalseに設定する
		isValidInput = false;

	}

});


// 入力コンテンツがすべて入力されていることをチェックする
$('input[type="text"]').blur(function() {
	let $allJQueryObjects = $('input[type="text"]');

	let isAllInputed = false;
	$allJQueryObjects.each(function(i, element) {
		let elementValue = $(element).val();

		if (elementValue !== '' && elementValue !== null) {
			isAllInputed = true;
		} else {
			isAllInputed = false;
		}
	});

	if (isAllInputed && isValidInput) {
		$('input[type="submit"].regist').prop('disabled',false);
	} else {
		$('input[type="submit"].regist').prop('disabled',true);
	}
});