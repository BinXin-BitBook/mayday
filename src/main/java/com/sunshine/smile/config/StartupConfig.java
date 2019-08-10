package com.sunshine.smile.config;

import java.util.List;

import com.sunshine.smile.service.MenuService;
import com.sunshine.smile.service.OptionsService;
import com.sunshine.smile.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.sunshine.smile.model.domain.Options;
import com.sunshine.smile.model.dto.SmileConst;

/**
 * @author :
 * @createDate :
 */
@Configuration
public class StartupConfig implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private OptionsService optionsService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private ThemeService themeService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		this.loadOptions();
		this.loadMenus();
		this.loadThemeName();
	}

	/**
	 * 加载设置选项
	 */
	private void loadOptions() {
		List<Options> listMap = optionsService.selectMap();
		if (listMap.size() > 0 && !listMap.isEmpty()) {
			for (Options options : listMap) {
				SmileConst.OPTIONS.put(options.getOptionName(), options.getOptionValue());
			}
		}
	}

	/**
	 * 加载菜单
	 */
	private void loadMenus() {
		SmileConst.MENUS = menuService.findMenus();
	}
	/**
	 * 加载主题
	 */
	private void loadThemeName() {
		SmileConst.THEME_NAME=themeService.getEnabledTheme();
	}

}
