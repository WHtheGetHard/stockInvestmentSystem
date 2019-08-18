//　プルダウンリストが変更されたときの処理
$('select[name="selectedSearchType"]').on('change', function() {
	var selectedVal = $(this).val();

	let isValidValue = confirmSelect(selectedVal);

	if (isValidValue) {
		searchConditionChange(selectedVal)

		showSearchArea(true);

	} else {
		delSearchWord();
		showSearchArea(false);
		changeDisabled(true);
	}
});

//　プルダウンリストの選択値が有効範囲内かを確認
function confirmSelect(selectedVal) {
	let isValidValue = false;

	if (1 <= selectedVal && selectedVal <= 3) {
		isValidValue = true;
	} else {
		isValidValue = false;
	}

	return isValidValue;
}

//　プルダウンリストの選択値に応じて、ラベルを変更
function searchConditionChange(selectedVal) {
	let $searchType = $('td#searchType');

	if (1 == selectedVal) {
		$searchType.html('会社名');
	} else if (2 == selectedVal) {
		$searchType.html('証券コード');
	} else if (3 == selectedVal) {
		$searchType.html('市場');
	}
}


//　検索条件エリアのhidden属性を変更する
function showSearchArea(show) {
	if (show) {
		$('div.search-area').removeAttr('hidden');
	} else {
		$('div.search-area').attr('hidden', 'true');
	}
}


//　検索条件に入力されている値を削除する
function delSearchWord() {
	$('input[name="searchWord"]').prop('value','');
}

//検索ボックスの値が入力されているかの確認
$('input[name="searchWord"]').on('change', function() {
	var searchConditionWord = $(this).val();

	let isValidInput  = simpleInputCheck(searchConditionWord);

	activeSubmit(isValidInput);
});


//　サブミットボタンの活性・非活性を制御
function activeSubmit(isActivate) {
	if (isActivate) {
		$('input[type="submit"]').prop('disabled',false);
	} else {
		$('input[type="submit"]').prop('disabled',true);
	}
}