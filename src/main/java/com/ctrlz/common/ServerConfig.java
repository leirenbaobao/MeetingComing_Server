package com.ctrlz.common;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.jfinal.BeetlRenderFactory;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;

public class ServerConfig extends JFinalConfig {

	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 80, "/", 5);
	}

	/**
	 * 配置常量
	 */

	@Override
	public void configConstant(Constants me) {
		// 开发模式
		me.setDevMode(true);
		// 设置视图文件渲染工厂
		BeetlRenderFactory brf = new BeetlRenderFactory();
		// 设置视图文件后缀名
		BeetlRenderFactory.viewExtension = ".btl";
		me.setMainRenderFactory(brf);
		@SuppressWarnings("unused")
		GroupTemplate groupTemplate = BeetlRenderFactory.groupTemplate;// 获取GroupTemplate
	}

	/**
	 * 配置处理器
	 */
	@Override
	public void configHandler(Handlers me) {

	}

	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {

	}

	/**
	 * 配置插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		// 配置Ehcache缓存
		me.add(new EhCachePlugin());

		// 配置druid连接池插件
		DruidPlugin druidPlugin = new DruidPlugin("jdbc:sqlite:db/test.db",
				"root", "root", "org.sqlite.JDBC");
		// 配置Druid 监控SQL状态过滤器
		StatFilter stat = new StatFilter();
		stat.setDbType("sqlite");
		druidPlugin.addFilter(stat);

		// 配置Druid 监控 SQL防火墙过滤器
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		druidPlugin.addFilter(wall);

		me.add(druidPlugin);
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		me.add(arp);
		arp// .addMapping("roles", Roles.class)
		.setShowSql(true);
		// 配置显示SQL语句
	}

	/**
	 * 配置路由
	 */
	@Override
	public void configRoute(Routes me) {
		me.add("/", Index.class);
	}
}
