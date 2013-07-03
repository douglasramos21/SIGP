function loadPage(url) {
	$("#pGroup").load(url);
}

function editTableRow($dataTable) {

	$dataTable.last().find('span.ui-icon-pencil').last().each(function() {
		$(this).click();
	});

	$dataTable.last().find('tr').last().each(function() {
		$(this).find('select').first().each(function() {
			changeClassHeader(this);
		});
	});
}

function handleLoginRequest(xhr, status, args) {
	if (args.validationFailed || !args.loggedIn) {
		dlg.jq.effect("shake", {
			times : 5
		}, 100);
	} else {
		dlg.hide();
		$('#dialog').fadeOut();
	}
}

function upppercase($element) {
	$element.val(($element.val()).toUpperCase());
}

function changeClassHeader(element) {

	var elementStr = element.id;

	if (elementStr.indexOf("addDocButton") !== -1) {
		elementStr = elementStr.replace(/:addDocButton/, ":0:addDocButton");
	}

	$tipoDocumento = $(jqClientId(elementStr.substring(0, 34)+ ":tipoDocumentoCad"));

	$classificacaoDoc = $(jqClientId(elementStr.substring(0, 34) + ":docClass"));
	$tipoVisto = $(jqClientId(elementStr.substring(0, 34) + ":docTipoVisto"));

	if ($tipoDocumento.find(":selected").text() === "Visto") {
		$classificacaoDoc.css("display", "none");
		$tipoVisto.css("display", "inline");
		return;
	}

	$classificacaoDoc.css("display", "inline");
	$tipoVisto.css("display", "none");

}

function jqClientId(elementStr) {
	return "#" + elementStr.replace(/:/g, "\\\:");
}

function clickPencil($element) {
	
	$pencil = $element.find('span.ui-icon-pencil');
	
	if(typeof $pencil.attr('style') === 'undefined'){
		return true;
//		changeClassHeader($element.parent().parent().siblings().first().find('select').first());
	}
	
	return false;
	
}

// function verifiyRowOnFocus($idDataTable) {
// jQuery($idDataTable).find("[style*='display: inline']").each(function() {
// return false;
// });
//
// return $idDataTable;
// }
