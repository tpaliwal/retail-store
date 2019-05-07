package com.mycompany.retail_store.service;

import com.mycompany.retail_store.dto.RetailStoreRequest;

public interface RetailStoreService {

	double calculatePayableAmount(RetailStoreRequest retailStoreRequest);

}
