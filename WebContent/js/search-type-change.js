$('select[name="selectedSearchType"]').on('change', function() {
	var selectedVal = $(this).val();

	let isValidValue = confirmSelect(selectedVal);

	if (isValidValue) {
		searchConditionChange(selectedVal)
	} else {
		changeDisabled(true);
	}
});

function confirmSelect(selectedVal) {
	let isValidValue = false;

	if (1 <= selectedVal && selectedVal <= 3) {
		isValidValue = true;
	} else {
		isValidValue = false;
	}

	return isValidValue;
}



function changeDisabled(isDisabled) {
	if (isDisabled) {
		$('input[type="submit"]').prop('disabled',true);
	} else {
		$('input[type="submit"]').prop('disabled',false);
	}
}

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