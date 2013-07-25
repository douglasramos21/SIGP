function loadPage(url) {
	$("#pGroup").load(url);
}

function editTableRow($dataTable) {

	$dataTable.last().find('span.ui-icon-pencil').last().each(function() {
		$(this).click();
	});

//	$dataTable.last().find('tr').last().each(function() {
//		$(this).find('select').first().each(function() {
//			changeClassHeader(this);
//		});
//	});
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

	$docClassOutput = $(jqClientId(elementStr.substring(0, 34) + ":docClassOutput"));
	$docClassInput = $(jqClientId(elementStr.substring(0, 34) + ":docClassInput"));
	$tipoVistoOutput = $(jqClientId(elementStr.substring(0, 34) + ":docTipoVistoOutput"));
	$tipoVistoInput = $(jqClientId(elementStr.substring(0, 34) + ":docTipoVistoInput"));

	if ($tipoDocumento.find(":selected").text() === "Visto") {
		$docClassOutput.css("display", "none");
		$docClassInput.css("display", "none");
		$tipoVistoOutput.css("display", "inline");
		$tipoVistoInput.css("display", "inline");
		return;
	}

	$docClassOutput.css("display", "inline");
	$docClassInput.css("display", "inline");
	$tipoVistoOutput.css("display", "none");
	$tipoVistoInput.css("display", "none");

}

function jqClientId(elementStr) {
	return "#" + elementStr.replace(/:/g, "\\\:");
}

function clickPencil() {
	
	$pencil = $('tr').find("span.ui-icon-pencil[style*='display: none']");

	changeClassHeader($pencil.parent().parent().siblings().first().find('select').first().get(0));
	
}

// function verifiyRowOnFocus($idDataTable) {
// jQuery($idDataTable).find("[style*='display: inline']").each(function() {
// return false;
// });
//
// return $idDataTable;
// }
