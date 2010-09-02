function updatePrice(txtItemPriceArray, txtQuantityArray, arrayIndex, unitPrice, txtTotalPrice) {
	
	txtItemPriceArray[arrayIndex].value = txtQuantityArray[arrayIndex].value * unitPrice;
	
	var totalPrice = 0;
	
	for (var index = 0; index < txtItemPriceArray.length; index++) {
		
		totalPrice += parseFloat(txtItemPriceArray[index].value);
		
	}
	
	txtTotalPrice.value = totalPrice;
	
}

