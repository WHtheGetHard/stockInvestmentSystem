// li要素の入れ子要素をマウスが当たった場合・外れた場合で表示・非表示を制御
$('li.parents').hover(
		// マウスが当たった場合は子要素を表示(要素の対応はdata-contents属性で判断する)
		function() {
			let dataContentsName = $(this).attr('data-contents');
			activationControl(dataContentsName, true);
		},
		// マウスが外れた場合は子要素を非表示(要素の対応はdata-contents属性で判断する)
		function() {
			let dataContentsName = $(this).attr('data-contents');
			activationControl(dataContentsName, false);
		}
);


// 第二引数のisDisplayの真偽値に応じて、第一引数のul要素の表示・非表示を切り替える
function activationControl(dataContentsName, isDisplay) {
	if (isDisplay) {
		$('ul[data-contents="'+dataContentsName+'"]').css('display', 'block');
	} else {
		$('ul[data-contents="'+dataContentsName+'"]').css('display', 'none');
	}
}