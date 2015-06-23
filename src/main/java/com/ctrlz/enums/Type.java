package com.ctrlz.enums;
/**
 * 消息类型
 * 
 * @author ctrlz
 */
public enum Type {
	/**
	 * 系统消息
	 */
	broadcastMsg {
		@Override
		public int getValue() {
			return 0;
		}

		@Override
		public String getName() {
			return "系统消息";
		}
	},
	/**
	 * 个人消息
	 */
	personalMsg {
		@Override
		public int getValue() {
			return 1;
		}

		@Override
		public String getName() {
			return "个人消息";
		}
	};
	/**
	 * 获得消息类型 值 0广播,1个人
	 * 
	 * @return value
	 */
	public abstract int getValue();
	/**
	 * 获得消息类型名称
	 * 
	 * @return name
	 */
	public abstract String getName();
}
