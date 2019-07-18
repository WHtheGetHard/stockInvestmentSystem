$('th.showbutton').on('click', function() {
	// TODO : 押下されたthの親要素のtr要素(jQueryオブジェクト)を取得する
	let $parentTrObj = $(this).parent('tr');

	// TODO : 次に配置されているtr要素(jQueryオブジェクト)を取得する
	let $wrapTargetTrObj = $parentTrObj.next('tr');

	// TODO : 取得したtr要素の子要素であるtd要素(jQueryオブジェクト)を取得する
	let $targetTd = $wrapTargetTrObj.children('td');

	let visibleState = $targetTd.attr('data-isvisible');

	if (visibleState === 'false') {
		$targetTd.attr('data-isvisible', 'true');
		$targetTd.removeAttr('hidden');
	} else if (visibleState === 'true') {
		$targetTd.attr('data-isvisible', 'false');
		$targetTd.attr('hidden', 'true');
	}
});