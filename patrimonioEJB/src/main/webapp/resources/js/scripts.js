function loadPage(url) {
	$("#pGroup").load(url);
}

function incluiDataTable(idDialog, idDataTable) {

}

function editTableRow($idDataTable) {

	jQuery($idDataTable).last().find('span.ui-icon-pencil').last().each(function() {
		jQuery(this).click();
	});
}

function verifiyRowOnFocus($idDataTable) {
	jQuery($idDataTable).find("[style*='display: inline']").each(function() {
		alert("não tem");
		return false;
	});

	alert("tem");
	return $idDataTable;
}

function handleLoginRequest(xhr, status, args) {  
    if(args.validationFailed || !args.loggedIn) {  
        dlg.jq.effect("shake", { times:5 }, 100);  
    }   
    else {  
        dlg.hide();  
        $('#dialog').fadeOut();  
    }  
}  