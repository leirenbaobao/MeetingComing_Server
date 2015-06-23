package com.ctrlz.enums;
/**
 * 会议状态
 * 
 * @author ctrlz
 */
public enum Status {

	init {
		@Override
		public int getValue() {
			return 0;
		}

		@Override
		public String getName() {
			return "发起";
		}
	},
	start {
		@Override
		public int getValue() {
			return 1;
		}

		@Override
		public String getName() {
			return "开始";
		}
	},

	end {
		@Override
		public int getValue() {
			return 2;
		}

		@Override
		public String getName() {
			return "结束";
		}
	},
	cancel {
		@Override
		public int getValue() {
			return 3;
		}

		@Override
		public String getName() {
			return "取消";
		}
	};
	/**
	 * 获得会议状态 值 0发起,1开始,2结束,3 取消
	 * 
	 * @return value
	 */
	public abstract int getValue();
	/**
	 * 获得会议状态名称
	 * 
	 * @return name
	 */
	public abstract String getName();
}
