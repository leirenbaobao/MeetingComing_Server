package com.ctrlz.enums;

/**
 * 会议时长
 * 
 * @author ctrlz
 */
public enum Duration {
	/**
	 * 15分钟
	 */
	quarter {
		@Override
		public int getValue() {
			return 15;
		}

		@Override
		public String getName() {
			return "15分钟";
		}
	},
	/**
	 * 30分钟
	 */
	halfhour {
		@Override
		public int getValue() {
			return 30;
		}

		@Override
		public String getName() {
			return "30分钟";
		}
	},
	/**
	 * 45分钟
	 */
	threequarter {
		@Override
		public int getValue() {
			return 45;
		}

		@Override
		public String getName() {
			return "45分钟";
		}
	},
	/**
	 * 1小时
	 */
	onehour {
		@Override
		public int getValue() {
			return 60;
		}

		@Override
		public String getName() {
			return "1小时";
		}
	},
	/**
	 * 75分钟
	 */
	fivequarter {
		@Override
		public int getValue() {
			return 75;
		}

		@Override
		public String getName() {
			return "75分钟";
		}
	},
	/**
	 * 1个半小时
	 */
	onehalf {
		@Override
		public int getValue() {
			return 90;
		}

		@Override
		public String getName() {
			return "1个半小时";
		}
	},
	/**
	 * 2小时
	 */
	twohour {
		@Override
		public int getValue() {
			return 120;
		}

		@Override
		public String getName() {
			return "2小时";
		}
	},
	/**
	 * 2个半小时
	 */
	twohalf {
		@Override
		public int getValue() {
			return 150;
		}

		@Override
		public String getName() {
			return "2个半小时";
		}
	},
	/**
	 * 3小时
	 */
	threehour {
		@Override
		public int getValue() {
			return 180;
		}

		@Override
		public String getName() {
			return "3小时";
		}
	},
	/**
	 * 4小时
	 */
	fourhour {
		@Override
		public int getValue() {
			return 240;
		}

		@Override
		public String getName() {
			return "4小时";
		}
	},
	/**
	 * 5小时
	 */
	fivehour {
		@Override
		public int getValue() {
			return 300;
		}

		@Override
		public String getName() {
			return "5小时";
		}
	},
	/**
	 * 1天
	 */
	oneday {
		@Override
		public int getValue() {
			return 480;
		}

		@Override
		public String getName() {
			return "1天";
		}
	};

	/**
	 * 获得时长(单位:分)
	 * 
	 * @return minute
	 */
	public abstract int getValue();

	/**
	 * 获得名称
	 * 
	 * @return name
	 */
	public abstract String getName();
}
