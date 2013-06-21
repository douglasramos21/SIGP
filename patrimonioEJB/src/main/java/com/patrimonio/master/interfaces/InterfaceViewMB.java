package com.patrimonio.master.interfaces;

import java.io.IOException;

public interface InterfaceViewMB {

	void novo() throws IOException, Exception;

	void edit() throws IOException, Exception;

	void delete() throws Exception;
	
	void cancel() throws Exception;
	
	void save() throws Exception;

	void pesquisar();
	
}
