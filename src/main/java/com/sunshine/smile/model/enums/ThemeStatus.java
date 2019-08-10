package com.sunshine.smile.model.enums;
/**
* @author
* @createDate 创建时间：
* 
*/
public enum ThemeStatus {
	/**
	 * 0 未启用
	 */
	THEME_NOT_ENABLED(0),

	/**
	 * 1 已启用
	 */
	THEME_ENABLED(1);

	private int value;

	private ThemeStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
