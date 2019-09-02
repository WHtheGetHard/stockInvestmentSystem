var conditions = {isSuitableInput : false, message : ''};

$('input[type="number"]').blur(function() {
	var $inputElement = $('#stockInfoInput').find('input');

	var conditions = appropriateInputCheck($inputElement);

	if (conditions.isSuitableInput) {
		$('input[type="submit"]').prop('disabled',false);
	} else {
		$('input[type="submit"]').prop('disabled',true);
	}
});

function appropriateInputCheck($inputElement) {
	let isNumStockInputed = false;
	let isBuyingPriceInputed = false;
	let isSellingPrice = false;

	$inputElement.each(function(index, element) {
		let title = $(element).prop('title');
		let isValidInput = false;

		isValidInput = simpleInputCheck($(element).val());

		if (title === '保有数') {
			isNumStockInputed = isValidInput;
		} else if (title === '買値') {
			isBuyingPriceInputed = isValidInput;
		} else if (title === '売値') {
			isSellingPriceInputed = isValidInput;
		}
	});

	if (isNumStockInputed) {
		if (isBuyingPriceInputed && isSellingPriceInputed) {
			conditions.isSuitableInput = false;
			conditions.message ="買値と売値の両方に入力することはできません。";
		} else if (!isBuyingPriceInputed && !isSellingPriceInputed) {
			conditions.isSuitableInput = false;
			conditions.message ="買値と売値のどちらかは入力する必要があります。";
		} else {
			conditions.isSuitableInput = true;
		}

	} else {
		conditions.message ="保有数を入力してください。";
	}


	return conditions;
}

$('img').on('click',function() {
	instraction("inputUserStockInfo", !conditions.isSuitableInput, conditions.message);
});