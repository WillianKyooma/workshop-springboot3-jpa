package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAYTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	
	
	private OrderStatus(int code) {
		this.code = code;
		
	}
	
	public int GetCode() {
		return code;
	}
	
	
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.GetCode()== code ) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
