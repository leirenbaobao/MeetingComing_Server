package com.ctrlz.enums;
/**
 * 会议紧急度
 * 
 * @author ctrlz
 */
public enum Emergency {
	/**
	 * 1颗星
	 */
	one {
		@Override
		public int getValue() {
			return 1;
		}
		@Override
		public String getName() {
			return "1颗星";
		}
	},
	/**
	 * 2颗星
	 */
	two {
		@Override
		public int getValue() {
			return 2;
		}
		@Override
		public String getName() {
			return "2颗星";
		}
	},
	/**
	 * 3颗星
	 */
	three {
		@Override
		public int getValue() {
			return 3;
		}
		@Override
		public String getName() {
			return "3颗星";
		}
	},
	/**
	 * 4颗星
	 */
	four {
		@Override
		public int getValue() {
			return 4;
		}
		@Override
		public String getName() {
			return "4颗星";
		}
	},
	/**
	 * 5颗星
	 */
	five {
		@Override
		public int getValue() {
			return 5;
		}
		@Override
		public String getName() {
			return "5颗星";
		}
	};
	public abstract int getValue();
	public abstract String getName();
}